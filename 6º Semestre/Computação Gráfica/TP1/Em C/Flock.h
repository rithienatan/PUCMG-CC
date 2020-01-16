#ifndef flock__h
#define flock__h

#include <aribeiro/aribeiro.h>
using namespace aRibeiro;

#include "Boid.h"
#include "App.h"
#include "BoidModel.h"

vec3 randomDirection(){
    vec3 aux;
    do{
        aux = normalize(Random::getVec3() - 0.5f);
    }while (sqrLength(aux) < 0.0002f*0.0002f);
    aux = normalize(aux);
    return aux;
}

class Flock {
    App *app;
    vec3 sceneMin,sceneMax, sceneDelta;
    
    //double buffer
    std::vector<Boid> boids[2];
    int doubleBuffer;
    
    BoidModel *boidModel;
    
    void computeNeighbor(const Boid *boid, const std::vector<Boid> &list,
                         
                         int &neighborCounter,
                         vec3 &neighborAlignment,
                         vec3 &neighborSeparation,
                         vec3 &neighborCohesion
                         ) {
        
        neighborCounter = 0;
        vec3 neighborCentroid = vec3(0);
        neighborAlignment = vec3(0);
        neighborSeparation = vec3(0);
        neighborCohesion = vec3(0);
        
        vec3 aux;
        float dist;
        for(int i=0;i<list.size();i++){
            if (boid != &list[i]){
                
                if (boid->isVisible(list[i],false)){
                    neighborCounter++;
                    neighborCentroid += list[i].pos;
                    neighborAlignment += list[i].dir;
                }
                
                if (boid->isVisible(list[i],true)){
                    //calcular separacao
                    aux = boid->pos - list[i].pos;
                    dist = length(aux);
                    if (dist <= 0.0002f) {
                        aux = randomDirection();
                        aux *= 9999.0f;
                    } else {
                        aux /= dist;
                        aux *= 1.0f/(dist*dist);
                    }
                    
                    neighborSeparation += aux;
                }
            }
        }
        
        if (neighborCounter > 0){
            
            //neighborAlignment /= neighborCounter;
            if (sqrLength(neighborAlignment) > 1e-6f)
                neighborAlignment = normalize(neighborAlignment);
            
            neighborCentroid /= neighborCounter;
            neighborCohesion = neighborCentroid - boid->pos;
            if (sqrLength(neighborCohesion) > 1e-6f)
                neighborCohesion = normalize(neighborCohesion);
            else
                neighborCohesion = vec3(0);
        }
        
    }
public:
    
    Boid boidMaster;
    
    Flock(App *app, int numBoids , vec3 sceneMin, vec3 sceneMax):
    boidMaster(
    (sceneMax+sceneMin)*0.5f,
               vec3(0,0,-1.0),
               5.0f,
               0.0f,0.0f) {
        
        this->app = app;
        this->sceneMin = sceneMin;
        this->sceneMax = sceneMax;
        sceneDelta = sceneMax - sceneMin;
        
        boidModel = new BoidModel(app);
        
        doubleBuffer = 0;
        
        for(int i=0;i<numBoids;i++)
            createBoid();
    }
    ~Flock() {
        setNullAndDelete(boidModel);
    }
    
    void createBoid() {
        vec3 dir = randomDirection();
        dir *= vec3(1.0f,0.2f,1.0f);
        dir = normalize(dir);
        
        vec3 pos = sceneMin + (Random::getVec3() - vec3(0.5f))*2.0f*sceneDelta;
        
        float vel = Random::getFloat() * 5.0f + 5.0f;
        
        Boid boid = Boid(pos,dir,vel,
                         4.0f,//vision distance
                         120.0f//vision angle degree
                         );
        boids[0].push_back(boid);
        boids[1].push_back(boid);
    }
    
    void boidsUpdate(const PlatformTime &time) {
        int source = doubleBuffer;
        int target = (doubleBuffer + 1) % 2;
        
#pragma omp parallel for
        for(int i=0;i<boids[target].size();i++){
            Boid &bsource = boids[source][i];
            Boid &btarget = boids[target][i];
            
            btarget = bsource;
            
            int neighborCounter;
            vec3 neighborAlignment;
            vec3 neighborSeparation;
            vec3 neighborCohesion;
            
            computeNeighbor(&bsource, boids[source],
                            neighborCounter,
                            neighborAlignment,
                            neighborSeparation,
                            neighborCohesion);
            
            vec3 sceneCollision = vec3(0);
            if (btarget.pos.y < sceneMin.y){
                //sceneCollision = reflect(btarget.dir,vec3(0,1,0));
                sceneCollision = vec3(0,1,0);
                btarget.pos.y = sceneMin.y;
            }else if (btarget.pos.y > sceneMax.y) {
                sceneCollision = vec3(0,-1,0);//reflect(btarget.dir,vec3(0,1,0));
                //btarget.pos.y = sceneMax.y;
            }
            
            vec3 toBoidMaster = boidMaster.pos - bsource.pos;
            float lgnht = length(toBoidMaster);
            if ( lgnht > 1e-6f)
                toBoidMaster /= lgnht;
            
            
            vec3 targetVel =
            neighborAlignment * 1.5f +
            neighborSeparation * 0.5f +
            neighborCohesion * 1.0f +
            sceneCollision * 1.0f
            +toBoidMaster * 0.5f
            ;
            targetVel *= 10.0f;
            
            if (sqrLength(targetVel) > 1e-6f){
                //vec3 aux = perpendicularComponent(targetVel, btarget.dir);
                //vec3 targetDir = normalize(btarget.dir + aux);
                
                vec3 targetDir = normalize(targetVel);
                
                float targetVelF = dot(targetVel,btarget.dir);
                if (abs(targetVelF)<2.0f)
                    targetVelF = sign(targetVelF)*2.0f;
                
                btarget.dir = moveSlerp(bsource.dir, targetDir, DEG2RAD(time.deltaTime*100.0f));
                btarget.vel = move(bsource.vel, targetVelF, time.deltaTime * 2.5f);
                
                btarget.dir = normalize(btarget.dir);
                
                btarget.vel = clamp(btarget.vel, 2.0f, 5.0f);
            } else {
                btarget.vel = clamp(move(btarget.vel,btarget.vel*1.5f,time.deltaTime*10.0f), 2.0f, 5.0f);
            }
            
            btarget.pos += btarget.dir * btarget.vel * time.deltaTime;
            
            /*
             if (btarget.pos.y < sceneMin.y){
             btarget.dir = reflect(btarget.dir,vec3(0,1,0));
             btarget.pos.y = sceneMin.y;
             }else if (btarget.pos.y > sceneMax.y) {
             btarget.dir = reflect(btarget.dir,vec3(0,1,0));
             btarget.pos.y = sceneMax.y;
             }*/
            
            if (btarget.pos.x < sceneMin.x)
                btarget.pos.x += sceneDelta.x;
            else if (btarget.pos.x > sceneMax.x)
                btarget.pos.x -= sceneDelta.x;
            
            if (btarget.pos.z < sceneMin.z)
                btarget.pos.z += sceneDelta.z;
            else if (btarget.pos.z > sceneMax.z)
                btarget.pos.z -= sceneDelta.z;
            
        }
        
        
    }
    
    void draw(PlatformTime &time, const mat4 &m) {
        //limit max variation to run like 60FPS
        time.deltaTime = minimum(time.deltaTime, 1.0f/24.0f);
        
        processBoidMasterInput(time);
        boidsUpdate(time);
        
        //int previousFrame = doubleBuffer;
        int currentFrame = (doubleBuffer + 1) % 2;
        
        for(int i=0;i<boids[currentFrame].size();i++){
            Boid &boid = boids[currentFrame][i];
            boidModel->draw(m, boid.pos, boid.dir);
        }
        
        doubleBuffer = (doubleBuffer + 1) % 2;
        
        //
        // Draw boid master
        //
        boidModel->drawBoidMaster(m, boidMaster.pos, boidMaster.dir);
    }
    
    void processBoidMasterInput(const PlatformTime &time) {
        
        
        sf::Vector2i ipos = sf::Mouse::getPosition(*app->window);
        iSize iscreen = app->WindowSize;
        
        ipos.y = iscreen.y - 1 - ipos.y;
        
        vec2 input = vec2((float)ipos.x / (float)(iscreen.x-1),
                          (float)ipos.y / (float)(iscreen.y-1));
        
        input = clamp(input, vec2(0),vec2(1));
        input = (input - 0.5f) * 2.0f;
        
        if (input.x > -0.125f && input.x < 0.125f)
            input.x = 0.0f;
        
        vec3 targetDir = boidMaster.dir;
        
        vec3 perp = cross(normalize(vec3(boidMaster.dir.x,0,boidMaster.dir.z)), vec3(0,1.0f,0));
        targetDir += perp * input.x * 0.5f;
        targetDir.y = input.y;
        targetDir = normalize(targetDir);
        
        boidMaster.dir = moveSlerp(boidMaster.dir, targetDir, DEG2RAD(80.0f) * time.deltaTime);
        
        
        //
        // BoidMaster calculation
        //
        
        boidMaster.pos += boidMaster.dir * boidMaster.vel * time.deltaTime;
        
        if (boidMaster.pos.y < sceneMin.y){
            boidMaster.dir.y = 0;
            boidMaster.dir = normalize(boidMaster.dir);
            boidMaster.pos.y = sceneMin.y;
        }else if (boidMaster.pos.y > sceneMax.y) {
            boidMaster.dir.y = 0;
            boidMaster.dir = normalize(boidMaster.dir);
            boidMaster.pos.y = sceneMax.y;
        }
        
        if (boidMaster.pos.x < sceneMin.x)
            boidMaster.pos.x += sceneDelta.x;
        else if (boidMaster.pos.x > sceneMax.x)
            boidMaster.pos.x -= sceneDelta.x;
        
        if (boidMaster.pos.z < sceneMin.z)
            boidMaster.pos.z += sceneDelta.z;
        else if (boidMaster.pos.z > sceneMax.z)
            boidMaster.pos.z -= sceneDelta.z;
    }
    
};

#endif

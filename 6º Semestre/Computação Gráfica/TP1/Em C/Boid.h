#ifndef __boid_h
#define __boid_h

#include <aribeiro/aribeiro.h>
using namespace aRibeiro;

class Boid {
public:
    vec3 pos;
    vec3 dir;
    float vel;
    
    float visionDistanceSquared;
    float visionAngleCos;
    
    Boid(vec3 pos,vec3 dir, float vel,
         float visionDistance,
         float visionAngleDegree) {
        this->pos = pos;
        this->dir = dir;
        this->vel = vel;
        
        this->visionDistanceSquared = visionDistance*visionDistance;
        this->visionAngleCos = cos(DEG2RAD(visionAngleDegree / 2.0f));
    }
    
    bool isVisible(const Boid &boid, bool ignoreAngle = false)const{
        vec3 toBoid = boid.pos - pos;
        float distance = sqrLength(toBoid);
        if (distance < visionDistanceSquared && distance > 1e-6f){
            
            if (ignoreAngle)
                return true;
            
            distance = sqrt(distance);
            toBoid /= distance;
            
            return dot(toBoid,dir) > visionAngleCos;
        }
        return false;
    }
};

#endif


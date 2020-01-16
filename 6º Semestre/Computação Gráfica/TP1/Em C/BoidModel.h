
#ifndef boid_model_H
#define boid_model_H

#include <aribeiro/aribeiro.h>
using namespace aRibeiro;

#include "App.h"
#include "Boid.h"

class BoidModel {
    App *app;
public:
    
    BoidModel(App *app){
        this->app = app;
    }
    
    void draw(const mat4 &transform, const vec3 &pos, const vec3 &dir){
        
        //
        // Compute rotation
        //
        vec3 up = vec3(0.0f,1.0f,0.0f);
        vec3 lookTo = normalize(dir);
        vec3 x, y, z;
        z = -lookTo;
        x = cross(up, z);
        y = cross(z, x);
        
        mat4 boidTransform = transform * mat4(
                                              x.x, y.x, z.x, pos.x,
                                              x.y, y.y, z.y, pos.y,
                                              x.z, y.z, z.z, pos.z,
                                              0, 0, 0, 1);
        
        
        
        /*
         /\  - red
         <| |> - blue
         /\  - blue
         */
        static const vec3 bodyVBuffer[] = {
            vec3(-0.25f,0.0f, 0.5f),
            vec3( 0.25f,0.0f, 0.5f),
            vec3( 0.25f,0.0f, -0.5f),
            vec3(-0.25f,0.0f, -0.5f),
            
            vec3(-0.25f,0.0f, 1.0f),
            vec3( 0.25f,0.0f, 1.0f),
            vec3( 0.125f,0.0f, 0.5f),
            vec3(-0.125f,0.0f, 0.5f)
        };
        
        static const vec4 bodyCBuffer[] = {
            // blue
            vec4(0.4f,0.4f,1.0f,1.0f),
            vec4(0.4f,0.4f,1.0f,1.0f),
            vec4(0.4f,0.4f,1.0f,1.0f),
            vec4(0.4f,0.4f,1.0f,1.0f),
            
            
            vec4(0.4f,0.4f,1.0f,1.0f),
            vec4(0.4f,0.4f,1.0f,1.0f),
            vec4(0.7f,0.7f,1.0f,1.0f),
            vec4(0.7f,0.7f,1.0f,1.0f)
        };
        app->drawPrimitive(GL_QUADS,boidTransform,bodyVBuffer, bodyCBuffer, 8 );
        
        
        
        /*
         /\  - red
         <| |> - blue
         /\  - blue
         */
        static const vec3 headVBuffer[] = {
            vec3(-0.25f,0.0f, -0.5f),
            vec3( 0.25f,0.0f, -0.5f),
            vec3( 0.0f,0.0f, -1.0f)
            
        };
        
        static const vec4 headCBuffer[] = {
            // blue
            vec4(1.0f,0.7f,0.7f,1.0f),
            vec4(1.0f,0.7f,0.7f,1.0f),
            vec4(1.0f,0.4f,0.4f,1.0f)
        };
        app->drawPrimitive(GL_TRIANGLES,boidTransform,headVBuffer, headCBuffer, 3 );
        
        
        
        static const vec3 wingVBuffer[] = {
            vec3( 0.0f,0.0f, -0.5f),
            vec3( 0.0f,0.0f, 0.5f),
            vec3( 0.75f,0.0f, 0.0f),
            
            
            vec3( 0.0f,0.0f, 0.5f),
            vec3( 0.0f,0.0f, -0.5f),
            vec3( -0.75f,0.0f, 0.0f)
            
        };
        
        static const vec4 wingCBuffer[] = {
            // blue
            vec4(0.7f,0.7f,1.0f,1.0f),
            vec4(0.4f,0.4f,1.0f,1.0f),
            vec4(0.7f,0.7f,1.0f,1.0f),
            
            vec4(0.4f,0.4f,1.0f,1.0f),
            vec4(0.7f,0.7f,1.0f,1.0f),
            vec4(0.7f,0.7f,1.0f,1.0f)
        };
        
        app->drawPrimitive(GL_TRIANGLES,boidTransform*translate(0.25f,0.0f,0.0f)*zRotate(DEG2RAD(20.0f)),wingVBuffer, wingCBuffer, 3 );
        
        app->drawPrimitive(GL_TRIANGLES,boidTransform*translate(-0.25f,0.0f,0.0f)*zRotate(DEG2RAD(-20.0f)),&wingVBuffer[3], &wingCBuffer[3], 3 );
        
        
    }
    
    
    void drawBoidMaster(const mat4 &transform, const vec3 &pos, const vec3 &dir){
        
        //
        // Compute rotation
        //
        vec3 up = vec3(0.0f,1.0f,0.0f);
        vec3 lookTo = normalize(dir);
        vec3 x, y, z;
        z = -lookTo;
        x = cross(up, z);
        y = cross(z, x);
        
        mat4 boidTransform = transform * mat4(
                                              x.x, y.x, z.x, pos.x,
                                              x.y, y.y, z.y, pos.y,
                                              x.z, y.z, z.z, pos.z,
                                              0,   0,   0,   1
                                              );
        
        
        
        /*
         /\  - red
         <| |> - blue
         /\  - blue
         */
        static const vec3 bodyVBuffer[] = {
            vec3(-0.25f,0.0f, 0.5f),
            vec3( 0.25f,0.0f, 0.5f),
            vec3( 0.25f,0.0f, -0.5f),
            vec3(-0.25f,0.0f, -0.5f),
            
            vec3(-0.25f,0.0f, 1.0f),
            vec3( 0.25f,0.0f, 1.0f),
            vec3( 0.125f,0.0f, 0.5f),
            vec3(-0.125f,0.0f, 0.5f)
        };
        
        static const vec4 bodyCBuffer[] = {
            // blue
            vec4(1.0f,1.0f,0.4f,1.0f),
            vec4(1.0f,1.0f,0.4f,1.0f),
            vec4(1.0f,1.0f,0.4f,1.0f),
            vec4(1.0f,1.0f,0.4f,1.0f),
            
            
            vec4(1.0f,1.0f,0.4f,1.0f),
            vec4(1.0f,1.0f,0.4f,1.0f),
            vec4(1.0f,1.0f,0.7f,1.0f),
            vec4(1.0f,1.0f,0.7f,1.0f)
        };
        app->drawPrimitive(GL_QUADS,boidTransform,bodyVBuffer, bodyCBuffer, 8 );
        
        
        
        /*
         /\  - red
         <| |> - blue
         /\  - blue
         */
        static const vec3 headVBuffer[] = {
            vec3(-0.25f,0.0f, -0.5f),
            vec3( 0.25f,0.0f, -0.5f),
            vec3( 0.0f,0.0f, -1.0f)
            
        };
        
        static const vec4 headCBuffer[] = {
            // blue
            vec4(1.0f,0.7f,0.7f,1.0f),
            vec4(1.0f,0.7f,0.7f,1.0f),
            vec4(1.0f,0.4f,0.4f,1.0f)
        };
        app->drawPrimitive(GL_TRIANGLES,boidTransform,headVBuffer, headCBuffer, 3 );
        
        
        
        static const vec3 wingVBuffer[] = {
            vec3( 0.0f,0.0f, -0.5f),
            vec3( 0.0f,0.0f, 0.5f),
            vec3( 0.75f,0.0f, 0.0f),
            
            
            vec3( 0.0f,0.0f, 0.5f),
            vec3( 0.0f,0.0f, -0.5f),
            vec3( -0.75f,0.0f, 0.0f)
            
        };
        
        static const vec4 wingCBuffer[] = {
            // blue
            vec4(1.0f,1.0f,0.7f,1.0f),
            vec4(1.0f,1.0f,0.4f,1.0f),
            vec4(1.0f,1.0f,0.7f,1.0f),
            
            vec4(1.0f,1.0f,0.4f,1.0f),
            vec4(1.0f,1.0f,0.7f,1.0f),
            vec4(1.0f,1.0f,0.7f,1.0f)
        };
        
        app->drawPrimitive(GL_TRIANGLES, boidTransform * translate(0.25f,0.0f,0.0f) * zRotate(DEG2RAD(20.0f)), wingVBuffer, wingCBuffer, 3 );
        
        app->drawPrimitive(GL_TRIANGLES,boidTransform * translate(-0.25f,0.0f,0.0f) * zRotate(DEG2RAD(-20.0f)), &wingVBuffer[3], &wingCBuffer[3], 3 );
        
        
    }

};

#endif

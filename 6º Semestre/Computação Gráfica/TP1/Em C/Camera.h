#ifndef __camera_h
#define __camera_h

#include <aribeiro/aribeiro.h>
using namespace aRibeiro;

#include "Boid.h"

class Camera {
public:
    vec3 dir;
    vec3 up;
    float distance;
    
    mat4 transformMatrix;
    
    Camera() {
        dir = vec3(0,0,-1);
        up = vec3(0,1,0);
        
        distance = 20.0f;
        
        //transform direction
        dir = toVec3(
                     zRotate(DEG2RAD(-45.0f)) *
                     xRotate(DEG2RAD(-45.0f)) * toVec4(dir) );
        
    }
    
    mat4 computeViewMatrix(Boid *boidMaster) {
        vec3 lookTo = dir;
        vec3 x, y, z;
        z = -lookTo;
        x = cross(up, z);
        y = cross(z, x);
        
        transformMatrix = mat4(
                               x.x, y.x, z.x, 0,
                               x.y, y.y, z.y, 0,
                               x.z, y.z, z.z, 0,
                               0, 0, 0, 1);
        
        transformMatrix =
        translate(boidMaster->pos.x,boidMaster->pos.y,boidMaster->pos.z) *
        transformMatrix *
        translate(0,0,distance);
        
        return inv(transformMatrix);
    }
    
};

#endif


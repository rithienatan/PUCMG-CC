#ifndef Ground_model_h
#define Ground_model_h

#include <aribeiro/aribeiro.h>
using namespace aRibeiro;

#include "App.h"

class GroundModel {
public:
    App *app;
    vec3 *vertexBuffer;
    vec4 *colorBuffer;
    uint16_t *indicesBuffer;
    int indiceCount;
    
    GroundModel(App *app,
                vec3 min, vec3 max,
                int xDiv, int zDiv,
                float randomHeight = 0.1f){
        this->app = app;
        
        if (xDiv < 2)
            xDiv = 2;
        if (zDiv < 2)
            zDiv = 2;
        
        vertexBuffer = new vec3[xDiv*zDiv];
        colorBuffer = new vec4[xDiv*zDiv];
        indicesBuffer = new uint16_t[(xDiv-1)*(zDiv-1)*4];
        
        vec3 delta = max - min;
        delta.x /= (xDiv-1);
        delta.z /= (zDiv-1);
        int count = 0;
        for(int z=0;z<zDiv;z++){
            for(int x=0;x<xDiv;x++){
                float heightNorm = Random::getFloat();
                vertexBuffer[x+z*xDiv] = vec3(min.x + (float)x*delta.x, heightNorm * randomHeight,min.z + (float)z*delta.z);
                colorBuffer[x+z*xDiv] = vec4( FloatColorConversion::HSVtoRGB(
                            vec3(Random::getFloat()*360.0f, 0.5f, heightNorm * 0.5f + 0.5f)), 1.0f );
                
                if (z<zDiv-1 && x<xDiv-1){
                    indicesBuffer[count + 0] = x + z * xDiv;
                    indicesBuffer[count + 1] = x + (z+1) * xDiv;
                    indicesBuffer[count + 2] = x + 1 + (z+1) * xDiv;
                    indicesBuffer[count + 3] = x + 1 + z * xDiv;
                    
                    count += 4;
                }
            }
        }
        
        indiceCount = count;
        
        
    }
    
    
    ~GroundModel() {
        setNullAndDeleteArray(vertexBuffer);
        setNullAndDeleteArray(colorBuffer);
        setNullAndDeleteArray(indicesBuffer);
    }
    
    
    void draw(const mat4 &transform){
        app->drawPrimitive6(GL_QUADS, transform, vertexBuffer, colorBuffer, indicesBuffer,  indiceCount );
    }
    
};

#endif

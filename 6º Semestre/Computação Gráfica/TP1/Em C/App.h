#ifndef App__H
#define App__H

#include <aribeiro/aribeiro.h>
using namespace aRibeiro;

#include "util/AppBase.h"
#include "util/GLRenderState.h"

#include <SFML/System.hpp>
#include <SFML/Window.hpp>
#include <SFML/Graphics.hpp>

//#include "GroundModel.h"
class GroundModel;
class BoidModel;//forwarding implementation
class Flock;
class Camera;


class App : public AppBase {
    // render state
    GLRenderState *renderState;
    //
    // time processor
    //
    PlatformTime time;
    //
    // default drawing shader
    //
    GLShaderVertexColor *shaderVertexColor;
    //
    // auxiliary matrix
    //
    mat4 projection;
    //mat4 camera;
    //
    // input helper
    //
    PressReleaseDetector left,right,up,down;
    //
    // auxiliary variables
    //
    //vec3 cameraPosition;
    
    GroundModel *groundModel;
    
    Flock *flock;
    Camera *camera;
    
    //BoidModel *boidModel;
    void processInput();
    
    void OnWindowResize(Property<iSize> *prop);
    
public:
    sf::RenderWindow *window;
    
    App(sf::RenderWindow *window, int w, int h);
	virtual ~App();
	virtual void draw();
    
    void drawPrimitive(GLuint oglPrimitive, const mat4 &modelViewProjection, const vec3 vertexBuffer[], const vec4 colorBuffer[], int count);
    
    void drawPrimitive6(GLuint oglPrimitive, const mat4 &modelViewProjection, const vec3 *vertexBuffer, const vec4 *colorBuffer, const uint16_t *indice, int count);
};

#endif

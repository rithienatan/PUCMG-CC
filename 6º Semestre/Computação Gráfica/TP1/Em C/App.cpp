#include <aribeiro/aribeiro.h>
using namespace aRibeiro;
#include "App.h"

#include "GroundModel.h"
#include "BoidModel.h"
#include "Flock.h"
#include "Camera.h"

App::App(sf::RenderWindow *window, int w, int h):
    AppBase(w,h)
{
    this->window = window;
    
    
    int limitz = 20;
    int limitx = limitz;
    vec3 sceneMin = vec3(-limitx,0.3f,-limitz);
    vec3 sceneMax = vec3(limitx,3.0f,limitz);
    
    groundModel = new GroundModel(this,
                sceneMin,sceneMax,
                limitx,limitz,0.3f);
    
    flock = new Flock(this,
                      500,
                      sceneMin,sceneMax);
    
    camera = new Camera();
    
    renderState = GLRenderState::getInstance();
    
    shaderVertexColor = new GLShaderVertexColor();
    
    //initialize all matrix
    projection = mat4::IdentityMatrix;
    //camera = mat4::IdentityMatrix;
    
    //initialize auxiliary variables
    //cameraPosition = vec3(0.0f,5.0f,10.0f);
    
    //listen the resize window event
    WindowSize.OnChange.add(this, &App::OnWindowResize);
    OnWindowResize(&WindowSize);

    //setup renderstate
    renderState->ClearColor = vec4(1.0f,1.0f,250.0f/255.0f,1.0f);
    renderState->Wireframe = WireframeBack;
    renderState->CullFace = CullFaceNone;
    
    time.update();
}

App::~App(){
    setNullAndDelete(shaderVertexColor);
    setNullAndDelete(groundModel);
    setNullAndDelete(flock);
    setNullAndDelete(camera);
}

void App::OnWindowResize(Property<iSize> *prop){
    iSize size = prop->value;
    // configure the projection
    projection = projection_perspective(75.0f, (float)size.x/(float)size.y, 0.01f, 100.0f);
}
float acc = 0;
void App::draw() {
    time.update();
    acc += time.deltaTime;
    if (acc > 1.0f){
        acc = fmod(acc,1.0f);
        printf("fps: %f\n", 1.0f/time.deltaTime);
    }
    processInput();
    
    glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
    
    //compute the camera projection matrix
    //camera = inv(translate(cameraPosition)*xRotate(DEG2RAD(-30.0f)));
    mat4 viewProjection = (mat4)projection * camera->computeViewMatrix(&flock->boidMaster);
    
    groundModel->draw(viewProjection);
    flock->draw(time,viewProjection);
}

void App::processInput() {
    left.setState( sf::Keyboard::isKeyPressed(sf::Keyboard::Left) );
    right.setState( sf::Keyboard::isKeyPressed(sf::Keyboard::Right) );
    up.setState( sf::Keyboard::isKeyPressed(sf::Keyboard::Up) );
    down.setState( sf::Keyboard::isKeyPressed(sf::Keyboard::Down) );
    
    /*
    const float speed = 3.0f;
    if (up.pressed)
        cameraPosition.z -= time.deltaTime * speed;
    if (down.pressed)
        cameraPosition.z += time.deltaTime * speed;
     */
    /*
     if (left.pressed)
     cameraPosition.x -= time.deltaTime * speed;
     if (right.pressed)
     cameraPosition.x += time.deltaTime * speed;
     */
}

void App::drawPrimitive( GLuint oglPrimitive, const mat4 &modelViewProjection, const vec3 vertexBuffer[], const vec4 colorBuffer[], int count ){
    
    renderState->CurrentShader = shaderVertexColor;
    
    shaderVertexColor->setMatrix(modelViewProjection);
    OPENGL_CMD(glEnableVertexAttribArray(GLShaderVertexColor::vPosition));
    OPENGL_CMD(glVertexAttribPointer(GLShaderVertexColor::vPosition, 3, GL_FLOAT, false, sizeof(vec3), &vertexBuffer[0]));
    OPENGL_CMD(glEnableVertexAttribArray(GLShaderVertexColor::vColor));
    OPENGL_CMD(glVertexAttribPointer(GLShaderVertexColor::vColor, 4, GL_FLOAT, false, sizeof(vec4), &colorBuffer[0]));
    OPENGL_CMD(glDrawArrays(oglPrimitive, 0, count));
    OPENGL_CMD(glDisableVertexAttribArray(GLShaderVertexColor::vPosition));
    OPENGL_CMD(glDisableVertexAttribArray(GLShaderVertexColor::vColor));
}

void App::drawPrimitive6(GLuint oglPrimitive, const mat4 &modelViewProjection, const vec3 *vertexBuffer, const vec4 *colorBuffer, const uint16_t *indices, int count) {
    renderState->CurrentShader = shaderVertexColor;
    
    shaderVertexColor->setMatrix(modelViewProjection);
    OPENGL_CMD(glEnableVertexAttribArray(GLShaderVertexColor::vPosition));
    OPENGL_CMD(glVertexAttribPointer(GLShaderVertexColor::vPosition, 3, GL_FLOAT, false, sizeof(vec3), &vertexBuffer[0]));
    OPENGL_CMD(glEnableVertexAttribArray(GLShaderVertexColor::vColor));
    OPENGL_CMD(glVertexAttribPointer(GLShaderVertexColor::vColor, 4, GL_FLOAT, false, sizeof(vec4), &colorBuffer[0]));
    OPENGL_CMD(glDrawElements(oglPrimitive, count, GL_UNSIGNED_SHORT, indices));
    OPENGL_CMD(glDisableVertexAttribArray(GLShaderVertexColor::vPosition));
    OPENGL_CMD(glDisableVertexAttribArray(GLShaderVertexColor::vColor));
}

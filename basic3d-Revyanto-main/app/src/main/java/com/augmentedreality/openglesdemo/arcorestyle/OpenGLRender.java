package com.augmentedreality.openglesdemo.arcorestyle;

import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRender {

    private int viewportWidth = 1;
    private int viewportHeight = 1;

    public OpenGLRender(GLSurfaceView glSurfaceView, Renderer renderer) {
        glSurfaceView.setPreserveEGLContextOnPause(true);
        glSurfaceView.setEGLContextClientVersion(3);
        glSurfaceView.setEGLConfigChooser(
                8, 8, 8, 8,
                16, 0);
        glSurfaceView.setRenderer(
                //create surface view renderer
                new GLSurfaceView.Renderer() {
                    @Override
                    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
                        GLES30.glEnable(GLES30.GL_BLEND);
                        Log.e("GLSurfaceView.Renderer()", "Failed to enable blending" + "glEnable");
                        renderer.onSurfaceCreated(OpenGLRender.this);
                    }

                    @Override
                    public void onSurfaceChanged(GL10 gl10, int w, int h) {
                        viewportWidth = w;
                        viewportHeight = h;
                        renderer.onSurfaceChanged(OpenGLRender.this, w, h);
                    }

                    @Override
                    public void onDrawFrame(GL10 gl10) {
                        clearFramebuffer(0f, 0f, 0f, 1f);
                        renderer.onDrawFrame(OpenGLRender.this);
                    }
                }
        );

        glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        glSurfaceView.setWillNotDraw(false);
    }

    public void draw() {
        useFramebuffer();

    }

    /**
     * Clear the given framebuffer.
     *
     * <p>The {@code framebuffer} argument may be null, in which case the default framebuffer is
     * cleared.
     */
    private void clearFramebuffer(float r, float g, float b, float a) {
        GLES30.glClearColor(r, g, b, a);
        GLError.maybeThrowGLException("Failed to set clear color", "glClearColor");
        GLES30.glDepthMask(true);
        GLError.maybeThrowGLException("Failed to set depth write mask", "glDepthMask");
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT | GLES30.GL_DEPTH_BUFFER_BIT);
        GLError.maybeThrowGLException("Failed to clear framebuffer", "glClear");
    }

    private void useFramebuffer() {
        int framebufferId = 0;
        int viewportWidth = this.viewportWidth;
        int viewportHeight = this.viewportHeight;

        GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, framebufferId);
        GLError.maybeThrowGLException("Failed to bind framebuffer", "glBindFramebuffer");
        GLES30.glViewport(0, 0, viewportWidth, viewportHeight);
        GLError.maybeThrowGLException("Failed to set viewport dimensions", "glViewport");
    }
}

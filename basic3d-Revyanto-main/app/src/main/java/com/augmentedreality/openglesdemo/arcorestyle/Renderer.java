package com.augmentedreality.openglesdemo.arcorestyle;

import android.opengl.GLSurfaceView;

/** Interface to be implemented for rendering callbacks. */
interface Renderer {
    void onSurfaceCreated(OpenGLRender sampleRender);

    void onSurfaceChanged(OpenGLRender render, int width, int height);

    /**
     * Called by {@link OpenGLRender} when a GL frame is to be rendered.
     *
     * <p>See {@link GLSurfaceView.Renderer#onDrawFrame}.
     */
    void onDrawFrame(OpenGLRender render);
}

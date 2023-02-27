package com.augmentedreality.openglesdemo;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class MyGlSurfaceView extends GLSurfaceView {

    private final MyGLRenderer renderer;

    public MyGlSurfaceView(Context context) {
        super(context);
        renderer = new MyGLRenderer();
        initOpenGLView();
    }

    public MyGlSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        renderer = new MyGLRenderer();
        initOpenGLView();
    }

    private void initOpenGLView() {
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(3);
        setRenderer(renderer);
    }
}

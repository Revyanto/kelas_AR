package com.augmentedreality.openglesdemo.arcorestyle;

import android.opengl.GLES30;
import android.opengl.GLException;

import java.util.ArrayList;
import java.util.List;

public class GLError {
    public static void maybeThrowGLException(String reason, String api) {
        List<Integer> errorCodes = getGlErrors();
        if (errorCodes != null) {
            throw new GLException(errorCodes.get(0), "Reason : " + reason + " , API: " + api + " , errorCode: " + errorCodes);
        }
    }

    private static List<Integer> getGlErrors() {
        int errorCode = GLES30.glGetError();
        // Shortcut for no errors
        if (errorCode == GLES30.GL_NO_ERROR) {
            return null;
        }
        List<Integer> errorCodes = new ArrayList<>();
        errorCodes.add(errorCode);
        while (true) {
            errorCode = GLES30.glGetError();
            if (errorCode == GLES30.GL_NO_ERROR) {
                break;
            }
            errorCodes.add(errorCode);
        }
        return errorCodes;
    }
}

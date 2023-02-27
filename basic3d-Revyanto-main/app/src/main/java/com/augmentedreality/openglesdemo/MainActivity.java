package com.augmentedreality.openglesdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.augmentedreality.openglesdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    MyGlSurfaceView myGlSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myGlSurfaceView = binding.surfaceview;
    }
}
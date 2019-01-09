package com.example.sheetalkumar.swasthya.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sheetalkumar.swasthya.R;

public class LoginActivity extends AppCompatActivity {


    private LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        lottieAnimationView = findViewById(R.id.lotti_animation);
        lottieAnimationView.playAnimation();
    }
}

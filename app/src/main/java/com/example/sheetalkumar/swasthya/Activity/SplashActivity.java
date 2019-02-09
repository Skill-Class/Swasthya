package com.example.sheetalkumar.swasthya.Activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sheetalkumar.swasthya.R;


/**
 * @Author - Sheetal Kumar
 * -------------------------------------
 * In App - Splash Activity
 * Attached adapter - None
 * Objective -  To show splash screen and when user clicks on get started button he/she will be send to intro screen activity.
 * Todo - nothing
 * Status - complete
 * -------------------------------------
 */

public class SplashActivity extends AppCompatActivity {

    private Button getStartedButton;
    private ImageView logoImage;
    private TextView logoText, shortTextLogo, termsText, developerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /**
         **
         * Connecting all XML views to java file using findViewById
         */
        AddXMLToJava();

        /**
         **
         * Adding Animation to Views
         * Here using AnimationUtils
         */
        AddAnimationToView();


        // Whenever user clicks on get started button he/she will be send to Intro screen.
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToIntroScreen();
            }
        });

    }

    private void sendToIntroScreen() {

        Intent intent = new Intent(SplashActivity.this, IntroActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);    // Activity transition animation

    }

    private void AddAnimationToView() {

        Animation bottomToUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_top);
        Animation topToBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_to_bottom);

        getStartedButton.startAnimation(bottomToUp);
        termsText.startAnimation(bottomToUp);
        developerText.startAnimation(bottomToUp);

        logoText.startAnimation(topToBottom);
        logoImage.startAnimation(topToBottom);
        shortTextLogo.startAnimation(topToBottom);

    }

    private void AddXMLToJava() {

        logoText = findViewById(R.id.logo_text);
        shortTextLogo = findViewById(R.id.dummy_logo_text);
        termsText = findViewById(R.id.terms_text);
        logoImage = findViewById(R.id.imageView3);
        developerText = findViewById(R.id.textView10);
        getStartedButton = findViewById(R.id.button_getStarted);

    }

}



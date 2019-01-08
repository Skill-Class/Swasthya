package com.example.sheetalkumar.swasthya.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.sheetalkumar.swasthya.R;

public class SplashActivity extends AppCompatActivity {

    private Button getStartedButton;
    private TextView logoText, dummyLogoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getStartedButton = findViewById(R.id.button_getStarted);
        logoText = findViewById(R.id.logo_text);
        dummyLogoText = findViewById(R.id.dummy_logo_text);


        Animation bottomToUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_top);
        Animation topToBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_to_bottom);

        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, IntroActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
            }
        });

        getStartedButton.startAnimation(bottomToUp);
        logoText.startAnimation(topToBottom);
        dummyLogoText.startAnimation(topToBottom);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final Intent intent = new Intent(this, IntroActivity.class);
        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                    finish();

                }
            }
        };
        timer.start();

    }

}



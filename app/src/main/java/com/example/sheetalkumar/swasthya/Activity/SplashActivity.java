package com.example.sheetalkumar.swasthya.Activity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sheetalkumar.swasthya.R;

public class SplashActivity extends AppCompatActivity {

    private Button getStartedButton;
    private Button getSignin;

    private TextView logoText, dummyLogoText, termsText;

  //  private LottieAnimationView lottieAnimationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        getStartedButton = findViewById(R.id.button_getStarted);
      //  getSignin = findViewById(R.id.button_getSignin);

        logoText = findViewById(R.id.logo_text);
        dummyLogoText = findViewById(R.id.dummy_logo_text);
        termsText = findViewById(R.id.terms_text);

        // lottieAnimationView = findViewById(R.id.lotti_animation);
        // startCheckAnimation();

        Animation bottomToUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_top);
        Animation topToBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_to_bottom);


        Animation zoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);

        // lottieAnimationView.startAnimation(zoomOut);

        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, IntroActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);    // Activity transition animation
            }
        });




      //  getSignin.startAnimation(bottomToUp);
        getStartedButton.startAnimation(bottomToUp);
        termsText.startAnimation(bottomToUp);

        logoText.startAnimation(topToBottom);
        dummyLogoText.startAnimation(topToBottom);


        // lottieAnimationView.playAnimation();

    }


    // this was used to splash screen working fine.


  /*  @Override
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
    }*/



  // lotti animation function works fine.

    /*
    private void startCheckAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f).setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                lottieAnimationView.setProgress((Float) animation.getAnimatedValue());
            }
        });

        if (lottieAnimationView.getProgress() == 0f) {
            valueAnimator.start();
        } else {
            lottieAnimationView.setProgress(0f);
        }
    }*/

}



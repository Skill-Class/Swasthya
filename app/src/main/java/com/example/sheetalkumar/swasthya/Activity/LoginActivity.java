package com.example.sheetalkumar.swasthya.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sheetalkumar.swasthya.R;

public class LoginActivity extends AppCompatActivity {


    private LottieAnimationView lottieAnimationView;
    private TextView RegisterNowText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        RegisterNowText = findViewById(R.id.textView3);
        lottieAnimationView = findViewById(R.id.lotti_animation);


        RegisterNowText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);    // Activity transition animation

            }
        });
        lottieAnimationView.playAnimation();
    }
}

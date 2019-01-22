package com.example.sheetalkumar.swasthya.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sheetalkumar.swasthya.R;

public class LoginActivity extends AppCompatActivity {


    private LottieAnimationView lottieAnimationView;
    private TextView RegisterNowText, textView1,textView2;
    private Button loginButton;

    private ConstraintLayout constraintLayout;
    private ImageView logoImage;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        RegisterNowText = findViewById(R.id.textView3);
        loginButton = findViewById(R.id.button2);
        constraintLayout = findViewById(R.id.constraintLayout);
        logoImage = findViewById(R.id.imageView);

        textView1 = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView3);

        progressDialog = new ProgressDialog(this);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_top);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_to_bottom);

        constraintLayout.startAnimation(animation);
        logoImage.startAnimation(animation1);
        textView1.startAnimation(animation);
        textView2.startAnimation(animation);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.setIcon(R.drawable.ic_social_care_green);
                progressDialog.setTitle("Signing in");
                progressDialog.setMessage("Please wait for a moment..");
                progressDialog.show();

                Intent intent = new Intent(LoginActivity.this, HomeScreenActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);    // Activity transition animation
            }
        });
        // lottieAnimationView = findViewById(R.id.lotti_animation);


        RegisterNowText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);    // Activity transition animation

            }
        });
        //  lottieAnimationView.playAnimation();
    }
}

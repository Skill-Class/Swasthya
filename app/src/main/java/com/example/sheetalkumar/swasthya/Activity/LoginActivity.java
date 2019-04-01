package com.example.sheetalkumar.swasthya.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sheetalkumar.swasthya.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * @Author - Sheetal Kumar
 * -------------------------------------
 * In App - Login Activity
 * Attached adapter - None
 * Objective -  Allow user to login in this app
 * Todo - Firebase Authentication
 * Status - incomplete
 * -------------------------------------
 */

public class LoginActivity extends AppCompatActivity {

    private TextView RegisterNowText, textView1, textView2;
    private Button loginButton;
    private ConstraintLayout constraintLayout;
    private ImageView logoImage;
    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;
    private TextInputLayout emailtext, passwordtext;
    private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        mAuth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();





        //   databaseReferenceroot = firebaseDatabase.getReference();


        /**
         **
         * Connecting all XML views to java file using findViewById
         */
        AddXMLToJava();

        /**
         * Add adapters
         */
        AddAnimationToViews();


        // Sending user to home screen after login button clicked
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Please wait..", Toast.LENGTH_SHORT).show();
                String email = emailtext.getEditText().getText().toString().trim();
                String password = passwordtext.getEditText().getText().toString().trim();

                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                Intent mainIntent = new Intent(LoginActivity.this, HomeScreenActivity.class);
                                startActivity(mainIntent);
                                finish();

                            } else {
                                String erroMessage = task.getException().getMessage();
                                Toast.makeText(LoginActivity.this, "Error : " + erroMessage, Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }
        });

        // Sending user to register screen
        RegisterNowText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToRegisterActivity();
            }
        });
    }

    private void sendToRegisterActivity() {

        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);    // Activity transition animation

    }

    private void sendToHomeScreen() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setIcon(R.drawable.ic_social_care_green);
        progressDialog.setTitle("Signing in");
        progressDialog.setMessage("Please wait for a moment..");
        progressDialog.show();

        Intent intent = new Intent(LoginActivity.this, HomeScreenActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);    // Activity transition animation
    }

    private void AddAnimationToViews() {

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_top);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_to_bottom);

        constraintLayout.startAnimation(animation);
        logoImage.startAnimation(animation1);
        textView1.startAnimation(animation);
        textView2.startAnimation(animation);

    }

    private void AddXMLToJava() {

        RegisterNowText = findViewById(R.id.textView3);
        loginButton = findViewById(R.id.button2);
        constraintLayout = findViewById(R.id.constraintLayout);
        logoImage = findViewById(R.id.imageView);
        textView1 = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView3);
        emailtext= findViewById(R.id.textInputLayoutemail);
        passwordtext=findViewById(R.id.textinputlayoutpassword);




    }
}

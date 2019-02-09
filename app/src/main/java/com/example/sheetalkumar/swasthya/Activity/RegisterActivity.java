package com.example.sheetalkumar.swasthya.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sheetalkumar.swasthya.R;


/**
 * @Author - Sheetal Kumar
 * -------------------------------------
 * In App - Register Activity
 * Attached adapter - None
 * Objective -  Allow user to register
 * Todo - static data to dynamic data. 2. firebase authentication
 * Status - incomplete
 * -------------------------------------
 */

public class RegisterActivity extends AppCompatActivity {

    private TextView loginText;
    private Button registerButton;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        /**
         **
         * Connecting all XML views to java file using findViewById
         */
        AddXMLToJava();

        // Sending user to home screen
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToHomeScreen();

            }
        });

        // Sending user to login screen.
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToLoginScreen();
            }
        });
    }

    private void AddXMLToJava() {

        registerButton = findViewById(R.id.button2);
        loginText = findViewById(R.id.textView3);

    }

    private void sendToLoginScreen() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
    }

    private void sendToHomeScreen() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setIcon(R.drawable.ic_social_care_green);
        progressDialog.setTitle("Signing up");
        progressDialog.setMessage("Please wait for a moment..");
        progressDialog.show();

        Intent intent = new Intent(RegisterActivity.this, HomeScreenActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
    }
}

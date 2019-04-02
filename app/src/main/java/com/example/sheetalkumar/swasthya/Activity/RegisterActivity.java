package com.example.sheetalkumar.swasthya.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sheetalkumar.swasthya.Model.Users;
import com.example.sheetalkumar.swasthya.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


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
    private TextInputLayout emailText, pass,confirmpass,username;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    private DatabaseReference databaseReference;
    private FirebaseDatabase mdatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        AddXMLToJava();

        mAuth = FirebaseAuth.getInstance();
        String userName = username.getEditText().getText().toString();


        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
//        String currnetusername = mAuth.getCurrentUser().getDisplayName();
        mdatabase = FirebaseDatabase.getInstance();
        databaseReference = mdatabase.getReference();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "Please wait..", Toast.LENGTH_SHORT).show();
                createNewAccoutnt();
            }
        });


        /**
         **
         * Connecting all XML views to java file using findViewById
         */




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
        emailText = findViewById(R.id.textInputLayoutemail);
        pass = findViewById(R.id.textinputlayoutpassword);
        confirmpass = findViewById(R.id.textinputlayoutconfirmpassword);
        username = findViewById(R.id.textinputlayoutusername);

    }

    private void sendToLoginScreen() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
    }

    private void createNewAccoutnt() {
        final String emailID = emailText.getEditText().getText().toString().trim();
        final String password = pass.getEditText().getText().toString().trim();
        final String confirmpassword = confirmpass.getEditText().getText().toString().trim();
        final String userName = username.getEditText().getText().toString();


       // FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();



        if (!TextUtils.isEmpty(emailID) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirmpassword)) {

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


            if (password.equals(confirmpassword)) {
                mAuth.createUserWithEmailAndPassword(emailID, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
//                            StorageReference imagePath = mFirebaseStorage.child("MBlog_Profile_Pics")
                            //                                  .child(resultUri.getLastPathSegment());

                            String userid = mAuth.getCurrentUser().getUid();
                            DatabaseReference currentUserDb = databaseReference.child("Users").push();
                            String pushId = currentUserDb.getKey();
                            Users users = new Users("userName", "userEmailId", "userProfilePic");

                            Map<String, String> DataToSave = new HashMap<>();
                            DataToSave.put("userName", userName);
                            DataToSave.put("userEmailId", emailID);
                            DataToSave.put("userName",userName);
                            //  DataToSave.put()
                            // DataToSave.put("timestamp", String.valueOf(java.lang.System.currentTimeMillis()));
                            currentUserDb.setValue(DataToSave);
                            //currentUserDb.child("Email").setValue(emailID);
                            //currentUserDb.child("Username").setValue(username);
                            progressDialog.setTitle("Success");
                            progressDialog.setMessage("We are creating your account. Please wait..");
                            progressDialog.show();
                            senttomain();
                        } else {
                            String errorMessage = task.getException().getMessage();
                            Toast.makeText(RegisterActivity.this, "Error : " + errorMessage, Toast.LENGTH_SHORT).show();


                        }
                    }
                });

            } else {
                Toast.makeText(RegisterActivity.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
            }

        }
    }
    // working code ends here.

    private void senttomain() {

        Intent intent = new Intent(RegisterActivity.this, HomeScreenActivity.class);
         // Bundle bundle = new Bundle();
          //bundle.putString("username",username);
         // intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}

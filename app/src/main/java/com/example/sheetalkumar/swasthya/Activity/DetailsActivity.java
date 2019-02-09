package com.example.sheetalkumar.swasthya.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

public class DetailsActivity extends AppCompatActivity {

    private TextView descTextView, titleTextView, headingTextView;
    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        /**
         **
         * Connecting all XML views to java file using findViewById
         */
        AddXMLToJava();

        /**
         **
         * Connecting all XML views to java file using findViewById
         */
        ReceiveDataFromDailyTipsFragmentInBundle();


    }

    private void ReceiveDataFromDailyTipsFragmentInBundle() {

        // Receiving data from fragment to an activity (DailyTipsFragment -> DetailsActivity)
        try {

            Bundle intent = getIntent().getExtras();
            Integer Title = intent.getInt("Title");
            Integer Desc = intent.getInt("Desc");
            Integer Heading = intent.getInt("Heading");

            descTextView.setText(Desc);
            titleTextView.setText(Title);
            headingTextView.setText(Heading);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void AddXMLToJava() {

        myToolbar = findViewById(R.id.my_toolbar);
        descTextView = findViewById(R.id.textView21);
        titleTextView = findViewById(R.id.title_text);
        headingTextView = findViewById(R.id.textView18);

        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...

                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}

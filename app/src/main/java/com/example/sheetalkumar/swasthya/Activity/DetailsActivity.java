package com.example.sheetalkumar.swasthya.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.sheetalkumar.swasthya.R;


/*
    @Dev - Sheetal Kumar
    Date - 23 Jan 2019
 */

public class DetailsActivity extends AppCompatActivity {

    Toolbar myToolbar;
    private TextView descTextView, titleTextView, headingTextView;
    private String Desc;
    private String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        descTextView = findViewById(R.id.textView21);
        titleTextView = findViewById(R.id.title_text);
        headingTextView = findViewById(R.id.textView18);


        // Receiving data from fragment to an activity (DailyTipsFragment -> DetailsActivity)

        try {

            Bundle intent = getIntent().getExtras();
            Integer Title = intent.getInt("Title");
            Integer Desc = intent.getInt("Desc");
            Integer Heading = intent.getInt("Heading");

            descTextView.setText(Desc);
            titleTextView.setText(Title);
            headingTextView.setText(Heading);


        } catch(Exception e) {
            e.printStackTrace();
        }
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

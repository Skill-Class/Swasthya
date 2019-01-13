package com.example.sheetalkumar.swasthya.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.sheetalkumar.swasthya.Fragment.CheckMeFragment;
import com.example.sheetalkumar.swasthya.Fragment.DailyTipsFragment;
import com.example.sheetalkumar.swasthya.Fragment.FinDiseaseFragment;
import com.example.sheetalkumar.swasthya.Fragment.GhareluNuksheFragment;
import com.example.sheetalkumar.swasthya.R;

public class HomeScreenActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        bottomNavigationView = findViewById(R.id.navigation);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        loadFragment(new DailyTipsFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.near_me:
                        fragment = new DailyTipsFragment();
                        loadFragment(fragment);
                        //                    Toast.makeText(MainActivity.this, "Near Me", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.explore:
                        //                  Toast.makeText(MainActivity.this, "Explore", Toast.LENGTH_LONG).show();
                        fragment = new GhareluNuksheFragment();
                        loadFragment(fragment);
                        return true;

                    case R.id.cart:
                        //              Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_LONG).show();
                        fragment = new CheckMeFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.account:
                        fragment = new FinDiseaseFragment();
                        loadFragment(fragment);
                        //            Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_LONG).show();
                        return true;
                }
                return false;
            }
        });
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

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}

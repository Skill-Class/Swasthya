package com.example.sheetalkumar.swasthya.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.view.View;
import android.widget.Toast;

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

        //Show daily tips as alert

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

            case R.id.action_about:
                // User chose the "Settings" item, show the app settings UI...

                final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                //  alertDialog.setContentView(R.layout.menudialog);
                alertDialog.setTitle("Swasthya");
                alertDialog.setIcon(R.drawable.ic_social_care_green);
                alertDialog.setCancelable(true);
                alertDialog.setMessage("\nToday, Ayurveda is dominated by all over the world, advises the practitioners, doctors, scientists, Ayurveda and yoga of the entire world and follow their miraculous effects.\n" +
                        "Home remedies can be used in various everyday diseases such as fever, colds, headache, physical impairment, obesity, abdominal pain, back pain, joints and knee pain etc and it is instant relief. Think of your health, now you sit at home.\n" +
                        "Through this app, we are trying to reach the domestic Ayurvedic prescriptions to the general public so that all people can take Ayurveda in their life and benefit from it.\n" +
                        "\n\u2022 Prevention is better than cure. Get personal and useful health tips. Simple tips to improve your daily health or lifestyle.\n" +
                        "\n\u2022 Here you can check of any disease after uploading an image of that part of your body which is suffered from the disease and provide details of the corresponding disease to you.\n" +
                        "\n\u2022 What if you already know that this disease is spreading rapidly in your area. Is not it good? Of course it is good so that you can save yourself from suffering or take action accordingly.\n" +
                        "This feature of the application provides the name of the disease that most people suffer and to prevent that illness, an expert will be sent to resolve that common disease.");
                alertDialog.setButton(alertDialog.BUTTON_POSITIVE, "Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.cancel();
                    }
                });
               /* alertDialog.setButton(alertDialog.BUTTON_NEGATIVE, "Not Agree", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ChatActivity.this, "Sorry. we can not allow you to post anything until you do not accept our terms and conditions.!", Toast.LENGTH_LONG).show();
                       // Intent intent = new Intent(ChatActivity.this, MainHomeScreen.class);
                       // startActivity(intent);
                       // finish();
                    }
                });*/

                alertDialog.show();

                return true;

            case R.id.action_logout:
                // User chose the "Settings" item, show the app settings UI...

                return true;

            case R.id.action_help:
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

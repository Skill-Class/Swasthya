package com.example.sheetalkumar.swasthya.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.sheetalkumar.swasthya.Adapter.PagerAdapter;
import com.example.sheetalkumar.swasthya.Adapter.PagerAdapterForBlogPostActivity;
import com.example.sheetalkumar.swasthya.R;

public class BlogPostActivity extends AppCompatActivity {

    private TextView titleText;
    private Toolbar myToolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_post);


        /**
         **
         * Connecting all XML views to java file using findViewById
         */
        AddXMLToJava();


        /**
         * Add TabLayout
         * */
        AddTabLayoutToHomeScreen();
    }

    private void AddTabLayoutToHomeScreen() {

        // Title of tab layout
        tabLayout.addTab(tabLayout.newTab().setText("Feed"));
        tabLayout.addTab(tabLayout.newTab().setText("Community Help"));
        tabLayout.addTab(tabLayout.newTab().setText("Follow"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final PagerAdapterForBlogPostActivity adapter = new PagerAdapterForBlogPostActivity
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void AddXMLToJava() {

        myToolbar = findViewById(R.id.my_toolbar);
        titleText = findViewById(R.id.title_text);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.pager);

        // Adding toolbar to Home screen
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

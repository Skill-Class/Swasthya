package com.example.sheetalkumar.swasthya.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sheetalkumar.swasthya.Adapter.SlideAdapter;
import com.example.sheetalkumar.swasthya.R;



/*
      @Author - Sheetal Kumar
      -------------------------------------
      In App - Splash Activity
      Attached adapter - None
      Objective -  To show splash screen and to to intro screen after particular time.
      Todo - nothing
      Status - complete
      -------------------------------------

*/
    public class IntroActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    public TextView h;
    public TextView e;
    private SlideAdapter sliderAdapter;
    private ImageButton mNextBtn;
    private Button mPreBtn;
    private int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        /*
         **
         * Connecting all XML views to java file using findViewById
         */
        AddXMLToJava();




        sliderAdapter = new SlideAdapter(this);

        viewPager.setAdapter(sliderAdapter);


        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListner);

        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());


        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mCurrentPage == 3) {

                    Intent intent = new Intent(IntroActivity.this, LoginActivity.class);   // sending to the Login Activity
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                    finish();
                }
                viewPager.setCurrentItem(mCurrentPage + 1); // sending back to next page from the current one


                //   Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_top);
                //  viewPager.startAnimation(animation);
                // viewPager.startAnimation(animation);
            }
        });


        mPreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(mCurrentPage - 1);
            }
        });
    }

    private void AddXMLToJava() {

        viewPager = findViewById(R.id.viewPager);
        mDotLayout = findViewById(R.id.dotsLayout);
        mNextBtn = findViewById(R.id.nextBtn);
        mPreBtn = findViewById(R.id.preBtn);


    }

    //page transform starts
    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            TextView desc = view.findViewById(R.id.text2);


            if (position < desc.length()) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right_slide_adapter);
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left_slide_adapter);

                TextView title = view.findViewById(R.id.text1);
                title.startAnimation(animation1);
                desc.startAnimation(animation);


            }

        }
    }


    // page transform ends


    // starting new function to add dots

    public void addDotsIndicator(int j) {

        mDots = new TextView[4];
        mDotLayout.removeAllViews();     // removing multiples dots

        // Adding All Dots on the MainScreen
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(IntroActivity.this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorAccent));

            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[j].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }

    // page Selector

    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage = position;

            if (position == 0) {
                mNextBtn.setEnabled(true);
                mPreBtn.setEnabled(false);
                mPreBtn.setVisibility(View.INVISIBLE);

                // mNextBtn.setText("Next");
                mPreBtn.setText("");


            } else if (position == mDots.length - 1) {
                mNextBtn.setEnabled(true);
                mPreBtn.setEnabled(true);
                mPreBtn.setVisibility(View.VISIBLE);

                //  mNextBtn.setText("Let's Start");
                mPreBtn.setText("Back");

            } else {
                mNextBtn.setEnabled(true);
                mPreBtn.setEnabled(true);
                mPreBtn.setVisibility(View.VISIBLE);

                //mNextBtn.setText("Next");
                mPreBtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}


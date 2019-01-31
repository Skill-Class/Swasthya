package com.example.sheetalkumar.swasthya.Adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sheetalkumar.swasthya.R;


public class SlideAdapter extends PagerAdapter {


    /*
        @Dev - Sheetal Kumar
        Date - 23 Jan 2019
     */

    LayoutInflater layoutInflater;

    Context context;
    public SlideAdapter(Context context) {
        this.context = context;
    }


    //Arrays
    public int[] slide_image = {
            R.drawable.ic_undraw_workout_gcgu,
            R.drawable.ic_undraw_super_thank_you_obwk,
            R.drawable.ic_undraw_getting_coffee_wntr,
    };



    //Animation bottomToUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_top);
    //Animation topToBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_to_bottom);

    public String[] slide_headings = {"Get Your Daily Health Tips", "Basic problems and their solutions", "घरेलू नुस्खे"};

    public String[] slide_desc = {"Travel delhi like never before. Although there are shaded areas in the complex but it is always good to carry sunscreen or sunglasses especially during summer.Travel delhi like never before. Although there are shaded areas in the complex but it is always good to carry sunscreen or sunglasses especially during summer.`",
            "Explore best food outlets of delhi. Although there are shaded areas in the complex but it is always good to carry sunscreen or sunglasses especially during summer.Travel delhi like never before. Although there are shaded areas in the complex but it is always good to carry sunscreen or sunglasses especially during summer.",
            "घरेलू नुस्\u200Dखों (Gharelu Nuskhe) के कोई साइड इफेक्\u200Dट नहीं होते और आप आसानी से इनका प्रयोग कर सकते हैं । सालों से अपनायी जा रही हैं घरेलू नुस्खे / होम रेमेडीज़ (Home Remedies in Hindi) के बारे में जानें। घरेलू नुस्खे / होम रेमेडीज़ का प्रयोग सिर्फ बीमारियों में ही नहीं, बल्कि अच्\u200Dछी सेहत के लिए भी किया जाता है।"};


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (ConstraintLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.slidelayout, container, false);

        ImageView slide_image_view = (ImageView) view.findViewById(R.id.img);
        TextView slideHeading = (TextView) view.findViewById(R.id.text1);
        TextView slideDesc = (TextView) view.findViewById(R.id.text2);


          // Animation animation = AnimationUtils.loadAnimation(context, R.anim.bottom_to_top);
          // slideHeading.startAnimation(animation);
          // slideDesc.startAnimation(animation);

        slide_image_view.setImageResource(slide_image[position]);

        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout) object);

    }

}

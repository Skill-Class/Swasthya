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
        Date - 23 Jan 2018
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
            R.drawable.ic_undraw_workout_gcgu
    };



    //Animation bottomToUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_top);
    //Animation topToBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_to_bottom);

    public String[] slide_headings = {"Home remedies", "Read Health Tips", "Check Me","Find Disease in Your Area"};

    public String[] slide_desc = {"Today, Ayurveda is dominated by all over the world, advises the practitioners, doctors, scientists, Ayurveda and yoga of the entire world and follow their miraculous effects. Home remedies can be used in various everyday diseases such as fever, colds, headache, physical impairment, obesity, abdominal pain, back pain, joints and knee pain etc and it is instant relief. Think of your health, now you sit at home. Through this app, we are trying to reach the domestic Ayurvedic prescriptions to the general public so that all people can take Ayurveda in their life and benefit from it. ",
            "Prevention is better than cure. Get personal & useful health tips. Simple tips to improve your daily health or lifestyle.",
            "Here you can check of any disease after uploading an image of that part of your body which is suffered from the disease and provide details of the corresponding disease to you.",
           " What if you already know that this disease is spreading rapidly in your area. Is not it good? Of course it is good so that you can save yourself from suffering or take action accordingly. This feature of the application provides the name of the disease that most people suffer and to prevent that illness, an expert will be sent to resolve that common disease."};


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

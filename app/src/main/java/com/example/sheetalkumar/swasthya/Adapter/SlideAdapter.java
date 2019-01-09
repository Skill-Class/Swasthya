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

    LayoutInflater layoutInflater;

    Context context;
    public SlideAdapter(Context context) {
        this.context = context;
    }


    //Arrays
    public int[] slide_image = {
            R.drawable.ic_undraw_loading_frh4,
            R.drawable.ic_undraw_smiley_face_lmgm,
            R.drawable.ic_undraw_feeling_blue_4b7q,
    };

    public String[] slide_headings = {"Get Your Daily Health Tips", "Basic problems and their solutions", "Disease In Your Area"};

    public String[] slide_desc = {"Travel delhi like never before. Although there are shaded areas in the complex but it is always good to carry sunscreen or sunglasses especially during summer.Travel delhi like never before. Although there are shaded areas in the complex but it is always good to carry sunscreen or sunglasses especially during summer.`",
            "Explore best food outlets of delhi. Although there are shaded areas in the complex but it is always good to carry sunscreen or sunglasses especially during summer.Travel delhi like never before. Although there are shaded areas in the complex but it is always good to carry sunscreen or sunglasses especially during summer.",
            "Experience 'The Desi Swag' of delhi people. Although there are shaded areas in the complex but it is always good to carry sunscreen or sunglasses especially during summer.Travel delhi like never before. Although there are shaded areas in the complex but it is always good to carry sunscreen or sunglasses especially during summer."};


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

       // Animation animation = AnimationUtils.loadAnimation(context, R.anim.bottomtoup);
        //slideHeading.startAnimation(animation);
        //slideDesc.startAnimation(animation);

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

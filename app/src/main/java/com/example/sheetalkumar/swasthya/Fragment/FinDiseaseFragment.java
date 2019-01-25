package com.example.sheetalkumar.swasthya.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sheetalkumar.swasthya.R;
public class FinDiseaseFragment extends Fragment {


    /*
        @Dev - Sheetal Kumar
        Date - 23 Jan 2019
     */

    private LottieAnimationView lottieAnimationView;
    private TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  getImages();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fin_disease, container, false);

        lottieAnimationView = rootView.findViewById(R.id.intro_lottie_animation_view);
        //lottieAnimationView.playAnimation();
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.bottom_to_top);
        textView = rootView.findViewById(R.id.textView11);
        textView.startAnimation(animation);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        lottieAnimationView.playAnimation();
    }
}

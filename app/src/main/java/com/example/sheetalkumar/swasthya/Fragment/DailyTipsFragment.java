package com.example.sheetalkumar.swasthya.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sheetalkumar.swasthya.Adapter.OffterAdapter;
import com.example.sheetalkumar.swasthya.R;

import java.util.ArrayList;

public class DailyTipsFragment extends Fragment {

    private ArrayList<Integer> OfferImages = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

          getImages();
    }

    private void getImages() {
            OfferImages.add(R.drawable.pple);
        OfferImages.add(R.drawable.ppleone);
        OfferImages.add(R.drawable.ppletwo);
        OfferImages.add(R.drawable.pple);
        OfferImages.add(R.drawable.ppleone);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_daily_tips, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        RecyclerView offterRecyclerView = rootView.findViewById(R.id.recyclerView);
        offterRecyclerView.setLayoutManager(layoutManager);
        OffterAdapter adapter = new OffterAdapter(getContext(), OfferImages);
        offterRecyclerView.setAdapter(adapter);

        return rootView;
    }
}



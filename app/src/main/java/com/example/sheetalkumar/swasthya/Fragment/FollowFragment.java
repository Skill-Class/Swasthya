package com.example.sheetalkumar.swasthya.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.sheetalkumar.swasthya.Adapter.AdapterForFollowFragment;
import com.example.sheetalkumar.swasthya.Adapter.RecyclerViewAdapterForUpcomingProducts;
import com.example.sheetalkumar.swasthya.Model.ItemsWithImage;
import com.example.sheetalkumar.swasthya.R;

import java.util.ArrayList;
import java.util.List;


/**
 * This sectio contain the follow screen data set
 * In this screen user can follow the particular topic  and particular person

 */
public class FollowFragment extends Fragment {

    private RecyclerView myRecycleView;
    private List<ItemsWithImage> itemsDetails;
    private EditText searchInput;
    private CharSequence search = "";

    AdapterForFollowFragment myAdaper;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemsDetails = new ArrayList<>();
        getImages();
    }


    private void getImages() {


        /*
            here
            Company Name = person name
            item type = Status
            prize = null
            fav = null
         */

        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Sheetal Kumar", "Busy",
                "Follow", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Anjali Bansal", "Available",
                "Following", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Vineeta ", "\uD83D\uDC99",
                "Following", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Krishna", "At work",
                "Follow", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Jaideep", "Hello World.",
                "Following", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Mohit", "Keeping it Lowkey.!",
                "Follow", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Mohit Arora", "Busy",
                "Following", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Ashita Diwan", "Available",
                "Following", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Satyam Santosh", ".",
                "Following", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Meghna", ".",
                "Follow", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Mridula", "To the Stars..",
                "Follow", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Swati ", "More life, more everything",
                "Following", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Sakeena", "Hello..",
                "Follow", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Surbhi", "Nobody stays. Nobody matters.",
                "Following", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Sulekha", "\uD83E\uDD2D",
                "Follow", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "Bhawna", "Busy",
                "Follow", false));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_follow, container, false);

        myRecycleView = rootView.findViewById(R.id.recyclerView);
        searchInput = rootView.findViewById(R.id.search_input);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
         AdapterForFollowFragment myAdapter = new AdapterForFollowFragment(getActivity(), itemsDetails);


        myRecycleView.setAdapter(myAdapter);
        myRecycleView.setLayoutManager(layoutManager);


        return rootView;

    }



}

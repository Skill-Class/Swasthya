package com.example.sheetalkumar.swasthya.Fragment;


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

import com.example.sheetalkumar.swasthya.Adapter.RecyclerViewAdapterForUpcomingProducts;
import com.example.sheetalkumar.swasthya.Model.ItemsWithImage;
import com.example.sheetalkumar.swasthya.R;

import java.util.ArrayList;
import java.util.List;


public class BlogPostFragment extends Fragment {


    private RecyclerView myRecycleView;
    private List<ItemsWithImage> itemsDetails;
   // private RecyclerViewAdapterForUpcomingProducts recyclerViewAdapterForUpcomingProducts;
    private EditText searchInput;
    private CharSequence search = "";

    RecyclerViewAdapterForUpcomingProducts myAdaper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemsDetails = new ArrayList<>();
        getImages();




    }


    private void getImages() {



        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "WROGN", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "33 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "MODA RAPIDO", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "32 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "ETHER", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "13 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "DIFFERENCE OF OPINION", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "23 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "HIGHLANDER", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "31 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "WROGN", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "30 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "ETHER", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "13 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "DIVINE CASA", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "14 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "WROGN", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "33 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "MODA RAPIDO", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "32 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "ETHER", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "13 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "DIFFERENCE OF OPINION", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "23 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "HIGHLANDER", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "31 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "WROGN", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "30 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "ETHER", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "13 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.backgroundimg, "DIVINE CASA", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "14 Days To Go!", false));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_blog_post, container, false);

        myRecycleView = rootView.findViewById(R.id.recyclerView);
        searchInput = rootView.findViewById(R.id.search_input);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
       final RecyclerViewAdapterForUpcomingProducts myAdapter = new RecyclerViewAdapterForUpcomingProducts(getActivity(), itemsDetails);


        if (!search.toString().isEmpty()){

            myAdapter.getFilter().filter(search);

        }
        myRecycleView.setAdapter(myAdapter);

        myRecycleView.setLayoutManager(layoutManager);

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                myAdapter.getFilter().filter(s);
                search = s;


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        return rootView;
    }



}

package com.example.sheetalkumar.swasthya.Fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sheetalkumar.swasthya.Activity.DetailsActivity;
import com.example.sheetalkumar.swasthya.Adapter.ItemAdapter;
import com.example.sheetalkumar.swasthya.Adapter.OffterAdapter;
import com.example.sheetalkumar.swasthya.R;


import java.util.ArrayList;

public class DailyTipsFragment extends Fragment {


    /*
        @Dev - Sheetal Kumar
        Date - 23 Jan 2019
     */
    private ArrayList<Integer> OfferImages = new ArrayList<>();
    private ArrayList<Integer> itemImages = new ArrayList<>();
    private ArrayList<String> itemName = new ArrayList<>();

    private ArrayList<Integer> mDesc = new ArrayList<>();
    private ArrayList<Integer> mTitle = new ArrayList<>();
    private ArrayList<Integer> mHeading = new ArrayList<>();

    private ProgressDialog progressDialog;

   // private TextSwitcher textSwitcher;
   // int flag = 1;
    private TextView textViewone;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getImages();

    }

    private void getImages() {
        OfferImages.add(R.drawable.pple);
        OfferImages.add(R.drawable.ppleone);
        OfferImages.add(R.drawable.ppletwo);
        OfferImages.add(R.drawable.pletwo);
        OfferImages.add(R.drawable.pplethree);
        OfferImages.add(R.drawable.pplefour);
        OfferImages.add(R.drawable.pplefive);


        itemImages.add(R.drawable.ple); //1
        itemImages.add(R.drawable.pleone); //2
        itemImages.add(R.drawable.plethree); //3
        itemImages.add(R.drawable.plefour);
        itemImages.add(R.drawable.plefive);
        itemImages.add(R.drawable.plesix);
        itemImages.add(R.drawable.pleseven);  //7


        itemName.add("5 टिप्स सेहत के लिए"); //1
        itemName.add("स्वस्थ रहने की 10 अच्छी आदतें ");
        itemName.add("सुपर फूड्स");
        itemName.add("लम्\u200Dबा होना है? तो करिए ये योगासन");
        itemName.add("स्वस्थ रहने के नौ टिप्स");
        itemName.add("स्वस्थ रहने के 20 सूत्र");
        itemName.add("फिट रहना है तो अपनाएं ये छोटे-छोट टिप्\u200Dस");

        mDesc.add(R.string.desc_a);
        mDesc.add(R.string.desc_b);
        mDesc.add(R.string.desc_c);
        mDesc.add(R.string.desc_d);
        mDesc.add(R.string.desc_e);
        mDesc.add(R.string.desc_f);
        mDesc.add(R.string.desc_g);


        mTitle.add(R.string.title_a);
        mTitle.add(R.string.title_b);
        mTitle.add(R.string.title_c);
        mTitle.add(R.string.title_d);
        mTitle.add(R.string.title_e);
        mTitle.add(R.string.title_f);
        mTitle.add(R.string.title_g);


        mHeading.add(R.string.heading_a);
        mHeading.add(R.string.heading_a);
        mHeading.add(R.string.heading_c);
        mHeading.add(R.string.heading_d);
        mHeading.add(R.string.heading_a);
        mHeading.add(R.string.heading_f);
        mHeading.add(R.string.heading_a);


    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_daily_tips, container, false);


        textViewone = rootView.findViewById(R.id.textView5);

        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.right_to_left);
        Animation animation1 = AnimationUtils.loadAnimation(getActivity(),R.anim.left_to_right);

        textViewone.startAnimation(animation);

        progressDialog = new ProgressDialog(getActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        RecyclerView offterRecyclerView = rootView.findViewById(R.id.recyclerView);
        offterRecyclerView.setLayoutManager(layoutManager);
        OffterAdapter adapter = new OffterAdapter(getContext(), OfferImages);
        offterRecyclerView.setAdapter(adapter);

        offterRecyclerView.startAnimation(animation);

      //  int resId = R.anim.layout_animation_fall_down;
       // LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getActivity(), resId);
       // offterRecyclerView.setLayoutAnimation(animation);



        LinearLayoutManager layoutManagerForItems = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerView itemRecyclerView = rootView.findViewById(R.id.items_recyclerView);
        itemRecyclerView.setLayoutManager(layoutManagerForItems);
        ItemAdapter adapterforItem = new ItemAdapter(getContext(), itemImages, itemName);
        itemRecyclerView.setAdapter(adapterforItem);
        itemRecyclerView.startAnimation(animation1);


        offterRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                offterRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                Toast.makeText(getActivity(), "Showing Position  (Single Press) : " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity(), "Showing Position  (Long Press) : " + position,
                        Toast.LENGTH_SHORT).show();
            }
        }));

        itemRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                itemRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
              //  Toast.makeText(getActivity(), "Showing Position  (Single Press) : " + position,
                //        Toast.LENGTH_SHORT).show();

                progressDialog.setIcon(R.drawable.ic_social_care_green);
                progressDialog.setTitle("Loading");
                progressDialog.setMessage("Please wait for a moment..");
                progressDialog.show();

                Intent intent = new Intent(getActivity(), DetailsActivity.class);


                //Sending Data from a fragment to an activity (DailyTipsFragment -> DetailsActivity)

                intent.putExtra("Title", mTitle.get(position));
                intent.putExtra("Desc", mDesc.get(position));
                intent.putExtra("Heading", mHeading.get(position));

                startActivity(intent);


                // startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity(), "Showing Position  (Long Press) : " + position,
                        Toast.LENGTH_SHORT).show();
            }
        }));

        return rootView;
    }

    private void addRecyclerTouchListner(RecyclerView recyclerView) {

    }


    //RECYCLER VIEW ONCLICK METHOND STARTS
    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private DailyTipsFragment.ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView,
                                     final DailyTipsFragment.ClickListener clicklistener) {

            this.clicklistener = clicklistener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clicklistener != null) {
                        clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clicklistener != null && gestureDetector.onTouchEvent(e)) {
                clicklistener.onClick(child, rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}



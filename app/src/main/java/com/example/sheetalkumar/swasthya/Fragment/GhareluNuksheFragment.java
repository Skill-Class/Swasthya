package com.example.sheetalkumar.swasthya.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.Toast;

import com.example.sheetalkumar.swasthya.Activity.DetailsActivity;
import com.example.sheetalkumar.swasthya.Activity.DetailsGNActivity;
import com.example.sheetalkumar.swasthya.Activity.TinytipsDetialsActivity;
import com.example.sheetalkumar.swasthya.Adapter.GhareluAdapter;
import com.example.sheetalkumar.swasthya.Adapter.OffterAdapter;
import com.example.sheetalkumar.swasthya.R;

import java.util.ArrayList;

public class GhareluNuksheFragment extends Fragment {


    /*
        @Dev - Sheetal Kumar
        Date - 31 march 2019
     */
    private ArrayList<Integer> itemImages = new ArrayList<>();
    private ArrayList<Integer> itemName = new ArrayList<>();

    private ArrayList<Integer> itemDes = new ArrayList<>();

    private ProgressDialog progressDialog;

    public String sheetal ="Hello world";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


         // getting image database
         getImages();
    }


    // this function is adding data to the array list

    private void getImages() {


        itemImages.add(R.drawable.ple); //1
        itemImages.add(R.drawable.pleone); //2
        itemImages.add(R.drawable.plethree); //3
        itemImages.add(R.drawable.plefour);
        itemImages.add(R.drawable.plefive);
        itemImages.add(R.drawable.plesix);
        itemImages.add(R.drawable.pleseven);  //7

        itemName.add(R.string.gn_a); //1
        itemName.add(R.string.gn_b);
        itemName.add(R.string.gn_c);
        itemName.add(R.string.gn_d);
        itemName.add(R.string.gn_e);
        itemName.add(R.string.gn_f);
        itemName.add(R.string.gn_g);
        itemName.add(R.string.gn_h); //1
        itemName.add(R.string.gn_i);
        itemName.add(R.string.gn_j);

        itemDes.add(R.string.desc_a);
        itemDes.add(R.string.desc_b);
        itemDes.add(R.string.desc_c);
        itemDes.add(R.string.desc_d);
        itemDes.add(R.string.desc_e);
        itemDes.add(R.string.desc_f);
        itemDes.add(R.string.desc_g);
        itemDes.add(R.string.desc_a);
        itemDes.add(R.string.desc_a);
        itemDes.add(R.string.desc_a);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gharelu_nukshe, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);


        Animation animation1 = AnimationUtils.loadAnimation(getActivity(),R.anim.left_to_right);

        RecyclerView offterRecyclerView = rootView.findViewById(R.id.recyclerView);
        offterRecyclerView.setLayoutManager(layoutManager);

        // defining the progress bar
        progressDialog = new ProgressDialog(getActivity());




        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), resId);
        offterRecyclerView.setLayoutAnimation(animation);



        GhareluAdapter adapter = new GhareluAdapter(getContext(), itemName);
        offterRecyclerView.setAdapter(adapter);
       // offterRecyclerView.startAnimation(animation1);


        // adding the on click listner to the recycler view
        offterRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                offterRecyclerView, new ClickListener() {

            @Override
            public void onClick(View view, final int position) {
               // Toast.makeText(getActivity(), "Showing Position  (Single Press) : " + position,
                 //       Toast.LENGTH_SHORT).show();

                progressDialog.setIcon(R.drawable.ic_social_care_green);
                progressDialog.setTitle("Loading");
                progressDialog.setMessage("Please wait for a moment..");
                progressDialog.show();



                Intent intent = new Intent(getActivity(), TinytipsDetialsActivity.class);

                //Sending Data from a fragment to an activity (DailyTipsFragment -> DetailsActivity)

                 intent.putExtra("Title", itemName.get(position));
                 intent.putExtra("Desc",itemDes.get(position));
                //intent.putExtra("Desc", mDesc.get(position));
                //intent.putExtra("Heading", mHeading.get(position));

                startActivity(intent);
            }

                // startActivity(intent);


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

        private GhareluNuksheFragment.ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView,
                                     final GhareluNuksheFragment.ClickListener clicklistener) {

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


package com.example.sheetalkumar.swasthya.Fragment;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sheetalkumar.swasthya.Activity.DetailsActivity;
import com.example.sheetalkumar.swasthya.Adapter.ItemAdapter;
import com.example.sheetalkumar.swasthya.Adapter.OffterAdapter;
import com.example.sheetalkumar.swasthya.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


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
    private ImageView imageView;
    public String value=" ";

    private static final int NOTIFICATION_ID = 1;

    private NotificationManager mNotificationManager;

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

        progressDialog = new ProgressDialog(getActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        RecyclerView offterRecyclerView = rootView.findViewById(R.id.recyclerView);
        imageView = rootView.findViewById(R.id.imageView2);

        offterRecyclerView.setLayoutManager(layoutManager);

        OffterAdapter adapter = new OffterAdapter(getActivity(), OfferImages);


        offterRecyclerView.setAdapter(adapter);




        /* FIREBASE NOTIFICATION */



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Daily Notification");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                final String value = dataSnapshot.getValue(String.class);
                showNotification("Team Swasthya",value);
                //
                //  final String notidata =returndata(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        //  FirebaseApp.initializeApp(getContext());




        LinearLayoutManager layoutManagerForItems = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerView itemRecyclerView = rootView.findViewById(R.id.items_recyclerView);

        itemRecyclerView.setLayoutManager(layoutManagerForItems);
        ItemAdapter adapterforItem = new ItemAdapter(getActivity(), itemImages, itemName);

        itemRecyclerView.setAdapter(adapterforItem);
      //  itemRecyclerView.startAnimation(animation1);

        // push notification | check API Level - Integer.valueOf(android.os.Build.VERSION.SDK)

      /*  imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "Hello ", Toast.LENGTH_LONG).show();

                // Read notification from the firebase  database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");


                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        final String value = dataSnapshot.getValue(String.class);
                        showNotification("Team Swasthya",value);
                       //
                     //  final String notidata =returndata(value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        // Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

                //Toast.makeText(getActivity(),notidata,Toast.LENGTH_LONG).show();

               // showNotification("Swasthya", "hihi");


            }
        });
        */

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

    private String returndata(String value) {
        //Toast.makeText(getActivity(),value,Toast.LENGTH_LONG).show();
        return String.valueOf(value);
        //showNotification("hi",value);
    }


    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is new and not in the support library
    void showNotification(String title, String content) {
        NotificationManager mNotificationManager =
                (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default",
                    "YOUR_CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DISCRIPTION");
            mNotificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getActivity(), "default")
                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle(title) // title for notification
                .setContentText(content)// message for notification
                .setColor(getResources().getColor(R.color.colorPrimaryDark))
                // .setSound(alarmSound) // set alarm sound for notification
                .setStyle(new NotificationCompat.BigTextStyle()) // full text of notification
                .setAutoCancel(true); // clear notification after click

        // Intent intent = new Intent(getContext(), _.class);
        //PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //mBuilder.setContentIntent(pi);

        mNotificationManager.notify(0, mBuilder.build());

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



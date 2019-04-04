package com.example.sheetalkumar.swasthya.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import com.example.sheetalkumar.swasthya.Model.JsonPlaceHolderAPI;
import com.example.sheetalkumar.swasthya.Model.Post;
import com.example.sheetalkumar.swasthya.Model.places;
import com.example.sheetalkumar.swasthya.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FinDiseaseFragment extends Fragment {


    /*
        @Dev - Sheetal Kumar
        Date - 30 March 2019
     */

    /**
     * In this activity user can  check that what kind of fever is highly active in particular area
     * he/she can see a proper cart for that particular area and update details.
     */

    private LottieAnimationView lottieAnimationView;
    private TextView locationText;
    private Button locationButton;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private ProgressDialog progressDialog;
    private TextView texttwo,textone;
    private String[] parts;

    private DatabaseReference databaseReference;
    private FirebaseDatabase mdatabase;
    public String mydata = "";
    public String jsondata = "";

    private List<String> percentageofFever = new ArrayList<>();
    private List<String> feverName = new ArrayList<>();


    private PieChart pieChart;
    private PieDataSet dataSet;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  ArrayList feverName = new ArrayList();
        feverName.add("Dengue");
        feverName.add("Normal Fever");
        feverName.add("Maleriya");





        //  ArrayList percentageOfFever = new ArrayList();

        //  getImages();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fin_disease, container, false);


        textone = rootView.findViewById(R.id.textView);
        texttwo = rootView.findViewById(R.id.textview2);

        textone.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_scale_animation));
       texttwo.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.zoom_enter));



        // lottieAnimationView = rootView.findViewById(R.id.intro_lottie_animation_view);
        //lottieAnimationView.playAnimation();
        // Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.bottom_to_top);
        // textView = rootView.findViewById(R.id.textView11);
        //textView.startAnimation(animation);

        //fetching current location of user

       // locationText = rootView.findViewById(R.id.locationText);
       // locationButton = rootView.findViewById(R.id.getLocationBtn);
       // texttwo = rootView.findViewById(R.id.textView11);
        pieChart = rootView.findViewById(R.id.piechart);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setIcon(R.drawable.ic_social_care_green);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Fetching your current location.");
        progressDialog.show();

        setPieChart();

        pieChart.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_scale_animation));
        progressDialog.dismiss();
//        locationButton.setVisibility(View.GONE);




        if (ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(),
                        android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }

      /*  locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setIcon(R.drawable.ic_social_care_green);
                progressDialog.setTitle("Loading");
                progressDialog.setMessage("Please wait for a moment..");
                progressDialog.show();

                // fetching the current location
                getLocation();


            }
        });*/

       /* Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);

        Call<List<Post>> call = jsonPlaceHolderAPI.getPosts();


        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                // Checking if response is null or not. server may cause 404 error.
                if (!response.isSuccessful()) {
                    // textResult.setText("Code : " + response.code());
                    return;
                }

                List<Post> posts = response.body();


                // getting all the post with id, userid, title and text.
                for (Post post : posts) {

                    String content = "";

                    content += "ID:" + post.getId() + "\n";
                    content += "UserId:" + post.getUserId() + "\n";
                    content += "Title" + post.getTitle() + "\n";
                    content += "Text : " + post.getText() + "\n\n";

                    // using append  so that it does not override value.
                    // textResult.append(content);
                }

                // getting only title and showing into listView
                String[] titile_text = new String[posts.size()];

                for (int i = 0; i < posts.size(); i++) {
                    titile_text[i] = posts.get(i).getTitle();
                }

                //Toast.makeText(getActivity(),posts.get(0).getTitle(),Toast.LENGTH_LONG).show();
                // Toast.makeText(getActivity(),mydata,Toast.LENGTH_LONG).show();

                jsondata = posts.get(0).getTitle();

                //displaying the string array into listview
                // listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, titile_text));

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                //textResult.setText(t.getMessage());

            }
        });

        return rootView;
    }

    private void setPieChart() {
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(true);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.9f);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.setHoleColor(Color.WHITE);

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(34f,"Dengue"));
        yValues.add(new PieEntry(56f,"Normal Fever"));
        yValues.add(new PieEntry(66f,"Maleriya"));

        PieDataSet dataSet = new PieDataSet(yValues, "Desease Per Regions");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData((dataSet));
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(Color.YELLOW);
        pieChart.setData(pieData);
    }


    private void getLocation() {

        final String[] parts;

        try {
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {

                    //if location is fetched making dialog invisible. and button disable.
                    progressDialog.dismiss();
                    locationButton.setEnabled(false);

                    // showing latitude and longitude
                  //  locationText.setText("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());

                    try {

                        //printing address in text

                        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                        //    locationText.setText(locationText.getText() + "\n\nYour Current location is - " + "\n" + addresses.get(0).getAddressLine(0) + ", " +
                      //          addresses.get(0).getAddressLine(1) + ", " + addresses.get(0).getAddressLine(2));

                        String finalLocation = addresses.get(0).getAddressLine(0);

                        //calling pie chart function


                        if (finalLocation.contains(",")) {
                            // Split it.
                            //parts[2] = "";
                            final String[] parts = finalLocation.split(",");
                            mydata = parts[2];
                            // Toast.makeText(getActivity(), parts[2], Toast.LENGTH_LONG).show();
                            // currentLocation(parts[2]);
                        } else {
                            throw new IllegalArgumentException("String " + finalLocation + " does not contain ,");
                        }


                    } catch (Exception e) {
                    }
                    // not working here.
                    reatTimeData(mydata);
                    // Toast.makeText(getActivity(),mydata,Toast.LENGTH_LONG).show();
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {
                    progressDialog.dismiss();
                    Toast.makeText(getActivity(), "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };

            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, locationListener);

        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }


    private void reatTimeData(String mydata) {

        // String currentData =

        //  FirebaseApp.initializeApp(getContext());
        Toast.makeText(getActivity(), mydata + "\n" + jsondata, Toast.LENGTH_LONG).show();
          //  String data1 = jsondata;

/*        if(mydata.equals(jsondata))
        {
            Toast.makeText(getActivity(), "success", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getActivity(), "fail", Toast.LENGTH_LONG).show();
        }
*/

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Places").child("malka ganj");
        // Toast.makeText(getActivity(),mydata,Toast.LENGTH_LONG).show();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                places data = dataSnapshot.getValue(places.class);
                String data1 = data.getDengue();
                String data2 = data.getMaleriya();
                String data3 = data.getFever();

                // String currentlocation = currentLocation();
                // String value = dataSnapshot.getValue(String.class);

                percentageofFever.add(data1);
                percentageofFever.add(data2);
                percentageofFever.add(data3);

//                texttwo.setText("\n Location : Malka Ganj\n\n" + "Maleriya - " + data1 + "%" + "\n" + "Dengue - " + data2 + "%" + "\n" + "Fever - " + data3 + "%" + "\n");
                // Toast.makeText(getActivity(),mydata,Toast.LENGTH_LONG).show();

                // adding dataset into pie chart
                addchat(percentageofFever);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void addchat(List<String> percentageofFever) {

    }


    // for playing lottie animation in fragment
   /* @Override
    public void onStart() {
        super.onStart();
        lottieAnimationView.playAnimation();
    }*/
}

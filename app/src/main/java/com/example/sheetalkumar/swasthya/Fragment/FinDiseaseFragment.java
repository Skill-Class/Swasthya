package com.example.sheetalkumar.swasthya.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sheetalkumar.swasthya.R;

import java.util.List;
import java.util.Locale;

public class FinDiseaseFragment extends Fragment {


    /*
        @Dev - Sheetal Kumar
        Date - 23 Jan 2019
     */

    private LottieAnimationView lottieAnimationView;
    private TextView locationText;
    private Button locationButton;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private ProgressDialog progressDialog;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  getImages();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fin_disease, container, false);

        // lottieAnimationView = rootView.findViewById(R.id.intro_lottie_animation_view);
        //lottieAnimationView.playAnimation();
        // Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.bottom_to_top);
        // textView = rootView.findViewById(R.id.textView11);
        //textView.startAnimation(animation);

        //fetching current location of user

        locationText = rootView.findViewById(R.id.locationText);
        locationButton = rootView.findViewById(R.id.getLocationBtn);

        progressDialog = new ProgressDialog(getActivity());


        if (ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(),
                        android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setIcon(R.drawable.ic_social_care_green);
                progressDialog.setTitle("Loading");
                progressDialog.setMessage("Please wait for a moment..");
                progressDialog.show();

                // fetching the current location
                getLocation();
            }
        });


        return rootView;
    }

    private void getLocation() {
        try {
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {

                    //if location is fetched making dialog invisible. and button disable.
                    progressDialog.dismiss();
                    locationButton.setEnabled(false);

                    // showing latitude and longitude
                    locationText.setText("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());

                    try {

                        //printing address in text

                        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        locationText.setText(locationText.getText() + "\n\nYour Current location is - " + "\n" + addresses.get(0).getAddressLine(0) + ", " +
                                addresses.get(0).getAddressLine(1) + ", " + addresses.get(0).getAddressLine(2));

                        String finalLocation = addresses.get(0).getAddressLine(0);
                        //    Toast.makeText(getActivity(), finalLocation, Toast.LENGTH_SHORT).show();

                        if (finalLocation.contains(",")) {
                            // Split it.
                            String[] parts = finalLocation.split(",");
                            Toast.makeText(getActivity(), parts[2], Toast.LENGTH_LONG).show();


                        } else {
                            throw new IllegalArgumentException("String " + finalLocation + " does not contain ,");
                        }

                    } catch (Exception e) {

                    }
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

    // for playing lottie animation in fragment
   /* @Override
    public void onStart() {
        super.onStart();
        lottieAnimationView.playAnimation();
    }*/
}

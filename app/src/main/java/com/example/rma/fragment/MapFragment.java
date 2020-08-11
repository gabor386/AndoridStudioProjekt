package com.example.rma.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rma.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Locale;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Intent intent;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_map_fragment);
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_map_fragment, null, false);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        return view;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        String v= getArguments().getString("mapa");
        System.out.println("OOOOOOOOOOOOOOOOOOOOVDEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"+v);

//        intent=getIntent();
//        String map=intent.getStringExtra("map");
//        System.out.println("MAPAAAAAA "+map);
//        String contry=intent.getStringExtra("contry");
//        System.out.println("CONTRYYYYY  "+contry);
//
//
//
        Geocoder coder = new Geocoder(getActivity());
        List<Address> address;
        LatLng p1=new LatLng(0,0);
        if(v!=null) {
            try {
        // May throw an IOException
        address = coder.getFromLocationName(v, 1);
        if (address == null) {
            System.out.println("GRESKAAAAAAAAAAAA");
        }
        if (!address.isEmpty()) {
            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude());
            System.out.println("OVDEEEEEEEE " + p1);
        }

             } catch (IOException ex) {

        ex.printStackTrace();
         }
        }

        mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );
        mMap.setPadding(0, 000, 0, 1000);
        mMap.addMarker(new MarkerOptions().position(p1).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(p1));
    }



}
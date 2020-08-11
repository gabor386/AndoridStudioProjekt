package com.example.rma.fragment;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.rma.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.GeocodingApi;

import java.io.IOException;
import java.util.List;

public class MapClass extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_fragment);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
    }


//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_map_fragment, null, false);
//
//        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//
//
//        return view;
//    }

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
        LatLng sydney = new LatLng(-34, 151);

//        String v= getArguments().getString("mapa");
//        System.out.println("OOOOOOOOOOOOOOOOOOOOVDEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"+v);

        intent=getIntent();
        String map=intent.getStringExtra("map");
        System.out.println("MAPAAAAAA "+map);
        String contry=intent.getStringExtra("contry");
        System.out.println("CONTRYYYYY  "+contry);
//
//
//


        Geocoder coder = new Geocoder(getApplicationContext());
        List<Address> address;
        LatLng p1=new LatLng(0,0);

        if(map!=null) {
            try {
                // May throw an IOException
                address = coder.getFromLocationName(map, 1);
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
//        mMap.setPadding(0, 000, 0, 1000);
        mMap.addMarker(new MarkerOptions().position(p1).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(p1));
    }
//    public void reloadMap(String s){
//        SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
//        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(GoogleMap googleMap) {
//                mMap = googleMap;
//                Geocoder coder = new Geocoder(getApplicationContext());
//                List<Address> address;
//                LatLng p1=new LatLng(0,0);
//
//                try {
//                    // May throw an IOException
//                    address = coder.getFromLocationName(s, 1);
//                    if (address == null) {
//                        System.out.println("GRESKAAAAAAAAAAAA");
//                    }
//                    if(!address.isEmpty()) {
//                        Address location = address.get(0);
//                        p1 = new LatLng(location.getLatitude(), location.getLongitude());
//                        System.out.println("OVDEEEEEEEE " + p1);
//                    }
//
//                } catch (IOException ex) {
//
//                    ex.printStackTrace();
//                }
//
//                mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );
//
//                mMap.addMarker(new MarkerOptions().position(p1).title("Marker in Sydney"));
//                mMap.moveCamera(CameraUpdateFactory.newLatLng(p1));
//
//            }
//        });
//    }


}
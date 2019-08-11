package com.lavish.smartbin;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        LatLng tialknagarmain = new LatLng(22.719626, 75.897621);
        mMap.addMarker(new MarkerOptions().position(tialknagarmain).title("SmartBin in Tialknagar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tialknagarmain, 10f));
        LatLng saketsquare = new LatLng(22.725570, 75.894660);
        mMap.addMarker(new MarkerOptions().position(saketsquare).title("SmartBin in Saket Square"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(saketsquare, 10f));
        LatLng Vijaynagar = new LatLng(22.744365, 75.894323);
        mMap.addMarker(new MarkerOptions().position(Vijaynagar).title("SmartBin in Vijay Nagar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Vijaynagar, 10f));
        LatLng medicaps = new LatLng(22.621051, 75.805532);
        mMap.addMarker(new MarkerOptions().position(medicaps).title("SmartBin in MEDICAPS"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(medicaps, 10f));
        LatLng rajivgandhi = new LatLng(22.683130, 75.857234);
        mMap.addMarker(new MarkerOptions().position(rajivgandhi).title("SmartBin in RAJIVGANDHI SQUARE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rajivgandhi, 10f));
        LatLng rao = new LatLng( 22.637476,75.811248);
        mMap.addMarker(new MarkerOptions().position(rao).title("SmartBin in RAO"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rao,10f));


    }
}

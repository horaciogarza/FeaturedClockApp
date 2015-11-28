package com.example.hgx95.hci_project;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class worldClockMap extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private City[] cities = new City[50];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_clock_map);
        cities[0] = new City("Europe/Athens", "Atenas", 37.984593, 23.730784);
        cities[1] = new City("Europe/Belfast", "Belfast", 54.603152, -5.928701);
        cities[2] = new City("Asia/Taipei","Taipei", 25.033141, 121.564006);
        cities[3] = new City("America/New_York", "New York", 40.710261, -74.000323);
        cities[4] = new City("Europe/Madrid", "Barcelona", 41.385536, 2.170082);
        cities[5] = new City("Europe/Paris", "Paris", 48.856579, 2.354765);
        cities[6] = new City("America/Cancun", "Cancun", 21.161137, -86.852190);
        cities[7] = new City("Europe/Madrid", "Madrid", 40.416439, -3.696026);
        cities[8] = new City("Asia/Dubai", "Dubai",	25.202890, 55.260011);
        cities[9] = new City("Europe/Amsterdam", "Amsterdam", 52.367087, 4.884187);
        cities[10] = new City("Australia/Sydney", "Sydney",-33.868474, 151.230011);
        cities[11] = new City("Africa/Cairo", "El Cairo",	30.036226, 31.247581);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        for (int i= 0 ; i < 12 ; i++){
            mMap.addMarker(new MarkerOptions().position(new LatLng(cities[i].getCoordx(), cities[i].getCoordy())).title(cities[i].getTimeZone()));
        }


    }
}

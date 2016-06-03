package com.quintas.guiadointercambista;

/**
 * Created by Quintas on 6/3/2016.
 */

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class PageMapFragment extends SupportMapFragment implements
        OnMapReadyCallback {
    private boolean needsInit=false;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState == null) {
            needsInit=true;
        }

        getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        if (needsInit) {
            CameraUpdate center=
                    CameraUpdateFactory.newLatLngZoom(new LatLng(52.3702,
                            4.8952), 10);

            map.animateCamera(center);
        }

        Marker marker = map.addMarker(new MarkerOptions()
                            .position(new LatLng(52.3702, 4.8952))
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.amanda_map))
                            .title(getResources().getString(R.string.amanda)));

        Marker marker2 = map.addMarker(new MarkerOptions()
                .position(new LatLng(52.3427359,4.9675097))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcos_map))
                .title(getResources().getString(R.string.marcos)));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(52.3590194,4.9063433))
                .title(getResources().getString(R.string.you)));

    }

    private void addMarker(GoogleMap map, double lat, double lon,
                           int title, int snippet) {
        map.addMarker(new MarkerOptions().position(new LatLng(lat, lon))
                .title(getString(title))
                .snippet(getString(snippet)));
    }
}
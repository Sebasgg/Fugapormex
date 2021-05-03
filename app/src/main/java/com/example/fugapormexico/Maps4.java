package com.example.fugapormexico;



import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps4 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        int stats = GooglePlayServicesUtil.isGooglePlayServicesAvailable( getApplicationContext() );
        if (stats== ConnectionResult.SUCCESS) {


            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById( R.id.map );
            mapFragment.getMapAsync( this );
        }else {
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog( stats,(Activity)getBaseContext(),10 );
            dialog.show();



        }
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
        mMap.setMapType( googleMap.MAP_TYPE_HYBRID );
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng( -34, 151 );
        mMap.addMarker( new MarkerOptions().position( sydney ).title( "Bar Sin Nombre" ) );
        mMap.moveCamera( CameraUpdateFactory.newLatLng( sydney ) );
    }
}

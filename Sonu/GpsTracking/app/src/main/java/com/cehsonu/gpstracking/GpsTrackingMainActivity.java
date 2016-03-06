package com.cehsonu.gpstracking;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class GpsTrackingMainActivity extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_tracking_main);
        locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,2000,1,this);
    }

    public void onLocationChanged(Location location)
    {
        String msg="Latitude = "+location.getLatitude()+"Longitude = "+location.getLongitude();
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }

    public void onProviderDisabled(String provider)
    {
        //
    }
    public void onStatusChanged(String provider,int status,Bundle extras)
    {

    }
    public void onProviderEnabled(String str)
    {
        //
    }
}
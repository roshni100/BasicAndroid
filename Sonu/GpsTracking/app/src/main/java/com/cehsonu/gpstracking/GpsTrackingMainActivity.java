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
		
		/*creating object of LocationManager and then providing useful data like 2000 millisecond time 
		to get updated after this time as second parameter and getting location update on change of loaction of distance 1 meter as 3rd
		parameter in requestLocationUpdates method*/
		
        locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);			
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,2000,1,this);   
    }

    /*  onLocationChanged will be called on change in location by some distance as per specification provided throgh method
	requestLocationUpdates above  */
	
	public void onLocationChanged(Location location)										
    {
        String msg="Latitude = "+location.getLatitude()+"Longitude = "+location.getLongitude();
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }

	/*  onProviderDisabled will be called when gps setting is turned off in ur mobile i am leaving this blank for now,
	jst for testing purpose kindly turn on your gps location  */
	
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
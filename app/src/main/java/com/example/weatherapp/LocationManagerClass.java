package com.example.weatherapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LocationManagerClass {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference user = database.getReference("users");
    LocationListener locationListener;
    LocationManager locationManager;

    private Context mContext;
    private String userId;

    public LocationManagerClass(Context context) {
        this.mContext = context;
    }

    @SuppressLint({"MissingPermission", "HardwareIds", "ServiceCast"})
    public void start() {
        Log.v("locationUpdate", "started");
        userId = Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.ANDROID_ID);
        String key =user.getKey();

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.v("locationUpdate", "updated");
                try{
                    user.child(userId).child("latitude").setValue(location.getLatitude());
                    user.child(userId).child("longitude").setValue(location.getLongitude());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        if (locationManager != null) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 5, locationListener);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 5, locationListener);
            Log.v("locationUpdate", "triggered");
        }else{
            Log.v("locationUpdate", "null porblem");
        }

    }

}

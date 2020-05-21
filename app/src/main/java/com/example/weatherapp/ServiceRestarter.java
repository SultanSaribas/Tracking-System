package com.example.weatherapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ServiceRestarter  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("serviceTest", "Restarted by receiver");
        context.startService(new Intent(context, LocationTrackerService.class));
    }
}

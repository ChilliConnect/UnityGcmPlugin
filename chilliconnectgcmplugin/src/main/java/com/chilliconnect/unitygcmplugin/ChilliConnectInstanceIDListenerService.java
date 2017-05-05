package com.chilliconnect.unitygcmplugin;


import android.content.Intent;
import android.util.Log;

import com.google.android.gms.iid.InstanceIDListenerService;

public class ChilliConnectInstanceIDListenerService extends InstanceIDListenerService {

    private static String TAG = "ChilliConnectInstanceIDListenerService";

    @Override
    public void onTokenRefresh() {
        Log.w(TAG, "onTokenRefresh called");
        Intent intent = new Intent(this, ChilliConnectRegistrationIntentService.class);
        startService(intent);
        Log.w(TAG, "onTokenRefresh service started");
    }
}
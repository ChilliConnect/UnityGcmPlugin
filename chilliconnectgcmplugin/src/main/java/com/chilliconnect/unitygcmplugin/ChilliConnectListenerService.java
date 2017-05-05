package com.chilliconnect.unitygcmplugin;

import android.os.Bundle;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * The listener service will be invoked for Data notifications - here
 * you can implement custom notification handling logic for background
 * processing of notifications or display a custom local notification
 */
public class ChilliConnectListenerService extends GcmListenerService {

    private static final String TAG = "ChilliConnectListenerService";

    public void onMessageReceived(String from, Bundle data) {

        /**
         * Will return the "message" key from the
         * payload of a data notification
         */
        String message = data.getString("message");

    }
}
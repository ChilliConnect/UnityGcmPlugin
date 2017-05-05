package com.chilliconnect.unitygcmplugin;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

public class ChilliConnectRegistrationIntentService extends IntentService {

    private static String TAG = "ChilliConnectGcmPlugin::ChilliConnectRegistrationIntentService";
    private static String senderId = "";

    public ChilliConnectRegistrationIntentService() {
        super("ChilliConnectRegistrationIntentService");
    }

    @Override
    public void onHandleIntent(Intent intent) {

        Log.w(TAG, "onHandleIntent called");
        try {

            InstanceID instanceID = InstanceID.getInstance(this);

            Log.w(TAG, "requesting token");

            String token = instanceID.getToken(senderId,
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

            Log.w(TAG, "Received token:" + token);

            UnityMessenger.send("OnToken", token);

        } catch (IOException e) {
            Log.w(TAG, "Error:", e);
        }
    }

    public static void requestToken(Activity activity, String senderId) {

        Log.w(TAG, "requestToken called");

        ChilliConnectRegistrationIntentService.senderId = senderId;
        activity.startService(new Intent(activity, ChilliConnectRegistrationIntentService.class));
    }
}
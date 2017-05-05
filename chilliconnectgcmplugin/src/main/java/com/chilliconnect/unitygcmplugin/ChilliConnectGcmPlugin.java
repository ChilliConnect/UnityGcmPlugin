package com.chilliconnect.unitygcmplugin;

import android.text.TextUtils;
import android.util.Log;

import com.unity3d.player.UnityPlayer;

public class ChilliConnectGcmPlugin {

    private static final String TAG = "ChilliConnectGcmPlugin";

    public static void SetReceiverGameObject(String receiverGameObject) {
        UnityMessenger.setReceiverGameObject(receiverGameObject);
    }

    public static void GenerateDeviceID(String senderId) {

        if (TextUtils.isEmpty(senderId)) {
            Log.w(TAG, "GenerateDeviceID:: empty senderId provided");
            return;
        }

        ChilliConnectRegistrationIntentService.requestToken(UnityPlayer.currentActivity, senderId);
    }
}

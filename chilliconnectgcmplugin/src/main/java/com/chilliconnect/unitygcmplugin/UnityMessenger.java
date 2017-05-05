package com.chilliconnect.unitygcmplugin;

import android.text.TextUtils;
import android.util.Log;

import com.unity3d.player.UnityPlayer;

public class UnityMessenger {

    private static final String TAG = "UnityBroadcastUtil";

    private static String receiverGameObject;

    public static void setReceiverGameObject(String receiverGameObject) {
        UnityMessenger.receiverGameObject = receiverGameObject;
    }

    public static void send(String method, String message) {

        if (TextUtils.isEmpty(receiverGameObject)) {
            Log.e( TAG, "No receiverGameObject defined");
            return;
        }

        Log.e( TAG, "Sending message [" + message + "] to [ " + receiverGameObject   + "]");

        try {
            if (TextUtils.isEmpty(message)) {
                UnityPlayer.UnitySendMessage(receiverGameObject, method, "");
            } else {
                UnityPlayer.UnitySendMessage(receiverGameObject, method, message);
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }
}

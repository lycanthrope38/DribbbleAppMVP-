package com.thongle.dribbbleapp.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.thongle.dribbbleapp.DribbbleApp;

/**
 * Created by ThongLe on 4/13/2016.
 */
public class ConnectionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = conn.getActiveNetworkInfo();
            if (info != null) {
                DribbbleApp.isNetConnect = info.isConnected();
            } else {
                DribbbleApp.isNetConnect = false;
            }
        }
    }
}


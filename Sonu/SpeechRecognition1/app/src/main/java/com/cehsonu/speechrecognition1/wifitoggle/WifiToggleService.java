package com.cehsonu.speechrecognition1.wifitoggle;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;

public class WifiToggleService extends IntentService {

    public static final String EXTRA_MESSAGE = "message";
    public WifiToggleService() {
        super("WifiToggleService");
    }

    @Override
    public void onHandleIntent(Intent intent){
        WifiManager wifiManager=(WifiManager)this.getSystemService(Context.WIFI_SERVICE);
        String text=intent.getStringExtra(EXTRA_MESSAGE);
         text=text.toLowerCase();
        if(text.equals("turn on wifi")){
            wifiManager.setWifiEnabled(true);
        }
        if(text.equals("turn off wifi")){
            wifiManager.setWifiEnabled(false);
        }

    }
}

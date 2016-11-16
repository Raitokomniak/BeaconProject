package com.T2Viat00StudentsOamkFi.NotificationtestbeaconP89;

import android.app.Application;
import android.util.Log;

import com.T2Viat00StudentsOamkFi.NotificationtestbeaconP89.estimote.BeaconID;
import com.T2Viat00StudentsOamkFi.NotificationtestbeaconP89.estimote.BeaconNotificationsManager;
import com.estimote.sdk.EstimoteSDK;

import java.util.Map;

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

public class MyApplication extends Application implements BeaconNotificationsManager.BeaconDataAvailableInterface{

    private boolean beaconNotificationsEnabled = false;
    private static final String TAG = "MyApplication";

    public interface ResponseListener {
        public void dataAvailable(Map<String,Object> itemInfo);
    }

    public MyApplication() { }

    ResponseListener uiCallback;




    @Override
    public void onCreate() {
        super.onCreate();

        EstimoteSDK.initialize(getApplicationContext(), "notificationtestbeacon-p89", "849f41d527a271e5a5c1acc83d2860c3");

        // uncomment to enable debug-level logging
        // it's usually only a good idea when troubleshooting issues with the Estimote SDK
        EstimoteSDK.enableDebugLogging(true);
    }

    public void enableBeaconNotifications(ResponseListener callbackInterface) {
        if (beaconNotificationsEnabled) { return; }
        this.uiCallback = callbackInterface;
        BeaconNotificationsManager beaconNotificationsManager = new BeaconNotificationsManager(this,this);
        beaconNotificationsManager.addNotification(
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 30186, 49616),
                "candy",
                "uncandy");
        beaconNotificationsManager.addNotification(
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 37180, 7903),
                "PEKONA",
                "UNPEKONA");
        beaconNotificationsManager.startMonitoring();

        beaconNotificationsEnabled = true;
    }

    public boolean isBeaconNotificationsEnabled() {
        return beaconNotificationsEnabled;
    }

    @Override
    public void beaconDataAvailable(Map<String,Object> itemInfo) {
        try
        {
            uiCallback.dataAvailable(itemInfo);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}

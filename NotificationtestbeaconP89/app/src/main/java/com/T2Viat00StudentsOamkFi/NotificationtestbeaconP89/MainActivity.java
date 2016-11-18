package com.T2Viat00StudentsOamkFi.NotificationtestbeaconP89;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.estimote.sdk.SystemRequirementsChecker;
import com.bumptech.glide.Glide;

import java.util.Map;

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

public class MainActivity extends AppCompatActivity implements MyApplication.ResponseListener {

    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        MyApplication app = (MyApplication) getApplication();
        if (!SystemRequirementsChecker.checkWithDefaultDialogs(this)) {
            Log.e(TAG, "Can't scan for beacons, some pre-conditions were not met");
            Log.e(TAG, "Read more about what's required at: http://estimote.github.io/Android-SDK/JavaDocs/com/estimote/sdk/SystemRequirementsChecker.html");
            Log.e(TAG, "If this is fixable, you should see a popup on the app's screen right now, asking to enable what's necessary");
        } else if (!app.isBeaconNotificationsEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            app.enableBeaconNotifications(this);
        }
    }

    @Override
    public void dataAvailable(final Map<String,Object> itemInfo) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                updateUI(itemInfo);
            }
        });
    }

    public void updateUI(Map<String,Object> itemInfo) {
        TextView textViewName = (TextView) findViewById(R.id.textName);
        TextView textViewAuthor = (TextView) findViewById(R.id.textAuthor);
        TextView textViewYear = (TextView) findViewById(R.id.textYear);
        TextView textViewDescription = (TextView) findViewById(R.id.textDescription);
        textViewName.setText(itemInfo.get("name").toString());
        textViewAuthor.setText(itemInfo.get("author").toString());
        textViewYear.setText(itemInfo.get("year").toString());
        textViewDescription.setText(itemInfo.get("description").toString());
    }

    public void loadImage(String imageURL) {
        //Maybe stuff here later
    }
}

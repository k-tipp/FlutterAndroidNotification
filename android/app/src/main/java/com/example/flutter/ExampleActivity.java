// Copyright 2016 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.example.flutter;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterView;

public class ExampleActivity extends Activity {
    private static final String TAG = "ExampleActivity";

    private FlutterView flutterView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlutterMain.ensureInitializationComplete(getApplicationContext(), null);
        setContentView(R.layout.hello_services_layout);

        flutterView = (FlutterView) findViewById(R.id.flutter_view);
        flutterView.runFromBundle(FlutterMain.findAppBundlePath(getApplicationContext()), null);

        flutterView.addOnMessageListener("createNotification",
                new FlutterView.OnMessageListener() {
                    @Override
                    public String onMessage(FlutterView view, String message) {
                        return onCreateNotification(message);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        if (flutterView != null) {
            flutterView.destroy();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        flutterView.onPause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        flutterView.onPostResume();
    }

    private String onCreateNotification(String message) {
        Intent myIntent = new Intent(this, ExampleActivity.class);

        NotificationCompat.Builder myBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("My notification")
                        .setContentText(message);

        PendingIntent myPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        myIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        myBuilder.setContentIntent(myPendingIntent);

        // Set a id for the notification
        int myNotificationId = 001;
        // Instantiate a notification manager
        NotificationManager myNotificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Build the notification and notify the user
        myNotificationManager.notify(myNotificationId, myBuilder.build());

        String reply = "Notification created";

        return reply;
    }
}

package com.rameshwor.agronepal.activities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.Button;
import android.widget.EditText;

import com.rameshwor.agronepal.R;

public class AboutusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        EditText editText;
        Button submit;
        Context context;
        getNotification();
    }

    public void getNotification() {
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.profile)
                .setContentTitle("About Us Notification")
                .setContentText("It's just a sample notification for the test.");


        Intent resultIntent = new Intent(this, AboutusActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(mId, mBuilder.build());

    }
}

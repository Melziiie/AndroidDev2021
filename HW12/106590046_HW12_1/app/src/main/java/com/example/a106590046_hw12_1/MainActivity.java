package com.example.a106590046_hw12_1;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent notifyIntent = new Intent(this, AlarmReceiver.class);
        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent,
                PendingIntent.FLAG_NO_CREATE) != null);
        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);

        alarmToggle.setChecked(alarmUp);
        PendingIntent notifyPendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmToggle.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton,
                                                 boolean isChecked) {
                        String toastMessage;
                        if (isChecked) {
                            long triggerTime;
                            Calendar cal = Calendar.getInstance();
                            cal.set(Calendar.AM_PM, Calendar.AM);
                            cal.set(Calendar.HOUR, 11);
                            cal.set(Calendar.MINUTE, 11);
                            cal.set(Calendar.SECOND, 0);

                            if (alarmManager != null) {
                                if (System.currentTimeMillis()>cal.getTimeInMillis()) {
                                    cal.add(Calendar.DAY_OF_MONTH,1);
                                }
                                triggerTime = cal.getTimeInMillis();
                                alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, notifyPendingIntent);
                            }
                            //Set the toast message for the "on" case
                            toastMessage = getString(R.string.alarm_on_toast);
                        } else {
                            //Cancel notification if the alarm is turned off
                            if (alarmManager != null) {
                                alarmManager.cancel(notifyPendingIntent);
                            }

                            mNotificationManager.cancelAll();

                            //Set the toast message for the "off" case
                            toastMessage = getString(R.string.alarm_off_toast);
                        }

                        //Show a toast to say the alarm is turned on or off.
                        Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createNotificationChannel();
    }

    /**
     * Creates a Notification channel, for OREO and higher.
     */
    public void createNotificationChannel() {

        // Create a notification manager object.
        mNotificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "11:11 notification",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    ("Reminds you to make 11:11 wish!");
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }


}
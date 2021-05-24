package com.example.a106590046_hw11_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public TextView mRandomInt;
    private CustomReceiver mReceiver = new CustomReceiver();
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRandomInt = findViewById(R.id.randIntText);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mReceiver,
                        new IntentFilter(ACTION_CUSTOM_BROADCAST));

        this.registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        //Unregister the receiver
        this.unregisterReceiver(mReceiver);
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    public void sendBroadcast(View view) {
        Random rand = new Random();
        Integer rInt = rand.nextInt(20);
        mRandomInt.setText(rInt.toString());
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        customBroadcastIntent.putExtra("randInt", rInt);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }
}
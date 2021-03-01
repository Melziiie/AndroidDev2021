package com.example.a106590046_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "Something's happening");
        Log.e(LOG_TAG, "Problem");
        Log.w(LOG_TAG, "Potential Problem");
        Log.i(LOG_TAG, "Hello World");

    }
}
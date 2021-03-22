package com.example.a106590046_hw4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    private int mCount = 0;
    private TextView mShowCount;
    public static final String EXTRA_MESSAGE = "com.example.a106590046_hw4_1.extra.MESSAGE";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG,"onSaveInstanceState");
        if (mCount>0) {
            outState.putBoolean("count_started", true);
            outState.putString("count_value",
                    mShowCount.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG,"-------");
        Log.d(LOG_TAG,"onCreate");
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.showCount);

        if (savedInstanceState != null) {
            boolean isStarted = savedInstanceState.getBoolean("count_started");
            if(isStarted){
                mShowCount.setText(savedInstanceState.getString("count_value"));
                mCount = Integer.parseInt(mShowCount.getText().toString());
            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mShowCount.setText(reply);
                mCount = Integer.parseInt(reply);
            }
        }
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mShowCount.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent,TEXT_REQUEST);
    }
}
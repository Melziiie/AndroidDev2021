package com.example.a106590046_hw3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private EditText mCountEditText;
    public static final String EXTRA_REPLY = "com.example.a106590046_hw3_2.extra.REPLY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mCountEditText = (EditText) findViewById(R.id.setCount);
        mCountEditText.setText(message);
    }

    public void updateCount(View view) {
        Intent replyIntent = new Intent();
        String reply = mCountEditText.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}
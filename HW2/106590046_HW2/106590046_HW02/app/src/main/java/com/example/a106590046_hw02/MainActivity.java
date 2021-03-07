package com.example.a106590046_hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mBtnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.showCount);
        mBtnCount = (Button) findViewById(R.id.btnCount);

//        mBtnCount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this,R.string.toastMessage,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if (mCount % 2 == 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mBtnCount.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            }
            mBtnCount.setBackgroundColor(getResources().getColor(R.color.green));
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mBtnCount.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
            }
            mBtnCount.setBackgroundColor(getResources().getColor(R.color.red));
        }
        if (mCount > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                findViewById(R.id.btnZero).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            }
            findViewById(R.id.btnZero).setBackgroundColor(getResources().getColor(R.color.teal_700));
        }

    }

    public void setZero(View view) {
        mShowCount.setText(R.string.showCountInitial);
        mCount=0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById(R.id.btnCount).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.purple_500)));
            view.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.gray)));
        }
        view.setBackgroundColor(getResources().getColor(R.color.gray));
        findViewById(R.id.btnCount).setBackground(getResources().getDrawable(R.color.purple_500));
    }
}
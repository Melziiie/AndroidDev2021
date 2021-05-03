package com.example.a106590046_hw8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public ImageView imgBattery;
    public int count=0;
//    public LevelListDrawable levelList = new LevelListDrawable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgBattery = (ImageView) findViewById(R.id.imageView2);
    }

    public void levelDown(View view) {
        if (count > 0) count--;
        imgBattery.setImageLevel(count);
    }

    public void levelUp(View view) {
        if (count < 5) count++;
        imgBattery.setImageLevel(count);
    }
}
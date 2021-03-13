package com.example.a106590046_hw3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    public ImageView imgArticle;
    public ScrollView mScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgArticle = (ImageView) findViewById(R.id.article_img);
        imgArticle.setTag(R.drawable.article_img2);
        mScroll = (ScrollView) findViewById(R.id.article_scroll);
    }

    public void changeImage(View view) {
        if ((int) imgArticle.getTag()== R.drawable.article_img2){
            imgArticle.setImageDrawable(getResources().getDrawable(R.drawable.article_img));
            imgArticle.setTag(R.drawable.article_img);
        }else{
            imgArticle.setImageDrawable(getResources().getDrawable(R.drawable.article_img2));
            imgArticle.setTag(R.drawable.article_img2);
        }
        mScroll.fullScroll(View.FOCUS_UP);
    }
}
package com.example.a106590046_hw4_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEdit;
    private EditText mLocationEdit;
    private EditText mShareEdit;
    private ImageView mCapturedImage;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEdit = findViewById(R.id.edit_website);
        mLocationEdit = findViewById(R.id.edit_location);
        mShareEdit = findViewById(R.id.edit_share);
        mCapturedImage = findViewById(R.id.imageView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mCapturedImage.setVisibility(View.VISIBLE);
            mCapturedImage.setImageBitmap(imageBitmap);
        }
    }

    public void openWebsite(View view) {
        String url = mWebsiteEdit.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }else Log.d("ImplicitIntents", "Can't handle this!");
    }

    public void openLocation(View view) {
        String loc = mLocationEdit.getText().toString();
        Uri address = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, address);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }else Log.d("ImplicitIntents", "Can't handle this!");
    }

    public void shareText(View view) {
        String text = mShareEdit.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.chooserTitle)
                .setText(text)
                .startChooser();
    }

    public void takePicture(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }else Log.d("ImplicitIntents", "Can't handle this!");
    }
}
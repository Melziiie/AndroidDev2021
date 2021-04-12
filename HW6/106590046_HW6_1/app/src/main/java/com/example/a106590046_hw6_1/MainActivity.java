package com.example.a106590046_hw6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String mToast = "Toppings: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayToast(View view) {
        Toast toast = Toast.makeText(this,mToast,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onCheckBoxClicked(View view) {
        boolean checked = ((CheckBox)view).isChecked();

        switch (view.getId()){
            case R.id.syrupCheckBox:
                if(checked) {
                    mToast += (getString(R.string.syrupText)+' ');
                }else{
                    mToast=mToast.replaceAll((getString(R.string.syrupText)+' '),"");
                }
                break;
            case R.id.sprinklesCheckBox:
                if(checked) {
                    mToast += (getString(R.string.sprinklesText)+' ');
                }else{
                    mToast=mToast.replaceAll((getString(R.string.sprinklesText)+' '),"");
                }
                break;
            case R.id.nutsCheckBox:
                if(checked) {
                    mToast += (getString(R.string.nutsText)+' ');
                }else{
                    mToast=mToast.replaceAll((getString(R.string.nutsText)+' '),"");
                }
                break;
            case R.id.cherriesCheckBox:
                if(checked) {
                    mToast += (getString(R.string.cherriesText)+' ');
                }else{
                    mToast=mToast.replaceAll((getString(R.string.cherriesText)+' '),"");
                }
                break;
            case R.id.oreoCheckBox:
                if(checked) {
                    mToast += (getString(R.string.oreoText)+' ');
                }else{
                    mToast=mToast.replaceAll((getString(R.string.oreoText)+' '),"");
                }
                break;
        }
    }
}
package com.example.a106590046_hw10_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks, PopupMenu.OnMenuItemClickListener {
    private EditText mURL;
    private TextView mSourceText;
    private TextView mProtocol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mURL=(EditText)findViewById(R.id.URL);
        mSourceText=(TextView)findViewById(R.id.sourceText);
        mProtocol=(TextView)findViewById(R.id.urlStart);


        if(getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }
    }



    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.http:
                mProtocol.setText(R.string.http);
                return true;
            case R.id.https:
                mProtocol.setText(R.string.https);
                return true;
            default:
                return false;
        }
    }

    public void getSource(View view) {
        String queryString = mProtocol.getText() + mURL.getText().toString();

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputManager != null ) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {
            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);
            mSourceText.setText(R.string.loading);
        }else {
            if (queryString.length() == 0) {
                mSourceText.setText(R.string.noURL);
            } else {
                mSourceText.setText(R.string.noNetwork);
            }
        }
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Loader onCreateLoader(int id, @Nullable @org.jetbrains.annotations.Nullable Bundle args) {
        String queryString = "";

        if (args != null) {
            queryString = args.getString("queryString");
        }

        return new SourceLoader(this, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull @org.jetbrains.annotations.NotNull Loader loader, Object data) {
        String source;
        try {
            if (data != null) {
                mSourceText.setText(data.toString());
            } else {
                mSourceText.setText(R.string.no_results);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mSourceText.setText(R.string.no_results);
        }
    }

    @Override
    public void onLoaderReset(@NonNull @org.jetbrains.annotations.NotNull Loader loader) {

    }

    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, mProtocol);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.protocols, popup.getMenu());
        popup.show();
        popup.setOnMenuItemClickListener(this);
    }
}
package com.example.a106590046_hw10_2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

public class SourceLoader extends AsyncTaskLoader<String> {
    private String mQueryString;

    SourceLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        return NetworkUtils.getSourceURL(mQueryString);
    }
}

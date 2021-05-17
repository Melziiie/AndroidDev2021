package com.example.a106590046_hw10_2;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();
    //    // Parameter for the search string.
//    private static final String QUERY_PARAM = "q";
//    // Parameter that limits search results.
//    private static final String MAX_RESULTS = "maxResults";
//    // Parameter to filter by print type.
//    private static final String PRINT_TYPE = "printType";

    static String getSourceURL(String queryString){
        // Base URL for Books API.
        //=  "https://www.googleapis.com/books/v1/volumes?";
        String BOOK_BASE_URL = queryString;
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String sourceJSONString = null;

        try {
            URL requestURL = new URL(BOOK_BASE_URL);

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
//            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }

            if (builder.length() == 0) {
                return null;
            }

            sourceJSONString = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            String error = urlConnection.getErrorStream().toString();
            Log.d(LOG_TAG, error);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.d(LOG_TAG, sourceJSONString);
        return sourceJSONString;
    }
}

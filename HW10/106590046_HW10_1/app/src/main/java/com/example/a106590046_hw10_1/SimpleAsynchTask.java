package com.example.a106590046_hw10_1;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsynchTask extends AsyncTask <Void, Integer, String>{
    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mProgressBar;

    SimpleAsynchTask(TextView tv, ProgressBar pb) {
        mTextView=new WeakReference<>(tv);
        mProgressBar=new WeakReference<>(pb);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);

        int s = n * 200;
        int sPart = s/10;
        int temp;

        for (int i=sPart; i<=s; i+=sPart) {
            try {
                Thread.sleep(i);
                temp=(int)(((double)i / s) * 100);
                publishProgress(temp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
        mProgressBar.get().setProgress(progress[0]);
    }

    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }

}

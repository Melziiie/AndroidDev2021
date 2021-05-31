package com.example.a106590046_hw12_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private JobScheduler mScheduler;
    private static final int JOB_ID = 0;
    private Button mDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDownload = findViewById(R.id.download);
        mDownload.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                download(v);
            }
        });


    }

    public void download(View view) {
        int selectedNetworkOption = JobInfo.NETWORK_TYPE_UNMETERED;
        mScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        ComponentName serviceName = new ComponentName(getPackageName(),
                NotificationJobService.class.getName());
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, serviceName);
        builder.setRequiredNetworkType(selectedNetworkOption)
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true);;

        JobInfo myJobInfo = builder.build();
        mScheduler.schedule(myJobInfo);

        Toast.makeText(this, "Download will begin when " +
                "power and WIFI are connected.", Toast.LENGTH_SHORT).show();
    }

    public void cancelDownload(View view) {
        if (mScheduler!=null){
            mScheduler.cancelAll();
            mScheduler = null;
            Toast.makeText(this, "Download cancelled", Toast.LENGTH_SHORT).show();
        }
    }
}
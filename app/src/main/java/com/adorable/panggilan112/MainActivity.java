package com.adorable.panggilan112;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;

import com.adorable.panggilan112.activity.HomeActivity;
import com.adorable.panggilan112.activity.WelcomeActivity;
import com.adorable.panggilan112.utility.NetworkChangeListener;

public class MainActivity extends AppCompatActivity {
    private static int splash_time_out=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent c = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(c);
                finish();
            }
        },splash_time_out);
    }

}
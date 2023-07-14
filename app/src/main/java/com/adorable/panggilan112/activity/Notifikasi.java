package com.adorable.panggilan112.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.adorable.panggilan112.R;

public class Notifikasi {

    //Initialize variable
    TextView textView;
    private Button btn_kembali;
    //private static int splash_time_out=10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        //new Handler().postDelayed(new Runnable() {
        //@Override
        //public void run() {
        //Intent c = new Intent(Notifikasi.this, Onboarding_satu.class);
        //startActivity(c);
        //finish();
        //}
        //},splash_time_out);

        Button btn_kembali = (Button) findViewById(R.id.btn_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent a = new Intent(view.getContext(), WelcomeActivity.class);
                startActivity(a);
                finish();
            }
        });
        //Assign variable
        textView=findViewById(R.id.textView);

        //Initialize timer duration
        //long duration = TimeUnit.MINUTES.toMillis(1);

        //Initialiaze countdown timer
        new CountDownTimer(59000, 1000) {
            @Override
            public void onTick(long l) {
                textView.setText("00 : " + l/1000);
                //When tick
                //Convert millisecond to minute and second
                //String sDuration = String.format(Locale.ENGLISH, "%02d : %02d"
                //,TimeUnit.MILLISECONDS.toMinutes(1)
                //,TimeUnit.MILLISECONDS.toSeconds(1) -
                // TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(1)));

                //Set Converted string on text view
                //textView.setText(sDuration);
            }

            @Override
            public void onFinish() {

                textView.setText("00 : 00");
                //When finish
                //Hide text view
                //textView.setVisibility(View.GONE);
                //Display toast
                //Toast.makeText(getApplicationContext()
                //, "Countdown timer has ended", Toast.LENGTH_LONG).show();
            }
        }.start();
    }
}
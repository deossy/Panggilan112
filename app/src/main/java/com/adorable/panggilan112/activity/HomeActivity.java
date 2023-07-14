package com.adorable.panggilan112.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.adorable.panggilan112.R;
import com.adorable.panggilan112.utility.NetworkChangeListener;

public class HomeActivity {
    private Button btn_emergency;
    private ImageButton btn_polisi, btn_psc, btn_damkar, btn_bpbd, btn_spp;
    private ImageView ic_menu;
    private Object Menu;
    NetworkChangeListener networkChangeListener = new NetworkChangeListener();

    //    TextView nama_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        nama_user = (TextView) findViewById(R.id.nama_user);
//        Bundle bundle = getIntent().getExtras();
//        String data1 = bundle.getString("urname");
//
//        nama_user.setText(data1);

        Button btn_emergency = (Button) findViewById(R.id.btn_emergency);
        btn_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a = new Intent(view.getContext(), EmergencyActivity.class);
                startActivity(a);
                finish();
            }

        });

        ImageButton btn_polisi = (ImageButton) findViewById(R.id.btn_polisi);
        btn_polisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Layanan Polisi", Toast.LENGTH_LONG).show();//display the toast on polisi button click
                Intent a = new Intent(view.getContext(), LayananPolisi.class);
                startActivity(a);
                finish();
            }

        });

        ImageButton btn_damkar = (ImageButton) findViewById(R.id.btn_damkar);
        btn_damkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Layanan Damkar", Toast.LENGTH_LONG).show();//display the toast on damkar button click
                Intent a = new Intent(view.getContext(), LayananDamkar.class);
                startActivity(a);
                finish();
            }

        });

        ImageButton btn_psc = (ImageButton) findViewById(R.id.btn_psc);
        btn_psc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Layanan PSC", Toast.LENGTH_LONG).show();//display the toast on psc button click
                Intent a = new Intent(view.getContext(), LayananPsc.class);
                startActivity(a);
                finish();
            }

        });

        ImageButton btn_bpbd = (ImageButton) findViewById(R.id.btn_bpbd);
        btn_bpbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Layanan BPBD", Toast.LENGTH_LONG).show();//display the toast on bpbd button click
                Intent a = new Intent(view.getContext(), LayananBpbd.class);
                startActivity(a);
                finish();
            }

        });

        ImageButton btn_spp = (ImageButton) findViewById(R.id.btn_spp);
        btn_spp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Layanan Satpol PP", Toast.LENGTH_LONG).show();//display the toast on spp button click
                Intent a = new Intent(view.getContext(), LayananSatpol.class);
                startActivity(a);
                finish();
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                Toast.makeText(this, "Kembali ke halaman Register", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                logout();
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void logout()
    {
        Toast.makeText(this, "Anda keluar", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, filter);
        super.onStart();
    }
    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);
        super.onStop();
    }
}
package com.adorable.panggilan112.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.adorable.panggilan112.Notifikasi;
import com.adorable.panggilan112.R;
import com.adorable.panggilan112.utility.NetworkChangeListener;

public class EmergencyActivity extends AppCompatActivity {
    private ImageView back, myImage;
    private Button btn_kirim;
    NetworkChangeListener networkChangeListener = new NetworkChangeListener();
    private static  final int REQUEST_CODE = 22;
    Button btnpicture;
    ImageView imageView;
    String[] item = {"KEBAKARAN", "KECELAKAAN", "DARURAT MEDIS", "PENCARIAN DAN PERTOLONGAN", "HEWAN LIAR/BUAS", "BENCANA ALAM","KERUNTUHAN BANGUNAN","GANGGUAN KEAMANAN/KETERTIBAN", "KDRT"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        Button btn_kirim = (Button) findViewById(R.id.btn_kirim);
        btn_kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a = new Intent(view.getContext(), Notifikasi.class);
                startActivity(a);
                finish();
            }

        });
        ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a = new Intent(view.getContext(), HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        autoCompleteTextView = findViewById(R.id.auto_complete_textview);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item, item);

        autoCompleteTextView.setAdapter(adapterItems);


        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(EmergencyActivity.this, "Choose "+ item, Toast.LENGTH_SHORT).show();
            }
        });

        btnpicture = findViewById(R.id.btncamera_id);
        myImage = findViewById(R.id.myImage);

        btnpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            myImage.setImageBitmap(photo);

        }
        else {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
        }
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

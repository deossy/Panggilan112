package com.adorable.panggilan112.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.adorable.panggilan112.R;
import com.adorable.panggilan112.utility.NetworkChangeListener;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity {
    //TextView captureTxt;
    private ImageView back, myImage;
    TextInputLayout urname;
    private Button button, btnkirim;
    NetworkChangeListener networkChangeListener = new NetworkChangeListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        urname = (TextInputLayout) findViewById(R.id.urname);
        btnkirim = (Button) findViewById(R.id.btnkirim);

        ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a = new Intent(view.getContext(), WelcomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        Button btnkirim = (Button) findViewById(R.id.btnkirim);
        btnkirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a = new Intent(view.getContext(), HomeActivity.class);
                startActivity(a);
                finish();
            }
        });


        myImage = (ImageView) findViewById(R.id.myImage);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });

        //autoCompleteTextView = findViewById(R.id.auto_complete_textview);

        //adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, item);

        //autoCompleteTextView.setAdapter(adapterItems);


        //autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //@Override
        //public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //String item = adapterView.getItemAtPosition(position).toString();
        //Toast.makeText(Registrasi.this, "Choose " + item, Toast.LENGTH_SHORT).show();
        //}
        //});

        //clickToUploading = (ImageView) findViewById(R.id.clickToUploading);
//        btnpicture = findViewById(R.id.btncamera_id);
//        imageView = findViewById(R.id.imageview1);
//
//        btnpicture.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent, REQUEST_CODE);
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            imageView.setImageBitmap(photo);
//
//        } else {
//            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }

//    public void movepage(View view) {
//        String stname = urname.getText().toString();
//
//        if (stname.equals("Levi Ackerman")) {
//            Intent in = new Intent(Registrasi.this, Home.class);
//            Bundle bundle = new Bundle();
//            bundle.putString("urname", stname);
//            in.putExtras(bundle);
//            startActivity(in);
//        } else if (stname.equals(""))
//        {
//            Toast.makeText(getBaseContext(), "Enter both Name and passsword", Toast.LENGTH_SHORT).show();
//        } else
//        {
//            Toast.makeText(getBaseContext(), "wrong Name and passsword", Toast.LENGTH_SHORT).show();
//
//        }
//    }
}

    private void takePicture() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 0);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Bitmap b = (Bitmap) data.getExtras().get("data");
            myImage.setImageBitmap(b);
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

//UNTUK FILES CHOOSE



//ActivityResultLauncher<Intent> sActivityResultLauncher = registerForActivityResult(
//new ActivityResultContracts.StartActivityForResult(),
//new ActivityResultCallback<ActivityResult>() {
//@Override
//public void onActivityResult(ActivityResult result) {
//if (result.getResultCode() == Activity.RESULT_OK){
//Intent data = result.getData();
//Uri uri = data.getData();
//clickToUploading.setImageURI(uri);
//}
//}
//}


//);
//public void openFileDialog(View view) {
//Intent data = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//data.setType("image/*");
//data = Intent.createChooser(data, "Choose a file");
//sActivityResultLauncher.launch(data);
//}

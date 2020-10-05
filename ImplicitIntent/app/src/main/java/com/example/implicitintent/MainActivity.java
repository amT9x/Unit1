package com.example.implicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnWeb, btnLocation, btnShare, btnCapture;
    private EditText edtWeb, edtLocation, edtShare;

    private static final int REQUEST_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        OpenWeb();
        OpenLocation();
        ShareText();
        Capture();
    }

    private void Capture(){
        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CAPTURE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CAPTURE){
            if(resultCode == RESULT_OK){
                Bundle extra = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extra.get("data");
            }
        }
    }

    private void ShareText(){
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = edtShare.getText().toString().trim();
                String mimeType = "type/plain";
                ShareCompat.IntentBuilder
                        .from(MainActivity.this)
                        .setType(mimeType)
                        .setChooserTitle(R.string.text_share_title)
                        .setText(txt)
                        .startChooser();
            }
        });
    }

    private void OpenLocation(){
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = edtLocation.getText().toString().trim();
                Uri address = Uri.parse("geo:0,0?q=" + location);
                Intent intentLocation = new Intent(Intent.ACTION_VIEW, address);
                if(intentLocation.resolveActivity(getPackageManager()) != null){
                    startActivity(intentLocation);
                }else{
                    Log.d("Implicit", "onClick: Can't handle this intent");
                }
            }
        });
    }

    private void OpenWeb(){
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = edtWeb.getText().toString().trim();
                Uri webpage = Uri.parse(url);
                //truyen 1 action va data
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, webpage);
                if(intentWeb.resolveActivity(getPackageManager()) != null){
                    startActivity(intentWeb);
                }else{
                    Log.d("Implicit", "onClick: Can't handle this!");
                }

            }
        });
    }

    private void AnhXa(){
        btnWeb = (Button) findViewById(R.id.buttonWeb);
        btnLocation = (Button) findViewById(R.id.buttonLocation);
        btnShare = (Button) findViewById(R.id.buttonShare);
        edtWeb = (EditText) findViewById(R.id.edittextWeb);
        edtLocation = (EditText) findViewById(R.id.edittextLocation);
        edtShare = (EditText) findViewById(R.id.edittextShare);
        btnCapture = (Button) findViewById(R.id.buttoncapture);
    }
}
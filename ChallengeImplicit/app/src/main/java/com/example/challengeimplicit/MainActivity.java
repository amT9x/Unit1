package com.example.challengeimplicit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtItemBought;
    private Button btnShopActivity;

    public static final int REQUEST_CODE = 1;
    private static final String TAG_MAIN = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        TransferShopActivity();
    }

    private void TransferShopActivity(){
        btnShopActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentShop = new Intent(MainActivity.this, ShopActivity.class);
                startActivityForResult(intentShop, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG_MAIN, "onActivityResult: \n" + requestCode + " - " + resultCode + " - ");
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String messageReply = data.getStringExtra(ShopActivity.EXTRA_REPLY);
                txtItemBought.setText(messageReply);
            }
        }
    }

    private void AnhXa(){
        btnShopActivity = (Button) findViewById(R.id.buttonShopActivity);
        txtItemBought = (TextView) findViewById(R.id.textVietListBought);

    }
}
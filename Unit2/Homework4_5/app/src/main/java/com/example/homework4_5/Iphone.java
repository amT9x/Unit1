package com.example.homework4_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import static com.example.homework4_5.ShopAdapter.EXTRA_IPHONE;

public class Iphone extends AppCompatActivity {

    private TextView txtIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iphone);

        txtIP = (TextView) findViewById(R.id.textviewIP);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarIP);
//        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_IPHONE);
        txtIP.setText(message);
    }
}
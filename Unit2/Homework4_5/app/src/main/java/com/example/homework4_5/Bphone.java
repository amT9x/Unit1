package com.example.homework4_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.homework4_5.ShopAdapter.EXTRA_BPHONE;

public class Bphone extends AppCompatActivity {

    TextView txtBphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bphone);

        txtBphone = (TextView) findViewById(R.id.textviewBphone);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_BPHONE);
        txtBphone.setText(message);
    }
}
package com.example.homework4_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.homework4_5.ShopAdapter.EXTRA_SAMSUNG;

public class Samsung extends AppCompatActivity {

    TextView txtSamsung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsung);

        txtSamsung = (TextView) findViewById(R.id.textviewSamsung);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_SAMSUNG);
        txtSamsung.setText(message);
    }
}
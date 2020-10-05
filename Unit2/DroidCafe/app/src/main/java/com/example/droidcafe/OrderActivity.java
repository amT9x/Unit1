package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private TextView txt_item_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        AnhXa();
        ReceivedMessageOrder();
    }

    private void ReceivedMessageOrder(){
        Intent intent = getIntent();
        String messageReceived = intent.getStringExtra(MainActivity.MESSAGE_ORDER);
        txt_item_order.setText(messageReceived);
    }

    private void AnhXa(){
        txt_item_order = (TextView) findViewById(R.id.order_textview);
    }
}
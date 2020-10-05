package com.example.homeworkactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mtxtSecond, mtxtReceivedCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        AnhXa();
        ReceivedCount();
    }

    private void ReceivedCount(){
        Intent iReceived = getIntent();
        int countReceived = iReceived.getIntExtra(MainActivity.EXTRA_SEND, 0);
        mtxtSecond.setText(R.string.text_second_activity);
        mtxtReceivedCount.setText(String.valueOf(countReceived));
    }

    private void AnhXa(){
        mtxtSecond = (TextView) findViewById(R.id.tVSecond);
        mtxtReceivedCount = (TextView) findViewById(R.id.tVReceivedCount);
    }
}
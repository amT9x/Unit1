package com.example.homeworkactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnSecondActivity, btnCount;
    TextView txtCount;
    public int mCount = 0;

    public static final String TAG_MAIN_ACTIVITY = "MainActivity";
    public static final String EXTRA_SEND = "com.example.homeworkactivity.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        Count();
        TransferSecondAvtivity();
    }

    private void Count(){
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++mCount;
                if(txtCount != null){
                    txtCount.setText(String.valueOf(mCount));
                    Log.d(TAG_MAIN_ACTIVITY, "onClick: " + txtCount);
                }
            }
        });
    }

    private void TransferSecondAvtivity(){
        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSecond = new Intent(MainActivity.this, SecondActivity.class);
                intentSecond.putExtra(EXTRA_SEND, mCount);
                startActivity(intentSecond);
            }
        });
    }

    private void AnhXa(){
        btnCount = (Button) findViewById(R.id.buttonCount);
        btnSecondActivity = (Button) findViewById(R.id.buttonSecongActivity);
        txtCount = (TextView) findViewById(R.id.textviewCount);
    }
}
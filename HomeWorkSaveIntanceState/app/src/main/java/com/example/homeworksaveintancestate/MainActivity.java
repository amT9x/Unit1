package com.example.homeworksaveintancestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtInfo;
    private Button btnCount;
    private EditText edtEnter;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        if(savedInstanceState != null){
            boolean isVisible = savedInstanceState.getBoolean("key");
            if(isVisible){
                txtInfo.setText(savedInstanceState.getString("string_key"));
                txtInfo.setVisibility(View.VISIBLE);
            }
        }

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++mCount;
                if(txtInfo != null){
                    txtInfo.setText(String.valueOf(mCount));
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if(txtInfo.getVisibility() == View.VISIBLE){
            outState.putBoolean("key", true);
            outState.putString("string_key", txtInfo.getText().toString());
        }
    }

    private void AnhXa(){
        txtInfo = (TextView) findViewById(R.id.textView);
        btnCount = (Button) findViewById(R.id.button);
        edtEnter = (EditText) findViewById(R.id.editText);











    }
}
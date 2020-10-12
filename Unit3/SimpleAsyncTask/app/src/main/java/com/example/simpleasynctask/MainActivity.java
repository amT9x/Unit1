package com.example.simpleasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button btnButton;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);
        btnButton = (Button) findViewById(R.id.button1);
        pb = (ProgressBar) findViewById(R.id.progressBar);



        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText(R.string.napping);
//                pb.setVisibility(View.VISIBLE);
//                pb.setProgress(0);
                new SimpleAsyncTask(mTextView, pb).execute();
            }
        });
    }
}
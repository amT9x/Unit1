package com.example.homework4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox cb1, cb2, cb3, cb4, cb5;
    private Button btnShowToast, btnTest;

    public static final String TAG_MAINACTIVITY = "_MainActivity";

    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        arrayList = new ArrayList<>();
        checkCheckBox();

    }

    private void checkCheckBox(){

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cb1.isChecked()){
                    arrayList.add(getString(R.string.chocolate));
                }else{
                    arrayList.remove(getString(R.string.chocolate));
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cb2.isChecked()){
                    arrayList.add(getString(R.string.Sprinkles));
                }else{
                    arrayList.remove(getString(R.string.Sprinkles));
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cb3.isChecked()){
                    arrayList.add(getString(R.string.Crushed));
                }else{
                    arrayList.remove(getString(R.string.Crushed));
                }
            }
        });
        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cb4.isChecked()){
                    arrayList.add(getString(R.string.cherries));
                }else{
                    arrayList.remove(getString(R.string.cherries));
                }
            }
        });
        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    arrayList.add(getString(R.string.orio));
                }else{
                    arrayList.remove(getString(R.string.orio));
                }
            }
        });

/*        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG_MAINACTIVITY, "onClick: " + arrayList2);
                Toast.makeText(MainActivity.this, String.valueOf(arrayList2), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    private void AnhXa(){
        cb1 = (CheckBox) findViewById(R.id.cb_chocolate);
        cb1.setOnClickListener(this);
        cb2 = (CheckBox) findViewById(R.id.cb_sprin);
        cb2.setOnClickListener(this);
        cb3 = (CheckBox) findViewById(R.id.cb_crus);
        cb3.setOnClickListener(this);
        cb4 = (CheckBox) findViewById(R.id.cb_cherri);
        cb4.setOnClickListener(this);
        cb5 = (CheckBox) findViewById(R.id.cb_orio);
        cb5.setOnClickListener(this);
        btnShowToast = (Button) findViewById(R.id.buttonShowToast);
        btnShowToast.setOnClickListener(this);
        btnTest = findViewById(R.id.buttonTest);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonShowToast:
                Log.d(TAG_MAINACTIVITY, "onClick: " + arrayList);
                Toast.makeText(this, String.valueOf(arrayList), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
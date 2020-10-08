package com.example.inputcontrol_date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView txt_item_order;
    private Button btnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        AnhXa();
        ReceivedMessageOrder();

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment date = new DatePickerFragment();
                date.show(getSupportFragmentManager(), "datePicker");
            }
        });

        Spinner spinner = findViewById(R.id.label_spiner);
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if(spinner != null){
            spinner.setAdapter(adapter);
        }
    }

    public void processDatePicker(int y, int m, int d){
        String yeer = Integer.toString(y);
        String month = Integer.toString(m);
        String day = Integer.toString(d);
        String date = (month + "/" + day + "/" + yeer);
        Toast.makeText(this, "Date: " + date, Toast.LENGTH_SHORT).show();
    }

    private void ReceivedMessageOrder(){
        Intent intent = getIntent();
        String messageReceived = intent.getStringExtra(MainActivity.MESSAGE_ORDER);
        txt_item_order.setText(messageReceived);
    }

    private void AnhXa(){
        txt_item_order = (TextView) findViewById(R.id.order_textview);
        btnDate = (Button) findViewById(R.id.buttonDate);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.sameday:
                if(checked){
                    displayToast(getString(R.string.text_same_day));
                }
            case R.id.nextday:
                if(checked){
                    displayToast(getString(R.string.text_next_day));
                }
            case R.id.pickup:
                if(checked){
                    displayToast(getString(R.string.text_pickup));
                }
        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
package com.example.challengeimplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnShowItems, btnReturn;
    private TextView txtItem1, txtItem2, txtItem3, txtItem4, txtItem5
            , txtItem6, txtItem7, txtItem8, txtItem9, txtItem10;

    public static final String EXTRA_REPLY = "com.example.challengeimplicit.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        AnhXa();
    }

    private void AnhXa(){
        btnShowItems = (Button) findViewById(R.id.buttonShowItems);
        btnShowItems.setOnClickListener(this);
        btnReturn = (Button) findViewById(R.id.buttonReturn);
        btnReturn.setOnClickListener(this);
        txtItem1 = (TextView) findViewById(R.id.itemApple);
        txtItem1.setOnClickListener(this);
        txtItem2 = (TextView) findViewById(R.id.itemMango);
        txtItem3 = (TextView) findViewById(R.id.itemBanana);
        txtItem4 = (TextView) findViewById(R.id.itemOrange);
        txtItem5 = (TextView) findViewById(R.id.itemEgg);
        txtItem6 = (TextView) findViewById(R.id.itemMeat);
        txtItem7 = (TextView) findViewById(R.id.itemClothes);
        txtItem8 = (TextView) findViewById(R.id.itemMelon);
        txtItem9 = (TextView) findViewById(R.id.itemLemon);
        txtItem10 = (TextView) findViewById(R.id.itemFish);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //return MainActivity
            case R.id.buttonReturn:
//                Toast.makeText(this, "tunghv", Toast.LENGTH_SHORT).show();
                String messageReply = txtItem1.getText().toString().trim();
                Intent intentReturn = new Intent(ShopActivity.this, MainActivity.class);
                intentReturn.putExtra(EXTRA_REPLY, messageReply);
                setResult(RESULT_OK, intentReturn);
                finish();
                break;
            case R.id.itemApple:
                txtItem1.setBackgroundColor(getColor(R.color.button_Main));
            case R.id.buttonShowItems:
                txtItem1.setText(getString(R.string.text_item1));//apple
                txtItem1.setVisibility(View.VISIBLE);
                txtItem2.setText(getString(R.string.text_item2));//mango
                txtItem2.setVisibility(View.VISIBLE);
                txtItem3.setText(getString(R.string.text_item3));//banana
                txtItem3.setVisibility(View.VISIBLE);
                txtItem4.setText(getString(R.string.text_item4));//orange
                txtItem4.setVisibility(View.VISIBLE);
                txtItem5.setText(getString(R.string.text_item5));//egg
                txtItem5.setVisibility(View.VISIBLE);
                txtItem6.setText(getString(R.string.text_item6));//meat
                txtItem6.setVisibility(View.VISIBLE);
                txtItem7.setText(getString(R.string.text_item7));//clothes
                txtItem7.setVisibility(View.VISIBLE);
                txtItem8.setText(getString(R.string.text_item8));//melon
                txtItem8.setVisibility(View.VISIBLE);
                txtItem9.setText(getString(R.string.text_item9));//lemon
                txtItem9.setVisibility(View.VISIBLE);
                txtItem10.setText(getString(R.string.text_item10)+getString(R.string.decri_item10));
                txtItem10.setVisibility(View.VISIBLE);
        }
    }
}
package com.example.homework7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtPopUp, txtGetSource;
    private Button btnGetSource;
    private EditText edtURL;
    GetSource getSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPopUp = (TextView) findViewById(R.id.text_http);
        txtGetSource = (TextView) findViewById(R.id.textGetSource);
        btnGetSource = (Button) findViewById(R.id.buttonSource);
        edtURL = (EditText) findViewById(R.id.edittextURL);

        txtPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupHttp();
            }
        });

        btnGetSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSource = new GetSource(txtGetSource);
                getSource.execute(txtPopUp.getText().toString().trim() + edtURL.getText().toString().trim());
            }
        });
    }

    private void PopupHttp(){
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, txtPopUp);
        popupMenu.inflate(R.menu.layout_popup_menu);

        Menu menu = popupMenu.getMenu();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return menuItemClicked(menuItem);
            }
        });

        popupMenu.show();
    }

    private boolean menuItemClicked(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuHTTP:
                txtPopUp.setText(getString(R.string.http));
                break;
            case R.id.menuHTTPS:
                txtPopUp.setText(getString(R.string.https));
                break;
        }
        return true;
    }
}
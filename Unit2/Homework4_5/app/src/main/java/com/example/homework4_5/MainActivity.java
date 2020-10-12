package com.example.homework4_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();
    }

    public void initRecycler(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<DataShop> arrayList = new ArrayList<>();
        arrayList.add(new DataShop("Samsung a71", getString(R.string.decribe_samsung)));
        arrayList.add(new DataShop("Iphone XR", getString(R.string.decribe_ip)));
        arrayList.add(new DataShop("Bphone B86s", getString(R.string.decribe_bp)));


        ShopAdapter shopAdapter = new ShopAdapter(arrayList, recyclerView.getContext());

        recyclerView.setAdapter(shopAdapter);
    }
}
package com.example.homework4_5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder>{
    ArrayList<DataShop> arrayList;
    Context context;

    public static final String EXTRA_IPHONE = "com.example.homework4_5.EXTRA.IPHONE";
    public static final String EXTRA_BPHONE = "com.example.homework4_5.EXTRA.BPHONE";
    public static final String EXTRA_SAMSUNG = "com.example.homework4_5.EXTRA.SAMSUNG";

    public ShopAdapter(ArrayList<DataShop> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Tao 1 layout
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_decribe, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(arrayList.get(position).getName());
        holder.txtdescribe.setText(arrayList.get(position).getDescribe());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName, txtdescribe;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.name);
            txtdescribe = (TextView) itemView.findViewById(R.id.decribe);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                    Intent intent;
/*//                    Toast.makeText(view.getContext(), "" + itemPosition, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, Iphone.class);
                    intent.putExtra(EXTRA_IPHONE, "Iphone");
                    context.startActivity(intent);*/
                    switch (itemPosition){
                        case 0:
                            intent = new Intent(context, Samsung.class);
                            intent.putExtra(EXTRA_SAMSUNG, "samsung");
                            context.startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(context, Iphone.class);
                            intent.putExtra(EXTRA_IPHONE, "Iphone");
                            context.startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(context, Bphone.class);
                            intent.putExtra(EXTRA_BPHONE, "bphone");
                            context.startActivity(intent);
                            break;
                    }
                }
            });
        }

    }
}

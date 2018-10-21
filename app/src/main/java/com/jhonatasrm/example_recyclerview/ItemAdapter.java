package com.jhonatasrm.example_recyclerview;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    List<Item> items = new ArrayList<>();
    private Context context;

    public ItemAdapter(Context context){
        this.context = context;

        for(int i = 0; i <= 100; i++){
            Item item = new Item(i + 1, "Item " + (i + 1));
            items.add( item );
        }
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =  LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, viewGroup, false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        Item item = items.get(i);
        itemHolder.txtId.setText(String.valueOf(item.getId()));
        itemHolder.txtName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // Class Item Holder
    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtId;
        public TextView txtName;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            txtId = itemView.findViewById(android.R.id.text2);
            txtName = itemView.findViewById(android.R.id.text1);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            items.remove(position);
            String itemName = String.valueOf(items.get(position));
            String msg = String.format("Item %s removed", itemName);
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            notifyItemRemoved(position);
        }
    }
}

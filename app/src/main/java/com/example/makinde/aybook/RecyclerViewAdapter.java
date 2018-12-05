package com.example.makinde.aybook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.example.makinde.aybook.Database.ItemObject;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders>{
    RecyclerViewHolders rcv;
    private List<ItemObject> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;

    }


    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        rcv = new RecyclerViewHolders(layoutView);rcv.getAllItem(itemList);
        rcv.setContext(context);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.name.setText("Name: " + itemList.get(position).getName());
        holder.email.setText(" " + itemList.get(position).getEmail());
        holder.phone.setText(" " + itemList.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    private void deleteItem(int position) {
        itemList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, itemList.size());
        rcv.itemView.setVisibility(View.GONE);
    }




}
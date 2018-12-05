package com.example.makinde.aybook;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewHolders extends RecyclerView.ViewHolder
        implements View.OnClickListener  {

    public TextView name;
    public TextView email;
    public TextView phone;
    private List<ItemObject> itemList;
    private Context context;
    ContactDbAdapter contactDbAdapter;
 //   RecyclerViewAdapter a;

    private ItemObject selectedItem;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        name = (TextView) itemView.findViewById(R.id.name);
        email = (TextView) itemView.findViewById(R.id.email);
        phone = (TextView) itemView.findViewById(R.id.phone);

    }

    @Override
    public void onClick(View view) {
        selectedItem = itemList.get(getAdapterPosition());
        if (selectedItem.get(false)) {
            selectedItem.delete(getAdapterPosition());
            view.setSelected(false);
        } else {
            selectedItem.put(getAdapterPosition(), true);
          //  Toast.makeText(view.getContext(), String.valueOf(selectedItem.getPhone()), Toast.LENGTH_SHORT).show();
            contactDbAdapter = new ContactDbAdapter(this.context);
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(context);
            }
            builder.setTitle("Delete entry")
                    .setMessage("Are you sure you want to delete this contact")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {


                            // Create an Intent for the activity you want to start
                         //   Intent resultIntent = new Intent(this, MainActivity.class);
// Create the TaskStackBuilder and add the intent, which inflates the back stack
                           // TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
                            //stackBuilder.addNextIntentWithParentStack(resultIntent);
// Get the PendingIntent containing the entire back stack
                            //PendingIntent resultPendingIntent =
                            //delete(getAdapterPosition());
                            //      stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                            // continue with delete
                      //     RecyclerViewHolders.this.notify();
                            contactDbAdapter.deleteContact(selectedItem.getPhone());

                          //  RecyclerViewHolders(View itemView);
                            Activity activity = (Activity) context;

                            Intent myIntent = new Intent(context, activity.getClass());
                            context.startActivity(myIntent);
                          //  itemList.remove(getAdapterPosition());
                          //  a.getItemCount();
                          //  a.notifyItemRangeChanged(getAdapterPosition(),itemList.size());
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

            // der(position);
            //contactDbAdapter.deleteContact(itemList.get(position).getPhone());
            //view.setSelected(false);

            view.setSelected(false);
            //  onBindiewHolder(position);
        }
    }

    public void getAllItem(List<ItemObject> items) {
        itemList = items;
    }
    public void setContext(Context context) {
        this.context=context;
    }

    public void onBindiewHolder(int position) {
        String s = itemList.get(position).getPhone();


    }





}

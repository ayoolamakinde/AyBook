package com.example.makinde.aybook;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
//import com.example.makinde.aybook.Database.ItemObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class show extends AppCompatActivity {


    private final String TAG = "show";
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerViewAdapter adapter;

    // contactDbAdapter.open();

 //   Cursor equipmentCursor = contactDbAdapter.getContact();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);



        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        layoutManager = new LinearLayoutManager(show.this);
        recyclerView.setLayoutManager(layoutManager);
        ContactDbAdapter contactDbAdapter = new ContactDbAdapter(this);
        contactDbAdapter.open();
        Cursor equipmentCursor = contactDbAdapter.getContact();
        //StringBuilder results = new StringBuilder();
        List<ItemObject> results  = new ArrayList<ItemObject>();
        //ArrayList<String> = new ArrayList<String>();
        if(equipmentCursor.moveToFirst()){
            do{
                Contact cont = contactDbAdapter.getContactFromCursor(equipmentCursor);
                results.add(new ItemObject(cont.First_Name+" "+cont.Last_Name, cont.Email, cont.Phn_Number));
               // results.add(cont.First_Name);
              //  results.add(cont.Last_Name);
              //  results.add(cont.Email);
              //  results.add(cont.Phn_Number);
            }while(equipmentCursor.moveToNext());
        }
        equipmentCursor.close();
        contactDbAdapter.close();


      // items=results;

        adapter = new RecyclerViewAdapter(show.this,results);
       // adapter.setClickListener(this);

        recyclerView.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_app, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        //respond to menu item selection

        switch (item.getItemId()) {
            case R.id.add:
                startActivity(new Intent(this, add.class));
                return true;
            case R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.show:
                startActivity(new Intent(this, show.class));
                return true;
            case R.id.search:
                startActivity(new Intent(this, searchcontact.class));
                return true;
            case R.id.exit:
                System.exit(0);finish();
                moveTaskToBack(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


   /* private List<ItemObject> returnListItems(){
     //   ContactDbAdapter contactDbAdapter = new ContactDbAdapter(this);
       // contactDbAdapter.open();
        //Cursor equipmentCursor = contactDbAdapter.getContact();
        //Contact cont = contactDbAdapter.getContactFromCursor(equipmentCursor);
        List<ItemObject> items = new ArrayList<ItemObject>();
        items.add(new ItemObject("aYOOLA", "MAN", "GOAT"));
       // items.add(new ItemObject(cont.First_Name+" "+cont.Last_Name, cont.Email, cont.Phn_Number));


        return items;
    }*/
}

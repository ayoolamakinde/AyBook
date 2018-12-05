package com.example.makinde.aybook;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class searchcontact extends AppCompatActivity {

    private final String TAG = "show";
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerViewAdapter adapter;


    //EditText text = (EditText) findViewById(R.id.your_text);
//text.setText("Display this text");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);


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
                finish();
                moveTaskToBack(true);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void addUp(View v) {
        if (!validateForm()) {
            return;
        }
        EditText search1 = (EditText) findViewById(R.id.search_term);
        ImageView a = (ImageView) findViewById(R.id.awa);
        ImageView aa = (ImageView) findViewById(R.id.awa2);
        RecyclerView aaa = (RecyclerView) findViewById(R.id.recycler_view);
        a.setVisibility(View.GONE);
        String search_text = search1.getText().toString().toUpperCase();


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        layoutManager = new LinearLayoutManager(searchcontact.this);
        recyclerView.setLayoutManager(layoutManager);
        ContactDbAdapter contactDbAdapter = new ContactDbAdapter(this);
        contactDbAdapter.open();

        String e = "0";
        if(contactDbAdapter.Exists3(search_text)) {
            e = "1";


            Cursor equipmentCursor = contactDbAdapter.getData3(search_text);
           if (e.equals("1")) {
                //StringBuilder results = new StringBuilder();
                List<ItemObject> results = new ArrayList<ItemObject>();
                //ArrayList<String> = new ArrayList<String>();
                if (equipmentCursor.moveToFirst()) {
                    do {
                        Contact cont = contactDbAdapter.getContactFromCursor(equipmentCursor);
                        results.add(new ItemObject(cont.First_Name + " " + cont.Last_Name, cont.Email, cont.Phn_Number));
                        // results.add(cont.First_Name);
                        //  results.add(cont.Last_Name);
                        //  results.add(cont.Email);
                        //  results.add(cont.Phn_Number);
                    } while (equipmentCursor.moveToNext());
                }
                equipmentCursor.close();
                contactDbAdapter.close();


                // items=results;

                adapter = new RecyclerViewAdapter(searchcontact.this, results);
                recyclerView.setAdapter(adapter);

            } }
            else if (contactDbAdapter.Exists(search_text)) {
                e = "1";
                Cursor equipmentCursor = contactDbAdapter.getData1(search_text);
                if (e.equals("1")) {
                    //StringBuilder results = new StringBuilder();
                    List<ItemObject> results = new ArrayList<ItemObject>();
                    //ArrayList<String> = new ArrayList<String>();
                    if (equipmentCursor.moveToFirst()) {
                        do {
                            Contact cont = contactDbAdapter.getContactFromCursor(equipmentCursor);
                            results.add(new ItemObject(cont.First_Name + " " + cont.Last_Name, cont.Email, cont.Phn_Number));
                            // results.add(cont.First_Name);
                            //  results.add(cont.Last_Name);
                            //  results.add(cont.Email);
                            //  results.add(cont.Phn_Number);
                        } while (equipmentCursor.moveToNext());
                    }
                    equipmentCursor.close();
                    contactDbAdapter.close();


                    // items=results;

                    adapter = new RecyclerViewAdapter(searchcontact.this, results);
                    recyclerView.setAdapter(adapter);
                }
            } else if (contactDbAdapter.Exists2(search_text)) {
                e = "1";
                Cursor equipmentCursor = contactDbAdapter.getData2(search_text);
                if (e.equals("1")) {
                    //StringBuilder results = new StringBuilder();
                    List<ItemObject> results = new ArrayList<ItemObject>();
                    //ArrayList<String> = new ArrayList<String>();
                    if (equipmentCursor.moveToFirst()) {
                        do {
                            Contact cont = contactDbAdapter.getContactFromCursor(equipmentCursor);
                            results.add(new ItemObject(cont.First_Name + " " + cont.Last_Name, cont.Email, cont.Phn_Number));
                            // results.add(cont.First_Name);
                            //  results.add(cont.Last_Name);
                            //  results.add(cont.Email);
                            //  results.add(cont.Phn_Number);
                        } while (equipmentCursor.moveToNext());
                    }
                    equipmentCursor.close();
                    contactDbAdapter.close();


                    // items=results;

                    adapter = new RecyclerViewAdapter(searchcontact.this, results);
                    recyclerView.setAdapter(adapter);
                }
            } else if (contactDbAdapter.Exists4(search_text)) {
                e = "1";
                Cursor equipmentCursor = contactDbAdapter.getData4(search_text);
                if (e.equals("1")) {
                    //StringBuilder results = new StringBuilder();
                    List<ItemObject> results = new ArrayList<ItemObject>();
                    //ArrayList<String> = new ArrayList<String>();
                    if (equipmentCursor.moveToFirst()) {
                        do {
                            Contact cont = contactDbAdapter.getContactFromCursor(equipmentCursor);
                            results.add(new ItemObject(cont.First_Name + " " + cont.Last_Name, cont.Email, cont.Phn_Number));
                            // results.add(cont.First_Name);
                            //  results.add(cont.Last_Name);
                            //  results.add(cont.Email);
                            //  results.add(cont.Phn_Number);
                        } while (equipmentCursor.moveToNext());
                    }
                    equipmentCursor.close();
                    contactDbAdapter.close();


                    // items=results;

                    adapter = new RecyclerViewAdapter(searchcontact.this, results);
                    recyclerView.setAdapter(adapter);
                }
            } else {
                Toast.makeText(getApplicationContext(), "No matching record found",
                        Toast.LENGTH_SHORT).show();

            }

        }

        //final String fullname = mFullnameField.getText().toString();




    private boolean validateForm() {
        boolean valid = true;
        EditText search1 = (EditText) findViewById(R.id.search_term);
        String search_text = search1.getText().toString();

        //String phone1 = email1.getText().toString();
        if (TextUtils.isEmpty(search_text)) {
            search1.setError("Required.");
            Toast.makeText(searchcontact.this, "Search box empty ",
                    Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            search1.setError(null);
        }


        return valid;
    }
}


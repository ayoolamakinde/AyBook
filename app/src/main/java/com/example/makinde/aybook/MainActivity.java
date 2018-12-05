package com.example.makinde.aybook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view){
        Intent startIntent = new Intent(this ,add.class);
        startActivity(startIntent);
    }
    public void show(View view){
        Intent startIntent = new Intent(this ,show.class);
        startActivity(startIntent);
    }
    public void search(View view){
        Intent startIntent = new Intent(this ,searchcontact.class);
        startActivity(startIntent);
    }
    public void exit(View view){
        finish();
        moveTaskToBack(true);
    }

}

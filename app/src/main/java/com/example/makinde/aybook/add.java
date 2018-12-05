package com.example.makinde.aybook;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.makinde.aybook.Database.DBHelper;

public class add extends AppCompatActivity {

   // DBHelper mydb;
    //FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getContext());
//text.setText("Display this text");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }


    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_app, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        //respond to menu item selection
      //  mydb = new DBHelper(this);

        switch (item.getItemId()) {
            case R.id.add:
                //todo close the drawer;
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
   public void addUp(){
        if (!validateForm()) {
            return;
        }
       EditText first = (EditText) findViewById(R.id.first);
       EditText last = (EditText) findViewById(R.id.last);
       EditText email = (EditText) findViewById(R.id.email);
       EditText phone = (EditText) findViewById(R.id.phone);
        String email1 = email.getText().toString().toUpperCase();
        String first1 = first.getText().toString().toUpperCase();
        String last1 = last.getText().toString().toUpperCase();
        String phone1 = phone.getText().toString();

       ContactDbAdapter contactDbAdapter = new ContactDbAdapter(this);
       contactDbAdapter.open();
       ContentValues newValues = new ContentValues();
       newValues.put(ContactDbAdapter.FIRST_NAME, first1);
       newValues.put(ContactDbAdapter.LAST_NAME, last1);
       newValues.put(ContactDbAdapter.EMAIL, email1);
       newValues.put(ContactDbAdapter.PHONE_NUMBER_ROWID, phone1);
       newValues.put(ContactDbAdapter.AVAILABLE, 1);



       if(contactDbAdapter.Exists(phone1))
       {
           Toast.makeText(getApplicationContext(), "Contact Already Exists",
                   Toast.LENGTH_SHORT).show();
       }
       else {

           long track = contactDbAdapter.insertContact(newValues);

           Toast.makeText(getApplicationContext(), "Contact Added Successfully",
                   Toast.LENGTH_SHORT).show();
           email.setText("");
           first.setText("");
           last.setText("");
           phone.setText("");
       }
     /*  if(mydb.insertContact(first1,last1,email1,phone1)){

       } else{
           Toast.makeText(getApplicationContext(), "not done",
                   Toast.LENGTH_SHORT).show();
       }
*/
     //  mydb.insertContact(first1,last1,email1,phone1);
       //Toast.makeText(getApplicationContext(), "Contacted Added Successfully",
         //      Toast.LENGTH_SHORT).show();


       //final String fullname = mFullnameField.getText().toString();
   }

   public void clicked(View view)
   {
       addUp();
   }

    private boolean validateForm() {
        boolean valid = true;
        EditText first = (EditText) findViewById(R.id.first);
        EditText last = (EditText) findViewById(R.id.last);
        EditText email = (EditText) findViewById(R.id.email);
        EditText phone = (EditText) findViewById(R.id.phone);
        String email1 = email.getText().toString();
        String first1 = first.getText().toString();
        String last1 = last.getText().toString();
        String phone1 = phone.getText().toString();
        if (TextUtils.isEmpty(email1) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            email.setError("Required.");
            Toast.makeText(add.this, "Invalid email address ",
                    Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            email.setError(null);
        }

        if (TextUtils.isEmpty(first1)) {
            first.setError("Required.");
            Toast.makeText(add.this, "Enter First Name ",
                    Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            first.setError(null);
        }

        if (TextUtils.isEmpty(last1)) {
            last.setError("Required.");
            Toast.makeText(add.this, "Enter Last Name ",
                    Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            last.setError(null);
        }

        if (TextUtils.isEmpty(phone1)) {
            phone.setError("Required.");
            Toast.makeText(add.this, "Enter Phone Number",
                    Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            phone.setError(null);
        }



        return valid;
    }



}

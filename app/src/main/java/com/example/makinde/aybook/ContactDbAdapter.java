package com.example.makinde.aybook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDbAdapter {

    private static final String DATABASE_NAME = "CONTACT_DATABASE.db";
    private static final String CONTACT_LIST_TABLE = "CONTACT_LIST_TABLE";
    private static final int DATABASE_VERSION = 200;
    private final Context Ctx;

    public static String TAG = ContactDbAdapter.class.getSimpleName();

    private DatabaseHelper DbHelper;
    SQLiteDatabase Db;


    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "Email";
    public static final String PHONE_NUMBER_ROWID="PhoneNumber";
    public static final String AVAILABLE="available";


    public static final String[] CONTACT_FIELDS = new String[]{
            FIRST_NAME,
            LAST_NAME,
            EMAIL,
            PHONE_NUMBER_ROWID,
            AVAILABLE
    };

    private static final String CREATE_TABLE_CONTACT_LIST =
            "create table " + CONTACT_LIST_TABLE +"("
                    + FIRST_NAME + " text not null,"
                    + LAST_NAME + " text not null,"
                    + EMAIL + " text not null UNIQUE,"
                    + PHONE_NUMBER_ROWID + " text PRIMARY KEY,"
                    + AVAILABLE + " INTEGER"
                    +");";

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_CONTACT_LIST);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy old data");
            db.execSQL("DROP TABLE IF EXISTS" + CONTACT_LIST_TABLE);
            onCreate(db);
        }
    }

    public ContactDbAdapter(Context ctx){
        this.Ctx = ctx;
        //super(ctx,DATABASE_NAME, null, 1);
    }

    public ContactDbAdapter open() throws SQLException {
        DbHelper = new DatabaseHelper(Ctx);
        Db = DbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        if(DbHelper!=null){
            DbHelper.close();
        }
    }

    public void upgrade() throws SQLException{
        DbHelper = new DatabaseHelper(Ctx);
        Db = DbHelper.getWritableDatabase();
        DbHelper.onUpgrade(Db, 1, 0);
    }

    public long insertContact(ContentValues initialValues){
        return Db.insertWithOnConflict(CONTACT_LIST_TABLE, null, initialValues, SQLiteDatabase.CONFLICT_IGNORE);
    }

    public boolean updateContact(int id, ContentValues newValues){
        String[] selectionArgs = {String.valueOf(id)};
        return Db.update(CONTACT_LIST_TABLE, newValues, PHONE_NUMBER_ROWID + "=?", selectionArgs) >0;
    }


    public boolean deleteContact(String id){
        open();
        String[] selectionArgs = {id};
       return Db.delete(CONTACT_LIST_TABLE, PHONE_NUMBER_ROWID + "=?", selectionArgs)>0;
     // String sql =" DELETE FROM "+ CONTACT_LIST_TABLE+ "WHERE " +PHONE_NUMBER_ROWID + "IN "("SELECT " +PHONE_NUMBER_ROWID + " FROM " + CONTACT_LIST_TABLE + " WHERE " + PHONE_NUMBER_ROWID + "LIKE '"+ id + '%'");
      //  String sql = "SELECT * FROM " + CONTACT_LIST_TABLE + " WHERE " + FIRST_NAME + " LIKE '" + id + "%'";

    }


    public Cursor getContact(){
        return Db.query(CONTACT_LIST_TABLE, CONTACT_FIELDS,null, null, null, null, FIRST_NAME);
    }

    public static Contact getContactFromCursor(Cursor cursor){
        Contact contact = new Contact();

        contact.First_Name = cursor.getString(cursor.getColumnIndex(FIRST_NAME));
        contact.Last_Name = cursor.getString(cursor.getColumnIndex(LAST_NAME));
        contact.Email = cursor.getString(cursor.getColumnIndex(EMAIL));
        contact.Phn_Number= cursor.getString(cursor.getColumnIndex(PHONE_NUMBER_ROWID));
        contact.IsAvailable = (cursor.getInt(cursor.getColumnIndex(AVAILABLE)) == 1);

        return(contact);
    }


    public boolean Exists(String searchItem) {
        String[] columns = { PHONE_NUMBER_ROWID };
        String selection = PHONE_NUMBER_ROWID + " =?";
        String[] selectionArgs = { searchItem };
        String limit = "1";

        Cursor cursor = Db.query(CONTACT_LIST_TABLE , columns, selection, selectionArgs, null, null, null, limit);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;


    }

    public boolean Exists2(String searchItem) {
        String[] columns = { PHONE_NUMBER_ROWID };
        String selection = FIRST_NAME + " =?";
        String[] selectionArgs = { searchItem };
        String limit = "1";

        Cursor cursor = Db.query(CONTACT_LIST_TABLE , columns, selection, selectionArgs, null, null, null, limit);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;


    }

    public boolean Exists3(String searchItem) {
        String[] columns = { LAST_NAME };
        String selection = LAST_NAME + " =?";
        String[] selectionArgs = { searchItem };
        String limit = "1";

        Cursor cursor = Db.query(CONTACT_LIST_TABLE , columns, selection, selectionArgs, null, null, null, limit);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;


    }

    public boolean Exists4(String searchItem) {
        String[] columns = { EMAIL };
        String selection = EMAIL + " =?";
        String[] selectionArgs = { searchItem };
        String limit = "1";

        Cursor cursor = Db.query(CONTACT_LIST_TABLE , columns, selection, selectionArgs, null, null, null, limit );
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;


    }



    public Cursor getData1(String id) {

        /*return Db.query(CONTACT_LIST_TABLE, // Table name
                CONTACT_FIELDS, // String[] containing your column names
                PHONE_NUMBER_ROWID+" = "+id, // your where statement, you do not include the WHERE or the FROM DATABASE_TABLE parts of the query,
                null,
                null,
                null,
                null
        );*/

        String sql = "SELECT * FROM " + CONTACT_LIST_TABLE + " WHERE " + PHONE_NUMBER_ROWID + " LIKE '" + id + "%'";
        Cursor cursor = Db.rawQuery(sql, null);
        return cursor;

    }
    public Cursor getData2(String id) {


        String sql = "SELECT * FROM " + CONTACT_LIST_TABLE + " WHERE " + FIRST_NAME + " LIKE '" + id + "%'";
        Cursor cursor = Db.rawQuery(sql, null);
        return cursor;
    }
    public Cursor getData3(String ida) {

       /* return Db.query(CONTACT_LIST_TABLE, // Table name
                CONTACT_FIELDS, // String[] containing your column names
                LAST_NAME+"="+ida, // your where statement, you do not include the WHERE or the FROM DATABASE_TABLE parts of the query,
                null,
                null,
                null,
                null
        );*/

        String sql = "SELECT * FROM " + CONTACT_LIST_TABLE + " WHERE " + LAST_NAME + " LIKE '" + ida + "%'" +"COLLATE NOCASE";
        Cursor cursor = Db.rawQuery(sql, null);
        return cursor;


    }
    public Cursor getData4(String id) {


        String sql = "SELECT * FROM " + CONTACT_LIST_TABLE + " WHERE " + EMAIL + " LIKE '" + id + "%'";
        Cursor cursor = Db.rawQuery(sql, null);
        return cursor;


    }
    public Cursor getData(String id) {

        return  Db.rawQuery( "select * from CONTACT_LIST_TABLE where id="+id+"", null );


    }




}

package com.example.sqlitetutor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "create table " +
            ContactContract.ContactEntry.TABLE_NAME + "(" +
            ContactContract.ContactEntry.CONTACT_NO + " number," +
            ContactContract.ContactEntry.NAME + " text," +
            ContactContract.ContactEntry.EMAIL +" text);";// Create Table Query

    public static final String DROP_TABLE = "drop table if exists "+
            ContactContract.ContactEntry.TABLE_NAME;

    public ContactDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("Database Operation","Database created...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Database Operation",ContactContract.ContactEntry.TABLE_NAME+" created...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addContact(int id, String name, String email, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.CONTACT_NO,id);
        contentValues.put(ContactContract.ContactEntry.NAME,name);
        contentValues.put(ContactContract.ContactEntry.EMAIL,email);
        db.insert(ContactContract.ContactEntry.TABLE_NAME,null,contentValues);
        Log.d("Database Operation","Row inserted....");
    }

    public Cursor readContact(SQLiteDatabase db){
        String[] projections = {
                ContactContract.ContactEntry.CONTACT_NO,
                ContactContract.ContactEntry.NAME,
                ContactContract.ContactEntry.EMAIL
        };
        Cursor cursor = db.query(
                ContactContract.ContactEntry.TABLE_NAME,
                projections,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    public void updateContact(int id,String name,String email,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.NAME,name);
        contentValues.put(ContactContract.ContactEntry.EMAIL,email);
        String selection = ContactContract.ContactEntry.CONTACT_NO + " = " + id;
        db.update(ContactContract.ContactEntry.TABLE_NAME,contentValues,selection,null);
    }

    public void deleteContact(int id,SQLiteDatabase db){
        String selection = ContactContract.ContactEntry.CONTACT_NO + " = " +id;
        db.delete(ContactContract.ContactEntry.TABLE_NAME,selection,null);
    }

}

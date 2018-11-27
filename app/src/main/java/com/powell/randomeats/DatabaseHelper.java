package com.powell.randomeats;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "People.db";
    public static final String TABLE_NAME = "user";
    public static final String COL1 = "email";
    public static final String COL2 = "password";
    public static final String COL3 = "first_name";
    public static final String COL4 = "last_name";
    public static final String COL5 = "birthday";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2); //The 2 instead of 1 is to change the version
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                COL1 + " TEXT PRIMARY KEY," +
                COL2 + " TEXT," +
                COL3 + " TEXT," +
                COL4 + " TEXT," +
                COL5 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    /*Inserting into database*/

    public boolean add(String email, String password, String fname, String lname, String birthday) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(); //helps write values to database
        contentValues.put(COL1, email);
        contentValues.put(COL2, password);
        contentValues.put(COL3, fname);
        contentValues.put(COL4, lname);
        contentValues.put(COL5, birthday);
        long ins = db.insert(TABLE_NAME, null, contentValues);

        if (ins == -1) return false;
        else return true;
    }

    /*checking if email exist*/
    public Boolean chkemail(String email) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from " + TABLE_NAME + " where email = ?", new String[]{email});
        if (cursor.getCount() > 0) return false;
        else return true;
         // "SELECT*FROM" + TABLE
    }
        //checking the email and paasword
    public Boolean emailpassword(String email, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from " + TABLE_NAME + " where email = ? and password=?", new String[]{email, password});
        if(cursor.getCount()>0) return true;
        else return false;
    }
}
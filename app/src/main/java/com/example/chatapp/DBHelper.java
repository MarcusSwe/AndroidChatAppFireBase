package com.example.chatapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "savedMessages.db";

    public static final String TABLE_NAME = "message_table";
    public static final String COLUMN_NAME_VALUE_CONTENT = "messages";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createQuery = " CREATE TABLE "
                    + TABLE_NAME +
                " ( value_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME_VALUE_CONTENT + " TEXT);";

        db.execSQL(createQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addValue(String savedmessage) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME_VALUE_CONTENT,savedmessage);

        long value_id = db.insert(TABLE_NAME, null, contentValues);

        if(value_id==-1){
            return false;
        } else{
            return true;
        }
    }


    public void wholeTable(){

        SQLiteDatabase db = this.getWritableDatabase();

        String selectALL = "SELECT * FROM " +TABLE_NAME;

        Cursor cursor = db.rawQuery(selectALL, null);

        if (cursor.moveToNext()) {

            while(cursor.moveToNext()) {
                int value_id = cursor.getInt(0);
                String messages = cursor.getString(1);

                Log.d("firebase3", messages);

            }
        }

        cursor.close();
        db.close();

    }


}

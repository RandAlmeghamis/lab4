package com.example.lab4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String ID = "ID";
    public static final String CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String CUSTOMER_AGE = "CUSTOMER_AGE";
    public static final String ACTIVE_CUSTOMER = "ACTIVE_CUSTOMER";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "Customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      String createTableStatement= "CREATE TABLE " + CUSTOMER_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + CUSTOMER_NAME + " TEXT, " + CUSTOMER_AGE + " INTEGER, " + ACTIVE_CUSTOMER + " BOOLEAN )";
    sqLiteDatabase.execSQL(createTableStatement);
    }

    public boolean addOne(customerModel cm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ID, cm.getID());
        cv.put(CUSTOMER_NAME, cm.getName());
        cv.put(CUSTOMER_AGE, cm.getAge());
        cv.put(ACTIVE_CUSTOMER, cm.isActive());


        long insert = db.insert(CUSTOMER_TABLE, null,cv);
        if(insert == -1){
            return false;
        }
        else {
            return true;
        }
    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

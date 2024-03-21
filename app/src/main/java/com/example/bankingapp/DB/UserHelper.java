package com.example.bankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserContract.UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + UserContract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserContract.UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Ajay Kumar', 'ajay9696@gmail.com','4672','8400097493', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Rishabh', 'rishabh0321@gmail.com','7252','9670348649', 35000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Harshit', 'harshit@recbanda.ac.in','8896','9305014431', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Akash', 'akash@gmail.com','7752','8795452849', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Pratyush', 'pratyush@gmail.com','4522','7885021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Kuldeep', 'kuldeep@gmail.com','3669','9798654623', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Ritik', 'ritik@gmail.com','9985','9339319431', 25000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Krishna', 'krishna@gmail.com','1207','6395640215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Ashmit', 'ashmit@gmail.com','6582','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Bhaskar', 'bhaskar123@gmail.com','5450','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Manish', 'manish@gmail.com','2656','7015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Rishi', 'rishi@gmail.com','1203','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Sangam', 'sangam@gmail.com','5566','7019541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Ashish', 'ashish@gmail.com','2236','6354642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Ashutosh Pandey', 'ashutosh_panndey@gmail.com','6692','9693641266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserContract.UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserContract.UserEntry.TABLE_NAME + " where " +
                UserContract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserContract.UserEntry.TABLE_NAME + " set " + UserContract.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserContract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
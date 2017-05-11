package com.roksagmail.bd_lab4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vovat on 11.05.2017.
 */

public class RecordsHelper extends SQLiteOpenHelper {
    public RecordsHelper(Context context) {
        super(context, Contact.DATABASE_NAME, null, Contact.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Contact.TABLE_RECORDS.TABLE_NAME+" ("
                + Contact.TABLE_RECORDS.ID+" integer primary key autoincrement,"
                + Contact.TABLE_RECORDS.DATE+" text,"
                + Contact.TABLE_RECORDS.NAME+" text,"
                + Contact.TABLE_RECORDS.RECORD+" INTEGER" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

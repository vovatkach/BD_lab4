package com.roksagmail.bd_lab4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vovat on 11.05.2017.
 */

public class DBWorker {
    private RecordsHelper helper;
    private Context context;
    public DBWorker(Context context)
    {
        this.context=context;
        helper=new RecordsHelper(context);
    }
    public void close()
    {
        helper.close();
    }
    //----------------------------------------
    public List<ModelRecord> getRecords()
    {
        ArrayList<ModelRecord> records=new ArrayList<>();
        SQLiteDatabase database=helper.getReadableDatabase();
        Cursor cursor=database.query(Contact.TABLE_RECORDS.TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst())
        {
            int idColIndex=cursor.getColumnIndex(Contact.TABLE_RECORDS.ID);
            int dateColIndex=cursor.getColumnIndex(Contact.TABLE_RECORDS.DATE);
            int nameColIndex=cursor.getColumnIndex(Contact.TABLE_RECORDS.NAME);
            int recordColIndex=cursor.getColumnIndex(Contact.TABLE_RECORDS.RECORD);
            do {
                records.add(new ModelRecord(cursor.getString(dateColIndex),cursor.getString(nameColIndex),cursor.getInt(recordColIndex)));

            }while (cursor.moveToNext());
        }
        database.close();
        return records;
    }
    //-----------------------------------------------
    public void addRecord(ModelRecord record)
    {
        SQLiteDatabase database=helper.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Contact.TABLE_RECORDS.DATE,record.getDate());
        contentValues.put(Contact.TABLE_RECORDS.NAME,record.getName());
        contentValues.put(Contact.TABLE_RECORDS.RECORD,record.getRecord());
        database.insert(Contact.TABLE_RECORDS.TABLE_NAME,null,contentValues);
        database.close();
    }
}

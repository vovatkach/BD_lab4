package com.roksagmail.bd_lab4;

/**
 * Created by vovat on 11.05.2017.
 */

public class ModelRecord {
    private String date;
    private String name;
    private int record;
    public ModelRecord(String date,String name,int record)
    {
        this.date=date;
        this.name=name;
        this.record=record;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getRecord() {
        return record;
    }
}

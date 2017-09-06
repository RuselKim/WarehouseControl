package com.example.sus.warehousecontrol.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sus on 06.09.2017.
 */

public class WarehouseDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "warehouse.db";
    private static final int DATABASE_VERSION = 1;


    public WarehouseDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_WAREHOUSE_TABLE = "CREATE TABLE " + BaseContract.WarehouseBase.TABLE_NAME + " ("
                + BaseContract.WarehouseBase._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BaseContract.WarehouseBase.ITEM + " TEXT NOT NULL, "
                + BaseContract.WarehouseBase.COUNT + " INTEGER NOT NULL DEFAULT 0);";

        sqLiteDatabase.execSQL(SQL_CREATE_WAREHOUSE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF IT EXISTS " + BaseContract.WarehouseBase.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


}

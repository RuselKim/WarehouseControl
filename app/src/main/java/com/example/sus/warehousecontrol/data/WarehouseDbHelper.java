package com.example.sus.warehousecontrol.data;

import android.content.Context;
import android.database.Cursor;
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

    public void insertInTable (String name, int count){
        SQLiteDatabase db = getWritableDatabase();

        String insertValues = "INSERT INTO " +
                BaseContract.WarehouseBase.TABLE_NAME
                + " ( " + BaseContract.WarehouseBase.ITEM + ", "
                + BaseContract.WarehouseBase.COUNT + ") VALUES (\""
                + name + "\", " + count + ");";

        db.execSQL(insertValues);
    }

    public void deleteFromTable (long id){
        SQLiteDatabase db = getWritableDatabase();

        String comandSring = "DELETE FROM " +
                BaseContract.WarehouseBase.TABLE_NAME
                + " WHERE " + BaseContract.WarehouseBase._ID + " = "
                + id + ";";

        db.execSQL(comandSring);
    }

    public void updateInTable (int count,long id) {
        SQLiteDatabase db = getWritableDatabase();

        String comandSring = "UPDATE " +
                BaseContract.WarehouseBase.TABLE_NAME
                + " SET " + BaseContract.WarehouseBase.COUNT
                + " = " + count + " WHERE "
                + BaseContract.WarehouseBase._ID + " = " + id + ";";

        db.execSQL(comandSring);
    }

    public Cursor selectFromTable (String value) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT " + value + " FROM "
                + BaseContract.WarehouseBase.TABLE_NAME;
        return db.rawQuery(query,null);
    }
}

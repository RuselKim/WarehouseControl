package com.example.sus.warehousecontrol;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.sus.warehousecontrol.data.BaseContract;
import com.example.sus.warehousecontrol.data.WarehouseDbHelper;

public class ViewActivity extends ListActivity {

    private ListAdapter listAdapter;
    private WarehouseDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listAdapter = new ListAdapter(this, getInfoFromBase(),0);
        setListAdapter(listAdapter);
    }

    private Cursor getInfoFromBase (){
        mDbHelper = new WarehouseDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String query = "SELECT * FROM "
                + BaseContract.WarehouseBase.TABLE_NAME;
        return db.rawQuery(query,null);

    }


}

package com.example.sus.warehousecontrol;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.sus.warehousecontrol.data.WarehouseDbHelper;

public class ViewActivity extends ListActivity {

    private ListAdapter listAdapter;
    private WarehouseDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDbHelper = new WarehouseDbHelper(this);
        listAdapter = new ListAdapter(this, mDbHelper.selectFromTable("*"),0);
        setListAdapter(listAdapter);
    }

}

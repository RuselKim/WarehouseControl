package com.example.sus.warehousecontrol;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sus.warehousecontrol.data.WarehouseDbHelper;

public class ViewActivity extends ListActivity {

    private ListAdapter listAdapter;
    private WarehouseDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDbHelper = new WarehouseDbHelper(this);
        listAdapter = new ListAdapter(this, mDbHelper.selectFromTable("*"), 0);
        setListAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        showPopupMenu(v, id);
    }

    public void showPopupMenu(final View v, final long id) {
        final PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.main_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.menu_editCount:
                        goToEditCountActivity(v);
                        return true;
                    case R.id.menu_delete:
                        deleteFromList(id);
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }

    public void goToEditCountActivity(View v) {
        Intent viewIntent = new Intent(ViewActivity.this, EditCountActivity.class);
        startActivity(viewIntent);
    }

    public void deleteFromList(long id) {
        mDbHelper.deleteFromTable(id);
        listAdapter.changeCursor(mDbHelper.selectFromTable("*"));
        Toast.makeText(this,"Item deleted", Toast.LENGTH_LONG).show();

    }
}

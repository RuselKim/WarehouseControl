package com.example.sus.warehousecontrol;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.sus.warehousecontrol.data.BaseContract;

/**
 * Created by Sus on 07.09.2017.
 */

public class ListAdapter extends CursorAdapter {
    public ListAdapter(Context context, Cursor c, int flags) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_adapter, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView id = (TextView) view.findViewById(R.id.id_column);
        TextView name = (TextView) view.findViewById(R.id.name_column);
        TextView email = (TextView) view.findViewById(R.id.count_column);

        int intId = cursor.getInt(cursor.getColumnIndex(BaseContract.WarehouseBase._ID));
        String strName = cursor.getString(cursor.getColumnIndex(BaseContract.WarehouseBase.ITEM));
        String strCount = cursor.getString(cursor.getColumnIndex(BaseContract.WarehouseBase.COUNT));

        id.setText(String.valueOf(intId));
        name.setText(strName);
        email.setText(strCount);
    }
}

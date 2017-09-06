package com.example.sus.warehousecontrol;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sus.warehousecontrol.data.BaseContract;
import com.example.sus.warehousecontrol.data.WarehouseDbHelper;

public class EditActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    public void addItem (View view) {
        EditText itemNameEditText = (EditText) findViewById(R.id.item_name_view);
        EditText itemCountEditText = (EditText) findViewById(R.id.item_count_view);
        String itemName = itemNameEditText.getText().toString();
        String stringCount = itemCountEditText.getText().toString();
        int itemCount = Integer.parseInt(stringCount);


        WarehouseDbHelper dbHelper = new WarehouseDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String insertValues = "INSERT INTO " +
                        BaseContract.WarehouseBase.TABLE_NAME
                        + " ( " + BaseContract.WarehouseBase.ITEM + ", "
                        + BaseContract.WarehouseBase.COUNT + ") VALUES (\""
                        + itemName + "\", " + itemCount + ");";

        db.execSQL(insertValues);
        showToast("Item added");
        itemNameEditText.setText(null);
        itemCountEditText.setText(null);
    }

    public void showToast (String text) {
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }


}

package com.example.sus.warehousecontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        String itemName, stringCount;

        if  (itemNameEditText.getText().toString().equals("")) {
            showToast("Name is not entered");
            return;
        } else {
            itemName = itemNameEditText.getText().toString();
        }

        if  (itemCountEditText.getText().toString().equals("")) {
            showToast("Count is not entered");
            return;
        } else {
            stringCount = itemCountEditText.getText().toString();
        }

        int itemCount = Integer.parseInt(stringCount);

        WarehouseDbHelper dbHelper = new WarehouseDbHelper(this);
        dbHelper.insertInTable(itemName,itemCount);

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

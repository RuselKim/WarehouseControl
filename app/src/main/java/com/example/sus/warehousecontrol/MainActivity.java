package com.example.sus.warehousecontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onViewClick(View view) {
        Intent viewIntent = new Intent(MainActivity.this, ViewActivity.class);
        startActivity(viewIntent);
    }

    public void onEditClick(View view) {
        Intent viewIntent = new Intent(MainActivity.this, EditActivity.class);
        startActivity(viewIntent);
    }
}

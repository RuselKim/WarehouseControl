package com.example.sus.warehousecontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    LinearLayout mainLayout;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}

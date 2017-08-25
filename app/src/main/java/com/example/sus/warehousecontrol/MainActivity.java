package com.example.sus.warehousecontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    LinearLayout mainLayout;
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.66F);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        etName = (EditText) findViewById(R.id.item_name);

    }

    public void createItem(View view) {

        LinearLayout itemLayout = new LinearLayout(this);
        itemLayout.setLayoutParams(params);
        TextView itemName = new TextView(this);
        itemName.setText(etName.getText().toString());
        itemName.setLayoutParams(params2);
        TextView itemCount = new TextView(this);
        itemCount.setText("" + 0);
        Button btnIncrement = new Button(this);
        btnIncrement.setText("+");
        btnIncrement.setWidth(30);
        btnIncrement.setHeight(30);
        Button btnDecrement = new Button(this);
        btnDecrement.setText("-");
        btnDecrement.setWidth(30);
        btnDecrement.setHeight(30);

        itemLayout.addView(itemName);
        itemLayout.addView(btnDecrement);
        itemLayout.addView(itemCount);
        itemLayout.addView(btnIncrement);
        mainLayout.addView(itemLayout);

    }


}

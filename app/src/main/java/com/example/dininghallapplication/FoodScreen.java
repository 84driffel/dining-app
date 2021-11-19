package com.example.dininghallapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FoodScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_screen);
        String unparsed = getIntent().getStringExtra("food");
        /*if (unparsed == null) {
            //finish();
            //startActivity(getIntent());
        }*/
        //String parsed = foodParser(unparsed);
        TextView foodTextView = (TextView) findViewById(R.id.foodText);
        foodTextView.setText(unparsed);
    }
}
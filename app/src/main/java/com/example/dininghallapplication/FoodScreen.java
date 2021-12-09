package com.example.dininghallapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodScreen extends AppCompatActivity {
    public List<String> section1;
    public List<String> section2;
    public List<String> section3;
    public List<String> section4;
    public List<String> section5;
    public List<String> section6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        section1 = new ArrayList<>();
        section2 = new ArrayList<>();
        section3 = new ArrayList<>();
        section4 = new ArrayList<>();
        section5= new ArrayList<>();
        section6 = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_screen);
        //unparsed = getIntent().getStringArrayListExtra("food");
        section1 = getIntent().getStringArrayListExtra("section1");
        section2 = getIntent().getStringArrayListExtra("section2");
        section3 = getIntent().getStringArrayListExtra("section3");
        section4 = getIntent().getStringArrayListExtra("section4");
        section5 = getIntent().getStringArrayListExtra("section5");
        section6 = getIntent().getStringArrayListExtra("section6");
        /*if (unparsed == null) {
            //finish();
            //startActivity(getIntent());
        }*/
        //String parsed = foodParser(unparsed);
        TextView foodTextView = (TextView) findViewById(R.id.foodText);
        for(int i = 0; i<section1.size(); i++){
            foodTextView.append(section1.get(i));
            foodTextView.append("\n");
        }
        foodTextView.append("-------------------------------------------------------------------");
        foodTextView.append("\n");
        for(int i = 0; i<section2.size(); i++){
            foodTextView.append(section2.get(i));
            foodTextView.append("\n");
        }
        foodTextView.append("-------------------------------------------------------------------");
        foodTextView.append("\n");
        for(int i = 0; i<section3.size(); i++){
            foodTextView.append(section3.get(i));
            foodTextView.append("\n");
        }
        foodTextView.append("-------------------------------------------------------------------");
        foodTextView.append("\n");
        for(int i = 0; i<section4.size(); i++){
            foodTextView.append(section4.get(i));
            foodTextView.append("\n");
        }
        foodTextView.append("-------------------------------------------------------------------");
        foodTextView.append("\n");
        for(int i = 0; i<section5.size(); i++){
            foodTextView.append(section5.get(i));
            foodTextView.append("\n");
        }
        foodTextView.append("-------------------------------------------------------------------");
        foodTextView.append("\n");
        for(int i = 0; i<section6.size(); i++){
            foodTextView.append(section6.get(i));
            foodTextView.append("\n");
        }
    }
}
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
    public List<String> section7;
    public List<String> section8;
    public List<String> section9;
    public List<String> section10;
    public List<String> section11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        section1 = new ArrayList<>();
        section2 = new ArrayList<>();
        section3 = new ArrayList<>();
        section4 = new ArrayList<>();
        section5 = new ArrayList<>();
        section6 = new ArrayList<>();
        section7 = new ArrayList<>();
        section8 = new ArrayList<>();
        section9 = new ArrayList<>();
        section10 = new ArrayList<>();
        section11 = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_screen);
        //unparsed = getIntent().getStringArrayListExtra("food");
        section1 = getIntent().getStringArrayListExtra("section1");
        section2 = getIntent().getStringArrayListExtra("section2");
        section3 = getIntent().getStringArrayListExtra("section3");
        section4 = getIntent().getStringArrayListExtra("section4");
        section5 = getIntent().getStringArrayListExtra("section5");
        section6 = getIntent().getStringArrayListExtra("section6");
        section7 = getIntent().getStringArrayListExtra("section7");
        section8 = getIntent().getStringArrayListExtra("section8");
        section9 = getIntent().getStringArrayListExtra("section9");
        section10 = getIntent().getStringArrayListExtra("section10");
        section11 = getIntent().getStringArrayListExtra("section11");

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
        if(section7.isEmpty() && section8.isEmpty() && section9.isEmpty()){
            System.out.println("hello");
        }
        else{
            foodTextView.append("-------------------------------------------------------------------");
            foodTextView.append("\n");
            for(int i = 0; i<section7.size(); i++){
                foodTextView.append(section7.get(i));
                foodTextView.append("\n");
            }
            foodTextView.append("-------------------------------------------------------------------");
            foodTextView.append("\n");
            for(int i = 0; i<section8.size(); i++){
                foodTextView.append(section8.get(i));
                foodTextView.append("\n");
            }
            foodTextView.append("-------------------------------------------------------------------");
            foodTextView.append("\n");
            for(int i = 0; i<section9.size(); i++){
                foodTextView.append(section9.get(i));
                foodTextView.append("\n");
            }

        }
        if(section10.isEmpty() && section11.isEmpty()){
            System.out.println("hello2");
        }else{
            foodTextView.append("-------------------------------------------------------------------");
            foodTextView.append("\n");
            for(int i = 0; i<section10.size(); i++){
                foodTextView.append(section10.get(i));
                foodTextView.append("\n");
            }
            foodTextView.append("-------------------------------------------------------------------");
            foodTextView.append("\n");
            for(int i = 0; i<section11.size(); i++){
                foodTextView.append(section11.get(i));
                foodTextView.append("\n");
            }
        }

    }
}
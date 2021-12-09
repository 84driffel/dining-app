package com.example.dininghallapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
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
        String a = "<b>" + section1.get(0) + "</b>";
        String b = "<u>" + section1.get(1) + "</u>";
        foodTextView.append(Html.fromHtml(a));
        foodTextView.append("\n");
        foodTextView.append("\n");
        foodTextView.append(Html.fromHtml(b));
        foodTextView.append("\n");
        for(int i = 2; i<section1.size(); i++){
            foodTextView.append(section1.get(i));
            foodTextView.append("\n");
        }

        foodTextView.append("\n");
        String c = "<b>" + section2.get(0) + "</b>";
        String d = "<u>" + section2.get(1) + "</u>";
        foodTextView.append(Html.fromHtml(c));
        foodTextView.append("\n");
        foodTextView.append("\n");
        foodTextView.append(Html.fromHtml(d));
        foodTextView.append("\n");
        for(int i = 2; i<section2.size(); i++){
            foodTextView.append(section2.get(i));
            foodTextView.append("\n");
        }

        foodTextView.append("\n");
        String e = "<b>" + section3.get(0) + "</b>";
        String f = "<u>" + section3.get(1) + "</u>";
        foodTextView.append(Html.fromHtml(e));
        foodTextView.append("\n");
        foodTextView.append("\n");
        foodTextView.append(Html.fromHtml(f));
        foodTextView.append("\n");
        for(int i = 2; i<section3.size(); i++){
            foodTextView.append(section3.get(i));
            foodTextView.append("\n");
        }


        foodTextView.append("\n");
        String g = "<b>" + section4.get(0) + "</b>";
        String h = "<u>" + section4.get(1) + "</u>";
        foodTextView.append(Html.fromHtml(g));
        foodTextView.append("\n");
        foodTextView.append("\n");
        foodTextView.append(Html.fromHtml(h));
        foodTextView.append("\n");
        for(int i = 2; i<section4.size(); i++){
            foodTextView.append(section4.get(i));
            foodTextView.append("\n");
        }
        if(section5.isEmpty()){
            System.out.println("section 5 is empty");
        }else{

            foodTextView.append("\n");
            String j = "<b>" + section5.get(0) + "</b>";
            String k = "<u>" + section5.get(1) + "</u>";
            foodTextView.append(Html.fromHtml(j));
            foodTextView.append("\n");
            foodTextView.append("\n");
            foodTextView.append(Html.fromHtml(k));
            foodTextView.append("\n");
            for(int i = 2; i<section5.size(); i++){
                foodTextView.append(section5.get(i));
                foodTextView.append("\n");
            }
        }
        if(section6.isEmpty()){
            System.out.println("section 6 is empty");
        }else{

            foodTextView.append("\n");
            String l = "<b>" + section6.get(0) + "</b>";
            String m = "<u>" + section6.get(1) + "</u>";
            foodTextView.append(Html.fromHtml(l));
            foodTextView.append("\n");
            foodTextView.append("\n");
            foodTextView.append(Html.fromHtml(m));
            foodTextView.append("\n");
            for(int i = 2; i<section6.size(); i++){
                foodTextView.append(section6.get(i));
                foodTextView.append("\n");
            }
        }
        if(section7.isEmpty()){
            System.out.println("section 7 is empty");
        }
        else{

            foodTextView.append("\n");
            String m = "<b>" + section7.get(0) + "</b>";
            String n = "<u>" + section7.get(1) + "</u>";
            foodTextView.append(Html.fromHtml(m));
            foodTextView.append("\n");
            foodTextView.append("\n");
            foodTextView.append(Html.fromHtml(n));
            foodTextView.append("\n");
            for(int i = 2; i<section7.size(); i++){
                foodTextView.append(section7.get(i));
                foodTextView.append("\n");
            }
        }
        if(section8.isEmpty()){
            System.out.println("section 8 is empty");
        }else{

            foodTextView.append("\n");
            String o = "<b>" + section8.get(0) + "</b>";
            String p = "<u>" + section8.get(1) + "</u>";
            foodTextView.append(Html.fromHtml(o));
            foodTextView.append("\n");
            foodTextView.append("\n");
            foodTextView.append(Html.fromHtml(p));
            foodTextView.append("\n");
            for(int i = 2; i<section8.size(); i++){
                foodTextView.append(section8.get(i));
                foodTextView.append("\n");
            }
        }
        if(section9.isEmpty()){
            System.out.println("section 9 is empty");
        }else{

            foodTextView.append("\n");
            String q = "<b>" + section9.get(0) + "</b>";
            String r = "<u>" + section9.get(1) + "</u>";
            foodTextView.append(Html.fromHtml(q));
            foodTextView.append("\n");
            foodTextView.append("\n");
            foodTextView.append(Html.fromHtml(r));
            foodTextView.append("\n");
            for(int i = 2; i<section9.size(); i++){
                foodTextView.append(section9.get(i));
                foodTextView.append("\n");
            }
        }
        if(section10.isEmpty()){
            System.out.println("section 10 is empty");
        }else{

            foodTextView.append("\n");
            String s = "<b>" + section10.get(0) + "</b>";
            String t = "<u>" + section10.get(1) + "</u>";
            foodTextView.append(Html.fromHtml(s));
            foodTextView.append("\n");
            foodTextView.append("\n");
            foodTextView.append(Html.fromHtml(t));
            foodTextView.append("\n");
            for(int i = 2; i<section10.size(); i++){
                foodTextView.append(section10.get(i));
                foodTextView.append("\n");
            }
        }
        if(section11.isEmpty()){
            System.out.println("section 11 is empty");
        }else{

            foodTextView.append("\n");
            String t = "<b>" + section11.get(0) + "</b>";
            String u = "<u>" + section11.get(1) + "</u>";
            foodTextView.append(Html.fromHtml(t));
            foodTextView.append("\n");
            foodTextView.append("\n");
            foodTextView.append(Html.fromHtml(u));
            foodTextView.append("\n");
            for(int i = 2; i<section11.size(); i++){
                foodTextView.append(section11.get(i));
                foodTextView.append("\n");
            }
        }
        String z = "<b>" + "Allergen and Nutrition Legend" + "</b>";
        foodTextView.append("\n");
        foodTextView.append(Html.fromHtml(z));
        foodTextView.append("\n");
        foodTextView.append("A -> Alcohol");
        foodTextView.append("\n");
        foodTextView.append("E -> Contains Eggs");
        foodTextView.append("\n");
        foodTextView.append("PK -> Contains Pork");
        foodTextView.append("\n");
        foodTextView.append("F -> Contains Fish");
        foodTextView.append("\n");
        foodTextView.append("G -> Contains Gluten");
        foodTextView.append("\n");
        foodTextView.append("M -> Contains Milk");
        foodTextView.append("\n");
        foodTextView.append("P -> Contains Peanuts");
        foodTextView.append("\n");
        foodTextView.append("SF -> Contains Shellfish");
        foodTextView.append("\n");
        foodTextView.append("S -> Contains Soy");
        foodTextView.append("\n");
        foodTextView.append("TN -> Contains Tree Nuts");
        foodTextView.append("\n");
        foodTextView.append("W -> Contains Wheat");
        foodTextView.append("\n");
        foodTextView.append("V -> Item is Vegan");
        foodTextView.append("\n");
        foodTextView.append("VG -> Item is Vegetarian");

    }
}
package com.example.dininghallapplication.ui.home;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dininghallapplication.FoodScreen;
import com.example.dininghallapplication.databinding.FragmentHomeBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import java.io.*;



//HomeFragment = Burge menus
public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private TextView textView;
    private EditText inputText;
    private Button bbutton;
    private Button blbutton;
    private Button bdbutton;
    private Button vote;


    public ArrayList<String> BurgeBreakfastitems;
    public List<String> array1BurgeBreakfast;
    public List<String> array2BurgeBreakfast;
    public List<String> array3BurgeBreakfast;
    public List<String> array4BurgeBreakfast;
    public List<String> array5BurgeBreakfast;
    public List<String> array6BurgeBreakfast;
    public List<Integer> indexofBurgeBreakfast;

    public ArrayList<String> BurgeLunchitems;
    public List<String> array1BurgeLunch;
    public List<String> array2BurgeLunch;
    public List<String> array3BurgeLunch;
    public List<String> array4BurgeLunch;
    public List<String> array5BurgeLunch;
    public List<String> array6BurgeLunch;
    public List<String> array7BurgeLunch;
    public List<String> array8BurgeLunch;
    public List<String> array9BurgeLunch;
    public List<String> array10BurgeLunch;
    public List<String> array11BurgeLunch;
    public List<Integer> indexofBurgeLunch;

    public  ArrayList<String> BurgeDinneritems;
    public  List<String> array1BurgeDinner;
    public  List<String> array2BurgeDinner;
    public  List<String> array3BurgeDinner;
    public  List<String> array4BurgeDinner;
    public  List<String> array5BurgeDinner;
    public  List<String> array6BurgeDinner;
    public  List<String> array7BurgeDinner;
    public  List<String> array8BurgeDinner;
    public  List<String> array9BurgeDinner;
    public  List<Integer> indexofBurgeDinner;

    //function to read Database
    //will print to the console the number of votes for specified item
    public  void voteRead(Editable args) throws Exception {
        URL url = new URL("http://workoutdev.org:5000/vote?item=" + args);
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println("Updated value to: " + inputLine);
        in.close();


    }
    //function to write to the Database
    //will update the vote count by 1 for specified item
    public void voteWrite(Editable a) throws IOException {
        URL website = new URL("http://workoutdev.org:5000/vote");
        URLConnection yc = website.openConnection();
        HttpURLConnection http = (HttpURLConnection) yc;
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        byte[] out = ("{\"name\":\"" + a + "\",\"value\":\"" + 1 + "\"}").getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try (OutputStream os = http.getOutputStream()) {
            os.write(out);
        }
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
        //will create the View for the HomeFragment aka Burge menus
        public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textView = binding.textHome;
        inputText = binding.editTextBurge;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
            //fixed error with thread policy problem
            int SDK_INT = android.os.Build.VERSION.SDK_INT;
            if (SDK_INT > 8) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                        .permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
        new doIT().execute();
        bbutton = binding.btnView;
        //Burge Breakfast menu button
        //When clicked will go to FoodScreen with the menu
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomeFragment.this.getActivity(), FoodScreen.class);
                i.putStringArrayListExtra("section1", new ArrayList<>(array1BurgeBreakfast));
                i.putStringArrayListExtra("section2", new ArrayList<>(array2BurgeBreakfast));
                i.putStringArrayListExtra("section3", new ArrayList<>(array3BurgeBreakfast));
                i.putStringArrayListExtra("section4", new ArrayList<>(array4BurgeBreakfast));
                i.putStringArrayListExtra("section5", new ArrayList<>(array5BurgeBreakfast));
                i.putStringArrayListExtra("section6", new ArrayList<>(array6BurgeBreakfast));
                i.putStringArrayListExtra("section7", new ArrayList<>());
                i.putStringArrayListExtra("section8", new ArrayList<>());
                i.putStringArrayListExtra("section9", new ArrayList<>());
                i.putStringArrayListExtra("section10", new ArrayList<>());
                i.putStringArrayListExtra("section11", new ArrayList<>());
                startActivity(i);

            }
        });
        blbutton = binding.btnView2;
        //Burge Lunch menu button
        //When clicked will go to FoodScreen with the menu
        blbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomeFragment.this.getActivity(), FoodScreen.class);
                i.putStringArrayListExtra("section1", new ArrayList<>(array1BurgeLunch));
                i.putStringArrayListExtra("section2", new ArrayList<>(array2BurgeLunch));
                i.putStringArrayListExtra("section3", new ArrayList<>(array3BurgeLunch));
                i.putStringArrayListExtra("section4", new ArrayList<>(array4BurgeLunch));
                i.putStringArrayListExtra("section5", new ArrayList<>(array5BurgeLunch));
                i.putStringArrayListExtra("section6", new ArrayList<>(array6BurgeLunch));
                i.putStringArrayListExtra("section7", new ArrayList<>(array7BurgeLunch));
                i.putStringArrayListExtra("section8", new ArrayList<>(array8BurgeLunch));
                i.putStringArrayListExtra("section9", new ArrayList<>(array9BurgeLunch));
                i.putStringArrayListExtra("section10", new ArrayList<>(array10BurgeLunch));
                i.putStringArrayListExtra("section11", new ArrayList<>(array11BurgeLunch));
                startActivity(i);

            }
        });
        bdbutton = binding.btnView3;
        //Burge Dinner menu button
        //When clicked will go to FoodScreen with the menu
        bdbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomeFragment.this.getActivity(), FoodScreen.class);
                i.putStringArrayListExtra("section1", new ArrayList<>(array1BurgeDinner));
                i.putStringArrayListExtra("section2", new ArrayList<>(array2BurgeDinner));
                i.putStringArrayListExtra("section3", new ArrayList<>(array3BurgeDinner));
                i.putStringArrayListExtra("section4", new ArrayList<>(array4BurgeDinner));
                i.putStringArrayListExtra("section5", new ArrayList<>(array5BurgeDinner));
                i.putStringArrayListExtra("section6", new ArrayList<>(array6BurgeDinner));
                i.putStringArrayListExtra("section7", new ArrayList<>(array7BurgeDinner));
                i.putStringArrayListExtra("section8", new ArrayList<>(array8BurgeDinner));
                i.putStringArrayListExtra("section9", new ArrayList<>(array9BurgeDinner));
                i.putStringArrayListExtra("section10", new ArrayList<>());
                i.putStringArrayListExtra("section11", new ArrayList<>());
                startActivity(i);

            }
        });
        //Voting for food item (only done for Burge, didn't have time to implement other dinning halls)
        //When clicked will get the input from the user and update the vote count by 1
        //Will output to console the new vote count
        vote = binding.btnView4;
        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    voteWrite(inputText.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Submitted to db");


                try {
                    voteRead(inputText.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                textView.setText("Voted for " + inputText.getText());
                //inputText.setText("");
            }

        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public class doIT extends AsyncTask<Void,Void,Void> {


        //Web Scrape for Burge dinning hall
        //Will parse the div elements into an array by meal
        @Override
        protected Void doInBackground(Void... params) {
            try {
                BurgeBreakfastitems = new ArrayList<>();
                BurgeLunchitems = new ArrayList<>();
                BurgeDinneritems = new ArrayList<>();

                Document document = Jsoup.connect("https://dining.uiowa.edu/burge-market-place").get();

                Element breakfastId = document.getElementById("Breakfast");
                Elements breakfastDivs = breakfastId.getElementsByTag("div");
                Element lunchId = document.getElementById("Lunch");
                Elements lunchDivs = lunchId.getElementsByTag("div");
                Element dinnerId = document.getElementById("Dinner");
                Elements dinnerDivs = dinnerId.getElementsByTag("div");
                for(Element div : breakfastDivs ){
                    if(div.hasClass("panel-heading")){
                        BurgeBreakfastitems.add(div.text());
                    }
                    if(div.hasClass("h5 menu-course-title")) {
                        BurgeBreakfastitems.add(div.text());
                    }
                    if(div.hasClass("menu-item")){
                        BurgeBreakfastitems.add(div.text());
                    }

                }
                for(Element d : lunchDivs ){
                    if(d.hasClass("panel-heading")){
                        BurgeLunchitems.add(d.text());
                    }
                    if(d.hasClass("h5 menu-course-title")) {
                        BurgeLunchitems.add(d.text());
                    }
                    if(d.hasClass("menu-item")){
                        BurgeLunchitems.add(d.text());
                    }

                }
                for(Element div : dinnerDivs ){
                    if(div.hasClass("panel-heading")){
                        BurgeDinneritems.add(div.text());
                    }
                    if(div.hasClass("h5 menu-course-title")) {
                        BurgeDinneritems.add(div.text());
                    }
                    if(div.hasClass("menu-item")){
                        BurgeDinneritems.add(div.text());
                    }

                }
                //removing any empty elements
                while(BurgeDinneritems.remove(""));
                while(BurgeLunchitems.remove(""));
                while(BurgeBreakfastitems.remove(""));
            } catch (IOException e) {
                e.printStackTrace();
            } return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //Arranging Burge Breakfast
            array1BurgeBreakfast = new ArrayList<>();
            array2BurgeBreakfast = new ArrayList<>();
            array3BurgeBreakfast = new ArrayList<>();
            array4BurgeBreakfast = new ArrayList<>();
            array5BurgeBreakfast = new ArrayList<>();
            array6BurgeBreakfast = new ArrayList<>();
            indexofBurgeBreakfast = new ArrayList<>();
            int burgeFruitYogurtbar = BurgeBreakfastitems.indexOf("Burge Fruit & Yogurt Bar");
            int burgeBreakfastBar = BurgeBreakfastitems.indexOf("Burge Breakfast Bar");
            int burgeEastsideGrille = BurgeBreakfastitems.indexOf("Burge Eastside Grille");
            int burgeDesserts = BurgeBreakfastitems.indexOf("Burge Desserts");
            int burgeSanteFe = BurgeBreakfastitems.indexOf("Burge Santa Fe");
            int burgeThrive = BurgeBreakfastitems.indexOf("Burge Thrive ( Allergen Free )");
            indexofBurgeBreakfast.add(burgeFruitYogurtbar);
            indexofBurgeBreakfast.add(burgeBreakfastBar);
            indexofBurgeBreakfast.add(burgeEastsideGrille);
            indexofBurgeBreakfast.add(burgeDesserts);
            indexofBurgeBreakfast.add(burgeSanteFe);
            indexofBurgeBreakfast.add(burgeThrive);
            Collections.sort(indexofBurgeBreakfast);

            array1BurgeBreakfast =  BurgeBreakfastitems.subList(indexofBurgeBreakfast.get(0),indexofBurgeBreakfast.get(1));
            array2BurgeBreakfast =  BurgeBreakfastitems.subList(indexofBurgeBreakfast.get(1),indexofBurgeBreakfast.get(2));
            array3BurgeBreakfast =  BurgeBreakfastitems.subList(indexofBurgeBreakfast.get(2),indexofBurgeBreakfast.get(3));
            array4BurgeBreakfast =  BurgeBreakfastitems.subList(indexofBurgeBreakfast.get(3),indexofBurgeBreakfast.get(4));
            array5BurgeBreakfast =  BurgeBreakfastitems.subList(indexofBurgeBreakfast.get(4),indexofBurgeBreakfast.get(5));
            array6BurgeBreakfast =  BurgeBreakfastitems.subList(indexofBurgeBreakfast.get(5), BurgeBreakfastitems.size());

            //Aranging Burge Lunch
            array1BurgeLunch = new ArrayList<>();
            array2BurgeLunch = new ArrayList<>();
            array3BurgeLunch = new ArrayList<>();
            array4BurgeLunch = new ArrayList<>();
            array5BurgeLunch = new ArrayList<>();
            array6BurgeLunch = new ArrayList<>();
            array7BurgeLunch = new ArrayList<>();
            array8BurgeLunch = new ArrayList<>();
            array9BurgeLunch = new ArrayList<>();
            array10BurgeLunch = new ArrayList<>();
            array11BurgeLunch = new ArrayList<>();
            indexofBurgeLunch = new ArrayList<>();

            int burgeFruitYogurtbar2 = BurgeLunchitems.indexOf("Burge Fruit & Yogurt Bar");
            int burgeSaladBar = BurgeLunchitems.indexOf("Burge Salad Bar");
            int burgeCarvingStation = BurgeLunchitems.indexOf("Burge Carving Station");
            int burgePizza = BurgeLunchitems.indexOf("Burge Pizza/Pasta");
            int burgeWrap = BurgeLunchitems.indexOf("Burge It's a Wrap");
            int burgeBreakfastbar = BurgeLunchitems.indexOf("Burge Breakfast Bar");
            int burgeInternational = BurgeLunchitems.indexOf("Burge International");
            int burgeDesserts2 = BurgeLunchitems.indexOf("Burge Desserts");
            int burgeEastside = BurgeLunchitems.indexOf("Burge Eastside Grille");
            int burgeThrive2 = BurgeLunchitems.indexOf("Burge Thrive ( Allergen Free )");
            int burgeSantafe = BurgeLunchitems.indexOf("Burge Santa Fe");

            indexofBurgeLunch.add(burgeFruitYogurtbar2);
            indexofBurgeLunch.add(burgeSaladBar);
            indexofBurgeLunch.add(burgeCarvingStation);
            indexofBurgeLunch.add(burgePizza);
            indexofBurgeLunch.add(burgeWrap);
            indexofBurgeLunch.add(burgeBreakfastbar);
            indexofBurgeLunch.add(burgeInternational);
            indexofBurgeLunch.add(burgeDesserts2);
            indexofBurgeLunch.add(burgeEastside);
            indexofBurgeLunch.add(burgeThrive2);
            indexofBurgeLunch.add(burgeSantafe);
            Collections.sort(indexofBurgeLunch);
            array1BurgeLunch = BurgeLunchitems.subList(indexofBurgeLunch.get(0),indexofBurgeLunch.get(1));
            array2BurgeLunch = BurgeLunchitems.subList(indexofBurgeLunch.get(1),indexofBurgeLunch.get(2));
            array3BurgeLunch = BurgeLunchitems.subList(indexofBurgeLunch.get(2),indexofBurgeLunch.get(3));
            array4BurgeLunch = BurgeLunchitems.subList(indexofBurgeLunch.get(3),indexofBurgeLunch.get(4));
            array5BurgeLunch = BurgeLunchitems.subList(indexofBurgeLunch.get(4),indexofBurgeLunch.get(5));
            array6BurgeLunch = BurgeLunchitems.subList(indexofBurgeLunch.get(5),indexofBurgeLunch.get(6));
            array7BurgeLunch = BurgeLunchitems.subList(indexofBurgeLunch.get(6),indexofBurgeLunch.get(7));
            array8BurgeLunch = BurgeLunchitems.subList(indexofBurgeLunch.get(7),indexofBurgeLunch.get(8));
            array9BurgeLunch = BurgeLunchitems.subList(indexofBurgeLunch.get(8),indexofBurgeLunch.get(9));
            array10BurgeLunch = BurgeLunchitems.subList(indexofBurgeLunch.get(9),indexofBurgeLunch.get(10));
            array11BurgeLunch = BurgeLunchitems.subList(indexofBurgeLunch.get(10),BurgeLunchitems.size());

            //Arranging Burge Dinner
            array1BurgeDinner = new ArrayList<>();
            array2BurgeDinner = new ArrayList<>();
            array3BurgeDinner = new ArrayList<>();
            array4BurgeDinner = new ArrayList<>();
            array5BurgeDinner = new ArrayList<>();
            array6BurgeDinner = new ArrayList<>();
            array7BurgeDinner = new ArrayList<>();
            array8BurgeDinner = new ArrayList<>();
            array9BurgeDinner = new ArrayList<>();
            indexofBurgeDinner = new ArrayList<>();

            int burgeFruitYogurtbar3 = BurgeDinneritems.indexOf("Burge Fruit & Yogurt Bar");
            int burgeSaladBar3 = BurgeDinneritems.indexOf("Burge Salad Bar");
            int burgeWrap3 = BurgeDinneritems.indexOf("Burge It's a Wrap");
            int burgeCarvingStation3 = BurgeDinneritems.indexOf("Burge Carving Station");
            int burgeDesserts3 = BurgeDinneritems.indexOf("Burge Desserts");
            int burgePizza3 = BurgeDinneritems.indexOf("Burge Pizza/Pasta");
            int burgeThrive3 = BurgeDinneritems.indexOf("Burge Thrive ( Allergen Free )");
            int burgeEastside3 = BurgeDinneritems.indexOf("Burge Eastside Grille");
            int burgeSantafe3 = BurgeDinneritems.indexOf("Burge Santa Fe");
            indexofBurgeDinner.add(burgeFruitYogurtbar3);
            indexofBurgeDinner.add(burgeSaladBar3);
            indexofBurgeDinner.add(burgeWrap3);
            indexofBurgeDinner.add(burgeCarvingStation3);
            indexofBurgeDinner.add(burgeDesserts3);
            indexofBurgeDinner.add(burgePizza3);
            indexofBurgeDinner.add(burgeThrive3);
            indexofBurgeDinner.add(burgeEastside3);
            indexofBurgeDinner.add(burgeSantafe3);
            Collections.sort(indexofBurgeDinner);

            array1BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(0), indexofBurgeDinner.get(1));
            array2BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(1), indexofBurgeDinner.get(2));
            array3BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(2), indexofBurgeDinner.get(3));
            array4BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(3), indexofBurgeDinner.get(4));
            array5BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(4), indexofBurgeDinner.get(5));
            array6BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(5), indexofBurgeDinner.get(6));
            array7BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(6), indexofBurgeDinner.get(7));
            array8BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(7), indexofBurgeDinner.get(8));
            array9BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(8),BurgeDinneritems.size());


        }

    }

}
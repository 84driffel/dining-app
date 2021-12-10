package com.example.dininghallapplication.ui.custom;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.dininghallapplication.FoodScreen;
import com.example.dininghallapplication.R;
import com.example.dininghallapplication.ui.home.HomeFragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomFragment extends PreferenceFragmentCompat {

    public Boolean burge = false;
    public Boolean catlett = false;
    public Boolean hillcrest = false;
    public Boolean entrees = false;
    public Boolean sides = false;
    public Boolean desserts = false;
    public Boolean toppings = false;
    public Boolean breakfast = false;
    public Boolean lunch = false;
    public Boolean dinner = false;

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



    public ArrayList<String> CatletBreakfastitems;
    public List<String> array1CatlettBreakfast;
    public List<String> array2CatlettBreakfast;
    public List<String> array3CatlettBreakfast;
    public List<String> array4CatlettBreakfast;
    public List<Integer> indexofCatlettBreakfast;

    public ArrayList<String> CatletLunchitems;
    public List<String> array1CatlettLunch;
    public List<String> array2CatlettLunch;
    public List<String> array3CatlettLunch;
    public List<String> array4CatlettLunch;
    public List<String> array5CatlettLunch;
    public List<String> array6CatlettLunch;
    public List<String> array7CatlettLunch;
    public List<Integer> indexofCatlettLunch;

    public ArrayList<String> CatletDinneritems;
    public List<String> array1CatlettDinner;
    public List<String> array2CatlettDinner;
    public List<String> array3CatlettDinner;
    public List<String> array4CatlettDinner;
    public List<String> array5CatlettDinner;
    public List<String> array6CatlettDinner;
    public List<Integer> indexofCatlettDinner;


    public ArrayList<String> HillBreakfastitems;
    public List<String> array1HillBreakfast;
    public List<String> array2HillBreakfast;
    public List<String> array3HillBreakfast;
    public List<String> array4HillBreakfast;
    public List<String> array5HillBreakfast;
    public List<Integer> indexofHillBreakfast;

    public ArrayList<String> HillLunchitems;
    public List<String> array1HillLunch;
    public List<String> array2HillLunch;
    public List<String> array3HillLunch;
    public List<String> array4HillLunch;
    public List<String> array5HillLunch;
    public List<String> array6HillLunch;
    public List<String> array7HillLunch;
    public List<String> array8HillLunch;
    public List<String> array9HillLunch;
    public List<Integer> indexofHillLunch;

    public ArrayList<String> HillDinneritems;
    public List<String> array1HillDinner;
    public List<String> array2HillDinner;
    public List<String> array3HillDinner;
    public List<String> array4HillDinner;
    public List<String> array5HillDinner;
    public List<String> array6HillDinner;
    public List<String> array7HillDinner;
    public List<String> array8HillDinner;
    public List<String> array9HillDinner;
    public List<Integer> indexofHillDinner;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
        new doIT().execute();

        Preference burgePref = findPreference("burge");
        burgePref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                burge ^= true;
                System.out.println(burge);
                return burge;
            }
        });
        Preference catlettPref = findPreference("catlett");
        catlettPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                catlett ^= true;
                System.out.println(catlett);
                return catlett;
            }
        });
        Preference hillcrestPref = findPreference("hillcrest");
        hillcrestPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                hillcrest ^= true;
                System.out.println(hillcrest);
                return hillcrest;
            }
        });
        Preference entreesPref = findPreference("entrees");
        entreesPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                entrees ^= true;
                System.out.println(entrees);
                return entrees;
            }
        });
        Preference sidesPref = findPreference("sides");
        sidesPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                sides ^= true;
                System.out.println(sides);
                return sides;
            }
        });
        Preference dessertsPref = findPreference("desserts");
        dessertsPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                desserts ^= true;
                System.out.println(desserts);
                return desserts;
            }
        });
        Preference breakfastPref = findPreference("breakfast");
        breakfastPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                breakfast ^= true;
                System.out.println(breakfast);
                return breakfast;
            }
        });
        Preference lunchPref = findPreference("lunch");
        lunchPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                lunch ^= true;
                System.out.println(lunch);
                return lunch;
            }
        });
        Preference dinnerPref = findPreference("dinner");
        dinnerPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                dinner ^= true;
                System.out.println(dinner);
                return dinner;
            }
        });


        Preference navbutton = findPreference("menubutton");
        navbutton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent i = new Intent(CustomFragment.this.getActivity(), FoodScreen.class);
                i.putStringArrayListExtra("section1", new ArrayList<>());
                i.putStringArrayListExtra("section2", new ArrayList<>());
                i.putStringArrayListExtra("section3", new ArrayList<>());
                i.putStringArrayListExtra("section4", new ArrayList<>());
                i.putStringArrayListExtra("section5", new ArrayList<>());
                i.putStringArrayListExtra("section6", new ArrayList<>());
                i.putStringArrayListExtra("section7", new ArrayList<>());
                i.putStringArrayListExtra("section8", new ArrayList<>());
                i.putStringArrayListExtra("section9", new ArrayList<>());
                i.putStringArrayListExtra("section10", new ArrayList<>());
                i.putStringArrayListExtra("section11", new ArrayList<>());
                if (breakfast == true) {
                    if (entrees == true) {
                        if (burge == true) {
                            i.putStringArrayListExtra("section1", new ArrayList<>(array2BurgeBreakfast));
                            i.putStringArrayListExtra("section2", new ArrayList<>(array3BurgeBreakfast));
                            i.putStringArrayListExtra("section3", new ArrayList<>(array5BurgeBreakfast));
                        }
                        if (catlett == true) {
                            i.putStringArrayListExtra("section4", new ArrayList<>(array1CatlettBreakfast));
                            i.putStringArrayListExtra("section5", new ArrayList<>(array3CatlettBreakfast));

                        }
                        if (hillcrest == true) {
                            i.putStringArrayListExtra("section6", new ArrayList<>(array2HillBreakfast));
                        }
                    }
                    if (sides == true) {
                        if (burge == true) {
                            i.putStringArrayListExtra("section9", new ArrayList<>(array1BurgeBreakfast));
                            i.putStringArrayListExtra("section10", new ArrayList<>(array6BurgeBreakfast));
                        }
                        if (catlett == true) {
                            i.putStringArrayListExtra("section8", new ArrayList<>(array2CatlettBreakfast));
                        }
                        if (hillcrest == true) {
                            i.putStringArrayListExtra("section7", new ArrayList<>(array1HillBreakfast));
                            i.putStringArrayListExtra("section6", new ArrayList<>(array4HillBreakfast));
                        }
                    }
                    if (desserts == true) {
                        if (burge == true) {
                            i.putStringArrayListExtra("section11", new ArrayList<>(array4BurgeBreakfast));
                        }
                        if (catlett == true) {
                            i.putStringArrayListExtra("section10", new ArrayList<>(array4CatlettBreakfast));
                        }
                        if (hillcrest == true) {
                            i.putStringArrayListExtra("section9", new ArrayList<>(array3HillBreakfast));
                        }
                    }
                }
                if (lunch == true) {
                    if (entrees == true) {
                        if (burge == true) {
                            i.putStringArrayListExtra("section1", new ArrayList<>(array3BurgeLunch));
                            i.putStringArrayListExtra("section2", new ArrayList<>(array4BurgeLunch));
                            i.putStringArrayListExtra("section3", new ArrayList<>(array7BurgeLunch));
                        }
                        if (catlett == true) {
                            i.putStringArrayListExtra("section4", new ArrayList<>(array3CatlettLunch));
                            i.putStringArrayListExtra("section5", new ArrayList<>(array4CatlettLunch));
                            i.putStringArrayListExtra("section6", new ArrayList<>(array5CatlettLunch));

                        }
                        if (hillcrest == true) {
                            i.putStringArrayListExtra("section7", new ArrayList<>(array2HillLunch));
                            i.putStringArrayListExtra("section8", new ArrayList<>(array3HillLunch));
                            i.putStringArrayListExtra("section9", new ArrayList<>(array4HillLunch));
                        }
                    }
                    if (sides == true) {
                        if (burge == true) {
                            i.putStringArrayListExtra("section9", new ArrayList<>(array1BurgeLunch));
                            i.putStringArrayListExtra("section10", new ArrayList<>(array2BurgeLunch));
                        }
                        if (catlett == true) {
                            i.putStringArrayListExtra("section8", new ArrayList<>(array1CatlettLunch));
                        }
                        if (hillcrest == true) {
                            i.putStringArrayListExtra("section7", new ArrayList<>(array1HillLunch));
                            i.putStringArrayListExtra("section6", new ArrayList<>(array8HillLunch));
                        }
                    }
                    if (desserts == true) {
                        if (burge == true) {
                            i.putStringArrayListExtra("section11", new ArrayList<>(array8BurgeLunch));
                        }
                        if (catlett == true) {
                            i.putStringArrayListExtra("section10", new ArrayList<>(array7CatlettLunch));
                        }
                        if (hillcrest == true) {
                            i.putStringArrayListExtra("section9", new ArrayList<>(array7HillLunch));
                        }
                    }
                }
                if (dinner == true) {
                    if (entrees == true) {
                        if (burge == true) {
                            i.putStringArrayListExtra("section1", new ArrayList<>(array3BurgeDinner));
                            i.putStringArrayListExtra("section2", new ArrayList<>(array4BurgeDinner));
                            i.putStringArrayListExtra("section3", new ArrayList<>(array7BurgeDinner));
                        }
                        if (catlett == true) {
                            i.putStringArrayListExtra("section4", new ArrayList<>(array3CatlettDinner));
                            i.putStringArrayListExtra("section5", new ArrayList<>(array4CatlettDinner));
                            i.putStringArrayListExtra("section6", new ArrayList<>(array5CatlettDinner));

                        }
                        if (hillcrest == true) {
                            i.putStringArrayListExtra("section7", new ArrayList<>(array2HillDinner));
                            i.putStringArrayListExtra("section8", new ArrayList<>(array3HillDinner));
                            i.putStringArrayListExtra("section9", new ArrayList<>(array4HillDinner));
                        }
                    }
                    if (sides == true) {
                        if (burge == true) {
                            i.putStringArrayListExtra("section9", new ArrayList<>(array1BurgeDinner));
                            i.putStringArrayListExtra("section10", new ArrayList<>(array2BurgeDinner));
                        }
                        if (catlett == true) {
                            i.putStringArrayListExtra("section8", new ArrayList<>(array1CatlettDinner));
                        }
                        if (hillcrest == true) {
                            i.putStringArrayListExtra("section7", new ArrayList<>(array1HillDinner));
                            i.putStringArrayListExtra("section6", new ArrayList<>(array8HillDinner));
                        }
                    }
                    if (desserts == true) {
                        if (burge == true) {
                            i.putStringArrayListExtra("section11", new ArrayList<>(array5BurgeDinner));
                        }
                        if (catlett == true) {
                            i.putStringArrayListExtra("section10", new ArrayList<>(array6CatlettDinner));
                        }
                        if (hillcrest == true) {
                            i.putStringArrayListExtra("section9", new ArrayList<>(array7HillDinner));
                        }
                    }
                }
                startActivity(i);
                return true;
            }
        });
    }

    public class doIT extends AsyncTask<Void,Void,Void> {
        String words;
        String burgeBreakfastText;
        String burgeLunchText;
        String burgeDinnerText;


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
                while(BurgeDinneritems.remove(""));
                while(BurgeLunchitems.remove(""));
                while(BurgeBreakfastitems.remove(""));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                CatletBreakfastitems = new ArrayList<>();
                CatletLunchitems = new ArrayList<>();
                CatletDinneritems = new ArrayList<>();

                Document document = Jsoup.connect("https://dining.uiowa.edu/catlett-market-place").get();

                Element breakfastId = document.getElementById("Breakfast");
                Elements breakfastDivs = breakfastId.getElementsByTag("div");
                Element lunchId = document.getElementById("Lunch");
                Elements lunchDivs = lunchId.getElementsByTag("div");
                Element dinnerId = document.getElementById("Dinner");
                Elements dinnerDivs = dinnerId.getElementsByTag("div");
                for(Element div : breakfastDivs ){
                    if(div.hasClass("panel-heading")){
                        CatletBreakfastitems.add(div.text());
                    }
                    if(div.hasClass("h5 menu-course-title")) {
                        CatletBreakfastitems.add(div.text());
                    }
                    if(div.hasClass("menu-item")){
                        CatletBreakfastitems.add(div.text());
                    }

                }
                for(Element d : lunchDivs ){
                    if(d.hasClass("panel-heading")){
                        CatletLunchitems.add(d.text());
                    }
                    if(d.hasClass("h5 menu-course-title")) {
                        CatletLunchitems.add(d.text());
                    }
                    if(d.hasClass("menu-item")){
                        CatletLunchitems.add(d.text());
                    }

                }
                for(Element div : dinnerDivs ){
                    if(div.hasClass("panel-heading")){
                        CatletDinneritems.add(div.text());
                    }
                    if(div.hasClass("h5 menu-course-title")) {
                        CatletDinneritems.add(div.text());
                    }
                    if(div.hasClass("menu-item")){
                        CatletDinneritems.add(div.text());
                    }

                }
                while(CatletDinneritems.remove(""));
                while(CatletLunchitems.remove(""));
                while(CatletBreakfastitems.remove(""));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                HillBreakfastitems = new ArrayList<>();
                HillLunchitems = new ArrayList<>();
                HillDinneritems = new ArrayList<>();

                Document document = Jsoup.connect("https://dining.uiowa.edu/hillcrest-market-place").get();

                Element breakfastId = document.getElementById("Breakfast");
                Elements breakfastDivs = breakfastId.getElementsByTag("div");
                Element lunchId = document.getElementById("Lunch");
                Elements lunchDivs = lunchId.getElementsByTag("div");
                Element dinnerId = document.getElementById("Dinner");
                Elements dinnerDivs = dinnerId.getElementsByTag("div");
                for(Element div : breakfastDivs ){
                    if(div.hasClass("panel-heading")){
                        HillBreakfastitems.add(div.text());
                    }
                    if(div.hasClass("h5 menu-course-title")) {
                        HillBreakfastitems.add(div.text());
                    }
                    if(div.hasClass("menu-item")){
                        HillBreakfastitems.add(div.text());
                    }

                }
                for(Element d : lunchDivs ){
                    if(d.hasClass("panel-heading")){
                        HillLunchitems.add(d.text());
                    }
                    if(d.hasClass("h5 menu-course-title")) {
                        HillLunchitems.add(d.text());
                    }
                    if(d.hasClass("menu-item")){
                        HillLunchitems.add(d.text());
                    }

                }
                for(Element div : dinnerDivs ){
                    if(div.hasClass("panel-heading")){
                        HillDinneritems.add(div.text());
                    }
                    if(div.hasClass("h5 menu-course-title")) {
                        HillDinneritems.add(div.text());
                    }
                    if(div.hasClass("menu-item")){
                        HillDinneritems.add(div.text());
                    }

                }
                while(HillDinneritems.remove(""));
                while(HillLunchitems.remove(""));
                while(HillBreakfastitems.remove(""));
            } catch (IOException e) {
                e.printStackTrace();
            } return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            //textView.setText(burgeItems);
//            //System.out.println(burgeItems);
//            breakfastString = burgeBreakfastText;
//            lunchString = burgeLunchText;
//            dinnerString = burgeDinnerText;

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


            //Arranging Cat Breakfast
            array1CatlettBreakfast = new ArrayList<>();
            array2CatlettBreakfast = new ArrayList<>();
            array3CatlettBreakfast = new ArrayList<>();
            array4CatlettBreakfast = new ArrayList<>();

            indexofCatlettBreakfast = new ArrayList<>();
            int catlettSunnySide = CatletBreakfastitems.indexOf("Catlett Sunny Side Up");
            int catlettSprouts = CatletBreakfastitems.indexOf("Catlett Sprouts");
            int catlettZa = CatletBreakfastitems.indexOf("Catlett Za!");
            int catlettDelights = CatletBreakfastitems.indexOf("Catlett Delights");

            indexofCatlettBreakfast.add(catlettSunnySide);
            indexofCatlettBreakfast.add(catlettSprouts);
            indexofCatlettBreakfast.add(catlettZa);
            indexofCatlettBreakfast.add(catlettDelights);

            Collections.sort(indexofCatlettBreakfast);

            array1CatlettBreakfast = CatletBreakfastitems.subList(indexofCatlettBreakfast.get(0),indexofCatlettBreakfast.get(1));
            array2CatlettBreakfast = CatletBreakfastitems.subList(indexofCatlettBreakfast.get(1),indexofCatlettBreakfast.get(2));
            array3CatlettBreakfast = CatletBreakfastitems.subList(indexofCatlettBreakfast.get(2),indexofCatlettBreakfast.get(3));
            array4CatlettBreakfast = CatletBreakfastitems.subList(indexofCatlettBreakfast.get(3),CatletBreakfastitems.size());

            //Aranging Cat Lunch
            array1CatlettLunch = new ArrayList<>();
            array2CatlettLunch = new ArrayList<>();
            array3CatlettLunch = new ArrayList<>();
            array4CatlettLunch = new ArrayList<>();
            array5CatlettLunch = new ArrayList<>();
            array6CatlettLunch = new ArrayList<>();
            array7CatlettLunch = new ArrayList<>();

            indexofCatlettLunch = new ArrayList<>();
            int catlettSunnySide2 = CatletLunchitems.indexOf("Catlett Sunny Side Up");
            int catlettSprouts2 = CatletLunchitems.indexOf("Catlett Sprouts");
            int catlettFamilyTable2 = CatletLunchitems.indexOf("Catlett Family Table");
            int catlettZa2 = CatletLunchitems.indexOf("Catlett Za!");
            int catlettFlavorsAbroad2 = CatletLunchitems.indexOf("Catlett Flavors Abroad");
            int catlettFireup2 = CatletLunchitems.indexOf("Catlett Fire Up");
            int catlettDelights2 = CatletLunchitems.indexOf("Catlett Delights");

            indexofCatlettLunch.add(catlettSunnySide2);
            indexofCatlettLunch.add(catlettSprouts2);
            indexofCatlettLunch.add(catlettFamilyTable2);
            indexofCatlettLunch.add(catlettZa2);
            indexofCatlettLunch.add(catlettFlavorsAbroad2);
            indexofCatlettLunch.add(catlettFireup2);
            indexofCatlettLunch.add(catlettDelights2);

            Collections.sort(indexofCatlettLunch);

            array1CatlettLunch = CatletLunchitems.subList(indexofCatlettLunch.get(0),indexofCatlettLunch.get(1));
            array2CatlettLunch = CatletLunchitems.subList(indexofCatlettLunch.get(1),indexofCatlettLunch.get(2));
            array3CatlettLunch= CatletLunchitems.subList(indexofCatlettLunch.get(2),indexofCatlettLunch.get(3));
            array4CatlettLunch = CatletLunchitems.subList(indexofCatlettLunch.get(3),indexofCatlettLunch.get(4));
            array5CatlettLunch = CatletLunchitems.subList(indexofCatlettLunch.get(4),indexofCatlettLunch.get(5));
            array6CatlettLunch = CatletLunchitems.subList(indexofCatlettLunch.get(5),indexofCatlettLunch.get(6));
            array7CatlettLunch = CatletLunchitems.subList(indexofCatlettLunch.get(6),CatletLunchitems.size());

            //Arranging Cat Dinner
            array1CatlettDinner = new ArrayList<>();
            array2CatlettDinner = new ArrayList<>();
            array3CatlettDinner = new ArrayList<>();
            array4CatlettDinner = new ArrayList<>();
            array5CatlettDinner = new ArrayList<>();
            array6CatlettDinner = new ArrayList<>();
            indexofCatlettDinner = new ArrayList<>();

            int catlettSprouts3 = CatletDinneritems.indexOf("Catlett Sprouts");
            int catlettFamilyTable3 = CatletDinneritems.indexOf("Catlett Family Table");
            int catlettZa3 = CatletDinneritems.indexOf("Catlett Za!");
            int catlettFlavorsAbroad3 = CatletDinneritems.indexOf("Catlett Flavors Abroad");
            int catlettFireup3 = CatletDinneritems.indexOf("Catlett Fire Up");
            int catlettDelights3 = CatletDinneritems.indexOf("Catlett Delights");

            indexofCatlettDinner.add(catlettSprouts3);
            indexofCatlettDinner.add(catlettFamilyTable3);
            indexofCatlettDinner.add(catlettZa3);
            indexofCatlettDinner.add(catlettFlavorsAbroad3);
            indexofCatlettDinner.add(catlettFireup3);
            indexofCatlettDinner.add(catlettDelights3);

            Collections.sort(indexofCatlettDinner);

            array1CatlettDinner = CatletDinneritems.subList(indexofCatlettDinner.get(0),indexofCatlettDinner.get(1));
            array2CatlettDinner = CatletDinneritems.subList(indexofCatlettDinner.get(1),indexofCatlettDinner.get(2));
            array3CatlettDinner = CatletDinneritems.subList(indexofCatlettDinner.get(2),indexofCatlettDinner.get(3));
            array4CatlettDinner = CatletDinneritems.subList(indexofCatlettDinner.get(3),indexofCatlettDinner.get(4));
            array5CatlettDinner = CatletDinneritems.subList(indexofCatlettDinner.get(4),indexofCatlettDinner.get(5));
            array6CatlettDinner = CatletDinneritems.subList(indexofCatlettDinner.get(5),CatletDinneritems.size());


            //Arranging Hill Breakfast
            array1HillBreakfast = new ArrayList<>();
            array2HillBreakfast = new ArrayList<>();
            array3HillBreakfast = new ArrayList<>();
            array4HillBreakfast = new ArrayList<>();
            array5HillBreakfast = new ArrayList<>();
            indexofHillBreakfast = new ArrayList<>();

            int hillFieldOfGreens = HillBreakfastitems.indexOf("Hillcrest Field of Greens");
            int hillGrandAveGrill = HillBreakfastitems.indexOf("Hillcrest Grand Ave Grill");
            int hillDesserts = HillBreakfastitems.indexOf("Hillcrest Desserts");
            int hillGluten = HillBreakfastitems.indexOf("Hillcrest Gluten Free");
            int hillDrinks = HillBreakfastitems.indexOf("Hillcrest Drinks/Condiments");

            indexofHillBreakfast.add(hillFieldOfGreens);
            indexofHillBreakfast.add(hillGrandAveGrill);
            indexofHillBreakfast.add(hillDesserts);
            indexofHillBreakfast.add(hillGluten);
            indexofHillBreakfast.add(hillDrinks);

            Collections.sort(indexofHillBreakfast);

            array1HillBreakfast = HillBreakfastitems.subList(indexofHillBreakfast.get(0),indexofHillBreakfast.get(1));
            array2HillBreakfast = HillBreakfastitems.subList(indexofHillBreakfast.get(1),indexofHillBreakfast.get(2));
            array3HillBreakfast = HillBreakfastitems.subList(indexofHillBreakfast.get(2),indexofHillBreakfast.get(3));
            array4HillBreakfast = HillBreakfastitems.subList(indexofHillBreakfast.get(3),indexofHillBreakfast.get(4));
            array5HillBreakfast = HillBreakfastitems.subList(indexofHillBreakfast.get(4),HillBreakfastitems.size());

            //Aranging Hill Lunch
            array1HillLunch = new ArrayList<>();
            array2HillLunch = new ArrayList<>();
            array3HillLunch = new ArrayList<>();
            array4HillLunch = new ArrayList<>();
            array5HillLunch = new ArrayList<>();
            array6HillLunch = new ArrayList<>();
            array7HillLunch = new ArrayList<>();
            array8HillLunch = new ArrayList<>();
            array9HillLunch = new ArrayList<>();
            indexofHillLunch = new ArrayList<>();

            int hillFieldOfGreens2 = HillLunchitems.indexOf("Hillcrest Field of Greens");
            int hillGolden2 = HillLunchitems.indexOf("Hillcrest Golden Harvest");
            int hillPizza2 = HillLunchitems.indexOf("Hillcrest Piazza Cafe");
            int hillCorner2 = HillLunchitems.indexOf("Hillcrest Corner Wok");
            int hillGrandAveGrill2 = HillLunchitems.indexOf("Hillcrest Grand Ave Grill");
            int hillCafeRio2 = HillLunchitems.indexOf("Hillcrest Cafe Rio Grande");
            int hillDesserts2 = HillLunchitems.indexOf("Hillcrest Desserts");
            int hillGluten2 = HillLunchitems.indexOf("Hillcrest Gluten Free");
            int hillDrinks2 = HillLunchitems.indexOf("Hillcrest Drinks/Condiments");

            indexofHillLunch.add(hillFieldOfGreens2);
            indexofHillLunch.add(hillGolden2);
            indexofHillLunch.add(hillPizza2);
            indexofHillLunch.add(hillCorner2);
            indexofHillLunch.add(hillGrandAveGrill2);
            indexofHillLunch.add(hillCafeRio2);
            indexofHillLunch.add(hillDesserts2);
            indexofHillLunch.add(hillGluten2);
            indexofHillLunch.add(hillDrinks2);

            Collections.sort(indexofHillLunch);

            array1HillLunch = HillLunchitems.subList(indexofHillLunch.get(0),indexofHillLunch.get(1));
            array2HillLunch = HillLunchitems.subList(indexofHillLunch.get(1),indexofHillLunch.get(2));
            array3HillLunch = HillLunchitems.subList(indexofHillLunch.get(2),indexofHillLunch.get(3));
            array4HillLunch = HillLunchitems.subList(indexofHillLunch.get(3),indexofHillLunch.get(4));
            array5HillLunch = HillLunchitems.subList(indexofHillLunch.get(4),indexofHillLunch.get(5));
            array6HillLunch = HillLunchitems.subList(indexofHillLunch.get(5),indexofHillLunch.get(6));
            array7HillLunch = HillLunchitems.subList(indexofHillLunch.get(6),indexofHillLunch.get(7));
            array8HillLunch = HillLunchitems.subList(indexofHillLunch.get(7),indexofHillLunch.get(8));
            array9HillLunch = HillLunchitems.subList(indexofHillLunch.get(8),HillLunchitems.size());

            //Arranging Hill Dinner
            array1HillDinner = new ArrayList<>();
            array2HillDinner = new ArrayList<>();
            array3HillDinner = new ArrayList<>();
            array4HillDinner = new ArrayList<>();
            array5HillDinner = new ArrayList<>();
            array6HillDinner = new ArrayList<>();
            array7HillDinner = new ArrayList<>();
            array8HillDinner = new ArrayList<>();
            array9HillDinner = new ArrayList<>();
            indexofHillDinner = new ArrayList<>();

            int hillFieldOfGreens3 = HillDinneritems.indexOf("Hillcrest Field of Greens");
            int hillGolden3 = HillDinneritems.indexOf("Hillcrest Golden Harvest");
            int hillPizza3 = HillDinneritems.indexOf("Hillcrest Piazza Cafe");
            int hillCorner3 = HillDinneritems.indexOf("Hillcrest Corner Wok");
            int hillGrandAveGrill3 = HillDinneritems.indexOf("Hillcrest Grand Ave Grill");
            int hillCafeRio3 = HillDinneritems.indexOf("Hillcrest Cafe Rio Grande");
            int hillDesserts3 = HillDinneritems.indexOf("Hillcrest Desserts");
            int hillGluten3 = HillDinneritems.indexOf("Hillcrest Gluten Free");
            int hillDrinks3 = HillDinneritems.indexOf("Hillcrest Drinks/Condiments");

            indexofHillDinner.add(hillFieldOfGreens3);
            indexofHillDinner.add(hillGolden3);
            indexofHillDinner.add(hillPizza3);
            indexofHillDinner.add(hillCorner3);
            indexofHillDinner.add(hillGrandAveGrill3);
            indexofHillDinner.add(hillCafeRio3);
            indexofHillDinner.add(hillDesserts3);
            indexofHillDinner.add(hillGluten3);
            indexofHillDinner.add(hillDrinks3);

            Collections.sort(indexofHillDinner);

            array1HillDinner = HillDinneritems.subList(indexofHillDinner.get(0),indexofHillDinner.get(1));
            array2HillDinner = HillDinneritems.subList(indexofHillDinner.get(1),indexofHillDinner.get(2));
            array3HillDinner = HillDinneritems.subList(indexofHillDinner.get(2),indexofHillDinner.get(3));
            array4HillDinner = HillDinneritems.subList(indexofHillDinner.get(3),indexofHillDinner.get(4));
            array5HillDinner = HillDinneritems.subList(indexofHillDinner.get(4),indexofHillDinner.get(5));
            array6HillDinner = HillDinneritems.subList(indexofHillDinner.get(5),indexofHillDinner.get(6));
            array7HillDinner = HillDinneritems.subList(indexofHillDinner.get(6),indexofHillDinner.get(7));
            array8HillDinner = HillDinneritems.subList(indexofHillDinner.get(7),indexofHillDinner.get(8));
            array9HillDinner = HillDinneritems.subList(indexofHillDinner.get(8),HillDinneritems.size());


        }

    }
}
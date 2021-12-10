package com.example.dininghallapplication.ui.custom;

import android.content.Intent;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.dininghallapplication.FoodScreen;
import com.example.dininghallapplication.R;
import com.example.dininghallapplication.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class CustomFragment extends PreferenceFragmentCompat {

    public Boolean burge = true;
    public Boolean catlett = true;
    public Boolean hillcrest = true;
    public Boolean entrees = true;
    public Boolean sides = false;
    public Boolean desserts = false;
    public Boolean toppings = false;
    public Boolean breakfast = false;
    public Boolean lunch = true;
    public Boolean dinner = true;

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

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

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
        Preference toppingsPref = findPreference("toppings");
        toppingsPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                toppings ^= true;
                System.out.println(toppings);
                return toppings;
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
                return true;
            }
        });
    }
}
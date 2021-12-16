package com.example.dininghallapplication.ui.dashboard;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dininghallapplication.FoodScreen;
import com.example.dininghallapplication.databinding.FragmentDashboardBinding;
import com.example.dininghallapplication.databinding.FragmentHomeBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//DashboardFragment = Catlett
public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    private TextView textView;
    private Button bbutton;
    private Button blbutton;
    private Button bdbutton;


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


    //will create the View for the HomeFragment aka Catlett menus
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        new doIT().execute();
        bbutton = binding.btnView;
        //Catlett Breakfast menu button
        //When clicked will go to FoodScreen with the menu
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(DashboardFragment.this.getActivity(), FoodScreen.class);
                i.putStringArrayListExtra("section1", new ArrayList<>(array1CatlettBreakfast));
                i.putStringArrayListExtra("section2", new ArrayList<>(array2CatlettBreakfast));
                i.putStringArrayListExtra("section3", new ArrayList<>(array3CatlettBreakfast));
                i.putStringArrayListExtra("section4", new ArrayList<>(array4CatlettBreakfast));
                i.putStringArrayListExtra("section5", new ArrayList<>());
                i.putStringArrayListExtra("section6", new ArrayList<>());
                i.putStringArrayListExtra("section7", new ArrayList<>());
                i.putStringArrayListExtra("section8", new ArrayList<>());
                i.putStringArrayListExtra("section9", new ArrayList<>());
                i.putStringArrayListExtra("section10", new ArrayList<>());
                i.putStringArrayListExtra("section11", new ArrayList<>());
                startActivity(i);

            }
        });
        blbutton = binding.btnView2;
        //Catlett Lunch menu button
        //When clicked will go to FoodScreen with the menu
        blbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(DashboardFragment.this.getActivity(), FoodScreen.class);
                i.putStringArrayListExtra("section1", new ArrayList<>(array1CatlettLunch));
                i.putStringArrayListExtra("section2", new ArrayList<>(array2CatlettLunch));
                i.putStringArrayListExtra("section3", new ArrayList<>(array3CatlettLunch));
                i.putStringArrayListExtra("section4", new ArrayList<>(array4CatlettLunch));
                i.putStringArrayListExtra("section5", new ArrayList<>(array5CatlettLunch));
                i.putStringArrayListExtra("section6", new ArrayList<>(array6CatlettLunch));
                i.putStringArrayListExtra("section7", new ArrayList<>(array7CatlettLunch));
                i.putStringArrayListExtra("section8", new ArrayList<>());
                i.putStringArrayListExtra("section9", new ArrayList<>());
                i.putStringArrayListExtra("section10", new ArrayList<>());
                i.putStringArrayListExtra("section11", new ArrayList<>());
                startActivity(i);

            }
        });
        bdbutton = binding.btnView3;
        //Catlett Dinner menu button
        //When clicked will go to FoodScreen with the menu
        bdbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(DashboardFragment.this.getActivity(), FoodScreen.class);
                i.putStringArrayListExtra("section1", new ArrayList<>(array1CatlettDinner));
                i.putStringArrayListExtra("section2", new ArrayList<>(array2CatlettDinner));
                i.putStringArrayListExtra("section3", new ArrayList<>(array3CatlettDinner));
                i.putStringArrayListExtra("section4", new ArrayList<>(array4CatlettDinner));
                i.putStringArrayListExtra("section5", new ArrayList<>(array5CatlettDinner));
                i.putStringArrayListExtra("section6", new ArrayList<>(array6CatlettDinner));
                i.putStringArrayListExtra("section7", new ArrayList<>());
                i.putStringArrayListExtra("section8", new ArrayList<>());
                i.putStringArrayListExtra("section9", new ArrayList<>());
                i.putStringArrayListExtra("section10", new ArrayList<>());
                i.putStringArrayListExtra("section11", new ArrayList<>());
                startActivity(i);

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


        //Web Scrape for Catlett dinning hall
        //Will parse the div elements into an array by meal
        @Override
        protected Void doInBackground(Void... params) {
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
                //removing any empty elements
                while(CatletDinneritems.remove(""));
                while(CatletLunchitems.remove(""));
                while(CatletBreakfastitems.remove(""));
            } catch (IOException e) {
                e.printStackTrace();
            } return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //Arranging Catlett Breakfast
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

            //Aranging Catlett Lunch
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

            //Arranging Catlett Dinner
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


        }

    }

}
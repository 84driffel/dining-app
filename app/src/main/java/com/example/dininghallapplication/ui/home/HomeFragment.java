package com.example.dininghallapplication.ui.home;

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
import com.example.dininghallapplication.databinding.FragmentHomeBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private TextView textView;
    private Button bbutton;
    private Button blbutton;
    private Button bdbutton;
    public String breakfastString;
    public String lunchString;
    public String dinnerString;

    public ArrayList<String> BurgeBreakfastitems;
    public List<String> array1BurgeBreakfast;
    public List<String> array2BurgeBreakfast;
    public List<String> array3BurgeBreakfast;
    public List<String> array4BurgeBreakfast;
    public List<String> array5BurgeBreakfast;
    public List<String> array6BurgeBreakfast;
    public List<Integer> indexofBurgeBreakfast;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        new doIT().execute();
        bbutton = binding.btnView;
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

//                if (breakfastString != null) {
//                    i.putExtra("food",breakfastString);
//                }
//                else {
//                    i.putExtra("food", "Could not load menu data.");
//                }
                startActivity(i);

            }
        });
        blbutton = binding.btnView2;
        blbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomeFragment.this.getActivity(), FoodScreen.class);
                if (lunchString != null) { i.putExtra("food", lunchString); }
                else {i.putExtra("food", "Could not load menu data.");}
                startActivity(i);

            }
        });
        bdbutton = binding.btnView3;
        bdbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomeFragment.this.getActivity(), FoodScreen.class);
                if (dinnerString != null) { i.putExtra("food", dinnerString); }
                else {i.putExtra("food", "Could not load menu data.");}
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
        String words;
        String burgeBreakfastText;
        String burgeLunchText;
        String burgeDinnerText;
        List<String> a;


        @Override
        protected Void doInBackground(Void... params) {
            try {
//                Document document = Jsoup.connect("https://dining.uiowa.edu/burge-market-place").get();
//                words = document.text();
//                Elements breakItems = document.select("#Breakfast");
//                Elements lunchItems = document.select("#Lunch");
//                Elements dinnerItems = document.select("#Dinner");
//                burgeBreakfastText = breakItems.text();
//                burgeLunchText = lunchItems.text();
//                burgeDinnerText = dinnerItems.text();
                //FoodString = burgeItems;
                BurgeBreakfastitems = new ArrayList<>();

                Document document = Jsoup.connect("https://dining.uiowa.edu/burge-market-place").get();

                //Burge Breakfast Scrape
                Element breakfastId = document.getElementById("Breakfast");
                Elements breakfastDivs = breakfastId.getElementsByTag("div");
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
                while(BurgeBreakfastitems.remove(""));
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



        }

    }

}
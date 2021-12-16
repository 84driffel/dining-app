package com.example.dininghallapplication.ui.notifications;

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
import com.example.dininghallapplication.databinding.FragmentNotificationsBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//NotificationsFragment = HillCrest
public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;
    private TextView textView;
    private Button bbutton;
    private Button blbutton;
    private Button bdbutton;


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


    //will create the View for the HomeFragment aka Hillcrest menus
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        new doIT().execute();
        bbutton = binding.btnView;
        //Hillcrest Breakfast menu button
        //When clicked will go to FoodScreen with the menu
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(NotificationsFragment.this.getActivity(), FoodScreen.class);
                i.putStringArrayListExtra("section1", new ArrayList<>(array1HillBreakfast));
                i.putStringArrayListExtra("section2", new ArrayList<>(array2HillBreakfast));
                i.putStringArrayListExtra("section3", new ArrayList<>(array3HillBreakfast));
                i.putStringArrayListExtra("section4", new ArrayList<>(array4HillBreakfast));
                i.putStringArrayListExtra("section5", new ArrayList<>(array5HillBreakfast));
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
        blbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(NotificationsFragment.this.getActivity(), FoodScreen.class);
                i.putStringArrayListExtra("section1", new ArrayList<>(array1HillLunch));
                i.putStringArrayListExtra("section2", new ArrayList<>(array2HillLunch));
                i.putStringArrayListExtra("section3", new ArrayList<>(array3HillLunch));
                i.putStringArrayListExtra("section4", new ArrayList<>(array4HillLunch));
                i.putStringArrayListExtra("section5", new ArrayList<>(array5HillLunch));
                i.putStringArrayListExtra("section6", new ArrayList<>(array6HillLunch));
                i.putStringArrayListExtra("section7", new ArrayList<>(array7HillLunch));
                i.putStringArrayListExtra("section8", new ArrayList<>(array8HillLunch));
                i.putStringArrayListExtra("section9", new ArrayList<>(array9HillLunch));
                i.putStringArrayListExtra("section10", new ArrayList<>());
                i.putStringArrayListExtra("section11", new ArrayList<>());
                startActivity(i);

            }
        });
        bdbutton = binding.btnView3;
        bdbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(NotificationsFragment.this.getActivity(), FoodScreen.class);
                i.putStringArrayListExtra("section1", new ArrayList<>(array1HillDinner));
                i.putStringArrayListExtra("section2", new ArrayList<>(array2HillDinner));
                i.putStringArrayListExtra("section3", new ArrayList<>(array3HillDinner));
                i.putStringArrayListExtra("section4", new ArrayList<>(array4HillDinner));
                i.putStringArrayListExtra("section5", new ArrayList<>(array5HillDinner));
                i.putStringArrayListExtra("section6", new ArrayList<>(array6HillDinner));
                i.putStringArrayListExtra("section7", new ArrayList<>(array7HillDinner));
                i.putStringArrayListExtra("section8", new ArrayList<>(array8HillDinner));
                i.putStringArrayListExtra("section9", new ArrayList<>(array9HillDinner));
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

        //Web Scrape for Hillcrest dinning hall
        //Will parse the div elements into an array by meal
        @Override
        protected Void doInBackground(Void... params) {
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
                //removing any empty elements
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

            //Arranging Hillcrest Breakfast
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

            //Arranging Hillcrest Lunch
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

            //Arranging Hillcrest Dinner
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
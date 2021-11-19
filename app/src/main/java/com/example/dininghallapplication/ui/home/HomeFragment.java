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
import org.jsoup.select.Elements;

import java.io.IOException;


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
                if (breakfastString != null) { i.putExtra("food", breakfastString); }
                else {i.putExtra("food", "Could not load menu data.");}
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
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect("https://dining.uiowa.edu/burge-market-place").get();
                words = document.text();
                Elements breakItems = document.select("#Breakfast");
                Elements lunchItems = document.select("#Lunch");
                Elements dinnerItems = document.select("#Dinner");
                burgeBreakfastText = breakItems.text();
                burgeLunchText = lunchItems.text();
                burgeDinnerText = dinnerItems.text();
                //FoodString = burgeItems;
            } catch (IOException e) {
                e.printStackTrace();
            } return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //textView.setText(burgeItems);
            //System.out.println(burgeItems);
            breakfastString = burgeBreakfastText;
            lunchString = burgeLunchText;
            dinnerString = burgeDinnerText;
        }

    }

}
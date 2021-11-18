package com.example.dininghallapplication.ui.home;


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
    public String cssQuery;

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
        bbutton = binding.btnView;
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cssQuery = "#Breakfast";
                new doIT().execute();
            }
        });
        blbutton = binding.btnView2;
        blbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cssQuery = "#Lunch";
                new doIT().execute();
            }
        });
        bdbutton = binding.btnView3;
        bdbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cssQuery = "#Dinner";
                new doIT().execute();
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
        String burgeItems;
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect("https://dining.uiowa.edu/burge-market-place").get();
                words = document.text();
                Elements items = document.select(cssQuery);
                burgeItems = items.text();
            } catch (IOException e) {
                e.printStackTrace();
            } return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //textView.setText(menuItems);
            System.out.println(burgeItems);
        }

    }

}
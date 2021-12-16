package com.example.lib;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class webScrapHillcrest {
    public static List<String> HillBreakfastitems;
    public static List<String> array1HillBreakfast;
    public static List<String> array2HillBreakfast;
    public static List<String> array3HillBreakfast;
    public static List<String> array4HillBreakfast;
    public static List<String> array5HillBreakfast;
    public static List<Integer> indexofHillBreakfast;

    public static List<String> HillLunchitems;
    public static List<String> array1HillLunch;
    public static List<String> array2HillLunch;
    public static List<String> array3HillLunch;
    public static List<String> array4HillLunch;
    public static List<String> array5HillLunch;
    public static List<String> array6HillLunch;
    public static List<String> array7HillLunch;
    public static List<String> array8HillLunch;
    public static List<String> array9HillLunch;
    public static List<Integer> indexofHillLunch;

    public static List<String> HillDinneritems;
    public static List<String> array1HillDinner;
    public static List<String> array2HillDinner;
    public static List<String> array3HillDinner;
    public static List<String> array4HillDinner;
    public static List<String> array5HillDinner;
    public static List<String> array6HillDinner;
    public static List<String> array7HillDinner;
    public static List<String> array8HillDinner;
    public static List<String> array9HillDinner;
    public static List<Integer> indexofHillDinner;

    public static void HillBreakfastWebScrape() throws IOException {

        HillBreakfastitems = new ArrayList<>();
        Document document = Jsoup.connect("https://dining.uiowa.edu/hillcrest-market-place").get();

        //Hillcrest Breakfast Scrape
        Element breakfastId = document.getElementById("Breakfast");
        Elements breakfastDivs = breakfastId.getElementsByTag("div");
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
        //System.out.println(HillBreakfastitems);

    }

    public static void arrangeArraysHillBreakfast() throws IOException {
        HillBreakfastWebScrape();
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


        System.out.println(array1HillBreakfast);
        System.out.println(array2HillBreakfast);
        System.out.println(array3HillBreakfast);
        System.out.println(array4HillBreakfast);
        System.out.println(array5HillBreakfast);


    }

    public static void HillLunchWebScrape() throws IOException {

        HillLunchitems = new ArrayList<>();
        Document document = Jsoup.connect("https://dining.uiowa.edu/hillcrest-market-place").get();

        //Hillcrest Breakfast Scrape
        Element lunchId = document.getElementById("Lunch");
        Elements lunchDivs = lunchId.getElementsByTag("div");
        for(Element div : lunchDivs ){
            if(div.hasClass("panel-heading")){
                HillLunchitems.add(div.text());
            }
            if(div.hasClass("h5 menu-course-title")) {
                HillLunchitems.add(div.text());
            }
            if(div.hasClass("menu-item")){
                HillLunchitems.add(div.text());
            }

        }
        //System.out.println(HillLunchitems);

    }

    public static void arrangeArraysHillLunch() throws IOException {
        HillLunchWebScrape();
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

        int hillFieldOfGreens = HillLunchitems.indexOf("Hillcrest Field of Greens");
        int hillGolden = HillLunchitems.indexOf("Hillcrest Golden Harvest");
        int hillPizza = HillLunchitems.indexOf("Hillcrest Piazza Cafe");
        int hillCorner = HillLunchitems.indexOf("Hillcrest Corner Wok");
        int hillGrandAveGrill = HillLunchitems.indexOf("Hillcrest Grand Ave Grill");
        int hillCafeRio = HillLunchitems.indexOf("Hillcrest Cafe Rio Grande");
        int hillDesserts = HillLunchitems.indexOf("Hillcrest Desserts");
        int hillGluten = HillLunchitems.indexOf("Hillcrest Gluten Free");
        int hillDrinks = HillLunchitems.indexOf("Hillcrest Drinks/Condiments");

        indexofHillLunch.add(hillFieldOfGreens);
        indexofHillLunch.add(hillGolden);
        indexofHillLunch.add(hillPizza);
        indexofHillLunch.add(hillCorner);
        indexofHillLunch.add(hillGrandAveGrill);
        indexofHillLunch.add(hillCafeRio);
        indexofHillLunch.add(hillDesserts);
        indexofHillLunch.add(hillGluten);
        indexofHillLunch.add(hillDrinks);

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


        System.out.println(array1HillLunch);
        System.out.println(array2HillLunch);
        System.out.println(array3HillLunch);
        System.out.println(array4HillLunch);
        System.out.println(array5HillLunch);
        System.out.println(array6HillLunch);
        System.out.println(array7HillLunch);
        System.out.println(array8HillLunch);
        System.out.println(array9HillLunch);



    }

    public static void HillDinnerWebScrape() throws IOException {

        HillDinneritems = new ArrayList<>();
        Document document = Jsoup.connect("https://dining.uiowa.edu/hillcrest-market-place").get();

        //Hillcrest Breakfast Scrape
        Element dinnerId = document.getElementById("Dinner");
        Elements dinnerDivs = dinnerId.getElementsByTag("div");
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
        //System.out.println(HillDinneritems);

    }
    public static void arrangeArraysHillDinner() throws IOException {
        HillDinnerWebScrape();
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

        int hillFieldOfGreens = HillDinneritems.indexOf("Hillcrest Field of Greens");
        int hillGolden = HillDinneritems.indexOf("Hillcrest Golden Harvest");
        int hillPizza = HillDinneritems.indexOf("Hillcrest Piazza Cafe");
        int hillCorner = HillDinneritems.indexOf("Hillcrest Corner Wok");
        int hillGrandAveGrill = HillDinneritems.indexOf("Hillcrest Grand Ave Grill");
        int hillCafeRio = HillDinneritems.indexOf("Hillcrest Cafe Rio Grande");
        int hillDesserts = HillDinneritems.indexOf("Hillcrest Desserts");
        int hillGluten = HillDinneritems.indexOf("Hillcrest Gluten Free");
        int hillDrinks = HillDinneritems.indexOf("Hillcrest Drinks/Condiments");

        indexofHillDinner.add(hillFieldOfGreens);
        indexofHillDinner.add(hillGolden);
        indexofHillDinner.add(hillPizza);
        indexofHillDinner.add(hillCorner);
        indexofHillDinner.add(hillGrandAveGrill);
        indexofHillDinner.add(hillCafeRio);
        indexofHillDinner.add(hillDesserts);
        indexofHillDinner.add(hillGluten);
        indexofHillDinner.add(hillDrinks);

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


        System.out.println(array1HillDinner);
        System.out.println(array2HillDinner);
        System.out.println(array3HillDinner);
        System.out.println(array4HillDinner);
        System.out.println(array5HillDinner);
        System.out.println(array6HillDinner);
        System.out.println(array7HillDinner);
        System.out.println(array8HillDinner);
        System.out.println(array9HillDinner);



    }

    public static void main(String[] args) throws IOException {
        //arrangeArraysHillBreakfast();
        //arrangeArraysHillLunch();
        arrangeArraysHillDinner();

    }
}

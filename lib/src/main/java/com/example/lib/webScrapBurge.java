package com.example.lib;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class webScrapBurge {

    public static List<String> BurgeBreakfastitems;
    public static List<String> array1BurgeBreakfast;
    public static List<String> array2BurgeBreakfast;
    public static List<String> array3BurgeBreakfast;
    public static List<String> array4BurgeBreakfast;
    public static List<String> array5BurgeBreakfast;
    public static List<String> array6BurgeBreakfast;
    public static List<Integer> indexofBurgeBreakfast;

    public static List<String> BurgeLunchitems;
    public static List<String> array1BurgeLunch;
    public static List<String> array2BurgeLunch;
    public static List<String> array3BurgeLunch;
    public static List<String> array4BurgeLunch;
    public static List<String> array5BurgeLunch;
    public static List<String> array6BurgeLunch;
    public static List<String> array7BurgeLunch;
    public static List<String> array8BurgeLunch;
    public static List<String> array9BurgeLunch;
    public static List<String> array10BurgeLunch;
    public static List<String> array11BurgeLunch;
    public static List<Integer> indexofBurgeLunch;

    public static List<String> BurgeDinneritems;
    public static List<String> array1BurgeDinner;
    public static List<String> array2BurgeDinner;
    public static List<String> array3BurgeDinner;
    public static List<String> array4BurgeDinner;
    public static List<String> array5BurgeDinner;
    public static List<String> array6BurgeDinner;
    public static List<String> array7BurgeDinner;
    public static List<String> array8BurgeDinner;
    public static List<String> array9BurgeDinner;
    public static List<Integer> indexofBurgeDinner;


    public static void burgeBreakfastWebScrape() throws IOException {
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
        //System.out.println(BurgeBreakfastitems);

    }


    public static void arrangeArraysBurgeBreakfast() throws IOException {
        burgeBreakfastWebScrape();
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

        array1BurgeBreakfast = BurgeBreakfastitems.subList(indexofBurgeBreakfast.get(0),indexofBurgeBreakfast.get(1));
        array2BurgeBreakfast = BurgeBreakfastitems.subList(indexofBurgeBreakfast.get(1),indexofBurgeBreakfast.get(2));
        array3BurgeBreakfast = BurgeBreakfastitems.subList(indexofBurgeBreakfast.get(2),indexofBurgeBreakfast.get(3));
        array4BurgeBreakfast = BurgeBreakfastitems.subList(indexofBurgeBreakfast.get(3),indexofBurgeBreakfast.get(4));
        array5BurgeBreakfast = BurgeBreakfastitems.subList(indexofBurgeBreakfast.get(4),indexofBurgeBreakfast.get(5));
        array6BurgeBreakfast = BurgeBreakfastitems.subList(indexofBurgeBreakfast.get(5), BurgeBreakfastitems.size());

        System.out.println(array1BurgeBreakfast);
        System.out.println(array2BurgeBreakfast);
        System.out.println(array3BurgeBreakfast);
        System.out.println(array4BurgeBreakfast);
        System.out.println(array5BurgeBreakfast);
        System.out.println(array6BurgeBreakfast);

    }

    public static void burgeLunchWebScrape() throws IOException{
        BurgeLunchitems = new ArrayList<>();
        Document document = Jsoup.connect("https://dining.uiowa.edu/burge-market-place").get();
        //Burge Lunch Scrape
        Element lunchId = document.getElementById("Lunch");
        Elements lunchDivs = lunchId.getElementsByTag("div");
        for(Element div : lunchDivs ){
            if(div.hasClass("panel-heading")){
                BurgeLunchitems.add(div.text());
            }
            if(div.hasClass("h5 menu-course-title")) {
                BurgeLunchitems.add(div.text());
            }
            if(div.hasClass("menu-item")){
                BurgeLunchitems.add(div.text());
            }

        }
        //System.out.println(BurgeLunchitems);

    }

    public static void arrangeArraysBurgeLunch() throws IOException {
        burgeLunchWebScrape();
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

        int burgeFruitYogurtbar = BurgeLunchitems.indexOf("Burge Fruit & Yogurt Bar");
        int burgeSaladBar = BurgeLunchitems.indexOf("Burge Salad Bar");
        int burgeCarvingStation = BurgeLunchitems.indexOf("Burge Carving Station");
        int burgePizza = BurgeLunchitems.indexOf("Burge Pizza/Pasta");
        int burgeWrap = BurgeLunchitems.indexOf("Burge It's a Wrap");
        int burgeBreakfastbar = BurgeLunchitems.indexOf("Burge Breakfast Bar");
        int burgeInternational = BurgeLunchitems.indexOf("Burge International");
        int burgeDesserts = BurgeLunchitems.indexOf("Burge Desserts");
        int burgeEastside = BurgeLunchitems.indexOf("Burge Eastside Grille");
        int burgeThrive = BurgeLunchitems.indexOf("Burge Thrive ( Allergen Free )");
        int burgeSantafe = BurgeLunchitems.indexOf("Burge Santa Fe");

        indexofBurgeLunch.add(burgeFruitYogurtbar);
        indexofBurgeLunch.add(burgeSaladBar);
        indexofBurgeLunch.add(burgeCarvingStation);
        indexofBurgeLunch.add(burgePizza);
        indexofBurgeLunch.add(burgeWrap);
        indexofBurgeLunch.add(burgeBreakfastbar);
        indexofBurgeLunch.add(burgeInternational);
        indexofBurgeLunch.add(burgeDesserts);
        indexofBurgeLunch.add(burgeEastside);
        indexofBurgeLunch.add(burgeThrive);
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

        System.out.println(array1BurgeLunch);
        System.out.println(array2BurgeLunch);
        System.out.println(array3BurgeLunch);
        System.out.println(array4BurgeLunch);
        System.out.println(array5BurgeLunch);
        System.out.println(array6BurgeLunch);
        System.out.println(array7BurgeLunch);
        System.out.println(array8BurgeLunch);
        System.out.println(array9BurgeLunch);
        System.out.println(array10BurgeLunch);
        System.out.println(array11BurgeLunch);



    }


    public static void burgeDinnerWebScrape() throws IOException{
        BurgeDinneritems = new ArrayList<>();
        Document document = Jsoup.connect("https://dining.uiowa.edu/burge-market-place").get();
        //Burge Lunch Scrape
        Element dinnerId = document.getElementById("Dinner");
        Elements dinnerDivs = dinnerId.getElementsByTag("div");
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
        //System.out.println(BurgeDinneritems);

    }

    public static void arrangeArraysDinnerLunch() throws IOException {
        burgeDinnerWebScrape();
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

        int burgeFruitYogurtbar = BurgeDinneritems.indexOf("Burge Fruit & Yogurt Bar");
        int burgeSaladBar = BurgeDinneritems.indexOf("Burge Salad Bar");
        int burgeWrap = BurgeDinneritems.indexOf("Burge It's a Wrap");
        int burgeCarvingStation = BurgeDinneritems.indexOf("Burge Carving Station");
        int burgeDesserts = BurgeDinneritems.indexOf("Burge Desserts");
        int burgePizza = BurgeDinneritems.indexOf("Burge Pizza/Pasta");
        int burgeThrive = BurgeDinneritems.indexOf("Burge Thrive ( Allergen Free )");
        int burgeEastside = BurgeDinneritems.indexOf("Burge Eastside Grille");
        int burgeSantafe = BurgeDinneritems.indexOf("Burge Santa Fe");
        indexofBurgeDinner.add(burgeFruitYogurtbar);
        indexofBurgeDinner.add(burgeSaladBar);
        indexofBurgeDinner.add(burgeWrap);
        indexofBurgeDinner.add(burgeCarvingStation);
        indexofBurgeDinner.add(burgeDesserts);
        indexofBurgeDinner.add(burgePizza);
        indexofBurgeDinner.add(burgeThrive);
        indexofBurgeDinner.add(burgeEastside);
        indexofBurgeDinner.add(burgeSantafe);
        Collections.sort(indexofBurgeDinner);
        //System.out.println(indexofBurgeDinner);

        array1BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(0), indexofBurgeDinner.get(1));
        array2BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(1), indexofBurgeDinner.get(2));
        array3BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(2), indexofBurgeDinner.get(3));
        array4BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(3), indexofBurgeDinner.get(4));
        array5BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(4), indexofBurgeDinner.get(5));
        array6BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(5), indexofBurgeDinner.get(6));
        array7BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(6), indexofBurgeDinner.get(7));
        array8BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(7), indexofBurgeDinner.get(8));
        array9BurgeDinner = BurgeDinneritems.subList(indexofBurgeDinner.get(8),BurgeDinneritems.size());

        System.out.println(array1BurgeDinner);
        System.out.println(array2BurgeDinner);
        System.out.println(array3BurgeDinner);
        System.out.println(array4BurgeDinner);
        System.out.println(array5BurgeDinner);
        System.out.println(array6BurgeDinner);
        System.out.println(array7BurgeDinner);
        System.out.println(array8BurgeDinner);
        System.out.println(array9BurgeDinner);


    }




    public static void main(String[] args) throws IOException {

//        arrangeArraysBurgeBreakfast();
//
//        arrangeArraysBurgeLunch();

        arrangeArraysDinnerLunch();


    }
}


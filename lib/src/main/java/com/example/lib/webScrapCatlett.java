package com.example.lib;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class webScrapCatlett {


    public static List<String> CatletBreakfastitems;
    public static List<String> array1CatlettBreakfast;
    public static List<String> array2CatlettBreakfast;
    public static List<String> array3CatlettBreakfast;
    public static List<String> array4CatlettBreakfast;
    public static List<Integer> indexofCatlettBreakfast;

    public static List<String> CatletLunchitems;
    public static List<String> array1CatlettLunch;
    public static List<String> array2CatlettLunch;
    public static List<String> array3CatlettLunch;
    public static List<String> array4CatlettLunch;
    public static List<String> array5CatlettLunch;
    public static List<String> array6CatlettLunch;
    public static List<String> array7CatlettLunch;
    public static List<Integer> indexofCatlettLunch;

    public static List<String> CatletDinneritems;
    public static List<String> array1CatlettDinner;
    public static List<String> array2CatlettDinner;
    public static List<String> array3CatlettDinner;
    public static List<String> array4CatlettDinner;
    public static List<String> array5CatlettDinner;
    public static List<String> array6CatlettDinner;
    public static List<Integer> indexofCatlettDinner;


    public static void CatlettBreakfastWebScrape() throws IOException {

        CatletBreakfastitems = new ArrayList<>();
        Document document = Jsoup.connect("https://dining.uiowa.edu/catlett-market-place").get();

        //Catlett Breakfast Scrape
        Element breakfastId = document.getElementById("Breakfast");
        Elements breakfastDivs = breakfastId.getElementsByTag("div");
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
        //System.out.println(CatletBreakfastitems);

    }

    public static void arrangeArraysCatlettBreakfast() throws IOException {
        CatlettBreakfastWebScrape();
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


        System.out.println(array1CatlettBreakfast);
        System.out.println(array2CatlettBreakfast);
        System.out.println(array3CatlettBreakfast);
        System.out.println(array4CatlettBreakfast);


    }

    public static void CatlettLunchWebScrape() throws IOException {

        CatletLunchitems = new ArrayList<>();
        Document document = Jsoup.connect("https://dining.uiowa.edu/catlett-market-place").get();

        //Catlett Lunch Scrape
        Element lunchId = document.getElementById("Lunch");
        Elements lunchDivs = lunchId.getElementsByTag("div");
        for(Element div : lunchDivs ){
            if(div.hasClass("panel-heading")){
                CatletLunchitems.add(div.text());
            }
            if(div.hasClass("h5 menu-course-title")) {
                CatletLunchitems.add(div.text());
            }
            if(div.hasClass("menu-item")){
                CatletLunchitems.add(div.text());
            }

        }
        //System.out.println(CatletLunchitems);

    }

    public static void arrangeArraysCatlettLunch() throws IOException {
        CatlettLunchWebScrape();
        array1CatlettLunch = new ArrayList<>();
        array2CatlettLunch = new ArrayList<>();
        array3CatlettLunch = new ArrayList<>();
        array4CatlettLunch = new ArrayList<>();
        array5CatlettLunch = new ArrayList<>();
        array6CatlettLunch = new ArrayList<>();
        array7CatlettLunch = new ArrayList<>();

        indexofCatlettLunch = new ArrayList<>();
        int catlettSunnySide = CatletLunchitems.indexOf("Catlett Sunny Side Up");
        int catlettSprouts = CatletLunchitems.indexOf("Catlett Sprouts");
        int catlettFamilyTable = CatletLunchitems.indexOf("Catlett Family Table");
        int catlettZa = CatletLunchitems.indexOf("Catlett Za!");
        int catlettFlavorsAbroad = CatletLunchitems.indexOf("Catlett Flavors Abroad");
        int catlettFireup = CatletLunchitems.indexOf("Catlett Fire Up");
        int catlettDelights = CatletLunchitems.indexOf("Catlett Delights");

        indexofCatlettLunch.add(catlettSunnySide);
        indexofCatlettLunch.add(catlettSprouts);
        indexofCatlettLunch.add(catlettFamilyTable);
        indexofCatlettLunch.add(catlettZa);
        indexofCatlettLunch.add(catlettFlavorsAbroad);
        indexofCatlettLunch.add(catlettFireup);
        indexofCatlettLunch.add(catlettDelights);

        Collections.sort(indexofCatlettLunch);

        array1CatlettLunch = CatletLunchitems.subList(indexofCatlettLunch.get(0),indexofCatlettLunch.get(1));
        array2CatlettLunch = CatletLunchitems.subList(indexofCatlettLunch.get(1),indexofCatlettLunch.get(2));
        array3CatlettLunch= CatletLunchitems.subList(indexofCatlettLunch.get(2),indexofCatlettLunch.get(3));
        array4CatlettLunch = CatletLunchitems.subList(indexofCatlettLunch.get(3),indexofCatlettLunch.get(4));
        array5CatlettLunch = CatletLunchitems.subList(indexofCatlettLunch.get(4),indexofCatlettLunch.get(5));
        array6CatlettLunch = CatletLunchitems.subList(indexofCatlettLunch.get(5),indexofCatlettLunch.get(6));
        array7CatlettLunch = CatletLunchitems.subList(indexofCatlettLunch.get(6),CatletLunchitems.size());



        System.out.println(array1CatlettLunch);
        System.out.println(array2CatlettLunch);
        System.out.println(array3CatlettLunch);
        System.out.println(array4CatlettLunch);
        System.out.println(array5CatlettLunch);
        System.out.println(array6CatlettLunch);
        System.out.println(array7CatlettLunch);


    }

    public static void CatlettDinnerWebScrape() throws IOException {

        CatletDinneritems = new ArrayList<>();
        Document document = Jsoup.connect("https://dining.uiowa.edu/catlett-market-place").get();

        //Catlett Dinner Scrape
        Element dinnerId = document.getElementById("Dinner");
        Elements dinnerDivs = dinnerId.getElementsByTag("div");
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
        //System.out.println(CatletDinneritems);

    }

    public static void arrangeArraysCatlettDinner() throws IOException {
        CatlettDinnerWebScrape();
        array1CatlettDinner = new ArrayList<>();
        array2CatlettDinner = new ArrayList<>();
        array3CatlettDinner = new ArrayList<>();
        array4CatlettDinner = new ArrayList<>();
        array5CatlettDinner = new ArrayList<>();
        array6CatlettDinner = new ArrayList<>();
        indexofCatlettDinner = new ArrayList<>();

        int catlettSprouts = CatletDinneritems.indexOf("Catlett Sprouts");
        int catlettFamilyTable = CatletDinneritems.indexOf("Catlett Family Table");
        int catlettZa = CatletDinneritems.indexOf("Catlett Za!");
        int catlettFlavorsAbroad = CatletDinneritems.indexOf("Catlett Flavors Abroad");
        int catlettFireup = CatletDinneritems.indexOf("Catlett Fire Up");
        int catlettDelights = CatletDinneritems.indexOf("Catlett Delights");

        indexofCatlettDinner.add(catlettSprouts);
        indexofCatlettDinner.add(catlettFamilyTable);
        indexofCatlettDinner.add(catlettZa);
        indexofCatlettDinner.add(catlettFlavorsAbroad);
        indexofCatlettDinner.add(catlettFireup);
        indexofCatlettDinner.add(catlettDelights);

        Collections.sort(indexofCatlettDinner);

        array1CatlettDinner = CatletDinneritems.subList(indexofCatlettDinner.get(0),indexofCatlettDinner.get(1));
        array2CatlettDinner = CatletDinneritems.subList(indexofCatlettDinner.get(1),indexofCatlettDinner.get(2));
        array3CatlettDinner = CatletDinneritems.subList(indexofCatlettDinner.get(2),indexofCatlettDinner.get(3));
        array4CatlettDinner = CatletDinneritems.subList(indexofCatlettDinner.get(3),indexofCatlettDinner.get(4));
        array5CatlettDinner = CatletDinneritems.subList(indexofCatlettDinner.get(4),indexofCatlettDinner.get(5));
        array6CatlettDinner = CatletDinneritems.subList(indexofCatlettDinner.get(5),CatletDinneritems.size());


        System.out.println(array1CatlettDinner);
        System.out.println(array2CatlettDinner);
        System.out.println(array3CatlettDinner);
        System.out.println(array4CatlettDinner);
        System.out.println(array5CatlettDinner);
        System.out.println(array6CatlettDinner);


    }

    public static void main(String[] args) throws IOException {
        //arrangeArraysCatlettBreakfast();
        //arrangeArraysCatlettLunch();
        arrangeArraysCatlettDinner();

    }

}


package com.example.lib;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyClass {

    public static List<String> BurgeBreakfastitems;
    public static List<String> BBurgeFruitBar;
    public static List<String> BBurgeBreakfastBar;
    public static List<String> BBurgeEastsideGrille;
    public static List<String> BBurgeDesserts;
    public static List<String> BBurgeSantaFe;
    public static List<String> BBurgeThrive;

    public static List<String> BurgeLunchitems;
    public static List<String> LBurgeFruitBar;
    public static List<String> LBurgeSaladBar;
    public static List<String> LBurgeCarvingStation;
    public static List<String> LBurgePizza;
    public static List<String> LBurgeWrap;
    public static List<String> LBurgeBreakfastBar;
    public static List<String> LBurgeInternational;
    public static List<String> LBurgeDesserts;
    public static List<String> LBurgerEastsideGrille;
    public static List<String> LBurgeThrive;
    public static List<String> LBurgeSantaFe;

    public static List<String> BurgeDinneritems;
    public static List<String> DBurgeFruitBar;
    public static List<String> DBurgeSaladBar;
    public static List<String> DBurgeWrap;
    public static List<String> DBurgeCarvingStation;
    public static List<String> DBurgeDesserts;
    public static List<String> DBurgePizza;
    public static List<String> DBurgeThrive;
    public static List<String> DBurgeEastsideGrille;
    public static List<String> DBurgeSanatFe;


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

    public static void arrangeArraysBurgeBreakfast(){
        BBurgeFruitBar = new ArrayList<>();
        BBurgeBreakfastBar = new ArrayList<>();
        BBurgeEastsideGrille = new ArrayList<>();
        BBurgeDesserts = new ArrayList<>();
        BBurgeSantaFe = new ArrayList<>();
        BBurgeThrive = new ArrayList<>();
        int burgeFruitYogurtbar = BurgeBreakfastitems.indexOf("Burge Fruit & Yogurt Bar");
        int burgeBreakfastBar = BurgeBreakfastitems.indexOf("Burge Breakfast Bar");
        int burgeEastsideGrille = BurgeBreakfastitems.indexOf("Burge Eastside Grille");
        int burgeDesserts = BurgeBreakfastitems.indexOf("Burge Desserts");
        int burgeSanteFe = BurgeBreakfastitems.indexOf("Burge Santa Fe");
        int burgeThrive = BurgeBreakfastitems.indexOf("Burge Thrive ( Allergen Free )");
        BBurgeFruitBar = BurgeBreakfastitems.subList(burgeFruitYogurtbar,burgeBreakfastBar);
        BBurgeBreakfastBar = BurgeBreakfastitems.subList(burgeBreakfastBar,burgeEastsideGrille);
        BBurgeEastsideGrille = BurgeBreakfastitems.subList(burgeEastsideGrille,burgeDesserts);
        //BBurgeDesserts = BurgeBreakfastitems.subList(burgeDesserts,burgeSanteFe);
        BBurgeSantaFe = BurgeBreakfastitems.subList(burgeSanteFe,burgeThrive);
        BBurgeThrive = BurgeBreakfastitems.subList(burgeThrive, BurgeBreakfastitems.size());

//        System.out.println(BBurgeFruitBar);
//        System.out.println(BBurgeBreakfastBar);
//        System.out.println(BBurgeEastsideGrille);
//        System.out.println(BBurgeDesserts);
//        System.out.println(BBurgeSantaFe);
//        System.out.println(BBurgeThrive);

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

    public static void arrangeArraysBurgeLunch(){
        LBurgeFruitBar = new ArrayList<>();
        LBurgeSaladBar = new ArrayList<>();
        LBurgeCarvingStation = new ArrayList<>();
        LBurgePizza = new ArrayList<>();
        LBurgeWrap = new ArrayList<>();
        LBurgeBreakfastBar = new ArrayList<>();
        LBurgeInternational = new ArrayList<>();
        LBurgeDesserts = new ArrayList<>();
        LBurgerEastsideGrille = new ArrayList<>();
        LBurgeThrive = new ArrayList<>();
        LBurgeSantaFe = new ArrayList<>();
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
        LBurgeFruitBar = BurgeLunchitems.subList(burgeFruitYogurtbar,burgeSaladBar);
        LBurgeSaladBar = BurgeLunchitems.subList(burgeSaladBar,burgeCarvingStation);
        LBurgeCarvingStation = BurgeLunchitems.subList(burgeCarvingStation,burgePizza);
        LBurgePizza = BurgeLunchitems.subList(burgePizza,burgeWrap);
        LBurgeWrap = BurgeLunchitems.subList(burgeWrap,burgeBreakfastbar);
        LBurgeBreakfastBar = BurgeLunchitems.subList(burgeBreakfastbar,burgeInternational);
        LBurgeInternational = BurgeLunchitems.subList(burgeInternational,burgeDesserts);
        LBurgeDesserts = BurgeLunchitems.subList(burgeDesserts,burgeEastside);
        LBurgerEastsideGrille = BurgeLunchitems.subList(burgeEastside,burgeThrive);
        LBurgeThrive = BurgeLunchitems.subList(burgeThrive,burgeSantafe);
        LBurgeSantaFe = BurgeLunchitems.subList(burgeSantafe,BurgeLunchitems.size());
//        System.out.println(LBurgeFruitBar);
//        System.out.println(LBurgeSaladBar);
//        System.out.println(LBurgeCarvingStation);
//        System.out.println(LBurgePizza);
//        System.out.println(LBurgeWrap);
//        System.out.println(LBurgeBreakfastBar);
//        System.out.println(LBurgeInternational);
//        System.out.println(LBurgeDesserts);
//        System.out.println(LBurgerEastsideGrille);
//        System.out.println(LBurgeThrive);
//        System.out.println(LBurgeSantaFe);
    }


    public static void burgeDinnerWebScrape() throws IOException{
        BurgeDinneritems = new ArrayList<>();
        Document document = Jsoup.connect("https://dining.uiowa.edu/burge-market-place").get();
        //Burge Lunch Scrape
        Element lunchId = document.getElementById("Dinner");
        Elements lunchDivs = lunchId.getElementsByTag("div");
        for(Element div : lunchDivs ){
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

    public static void arrangeArraysDinnerLunch(){
        DBurgeFruitBar = new ArrayList<>();
        DBurgeSaladBar = new ArrayList<>();
        DBurgeWrap = new ArrayList<>();
        DBurgeCarvingStation = new ArrayList<>();
        DBurgeDesserts = new ArrayList<>();
        DBurgePizza = new ArrayList<>();
        DBurgeThrive = new ArrayList<>();
        DBurgeEastsideGrille = new ArrayList<>();
        DBurgeSanatFe = new ArrayList<>();
        int burgeFruitYogurtbar = BurgeDinneritems.indexOf("Burge Fruit & Yogurt Bar");
        int burgeSaladBar = BurgeDinneritems.indexOf("Burge Salad Bar");
        int burgeWrap = BurgeDinneritems.indexOf("Burge It's a Wrap");
        int burgeCarvingStation = BurgeDinneritems.indexOf("Burge Carving Station");
        int burgeDesserts = BurgeDinneritems.indexOf("Burge Desserts");
        int burgePizza = BurgeDinneritems.indexOf("Burge Pizza/Pasta");
        int burgeThrive = BurgeDinneritems.indexOf("Burge Thrive ( Allergen Free )");
        int burgeEastside = BurgeDinneritems.indexOf("Burge Eastside Grille");
        int burgeSantafe = BurgeDinneritems.indexOf("Burge Santa Fe");
        DBurgeFruitBar = BurgeDinneritems.subList(burgeFruitYogurtbar,burgeSaladBar);
        DBurgeSaladBar = BurgeDinneritems.subList(burgeSaladBar,burgeWrap);
        DBurgeWrap = BurgeDinneritems.subList(burgeWrap,burgeCarvingStation);
        DBurgeCarvingStation = BurgeDinneritems.subList(burgeCarvingStation,burgeDesserts);
        DBurgeDesserts = BurgeDinneritems.subList(burgeDesserts,burgePizza);
        DBurgePizza = BurgeDinneritems.subList(burgePizza,burgeThrive);
        DBurgeThrive = BurgeDinneritems.subList(burgeThrive,burgeEastside);
        DBurgeEastsideGrille = BurgeDinneritems.subList(burgeEastside,burgeSantafe);
        DBurgeSanatFe = BurgeDinneritems.subList(burgeSantafe,BurgeDinneritems.size());
        System.out.println(DBurgeFruitBar);
        System.out.println(DBurgeSaladBar);
        System.out.println(DBurgeWrap);
        System.out.println(DBurgeCarvingStation);
        System.out.println(DBurgeDesserts);
        System.out.println(DBurgePizza);
        System.out.println(DBurgeThrive);
        System.out.println(DBurgeEastsideGrille);
        System.out.println(DBurgeSanatFe);

    }




    public static void main(String[] args) throws IOException {
//        burgeBreakfastWebScrape();
//        arrangeArraysBurgeBreakfast();
//        burgeLunchWebScrape();
//        arrangeArraysBurgeLunch();
        burgeDinnerWebScrape();
        arrangeArraysDinnerLunch();

    }

}


package com.tavisca.testapp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MenuIngredientUtil {
    public static final String MILK = "milk";
    public static final String SUGAR = "sugar";
    public static final String WATER = "water";
    public static final String SODA = "soda";
    public static final String MINT = "mint";

    public static final String COFFEE = "coffee";
    public static final String TEA = "tea";
    public static final String BANANA = "banana";
    public static final String STRAWBERRIES = "strawberries";
    public static final String LEMON = "lemon";

    public static final String CHAI = "chai";
    public static final String BANANA_SMOOTHIE = "banana smoothie";
    public static final String STRAWBERRY_SHAKE = "strawberry shake";
    public static final String MOJITO = "mojito";

    public static Map<String,Menu> createMenu(){
        final Map<String,Menu> menu= new HashMap<>();
        menu.put(COFFEE,new Menu(COFFEE,Arrays.asList(COFFEE,MILK,SUGAR,WATER),5));
        menu.put(CHAI,new Menu(CHAI,Arrays.asList(TEA,MILK,SUGAR,WATER),4));
        menu.put(BANANA_SMOOTHIE,new Menu(BANANA_SMOOTHIE,Arrays.asList(BANANA,MILK,SUGAR,WATER),6));
        menu.put(STRAWBERRY_SHAKE,new Menu(STRAWBERRY_SHAKE,Arrays.asList(STRAWBERRIES,MILK,SUGAR,WATER),7));
        menu.put(MOJITO,new Menu(MOJITO,Arrays.asList(LEMON,SUGAR,WATER,SODA,MINT),7.5));
        return  menu;
    }
    public static Map<String,Double> getIngredientData(){
        final Map<String,Double> ingredientMap = new HashMap<>();
        ingredientMap.put(MILK,1.0);
        ingredientMap.put(SUGAR,0.5);
        ingredientMap.put(WATER,0.5);
        ingredientMap.put(SODA,0.5);
        ingredientMap.put(MINT,0.5);
        ingredientMap.put(COFFEE,1.0);
        ingredientMap.put(TEA,1.0);
        ingredientMap.put(BANANA,1.0);
        ingredientMap.put(STRAWBERRIES,1.0);
        ingredientMap.put(LEMON,1.0);

        return ingredientMap;
    }
}

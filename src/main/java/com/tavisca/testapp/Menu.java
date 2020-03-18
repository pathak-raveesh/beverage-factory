package com.tavisca.testapp;

import java.util.*;

public class Menu {
    private String menuName;
    private List<String> ingredients;
    private double price;

    public Menu(String menuName, List<String> ingredients, double price) {
        this.menuName = menuName;
        this.ingredients = ingredients;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

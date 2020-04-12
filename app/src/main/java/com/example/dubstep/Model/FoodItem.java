package com.example.dubstep.Model;

public class FoodItem {
    String price;
    String name;

    public FoodItem(){

    }

    public FoodItem(String price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}

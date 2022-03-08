package com.example.cookingrecipe;

public class FoodItem {

    private String name;
    private float rating;
    private int time;
    private int image;

    public FoodItem(String name, float rating, int time, int image) {
        this.name = name;
        this.rating = rating;
        this.time = time;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

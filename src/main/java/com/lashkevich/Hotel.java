package com.lashkevich;

public class Hotel {
    private int id;
    private String title;
    private int stars;
    private double price;
    private boolean available;

    public Hotel() {}

    public Hotel(int id, String title, int stars, double price, boolean available) {
        this.id = id;
        this.title = title;
        this.stars = stars;
        this.price = price;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
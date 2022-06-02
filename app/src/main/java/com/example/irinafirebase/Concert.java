package com.example.irinafirebase;

public class Concert {
    private String name;
    private String date;
    private Integer price;

    public Concert(String name, String date, Integer price) {
        this.name = name;
        this.date = date;
        this.price = price;
    }

    public Concert() {
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public Integer getPrice() {
        return price;
    }
}

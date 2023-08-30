package com.group.libraryapp.dto.fruit;

public class FruitCreateRequest {
    private String name;
    private int price;
    private String date; // 원래는 String 대신 localdate 를 사용하지만 어려우니까 String 사용

    public FruitCreateRequest(String name, int price, String date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }
}

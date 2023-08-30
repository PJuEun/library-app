package com.group.libraryapp;

public class ShapeDto {

/*
    private int num;

    public int getNum() {
        return num;
    }

    // static은 클래스의 인스턴스랑 관련이 없다.
    // - static 함수는 인스턴스를 만들지 않고 바로 호출 가능.
    // - static 함수는 클래스 변수를 쓸 수 없다.
    public static int getNum2() {
        return num;
    }
*/

    private String name;
    private double round;

    public ShapeDto(String name, double round) {
        this.name = name;
        this.round = round;
    }

    public String getName() {
        return name;
    }

    public double getRound() {
        return round;
    }
}
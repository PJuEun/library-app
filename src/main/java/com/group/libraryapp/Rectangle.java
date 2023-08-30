package com.group.libraryapp;

import com.group.Shape;

import java.util.List;

public class Rectangle extends Shape {

    /* // Main.java에서 상속 관련 얘기할때,
    @Override
    public double calculateRound() {
        return 3.0;
    }*/

    private double num1;
    private double num2;

    public Rectangle(List<Double> nums) {
        this.num1 = nums.get(0);
        this.num2 = nums.get(1);
    }

    @Override
    public ShapeDto toDto() {
        return new ShapeDto("직사각형", (num1+num2)*2);
    }


}

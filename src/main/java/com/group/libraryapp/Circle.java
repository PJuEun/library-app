package com.group.libraryapp;

import com.group.Shape;

import java.util.List;

public class Circle extends Shape {
    private double r;

    public Circle(List<Double> nums) {
        this.r = nums.get(0);
    }

    @Override
    public ShapeDto toDto() {
        return new ShapeDto("원", 2 * r * Math.PI);
    }
}

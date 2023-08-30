package com.group.libraryapp;

import com.group.Shape;

import java.util.List;

public class Square extends Shape {
    private double num;

    public Square(List<Double> numa) {
        this.num = numa.get(0);
    }

    @Override
    public ShapeDto toDto() {
        return new ShapeDto("정사각형", num * 4);
    }
}

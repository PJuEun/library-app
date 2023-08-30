package com.group.libraryapp.dto.calculator;

public class MinusRequest {
    private double num1;
    private double num2;

    public MinusRequest(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }
}

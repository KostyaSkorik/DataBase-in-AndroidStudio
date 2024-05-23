package com.mirea.kt.hometask_2_10;

public class Car {
    private String model;
    public String number;
    private int year;

    public Car(String model, String number, int year) {
        this.model = model;
        this.number = number;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

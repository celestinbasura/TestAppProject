package com.cele.testapp;

/**
 * Created by Celestin on 11.02.14..
 */
public class Point {
    String name = "Testing";
    String address = "1X001";
    String state = "On";


    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }
}

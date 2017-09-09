package com.example.findingpg;

/**
 * Created by aadi on 1/9/17.
 */

public class Base {

    private String name;

    public Base() {
        // Default constructor required for calls to DataSnapshot.getValue(Base.class)
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

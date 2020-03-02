package com.myironfit.ironfit.models;

public class SetDynamics {

    private String name;

    public SetDynamics(String name) {

    }

    public SetDynamics(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SetDynamics{" +
                "name='" + name + '\'' +
                '}';
    }
}

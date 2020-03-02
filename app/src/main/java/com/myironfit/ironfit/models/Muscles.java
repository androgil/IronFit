package com.myironfit.ironfit.models;

public class Muscles {

    private String muscle;
    private String bodypart;
    // --- Function is for push, pull or stabilizer ---//
    private String function;

    public Muscles(String muscle, String bodypart, String function) {
        this.muscle = muscle;
        this.bodypart = bodypart;
        this.function = function;
    }

    public Muscles() {

    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getBodypart() {
        return bodypart;
    }

    public void setBodypart(String bodypart) {
        this.bodypart = bodypart;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "Muscles{" +
                "muscle='" + muscle + '\'' +
                ", bodypart='" + bodypart + '\'' +
                ", function='" + function + '\'' +
                '}';
    }
}

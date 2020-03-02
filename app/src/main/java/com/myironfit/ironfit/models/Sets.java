package com.myironfit.ironfit.models;

public class Sets {

    private String exercise;
    private int setnum;
    private int reps;
    private int weight;
    private String dynamics;

    public Sets(String exercise, int setnum, int reps, int weight, String dynamics) {

    }

    public Sets(){

    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public int getSetnum() {
        return setnum;
    }

    public void setSetnum(int setnum) {
        this.setnum = setnum;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDynamics() {
        return dynamics;
    }

    public void setDynamics(String dynamics) {
        this.dynamics = dynamics;
    }

    @Override
    public String toString() {
        return "Sets{" +
                "exercise='" + exercise + '\'' +
                ", setnum=" + setnum +
                ", reps=" + reps +
                ", weight=" + weight +
                ", dynamics='" + dynamics + '\'' +
                '}';
    }
}

package com.myironfit.ironfit.models;

public class Exercises {

    private String name;
    private String description;
    private String equipment;
    // --- Type is push, pull, core or legs ---//
    private String type;
    private String muscle;
    private String secondarymuscle;

    public Exercises(String name, String description, String equipment, String type, String muscle, String secondarymuscle) {

    }

    public Exercises() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getSecondarymuscle() {
        return secondarymuscle;
    }

    public void setSecondarymuscle(String secondarymuscle) {
        this.secondarymuscle = secondarymuscle;
    }

    @Override
    public String toString() {
        return "Exercises{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", equipment='" + equipment + '\'' +
                ", type='" + type + '\'' +
                ", muscle='" + muscle + '\'' +
                ", secondarymuscle='" + secondarymuscle + '\'' +
                '}';
    }
}

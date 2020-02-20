package com.myironfit.ironfit.models;

public class RecentHistory {

    private String day, date, month, name, muscles, exercises, duration;


    public RecentHistory(String day, String date, String month, String name, String muscles, String exercises, String duration) {
        this.day = day;
        this.date = date;
        this.month = month;
        this.name = name;
        this.muscles = muscles;
        this.exercises = exercises;
        this.duration = duration;
    }

    public RecentHistory(){
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscles() {
        return muscles;
    }

    public void setMuscles(String muscles) {
        this.muscles = muscles;
    }

    public String getExercises() {
        return exercises;
    }

    public void setExercises(String exercises) {
        this.exercises = exercises;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}

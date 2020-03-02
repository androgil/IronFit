package com.myironfit.ironfit.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Sessions {

    private String name;
    private String date;
    private String timestart;
    private String timeend;
    private String duration;
    private String goal;
    private String notes;

    private List<Exercises> mExercises = new ArrayList<>();
    private List<Sets> mSets = new ArrayList<>();
    private List<Muscles> mMuscles = new ArrayList<>();

    public Sessions(String name, String date, String timestart, String timeend, String duration, String goal, String notes, List mExercises, List mSets, List mMuscles) {

    }

    public Sessions(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimestart() {
        return timestart;
    }

    public void setTimestart(String timestart) {
        this.timestart = timestart;
    }

    public String getTimeend() {
        return timeend;
    }

    public void setTimeend(String timeend) {
        this.timeend = timeend;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Exercises> getmExercises() {
        return mExercises;
    }

    public void setmExercises(List<Exercises> mExercises) {
        this.mExercises = mExercises;
    }

    public List<Sets> getmSets() {
        return mSets;
    }

    public void setmSets(List<Sets> mSets) {
        this.mSets = mSets;
    }

    public List<Muscles> getmMuscles() {
        return mMuscles;
    }

    public void setmMuscles(List<Muscles> mMuscles) {
        this.mMuscles = mMuscles;
    }

    @Override
    public String toString() {
        return "Sessions{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", timestart='" + timestart + '\'' +
                ", timeend='" + timeend + '\'' +
                ", duration='" + duration + '\'' +
                ", goal='" + goal + '\'' +
                ", notes='" + notes + '\'' +
                ", mExercises=" + mExercises +
                ", mSets=" + mSets +
                ", mMuscles=" + mMuscles +
                '}';
    }
}

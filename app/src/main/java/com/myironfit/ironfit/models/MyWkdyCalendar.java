package com.myironfit.ironfit.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyWkdyCalendar {
    // storing day - like Sun, Wed etc..,
    // date like 1, 2 etc..
    //Month 1..12
    // year .. 2019.. beyond

    private String day;
    private String date, month, year;
    private int pos, txtColor, lineVisible, dotVisible;

    public MyWkdyCalendar() {
    }

    public MyWkdyCalendar(String day, String date, String month, String year, int i, int color, int visible) {
        this.day = day;
        this.date = date;
        this.month = getMonthStr(month);
        this.year = year;
        this.pos =i;
        this.txtColor = color;
        this.lineVisible = visible;
        this.dotVisible = visible;


    }
    private String getMonthStr(String month){

        Calendar cal=Calendar.getInstance();

        SimpleDateFormat month_date = new SimpleDateFormat("MMM");
        int monthnum=Integer.parseInt(month);
        cal.set(Calendar.MONTH,monthnum);
        String month_name = month_date.format(cal.getTime());
        return month_name;

    }

    /**
     *  ------------ Data Model Functions -----------------
     */

    public int getPos() {
        return pos;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String date) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    public String getMonth() {
        return month;
    }


    public String getYear() {
        return year;
    }


    public void setYear(String year) {
        this.year = year;
    }

    /**
     *  ------------ UI Model Functions -----------------
     */

    public int getDotVisible(){
        return dotVisible;
    }

    public int getTxtColor(){
        return txtColor;
    }

    public void setTxtColor(int color){
        txtColor = color;
    }

    public int getLnVisible(){
        return lineVisible;
    }

    public void setLnVisible(int visible){
        lineVisible = visible;
    }



}

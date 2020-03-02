package com.myironfit.ironfit.models;

public class Profile {

    private String name;
    private String age;
    private String height;
    private String weight;
    private String bodyfat;

    public Profile(String name, String age, String height, String weight, String bodyfat) {

    }

    public Profile() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBodyfat() {
        return bodyfat;
    }

    public void setBodyfat(String bodyfat) {
        this.bodyfat = bodyfat;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", bodyfat='" + bodyfat + '\'' +
                '}';
    }
}

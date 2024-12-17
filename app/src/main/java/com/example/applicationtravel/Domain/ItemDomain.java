package com.example.applicationtravel.Domain;

import java.io.Serializable;

public class ItemDomain implements Serializable {
    private String title;
    private String address;
    private String description;
    private String pic;
    private String duration;
    private String timetour;
    private String datetour;
    private String tourguidename;
    private String tourguidephone;
    private String tourguidepic;
    private int price;
    private int bed;
    private String distance;
    private double score;

    public ItemDomain() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTimetour() {
        return timetour;
    }

    public void setTimetour(String timetour) {
        this.timetour = timetour;
    }

    public String getDatetour() {
        return datetour;
    }

    public void setDatetour(String datetour) {
        this.datetour = datetour;
    }

    public String getTourguidename() {
        return tourguidename;
    }

    public void setTourguidename(String tourguidename) {
        this.tourguidename = tourguidename;
    }

    public String getTourguidephone() {
        return tourguidephone;
    }

    public void setTourguidephone(String tourguidephone) {
        this.tourguidephone = tourguidephone;
    }

    public String getTourguidepic() {
        return tourguidepic;
    }

    public void setTourguidepic(String tourguidepic) {
        this.tourguidepic = tourguidepic;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

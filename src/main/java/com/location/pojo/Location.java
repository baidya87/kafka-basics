package com.location.pojo;

public class Location {
    private String city;
    private float longitude;
    private float latitude;

    public Location(){}

    public Location(String city, float latitude, float longitude){
        this.city = city;
        this.latitude = latitude;
        this.longitude =  longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}

package com.example.randomuserapp.data;

public class Location {

    private String street;
    private String city;
    private String state;
    private String postcode;
    private Coordinates coordinates;
    private Timezone timezone;

    public void setStreet(String street){
        this.street = street;
    }
    public String getStreet(){
        return this.street;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setState(String state){ this.state = state; }
    public String getState(){
        return this.state;
    }
    public void setPostcode(String postcode){
        this.postcode = postcode;
    }
    public String getPostcode(){
        return this.postcode;
    }
    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }
    public Coordinates getCoordinates(){
        return this.coordinates;
    }
    public void setTimezone(Timezone timezone){
        this.timezone = timezone;
    }
    public Timezone getTimezone(){
        return this.timezone;
    }
}

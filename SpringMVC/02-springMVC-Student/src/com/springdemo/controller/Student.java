package com.springdemo.controller;

import org.springframework.beans.factory.annotation.Value;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private String operatingSystem;

//    LinkedHashMap<String, String> favoriteLanguageOptions;


//    if we would like to hardcode country options
//    no:1-2-3 parts should be working.
//    No:1
//    private LinkedHashMap<String, String> countryOptions;
//    populate country options: used ISO country code



    public Student() {
//    No:2
//        countryOptions.put("BR","Bra");
//        countryOptions.put("TR","Turkey");
//        countryOptions.put("GR","Germany");
//        countryOptions.put("FR","French");
//        countryOptions.put("US","America");

//        favoriteLanguageOptions = new LinkedHashMap<String,String>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    //    No:3
//    public LinkedHashMap<String, String> getCountryOptions() {
//        return countryOptions;
//    }

}

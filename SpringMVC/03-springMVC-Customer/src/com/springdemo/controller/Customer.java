package com.springdemo.controller;

import com.springdemo.validation.CourseCode;
import javax.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message="is required.")
    @Size(min=1,message="is required.")
    private String lastName;

    @Min(value = 0,message = "Must be greater than 0")
    @Max(value = 10,message = "Must be lower than 10")
    @NotNull(message="is required.")
    private Integer freePasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}",message = "Please enter 5 chars/digits")
    private String postalCode;

    @CourseCode(value = {"RED","BLUE"}, message = "must start with 'RED' or 'BLUE' ")
    private String courseCode;

    public Customer() {
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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}

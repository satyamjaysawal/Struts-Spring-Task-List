package net.javaguides.sms.entity;

import jakarta.persistence.*;

@Embeddable
public class Address {

    private String streetAddress;
    private String apartment;
    private String city;

    // Constructors, getters, setters, and other methods

    // Constructors

    public Address() {
        // Default constructor required by JPA
    }

    public Address(String streetAddress, String apartment, String city) {
        this.streetAddress = streetAddress;
        this.apartment = apartment;
        this.city = city;
    }

    // Getters and Setters

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

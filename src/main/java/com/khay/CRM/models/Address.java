package com.khay.CRM.models;

import javax.persistence.*;

@Entity
@Table(name = "addresstbl")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int addressId;

    @Column(name="region")
    private String region;

    @Column(name = "city")
    private String city;

    public Address() {
    }

    public Address(String region, String city) {
        this.region = region;
        this.city = city;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

package com.airline.AirlineSystem.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "passengers")
public class Passenger {

    @Transient
    public static final String SEQUENCE_NAME = "passengers_sequence";

    @Id
    private Long id;

    private String name;

    private String mobileNumber;

    private String NIC;

    @DBRef
    private Flight flight;

    @DBRef
    private Package aPackage;

    public Passenger() {
        super();
    }

    public Passenger(String name, String mobileNumber, String NIC, Flight flight, Package aPackage) {
        super();
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.NIC = NIC;
        this.flight=flight;
        this.aPackage = aPackage;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }
}

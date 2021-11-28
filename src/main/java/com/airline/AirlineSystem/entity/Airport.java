package com.airline.AirlineSystem.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "airports")
public class Airport {

@Transient
public static final String SEQUENCE_NAME = "airports_sequence";

    @Id
    private Long id;


    private String name;

    private String country;

    public Airport(String name, String country) {
        super();
        this.name = name;
        this.country = country;
    }

    public Airport() {
        super();
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



}

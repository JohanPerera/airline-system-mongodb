package com.airline.AirlineSystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "packages")
public class Package {

    @Transient
    public static final String SEQUENCE_NAME = "packages_sequence";

    @Id
    private Long id;

    private String name;

    private String price;

    public Package(String name, String price) {
        super();
        this.name = name;
        this.price = price;
    }

    public Package() {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
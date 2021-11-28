package com.airline.AirlineSystem.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "planes")
public class Plane {


    @Transient
    public static final String SEQUENCE_NAME = "planes_sequence";

    @Id
    private Long id;
    private String registration_number;
    private String model_number;
    private String passenger_capacity;

    public Plane(String registration_number, String model_number,String passenger_capacity) {
        super();
        this.registration_number = registration_number;
        this.model_number = model_number;
        this.passenger_capacity = passenger_capacity;
    }

    public Plane() {
        super();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getModel_number() {
        return model_number;
    }

    public void setModel_number(String model_number) {
        this.model_number = model_number;
    }

    public String getPassenger_capacity() {
        return passenger_capacity;
    }

    public void setPassenger_capacity(String passenger_capacity) {
        this.passenger_capacity = passenger_capacity;
    }
}

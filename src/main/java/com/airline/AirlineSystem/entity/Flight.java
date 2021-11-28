package com.airline.AirlineSystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "flights")
public class Flight {

    @Transient
    public static final String SEQUENCE_NAME = "flights_sequence";

    @Id
    private Long id;

    private String plane;

    @DBRef
    private Airport fromAirport;

    @DBRef
    private Airport toAirport;

    private Date depTime;

    public Flight() {
        super();
    }

    public Flight(String plane, Airport fromAirport, Airport toAirport, Date depTime) {
        super();
        this.plane = plane;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.depTime = depTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(Airport fromAirport) {
        this.fromAirport = fromAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }

    public Date getDepTime() {
        return depTime;
    }

    public void setDepTime(Date depTime) {
        this.depTime = depTime;
    }
}

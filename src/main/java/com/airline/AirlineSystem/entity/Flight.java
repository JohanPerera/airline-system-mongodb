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

    @DBRef
    private Airport fromAirport;

    @DBRef
    private Airport toAirport;

    @DBRef
    private Pilot pilot;

    @DBRef
    private Plane plane;

    private Date depTime;

    public Flight() {
        super();
    }

    public Flight(String plane, Airport fromAirport, Airport toAirport, Pilot pilot, Plane plane1, Date depTime) {
        super();
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.pilot = pilot;
        this.plane = plane1;
        this.depTime = depTime;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

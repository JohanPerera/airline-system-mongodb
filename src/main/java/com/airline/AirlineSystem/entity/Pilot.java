package com.airline.AirlineSystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pilots")
public class Pilot {

    @Transient
    public static final String SEQUENCE_NAME = "pilots_sequence";

    @Id
    private Long id;
    private String name;
    private int age;

    public Pilot(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Pilot() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

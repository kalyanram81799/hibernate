package com.rvr.app;

import jakarta.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public Department() {}

    public Department(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
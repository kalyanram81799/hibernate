package com.rvr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Employee1 {

    @Id
    private int eid;
    private int age;
    private String ename;

    @Transient
    private String ecity;

    // Constructor
    public Employee1() {
        System.out.println("Employee constructor");
    }

    // Getters and Setters

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEcity() {
        return ecity;
    }

    public void setEcity(String ecity) {
        this.ecity = ecity;
    }

    @Override
    public String toString() {
        return "Employee1 [eid=" + eid + ", age=" + age + ", ename=" + ename + ", ecity=" + ecity + "]";
    }
}
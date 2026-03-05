package com.rvr.app;

import jakarta.persistence.*;

@Entity
@Table(name="passport")
public class Passport {

    @Id
    private int passportId;

    private String passportNumber;

    @OneToOne(mappedBy="passport")
    private Person person;

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

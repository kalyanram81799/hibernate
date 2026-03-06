package com.rvr.app;



import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    @ManyToMany(mappedBy="courses")
    private Set<Student> students;

    public Course(){}

    public Course(String title){
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
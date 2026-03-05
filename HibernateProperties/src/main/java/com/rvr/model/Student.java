package com.rvr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Student_table")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="student_id")
private int sid;
@Column(name="Student_name")
private String sname;
@Column(name="student_city")
private String scity;
public int getsid() {
	return sid;
}
public Student() {
	System.out.println("student constructor");
}
public void setsid(int sid) {
	this.sid = sid;
}
public String getsname() {
	return sname;
}
public void setsname(String sname) {
	this.sname = sname;
}
public String getscity() {
	return scity;
}
public void setscity(String scity) {
	this.scity = scity;
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", sname=" + sname + ", scity=" + scity + "]";
}



}


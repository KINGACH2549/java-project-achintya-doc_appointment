package com.java_project_achintya.doctorAppointment.entities;

public class Doctor {
  private int doctorID;
  private String name;
  private String specialization;
public int getDoctorID() {
	return doctorID;
}
public void setDoctorID(int doctorID) {
	this.doctorID = doctorID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSpecialization() {
	return specialization;
}
public void setSpecialization(String specialization) {
	this.specialization = specialization;
}
@Override
public String toString() {
	return "Doctor [doctorID=" + doctorID + ", name=" + name + ", specialization=" + specialization + "]";
}
  
  
}

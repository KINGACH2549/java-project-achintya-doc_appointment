package com.java_project_achintya.doctorAppointment.entities;

public class Appointment {
   
	
	private int id;
	private int customerID;
	private int doctorID;
	private String doctorName;
	private String customerName;
	private String Consulting;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getConsulting() {
		return Consulting;
	}
	public void setConsulting(String consulting) {
		Consulting = consulting;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", customerID=" + customerID + ", doctorID=" + doctorID + ", doctorName="
				+ doctorName + ", customerName=" + customerName + ", Consulting=" + Consulting + "]";
	
	}
	
	
}

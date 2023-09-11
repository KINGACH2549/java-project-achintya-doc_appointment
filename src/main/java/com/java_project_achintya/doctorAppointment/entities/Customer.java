package com.java_project_achintya.doctorAppointment.entities;

public class Customer {
   private int id;
   private String emailId;
   private int age;
   private String name;
   private String contactNumber;
   public Customer() {
	   this.id=-1;
	   this.emailId=null;
	   this.age=-1;
	   this.name=null;
	   
   }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", emailId=" + emailId + ", age=" + age + ", name=" + name + ", contactNumber="
			+ contactNumber + "]";
}


   
}

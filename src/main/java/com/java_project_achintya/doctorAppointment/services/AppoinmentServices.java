package com.java_project_achintya.doctorAppointment.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java_project_achintya.doctorAppointment.dao.impl.AppointmentDaoImpl;
import com.java_project_achintya.doctorAppointment.entities.Appointment;
import com.java_project_achintya.doctorAppointment.entities.Doctor;

public class AppoinmentServices {
	
    private AppointmentDaoImpl appointmentDao = new AppointmentDaoImpl();
    private Appointment appointmentData = new Appointment();
    private DoctorServices doctorService = new DoctorServices();
    private Scanner sc = new Scanner(System.in);
	public void bookAppointment() {
		
		//create booking for appointment
//        appointmentDao		
		
		System.out.println("Enter customer ID :");
		appointmentData.setCustomerID(Integer.parseInt(sc.nextLine()));
		System.out.println();
		System.out.println("Choose the doctor below to proceed with your bookings.... Press the button corresponding to Doctor ID. \n");
		doctorService.getAllDoctors();
		appointmentData.setDoctorID(Integer.parseInt(sc.nextLine()));
		System.out.println();
		try {
			if(appointmentDao.create(appointmentData)) {
				System.out.println("Appointment Created Successfully!!! \n");
			}else {
				System.out.println("Could not create Appointment Please Try again!! \n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	
	}
	
	public void updateAppointment() {
		
		getAppointmentByID(); 
		
		
			
			System.out.println("Press 1 to update Doctor ID : ");
			System.out.println("Press 0 to Exit from Appointment Update: ");
			int option = Integer.parseInt(sc.nextLine());
			
			switch(option) {
			case 0 : try {
					if(appointmentDao.update(appointmentData)) System.out.println("Updated Successfully !!") ;
					         else {
					        	 System.out.println("Could not Update !!");
					         }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
			          System.out.println(e.getMessage());
				}break;
			
			case 1 : System.out.println("Enter the new doctorID you want to select from table shown below :");
			         doctorService.getAllDoctors();
			         appointmentData.setDoctorID(Integer.parseInt(sc.nextLine()));
			         break;
			default : System.out.println("Enter a valid option or choose 0 to exit!!");
			           break;
			}
			
			
		
		
	}
	
	public void deleteAppointment() {
		
		System.out.println("Enter appointment ID you want to delete : ");
		
		int appointmentID = Integer.parseInt(sc.nextLine());
		
		try {
			if(appointmentDao.delete(appointmentID)) {
				System.out.println("Deleted Successfully!!");
			}else {
				System.out.println("Could Not Delete Please try again !!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
    
	public void getAllAppointment(){
	List<Appointment> appointmentList = new ArrayList<Appointment>();
		
		try {
			appointmentList = appointmentDao.getAll();
			
			for (Appointment appointment : appointmentList) {
				
				System.out.println(appointment);
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public void getAppointmentByID(){
		
		System.out.println("Enter Appointment Id : ");
		int appointmentID = Integer.parseInt(sc.nextLine());
		
		//call dao
		
		try {
			
			appointmentData=appointmentDao.getById(appointmentID);
			System.out.println(appointmentData);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}

package com.java_project_achintya.doctorAppointment;

import java.util.Scanner;

import com.java_project_achintya.doctorAppointment.exceptions.AgeException;
import com.java_project_achintya.doctorAppointment.exceptions.ContactException;
import com.java_project_achintya.doctorAppointment.exceptions.EmailException;
import com.java_project_achintya.doctorAppointment.services.AppoinmentServices;
import com.java_project_achintya.doctorAppointment.services.CustomerServices;

public class Menu {
 
	private static void getCustomerMenu() {
		
		Scanner sc = new Scanner(System.in);
		CustomerServices customerFunc = new CustomerServices();
	
		while(true) {
			
			try {
		  
		  System.out.println("CHOOSE THE OPTIONS FOR CUSTOMERS BELOW TO CONTINUE ....................PRESS 0 TO EXIT");
		   
		  System.out.println("PRESS 1 FOR REGISTERING A CUSTOMER: ");
		  System.out.println("PRESS 2 FOR MODIFYING A CUSTOMER  RECORD: ");
		  System.out.println("PRESS 3 FOR DELETING A CUSTOMER RECORD: ");
		  System.out.println("PRESS 4 FOR VIEWING A CUSTOMER RECORD :");
		  System.out.println("PRESS 5 FOR VIEWING ALL CUSTOMER RECORD :");
		  
		  int option =Integer.parseInt(sc.nextLine());
		  
		  switch(option) {
		  case 0 :System.out.println("Exiting from Customer......\n");
			      break;
		  case 1 : customerFunc.registerCustomer();
		           break;
		  case 2 : customerFunc.updateCustomer();
		           break;
		  case 3 : customerFunc.deleteCustomer(); break;
		  case 4 :  customerFunc.getById(); break;
		  case 5 : customerFunc.getAll(); break;
		  default : System.out.println("Not a valid Option Please Select Again or Press 0 to Exit.....");
		            continue;
		  }
		  if(option==0) {
			  System.out.print("Exited Successfully from Customer...........\n");
			  break;
		  }
		  
		
		}catch (EmailException e) {
			System.out.println(e.getMessage());
		}catch (AgeException e) {
			System.out.println(e.getMessage());

		}catch (ContactException e) {
			System.out.println(e.getMessage());

		
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());

		}
	}
	}

       
	
	
	private static void getAppointmentMenu() {
		Scanner sc = new Scanner(System.in);
		AppoinmentServices appointmentFunc = new AppoinmentServices();
		try {
		while(true) {
		  
		  System.out.println("CHOOSE THE OPTIONS FOR APPOINTMENTS BELOW TO CONTINUE ....................PRESS 0 TO EXIT");
		   
		  System.out.println("PRESS 1 FOR BOOKING AN APPOINTMENT: ");
		  System.out.println("PRESS 2 FOR MODIFYING AN APPOINTMENT: ");
		  System.out.println("PRESS 3 FOR DELETING AN APPOINTMENT: ");
		  System.out.println("PRESS 4 FOR VIEWING ALL APPOINTMENTS:");
		  System.out.println("PRESS 5 FOR VIEWING A SINGLE APPOINTMENT :");
		  
		  int option = Integer.parseInt(sc.nextLine());
		  
		  switch(option) {
		  case 0 :System.out.println("Exiting from Appointment......\n");
			      break;
		  case 1 : appointmentFunc.bookAppointment();
		           break;
		  case 2 : appointmentFunc.updateAppointment();
		           break;
		  case 3 :  appointmentFunc.deleteAppointment(); break;
		  case 4 :  appointmentFunc.getAllAppointment();
		             break;
		  case 5 : appointmentFunc.getAppointmentByID();
		           break;
		  default : System.out.println("Not a valid Option Please Select Again or Press 0 to Exit.....");
		            continue;
		  }
		  if(option==0) {
			  System.out.print("Exited Successfully from Appointment...........\n");
			  break;
		  }
		}
		}catch(NumberFormatException e) {
			System.out.println("Invalid Number "+e.getMessage());
		}
		  
		
		}
	
	
    public static void getMainMenu() {
    	Scanner sc = new Scanner(System.in);
    	try {
		while(true) {
	
		  System.out.println("CHOOSE THE OPTIONS BELOW TO CONTINUE ....................PRESS 0 TO EXIT");
		   
		  System.out.println("PRESS 1 FOR CUSTOMER: ");
		  System.out.println("PRESS 2 FOR DOCTOR : ");
		  int option = Integer.parseInt(sc.nextLine());
		  
		  switch(option) {
		  case 0 :System.out.println("Exiting......");
			      break;
		  case 1 : System.out.println();
			       getCustomerMenu();
			        break;
		  case 2 :  System.out.println();
			        getAppointmentMenu();
			        break;
		  default : System.out.println(option);
			        System.out.println("Not a valid Option Please Select Again or Press 0 to Exit.....");
		            continue;
		  }
		  if(option==0) {
			  System.out.println("Exited Successfully...........");
			  break;
		  }
		  
		  
		}
		sc.close();
		}catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Inavlid Number ..."+e.getMessage());
		}
    }
}

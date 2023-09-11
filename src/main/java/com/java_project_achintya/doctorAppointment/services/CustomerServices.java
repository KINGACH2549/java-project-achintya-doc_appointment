package com.java_project_achintya.doctorAppointment.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ctc.wstx.shaded.msv_core.verifier.Acceptor;
import com.java_project_achintya.doctorAppointment.dao.impl.CustomerDaoImpl;
import com.java_project_achintya.doctorAppointment.entities.Customer;
import com.java_project_achintya.doctorAppointment.exceptions.AgeException;
import com.java_project_achintya.doctorAppointment.exceptions.ContactException;
import com.java_project_achintya.doctorAppointment.exceptions.EmailException;

public class CustomerServices {
	private Customer customerData = new Customer();
	private CustomerDaoImpl customerdao = new CustomerDaoImpl();
    Scanner sc = new Scanner(System.in);
	public void registerCustomer() throws EmailException, AgeException, ContactException{
		
		System.out.println("Enter Your Name : ");
		String name = sc.nextLine();
		customerData.setName(name);

		System.out.println("Enter Your Age : ");
		int age = Integer.parseInt(sc.nextLine());
		
		if(age<0) {
			throw new AgeException("Age can not be less than 0");
		}
		customerData.setAge(age); //age exception
		
		System.out.println("Enter Your EmailID : ");
		String emailID = sc.nextLine();
		
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);  
        Matcher matcher = pattern.matcher(emailID);  
        
        if(!matcher.matches()) {
        	throw new EmailException("Email Format Invalid!!!");
        }

		customerData.setEmailId(emailID); //email exception
		
		System.out.println("Enter Your Contact Number : ");
		String contactNumber = sc.nextLine();
		
		if(contactNumber.length()<10 || contactNumber.length() >10) {
			throw new ContactException("Invalid contact Number");
		}
		customerData.setContactNumber(contactNumber); //contact exception
		 
		
		//call DAO Implementation..............
		customerdao.createCustomer(customerData);
		
		
	}
	public void getAll() {
	  List<Customer> allCustomerData = new ArrayList<Customer>();
	  try {
		allCustomerData = customerdao.getAllCustomers();
		System.out.println("ALL CUSTOMERS DATA \n");
		for (Customer customer : allCustomerData) {
			
			System.out.println(customer);
		}
		System.out.println();
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		// TODO Auto-generated catch block
	}
}
	
	public void getById() {
		
		System.out.println("Enter the Customer Id : ");
		
		int customerID = Integer.parseInt(sc.nextLine());
		
		//call dao
		customerData = customerdao.getCustomerById(customerID);
	    
		System.out.println(customerData);
	}
	
	public void updateCustomer() {
		
		
		
	     getById();
		
		while(true) {
			System.out.println("Select from below what you want to update ..? ");
			
			System.out.println("Press 1 to Update Name");
			System.out.println("Press 2 to Update Age");
			System.out.println("Press 3 to Update EmailID");
			System.out.println("Press 4 to Update Contact Number");
			System.out.println("Press 0 if you are done updating the required field!!...");

			int option = Integer.parseInt(sc.nextLine());
			
			switch(option) {
			  case 0 : customerdao.updateCustomerData(customerData);
			           break;
			  case 1 : System.out.println("Enter Name:");
			           customerData.setName(sc.nextLine());
			           break;
			  case 2 : System.out.println("Enter Age: ");
			           customerData.setAge(Integer.parseInt(sc.nextLine()));
			           break;
			           
			  case 3 : System.out.println("Enter EmailID: ");
	                   customerData.setEmailId(sc.nextLine());
	                   break;
			  case 4 : System.out.println("Enter Contact Number :");
			            customerData.setContactNumber(sc.nextLine());
			            break;
	          default : System.out.println("Please Enter Valid Option ");
//	                    continue;
			}  
			if(option==0) break;
		}
		
	}
	
	public void deleteCustomer() {
		 System.out.println("Enter the customerID whose details you want to delete :");
		 
		 int customerID = Integer.parseInt(sc.nextLine());
		 
		 
		 try {
			if(customerdao.deleteCustomer(customerID)) {
				System.out.println("Deleted Sucessfully!");
				
			}else {
				System.out.println("Not able to delete Please try again!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		}
//		 customerdao
	}
}

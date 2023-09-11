package com.java_project_achintya.doctorAppointment.dao;

import java.sql.SQLException;
import java.util.List;

import com.java_project_achintya.doctorAppointment.entities.Customer;

public interface CustomerDao {

	public void createCustomer(Customer customerData); //registering a customer
	
	public void updateCustomerData(Customer customerData); //modifying customer details
	
	public List<Customer> getAllCustomers() throws SQLException; //get all customer data
	
	public Customer getCustomerById(int customerID); //get a single record of customer by ID.
	
	public boolean deleteCustomer(int customerID) throws SQLException;
	
}

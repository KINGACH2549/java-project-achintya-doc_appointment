package com.java_project_achintya.doctorAppointment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jaxen.function.IdFunction;

import com.java_project_achintya.doctorAppointment.dao.CustomerDao;
import com.java_project_achintya.doctorAppointment.entities.Customer;
import com.java_project_achintya.doctorAppointment.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao{
    
	private static final String INSERT_CUSTOMER="insert into customer(name, emailID, age ,contactNumber) values(?,?,?,?)";
    private static final String GETBY_CUSTOMERID ="select * from customer where uid = ?";
    private static final String UPDATE_CUSTOMER = "update customer set name = ? , emailID=? ,age=? ,contactNumber = ? where uid = ?";
    private static final String DELETE_CUSTOMER = "delete  from customer where uid = ?";
    private static final String GETALL_CUSTOMERS = "select * from customer";
	private  Connection connection=DBUtil.getConnection();
	
	public void createCustomer(Customer customerData) {
		
		// TODO Auto-generated method stubs
		try {
			PreparedStatement ps=connection.prepareStatement(INSERT_CUSTOMER);
			// Set The value
			ps.setString(1, customerData.getName());
			ps.setString(2, customerData.getEmailId());
			ps.setInt(3, customerData.getAge());
			ps.setString(4, customerData.getContactNumber());
			//Execute Statement
			int executeUpdate = ps.executeUpdate();
			ps.close();
			if(executeUpdate>0) {
			   System.out.println("Customer Registered Sucessfully.............");
			}else {
				   System.out.println("Customer could not be Registered.............");

			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	public void updateCustomerData(Customer customerData) {
		
		// TODO Auto-generated method stub
	
		try {
			PreparedStatement ps=connection.prepareStatement(UPDATE_CUSTOMER);
			// Set The value
			ps.setString(1, customerData.getName());
			ps.setString(2, customerData.getEmailId());
			ps.setInt(3, customerData.getAge());
			ps.setString(4, customerData.getContactNumber());
			ps.setInt(5, customerData.getId());
			//Execute Statement
			int executeUpdate = ps.executeUpdate();
		    
			ps.close();
			if(executeUpdate>0) {
			   System.out.println("Customer Details Updated Sucessfully.............");
			}else {
				   System.out.println("Customer could not be Updated.............");

			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		
	}
	}
	public List<Customer> getAllCustomers() throws SQLException {
		// TODO Auto-generated method stub
		List<Customer> allCustomerData = new ArrayList<Customer>();
	    PreparedStatement ps=connection.prepareStatement(GETALL_CUSTOMERS);
	     
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()) {
	    	Customer customerData = new Customer();
	      	customerData.setId(rs.getInt("uid"));
	    	 customerData.setAge(rs.getInt("age"));
			 customerData.setEmailId(rs.getString("emailID"));
			 customerData.setName(rs.getString("name"));
			 customerData.setContactNumber(rs.getString("conatactNumber"));
			 allCustomerData.add(customerData);

	    }
       return allCustomerData;
		
	}

	public Customer getCustomerById(int customerID) {
		Customer customerData = new Customer();

		// TODO Auto-generated method stub
		try {
		 PreparedStatement ps=connection.prepareStatement(GETBY_CUSTOMERID);
		 ps.setInt(1,customerID);
		 
		 ResultSet rs = ps.executeQuery();
		 rs.next();
		customerData.setId(rs.getInt("uid"));
		 customerData.setAge(rs.getInt("age"));
		 customerData.setEmailId(rs.getString("emailID"));
		 customerData.setName(rs.getString("name"));
		 customerData.setContactNumber(rs.getString("contactNumber"));

		 ps.close();
		 
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
   
		
		return customerData;
	}
	
	public boolean deleteCustomer(int customerID) throws SQLException{
		
			 PreparedStatement ps=connection.prepareStatement(DELETE_CUSTOMER);
			 ps.setInt(1,customerID);
			 
	       	int executeUpdate = ps.executeUpdate();
	       	ps.close();
             if(executeUpdate>0){
            	return true;
             }
			 
			 return false;
			 
			
	}

	
}

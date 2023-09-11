package com.java_project_achintya.doctorAppointment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java_project_achintya.doctorAppointment.entities.Appointment;
import com.java_project_achintya.doctorAppointment.util.DBUtil;

public class AppointmentDaoImpl {
 
	private static final String GETAPPOINTMENT_BYID = "SELECT appointment.* , customer.name as customerName , doctor.name as doctorName , doctor.specialization from appointment INNER JOIN customer on appointment.customerID =customer.uid INNER JOIN doctor on appointment.doctorID = doctor.uid where appointment.uid = ?";
	private static final String UPDATE_APPOINTMENT = "UPDATE appointment SET doctorID =  ? ,updatedon = CURRENT_TIMESTAMP where uid = ?";
	private static final String DELETE_APPOINTMENT = "DELETE FROM appointment where uid = ?";
	private static final String GETALL_APPOINTMENTS = "SELECT appointment.* , customer.name as customerName , doctor.name as doctorName , doctor.specialization from appointment INNER JOIN customer on appointment.customerID =customer.uid INNER JOIN doctor on appointment.doctorID = doctor.uid " ;
	private final String CREATE_APPOINTMENT = "INSERT INTO APPOINTMENT(customerID , doctorID , createdon , updatedon) VALUES(?,?,CURRENT_TIMESTAMP , CURRENT_TIMESTAMP)"; 
	private  Connection connection=DBUtil.getConnection();
	public boolean create(Appointment appointmentData) throws SQLException {
		
		// TODO Auto-generated method stub
		PreparedStatement ps = connection.prepareStatement(CREATE_APPOINTMENT);
		ps.setInt(1, appointmentData.getCustomerID());
		ps.setInt(2, appointmentData.getDoctorID());
		
		int executeUpdate = ps.executeUpdate();
		ps.close();
		
		if(executeUpdate>0) {
			return true;
		}
		return false;
		
	}
	public Appointment getById(int appointmentID) throws SQLException {
		Appointment appointmentData = new Appointment();
		
		PreparedStatement ps = connection.prepareStatement(GETAPPOINTMENT_BYID);
		
		ps.setInt(1,appointmentID);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		appointmentData.setId(rs.getInt("uid"));
		appointmentData.setDoctorName(rs.getString("doctorName"));
		appointmentData.setCustomerName(rs.getString("customerName"));
		appointmentData.setConsulting(rs.getString("specialization"));
		appointmentData.setCustomerID(rs.getInt("customerId"));
		appointmentData.setDoctorID(rs.getInt("doctorID"));
		
		rs.close();
		ps.close();
		
		return appointmentData;
		
	}
	public boolean update(Appointment appointment) throws SQLException {
		
		PreparedStatement ps = connection.prepareStatement(UPDATE_APPOINTMENT);
		
		ps.setInt(1, appointment.getDoctorID());
		ps.setInt(2, appointment.getId());
        
		int executeUpdate = ps.executeUpdate();
		
		if(executeUpdate>0) return true;
		
		return false;
       
	}
	public boolean delete(int appointmentID) throws SQLException{
		
		
       PreparedStatement ps = connection.prepareStatement(DELETE_APPOINTMENT);
		
		ps.setInt(1, appointmentID);
        
		int executeUpdate = ps.executeUpdate();
		
		if(executeUpdate>0) return true;
		
		return false;		
	}
	public List<Appointment> getAll()  throws SQLException {
		
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		
		PreparedStatement ps = connection.prepareStatement(GETALL_APPOINTMENTS);
		
		ResultSet rs = ps.executeQuery();
		
		 while(rs.next()) {
			 Appointment appointmentData = new Appointment();
			 
				appointmentData.setId(rs.getInt("uid"));
				appointmentData.setDoctorName(rs.getString("doctorName"));
				appointmentData.setCustomerName(rs.getString("customerName"));
				appointmentData.setConsulting(rs.getString("specialization"));
				appointmentData.setCustomerID(rs.getInt("customerId"));
				appointmentData.setDoctorID(rs.getInt("doctorID"));
				
				appointmentList.add(appointmentData);
				
			 
		 }
		 rs.close();
		 ps.close();
		 
		return appointmentList;
	}
     

}

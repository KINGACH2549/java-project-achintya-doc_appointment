package com.java_project_achintya.doctorAppointment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java_project_achintya.doctorAppointment.entities.Customer;
import com.java_project_achintya.doctorAppointment.entities.Doctor;
import com.java_project_achintya.doctorAppointment.util.DBUtil;

public class DoctorDaoImpl {
	
	private final String  GETALL_DOCTORS = "select * from doctor";
	private  Connection connection=DBUtil.getConnection();

	public List<Doctor> getAll() throws SQLException {
		
		List<Doctor> doctorList = new ArrayList<Doctor>();
		  PreparedStatement ps=connection.prepareStatement(GETALL_DOCTORS);
		     
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		        Doctor doctorData = new Doctor();				 
				 doctorData.setDoctorID(rs.getInt("uid"));
				 doctorData.setName(rs.getString("name"));
				 doctorData.setSpecialization(rs.getString("specialization"));
				 
                doctorList.add(doctorData);
		    }
		return doctorList;
	}
   
	
}

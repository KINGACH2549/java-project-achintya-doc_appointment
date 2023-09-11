package com.java_project_achintya.doctorAppointment.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java_project_achintya.doctorAppointment.dao.impl.DoctorDaoImpl;
import com.java_project_achintya.doctorAppointment.entities.Doctor;

public class DoctorServices {
    private DoctorDaoImpl doctorDao = new DoctorDaoImpl();
	public void getAllDoctors(){
		//call doctor dao
		List<Doctor> doctorList = new ArrayList<Doctor>();
		
		try {
			doctorList = doctorDao.getAll();
			for (Doctor doctor : doctorList) {
				
				System.out.println(doctor);
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

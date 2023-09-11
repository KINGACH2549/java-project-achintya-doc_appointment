package com.java_project_achintya.doctorAppointment.dao;

import java.sql.SQLException;
import java.util.List;

import com.java_project_achintya.doctorAppointment.entities.Doctor;

public interface DoctorDao {
	public List<Doctor> getAll() throws SQLException;
}

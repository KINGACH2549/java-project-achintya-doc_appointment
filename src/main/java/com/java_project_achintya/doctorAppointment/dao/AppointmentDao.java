package com.java_project_achintya.doctorAppointment.dao;

import java.sql.SQLException;
import java.util.List;

import com.java_project_achintya.doctorAppointment.entities.Appointment;

public interface AppointmentDao {
  public boolean create() throws SQLException;
  public Appointment getById(int appointmentID) throws SQLException;
  public boolean update(Appointment appointment) throws SQLException;
  public boolean delete(int appointmentID) throws SQLException;
  public List<Appointment> getAll()  throws SQLException;  
}

package com.hrms.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


public class TitlesId implements Serializable{
	
    private LocalDate fromDate;
    private Employee employee;
   
	
	public LocalDate getFromDate() {
		return fromDate;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}


	public TitlesId(LocalDate fromDate, Employee employee) {
		super();
		this.fromDate = fromDate;
		this.employee = employee;
	}


	public TitlesId() {
		super();
	}
	
}

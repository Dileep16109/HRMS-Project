package com.hrms.entities;


import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dept_manager")
@IdClass(DepartmentManagerId.class)

public class DepartmentManager {

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_no")
	private Employee employee;	
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_no")
	private Departments department;

	@Column(name = "from_date", nullable=false)
	private LocalDate fromDate;

	@Column(name = "to_date", nullable=false)
	private LocalDate toDate;

	public DepartmentManager() {
		super();
	}

	public DepartmentManager(Employee employee, Departments department, LocalDate fromDate, LocalDate toDate) {
		super();
		this.employee = employee;
		this.department = department;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	
}

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

@Entity
@IdClass(SalaryId.class)

public class Salaries {

	@Id
	@Column(name = "from_date", nullable = false)
	private LocalDate fromDate;

	@Column(name = "salary", nullable = false)
	private int salary;

	@Column(name = "to_date", nullable = false)
	private LocalDate toDate;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_no")
	private Employee employee;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate from_date) {
		this.fromDate = from_date;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate to_date) {
		this.toDate = to_date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Salaries() {
		super();
	}

	public Salaries(LocalDate fromDate, int salary, LocalDate toDate, Employee employee) {
		super();
		this.fromDate = fromDate;
		this.salary = salary;
		this.toDate = toDate;
		this.employee = employee;
	}
	

}

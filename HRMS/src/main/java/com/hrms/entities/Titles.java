package com.hrms.entities;


import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="titles")
@IdClass(TitlesId.class)

public class Titles {

	@Column(name = "title", nullable = false, length = 50)
	private String title;

	@Id
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

	@Column(name = "to_date")
	private LocalDate toDate;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_no")
	private Employee employee;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Titles() {
		super();
	}

	public Titles(String title, LocalDate fromDate, LocalDate toDate, Employee employee) {
		super();
		this.title = title;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.employee = employee;
	}
	

}

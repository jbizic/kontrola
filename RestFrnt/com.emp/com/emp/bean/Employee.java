package com.emp.bean;

import java.io.Serializable;

/**
 * @author Jovan
 *
 */

public class Employee implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String jobDescription;
	private Double monthSalary;
	
	public Employee() {
	}
	public Employee(long id, String name, String jobDescription, double salary) {
		this.setId(id);
		this.setName(name);
		this.setJobDescription(jobDescription);
		this.setMonthSalary(salary);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Double getMonthSalary() {
		return monthSalary;
	}

	public void setMonthSalary(Double monthSalary) {
		this.monthSalary = monthSalary;
	}
	
}

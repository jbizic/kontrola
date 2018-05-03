package com.emp.bean;

import java.io.Serializable;

import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table; 


/**
 * @author Jovan
 *
 */
@Entity
@Table(name="employee")
@NamedQuery(name = "findAllEmployees", query = "SELECT e FROM Employee e")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="jobDescription")
	private String jobDescription;
	@Column(name="monthSalary")
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

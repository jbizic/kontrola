package com.emp.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

/**
 * @author Jovan
 *
 */
@Entity
public class Employee implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	private String name;
	private String jobDescription;
	private Double monthSalary;
	private Long parentId;
	private List<Employee>children;
	
	public Employee() {
		this.children = new ArrayList<Employee>();
	}
	public Employee(long id, String name, String jobDescription, double salary, long parentId, List<Employee>children) {
		this.setId(id);
		this.setName(name);
		this.setJobDescription(jobDescription);
		this.setMonthSalary(salary);
		this.setParentId(parentId);
		this.children = new ArrayList<Employee>();
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
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public List<Employee> getChildren() {
		return children;
	}
	public void setChildren(List<Employee> children) {
		this.children = children;
	}
	
}

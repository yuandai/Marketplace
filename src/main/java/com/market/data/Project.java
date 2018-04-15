package com.market.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



public class Project implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String projectName;
	private String description;
	private BigDecimal budget;
	private Date endingDate;
	private Person assignee;
	private Person owner;
	
	public Project() {
		
	}
	
	public Project(String projectName, String description, /*float*/BigDecimal budget, Date endingDate, Person owner ) {
		
		this.projectName = projectName;
		this.description = description;
		this.budget = budget;
		this.endingDate = endingDate;
		this.owner = owner;
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	
	public BigDecimal getBudget() {
		return budget;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	
	public Date getEndingDate() {
		return endingDate;
	}

	public void setAssignee(Person assignee) {
		this.assignee = assignee;
	}
	
	public Person getAssignee() {
		return assignee;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	public Person getOwner() {
		return owner;
	}


	
	@Override
	public String toString() {
	        return new StringBuffer(" Project Name : ").append(this.projectName)
	                .append(" Description : ").append(this.description)
	                .append(" Budget : ").append(this.budget)
	                .append(" Ending Date : ").append(this.endingDate)
	                .append("Assignee Name").append(this.assignee.getName())
	                .append("Owner Name").append(this.owner.getName()).toString();
	}


}

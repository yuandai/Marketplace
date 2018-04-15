package com.market.data;

import java.io.Serializable;
import java.math.BigDecimal;



public class Bid implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String proposal;
	private BigDecimal amount;
	private Person engineer;
	private Project project;
	
	
	public Bid() {
		
	}
	
	public Bid(Person engineer, Project project, String proposal, BigDecimal amount) {
		
		this.project = project;
		this.engineer = engineer;
		this.proposal = proposal;
		this.amount = amount;
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setProposal(String proposal) {
		this.proposal = proposal;
	}
	
	public String getProposal() {
		return this.proposal;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setEngineer(Person engineer) {
		this.engineer = engineer;
	}
	
	public Person getEngineer() {
		return this.engineer;
	}


	public void setProject(Project project) {
		this.project = project;
	}
	
	public Project getProject() {
		return this.project;
	}


	@Override
	public String toString() {
	        return new StringBuffer(" Project Name : ").append(this.project.getProjectName())
	                .append(" Engineer Name : ").append(this.engineer.getName())
	                .append(" Proposal : ").append(this.proposal)
	                .append(" Amount : ").append(this.amount).toString();
	}

}

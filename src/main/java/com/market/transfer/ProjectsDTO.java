package com.market.transfer;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.market.data.Project;

/*
 * Data Transfer Object
 */

public class ProjectsDTO {
	
	private List<ProjectDTO> projects;
	
	public ProjectsDTO() {
		this.projects = new ArrayList<ProjectDTO>();
	}
	
	public ProjectsDTO(List<Project> projList) {
		projects = new ArrayList<ProjectDTO>();

		for (Project proj : projList) {
			ProjectDTO pj = new ProjectDTO();
			
			pj.setBudget(proj.getBudget());
			if (proj.getAssignee() != null) {
				pj.setAssigneeName(proj.getAssignee().getName());
			}
			pj.setOwnerName(proj.getOwner().getName());
			pj.setProjectName(proj.getProjectName());
			pj.setDescription(proj.getDescription());
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YY");
			pj.setEndingDate(sdf.format(proj.getEndingDate()));
						
			projects.add(pj);
		}
		
	}

		
	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}
	
	public List<ProjectDTO> getProjects() {
		return this.projects;
	}

}

class ProjectDTO {
	
	private String projectName;
	private String description;
	private BigDecimal budget;
	private String endingDate;
	private String assigneeName = "";
	private String ownerName;
	
	
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

	public void setEndingDate(String endingDate) {
		this.endingDate = endingDate;
	}
	
	public String getEndingDate() {
		return endingDate;
	}

	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}
	
	public String getAssigneeName() {
		return assigneeName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	

}

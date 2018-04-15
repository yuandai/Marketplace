package com.market.helper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.market.data.Bid;
import com.market.data.Database;
import com.market.data.Person;
import com.market.data.Project;
import com.market.transfer.ProjectBidsDTO;
import com.market.transfer.ProjectsDTO;
import com.market.validation.Validation;

/*
 * Business Object
 */

@Transactional
public class ProjectHelper {
	
	Database database;
	Validation validation;
	
	public void setDatabase(Database database) {
		this.database = database;
	}
	
	public void setValidation(Validation validation) {
		this.validation = validation;
	}
	
	public boolean updateProject(Project project) {
		boolean result = false;
		
		if (validation.validateUpdateProject(project)) {
			
			database.saveProject(project);
			result = true;
			
		} else
			
			result = false;
		
		return result;
		
	}
	
	
	public ProjectsDTO getProjectsOfPerson(String name) {
		
		ProjectsDTO ret = new ProjectsDTO();
		
		List<Project> projs = database.getProjectsByOwnerName(name);
		
		ret = new ProjectsDTO(projs);
		
		return ret;
	}

	
	public boolean createProject(Project project) {
		boolean result = false;
		
		if (validation.validateCreateProject(project)) {
			
			database.saveProject(project);
			result = true;
			
		} else
			
			result = false;
		
		return result;
		
	}
	
	public ProjectBidsDTO getProjectWithAllBids(String projectName) {
		
		ProjectBidsDTO projBids = new ProjectBidsDTO();
		
		Project proj = database.getProject(projectName);
		
		ArrayList<Bid> bids = new ArrayList<Bid>();
		
		List<Person> persons = database.getPersons();
		
		for (Person person : persons) {
			
			Bid b = database.getBid(person.getName(), projectName);
			if (b != null)
				bids.add(b);
			
		}		
		
		projBids.setProject(proj);
		projBids.setBids(bids);
		
		return projBids;
	}

}

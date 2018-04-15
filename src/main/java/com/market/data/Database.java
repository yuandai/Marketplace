package com.market.data;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/*
 * DAO Object
 */

public class Database extends HibernateDaoSupport {
	
	
	public Person savePerson(Person person) {
		        
		getHibernateTemplate().saveOrUpdate(person);

		return person;                
	}
	
	public Person getPersonByName(String name) {
		
		String[] params = {name};
		List list = getHibernateTemplate().find("from Person where name = ? ", params);
        if (list != null && list.size() > 0)
        	return (Person)list.get(0);
        else
        	return null;
		
	}

	
	public List<Person> getPersons() {
		
		List list = getHibernateTemplate().find("from Person");

        return list;
	}


	public Project saveProject(Project project) {
		
        
		getHibernateTemplate().saveOrUpdate(project);

		return project;
	}
	
	public Project getProject(String projectName) {
		
		String[] params = {projectName};
		List list = getHibernateTemplate().find("from Project as proj where proj.projectName = ? ", params);
        
        if (list != null && list.size() > 1)
        	return (Project)list.get(0);
        else
        	return null;
		
	}
	
	public List<Project> getProjectsWithoutAssignee() {
		
		List list = getHibernateTemplate().find("from Project where assignee = null and endingDate <= current_date ");

		return list;
		
	}
	
	public List<Project> getProjectsByOwnerName(String name) {
		
		String[] params = {name};
		List<Project> list = getHibernateTemplate().find("from Project as proj where proj.owner.name = ? ", params);

		return list;
		
	}


	public Bid saveBid(Bid bid) {
		
		String[] params = {bid.getEngineer().getName()};
		List list = getHibernateTemplate().find("from Person where name = ? ", params);
		Person person = (Person)list.get(0);
        
        bid.setEngineer(person);
        
        params[0] = bid.getProject().getProjectName();
        list = getHibernateTemplate().find("from Project where projectName = ? ", params);
        Project project = (Project)list.get(0);
        
        bid.setProject(project);
        
        getHibernateTemplate().saveOrUpdate(bid);
        
        return bid;

	}
	
	
	public Bid getBid(String name, String projectName) {
		
		String[] params = {projectName, name};
		List<Bid> list = getHibernateTemplate().find("from Bid as bid where bid.project.projectName = ? and bid.engineer.name = ?", params);
        if (list != null && list.size() > 1)
        	return list.get(0);
        else
        	return null;
		
	}
	
	public List<Bid> getBidByProjectName(String projectName) {
		
		String[] params = {projectName};
		List<Bid> list = getHibernateTemplate().find("from Bid as bid where bid.project.projectName = ?", params);

		return list;
				
	}
	
	public List<Bid> getBidsByEngineerName(String engineerName) {
		
		String[] params = {engineerName};
		List<Bid> list  = getHibernateTemplate().find("from Bid as bid where bid.engineer.name = ?", params);

		return list;
				
	}



}

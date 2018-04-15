package com.market;


import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.market.data.Bid;
import com.market.data.Person;
import com.market.data.Project;
import com.market.helper.BidHelper;
import com.market.helper.CommonHelper;
import com.market.helper.PersonHelper;
import com.market.helper.ProjectHelper;
import com.market.transfer.BidsDTO;
import com.market.transfer.ProjectBidsDTO;
import com.market.transfer.ProjectsDTO;


/*
 * RestAPI Web Services
 */


@Path("/service")
public class MarketService {
	
	
	/*
	 * Bid RestAPIs
	 */

	
	@GET
	@Path(Constant.BID)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response responseBid(@QueryParam("query") String query) {
						
    	ApplicationContext appContext = 
        		new ClassPathXmlApplicationContext("config/BeanLocations.xml");
    	
        ProjectHelper projectHelper = (ProjectHelper)appContext.getBean("projectHelper");
        BidHelper bidHelper = (BidHelper)appContext.getBean("bidHelper");
        
		if (query.startsWith(Constant.NAME))	 {
			
			StringTokenizer st = new StringTokenizer(query, "=");
			st.nextToken();
			String name = st.nextToken();
			
			BidsDTO bidDTO = bidHelper.getBidsOfPerson(name);
			
			return Response.status(Constant.OK).entity(bidDTO).build();
			
		} else if (query.startsWith(Constant.PROJECT_NAME)) {
			
			StringTokenizer st = new StringTokenizer(query, "=");
			st.nextToken();
			String projectName = st.nextToken();
			
			ProjectBidsDTO projBidsDTO = projectHelper.getProjectWithAllBids(projectName); 
				
			return Response.status(Constant.OK).entity(projBidsDTO).build();
		}
		
		return Response.status(Constant.NotFound).entity(Constant.errMsg).build();
					
	}
	
	

	@POST
	@Path(Constant.BID)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBid(Bid bid) {
									
    	ApplicationContext appContext = 
        		new ClassPathXmlApplicationContext("config/BeanLocations.xml");
    	
        BidHelper bidHelper = (BidHelper)appContext.getBean("bidHelper");
        
		boolean result = bidHelper.createBid(bid);
			
		if (result)
			return Response.status(Constant.OK).entity(Constant.successMsg).build();
		else
			return Response.status(Constant.InternalErr).entity(Constant.errMsg).build();
			
	}
	
	
	@PUT
	@Path(Constant.BID)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBid(Bid bid) {
									
    	ApplicationContext appContext = 
        		new ClassPathXmlApplicationContext("config/BeanLocations.xml");
    	
        BidHelper bidHelper = (BidHelper)appContext.getBean("bidHelper");
        
		boolean result = bidHelper.updateBid(bid);
			
		if (result)
			return Response.status(Constant.OK).entity(Constant.successMsg).build();
		else
			return Response.status(Constant.InternalErr).entity(Constant.errMsg).build();
			
	}
	
	
	/*
	 * Person RestAPIs
	 */
	
	
	@POST
	@Path(Constant.PERSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPerson(Person person) {
									
    	ApplicationContext appContext = 
        		new ClassPathXmlApplicationContext("config/BeanLocations.xml");
    	
        PersonHelper personHelper = (PersonHelper)appContext.getBean("personHelper");
        
		boolean result = personHelper.createPerson(person);
			
		if (result)
			return Response.status(Constant.OK).entity(Constant.successMsg).build();
		else
			return Response.status(Constant.InternalErr).entity(Constant.errMsg).build();
			
	}
	
	
	/*
	 * Project RestAPIs
	 */
	
	
	@GET
	@Path(Constant.PROJECT)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response responseProject(@QueryParam("query") String query) {
						
    	ApplicationContext appContext = 
        		new ClassPathXmlApplicationContext("config/BeanLocations.xml");
    	
        ProjectHelper projectHelper = (ProjectHelper)appContext.getBean("projectHelper");
        	
		StringTokenizer st = new StringTokenizer(query, "=");
		st.nextToken();
		String name = st.nextToken();
			
		ProjectsDTO projDTO = projectHelper.getProjectsOfPerson(name);
		return Response.status(Constant.OK).entity(projDTO).build();
					
	}
	
	@POST
	@Path(Constant.PROJECT)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProject(Project project) {
									
    	ApplicationContext appContext = 
        		new ClassPathXmlApplicationContext("config/BeanLocations.xml");
    	
        ProjectHelper projectHelper = (ProjectHelper)appContext.getBean("projectHelper");
        
		boolean result = projectHelper.createProject(project);
			
		if (result)
			return Response.status(Constant.OK).entity(Constant.successMsg).build();
		else
			return Response.status(Constant.InternalErr).entity(Constant.errMsg).build();

	}
	
	
	@PUT
	@Path(Constant.PROJECT)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProject(Project project) {
									
    	ApplicationContext appContext = 
        		new ClassPathXmlApplicationContext("config/BeanLocations.xml");
    	
        ProjectHelper projectHelper = (ProjectHelper)appContext.getBean("projectHelper");
        
		boolean result = projectHelper.updateProject(project);
			
		if (result)
			return Response.status(Constant.OK).entity(Constant.successMsg).build();
		else
			return Response.status(Constant.InternalErr).entity(Constant.errMsg).build();

	}
	

	/*
	 * Other RestAPIs
	 */
	
	
	@POST
	@Path(Constant.INITIAL)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response initial() {
									
    	ApplicationContext appContext = 
        		new ClassPathXmlApplicationContext("config/BeanLocations.xml");
    	
        CommonHelper commonHelper = (CommonHelper)appContext.getBean("commonHelper");
        
		commonHelper.initial();
		return Response.status(Constant.OK).entity(Constant.successMsg).build();

	}
	
	@POST
	@Path(Constant.ASSIGN)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response assign() {
									
    	ApplicationContext appContext = 
        		new ClassPathXmlApplicationContext("config/BeanLocations.xml");
    	
        CommonHelper commonHelper = (CommonHelper)appContext.getBean("commonHelper");
        
		commonHelper.assign();
		return Response.status(Constant.OK).entity(Constant.successMsg).build();

	}
	
}

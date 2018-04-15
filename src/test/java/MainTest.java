

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.market.data.Person;
import com.market.data.Project;
import com.market.data.Bid;
import com.market.data.Database;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MainTest 
    extends TestCase
{
    private static Person owner;
    private static Person engineer;
    private static Person engineer1;
    private static Project project;
    private static Bid bid;
    private static Bid bid1;

	ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext("config/BeanLocations.xml");
	
    Database database = (Database)appContext.getBean("database");
    
    @org.junit.Test
    public void testPerson(){
        String nameOwner = "Mark";
        String contactInfoOwner = "408-9876341";
        owner = new Person();
        
        String nameEngineer = "Jonathan";
        String contactInfoEngineer = "408-9876342";
        engineer = new Person();
        
        String nameEngineer1 = "Gorden";
        String contactInfoEngineer1 = "408-8763981";
        engineer1 = new Person();
        
        owner.setName(nameOwner);
        owner.setContactInfo(contactInfoOwner);
        engineer.setName(nameEngineer);
        engineer.setContactInfo(contactInfoEngineer);
        engineer1.setName(nameEngineer1);
        engineer1.setContactInfo(contactInfoEngineer1);
        
        owner = (Person) database.savePerson(owner);
        Integer ownerId = owner.getId();
        engineer = (Person) database.savePerson(engineer);
        Integer engineerId = engineer.getId();
        engineer1 = (Person) database.savePerson(engineer1);
        Integer engineer1Id = engineer1.getId();
        
        assertEquals("Mark", owner.getName());
        assertEquals("Jonathan", engineer.getName());
        assertEquals("Gorden", engineer1.getName());

    //}
    
    //@org.junit.Test
    //public void testProject(){
    	
        project = new Project();
        project.setProjectName("PCRepair");
        project.setDescription("Auto reboot");
        project.setBudget(new BigDecimal("18.00"));
        project.setEndingDate(new Date());
        project.setOwner(owner);

        if (owner != null && engineer != null) {
        
            project = (Project) database.saveProject(project);
            Integer projectId = project.getId();
        
        	assertEquals("PCRepair",project.getProjectName());
        	assertEquals(owner.getId(), project.getOwner().getId());

        }
    //}
    
    //@org.junit.Test
    //public void testBid(){
    	
        bid = new Bid();
        bid.setProposal("5 years experience");
        bid.setAmount(new BigDecimal("10.00"));
        bid.setEngineer(engineer);
        bid.setProject(project);

        if (project != null && engineer != null) {
        
            bid = (Bid) database.saveBid(bid);
        	Integer bidId =(Integer) bid.getId();
        
        	assertEquals("5 years experience", bid.getProposal());
        	assertEquals(engineer.getId(), bid.getEngineer().getId());
        	assertEquals(project.getId(), bid.getProject().getId());

        }
        
        bid1 = new Bid();
        bid1.setProposal("3 years experience");
        bid1.setAmount(new BigDecimal("20.00"));
        bid1.setEngineer(engineer1);
        bid1.setProject(project);

        
        if (project != null && engineer1 != null) {
        
            bid1 = (Bid) database.saveBid(bid1);
        	Integer bid1Id =(Integer) bid1.getId();
        
        	assertEquals("3 years experience", bid1.getProposal());
        	assertEquals(engineer1.getId(), bid1.getEngineer().getId());
        	assertEquals(project.getId(), bid1.getProject().getId());

        }
    }

    
}

package com.market.helper;

import org.springframework.transaction.annotation.Transactional;

import com.market.data.Database;
import com.market.data.Person;
import com.market.validation.Validation;

/*
 * Business Object
 */

@Transactional
public class PersonHelper {
	
	Database database;
	Validation validation;
	
	public void setDatabase(Database database) {
		this.database = database;
	}
	
	public void setValidation(Validation validation) {
		this.validation = validation;
	}
	
	public boolean createPerson(Person person) {
		boolean result = false;
		
		if (validation.validateCreatePerson(person)) {
			
			database.savePerson(person);
			result = true;
			
		} else 
			
			result = false;
		
		return result;
	}

}

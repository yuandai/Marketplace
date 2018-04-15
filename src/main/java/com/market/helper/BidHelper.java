package com.market.helper;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.market.data.Bid;
import com.market.data.Database;
import com.market.transfer.BidsDTO;
import com.market.validation.Validation;

/*
 * Business Object
 */

@Transactional
public class BidHelper {
	
	Database database; 
	Validation validation;
	
	public void setDatabase(Database database) {
		this.database = database;
	}
	
	public void setValidation(Validation validation) {
		this.validation = validation;
	}
	
	public BidsDTO getBidsOfPerson(String name) {
		
		BidsDTO ret = new BidsDTO();
		
		List<Bid> bids = database.getBidsByEngineerName(name);
		
		ret = new BidsDTO(bids);
		
		return ret;
	}
	
	
	public boolean createBid(Bid bid) {
		boolean result = false;
		
		if (validation.validateCreateBid(bid)) {
			
			database.saveBid(bid);
			result = true;
			
		} else
			
			result = false;
		
		return result;
	}

	
	
	public boolean updateBid(Bid bid) {
		boolean result = false;
		
		if (validation.validateUpdateBid(bid)) {
			
			database.saveBid(bid);
			result = true;
			
		} else
			
			result = false;
		
		return result;
	}

}

package com.market.transfer;

import java.util.ArrayList;

import com.market.data.Bid;
import com.market.data.Project;

/*
 * Data Transfer Object
 */

public class ProjectBidsDTO {
	
	private Project project;
	private ArrayList<Bid> bids;
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public Project getProject() {
		return project;
	}

	public void setBids(ArrayList<Bid> bids) {
		this.bids = bids;
	}
	
	public ArrayList<Bid> getBids() {
		return bids;
	}

	
}

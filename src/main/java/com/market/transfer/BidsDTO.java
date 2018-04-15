package com.market.transfer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.market.data.Bid;

/*
 * Data Transfer Object
 */

public class BidsDTO {
	
	private List<BidDTO> bids;
	
	public BidsDTO() {
		bids = new ArrayList<BidDTO>();
	}
	
	public BidsDTO(List<Bid> bidList) {
		bids = new ArrayList<BidDTO>();

		for (Bid bid : bidList) {
			BidDTO bd = new BidDTO();
			
			bd.setAmount(bid.getAmount());
			bd.setEngineerName(bid.getEngineer().getName());
			bd.setProjectName(bid.getProject().getProjectName());
			bd.setProposal(bid.getProposal());
			
			bids.add(bd);
		}
		
	}
	
	public void setBids(List<BidDTO> bids) {
		this.bids = bids;
	}
	
	public List<BidDTO> getBids() {
		return this.bids;
	}

}

class BidDTO {
	
	private String proposal;
	private BigDecimal amount;
	private String engineerName;
	private String projectName;
	
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

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}
	
	public String getEngineerName() {
		return this.engineerName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getProjectName() {
		return this.projectName;
	}

}

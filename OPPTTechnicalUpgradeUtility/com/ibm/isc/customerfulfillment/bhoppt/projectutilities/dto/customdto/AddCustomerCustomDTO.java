/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.TreeMap;


/**
 * Custom dto that holds data required for fetching alternate partner for a partner type.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 10, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */


public class AddCustomerCustomDTO extends OPPTCustomDTO 
{
	private ProposalCustomDTO proposal = null;
	private TreeMap customeList = null;
	
	/**
	 * Returns collection of customer lists available for the proposal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getCustomerLists() {
		return customeList;
	}

	/**
	 * Returns proposal to which customers being added 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalCustomDTO
	 */
	public ProposalCustomDTO getProposal() {
		return proposal;
	}

	/**
	 * Sets customer lists collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerLists TreeMap 
	 */
	public void setCustomerLists(TreeMap newCustomerLists) {
		customeList = newCustomerLists;
	}

	/**
	 * Sets proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposal ProposalCustomDTO 
	 */
	public void setProposal(ProposalCustomDTO newProposal) {
		proposal = newProposal;
	}

	/**
	 * Adds new customer to the collection of customers in the customer list  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customer CustomerListCustomerCustomDTO
	 */
	public void addCustomerList(CustomerListCustomDTO customer){
		if(null != customer){
			if(null == customeList){
				customeList = new TreeMap();
			}
			customeList.put(customer.getListNumber(), customer);
		}
	}
    /**
     * return the customeList 
     *
     * @return Returns the customeList.
     */
    public TreeMap getCustomeList() {
        return customeList;
    }
    /**
     * sets the customeList
     *
     * @param lCustomeList The customeList to set.
     */
    public void setCustomeList(TreeMap lCustomeList) {
        customeList = lCustomeList;
    }
}

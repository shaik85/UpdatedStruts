/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;
import java.util.TreeMap;
import java.util.Vector;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;

/**
 * This class holds information of customer to be added into the proposal.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 14, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class AddCustomerViewBean extends OPPTViewBean {
	private String proposalName = null;
	private TreeMap customerLists = null;

	/**
	 * Returns collection of customer lists available for selection for adding into a proposal. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getCustomerLists() {
		return customerLists;
	}

	/**
	 * Returns the name of the proposal to which the customer selection is being performed. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getProposalName() {
		return proposalName;
	}

	/**
	 * Sets the collection passed as the customer list collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerLists TreeMap
	 */
	public void setCustomerLists(TreeMap newCustomerLists) {
		customerLists = newCustomerLists;
	}

	/**
	 * Sets the string value passed as the proposal name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalName String  
	 */
	public void setProposalName(String newProposalName) {
		proposalName = newProposalName;
	}
	
	/**
	 * Sets all the information in a single call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalName String
	 * @param customerLists TreeMap
	 */
	public void setData(String proposalName, TreeMap customerLists) {
		setProposalName(proposalName);
		setCustomerLists(customerLists);
	}
	
	/**
	 * Adds the new customer list to already existing collection of customer lists.   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerList CustomerListViewBean
	 */
	public void addCustomerList(CustomerListViewBean customerList) {
		if(customerList != null) {
			if(customerLists == null) {
				customerLists = new TreeMap();
			}
			customerLists.put(customerList.getListNumber(), customerList);
		}
	}

	/**
	 * Sets complete data from an custom dto  
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
	 * @param customDTO AddCustomerCustomDTO
	 */	
	public void setData(AddCustomerCustomDTO customDTO){
		if(null != customDTO){
			ProposalCustomDTO proposal = customDTO.getProposal();
			if(null != proposal){
				String name = proposal.getName();
				String type = proposal.getType();
				String nameType = "";  //$NON-NLS-1$
				if(null != name){
					nameType = name;
					if(null != type){
						nameType += "("+type+")";  //$NON-NLS-1$  //$NON-NLS-2$
					}
				}
			}
			
			setProposalName(customDTO.getProposal().getName());
			setButtonFlags(customDTO.getButtonFlags());
			
			TreeMap customerLists = customDTO.getCustomerLists();
			if(null != customerLists){
				Iterator iterator = customerLists.values().iterator();
				while(iterator.hasNext()){
					addCustomerList(new CustomerListViewBean((CustomerListCustomDTO)iterator.next()));
				}
			}
		}
	}
	
	/**
     * AddCustomerViewBean
     * 
     * @author thirumalai
     */
    public AddCustomerViewBean(){
	}
	/**
     * @param customDTO
     * @author thirumalai
     */
    public AddCustomerViewBean(AddCustomerCustomDTO customDTO){
		setData(customDTO);
	}
}

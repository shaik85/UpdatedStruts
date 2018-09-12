/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.ArrayList;
import java.util.List;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Oct 28, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1x
 */

public class DeleteInventoryCustomDTO extends OPPTCustomDTO 
{
	private ProposalCustomDTO proposal = null;

	private List customers = null;
	private List dMs = null;
	private List swos = null;

	private boolean confirmationRequired = false;

	/**
	 * returns true if confirmation is required 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isConfirmationRequired() {
		return confirmationRequired;
	}

	/**
	 * Returns collection of selected customers 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getCustomers() {
		return customers;
	}

	/**
	 * Returns collection of selected dms 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getDMs() {
		return dMs;
	}

	/**
	 * Returns current proposal details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
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
	 * Returns collection of selected swos 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getSwos() {
		return swos;
	}

	/**
	 * Sets confirmation required flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newConfirmationRequired
	 */
	public void setConfirmationRequired(boolean newConfirmationRequired) {
		confirmationRequired = newConfirmationRequired;
	}

	/**
	 * Sets collection of selected customers 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomers 
	 */
	public void setCustomers(List newCustomers) {
		customers = newCustomers;
	}

	/**
	 * Sets collection of selected dms 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMs 
	 */
	public void setDMs(List newDMs) {
		dMs = newDMs;
	}

	/**
	 * Sets current proposal data 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposal 
	 */
	public void setProposal(ProposalCustomDTO newProposal) {
		proposal = newProposal;
	}

	/**
	 * Sets collection of selcted swos 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwos 
	 */
	public void setSwos(List newSwos) {
		swos = newSwos;
	}
	
	/**
	 * Adds new customer to the collection existing set of selected customers  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customer 
	 */
	public void addCustomer(ProposalCustomerCustomDTO customer){
		if(null != customer){
			if(null == customers){
				customers = new ArrayList();
			}
			customers.add(customer);
		}
	}

	/**
	 * Adds new swo to the collection existing set of selected swos  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swo 
	 */
	public void addSWO(SWOCustomDTO swo){
		if(null != swo){
			if(null == swos){
				swos = new ArrayList();
			}
			swos.add(swo);
		}
	}

	/**
	 * Adds new dm to the collection existing set of selected dms  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dm 
	 */
	public void addDM(DMCustomDTO dm){
		if(null != dm){
			if(null == dMs){
				dMs = new ArrayList();
			}
			dMs.add(dm);
		}
	}
}

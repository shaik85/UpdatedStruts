/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.*;

/**
 * CustomDTO that holds data baout a customer  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 9, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProposalCustomerCustomDTO extends ESWCustomerCustomDTO {

	private int proposalId = -1;
	private int customerId = -1;
	private Date planStartDate = null;
	private Date planEndDate = null;
	private TreeMap dMs = null;
	private ESWCustomerCustomDTO[] eSWCustomerCustomDTOs = null;

	private boolean sAndS = false;

	/**
	 * Returns collection of dms available for the customer 
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
	 * @return TreeMap
	 */
	public TreeMap getDMs() {
		return dMs;
	}

	/**
	 * Returns customer's plan end date 
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
	 * @return Date
	 */
	public Date getPlanEndDate() {
		return planEndDate;
	}

	/**
	 * Returns customers plan start date 
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
	 * @return Date
	 */
	public Date getPlanStartDate() {
		return planStartDate;
	}

	/**
	 * Returs customer's proposal id 
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
	 * @return int
	 */
	public int getProposalId() {
		return proposalId;
	}

	/**
	 * Sets dm collection 
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
	 * @param newDMs TreeMap 
	 */
	public void setDMs(TreeMap newDMs) {
		//		if(null != newDMs){
		//			Iterator iterator = newDMs.values().iterator();
		//			while(iterator.hasNext()){
		//				DMCustomDTO dm = (DMCustomDTO)iterator.next();
		//				if(null != dm){
		//					dm.setProposalId(getProposalId());
		//					dm.setCustomerId(getSAPCustomerNumber());
		//				}
		//			}
		//		}
		dMs = newDMs;
	}

	/**
	 * Sets plan end date of the customer 
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
	 * @param newPlanEndDate Date 
	 */
	public void setPlanEndDate(Date newPlanEndDate) {
		planEndDate = newPlanEndDate;
	}

	/**
	 * Sets plan start date 
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
	 * @param newPlanStartDate Date 
	 */
	public void setPlanStartDate(Date newPlanStartDate) {
		planStartDate = newPlanStartDate;
	}

	/**
	 * Sets proposal id 
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
	 * @param newProposalId int 
	 */
	public void setProposalId(int newProposalId) {
		proposalId = newProposalId;
	}

	/**
	 * Adds a new dm to the collection of dms available for the customer.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dm DMCustomDTO
	 */
	public void addDM(DMCustomDTO dm) {
		if (null != dm) {
			if (null == dMs) {
				dMs = new TreeMap();
			}
			dm.setProposalId(getProposalId());
			dm.setCustomerId(getCustomerId() + "");  /* NOI18N */
			// dMs.put(dm.getId(), dm);
			dMs.put(String.valueOf(dMs.size() + 1), dm);
		}
	}

	/**
	 * Sets complete data about a customer in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aid int
	 * @param acustomerName String
	 * @param asapCustomerNumber String
	 * @param alegacyCustomerNumber String
	 * @param aaddressSequenceNumber String
	 * @param aplanStartDate Date
	 * @param aplanEndDate Date
	 * @param adms TreeMap
	 */
	public void setData(int aid, String acustomerName, String asapCustomerNumber, String alegacyCustomerNumber, String aaddressSequenceNumber, Date aplanStartDate, Date aplanEndDate, TreeMap adms) {
		setCustomerId(aid);
		setCustomerName(acustomerName);
		setSAPCustomerNumber(asapCustomerNumber);
		setLegacyCustomerNumber(alegacyCustomerNumber);
		setAddressSequenceNumber(aaddressSequenceNumber);
		setPlanStartDate(aplanStartDate);
		setPlanEndDate(aplanEndDate);
		setDMs(adms);
	}

	/**
	 * Returns customer id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getCustomerId() {
		return customerId ;
	}

	/**
	 * Sets customer id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerId int
	 */
	public void setCustomerId(int newCustomerId) {
		customerId  = newCustomerId;
	}
	/** 
	 * Returns array of ESWCustomerCustomDTO
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ESWCustomerCustomDTO []
	 */
	public ESWCustomerCustomDTO[] getESWCustomerCustomDTOs() {
		return eSWCustomerCustomDTOs;
	}

	/** 
	 * Sets array of ESWCustomerCustomDTO
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTOs ESWCustomerCustomDTO[]
	 */
	public void setESWCustomerCustomDTOs(ESWCustomerCustomDTO[] customDTOs) {
		eSWCustomerCustomDTOs = customDTOs;
	}

	/** 
	 * toString
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @return String
	 */
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("\nCustomer name: " + getCustomerName());  /* NOI18N */
		buffer.append("\nCustomer id: " + getCustomerId());  /* NOI18N */
		buffer.append("\nProposal id: " + getProposalId());  /* NOI18N */

		if (null != getDMs()) {
			buffer.append("Start of dm Information....");  /* NOI18N */
			Iterator iterator = getDMs().values().iterator();
			while (iterator.hasNext()) {
				buffer.append(iterator.next());
			}
			buffer.append("End of dm Information....");  /* NOI18N */
		}

		return buffer.toString();
	}
	/** 
	 * get method
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean 
	 */
	public boolean isSAndS() {
		return sAndS;
	}

	/** 
	 * set sands
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	
	public void setSAndS(boolean b) {
		sAndS = b;
	}

	/**
	 * finalize method 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 */
	
/*	protected void finalize() {
		
		planStartDate = null;
		planEndDate = null;
		if(dMs != null) {
			dMs.clear();
			dMs = null;
		}
		eSWCustomerCustomDTOs = null;
		
		
	}*/
}
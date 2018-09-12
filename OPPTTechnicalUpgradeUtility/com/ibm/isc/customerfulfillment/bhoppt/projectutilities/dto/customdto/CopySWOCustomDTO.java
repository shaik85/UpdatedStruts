/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.*;

/**
 * Copy SWO Custom DTO
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 16, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class CopySWOCustomDTO extends OPPTCustomDTO {
	private SWOCustomDTO sourceSWO = null;
	private ESWCustomerCustomDTO sourceCustomer = null;
	private String sourceDMNumber = null;
	private String sourceDMDescription = null;
	
	private DMCustomDTO selectedTargetDM = null;
	private String selectedTargetCustomer = null;
	private Map targetCustomers = null;

	private Date planStartDate = null;
	private Date planEndDate = null;
	
	private List startYears = null;
	private List endYears = null;

	/**
	 * Returns copied swo plan end date
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
	 * @return Date
	 */
	public Date getPlanEndDate() {
		return planEndDate;
	}

	/** 
	 * Returns copied swo plan start date
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
	 * @return Date
	 */
	public Date getPlanStartDate() {
		return planStartDate;
	}

	/**
	 * Returns source dm description value 
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
	 * @return String
	 */
	public String getSourceDMDescription() {
		return sourceDMDescription;
	}

	/**
	 * Returns source dm number value 
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
	 * @return String
	 */
	public String getSourceDMNumber() {
		return sourceDMNumber;
	}

	/**
	 * Returns source sold to party value 
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
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getSourceCustomer() {
		return sourceCustomer;
	}

	/**
	 * Returns source swo information 
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
	 * @return SWOCustomDTO
	 */
	public SWOCustomDTO getSourceSWO() {
		return sourceSWO;
	}

	/**
	 * Returns target collection of customers 
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
	 * @return Map
	 */
	public Map getTargetCustomers() {
		return targetCustomers;
	}

	/**
	 * Returns target dm details 
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
	 * @return DMCustomDTO
	 */
	public DMCustomDTO getSelectedTargetDM() {
		return selectedTargetDM;
	}

	/**
	 * Sets copied swos plan end date 
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
	 * @param newPlanEndDate 
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
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanStartDate 
	 */
	public void setPlanStartDate(Date newPlanStartDate) {
		planStartDate = newPlanStartDate;
	}

	/**
	 * Sets source dm description 
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
	 * @param newSourceDMDescription 
	 */
	public void setSourceDMDescription(String newSourceDMDescription) {
		sourceDMDescription = newSourceDMDescription;
	}

	/**
	 * Sets source dm number 
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
	 * @param newSourceDMNumber 
	 */
	public void setSourceDMNumber(String newSourceDMNumber) {
		sourceDMNumber = newSourceDMNumber;
	}

	/**
	 * Sets source sold to party value 
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
	 * @param newSourceCustomer 
	 */
	public void setSourceCustomer(ESWCustomerCustomDTO newSourceCustomer) {
		sourceCustomer = newSourceCustomer;
	}

	/**
	 * Sets source swo details 
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
	 * @param newSourceSWO 
	 */
	public void setSourceSWO(SWOCustomDTO newSourceSWO) {
		sourceSWO = newSourceSWO;
	}

	/**
	 * Sets target customers collection 
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
	 * @param newTargetCustomers 
	 */
	public void setTargetCustomers(TreeMap newTargetCustomers) {
		targetCustomers = newTargetCustomers;
	}

	/**
	 * Sets target dm value 
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
	 * @param newSelectedTargetDM 
	 */
	public void setSelectedTargetDM(DMCustomDTO newSelectedTargetDM) {
		selectedTargetDM = newSelectedTargetDM;
	}
	/**
	 * Returns contract end year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customer
	 */
	
	public void addTargetCustomer(ProposalCustomerCustomDTO customer){
		if(null != customer){
			if(null == targetCustomers){
				targetCustomers = new TreeMap();
			}
			targetCustomers.put(String.valueOf(customer.getCustomerId()), customer);
		}
	}


	/**
	 * Returns contract end year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getEndYears() {
		return endYears;
	}

	/**
	 * Returns contract start year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getStartYears() {
		return startYears;
	}
	/**
	 * Sets contract end year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEndYears 
	 */
	public void setEndYears(List newEndYears) {
		endYears = newEndYears;
	}

	/**
	 * Sets contract start year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStartYears 
	 */
	public void setStartYears(List newStartYears) {
		startYears = newStartYears;
	}
	
	/**
	 * Returns the selected target customer id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedTargetCustomer() {
		return selectedTargetCustomer;
	}

	/**
	 * Sets the selected target customer id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedTargetCustomer 
	 */
	public void setSelectedTargetCustomer(String newSelectedTargetCustomer) {
		selectedTargetCustomer = newSelectedTargetCustomer;
	}
}
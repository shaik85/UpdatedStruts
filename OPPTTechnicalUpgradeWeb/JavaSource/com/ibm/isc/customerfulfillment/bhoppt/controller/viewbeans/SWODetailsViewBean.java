/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;
import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.CustomerInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EECustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWODetailsCustomDTO;

/**
 * Holds complete details required for swo details view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class SWODetailsViewBean extends SWOViewBean {
	private CustomerInfoDataBean iSoldToParty = null;
	private CustomerInfoDataBean iBillToParty = null;
	private CustomerInfoDataBean iPayer = null;
	private Date iCustomerPlanStartDate = null;
	private Date iCustomerPlanEndDate = null;

	private String iDMNumber = null;
	private String iDMDescription = null;	
	private Date iDMPlanStartDate = null;
	private Date iDMPlanEndDate = null;
	
	private String iSwoReferenceSN = null;
	private String iSwoReferenceDN = null;
	private String iSwoContractStatus = null;
	private String iSwoContractNumber = null;
	private String iSwoContractType = null; 

	private TreeMap iEEs = null;
	private boolean iSAndS = false;

	/**
	 * Returns bill to party details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CustomerInfoDataBean
	 */
	public CustomerInfoDataBean getBillToParty() {
		return iBillToParty;
	}

	/**
	 * Returns customers plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getCustomerPlanEndDate() {
		return iCustomerPlanEndDate;
	}

	/**
	 * Returns customers plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getCustomerPlanStartDate() {
		return iCustomerPlanStartDate;
	}

	/**
	 * Returns dm description 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDMDescription() {
		return iDMDescription;
	}

	/**
	 * Returns dm number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDMNumber() {
		return iDMNumber;
	}

	/**
	 * Returns dm plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getDMPlanEndDate() {
		return iDMPlanEndDate;
	}

	/**
	 * Returns dm plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getDMPlanStartDate() {
		return iDMPlanStartDate;
	}

	/**
	 * Returns ee collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getEEs() {
		return iEEs;
	}

	/**
	 * Returns payer details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CustomerInfoDataBean
	 */
	public CustomerInfoDataBean getPayer() {
		return iPayer;
	}

	/**
	 * Returns swo contract type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSwoContractType() {
		return iSwoContractType;
	}

	/**
	 * Returns sold to party details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CustomerInfoDataBean
	 */
	public CustomerInfoDataBean getSoldToParty() {
		return iSoldToParty;
	}

	/**
	 * Returns swo contract number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSwoContractNumber() {
		return iSwoContractNumber;
	}

	/**
	 * Returns swo contract status 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSwoContractStatus() {
		return iSwoContractStatus;
	}

	/**
	 * Returns swo reference dn value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSwoReferenceDN() {
		return iSwoReferenceDN;
	}

	/**
	 * Returns swo reference sn value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSwoReferenceSN() {
		return iSwoReferenceSN;
	}

	/**
	 * Sets bill to party details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToParty CustomerInfoDataBean 
	 */
	public void setBillToParty(CustomerInfoDataBean newBillToParty) {
		iBillToParty = newBillToParty;
	}

	/**
	 * Sets customer plan end date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerPlanEndDate Date 
	 */
	public void setCustomerPlanEndDate(Date newCustomerPlanEndDate) {
		iCustomerPlanEndDate = newCustomerPlanEndDate;
	}

	/**
	 * Sets customer plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerPlanStartDate Date 
	 */
	public void setCustomerPlanStartDate(Date newCustomerPlanStartDate) {
		iCustomerPlanStartDate = newCustomerPlanStartDate;
	}

	/**
	 * Sets dm description value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMDescription String 
	 */
	public void setDMDescription(String newDMDescription) {
		iDMDescription = newDMDescription;
	}

	/**
	 * Sets new dm number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMNumber String 
	 */
	public void setDmNumber(String newDMNumber) {
		iDMNumber = newDMNumber;
	}

	/**
	 * Sets dm plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMPlanEndDate Date 
	 */
	public void setDmPlanEndDate(Date newDMPlanEndDate) {
		iDMPlanEndDate = newDMPlanEndDate;
	}

	/**
	 * Sets dm plan start date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMPlanStartDate Date 
	 */
	public void setDmPlanStartDate(Date newDMPlanStartDate) {
		iDMPlanStartDate = newDMPlanStartDate;
	}

	/**
	 * Sets ee collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEEs TreeMap 
	 */
	public void setEes(TreeMap newEEs) {
		iEEs = newEEs;
	}

	/**
	 * Sets payer details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayer CustomerInfoDataBean
	 */
	public void setPayer(CustomerInfoDataBean newPayer) {
		iPayer = newPayer;
	}

	/**
	 * Sets swo contract type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwoContractType String 
	 */
	public void setSwoContractType(String newSwoContractType) {
		iSwoContractType = newSwoContractType;
	}

	/**
	 * Sets sold to party details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToParty CustomerInfoDataBean
	 */
	public void setSoldToParty(CustomerInfoDataBean newSoldToParty) {
		iSoldToParty = newSoldToParty;
	}

	/**
	 * Sets swo contract number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwoContractNumber String
	 */
	public void setSwoContractNumber(String newSwoContractNumber) {
		iSwoContractNumber = newSwoContractNumber;
	}

	/**
	 * Sets swo contract status 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwoContractStatus String
	 */
	public void setSwoContractStatus(String newSwoContractStatus) {
		iSwoContractStatus = newSwoContractStatus;
	}

	/**
	 * Sets swo reference dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwoReferenceDN String 
	 */
	public void setSwoReferenceDN(String newSwoReferenceDN) {
		iSwoReferenceDN = newSwoReferenceDN;
	}

	/**
	 * Sets swo reference SN 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwoReferenceSN String 
	 */
	public void setSwoReferenceSN(String newSwoReferenceSN) {
		iSwoReferenceSN = newSwoReferenceSN;
	}
	
	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSAndS() {
		return iSAndS;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSAndS(boolean b) {
		iSAndS = b;
	}
	
	/**
	 * Adds ee to the collection of ees available  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ee EEViewBean
	 */
	public void addEE(EEViewBean ee){
		if(null != ee){
			if(null == iEEs){
				iEEs = new TreeMap();
			}
			iEEs.put(ee.getId(), ee);
		}
	}
	
	/**
	 * Sets complete data from an custom dto  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO SWODetailsCustomDTO
	 */
	public void setData(SWODetailsCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			setSerialNumber(customDTO.getSerialNumber());
			setSwoNumber(customDTO.getNumber());
			setDescription(customDTO.getDescription());
			setPlanStartDate(customDTO.getPlanStartDate());
			setPlanEndDate(customDTO.getPlanEndDate());
			setEswPrice(customDTO.getEswPrice());
			setAlternatePrice(customDTO.getAlternatePrice());
			setCalculatedPrice(customDTO.getCalculatedPrice());
			setId(customDTO.getId());
			setSAndS(customDTO.isSAndS());
			
			setSoldToParty(new CustomerInfoDataBean(customDTO.getSoldToParty()));
			setBillToParty(new CustomerInfoDataBean(customDTO.getBillToParty()));
			setPayer(new CustomerInfoDataBean(customDTO.getPayer()));
			setCustomerPlanStartDate(customDTO.getCustomerPlanStartDate());
			setCustomerPlanEndDate(customDTO.getCustomerPlanEndDate());


			setDmNumber(customDTO.getDMNumber());
			setDMDescription(customDTO.getDMDescription());
			setDmPlanStartDate(customDTO.getDMPlanStartDate());
			setDmPlanEndDate(customDTO.getDMPlanEndDate());

			setSwoReferenceSN(customDTO.getSwoReferenceSN());
			setSwoReferenceDN(customDTO.getSwoReferenceDN());
			setSwoContractStatus(customDTO.getSwoContractStatus());
			setSwoContractNumber(customDTO.getSwoContractNumber());
			setSwoContractType(customDTO.getSwoContractType());

			TreeMap ees = customDTO.getEEs();
			if(null != ees){
				Iterator eeIterator = ees.values().iterator();
				while(eeIterator.hasNext()){
					addEE(new EEViewBean((EECustomDTO)eeIterator.next()));
				}
			}
		}
	}
	
	/**
     * SWODetailsViewBean
     * 
     * @author thirumalai
     */
    public SWODetailsViewBean(){
	}
	/**
     * SWODetailsViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public SWODetailsViewBean(SWODetailsCustomDTO customDTO){
		setData(customDTO);
	}
}

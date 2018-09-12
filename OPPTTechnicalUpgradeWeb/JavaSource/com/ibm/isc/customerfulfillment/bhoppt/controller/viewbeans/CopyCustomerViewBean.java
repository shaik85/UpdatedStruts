/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CopyCustomerActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.CustomerInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomerCustomDTO;

/**
 * Hold information required for copy customer view.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CopyCustomerViewBean extends OPPTViewBean {
	private String customerName = null;
	private String customerNumber = null;
	private String legacyCustomerNumber = null;
	private String addressSequenceNumber = null;

	private TreeMap targetCustomerNumber = null;
	private TreeMap targetCustomerName = null;
	private Date startDate = null;
	private Date endDate = null;
	
	private List startYears = null;
	private List endYears = null;


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
	 * @param newEndYears List 
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
	 * @param newStartYears List 
	 */
	public void setStartYears(List newStartYears) {
		startYears = newStartYears;
	}

	/**
	 * Returns the end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Returns the start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Returns the collection of target users 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getTargetCustomerNumber() {
		return targetCustomerNumber;
	}
	/**
     * getTargetCustomerName
     * 
     * @return
     * @author thirumalai
     */
    public TreeMap getTargetCustomerName() {
		return targetCustomerName;
	}

	/**
	 * Sets the end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEndDate Date 
	 */
	public void setEndDate(Date newEndDate) {
		endDate = newEndDate;
	}

	/**
	 * Sets the start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStartDate 
	 */
	public void setStartDate(Date newStartDate) {
		startDate = newStartDate;
	}

	/**
	 * Sets the targer users collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newTargetCustomerNumber TreeMap 
	 */
	public void setTargetCustomerNumber(TreeMap newTargetCustomerNumber) {
		targetCustomerNumber = newTargetCustomerNumber;
	}
	/**
     * setTargetCustomerName
     * 
     * @param newTargetCustomerName
     * @author thirumalai
     */
    public void setTargetCustomerName(TreeMap newTargetCustomerName) {
		targetCustomerName = newTargetCustomerName;
	}

	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(CopyCustomerCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			ProposalCustomerCustomDTO sourceCustomer = customDTO.getSourceCustomer();
			if(null != sourceCustomer){
				setCustomerName(sourceCustomer.getCustomerName());
				setLegacyCustomerNumber(sourceCustomer.getLegacyCustomerNumber());
				setAddressSequenceNumber(sourceCustomer.getAddressSequenceNumber());
				setCustomerNumber(sourceCustomer.getSAPCustomerNumber());
				setStartDate(sourceCustomer.getPlanStartDate());
				setEndDate(sourceCustomer.getPlanEndDate());
			}

			TreeMap targetCustomers = customDTO.getTargetCustomers();
			if(null != targetCustomers){
				Iterator iterator = targetCustomers.keySet().iterator();
				while(iterator.hasNext()){
					String key = (String)iterator.next();
					addTargetCustomer(key, new CustomerInfoDataBean((ProposalCustomerCustomDTO)targetCustomers.get(key)));					
				}
			}

			setStartYears(customDTO.getStartYears());
			setEndYears(customDTO.getEndYears());
		}
	}
	
	/**
     * addTargetCustomer
     * 
     * @param key
     * @param customer
     * @author thirumalai
     */
    public void addTargetCustomer(String key, CustomerInfoDataBean customer){
		if(null != key && null != customer){
			if(null == targetCustomerNumber){
				targetCustomerNumber = new TreeMap();
			}
			if(null == targetCustomerName){
				targetCustomerName = new TreeMap();
			}
			targetCustomerNumber.put(key, customer.getLegacyCustomerNumberWithAS());
			targetCustomerName.put(key, customer.getCustomerName());
		}
	}
	
	/**
     * CopyCustomerViewBean
     * 
     * @author thirumalai
     */
    public CopyCustomerViewBean(){
	}

	/**
     * @param customDTO
     * @author thirumalai
     */
    public CopyCustomerViewBean(CopyCustomerCustomDTO customDTO){
		setData(customDTO);
	}

	/**
	 * Returns customer name value 
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
	 * @return String 
	 */
	public String getCustomerName() {
		return customerName;
	}

	/** 
	 * Retunrs customer number
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
	 * @return String
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * Returns legacy customer number 
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
	 * @return String
	 */
	public String getLegacyCustomerNumber() {
		return legacyCustomerNumber;
	}


	/**
	 * Returns legacy customer embeded with address sequence number  
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
	 * @return String
	 */
	public String getLegacyCustomerNumberWithAS() {
		return legacyCustomerNumber+" "+addressSequenceNumber;  //$NON-NLS-1$
	}

	/**
	 * Sets customer name 
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
	 * @param newCustomerName String 
	 */
	public void setCustomerName(String newCustomerName) {
		customerName = newCustomerName;
	}

	/**
	 * Sets customer number 
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
	 * @param newCustomerNumber String 
	 */
	public void setCustomerNumber(String newCustomerNumber) {
		customerNumber = newCustomerNumber;
	}

	/**
	 * Sets legacy customer number 
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
	 * @param newLegacyCustomerNumber String 
	 */
	public void setLegacyCustomerNumber(String newLegacyCustomerNumber) {
		legacyCustomerNumber = newLegacyCustomerNumber;
	}
	

	/**
	 * Returns address sequence number 
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
	 * @return String
	 */
	public String getAddressSequenceNumber() {
		return addressSequenceNumber;
	}


	/**
	 * Sets address sequence number of the customer 
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
	 * @param newAddressSequenceNumber string 
	 */
	public void setAddressSequenceNumber(String newAddressSequenceNumber) {
		addressSequenceNumber = newAddressSequenceNumber;
	}
	
	/**
     * getCopyCustomerActionForm
     * 
     * @return
     * @author thirumalai
     */
    public CopyCustomerActionForm getCopyCustomerActionForm(){
		CopyCustomerActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof CopyCustomerActionForm){
			actionForm = (CopyCustomerActionForm)getActionForm();
		}
		else{
			actionForm = new CopyCustomerActionForm();
		}
		return actionForm;
	}
}
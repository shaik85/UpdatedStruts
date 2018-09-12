/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomerListCustomDTO;

/**
 * Action form for fetch customer list selection  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 3, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class FetchCustomerListActionForm extends OPPTActionForm {
	private String customerListNumber = null;
	private String customerListName = null;
	
	//DAD02 Sateesh
	private String siteID = null;
	private String siteName = null;
	
	private String zipCode = null;
	private String city = null;
	private String comments = null;
	
	/**
	 * Returns city value 
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
	 * @return String
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Returns customer list name 
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
	 * @return String
	 */
	public String getCustomerListName() {
		return customerListName;
	}

	/**
	 * Returns customer list number 
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
	 * @return String
	 */
	public String getCustomerListNumber() {
		return customerListNumber;
	}

	/**
	 * Returns zip code value 
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
	 * @return String
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Sets city value 
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
	 * @param newCity String 
	 */
	public void setCity(String newCity) {
		city = newCity;
	}

	/**
	 * Sets customer list name value 
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
	 * @param newCustomerListName String 
	 */
	public void setCustomerListName(String newCustomerListName) {
		customerListName = newCustomerListName;
	}

	/**
	 * Sets customer list number 
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
	 * @param newCustomerListNumber String 
	 */
	public void setCustomerListNumber(String newCustomerListNumber) {
		customerListNumber = newCustomerListNumber;
	}

	/**
	 * Sets zip code value 
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
	 * @param newZipCode String 
	 */
	public void setZipCode(String newZipCode) {
		zipCode = newZipCode;
	}
	
	public void getRequestParams(FetchCustomerListCustomDTO customDTO){
		if(null != customDTO){
			if(null != getCustomerListNumber()){
				customDTO.setCustomerListNumber(getCustomerListNumber().toUpperCase());
			}
			if(null != getCustomerListName()){
				customDTO.setCustomerListName(getCustomerListName().toUpperCase());
			}
			if(null != getZipCode()){
				customDTO.setZipCode(getZipCode().toUpperCase());
			}
			if(null != getCity()){
				customDTO.setCity(getCity().toUpperCase());
			}
			if(null!=getSiteID()){
				customDTO.setSiteID(getSiteID().toUpperCase());
			}
			if(null!=getSiteName()){
				customDTO.setSiteName(getSiteName().toUpperCase());
			}
		}
	}

	public void reset(){
		customerListNumber = null;
		customerListName = null;
		siteID = null;
		siteName = null;
		zipCode = null;
		city = null;
		comments = null;
	}
	
	/**
	 * Returns comments value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Sets comments value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCommens String 
	 */
	public void setComments(String newCommens) {
		comments = newCommens;
	}
	/**
	 * @return Returns the siteID.
	 */
	public String getSiteID() {
		return siteID;
	}
	/**
	 * @param siteID The siteID to set.
	 */
	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}
	/**
	 * @return Returns the siteName.
	 */
	public String getSiteName() {
		return siteName;
	}
	/**
	 * @param siteName The siteName to set.
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
}
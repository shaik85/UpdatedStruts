/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ErrorDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ErrorInfoCustomDTO;

/**
 * Holds the information about an error entry in the error history of a proposal.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 19, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ErrorInfoViewBean extends OPPTViewBean {
	private Integer iId = null;
	private String iUserId = null;
	private int iMessageNumber = 0;
	private String iMessageDescription = null;
	private Date iDate = null;
	private Time iTime = null;
	private ArrayList iErrorDetails = null;
	private boolean iContract = false;
	
	/**
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public ErrorInfoViewBean(){
	}

	/**
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param customDTO ErrorInfoCustomDTO
	 */
	public ErrorInfoViewBean(ErrorInfoCustomDTO customDTO){
		setData(customDTO);
	}
	
	/**
     * ErrorInfoViewBean
     * @param customDTO
     * @param contract
     * @author thirumalai
     */
    public ErrorInfoViewBean(ErrorInfoCustomDTO customDTO, boolean contract){
		setData(customDTO);
		setContract(contract);
	}
	

	/**
	 * Returns date time when this error occured 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getDate() {
		return iDate;
	}

	/**
	 * Returns ErrorDetailsViewBean if this error has some details associated with it. 
	 * If none it returns null. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ArrayList
	 */
	public ArrayList getErrorDetails() {
		return iErrorDetails;
	}

	/**
	 * Returns identifier for this error 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Integer
	 */
	public Integer getId() {
		return iId;
	}

	/** 
	 * Returns message description
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getMessageDescription() {
		return iMessageDescription;
	}

	/**
	 * Returns message number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getMessageNumber() {
		return iMessageNumber;
	}

	/**
	 * Retuns user id involved in occurance of this error. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getUserId() {
		return iUserId;
	}

	/**
	 * Sets the date and time of the occurance of the error message 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDate Date 
	 */
	public void setDate(Date newDate) {
		iDate = newDate;
	}

	/**
	 * Sets the error details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newErrorDetails ArrayList 
	 */
	public void setErrorDetails(ArrayList newErrorDetails) {
		iErrorDetails = newErrorDetails;
	}

	/**
	 * Sets the error id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newId Integer 
	 */
	public void setId(Integer newId) {
		iId = newId;
	}

	/**
	 * Sets the error description 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessageDescription String 
	 */
	public void setMessageDescription(String newMessageDescription) {
		iMessageDescription = newMessageDescription;
	}

	/**
	 * Sets the message number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessageNumber int 
	 */
	public void setMessageNumber(int newMessageNumber) {
		iMessageNumber = newMessageNumber;
	}

	/**
	 * Sets the user id associated with the error 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUserId String 
	 */
	public void setUserId(String newUserId) {
		iUserId = newUserId;
	}

	/**
	 * Sets complete data from the custom dto.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO ErrorInfoCustomDTO
	 */
	public void setData(ErrorInfoCustomDTO customDTO){
		if(null != customDTO){
			setId(customDTO.getId());
			setUserId(customDTO.getUserId());
			setMessageNumber((int)customDTO.getMessageNumber());
			setMessageDescription(customDTO.getMessageDescription());
			setDate(customDTO.getDate());
			setTime(customDTO.getTime());
			
			ArrayList errorDetails = customDTO.getErrorDetails();
			if(null != errorDetails){
				for(int i=0, size=errorDetails.size(); i<size; i++){
					addErrorDetail(new ErrorDetailsViewBean((ErrorDetailsCustomDTO)errorDetails.get(i)));
				}
			}
		}
	}

	/**
	 * Adds new error details object to the collection of error detail objects available
	 * for the error.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorDetail ErrorDetailsViewBean
	 */	
	public void addErrorDetail(ErrorDetailsViewBean errorDetail){
		if(null != errorDetail){
			if(null == iErrorDetails){
				iErrorDetails = new ArrayList();
			}
			iErrorDetails.add(errorDetail);
		}
	}
	
	/**
	 * Returns the time at which the error occured 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Time
	 */
	public Time getTime() {
		return iTime;
	}

	/**
	 * Sets the time at which error occured 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newTime Time 
	 */
	public void setTime(Time newTime) {
		iTime = newTime;
	}

	/**
	 * Returns true if the error history is for an contract 
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
	 * @return boolean
	 */
	public boolean isContract() {
		return iContract;
	}

	/**
	 * Sets a flag telling whether the error history is for an proposal or a contract. 
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
	 * @param newContract boolean
	 */
	public void setContract(boolean newContract) {
		iContract = newContract;
	}
}

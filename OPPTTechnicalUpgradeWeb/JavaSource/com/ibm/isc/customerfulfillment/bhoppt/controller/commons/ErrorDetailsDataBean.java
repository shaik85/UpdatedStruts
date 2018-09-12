/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;


/**
 * Holds error details information  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 25, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ErrorDetailsDataBean extends OPPTDataBean{
	private String exceptionCode = null;
	private String salesDocNumber = null;
	private String itemPositionNumber = null;
	private String internalContractNumber = null;
	private String message = null;
	
	/**
	 * Returns error code 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getExceptionCode() {
		return exceptionCode;
	}

	/**
	 * Returns internal contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getInternalContractNumber() {
		return internalContractNumber;
	}

	/**
	 * Returns item position number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getItemPositionNumber() {
		return itemPositionNumber;
	}

	/**
	 * Returns message value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Returns sales doc number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSalesDocNumber() {
		return salesDocNumber;
	}

	/**
	 * Sets exception code value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newExceptionCode String 
	 */
	public void setExceptionCode(String newExceptionCode) {
		exceptionCode = newExceptionCode;
	}

	/**
	 * Sets internal contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newInternalContractNumber String 
	 */
	public void setInternalContractNumber(String newInternalContractNumber) {
		internalContractNumber = newInternalContractNumber;
	}

	/**
	 * Sets item position number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newItemPositionNumber String 
	 */
	public void setItemPositionNumber(String newItemPositionNumber) {
		itemPositionNumber = newItemPositionNumber;
	}

	/**
	 * Sets message value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessage String 
	 */
	public void setMessage(String newMessage) {
		message = newMessage;
	}

	/**
	 * Sets sales doc number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSalesDocNumber String 
	 */
	public void setSalesDocNumber(String newSalesDocNumber) {
		salesDocNumber = newSalesDocNumber;
	}

	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param exceptionCode String
	 * @param salesDocNumber String
	 * @param itemPositionNumber String
	 * @param internalContractNumber String
	 * @param message String
	 */
	public void setData(String exceptionCode, String salesDocNumber, String itemPositionNumber, 
						String internalContractNumber, String message){
		setExceptionCode(exceptionCode);
		setSalesDocNumber(salesDocNumber);
		setItemPositionNumber(itemPositionNumber);
		setInternalContractNumber(internalContractNumber);
		setMessage(message);
	}
}

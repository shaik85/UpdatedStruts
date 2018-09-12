/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * Custom dto that holds information about an error detail record.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 31, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ErrorDetailsCustomDTO extends OPPTCustomDTO 
{
	private String exceptionCode = null;
	private String salesDocNumber = null;
	private String itemPositionNumber = null;
	private String internalContractNumber = null;
	private String message = null;
	
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
	public ErrorDetailsCustomDTO(){
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
	 * @param aexceptionCode 
	 * @param asalesDocNumber 
	 * @param aitemPositionNumber 
	 * @param ainternalContractNumber 
	 * @param amessage 
	 */
	public ErrorDetailsCustomDTO(String aexceptionCode, String asalesDocNumber, String aitemPositionNumber,
								String ainternalContractNumber, String amessage){
		setData(aexceptionCode, asalesDocNumber,aitemPositionNumber, ainternalContractNumber, amessage);
	}
	

	/**
	 * Returns exception code value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
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
	 * Returns internal contract number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
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
	 * Returns item position number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
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
	 * date Dec 29, 2003 
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
	 * Returns sales document number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
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
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newExceptionCode 
	 */
	public void setExceptionCode(String newExceptionCode) {
		exceptionCode = newExceptionCode;
	}

	/**
	 * Sets internal contract number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newInternalContractNumber 
	 */
	public void setInternalContractNumber(String newInternalContractNumber) {
		internalContractNumber = newInternalContractNumber;
	}

	/**
	 * Sets item position number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newItemPositionNumber 
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
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessage 
	 */
	public void setMessage(String newMessage) {
		message = newMessage;
	}

	/**
	 * Sets sales document number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSalesDocNumber 
	 */
	public void setSalesDocNumber(String newSalesDocNumber) {
		salesDocNumber = newSalesDocNumber;
	}
	
	/**
	 * Sets complete data in a single method call.  
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
	 * @param aexceptionCode 
	 * @param asalesDocNumber 
	 * @param aitemPositionNumber 
	 * @param ainternalContractNumber 
	 * @param amessage 
	 */
	public void setData(String aexceptionCode, String asalesDocNumber, String aitemPositionNumber,
						String ainternalContractNumber, String amessage){
		setExceptionCode(aexceptionCode);
		setSalesDocNumber(asalesDocNumber);
		setItemPositionNumber(aitemPositionNumber);
		setInternalContractNumber(ainternalContractNumber);
		setMessage(amessage);
	}
}

/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ErrorDetailsCustomDTO;

/**
 * Hold information about ErrorDetails of an proposal error history entry.  
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
public class ErrorDetailsViewBean extends OPPTViewBean 
{
	private String iExceptionCode = null;
	private String iSalesDocNumber = null;
	private String iItemPositionNumber = null;
	private String iInternalContractNumber = null;
	private String iMessage = null;
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
	public ErrorDetailsViewBean(){
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
	 * @param customDTO ErrorDetailsCustomDTO
	 */
	public ErrorDetailsViewBean(ErrorDetailsCustomDTO customDTO){
		setData(customDTO);
	}
	/**
     * ErrorDetailsViewBean
     * 
     * @param customDTO
     * @param contract
     * @author thirumalai
     */
    public ErrorDetailsViewBean(ErrorDetailsCustomDTO customDTO, boolean contract){
		setData(customDTO);
		setContract(contract);
	}

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
		return iExceptionCode;
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
		return iInternalContractNumber;
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
		return iItemPositionNumber;
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
		return iMessage;
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
		return iSalesDocNumber;
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
		iExceptionCode = newExceptionCode;
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
		iInternalContractNumber = newInternalContractNumber;
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
		iItemPositionNumber = newItemPositionNumber;
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
		iMessage = newMessage;
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
		iSalesDocNumber = newSalesDocNumber;
	}
	
	/**
	 * Sets complete data from an custom dto  
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
	 * @param customDTO ErrorDetailsCustomDTO
	 */
	public void setData(ErrorDetailsCustomDTO customDTO){
		if(null != customDTO){
			setExceptionCode(customDTO.getExceptionCode());
			setSalesDocNumber(customDTO.getSalesDocNumber());
			setItemPositionNumber(customDTO.getItemPositionNumber());
			setInternalContractNumber(customDTO.getInternalContractNumber());
			setMessage(customDTO.getMessage());
		}
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

/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Class that hold the ee information that is used in compare tp report.  
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
public class CompareTPEEViewBean extends OPPTViewBean{
	private String serialNumber;
	private String eeNumber;
	private String eeDescription;
	private boolean changeInESWPrice;
	private boolean oldContract;
	private boolean newContract;

	/**
	 * Returns true if there is change in esw price for the ee.  
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
	 * @return boolean
	 */
	public boolean isChangeInESWPrice() {
		return changeInESWPrice;
	}

	/**
	 * Returns the ee description 
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
	 * @return String
	 */
	public String getEEDescription() {
		return eeDescription;
	}

	/**
	 * Returns the ee number 
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
	 * @return String
	 */
	public String getEENumber() {
		return eeNumber;
	}

	/**
	 * Returns true if the contract is a new contract 
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
	 * @return boolean
	 */
	public boolean isNewContract() {
		return newContract;
	}

	/**
	 * Returns true if the contract is a old contract 
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
	 * @return boolean
	 */
	public boolean isOldContract() {
		return oldContract;
	}

	/**
	 * Returns the serial number of the EE 
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
	 * @return String
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Sets the change in esw price flag. 
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
	 * @param newChangeInESWPrice boolean 
	 */
	public void setChangeInESWPrice(boolean newChangeInESWPrice) {
		changeInESWPrice = newChangeInESWPrice;
	}

	/**
	 * Sets EE description 
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
	 * @param newEEDescription String 
	 */
	public void setEEDescription(String newEEDescription) {
		eeDescription = newEEDescription;
	}

	/**
	 * Sets the EE number 
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
	 * @param newEENumber String 
	 */
	public void setEENumber(String newEENumber) {
		eeNumber = newEENumber;
	}

	/**
	 * Sets new contract flag. 
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
	 * @param newContract boolean 
	 */
	public void setNewContract(boolean lnewContract) {
		newContract = lnewContract;
	}

	/**
	 * Sets old contract flag 
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
	 * @param newOldContract boolean 
	 */
	public void setOldContract(boolean newOldContract) {
		oldContract = newOldContract;
	}

	/**
	 * Sets the ee serial number 
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
	 * @param newSerialNumber String 
	 */
	public void setSerialNumber(String newSerialNumber) {
		serialNumber = newSerialNumber;
	}
	
	/**
	 * Sets the data in a single method call  
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
	 * @param newSerialNumber String
	 * @param newEENumber String
	 * @param newEEDescription String
	 * @param newChangeInESWPrice boolean
	 * @param newOldContract boolean
	 * @param newContract boolean
	 */
	public void setData(String newSerialNumber, String newEENumber, String newEEDescription, boolean newChangeInESWPrice, boolean newOldContract, boolean newContract){
		setSerialNumber(newSerialNumber);
		setEENumber(newEENumber);
		setEEDescription(newEEDescription);
		setChangeInESWPrice(newChangeInESWPrice);
		setOldContract(newOldContract);
		setNewContract(newContract);
	}
}

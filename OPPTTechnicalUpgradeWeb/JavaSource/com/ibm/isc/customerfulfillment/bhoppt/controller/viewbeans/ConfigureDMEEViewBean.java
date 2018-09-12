/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMEECustomDTO;

/**
 * Holds ee information of the Configure DM view.
 * 
 * There are different states an EE can be shown when configuring DM. Each state should be 
 * represented in different color. This state is represented by color type property.  
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
public class ConfigureDMEEViewBean extends OPPTViewBean 
{
	private String id = null;
	private String eeNumber = null;
	private String licenseType = null;
	private String valueMetricDescription = null;
	private String useLevel = null;
	private String chargeOption = null;
	
	/**
	 * Display ee in another color
	 */	
	private boolean defaulted = false;
	/**
	 * Display ee in another color
	 */	
	private boolean invalid = false;
	
	/**
	 * Display ee in another color
	 */	
	private boolean copied = false;

	/**
	 * Returns the charge option at EE level. 
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
	public String getChargeOption() {
		return chargeOption;
	}

	/**
	 * Returns the EE number associated with the EE 
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
	 * Returns the license type of the EE. 
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
	public String getLicenseType() {
		return licenseType;
	}

	/**
	 * Returns the use level of the EE. 
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
	public String getUseLevel() {
		return useLevel;
	}

	/**
	 * Returns the value metric description of the EE. 
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
	public String getValueMetricDescription() {
		return valueMetricDescription;
	}

	/**
	 * Sets the charge option of the EE. 
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
	 * @param newChargeOption String 
	 */
	public void setChargeOption(String newChargeOption) {
		chargeOption = newChargeOption;
	}

	/**
	 * Sets the ee number for the EE. 
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
	 * @param newEENumber 
	 */
	public void setEeNumber(String newEENumber) {
		eeNumber = newEENumber;
	}

	/**
	 * Sets the license type of the ee. 
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
	 * @param newLicenseType String 
	 */
	public void setLicenseType(String newLicenseType) {
		licenseType = newLicenseType;
	}

	/**
	 * Sets the use level of the ee. 
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
	 * @param newUseLevel String 
	 */
	public void setUseLevel(String newUseLevel) {
		useLevel = newUseLevel;
	}

	/**
	 * Sets the value metric description of the ee. 
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
	 * @param newValueMetricDescription String 
	 */
	public void setValueMetricDescription(String newValueMetricDescription) {
		valueMetricDescription = newValueMetricDescription;
	}
	
	/**
	 * Returns true if ee is an defaulted ee
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isDefaulted() {
		return defaulted;
	}

	/**
	 * Returns true if the ee is an invalid ee 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isInvalid() {
		return invalid;
	}

	/**
	 * Sets defaulted property of the ee 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDefaulted boolean 
	 */
	public void setDefaulted(boolean newDefaulted) {
		defaulted = newDefaulted;
	}

	/**
	 * Sets valid property of the ee 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newInalid boolean 
	 */
	public void setInvalid(boolean newInalid) {
		invalid = newInalid;
	}
	
	/**
	 * Returns copied flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isCopied() {
		return copied;
	}

	/**
	 * Sets copied flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCopied boolean 
	 */
	public void setCopied(boolean newCopied) {
		copied = newCopied;
	}

	/**
	 * setData
	 * 
	 * @param customDTO
	 */
	public void setData(ConfigureDMEECustomDTO customDTO){
		if(null != customDTO){
			setId(customDTO.getId());
			setEeNumber(customDTO.getEeNumber());
			setLicenseType(customDTO.getLicenseType());
			setValueMetricDescription(customDTO.getValueMetricDescription());
			setUseLevel(customDTO.getUseLevel());
			setChargeOption(customDTO.getChargeOption());
	
			setDefaulted(customDTO.isDefaultedEE());
			setInvalid(customDTO.isInvalidEE());
			setCopied(customDTO.isCopiedEE());	
		}
	}
	
	/**
	 * Returns ee view bean 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets ee identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newId String 
	 */
	public void setId(String newId) {
		id = newId;
	}

	/**
	 * ConfigureDMEEViewBean
	 * 
	 */	
	public ConfigureDMEEViewBean(){
	}

	/**
	 * ConfigureDMEEViewBean
	 * 
	 * @param customDTO
	 */		
	public ConfigureDMEEViewBean(ConfigureDMEECustomDTO customDTO){
		setData(customDTO);
	}
}

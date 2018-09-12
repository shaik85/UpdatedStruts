/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;
/**
 * Configure DMEE Custom DTO
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */

public class ConfigureDMEECustomDTO extends OPPTCustomDTO {
	private String id = null;
	private String eeNumber = null;
	private String eeItemNumber = null;
	private String salesDocNumber = null;
	private String swoItemNo=null;

	private String licenseType = null;
	private String valueMetricDescription = null;
	private String useLevel = null;
	private String chargeOption = null;

	private boolean defaultedEE = false;
	private boolean copiedEE = false;
	private boolean invalidEE = false;

	private boolean selected = false;
	
	private String vm=null;
	private String lt=null;
	private String cho=null;
	private String mt=null;
	private String ul=null;

	/**
	 * Returns chage option for the ee 
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
	public String getChargeOption() {
		return chargeOption;
	}

	/**
	 * Returns true if the ee is an copied ee 
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
	public boolean isCopiedEE() {
		return copiedEE;
	}

	/**
	 * Returns true if the ee is an defaulted ee 
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
	public boolean isDefaultedEE() {
		return defaultedEE;
	}

	/**
	 * Returns ee item number 
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
	public String getEeItemNumber() {
		return eeItemNumber;
	}

	/**
	 * Returns ee number 
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
	public String getEeNumber() {
		return eeNumber;
	}

	/**
	 * Returs ee identifier 
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
	 * Returns true if the ee is an invalid ee 
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
	public boolean isInvalidEE() {
		return invalidEE;
	}

	/**
	 * Returns the license type 
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
	public String getLicenseType() {
		return licenseType;
	}

	/**
	 * Returns saled doc number 
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
	public String getSalesDocNumber() {
		return salesDocNumber;
	}

	/**
	 * Returns true if the ee is selected  
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
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Returns use level value 
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
	public String getUseLevel() {
		return useLevel;
	}

	/**
	 * Returns value metric description value 
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
	public String getValueMetricDescription() {
		return valueMetricDescription;
	}

	/**
	 * Sets charge option value 
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
	 * @param newChargeOption String 
	 */
	public void setChargeOption(String newChargeOption) {
		chargeOption = newChargeOption;
	}

	/**
	 * Sets copied ee flag 
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
	 * @param newCopiedEE boolean
	 */
	public void setCopiedEE(boolean newCopiedEE) {
		copiedEE = newCopiedEE;
	}

	/**
	 * Sets defaulted ee flag 
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
	 * @param newDefaultedEE boolean
	 */
	public void setDefaultedEE(boolean newDefaultedEE) {
		defaultedEE = newDefaultedEE;
	}

	/**
	 * Sets ee item number value 
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
	 * @param newEEItemNumber String 
	 */
	public void setEeItemNumber(String newEEItemNumber) {
		eeItemNumber = newEEItemNumber;
	}

	/**
	 * Sets new ee number 
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
	 * @param newEENumber String 
	 */
	public void setEeNumber(String newEENumber) {
		eeNumber = newEENumber;
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
	 * Sets invalid ee identifier 
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
	 * @param newInvalidEE boolean
	 */
	public void setInvalidEE(boolean newInvalidEE) {
		invalidEE = newInvalidEE;
	}

	/**
	 * Sets license type value 
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
	 * @param newLicenseType String 
	 */
	public void setLicenseType(String newLicenseType) {
		licenseType = newLicenseType;
	}

	/**
	 * Sets saled doc number value 
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
	 * @param newSalesDocNumber String 
	 */
	public void setSalesDocNumber(String newSalesDocNumber) {
		salesDocNumber = newSalesDocNumber;
	}

	/**
	 * Sets ee selected flag value 
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
	 * @param newSelected boolean
	 */
	public void setSelected(boolean newSelected) {
		selected = newSelected;
	}

	/**
	 * Sets use level value 
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
	 * @param newUseLevel String 
	 */
	public void setUseLevel(String newUseLevel) {
		useLevel = newUseLevel;
	}

	/**
	 * Sets value metric description value 
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
	 * @param newValueMetricDescription String 
	 */
	public void setValueMetricDescription(String newValueMetricDescription) {
		valueMetricDescription = newValueMetricDescription;
	}
	/**
	 * get swo item no
	 * 
	 * @return
	 */
	public String getSwoItemNo() {
		return swoItemNo;
	}

	/**
	 * set swo item no
	 * 
	 * @param string
	 */
	public void setSwoItemNo(String string) {
		swoItemNo = string;
	}

	/**
	 * get cho
	 * 
	 * @return String
	 */
	public String getCho() {
		return cho;
	}

	/**
	 * get it
	 * 
	 * @return String
	 */
	
	public String getLt() {
		return lt;
	}

	/**
	 * get Mt
	 * 
	 * @return String
	 */
	
	public String getMt() {
		return mt;
	}

	/**
	 * get ui
	 * 
	 * @return String
	 */
	
	public String getUl() {
		return ul;
	}

	/**
	 * get vm
	 * 
	 * @return String
	 */
	public String getVm() {
		return vm;
	}

	/**
	 * set cho
	 * 
	 * @param string
	 */
	
	public void setCho(String string) {
		cho = string;
	}

	/**
	 * set it
	 * 
	 * @param string
	 */
	
	public void setLt(String string) {
		lt = string;
	}

	/**
	 * set mt
	 * 
	 * @param string
	 */
	public void setMt(String string) {
		mt = string;
	}

	/**
	 * set ui
	 * 
	 * @param string
	 */
	
	public void setUl(String string) {
		ul = string;
	}

	/**
	 * set vm
	 * 
	 * @param string
	 */
	public void setVm(String string) {
		vm = string;
	}

}

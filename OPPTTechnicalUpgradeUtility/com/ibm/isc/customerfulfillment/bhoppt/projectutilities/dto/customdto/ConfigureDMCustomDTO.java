/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.*;
/**
 * Configure DM Custom DTO
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

public class ConfigureDMCustomDTO extends OPPTCustomDTO 
{
	private int proposalId = -1;
	private String customerId = null;
	private String id = null;
	private String number = null;
	private String description = null;

	private Date planEndDate = null;
	private Date planStartDate = null;
	
	private Date bumpPlanStartDate = null;
	private Date bumpPlanEndDate = null;
	
	private Map valueMetricDescription = null;
	private Map licenseType = null;
	private Map chargeOption = null;
	private Map useLevel = null;
	
	private String selectedValueMetricDescription = null;
	private String selectedLicenseType = null;
	private String selectedChargeOption = null;
	private String selectedUseLevel = null;
	
	private List swos = null;

	private boolean configChange = false;
	
	private boolean selectCopy= false;
	
	private boolean vmChanged=false;
	private boolean licenseTypeChaged=false;
	private boolean choChanged=false;
	private boolean useLevelChanged=false;

	private List startYears = null;
	private List endYears = null;

	private ConfigureDMEECustomDTO defaultedEE = null;

	private boolean sAndS = false;

	private boolean displayDefaultValues = true;

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
	 * @param newEndYears
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
	 * @param newStartYears 
	 */
	public void setStartYears(List newStartYears) {
		startYears = newStartYears;
	}

	/**
	 * Returns bump plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getBumpPlanEndDate() {
		return bumpPlanEndDate;
	}

	/**
	 * Returns bump plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getBumpPlanStartDate() {
		return bumpPlanStartDate;
	}

	/**
	 * Returns charge option collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Map
	 */
	public Map getChargeOption() {
		return chargeOption;
	}

	/**
	 * Returns customer id to which the dm belongs 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Returns description about the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns dm identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
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
	 * Returns license type collection
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Map
	 */
	public Map getLicenseType() {
		return licenseType;
	}

	/**
	 * Returns dm number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Returns plan end date for the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getPlanEndDate() {
		return planEndDate;
	}

	/**
	 * Returns plan start date  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getPlanStartDate() {
		return planStartDate;
	}

	/**
	 * Returns proposal id to which the dm belongs to 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getProposalId() {
		return proposalId;
	}

	/**
	 * Returns selected charge option 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedChargeOption() {
		return selectedChargeOption;
	}

	/**
	 * Returns selected license type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedLicenseType() {
		return selectedLicenseType;
	}

	/**
	 * Returns selected use level value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedUseLevel() {
		return selectedUseLevel;
	}

	/**
	 * Returns selected value metric description value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedValueMetricDescription() {
		return selectedValueMetricDescription;
	}

	/**
	 * Returns swo collection for the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getSwos() {
		return swos;
	}

	/**
	 * Returns use level collection values 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Map
	 */
	public Map getUseLevel() {
		return useLevel;
	}

	/**
	 * Returns value metric description collection values
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Map
	 */
	public Map getValueMetricDescription() {
		return valueMetricDescription;
	}

	/**
	 * Returns bump plan end date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBumpPlanEndDate Date 
	 */
	public void setBumpPlanEndDate(Date newBumpPlanEndDate) {
		bumpPlanEndDate = newBumpPlanEndDate;
	}

	/**
	 * Returns bump plan start date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBumpPlanStartDate Date 
	 */
	public void setBumpPlanStartDate(Date newBumpPlanStartDate) {
		bumpPlanStartDate = newBumpPlanStartDate;
	}

	/**
	 * Sets charge options collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newChargeOption TreeMap 
	 */
	public void setChargeOption(Map newChargeOption) {
		chargeOption = newChargeOption;
	}

	/**
	 * Sets customer id value to which the dm belongs 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerId String 
	 */
	public void setCustomerId(String newCustomerId) {
		customerId = newCustomerId;
	}

	/**
	 * Sets description value for the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDescription String 
	 */
	public void setDescription(String newDescription) {
		description = newDescription;
	}

	/**
	 * Sets id value for the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
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
	 * Sets license type for the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLicenseType Map 
	 */
	public void setLicenseType(Map newLicenseType) {
		licenseType = newLicenseType;
	}

	/**
	 * Sets dm number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNumber String 
	 */
	public void setNumber(String newNumber) {
		number = newNumber;
	}

	/**
	 * Sets plan end date value for the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanEndDate Date 
	 */
	public void setPlanEndDate(Date newPlanEndDate) {
		planEndDate = newPlanEndDate;
	}

	/**
	 * Sets plan start date for the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanStartDate Date 
	 */
	public void setPlanStartDate(Date newPlanStartDate) {
		planStartDate = newPlanStartDate;
	}

	/**
	 * Sets proposal id value to which the dm belongs to 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalId int
	 */
	public void setProposalId(int newProposalId) {
		proposalId = newProposalId;
	}

	/**
	 * Sets selected charge option value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedChargeOption String 
	 */
	public void setSelectedChargeOption(String newSelectedChargeOption) {
		selectedChargeOption = newSelectedChargeOption;
	}

	/**
	 * Sets selected license type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedLicenseType String 
	 */
	public void setSelectedLicenseType(String newSelectedLicenseType) {
		selectedLicenseType = newSelectedLicenseType;
	}

	/**
	 * Sets selected use level value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedUseLevel String 
	 */
	public void setSelectedUseLevel(String newSelectedUseLevel) {
		selectedUseLevel = newSelectedUseLevel;
	}

	/**
	 * Sets selected value metric description value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedValueMetricDescription String 
	 */
	public void setSelectedValueMetricDescription(String newSelectedValueMetricDescription) {
		selectedValueMetricDescription = newSelectedValueMetricDescription;
	}

	/**
	 * Sets swos collection for the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwos List 
	 */
	public void setSwos(List newSwos) {
		swos = newSwos;
	}

	/**
	 * Returns use level collection values 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUseLevel Map
	 */
	public void setUseLevel(Map newUseLevel) {
		useLevel = newUseLevel;
	}

	/**
	 * Sets value metric description collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newValueMetricDescription Map
	 */
	public void setValueMetricDescription(Map newValueMetricDescription) {
		valueMetricDescription = newValueMetricDescription;
	}

	/**
	 * Return configChage flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isConfigChange() {
		return configChange;
	}

	/** 
	 * Sets config change value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newConfigChange boolean
	 */
	public void setConfigChange(boolean newConfigChange) {
		configChange = newConfigChange;
	}

	/**
	 * Returns the defaulted ee information 
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
	 * @return ConfigureDMEECustomDTO
	 */
	public ConfigureDMEECustomDTO getDefaultedEE() {
		return defaultedEE;
	}

	/**
	 * Sets defaulted ee information 
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
	 * @param newDefaultedEE ConfigureDMEECustomDTO
	 */
	public void setDefaultedEE(ConfigureDMEECustomDTO newDefaultedEE) {
		defaultedEE = newDefaultedEE;
	}
	
	/**
	 * addswo
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swo
	 */
	
	public void addSwo(ConfigureDMSWOCustomDTO swo){
		if(null != swo){
			if(null == swos){
				swos = new ArrayList();
			}
			swos.add(swo);
		}
	}

	/**
	 * Returns s and s flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isSAndS() {
		return sAndS;
	}

	/**
	 * Sets s & s flag value
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSAndS boolean
	 */
	public void setSAndS(boolean newSAndS) {
		sAndS = newSAndS;
	}
	
	/**
	 * Return select copy flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isSelectCopy() {
		return selectCopy;
	}

	/** 
	 * Sets config change value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectCopy
	 * 
	 */
	public void setSelectCopy(boolean newSelectCopy) {
		selectCopy = newSelectCopy;
	}


	/**
	 * Return vm change flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Jan 22, 2004 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @return boolean
		 */
	public boolean isVmChanged() {
		return vmChanged;
	}

	/** 
	 * Sets VM config change value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newVmChanged boolean
	 */
	public void setVmChanged(boolean newVmChanged) {
		vmChanged = newVmChanged;
	}

	/**
	 * is license type chaged
	 * @return boolean
	 */
	public boolean isLicenseTypeChaged() {
		return licenseTypeChaged;
	}

	/**
	 * set the is license type chaged
	 * 
	 * @param b
	 */
	public void setLicenseTypeChaged(boolean b) {
		licenseTypeChaged = b;
	}

	/**
	 * is cho changed
	 * 
	 * @return
	 */
	public boolean isChoChanged() {
		return choChanged;
	}

	/**
	 * set cho changed
	 * 
	 * @param b
	 */
	public void setChoChanged(boolean b) {
		choChanged = b;
	}

	/**
	 * is use level changed
	 * 
	 * @return boolean
	 */
	public boolean isUseLevelChanged() {
		return useLevelChanged;
	}

	/**
	 * set use level changed
	 * 
	 * @param b
	 */
	public void setUseLevelChanged(boolean b) {
		useLevelChanged = b;
	}

	/**
	 * Returns flag value to diplay the default values fileds or not
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isDisplayDefaultValues() {
		return displayDefaultValues;
	}

	/**
	 * Sets the flag value for displaying the default values fields  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDisplayDefaultValues boolean
	 */
	
	public void setDisplayDefaultValues(boolean newDisplayDefaultValues) {
		displayDefaultValues = newDisplayDefaultValues;
	}
}
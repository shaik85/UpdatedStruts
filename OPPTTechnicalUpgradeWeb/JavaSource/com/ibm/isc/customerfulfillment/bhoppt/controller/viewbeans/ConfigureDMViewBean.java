/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;

import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ConfigureDMActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.DateDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMSWOCustomDTO;

/**
 * Hold complete information required for Configure DM View.  
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
public class ConfigureDMViewBean extends DMCopyBumpViewBean
{
	private Date bumpPlanStartDate = null;
	private Date bumpPlanEndDate = null;

	private List swoViewBeans = null;
	
	private TreeMap valueMetricDescriptions = null;
	private TreeMap licenseTypes = null;
	private TreeMap chargeOptions = null;
	private TreeMap useLevels = null;
	
	private String selectedValueMetricDescription = null;
	private String selectedLicenseType = null;
	private String selectedChargeOption = null;
	private String selectedUseLevel = null;
	
	private boolean displayDefaultValues = true;
	private boolean defaultValuesAllText = true;
	private boolean useLevelText = true;
	private boolean valueMetricDescriptionText = true;
	private boolean chargeOptionText = true;
	private boolean licenseTypeText = true;
	
	/**
	 * Returns the bump plan end date 
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
	public Date getBumpPlanEndDate() {
		return bumpPlanEndDate;
	}

	/**
	 * Returns the bump plan start date 
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
	public Date getBumpPlanStartDate() {
		return bumpPlanStartDate;
	}

	/**
	 * Returns the charge options available 
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
	public TreeMap getChargeOptions() {
		return chargeOptions;
	}

	/**
	 * Returns the license types available for the dm 
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
	public TreeMap getLicenseTypes() {
		return licenseTypes;
	}

	/**
	 * Returns the collection of ConfigureDMSWOViewBeans's associated with the dm. 
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
	 * @return List
	 */
	public List getSwoViewBeans() {
		return swoViewBeans;
	}

	/**
	 * Returns the collection of use leveles associated with the dm. 
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
	public TreeMap getUseLevels() {
		return useLevels;
	}

	/**
	 * Returns the collection of value metric descriptions associated with the dm. 
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
	public TreeMap getValueMetricDescriptions() {
		return valueMetricDescriptions;
	}

	/**
	 * Sets the bump plan end date. 
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
	 * @param newBumpPlanEndDate Date
	 */
	public void setBumpPlanEndDate(Date newBumpPlanEndDate) {
		bumpPlanEndDate = newBumpPlanEndDate;
	}

	/**
	 * Sets the bump plan start date
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
	 * @param newBumpPlanStartDate Date 
	 */
	public void setBumpPlanStartDate(Date newBumpPlanStartDate) {
		bumpPlanStartDate = newBumpPlanStartDate;
	}

	/**
	 * Sets the collection as charge options available for the dm. 
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
	 * @param newChargeOptions TreeMap 
	 */
	public void setChargeOptions(TreeMap newChargeOptions) {
		chargeOptions = newChargeOptions;
	}

	/**
	 * Sets the collection as license types available for the dm. 
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
	 * @param newLicenseTypes TreeMap 
	 */
	public void setLicenseTypes(TreeMap newLicenseTypes) {
		licenseTypes = newLicenseTypes;
	}

	/**
	 * Sets the collection as collection of swos associated with the dm. 
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
	 * @param newSwoViewBeans List 
	 */
	public void setSwoViewBeans(List newSwoViewBeans) {
		swoViewBeans = newSwoViewBeans;
	}

	/**
	 * Sets the collection as use levels associated with the dm. 
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
	 * @param newUseLevels TreeMap 
	 */
	public void setUseLevels(TreeMap newUseLevels) {
		useLevels = newUseLevels;
	}

	/**
	 * Sets the collection as value metric descriptions available for the dm. 
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
	 * @param newValueMetricDescriptions TreeMap 
	 */
	public void setValueMetricDescriptions(TreeMap newValueMetricDescriptions) {
		valueMetricDescriptions = newValueMetricDescriptions;
	}
	
	/**
	 * Adds the ConfigureDMSWOViewBean to already existing collection of swo's. If none exists 
	 * it creates a new collection and adds this swo.  
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
	 * @param swoViewBean ConfigureDMSWOViewBean
	 */
	public void addSWOViewBean(ConfigureDMSWOViewBean swoViewBean) {
		if(null != swoViewBean) {
			if(null == swoViewBeans) {
				swoViewBeans = new ArrayList();
			}
			swoViewBeans.add(swoViewBean);
		}
	}
	
	/**
     * Adds new value metric description to the already existing collection of value metric
     * description available. If none exists it creates a new collection and adds.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 17, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param valueMetricDescription String
     * @param key 
     */
	public void addValueMetricDescription(String key, String valueMetricDescription) {
		if(null != key) {
			if(null == valueMetricDescriptions){
				valueMetricDescriptions = new TreeMap();
			}
			valueMetricDescriptions.put(key, valueMetricDescription);
		}
	}
	
	/**
     * Adds new licenseType to alreay existing collection of license types available. It no collection
     * available, it creates a new collection and adds this licenseType to that collection.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 17, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param licenseType String
     * @param key 
     */
	public void addLicenseType(String key, String licenseType){ 
		if(null != key){
			if(null == licenseTypes) {
				licenseTypes = new TreeMap();
			}
			licenseTypes.put(key, licenseType);
		}
	}
	
	/**
     * Adds new chargeOption to alreay existing collection of charge options available. It no collection
     * available, it creates a new collection and adds this charge option to that collection.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 17, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param chargeOption String
     * @param key 
     */
	public void addChargeOption(String key, String chargeOption){
		if(null != key) {
			if(null == chargeOptions){
				chargeOptions = new TreeMap();
			}
			chargeOptions.put(key, chargeOption);
		}
	}
	
	/**
     * Adds new use level to alreay existing collection of use levels available. It no collection
     * available, it creates a new collection and adds this uselevel to that collection.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 17, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param useLevel
     * @param key 
     */
	public void addUseLevel(String key, String useLevel){
		if(null != key){
			if(null == useLevels){
				useLevels = new TreeMap();
			}
			useLevels.put(key, useLevel);
		}
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
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(ConfigureDMCustomDTO customDTO){
		if(null != customDTO){	
			setButtonFlags(customDTO.getButtonFlags());
			setDMNumber(customDTO.getNumber());
			setDMDescription(customDTO.getDescription());
			setPlanStartDate(customDTO.getPlanStartDate());
			setPlanEndDate(customDTO.getPlanEndDate());

			setStartYears(customDTO.getStartYears());
			setEndYears(customDTO.getEndYears());
			
			setBumpPlanStartDate(customDTO.getBumpPlanStartDate());
			setBumpPlanEndDate(customDTO.getBumpPlanEndDate());

			setDisplayDefaultValues(customDTO.isDisplayDefaultValues());

			Map collection = customDTO.getValueMetricDescription();
			if(null != collection){
				Iterator iterator = collection.keySet().iterator();
				while(iterator.hasNext()){
					String key = (String)iterator.next();
					addValueMetricDescription(key, (String)collection.get(key));
				}

				defaultValuesAllText = false;
				valueMetricDescriptionText = false;
			}

			collection = customDTO.getLicenseType();
			if(null != collection){
				Iterator iterator = collection.keySet().iterator();
				while(iterator.hasNext()){
					String key = (String)iterator.next();
					addLicenseType(key, (String)collection.get(key));
				}

				defaultValuesAllText = false;
				licenseTypeText = false;
			}

			collection = customDTO.getChargeOption();
			if(null != collection){
				Iterator iterator = collection.keySet().iterator();
				while(iterator.hasNext()){
					String key = (String)iterator.next();
					addChargeOption(key, (String)collection.get(key));
				}

				defaultValuesAllText = false;
				chargeOptionText = false;
			}

			collection = customDTO.getUseLevel();
			if(null != collection){
				Iterator iterator = collection.keySet().iterator();
				while(iterator.hasNext()){
					String key = (String)iterator.next();
					addUseLevel(key, (String)collection.get(key));
				}

				defaultValuesAllText = false;
				useLevelText = false;
			}

			setSelectedValueMetricDescription(customDTO.getSelectedValueMetricDescription());
			setSelectedLicenseType(customDTO.getSelectedLicenseType());
			setSelectedChargeOption(customDTO.getSelectedChargeOption());
			setSelectedUseLevel(customDTO.getSelectedUseLevel());	

			List swoCollection = customDTO.getSwos();
			if(null != swoCollection){
				for(int i=0, size=swoCollection.size(); i<size; i++){
					addSWOViewBean(new ConfigureDMSWOViewBean((ConfigureDMSWOCustomDTO)swoCollection.get(i)));						
				}
			}
		}
	}
	
	/**
     * ConfigureDMViewBean
     * 
     * @author thirumalai
     */
    public ConfigureDMViewBean(){
	}
	/**
     * ConfigureDMViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public ConfigureDMViewBean(ConfigureDMCustomDTO customDTO){
		setData(customDTO);
	}
	/**
     * ConfigureDMViewBean
     * 
     * @param customDTO
     * @param bumpPlanStartDate
     * @author thirumalai
     */
    public ConfigureDMViewBean(ConfigureDMCustomDTO customDTO, Date bumpPlanStartDate){
		setData(customDTO);
		setBumpPlanStartDate(bumpPlanStartDate);
	}

	/**
     * getConfigureDMActionForm
     * 
     * @return
     * @author thirumalai
     */
    public ConfigureDMActionForm getConfigureDMActionForm() {
		ConfigureDMActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof ConfigureDMActionForm){
			actionForm = (ConfigureDMActionForm)getActionForm();
		}
		else{
			actionForm = new ConfigureDMActionForm();
			actionForm.setBumpPlanStartDate(new DateDataBean(getBumpPlanStartDate()));
			actionForm.setBumpPlanEndDate(new DateDataBean(getPlanEndDate()));
			actionForm.setValueMetricDescription(getSelectedValueMetricDescription());
			actionForm.setLicenseType(getSelectedLicenseType());
			actionForm.setChargeOption(getSelectedChargeOption());
			actionForm.setUseLevel(getSelectedUseLevel());
		}
		return actionForm;
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
	 * Returns flag value for displaying charge option field as text field 
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
	public boolean isChargeOptionText() {
		return chargeOptionText;
	}

	/**
	 * Returns flag value for displaying all the default values field values as text fields. 
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
	public boolean isDefaultValuesAllText() {
		return defaultValuesAllText;
	}

	/** 
	 * Returns flag value for displaying license type field as text field 
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
	public boolean isLicenseTypeText() {
		return licenseTypeText;
	}

	/** 
	 * Returns flag value for displaying use level field as text field 
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
	public boolean isUseLevelText() {
		return useLevelText;
	}

	/** 
	 * Returns flag value for displaying value metrix description field as text field 
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
	public boolean isValueMetricDescriptionText() {
		return valueMetricDescriptionText;
	}

	/** 
	 * Sets flag value for displaying charge option field as text field 
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
	 * @param newChargeOptionText boolean 
	 */
	public void setChargeOptionText(boolean newChargeOptionText) {
		chargeOptionText = newChargeOptionText;
	}

	/** 
	 * Sets flag value for displaying charge option field as text field 
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
	 * @param newDefaultValuesAllText boolean 
	 */
	public void setDefaultValuesAllText(boolean newDefaultValuesAllText) {
		defaultValuesAllText = newDefaultValuesAllText;
	}

	/** 
	 * Sets flag value for displaying charge option field as text field 
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
	 * @param newLicenseTypeText boolean 
	 */
	public void setLicenseTypeText(boolean newLicenseTypeText) {
		licenseTypeText = newLicenseTypeText;
	}

	/** 
	 * Sets flag value for displaying charge option field as text field 
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
	 * @param newUseLevelText boolean 
	 */
	public void setUseLevelText(boolean newUseLevelText) {
		useLevelText = newUseLevelText;
	}

	/** 
	 * Sets flag value for displaying charge option field as text field 
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
	 * @param newValueMetricDescriptionText boolean 
	 */
	public void setValueMetricDescriptionText(boolean newValueMetricDescriptionText) {
		valueMetricDescriptionText = newValueMetricDescriptionText;
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
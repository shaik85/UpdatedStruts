/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.DateDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;


/**
 * Action form for configure dm view  
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


public class ConfigureDMActionForm extends OPPTActionForm {
	
	private DateDataBean originalPlanEndDate = null;
	private DateDataBean bumpPlanStartDate = null;
	private DateDataBean bumpPlanEndDate = null;
	
	private String valueMetricDescription = null;
	private String licenseType = null;
	private String chargeOption = null;
	private String useLevel = null;
	
	private String[] selectedIds = null;

	/**
	 * Returns bump plan end date 
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
	 * @return DateDataBean
	 */
	public DateDataBean getBumpPlanEndDate() {
		if(null == bumpPlanEndDate){
			bumpPlanEndDate = new DateDataBean();
		}
		return bumpPlanEndDate;
	}

	/**
	 * Returns bump plan start date 
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
	 * @return DateDataBean
	 */
	public DateDataBean getBumpPlanStartDate() {
		if(null == bumpPlanStartDate){
			bumpPlanStartDate = new DateDataBean();
		}
		return bumpPlanStartDate;
	}

	/**
	 * Returns the charge option 
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
	public String getChargeOption() {
		return chargeOption;
	}

	/**
	 * Returns the license type 
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
	public String getLicenseType() {
		return licenseType;
	}

	/**
	 * Returns the original plan end date 
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
	 * @return DateDataBean
	 */
	public DateDataBean getOriginalPlanEndDate() {
		if(null == originalPlanEndDate){
			originalPlanEndDate = new DateDataBean();
		}
		return originalPlanEndDate;
	}

	/**
	 * Returns collection of selected ids 
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
	 * @return String[]
	 */
	public String[] getSelectedIds() {
		return selectedIds;
	}

	/**
	 * Returns use level value 
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
	public String getUseLevel() {
		return useLevel;
	}

	/**
	 * Returns value metric description 
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
	public String getValueMetricDescription() {
		return valueMetricDescription;
	}

	/**
	 * Sets bump plan end date 
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
	 * @param newBumpPlanEndDate DateDataBean 
	 */
	public void setBumpPlanEndDate(DateDataBean newBumpPlanEndDate) {
		bumpPlanEndDate = newBumpPlanEndDate;
	}

	/**
	 * Sets bump plan start date 
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
	 * @param newBumpPlanStartDate DateDataBean 
	 */
	public void setBumpPlanStartDate(DateDataBean newBumpPlanStartDate) {
		bumpPlanStartDate = newBumpPlanStartDate;
	}

	/**
	 * Sets charge option 
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
	 * @param newChargeOption String 
	 */
	public void setChargeOption(String newChargeOption) {
		chargeOption = newChargeOption;
	}

	/**
	 * Sets license type 
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
	 * @param newLicenseType String 
	 */
	public void setLicenseType(String newLicenseType) {
		licenseType = newLicenseType;
	}

	/**
	 * Sets original plan end date 
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
	 * @param newOriginalPlanEndDate DateDataBean 
	 */
	public void setOriginalPlanEndDate(DateDataBean newOriginalPlanEndDate) {
		originalPlanEndDate = newOriginalPlanEndDate;
	}

	/**
	 * Sets selected ids collection 
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
	 * @param newSelectedIds String[] 
	 */
	public void setSelectedIds(String[] newSelectedIds) {
		selectedIds = newSelectedIds;
	}

	/**
	 * Sets use level 
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
	 * @param newUseLevel String 
	 */
	public void setUseLevel(String newUseLevel) {
		useLevel = newUseLevel;
	}

	/**
	 * Sets value metric description 
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
	 * @param newValueMetricDescription String 
	 */
	public void setValueMetricDescription(String newValueMetricDescription) {
		valueMetricDescription = newValueMetricDescription;
	}

	/**
	 * @param customDTO
	 * @return
	 */
	public ConfigureDMCustomDTO getInputValues(ConfigureDMCustomDTO customDTO){
		if(null != customDTO){
			if(!isSelectEmpty(valueMetricDescription)){
				customDTO.setSelectedValueMetricDescription(valueMetricDescription);
			}
			if(!isSelectEmpty(licenseType)){
				customDTO.setSelectedLicenseType(licenseType);
			}
			if(!isSelectEmpty(chargeOption)){
				customDTO.setSelectedChargeOption(chargeOption);
			}
			if(!isSelectEmpty(useLevel)){
				customDTO.setSelectedUseLevel(useLevel);
			}
			
			customDTO.setBumpPlanStartDate(getBumpPlanStartDate().getDate());
			customDTO.setBumpPlanEndDate(getBumpPlanEndDate().getDate());
			customDTO.setPlanEndDate(getOriginalPlanEndDate().getDate());
		}
		return customDTO;
	}
	
	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset(){
		originalPlanEndDate = null;
		bumpPlanStartDate = null;
		bumpPlanEndDate = null;
	
		valueMetricDescription = null;
		licenseType = null;
		chargeOption = null;
		useLevel = null;
	
		selectedIds = null;
	}
	
	/**
	 * @return
	 */
	public ErrorReport validateInputForPrice(){
		ErrorReport errorReport = new ErrorReport();
		
		if(isDateEmpty(getBumpPlanStartDate())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF101, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if(isDateEmpty(getBumpPlanEndDate())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF102, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		return errorReport;
	}
}
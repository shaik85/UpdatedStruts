/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Date;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.DMCopyBumpActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.DateDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DMCustomDTO;

/**
 * Hold complete information about dm copy bump view.
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
public class DMCopyBumpViewBean extends OPPTViewBean {
	private String iDMNumber = null;
	private String iDMDescription = null;
	private Date iPlanStartDate = null;
	private Date iPlanEndDate = null;
	private List iStartYears = null;
	private List iEndYears = null;

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
		return iEndYears;
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
		return iStartYears;
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
	 * @param newEndYears List 
	 */
	public void setEndYears(List newEndYears) {
		iEndYears = newEndYears;
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
	 * @param newStartYears List 
	 */
	public void setStartYears(List newStartYears) {
		iStartYears = newStartYears;
	}

	/**
	 * Returns dm description 
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
	public String getDMDescription() {
		return iDMDescription;
	}

	/**
	 * Returns dm number 
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
	public String getDMNumber() {
		return iDMNumber;
	}

	/**
	 * Returns plan end date 
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
	public Date getPlanEndDate() {
		return iPlanEndDate;
	}

	/**
	 * Returns plan start date 
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
	public Date getPlanStartDate() {
		return iPlanStartDate;
	}

	/**
	 * Sets dm description 
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
	 * @param newDMDescription String 
	 */
	public void setDMDescription(String newDMDescription) {
		iDMDescription = newDMDescription;
	}

	/**
	 * Sets dm number 
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
	 * @param newDMNumber String 
	 */
	public void setDMNumber(String newDMNumber) {
		iDMNumber = newDMNumber;
	}

	/**
	 * Sets plan end date 
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
	 * @param newPlanEndDate Date 
	 */
	public void setPlanEndDate(Date newPlanEndDate) {
		iPlanEndDate = newPlanEndDate;
	}

	/**
	 * Sets plan start date 
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
	 * @param newPlanStartDate Date 
	 */
	public void setPlanStartDate(Date newPlanStartDate) {
		iPlanStartDate = newPlanStartDate;
	}

	/**
	 * Sets complete data in a single method call  
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
	 * @param dmNumber
	 * @param dmDescription
	 * @param planStartDate
	 * @param planEndDate
	 */
	public void setData(String dmNumber, String dmDescription, Date planStartDate, Date planEndDate){
		setDMNumber(dmNumber);
		setDMDescription(dmDescription);
		setPlanStartDate(planStartDate);
		setPlanEndDate(planEndDate);
	}
	
	/**
     * @param customDTO
     * @author thirumalai
     */
    public void setData(CopyBumpDMCustomDTO customDTO){
		if(null != customDTO){
			DMCustomDTO dm = customDTO.getDmDTO();
			if(null != dm){
				setDMNumber(dm.getNumber());
				setDMDescription(dm.getDescription());
				setPlanStartDate(dm.getPlanStartDate());
				setPlanEndDate(dm.getPlanEndDate());
			}
			setStartYears(customDTO.getStartYears());
			setEndYears(customDTO.getEndYears());
			
			DMCopyBumpActionForm actionForm = new DMCopyBumpActionForm();
			actionForm.setBumpPlanEndDate(new DateDataBean(getPlanEndDate()));
			actionForm.setOriginalPlanEndDate(new DateDataBean(getPlanEndDate()));
			setActionForm(actionForm);
		}
	}
	
	/**
     * DMCopyBumpViewBean
     * 
     * @author thirumalai
     */
    public DMCopyBumpViewBean(){
	}

	/**
     * DMCopyBumpViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public DMCopyBumpViewBean(CopyBumpDMCustomDTO customDTO){
		setData(customDTO);
	}

	/**
     * getCopyBumpDMActionForm
     * 
     * @return
     * @author thirumalai
     */
    public DMCopyBumpActionForm getCopyBumpDMActionForm(){
		DMCopyBumpActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof DMCopyBumpActionForm){
			actionForm = (DMCopyBumpActionForm)getActionForm();
		}
		else{
			actionForm = new DMCopyBumpActionForm();
		}
		return actionForm;
	}
	
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param newActionForm 
	 * 
	 */
	public void setActionForm(OPPTActionForm newActionForm) {
		super.setActionForm(newActionForm);
		
		DMCopyBumpActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof DMCopyBumpActionForm){
			actionForm = (DMCopyBumpActionForm)getActionForm();
			
			Date originalDate = actionForm.getOriginalPlanEndDate().getDate();
			if(null != originalDate){
				setPlanEndDate(originalDate);
			}
		}
	}
}
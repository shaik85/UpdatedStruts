/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditDMCustomDTO;

/**
 * Holds complete date required for edit dm view.  
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
public class EditDMViewBean extends OPPTViewBean {
	private String iDMDescription = null;
	private String iDMNumber = null;
	private Date iPlanEndDate = null;
	private Date iPlanStartDate = null;
	
	private Date iSelectedPlanEndDate = null;
	private Date iSelectedPlanStartDate = null;

	/**
	 * Returns description about the DM. 
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
	public String getDMDescription() {
		return iDMDescription;
	}


	/**
	 * Returns dm number 
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
	public String getDMNumber() {
		return iDMNumber;
	}


	/**
	 * Returns plan end date 
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
	public Date getPlanEndDate() {
		return iPlanEndDate;
	}


	/**
	 * Returns plan start date 
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
	 * @return 
	 */
	public Date getPlanStartDate() {
		return iPlanStartDate;
	}


	/**
	 * Sets the description about the dm. 
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
	 * @param newDMDescription String 
	 */
	public void setDMDescription(String newDMDescription) {
		iDMDescription = newDMDescription;
	}


	/**
	 * sets the dm number
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
	 * @param newDMNumber String 
	 */
	public void setDMNumber(String newDMNumber) {
		iDMNumber = newDMNumber;
	}


	/**
	 * Sets the plan end date for the dm. 
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
	 * @param newPlanEndDate Date 
	 */
	public void setPlanEndDate(Date newPlanEndDate) {
		iPlanEndDate = newPlanEndDate;
	}


	/**
	 * Sets the plan start date for the dm. 
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
	 * @param newPlanStartDate Date 
	 */
	public void setPlanStartDate(Date newPlanStartDate) {
		iPlanStartDate = newPlanStartDate;
	}

	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(EditDMCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			
			DMCustomDTO selectedDM = customDTO.getSelectedDM();
			if(null != selectedDM){
				setDMDescription(selectedDM.getDescription());
				setDMNumber(selectedDM.getNumber());
				setPlanStartDate(selectedDM.getPlanStartDate());
				setPlanEndDate(selectedDM.getPlanEndDate());
			}
			setSelectedPlanEndDate(customDTO.getEditPlanEndDate());
			setSelectedPlanStartDate(customDTO.getEditPlanStartDate());
		}
	}
	
	/**
     * EditDMViewBean
     * 
     * @author thirumalai
     */
    public EditDMViewBean(){
	}
	
	/**
     * EditDMViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public EditDMViewBean(EditDMCustomDTO customDTO){
		setData(customDTO);
	}

	/**
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public Date getSelectedPlanEndDate() {
		return iSelectedPlanEndDate;
	}

	/**
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public Date getSelectedPlanStartDate() {
		return iSelectedPlanStartDate;
	}

	/**
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedPlanEndDate
	 */
	public void setSelectedPlanEndDate(Date newSelectedPlanEndDate) {
		iSelectedPlanEndDate = newSelectedPlanEndDate;
	}

	/**
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedPlanStartDate
	 */
	public void setSelectedPlanStartDate(Date newSelectedPlanStartDate) {
		iSelectedPlanStartDate = newSelectedPlanStartDate;
	}
}
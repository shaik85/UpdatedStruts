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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SWOCopyBumpActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.DateDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWOCustomDTO;

/**
 * Holds complete data required for swo copy bump view.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class SWOCopyBumpViewBean extends OPPTViewBean{
	private String iSwoNumber = null;
	private String iSwoSerialNumber = null;
	private String iSwoDescription = null;
	private double iAlternatePrice = 0;
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
	 * Return original plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
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
	 * Return original plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
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
	 * Return source alternate price 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double
	 */
	public double getAlternatePrice() {
		return iAlternatePrice;
	}

	/**
	 * Return swo discription 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSwoDescription() {
		return iSwoDescription;
	}

	/**
	 * Returns swo number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSwoNumber() {
		return iSwoNumber;
	}

	/**
	 * Returns swo serial number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSwoSerialNumber() {
		return iSwoSerialNumber;
	}

	/**
	 * Sets original plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
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
	 * Sets original plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanStartDate Date 
	 */
	public void setPlanStartDate(Date newPlanStartDate){
		iPlanStartDate = newPlanStartDate;
	}

	/**
	 * Sets source alternate price 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAlternatePrice double 
	 */
	public void setAlternatePrice(double newAlternatePrice) {
		iAlternatePrice = newAlternatePrice;
	}

	/**
	 * Sets swo description 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwoDescription String 
	 */
	public void setSwoDescription(String newSwoDescription) {
		iSwoDescription = newSwoDescription;
	}

	/**
	 * Sets swo number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwoNumber String 
	 */
	public void setSwoNumber(String newSwoNumber) {
		iSwoNumber = newSwoNumber;
	}

	/**
	 * Sets swo serail number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwoSerialNumber String 
	 */
	public void setSwoSerialNumber(String newSwoSerialNumber) {
		iSwoSerialNumber = newSwoSerialNumber;
	}

	/**
     * Sets complete data in a single method call
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param swoNumber
     * @param swoSerialNumber
     * @param swoDescription
     * @param sourceAlternatePrice
     * @param originalPlanStartDate
     * @param originalPlanEndDate
     * @param bumpPlanEndDate
     * @param bumpPlanStartDate
     * @param targetAlternatePrice 
     */
	public void setData(String swoNumber, String swoSerialNumber, String swoDescription, 
						double sourceAlternatePrice, double targetAlternatePrice, 
						Date originalPlanStartDate, Date originalPlanEndDate, 
						Date bumpPlanStartDate, Date bumpPlanEndDate){
		setSwoNumber(swoNumber);
		setSwoSerialNumber(swoSerialNumber);
		setSwoDescription(swoDescription);
		setAlternatePrice(sourceAlternatePrice);
		setPlanStartDate(originalPlanStartDate);
		setPlanEndDate(originalPlanEndDate);
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(CopyBumpSWOCustomDTO customDTO){
		if(null != customDTO){
			SWOCustomDTO swo = customDTO.getSwoDTO();
			if(null != swo){
				setSwoNumber(swo.getNumber());
				setSwoSerialNumber(swo.getSerialNumber());
				setSwoDescription(swo.getDescription());
				setAlternatePrice(swo.getAlternatePrice());
				setPlanStartDate(swo.getPlanStartDate());
				setPlanEndDate(swo.getPlanEndDate());
			}
			setStartYears(customDTO.getStartYears());
			setEndYears(customDTO.getEndYears());
			
			SWOCopyBumpActionForm actionForm = new SWOCopyBumpActionForm();
			actionForm.setOriginalPlanEndDate(new DateDataBean(getPlanEndDate()));
			actionForm.setBumpPlanEndDate(new DateDataBean(getPlanEndDate()));
			actionForm.setSourceAlternatePrice(getAlternatePrice());
			setActionForm(actionForm);
		}
	}
	
	/**
     * SWOCopyBumpViewBean
     * 
     * @author thirumalai
     */
    public SWOCopyBumpViewBean(){
	}
	/**
     * SWOCopyBumpViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public SWOCopyBumpViewBean(CopyBumpSWOCustomDTO customDTO){
		setData(customDTO);
	}

	/**
     * getCopyBumpSWOActionForm
     * 
     * @return
     * @author thirumalai
     */
    public SWOCopyBumpActionForm getCopyBumpSWOActionForm(){
		SWOCopyBumpActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof SWOCopyBumpActionForm){
			actionForm = (SWOCopyBumpActionForm)getActionForm();
		}
		else{
			actionForm = new SWOCopyBumpActionForm();
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
		
		SWOCopyBumpActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof SWOCopyBumpActionForm){
			actionForm = (SWOCopyBumpActionForm)getActionForm();
			
			Date originalDate = actionForm.getOriginalPlanEndDate().getDate();
			if(null != originalDate){
				setPlanEndDate(originalDate);
			}
			setAlternatePrice(actionForm.getSourceAlternatePrice());
		}
	}
}
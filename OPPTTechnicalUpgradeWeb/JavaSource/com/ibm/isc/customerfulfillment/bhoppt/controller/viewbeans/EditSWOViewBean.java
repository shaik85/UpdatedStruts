/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWOCustomDTO;

/**
 * Hold data for edit swo view.  
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
public class EditSWOViewBean extends OPPTViewBean 
{
	private String iSwoNumber = null;
	private String iSerialNumber = null;
	private String iDescription = null;
	
	private double iAlternatePrice = 0;

	private Date iPlanEndDate = null;
	private Date iPlanStartDate = null;

	private Date iSelectedPlanEndDate = null;
	private Date iSelectedPlanStartDate = null;

	/**
	 * Returns alternati price for swo 
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
	 * @return double
	 */
	public double getAlternatePrice() {
		return iAlternatePrice;
	}


	/**
	 * Returns description 
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
	public String getDescription() {
		return iDescription;
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
	 * Returns the serial number 
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
		return iSerialNumber;
	}

	/**
	 * Returns the swo number 
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
	public String getSwoNumber() {
		return iSwoNumber;
	}

	/**
	 * Sets the alternate price for the license 
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
	 * @param newAlternatePrice double 
	 */
	public void setAlternatePrice(double newAlternatePrice) {
		iAlternatePrice = newAlternatePrice;
	}


	/**
	 * Sets the description of the license 
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
	 * @param newDescription String 
	 */
	public void setDescription(String newDescription) {
		iDescription = newDescription;
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
	 * Sets the serial number 
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
		iSerialNumber = newSerialNumber;
	}

	/**
	 * Sets the swo number 
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
	 * @param newSwoNumber String 
	 */
	public void setSwoNumber(String newSwoNumber) {
		iSwoNumber = newSwoNumber;
	}

	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(EditSWOCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());

			SWOCustomDTO swo = customDTO.getSelectedSWO();
			if(null != swo){
				setSwoNumber(swo.getNumber());
				setSerialNumber(swo.getSerialNumber());
				setDescription(swo.getDescription());
				setAlternatePrice(swo.getAlternatePrice());
				setPlanEndDate(swo.getPlanEndDate());
				setPlanStartDate(swo.getPlanStartDate());
			}
			setSelectedPlanEndDate(customDTO.getEditPlanEndDate());
			setSelectedPlanStartDate(customDTO.getEditPlanStartDate());
		}
	}
	
	/**
     * EditSWOViewBean
     * 
     * @author thirumalai
     */
    public EditSWOViewBean(){
	}
	
	/**
     * EditSWOViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public EditSWOViewBean(EditSWOCustomDTO customDTO){
		setData(customDTO);
	}
	
	/**
     * getSWONumberSerialNumber
     * 
     * @return
     * @author thirumalai
     */
    public String getSWONumberSerialNumber(){
		String value = "";  //$NON-NLS-1$
		
		if(null == getSwoNumber()){
			if(null != getSerialNumber()){
				value = getSerialNumber();
			}
		}
		else{
			value = getSwoNumber();
			if(null != getSerialNumber()){
				value += "/"+getSerialNumber();  //$NON-NLS-1$
			}
		}
		
		return value;
	}

	/**
	 * <p>Returns a string equivalent of alternate price based on its value. If alternate 
	 * price value is less than 0, returns an empty string value else returns equivalent 
	 * string value.</p>
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 28, 2004 
	 * 
	 * revision date author reason
	 * 28/05/2004 	 Vinod 	Added as part of MN19387428 for checking if alternate price returned 
	 * 						from service layer is -1 and if so, return empty value else return 
	 * 						equivalent string value.
	 * 
	 * </PRE><br> 
	 * 
	 * @return String String equivalent value of alternate price value.
	 */
	public String getAlternatePriceValue(){
		String value = "";  //$NON-NLS-1$
		if(0 <= iAlternatePrice){
			value = String.valueOf(iAlternatePrice);
		}
		return value;
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
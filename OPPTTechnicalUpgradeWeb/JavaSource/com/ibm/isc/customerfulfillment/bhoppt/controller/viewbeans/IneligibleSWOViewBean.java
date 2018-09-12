/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Date;
import java.util.ArrayList;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleEECustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleSWOCustomDTO;

/**
 * Holds information about an ineligible license that is used in ineligible licenses view.  
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
public class IneligibleSWOViewBean extends OPPTViewBean {
	private String iSapSTPNumber = null;
	private String iSwoNumber = null;
	private String iSwoSerialNumber = null;
	private String iDMNumber = null;
	private Date iLicenseEffectiveDate = null;
	private String iComment = null;
	private String iId = null;
	private ArrayList iIneligibleEEs = null;
	private boolean licensePulled = false;
	private boolean selected = false;
	
	/**
	 * Returns comment about the ineligible license  
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
	public String getComment() {
		return iComment;
	}

	/**
	 * Returns the dm number to which this license belongs 
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
	 * Returns the unique identifier for the license 
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
	public String getId() {
		return iId;
	}

	/**
	 * Returns the ineligible ee's for the licese 
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
	 * @return ArrayList
	 */
	public ArrayList getIneligibleEEs() {
		return iIneligibleEEs;
	}

	/**
	 * Returns license effective date 
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
	public Date getLicenseEffectiveDate() {
		return iLicenseEffectiveDate;
	}

	/**
	 * Returns sap stp number 
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
	public String getSapSTPNumber() {
		return iSapSTPNumber;
	}

	/**
	 * Returns swo number 
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
	public String getSwoNumber() {
		return iSwoNumber;
	}

	/**
	 * Returns swo serial number 
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
	public String getSwoSerialNumber() {
		return iSwoSerialNumber;
	}

	/**
	 * Sets comments  
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
	 * @param newComment String 
	 */
	public void setComment(String newComment) {
		iComment = newComment;
	}

	/**
     * Sets dm number
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 19, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newDMNumber 
     */
	public void setDmNumber(String newDMNumber) {
		iDMNumber = newDMNumber;
	}

	/**
	 * Sets license id 
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
	 * @param newId String 
	 */
	public void setId(String newId) {
		iId = newId;
	}

	/**
	 * Sets ineligible ees 
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
	 * @param newIneligibleEEs ArrayList 
	 */
	public void setIneligibleEEs(ArrayList newIneligibleEEs) {
		iIneligibleEEs = newIneligibleEEs;
	}

	/**
	 * Sets license effective date 
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
	 * @param newLicenseEffectiveDate Date 
	 */
	public void setLicenseEffectiveDate(Date newLicenseEffectiveDate) {
		iLicenseEffectiveDate = newLicenseEffectiveDate;
	}

	/**
	 * Sets sap stp number 
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
	 * @param newSapSTPNumber String 
	 */
	public void setSapSTPNumber(String newSapSTPNumber) {
		iSapSTPNumber = newSapSTPNumber;
	}

	/**
	 * Sets swo number 
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
	 * @param newSwoNumber String 
	 */
	public void setSwoNumber(String newSwoNumber) {
		iSwoNumber = newSwoNumber;
	}

	/**
	 * Sets swo serial number 
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
	 * @param newSwoSerialNumber String 
	 */
	public void setSwoSerialNumber(String newSwoSerialNumber) {
		iSwoSerialNumber = newSwoSerialNumber;
	}

	/**
	 * Adds ineligible ee to the already existing collection.  
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
	 * @param ineligibleEE IneligibleEEViewBean
	 */
	public void addIneligibleEE(IneligibleEEViewBean ineligibleEE){
		if(null != ineligibleEE){
			if(null == iIneligibleEEs){
				iIneligibleEEs = new ArrayList();
			}
			iIneligibleEEs.add(ineligibleEE);
		}
	}
	/**
	 * Sets complete data in a single method call.  
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
	 * @param id String
	 * @param swoNumber String
	 * @param swoSerialNumber String
	 * @param dmNumber String
	 * @param sapSTPNumber String
	 * @param licenseEffectiveDate Date
	 * @param comment String
	 * @param ineligibleEEs ArrayList
	 */
	public void setData(String id, String swoNumber, String swoSerialNumber, String dmNumber,
						String sapSTPNumber, Date licenseEffectiveDate, String comment, 
						ArrayList ineligibleEEs){
		setId(id);
		setSwoNumber(swoNumber);
		setSwoSerialNumber(swoSerialNumber);
		setDmNumber(dmNumber);
		setSapSTPNumber(sapSTPNumber);
		setLicenseEffectiveDate(licenseEffectiveDate);
		setComment(comment);
		setIneligibleEEs(ineligibleEEs);
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(IneligibleSWOCustomDTO customDTO){
		if(null != customDTO){
			setId(customDTO.getKey());
			setSwoNumber(customDTO.getSwoNumber());
			setSwoSerialNumber(customDTO.getSwoSerialNumber());
			setDmNumber(customDTO.getDmNumber());
			setSapSTPNumber(customDTO.getSapSTPNumber());
			setLicenseEffectiveDate(customDTO.getLicenseEffectiveDate());
			setComment(customDTO.getComment());
			setLicensePulled(customDTO.isLicensePulled());
			
			ArrayList ees = customDTO.getIneligibleEEs();
			if(null != ees){
				for(int i=0, size=ees.size(); i<size; i++){
					addIneligibleEE(new IneligibleEEViewBean((IneligibleEECustomDTO)ees.get(i)));
				}
			}
		}
	}
	
	/**
     * IneligibleSWOViewBean
     * 
     * @author thirumalai
     */
    public IneligibleSWOViewBean(){
	}

	/**
     * IneligibleSWOViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public IneligibleSWOViewBean(IneligibleSWOCustomDTO customDTO){
		setData(customDTO);
	}

	/**
	 * Returns true if the license is already pulled into proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isLicensePulled() {
		return licensePulled;
	}

	/**
	 * Sets license pulled flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLicensePulled boolean 
	 */
	public void setLicensePulled(boolean newLicensePulled) {
		licensePulled = newLicensePulled;
	}
	
	/**
	 * Returns selected value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 26, 2004 
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
	 * Sets selected value flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 26, 2004 
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
}
/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.*;

/**
 * Custom dto that holds data about ineligible swo.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class IneligibleSWOCustomDTO extends OPPTCustomDTO {
	private String sapSTPNumber = null;
	private String swoNumber = null;
	private String swoSerialNumber = null;
	private String dMNumber = null;
	private Date licenseEffectiveDate = null;
	private String comment = null;
	private String equipmentNo = null;
	private String salesDocumnetNo = null;
	private ArrayList ineligibleEEs = null;
	private boolean licensePulled = false;

	/**
	 * Returns comment value 
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
	 * @return String
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Returns dm number 
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
	 * @return String
	 */
	public String getDmNumber() {
		return dMNumber;
	}

	/**
	 * Returns ineligible swo identifier 
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
	 * @return String
	 */
	public String getEquipmentNo() {
		return equipmentNo;
	}

	/**
	 * Returns collection of ineligible ee's collection 
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
	 * @return ArrayList
	 */
	public ArrayList getIneligibleEEs() {
		return ineligibleEEs;
	}

	/**
	 * Returns license effective date 
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
	 * @return Date
	 */
	public Date getLicenseEffectiveDate() {
		return licenseEffectiveDate;
	}

	/**
	 * Returns sap stp number 
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
	 * @return String
	 */
	public String getSapSTPNumber() {
		return sapSTPNumber;
	}

	/**
	 * Returns swo number 
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
	 * @return String
	 */
	public String getSwoNumber() {
		return swoNumber;
	}

	/**
	 * Returns swo serial number 
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
	 * @return String
	 */
	public String getSwoSerialNumber() {
		return swoSerialNumber;
	}

	/**
	 * Sets comment value 
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
	 * @param newComment 
	 */
	public void setComment(String newComment) {
		comment = newComment;
	}

	/**
	 * Sets dm number 
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
	 * @param newDMNumber 
	 */
	public void setDMNumber(String newDMNumber) {
		dMNumber = newDMNumber;
	}

	/**
	 * Sets swo identifier 
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
	 * @param newEquipmentNo 
	 */
	public void setEquipmentNo(String newEquipmentNo) {
		equipmentNo = newEquipmentNo;
	}

	/**
	 * Sets ineligible ees collection 
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
	 * @param newIneligibleEEs 
	 */
	public void setIneligibleEEs(ArrayList newIneligibleEEs) {
		ineligibleEEs = newIneligibleEEs;
	}

	/**
	 * Sets license effective date value 
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
	 * @param newLicenseEffectiveDate 
	 */
	public void setLicenseEffectiveDate(Date newLicenseEffectiveDate) {
		licenseEffectiveDate = newLicenseEffectiveDate;
	}

	/**
	 * Sets sap sold to party number 
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
	 * @param newSapSTPNumber 
	 */
	public void setSapSTPNumber(String newSapSTPNumber) {
		sapSTPNumber = newSapSTPNumber;
	}

	/**
	 * Sets swo number 
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
	 * @param newSwoNumber 
	 */
	public void setSwoNumber(String newSwoNumber) {
		swoNumber = newSwoNumber;
	}

	/**
	 * Sets swo serial number 
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
	 * @param newSwoSerialNumber 
	 */
	public void setSwoSerialNumber(String newSwoSerialNumber) {
		swoSerialNumber = newSwoSerialNumber;
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
	 * @param newLicensePulled 
	 */
	public void setLicensePulled(boolean newLicensePulled) {
		licensePulled = newLicensePulled;
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
	 * @param ineligibleEE
	 */
	
	public void addIneligibleEE(IneligibleEECustomDTO ineligibleEE){
		if(null != ineligibleEE){
			if(null == ineligibleEEs){
				ineligibleEEs = new ArrayList();
			}
			ineligibleEEs.add(ineligibleEE);
		}
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
	 * date Oct 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String 
	 */
	public String getSalesDocumnetNo() {
		return salesDocumnetNo;
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
	 * date Oct 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSalesDocumentNo 
	 */
	public void setSalesDocumnetNo(String newSalesDocumentNo) {
		salesDocumnetNo = newSalesDocumentNo;
	}
	
	/**
     * Enter one sentence as a brief description for this method.
     * You can enter more text here. Please think of
     * - visibility decision
     * - changes that are made to objects, which are passed as parameters
     * - concurrency issues
     * - examples how to invoke this methods
     * - preconditions that this method relies on
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Oct 1, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return String
     */
	
	public String getKey(){
		StringBuffer buffer = new StringBuffer();
		if(null != getEquipmentNo()){
			buffer.append(getEquipmentNo());
			buffer.append("__");  /* NOI18N */
		}
		if(null != getSalesDocumnetNo()){
			buffer.append(getSalesDocumnetNo());
		}
		
		return buffer.toString();
	}
    /**
     * return the value
     * 
     * @return Returns the dMNumber.
     */
    public String getDMNumber() {
        return dMNumber;
    }
}
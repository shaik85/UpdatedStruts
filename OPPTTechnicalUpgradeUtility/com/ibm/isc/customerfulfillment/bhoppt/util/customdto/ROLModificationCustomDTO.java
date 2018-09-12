/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import java.util.Date;


/**
 * Custom dto that holds data related to the rol modification details.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jun 14, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Sasi R Challa
 * @version CBS 2.1
 */
public class ROLModificationCustomDTO extends ModificationCustomDTO {
	
	private Date rolStartDate = null;
	private Date rolEndDate = null;
	private String modificationOption = null;
	
    	/**
	 * @return Returns the modificationOption.
	 */
	public String getModificationOption() {
		return modificationOption;
	}
	/**
	 * @param modificationOption The modificationOption to set.
	 */
	public void setModificationOption(String modificationOption) {
		this.modificationOption = modificationOption;
	}
	/**
	 * @return Returns the rolEndDate.
	 */
	public Date getRolEndDate() {
		return rolEndDate;
	}
	/**
	 * @param rolEndDate The rolEndDate to set.
	 */
	public void setRolEndDate(Date rolEndDate) {
		this.rolEndDate = rolEndDate;
	}
	/**
	 * @return Returns the rolStartDate.
	 */
	public Date getRolStartDate() {
		return rolStartDate;
	}
	/**
	 * @param rolStartDate The rolStartDate to set.
	 */
	public void setRolStartDate(Date rolStartDate) {
		this.rolStartDate = rolStartDate;
	}
}

/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * Custom dto that holds the detail information about a form  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Oct 11, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Nayanatara L Pai
 * @version CBS 2.1
 */
public class FormDetailsCustomDTO extends OPPTCustomDTO {
	
	private String formNumber = null;
	
	private String formLongDescription = null;
	
	private String formShortDescription = null;
	
	private String language = null;
	
	private String salesOrg = null;
	
	private Date effectiveDate = null;
	
	
	/**
	 * @return Returns the effectiveDate.
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	/**
	 * @param effectiveDate The effectiveDate to set.
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	/**
	 * @return Returns the comments.
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments The comments to set.
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return Returns the formClass.
	 */
	public String getFormClass() {
		return formClass;
	}
	/**
	 * @param formClass The formClass to set.
	 */
	public void setFormClass(String formClass) {
		this.formClass = formClass;
	}
	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return Returns the language.
	 */
	public String getLanguage() {
		return language;
	}
	private String type = null;
	
	private String formClass = null;
	
	private String comments = null;
	
	
	/**
	 * Returns the formLongDescription
	 * 
	 * @return String
	 */
	public String getFormLongDescription() {
		return formLongDescription;
	}
	
	/**
	 * sets formLongDescription
	 * 
	 * @param formLongDescription String
	 */
	public void setFormLongDescription(String LformLongDescription) {
		formLongDescription = LformLongDescription;
	}
	
	/**
	 * Returns the formNumber
	 * 
	 * @return String
	 */
	public String getFormNumber() {
		return formNumber;
	}
	
	/**
	 * sets formNumber
	 * 
	 * @param formNumber String
	 */
	public void setFormNumber(String lFormNumber) {
		formNumber = lFormNumber;
	}
	
	/**
	 * Returns the formShortDescription
	 * 
	 * @return String 
	 */
	public String getFormShortDescription() {
		return formShortDescription;
	}
	
	/**
	 * sets formShortDescription
	 * 
	 * @param formShortDescription String
	 */
	public void setFormShortDescription(String lFormShortDescription) {
		formShortDescription = lFormShortDescription;
	}
	
	/**
	 * Returns the language
	 * 
	 * @return String 
	 */
	/*public String getLanguage() {
		return language;
	}*/
	
	/**
	 * sets the language
	 * 
	 * @param language String
	 */
	public void setLanguage(String lLanguage) {
		language = lLanguage;
	}
	
	/**
	 * Returns the salesOrg
	 * 
	 * @return String 
	 */
	public String getSalesOrg() {
		return salesOrg;
	}
	
	/**
	 * sets the salesorg
	 * 
	 * @param salesOrg String
	 */
	public void setSalesOrg(String lSalesOrg) {
		salesOrg = lSalesOrg;
	}

}

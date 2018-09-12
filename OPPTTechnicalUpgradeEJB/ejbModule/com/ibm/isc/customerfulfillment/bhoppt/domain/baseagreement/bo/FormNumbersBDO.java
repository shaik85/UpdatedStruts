/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo;

import java.util.Date;

/**
 * FormNumbersBDO class represents attribute defined in FormNumbers Entity
 * This data can be validated using FormNumbersBO Business Object class
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
public class FormNumbersBDO {
	
	private String formNumber = null;
	private String formLongDescription = null;
	private String formShortDescription = null;
	private String salesOrg = null;
	private String comments = null;
	private String type = null;
	private String formClass = null;
	private String language = null;
	private Date createdDate = null;
	private Date effectiveDate = null;
	private String createdBy = null;
	
	
	
	
	
	/**
	 * @return Returns the createdBy.
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy The createdBy to set.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return Returns the createdDate.
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate The createdDate to set.
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
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
	 * @return Returns the language.
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language The language to set.
	 */
	public void setLanguage(String language) {
		this.language = language;
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
	 * @return Returns the formLongDescription.
	 */
	public String getFormLongDescription() {
		return formLongDescription;
	}
	/**
	 * @param formLongDescription The formLongDescription to set.
	 */
	public void setFormLongDescription(String formLongDescription) {
		this.formLongDescription = formLongDescription;
	}
	/**
	 * @return Returns the formNumber.
	 */
	public String getFormNumber() {
		return formNumber;
	}
	/**
	 * @param formNumber The formNumber to set.
	 */
	public void setFormNumber(String formNumber) {
		this.formNumber = formNumber;
	}
	/**
	 * @return Returns the formShortDescription.
	 */
	public String getFormShortDescription() {
		return formShortDescription;
	}
	/**
	 * @param formShortDescription The formShortDescription to set.
	 */
	public void setFormShortDescription(String formShortDescription) {
		this.formShortDescription = formShortDescription;
	}

	/**
	 * @return Returns the salesOrg.
	 */
	public String getSalesOrg() {
		return salesOrg;
	}
	/**
	 * @param salesOrg The salesOrg to set.
	 */
	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}
}

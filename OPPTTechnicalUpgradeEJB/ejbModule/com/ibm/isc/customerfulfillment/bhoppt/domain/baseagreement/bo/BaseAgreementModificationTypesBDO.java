/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo;

/**
 * BaseAgreementModificationTypesBDO class represents attribute defined in BaseAgreementModificationTypes Entity
 * This data can be validated using BaseAgreementModificationTypesBO Business Object class
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
public class BaseAgreementModificationTypesBDO {
	
	private String modificationTypeCode = null;
	private String modificationTypeDescription = null;
	private String salesOrg = null;
	

	/**
	 * @return Returns the modificationTypeCode.
	 */
	public String getModificationTypeCode() {
		return modificationTypeCode;
	}
	/**
	 * @param modificationTypeCode The modificationTypeCode to set.
	 */
	public void setModificationTypeCode(String modificationTypeCode) {
		this.modificationTypeCode = modificationTypeCode;
	}
	
	/**
	 * @return Returns the modificationTypeDescription.
	 */
	public String getModificationTypeDescription() {
		return modificationTypeDescription;
	}
	/**
	 * @param modificationTypeDescription The modificationTypeDescription to set.
	 */
	public void setModificationTypeDescription(
			String modificationTypeDescription) {
		this.modificationTypeDescription = modificationTypeDescription;
	}
	
    /**
     *gets the  salesOrg
     *
     * @return Returns the salesOrg.
     */
    public String getSalesOrg() {
        return salesOrg;
    }
    /**
     * sets the salesOrg
     * @param salesOrg The salesOrg to set.
     */
    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }
}

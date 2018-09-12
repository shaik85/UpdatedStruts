/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo;

/**
 * CoverageTypeBDO class represents attribute defined in CoverageType Entity
 * This data can be validated using CoverageTypeBO Business Object class
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
public class CoverageTypeBDO {
	
	private String coverageType = null;
	private String coverageTypeDescription = null;
	

	/**
	 * @return Returns the coverageType.
	 */
	public String getCoverageType() {
		return coverageType;
	}
	/**
	 * @param coverageType The coverageType to set.
	 */
	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}
	/**
	 * @return Returns the coverageTypeDescription.
	 */
	public String getCoverageTypeDescription() {
		return coverageTypeDescription;
	}
	/**
	 * @param coverageTypeDescription The coverageTypeDescription to set.
	 */
	public void setCoverageTypeDescription(String coverageTypeDescription) {
		this.coverageTypeDescription = coverageTypeDescription;
	}
}

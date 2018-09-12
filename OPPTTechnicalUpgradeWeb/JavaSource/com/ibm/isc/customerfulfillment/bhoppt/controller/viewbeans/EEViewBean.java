/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EECustomDTO;

/**
 * Holds complete information about an ee.  
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
public class EEViewBean extends OPPTViewBean {
	private String iId = null;
	private String iNumber = null;
	private String iDescription = null;
	private String iValueMetric = null;
	private String iUseLevel = null;
	private String iLicenceType = null;
	private double iEswPrice = 0;
	private double iAlternatePrice = 0;
	private double iCalculatedPrice = 0;
	private boolean iEditable = true;
	private boolean iDiscountEditable = true;
	private double iSAndSDiscountPercent = 0;

	
	/**
	 * Returns alternative price for the EE. 
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
	 * @return double
	 */
	public double getAlternatePrice() {
		return iAlternatePrice;
	}

	/**
	 * Returns calculated price for the EE. 
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
	 * @return double
	 */
	public double getCalculatedPrice() {
		return iCalculatedPrice;
	}

	/**
	 * Returns esw price for the EE. 
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
	 * @return double
	 */
	public double getEswPrice() {
		return iEswPrice;
	}

	/**
	 * Returns license type 
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
	public String getLicenceType() {
		return iLicenceType;
	}

	/**
	 * Returns use level for the EE. 
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
	public String getUseLevel() {
		return iUseLevel;
	}

	/**
	 * Returns value metric description of the EE. 
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
	public String getValueMetric() {
		return iValueMetric;
	}

	/**
	 * Sets the alternate price for the EE. 
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
	 * @param newAlternatePrice double
	 */
	public void setAlternatePrice(double newAlternatePrice) {
		iAlternatePrice = newAlternatePrice;
	}

	/**
	 * Sets the calculated price 
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
	 * @param newCalculatedPrice double 
	 */
	public void setCalculatedPrice(double newCalculatedPrice) {
		iCalculatedPrice = newCalculatedPrice;
	}

	/**
	 * Sets the ESW price 
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
	 * @param newEswPrice double 
	 */
	public void setEswPrice(double newEswPrice) {
		iEswPrice = newEswPrice;
	}

	/**
	 * Sets the license type 
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
	 * @param newLicenseType String 
	 */
	public void setLicenceType(String newLicenseType) {
		iLicenceType = newLicenseType;
	}

	/**
	 * Sets the use level fot the ee 
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
	 * @param newUseLevel String 
	 */
	public void setUseLevel(String newUseLevel) {
		iUseLevel = newUseLevel;
	}

	/**
	 * Sets the value metric description for the ee. 
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
	 * @param newValueMetricDescription String 
	 */
	public void setValueMetric(String newValueMetricDescription) {
		iValueMetric = newValueMetricDescription;
	}

	/**
	 * Returns ee id value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
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
	 * Returns description value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
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
	 * Sets ee identifier value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
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
	 * Sets description value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
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
	 * Returns true if ee is editable 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isEditable() {
		return iEditable;
	}

	/**
	 * Sets editable property for the ee 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEditable boolean 
	 */
	public void setEditable(boolean newEditable) {
		iEditable = newEditable;
	}

	/**
     * Sets complete data in a single method call
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 19, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @parma id String
     * @parma description String
     * @param valueMetric String
     * @param useLevel String
     * @param licenceType String
     * @param eswPrice double
     * @param alternatePrice double
     * @param calculatedPrice double
     * @param editable boolean
     * @param description
     * @param id 
     */
	public void setData(String id, String description, String valueMetric, String useLevel, String licenceType, 
						double eswPrice, double alternatePrice, double calculatedPrice, boolean editable){
		setId(id);
		setDescription(description);
		setValueMetric(valueMetric);
		setUseLevel(useLevel);
		setLicenceType(licenceType);
		setEswPrice(eswPrice);
		setAlternatePrice(alternatePrice);
		setCalculatedPrice(calculatedPrice);
		setEditable(editable);
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(EECustomDTO customDTO){
		if(null != customDTO){
			setId(customDTO.getId());
			setNumber(customDTO.getNumber());
			setDescription(customDTO.getDescription());
			setValueMetric(customDTO.getValueMetric());
			setUseLevel(customDTO.getUseLevel());
			setLicenceType(customDTO.getLicenseType());
			setEswPrice(customDTO.getEswPrice());
			setAlternatePrice(customDTO.getAlternatePrice());
			setCalculatedPrice(customDTO.getCalculatedPrice());
			setEditable(customDTO.isEditable());
			setDiscountEditable(customDTO.isDiscountEditable());
			setSAndSDiscountPercent(customDTO.getSAndSDiscountPercent());
		}
	}
	
	/**
     * EEViewBean
     * 
     * @author thirumalai
     */
    public EEViewBean(){
	}
	/**
     * EEViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public EEViewBean(EECustomDTO customDTO){
		setData(customDTO);
	}

	/**
	 * Returns ee number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getNumber() {
		return iNumber;
	}

	/**
	 * Sets ee number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNumber String 
	 */
	public void setNumber(String newNumber) {
		iNumber = newNumber;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public double getSAndSDiscountPercent() {
		return iSAndSDiscountPercent;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setSAndSDiscountPercent(double d) {
		iSAndSDiscountPercent = d;
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
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isDiscountEditable() {
		return iDiscountEditable;
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
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setDiscountEditable(boolean b) {
		iDiscountEditable = b;
	}

}

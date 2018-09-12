/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * Custom dto that holds details about an ee  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 7, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class EECustomDTO extends OPPTCustomDTO 
{
	private String id = null;
	private String number = null;
	private String description = null;
	private String valueMetric = null;
	private String useLevel = null;
	private String licenseType = null;

	private double eswPrice = 0;
	private double alternatePrice = 0;
	private double calculatedPrice = 0;
	private double sAndSDiscountPercent = 0;

	private boolean editable = true;
	private boolean discountEditable = true;

	/**
	 * Returns alternate price value 
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
	 * @return double
	 */
	public double getAlternatePrice() {
		//System.out.println("EECustomDTO.getAlternatePrice()"+alternatePrice);
		return alternatePrice;
	}

	/**
	 * Returns calculated price value 
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
	 * @return double
	 */
	public double getCalculatedPrice() {
		return calculatedPrice;
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
		return description;
	}

	/**
	 * Returns esw price value 
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
	 * @return double
	 */
	public double getEswPrice() {
		return eswPrice;
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
		return id;
	}

	/**
	 * Returns license type value 
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
	public String getLicenseType() {
		return licenseType;
	}

	/**
	 * Returns use level value for the ee 
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
	public String getUseLevel() {
		return useLevel;
	}

	/**
	 * Returns value metric description value 
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
	public String getValueMetric() {
		return valueMetric;
	}

	/**
	 * Seta alternate price value 
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
	 * @param newAlternatePrice 
	 */
	public void setAlternatePrice(double newAlternatePrice) {
		alternatePrice = newAlternatePrice;
			}

	/**
	 * Sets calculated price value 
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
	 * @param newCalculatedPrice 
	 */
	public void setCalculatedPrice(double newCalculatedPrice) {
		calculatedPrice = newCalculatedPrice;
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
	 * @param newDescription 
	 */
	public void setDescription(String newDescription) {
		description = newDescription;
	}

	/**
	 * Sets esw price value 
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
	 * @param newEswPrice 
	 */
	public void setEswPrice(double newEswPrice) {
		eswPrice = newEswPrice;
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
	 * @param newId 
	 */
	public void setId(String newId) {
		id = newId;
	}

	/**
	 * Sets license type value 
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
	 * @param newLicenseType 
	 */
	public void setLicenseType(String newLicenseType) {
		licenseType = newLicenseType;
	}

	/**
	 * Sets use level value 
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
	 * @param newUseLevel 
	 */
	public void setUseLevel(String newUseLevel) {
		useLevel = newUseLevel;
	}

	/**
	 * Sets value metric description value 
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
	 * @param newValueMetric 
	 */
	public void setValueMetric(String newValueMetric) {
		valueMetric = newValueMetric;
	}
	
	/**
	 * Sets value metric description value 
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
	 * @param iid
	 * @param ilicenseType
	 * @param idescription
	 * @param ieswPrice
	 * @param ivalueMetric
	 * @param ialternatePrice
	 * @param iuseLevel
	 * @param icalculatedPrice
	 */
	
	public void setData(String iid, String idescription, String ivalueMetric, String iuseLevel,
						String ilicenseType, double ieswPrice, double ialternatePrice, double icalculatedPrice){
		setId(iid);
		setDescription(idescription);
		setValueMetric(ivalueMetric);
		setUseLevel(iuseLevel);
		setLicenseType(ilicenseType);
		setEswPrice(ieswPrice);
		setAlternatePrice(ialternatePrice);
		setCalculatedPrice(icalculatedPrice);
	}
	
	/**
	 * Sets value metric description value 
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
	
	 */
	
	public EECustomDTO(){
	}
	
	/**
	 * Sets value metric description value 
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
	 * @param iid
	 * @param ilicenseType
	 * @param idescription
	 * @param ieswPrice
	 * @param ivalueMetric
	 * @param ialternatePrice
	 * @param iuseLevel
	 * @param icalculatedPrice
	 */
	
	public EECustomDTO(String iid, String idescription, String ivalueMetric, String iuseLevel,
						String ilicenseType, double ieswPrice, double ialternatePrice, double icalculatedPrice){
		setData(iid, idescription, ivalueMetric, iuseLevel, ilicenseType, ieswPrice, ialternatePrice, icalculatedPrice);	
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
		return editable;
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
	 * @param newEditable 
	 */
	public void setEditable(boolean newEditable) {
		editable = newEditable;
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
		return number;
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
	 * @param newNumber 
	 */
	public void setNumber(String newNumber) {
		number = newNumber;
	}

	/** 
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
	 * @return double 
	 */
	public double getSAndSDiscountPercent() {
		return sAndSDiscountPercent;
	}

	/** 
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
	 * @param d 
	 */
	public void setSAndSDiscountPercent(double d) {
		sAndSDiscountPercent = d;
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
	 * @return boolean
	 */
	public boolean isDiscountEditable() {
		return discountEditable;
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
	    discountEditable = b;
	}

}
/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;

/**
 * Custom dto that holds data about a license  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class SWOCustomDTO extends OPPTCustomDTO {
	private int proposalId = -1;
	private String customerId = null;
	private String dMId = null;
	private String id = null;

	private String serialNumber = null;
	private String number = null;
	private String description = null;

	private String swoReferenceSN = null;
	private String swoReferenceDN = null;
	private String swoContractStatus = null;
	private String swoContractNumber = null;
	private String swoContractType = null;

	private double eswPrice = 0;
	private double alternatePrice = 0;
	private double calculatedPrice = 0;

	private boolean showCalculatedPrice = true;
	private boolean showAlternatePrice = true;
	private boolean showESWPrice = true;

	private Date planEndDate = null;
	private Date planStartDate = null;

	private boolean amendedLicense = false;
	private boolean deltaFetchLicense = false;
	private boolean excluded = false;
	private boolean forConract = false;
	private boolean quote = false;
	private boolean refetchLicense = false;
	private boolean svcLicense = false;
	private boolean editedLicense = false;
	private boolean locked = false;
	private boolean bumped = false;
	private boolean isFirstBumped = false;

	private boolean sAndS = false;
	private boolean alreadyBilled = false;
	
	
	//CR 2031
	private boolean duplicateDeleted = false;
	private boolean markedForDeletion = false;
	
	
	

	/**
	 * Returns alternate price of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double
	 */
	public double getAlternatePrice() {
		//System.out.println("SWOCustomDTO.getAlternatePrice()"+alternatePrice);
		return alternatePrice;
	}

	/**
	 * Returns calculated price of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
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
	 * Returns customer id to which this license belongs 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Returns description of the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
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
	 * Returns dm is to which this license belongs 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDMId() {
		return dMId;
	}

	/**
	 * Returns esw price of the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
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
	 * Returns unique identifier of the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
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
	 * Returns license number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
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
	 * Returns license plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getPlanEndDate() {
		return planEndDate;
	}

	/**
	 * Returns license plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getPlanStartDate() {
		return planStartDate;
	}

	/**
	 * Returns proposal id to which the license belongs 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getProposalId() {
		return proposalId;
	}

	/**
	 * Returns license serial number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Returns true if the license is an amended license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isAmendedLicense() {
		return amendedLicense;
	}

	/**
	 * Returns true if the license is retrieved into proposal during delta fetch operation 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isDeltaFetchLicense() {
		return deltaFetchLicense;
	}

	/**
	 * Returns true is license is excluded from special pricing. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isExcluded() {
		return excluded;
	}

	/**
	 * Returns true if the license is for a contract 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isForConract() {
		return forConract;
	}

	/**
	 * Returns true if the license is a quote 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isQuote() {
		return quote;
	}

	/**
	 * Returns true if license is retrieved in to proposal during refetch operation. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isRefetchLicense() {
		return refetchLicense;
	}

	/**
	 * Returns true if license is an svc license
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isSvcLicense() {
		return svcLicense;
	}

	/**
	 * Sets alternate price of the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAlternatePrice double
	 */
	public void setAlternatePrice(double newAlternatePrice) {
		alternatePrice = newAlternatePrice;
	}

	/**
	 * Sets amended license flag.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAmendedLicense boolean 
	 */
	public void setAmendedLicense(boolean newAmendedLicense) {
		amendedLicense = newAmendedLicense;
	}

	/**
	 * Sets calculated price of the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCalculatedPrice double 
	 */
	public void setCalculatedPrice(double newCalculatedPrice) {
		calculatedPrice = newCalculatedPrice;
	}

	/**
	 * Sets customer id to which the license belongs 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerId String 
	 */
	public void setCustomerId(String newCustomerId) {
		customerId = newCustomerId;
	}

	/**
	 * Sets complete data about a license in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param iid
	 * @param inumber
	 * @param iserialNumber
	 * @param idescription
	 * @param iplanStartDate
	 * @param iplanEndDate
	 * @param ialternatePrice
	 * @param icalculatedPrice
	 * @param ieswPrice
	 */
	public void setData(String iid, String inumber, String iserialNumber, String idescription, Date iplanStartDate, Date iplanEndDate, double ialternatePrice, double icalculatedPrice, double ieswPrice) {
		setId(iid);
		setNumber(inumber);
		setSerialNumber(iserialNumber);
		setDescription(idescription);
		setPlanStartDate(iplanStartDate);
		setPlanEndDate(iplanEndDate);
		setAlternatePrice(ialternatePrice);
		setCalculatedPrice(icalculatedPrice);
		setEswPrice(ieswPrice);
	}

	/**
	 * Sets delta fetch license flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDeltaFetchLicense boolean 
	 */
	public void setDeltaFetchLicense(boolean newDeltaFetchLicense) {
		deltaFetchLicense = newDeltaFetchLicense;
	}

	/** 
	 * Sets description about the license
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDescription String 
	 */
	public void setDescription(String newDescription) {
		description = newDescription;
	}

	/**
	 * Sets license parent dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMId String 
	 */
	public void setDMId(String newDMId) {
		dMId = newDMId;
	}

	/**
	 * Sets esw price of the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEswPrice double 
	 */
	public void setEswPrice(double newEswPrice) {
		eswPrice = newEswPrice;
	}

	/**
	 * Sets license excluded from special pricing flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newExcluded boolean 
	 */
	public void setExcluded(boolean newExcluded) {
		excluded = newExcluded;
	}

	/**
     * Sets all the flags for the license
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 11, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param iquote boolean
     * @param isvcLicense boolean
     * @param iexcluded boolean
     * @param iforConract boolean
     * @param irefetchLicense boolean
     * @param ideltaFetchLicense boolean
     * @param iamendedLicense boolean
     * @param ieditedLicense 
     */
	public void setFlags(boolean iquote, boolean isvcLicense, boolean iexcluded, boolean iforConract, boolean irefetchLicense, boolean ideltaFetchLicense, boolean iamendedLicense, boolean ieditedLicense) {
		setQuote(iquote);
		setSvcLicense(isvcLicense);
		setExcluded(iexcluded);
		setForConract(iforConract);
		setRefetchLicense(irefetchLicense);
		setDeltaFetchLicense(ideltaFetchLicense);
		setAmendedLicense(iamendedLicense);
		setEditedLicense(ieditedLicense);
	}

	/**
	 * Sets true if the license if for contract details view 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newForContract boolean 
	 */
	public void setForConract(boolean newForContract) {
		forConract = newForContract;
	}

	/**
	 * Sets id of the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newId String 
	 */
	public void setId(String newId) {
		id = newId;
	}

	/**
	 * Sets license number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNumber String 
	 */
	public void setNumber(String newNumber) {
		number = newNumber;
	}

	/** 
	 * Sets plan end date
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanEndDate Date 
	 */
	public void setPlanEndDate(Date newPlanEndDate) {
		planEndDate = newPlanEndDate;
	}

	/**
	 * sets plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanStartDate date 
	 */
	public void setPlanStartDate(Date newPlanStartDate) {
		planStartDate = newPlanStartDate;
	}

	/**
	 * Sets license parent proposal id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalId int 
	 */
	public void setProposalId(int newProposalId) {
		proposalId = newProposalId;
	}

	/**
	 * Sets true if the license is an quote 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newQuote boolean 
	 */
	public void setQuote(boolean newQuote) {
		quote = newQuote;
	}

	/**
	 * Sets true if the license is retrieved into proposal during refetch operation 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newRefetchLicense boolean 
	 */
	public void setRefetchLicense(boolean newRefetchLicense) {
		refetchLicense = newRefetchLicense;
	}

	/**
	 * Sets serial number of the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSerialNumber String 
	 */
	public void setSerialNumber(String newSerialNumber) {
		serialNumber = newSerialNumber;
	}

	/**
	 * Sets true if the license is an svc license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSvcLicense boolean 
	 */
	public void setSvcLicense(boolean newSvcLicense) {
		svcLicense = newSvcLicense;
	}
	/**
	 * Returns edited license flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isEditedLicense() {
		return editedLicense;
	}

	/**
	 * Sets edited license flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEditedLicense boolean 
	 */
	public void setEditedLicense(boolean newEditedLicense) {
		editedLicense = newEditedLicense;
	}

	/**
	 * Returns swo contract type value 
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
	public String getSwoContractType() {
		return swoContractType;
	}

	/**
	 * Returns swo contract number value 
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
	public String getSwoContractNumber() {
		return swoContractNumber;
	}

	/**
	 * Returns swo contract status 
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
	public String getSwoContractStatus() {
		return swoContractStatus;
	}

	/**
	 * Returns swo reference dn value 
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
	public String getSwoReferenceDN() {
		return swoReferenceDN;
	}

	/**
	 * Returns swo reference sn value 
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
	public String getSwoReferenceSN() {
		return swoReferenceSN;
	}

	/**
	 * Sets swo contract type value 
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
	 * @param newSwoContractType String 
	 */
	public void setSwoContractType(String newSwoContractType) {
		swoContractType = newSwoContractType;
	}

	/**
	 * Sets swo contract number value 
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
	 * @param newSwoContractNumber String
	 */
	public void setSwoContractNumber(String newSwoContractNumber) {
		swoContractNumber = newSwoContractNumber;
	}

	/**
	 * Sets swo contract status 
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
	 * @param newSwoContractStatus String
	 */
	public void setSwoContractStatus(String newSwoContractStatus) {
		swoContractStatus = newSwoContractStatus;
	}

	/**
	 * Sets swo reference dm 
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
	 * @param newSwoReferenceDN String 
	 */
	public void setSwoReferenceDN(String newSwoReferenceDN) {
		swoReferenceDN = newSwoReferenceDN;
	}

	/**
	 * Sets swo reference SN 
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
	 * @param newSwoReferenceSN String 
	 */
	public void setSwoReferenceSN(String newSwoReferenceSN) {
		swoReferenceSN = newSwoReferenceSN;
	}
	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSAndS() {
		return sAndS;
	}

	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSAndS(boolean b) {
		sAndS = b;
	}

	/**
	 * Returns true if the license is an bumped license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean 
	 */
	public boolean isBumped() {
		return bumped;
	}

	/** 
	 * Returns true if the license is locked
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * Sets bump status of the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBumped boolean
	 */
	public void setBumped(boolean newBumped) {
		bumped = newBumped;
	}

	/**
	 * Sets locked status of the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLocked boolean
	 */
	public void setLocked(boolean newLocked) {
		locked = newLocked;
	}

	/**
     * to String
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Feb 18, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return String
     */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("\n[SWOCustomDTO] - Start...");  /* NOI18N */
		buffer.append("\nProposal id: " + proposalId);  /* NOI18N */
		buffer.append("\nCustomer id: " + customerId);  /* NOI18N */
		buffer.append("\nDM id: " + dMId);  /* NOI18N */
		buffer.append("\nId: " + id);  /* NOI18N */
		buffer.append("\nSerial number: " + serialNumber);  /* NOI18N */
		buffer.append("\nNumber: " + number);  /* NOI18N */
		buffer.append("\nDescription: " + description);  /* NOI18N */
		buffer.append("\nSWO reference SN: " + swoReferenceSN);  /* NOI18N */
		buffer.append("\nSWO reference DN: " + swoReferenceDN);  /* NOI18N */
		buffer.append("\nSWO contract status: " + swoContractStatus);  /* NOI18N */
		buffer.append("\nSWO contract number: " + swoContractNumber);  /* NOI18N */
		buffer.append("\nSWO contract type: " + swoContractType);  /* NOI18N */
		buffer.append("\nESW price: " + eswPrice);  /* NOI18N */
		buffer.append("\nAlternate price: " + alternatePrice);  /* NOI18N */
		//System.out.println("SWOCustomDTO.toString()"+alternatePrice);
		buffer.append("\nCalculated price: " + calculatedPrice);  /* NOI18N */
		buffer.append("\nShow ESW price: " + showESWPrice);  /* NOI18N */
		buffer.append("\nShow alternate price: " + showAlternatePrice);  /* NOI18N */
		buffer.append("\nShow calculated price: " + showCalculatedPrice);  /* NOI18N */
		buffer.append("\nPlan end date: " + planEndDate);  /* NOI18N */
		buffer.append("\nPlan end date: " + planEndDate);  /* NOI18N */
		buffer.append("\nPlan start date: " + planStartDate);  /* NOI18N */
		buffer.append("\nAmended license: " + amendedLicense);  /* NOI18N */
		buffer.append("\nDelta fetch license: " + deltaFetchLicense);  /* NOI18N */
		buffer.append("\nExcluded license: " + excluded);  /* NOI18N */
		buffer.append("\nFor contract license: " + forConract);  /* NOI18N */
		buffer.append("\nQuote: " + quote);  /* NOI18N */
		buffer.append("\nRefetch license: " + refetchLicense);  /* NOI18N */
		buffer.append("\nSVC license: " + svcLicense);  /* NOI18N */
		buffer.append("\nEdited license: " + editedLicense);  /* NOI18N */
		buffer.append("\nBumped license: " + bumped);  /* NOI18N */
		buffer.append("\nLocked license: " + locked);  /* NOI18N */
		buffer.append("\n[SWOCustomDTO] - End...\n");  /* NOI18N */
		return buffer.toString();
	}

	/**
	 * Returns true if the alternate price for the license can be displayed 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isShowAlternatePrice() {
		return showAlternatePrice;
	}

	/**
	 * Returns true if calculated price for the license can be shown 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isShowCalculatedPrice() {
		return showCalculatedPrice;
	}

	/**
	 * Returns true if esw price of the license can be shown 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isShowESWPrice() {
		return showESWPrice;
	}

	/**
	 * Sets show alternare price flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShowAlternatePrice boolean
	 */
	public void setShowAlternatePrice(boolean newShowAlternatePrice) {
		showAlternatePrice = newShowAlternatePrice;
	}

	/**
	 * Sets show calculated price flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShowCalculatedPrice boolean
	 */
	public void setShowCalculatedPrice(boolean newShowCalculatedPrice) {
		showCalculatedPrice = newShowCalculatedPrice;
	}

	/**
	 * Sets show esw price flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShowESWPrice boolean
	 */
	public void setShowESWPrice(boolean newShowESWPrice) {
		showESWPrice = newShowESWPrice;
	}
	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isAlreadyBilled() {
		return alreadyBilled;
	}

	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setAlreadyBilled(boolean b) {
		alreadyBilled = b;
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isFirstBumped() {
		return isFirstBumped;
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setFirstBumped(boolean b) {
		isFirstBumped = b;
	}
	/** 
	 * finalize the method
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 */
	
/*	protected void finalize() {

		customerId = null;
		dMId = null;
		id = null;

		serialNumber = null;
		number = null;
		description = null;

		swoReferenceSN = null;
		swoReferenceDN = null;
		swoContractStatus = null;
		swoContractNumber = null;
		swoContractType = null;

		planEndDate = null;
		planStartDate = null;

	}*/

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
	 * date Oct 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isDuplicateDeleted() {
		return duplicateDeleted;
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
	 * date Oct 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setDuplicateDeleted(boolean b) {
		duplicateDeleted = b;
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
	 * date Nov 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isMarkedForDeletion() {
		return markedForDeletion;
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
	 * date Nov 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setMarkedForDeletion(boolean b) {
		markedForDeletion = b;
	}

}

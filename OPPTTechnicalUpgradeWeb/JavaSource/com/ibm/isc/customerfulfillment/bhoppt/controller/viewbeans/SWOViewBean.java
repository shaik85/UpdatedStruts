/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Date; 

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWOCustomDTO;

/**
 * Holds basic informaton about a swo.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class SWOViewBean extends OPPTViewBean {
	private String iId = null;
	private String iSwoNumber = null;
	private String iSerialNumber = null;
	private String iDescription = null;
	
	private double iEswPrice = 0;
	private double iAlternatePrice = 0;
	private double iCalculatedPrice = 0;

	private boolean iShowCalculatedPrice = false;
	private boolean iShowAlternatePrice = false;
	private boolean iShowESWPrice = false;

	private Date iPlanStartDate = null;
	private Date iPlanEndDate = null;

	private String iSwoReferenceSN = null;
	private String iSwoReferenceDN = null;
	private String iSwoContractStatus = null;
	private String iSwoContractNumber = null;
	private String iSwoContractType = null; 

	/**
	 * License should be displayed in different color
	 */
	private boolean iQuote = false;
	/**
	 * License should be displayed in different color
	 */
	private boolean iSvcLicense = false;
	/**
	 * Exclude indicator should be displayed
	 */
	private boolean iExcluded = false;
	/**
	 * Licenses are displayed with lock indicator
	 */
	private boolean iForConract = false;
	/**
	 * Licenses are displayed with refetch indicator
	 */
	private boolean iRefetchLicense = false;
	/**
	 * License must be displayed with delta fetch indicator
	 */
	private boolean iDeltaFetchLicense = false;
	/**
	 * License must be displayed with amend indicator
	 */
	private boolean iAmendedLicense = false;
	
	/**
	 * License must be displayed in different color
	 */
	private boolean iEditedLicense = false;
	
	private boolean iLocked = false;
	private boolean iBumped = false;
	private boolean iFirstBump = false;
	
	private boolean iAlreadyBilled = false;
	
	//CR 2031
	private boolean iDuplicateDeleted = false;
	private boolean iMarkedForDeletion = false;

	/**
	 * Returns alternati price for swo 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Returns calculated price 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Returns description 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Returns esw price for the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Returns the swo identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Returns the plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getPlanEndDate() {
		return iPlanEndDate;
	}

	/**
	 * Returns plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getPlanStartDate() {
		return iPlanStartDate;
	}

	/**
	 * Returns the serial number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSerialNumber() {
		return iSerialNumber;
	}

	/**
	 * Returns the swo number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
     * getSwoNumberSerialNumber
     * 
     * @return
     * @author thirumalai
     */
    public String getSwoNumberSerialNumber() {
		String value = getSwoNumber();
		if(null != value && 0 < value.length()){
			if(null != getSerialNumber()){
				value += "/"+getSerialNumber();  //$NON-NLS-1$
			}
		}
		else{
			if(null != getSerialNumber()){
				value = getSerialNumber();
			}
		}
		
		return value;
	}

	/**
	 * Sets the alternate price for the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Sets the calculated price of the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Sets the description of the license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
     * Sets the esw price of the license
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 17, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newEswPrice 
     */
	public void setEswPrice(double newEswPrice) {
		iEswPrice = newEswPrice;
	}

	/**
	 * Sets the license identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Sets the plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanEndDate Date 
	 */
	public void setPlanEndDate(Date newPlanEndDate) {
		iPlanEndDate = newPlanEndDate;
	}

	/**
	 * Sets the plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanStartDate 
	 */
	public void setPlanStartDate(Date newPlanStartDate) {
		iPlanStartDate = newPlanStartDate;
	}

	/**
	 * Sets the serial number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSerialNumber String 
	 */
	public void setSerialNumber(String newSerialNumber) {
		iSerialNumber = newSerialNumber;
	}

	/**
	 * Sets the swo number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Sets complete data in a single method call.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param id String
	 * @param swoNumber String
	 * @param serialNumber String
	 * @param description String
	 * @param eswPrice double
	 * @param alternatePrice double
	 * @param calculatedPrice double
	 * @param planStartDate Date
	 * @param planEndDate Date
	 */
	public void setData(String id, String swoNumber, String serialNumber, String description, 
						double eswPrice, double alternatePrice, double calculatedPrice, 
						Date planStartDate, Date planEndDate){
		setId(id);
		setSwoNumber(swoNumber);
		setSerialNumber(serialNumber);
		setDescription(description);
		setEswPrice(eswPrice);
		setAlternatePrice(alternatePrice);
		setCalculatedPrice(calculatedPrice);
		setPlanStartDate(planStartDate);
		setPlanEndDate(planEndDate);
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(SWOCustomDTO customDTO){
		if(null != customDTO){
			setId(customDTO.getId());
			setSwoNumber(customDTO.getNumber());
			setSerialNumber(customDTO.getSerialNumber());
			setDescription(customDTO.getDescription());
			
			setEswPrice(customDTO.getEswPrice());
			setAlternatePrice(customDTO.getAlternatePrice());
			setCalculatedPrice(customDTO.getCalculatedPrice());
			setShowESWPrice(customDTO.isShowESWPrice());
			setShowAlternatePrice(customDTO.isShowAlternatePrice());
			setShowCalculatedPrice(customDTO.isShowCalculatedPrice());
			
			setPlanStartDate(customDTO.getPlanStartDate());
			setPlanEndDate(customDTO.getPlanEndDate());

			setLocked(customDTO.isLocked());
			setBumped(customDTO.isBumped());
			setQuote(customDTO.isQuote());
			setSvcLicense(customDTO.isSvcLicense());
			setExcluded(customDTO.isExcluded());
			setForConract(customDTO.isForConract());
			setRefetchLicense(customDTO.isRefetchLicense());
			setDeltaFetchLicense(customDTO.isDeltaFetchLicense());
			setAmendedLicense(customDTO.isAmendedLicense());
			setEditedLicense(customDTO.isEditedLicense());
					
			setSwoReferenceSN(customDTO.getSwoReferenceSN());
			setSwoReferenceDN(customDTO.getSwoReferenceDN());
			setSwoContractStatus(customDTO.getSwoContractStatus());
			setSwoContractNumber(customDTO.getSwoContractNumber());
			setSwoContractType(customDTO.getSwoContractType());
			setAlreadyBilled(customDTO.isAlreadyBilled());
			setFirstBump(customDTO.isFirstBumped());
			// CR2031
			setDuplicateDeleted(customDTO.isDuplicateDeleted());
			setMarkedForDeletion(customDTO.isMarkedForDeletion());
		}
	}
	
	/**
     * SWOViewBean
     * 
     * @author thirumalai
     */
    public SWOViewBean(){
	}
	/**
     * SWOViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public SWOViewBean(SWOCustomDTO customDTO){
		setData(customDTO);
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
		return iAmendedLicense;
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
		return iDeltaFetchLicense;
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
		return iExcluded;
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
		return iForConract;
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
		return iQuote;
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
		return iRefetchLicense;
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
		return iSvcLicense;
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
		iAmendedLicense = newAmendedLicense;
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
		iDeltaFetchLicense = newDeltaFetchLicense;
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
		iExcluded = newExcluded;
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
		iForConract = newForContract;
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
		iQuote = newQuote;
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
		iRefetchLicense = newRefetchLicense;
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
		iSvcLicense = newSvcLicense;
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
		return iEditedLicense;
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
		iEditedLicense = newEditedLicense;
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
		return iSwoContractType;
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
		return iSwoContractNumber;
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
		return iSwoContractStatus;
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
		return iSwoReferenceDN;
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
		return iSwoReferenceSN;
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
		iSwoContractType = newSwoContractType;
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
		iSwoContractNumber = newSwoContractNumber;
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
		iSwoContractStatus = newSwoContractStatus;
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
		iSwoReferenceDN = newSwoReferenceDN;
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
		iSwoReferenceSN = newSwoReferenceSN;
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
		return iBumped;
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
		return iLocked;
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
		iBumped = newBumped;
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
		iLocked = newLocked;
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
		return iShowAlternatePrice;
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
		return iShowCalculatedPrice;
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
		return iShowESWPrice;
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
		iShowAlternatePrice = newShowAlternatePrice;
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
		iShowCalculatedPrice = newShowCalculatedPrice;
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
		iShowESWPrice = newShowESWPrice;
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
	 * date Mar 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isAlreadyBilled() {
		return iAlreadyBilled;
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
	 * date Mar 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setAlreadyBilled(boolean b) {
		iAlreadyBilled = b;
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
	 * date Apr 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isFirstBump() {
		return iFirstBump;
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
	 * date Apr 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setFirstBump(boolean b) {
		iFirstBump = b;
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
	 * @return 
	 */
	public boolean isDuplicateDeleted() {
		return iDuplicateDeleted;
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
		iDuplicateDeleted = b;
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
		return iMarkedForDeletion;
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
		iMarkedForDeletion = b;
	}

}
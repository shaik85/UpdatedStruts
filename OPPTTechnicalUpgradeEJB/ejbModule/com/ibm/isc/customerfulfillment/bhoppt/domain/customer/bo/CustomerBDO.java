/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo;


import java.sql.Date;


/**
 *  
 * CustomerBDO class represents attribute defined in Customer Entity 
 * This data can be validated using Cutomer Business Object class
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar 
 *  @version 5.1A
 */

public class CustomerBDO {
	/** customerId
     */
    private int customerId;
	/** proposalId
     */
    private int proposalId;
	/** customerListNo
     */
    private String customerListNo;
	/** legacyCustomerNo
     */
    private String legacyCustomerNo;
	/** sapCustomerNo
     */
    private String sapCustomerNo;
	/** sapCustomerName
     */
    private String sapCustomerName;
	/** billToPartyNo
     */
    private String billToPartyNo;
	/** billToPartyName
     */
    private String billToPartyName;
	/** payerNo
     */
    private String payerNo;
	/** payerName
     */
    private String payerName;
	/** shipToPartyNo
     */
    private String shipToPartyNo;
	/** shipToPartyName
     */
    private String shipToPartyName;
	/** planStartDate
     */
    private Date planStartDate;
	/** planEndDate
     */
    private Date planEndDate;
	/** lastUpdatedDate
     */
    private Date lastUpdatedDate;
	/** payerLNo
     */
    private String payerLNo;
	/** billToPartyLNo
     */
    private String billToPartyLNo;
	/** shipToPartyLNo
     */
    private String shipToPartyLNo;
	/** custmerASNo
     */
    private String custmerASNo;
	/** billToPartyASNo
     */
    private String billToPartyASNo;
	/** shipToPartyASNo
     */
    private String shipToPartyASNo;
	/** payerASNo
     */
    private String payerASNo;
	/** countryCode
     */
    private String countryCode; //EF0607044559


    /**
     * getBillToPartyASNo
     *
     * @return Returns the billToPartyASNo.
     */
    public String getBillToPartyASNo() {
        return billToPartyASNo;
    }
    /**
     * setBillToPartyASNo
     *
     * @param iBillToPartyASNo 
     */
    public void setBillToPartyASNo(String iBillToPartyASNo) {
        billToPartyASNo = iBillToPartyASNo;
    }
    /**
     * getBillToPartyLNo
     * @return Returns the billToPartyLNo.
     */
    public String getBillToPartyLNo() {
        return billToPartyLNo;
    }
    /**
     * setBillToPartyLNo
     *
     * @param iBillToPartyLNo 
     */
    public void setBillToPartyLNo(String iBillToPartyLNo) {
        billToPartyLNo = iBillToPartyLNo;
    }
    /**
     * getBillToPartyName
     * @return Returns the billToPartyName.
     */
    public String getBillToPartyName() {
        return billToPartyName;
    }
    /**
     * setBillToPartyName
     *
     * @param iBillToPartyName 
     */
    public void setBillToPartyName(String iBillToPartyName) {
        billToPartyName = iBillToPartyName;
    }
    /**
     * getBillToPartyNo
     * @return Returns the billToPartyNo.
     */
    public String getBillToPartyNo() {
        return billToPartyNo;
    }
    /**
     * setBillToPartyNo
     *
     * @param iBillToPartyNo 
     */
    public void setBillToPartyNo(String iBillToPartyNo) {
       billToPartyNo = iBillToPartyNo;
    }
    /**
     * getCountryCode
     * @return Returns the countryCode.
     */
    public String getCountryCode() {
        return countryCode;
    }
    /**
     * setCountryCode
     *
     * @param iCountryCode 
     */
    public void setCountryCode(String iCountryCode) {
        countryCode = iCountryCode;
    }
    /**
     * getCustmerASNo
     * @return Returns the custmerASNo.
     */
    public String getCustmerASNo() {
        return custmerASNo;
    }
    /**
     * setCustmerASNo
     *
     * @param iCustmerASNo 
     */
    public void setCustmerASNo(String iCustmerASNo) {
        custmerASNo = iCustmerASNo;
    }
    /**
     * getCustomerId
     * @return Returns the customerId.
     */
    public int getCustomerId() {
        return customerId;
    }
    /**
     * setCustomerId
     *
     * @param iCustomerId 
     */
    public void setCustomerId(int iCustomerId) {
        customerId = iCustomerId;
    }
    /**
     * getCustomerListNo
     * @return Returns the customerListNo.
     */
    public String getCustomerListNo() {
        return customerListNo;
    }
    /**
     * setCustomerListNo
     *
     * @param iCustomerListNo 
     */
    public void setCustomerListNo(String iCustomerListNo) {
       customerListNo = iCustomerListNo;
    }
    /**
     * getLastUpdatedDate
     * @return Returns the lastUpdatedDate.
     */
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }
    /**
     * setLastUpdatedDate
     *
     * @param iLastUpdatedDate 
     */
    public void setLastUpdatedDate(Date iLastUpdatedDate) {
        lastUpdatedDate = iLastUpdatedDate;
    }
    /**
     * getLegacyCustomerNo
     * @return Returns the legacyCustomerNo.
     */
    public String getLegacyCustomerNo() {
        return legacyCustomerNo;
    }
    /**
     * setLegacyCustomerNo
     *
     * @param iLegacyCustomerNo 
     */
    public void setLegacyCustomerNo(String iLegacyCustomerNo) {
        legacyCustomerNo = iLegacyCustomerNo;
    }
    /**
     * getPayerASNo
     * @return Returns the payerASNo.
     */
    public String getPayerASNo() {
        return payerASNo;
    }
    /**
     * setPayerASNo
     *
     * @param iPayerASNo 
     */
    public void setPayerASNo(String iPayerASNo) {
       payerASNo = iPayerASNo;
    }
    /**
     * getPayerLNo
     * @return Returns the payerLNo.
     */
    public String getPayerLNo() {
        return payerLNo;
    }
    /**
     * setPayerLNo
     *
     * @param iPayerLNo 
     */
    public void setPayerLNo(String iPayerLNo) {
        payerLNo = iPayerLNo;
    }
    /**
     * getPayerName
     * @return Returns the payerName.
     */
    public String getPayerName() {
        return payerName;
    }
    /**
     * setPayerName
     *
     * @param iPayerName 
     */
    public void setPayerName(String iPayerName) {
        payerName = iPayerName;
    }
    /**
     * getPayerNo
     * @return Returns the payerNo.
     */
    public String getPayerNo() {
        return payerNo;
    }
    /**
     * setPayerNo
     *
     * @param iPayerNo 
     */
    public void setPayerNo(String iPayerNo) {
        payerNo = iPayerNo;
    }
    /**
     * getPlanEndDate
     * @return Returns the planEndDate.
     */
    public Date getPlanEndDate() {
        return planEndDate;
    }
    /**
     * setPlanEndDate
     *
     * @param iPlanEndDate 
     */
    public void setPlanEndDate(Date iPlanEndDate) {
        planEndDate = iPlanEndDate;
    }
    /**
     * getPlanStartDate
     * @return Returns the planStartDate.
     */
    public Date getPlanStartDate() {
        return planStartDate;
    }
    /**
     * setPlanStartDate
     *
     * @param iPlanStartDate 
     */
    public void setPlanStartDate(Date iPlanStartDate) {
        planStartDate = iPlanStartDate;
    }
    /**
     * getProposalId
     * @return Returns the proposalId.
     */
    public int getProposalId() {
        return proposalId;
    }
    /**
     * setProposalId
     *
     * @param iProposalId 
     */
    public void setProposalId(int iProposalId) {
        proposalId = iProposalId;
    }
    /**
     * getSapCustomerName
     * @return Returns the sapCustomerName.
     */
    public String getSapCustomerName() {
        return sapCustomerName;
    }
    /**
     * setSapCustomerName
     *
     * @param iSapCustomerName 
     */
    public void setSapCustomerName(String iSapCustomerName) {
        sapCustomerName = iSapCustomerName;
    }
    /** getSapCustomerNo
     * @return Returns the sapCustomerNo.
     */
    public String getSapCustomerNo() {
        return sapCustomerNo;
    }
    /**
     * setSapCustomerNo
     *
     * @param iSapCustomerNo 
     */
    public void setSapCustomerNo(String iSapCustomerNo) {
        sapCustomerNo = iSapCustomerNo;
    }
    /** getShipToPartyASNo
     * @return Returns the shipToPartyASNo.
     */
    public String getShipToPartyASNo() {
        return shipToPartyASNo;
    }
    /**
     * setShipToPartyASNo
     *
     * @param iShipToPartyASNo 
     */
    public void setShipToPartyASNo(String iShipToPartyASNo) {
        shipToPartyASNo = iShipToPartyASNo;
    }
    /** getShipToPartyLNo
     * @return Returns the shipToPartyLNo.
     */
    public String getShipToPartyLNo() {
        return shipToPartyLNo;
    }
    /**
     * setShipToPartyLNo
     *
     * @param iShipToPartyLNo 
     */
    public void setShipToPartyLNo(String iShipToPartyLNo) {
       shipToPartyLNo = iShipToPartyLNo;
    }
    /**
     * getShipToPartyName
     * @return Returns the shipToPartyName.
     */
    public String getShipToPartyName() {
        return shipToPartyName;
    }
    /**
     * setShipToPartyName
     *
     * @param iShipToPartyName 
     */
    public void setShipToPartyName(String iShipToPartyName) {
      shipToPartyName = iShipToPartyName;
    }
    /**
     * getShipToPartyNo
     * @return Returns the shipToPartyNo.
     */
    public String getShipToPartyNo() {
        return shipToPartyNo;
    }
    /**
     * setShipToPartyNo
     *
     * @param iShipToPartyNo 
     */
    public void setShipToPartyNo(String iShipToPartyNo) {
        shipToPartyNo = iShipToPartyNo;
    }
}
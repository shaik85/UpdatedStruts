/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.dto;

import java.sql.Date;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;

/**
 * This Domain DTOS have same attributes like CustomerBDO. But this DTOs are
 * mainly used to transfer the data across service layer
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date Nov 24, 2003
 * 
 * revision date author reason
 * 
 * </PRE>
 * 
 * <br/>
 * 
 * @author Ravishankar *
 * @version 5.1A
 */

public class CustomerDomainDTO extends OPPTDomainDTO {

    private int customerId;

    private int proposalId;

    private String customerListNo;

    private String legacyCustomerNo;

    private String sapCustomerNo;

    private String sapCustomerName;

    private String billToPartyNo;

    private String billToPartyName;

    private String payerNo;

    private String payerName;

    private String shipToPartyNo;

    private String shipToPartyName;

    private Date planStartDate;

    private Date planEndDate;

    private Date lastUpdatedDate;

    private String payerLNo;

    private String billToPartyLNo;

    private String shipToPartyLNo;

    private String custmerASNo;

    private String billToPartyASNo;

    private String shipToPartyASNo;

    private String payerASNo;

    private String countryCode; //EF0607044559

    private List iDMDTOList;
    
    private String soldToPartyNo; //DADO02

    /**
     * 
     * Empty Constructor
     * 
     * <br/>
     * 
     * <PRE>
     * 
     * date Nov 28, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br/>
     *  
     */
    public CustomerDomainDTO() {

    }

    /**
     * 
     * Customer Domain DTO Constructor takes the CustomerBO object Getter and
     * setter methods act on the constructor itself
     * 
     * <br/>
     * 
     * <PRE>
     * 
     * date Nov 25, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br/>
     * 
     * @param bo
     */
    public CustomerDomainDTO(CustomerBO bo) {
        customerId = bo.getCustomerId();
        proposalId = bo.getProposalId();
        customerListNo = bo.getCustomerListNo();
        legacyCustomerNo = bo.getLegacyCustomerNo();
        sapCustomerNo = bo.getSapCustomerNo();
        sapCustomerName = bo.getSapCustomerName();
        billToPartyNo = bo.getBillToPartyNo();
        billToPartyName = bo.getBillToPartyName();
        payerNo = bo.getPayerNo();
        payerName = bo.getPayerName();
        shipToPartyNo = bo.getShipToPartyNo();
        shipToPartyName = bo.getShipToPartyName();
        planStartDate = bo.getPlanStartDate();
        planEndDate = bo.getPlanEndDate();
        lastUpdatedDate = bo.getLastUpdatedDate();
        payerLNo = bo.getPayerLNo();
        billToPartyLNo = bo.getBillToPartyLNo();
        shipToPartyLNo = bo.getShipToPartyLNo();
        custmerASNo = bo.getCustmerASNo();
        billToPartyASNo = bo.getBillToPartyASNo();
        shipToPartyASNo = bo.getShipToPartyASNo();
        payerASNo = bo.getPayerASNo();
        countryCode = bo.getCountryCode(); //EF0607044559

    }

    /**
     * Get the Bill to Party Address Seq No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return billToPartyASNo
     */
    public String getBillToPartyASNo() {
        return billToPartyASNo;
    }

    /**
     * Get the Bill to Party List No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return billToPartyLNo
     */
    public String getBillToPartyLNo() {
        return billToPartyLNo;
    }

    /**
     * Get the Bill to Party Name <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return billToPartyName
     */
    public String getBillToPartyName() {
        return billToPartyName;
    }

    /**
     * Get the Bill To Party No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return billToPartyNo
     */
    public String getBillToPartyNo() {
        return billToPartyNo;
    }

    /**
     * Get the Customer Address Sequence No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return custmerASNo
     */
    public String getCustmerASNo() {
        return custmerASNo;
    }

    /**
     * Get the Customer Id <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Get the Customer List No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return customerListNo
     */
    public String getCustomerListNo() {
        return customerListNo;
    }

    /**
     * Get the Last Updated Date <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return lastUpdatedDate
     */
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    /**
     * Get the Legacy Customer No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return legacyCustomerNo
     */
    public String getLegacyCustomerNo() {
        return legacyCustomerNo;
    }

    /**
     * Get the Country code <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date June 16, 2004 Added for EF0607044559 by Sara
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Get the Payer Address Sequence No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return payerASNo
     */
    public String getPayerASNo() {
        return payerASNo;
    }

    /**
     * Get the Payer List No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return payerLNo
     */
    public String getPayerLNo() {
        return payerLNo;
    }

    /**
     * Get the Payer Name <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return payerName
     */
    public String getPayerName() {
        return payerName;
    }

    /**
     * Get the Payer No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return payerNo
     */
    public String getPayerNo() {
        return payerNo;
    }

    /**
     * Get the Palnned End Date <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return planEndDate
     */
    public Date getPlanEndDate() {
        return planEndDate;
    }

    /**
     * Get Plan start date <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return planStartDate
     */
    public Date getPlanStartDate() {
        return planStartDate;
    }

    /**
     * Get the Proposal Id <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return proposalId
     */
    public int getProposalId() {
        return proposalId;
    }

    /**
     * Get the Sap Customer Name <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return sapCustomerName
     */
    public String getSapCustomerName() {
        return sapCustomerName;
    }

    /**
     * Get the Sap Customer No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return sapCustomerNo
     */
    public String getSapCustomerNo() {
        return sapCustomerNo;
    }

    /**
     * Get the ship to party address sequence no <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return shipToPartyASNo
     */
    public String getShipToPartyASNo() {
        return shipToPartyASNo;
    }

    /**
     * Get ship to party list no <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return shipToPartyLNo
     */
    public String getShipToPartyLNo() {
        return shipToPartyLNo;
    }

    /**
     * Get ship to party name <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return shipToPartyName
     */
    public String getShipToPartyName() {
        return shipToPartyName;
    }

    /**
     * Get ship to party No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return shipToPartyNo
     */
    public String getShipToPartyNo() {
        return shipToPartyNo;
    }

    /**
     * set Bill to party address sequence no <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param billToPartyASNo
     */
    public void setBillToPartyASNo(String iBillToPartyASNo) {
        billToPartyASNo = iBillToPartyASNo;
    }

    /**
     * Set bill to party List No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param billToPartyLNo
     */
    public void setBillToPartyLNo(String iBillToPartyLNo) {
        billToPartyLNo = iBillToPartyLNo;
    }

    /**
     * set bill to party name <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param billToPartyName
     */
    public void setBillToPartyName(String iBillToPartyName) {
        billToPartyName = iBillToPartyName;
    }

    /**
     * set bill to party no <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param billToPartyNo
     */
    public void setBillToPartyNo(String iBillToPartyNo) {
        billToPartyNo = iBillToPartyNo;
    }

    /**
     * set customer Address sequence no <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param custmerASNo
     */
    public void setCustmerASNo(String iCustmerASNo) {
        custmerASNo = iCustmerASNo;
    }

    /**
     * Set customer id <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param customerId
     */
    public void setCustomerId(int iCustomerId) {
        customerId = iCustomerId;
    }

    /**
     * Set Customer List No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param customerListNo
     */
    public void setCustomerListNo(String iCustomerListNo) {
        customerListNo = iCustomerListNo;
    }

    /**
     * Set Last updated date <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param lastUpdatedDate
     */
    public void setLastUpdatedDate(Date iLastUpdatedDate) {
        lastUpdatedDate = iLastUpdatedDate;
    }

    /**
     * Set Legacy customer no <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param legacyCustomerNo
     */
    public void setLegacyCustomerNo(String iLegacyCustomerNo) {
        legacyCustomerNo = iLegacyCustomerNo;
    }

    /**
     * Set Country Code <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date June 16, 2004 Added for EF0607044559 by Sara
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param countryCode
     */
    public void setCountryCode(String iCountryCode) {
        countryCode = iCountryCode;
    }

    /**
     * set Payer Address Sequence No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param payerASNo
     */
    public void setPayerASNo(String iPayerASNo) {
        payerASNo = iPayerASNo;
    }

    /**
     * set Payer List No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param payerLNo
     */
    public void setPayerLNo(String iPayerLNo) {
        payerLNo = iPayerLNo;
    }

    /**
     * Set Payer Name <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param payerName
     */
    public void setPayerName(String iPayerName) {
        payerName = iPayerName;
    }

    /**
     * Set the Payer No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param payerNo
     */
    public void setPayerNo(String iPayerNo) {
        payerNo = iPayerNo;
    }

    /**
     * Set Plan End date <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param planEndDate
     */
    public void setPlanEndDate(Date iPlanEndDate) {
        planEndDate = iPlanEndDate;
    }

    /**
     * Set Plan start date <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param planStartDate
     */
    public void setPlanStartDate(Date iPlanStartDate) {
        planStartDate = iPlanStartDate;
    }

    /**
     * set Proposal Id <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param proposalId
     */
    public void setProposalId(int iProposalId) {
        proposalId = iProposalId;
    }

    /**
     * set Sap Customer Name <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param sapCustomerName
     */
    public void setSapCustomerName(String iSapCustomerName) {
        sapCustomerName = iSapCustomerName;
    }

    /**
     * set Sap Customer No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param sapCustomerNo
     */
    public void setSapCustomerNo(String iSapCustomerNo) {
        sapCustomerNo = iSapCustomerNo;
    }

    /**
     * Set ship to party Address Sequence No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param shipToPartyASNo
     */
    public void setShipToPartyASNo(String iShipToPartyASNo) {
        shipToPartyASNo = iShipToPartyASNo;
    }

    /**
     * Set Ship to Part List No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param shipToPartyLNo
     */
    public void setShipToPartyLNo(String iShipToPartyLNo) {
        shipToPartyLNo = iShipToPartyLNo;
    }

    /**
     * set Ship to Party Name <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param shipToPartyName
     */
    public void setShipToPartyName(String iShipToPartyName) {
        shipToPartyName = iShipToPartyName;
    }

    /**
     * set Ship to Party No <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 21, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param shipToPartyNo
     */
    public void setShipToPartyNo(String iShipToPartyNo) {
        shipToPartyNo = iShipToPartyNo;
    }

    /**
     * Get the DM DTO list from Customer Domain DTO object
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 28, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return
     */
    public List getDMDTOList() {
        return iDMDTOList;
    }

    /**
     * 
     * Set the DM DTO list in Customer Domain DTO object
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 28, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param dmDTOList
     */
    public void setDMDTOList(List dmDTOList) {
        iDMDTOList = dmDTOList;
    }

    /**
     * Added for Batch Update
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Apr 27, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return
     * @author balajiv
     */

    public String getSQL() {

        StringBuffer bufferSQL = new StringBuffer();
        OPPTCalender cal = new OPPTCalender();

        bufferSQL
                .append("INSERT INTO BH.SOLDTOPARTY (SOLD_TO_PARTY_ID ,PROPOSAL_ID,CUSTOMER_LIST_NO,LEGACY_SOLD_P_NO,SAP_SOLD_TO_P_NO,SAP_SOLD_TO_P_NAME,BILL_TO_P_NO,BILL_TO_P_NAME,PAYER_NO,PAYER_NAME,SHIP_TO_P_NO,SHIP_TO_P_NAME,PLAN_START_DATE,PLAN_END_DATE,LAST_UPDATED_DATE,BILL_TO_P_LNO,PAYER_LNO,SHIP_TO_P_LNO,SOLD_TO_P_ASNO,BILL_TO_P_ASNO,PAYER_ASNO,SHIP_TO_P_ASNO) values ( ");
        bufferSQL.append(getCustomerId());
        bufferSQL.append(",");
        bufferSQL.append(getProposalId());
        bufferSQL.append(",'");
        bufferSQL.append(getCustomerListNo());
        bufferSQL.append("','");
        bufferSQL.append(getLegacyCustomerNo());
        bufferSQL.append("','");
        bufferSQL.append(getSapCustomerNo());
        bufferSQL.append("','");
        bufferSQL.append(getSapCustomerName());
        bufferSQL.append("','");
        bufferSQL.append(getBillToPartyNo());
        bufferSQL.append("','");
        bufferSQL.append(getBillToPartyName());
        bufferSQL.append("','");
        bufferSQL.append(getPayerNo());
        bufferSQL.append("','");
        bufferSQL.append(getPayerName());
        bufferSQL.append("','");
        bufferSQL.append(getShipToPartyNo());
        bufferSQL.append("','");
        bufferSQL.append(getShipToPartyName());
        bufferSQL.append("','");
        bufferSQL.append(cal.getDateString(getPlanStartDate()));
        bufferSQL.append("','");
        bufferSQL.append(cal.getDateString(getPlanEndDate()));
        bufferSQL.append("','");
        bufferSQL.append(cal.getDateString(getLastUpdatedDate()));
        bufferSQL.append("','");
        bufferSQL.append(getBillToPartyLNo());
        bufferSQL.append("','");
        bufferSQL.append(getPayerLNo());
        bufferSQL.append("','");
        bufferSQL.append(getShipToPartyLNo());
        bufferSQL.append("','");
        bufferSQL.append(getCustmerASNo());
        bufferSQL.append("','");
        bufferSQL.append(getBillToPartyASNo());
        bufferSQL.append("','");
        bufferSQL.append(getPayerASNo());
        bufferSQL.append("','");
        bufferSQL.append(getShipToPartyASNo());
        bufferSQL.append("' )");

        return formatSQL(bufferSQL.toString());
    }

 /*   protected void finalize() {
        if (null != iDMDTOList) {
            iDMDTOList.clear();
            iDMDTOList = null;
        }
    }*/

	/**
	 * @return Returns the soldToPartyNo.
	 */
	public String getSoldToPartyNo() {
		return soldToPartyNo;
	}
	/**
	 * @param soldToPartyNo The soldToPartyNo to set.
	 */
	public void setSoldToPartyNo(String soldToPartyNo) {
		this.soldToPartyNo = soldToPartyNo;
	}
}

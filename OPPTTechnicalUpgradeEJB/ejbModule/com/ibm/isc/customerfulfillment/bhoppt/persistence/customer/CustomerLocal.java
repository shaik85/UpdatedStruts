/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer;
/**
 * Local interface for Enterprise Bean: Customer
 */
public interface CustomerLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: customerListNo
	 */
	public java.lang.String getCustomerListNo();
	/**
	 * Set accessor for persistent attribute: customerListNo
	 */
	public void setCustomerListNo(java.lang.String newCustomerListNo);
	/**
	 * Get accessor for persistent attribute: legacyCustomerNo
	 */
	public java.lang.String getLegacyCustomerNo();
	/**
	 * Set accessor for persistent attribute: legacyCustomerNo
	 */
	public void setLegacyCustomerNo(java.lang.String newLegacyCustomerNo);
	/**
	 * Get accessor for persistent attribute: sapCustomerNo
	 */
	public java.lang.String getSapCustomerNo();
	/**
	 * Set accessor for persistent attribute: sapCustomerNo
	 */
	public void setSapCustomerNo(java.lang.String newSapCustomerNo);
	/**
	 * Get accessor for persistent attribute: billToPartyNo
	 */
	public java.lang.String getBillToPartyNo();
	/**
	 * Set accessor for persistent attribute: billToPartyNo
	 */
	public void setBillToPartyNo(java.lang.String newBillToPartyNo);
	/**
	 * Get accessor for persistent attribute: billToPartyName
	 */
	public java.lang.String getBillToPartyName();
	/**
	 * Set accessor for persistent attribute: billToPartyName
	 */
	public void setBillToPartyName(java.lang.String newBillToPartyName);
	/**
	 * Get accessor for persistent attribute: payerNo
	 */
	public java.lang.String getPayerNo();
	/**
	 * Set accessor for persistent attribute: payerNo
	 */
	public void setPayerNo(java.lang.String newPayerNo);
	/**
	 * Get accessor for persistent attribute: payerName
	 */
	public java.lang.String getPayerName();
	/**
	 * Set accessor for persistent attribute: payerName
	 */
	public void setPayerName(java.lang.String newPayerName);
	/**
	 * Get accessor for persistent attribute: shipToPartyName
	 */
	public java.lang.String getShipToPartyName();
	/**
	 * Set accessor for persistent attribute: shipToPartyName
	 */
	public void setShipToPartyName(java.lang.String newShipToPartyName);
	/**
	 * Get accessor for persistent attribute: shipToPartyNo
	 */
	public java.lang.String getShipToPartyNo();
	/**
	 * Set accessor for persistent attribute: shipToPartyNo
	 */
	public void setShipToPartyNo(java.lang.String newShipToPartyNo);
	/**
	 * Get accessor for persistent attribute: planEndDate
	 */
	public java.sql.Date getPlanEndDate();
	/**
	 * Set accessor for persistent attribute: planEndDate
	 */
	public void setPlanEndDate(java.sql.Date newPlanEndDate);
	/**
	 * Get accessor for persistent attribute: lastUpdatedDate
	 */
	public java.sql.Date getLastUpdatedDate();
	/**
	 * Set accessor for persistent attribute: lastUpdatedDate
	 */
	public void setLastUpdatedDate(java.sql.Date newLastUpdatedDate);
	/**
	 * Get accessor for persistent attribute: billToPartyLNo
	 */
	public java.lang.String getBillToPartyLNo();
	/**
	 * Set accessor for persistent attribute: billToPartyLNo
	 */
	public void setBillToPartyLNo(java.lang.String newBillToPartyLNo);
	/**
	 * Get accessor for persistent attribute: shipToPartyLNo
	 */
	public java.lang.String getShipToPartyLNo();
	/**
	 * Set accessor for persistent attribute: shipToPartyLNo
	 */
	public void setShipToPartyLNo(java.lang.String newShipToPartyLNo);
	/**
	 * Get accessor for persistent attribute: customerASNo
	 */
	public java.lang.String getCustomerASNo();
	/**
	 * Set accessor for persistent attribute: customerASNo
	 */
	public void setCustomerASNo(java.lang.String newCustomerASNo);
	/**
	 * Get accessor for persistent attribute: billToPartyASNo
	 */
	public java.lang.String getBillToPartyASNo();
	/**
	 * Set accessor for persistent attribute: billToPartyASNo
	 */
	public void setBillToPartyASNo(java.lang.String newBillToPartyASNo);
	/**
	 * Get accessor for persistent attribute: shipToPartyASNo
	 */
	public java.lang.String getShipToPartyASNo();
	/**
	 * Set accessor for persistent attribute: shipToPartyASNo
	 */
	public void setShipToPartyASNo(java.lang.String newShipToPartyASNo);
	/**
	 * Get accessor for persistent attribute: payerASNo
	 */
	public java.lang.String getPayerASNo();
	/**
	 * Set accessor for persistent attribute: payerASNo
	 */
	public void setPayerASNo(java.lang.String newPayerASNo);
	/**
	 * Get accessor for persistent attribute: sapCustomerName
	 */
	public java.lang.String getSapCustomerName();
	/**
	 * Set accessor for persistent attribute: sapCustomerName
	 */
	public void setSapCustomerName(java.lang.String newSapCustomerName);
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: customerId
	 */
	public int getCustomerId();
	/**
	 * Set accessor for persistent attribute: customerId
	 */
	public void setCustomerId(int newCustomerId);
	/**
	 * Get accessor for persistent attribute: planStartDate
	 */
	public java.sql.Date getPlanStartDate();
	/**
	 * Set accessor for persistent attribute: planStartDate
	 */
	public void setPlanStartDate(java.sql.Date newPlanStartDate);
	/**
	 * Get accessor for persistent attribute: payerLNo
	 */
	public java.lang.String getPayerLNo();
	/**
	 * Set accessor for persistent attribute: payerLNo
	 */
	public void setPayerLNo(java.lang.String newPayerLNo);
	/**
	 * Get accessor for persistent attribute: countryCode
	 */
	public java.lang.String getCountryCode();
	/**
	 * Set accessor for persistent attribute: countryCode
	 */
	public void setCountryCode(java.lang.String newCountryCode);
}

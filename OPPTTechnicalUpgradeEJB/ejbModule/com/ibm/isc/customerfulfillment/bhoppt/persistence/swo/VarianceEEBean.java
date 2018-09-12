/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Bean implementation class for Enterprise Bean: VarianceEE
 */
public abstract class VarianceEEBean implements javax.ejb.EntityBean {
	
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey ejbCreate(
		int eeId,
		int swoId,
		int dmId,
		int customerId,
		int proposalId,String eeNo)
		throws javax.ejb.CreateException {
		setEeId(eeId);
		setSwoId(swoId);
		setDmId(dmId);
		setCustomerId(customerId);
		setProposalId(proposalId);
		setEeNo(eeNo);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		int eeId,
		int swoId,
		int dmId,
		int customerId,
		int proposalId,String eeNo)
		throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: eeId
	 */
	public abstract int getEeId();
	/**
	 * Set accessor for persistent attribute: eeId
	 */
	public abstract void setEeId(int newEeId);
	/**
	 * Get accessor for persistent attribute: swoId
	 */
	public abstract int getSwoId();
	/**
	 * Set accessor for persistent attribute: swoId
	 */
	public abstract void setSwoId(int newSwoId);
	/**
	 * Get accessor for persistent attribute: dmId
	 */
	public abstract int getDmId();
	/**
	 * Set accessor for persistent attribute: dmId
	 */
	public abstract void setDmId(int newDmId);
	/**
	 * Get accessor for persistent attribute: customerId
	 */
	public abstract int getCustomerId();
	/**
	 * Set accessor for persistent attribute: customerId
	 */
	public abstract void setCustomerId(int newCustomerId);
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public abstract int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public abstract void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: salesDocNo
	 */
	public abstract java.lang.String getSalesDocNo();
	/**
	 * Set accessor for persistent attribute: salesDocNo
	 */
	public abstract void setSalesDocNo(java.lang.String newSalesDocNo);
	/**
	 * Get accessor for persistent attribute: eeItemNo
	 */
	public abstract java.lang.String getEeItemNo();
	/**
	 * Set accessor for persistent attribute: eeItemNo
	 */
	public abstract void setEeItemNo(java.lang.String newEeItemNo);
	/**
	 * Get accessor for persistent attribute: swoItemNo
	 */
	public abstract java.lang.String getSwoItemNo();
	/**
	 * Set accessor for persistent attribute: swoItemNo
	 */
	public abstract void setSwoItemNo(java.lang.String newSwoItemNo);
	/**
	 * Get accessor for persistent attribute: eeNo
	 */
	public abstract java.lang.String getEeNo();
	/**
	 * Set accessor for persistent attribute: eeNo
	 */
	public abstract void setEeNo(java.lang.String newEeNo);
	/**
	 * Get accessor for persistent attribute: eeDesc
	 */
	public abstract java.lang.String getEeDesc();
	/**
	 * Set accessor for persistent attribute: eeDesc
	 */
	public abstract void setEeDesc(java.lang.String newEeDesc);
	/**
	 * Get accessor for persistent attribute: valueMetric
	 */
	public abstract java.lang.String getValueMetric();
	/**
	 * Set accessor for persistent attribute: valueMetric
	 */
	public abstract void setValueMetric(java.lang.String newValueMetric);
	/**
	 * Get accessor for persistent attribute: useLevel
	 */
	public abstract java.lang.String getUseLevel();
	/**
	 * Set accessor for persistent attribute: useLevel
	 */
	public abstract void setUseLevel(java.lang.String newUseLevel);
	/**
	 * Get accessor for persistent attribute: licenseType
	 */
	public abstract java.lang.String getLicenseType();
	/**
	 * Set accessor for persistent attribute: licenseType
	 */
	public abstract void setLicenseType(java.lang.String newLicenseType);
	/**
	 * Get accessor for persistent attribute: eswPrice
	 */
	public abstract double getEswPrice();
	/**
	 * Set accessor for persistent attribute: eswPrice
	 */
	public abstract void setEswPrice(double newEswPrice);
	/**
	 * Get accessor for persistent attribute: sequenceNo
	 */
	public abstract int getSequenceNo();
	/**
	 * Set accessor for persistent attribute: sequenceNo
	 */
	public abstract void setSequenceNo(int newSequenceNo);
	/**
	 * Get accessor for persistent attribute: chargeOption
	 */
	public abstract java.lang.String getChargeOption();
	/**
	 * Set accessor for persistent attribute: chargeOption
	 */
	public abstract void setChargeOption(java.lang.String newChargeOption);
	/**
	 * Get accessor for persistent attribute: chargeOptionDesc
	 */
	public abstract java.lang.String getChargeOptionDesc();
	/**
	 * Set accessor for persistent attribute: chargeOptionDesc
	 */
	public abstract void setChargeOptionDesc(
		java.lang.String newChargeOptionDesc);
}

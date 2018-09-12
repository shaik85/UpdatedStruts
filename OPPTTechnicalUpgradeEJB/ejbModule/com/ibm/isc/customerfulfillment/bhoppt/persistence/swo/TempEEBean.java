/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Bean implementation class for Enterprise Bean: TempEE
 */
public abstract class TempEEBean implements javax.ejb.EntityBean {
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey ejbCreate(
		int proposalId,
		int customerId,
		int dmId)
		throws javax.ejb.CreateException {
		setProposalId(proposalId);
		setCustomerId(customerId);
		setDmId(dmId);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int proposalId, int customerId, int dmId)
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
	 * Get accessor for persistent attribute: proposalId
	 */
	public abstract int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public abstract void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: customerId
	 */
	public abstract int getCustomerId();
	/**
	 * Set accessor for persistent attribute: customerId
	 */
	public abstract void setCustomerId(int newCustomerId);
	/**
	 * Get accessor for persistent attribute: dmId
	 */
	public abstract int getDmId();
	/**
	 * Set accessor for persistent attribute: dmId
	 */
	public abstract void setDmId(int newDmId);
	/**
	 * Get accessor for persistent attribute: sessionId
	 */
	public abstract java.lang.String getSessionId();
	/**
	 * Set accessor for persistent attribute: sessionId
	 */
	public abstract void setSessionId(java.lang.String newSessionId);
	/**
	 * Get accessor for persistent attribute: swoId
	 */
	public abstract int getSwoId();
	/**
	 * Set accessor for persistent attribute: swoId
	 */
	public abstract void setSwoId(int newSwoId);
	/**
	 * Get accessor for persistent attribute: eeId
	 */
	public abstract int getEeId();
	/**
	 * Set accessor for persistent attribute: eeId
	 */
	public abstract void setEeId(int newEeId);
	/**
	 * Get accessor for persistent attribute: eeNo
	 */
	public abstract java.lang.String getEeNo();
	/**
	 * Set accessor for persistent attribute: eeNo
	 */
	public abstract void setEeNo(java.lang.String newEeNo);
	/**
	 * Get accessor for persistent attribute: salesDocNo
	 */
	public abstract java.lang.String getSalesDocNo();
	/**
	 * Set accessor for persistent attribute: salesDocNo
	 */
	public abstract void setSalesDocNo(java.lang.String newSalesDocNo);
	/**
	 * Get accessor for persistent attribute: swoItemNo
	 */
	public abstract java.lang.String getSwoItemNo();
	/**
	 * Set accessor for persistent attribute: swoItemNo
	 */
	public abstract void setSwoItemNo(java.lang.String newSwoItemNo);
	/**
	 * Get accessor for persistent attribute: eeItemNo
	 */
	public abstract java.lang.String getEeItemNo();
	/**
	 * Set accessor for persistent attribute: eeItemNo
	 */
	public abstract void setEeItemNo(java.lang.String newEeItemNo);
	/**
	 * Get accessor for persistent attribute: valueMetric
	 */
	public abstract java.lang.String getValueMetric();
	/**
	 * Set accessor for persistent attribute: valueMetric
	 */
	public abstract void setValueMetric(java.lang.String newValueMetric);
	/**
	 * Get accessor for persistent attribute: licenseType
	 */
	public abstract java.lang.String getLicenseType();
	/**
	 * Set accessor for persistent attribute: licenseType
	 */
	public abstract void setLicenseType(java.lang.String newLicenseType);
	/**
	 * Get accessor for persistent attribute: chargeOptionDesc
	 */
	public abstract java.lang.String getChargeOptionDesc();
	/**
	 * Set accessor for persistent attribute: chargeOptionDesc
	 */
	public abstract void setChargeOptionDesc(
		java.lang.String newChargeOptionDesc);
	/**
	 * Get accessor for persistent attribute: useLevel
	 */
	public abstract java.lang.String getUseLevel();
	/**
	 * Set accessor for persistent attribute: useLevel
	 */
	public abstract void setUseLevel(java.lang.String newUseLevel);
	/**
	 * Get accessor for persistent attribute: validInd
	 */
	public abstract java.lang.String getValidInd();
	/**
	 * Set accessor for persistent attribute: validInd
	 */
	public abstract void setValidInd(java.lang.String newValidInd);
	/**
	 * Get accessor for persistent attribute: valueMetricType
	 */
	public abstract java.lang.String getValueMetricType();
	/**
	 * Set accessor for persistent attribute: valueMetricType
	 */
	public abstract void setValueMetricType(
		java.lang.String newValueMetricType);
	/**
	 * Get accessor for persistent attribute: vm
	 */
	public abstract java.lang.String getVm();
	/**
	 * Set accessor for persistent attribute: vm
	 */
	public abstract void setVm(java.lang.String newVm);
	/**
	 * Get accessor for persistent attribute: lcs
	 */
	public abstract java.lang.String getLcs();
	/**
	 * Set accessor for persistent attribute: lcs
	 */
	public abstract void setLcs(java.lang.String newLcs);
	/**
	 * Get accessor for persistent attribute: cho
	 */
	public abstract java.lang.String getCho();
	/**
	 * Set accessor for persistent attribute: cho
	 */
	public abstract void setCho(java.lang.String newCho);
	/**
	 * Get accessor for persistent attribute: ul
	 */
	public abstract java.lang.String getUl();
	/**
	 * Set accessor for persistent attribute: ul
	 */
	public abstract void setUl(java.lang.String newUl);
	/**
	 * Get accessor for persistent attribute: defaultFlag
	 */
	public abstract java.lang.String getDefaultFlag();
	/**
	 * Set accessor for persistent attribute: defaultFlag
	 */
	public abstract void setDefaultFlag(java.lang.String newDefaultFlag);
}

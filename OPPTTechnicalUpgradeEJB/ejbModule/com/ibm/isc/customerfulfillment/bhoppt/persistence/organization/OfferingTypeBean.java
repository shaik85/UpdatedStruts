
//OPPT BH -DAD001-SRINIVAS
/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: OfferingType
 */
public abstract class OfferingTypeBean implements javax.ejb.EntityBean {
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey ejbCreate(
		java.lang.String offeringType,
		java.lang.String offeringDesc) throws javax.ejb.CreateException {
		setOfferingType(offeringType);
		setOfferingDesc(offeringDesc);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String offeringType,
		java.lang.String offeringDesc) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: offeringType
	 */
	public abstract java.lang.String getOfferingType();
	/**
	 * Set accessor for persistent attribute: offeringType
	 */
	public abstract void setOfferingType(java.lang.String newOfferingType);
	/**
	 * Get accessor for persistent attribute: offeringDesc
	 */
	public abstract java.lang.String getOfferingDesc();
	/**
	 * Set accessor for persistent attribute: offeringDesc
	 */
	public abstract void setOfferingDesc(java.lang.String newOfferingDesc);
	/**
	 * Get accessor for persistent attribute: tvmAllowed
	 */
	public abstract java.lang.String getTvmAllowed();
	/**
	 * Set accessor for persistent attribute: tvmAllowed
	 */
	public abstract void setTvmAllowed(java.lang.String newTvmAllowed);
	/**
	 * Get accessor for persistent attribute: specialRateInd
	 */
	public abstract java.lang.String getSpecialRateInd();
	/**
	 * Set accessor for persistent attribute: specialRateInd
	 */
	public abstract void setSpecialRateInd(java.lang.String newSpecialRateInd);
	/**
	 * Get accessor for persistent attribute: annivContractAmtInd
	 */
	public abstract java.lang.String getAnnivContractAmtInd();
	/**
	 * Set accessor for persistent attribute: annivContractAmtInd
	 */
	public abstract void setAnnivContractAmtInd(
		java.lang.String newAnnivContractAmtInd);
	/**
	 * Get accessor for persistent attribute: duration
	 */
	public abstract int getDuration();
	/**
	 * Set accessor for persistent attribute: duration
	 */
	public abstract void setDuration(int newDuration);
}

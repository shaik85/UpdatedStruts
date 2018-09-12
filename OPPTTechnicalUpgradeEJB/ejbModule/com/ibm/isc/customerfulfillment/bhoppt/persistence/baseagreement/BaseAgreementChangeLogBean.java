/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Bean implementation class for Enterprise Bean: BaseAgreementChangeLog
 */
public abstract class BaseAgreementChangeLogBean
	implements
		javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 * @param ctx
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 * @return EntityContext
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
	 * @param changeId
	 * @param agreementId
	 * @return BaseAgreementChangeLogKey
	 * @throws CreateException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey ejbCreate(
			java.lang.Integer changeId,java.lang.Integer agreementId) throws javax.ejb.CreateException {
			setChangeId(changeId);
			setAgreementId(agreementId);
			return null;
		}
	/**
	 * ejbPostCreate
	 * @param changeId
	 * @param agreementId
	 * @throws CreateException
	 */
	public void ejbPostCreate(java.lang.Integer changeId,java.lang.Integer agreementId)
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
	 * @throws RemoveException
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: changeId
	 * @return Integer
	 */
	public abstract java.lang.Integer getChangeId();
	/**
	 * Set accessor for persistent attribute: changeId
	 * @param newChangeId
	 */
	public abstract void setChangeId(java.lang.Integer newChangeId);
	/**
	 * Get accessor for persistent attribute: agreementId
	 * @return Integer
	 */
	public abstract java.lang.Integer getAgreementId();
	/**
	 * Set accessor for persistent attribute: agreementId
	 * @param newAgreementId
	 */
	public abstract void setAgreementId(java.lang.Integer newAgreementId);
	/**
	 * Get accessor for persistent attribute: createdBy
	 * @return String
	 */
	public abstract java.lang.String getCreatedBy();
	/**
	 * Set accessor for persistent attribute: createdBy
	 * @param newCreatedBy
	 */
	public abstract void setCreatedBy(java.lang.String newCreatedBy);
	/**
	 * Get accessor for persistent attribute: changedDate
	 * @return Date
	 */
	public abstract java.sql.Date getChangedDate();
	/**
	 * Set accessor for persistent attribute: changedDate
	 * @param newChangedDate
	 */
	public abstract void setChangedDate(java.sql.Date newChangedDate);
	/**
	 * Get accessor for persistent attribute: changedTime
	 * @return java.sql.Time
	 */
	public abstract java.sql.Time getChangedTime();
	/**
	 * Set accessor for persistent attribute: changedTime
	 * @param newChangedTime
	 */
	public abstract void setChangedTime(java.sql.Time newChangedTime);
	/**
	 * Get accessor for persistent attribute: changedDetails
	 * @return String
	 */
	public abstract java.lang.String getChangedDetails();
	/**
	 * Set accessor for persistent attribute: changedDetails
	 * @param newChangedDetails
	 */
	public abstract void setChangedDetails(java.lang.String newChangedDetails);
}

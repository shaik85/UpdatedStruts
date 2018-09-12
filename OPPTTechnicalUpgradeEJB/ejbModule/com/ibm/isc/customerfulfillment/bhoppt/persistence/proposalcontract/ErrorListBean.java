/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Bean implementation class for Enterprise Bean: ErrorList
 */
public abstract class ErrorListBean implements javax.ejb.EntityBean {
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
	public java.lang.Integer ejbCreate(java.lang.Integer messageId,int proposalId)
		throws javax.ejb.CreateException {
		setMessageId(messageId);
		setProposalId(proposalId);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer messageId, int proposalId)
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
	 * Get accessor for persistent attribute: messageId
	 */
	public abstract java.lang.Integer getMessageId();
	/**
	 * Set accessor for persistent attribute: messageId
	 */
	public abstract void setMessageId(java.lang.Integer newMessageId);
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public abstract int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public abstract void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: messageNO
	 */
	public abstract double getMessageNO();
	/**
	 * Set accessor for persistent attribute: messageNO
	 */
	public abstract void setMessageNO(double newMessageNO);
	/**
	 * Get accessor for persistent attribute: className
	 */
	public abstract java.lang.String getClassName();
	/**
	 * Set accessor for persistent attribute: className
	 */
	public abstract void setClassName(java.lang.String newClassName);
	/**
	 * Get accessor for persistent attribute: methodName
	 */
	public abstract java.lang.String getMethodName();
	/**
	 * Set accessor for persistent attribute: methodName
	 */
	public abstract void setMethodName(java.lang.String newMethodName);
	/**
	 * Get accessor for persistent attribute: messageDesc
	 */
	public abstract java.lang.String getMessageDesc();
	/**
	 * Set accessor for persistent attribute: messageDesc
	 */
	public abstract void setMessageDesc(java.lang.String newMessageDesc);
	/**
	 * Get accessor for persistent attribute: messageDetail
	 */
	public abstract java.lang.String getMessageDetail();
	/**
	 * Set accessor for persistent attribute: messageDetail
	 */
	public abstract void setMessageDetail(java.lang.String newMessageDetail);
	/**
	 * Get accessor for persistent attribute: userId
	 */
	public abstract java.lang.String getUserId();
	/**
	 * Set accessor for persistent attribute: userId
	 */
	public abstract void setUserId(java.lang.String newUserId);
	/**
	 * Get accessor for persistent attribute: date
	 */
	public abstract java.sql.Date getDate();
	/**
	 * Set accessor for persistent attribute: date
	 */
	public abstract void setDate(java.sql.Date newDate);
	/**
	 * Get accessor for persistent attribute: time
	 */
	public abstract java.sql.Time getTime();
	/**
	 * Set accessor for persistent attribute: time
	 */
	public abstract void setTime(java.sql.Time newTime);
}

/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Bean implementation class for Enterprise Bean: BaseAgreementFormBean
 */
public abstract class BaseAgreementFormBeanBean implements javax.ejb.EntityBean {
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
	 * @return BaseAgreementFormBeanKey
	 * @param formNumber
	 * @throws CreateException
	 *
	 *	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBeanKey ejbCreate(
		java.lang.String formNumber) throws javax.ejb.CreateException {
		setFormNumber(formNumber);
		return null;
	}
	/**
	 * ejbPostCreate
	 * @param formNumber
	 */
	public void ejbPostCreate(java.lang.String formNumber)
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
	 * Get accessor for persistent attribute: formNumber
	 * @return String
	 */
	public abstract java.lang.String getFormNumber();
	/**
	 * Set accessor for persistent attribute: formNumber
	 * @param newFormNumber
	 */
	public abstract void setFormNumber(java.lang.String newFormNumber);
	/**
	 * Get accessor for persistent attribute: formLongDescription
	 * @return String
	 */
	public abstract java.lang.String getFormLongDescription();
	/**
	 * Set accessor for persistent attribute: formLongDescription
	 * @param newFormLongDescription
	 */
	public abstract void setFormLongDescription(
		java.lang.String newFormLongDescription);
	/**
	 * Get accessor for persistent attribute: formShortDescription
	 * @return String
	 */
	public abstract java.lang.String getFormShortDescription();
	/**
	 * Set accessor for persistent attribute: formShortDescription
	 * @param newFormShortDescription
	 */
	public abstract void setFormShortDescription(
		java.lang.String newFormShortDescription);
}

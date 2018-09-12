/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Bean implementation class for Enterprise Bean: CustomerList
 */
public abstract class CustomerListBean implements javax.ejb.EntityBean
{
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx)
	{
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext()
	{
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext()
	{
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey ejbCreate(
		int proposalId,
		java.lang.String customerListNo)
		throws javax.ejb.CreateException
	{
		setProposalId(proposalId);
		setCustomerListNo(customerListNo);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int proposalId, java.lang.String customerListNo) throws javax.ejb.CreateException
	{
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate()
	{
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad()
	{
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate()
	{
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException
	{
	}
	/**
	 * ejbStore
	 */
	public void ejbStore()
	{
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
	 * Get accessor for persistent attribute: customerListNo
	 */
	public abstract java.lang.String getCustomerListNo();
	/**
	 * Set accessor for persistent attribute: customerListNo
	 */
	public abstract void setCustomerListNo(java.lang.String newCustomerListNo);
	/**
	 * Get accessor for persistent attribute: customerListName
	 */
	public abstract java.lang.String getCustomerListName();
	/**
	 * Set accessor for persistent attribute: customerListName
	 */
	public abstract void setCustomerListName(java.lang.String newCustomerListName);
	/**
	 * Get accessor for persistent attribute: lastUpdatedDate
	 */
	public abstract java.sql.Date getLastUpdatedDate();
	/**
	 * Set accessor for persistent attribute: lastUpdatedDate
	 */
	public abstract void setLastUpdatedDate(java.sql.Date newLastUpdatedDate);
}

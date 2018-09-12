/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: Group
 */
public abstract class GroupBean implements javax.ejb.EntityBean
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
	public java.lang.String ejbCreate(java.lang.String groupName) throws javax.ejb.CreateException
	{
		setGroupName(groupName);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String groupName)throws javax.ejb.CreateException
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
	 * Get accessor for persistent attribute: groupName
	 */
	public abstract java.lang.String getGroupName();
	/**
	 * Set accessor for persistent attribute: groupName
	 */
	public abstract void setGroupName(java.lang.String newGroupName);
	/**
	 * Get accessor for persistent attribute: salesOrg
	 */
	public abstract java.lang.String getSalesOrg();
	/**
	 * Set accessor for persistent attribute: salesOrg
	 */
	public abstract void setSalesOrg(java.lang.String newSalesOrg);
}

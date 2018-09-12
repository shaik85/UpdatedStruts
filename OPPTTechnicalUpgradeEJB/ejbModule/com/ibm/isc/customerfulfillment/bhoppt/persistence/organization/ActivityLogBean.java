/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: ActivityLog
 */
public abstract class ActivityLogBean implements javax.ejb.EntityBean
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
	 * Get accessor for persistent attribute: message
	 */
	public abstract java.lang.String getMessage();
	/**
	 * Set accessor for persistent attribute: message
	 */
	public abstract void setMessage(java.lang.String newMessage);
	/**
	 * Get accessor for persistent attribute: ActivityDate
	 */
	public abstract java.sql.Date getActivityDate();
	/**
	 * Set accessor for persistent attribute: ActivityDate
	 */
	public abstract void setActivityDate(java.sql.Date newActivityDate);
	/**
	 * Get accessor for persistent attribute: ActivityTime
	 */
	public abstract java.sql.Time getActivityTime();
	/**
	 * Set accessor for persistent attribute: ActivityTime
	 */
	public abstract void setActivityTime(java.sql.Time newActivityTime);
	/**
	 * ejbCreate
	 */
	
	/**
	 * Get accessor for persistent attribute: userId
	 */
	public abstract java.lang.String getUserId();
	/**
	 * Set accessor for persistent attribute: userId
	 */
	public abstract void setUserId(java.lang.String newUserId);
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey ejbCreate(
		java.lang.String userId,
		java.sql.Date activityDate,java.sql.Time activityTime) throws javax.ejb.CreateException {
		setUserId(userId);
		setActivityTime(activityTime);
		setActivityDate(activityDate);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String userId,
		java.sql.Date activityDate,
		java.sql.Time activityTime) throws javax.ejb.CreateException {
	}
	}
/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: UserProfile
 */
public abstract class UserProfileBean implements javax.ejb.EntityBean {
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
	public java.lang.String ejbCreate(java.lang.String userId, String role)
		throws javax.ejb.CreateException {
		setUserId(userId);
		setRole(role);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String userId, String role)
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
	 * Get accessor for persistent attribute: userId
	 */
	public abstract java.lang.String getUserId();
	/**
	 * Set accessor for persistent attribute: userId
	 */
	public abstract void setUserId(java.lang.String newUserId);
	/**
	 * Get accessor for persistent attribute: role
	 */
	public abstract java.lang.String getRole();
	/**
	 * Set accessor for persistent attribute: role
	 */
	public abstract void setRole(java.lang.String newRole);
	/**
	 * Get accessor for persistent attribute: assoSalesOrg
	 */
	public abstract java.lang.String getAssoSalesOrg();
	/**
	 * Set accessor for persistent attribute: assoSalesOrg
	 */
	public abstract void setAssoSalesOrg(java.lang.String newAssoSalesOrg);
	/**
	 * Get accessor for persistent attribute: authorization
	 */
	public abstract java.lang.String getAuthorization();
	/**
	 * Set accessor for persistent attribute: authorization
	 */
	public abstract void setAuthorization(java.lang.String newAuthorization);
	/**
	 * Get accessor for persistent attribute: approverId
	 */
	public abstract java.lang.String getApproverId();
	/**
	 * Set accessor for persistent attribute: approverId
	 */
	public abstract void setApproverId(java.lang.String newApproverId);
	/**
	 * Get accessor for persistent attribute: groupName
	 */
	public abstract java.lang.String getGroupName();
	/**
	 * Set accessor for persistent attribute: groupName
	 */
	public abstract void setGroupName(java.lang.String newGroupName);
	/**
	 * Get accessor for persistent attribute: bpAccessIndicator
	 */
	public abstract java.lang.String getBpAccessIndicator();
	/**
	 * Set accessor for persistent attribute: bpAccessIndicator
	 */
	public abstract void setBpAccessIndicator(
		java.lang.String newBpAccessIndicator);
	/**
	 * Get accessor for persistent attribute: lastLoginDate
	 */
	public abstract java.sql.Date getLastLoginDate();
	/**
	 * Set accessor for persistent attribute: lastLoginDate
	 */
	public abstract void setLastLoginDate(java.sql.Date newLastLoginDate);
	/**
	 * Get accessor for persistent attribute: firstName
	 */
	public abstract java.lang.String getFirstName();
	/**
	 * Set accessor for persistent attribute: firstName
	 */
	public abstract void setFirstName(java.lang.String newFirstName);
	/**
	 * Get accessor for persistent attribute: lastName
	 */
	public abstract java.lang.String getLastName();
	/**
	 * Set accessor for persistent attribute: lastName
	 */
	public abstract void setLastName(java.lang.String newLastName);
	/**
	 * Get accessor for persistent attribute: userType
	 */
	public abstract java.lang.String getUserType();
	/**
	 * Set accessor for persistent attribute: userType
	 */
	public abstract void setUserType(java.lang.String newUserType);
	/**
	 * Get accessor for persistent attribute: BARole
	 */
	public abstract java.lang.String getBaRole();
	/**
	 * Set accessor for persistent attribute: BARole
	 */
	public abstract void setBaRole(java.lang.String newBARole);
}

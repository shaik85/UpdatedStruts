/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: Role
 */
public abstract class RoleBean implements javax.ejb.EntityBean {
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
	public java.lang.String ejbCreate(java.lang.String role)
		throws javax.ejb.CreateException {
		setRole(role);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String role)
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
	 * Get accessor for persistent attribute: role
	 */
	public abstract java.lang.String getRole();
	/**
	 * Set accessor for persistent attribute: role
	 */
	public abstract void setRole(java.lang.String newRole);
	/**
	 * Get accessor for persistent attribute: roleDesc
	 */
	public abstract java.lang.String getRoleDesc();
	/**
	 * Set accessor for persistent attribute: roleDesc
	 */
	public abstract void setRoleDesc(java.lang.String newRoleDesc);
	/**
	 * Get accessor for persistent attribute: active
	 */
	public abstract java.lang.String getActive();
	/**
	 * Set accessor for persistent attribute: active
	 */
	public abstract void setActive(java.lang.String newActive);
}

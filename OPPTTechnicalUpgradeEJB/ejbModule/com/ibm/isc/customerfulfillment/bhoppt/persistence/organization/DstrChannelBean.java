/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: DstrChannel
 */
public abstract class DstrChannelBean implements javax.ejb.EntityBean {
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey ejbCreate(
		java.lang.String distributionChannel,
		java.lang.String salesGroup,
		java.lang.String channelRole,
		java.lang.String submitterRole) throws javax.ejb.CreateException {
		setDistributionChannel(distributionChannel);
		setSalesGroup(salesGroup);
		setChannelRole(channelRole);
		setSubmitterRole(submitterRole);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String distributionChannel,
		java.lang.String salesGroup,
		java.lang.String channelRole,
		java.lang.String submitterRole) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: distributionChannel
	 */
	public abstract java.lang.String getDistributionChannel();
	/**
	 * Set accessor for persistent attribute: distributionChannel
	 */
	public abstract void setDistributionChannel(
		java.lang.String newDistributionChannel);
	/**
	 * Get accessor for persistent attribute: distributionChannelDesc
	 */
	public abstract java.lang.String getDistributionChannelDesc();
	/**
	 * Set accessor for persistent attribute: distributionChannelDesc
	 */public abstract void setDistributionChannelDesc(java.lang.String newDistributionChannelDesc);
	/**
	 * Get accessor for persistent attribute: salesGroup
	 */
	public abstract java.lang.String getSalesGroup();
	/**
	 * Set accessor for persistent attribute: salesGroup
	 */
	public abstract void setSalesGroup(java.lang.String newSalesGroup);
	/**
	 * Get accessor for persistent attribute: channelRole
	 */
	public abstract java.lang.String getChannelRole();
	/**
	 * Set accessor for persistent attribute: channelRole
	 */
	public abstract void setChannelRole(java.lang.String newChannelRole);
	/**
	 * Get accessor for persistent attribute: submitterRole
	 */
	public abstract java.lang.String getSubmitterRole();
	/**
	 * Set accessor for persistent attribute: submitterRole
	 */
	public abstract void setSubmitterRole(java.lang.String newSubmitterRole);
}

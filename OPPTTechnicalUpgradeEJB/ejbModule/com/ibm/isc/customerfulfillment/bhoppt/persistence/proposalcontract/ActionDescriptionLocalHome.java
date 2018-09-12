package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

/*
  Created on Dec 30, 2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * Local Home interface for Enterprise Bean: ActionDescription
 */
public interface ActionDescriptionLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: ActionDescription
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ActionDescriptionLocal create(
		java.lang.String actionDescription)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: ActionDescription
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract
		.ActionDescriptionLocal findByPrimaryKey(
		java.lang.String primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllActions()
		throws javax.ejb.FinderException;
}

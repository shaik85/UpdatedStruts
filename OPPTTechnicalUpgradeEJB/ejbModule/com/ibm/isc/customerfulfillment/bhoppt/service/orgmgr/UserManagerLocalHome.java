/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;
/**
 * Local Home interface for Enterprise Bean: UserManager
 */
public interface UserManagerLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates a default instance of Session Bean: UserManager
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerLocal create()
		throws javax.ejb.CreateException;
}

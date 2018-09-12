/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;
/**
 * Local Home interface for Enterprise Bean: GroupManager
 */
public interface GroupManagerLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates a default instance of Session Bean: GroupManager
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManagerLocal create()
		throws javax.ejb.CreateException;
}

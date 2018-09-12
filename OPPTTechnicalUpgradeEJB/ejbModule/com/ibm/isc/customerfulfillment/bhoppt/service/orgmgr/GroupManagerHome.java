/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;
/**
 * Home interface for Enterprise Bean: GroupManager
 */
public interface GroupManagerHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: GroupManager
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManager create()
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}

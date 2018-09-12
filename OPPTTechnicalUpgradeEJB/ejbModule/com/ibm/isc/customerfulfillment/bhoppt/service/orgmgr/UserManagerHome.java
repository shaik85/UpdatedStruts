/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;
/**
 * Home interface for Enterprise Bean: UserManager
 */
public interface UserManagerHome extends javax.ejb.EJBHome 
{
	/**
	 * Creates a default instance of Session Bean: UserManager
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManager create()	throws javax.ejb.CreateException, java.rmi.RemoteException;
}

/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.service.swomgr;
/**
 * Local Home interface for Enterprise Bean: SWOManager
 */
public interface SWOManagerLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates a default instance of Session Bean: SWOManager
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocal create()
		throws javax.ejb.CreateException;
}

/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr;
/**
 * Home interface for Enterprise Bean: ReportManager
 */
public interface ReportManagerHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: ReportManager
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManager create()
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}

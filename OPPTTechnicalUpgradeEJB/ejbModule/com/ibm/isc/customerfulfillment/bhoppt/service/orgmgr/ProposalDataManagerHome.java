/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;

/**
 * Home interface for Enterprise Bean: ProposalDataManager
 */
public interface ProposalDataManagerHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: ProposalDataManager
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManager create()
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}

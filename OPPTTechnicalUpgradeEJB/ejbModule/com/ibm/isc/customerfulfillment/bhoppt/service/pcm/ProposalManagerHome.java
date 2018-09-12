/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;
/**
 * Home interface for Enterprise Bean: ProposalManager
 */
public interface ProposalManagerHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: ProposalManager
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManager create()
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}

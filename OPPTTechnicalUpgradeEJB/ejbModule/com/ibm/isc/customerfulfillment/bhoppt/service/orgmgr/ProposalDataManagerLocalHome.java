/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;
/**
 * Local Home interface for Enterprise Bean: ProposalDataManager
 */
public interface ProposalDataManagerLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates a default instance of Session Bean: ProposalDataManager
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr
		.ProposalDataManagerLocal create() throws javax.ejb.CreateException;
}

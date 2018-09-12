/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;
/**
 * Home interface for Enterprise Bean: BaseAgreementManager
 */
public interface BaseAgreementManagerHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: BaseAgreementManager
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManager create()
		throws javax.ejb.CreateException,
		java.rmi.RemoteException;
}

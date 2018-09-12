/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.invmgr;
/**
 * Local Home interface for Enterprise Bean: PriceManager
 */
public interface PriceManagerLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates a default instance of Session Bean: PriceManager
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.PriceManagerLocal create()
		throws javax.ejb.CreateException;
}

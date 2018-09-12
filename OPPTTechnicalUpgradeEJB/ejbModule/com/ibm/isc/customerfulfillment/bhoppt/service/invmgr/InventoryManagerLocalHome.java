/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.service.invmgr;
/**
 * Local Home interface for Enterprise Bean: InventoryManager
 */
public interface InventoryManagerLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates a default instance of Session Bean: InventoryManager
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerLocal create()
		throws javax.ejb.CreateException;
}

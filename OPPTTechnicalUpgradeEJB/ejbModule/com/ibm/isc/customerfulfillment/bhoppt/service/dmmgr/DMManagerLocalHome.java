/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr;


/**
 * Local Home interface for Enterprise Bean: DMManager
 *
 * @version 
 */
public interface DMManagerLocalHome extends javax.ejb.EJBLocalHome {
	/**
     * Creates a default instance of Session Bean: DMManager
     *
     * @return
     * @exception javax.ejb.CreateException
     */
	public com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerLocal create()
		throws javax.ejb.CreateException;
}

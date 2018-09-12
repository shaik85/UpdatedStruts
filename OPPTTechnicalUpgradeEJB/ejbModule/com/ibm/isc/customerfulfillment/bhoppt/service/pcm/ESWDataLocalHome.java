/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;
/**
 * Local Home interface for Enterprise Bean: ESWData
 */
public interface ESWDataLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates a default instance of Session Bean: ESWData
	 * @author Sara
	 * Defect 11 - Fix for GWA XA
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ESWDataLocal create()
		throws javax.ejb.CreateException;
}

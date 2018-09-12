/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector;
/**
 * Local Home interface for Enterprise Bean: JMSConnectorBean
 */
public interface JMSConnectorLocalHome extends javax.ejb.EJBLocalHome
{
	/**
	 * Creates a default instance of Session Bean: JMSConnectorBean
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocal create() throws javax.ejb.CreateException;
}

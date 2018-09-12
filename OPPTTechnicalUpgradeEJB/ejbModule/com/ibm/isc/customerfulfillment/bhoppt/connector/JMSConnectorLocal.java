/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector;

/**
 * Local interface for Enterprise Bean: JMSConnectorBean
 */
public interface JMSConnectorLocal extends javax.ejb.EJBLocalObject
{
	public ConnectorDTOInterface sendReceive(ConnectorDTOInterface aConnectorDTO) throws Exception;
}

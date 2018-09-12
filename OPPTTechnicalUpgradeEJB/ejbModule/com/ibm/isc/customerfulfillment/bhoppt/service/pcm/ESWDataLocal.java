/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import java.util.Map;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Local interface for Enterprise Bean: ESWData
 * @author Sara
 * Defect 11 - Fix for GWA XA
 */
public interface ESWDataLocal extends javax.ejb.EJBLocalObject {
	public void deleteESWData(String sessionId, int proposalId, String transAttribute) throws ServiceException;
	public Map retrieveESWData(String sessionId, int proposalId, String transAttribute) throws ServiceException;
	public void storeESWData(String sessionId, ConnectorDTOInterface dtoList, int proposalId, String transAttribute) throws ServiceException;
}

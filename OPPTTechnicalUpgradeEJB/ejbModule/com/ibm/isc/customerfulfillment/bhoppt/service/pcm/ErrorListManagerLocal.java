/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ErrorListBO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Local interface for Enterprise Bean: ErrorListManager
 */
public interface ErrorListManagerLocal extends javax.ejb.EJBLocalObject {
	public void storeErrorList(ErrorListBO errorListBO) throws ServiceException;
	
}

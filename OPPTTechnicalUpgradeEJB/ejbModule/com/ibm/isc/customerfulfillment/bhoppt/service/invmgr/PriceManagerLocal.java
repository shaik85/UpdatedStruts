/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.invmgr;


import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Local interface for Enterprise Bean: PriceManager
 */
public interface PriceManagerLocal extends javax.ejb.EJBLocalObject {
	public PriceProposalDomainDTO priceProposal(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException;
}

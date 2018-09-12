/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.swomgr;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Local interface for Enterprise Bean: EEPriceManager
 */
public interface EEPriceManagerLocal extends javax.ejb.EJBLocalObject {
	public PriceProposalDomainDTO priceVariance(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException;
	public PriceProposalDomainDTO calculatePrice(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException;
	public PriceProposalDomainDTO priceAnnivEASExcludedProposal(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException;
	public PriceProposalDomainDTO priceAnnivAmtProposal(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException;
	public PriceProposalDomainDTO updateProposalPricingDetails(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException;
}

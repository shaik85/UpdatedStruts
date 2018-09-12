/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CurrencyDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ValidCombinationDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ProposalTypeBO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalFormDataCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;


/**
 * Local interface for Enterprise Bean: ProposalDataManager
 */
public interface ProposalDataManagerLocal extends javax.ejb.EJBLocalObject {
	
	public ProposalFormDataCustomDTO getProposalFormData(boolean createProposal) throws ServiceException; 
	public boolean checkValidCombination(ValidCombinationDomainDTO validCombinationDomainDTO) throws ServiceException;
	public CurrencyDomainDTO getCurrencyInformation(String currency)throws ServiceException; 	
}

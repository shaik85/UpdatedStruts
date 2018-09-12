/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.swomgr;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

public interface SWOManagerLocal extends javax.ejb.EJBLocalObject {
	public List retrieveSWODetails(DMDomainDTO dmDTO)throws ServiceException;
	public void storeSWODetails(List swoDTOList)throws ServiceException;
	public SWODomainDTO retrieveSWOEditInfo(SWODomainDTO swoDomainDTO)throws ServiceException;
	public void removeSVCLicenses(ProposalDomainDTO proposalDTO) throws ServiceException;
	public boolean verifyLicenseAreExists(SWODomainDTO swoDomainDTO)throws ServiceException;
	public void insertBumpLicenseInfo(List bumpSWODTOList)throws ServiceException;
	public void storeVarianceInfoSWO(List swoDTOList) throws ServiceException;
	public DMDomainDTO retrieveVarianceForSWO(DMDomainDTO dmDTO);
	public void storeIneligibleLicense(List swoDTOList)throws ServiceException;
	public void removeLicenses(SWODomainDTO swoDTO)throws ServiceException;
	public void updateSWOForCustomer(CustomerDomainDTO customerDTO)throws ServiceException;
	public void updateSWOForDM(DMDomainDTO dmDTO)throws ServiceException;
	public void copyStoreSWOHistoryInfo(SWODomainDTO swoDTO)throws ServiceException;
	public void storeEEConfigInfo(TempEEDomainDTO tempEEDTO)throws ServiceException;
	public void storeConfigSWODetails(List swoDTO)throws ServiceException;
	public void removeConfigurationDetails(TempEEDomainDTO tempEEDomainDTO)throws ServiceException;
	public void calculateSWOPrice(PriceProposalDomainDTO priceProposalDTO);
	public void replaceSkipLicenses(List swoDTOList)throws ServiceException;
	public void copyInventory(CopyInventoryDomainDTO copyInventoryDomainDTO)throws ServiceException;
	public PriceProposalDomainDTO retrieveSWODetailsForPricing(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException;
	public boolean chkSVCLicense(int ProposalID, String transactionName) throws ServiceException;
	public TempEEDomainDTO retrieveEEConfigInfoFromTemp(TempEEDomainDTO tempEEDomainDTO)throws ServiceException;
	public SWODomainDTO validateAndPopulateSWOForStatusCheck(SWODomainDTO swoDomainDTO)throws ServiceException;
	public boolean excludeIncludeSWO(SWODomainDTO[] licenses) throws ServiceException;
	public boolean excludeIncludeSWOsOfDM(DMDomainDTO machine) throws ServiceException;
	public boolean excludeIncludeSWOsOfCustomer(CustomerDomainDTO customer) throws ServiceException;
	public SWODomainDTO[] retrieveSWODetails(SWODomainDTO[] licenses) throws ServiceException;
	public void updateSWODetails(SWODomainDTO[] licenses) throws ServiceException;
	public void updateESWPriceForVarianceProposal(ProposalDomainDTO proposalDomainDTO) throws ServiceException;
	public boolean removeQuotes(ProposalDomainDTO proposalDTO) throws ServiceException;
	public List fetchSAndSDetails(DMDomainDTO[] dmDomainDTOList,SWODomainDTO[] swoDomainDTOList) throws ServiceException;
	public void applySAndSDiscount(EEDomainDTO[] eeDomainDTOArray,double sAndSDiscount) throws ServiceException;
	public boolean chkSandSLicense(int ProposalID, String flag) throws ServiceException;
	public String chkSWOExternalCntrNumber(int ProposalID) throws ServiceException;
	public DMDomainDTO retrieveSWOForCopyInventory(DMDomainDTO dmDomainDTO) throws ServiceException;
	public void copyInventory(DMDomainDTO dmDomainDTO,CopyInventoryDomainDTO copyInventoryDomainDTO)throws ServiceException; // Method added for copying variance proposal
}

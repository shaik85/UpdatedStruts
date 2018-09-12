/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.service.swomgr;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

public interface SWOInfoLocal extends javax.ejb.EJBLocalObject {
public void storeSWOInfo(List swoDomainDTOList)throws ServiceException;	
public boolean verifyLicensesAreExists(SWODomainDTO swoDomainDTO)throws ServiceException;
public void storeIneligibleLicenses(SWODomainDTO swoDomainDTO)throws ServiceException;
public List retrieveSWODetails(SWODomainDTO swoDomainDTO)throws ServiceException;
public void updateSWOInfo(SWODomainDTO swoDomainDTO)throws ServiceException;
public void copyInventory(CopyInventoryDomainDTO copyInventoryDomainDTO) throws ServiceException;
public PriceProposalDomainDTO retrieveSWODetailsForPricing(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException;
public boolean chkSVCLicense(int ProposalID, String transactionName) throws ServiceException;
public void storeVarianceInfoSWO(SWODomainDTO swoDomainDTO) throws ServiceException;
public SWODomainDTO retrieveSWOInformation(SWODomainDTO swoDomainDTO)throws ServiceException;
public void updateSWOForCustomer(CustomerDomainDTO customerDTO)throws ServiceException;
public void updateSWOForDM(DMDomainDTO dmDomainDTO)throws ServiceException;
public void copyStoreInfo(SWODomainDTO swoDomainDTO)throws ServiceException;
public void removeLicenses(SWODomainDTO swoDomainDTO)throws ServiceException;
public void updateSWOEditInfo(SWODomainDTO swoDomainDTO)throws ServiceException;
public void removeSVCLicenses(ProposalDomainDTO proposalInfo) throws ServiceException;
public void insertBumpSwoInfo(SWODomainDTO swoDomainDTO)throws ServiceException;
public void storeEEConfigInfo(TempEEDomainDTO tempEEDomainDTO)throws ServiceException;
public TempEEDomainDTO retrieveEEConfigInfoFromTemp(TempEEDomainDTO tempEEDomainDTO)throws ServiceException;
public void storeSWOConfigInfo(SWODomainDTO swoDomainDTO)throws ServiceException;
public void removeConfigurationInfo(TempEEDomainDTO tempEEDomainDTO)throws ServiceException;
	public SWODomainDTO validateAndPopulateForStatusCheck(SWODomainDTO swoDomainDTO) throws ServiceException;
	public boolean updateSWOForExcludeInclude(SWODomainDTO license) throws ServiceException;
	public boolean updateSWOsOfDMForExcludeInclude(DMDomainDTO machine) throws ServiceException;
	public boolean updateSWOsOfCustomerForExcludeInclude(CustomerDomainDTO customer) throws ServiceException;
	public void updateESWPriceForVarianceProposal(ProposalDomainDTO proposalDomainDTO) throws ServiceException;
	public boolean removeQuotes(ProposalDomainDTO proposalInfo) throws ServiceException;
	public List fetchSAndSDetails(DMDomainDTO[] dmDomainDTOList,SWODomainDTO[] swoDomainDTOList) throws ServiceException;
	public void applySAndSDiscount(EEDomainDTO[] eeDomainDTOArray,double sAndSDiscount) throws ServiceException;
	public boolean chkSandSLicense(int ProposalID, String flag) throws ServiceException;
	public String chkSWOExternalCntrNumber(int ProposalID) throws ServiceException;
	public DMDomainDTO retrieveSWOForCopyInventory(DMDomainDTO dmDomainDTO) throws ServiceException;
	public void copyInventory(DMDomainDTO dmDomainDTO,CopyInventoryDomainDTO copyInventoryDomainDTO) throws ServiceException; // Method added for Variance proposal copy
}

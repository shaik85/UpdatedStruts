/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.invmgr;
import java.sql.Date;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

public interface InventoryManagerLocal extends javax.ejb.EJBLocalObject
{
	public void removeCustomerDetail(CustomerDomainDTO customerDTO)throws ServiceException;
	public void addCustomersToProposal(CustomerDomainDTO customerDTO)throws ServiceException;
	public ProposalDomainDTO retrieveCustomerForProposal(ProposalDomainDTO proposalDTO) throws ServiceException;
	public ProposalDomainDTO retrieveCustomerForCopyInventory(ProposalDomainDTO proposalDTO) throws ServiceException;
	public void storeInventory(CustomerDomainDTO customerDTO) throws ServiceException;
	public void storeIneligibleInventory(CustomerDomainDTO customerDTO) throws ServiceException;
	public CustomerDomainDTO retrieveDMEditInfo(DMDomainDTO dmDomainDTO)throws ServiceException;
	public CustomerDomainDTO retrieveSWOEditInfo(SWODomainDTO swoDomainDTO)throws ServiceException;
	public void updateSWODetails(SWODomainDTO[] swoDTO)throws ServiceException;
	public void updateDMEditInfo(DMDomainDTO dmDTO)throws ServiceException;
	public void updateCustomer(CustomerDomainDTO customerDTO)throws ServiceException;
	public DMDomainDTO retrieveDMAndLicenseInfo(DMDomainDTO dmDTO)throws ServiceException;
	public void removeSVCLicenses(ProposalDomainDTO proposalDTO) throws ServiceException;
	public CustomerDomainDTO[] retrieveCustomerDetails(CustomerDomainDTO[] customers)throws ServiceException;
	public void storeBumpInfo(DMDomainDTO bumpDMDTO)throws ServiceException;
	public void storeVarianceInfo(CustomerDomainDTO customerDTO) throws ServiceException;
	public boolean verifyLicensesAlreadyExists(SWODomainDTO swoDomainDTO) throws ServiceException;
	public void removeDMDetails(DMDomainDTO dmDTO)throws ServiceException;
	public void removeSWODetails(SWODomainDTO swoDTO)throws ServiceException;
	public DMDomainDTO[] retrieveDMDetails(DMDomainDTO[] machines) throws ServiceException;
	public void copyStoreCustomerInfo(CustomerDomainDTO customerDTO)throws ServiceException;
	public CustomerDomainDTO retrieveCustomerAndDMInfo(DMDomainDTO dmDTO)throws ServiceException;
	public void storeConfigureDMInfo(DMDomainDTO dmDTO)throws ServiceException;
	public CustomerDomainDTO retrieveSWOCopyInfo(SWODomainDTO swoDomainDTO)throws ServiceException;
	public void storeEEConfigInfo(TempEEDomainDTO tempEEDTO)throws ServiceException;
	public void replaceSkipLicenses(CustomerDomainDTO customerDTO) throws ServiceException;
	public void copyInventory(CopyInventoryDomainDTO copyInventoryDomainDTO) throws ServiceException;
	public boolean isSVCLicenseExistsForProposal(int proposalID, String transactionName) throws ServiceException;
	public boolean excludeIncludeLicenses(SWODomainDTO[] licenses,DMDomainDTO[] machines, 
		CustomerDomainDTO[] customers) throws ServiceException;
	public SWODomainDTO[] retrieveSWODetails(SWODomainDTO[] licenses) throws ServiceException;
	public CustomerDomainDTO retrieveCustomerInfo(CustomerDomainDTO customer)throws ServiceException;
	public DMDomainDTO retrieveDMInfo(DMDomainDTO machine) throws ServiceException;
	public List retrieveSWODetails(DMDomainDTO dmDTO) throws ServiceException;
	public TempEEDomainDTO retrieveEEConfigInfoFromTemp(TempEEDomainDTO tempEEDomainDTO)throws ServiceException;
	public void removeEEConfigDetails(TempEEDomainDTO tempEEDomainDTO)throws ServiceException;
	public CustomerBO[] retrieveCustomerNumberForCustomerList(CustomerDomainDTO customerDomainDTO) throws ServiceException; //DADO02 Sateesh Anne Blue Harmony 
	public SWODomainDTO validateAndPopulateSWOForStatusCheck(SWODomainDTO swoDomainDTO) throws ServiceException;
	public void deleteVarianceInventory(ProposalDomainDTO proposal) throws ServiceException;
	public void updateESWPriceForVarianceProposal(ProposalDomainDTO proposalDomainDTO) throws ServiceException;
	public boolean removeQuotes(ProposalDomainDTO proposalDTO) throws ServiceException;
	public List fetchSAndSDetails(DMDomainDTO[] dmDomainDTOList,SWODomainDTO[] swoDomainDTOList) throws ServiceException;
	public void applySAndSDiscount(EEDomainDTO[] eeDomainDTOArray,double sAndSDiscount) throws ServiceException;	
	public boolean isCustomerAvailableForProposal(CustomerDomainDTO customer) throws ServiceException;
	public boolean isSandSLicenseExistForProposal(int proposalID, String flag) throws ServiceException;
	public String getSWOExternalCntrNumber(int proposalID) throws ServiceException;
	public CustomerDomainDTO findSTPForProposal(int proposalId,String sapCustomerNo) throws ServiceException; /* Changed for EF0607044559S by Sara on June 16,2004 */
	/* Start change CR6153 */
	public void addCustomersToProposalSAndSExtended(CustomerDomainDTO customerDTO)throws ServiceException;
	public boolean isCustomerAvailableForProposalPlanStartEndDate(CustomerDomainDTO customer)throws ServiceException;
	public CustomerDomainDTO findSTPForProposalPlanStartEndDate(int proposalId, String sapCustomerNo, Date planStartDate, Date planEndDate) throws ServiceException;
	/* End change CR6153 */
}

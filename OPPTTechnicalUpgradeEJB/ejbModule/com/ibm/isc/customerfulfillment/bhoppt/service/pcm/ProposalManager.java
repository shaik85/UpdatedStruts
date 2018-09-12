/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import java.rmi.RemoteException;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
/**
 * Remote interface for Enterprise Bean: ProposalManager
 */
public interface ProposalManager extends javax.ejb.EJBObject {

	public ProposalFormDataCustomDTO getProposalFormData() throws ServiceException, RemoteException;
	public ProposalHeaderCustomDTO validateProposalHeader(ProposalHeaderCustomDTO proposalHeaderCustomDTO) throws ServiceException, RemoteException;
	// BH Wave1 - DAD003 - CCI - Manoj - Begin
	public BasicProposalCustomDTO validateComplexContractIdentifiers(BasicProposalCustomDTO basicProposalCustomDTO) throws ServiceException,RemoteException;
	public void throwExceptionForService(String str,int i) throws ServiceException, RemoteException;
	// BH Wave1 - DAD003 - CCI - Manoj - End
	public InventoryCustomDTO fetchInventory(InventoryCustomDTO inventoryCustomDTO) throws ServiceException, RemoteException;
	//public FetchCustomersCustomDTO fetchCustomersFromCustomerLists(FetchCustomersCustomDTO fetchCustomersCustomDTO) throws ServiceException,RemoteException; DADO02 Sateesh ANNE 
	public FetchCustomersCustomDTO fetchCustomes(FetchCustomersCustomDTO fetchCustomersCustomDTO)throws ServiceException,RemoteException; //DADO02
	public FetchPartnerInformationCustomDTO fetchPartnerInformationForCustomer(FetchPartnerInformationCustomDTO fetchPartnerInformationCustomDTO) throws ServiceException, RemoteException;
	//public FetchCustomerListCustomDTO fetchCustomerLists(FetchCustomerListCustomDTO fetchCustomerListCustomDTO) throws ServiceException, RemoteException; //DADO02 SATEESH anne
	public IneligibleLicensesCustomDTO fetchIneligibleInventory(IneligibleLicensesCustomDTO ineligibleLicensesCustomDTO) throws ServiceException, RemoteException;
	public InventoryDateRangeCustomDTO initiateFetchPlannedInventory(InventoryDateRangeCustomDTO inventoryDateRangeCustomDTO) throws ServiceException, RemoteException;
	public QuotesListCustomDTO fetchPlannedInventory(QuotesListCustomDTO quotesListCustomDTO) throws ServiceException, RemoteException;

	public PlannedInventoryCustomDTO addPlannedInventory(PlannedInventoryCustomDTO plannedInventoryCustomDTO) throws ServiceException, RemoteException;
	public IneligibleLicensesCustomDTO addIneligibleInventoryToProposal(IneligibleLicensesCustomDTO ineligibleLicensesCustomDTO) throws ServiceException, RemoteException;

	public UserCustomDTO checkForRemovingUser(UserCustomDTO userCustom) throws ServiceException, RemoteException;
	public void updateProposalWithGroupName(String userID,String groupName) throws ServiceException, java.rmi.RemoteException;
	public FetchPartnerInformationCustomDTO fetchPartnerInformationForBP(FetchPartnerInformationCustomDTO fetchPartnerInformationCustomDTO) throws ServiceException, RemoteException;
	public FetchCustomerListCustomDTO fetchCustomerListsForBP(FetchCustomerListCustomDTO fetchCustomerListCustomDTO) throws ServiceException, RemoteException;
	public AlternatePartnerCustomDTO fetchAlternatePartner(AlternatePartnerCustomDTO alternatePartnerCustomDTO) throws ServiceException, RemoteException;
	public ProposalHeaderCustomDTO saveProposal(ProposalHeaderCustomDTO proposalHeaderCustomDTO) throws ServiceException, RemoteException;

	public ProposalDetailsCustomDTO fetchProposalDetails(ProposalDetailsCustomDTO proposalDetailsCustomDTO) throws ServiceException, RemoteException;
	public CopyProposalCustomDTO copyProposal(CopyProposalCustomDTO copyProposalCustomDTO) throws ServiceException, RemoteException;
	
	public ExtendContractCustomDTO extendContract(ExtendContractCustomDTO extendContractCustomDTO) throws ServiceException, RemoteException;
	public ExtendContractCustomDTO submitExtendContract(ExtendContractCustomDTO extendContractCustomDTO) throws ServiceException, RemoteException;

	public ReplaceContractCustomDTO getHeaderForReplacement(ReplaceContractCustomDTO replaceContractCustomDTO) throws ServiceException, RemoteException;
	public CopyReplacementCustomDTO copyReplaceContract(CopyReplacementCustomDTO copyReplacementCustomDTO) throws ServiceException, RemoteException;
	public RenewContractCustomDTO renewContract(RenewContractCustomDTO renewContractCustomDTO) throws ServiceException, RemoteException;
	public RenewContractCustomDTO enterRenewContractInfo(RenewContractCustomDTO renewContractCustomDTO) throws ServiceException, RemoteException;
	public AmendContractCustomDTO amendContract(AmendContractCustomDTO amendContractCustomDTO) throws ServiceException, RemoteException;
	public AmendContractCustomDTO processAmendContract(AmendContractCustomDTO amendContractCustomDTO) throws ServiceException, RemoteException;
	public ValidateTPProposalCustomDTO validateTPProposal(ValidateTPProposalCustomDTO validateTPProposalCustomDTO) throws ServiceException, RemoteException;
	public ContractCustomDTO canEASIICopyPerformed(ContractCustomDTO contractDTO) throws ServiceException, RemoteException;
	public EASIICopyCustomDTO easIICopy(EASIICopyCustomDTO easIICopyCustomDTO) throws ServiceException, RemoteException;
	public ReplaceContractCustomDTO validateReplacementDate(ReplaceContractCustomDTO replacementCustomDTO) throws ServiceException, RemoteException;
	public CopyBumpDMCustomDTO copyBumpInventory(CopyBumpDMCustomDTO copyBumpDMCustomDTO) throws ServiceException, RemoteException;
	public CopyBumpDMCustomDTO saveCopyBumpDM(CopyBumpDMCustomDTO copyBumpDMCustomDTO) throws ServiceException, RemoteException;
	public CopyBumpSWOCustomDTO copyBumpInventory(CopyBumpSWOCustomDTO copyBumpSWOCustomDTO) throws ServiceException, RemoteException;
	public CopyBumpSWOCustomDTO saveCopyBumpSWO(CopyBumpSWOCustomDTO copyBumpSWOCustomDTO) throws ServiceException, RemoteException;
	public ProposalCustomDTO canDeltaFetchBePerformed(ProposalCustomDTO proposalCustomDTO) throws ServiceException, RemoteException;
	public DeltaFetchCustomDTO deltaFetch(DeltaFetchCustomDTO deltaFetchCustomDTO) throws ServiceException, RemoteException;
	public EditCustomerCustomDTO editInventory(EditCustomerCustomDTO editCustomerCustomDTO) throws ServiceException, RemoteException;
	public EditDMCustomDTO editInventory(EditDMCustomDTO editDMCustomDTO) throws ServiceException, RemoteException;
	public EditSWOCustomDTO editInventory(EditSWOCustomDTO editSWOCustomDTO) throws ServiceException, RemoteException;
	public EditInventoryCustomDTO editInventory(EditInventoryCustomDTO editInventoryCustomDTO) throws ServiceException, RemoteException; //MN20228979
	public EditDMCustomDTO saveEditDM(EditDMCustomDTO editDMCustomDTO) throws ServiceException, RemoteException;
	public EditCustomerCustomDTO saveEditCustomer(EditCustomerCustomDTO editCustomerCustomDTO) throws ServiceException, RemoteException;
	public EditSWOCustomDTO saveEditSWO(EditSWOCustomDTO editSWOCustomDTO) throws ServiceException, RemoteException;
	public EditInventoryCustomDTO saveInventory(EditInventoryCustomDTO editInventoryCustomDTO) throws ServiceException, RemoteException; //MN20228979
	public VarianceCustomDTO createOrSimulateVariance(VarianceCustomDTO varianceCustomDTO) throws ServiceException, RemoteException;
	public VarianceCustomDTO processVariance(VarianceCustomDTO varianceCustomDTO) throws ServiceException, RemoteException;
	public VarianceHeaderInformationCustomDTO checkVariance(VarianceHeaderInformationCustomDTO varianceHeaderInformationCustomDTO) throws ServiceException, RemoteException;

	public List checkForProposalsForCreateApprove(String userId, String role) throws ServiceException, java.rmi.RemoteException;

	public DeleteInventoryCustomDTO deleteInventory(DeleteInventoryCustomDTO deleteInventoryCustomDTO) throws ServiceException, java.rmi.RemoteException;

	/**
	 *  
	 * Common method to throw BackendException 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public List checkForProposalsForApproverAndManager(String userId) throws ServiceException, java.rmi.RemoteException;
	/**
	 *  
	 * Common method to throw BackendException 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public List checkForProposalsForCSOAndMarkAndManager(String userId, String role) throws ServiceException, java.rmi.RemoteException;

	public RegistrationCustomDTO getRegistrationData(RegistrationCustomDTO registrationCustomDTO) throws ServiceException, RemoteException;

	public RegistrationCustomDTO proposalRegistration(RegistrationCustomDTO registrationCustomDTO) throws ServiceException, RemoteException;

	public void renameProposal(ProposalCustomDTO proposalCustomDTO) throws ServiceException, RemoteException;
	public void deleteProposalContract(DeleteProposalCustomDTO deleteProposalCustomDTO) throws ServiceException, RemoteException;

	public UserProposalsCustomDTO listAllProposalsOfUser(UserProposalsCustomDTO customDTO) throws ServiceException, java.rmi.RemoteException;

	public ProposalHistoryCustomDTO getProposalHistory(ProposalHistoryCustomDTO proposalHistoryCustomDTO) throws ServiceException, RemoteException;

	public ReleaseLockOnProposalCustomDTO releaseLockOnProposal(ReleaseLockOnProposalCustomDTO releaseLockOnProposalCustomDTO) throws ServiceException, RemoteException;
//DAD-001 BlueHarmony Changed by Anand Sugumaran
	public UserContractsCustomDTO listAllContractsOfUser(UserContractsCustomDTO userContractsCustomDTO,boolean isArchive) throws ServiceException, RemoteException;

	public ErrorHistoryCustomDTO viewErrorHistory(ErrorHistoryCustomDTO errorHistoryCustomDTO) throws ServiceException, RemoteException;
	public void deleteErrorHistory(ErrorHistoryCustomDTO errorHistoryCustomDTO) throws ServiceException, RemoteException;
	public ProposalCustomDTO priceProposal(ProposalCustomDTO proposalCustomDTO) throws ServiceException, RemoteException;
	public void lockProposal(ProposalCustomDTO proposalCustomDTO) throws ServiceException, RemoteException;
	public void releaseProposal(ProposalCustomDTO proposalCustomDTO) throws ServiceException, java.rmi.RemoteException;
	public StatusCheckCustomDTO checkProposalStatus(StatusCheckCustomDTO statusCheckCustomDTO) throws ServiceException, java.rmi.RemoteException;
	public CopyCustomerCustomDTO copyCustomerInventory(CopyCustomerCustomDTO copyCustomerCustomDTO) throws ServiceException, java.rmi.RemoteException;

	public CopyDMCustomDTO copyDMInventory(CopyDMCustomDTO copyDMCustomDTO) throws ServiceException, java.rmi.RemoteException;

	public CopySWOCustomDTO copySWOInventory(CopySWOCustomDTO copySWOCustomDTO) throws ServiceException, java.rmi.RemoteException;

	public CopyCustomerCustomDTO copyInventory(CopyCustomerCustomDTO copyCustomerCustomDTO) throws ServiceException, java.rmi.RemoteException;

	public CopyDMCustomDTO copyInventory(CopyDMCustomDTO copyDMCustomDTO) throws ServiceException, java.rmi.RemoteException;

	public CopySWOCustomDTO copyInventory(CopySWOCustomDTO copySWOCustomDTO) throws ServiceException, java.rmi.RemoteException;

	public AmendSWOCustomDTO amendSWO(AmendSWOCustomDTO amendSWOCustomDTO) throws ServiceException, java.rmi.RemoteException;

	public ConfigureDMCustomDTO retrieveDM(ConfigureDMCustomDTO configureDMCustomDTO) throws ServiceException, java.rmi.RemoteException;

	public ConfigureDMCustomDTO retrieveEEConfigWhenConfigureDM(ConfigureDMCustomDTO configureDMCustomDTO) throws ServiceException, java.rmi.RemoteException;

	public ConfigureDMCustomDTO copyConfigToSWOsWhenConfigureDM(ConfigureDMCustomDTO configureDMCustomDTO) throws ServiceException, java.rmi.RemoteException;

	public ConfigureDMCustomDTO validateConfigWhenConfigureDM(ConfigureDMCustomDTO configureDMCustomDTO) throws ServiceException, java.rmi.RemoteException;

	public ConfigureDMCustomDTO fetchPriceWhenConfigureDM(ConfigureDMCustomDTO configureDMCustomDTO) throws ServiceException, java.rmi.RemoteException;
	
	public ConfigureDMCustomDTO cancelConfigureDM(ConfigureDMCustomDTO configureDMCustomDTO)throws ServiceException, java.rmi.RemoteException;
	
	public void deleteTempValues(OPPTCustomDTO opptCustomDTO)throws ServiceException, java.rmi.RemoteException;
	
	public VarianceHeaderInformationCustomDTO deleteTempVarianceValues(VarianceHeaderInformationCustomDTO varianceHeaderInformationCustomDTO) throws ServiceException,java.rmi.RemoteException;

	/** 
	 *  This method is called to get the target users for proposal transfer
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 * @author Kedar Harischandrakar
	 * @exception DomainException
	 * @param TransferProposalsCustomDTO 
	 */
	public TransferProposalsCustomDTO getTargetUsers(TransferProposalsCustomDTO transferProposalsCustomDTO) throws ServiceException, java.rmi.RemoteException;
	/** 
	 *  This method is called to  transfer the proposals to targeted users
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 * @author Kedar Harischandrakar
	 * @exception DomainException
	 * @param TransferProposalsCustomDTO 
	 */
	public TransferProposalsCustomDTO transferProposals(TransferProposalsCustomDTO transferProposalsCustomDTO) throws ServiceException, java.rmi.RemoteException;

	public ProposalsForApprovalCustomDTO listProposalsForApproval(ProposalsForApprovalCustomDTO proposalsForApprovalCustomDTO) throws ServiceException, java.rmi.RemoteException;
	public ProposalHeaderCustomDTO getHeaderInformation(ProposalHeaderCustomDTO proposalHeaderCustomDTO) throws ServiceException, java.rmi.RemoteException;
	public AddCustomerCustomDTO addSelectedCustomers(AddCustomerCustomDTO addCustomerCustomDTO) throws ServiceException, java.rmi.RemoteException;
	public AddCustomerCustomDTO getProposalCustomers(AddCustomerCustomDTO addCustomerCustomDTO) throws ServiceException, java.rmi.RemoteException;
	public ShareProposalCustomDTO getEligibleUserToShareProposal(ShareProposalCustomDTO customDTO) throws ServiceException, java.rmi.RemoteException;
	public ShareProposalCustomDTO shareProposal(ShareProposalCustomDTO customDTO) throws ServiceException, java.rmi.RemoteException;
	public ShareProposalCustomDTO removeShare(ShareProposalCustomDTO customDTO) throws ServiceException, java.rmi.RemoteException;
	public void canProposalBeCopied(ProposalCustomDTO customDTO) throws ServiceException, java.rmi.RemoteException;
	public PrintProposalCustomDTO printProposal(PrintProposalCustomDTO customDTO) throws ServiceException, java.rmi.RemoteException;
	public SWODetailsCustomDTO getSWODetails(SWODetailsCustomDTO customDTO) throws ServiceException, java.rmi.RemoteException;
	public void saveSWODetails(SWODetailsCustomDTO customDTO) throws ServiceException, java.rmi.RemoteException;
	public ProposalCustomDTO removeSVCLicenses(ProposalCustomDTO proposalInformation) throws ServiceException, java.rmi.RemoteException;
	public ProposalCustomerCustomDTO retrieveCustomerDetails(ProposalCustomerCustomDTO customer) throws ServiceException, java.rmi.RemoteException;
	public void excludeIncludeSWO(IncludeExcludeSWOCustomDTO includeExcludeLicenses) throws ServiceException, java.rmi.RemoteException;
	public void revertProposal(ContractCustomDTO customContract) throws ServiceException, java.rmi.RemoteException;
	public CloseContractCustomDTO closeContract(CloseContractCustomDTO closeContract) throws ServiceException, java.rmi.RemoteException;
	public void rejectRequest(RejectProposalCustomDTO rejectInfo) throws ServiceException, java.rmi.RemoteException;
	public VarianceHeaderInformationCustomDTO createVarianceProposal(VarianceHeaderInformationCustomDTO varianceHeaderInformationCustomDTO) throws ServiceException, RemoteException;
	public void approveRequest(ProposalCustomDTO approveInfo) throws ServiceException, java.rmi.RemoteException;
	public void deleteCustomerList(DeleteCustomerListCustomDTO deleteCustomerListCustomDTO) throws ServiceException, java.rmi.RemoteException;
	public void removeQuotes(ProposalCustomDTO proposalCustomDTO) throws ServiceException, java.rmi.RemoteException;
	public SAndSDetailsCustomDTO fetchSAndSDetails(SAndSDetailsCustomDTO sAndSInformation) throws ServiceException, java.rmi.RemoteException;
	public void applySAndSDiscount(SAndSPlanningCustomDTO sAndSPlanningCustomDTO) throws ServiceException, java.rmi.RemoteException;
	//DAD O02
	public FetchCustomerListCustomDTO fetchSiteIDLists(FetchCustomerListCustomDTO fetchCustomerListCustomDTO) throws ServiceException, RemoteException;
}

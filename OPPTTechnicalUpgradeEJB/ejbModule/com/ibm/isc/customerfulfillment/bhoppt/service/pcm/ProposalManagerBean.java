/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.ejb.CreateException;

import com.ibm.isc.customerfulfillment.bhoppt.connector.CommunicationConnector;
import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocal;
import com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.connector.MailConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ChangeContractInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ChangeContractOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ChangeCreateContractInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ChargeOptionConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CheckVarianceConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CheckVarianceInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CheckVarianceOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CompareAuthorInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CompareAuthorOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateContractInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateContractOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateVarianceReportInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateVarianceReportOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CustomerListConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.EEConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.GenericConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.LicenseConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.MessageConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.OrgConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.PartnerCheckInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.PartnerCheckOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.PriceInquiryInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.PriceInquiryOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RefreshVarianceInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RefreshVarianceOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveCustConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveCustInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveCustListInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveCustListOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveCustOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveDeltaInventoryInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveDeltaInventoryOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveIneligDeltaInvenInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveIneligInvenDetailInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveInvenConfigInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveInvenConfigOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveInvenDetailInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveInvenDetailOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrievePartnerConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrievePartnerInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrievePartnerOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveSiteIDCustConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveSiteIDListInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveSiteIDListOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.SWOConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.StatusCheckInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.StatusCheckOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.UseLevelConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateComplexDataInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateComplexDataOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateHeaderDataInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateHeaderDataOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateInvenConfigConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateInvenConfigInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateInvenConfigOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateUserAccessInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateUserAccessOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValueMetricConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.MailMessageConstants;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.factory.CustomerBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CopyInventoryDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CreateContractEEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CurrencyDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.EEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ReportsDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.TempEEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserGroupProfileDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserProfileDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ValidCombinationDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ActivityLogBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BPCustomerListBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BPLegacyBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.GeoSecOffBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.UserProfileBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.ActivityLogBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.GeoSecOffBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.UserProfileBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.AccessHistoryBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.CustomerListBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ErrorListBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.SharingBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.AccessHistoryBOFactory;

import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ActionDescriptionBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.CustomerListBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ESWDataFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ErrorListBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.InventoryDTOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ProposalContractBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ProposalContractDTOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.SharingBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.factory.SWODTOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.ProposalContractDAO;
import com.ibm.isc.customerfulfillment.bhoppt.service.helper.DomainDTOBuildHelper;
import com.ibm.isc.customerfulfillment.bhoppt.service.helper.InputConnectorDTOBuildHelper;
import com.ibm.isc.customerfulfillment.bhoppt.service.helper.ProposalDetailsBuildHelper;
import com.ibm.isc.customerfulfillment.bhoppt.service.helper.RenewContractHelper;
import com.ibm.isc.customerfulfillment.bhoppt.service.helper.StatusCheckHelper;
import com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.PriceManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ButtonConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ComplexContractIdentifiers;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ContractTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.FieldConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.IneligibleLicenseConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.LicenseConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.PartnerTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.PreparedString;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalContractStatusConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.SalesOrgConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AddCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AlternatePartnerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BasicProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CloseContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMEECustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyReplacementCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopySWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteCustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteInventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeltaFetchCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EASIICopyCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ESWCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditInventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ErrorHistoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ExtendContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomersCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IncludeExcludeSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleEECustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleLicensesCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryDateRangeCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PartnerInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PlannedInventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PricingInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PrintProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalFormDataCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHistoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHistoryDataCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalsForApprovalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.QuoteCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.QuotesListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RegistrationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RejectProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReleaseLockOnProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RenewContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReplaceContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSEECustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSPlanningCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWODetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SecondaryProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.StatusCheckCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.TransferProposalsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserContractsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserProposalsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ValidateTPProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceHeaderInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceRptCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ConnectorException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ProposalContractBOFactory;

/**
 *
 *This class serves as an entry point for all Proposal and Inventory calls.
 *
 * <br/><b>Known Bugs</b><br/>
 *
 * <br/><PRE>
 * date Dec 2, 2003
 *
 * revision date author reason
 *
 * </PRE><br/>
 * @author Ravishankar J
 * @version 5.1A
 */

public class ProposalManagerBean implements javax.ejb.SessionBean {
	private static final String CLASS_NAME = "ProposalManagerBean";
	private AccessHistoryBOFactory iAccessHistoryBOFactory = new AccessHistoryBOFactory();
	private ActivityLogBOFactory iActivityLogBOFactory = new ActivityLogBOFactory();
	private javax.ejb.SessionContext mySessionCtx;

	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}

	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}

	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}

	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}

	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}

	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}

	/**
	 * This method is the first method in proposal creation, it deligates a call to ProposalDataManager
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Jan 10, 2004
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @return ProposalFormDataCustomDTO
	 * @throws ServiceException
	 * @author balajiv
	 */
	public ProposalFormDataCustomDTO getProposalFormData() throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "getProposalFormData");
		ProposalDataManagerLocal proposalDataManagerLocal = null;
		try {
			proposalDataManagerLocal = (ProposalDataManagerLocal) HomeProvider.getProposalDataManagerLocal();
		} catch (CreateException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "getProposalFormData", null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		ProposalFormDataCustomDTO proposalFormDataCustomDTO = proposalDataManagerLocal.getProposalFormData(true);
		proposalFormDataCustomDTO.addButtonFlag(ButtonConstants.SAVE);
		log.end();
		return proposalFormDataCustomDTO;
	}
	/**
	 *
	 * This method validates the data entered and throws Service Exception
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Nov 28, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param proposalHeaderCustomDTO
	 * @return ProposalHeaderCustomDTO
	 * @throws ServiceException
	 * @author Bhanu P
	 *
	 */
public void throwExceptionForService(String str,int i) throws ServiceException, RemoteException{
	throwServiceException(str,i);
}

	/**
	 *
	 * This method validates the data entered by the user for complex contract identifiers
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Nov 28, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param proposalHeaderCustomDTO
	 * @return ProposalHeaderCustomDTO
	 * @throws ServiceException
	 * @author Bhanu P
	 *
	 */

/*public BasicProposalCustomDTO validateComplexContractIdentifiers(BasicProposalCustomDTO basicProposalCustomDTO) throws ServiceException{
	TimeTaken log = new TimeTaken(CLASS_NAME, "validateComplexContractIdentifiers");
	ComplexContractIdentifiers complexContractIdentifiers = ComplexContractIdentifiers.getComplexContractIdentifiers();
	
	ErrorReport messageReport = basicProposalCustomDTO.getMessageReport();
	//Manoj new code
	//if(("".equalsIgnoreCase(basicProposalCustomDTO.getCpsID())|| basicProposalCustomDTO.getCpsID()== null) && "0365".equals(basicProposalCustomDTO.getSalesOrganization())){
	System.out.println("ProposalManagerBean.validateComplexContractIdentifiers():sales org1"+basicProposalCustomDTO.getSalesOrganization());
	System.out.println("ProposalManagerBean.validateComplexContractIdentifiers():CPS_SALESORG2:??"+OPPTStaticDataHolder.getCpsSalesorg(basicProposalCustomDTO.getSalesOrganization()));
	if(!"".equals(OPPTStaticDataHolder.getCpsSalesorg(basicProposalCustomDTO.getSalesOrganization())) && OPPTStaticDataHolder.getCpsSalesorg(basicProposalCustomDTO.getSalesOrganization())!=null){
		System.out.println("ProposalManagerBean.validateComplexContractIdentifiers()???3");
	if(complexContractIdentifiers.IsCPSSalesorg(basicProposalCustomDTO)){
		System.out.println("ProposalManagerBean.validateComplexContractIdentifiers():manoj new code");
		complexContractIdentifiers.setReturnCode("483");
	ErrorReport messageReport = basicProposalCustomDTO.getMessageReport();
	//Manoj new code
		if(complexContractIdentifiers.IsCPSSalesorg(basicProposalCustomDTO)){
		complexContractIdentifiers.setReturnCode("483");
		basicProposalCustomDTO.setCciInd("N");
		if(null == messageReport){
			messageReport = new ErrorReport();
		}
		ErrorKey errorKey =	new ErrorKey(ErrorCodeConstants.SE0026, OPPTMessageCatalog.TYPE_SERVICE);
		messageReport.addErrorEntry(errorKey,null);
		basicProposalCustomDTO.setMessageReport(messageReport);
		log.end();
		return basicProposalCustomDTO;
	}
	//Manoj new code end

	if(complexContractIdentifiers.IsChangedComplexContractIdentifiers(basicProposalCustomDTO)) {
		complexContractIdentifiers.SetComplexContractIdentifiers(basicProposalCustomDTO);
		ValidateComplexDataInputConnectorDTO inputConnectorDTO = PCMConnectorDTOBuilder.buildValidateComplexDataInputConnectorDTO(basicProposalCustomDTO);
		// Check with CBS
		JMSConnectorLocal jmsConnectorLocal = null;
		try {
			jmsConnectorLocal = (JMSConnectorLocal) HomeProvider.getJMSConnectorLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateComplexContractIdentifiers", null, e);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}


		ValidateComplexDataOutputConnectorDTO outputConnectorDTO = null;
		try {
			outputConnectorDTO = (ValidateComplexDataOutputConnectorDTO) jmsConnectorLocal.sendReceive(inputConnectorDTO);
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateComplexContractIdentifiers", null, e1);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		complexContractIdentifiers.setReturnCode(outputConnectorDTO.getReturnCode());
		complexContractIdentifiers.setSapReturnCode(outputConnectorDTO.getSapReturnCode());
		complexContractIdentifiers.setExecptionCode(outputConnectorDTO.getExeptionCode());
		complexContractIdentifiers.setMessage(outputConnectorDTO.getErrorMessage());

		basicProposalCustomDTO.setOcpsID(outputConnectorDTO.getOcpsID());
		basicProposalCustomDTO.setContractType(outputConnectorDTO.getContractType());
		basicProposalCustomDTO.setBlbIndicator(outputConnectorDTO.getBlbIndicator());
		complexContractIdentifiers.setOcpsID(outputConnectorDTO.getOcpsID());
		complexContractIdentifiers.setContractType(outputConnectorDTO.getContractType());
		complexContractIdentifiers.setBlbIndicator(outputConnectorDTO.getBlbIndicator());
		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(outputConnectorDTO.getReturnCode())) {
			basicProposalCustomDTO.setCciInd("Y");
		} else {
			basicProposalCustomDTO.setCciInd("N");

			if(null == messageReport){
				messageReport = new ErrorReport();
			}
			ErrorKey errorKey =	new ErrorKey(ErrorCodeConstants.SE0026, OPPTMessageCatalog.TYPE_SERVICE);
			messageReport.addErrorEntry(errorKey,null);
			basicProposalCustomDTO.setMessageReport(messageReport);
		}
	}

	log.end();
	return basicProposalCustomDTO;
	}
}*/
public BasicProposalCustomDTO validateComplexContractIdentifiers(BasicProposalCustomDTO basicProposalCustomDTO) throws ServiceException{
	TimeTaken log = new TimeTaken(CLASS_NAME, "validateComplexContractIdentifiers");
	ComplexContractIdentifiers complexContractIdentifiers = ComplexContractIdentifiers.getComplexContractIdentifiers();
	ErrorReport messageReport = basicProposalCustomDTO.getMessageReport();
	//Manoj new code
	//if(("".equalsIgnoreCase(basicProposalCustomDTO.getCpsID())|| basicProposalCustomDTO.getCpsID()== null) && "0365".equals(basicProposalCustomDTO.getSalesOrganization())){
	//System.out.println("ProposalManagerBean.validateComplexContractIdentifiers():sales org1"+basicProposalCustomDTO.getSalesOrganization());
	//System.out.println("ProposalManagerBean.validateComplexContractIdentifiers():CPS_SALESORG2:??"+OPPTStaticDataHolder.getCpsSalesorg(basicProposalCustomDTO.getSalesOrganization()));
	if(!"".equals(OPPTStaticDataHolder.getCpsSalesorg(basicProposalCustomDTO.getSalesOrganization())) && OPPTStaticDataHolder.getCpsSalesorg(basicProposalCustomDTO.getSalesOrganization())!=null){
		//System.out.println("ProposalManagerBean.validateComplexContractIdentifiers()???3");
	if(complexContractIdentifiers.IsCPSSalesorg(basicProposalCustomDTO)){
		//System.out.println("ProposalManagerBean.validateComplexContractIdentifiers():manoj new code");
		complexContractIdentifiers.setReturnCode("483");
		basicProposalCustomDTO.setCciInd("N");
		if(null == messageReport){
			messageReport = new ErrorReport();
		}
		ErrorKey errorKey =	new ErrorKey(ErrorCodeConstants.SE0026, OPPTMessageCatalog.TYPE_SERVICE);
		messageReport.addErrorEntry(errorKey,null);
		basicProposalCustomDTO.setMessageReport(messageReport);
		log.end();
		return basicProposalCustomDTO;
	}
	}
	//Manoj new code end

	if(complexContractIdentifiers.IsChangedComplexContractIdentifiers(basicProposalCustomDTO)) {
		complexContractIdentifiers.SetComplexContractIdentifiers(basicProposalCustomDTO);
		ValidateComplexDataInputConnectorDTO inputConnectorDTO = PCMConnectorDTOBuilder.buildValidateComplexDataInputConnectorDTO(basicProposalCustomDTO);
		// Check with CBS
		JMSConnectorLocal jmsConnectorLocal = null;
		try {
			jmsConnectorLocal = (JMSConnectorLocal) HomeProvider.getJMSConnectorLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateComplexContractIdentifiers", null, e);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}


		ValidateComplexDataOutputConnectorDTO outputConnectorDTO = null;
		try {
			outputConnectorDTO = (ValidateComplexDataOutputConnectorDTO) jmsConnectorLocal.sendReceive(inputConnectorDTO);
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateComplexContractIdentifiers", null, e1);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		complexContractIdentifiers.setReturnCode(outputConnectorDTO.getReturnCode());
		complexContractIdentifiers.setSapReturnCode(outputConnectorDTO.getSapReturnCode());
		complexContractIdentifiers.setExecptionCode(outputConnectorDTO.getExeptionCode());
		complexContractIdentifiers.setMessage(outputConnectorDTO.getErrorMessage());

		basicProposalCustomDTO.setOcpsID(outputConnectorDTO.getOcpsID());
		basicProposalCustomDTO.setContractType(outputConnectorDTO.getContractType());
		basicProposalCustomDTO.setBlbIndicator(outputConnectorDTO.getBlbIndicator());
		complexContractIdentifiers.setOcpsID(outputConnectorDTO.getOcpsID());
		complexContractIdentifiers.setContractType(outputConnectorDTO.getContractType());
		complexContractIdentifiers.setBlbIndicator(outputConnectorDTO.getBlbIndicator());
		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(outputConnectorDTO.getReturnCode())) {
			basicProposalCustomDTO.setCciInd("Y");
		} else {
			basicProposalCustomDTO.setCciInd("N");

			if(null == messageReport){
				messageReport = new ErrorReport();
			}
			ErrorKey errorKey =	new ErrorKey(ErrorCodeConstants.SE0026, OPPTMessageCatalog.TYPE_SERVICE);
			messageReport.addErrorEntry(errorKey,null);
			basicProposalCustomDTO.setMessageReport(messageReport);
		}
	}

	log.end();
	return basicProposalCustomDTO;
}

	/**
	 *
	 * This method validates the data entered by the user for proposal creation
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * revision date author reason
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param proposalHeaderCustomDTO
	 * @return ProposalHeaderCustomDTO
	 * @throws ServiceException
	 * @author balajiv
	 *
	 */
	public ProposalHeaderCustomDTO validateProposalHeader(ProposalHeaderCustomDTO proposalHeaderCustomDTO) throws ServiceException {

		TimeTaken log = new TimeTaken(CLASS_NAME, "validateProposalHeader");
		ErrorReport errorReport = new ErrorReport();
		ErrorReport messageReport = new ErrorReport();
		BasicProposalCustomDTO basicProposalCustomDTO = proposalHeaderCustomDTO
				.getBasicProposalCustomDTO();
		ProposalCustomDTO proposalCustomDTO = proposalHeaderCustomDTO
				.getProposal();
		String proposalName = basicProposalCustomDTO.getProposalName();
				ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		boolean changeProposal = false;
		boolean retreivePartnerDetails = false;
		String origIGFNO = null;
		Date origStartPeriod = null;
		Date origEndPeriod = null;
		String origExternalContractNo = null;
		ProposalBO proposalBO = new ProposalBO();
		OPPTLogger.debug("validateProposalHeader starts", CLASS_NAME,"validateProposalHeader");
		if (proposalCustomDTO != null && ActionNameConstants.CHANGE_PROPOSAL.equals(proposalHeaderCustomDTO.getTransactionName())) {
			changeProposal = true;
			try {
				proposalBO = (ProposalBO) proposalContractBOFactory.getProposalContractBO(proposalCustomDTO.getId());
			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de.getErrorReport());
			}
		}

		/* CR6153 start change */
		OPPTCalender calendar = new OPPTCalender();
		if((proposalBO.getContrStartDate() != null) && (proposalBO.getContrEndDate() != null)){
			if(!(calendar.isDateEqual(proposalBO.getContrStartDate(),proposalHeaderCustomDTO.getBasicProposalCustomDTO().getContractStartDate()))
					|| !(calendar.isDateEqual(proposalBO.getContrEndDate(),proposalHeaderCustomDTO.getBasicProposalCustomDTO().getContractEndDate()))){

				proposalHeaderCustomDTO.getBasicProposalCustomDTO().setChangeDate(true);
			}
		}
		if (basicProposalCustomDTO.getReplacementContractNumber() != null
				&& !(basicProposalCustomDTO.getReplacementContractNumber()
						.equals(""))) {
			proposalBO.isReplaceNew(true);
		}
		/* CR6153 end change */

		// Check with CBS
		JMSConnectorLocal jmsConnectorLocal = null;
		try {
			jmsConnectorLocal = (JMSConnectorLocal) HomeProvider
					.getJMSConnectorLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"validateProposalHeader", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);

		}
		ValidateHeaderDataInputConnectorDTO connectorInputDTO = PCMConnectorDTOBuilder
				.buildValidateHeaderDataInputConnectorDTO(proposalHeaderCustomDTO);
		ValidateHeaderDataOutputConnectorDTO connectorOutputDTO = null;
		try {
			connectorOutputDTO = (ValidateHeaderDataOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(connectorInputDTO);
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"validateProposalHeader", null, e1);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		// if return code is not zero then throw a new service Exception e.
		if (!ConnectorConstants.RFC_SUCCESS_CODE.equals(connectorOutputDTO
				.getReturnCode())) {
			if (changeProposal) {
				try {
					getSessionContext().setRollbackOnly();
				} catch (IllegalStateException ise) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							"validateProposalHeader", null, ise);
				}
				storeErrorList(connectorOutputDTO.getReturnCode(), proposalBO
						.getProposalId(), proposalHeaderCustomDTO.getUserId(),
						"ChangeProposal");
			}
			throwServiceException(connectorOutputDTO.getReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
		}

		if (changeProposal) {
			try {
				proposalBO = (ProposalBO) proposalContractBOFactory
						.getProposalContractBO(proposalCustomDTO.getId());
				origIGFNO = proposalBO.getIGFNumber();
				origStartPeriod = proposalBO.getContrStartPeriod();
				origEndPeriod = proposalBO.getContrEndPeriod();
				origExternalContractNo = proposalBO.getExtContrNo();

			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de
						.getErrorReport());
			}

			PCMBOBuilder.populateProposalBO(proposalBO,
					proposalHeaderCustomDTO,
					PCMBOBuilder.VALIDATE_PROPOSAL_HEADER_CHANGE);

			if (proposalHeaderCustomDTO.isConfirmationRequired()) {
				if (null != proposalBO.getIGFNumber()
						&& (!"".equals(proposalBO.getIGFNumber()))
						&& (!proposalBO.getIGFNumber().equals(origIGFNO))) {
					ExceptionGenerator.addErrorEntry(messageReport,
							ErrorCodeConstants.SE0011,
							OPPTMessageCatalog.TYPE_SERVICE);
				}
				if (null != proposalBO.getExtContrNo()
						&& (!"".equals(proposalBO.getExtContrNo()))
						&& (!proposalBO.getExtContrNo().equals(
								origExternalContractNo))) {
					ExceptionGenerator.addErrorEntry(messageReport,
							ErrorCodeConstants.SE0012,
							OPPTMessageCatalog.TYPE_SERVICE);
				}
			}
		} else {
			PCMBOBuilder.populateProposalBO(proposalBO,
					proposalHeaderCustomDTO,
					PCMBOBuilder.VALIDATE_PROPOSAL_HEADER);
		}

		if (UtilityConstants.MLC_AND_SANDS.equals(proposalBO
				.getProposalContent())) {
			if (null != OPPTHelper.trimStringToNull(proposalBO
					.getAdvanceBilling())) {
				ExceptionGenerator.addErrorEntry(messageReport,
						ErrorCodeConstants.SE0033,
						OPPTMessageCatalog.TYPE_SERVICE);
			}
		}

		if (messageReport.size() > 0) {
			proposalHeaderCustomDTO.setMessageReport(messageReport);
		}

		// Basic
		ProposalDataManagerLocal proposalDataManagerLocal = null;
		try {
			proposalDataManagerLocal = (ProposalDataManagerLocal) HomeProvider
					.getProposalDataManagerLocal();
		} catch (CreateException cex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"validateProposalHeader", null, cex);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}

		ValidCombinationDomainDTO domainDTO = new ValidCombinationDomainDTO(
				basicProposalCustomDTO.getSalesOrganization(),
				basicProposalCustomDTO.getDivision(), basicProposalCustomDTO
						.getDistributionChannel());
		// If the combination is not Valid the following call will throw a
		// ServiceException
		//if proposal name exists
		if (!changeProposal) {
			if (proposalContractBOFactory.isProposalNameExists(proposalName)) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.SE0018,
						OPPTMessageCatalog.TYPE_SERVICE);
			}
		}
		try {
			proposalBO.validateProposalHeader(changeProposal);
		} catch (DomainException de) {
			errorReport.appendErrorReport(de.getErrorReport());
		}

		try {
			// this is not needed for change proposal need confirmation

			proposalDataManagerLocal.checkValidCombination(domainDTO);

		} catch (ServiceException se) {
			errorReport.appendErrorReport(se.getErrorReport());
		} finally {
			if (errorReport.size() > 0) {
				throw ExceptionGenerator.generateServiceException(errorReport);
			}
		}
		if (changeProposal
				&& (!proposalHeaderCustomDTO.isConfirmationRequired())) {
			String statusCode = proposalBO.getStatusCode();
			if (null != proposalBO.getIGFNumber()
					&& (!"".equals(proposalBO.getIGFNumber()))
					&& (!proposalBO.getIGFNumber().equals(origIGFNO))) {
				// IGF NUMBER PRESENT SO EMPTY BTP AND PAYER
				proposalBO.setRegBillToPartASNo(null);
				proposalBO.setRegBillToPartyLegNo(null);
				proposalBO.setRegBillToPartyName(null);
				proposalBO.setRegBillToPartyNo(null);
				proposalBO.setRegPayerASNo(null);
				proposalBO.setRegPayerLegNo(null);
				proposalBO.setRegPayerName(null);
				proposalBO.setRegPayerNo(null);
			}
			if (ProposalTypeConstants.EASII
					.equals(proposalBO.getProposalType())) {
				proposalBO.setStatusCode(ProposalContractStatusConstants.DRAFT);
			} else if (ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
					.equals(proposalBO.getStatusCode())
					|| ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
							.equals(proposalBO.getStatusCode())) {
				proposalBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
			} else if (ContractTypeConstants.VARIANCE.equals(proposalBO
					.getContrType())) {
				// Variance Proposal
				proposalBO.setStatusCode(ProposalContractStatusConstants.DRAFT);
				retreivePartnerDetails = true;
			} else {
				// Normal Proposal
				proposalBO.setStatusCode(ProposalContractStatusConstants.DRAFT);
				retreivePartnerDetails = true;
			}

			if (ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS
					.equals(statusCode)) {
				proposalBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS);
			}
			// Should be at the end
			try {
				proposalContractBOFactory.updateProposalContractBO(proposalBO);
			} catch (DomainException e2) {
				e2.printStackTrace();
				throw ExceptionGenerator.generateServiceException(e2
						.getErrorReport());
			}

			if (retreivePartnerDetails && (!proposalBO.isVarianceProposal())) {
				//RETRIEVE PARTNER DETAILS
				CustomerListBOFactory customerListBOFactory = new CustomerListBOFactory();
				List customerBOList = new ArrayList();
				PartnerInformationCustomDTO partnerInformationCustomDTO = new PartnerInformationCustomDTO();
				TreeMap customerListMap = new TreeMap();
				try {
					customerBOList = customerListBOFactory
							.findCustomerListBOForProposal(proposalBO
									.getProposalId());
					for (int i = 0, size = customerBOList.size(); i < size; i++) {
						CustomerListBO customerListBO = (CustomerListBO) customerBOList
								.get(i);
						CustomerListCustomDTO customerListCustomDTO = new CustomerListCustomDTO();
						customerListCustomDTO.setAlreadyExists(true);
						customerListCustomDTO.setListName(customerListBO
								.getCustomerListDesc());
						customerListCustomDTO.setListNumber(customerListBO
								.getCustomerListNo());
						customerListMap.put(customerListBO.getCustomerListNo(),
								customerListCustomDTO);
					}
					partnerInformationCustomDTO
							.setCustomerLists(customerListMap);
					PCMCustomDTOBuilder.populatePartnerInformationCustomDTO(
							partnerInformationCustomDTO, proposalBO);
					proposalHeaderCustomDTO
							.setPartnerInformationCustomDTO(partnerInformationCustomDTO);
				} catch (DomainException e3) {
					throw ExceptionGenerator.generateServiceException(e3
							.getErrorReport());
				}
			} else {
				// Show proposal details
				proposalHeaderCustomDTO.setProposalDetails(true);
				OPPTLogger.debug("Proposal Detail", CLASS_NAME,
						"validateProposalHeader");
			}
			OPPTCalender calender = new OPPTCalender();

			if ((!calender.isDateEqual(proposalBO.getContrStartPeriod(),
					origStartPeriod))
					|| (!calender.isDateEqual(proposalBO.getContrEndPeriod(),
							origEndPeriod))) {
				// Plan dates have changed should be updated at the STP,DM,SWO
				// level
				ProposalContractDTOFactory fact = new ProposalContractDTOFactory();
				try {
					fact.updatePlanDates(proposalBO.getProposalId(), proposalBO
							.getContrStartPeriod(), proposalBO
							.getContrEndPeriod());
				} catch (SQLException sqlEx) {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0801);
				}
			}
		}

		// If EASII proposal we take the user to ProposalDetails Page
		if (changeProposal
				&& ProposalTypeConstants.EASII.equals(proposalBO
						.getProposalType())) {
			proposalHeaderCustomDTO.setProposalDetails(true);
			proposalHeaderCustomDTO.setFetchInventory(false);
		}
		if (changeProposal && proposalBO.isVarianceProposal()) {
			proposalHeaderCustomDTO.setChangeVarianceProposal(true);
			proposalHeaderCustomDTO.setProposalDetails(false);
			proposalHeaderCustomDTO.setFetchInventory(false);
		}

		//DADO02 Sateesh Anne Blue Harmony
		//This blok of code is to display the customers in place of Customerlists
		if(changeProposal){
			int proposalId = proposalCustomDTO.getId();
			CustomerBOFactory customerBOFactory = new CustomerBOFactory();
	try{
			List customerBOList = customerBOFactory.findCustomerBOforProposal(proposalId,1);
			List selectedCustomers = new ArrayList();
			if(null!=customerBOList && customerBOList.size()>0){
				Iterator iterator = customerBOList.iterator();
				while(iterator.hasNext()){
					CustomerBO customerBO = (CustomerBO)iterator.next();

					CustomerListCustomDTO customerListCustomDTO  =  new CustomerListCustomDTO();
					customerListCustomDTO.setCustomerName(customerBO.getSapCustomerName());
					customerListCustomDTO.setCustomerNumber(customerBO.getSapCustomerNo());

					selectedCustomers.add(customerListCustomDTO);
				}
				proposalHeaderCustomDTO.getPartnerInformationCustomDTO().setSelectedCustomers(selectedCustomers);
			}
		}catch(DomainException e){
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());

		}
		}
		OPPTLogger.debug("validateProposalHeader end", CLASS_NAME,"validateProposalHeader");
		log.end();
		return proposalHeaderCustomDTO;

	}

	/**
	 *
	 * This method fetches the inventory of the Proposal
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Nov 29, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalCustomDTO
	 * @return InventoryCustomDTO
	 * @author Ravishankar
	 */
	public InventoryCustomDTO fetchInventory(
			InventoryCustomDTO inventoryCustomDTO) throws ServiceException {

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "fetchInventory");
		InventoryManagerLocal inventoryManagerLocal = null;
		JMSConnectorLocalHome jmsConnectorLocalHome = null;
		JMSConnectorLocal jmsConnectorLocal = null;
		//method variable
		int proposalId = 0;
		String methodName = "fetchInventory";
		ProposalDomainDTO proposalDomainDTO = null;
		CustomerDomainDTO customerDomainDTO = null;
		//CustomerListCustomerCustomDTO customerListCustomerCustomDTO = null;
		CustomerListCustomDTO customerListCustomDTO=null;
		List customerDomainDTOList = null;
		ProposalContractBO proposalContractBO = null;
		boolean fetchFlag = true;
		boolean customerChanged = false;
		//connecto dto instances
		ConnectorDTOInterface connectorDTO = null;
		RetrieveInvenDetailInputConnectorDTO retrieveInventoryDetailInputConnectorDTO = null;
		RetrieveInvenDetailOutputConnectorDTO retrieveInvenDetailOutputConnectorDTO = null;

		//factory instances
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		proposalId = inventoryCustomDTO.getId();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de
					.getErrorReport());
		}

		//check the pre-condtn here
		try {
			HashMap map = new HashMap();
			map.put(UtilityConstants.BO_USERID, inventoryCustomDTO.getUserId());
			map.put(UtilityConstants.BO_GROUPNAME, inventoryCustomDTO
					.getGroupName());
			SharingBO sharingBO = getSharingBOFromFactory(proposalContractBO
					.getProposalId(), inventoryCustomDTO.getUserId());
			if (null != sharingBO) {
				map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}
			proposalContractBO.validateFetchInventory(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
		String oldExtrContrNo = null;
		OPPTLogger.debug("Contract type" + proposalDomainDTO.getContrType(),
				CLASS_NAME, methodName);
		if (proposalDomainDTO.getContrType() != null
				&& proposalDomainDTO.getContrType().trim().equals(
						ContractTypeConstants.AMENDMENT)
				|| proposalDomainDTO.getContrType().trim().equals(
						ContractTypeConstants.RENEWAL)
				|| proposalDomainDTO.getContrType().trim().equals(
						ContractTypeConstants.REPLACEMENT)) {
			OPPTLogger
					.debug("Old Contr No######"
							+ proposalDomainDTO.getOldContrNo(), CLASS_NAME,
							methodName);
			ProposalContractBO oldProposal = null;
			try {
				oldProposal = proposalContractBOFactory
						.getProposalContractBOForContractNumber(
								proposalDomainDTO.getOldContrNo(), true);
			} catch (DomainException d) {
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());
			}
			if (oldProposal != null && oldProposal.getExtContrNo() != null
					&& !oldProposal.getExtContrNo().equals("")) {
				oldExtrContrNo = oldProposal.getExtContrNo();
				OPPTLogger.debug("Old Ext Contr No " + oldExtrContrNo,
						CLASS_NAME, methodName);
			} else {
				if (oldProposal != null) {
					oldExtrContrNo = oldProposal.getContrNo();
					OPPTLogger.debug("Contr No " + oldExtrContrNo, CLASS_NAME,
							methodName);
				}
			}
		}
		inventoryManagerLocal = getInventoryManagerLocal();
		proposalDomainDTO = inventoryManagerLocal
				.retrieveCustomerForProposal(proposalDomainDTO);

		if (inventoryCustomDTO.getFetchType() != null
				&& inventoryCustomDTO.getFetchType().equalsIgnoreCase(
						UtilityConstants.YES)) {
			fetchFlag = false;
		}

		try {
			List customerNoList = new ArrayList();
			if (proposalDomainDTO != null
					&& proposalDomainDTO.getCustomerDTOList() != null) {
				for (int i = 0; i < proposalDomainDTO.getCustomerDTOList()
						.size(); i++) {
					
					
					
					customerDomainDTO = (CustomerDomainDTO) proposalDomainDTO
							.getCustomerDTOList().get(i);
					
					if (inventoryCustomDTO.getCustomers() == null
							|| inventoryCustomDTO.getCustomers().size() == 0
							|| ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS
									.equals(proposalDomainDTO.getStatusCode())) {
						OPPTLogger.debug("If--Sap Customer no"
								+ customerDomainDTO.getSapCustomerNo(),
								CLASS_NAME, methodName);
						customerNoList.add(customerDomainDTO.getSapCustomerNo());
					} else {
						List selectedList = inventoryCustomDTO.getCustomers();
						
							//customerListCustomerCustomDTO = (CustomerListCustomerCustomDTO) selectedList
							CustomerListCustomDTO customerListCustomerCustomDTO = (CustomerListCustomDTO) selectedList
									.get(i);
							
							
							if (customerListCustomerCustomDTO.getCustomerNumber() != null&& 
									customerListCustomerCustomDTO.getCustomerNumber().equals(customerDomainDTO
															.getSapCustomerNo())) {
								OPPTLogger.debug("Else--Sap Customer no"
										+ customerDomainDTO.getSapCustomerNo(),
										CLASS_NAME, methodName);
						//		customerChanged = true;	
								customerNoList.add(customerDomainDTO
										.getSapCustomerNo());
							}
							else
							{	
							
								customerChanged = true;	
								customerNoList.add(customerDomainDTO
										.getSapCustomerNo());
							}
						
					}
				}
			}
			CustomerBOFactory customerBOFactory = new CustomerBOFactory();
			//List customerBOList = new ArrayList();
	        List customersNew=customerBOFactory.findCustomerBOforProposal(proposalId,1); 

	        Iterator it1=customersNew.iterator();
	    	OPPTLogger.debug("selected inv" + inventoryCustomDTO.isSelectedInventory(),CLASS_NAME, methodName);
	    	OPPTLogger.debug("continue with unmatchedInv:" + inventoryCustomDTO.isContinuErrSelectInv(),CLASS_NAME, methodName);
		    OPPTLogger.debug("selected Refetch" + inventoryCustomDTO.isRefetch(),CLASS_NAME, methodName);
		    OPPTLogger.debug("selectd ChangeProposal" + inventoryCustomDTO.isChangeProposal(),CLASS_NAME, methodName);
	      
			if(inventoryCustomDTO.isSelectedInventory())
			{	
				OPPTLogger.debug("selectd inventory is setting..",CLASS_NAME, methodName);
				// Here checking whether the fetchinventory or selected inventory is called.
				proposalDomainDTO.setSelectedinventory(inventoryCustomDTO.isSelectedInventory());
				proposalDomainDTO.setDesignatedMachineID(inventoryCustomDTO.getDesignatedMachineID());
				proposalDomainDTO.setMaterialID(inventoryCustomDTO.getMaterialID());
				proposalDomainDTO.setSerialNumber(inventoryCustomDTO.getSerialNumber());
			}else{
			      if(inventoryCustomDTO.isRefetch() && !inventoryCustomDTO.isChangeProposal())
			      {
			      	OPPTLogger.debug("selectd inventory Refetch Starts..",CLASS_NAME, methodName);	
			    	ESWDataFactory eswDataFactory = new ESWDataFactory();
					InventoryCustomDTO alreadeySeletedInv = (InventoryCustomDTO)eswDataFactory.retrieveSelectedInv(proposalId);
					if(null!=alreadeySeletedInv)
					{
						OPPTLogger.debug("processing with already selected inventory",CLASS_NAME, methodName);
						proposalDomainDTO.setDesignatedMachineID(alreadeySeletedInv.getDesignatedMachineID());
						proposalDomainDTO.setMaterialID(alreadeySeletedInv.getMaterialID());
						proposalDomainDTO.setSerialNumber(alreadeySeletedInv.getSerialNumber());
						proposalDomainDTO.setSelectedinventory(true);
					}
			      }
			      if(inventoryCustomDTO.isChangeProposal()){
					try{
						OPPTLogger.debug("Change proposal id:"+proposalId,CLASS_NAME, methodName);
						ESWDataFactory eswDataFactory = new ESWDataFactory();
						eswDataFactory.deleteSelectedINV(proposalId);
						OPPTLogger.debug("deletedSelectedINV",CLASS_NAME, methodName);
						} catch (DomainException ce) {
							OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,"", null, ce);
						}
			      	}
			}
			//ramesh added for insert into table
			if(inventoryCustomDTO.isContinuErrSelectInv())
			{
				try {
					 ESWDataFactory eswDataFactory = new ESWDataFactory();
					 eswDataFactory.storeInventory(proposalId,inventoryCustomDTO);
					 OPPTLogger.debug("selected inventory data inserted..",CLASS_NAME, methodName);
					} catch (DomainException ce) {
						OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,methodName, null, ce);
						ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
					}
			}
			
			proposalDomainDTO.setSelCustomersList(inventoryCustomDTO.getCustomers());
			retrieveInventoryDetailInputConnectorDTO = InputConnectorDTOBuildHelper
					.buildRetrieveInvenDetailInputConnectorDTO(
							proposalDomainDTO, inventoryCustomDTO
									.getSessionId(), inventoryCustomDTO
									.getUserId(), fetchFlag, false,
							customerNoList, customerChanged, oldExtrContrNo);

		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchInventory", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		try {
			jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
		} catch (CreateException c) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchInventory", null, c);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}

		try {
			retrieveInvenDetailOutputConnectorDTO = (RetrieveInvenDetailOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(retrieveInventoryDetailInputConnectorDTO);
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchInventory", null, e1);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}

// Selected Inventory code start -Ramesh
		if(inventoryCustomDTO.isSelectedInventory() && !inventoryCustomDTO.isContinuErrSelectInv()&& !inventoryCustomDTO.isRefetch())  // checking the request is comming from Selected inventory
		{	
			OPPTLogger.debug("selected inventory data comparigion start..",CLASS_NAME, methodName);
			List errList=new ArrayList();
			boolean errInvSearch= false;
			Map custInvent = new HashMap();
			List inventoryList =null;
			List errDesignatedMachineID=null;
			List errMaterialID =null;
			List errSerialNumber=null;
			
			if(retrieveInvenDetailOutputConnectorDTO != null && ConnectorConstants.RFC_SUCCESS_CODE.equals(retrieveInvenDetailOutputConnectorDTO.getReturnCode()))
			{
//				Output data iteration and storing into the Map with key as customer number values as inventory dataList..
				List SWOConnectorDTO = retrieveInvenDetailOutputConnectorDTO.getSWOConnectorDTOList();
				if(SWOConnectorDTO!=null)
				{
					 Iterator ia1 =SWOConnectorDTO.iterator();
					 OPPTLogger.debug("swosize"+SWOConnectorDTO.size(),CLASS_NAME, methodName);
					 String custNo=null;
					 String temp="";
					 	while(ia1.hasNext())
					 	{
					 		SWOConnectorDTO si=(SWOConnectorDTO)ia1.next();
					 		custNo=si.getCustomerNumber();
					 		if(!temp.equalsIgnoreCase(custNo)){
					 			if(!"".equalsIgnoreCase(temp)&&temp!=null){
					 				custInvent.put(temp, inventoryList);
					 			}
					 			inventoryList =new ArrayList();
					 			inventoryList.add(si.getDesignatedMachine());
					 			inventoryList.add(si.getSWOMaterialNumber());
					 			inventoryList.add(si.getSWOSerialNumber());
					 			temp=custNo;
					 		}else{
					 			inventoryList.add(si.getDesignatedMachine());
					 			inventoryList.add(si.getSWOMaterialNumber());
					 			inventoryList.add(si.getSWOSerialNumber());
					 		}
					 	}
					 	if(!"".equalsIgnoreCase(temp)&& inventoryList!=null){
					 			custInvent.put(temp, inventoryList);
					 	}
					}
					 	
					//Iterating the input data & comparing with Output data				 	
						if (inventoryCustomDTO.getCustomers() != null)
						{
							int c=0;
							OPPTLogger.debug("input customers size:"+inventoryCustomDTO.getCustomers().size(),CLASS_NAME, methodName);
							Iterator iter = inventoryCustomDTO.getCustomers().iterator();
							while (iter.hasNext())
							{
								InventoryCustomDTO inventoryCustomDTO1 = new  InventoryCustomDTO();
								String errCustomer= null;
								errDesignatedMachineID=new ArrayList();
								errMaterialID =new ArrayList();
								errSerialNumber=new ArrayList();
								OPPTLogger.debug("input all customers :"+inventoryCustomDTO.getCustomers(),CLASS_NAME, methodName);
								
								CustomerListCustomDTO custListCustomDTO=(CustomerListCustomDTO)iter.next();
								errCustomer=custListCustomDTO.getCustomerNumber();
								if(custInvent.get(custListCustomDTO.getCustomerNumber())!=null)
								{
									List invDetailList = (ArrayList)custInvent.get(custListCustomDTO.getCustomerNumber());
									if(inventoryCustomDTO.getDesignatedMachineID()!=null)
									{
										Map m1=inventoryCustomDTO.getDesignatedMachineID();
										ArrayList a1=(ArrayList)m1.get(new Integer(c));
										Iterator ia1 =a1.iterator();
										String dm=new String();
										while(ia1.hasNext())
										{
											dm=(String)ia1.next();
											if(!"".equalsIgnoreCase(dm) && !invDetailList.contains(dm)){
											OPPTLogger.debug("unmatched DesignatedMachineID:"+dm,CLASS_NAME, methodName);
											errDesignatedMachineID.add(dm);
											errInvSearch=true;
											}
										}
									}
									if(inventoryCustomDTO.getMaterialID()!=null)
									{
										Map m1=inventoryCustomDTO.getMaterialID();
										ArrayList a1=(ArrayList)m1.get(new Integer(c));
										Iterator ia1 =a1.iterator();
										String mi=new String();
										while(ia1.hasNext())
										{
											mi=(String)ia1.next();
											if(!"".equalsIgnoreCase(mi) &&!invDetailList.contains(mi)){
							 				OPPTLogger.debug("unmatched MaterialID:"+mi,CLASS_NAME, methodName);
							 				errMaterialID.add(mi);
							 				errInvSearch=true;
							 				}	
										}
									}
									if(inventoryCustomDTO.getSerialNumber()!=null)
									{
										Map m1=inventoryCustomDTO.getSerialNumber();
										ArrayList a1=(ArrayList)m1.get(new Integer(c));
										Iterator ia1 =a1.iterator();
										String si=new String();
										while(ia1.hasNext())
										{
											si=(String)ia1.next();
											if(!"".equalsIgnoreCase(si) && !invDetailList.contains(si)){
												OPPTLogger.debug("unmatched SerialNumber:"+si,CLASS_NAME, methodName);
												errSerialNumber.add(si);
												errInvSearch=true;
											}	
										}
									}
									if((errDesignatedMachineID.size()>0) || errMaterialID.size()>0 || errSerialNumber.size()>0){
										inventoryCustomDTO1.setErrCustomersList(errCustomer);
										inventoryCustomDTO1.setErrDesignatedMachineID(errDesignatedMachineID);
										inventoryCustomDTO1.setErrMaterialID(errMaterialID);
										inventoryCustomDTO1.setErrSerialNumber(errSerialNumber);
										errList.add(inventoryCustomDTO1);
									}
							 }else{
							 		errInvSearch=true;
							 		errCustomer=custListCustomDTO.getCustomerNumber();
							 		errDesignatedMachineID.add("");
							 		errMaterialID.add("");
							 		errSerialNumber.add("");
							 		inventoryCustomDTO1.setErrCustomersList(errCustomer);
							 		inventoryCustomDTO1.setErrDesignatedMachineID(errDesignatedMachineID);
								 	inventoryCustomDTO1.setErrMaterialID(errMaterialID);
								 	inventoryCustomDTO1.setErrSerialNumber(errSerialNumber);
								 	OPPTLogger.debug("errInvSearch:"+errInvSearch,CLASS_NAME, methodName);
								 	errList.add(inventoryCustomDTO1);
							 	}
							 	c++;
						}
							OPPTLogger.debug("unmatched inventory Size:"+errList.size(),CLASS_NAME, methodName);
							inventoryCustomDTO.setErrListData(errList);
					}
			}
			
			if(errInvSearch && errList.size()>0){
				inventoryCustomDTO.setErrSelectedInventory(true);
				OPPTLogger.debug("Selected inventory is unmatched so returning to new page:",CLASS_NAME, methodName);
				return inventoryCustomDTO;
			}
				//Selected search Success then we have to insert the data into DB
			try {
				ESWDataFactory eswDataFactory = new ESWDataFactory();
				eswDataFactory.storeInventory(proposalId,inventoryCustomDTO);
				OPPTLogger.debug("Selected inventory is unmatched so returning to new page:",CLASS_NAME, methodName);
				}catch (DomainException ce) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,methodName, null, ce);
					ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
				}
		}
//Selected Inventory code end -Ramesh

		if (retrieveInvenDetailOutputConnectorDTO != null
				&& ConnectorConstants.RFC_SUCCESS_CODE
						.equals(retrieveInvenDetailOutputConnectorDTO
								.getReturnCode())) {
			int decimalValue = 0;
			try {
				ProposalDataManagerLocal proposalDataManagerLocal = HomeProvider
						.getProposalDataManagerLocal();
				if (proposalContractBO.getCurrency() != null) {
					CurrencyDomainDTO currencyDomainDTO = proposalDataManagerLocal
							.getCurrencyInformation(proposalContractBO
									.getCurrency());
					decimalValue = currencyDomainDTO.getDecimalAllowed();
				}
			} catch (CreateException c) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						"fetchInventory", null, c);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}
			DomainDTOBuildHelper.populateProposalDomainDTO(proposalDomainDTO,
					retrieveInvenDetailOutputConnectorDTO, null, false,
					decimalValue, fetchFlag);
			//			OPPTLogger.debug("B4 Validate method", CLASS_NAME, methodName);
			//			DomainDTOBuildHelper.validatePlanDates(proposalDomainDTO);
			//			OPPTLogger.debug("After Validate method", CLASS_NAME,
			// methodName);

			/* Start change CR6153 */
			if ((proposalContractBO.getExtendPeriod() != null)
					&& (proposalContractBO.getExtendPeriod()
							.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {
				populateInventoryForAllYears(proposalDomainDTO);
			}
			/* End change CR6153 */

			if (proposalDomainDTO.getCustomerDTOList().size() > 0) {

				customerDomainDTOList = proposalDomainDTO.getCustomerDTOList();

				Iterator iterateCustomer = customerDomainDTOList.iterator();
				while (iterateCustomer.hasNext()) {

					customerDomainDTO = (CustomerDomainDTO) iterateCustomer
							.next();
					try {
						inventoryManagerLocal.storeInventory(customerDomainDTO);
					} catch (ServiceException se) {
						getSessionContext().setRollbackOnly();
						throw se;
					}
				}
				proposalContractBO.setEswFetchDate(new Date(
						retrieveInvenDetailOutputConnectorDTO.getSystemDate()
								.getTime()));
				proposalContractBO
						.setEswFetchTime(retrieveInvenDetailOutputConnectorDTO
								.getSystemTime());
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT);
				proposalContractBO.setInvoiceAmount(0.0);
				proposalContractBO.setFetchDate(new Date(new java.util.Date()
						.getTime()));
			}
		} else if (retrieveInvenDetailOutputConnectorDTO != null
				&& UtilityConstants.NO_INVENTORY_AVAIL_CODE
						.equals(retrieveInvenDetailOutputConnectorDTO
								.getReturnCode())) {
			proposalContractBO.setFetchDate(new Date(new java.util.Date()
					.getTime()));
			if (!fetchFlag) {
				storeErrorList(UtilityConstants.NO_RE_INVENTORY_AVAIL_CODE,
						proposalId, inventoryCustomDTO.getUserId(),
						"Fetch Inventory");
				inventoryCustomDTO.addMessageEntry(
						UtilityConstants.NO_RE_INVENTORY_AVAIL_CODE,
						OPPTMessageCatalog.TYPE_BACKEND);
			} else {
				storeErrorList(retrieveInvenDetailOutputConnectorDTO
						.getReturnCode(), proposalId, inventoryCustomDTO
						.getUserId(), "Fetch Inventory");
				inventoryCustomDTO.addMessageEntry(
						retrieveInvenDetailOutputConnectorDTO.getReturnCode(),
						OPPTMessageCatalog.TYPE_BACKEND);
			}

		} else {
			storeErrorList(retrieveInvenDetailOutputConnectorDTO
					.getReturnCode(), proposalId, inventoryCustomDTO
					.getUserId(), "Fetch Inventory");
			throwServiceException(retrieveInvenDetailOutputConnectorDTO
					.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
		}

		if (inventoryCustomDTO.getFetchType().equalsIgnoreCase(
				UtilityConstants.YES)) {
			proposalContractBO
					.setRefetchId(InventoryCustomDTO.REFETCH_INVENTORY);
		}
		//update the proposalBO
		try {
			proposalContractBOFactory
					.updateProposalContractBO(proposalContractBO);
		} catch (DomainException e2) {
			throw ExceptionGenerator.generateServiceException(e2
					.getErrorReport());
		}
		timeTaken.end();
		return inventoryCustomDTO;
	}

	/**
	 *
	 * This method get the error message from message catalogue and store this
	 * message in error list object
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 4, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param returnCode
	 */
	private void storeErrorList(String returnCode, int proposalId,
			String userId, String methodName) throws ServiceException {

		String className = ProposalManagerBean.CLASS_NAME;
		ErrorListBO errorBO = new ErrorListBO();
		ErrorListBOFactory errorBOFactory = new ErrorListBOFactory();
		ErrorReport errorReport = new ErrorReport();
		ErrorKey key = new ErrorKey(returnCode, OPPTMessageCatalog.TYPE_BACKEND);
		errorReport.addErrorEntry(key, null);
		OPPTMessageCatalog messageCat = OPPTMessageCatalog.getInstance();
		messageCat.populateErrorReport(errorReport);
		ErrorEntry entry = (ErrorEntry) errorReport.get(key);
		if (null != entry) {
			String errorMessage = entry.getErrorMessage();
			if (returnCode != null
					&& UtilityConstants.NO_FI_INVENTORY_AVAIL_CODE
							.equals(returnCode)
					|| UtilityConstants.NO_RE_INVENTORY_AVAIL_CODE
							.equals(returnCode)
					|| UtilityConstants.NO_DE_INVENTORY_AVAIL_CODE
							.equals(returnCode)
					|| UtilityConstants.NO_FP_INVENTORY_AVAIL_CODE
							.equals(returnCode)) {
				errorBO.setMessageNo(Double
						.parseDouble(UtilityConstants.NO_INVENTORY_AVAIL_CODE));
			} else {
				errorBO.setMessageNo(Double.parseDouble(returnCode));
			}
			errorBO.setMessageDesc(errorMessage);
			errorBO.setProposalId(proposalId);
			errorBO.setUserId(userId);
			errorBO.setMethodName(methodName);
			ErrorListManagerLocal errorListManagerLocal = null;
			try {
				errorListManagerLocal = HomeProvider.getErrorListManagerLocal();
			} catch (CreateException re) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}
			errorListManagerLocal.storeErrorList(errorBO);
		}
	}

	private void storeErrorList(String returnCode, int proposalId,
			String userId, String methodName, String messageDetail)
			throws ServiceException {

		String className = ProposalManagerBean.CLASS_NAME;
		ErrorListBO errorBO = new ErrorListBO();
		ErrorListBOFactory errorBOFactory = new ErrorListBOFactory();
		ErrorReport errorReport = new ErrorReport();
		ErrorKey key = new ErrorKey(returnCode, OPPTMessageCatalog.TYPE_BACKEND);
		errorReport.addErrorEntry(key, null);
		OPPTMessageCatalog messageCat = OPPTMessageCatalog.getInstance();
		messageCat.populateErrorReport(errorReport);
		ErrorEntry entry = (ErrorEntry) errorReport.get(key);
		if (null != entry) {
			String errorMessage = entry.getErrorMessage();
			errorBO.setMessageNo(Double.parseDouble(returnCode));
			errorBO.setMessageDesc(errorMessage);
			errorBO.setProposalId(proposalId);
			errorBO.setUserId(userId);
			errorBO.setMethodName(methodName);
			errorBO.setMessageDetail(messageDetail);
			ErrorListManagerLocal errorListManagerLocal = null;
			try {
				errorListManagerLocal = HomeProvider.getErrorListManagerLocal();
			} catch (CreateException re) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}
			errorListManagerLocal.storeErrorList(errorBO);
		}
	}

	/**
	 *
	 * This method retrieves the default date range of the proposal
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 4, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param inventoryDateRangeCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public InventoryDateRangeCustomDTO initiateFetchPlannedInventory(
			InventoryDateRangeCustomDTO inventoryDateRangeCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME,
				"initiateFetchPlannedInventory");

		int proposalId = 0;
		ProposalContractBOFactory proposalContractBOFactory = null;
		proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalContractBO proposalContractBO = null;
		boolean preCondtn = false;
		//check codtn here
		try {
			HashMap map = new HashMap();
			map.put(UtilityConstants.BO_USERID, inventoryDateRangeCustomDTO
					.getUserId());
			map.put(UtilityConstants.BO_GROUPNAME, inventoryDateRangeCustomDTO
					.getGroupName());
			proposalId = inventoryDateRangeCustomDTO.getProposalDTO().getId();
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
			SharingBO sharingBO = getSharingBOFromFactory(proposalContractBO
					.getProposalId(), inventoryDateRangeCustomDTO.getUserId());
			if (null != sharingBO) {
				map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}
			proposalContractBO.validateFetchPlan(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);

		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}

		inventoryDateRangeCustomDTO.setDefaultStartDate(proposalContractBO
				.getContrStartPeriod());
		inventoryDateRangeCustomDTO.setDefaultEndDate(proposalContractBO
				.getContrEndPeriod());
		inventoryDateRangeCustomDTO.setStartYears(OPPTCalender
				.getStartYearList());
		inventoryDateRangeCustomDTO.setEndYears(OPPTCalender.getEndYearList());

		timeTaken.end();

		return inventoryDateRangeCustomDTO;
	}

	/**
	 *
	 * This method retrieves the quotes list as part of the inventory
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 4, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param quotesListCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
public QuotesListCustomDTO fetchPlannedInventory(
			QuotesListCustomDTO quotesListCustomDTO) throws ServiceException {

		String methodName = "fetchPlannedInventory";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		ProposalCustomDTO proposalCustomDTO = null;
		int proposalId = 0;
		// bean instances
		InventoryManagerLocal inventoryManagerLocal = null;
		JMSConnectorLocalHome jmsConnectorLocalHome = null;
		JMSConnectorLocal jmsConnectorLocal = null;
		ProposalDomainDTO proposalDomainDTO = null;
		CustomerDomainDTO customerDomainDTO = null;
		List dmDTOList = null;
		List swoDTOList = null;
		List eeDTOList = null;
		DMDomainDTO dmDomainDTO = null;
		SWOConnectorDTO swoConnectorDTO = null;
		EEConnectorDTO eeConnectorDTO = null;
		SWODomainDTO swoDomainDTO = null;
		EEDomainDTO eeDomainDTO = null;
		//connecto dto instances
		RetrieveInvenDetailInputConnectorDTO retrieveInventoryDetailInputConnectorDTO = null;
		RetrieveInvenDetailOutputConnectorDTO retrieveInvenDetailOutputConnectorDTO = null;
		ProposalContractBO proposalContractBO = null;
		List customerDTOList = null;
		// Custom dto instance
		QuoteCustomDTO quoteCustomDTO = null;
		boolean custChanged = false;
		TreeMap quotes = new TreeMap();
		//factory instances
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		proposalCustomDTO = quotesListCustomDTO.getProposalDTO();
		proposalId = proposalCustomDTO.getId();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de
					.getErrorReport());
		}

		//	validate date ranges
		boolean isValidDateRange = false;
		proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
		isValidDateRange = validateDateRange(quotesListCustomDTO,
				proposalDomainDTO);
		if (isValidDateRange) {

			try {
				String oldExtrContrNo = null;
				if (proposalDomainDTO.getContrType() != null
						&& proposalDomainDTO.getContrType().trim().equals(
								ContractTypeConstants.AMENDMENT)
						|| proposalDomainDTO.getContrType().trim().equals(
								ContractTypeConstants.RENEWAL)
						|| proposalDomainDTO.getContrType().trim().equals(
								ContractTypeConstants.REPLACEMENT)) {
					ProposalContractBO oldProposal = null;
					try {
						oldProposal = proposalContractBOFactory
								.getProposalContractBOForContractNumber(
										proposalDomainDTO.getOldContrNo(), true);
					} catch (DomainException d) {
						throw ExceptionGenerator.generateServiceException(d
								.getErrorReport());
					}
					if (oldProposal != null
							&& oldProposal.getExtContrNo() != null
							&& !oldProposal.getExtContrNo().equals("")) {
						oldExtrContrNo = oldProposal.getExtContrNo();
						OPPTLogger.debug("Old Ext Contr No " + oldExtrContrNo,
								CLASS_NAME, methodName);
					} else {
						if (oldProposal != null) {
							oldExtrContrNo = oldProposal.getContrNo();
							OPPTLogger.debug("Contr No " + oldExtrContrNo,
									CLASS_NAME, methodName);
						}
					}
				}

				inventoryManagerLocal = getInventoryManagerLocal();
				proposalDomainDTO = inventoryManagerLocal
						.retrieveCustomerForProposal(proposalDomainDTO);
				// Create the connector DTO Object and set the values
				List customerNoList = new ArrayList();
				
				if (proposalDomainDTO != null
						&& proposalDomainDTO.getCustomerDTOList() != null) {
					for (int i = 0; i < proposalDomainDTO.getCustomerDTOList()
							.size(); i++) {
						customerDomainDTO = (CustomerDomainDTO) proposalDomainDTO
								.getCustomerDTOList().get(i);
						CustomerListCustomDTO customerListCustomDTO = new CustomerListCustomDTO();
						//sateesh Anne DADO02 BHWave1
						customerListCustomDTO.setCustomerName(customerDomainDTO.getSapCustomerName());
						customerListCustomDTO.setCustomerNumber(customerDomainDTO.getSapCustomerNo());
						//sateesh Anne DADO02 BHWave
						//customerNoList.add(customerDomainDTO.getSapCustomerNo());
						customerNoList.add(customerListCustomDTO);
					}
					proposalDomainDTO.setSelCustomersList(customerNoList); //Sateesh Anne DADO02 BHWave1
				}
				retrieveInventoryDetailInputConnectorDTO = InputConnectorDTOBuildHelper
						.buildRetrieveInvenDetailInputConnectorDTO(
								proposalDomainDTO, quotesListCustomDTO
										.getSessionId(), quotesListCustomDTO
										.getUserId(), true, true,
								customerNoList, custChanged, oldExtrContrNo);
				jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
				retrieveInvenDetailOutputConnectorDTO = (RetrieveInvenDetailOutputConnectorDTO) jmsConnectorLocal
						.sendReceive(retrieveInventoryDetailInputConnectorDTO);
			} catch (Exception e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						"fetchInventory", null, e);
				throwServiceException(ErrorCodeConstants.SE0801,
						OPPTMessageCatalog.TYPE_SERVICE);
			}

			if (retrieveInvenDetailOutputConnectorDTO != null
					&& ConnectorConstants.RFC_SUCCESS_CODE
							.equals(retrieveInvenDetailOutputConnectorDTO
									.getReturnCode())) {
				
				int decimalValue = 0;
				DomainDTOBuildHelper.populateProposalDomainDTO(
						proposalDomainDTO,
						retrieveInvenDetailOutputConnectorDTO, null, false,
						decimalValue, true);
				boolean isQuotesPulled = false;
				int quotesPulledCount = 0;
				ArrayList eeCustomDTOList = new ArrayList();

				if (proposalDomainDTO.getCustomerDTOList().size() > 0) {
					customerDTOList = proposalDomainDTO.getCustomerDTOList();
					for (int i = 0; i < customerDTOList.size(); i++) {
						customerDomainDTO = (CustomerDomainDTO) customerDTOList
								.get(i);
						dmDTOList = customerDomainDTO.getDMDTOList();
						if (dmDTOList != null && dmDTOList.size() > 0) {
							for (int j = 0; j < dmDTOList.size(); j++) {
								dmDomainDTO = (DMDomainDTO) dmDTOList.get(j);
								swoDTOList = dmDomainDTO.getSWODTOList();
					
								if (swoDTOList != null && swoDTOList.size() > 0) {
										for (int k = 0; k < swoDTOList.size(); k++) {
										swoDomainDTO = (SWODomainDTO) swoDTOList
												.get(k);
										if (LicenseConstants.QUOTE_FLAG
												.equalsIgnoreCase(swoDomainDTO
														.getItemCategory())) {
											quoteCustomDTO = new QuoteCustomDTO();
											// verify with sara
											quoteCustomDTO
													.setCraid(swoDomainDTO
															.getRequestDeliveryDate());
											quoteCustomDTO
													.setQuoteNumber(swoDomainDTO
															.getSalesDocNo());
											quoteCustomDTO
													.setDetails(swoDomainDTO
															.getSwoDesc());
											isQuotesPulled = inventoryManagerLocal
													.verifyLicensesAlreadyExists(swoDomainDTO);
											if (isQuotesPulled) {
												quotesPulledCount++;
											}
											quoteCustomDTO
													.setQuoteAdded(isQuotesPulled);
											String quoteNo = swoDomainDTO
													.getSalesDocNo();
											quoteCustomDTO.setId(quoteNo);
											OPPTLogger.debug("Quote no is"
													+ quoteNo, CLASS_NAME,
													methodName);
					
											quotes.put(quoteNo, quoteCustomDTO);
											OPPTLogger.debug("quotes "
													+ quotes.size(),
													CLASS_NAME, methodName);
										}
									}
								}
							}
						}
					}
					quotesListCustomDTO.setQuotes(quotes);
					if (0 == quotes.size()) {
						quotesListCustomDTO
								.addButtonFlag(ButtonConstants.CLEAR_ALL);
						quotesListCustomDTO
								.addButtonFlag(ButtonConstants.CANCEL);
						quotesListCustomDTO
								.addButtonFlag(ButtonConstants.SELECT_ALL);
					}
					// ESWDataFactory eswDataFactory = new ESWDataFactory();
					/*
					 * Fix for GWA - XA Defect 11 Saravanan
					 */
					//try {
					if (quotes != null && quotes.size() > 0) {
						try {
							ESWDataLocal eswDataLocal = HomeProvider
									.getESWDataLocal();
							eswDataLocal.storeESWData(quotesListCustomDTO
									.getSessionId(),
									retrieveInvenDetailOutputConnectorDTO,
									proposalId, UtilityConstants.FETCH_PLAN);
						} catch (CreateException ce) {
							OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR,
									CLASS_NAME, methodName, null, ce);
							ExceptionGenerator
									.generateServiceException(ErrorCodeConstants.SE0801);
						}
						//eswDataFactory.storeESWData(quotesListCustomDTO.getSessionId(),
						// retrieveInvenDetailOutputConnectorDTO, proposalId,
						// UtilityConstants.FETCH_PLAN);
					} else {
						quotesListCustomDTO.addMessageEntry(
								ErrorCodeConstants.SE0124,
								OPPTMessageCatalog.TYPE_SERVICE);
					}
					/*
					 * } catch (DomainException d) { throw
					 * ExceptionGenerator.generateServiceException(d.getErrorReport()); }
					 */
				}
			} else if (retrieveInvenDetailOutputConnectorDTO != null
					&& UtilityConstants.NO_INVENTORY_AVAIL_CODE
							.equals(retrieveInvenDetailOutputConnectorDTO
									.getReturnCode())) {
					storeErrorList(UtilityConstants.NO_FP_INVENTORY_AVAIL_CODE,
						proposalId, quotesListCustomDTO.getUserId(),
						"Fetch Planned Inventory");
				quotesListCustomDTO.addMessageEntry(
						UtilityConstants.NO_FP_INVENTORY_AVAIL_CODE,
						OPPTMessageCatalog.TYPE_BACKEND);

			} else {
						storeErrorList(retrieveInvenDetailOutputConnectorDTO
						.getReturnCode(), proposalId, quotesListCustomDTO
						.getUserId(), "Fetch Planned Inventory");
				throwServiceException(retrieveInvenDetailOutputConnectorDTO
						.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
			}

		} else {
			throwServiceException(ErrorCodeConstants.SE0101,
					OPPTMessageCatalog.TYPE_SERVICE);
		}
		timeTaken.end();
		return quotesListCustomDTO;
	}

	/**
	 *
	 * This method returns the Inventory Manager local home
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 5, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @return
	 * @throws ServiceException
	 */
	private InventoryManagerLocal getInventoryManagerLocal()
			throws ServiceException {
		InventoryManagerLocal inventoryManagerLocal = null;
		try {
			inventoryManagerLocal = HomeProvider.getInventoryManagerLocal();
		} catch (CreateException c) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchInventory", null, c);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return inventoryManagerLocal;
	}

	private UserManagerLocal getUserManagerLocal() throws ServiceException {
		UserManagerLocal userManagerLocal = null;
		try {
			userManagerLocal = HomeProvider.getUserManagerLocal();
		} catch (CreateException c) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchInventory", null, c);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return userManagerLocal;
	}

	/**
	 *
	 * This method validate date range selected by the user
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 4, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param quotesListCustomDTO
	 * @return
	 */
	private boolean validateDateRange(QuotesListCustomDTO quotesListCustomDTO,
			ProposalDomainDTO proposalDomainDTO) {
		boolean isValidDateRange = false;
		java.util.Date selStartDate = null;
		java.util.Date selEndDate = null;
		java.util.Date defaultStartDate = null;
		java.util.Date defaultEndDate = null;
		selStartDate = quotesListCustomDTO.getFromDate();
		selEndDate = quotesListCustomDTO.getToDate();
		defaultStartDate = proposalDomainDTO.getContrStartDate();
		defaultEndDate = proposalDomainDTO.getContrEndDate();

		if (selStartDate != null && selEndDate != null) {
			if ((selStartDate.getTime() >= defaultStartDate.getTime())
					&& (selEndDate.getTime() <= defaultEndDate.getTime())) {
				isValidDateRange = true;
				proposalDomainDTO.setContrStartPeriod(new Date(selStartDate
						.getTime()));
				proposalDomainDTO.setContrEndPeriod(new Date(selEndDate
						.getTime()));
			}
		} else {
			isValidDateRange = true;
		}
		return isValidDateRange;
	}

	/**
	 *
	 * This method adds the planned inventory as part of proposal
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 4, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param plannedInventoryCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public PlannedInventoryCustomDTO addPlannedInventory(
			PlannedInventoryCustomDTO plannedInventoryCustomDTO)
			throws ServiceException {

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "addPlannedInventory");
		//Instance of method level variable

		InventoryManagerLocal inventoryManagerLocal = null;
		TreeMap selectedQuotes = null;
		Map retrieveValue = null;
		QuoteCustomDTO qutoeCustomDTO = null;
		RetrieveInvenDetailOutputConnectorDTO retrieveInvenDetailOutputConnectorDTO = null;
		//Proposal details instances
		ProposalDomainDTO proposalDomainDTO = null;
		ProposalContractDTOFactory proposalContractDTOFactory = null;
		List customerDomainList = null;
		List selectedSalesDocNumberList = null;
		CustomerDomainDTO customerDomainDTO = null;
		boolean isProposal = false;

		//for test
		selectedQuotes = plannedInventoryCustomDTO.getSelectedQuotes();
		Set keySet = selectedQuotes.keySet();
		Iterator iterateKey = keySet.iterator();
		proposalContractDTOFactory = new ProposalContractDTOFactory();
		selectedSalesDocNumberList = new ArrayList();
		ProposalCustomDTO proposalDTO = plannedInventoryCustomDTO
				.getProposalDTO();
		int proposalId = proposalDTO.getId();
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalContractBO proposalContractBO = null;
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de
					.getErrorReport());
		}
		proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
		proposalDomainDTO.setActionName(ActionNameConstants.ADD_PLANNED_QUOTES);
		inventoryManagerLocal = getInventoryManagerLocal();
		proposalDomainDTO = inventoryManagerLocal
				.retrieveCustomerForProposal(proposalDomainDTO);

		while (iterateKey.hasNext()) {
			qutoeCustomDTO = (QuoteCustomDTO) selectedQuotes.get(iterateKey
					.next());
			String selectedNumber = qutoeCustomDTO.getId();
			OPPTLogger.debug("Selected number = " + selectedNumber, CLASS_NAME,
					"addPlannedInventory");
			selectedSalesDocNumberList.add(selectedNumber);
		}

		//ESWDataFactory eswDataFactory = new ESWDataFactory();

		try {
			if (selectedSalesDocNumberList.size() > 0) {
				//retrieveValue =
				// eswDataFactory.getESWData(plannedInventoryCustomDTO.getSessionId(),
				// proposalId, UtilityConstants.FETCH_PLAN);
				/*
				 * GWA defect XA Sara
				 */
				try {
					ESWDataLocal eswDataLocal = HomeProvider.getESWDataLocal();
					retrieveValue = eswDataLocal.retrieveESWData(
							plannedInventoryCustomDTO.getSessionId(),
							proposalId, UtilityConstants.FETCH_PLAN);
				} catch (CreateException ce) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							"addPlannedInventory", null, ce);
					ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0801);
				}
				OPPTLogger.debug("retrieveValue = " + retrieveValue,
						CLASS_NAME, "addPlannedInventory");
				retrieveInvenDetailOutputConnectorDTO = (RetrieveInvenDetailOutputConnectorDTO) retrieveValue
						.get(UtilityConstants.CONNECTOR_DTO);
				OPPTLogger.debug("retrieveInvenDetailOutputConnectorDTO = "
						+ retrieveInvenDetailOutputConnectorDTO, CLASS_NAME,
						"fetchInventory");
				int decimalValue = 0;
				try {
					ProposalDataManagerLocal proposalDataManagerLocal = HomeProvider
							.getProposalDataManagerLocal();
					if (proposalContractBO.getCurrency() != null) {
						CurrencyDomainDTO currencyDomainDTO = proposalDataManagerLocal
								.getCurrencyInformation(proposalContractBO
										.getCurrency());
						decimalValue = currencyDomainDTO.getDecimalAllowed();
					}
				} catch (CreateException c) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							"addPlannedInventory", null, c);
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0801);
				}
				DomainDTOBuildHelper.populateProposalDomainDTO(
						proposalDomainDTO,
						retrieveInvenDetailOutputConnectorDTO,
						selectedSalesDocNumberList, false, decimalValue, true);
				//DomainDTOBuildHelper.validatePlanDates(proposalDomainDTO);

				customerDomainList = proposalDomainDTO.getCustomerDTOList();
				for (int i = 0; i < customerDomainList.size(); i++) {
					customerDomainDTO = (CustomerDomainDTO) customerDomainList
							.get(i);

					try {
						inventoryManagerLocal.storeInventory(customerDomainDTO);

					} catch (ServiceException se) {
						getSessionContext().setRollbackOnly();
						throw se;
					}
				}
				//eswDataFactory.deleteESWData(plannedInventoryCustomDTO.getSessionId(),
				// proposalId, UtilityConstants.FETCH_PLAN);

				/* Fix for GWA XADataSource by Sara - CMVC Defect 11 */
				try {
					ESWDataLocal eswDataLocal = HomeProvider.getESWDataLocal();
					eswDataLocal.deleteESWData(plannedInventoryCustomDTO
							.getSessionId(), proposalId,
							UtilityConstants.FETCH_PLAN);
				} catch (CreateException ce) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							"addIneligibleInventoryToProposal", null, ce);
					ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0801);
				}

				isProposal = proposalContractBO.isProposal();
				if (isProposal) {
					proposalContractBO
							.setStatusCode(ProposalContractStatusConstants.DRAFT);
					proposalContractBO.setInvoiceAmount(0.0);
				} else {
					proposalContractBO
							.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
					proposalContractBO.setInvoiceAmount(0.0);
				}

				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);

			}
		} catch (Exception d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"addPlannedInventory", null, d);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		timeTaken.end();
		return plannedInventoryCustomDTO;
	}

	/**
	 *
	 * This method adds the ineligible licenses in to proposal
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 4, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param ineligibleLicensesCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public IneligibleLicensesCustomDTO addIneligibleInventoryToProposal(
			IneligibleLicensesCustomDTO ineligibleLicensesCustomDTO)
			throws ServiceException {

		String methodName = "addIneligibleInventoryToProposal";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		//bean and custom dto instances
		TreeMap licenseEffectiveDate = null;
		TreeMap deliveryBlockCheck = null;
		TreeMap licensesFailingWithSvc = null;
		TreeMap sAndSLicenseEffectiveDate = null;
		TreeMap sAndSDeliveryBlockCheck = null;
		TreeMap sAndSlicensesFailingWithSvc = null;
		Map retrieveValue = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		IneligibleSWOCustomDTO swoCustomDTO = null;
		//proposal inatances
		ProposalDomainDTO proposalDomainDTO = null;
		List customerDomainList = null;
		boolean isProposal = false;
		CustomerDomainDTO customerDomainDTO = null;
		RetrieveInvenDetailOutputConnectorDTO retrieveInvenDetailOutputConnectorDTO = null;

		ProposalCustomDTO proposalDTO = ineligibleLicensesCustomDTO
				.getProposalDTO();
		int proposalId = proposalDTO.getId();
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalContractBO proposalContractBO = null;
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de
					.getErrorReport());
		}
		proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
		inventoryManagerLocal = getInventoryManagerLocal();
		proposalDomainDTO = inventoryManagerLocal
				.retrieveCustomerForProposal(proposalDomainDTO);
		// retrieval from tree map
		deliveryBlockCheck = ineligibleLicensesCustomDTO
				.getLicensesFailingDueToDeleveryBlockDate();
		licenseEffectiveDate = ineligibleLicensesCustomDTO
				.getLicensesFailingLicenseEffectiveDateCheck();
		licensesFailingWithSvc = ineligibleLicensesCustomDTO
		.getLicensesFailingWithSvc();
		sAndSLicenseEffectiveDate = ineligibleLicensesCustomDTO
				.getSAndSLicensesFailingDueToDeleveryBlockDate();
		sAndSDeliveryBlockCheck = ineligibleLicensesCustomDTO
				.getSAndSLicensesFailingLicenseEffectiveDateCheck();
		sAndSlicensesFailingWithSvc = ineligibleLicensesCustomDTO
		.getSAndSLicensesFailingWithSvc();
		List selEquipmentNoList = new ArrayList();

		if (deliveryBlockCheck != null && deliveryBlockCheck.size() > 0) {
			Set keySet = deliveryBlockCheck.keySet();
			Iterator iterateKey = keySet.iterator();
			while (iterateKey.hasNext()) {
				swoCustomDTO = (IneligibleSWOCustomDTO) deliveryBlockCheck
						.get(iterateKey.next());
				String selEquipmentNo = swoCustomDTO.getEquipmentNo();
				OPPTLogger.debug(
						"Delivery Block Check ####Selected Equipment no :"
								+ selEquipmentNo + "DM No:"
								+ swoCustomDTO.getDmNumber() + "SWO No:"
								+ swoCustomDTO.getSwoNumber() + "Serial No:"
								+ swoCustomDTO.getSwoSerialNumber(),
						CLASS_NAME, methodName);
				selEquipmentNoList.add(swoCustomDTO.getKey());
			}
		}

		if (licenseEffectiveDate != null && licenseEffectiveDate.size() > 0) {
			Set keySet = licenseEffectiveDate.keySet();
			Iterator iterateKey = keySet.iterator();
			while (iterateKey.hasNext()) {
				swoCustomDTO = (IneligibleSWOCustomDTO) licenseEffectiveDate
						.get(iterateKey.next());
				String selEquipmentNo = swoCustomDTO.getEquipmentNo();
				OPPTLogger.debug(
						"License Effective date ####Selected Equipment no"
								+ selEquipmentNo + "DM No:"
								+ swoCustomDTO.getDmNumber() + "SWO No:"
								+ swoCustomDTO.getSwoNumber() + "Serial No:"
								+ swoCustomDTO.getSwoSerialNumber(),
						CLASS_NAME, methodName);
				selEquipmentNoList.add(swoCustomDTO.getKey());
			}
		}
		if (licensesFailingWithSvc != null && licensesFailingWithSvc.size() > 0) {
			Set keySet = licensesFailingWithSvc.keySet();
			Iterator iterateKey = keySet.iterator();
			while (iterateKey.hasNext()) {
				swoCustomDTO = (IneligibleSWOCustomDTO) licensesFailingWithSvc
						.get(iterateKey.next());
				String selEquipmentNo = swoCustomDTO.getEquipmentNo();
				OPPTLogger.debug(
						"License Failing with SVC ####Selected Equipment no"
								+ selEquipmentNo + "DM No:"
								+ swoCustomDTO.getDmNumber() + "SWO No:"
								+ swoCustomDTO.getSwoNumber() + "Serial No:"
								+ swoCustomDTO.getSwoSerialNumber(),
						CLASS_NAME, methodName);
				selEquipmentNoList.add(swoCustomDTO.getKey());
			}
		}

		if (sAndSDeliveryBlockCheck != null
				&& sAndSDeliveryBlockCheck.size() > 0) {
			Set keySet = sAndSDeliveryBlockCheck.keySet();
			Iterator iterateKey = keySet.iterator();
			while (iterateKey.hasNext()) {
				swoCustomDTO = (IneligibleSWOCustomDTO) sAndSDeliveryBlockCheck
						.get(iterateKey.next());
				String selEquipmentNo = swoCustomDTO.getEquipmentNo();
				OPPTLogger.debug(
						"S&S Delivery Block Check ####Selected Equipment no :"
								+ selEquipmentNo + "DM No:"
								+ swoCustomDTO.getDmNumber() + "SWO No:"
								+ swoCustomDTO.getSwoNumber() + "Serial No:"
								+ swoCustomDTO.getSwoSerialNumber(),
						CLASS_NAME, methodName);
				selEquipmentNoList.add(swoCustomDTO.getKey());
			}
		}

		if (sAndSLicenseEffectiveDate != null
				&& sAndSLicenseEffectiveDate.size() > 0) {
			Set keySet = sAndSLicenseEffectiveDate.keySet();
			Iterator iterateKey = keySet.iterator();
			while (iterateKey.hasNext()) {
				swoCustomDTO = (IneligibleSWOCustomDTO) sAndSLicenseEffectiveDate
						.get(iterateKey.next());
				String selEquipmentNo = swoCustomDTO.getEquipmentNo();
				OPPTLogger.debug(
						"S&S License Effective date ####Selected Equipment no"
								+ selEquipmentNo + "DM No:"
								+ swoCustomDTO.getDmNumber() + "SWO No:"
								+ swoCustomDTO.getSwoNumber() + "Serial No:"
								+ swoCustomDTO.getSwoSerialNumber(),
						CLASS_NAME, methodName);
				selEquipmentNoList.add(swoCustomDTO.getKey());
			}
		}
		if (sAndSlicensesFailingWithSvc != null
				&& sAndSlicensesFailingWithSvc.size() > 0) {
			Set keySet = sAndSlicensesFailingWithSvc.keySet();
			Iterator iterateKey = keySet.iterator();
			while (iterateKey.hasNext()) {
				swoCustomDTO = (IneligibleSWOCustomDTO) sAndSlicensesFailingWithSvc
						.get(iterateKey.next());
				String selEquipmentNo = swoCustomDTO.getEquipmentNo();
				OPPTLogger.debug(
						"S&S License Failing with SVC ####Selected Equipment no"
								+ selEquipmentNo + "DM No:"
								+ swoCustomDTO.getDmNumber() + "SWO No:"
								+ swoCustomDTO.getSwoNumber() + "Serial No:"
								+ swoCustomDTO.getSwoSerialNumber(),
						CLASS_NAME, methodName);
				selEquipmentNoList.add(swoCustomDTO.getKey());
			}
		}

		//ESWDataFactory eswDataFactory = new ESWDataFactory();
		try {
			if (selEquipmentNoList != null && selEquipmentNoList.size() > 0) {
				proposalDomainDTO
						.setActionName(ActionNameConstants.ADD_INELIGIBLE_LICENSES);
				//retrieveValue =
				// eswDataFactory.getESWData(ineligibleLicensesCustomDTO.getSessionId(),
				// proposalId, UtilityConstants.FETCH_INELIGIBLE);
				/*
				 * GWA defect XA Sara
				 */
				try {
					ESWDataLocal eswDataLocal = HomeProvider.getESWDataLocal();
					retrieveValue = eswDataLocal.retrieveESWData(
							ineligibleLicensesCustomDTO.getSessionId(),
							proposalId, UtilityConstants.FETCH_INELIGIBLE);
				} catch (CreateException ce) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							"addPlannedInventory", null, ce);
					ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0801);
				}
				retrieveInvenDetailOutputConnectorDTO = (RetrieveInvenDetailOutputConnectorDTO) retrieveValue
						.get(UtilityConstants.CONNECTOR_DTO);
				int decimalValue = 0;
				try {
					ProposalDataManagerLocal proposalDataManagerLocal = HomeProvider
							.getProposalDataManagerLocal();
					if (proposalContractBO.getCurrency() != null) {
						CurrencyDomainDTO currencyDomainDTO = proposalDataManagerLocal
								.getCurrencyInformation(proposalContractBO
										.getCurrency());
						decimalValue = currencyDomainDTO.getDecimalAllowed();
					}
				} catch (CreateException c) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							"addIneligibleInventoryToProposal", null, c);
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0801);
				}
				OPPTLogger.debug("B4 Populating object----List"
						+ selEquipmentNoList, CLASS_NAME, methodName);
				DomainDTOBuildHelper.populateProposalDomainDTO(
						proposalDomainDTO,
						retrieveInvenDetailOutputConnectorDTO,
						selEquipmentNoList, false, decimalValue, true);
				
				if ((proposalContractBO.getExtendPeriod() != null)
						&& (proposalContractBO.getExtendPeriod()
								.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {
					populateInventoryForAllYears(proposalDomainDTO);
				}
				
				
				//DomainDTOBuildHelper.validatePlanDates(proposalDomainDTO);
				customerDomainList = proposalDomainDTO.getCustomerDTOList();
				for (int i = 0; i < customerDomainList.size(); i++) {
					customerDomainDTO = (CustomerDomainDTO) customerDomainList
							.get(i);
					try {
						//OPPTLogger.debug("Customer Domain
						// obj"+customerDomainDTO,CLASS_NAME,methodName);
						inventoryManagerLocal
								.storeIneligibleInventory(customerDomainDTO);
					} catch (ServiceException se) {
						getSessionContext().setRollbackOnly();
						throw se;
					}
				}
				//eswDataFactory.deleteESWData(ineligibleLicensesCustomDTO.getSessionId(),
				// proposalId, UtilityConstants.FETCH_INELIGIBLE);
				/* Fix for GWA XADataSource by Sara - CMVC Defect 11 */
				try {
					ESWDataLocal eswDataLocal = HomeProvider.getESWDataLocal();
					eswDataLocal.deleteESWData(ineligibleLicensesCustomDTO
							.getSessionId(), proposalId,
							UtilityConstants.FETCH_INELIGIBLE);
				} catch (CreateException ce) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							"addIneligibleInventoryToProposal", null, ce);
					ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0801);
				}

				isProposal = proposalContractBO.isProposal();
				if (isProposal) {
					proposalContractBO
							.setStatusCode(ProposalContractStatusConstants.DRAFT);
					proposalContractBO.setInvoiceAmount(0.0);
				} else {
					proposalContractBO
							.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
					proposalContractBO.setInvoiceAmount(0.0);
				}

				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);

			}
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		timeTaken.end();
		return ineligibleLicensesCustomDTO;
	}

	/**
	 *
	 * This method retrieves Ineligible licenses from back end
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 4, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param ineligibleLicensesCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public IneligibleLicensesCustomDTO fetchIneligibleInventory(
			IneligibleLicensesCustomDTO ineligibleLicensesCustomDTO)
			throws ServiceException {

		String methodName = "fetchIneligibleInventory";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		if (ineligibleLicensesCustomDTO == null) {
			ineligibleLicensesCustomDTO = new IneligibleLicensesCustomDTO();
		}
		int proposalId = 0;
		//bean instance
		InventoryManagerLocal inventoryManagerLocal = null;
		JMSConnectorLocalHome jmsConnectorLocalHome = null;
		JMSConnectorLocal jmsConnectorLocal = null;
		ProposalDomainDTO proposalDomainDTO = null;
		CustomerDomainDTO customerDomainDTO = null;

		//connector dto instance
		RetrieveIneligInvenDetailInputConnectorDTO retrieveIneligbInventoryDetailInputConnectorDTO = null;
		RetrieveIneligDeltaInvenInputConnectorDTO retrieveIneligDeltaInvenInputConnectorDTO = null;
		RetrieveInvenDetailOutputConnectorDTO retrieveInvenDetailOutputConnectorDTO = null;

		//proposal factory changes
		ProposalContractBO proposalContractBO = null;
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalCustomDTO proposalDTO = ineligibleLicensesCustomDTO
				.getProposalDTO();
		proposalId = proposalDTO.getId();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de
					.getErrorReport());
		}

		proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
		//check pre-condtn here
		try {

			HashMap map = new HashMap();
			map.put(UtilityConstants.BO_USERID, ineligibleLicensesCustomDTO
					.getUserId());
			map.put(UtilityConstants.BO_GROUPNAME, ineligibleLicensesCustomDTO
					.getGroupName());
			SharingBO sharingBO = getSharingBOFromFactory(proposalContractBO
					.getProposalId(), ineligibleLicensesCustomDTO.getUserId());
			if (null != sharingBO) {
				map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}
			proposalContractBO.validateFetchIneligible(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);

		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}

		try {
			String oldExtrContrNo = null;
			if (proposalDomainDTO.getContrType() != null
					&& proposalDomainDTO.getContrType().trim().equals(
							ContractTypeConstants.RENEWAL)
					|| proposalDomainDTO.getContrType().trim().equals(
							ContractTypeConstants.REPLACEMENT)) {
				ProposalContractBO oldProposal = null;
				try {
					oldProposal = proposalContractBOFactory
							.getProposalContractBOForContractNumber(
									proposalDomainDTO.getOldContrNo(), true);
				} catch (DomainException d) {
					throw ExceptionGenerator.generateServiceException(d
							.getErrorReport());
				}
				if (oldProposal != null && oldProposal.getExtContrNo() != null
						&& !oldProposal.getExtContrNo().equals("")) {
					oldExtrContrNo = oldProposal.getExtContrNo();
					OPPTLogger.debug("Old Ext Contr No " + oldExtrContrNo,
							CLASS_NAME, methodName);
				} else {
					if (oldProposal != null) {
						oldExtrContrNo = oldProposal.getContrNo();
						OPPTLogger.debug("Contr No " + oldExtrContrNo,
								CLASS_NAME, methodName);
					}
				}
			}
			inventoryManagerLocal = getInventoryManagerLocal();
			proposalDomainDTO = inventoryManagerLocal
					.retrieveCustomerForProposal(proposalDomainDTO);
			List customerNoList = new ArrayList();
			if (proposalDomainDTO != null
					&& proposalDomainDTO.getCustomerDTOList() != null) {
				for (int i = 0; i < proposalDomainDTO.getCustomerDTOList()
						.size(); i++) {
					customerDomainDTO = (CustomerDomainDTO) proposalDomainDTO
							.getCustomerDTOList().get(i);
					customerNoList.add(customerDomainDTO.getSapCustomerNo());
				}
			}
			jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
			if (proposalDomainDTO.getStatusCode() != null
					&& ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
							.equals(proposalDomainDTO.getStatusCode())
					|| ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
							.equals(proposalDomainDTO.getStatusCode())) {
				retrieveIneligDeltaInvenInputConnectorDTO = InputConnectorDTOBuildHelper
						.buildRetrieveIneligDeltaInvenInputConnectorDTO(
								proposalDomainDTO, ineligibleLicensesCustomDTO
										.getSessionId(),
								ineligibleLicensesCustomDTO.getUserId(),
								customerNoList, oldExtrContrNo);
				retrieveInvenDetailOutputConnectorDTO = (RetrieveInvenDetailOutputConnectorDTO) jmsConnectorLocal
						.sendReceive(retrieveIneligDeltaInvenInputConnectorDTO);
				OPPTLogger.debug("Retrieve Details oppt"
						+ retrieveInvenDetailOutputConnectorDTO, CLASS_NAME,
						methodName);

			} else {
				//				Create the connector DTO Object and set the values
				retrieveIneligbInventoryDetailInputConnectorDTO = InputConnectorDTOBuildHelper
						.buildRetrieveIneligInvenDetailInputConnectorDTO(
								proposalDomainDTO, ineligibleLicensesCustomDTO
										.getSessionId(),
								ineligibleLicensesCustomDTO.getUserId(),
								customerNoList, oldExtrContrNo);
				retrieveInvenDetailOutputConnectorDTO = (RetrieveInvenDetailOutputConnectorDTO) jmsConnectorLocal
						.sendReceive(retrieveIneligbInventoryDetailInputConnectorDTO);
			}

		} catch (Exception e) {

			throwServiceException(ErrorCodeConstants.SE0801,
					OPPTMessageCatalog.TYPE_SERVICE);
		}

		if (retrieveInvenDetailOutputConnectorDTO != null
				&& ConnectorConstants.RFC_SUCCESS_CODE
						.equals(retrieveInvenDetailOutputConnectorDTO
								.getReturnCode())) {

			/*
			 * Fix for GWA XA Datasource Saravanan
			 */
			/*
			 * ESWDataFactory eswDataFactory = new ESWDataFactory(); try {
			 * eswDataFactory.storeESWData(ineligibleLicensesCustomDTO.getSessionId(),
			 * retrieveInvenDetailOutputConnectorDTO, proposalId,
			 * UtilityConstants.FETCH_INELIGIBLE); } catch (DomainException d) {
			 * throw
			 * ExceptionGenerator.generateServiceException(d.getErrorReport()); }
			 */
			try {
				ESWDataLocal eswDataLocal = HomeProvider.getESWDataLocal();
				eswDataLocal.storeESWData(ineligibleLicensesCustomDTO
						.getSessionId(), retrieveInvenDetailOutputConnectorDTO,
						proposalId, UtilityConstants.FETCH_INELIGIBLE);
			} catch (CreateException ce) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						methodName, null, ce);
				ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}
			int decimalValue = 0;
			DomainDTOBuildHelper.populateProposalDomainDTO(proposalDomainDTO,
					retrieveInvenDetailOutputConnectorDTO, null, false,
					decimalValue, true);
			ineligibleLicensesCustomDTO = validateIneligibleLicenseInfo(
					proposalDomainDTO, ineligibleLicensesCustomDTO);
			ineligibleLicensesCustomDTO.setMlcSandSOption(proposalDomainDTO
					.getProposalContent());
		} else if (retrieveInvenDetailOutputConnectorDTO != null
				&& UtilityConstants.NO_INVENTORY_AVAIL_CODE
						.equals(retrieveInvenDetailOutputConnectorDTO
								.getReturnCode())) {
			storeErrorList(UtilityConstants.NO_FI_INVENTORY_AVAIL_CODE,
					proposalId, ineligibleLicensesCustomDTO.getUserId(),
					"Fetch Ineligible Inventory");
			ineligibleLicensesCustomDTO.addMessageEntry(
					UtilityConstants.NO_FI_INVENTORY_AVAIL_CODE,
					OPPTMessageCatalog.TYPE_BACKEND);

		} else {
			storeErrorList(retrieveInvenDetailOutputConnectorDTO
					.getReturnCode(), proposalId, ineligibleLicensesCustomDTO
					.getUserId(), "Fetch Ineligible Inventory");
			throwServiceException(retrieveInvenDetailOutputConnectorDTO
					.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
		}
		proposalContractBO.setIneligibleInd(UtilityConstants.YES);
		try {
			proposalContractBOFactory
					.updateProposalContractBO(proposalContractBO);
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		timeTaken.end();
		return ineligibleLicensesCustomDTO;
	}

	/**
	 *
	 * This method validates the different ineligible license information and
	 * set it in the appropriate maps
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 8, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @return IneligibleLicensesCustomDTO
	 * @author Ravishankar
	 */
	private IneligibleLicensesCustomDTO validateIneligibleLicenseInfo(
			ProposalDomainDTO proposalDomainDTO,
			IneligibleLicensesCustomDTO ineligibleLicensesCustomDTO)
			throws ServiceException {

		String methodName = "validateIneligibleLicenseInfo";
		TreeMap licesnsesExistingContractCoverage = new TreeMap();
		TreeMap licensesFailingRemovalDateCheck = new TreeMap();
		TreeMap licensesWithRejectionReason = new TreeMap();
		TreeMap licensesFailingLicenseEffectiveDateCheck = new TreeMap();
		TreeMap licensesFailingDueToDeleveryBlockDate = new TreeMap();
		TreeMap licensesFailingWithSvc = new TreeMap();

		TreeMap sAndSExistingContractCoverage = new TreeMap();
		TreeMap sAndSLicensesFailingRemovalDateCheck = new TreeMap();
		TreeMap sAndSLicensesWithRejectionReason = new TreeMap();
		TreeMap sAndSLicensesFailingLicenseEffectiveDateCheck = new TreeMap();
		TreeMap sAndSLicensesFailingDueToDeleveryBlockDate = new TreeMap();
		TreeMap sAndSLicensesFailingWithSvc = new TreeMap();
		boolean isSAndS = false;

		if (ProposalTypeConstants.ESSO.equals(proposalDomainDTO
				.getProposalType())
				|| ProposalTypeConstants.AMO.equals(proposalDomainDTO
						.getProposalType())) {
			isSAndS = true;
		}

		// Custom DTO instances
		IneligibleSWOCustomDTO ineligibleSWOCustomDTO = null;
		IneligibleEECustomDTO ineligibleEECustomDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		List customerDTOList = null;
		List dmDTOList = null;
		List swoDTOList = null;
		List eeDTOList = null;
		CustomerDomainDTO customerDomainDTO = null;
		DMDomainDTO dmDomainDTO = null;
		SWOConnectorDTO swoConnectorDTO = null;
		EEConnectorDTO eeConnectorDTO = null;
		SWODomainDTO swoDomainDTO = null;
		EEDomainDTO eeDomainDTO = null;
		boolean isLicensePulled = false;
		boolean displayFlag = false;
		customerDTOList = proposalDomainDTO.getCustomerDTOList();
		if (customerDTOList != null && customerDTOList.size() > 0) {
			for (int i = 0; i < customerDTOList.size(); i++) {
				customerDomainDTO = (CustomerDomainDTO) customerDTOList.get(i);
				dmDTOList = customerDomainDTO.getDMDTOList();
				if (dmDTOList != null && dmDTOList.size() > 0) {
					for (int j = 0; j < dmDTOList.size(); j++) {
						dmDomainDTO = (DMDomainDTO) dmDTOList.get(j);
						swoDTOList = dmDomainDTO.getSWODTOList();
						if (swoDTOList != null && swoDTOList.size() > 0) {
							for (int k = 0; k < swoDTOList.size(); k++) {
								swoDomainDTO = (SWODomainDTO) swoDTOList.get(k);
								inventoryManagerLocal = getInventoryManagerLocal();
								isLicensePulled = inventoryManagerLocal
										.verifyLicensesAlreadyExists(swoDomainDTO);
								ineligibleSWOCustomDTO = new IneligibleSWOCustomDTO();
								ineligibleSWOCustomDTO
										.setSapSTPNumber(customerDomainDTO
												.getSapCustomerNo());
								ineligibleSWOCustomDTO.setDMNumber(dmDomainDTO
										.getDmNo());
								ineligibleSWOCustomDTO
										.setLicensePulled(isLicensePulled);
								ineligibleSWOCustomDTO
										.setSwoSerialNumber(swoDomainDTO
												.getSerialNo());
								ineligibleSWOCustomDTO
										.setSwoNumber(swoDomainDTO.getSwoNo());
								ineligibleSWOCustomDTO
										.setLicenseEffectiveDate(swoDomainDTO
												.getLicenseEffectiveDate());
								ineligibleSWOCustomDTO.setComment(swoDomainDTO
										.getComments());
								//OPPTLogger.debug("In eligiblity
								// comment"+ineligibleSWOCustomDTO.getComment(),CLASS_NAME,methodName);
								ineligibleSWOCustomDTO
										.setEquipmentNo(swoDomainDTO
												.getEquipmentNo());
								ineligibleSWOCustomDTO
										.setSalesDocumnetNo(swoDomainDTO
												.getSalesDocNo());
								//OPPTLogger.debug("ID from custom
								// dto"+ineligibleSWOCustomDTO.getId(),CLASS_NAME,methodName);
								eeDTOList = swoDomainDTO.getEEDTOList();
								ArrayList eeCustomDTOList = new ArrayList();
								if (eeDTOList != null && eeDTOList.size() > 0) {
									for (int l = 0; l < eeDTOList.size(); l++) {
										eeDomainDTO = (EEDomainDTO) eeDTOList
												.get(l);
										ineligibleEECustomDTO = new IneligibleEECustomDTO();
										ineligibleEECustomDTO
												.setEeMaterialNumber(eeDomainDTO
														.getEeNo());
										ineligibleEECustomDTO
												.setEEDetails(eeDomainDTO
														.getChargeOptionDesc());
										ineligibleEECustomDTO
												.setItemNumber(eeDomainDTO
														.getEeItemNo());
										ineligibleEECustomDTO
												.setSalesOrderNumber(eeDomainDTO
														.getSalesDocNo());
										eeCustomDTOList
												.add(ineligibleEECustomDTO);
									}
								}
								ineligibleSWOCustomDTO
										.setIneligibleEEs(eeCustomDTOList);
								if (IneligibleLicenseConstants.LICENSE_FAILING_EXISTING_CONTRACT_COVERAGE
										.equalsIgnoreCase(swoDomainDTO
												.getIneligFlag())) {
									if (UtilityConstants.SANDS_IND
											.equals(swoDomainDTO.getSAndSInd())) {
										sAndSExistingContractCoverage
												.put(ineligibleSWOCustomDTO
														.getKey(),
														ineligibleSWOCustomDTO);
									} else {
										licesnsesExistingContractCoverage
												.put(ineligibleSWOCustomDTO
														.getKey(),
														ineligibleSWOCustomDTO);
									}

								} else if (IneligibleLicenseConstants.LICENSE_FAILING_REMOVAL_DATE_CHECK
										.equalsIgnoreCase(swoDomainDTO
												.getIneligFlag())) {
									if (UtilityConstants.SANDS_IND
											.equals(swoDomainDTO.getSAndSInd())) {
										sAndSLicensesFailingRemovalDateCheck
												.put(ineligibleSWOCustomDTO
														.getKey(),
														ineligibleSWOCustomDTO);
									} else {
										licensesFailingRemovalDateCheck
												.put(ineligibleSWOCustomDTO
														.getKey(),
														ineligibleSWOCustomDTO);
									}
								} else if (IneligibleLicenseConstants.LICENSE_FAILING_REJECTION_REASON
										.equalsIgnoreCase(swoDomainDTO
												.getIneligFlag())) {
									if (UtilityConstants.SANDS_IND
											.equals(swoDomainDTO.getSAndSInd())) {
										sAndSLicensesWithRejectionReason
												.put(ineligibleSWOCustomDTO
														.getKey(),
														ineligibleSWOCustomDTO);
									} else {
										licensesWithRejectionReason
												.put(ineligibleSWOCustomDTO
														.getKey(),
														ineligibleSWOCustomDTO);
									}
								} else if (IneligibleLicenseConstants.LICENSE_FAILING_EFFECTIVE_DATE_CHECK
										.equalsIgnoreCase(swoDomainDTO
												.getIneligFlag())) {
									if (UtilityConstants.SANDS_IND
											.equals(swoDomainDTO.getSAndSInd())) {
										sAndSLicensesFailingLicenseEffectiveDateCheck
												.put(ineligibleSWOCustomDTO
														.getKey(),
														ineligibleSWOCustomDTO);
									} else {
										licensesFailingLicenseEffectiveDateCheck
												.put(ineligibleSWOCustomDTO
														.getKey(),
														ineligibleSWOCustomDTO);
									}
									if (!isLicensePulled) {
										displayFlag = true;
									}
								} else if (IneligibleLicenseConstants.LICENSE_FAILING_DELIVERY_BLOCK_CHECK
										.equalsIgnoreCase(swoDomainDTO
												.getIneligFlag())) {

									if (UtilityConstants.SANDS_IND
											.equals(swoDomainDTO.getSAndSInd())) {
										sAndSLicensesFailingDueToDeleveryBlockDate
												.put(ineligibleSWOCustomDTO
														.getKey(),
														ineligibleSWOCustomDTO);
									} else {
										licensesFailingDueToDeleveryBlockDate
												.put(ineligibleSWOCustomDTO
														.getKey(),
														ineligibleSWOCustomDTO);
									}
									if (!isLicensePulled) {
										displayFlag = true;
									}

								}
								else if (IneligibleLicenseConstants.LICENSE_FAILING__WITH_SVC
										.equalsIgnoreCase(swoDomainDTO
												.getIneligFlag())) {
									System.out
											.println("ProposalManagerBean.validateIneligibleLicenseInfo()2");
									if (UtilityConstants.SANDS_IND
											.equals(swoDomainDTO.getSAndSInd())) {
										sAndSLicensesFailingWithSvc.put(ineligibleSWOCustomDTO.getKey(),ineligibleSWOCustomDTO);
									} else {
										System.out
												.println("ProposalManagerBean.validateIneligibleLicenseInfo()3"+ineligibleSWOCustomDTO.getKey());
										licensesFailingWithSvc.put(ineligibleSWOCustomDTO.getKey(),ineligibleSWOCustomDTO);
									}
									if (!isLicensePulled) {
										System.out
												.println("ProposalManagerBean.validateIneligibleLicenseInfo():DISPLAY svc:");
										displayFlag = true;
									}
								}
							}
						}
					}
				}
			}
		}
		ineligibleLicensesCustomDTO
				.setLicensesFailingDueToDeleveryBlockDate(licensesFailingDueToDeleveryBlockDate);
		ineligibleLicensesCustomDTO
				.setLicensesFailingLicenseEffectiveDateCheck(licensesFailingLicenseEffectiveDateCheck);
		ineligibleLicensesCustomDTO
				.setLicensesFailingRemovalDateCheck(licensesFailingRemovalDateCheck);
		ineligibleLicensesCustomDTO
				.setExistingContractCoverage(licesnsesExistingContractCoverage);
		ineligibleLicensesCustomDTO
				.setLicensesWithRejectionReason(licensesWithRejectionReason);
		ineligibleLicensesCustomDTO
		        .setLicensesFailingWithSvc(licensesFailingWithSvc);
		if (!displayFlag) {
			ineligibleLicensesCustomDTO
					.addButtonFlag(ButtonConstants.CLEAR_ALL);
			ineligibleLicensesCustomDTO
					.addButtonFlag(ButtonConstants.SELECT_ALL);
			ineligibleLicensesCustomDTO.addButtonFlag(ButtonConstants.CANCEL);
		}
		if (isSAndS) {
			ineligibleLicensesCustomDTO
					.setSAndSExistingContractCoverage(sAndSExistingContractCoverage);
			ineligibleLicensesCustomDTO
					.setSAndSLicensesFailingDueToDeleveryBlockDate(sAndSLicensesFailingDueToDeleveryBlockDate);
			ineligibleLicensesCustomDTO
					.setSAndSLicensesFailingLicenseEffectiveDateCheck(sAndSLicensesFailingLicenseEffectiveDateCheck);
			ineligibleLicensesCustomDTO
					.setSAndSLicensesFailingRemovalDateCheck(sAndSLicensesFailingRemovalDateCheck);
			ineligibleLicensesCustomDTO
					.setSAndSLicensesWithRejectionReason(sAndSLicensesWithRejectionReason);
			ineligibleLicensesCustomDTO
			.setSAndSLicensesFailingWithSvc(sAndSLicensesFailingWithSvc);
			ineligibleLicensesCustomDTO.setSAndS(true);
		}

		return ineligibleLicensesCustomDTO;
	}

	/**
	 *
	 * This methos will be used by the controller to retrive the customer list
	 * information. <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 3, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param fetchCustomerListCustomDTO
	 * @return FetchCustomerListCustomDTO
	 * @throws ServiceException
	 * @author balajiv
	 *
	 */
	/*public FetchCustomerListCustomDTO fetchCustomerLists(
			FetchCustomerListCustomDTO fetchCustomerListCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "fetchCustomerLists");
		boolean changeProposal = false;
		boolean canShowDelete = false;
		TreeMap customerListMap = new TreeMap();
		ProposalCustomDTO proposalCustomDTO = fetchCustomerListCustomDTO
				.getProposal();
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		InventoryManagerLocal inventoryManagerLocal = null;
		try {
			inventoryManagerLocal = HomeProvider.getInventoryManagerLocal();
		} catch (CreateException e2) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchCustomerLists", null, e2);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);

		}
		ProposalContractBO proposalContractBO = null;
		if (proposalCustomDTO != null) {
			changeProposal = true;
			OPPTLogger.debug("CHANGE PROPOSAL", CLASS_NAME,
					"fetchCustomerLists");
			try {
				proposalContractBO = proposalContractBOFactory
						.getProposalContractBO(proposalCustomDTO.getId());
			} catch (Exception ex) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						"fetchCustomerLists", null, ex);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}

			CustomerListBOFactory customerListBOFactory = new CustomerListBOFactory();
			List customerBOList = new ArrayList();

			try {
				customerBOList = customerListBOFactory
						.findCustomerListBOForProposal(proposalContractBO
								.getProposalId());
				for (int i = 0, size = customerBOList.size(); i < size; i++) {
					CustomerListBO customerListBO = (CustomerListBO) customerBOList
							.get(i);
					CustomerListCustomDTO customerListCustomDTO = new CustomerListCustomDTO();
					CustomerDomainDTO customerDomainDTO = new CustomerDomainDTO();
					customerDomainDTO.setCustomerListNo(customerListBO
							.getCustomerListNo());
					customerDomainDTO.setProposalId(proposalCustomDTO.getId());
					CustomerBO[] customersNo = inventoryManagerLocal
							.retrieveCustomerNumberForCustomerList(customerDomainDTO);
					if (null != customersNo && customersNo.length > 0) {
						customerListCustomDTO.setCanBeDeleted(false);
					} else {
						customerListCustomDTO.setCanBeDeleted(true);
						canShowDelete = true;
					}
					customerListCustomDTO.setAlreadyExists(true);
					customerListCustomDTO.setListName(OPPTHelper
							.toUpperCase(customerListBO.getCustomerListDesc()));
					customerListCustomDTO.setListNumber(OPPTHelper
							.toUpperCase(customerListBO.getCustomerListNo()));
					customerListMap.put(customerListBO.getCustomerListNo(),
							customerListCustomDTO);
				}
			} catch (DomainException exe) {
				throw ExceptionGenerator.generateServiceException(exe
						.getErrorReport());
			}

		}
		// Form the connector DTO
		RetrieveCustListInputConnectorDTO inputConnectorDTO = null;
		if (changeProposal) {
			inputConnectorDTO = PCMConnectorDTOBuilder
					.buildRetrieveCustListInputConnectorDTO(
							fetchCustomerListCustomDTO, proposalContractBO);
		} else {
			inputConnectorDTO = PCMConnectorDTOBuilder
					.buildRetrieveCustListInputConnectorDTO(
							fetchCustomerListCustomDTO, null);
		}

		// Make the ESW Call to the Backend
		JMSConnectorLocal jmsConnectorLocal = null;
		try {
			jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchCustomerLists", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);

		}
		RetrieveCustListOutputConnectorDTO outputConnectorDTO = new RetrieveCustListOutputConnectorDTO();
		try {
			outputConnectorDTO = (RetrieveCustListOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(inputConnectorDTO);
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchCustomerLists", null, e1);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
			// should throw service exception
		}
		// "0" will be removed and moved to ConnectorConstants
		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(outputConnectorDTO
				.getReturnCode().trim())) {
			List customerList = outputConnectorDTO
					.getCustomerListConnectorDTOList();
			// in Loop
			for (int k = 0; k < customerList.size(); k++) {
				CustomerListConnectorDTO customerListConnectorDTO = (CustomerListConnectorDTO) customerList
						.get(k);
				CustomerListCustomDTO customerListCustomDTO = new CustomerListCustomDTO();
				customerListCustomDTO.setListName(OPPTHelper
						.toUpperCase(customerListConnectorDTO
								.getCustomerListName()));
				customerListCustomDTO.setListNumber(OPPTHelper
						.toUpperCase(customerListConnectorDTO
								.getCustomerListNo()));
				if (null == customerListMap.get(customerListCustomDTO
						.getListNumber())) {
					// If already exists we do not add them
					customerListMap.put(customerListCustomDTO.getListNumber(),
							customerListCustomDTO);
				}
			}
		} else {
			if (changeProposal) {
				storeErrorList(outputConnectorDTO.getReturnCode(),
						proposalContractBO.getProposalId(),
						fetchCustomerListCustomDTO.getUserId(),
						"fetchCustomerLists");
			}
			throwServiceException(outputConnectorDTO.getReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
		}
		fetchCustomerListCustomDTO.setCustomerLists(customerListMap);
		if (!changeProposal) {
			// hide delete button
			fetchCustomerListCustomDTO.addButtonFlag(ButtonConstants.DELETE);
		} else {
			if (!canShowDelete) {
				fetchCustomerListCustomDTO
						.addButtonFlag(ButtonConstants.DELETE);
			}
		}
		log.end();
		return fetchCustomerListCustomDTO;

	}
*/
	/*
	 * BlueHarmony-DADO02 Change Starts by Sateesh Anne
	 */
	public FetchCustomerListCustomDTO fetchSiteIDLists(
			FetchCustomerListCustomDTO fetchCustomerListCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "fetchSiteIDLists");
		boolean changeProposal = false;
		boolean canShowDelete = false;
		TreeMap customerListMap = new TreeMap();
		ProposalCustomDTO proposalCustomDTO = fetchCustomerListCustomDTO
				.getProposal();
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		InventoryManagerLocal inventoryManagerLocal = null;
		try {
			inventoryManagerLocal = HomeProvider.getInventoryManagerLocal();
		} catch (CreateException e2) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchSiteIDLists", null, e2);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);

		}
		ProposalContractBO proposalContractBO = null;
		if (proposalCustomDTO != null) {
			changeProposal = true;
			OPPTLogger.debug("CHANGE PROPOSAL", CLASS_NAME, "fetchSiteIDLists");
			try {
				proposalContractBO = proposalContractBOFactory
						.getProposalContractBO(proposalCustomDTO.getId());
			} catch (Exception ex) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						"fetchSiteIDLists", null, ex);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}

			CustomerListBOFactory customerListBOFactory = new CustomerListBOFactory();
			List customerBOList = new ArrayList();

			try {
				CustomerDomainDTO customerDomainDTO = new CustomerDomainDTO();
				customerDomainDTO.setProposalId(proposalCustomDTO.getId());

				CustomerBO[] customers = inventoryManagerLocal
				.retrieveCustomerNumberForCustomerList(customerDomainDTO);

				if (null != customers && customers.length > 0) {


				/*DADO02 customerBOList = customerListBOFactory
						.findCustomerListBOForProposal(proposalContractBO
								.getProposalId());*/

				for (int i = 0, size = customers.length; i < size; i++) {

					CustomerBO customerBO = (CustomerBO)customers[i];
					CustomerListCustomDTO customerListCustomDTO = new CustomerListCustomDTO();

									/*customerDomainDTO.setCustomerListNo(customerListBO
							.getCustomerListNo());
					*/
					/*String [] customersNo = inventoryManagerLocal
							.retrieveCustomerNumberForCustomerList(customerDomainDTO);
					if (null != customersNo && customersNo.length > 0) {
						customerListCustomDTO.setCanBeDeleted(false);
					} else {
						customerListCustomDTO.setCanBeDeleted(true);
						canShowDelete = true;
					}*/
					customerListCustomDTO.setCanBeDeleted(false);
					customerListCustomDTO.setAlreadyExists(true);
					customerListCustomDTO.setCustomerNumber(customerBO.getSapCustomerNo());
					customerListCustomDTO.setCustomerName(customerBO.getSapCustomerName());

					if(proposalContractBO.getRegCustomerNo().equals(customerBO.getSapCustomerNo())){
						customerListCustomDTO.setSTPSelected(true);
					}else{
						customerListCustomDTO.setSTPSelected(false);
					}
					/*customerListCustomDTO.setListName(OPPTHelper
							.toUpperCase(customerListBO.getCustomerListDesc()));
					customerListCustomDTO.setListNumber(OPPTHelper
							.toUpperCase(customerListBO.getCustomerListNo()));*/
					customerListMap.put(customerListCustomDTO.getCustomerNumber(),
							customerListCustomDTO);
				}
				}
			} catch (ServiceException exe) { //DADO02 Sateesh Anne Changed from Domain Exception to serviceException
				throw ExceptionGenerator.generateServiceException(exe
						.getErrorReport());
			}

		}
		// Form the connector DTO
		RetrieveSiteIDListInputConnectorDTO inputConnectorDTO = null;
		if (changeProposal) {
			inputConnectorDTO = PCMConnectorDTOBuilder
					.buildRetrieveSiteIDListInputConnectorDTO(
							fetchCustomerListCustomDTO, proposalContractBO);
		} else {
			inputConnectorDTO = PCMConnectorDTOBuilder
					.buildRetrieveSiteIDListInputConnectorDTO(
							fetchCustomerListCustomDTO, null);
		}

		// Make the ESW Call to the Backend
		JMSConnectorLocal jmsConnectorLocal = null;
		try {
			jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchCustomerLists", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);

		}
		RetrieveSiteIDListOutputConnectorDTO outputConnectorDTO = new RetrieveSiteIDListOutputConnectorDTO();
		try {
			outputConnectorDTO = (RetrieveSiteIDListOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(inputConnectorDTO);
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchCustomerLists", null, e1);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
			// should throw service exception
		}
		// "0" will be removed and moved to ConnectorConstants
		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(outputConnectorDTO
				.getReturnCode().trim())) {
			List customerList = outputConnectorDTO
					.getRetrieveCustConnectorDTOList();
			// in Loop

			for (int k = 0; k < customerList.size(); k++) {
			RetrieveSiteIDCustConnectorDTO retrieveSiteIDCustConnectorDTO = (RetrieveSiteIDCustConnectorDTO) customerList
						.get(k);
				// CustomerListCustomerCustomDTO customerListCustomerCustomDTO = new CustomerListCustomerCustomDTO();
				CustomerListCustomDTO customerListCustomDTO = new CustomerListCustomDTO();

				customerListCustomDTO.setSiteID(retrieveSiteIDCustConnectorDTO.getSiteID());
				customerListCustomDTO
						.setCustomerNumber(retrieveSiteIDCustConnectorDTO
								.getCustomerNo());
				customerListCustomDTO
						.setCustomerName(retrieveSiteIDCustConnectorDTO
								.getCustomerName());
				/*customerListCustomDTO
						.setSAPCustomerNumber(retrieveSiteIDCustConnectorDTO
								.getSapCustomerNo());*/

				if(changeProposal){
					CustomerDomainDTO customerDomainDTO = new CustomerDomainDTO();
					customerDomainDTO.setProposalId(proposalCustomDTO.getId());

					CustomerBO[] customers = inventoryManagerLocal
					.retrieveCustomerNumberForCustomerList(customerDomainDTO);

					if (null != customers && customers.length > 0) {


					/*DADO02 customerBOList = customerListBOFactory
							.findCustomerListBOForProposal(proposalContractBO
									.getProposalId());*/

						for (int i = 0, size = customers.length; i < size; i++) {

							CustomerBO customerBO = (CustomerBO)customers[i];

							if(customerBO.getSapCustomerNo().equals(customerListCustomDTO.getCustomerNumber())){
								customerListCustomDTO.setSTPSelected(true);
							}else{
								customerListCustomDTO.setSTPSelected(false);
							}

					    }//end of for
				}//end of if

				}//end of changeproposal if loop

				if (null == customerListMap.get(customerListCustomDTO
						.getCustomerNumber())) {
					// If already exists we do not add them
					customerListCustomDTO.setAlreadyExists(false);

					customerListMap.put(customerListCustomDTO
									.getCustomerNumber(),
									customerListCustomDTO);
				}
			}
		} else {
			if (changeProposal) {
				storeErrorList(outputConnectorDTO.getReturnCode(),
						proposalContractBO.getProposalId(),
						fetchCustomerListCustomDTO.getUserId(),
						"fetchCustomerLists");
			}
			throwServiceException(outputConnectorDTO.getReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
		}

		fetchCustomerListCustomDTO.setSiteIDLists(customerListMap); //DAO02

		if (!changeProposal) {
			// hide delete button
			fetchCustomerListCustomDTO.addButtonFlag(ButtonConstants.DELETE);
		} else {
			if (!canShowDelete) {
				fetchCustomerListCustomDTO
						.addButtonFlag(ButtonConstants.DELETE);
			}
		}
		log.end();
		return fetchCustomerListCustomDTO;

	}

	/**
	 * This method is used to get customers from backend form a particular
	 * selection <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 3, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param fetchCustomersCustomDTO
	 * @return FetchCustomersCustomDTO
	 * @throws ServiceException
	 * @author balajiv
	 *
	 */
/*	public FetchCustomersCustomDTO fetchCustomersFromCustomerLists(
			FetchCustomersCustomDTO fetchCustomersCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME,
				"fetchCustomersFromCustomerLists");
		boolean changeProposal = false;
		ProposalCustomDTO proposalCustomDTO = fetchCustomersCustomDTO
				.getProposalDTO();
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalContractBO proposalContractBO = null;
		int proposalId = 0;
		if (proposalCustomDTO != null) {
			OPPTLogger.debug("Change Proposal", CLASS_NAME,
					"fetchCustomersFromCustomerLists");
			proposalId = proposalCustomDTO.getId();
			changeProposal = true;
			try {
				proposalContractBO = proposalContractBOFactory
						.getProposalContractBO(proposalId);
			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de
						.getErrorReport());
			}

			proposalId = proposalCustomDTO.getId();
		}

		TreeMap customerListCustomDTOMap = fetchCustomersCustomDTO
				.getSelectedCustomerLists();
		Set keySet = customerListCustomDTOMap.keySet();
		Iterator iter = keySet.iterator();
		List selectedCustomerListNumbers = new ArrayList();
		while (iter.hasNext()) {
			CustomerListCustomDTO customerListCustomDTO = (CustomerListCustomDTO) customerListCustomDTOMap
					.get(iter.next());
			selectedCustomerListNumbers.add(customerListCustomDTO
					.getListNumber());
		}
		RetrieveCustInputConnectorDTO inputConnectorDTO = null;
		if (changeProposal) {
			inputConnectorDTO = PCMConnectorDTOBuilder
					.buildRetrieveCustInputConnectorDTO(
							selectedCustomerListNumbers,
							fetchCustomersCustomDTO, proposalContractBO);
		} else {
			inputConnectorDTO = PCMConnectorDTOBuilder
					.buildRetrieveCustInputConnectorDTO(
							selectedCustomerListNumbers,
							fetchCustomersCustomDTO, null);
		}
		//Make the ESW Call to the Backend
		JMSConnectorLocal jmsConnectorLocal = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		try {
			jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
			inventoryManagerLocal = HomeProvider.getInventoryManagerLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchCustomersFromCustomerLists", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		RetrieveCustOutputConnectorDTO outputConnectorDTO = new RetrieveCustOutputConnectorDTO();
		try {
			outputConnectorDTO = (RetrieveCustOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(inputConnectorDTO);
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchCustomersFromCustomerLists", null, e1);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(outputConnectorDTO
				.getReturnCode())) {
			List customerListCustomers = outputConnectorDTO
					.getRetrieveCustConnectorDTOList();
			//boolean isAlternatePartner = true;
			// in Loop

			for (int k = 0; k < customerListCustomers.size(); k++) {
				RetrieveCustConnectorDTO retrieveCustConnectorDTO = (RetrieveCustConnectorDTO) customerListCustomers
						.get(k);

				CustomerListCustomDTO customerListCustomDTO = (CustomerListCustomDTO) customerListCustomDTOMap
						.get(retrieveCustConnectorDTO.getCustomerListNo());

				CustomerListCustomerCustomDTO customerListCustomerCustomDTO = new CustomerListCustomerCustomDTO();
				customerListCustomerCustomDTO
						.setCustomerName(retrieveCustConnectorDTO
								.getCustomerName());
				customerListCustomerCustomDTO
						.setCustomerNumber(retrieveCustConnectorDTO
								.getCustomerNo());
				customerListCustomerCustomDTO
						.setLegacyCustomerNumber(retrieveCustConnectorDTO
								.getLegacyCustomerNo());
				customerListCustomerCustomDTO
						.setAddressSequenceNumber(retrieveCustConnectorDTO
								.getAddressSeqNo());
				customerListCustomerCustomDTO
						.setCountryCode(retrieveCustConnectorDTO
								.getCountryCode()); 
													 * Changed for EF0607044559
													 * by Sara on June 16,2004
													 
				if (changeProposal) {
					String customerListCustomerNo = retrieveCustConnectorDTO
							.getCustomerNo();
					CustomerDomainDTO customerDomainDTO = new CustomerDomainDTO();
					customerDomainDTO.setCustomerListNo(customerListCustomDTO
							.getListNumber());
					customerDomainDTO.setProposalId(proposalId);
					CustomerBO[] customersNo = inventoryManagerLocal
							.retrieveCustomerNumberForCustomerList(customerDomainDTO);
					if (customersNo != null) {
						for (int j = 0, size = customersNo.length; j < size; j++) {
							if (customerListCustomerNo.equals(customersNo[j])) {
								customerListCustomerCustomDTO
										.setAlreadyExists(true);
							}
						}
					}
					if (proposalContractBO.getRegCustomerNo().equals(
							customerListCustomerNo)) {
						customerListCustomerCustomDTO.setIsSTP(true);
						//			isAlternatePartner = false;
					}

				} // We populate the custome dto's.

				TreeMap customersMap = customerListCustomDTO.getCustomers();
				if (customersMap == null) {
					customersMap = new TreeMap();
					customersMap
							.put(customerListCustomerCustomDTO
									.getCustomerNumber(),
									customerListCustomerCustomDTO);
					customerListCustomDTO.setCustomers(customersMap);
				} else {
					customersMap
							.put(customerListCustomerCustomDTO
									.getCustomerNumber(),
									customerListCustomerCustomDTO);
				}

			}
			//	OPPTLogger.debug("isAlternatePartner =
			// "+isAlternatePartner,CLASS_NAME,"fetchCustomersFromCustomerLists");
			if (changeProposal) {
				// Then it is alternate partner STP
				ProposalDomainDTO proposalDomainDTO = new ProposalDomainDTO();
				proposalDomainDTO.setProposalId(proposalId);
				proposalDomainDTO = inventoryManagerLocal
						.retrieveCustomerForProposal(proposalDomainDTO);
				List customerList = proposalDomainDTO.getCustomerDTOList();

				for (int k = 0; k < customerList.size(); k++) {
					CustomerDomainDTO customer = (CustomerDomainDTO) customerList
							.get(k);
					if (!(customer.getCustomerListNo() != null && customer
							.getCustomerListNo().trim().length() > 0)) {
						// This is alternate partner
						CustomerListCustomerCustomDTO customerListCustomerCustomDTO = new CustomerListCustomerCustomDTO();
						customerListCustomerCustomDTO.setCustomerName(customer
								.getSapCustomerName());
						customerListCustomerCustomDTO
								.setCustomerNumber(customer.getSapCustomerNo());
						customerListCustomerCustomDTO
								.setLegacyCustomerNumber(customer
										.getLegacyCustomerNo());
						customerListCustomerCustomDTO
								.setAddressSequenceNumber(customer
										.getCustmerASNo());
						customerListCustomerCustomDTO.setAlreadyExists(true);
						customerListCustomerCustomDTO.setCountryCode(customer
								.getCountryCode()); 
													 * Changed for EF0607044559
													 * by Sara on June 16,2004
													 
						OPPTLogger.debug(
								"proposalContractBO.getRegCustomerNo() = "
										+ proposalContractBO.getRegCustomerNo()
										+ ":" + customer.getSapCustomerNo(),
								CLASS_NAME, "fetchCustomersFromCustomerLists");
						if (proposalContractBO.getRegCustomerNo().equals(
								customer.getSapCustomerNo())) {
							customerListCustomerCustomDTO.setIsSTP(true);
							OPPTLogger.debug("STP TRUE ", CLASS_NAME,
									"fetchCustomersFromCustomerLists");

						}
						fetchCustomersCustomDTO
								.addAlternatePartner(customerListCustomerCustomDTO);
					}
				}
			}
			// in Loop
		} else {
			if (changeProposal) {
				storeErrorList(outputConnectorDTO.getReturnCode(),
						proposalContractBO.getProposalId(),
						fetchCustomersCustomDTO.getUserId(),
						"fetchCustomersFromCustomerLists");
			}
			throwServiceException(outputConnectorDTO.getReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
		}
		fetchCustomersCustomDTO
				.setSelectedCustomerLists(customerListCustomDTOMap);
		log.end();
		return fetchCustomersCustomDTO;
	}*/

	// DADO02
	public FetchCustomersCustomDTO fetchCustomes(FetchCustomersCustomDTO fetchCustomersCustomDTO)throws ServiceException{
		
		
	
		return fetchCustomersCustomDTO;
	}
	/**
	 *
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 3, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param fetchPartnerInformationCustomDTO
	 * @return FetchPartnerInformationCustomDTO
	 * @throws ServiceException
	 * @author balajiv
	 */
	public FetchPartnerInformationCustomDTO fetchPartnerInformationForCustomer(
			FetchPartnerInformationCustomDTO fetchPartnerInformationCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME,
				"fetchPartnerInformationForCustomer");
		boolean changeProposal = false;
		boolean igfFlag = fetchPartnerInformationCustomDTO.isIGFFlag();
		ProposalCustomDTO proposalCustomDTO = fetchPartnerInformationCustomDTO
				.getProposalDTO();
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		InventoryManagerLocal inventoryManagerLocal = null;
		CustomerDomainDTO customerDomainDTO = null; // EF0607044559S
		ProposalContractBO proposalContractBO = null; // EF0607044559E
		if (proposalCustomDTO != null) {
			changeProposal = true;
			try {
				proposalContractBO = proposalContractBOFactory
						.getProposalContractBO(proposalCustomDTO.getId());
			} catch (DomainException ex) {
				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}
			if (proposalContractBO.isVarianceProposal()) {
				fetchPartnerInformationCustomDTO.setVarianceProposal(true);
			}
		}

		RetrievePartnerInputConnectorDTO inputConnectorDTO = null;
		if (changeProposal) {
			if (proposalContractBO.isVarianceProposal()) {
				ESWCustomerCustomDTO customer = new ESWCustomerCustomDTO();
				customer.setAddressSequenceNumber(proposalContractBO
						.getRegCustomerASNo());
				customer.setLegacyCustomerNumber(proposalContractBO
						.getRegCustomerLegNo());
				customer.setCustomerNumber(proposalContractBO.getRegCustomerNo()); 
				fetchPartnerInformationCustomDTO.setCustomer(customer);
			}
			/* Changed for EF0607044559S by Sara on June 16,2004 */
			/* Changed for EF0803046051S by Sara on Aug 03,2004 */

			/* CR6153 start change */
			if ((proposalContractBO.getExtendPeriod() != null)
					&& (proposalContractBO.getExtendPeriod()
							.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {
				inventoryManagerLocal = getInventoryManagerLocal();
				customerDomainDTO = inventoryManagerLocal
						.findSTPForProposalPlanStartEndDate(proposalContractBO
								.getProposalId(), proposalContractBO
								.getRegCustomerNo(), proposalContractBO
								.getContrStartPeriod(), proposalContractBO
								.getContrEndPeriod());
			} else {
				/* CR6153 end change */
				inventoryManagerLocal = getInventoryManagerLocal();
				customerDomainDTO = inventoryManagerLocal.findSTPForProposal(
						proposalContractBO.getProposalId(), proposalContractBO
								.getRegCustomerNo());
			}
			/* EF0803046051E */
			/* EF0607044559E */
			inputConnectorDTO = PCMConnectorDTOBuilder
					.buildRetrievePartnerInputConnectorDTO(
							fetchPartnerInformationCustomDTO,
							proposalContractBO);
			inputConnectorDTO
					.setCountryCode(customerDomainDTO.getCountryCode()); /* EF0607044559 */
		} else {
			inputConnectorDTO = PCMConnectorDTOBuilder
					.buildRetrievePartnerInputConnectorDTO(
							fetchPartnerInformationCustomDTO, null);
		}
		if (changeProposal) {
			PCMCustomDTOBuilder.populateFetchPartnerInformationCustomDTO(
					fetchPartnerInformationCustomDTO, proposalContractBO);
			fetchPartnerInformationCustomDTO.setComments(proposalContractBO
					.getComments());
		}

		JMSConnectorLocal jmsConnectorLocal = null;
		try {
			jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchPartnerInformationForCustomer", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		RetrievePartnerOutputConnectorDTO outputConnectorDTO = new RetrievePartnerOutputConnectorDTO();
		try {
			outputConnectorDTO = (RetrievePartnerOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(inputConnectorDTO);
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchPartnerInformationForCustomer", null, e1);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(outputConnectorDTO
				.getReturnCode())) {
			//RetrievePartnerConnectorDTO
			List retrievePartnerConnectorDTOList = outputConnectorDTO
					.getRetrievePartnerConnectorDTOList();
			PCMCustomDTOBuilder.populatePartnerInformation(
					retrievePartnerConnectorDTOList,
					fetchPartnerInformationCustomDTO, changeProposal, igfFlag);
			fetchPartnerInformationCustomDTO.getSelectedSoldToParty()
					.setCountryCode(inputConnectorDTO.getCountryCode()); /*
																		  * Changed
																		  * for
																		  * EF0607044559S
																		  * by
																		  * Sara
																		  * on
																		  * June
																		  * 16,2004
																		  */

		} else {
			if (changeProposal) {
				storeErrorList(outputConnectorDTO.getReturnCode(),
						proposalContractBO.getProposalId(),
						fetchPartnerInformationCustomDTO.getUserId(),
						"fetchPartnerInformationForCustomer");
			}
			throwServiceException(outputConnectorDTO.getReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
		}

		log.end();
		return fetchPartnerInformationCustomDTO;

	}

	/**
	 * To retrieve the proposal details. It also supports the print, goto page,
	 * search licenses.
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 9, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalDetailsCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public ProposalDetailsCustomDTO fetchProposalDetails(
			ProposalDetailsCustomDTO proposalDetailsCustomDTO)
			throws ServiceException {
		
		String methodName = "fetchProposalDetails";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		boolean showInvoiceAmount = false;
		try {
			CustomerBOFactory customerBOFactory = new CustomerBOFactory();
			ProposalCustomDTO proposalCustomDTO = proposalDetailsCustomDTO
					.getProposalDTO();
			int proposalID = proposalCustomDTO.getId();
			ProposalContractBOFactory boFactory = new ProposalContractBOFactory();
			ProposalContractBO proposalContractBO = boFactory
					.getProposalContractBO(proposalID);
		
			ProposalContractDTOFactory factory = new ProposalContractDTOFactory();

			SharingBO sharingBO = getSharingBOFromFactory(proposalID,
					proposalDetailsCustomDTO.getUserId());
			HashMap map = populateCompareValuesForUserAuthInProposalBO(
					proposalDetailsCustomDTO, sharingBO);
			map.put(UtilityConstants.BO_ROLE, new Integer(
					proposalDetailsCustomDTO.getRole()));

			proposalContractBO.validateProposalDetails(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);

			Boolean editable = (Boolean) map
					.get(UtilityConstants.PROPOSAL_DETAILS_EDITABLE);
			
			//Mallik-Start
			ProposalCustomDTO PCustDto=new ProposalCustomDTO();
			PCustDto.setContent(proposalContractBO.getProposalContent());
			PCustDto.setType(proposalContractBO.getProposalType());
			PCustDto.setName(proposalContractBO.getProposalName());
			proposalDetailsCustomDTO.setProposalDTO(PCustDto);
			//Mallik-End
			
			if (proposalContractBO.isProposal()) {
				if (ProposalContractStatusConstants.PENDING_APPROVAL
						.equals(proposalContractBO.getStatusCode())) {
					if (!(RoleConstants.CREATE_APPROVE == proposalDetailsCustomDTO
							.getRole() || RoleConstants.PROPOSAL_APPROVER == proposalDetailsCustomDTO
							.getRole())) {
						if (editable.booleanValue()) {
							proposalDetailsCustomDTO.setProposalEditable(false);
						}
					}
				} else if (ProposalContractStatusConstants.CHECK_PROPOSAL_STATUS
						.equals(proposalContractBO.getStatusCode())) {
					if (editable.booleanValue()) {
						proposalDetailsCustomDTO.setProposalEditable(false);
					}
				} else {
					proposalDetailsCustomDTO.setProposalEditable(editable
							.booleanValue());
				}
			} else {
				// Contracts
				if (editable.booleanValue() == false) {
					proposalDetailsCustomDTO.setProposalEditable(editable
							.booleanValue());
				} else {
					// User has access
					if (ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
							.equals(proposalContractBO.getStatusCode())
							|| ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
									.equals(proposalContractBO.getStatusCode())) {
						// Should be taken to PROPOSAL DETAILS
						proposalDetailsCustomDTO.setProposalEditable(editable
								.booleanValue());
					}
				}
			}

			if (proposalContractBO.isPriced()
					&& (!proposalContractBO.isDraft())) {
				showInvoiceAmount = true;
			}
			proposalDetailsCustomDTO.setIsPriced(showInvoiceAmount);

			ProposalDetailsBuildHelper helper = new ProposalDetailsBuildHelper();
			if (ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS
					.equals(proposalContractBO.getStatusCode())) {
				proposalDetailsCustomDTO.setInventoryFetched(false);
				ProposalDomainDTO domainDTO = new ProposalDomainDTO();
				domainDTO.setProposalId(proposalID);
				domainDTO = getInventoryManagerLocal()
						.retrieveCustomerForProposal(domainDTO);

				helper.buildPartnerInformation(proposalContractBO, domainDTO,
						proposalDetailsCustomDTO, getCustomerList(proposalID));
			} else {

				ProposalDomainDTO domainDTO = factory
						.getProposalContractDomainDTO(
								proposalID,
								proposalDetailsCustomDTO.getPageIndex(),
								proposalDetailsCustomDTO.getSearchString(),
								proposalDetailsCustomDTO.getRequestFor(),
								proposalDetailsCustomDTO.getTotalNoOfPages(),
								proposalDetailsCustomDTO.getMLCTotalNoOfPages(),
								proposalDetailsCustomDTO.getMLCExcess(),
								proposalContractBO.isSAndSProposal(),
								proposalContractBO.getProposalContent(),
								proposalDetailsCustomDTO.isDuplicateSerial());
				
				
				//CR 2031-Starts
				if (proposalDetailsCustomDTO.isDuplicateSerial()) {
					if ((domainDTO.getCustomerDTOList() == null || domainDTO
							.getCustomerDTOList().size() == 0)
							&& (domainDTO.getSAndSCustomerList() == null || domainDTO
									.getSAndSCustomerList().size() == 0)) {
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0029);
					}
				}
				//CR 2031-Ends

				domainDTO.setContrEndPeriod(proposalContractBO
						.getContrEndPeriod());
				domainDTO.setContrStartPeriod(proposalContractBO
						.getContrStartPeriod());

				helper.buildCustomDTO(domainDTO, proposalDetailsCustomDTO,
						proposalContractBO.isSAndSProposal(),
						proposalContractBO.isPriced(), proposalContractBO
								.isDraft(), proposalContractBO.getDatePriced(),
						proposalDetailsCustomDTO.isDuplicateSerial());
				proposalDetailsCustomDTO.setInventoryFetched(true);
				if ((ProposalContractStatusConstants.DRAFT
						.equals(proposalContractBO.getStatusCode()) || ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
						.equals(proposalContractBO.getStatusCode()))
						&& (!factory.isInventoryPresent(proposalID))) {
					ErrorReport messageReport = new ErrorReport();
					ExceptionGenerator.addErrorEntry(messageReport,
							ErrorCodeConstants.SE0007,
							OPPTMessageCatalog.TYPE_SERVICE);
					proposalDetailsCustomDTO.setMessageReport(messageReport);
				}
			}
			if (proposalContractBO.isSAndSProposal()) {
				proposalDetailsCustomDTO
						.setSAndSDiscountAmount(proposalContractBO
								.getSAndsDiscount());
				/* Start change CR6153 */
				if ((proposalContractBO.getExtendPeriod() != null)
						&& (proposalContractBO.getExtendPeriod()
								.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {
					proposalDetailsCustomDTO
							.setSAndSDiscountAmount1(proposalContractBO
									.getSAndSDiscountAmount1());
					proposalDetailsCustomDTO
							.setSAndSDiscountAmount2(proposalContractBO
									.getSAndSDiscountAmount2());
					proposalDetailsCustomDTO
							.setSAndSDiscountAmount3(proposalContractBO
									.getSAndSDiscountAmount3());
					proposalDetailsCustomDTO
							.setSAndSDiscountAmount4(proposalContractBO
									.getSAndSDiscountAmount4());
					proposalDetailsCustomDTO
							.setSAndSDiscountAmount5(proposalContractBO
									.getSAndSDiscountAmount5());

					int contractDurationMonths = OPPTCalender
							.calculateContractPeriodDuration(proposalContractBO
									.getContrStartDate(), proposalContractBO
									.getContrEndDate());
					int contractDurationYears = contractDurationMonths / 12;
					if (contractDurationMonths % 12 > 0) {
						++contractDurationYears;
					}
					proposalDetailsCustomDTO
							.setSAndSExtendedYears(contractDurationYears);
				}
				/* End change CR6153 */
			}
			proposalDetailsCustomDTO.setInvoiceAmount(proposalContractBO
					.getInvoiceAmount());

			if (proposalDetailsCustomDTO.getProposalEditable() == false
					|| ProposalContractStatusConstants.PENDING_APPROVAL
							.equals(OPPTHelper.trimString(proposalContractBO
									.getStatusCode()))) {

				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.FETCH_PLAN);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.FETCH_INELIGIBLE);
				proposalDetailsCustomDTO.addButtonFlag(ButtonConstants.REFETCH);
				proposalDetailsCustomDTO.addButtonFlag(ButtonConstants.PRICE);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.VALIDATE_TP);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.EDIT_INVENTORY);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.DELETE_INVENTORY);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.COPY_NEW);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.COPY_BUMP);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.CONFIGURE_DM);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.INCLUDE_EXCLUDE);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.ADDCUSTOMER_BUTTON);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.REMOVE_SVC_LICENSES);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.REGISTER);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.SS_PLANNING);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.REMOVE_QUOTES);
				//proposalDetailsCustomDTO.addButtonFlag(ButtonConstants.HEADER_DETAILS);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.AMEND_SWO);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.DELTA_FETCH);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.COMPARE_TP);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.CHANGEPROPOSAL_BUTTON);
				//CR 2031
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.DUPLICATE_SERIAL_NUMBERS);

			} else {
				proposalContractBO.validateProposalDetails(
						UtilityConstants.BUSINESSRULE_POST_COND_TYPE, map);
				proposalDetailsCustomDTO.setButtonFlags(proposalContractBO
						.getPostConditionResult());
				OPPTLogger.debug(proposalDetailsCustomDTO.getButtonFlags()
						.toString(), CLASS_NAME, methodName);
			}

			if ((proposalDetailsCustomDTO.getRole() == RoleConstants.PROPOSAL_APPROVER || proposalDetailsCustomDTO
					.getRole() == RoleConstants.CREATE_APPROVE) == false) {
				proposalDetailsCustomDTO.addButtonFlag(ButtonConstants.APPROVE);
				proposalDetailsCustomDTO.addButtonFlag(ButtonConstants.REJECT);
			}
			// This is added to fix bugs for approve and reject
			if (proposalDetailsCustomDTO.getProposalEditable() == false
					&& (proposalDetailsCustomDTO.getRole() == RoleConstants.PROPOSAL_APPROVER || proposalDetailsCustomDTO
							.getRole() == RoleConstants.CREATE_APPROVE)) {
				// Added for create approve and approve proposal
				if (!proposalContractBO.validateRequestForApproveOrReject(
						UtilityConstants.BUSINESSRULE_POST_COND_TYPE, map)) {
					proposalDetailsCustomDTO
							.addButtonFlag(ButtonConstants.APPROVE);
					proposalDetailsCustomDTO
							.addButtonFlag(ButtonConstants.REJECT);
				}
			}

			if (!proposalContractBO.isProposal()
					&& !(ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
							.equals(proposalContractBO.getStatusCode()) || ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
							.equals(proposalContractBO.getStatusCode()))) {
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.REGISTER);
			}

			int role = proposalDetailsCustomDTO.getRole();
			if (role == RoleConstants.CREATE_APPROVE) {
				String statusCode = OPPTHelper.trimString(proposalContractBO
						.getStatusCode());
				if ((ProposalContractStatusConstants.PENDING_APPROVAL
						.equals(statusCode)
						|| ProposalContractStatusConstants.EXTENDED_CONTRACT_PENDING_APPROVAL
								.equals(statusCode)
						|| ProposalContractStatusConstants.AMENDED_CONTRACT_PENDING_APPROVAL
								.equals(statusCode) || ProposalContractStatusConstants.VARIANCE_CLOSURE_PENDING_APROVAL
						.equals(statusCode))
						&& proposalDetailsCustomDTO.getUserId().equals(
								OPPTHelper.trimString(proposalContractBO
										.getApprovedBy()))) {
					proposalDetailsCustomDTO
							.addButtonFlag(ButtonConstants.PRINT_PROPOSAL);
					proposalDetailsCustomDTO
							.addButtonFlag(ButtonConstants.DUPLICATE_SERIAL_NUMBERS);
				}
			} else if (role != RoleConstants.CSO
					&& role != RoleConstants.MARKETING_REP
					&& role != RoleConstants.BHD
					&& role != RoleConstants.OPPT_READ
					&& role != RoleConstants.BUSINESS_PARTNER) {
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.PRINT_PROPOSAL);
			}

			if (!(ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
					.equals(proposalContractBO.getStatusCode()) || ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
					.equals(proposalContractBO.getStatusCode()))) {
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.CHANGEPROPOSAL_BUTTON);
			} else {
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.FETCH_PLAN);
				proposalDetailsCustomDTO.addButtonFlag(ButtonConstants.REFETCH);
				//proposalDetailsCustomDTO.addButtonFlag(ButtonConstants.CONFIGURE_DM);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.REMOVE_QUOTES);
				//proposalDetailsCustomDTO.addButtonFlag(ButtonConstants.REMOVE_SVC_LICENSES);
			}
			// This is a code change for Variance Proposal
			if (proposalContractBO.isVarianceProposal()) {
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.FETCH_PLAN);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.FETCH_INELIGIBLE);
				proposalDetailsCustomDTO.addButtonFlag(ButtonConstants.REFETCH);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.VALIDATE_TP);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.EDIT_INVENTORY);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.DELETE_INVENTORY);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.COPY_NEW);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.COPY_BUMP);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.CONFIGURE_DM);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.INCLUDE_EXCLUDE);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.ADDCUSTOMER_BUTTON);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.REMOVE_SVC_LICENSES);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.SS_PLANNING);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.REMOVE_QUOTES);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.AMEND_SWO);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.DELTA_FETCH);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.COMPARE_TP);
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.CHANGEPROPOSAL_BUTTON);
				proposalDetailsCustomDTO.setVarianceProposal(true);
				//CR 2031
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.DUPLICATE_SERIAL_NUMBERS);
			} else {
				proposalDetailsCustomDTO.setVarianceProposal(false);
			}
			if (proposalContractBO.isContractInAmendment()) {
				proposalDetailsCustomDTO
						.setAmendmentEffectiveDate(proposalContractBO
								.getAmendEffectiveDate());
				proposalDetailsCustomDTO.setContractInAmendment(true);
			}

			if (!proposalContractBO.isProposal()) {
				proposalDetailsCustomDTO
						.addButtonFlag(ButtonConstants.DUPLICATE_SERIAL_NUMBERS);
			}
           //DADO02 SateeshAnne BlueHarmony
			try{
				List customerBOList = customerBOFactory.findCustomerBOforProposal(proposalID,1);
				List selectedCustomers = new ArrayList();
				if(null!=customerBOList && customerBOList.size()>0){
					Iterator iterator = customerBOList.iterator();
					while(iterator.hasNext()){
						CustomerBO customerBO = (CustomerBO)iterator.next();

						CustomerListCustomDTO customerListCustomDTO  =  new CustomerListCustomDTO();
						customerListCustomDTO.setCustomerName(customerBO.getSapCustomerName());
						customerListCustomDTO.setCustomerNumber(customerBO.getSapCustomerNo());

						selectedCustomers.add(customerListCustomDTO);
					}
					proposalDetailsCustomDTO.setSelectedCustomers(selectedCustomers);
				}
			}catch(DomainException e){
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());

			} //DADO02

			return proposalDetailsCustomDTO;
		} catch (ServiceException se) {
			throw se;
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					methodName, null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To print the proposal
	 *
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Feb 4, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param printProposalCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public PrintProposalCustomDTO printProposal(
			PrintProposalCustomDTO printProposalCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "printProposal");

		try {
			ProposalCustomDTO proposalCustomDTO = printProposalCustomDTO
					.getProposal();
			ProposalContractDTOFactory factory = new ProposalContractDTOFactory();

			int proposalID = proposalCustomDTO.getId();
			ProposalContractBOFactory boFactory = new ProposalContractBOFactory();
			ProposalContractBO proposalContractBO = boFactory
					.getProposalContractBO(proposalID);

			if (OPPTPropertiesReader.useDownload()) {
				int swoCount = factory.getSWOCount(proposalContractBO
						.getProposalId());
				int maxSWOForView = OPPTPropertiesReader
						.getMaxSWOForViewProposal();
				String[] messageInputs = { String.valueOf(maxSWOForView) };
				if (swoCount > maxSWOForView) {
					ErrorReport errReport = new ErrorReport();
					errReport = ExceptionGenerator.addErrorEntry(errReport,
							messageInputs, ErrorCodeConstants.SE0019,
							OPPTMessageCatalog.TYPE_SERVICE);
					throw ExceptionGenerator
							.generateServiceException(errReport);
				}
			}

			ProposalDomainDTO domainDTO = factory.getProposalContractDomainDTO(
					proposalID, -1, null, UtilityConstants.PRINT_PAGE, 0, 0, 0,
					proposalContractBO.isSAndSProposal(), proposalContractBO
							.getProposalContent(), false);

			ProposalDetailsBuildHelper helper = new ProposalDetailsBuildHelper();
			helper.buildPrintProposalCustomDTO(domainDTO,
					printProposalCustomDTO, proposalContractBO,
					getCustomerList(proposalID), proposalContractBO
							.isSAndSProposal(), proposalContractBO.isPriced(),
					proposalContractBO.isDraft(), proposalContractBO
							.getDatePriced());

			if (proposalContractBO.isSAndSProposal()) {
				printProposalCustomDTO
						.setSandSDiscountAmount(proposalContractBO
								.getSAndsDiscount());
			}
			printProposalCustomDTO.setInvoiceAmount(proposalContractBO
					.getInvoiceAmount());

			return printProposalCustomDTO;
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"printProposal", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To copy the proposal or contract
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copyProposalCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public CopyProposalCustomDTO copyProposal(
			CopyProposalCustomDTO copyProposalCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "copyProposal");

		final String VARIANCE = "V";
		String operationPerformed = "Copy proposal created";

		ProposalContractBOFactory factory = new ProposalContractBOFactory();
		ProposalCustomDTO proposalCustomDTO = copyProposalCustomDTO
				.getSourceProposal();
		ProposalDomainDTO proposalDomainDTO = null;

		try {
			
			String newProposalName = copyProposalCustomDTO.getNewProposalName();
			if (newProposalName != null){
			
			if (factory.isProposalNameExists(newProposalName)) {
				throwServiceException(ErrorCodeConstants.SE0018,
						OPPTMessageCatalog.TYPE_SERVICE);
			}
			}
			ProposalContractBO proposalContractBO = factory
					.getProposalContractBO(proposalCustomDTO.getId());
			proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
			if (VARIANCE.equals(proposalContractBO.getContrType())) {
				throwServiceException(ErrorCodeConstants.SE0301,
						OPPTMessageCatalog.TYPE_SERVICE);
			}
			boolean isClosedStatus = ProposalContractStatusConstants.CLOSED
					.equals(proposalContractBO.getStatusCode());
			boolean isProposal = proposalContractBO.isProposal();

			if (isProposal || (isClosedStatus == false)) {
				CopyInventoryDomainDTO copyInventoryDomainDTO = new CopyInventoryDomainDTO();
				copyInventoryDomainDTO
						.setActionName(ActionNameConstants.COPY_PROPOSAL);
				copyInventoryDomainDTO.setOldProposalID(proposalContractBO
						.getProposalId());
				ProposalContractBO maxProposalContractBO = factory
						.findMaxProposalContractBO();
				proposalContractBO.setProposalId(maxProposalContractBO
						.getProposalId() + 1);
//				Blue Harmony Wave 1 DAD001 - Start - Anand
				if (newProposalName ==null || newProposalName.trim().equalsIgnoreCase("")){
				String proposalContent = proposalContractBO.getProposalContent().equalsIgnoreCase("M")? "MLC" :"SandS";	
                int customerNameLength =  proposalContractBO.getRegCustomerName().length();
                if(customerNameLength >= 20){
				proposalContractBO.setSelectedCustomerName(proposalContractBO.getRegCustomerName().substring(0,20).trim());
                }
                else
                {
                	proposalContractBO.setSelectedCustomerName(proposalContractBO.getRegCustomerName().trim());	
                }
			//	String copyNewProposalName = proposalContractBO.getSalesOrg()+"_"+proposalContractBO.getRegCustomerName()+"_"+proposalContent;
				int proposalCount;
				
				try{
				
					
				proposalCount = factory.getMaxProposalCount(proposalContractBO);
				
				proposalContractBO.setProposalCount(proposalCount);
				 newProposalName = proposalContractBO.getSalesOrg()+"_"+proposalContractBO.getSelectedCustomerName().trim()+"_"+proposalContent+"_"+proposalContractBO.getProposalCount();
				 proposalContractBO.setProposalName(newProposalName);
				 proposalContractBO.setAutoPopulate(UtilityConstants.YES);		
				 
				
			
				} catch (DomainException  ex){}
				
				
				
				}
				else{
				
				proposalContractBO.setProposalName(copyProposalCustomDTO
						.getNewProposalName());
				proposalContractBO.setAutoPopulate(UtilityConstants.NO);
				
				
				}
//				Blue Harmony Wave 1 DAD001 - End - Anand
				if (ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS
						.equals(proposalCustomDTO.getStatus())) {
					proposalContractBO
							.setStatusCode(ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS);
				} else {
					proposalContractBO
							.setStatusCode(ProposalContractStatusConstants.DRAFT);
				}

				ProposalContractDTOFactory dtoFactory = new ProposalContractDTOFactory();
				try {
					proposalContractBO.setContrNo(factory
							.getProposalContractBOWithMaxContractNumber("P01")
							.getContrNo());
				} catch (Exception ex) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							"copyProposal", null, ex);
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0801);
				}

				proposalContractBO.setCreatedBy(copyProposalCustomDTO
						.getUserId());

				java.util.Date today = new java.util.Date();

				// Release the proposal if the original is locked, shouldnt be
				// shared, submitted by and approved by should be null.
				updateProposalFieldsForCopy(proposalContractBO, true);

				proposalContractBO.setExtContrNo(null);
				proposalContractBO.setOldContrNo(null);
				proposalContractBO.setContrAmendNo(0);
				proposalContractBO.setContrRenewNo(1);
				proposalContractBO.setContrType(ContractTypeConstants.ORIGINAL);

				proposalContractBO.setLockedBy(copyProposalCustomDTO
						.getUserId());
				proposalContractBO.setLockedOn(new java.sql.Date(today
						.getTime()));
				OPPTLogger.debug("Use DAO = " + OPPTPropertiesReader.useDAO(),
						CLASS_NAME, "copyProposal");
				if (OPPTPropertiesReader.useDAO()) {
					// Building the DomainDTO's
					// added by Balaji
					proposalDomainDTO
							.setActionName(ActionNameConstants.COPY_PROPOSAL);
					proposalDomainDTO = getInventoryManagerLocal()
							.retrieveCustomerForCopyInventory(proposalDomainDTO);

				}

				factory.createProposalContractBO(proposalContractBO);
				copyInventoryDomainDTO.setNewProposalID(proposalContractBO
						.getProposalId());
				copyCustomerList(copyInventoryDomainDTO);
				if (OPPTPropertiesReader.useDAO()) {
					// Will call API to add inventory
					proposalDomainDTO.setProposalId(proposalContractBO
							.getProposalId());
					proposalDomainDTO.setActionAllowed(true);
					InventoryDTOFactory.storeInventory(proposalDomainDTO);

				} else {

					getInventoryManagerLocal().copyInventory(
							copyInventoryDomainDTO);
				}

				createAccessHistory(proposalContractBO.getProposalId(),
						copyProposalCustomDTO.getUserId(), operationPerformed);

				proposalCustomDTO.setId(proposalContractBO.getProposalId());
				proposalCustomDTO.setName(proposalContractBO.getProposalName());
				proposalCustomDTO.setOldContractNumber(proposalContractBO
						.getOldContrNo());
				proposalCustomDTO.setStatus(proposalContractBO.getStatusCode());
				proposalCustomDTO.setType(proposalContractBO.getProposalType());
				proposalCustomDTO.setLockedBy(proposalContractBO.getLockedBy());
			} else {
				if (isProposal) {
					throwServiceException(ErrorCodeConstants.SE0302,
							OPPTMessageCatalog.TYPE_SERVICE);
				} else {
					throwServiceException(ErrorCodeConstants.SE0303,
							OPPTMessageCatalog.TYPE_SERVICE);
				}
			}
			return copyProposalCustomDTO;
		} catch (DomainException e) {
			try {
				getSessionContext().setRollbackOnly();
			} catch (IllegalStateException lie) {
				// we do nothing
			}

			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To create the access history record for the given proposal and user id
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalID
	 * @param userID
	 * @param operationPerformed
	 */
	private void createAccessHistory(int proposalID, String userID,
			String operationPerformed) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "createAccessHistory");
		AccessHistoryBO accessHistoryBO = new AccessHistoryBO();
		accessHistoryBO.setProposalId(proposalID);
		accessHistoryBO.setUserId(userID);
		accessHistoryBO.setOperationPerformed(operationPerformed);
		try {
			iAccessHistoryBOFactory.create(accessHistoryBO);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To get the customer list
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 2, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalID
	 * @return
	 * @throws DomainException
	 */
	private List getCustomerList(int proposalID) throws DomainException {
		CustomerListBOFactory customerListBOFactory = new CustomerListBOFactory();
		return customerListBOFactory.findCustomerListBOForProposal(proposalID);
	}

	/**
	 * To copy the inventory domain dto
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 17, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copyInventoryDomainDTO
	 * @throws DomainException
	 */
	private void copyCustomerList(CopyInventoryDomainDTO copyInventoryDomainDTO)
			throws DomainException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "copyCustomerList");
		try {
			List list = getCustomerList(copyInventoryDomainDTO
					.getOldProposalID());
			Iterator iter = list.iterator();

			CustomerListBOFactory customerListBOFactory = new CustomerListBOFactory();
			CustomerListBO customerListBO;
			Date lastUpdateDate = new Date(System.currentTimeMillis());

			while (iter.hasNext()) {
				customerListBO = (CustomerListBO) iter.next();
				customerListBO.setProposalId(copyInventoryDomainDTO
						.getNewProposalID());
				customerListBO.setLastUpdatedDate(lastUpdateDate);
				customerListBOFactory.createCustomerListBO(customerListBO);
			}

		} catch (DomainException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To get the contract for extension
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param extendContractCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public ExtendContractCustomDTO extendContract(
			ExtendContractCustomDTO extendContractCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "extendContract");

		try {
			ProposalContractBOFactory factory = new ProposalContractBOFactory();
			ProposalContractBO proposalContractBO = null;
			try {
				proposalContractBO = factory
						.getProposalContractBO(extendContractCustomDTO
								.getContractDTO().getId());
			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de
						.getErrorReport());
			}

			String proposalType = proposalContractBO.getProposalType();

			boolean isValidUser = checkUserAndAuthority(proposalContractBO,
					extendContractCustomDTO);
			if (ProposalTypeConstants.EASII.equals(proposalType)
					|| proposalContractBO.isSAndSProposal()
					|| ProposalTypeConstants.AMO.equals(proposalType)
					|| ProposalTypeConstants.ESSO.equals(proposalType)
					|| ProposalTypeConstants.PLE.equals(proposalType)) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0304);
			}
			if ((ProposalContractStatusConstants.VARIANCE_BILLED
					.equals(proposalContractBO.getStatusCode()) || ProposalContractStatusConstants.CONTRACT
					.equals(proposalContractBO.getStatusCode()))
					|| (ProposalContractStatusConstants.EXTENDED
							.equals(proposalContractBO.getStatusCode()) && ProposalTypeConstants.TP
							.equals(proposalType))) {

				ContractCustomDTO customDTO = extendContractCustomDTO
						.getContractDTO();

				extendContractCustomDTO.setContractNumber(proposalContractBO
						.getContrNo());
				extendContractCustomDTO.setContractType(proposalContractBO
						.getContrType());
				extendContractCustomDTO
						.setExternalContractNumber(proposalContractBO
								.getExtContrNo());
				extendContractCustomDTO.setProposalName(proposalContractBO
						.getProposalName());
				extendContractCustomDTO.setProposalType(proposalContractBO
						.getProposalType());
				extendContractCustomDTO
						.setContractPeriodEndDate(proposalContractBO
								.getContrEndPeriod());
				extendContractCustomDTO
						.setContractPeriodStartDate(proposalContractBO
								.getContrStartPeriod());

				OPPTCalender calendar = new OPPTCalender();
				calendar.setTime(OPPTCalender.addDate(Calendar.MONTH, 3,
						proposalContractBO.getContrEndPeriod()));
				calendar.set(Calendar.DAY_OF_MONTH, calendar
						.getActualMaximum(Calendar.DAY_OF_MONTH));

				extendContractCustomDTO.setExtensionDate(calendar.getTime());

				customDTO.setContractNumber(proposalContractBO.getContrNo());
				customDTO.setId(proposalContractBO.getProposalId());
				customDTO.setLockedBy(proposalContractBO.getLockedBy());
				customDTO.setName(proposalContractBO.getProposalName());
				customDTO.setOldContractNumber(proposalContractBO
						.getOldContrNo());
				customDTO.setStatus(proposalContractBO.getStatusCode());
				customDTO.setType(proposalContractBO.getContrType());
				customDTO.setAccess(proposalContractBO.getProposalSharing());
			} else {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0305);
			}

			return extendContractCustomDTO;
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To check the user and authority
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalContractBO
	 * @param userID
	 * @return true if the user has access
	 */
	private boolean checkUserAndAuthority(
			ProposalContractBO proposalContractBO, OPPTCustomDTO customDTO)
			throws ServiceException {
		boolean isValidUser = false;
		try {
			SharingBO sharingBO = getSharingBOFromFactory(proposalContractBO
					.getProposalId(), customDTO.getUserId());
			HashMap map = populateCompareValuesForUserAuthInProposalBO(
					customDTO, sharingBO);

			if (proposalContractBO.validateUserAuthorityForChange(map) == false) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0306);
			}
			isValidUser = true;
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}
		return isValidUser;
	}

	/**
	 * To extend the contract
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param extendContractCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public ExtendContractCustomDTO submitExtendContract(
			ExtendContractCustomDTO extendContractCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "submitExtendContract");

		try {
			ProposalContractBOFactory factory = new ProposalContractBOFactory();
			ProposalContractBO proposalContractBO = null;
			try {
				proposalContractBO = factory
						.getProposalContractBO(extendContractCustomDTO
								.getContractDTO().getId());

				String proposalType = OPPTHelper.trimString(proposalContractBO
						.getProposalType());

				java.util.Date extensionDate = extendContractCustomDTO
						.getExtensionDate();
				if (ProposalTypeConstants.TP.equals(proposalType) == false) {
					if (OPPTCalender.isLastDayOfTheMonth(extensionDate) == false) {
						throw ExceptionGenerator
								.generateDomainException(ErrorCodeConstants.DE0028);
					}

					OPPTCalender calendar = new OPPTCalender();
					java.util.Date endPeriod = OPPTCalender.addDate(
							Calendar.MONTH, 3, proposalContractBO
									.getContrEndPeriod());

					if (calendar.isDateGreater(endPeriod, extensionDate)) {
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0340);
					}
				}

				//proposalContractBO.validateForContractDates(true);
			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de
						.getErrorReport());
			}

			RegistrationCustomDTO registrationCustomDTO = new RegistrationCustomDTO();
			registrationCustomDTO.setContractNumber(extendContractCustomDTO
					.getContractNumber());
			registrationCustomDTO
					.setContractType(ProposalContractStatusConstants.CONTRACT);
			registrationCustomDTO
					.setExternalContractNumber(extendContractCustomDTO
							.getExternalContractNumber());
			registrationCustomDTO
					.setUserId(extendContractCustomDTO.getUserId());

			ProposalCustomDTO proposalCustomDTO = new ProposalCustomDTO();
			ContractCustomDTO contractCustomDTO = extendContractCustomDTO
					.getContractDTO();

			proposalCustomDTO.setId(contractCustomDTO.getId());
			proposalCustomDTO.setLockedBy(contractCustomDTO.getLockedBy());
			proposalCustomDTO.setName(contractCustomDTO.getName());
			proposalCustomDTO.setOldContractNumber(contractCustomDTO
					.getOldContractNumber());
			proposalCustomDTO.setStatus(contractCustomDTO.getStatus());
			proposalCustomDTO.setType(contractCustomDTO.getType());
			proposalCustomDTO.setSessionId(extendContractCustomDTO
					.getSessionId());

			registrationCustomDTO.setProposalDTO(proposalCustomDTO);

			registrationCustomDTO = getRegistrationData(registrationCustomDTO);
			proposalCustomDTO = registrationCustomDTO.getProposalDTO();
			extendContractCustomDTO.setContractNumber(registrationCustomDTO
					.getContractNumber());
			extendContractCustomDTO.setContractType(registrationCustomDTO
					.getContractType());
			extendContractCustomDTO
					.setExternalContractNumber(registrationCustomDTO
							.getExternalContractNumber());
			extendContractCustomDTO
					.setProposalName(proposalCustomDTO.getName());
			extendContractCustomDTO
					.setProposalType(proposalCustomDTO.getType());
			contractCustomDTO.setContractNumber(registrationCustomDTO
					.getContractNumber());
			contractCustomDTO.setId(proposalCustomDTO.getId());
			contractCustomDTO.setLockedBy(proposalCustomDTO.getLockedBy());
			contractCustomDTO.setName(proposalCustomDTO.getName());
			contractCustomDTO.setOldContractNumber(proposalCustomDTO
					.getOldContractNumber());
			contractCustomDTO.setStatus(proposalCustomDTO.getStatus());
			contractCustomDTO.setType(proposalCustomDTO.getType());
			extendContractCustomDTO.setContractDTO(contractCustomDTO);
			return extendContractCustomDTO;
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To return the header for a replacement request
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 17, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param replaceContractCustomDTO
	 * @return replacement contract custom dto
	 * @throws ServiceException
	 */
	public ReplaceContractCustomDTO getHeaderForReplacement(
			ReplaceContractCustomDTO replaceContractCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME,
				"getHeaderForReplacement");

		try {
			ContractCustomDTO contractDTO = replaceContractCustomDTO
					.getContractDTO();
			String contractStatus = contractDTO.getStatus();

			if (ProposalContractStatusConstants.CONTRACT.equals(contractStatus)
					|| ProposalContractStatusConstants.EXTENDED
							.equals(contractStatus)
					|| ProposalContractStatusConstants.VARIANCE_BILLED
							.equals(contractStatus)) {
				ProposalContractBOFactory factory = new ProposalContractBOFactory();
				ProposalContractBO proposalContractBO = null;
				try {
					proposalContractBO = factory
							.getProposalContractBO(contractDTO.getId());
				} catch (DomainException de) {
					throw ExceptionGenerator.generateServiceException(de
							.getErrorReport());
				}
				boolean isValidUser = checkUserAndAuthority(proposalContractBO,
						replaceContractCustomDTO);

				if (ProposalTypeConstants.EAS.equals(proposalContractBO
						.getProposalType())) {
					checkForEASIIExistence(proposalContractBO.getTpContrNo());
				}

				replaceContractCustomDTO.setContractNumber(proposalContractBO
						.getContrNo());
				replaceContractCustomDTO.setContractType(proposalContractBO
						.getContrType());
				replaceContractCustomDTO
						.setExternalContractNumber(proposalContractBO
								.getExtContrNo());
				replaceContractCustomDTO.setProposalName(proposalContractBO
						.getProposalName());
				replaceContractCustomDTO.setProposalType(proposalContractBO
						.getProposalType());
				replaceContractCustomDTO
						.setContractPeriodEndDate(proposalContractBO
								.getContrEndPeriod());
				replaceContractCustomDTO
						.setContractPeriodStartDate(proposalContractBO
								.getContrStartPeriod());
				/* start change CR6153 */
				replaceContractCustomDTO
						.setISandsExtendPeriod(proposalContractBO
								.getExtendPeriod());
				replaceContractCustomDTO.setProposalContent(proposalContractBO
						.getProposalContent());
				replaceContractCustomDTO
						.setContractStartDate(proposalContractBO
								.getContrStartDate());
				replaceContractCustomDTO.setContractEndDate(proposalContractBO
						.getContrEndDate());
				/* end change CR6153 */
				replaceContractCustomDTO.setContractReplacementDate(null);
				//proposalContractBO.getContrReplDate());

				contractDTO.setContractNumber(proposalContractBO.getContrNo());
				contractDTO.setId(proposalContractBO.getProposalId());
				contractDTO.setLockedBy(proposalContractBO.getLockedBy());
				contractDTO.setName(proposalContractBO.getProposalName());
				contractDTO.setOldContractNumber(proposalContractBO
						.getOldContrNo());
				contractDTO.setStatus(proposalContractBO.getStatusCode());
				contractDTO.setType(proposalContractBO.getProposalType());
			} else {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0307);
			}

			return replaceContractCustomDTO;
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 17, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copyReplacementCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public CopyReplacementCustomDTO copyReplaceContract(
			CopyReplacementCustomDTO copyReplacementCustomDTO)
			throws ServiceException {
		String methodName = "copyReplaceContract";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		final String REPLACEMENT_CONTRACT = "R";
		final String operationPerformed = "Replace contract created using copy option";

		ReplaceContractCustomDTO replaceContractCustomDTO = copyReplacementCustomDTO
				.getReplaceContractDTO();
		ContractCustomDTO contractCustomDTO = replaceContractCustomDTO
				.getContractDTO();

		try {
			ProposalContractBOFactory factory = new ProposalContractBOFactory();
			ProposalContractBO proposalContractBO = null;
			try {
				proposalContractBO = factory
						.getProposalContractBO(contractCustomDTO.getId());
			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de
						.getErrorReport());
			}

			ProposalContractBO newProposalContractBO = null;
			try {
				proposalContractBO = factory
						.getProposalContractBO(contractCustomDTO.getId());
				newProposalContractBO = factory
						.getProposalContractBO(contractCustomDTO.getId());
			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de
						.getErrorReport());
			}
			if (factory.isProposalNameExists(copyReplacementCustomDTO
					.getNewProposalName())) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0018);
			}
			proposalContractBO.validateContractForReplacementRenewal();
			validateContractForReplacementRenewal(proposalContractBO);

			validateReplacementDate(replaceContractCustomDTO);

			java.util.Date replacementDate = replaceContractCustomDTO
					.getContractReplacementDate();
			String proposalType = OPPTHelper.trimString(proposalContractBO
					.getProposalType());

			Date replacementDateSQL = new Date(replacementDate.getTime());

			proposalContractBO.setContrReplDate(replacementDateSQL);
			proposalContractBO
					.setStatusCode(ProposalContractStatusConstants.REPLACEMENT_IN_PROGRESS);
			proposalContractBO.setLastUpdatedDate(new Date(System
					.currentTimeMillis()));

			double contractReplacementNo = proposalContractBO.getContrReplNo() + 1;
			newProposalContractBO.setContrReplNo(contractReplacementNo);
			newProposalContractBO.setContrNo(getNewTypeContractNumber(
					newProposalContractBO.getContrNo(), contractReplacementNo,
					REPLACEMENT_CONTRACT));
			newProposalContractBO
					.setOldContrNo(proposalContractBO.getContrNo());
			newProposalContractBO
					.setStatusCode(ProposalContractStatusConstants.DRAFT);

			newProposalContractBO.setContrStartPeriod(replacementDateSQL);
			newProposalContractBO.setContrStartDate(replacementDateSQL);
			newProposalContractBO
					.setContrType(ContractTypeConstants.REPLACEMENT);
			newProposalContractBO.setLastUpdatedDate(new Date(System
					.currentTimeMillis()));

			// UD change
			newProposalContractBO.setGroupName(proposalContractBO
					.getGroupName());

			//			if (ProposalTypeConstants.EASII.equals(proposalType)) {
			//				proposalContractBO.setTpContrNo(newProposalContractBO.getContrNo());
			//			}

			CopyInventoryDomainDTO copyInventoryDomainDTO = new CopyInventoryDomainDTO();
			copyInventoryDomainDTO.setOldProposalID(newProposalContractBO
					.getProposalId());
			ProposalContractBO maxProposalContractBO;
			String userID = copyReplacementCustomDTO.getUserId();
			try {
				maxProposalContractBO = factory.findMaxProposalContractBO();
				newProposalContractBO.setProposalId(maxProposalContractBO
						.getProposalId() + 1);
				
//				Blue Harmony Wave 1 DAD001 - Start - Anand
				
				String proposalName = copyReplacementCustomDTO.getNewProposalName();
				// system.out.println("Replace proposalName auto populate" +proposalContractBO.getAutoPopulate());
				// system.out.println("Replace proposalName" +proposalName);
				int replaceCount = (int) proposalContractBO.getContrReplNo()+1;
				String proposalContent1 = proposalContractBO.getProposalContent().equalsIgnoreCase("M")? "MLC" :"SandS";
			if ((proposalName== null ||proposalName.trim().equalsIgnoreCase(""))&& proposalContractBO.getAutoPopulate().equalsIgnoreCase(UtilityConstants.NO)){
					
				// system.out.println("inside if condition");
				int customerNameLength =  proposalContractBO.getRegCustomerName().length();
                if(customerNameLength >= 20){
                	newProposalContractBO.setSelectedCustomerName(proposalContractBO.getRegCustomerName().substring(0,20).trim());
                }
                else
                {
                	newProposalContractBO.setSelectedCustomerName(proposalContractBO.getRegCustomerName().trim());	
                }
				
				String salesOrg =  proposalContractBO.getSalesOrg();
		//		String proposalContent1 = proposalContractBO.getProposalContent().equalsIgnoreCase("M")? "MLC" :"SandS"; 
				String proposalContent =proposalContractBO.getProposalContent();
				
				// system.out.println("inside if condition" +customerName);
				// system.out.println("inside if condition" +salesOrg);
				// system.out.println("inside if condition" +proposalContent1);
				ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
					
				newProposalContractBO.setSalesOrg(salesOrg);
				newProposalContractBO.setProposalContent(proposalContent);
				
				int proposalCount;
				try{
					
				proposalCount = proposalContractBOFactory.getMaxProposalCount(newProposalContractBO);
				// system.out.println("proposal Count   " +proposalCount );
				
				newProposalContractBO.setProposalCount(proposalCount);
				// system.out.println("proposal Count   " +newProposalContractBO.getProposalCount());	
				
				String newProposalName =	salesOrg+"_"+newProposalContractBO.getSelectedCustomerName()+"_"+proposalContent1+"_"+proposalCount+"_RPL"+"_"+replaceCount;
		        newProposalContractBO.setProposalName(newProposalName);
		        newProposalContractBO.setAutoPopulate(UtilityConstants.YES);
				} catch (DomainException  ex){}
				}
			else if ((proposalName== null ||proposalName.trim().equalsIgnoreCase(""))&& proposalContractBO.getAutoPopulate().equalsIgnoreCase(UtilityConstants.YES)){
				//0147_ABC_MLC_1_RNW_2
				
				int renewindex = 	proposalContractBO.getProposalName().lastIndexOf("_RNW_");
				int replaceindex = proposalContractBO.getProposalName().lastIndexOf("_RPL_");
				String newProposalName =null;
				if (renewindex== -1 && replaceindex == -1  ){
				
					newProposalName = proposalContractBO.getProposalName()+"_RPL_"+replaceCount;
					newProposalContractBO.setProposalName(newProposalName);
					newProposalContractBO.setAutoPopulate(UtilityConstants.YES);
				
				}
				else if(replaceindex== -1 && renewindex!= -1){
					//0147_ABC_MLC_1_RNW_1
				String  oldProposalName = proposalContractBO.getProposalName().substring(0,proposalContractBO.getProposalName().lastIndexOf("_RNW_"));
			//	// system.out.println("orgProposalBO.getProposalName()  " +proposalContractBO.getProposalName());
			//	// system.out.println("oldProposalName    "   +oldProposalName);
				 newProposalName = oldProposalName+"_RPL_"+replaceCount;
				 newProposalContractBO.setProposalName(newProposalName);
				 newProposalContractBO.setAutoPopulate(UtilityConstants.YES);
				}
				
				else{
					String  oldProposalName = proposalContractBO.getProposalName().substring(0,proposalContractBO.getProposalName().lastIndexOf("_RPL_"));
				//	// system.out.println("orgProposalBO.getProposalName()  " +proposalContractBO.getProposalName());
				//	// system.out.println("oldProposalName    "   +oldProposalName);
					 newProposalName = oldProposalName+"_RPL_"+replaceCount;
					 newProposalContractBO.setProposalName(newProposalName);
					 newProposalContractBO.setAutoPopulate(UtilityConstants.YES);
					
				
				
				}
				
				
			}
			
			
			else {
				
				newProposalContractBO.setProposalName(copyReplacementCustomDTO
						.getNewProposalName());
				newProposalContractBO.setAutoPopulate(UtilityConstants.NO);
			}
			
//			Blue Harmony Wave 1 DAD001 - End - Anand
				newProposalContractBO.setCreatedBy(userID);
				// Added by Balaji as per Arun
				newProposalContractBO.setContrPeriodVarNo(0);
				// Added by Balaji as created date was copied from old contract
				// which is wrong
				newProposalContractBO.setCreatedDate(new Date(System
						.currentTimeMillis()));

				/* CR6153 start change */
				OPPTCalender startDateCalender = new OPPTCalender();
				OPPTCalender endDateCalender = new OPPTCalender();
				OPPTCalender calendar = new OPPTCalender();
				if ((proposalContractBO.getExtendPeriod() != null)
						&& (proposalContractBO.getExtendPeriod()
								.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {

					java.sql.Date tempStartDate = proposalContractBO
							.getContrStartPeriod();
					java.sql.Date tempEndDate = proposalContractBO
							.getContrEndPeriod();

					while (!((replacementDateSQL.after(tempStartDate) || calendar
							.isDateEqual(replacementDateSQL, tempStartDate)) && (replacementDateSQL
							.before(tempEndDate)))) {
						java.util.Date endPeriod = OPPTCalender.addDate(
								OPPTCalender.YEAR, 1, tempEndDate);
						java.util.Date startPeriod = OPPTCalender.addDate(
								OPPTCalender.YEAR, 1, tempStartDate);
						java.sql.Date endPeriod1 = new java.sql.Date(endPeriod
								.getTime());
						java.sql.Date startPeriod1 = new java.sql.Date(
								startPeriod.getTime());

						tempStartDate = startPeriod1;
						tempEndDate = endPeriod1;
					}

					newProposalContractBO.setContrEndPeriod(tempEndDate);
					newProposalContractBO.setExtendPeriod(proposalContractBO
							.getExtendPeriod());

					//If replacement date is in the first contract period, copy
					// the anniversary amounts as it is.
					//If the replacement date is in the second contract period,
					// copy the anniv amount of year 2 of original contract to
					// anniv amount of year 1 of replaced contract and so on.

					double[] sAndSAnnvAmountOrg = new double[5];
					sAndSAnnvAmountOrg[0] = proposalContractBO
							.getSAndsAnniversaryAmount();
					sAndSAnnvAmountOrg[1] = proposalContractBO
							.getSAndsAnniversaryAmt2();
					sAndSAnnvAmountOrg[2] = proposalContractBO
							.getSAndsAnniversaryAmt3();
					sAndSAnnvAmountOrg[3] = proposalContractBO
							.getSAndsAnniversaryAmt4();
					sAndSAnnvAmountOrg[4] = proposalContractBO
							.getSAndsAnniversaryAmt5();

					double[] sAndSAnnvAmountNew = new double[5];
					int contractDurationMonths = OPPTCalender
							.calculateContractPeriodDuration(proposalContractBO
									.getContrStartDate(), proposalContractBO
									.getContrEndDate());
					int contractDurationYears = contractDurationMonths / 12;

					tempStartDate = proposalContractBO.getContrStartPeriod();
					tempEndDate = proposalContractBO.getContrEndPeriod();

					for (int i = 0; i < contractDurationYears; i++) {
						if (((replacementDateSQL.after(tempStartDate) || calendar
								.isDateEqual(replacementDateSQL, tempStartDate)) && (replacementDateSQL
								.before(tempEndDate)))) {
							for (int j = i; j < contractDurationYears; j++) {
								sAndSAnnvAmountNew[j - i] = sAndSAnnvAmountOrg[j];
							}
							break;
						}
						java.util.Date endPeriod = OPPTCalender.addDate(
								OPPTCalender.YEAR, 1, tempEndDate);
						java.util.Date startPeriod = OPPTCalender.addDate(
								OPPTCalender.YEAR, 1, tempStartDate);
						java.sql.Date endPeriod1 = new java.sql.Date(endPeriod
								.getTime());
						java.sql.Date startPeriod1 = new java.sql.Date(
								startPeriod.getTime());

						tempStartDate = startPeriod1;
						tempEndDate = endPeriod1;
					}

					newProposalContractBO
							.setSAndsAnniversaryAmount(sAndSAnnvAmountNew[0]);
					newProposalContractBO
							.setSAndsAnniversaryAmt2(sAndSAnnvAmountNew[1]);
					newProposalContractBO
							.setSAndsAnniversaryAmt3(sAndSAnnvAmountNew[2]);
					newProposalContractBO
							.setSAndsAnniversaryAmt4(sAndSAnnvAmountNew[3]);
					newProposalContractBO
							.setSAndsAnniversaryAmt5(sAndSAnnvAmountNew[4]);
				}
				/* CR6153 end change */

				updateProposalFieldsForCopy(newProposalContractBO);
				if (!newProposalContractBO.getProposalType().equals(
						ProposalTypeConstants.EASII)) {
					if (newProposalContractBO.getBillingFreqCode().equals(
							UtilityConstants.BILLING_FREQ_QUARTERLY)) {
						String cntrStartPeriod = newProposalContractBO
								.getContrStartPeriod().toString();
						String cntrStartPeriodMonth = cntrStartPeriod
								.substring(5, 7);
						if (cntrStartPeriodMonth.equals("01")
								|| cntrStartPeriodMonth.equals("04")
								|| cntrStartPeriodMonth.equals("07")
								|| cntrStartPeriodMonth.equals("10")) {
							newProposalContractBO.setBillingType("YE");
						} else {
							newProposalContractBO.setBillingType("9Q");
						}
					}
				}

				boolean isUserInGroup = isUserInGroup(userID);
				if (isUserInGroup) {
					newProposalContractBO.setLockedBy(userID);
					newProposalContractBO.setLockedOn(new Date(System
							.currentTimeMillis()));
				}
				factory.createProposalContractBO(newProposalContractBO);

				copyInventoryDomainDTO
						.setActionName(ActionNameConstants.REPLACE_CONTRACT);
				copyInventoryDomainDTO.setNewProposalID(newProposalContractBO
						.getProposalId());
				HashMap values = new HashMap();
				values
						.put(UtilityConstants.PLAN_START_DATE,
								replacementDateSQL);
				values.put(UtilityConstants.PLAN_END_DATE,
						newProposalContractBO.getContrEndPeriod());
				copyInventoryDomainDTO.setValues(values);
				copyCustomerList(copyInventoryDomainDTO);

				getInventoryManagerLocal()
						.copyInventory(copyInventoryDomainDTO);
				createAccessHistory(newProposalContractBO.getProposalId(),
						copyReplacementCustomDTO.getUserId(),
						operationPerformed);

				// Update the replacement proposal
				factory.updateProposalContractBO(proposalContractBO);

				contractCustomDTO.setId(newProposalContractBO.getProposalId());
				contractCustomDTO.setName(newProposalContractBO
						.getProposalName());

				replaceContractCustomDTO.setContractType(newProposalContractBO
						.getContrType());
				replaceContractCustomDTO.setProposalType(newProposalContractBO
						.getProposalType());
			} catch (DomainException e) {
				OPPTLogger
						.debug("Rollback is called: ", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();

				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			} catch (Exception e) {
				OPPTLogger
						.debug("Rollback is called: ", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();

				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						methodName, null, e);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}

			return copyReplacementCustomDTO;
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To validate the replacement date
	 *
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 28, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copyReplacementCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public ReplaceContractCustomDTO validateReplacementDate(
			ReplaceContractCustomDTO replaceContractCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME,
				"validateReplacementDate");

		try {
			ProposalContractBOFactory factory = new ProposalContractBOFactory();
			ProposalContractBO proposalContractBO = null;
			try {
				proposalContractBO = factory
						.getProposalContractBO(replaceContractCustomDTO
								.getContractDTO().getId());
			} catch (DomainException ex) {
				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}

			//proposalContractBO.validateForContractDates(true);
			java.util.Date replacementDate = replaceContractCustomDTO
					.getContractReplacementDate();
			java.util.Date contractPeriodStartDate = replaceContractCustomDTO
					.getContractPeriodStartDate();
			java.util.Date contractPeriodEndDate = replaceContractCustomDTO
					.getContractPeriodEndDate();
			java.util.Date amendmentEffectiveDate = proposalContractBO
					.getAmendEffectiveDate();

			String proposalType = OPPTHelper.trimString(proposalContractBO
					.getProposalType());

			if (ProposalTypeConstants.TP.equals(proposalType) == false) {
				if (OPPTCalender.isFirstDayOfTheMonth(replacementDate) == false) {
					throw ExceptionGenerator
							.generateDomainException(ErrorCodeConstants.DE0027);
				}
			}

			OPPTCalender calendar = new OPPTCalender();

			boolean isValidAmendmentEffectiveDate = false;

			if (amendmentEffectiveDate != null) {
				isValidAmendmentEffectiveDate = (calendar.isDateGreater(
						replacementDate, amendmentEffectiveDate) || calendar
						.isDateEqual(replacementDate, amendmentEffectiveDate));
			}

			/* CR6153 start change */
			OPPTCalender startDateCalender = new OPPTCalender();
			OPPTCalender endDateCalender = new OPPTCalender();

			if ((proposalContractBO.getExtendPeriod() != null)
					&& (proposalContractBO.getExtendPeriod()
							.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {

				java.util.Date date = new java.util.Date();
				while (contractPeriodEndDate.getTime() < date.getTime()
						&& contractPeriodEndDate.getTime() < proposalContractBO
								.getContrEndDate().getTime()) {
					startDateCalender.setTime(OPPTCalender.addDate(
							OPPTCalender.YEAR, 1, contractPeriodStartDate));
					endDateCalender.setTime(OPPTCalender.addDate(
							OPPTCalender.YEAR, 1, contractPeriodEndDate));
					if (endDateCalender.getYear() % 4 == 0
							&& (endDateCalender.getYear() % 100 != 0 || endDateCalender
									.getYear() % 400 == 0)) {
						if (startDateCalender.getMonth() == 3
								&& startDateCalender.getDay() == 1
								&& (proposalContractBO.getContrEndDate()
										.getTime() > contractPeriodEndDate
										.getTime())) {
							endDateCalender.set(endDateCalender.getYear(),
									endDateCalender.getMonth() - 1,
									endDateCalender.getDay() + 1);
							// since month is 0 based in the set method, and
							// starts from 1 in the get method, we subtract 1
						}
					}
					contractPeriodStartDate.setTime(startDateCalender
							.getTimeInMillis());
					contractPeriodEndDate.setTime(endDateCalender
							.getTimeInMillis());
				}
			}
			/* CR6153 end change */

			if (proposalContractBO.isSAndSProposal()) {
				java.util.Date contractPeriodEndDatePlusOne = OPPTCalender
						.getDayPlusOneSqlDate(contractPeriodEndDate);
				if (calendar.isDateLesser(replacementDate,
						contractPeriodEndDatePlusOne)
						|| calendar.isDateEqual(replacementDate,
								contractPeriodEndDatePlusOne)) {
					if ((calendar.isDateGreater(replacementDate,
							contractPeriodStartDate) || calendar.isDateEqual(
							replacementDate, contractPeriodStartDate))
							|| isValidAmendmentEffectiveDate) {
						// do nothing... valid dates
					} else {
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0327);
					}
				} else {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0328);
				}

			} else {
				if (calendar.isDateLesser(replacementDate,
						contractPeriodEndDate)
						|| calendar.isDateEqual(replacementDate,
								contractPeriodEndDate)) {
					if ((calendar.isDateGreater(replacementDate,
							contractPeriodStartDate) || calendar.isDateEqual(
							replacementDate, contractPeriodStartDate))
							|| isValidAmendmentEffectiveDate) {
						// do nothing... valid dates
					} else {
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0327);
					}
				} else {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0328);
				}
			}

			if (ProposalTypeConstants.TP.equals(proposalType) == false) {
				String tpContractNumber = proposalContractBO.getTpContrNo();
				if (tpContractNumber != null
						&& (tpContractNumber = tpContractNumber.trim())
								.length() > 0) {
					ProposalContractBO contractBO = null;
					try {
						contractBO = factory
								.getProposalContractBOForContractNumber(
										tpContractNumber, true);
						if (ProposalContractStatusConstants.CONTRACT
								.equals(contractBO.getStatusCode())
								&& (calendar.isDateGreater(replacementDate,
										contractBO.getContrEndPeriod()) || calendar
										.isDateEqual(replacementDate,
												contractBO.getContrEndPeriod()))) {
							// do nothing
						} else {
							throw ExceptionGenerator
									.generateServiceException(ErrorCodeConstants.SE0312);
						}
					} catch (DomainException e) {
						if (isExceptionFound(e, ErrorCodeConstants.DE0636) == false) {
							throw ExceptionGenerator.generateServiceException(e
									.getErrorReport());
						}
					}
				}
			} else {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0308);
			}
			return replaceContractCustomDTO;
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To get the new contract number for the given type
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 23, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param contractNumber
	 * @param contractReplacementNo
	 * @param type
	 * @return new contract number for the given type
	 */
	private String getNewTypeContractNumber(String contractNumber,
			double contractReplacementNo, String type) {
		final String PADDING_CHAR = "0";
		String replacmentContractNoStr = Integer
				.toString((int) contractReplacementNo);
		StringBuffer buffer = new StringBuffer();
		buffer.append(contractNumber.substring(0, 7));
		buffer.append(type);
		if (replacmentContractNoStr.length() == 1) {
			buffer.append(PADDING_CHAR);
		}
		buffer.append(replacmentContractNoStr);
		return buffer.toString();
	}

	/**
	 * To get the renew contract
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 23, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param renewContractCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public RenewContractCustomDTO renewContract(
			RenewContractCustomDTO renewContractCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "renewContract");
			

		try {
			ContractCustomDTO contractDTO = renewContractCustomDTO
					.getContractDTO();
			String contractStatus = contractDTO.getStatus();

			if (ProposalTypeConstants.EASII.equals(contractDTO.getType())) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0334);
			}

			if (ProposalContractStatusConstants.CONTRACT.equals(contractStatus)
					|| ProposalContractStatusConstants.EXTENDED
							.equals(contractStatus)
					|| ProposalContractStatusConstants.VARIANCE_BILLED
							.equals(contractStatus)) {
				ProposalContractBOFactory factory = new ProposalContractBOFactory();
				ProposalContractBO proposalContractBO = null;
				try {
					proposalContractBO = factory
							.getProposalContractBO(contractDTO.getId());
				} catch (DomainException ex) {
					throw ExceptionGenerator.generateServiceException(ex
							.getErrorReport());
				}	
				boolean isValidUser = checkUserAndAuthority(proposalContractBO,
						renewContractCustomDTO);

				if (ProposalTypeConstants.EAS.equals(proposalContractBO
						.getProposalType())) {
					checkForEASIIExistence(proposalContractBO.getTpContrNo());
				}

				renewContractCustomDTO.setContractStartDate(proposalContractBO
						.getContrStartDate());
				renewContractCustomDTO.setContractEndDate(proposalContractBO
						.getContrEndDate());
				renewContractCustomDTO.setContractNumber(proposalContractBO
						.getContrNo());
				renewContractCustomDTO
						.setContractPeriodEndDate(proposalContractBO
								.getContrEndPeriod());
				renewContractCustomDTO
						.setContractPeriodStartDate(proposalContractBO
								.getContrStartPeriod());
				renewContractCustomDTO.setContractType(proposalContractBO
						.getContrType());
				renewContractCustomDTO
						.setExternalContractNumber(proposalContractBO
								.getExtContrNo());
				renewContractCustomDTO.setProposalName(proposalContractBO
						.getProposalName());
				renewContractCustomDTO.setProposalType(proposalContractBO
						.getProposalType());
				renewContractCustomDTO.setPrimarySalesOrg(proposalContractBO
						.getSalesOrg());
				/* start change CR6153 */
				renewContractCustomDTO.setISandsExtendPeriod(proposalContractBO
						.getExtendPeriod());
				renewContractCustomDTO.setProposalContent(proposalContractBO
						.getProposalContent());
				
							
				/* end change CR6153 */

				RenewContractHelper helper = new RenewContractHelper();
				renewContractCustomDTO.setAnniversaryRenewal(helper
						.isAnniversaryRenewal(renewContractCustomDTO,
								proposalContractBO));
				renewContractCustomDTO.setChooseRenewalType(helper.isShowRadio(
						renewContractCustomDTO, proposalContractBO));

			} else {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0307);
			}

			return renewContractCustomDTO;
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To renew the contract
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 23, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param renewContractCustomDTO
	 * @return
	 * @throws ServiceException
	 *             Customer information to be copied during Renewal. Changed by
	 *             Sara for EF0722042442 on 26 July 2004 - CMVCDefect 20
	 */
	public RenewContractCustomDTO enterRenewContractInfo(
			RenewContractCustomDTO renewContractCustomDTO)
			throws ServiceException {
		String methodName = "enterRenewContractInfo";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		final String operationPerformed = "Renew contract created";

		try {
			ProposalContractBOFactory factory = new ProposalContractBOFactory();
			if (factory.isProposalNameExists(renewContractCustomDTO
					.getNewProposalName())) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0018);
			}
			ContractCustomDTO contractDTO = renewContractCustomDTO
					.getContractDTO();
			contractDTO.setPrimarySalesOrg(renewContractCustomDTO
					.getPrimarySalesOrg());

			ProposalContractBO proposalBO = null;
			ProposalContractBO orgProposalBO = null;
			try {
				proposalBO = factory.getProposalContractBO(contractDTO.getId());
				orgProposalBO = factory.getProposalContractBO(contractDTO
						.getId());
			} catch (DomainException ex) {
				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}
			orgProposalBO.validateContractForReplacementRenewal();

			RenewContractHelper helper = new RenewContractHelper();
			/* start change CR6153 */
			if ((proposalBO.getExtendPeriod() != null)
					&& (proposalBO.getExtendPeriod()
							.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {
				final long orgCntrPeriodStrtDate = orgProposalBO
						.getContrStartPeriod().getTime();
				final long orgCntrPeriodEndDate = orgProposalBO
						.getContrEndPeriod().getTime();
				OPPTLogger.debug("Original contract period start date: "
						+ orgCntrPeriodStrtDate, CLASS_NAME, methodName);
				Date cntrPeriodStrtDate = proposalBO.getContrStartPeriod();
				Date cntrPeriodEndDate = proposalBO.getContrEndPeriod();

				OPPTCalender startDateCalender = new OPPTCalender();
				OPPTCalender endDateCalender = new OPPTCalender();
				java.util.Date date = new java.util.Date();
				while (cntrPeriodEndDate.getTime() < date.getTime()
						&& cntrPeriodEndDate.getTime() < proposalBO
								.getContrEndDate().getTime()) {
					startDateCalender.setTime(OPPTCalender.addDate(
							OPPTCalender.YEAR, 1, cntrPeriodStrtDate));
					endDateCalender.setTime(OPPTCalender.addDate(
							OPPTCalender.YEAR, 1, cntrPeriodEndDate));
					if (endDateCalender.getYear() % 4 == 0
							&& (endDateCalender.getYear() % 100 != 0 || endDateCalender
									.getYear() % 400 == 0)) {
						if (startDateCalender.getMonth() == 3
								&& startDateCalender.getDay() == 1
								&& (proposalBO.getContrEndDate().getTime() > cntrPeriodEndDate
										.getTime())) {
							endDateCalender.set(endDateCalender.getYear(),
									endDateCalender.getMonth() - 1,
									endDateCalender.getDay() + 1);
							// since month is 0 based in the set method, and
							// starts from 1 in the get method, we subtract 1
						}
					}
					cntrPeriodStrtDate.setTime(startDateCalender
							.getTimeInMillis());
					cntrPeriodEndDate
							.setTime(endDateCalender.getTimeInMillis());
				}
				OPPTLogger.debug("Original contract period start date 2: "
						+ orgCntrPeriodStrtDate, CLASS_NAME, methodName);
				orgProposalBO.setContrStartPeriod(new Date(
						orgCntrPeriodStrtDate));
				orgProposalBO.setContrEndPeriod(new Date(orgCntrPeriodEndDate));
				OPPTLogger.debug("Original contract period start date 3: "
						+ orgProposalBO.getContrStartPeriod(), CLASS_NAME,
						methodName);
				proposalBO.setContrStartDate(cntrPeriodStrtDate);
			}
			/* end change CR6153 */
			helper.validateAndPopulate(renewContractCustomDTO, proposalBO,
					orgProposalBO);

			/* start change CR6153 */
			if ((proposalBO.getExtendPeriod() != null)
					&& (proposalBO.getExtendPeriod()
							.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {
				proposalBO.setContrStartDate(proposalBO.getContrStartPeriod());
			}
			/* end change CR6153 */

			String userID = renewContractCustomDTO.getUserId();

			proposalBO.setOldContrNo(orgProposalBO.getContrNo());
			proposalBO.setCreatedBy(userID);
			proposalBO
					.setStatusCode(ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS);
			proposalBO.setContrType(ContractTypeConstants.RENEWAL);
			proposalBO.setLastUpdatedDate(new Date(System.currentTimeMillis()));
			validateContractForReplacementRenewal(orgProposalBO);
			//UD Change
			proposalBO.setGroupName(orgProposalBO.getGroupName());

			orgProposalBO
					.setStatusCode(ProposalContractStatusConstants.RENEWAL_IN_PROGRESS);
			orgProposalBO.setLastUpdatedDate(new Date(System
					.currentTimeMillis()));

			try {
				ProposalContractBO maxProposalContractBO = factory
						.findMaxProposalContractBO();

				proposalBO
						.setProposalId(maxProposalContractBO.getProposalId() + 1);
				
				String proposalName = renewContractCustomDTO.getNewProposalName();
				// system.out.println("Renew proposalName" +proposalName);
				// system.out.println("Renew proposalName" +orgProposalBO.getAutoPopulate());
//				Blue Harmony Wave 1 DAD001 - Start - Anand	
				int renewCount = (int) orgProposalBO.getContrRenewNo();
				String proposalContent1 = orgProposalBO.getProposalContent().equalsIgnoreCase("M")? "MLC" :"SandS"; 
			if ((proposalName== null ||proposalName.trim().equalsIgnoreCase(""))&&orgProposalBO.getAutoPopulate().equalsIgnoreCase(UtilityConstants.NO) ){
					
				// system.out.println("inside if condition");
				int customerNamelength = orgProposalBO.getRegCustomerName().length();
				String customerName =null;
				if (customerNamelength>=20){
				
				 customerName = orgProposalBO.getRegCustomerName().substring(0,20).trim();
				}
				else{
					customerName = orgProposalBO.getRegCustomerName().trim();	
				}
				String salesOrg =  orgProposalBO.getSalesOrg();
				
				String proposalContent =orgProposalBO.getProposalContent();
				
				// system.out.println("inside if condition" +customerName);
				// system.out.println("inside if condition" +salesOrg);
				// system.out.println("inside if condition" +proposalContent1);
				ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
				proposalBO.setSelectedCustomerName(customerName);	
				proposalBO.setSalesOrg(salesOrg);
				proposalBO.setProposalContent(proposalContent);
				
				
				int proposalCount;
				try{
					
				proposalCount = proposalContractBOFactory.getMaxProposalCount(proposalBO);
				// system.out.println("proposal Count   " +proposalCount );
				
				proposalBO.setProposalCount(proposalCount);
				// system.out.println("proposal Count   " +proposalBO.getProposalCount());
				
				
				
				String newProposalName =	salesOrg+"_"+customerName+"_"+proposalContent1+"_"+proposalCount+"_RNW"+"_"+renewCount;
				proposalBO.setProposalName(newProposalName);
				proposalBO.setAutoPopulate(UtilityConstants.YES);
			
				// system.out.println("inside if condition" +renewCount);
				// system.out.println("inside if condition" +proposalCount);
				// system.out.println("inside if condition" +newProposalName);
				
				} catch (DomainException  ex){}
				}
			
			else if ((proposalName== null ||proposalName.trim().equalsIgnoreCase(""))&&orgProposalBO.getAutoPopulate().equalsIgnoreCase(UtilityConstants.YES) ){
				// system.out.println("Inside elseif  " );
				//0147_ABC_MLC_1_RNW_2_RPL_1 or 0147_ABC_MLC_1_RPL_1  0147_ABC_MLC_1_RNW_2
				
			int renewindex = 	orgProposalBO.getProposalName().lastIndexOf("_RNW_");
			int replaceindex = orgProposalBO.getProposalName().lastIndexOf("_RPL_");
			String newProposalName =null;
			if (renewindex== -1 && replaceindex == -1  ){
			
				newProposalName = orgProposalBO.getProposalName()+"_RNW_"+renewCount;
				proposalBO.setProposalName(newProposalName);
				proposalBO.setAutoPopulate(UtilityConstants.YES);
			
			}
			else if(replaceindex!= -1 && renewindex== -1){
				//0147_ABC_MLC_1_RNW_1
			String  oldProposalName = orgProposalBO.getProposalName().substring(0,orgProposalBO.getProposalName().lastIndexOf("_RPL_"));
			// system.out.println("orgProposalBO.getProposalName()  " +orgProposalBO.getProposalName());
			// system.out.println("oldProposalName    "   +oldProposalName);
			 newProposalName = oldProposalName+"_RNW_"+renewCount;
			proposalBO.setProposalName(newProposalName);
			proposalBO.setAutoPopulate(UtilityConstants.YES);
			}
			
			else{
				String  oldProposalName = orgProposalBO.getProposalName().substring(0,orgProposalBO.getProposalName().lastIndexOf("_RNW_"));
				// system.out.println("orgProposalBO.getProposalName()  " +orgProposalBO.getProposalName());
				// system.out.println("oldProposalName    "   +oldProposalName);
				 newProposalName = oldProposalName+"_RNW_"+renewCount;
				proposalBO.setProposalName(newProposalName);
				proposalBO.setAutoPopulate(UtilityConstants.YES);
				
			
			
			}
			
			
			
			}
				
				else {
					proposalBO.setProposalName(renewContractCustomDTO.getNewProposalName());
					proposalBO.setAutoPopulate(UtilityConstants.NO);
				}
//			Blue Harmony Wave 1 DAD001 - End - Anand
				updateProposalFieldsForCopy(proposalBO);

				proposalBO.setPoDate(null);
				proposalBO.setPoNo(null);

				proposalBO.setExtContrNo(null);
				//proposalBO.setContrAmendNo(0);
				//proposalBO.setContrRenewNo(0);

				boolean userInGroup = isUserInGroup(userID);
				if (userInGroup) {
					proposalBO.setLockedBy(userID);
					proposalBO
							.setLockedOn(new Date(System.currentTimeMillis()));
				}
				if (proposalBO.getBillingFreqCode().equals(
						UtilityConstants.BILLING_FREQ_QUARTERLY)) {
					String cntrStartPeriod = proposalBO.getContrStartPeriod()
							.toString();
					String cntrStartPeriodMonth = cntrStartPeriod.substring(5,
							7);
					if (cntrStartPeriodMonth.equals("01")
							|| cntrStartPeriodMonth.equals("04")
							|| cntrStartPeriodMonth.equals("07")
							|| cntrStartPeriodMonth.equals("10")) {
						proposalBO.setBillingType("YE");
					} else {
						proposalBO.setBillingType("9Q");
					}
				}
				//	To set the created date properly
				proposalBO.setCreatedDate(new Date(System.currentTimeMillis()));

				/* CR6153 start change */
				if ((proposalBO.getExtendPeriod() != null)
						&& (proposalBO.getExtendPeriod()
								.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {
					//proposalBO.setContrStartDate(proposalBO.getContrStartPeriod());

					//If replacement date is in the first contract period, copy
					// the anniversary amounts as it is.
					//If the replacement date is in the second contract period,
					// copy the anniv amount of year 2 of original contract to
					// anniv amount of year 1 of replaced contract and so on.

					double[] sAndSAnnvAmountOrg = new double[5];
					sAndSAnnvAmountOrg[0] = orgProposalBO
							.getSAndsAnniversaryAmount();
					sAndSAnnvAmountOrg[1] = orgProposalBO
							.getSAndsAnniversaryAmt2();
					sAndSAnnvAmountOrg[2] = orgProposalBO
							.getSAndsAnniversaryAmt3();
					sAndSAnnvAmountOrg[3] = orgProposalBO
							.getSAndsAnniversaryAmt4();
					sAndSAnnvAmountOrg[4] = orgProposalBO
							.getSAndsAnniversaryAmt5();
					OPPTCalender calendar = new OPPTCalender();

					double[] sAndSAnnvAmountNew = new double[5];
					int contractDurationMonths = OPPTCalender
							.calculateContractPeriodDuration(orgProposalBO
									.getContrStartDate(), orgProposalBO
									.getContrEndDate());
					int contractDurationYears = contractDurationMonths / 12;

					java.sql.Date tempStartDate = orgProposalBO
							.getContrStartPeriod();
					java.sql.Date tempEndDate = orgProposalBO
							.getContrEndPeriod();

					for (int i = 0; i < contractDurationYears; i++) {
						if (((proposalBO.getContrStartPeriod().after(
								tempStartDate) || calendar
								.isDateEqual(proposalBO.getContrStartPeriod(),
										tempStartDate)) && (proposalBO
								.getContrStartPeriod().before(tempEndDate)))) {
							for (int j = i; j < contractDurationYears; j++) {
								sAndSAnnvAmountNew[j - i] = sAndSAnnvAmountOrg[j];
							}
							break;
						}
						java.util.Date endPeriod = OPPTCalender.addDate(
								OPPTCalender.YEAR, 1, tempEndDate);
						java.util.Date startPeriod = OPPTCalender.addDate(
								OPPTCalender.YEAR, 1, tempStartDate);
						java.sql.Date endPeriod1 = new java.sql.Date(endPeriod
								.getTime());
						java.sql.Date startPeriod1 = new java.sql.Date(
								startPeriod.getTime());

						tempStartDate = startPeriod1;
						tempEndDate = endPeriod1;
					}

					proposalBO.setSAndsAnniversaryAmount(sAndSAnnvAmountNew[0]);
					proposalBO.setSAndsAnniversaryAmt2(sAndSAnnvAmountNew[1]);
					proposalBO.setSAndsAnniversaryAmt3(sAndSAnnvAmountNew[2]);
					proposalBO.setSAndsAnniversaryAmt4(sAndSAnnvAmountNew[3]);
					proposalBO.setSAndsAnniversaryAmt5(sAndSAnnvAmountNew[4]);
				}

				/* CR6153 end change */

				factory.createProposalContractBO(proposalBO);
				/* EF0722042442S */
				CopyInventoryDomainDTO copyInventoryDomainDTO = new CopyInventoryDomainDTO();
				copyInventoryDomainDTO.setOldProposalID(orgProposalBO
						.getProposalId());
				copyInventoryDomainDTO.setNewProposalID(proposalBO
						.getProposalId());
				copyInventoryDomainDTO
						.setActionName(ActionNameConstants.RENEW_CONTRACT);
				HashMap values = new HashMap();
				values.put(UtilityConstants.PLAN_START_DATE, proposalBO
						.getContrStartPeriod());
				values.put(UtilityConstants.PLAN_END_DATE, proposalBO
						.getContrEndPeriod());
				copyInventoryDomainDTO.setValues(values);
				copyCustomerList(copyInventoryDomainDTO);

				getInventoryManagerLocal()
						.copyInventory(copyInventoryDomainDTO);
				/* EF0722042442E */
				factory.updateProposalContractBO(orgProposalBO);

				createAccessHistory(proposalBO.getProposalId(), proposalBO
						.getCreatedBy(), operationPerformed);

				contractDTO.setId(proposalBO.getProposalId());
				contractDTO.setName(proposalBO.getProposalName());
				contractDTO.setLockedBy(proposalBO.getLockedBy());
				contractDTO.setOldContractNumber(proposalBO.getOldContrNo());
				contractDTO.setStatus(proposalBO.getStatusCode());
				contractDTO.setType(proposalBO.getProposalType());
			} catch (DomainException e) {
				OPPTLogger
						.debug("Rollback is called: ", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();

				ExceptionGenerator.generateServiceException(e.getErrorReport());
			} catch (Exception e) {
				OPPTLogger
						.debug("Rollback is called: ", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();

				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						methodName, null, e);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}

			return renewContractCustomDTO;
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To copy the EAS II proposal
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 24, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param easIICopyCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public EASIICopyCustomDTO easIICopy(EASIICopyCustomDTO easIICopyCustomDTO)
			throws ServiceException {
		String methodName = "easIICopy";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {
			ContractCustomDTO contractDTO = easIICopyCustomDTO.getContractDTO();

			// if fails... it will throw the service exception
			contractDTO = canEASIICopyPerformed(contractDTO);

			String newProposalName = easIICopyCustomDTO.getNewProposalName();
			ProposalContractBOFactory factory = new ProposalContractBOFactory();
			if(newProposalName!= null){
			
			if (factory.isProposalNameExists(newProposalName)) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0018);
			}
			}
			ProposalContractBO proposalContractBO = null;
			ProposalContractBO orgProposalContractBO = null;
			try {
				//proposalContractBO =
				// factory.getProposalContractBO(contractDTO.getId());
				orgProposalContractBO = factory
						.getProposalContractBO(contractDTO.getId());
				proposalContractBO = PCMBOBuilder
						.createBOForEASIICopy(orgProposalContractBO);
			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de
						.getErrorReport());
			}

			proposalContractBO.setProposalType(ProposalTypeConstants.EASII);
			proposalContractBO
					.setOldContrNo(orgProposalContractBO.getContrNo());

			String userID = easIICopyCustomDTO.getUserId();

			try {
				ProposalContractBO maxBO = factory.findMaxProposalContractBO();
				proposalContractBO.setProposalId(maxBO.getProposalId() + 1);
//				Blue Harmony Wave 1 DAD001 - Start - Anand
				
				if (newProposalName ==null || newProposalName.trim().equalsIgnoreCase("")){
				String proposalContent = orgProposalContractBO.getProposalContent().equalsIgnoreCase("M")? "MLC" :"SandS";
				int customerNamelength = orgProposalContractBO.getRegCustomerName().length();
				String customerName =null;
				if (customerNamelength>=20){
				
				 customerName = orgProposalContractBO.getRegCustomerName().substring(0,20).trim();
				}
				else{
					customerName = orgProposalContractBO.getRegCustomerName().trim();	
				}
				
				
				orgProposalContractBO.setSelectedCustomerName(customerName);	
			//	String copyNewProposalName = proposalContractBO.getSalesOrg()+"_"+proposalContractBO.getRegCustomerName()+"_"+proposalContent;
				int proposalCount;
				
				try{
									
					
				proposalCount = factory.getMaxProposalCount(orgProposalContractBO);
				
				// system.out.println("proposal Count ==============  " +proposalCount );
				
				proposalContractBO.setProposalCount(proposalCount);
				 newProposalName = orgProposalContractBO.getSalesOrg()+"_"+orgProposalContractBO.getSelectedCustomerName().trim()+"_"+proposalContent+"_"+proposalCount;
				 proposalContractBO.setProposalName(newProposalName);
				 proposalContractBO.setAutoPopulate(UtilityConstants.YES);		
				 
				
				// system.out.println("proposal Count   " +newProposalName);
				} catch (DomainException  ex){}
				
				
				
				}
				else{
				
				proposalContractBO.setProposalName(easIICopyCustomDTO
						.getNewProposalName());
				proposalContractBO.setAutoPopulate(UtilityConstants.NO);
				
				
				}
//				Blue Harmony Wave 1 DAD001 - End - Anand
			//	proposalContractBO.setProposalName(newProposalName);
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT);
				proposalContractBO.setCreatedBy(userID);
				proposalContractBO.setCreatedDate(OPPTCalender
						.convertToSQLDate(new java.util.Date()));

				StringBuffer contrNo = new StringBuffer();
				contrNo.append(factory
						.getProposalContractBOWithMaxContractNumber("P")
						.getContrNo());
				contrNo.append("01");

				orgProposalContractBO.setTpContrNo(contrNo.toString());
				proposalContractBO.setContrNo(contrNo.toString());
				proposalContractBO.setContrType(ContractTypeConstants.ORIGINAL);

				updateProposalFieldsForCopy(proposalContractBO);

				boolean userInGroup = isUserInGroup(userID);
				if (userInGroup) {
					proposalContractBO.setLockedBy(userID);
					proposalContractBO.setLockedOn(new Date(System
							.currentTimeMillis()));
				}
				//UD Changes
				proposalContractBO.setGroupName(orgProposalContractBO
						.getGroupName());

				factory.createProposalContractBO(proposalContractBO);

				CopyInventoryDomainDTO copyInventoryDomainDTO = new CopyInventoryDomainDTO();
				copyInventoryDomainDTO
						.setActionName(ActionNameConstants.COPY_PROPOSAL);
				copyInventoryDomainDTO.setOldProposalID(orgProposalContractBO
						.getProposalId());

				copyInventoryDomainDTO.setNewProposalID(proposalContractBO
						.getProposalId());

				copyCustomerList(copyInventoryDomainDTO);
				getInventoryManagerLocal()
						.copyInventory(copyInventoryDomainDTO);

				factory.updateProposalContractBO(orgProposalContractBO);

				createAccessHistory(proposalContractBO.getProposalId(), userID,
						"EAS II Copy performed");

				contractDTO.setId(proposalContractBO.getProposalId());
				contractDTO.setName(proposalContractBO.getProposalName());
				contractDTO.setType(proposalContractBO.getProposalType());
				contractDTO.setStatus(proposalContractBO.getStatusCode());
			} catch (DomainException e) {
				OPPTLogger
						.debug("Rollback is called: ", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();

				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			} catch (Exception e) {
				OPPTLogger
						.debug("Rollback is called: ", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();

				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						methodName, null, e);

				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}

			return easIICopyCustomDTO;
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	private void updateProposalFieldsForCopy(
			ProposalContractBO proposalContractBO) {
		updateProposalFieldsForCopy(proposalContractBO, false);
	}

	private void updateProposalFieldsForCopy(
			ProposalContractBO proposalContractBO, boolean isCopyProposal) {
		proposalContractBO.setProposalSharing(null);
		proposalContractBO.setSubmittedBy(null);
		proposalContractBO.setApprovedBy(null);

		if (isCopyProposal == false) {
			proposalContractBO.setGrowthFactor(0);
			proposalContractBO.setSpecialRate(0);
		}

		proposalContractBO.setInvoiceAmount(0);
		proposalContractBO.setAmendInd(null);
		proposalContractBO.setAmendEffectiveDate(null);
		proposalContractBO.setDatePriced(null);
		proposalContractBO.setApprovedDate(null);
		proposalContractBO.setContrExtDate(null);
		proposalContractBO.setContrRetrDate(null);
		proposalContractBO.setContrReplDate(null);
		proposalContractBO.setContrClsDate(null);
		proposalContractBO.setFreeText(null);
		proposalContractBO.setPreTVM(0);
		proposalContractBO.setTpContrNo(null);
		proposalContractBO.setIneligibleInd(null);
		proposalContractBO.setInvoiceInd(null);
		proposalContractBO.setLockedBy(null);
		proposalContractBO.setLockedOn(null);
	}

	/**
	 *
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Feb 4, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param userID
	 * @return
	 */
	private boolean isUserInGroup(String userID) throws DomainException {
		UserProfileBOFactory userBOFactory = new UserProfileBOFactory();
		UserProfileBO userBO = userBOFactory.getUserProfileBO(userID);
		return (userBO != null && userBO.getGroupName() != null && userBO
				.getGroupName().trim().length() > 0);
	}

	/**
	 * To check whether the EAS II copy is allowed or not
	 *
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 28, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param contractDTO
	 * @return
	 * @throws ServiceException
	 */
	public ContractCustomDTO canEASIICopyPerformed(ContractCustomDTO contractDTO)
			throws ServiceException {
		String methodName = "canEASIICopyPerformed";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {
			String proposalType = contractDTO.getType();
			if (ProposalTypeConstants.EAS.equals(proposalType) == false) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0335);
			}

			ProposalContractBOFactory factory = new ProposalContractBOFactory();
			ProposalContractBO proposalContractBO = null;
			try {
				proposalContractBO = factory.getProposalContractBO(contractDTO
						.getId());
			} catch (DomainException ex) {
				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}
			checkUserAndAuthority(proposalContractBO, contractDTO);

			if (ProposalContractStatusConstants.CONTRACT.equals(contractDTO
					.getStatus()) == false) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0311);
			}

			checkForEASIIExistence(proposalContractBO.getTpContrNo());

			return contractDTO;
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	private void checkForEASIIExistence(String tpContrNo)
			throws ServiceException {
		String methodName = "checkForEASIIExistence";

		tpContrNo = OPPTHelper.trimString(tpContrNo);

		if (tpContrNo != null && tpContrNo.length() > 0) {
			try {
				ProposalContractBO bo = null;

				try {
					ProposalContractBOFactory factory = new ProposalContractBOFactory();

					bo = factory.getProposalContractBOForContractNumber(
							tpContrNo, true);
				} catch (DomainException e) {
					boolean rethrow = true;

					if (isExceptionFound(e, ErrorCodeConstants.DE0636)) {
						rethrow = false;
					}

					if (rethrow) {
						throw e;
					}
				}

				if (bo != null) {
					if (bo.getExtContrNo() != null) {
						ServiceException ex = new ServiceException();
						ErrorEntry entry = new ErrorEntry(new String[] { bo
								.getExtContrNo() });
						ErrorReport report = ex.getErrorReport();
						report.addErrorEntry(new ErrorKey(
								ErrorCodeConstants.SE0325,
								OPPTMessageCatalog.TYPE_SERVICE), entry);

						throw ex;
					} else if (bo.getProposalName() != null) {
						ServiceException ex = new ServiceException();
						ErrorEntry entry = new ErrorEntry(new String[] { bo
								.getProposalName() });
						ErrorReport report = ex.getErrorReport();
						report.addErrorEntry(new ErrorKey(
								ErrorCodeConstants.SE0326,
								OPPTMessageCatalog.TYPE_SERVICE), entry);

						throw ex;
					}
				}
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}

		}
	}

	private boolean isExceptionFound(OPPTException e, String errorCode) {
		ErrorReport report = e.getErrorReport();
		boolean found = false;

		if (report != null && (report.isEmpty() == false)) {
			Iterator iter = report.keySet().iterator();

			while (iter.hasNext()) {
				ErrorKey key = (ErrorKey) iter.next();
				if (errorCode.equals(key.getErrorId())) {
					found = true;
					break;
				}
			}
		}

		return found;
	}

	/**
	 * To get the amend contract details
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 24, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param amendContractCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public AmendContractCustomDTO amendContract(
			AmendContractCustomDTO amendContractCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "amendContract");

		try {
			ContractCustomDTO customDTO = amendContractCustomDTO.getContract();
			ProposalContractBOFactory factory = new ProposalContractBOFactory();
			ProposalContractBO bo = null;
			try {
				bo = factory.getProposalContractBO(customDTO.getId());
			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de
						.getErrorReport());
			}

			checkUserAndAuthority(bo, amendContractCustomDTO);
			String proposalType = bo.getProposalType();

			if (ProposalTypeConstants.EASII.equals(proposalType)) {
				throwServiceException(ErrorCodeConstants.SE0309,
						OPPTMessageCatalog.TYPE_SERVICE);
			}
			String contractStatus = OPPTHelper.trimString(bo.getStatusCode());

			boolean isChangeProposal = (amendContractCustomDTO
					.getDisplayOption() == AmendContractCustomDTO.CHANGE_PROPOSAL);

			boolean canProceed = ProposalContractStatusConstants.CONTRACT
					.equals(contractStatus)
					|| ProposalContractStatusConstants.EXTENDED
							.equals(contractStatus)
					|| ProposalContractStatusConstants.VARIANCE_BILLED
							.equals(contractStatus);
			if (isChangeProposal) {
				canProceed = (ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
						.equals(contractStatus) || ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
						.equals(contractStatus));
				amendContractCustomDTO.setAmendmentEffectiveDate(bo
						.getAmendEffectiveDate());
			} else {
				if (ProposalTypeConstants.EAS.equals(proposalType)) {
					checkForEASIIExistence(OPPTHelper.trimString(bo
							.getTpContrNo()));
				}
			}

			if (canProceed) {
				customDTO.setContractNumber(bo.getContrNo());
				customDTO.setId(bo.getProposalId());
				customDTO.setLockedBy(bo.getLockedBy());
				customDTO.setName(bo.getProposalName());
				customDTO.setOldContractNumber(bo.getOldContrNo());
				customDTO.setPrimarySalesOrg(bo.getSalesOrg());
				customDTO.setStatus(bo.getStatusCode());
				customDTO.setType(bo.getProposalType());

				BasicProposalCustomDTO basicProposalCustomDTO = amendContractCustomDTO
						.getBasicProposalCustomDTO();
				if (basicProposalCustomDTO == null) {
					basicProposalCustomDTO = new BasicProposalCustomDTO();
					amendContractCustomDTO
							.setBasicProposalCustomDTO(basicProposalCustomDTO);
				}
				basicProposalCustomDTO.setContractEndDate(bo.getContrEndDate());
				basicProposalCustomDTO.setContractPeriodBeginning(bo
						.getContrStartPeriod());
				basicProposalCustomDTO.setContractPeriodEnding(bo
						.getContrEndPeriod());
				basicProposalCustomDTO.setContractStartDate(bo
						.getContrStartDate());
				basicProposalCustomDTO.setCurrencyCode(bo.getCurrency());
				basicProposalCustomDTO.setDistributionChannel(bo
						.getDistrChannel());
				basicProposalCustomDTO.setSalesGroup(bo.getSalesGroup());
				basicProposalCustomDTO.setChannelRole(bo.getChannelRole());
				basicProposalCustomDTO.setSubmitterRole(bo.getSubmitterRole());
				basicProposalCustomDTO.setDivision(bo.getDivisionCode());
				basicProposalCustomDTO.setExternalContractNumber(bo
						.getExtContrNo());
				basicProposalCustomDTO.setProposalName(bo.getProposalName());
				basicProposalCustomDTO.setProposalType(bo.getProposalType());
				basicProposalCustomDTO.setSalesOrganization(bo.getSalesOrg());
				// changes for s and s starts
				/* start change CR6153 */
				basicProposalCustomDTO.setISandsExtendPeriod(bo
						.getExtendPeriod());
				/* end change CR6153 */
				basicProposalCustomDTO.setProposalContent(bo
						.getProposalContent());
				if (bo.isSAndSProposal()) {
					basicProposalCustomDTO.setShowProposalContent(true);
					basicProposalCustomDTO.setProposalContentEditable(false);
				}
				// changes for s and s ends
				// BH Wave 1 - DAD003 - Bhanu - Begin
				basicProposalCustomDTO.setCpsID(bo.getCpsId());
				//basicProposalCustomDTO.setComplexContractAmendment(bo.getComplexContractAmendment());
				basicProposalCustomDTO.setOcpsID(bo.getOcpsId());
				//basicProposalCustomDTO.setMasterContractID(bo.getMasterContractId());
				//basicProposalCustomDTO.setMasterContractAmendment(bo.getMasterContractAmendment());
				basicProposalCustomDTO.setContractType(bo.getContractType());
				basicProposalCustomDTO.setBlbIndicator(bo.getBlbIndicator());
				//System.out.println("ProposalManagerBean.amendContract():prebill:"+bo.getPrebillIndicator());
				basicProposalCustomDTO.setIsPreBillIndicator(bo.getPrebillIndicator());
				basicProposalCustomDTO.setCciInd(bo.getCciInd());

				// BH Wave 1 - DAD003 - Bhanu - End
				PricingInformationCustomDTO pricingInformationCustomDTO = amendContractCustomDTO
						.getPricingInformationCustomDTO();

				if (pricingInformationCustomDTO == null) {
					pricingInformationCustomDTO = new PricingInformationCustomDTO();
					amendContractCustomDTO
							.setPricingInformationCustomDTO(pricingInformationCustomDTO);
				}
				// BH Wave 1 - DAD003 - Bhanu - Begin
			/*	if((bo.getPrebillIndicator() != null) && (bo.getPrebillIndicator().equals(UtilityConstants.YES))){
					pricingInformationCustomDTO.setPrebillIndicator(true);
			    }else{
			    	pricingInformationCustomDTO.setPrebillIndicator(false);
				}*/
			
				pricingInformationCustomDTO.setPrebillIndicator(bo.getPrebillIndicator());
				// BH Wave 1 - DAD003 - Bhanu - End

				pricingInformationCustomDTO.setAnniversaryContractAmount(bo
						.getAnnvAmount());
				pricingInformationCustomDTO.setBillingBlock(bo
						.getBillingBlock());
				pricingInformationCustomDTO.setBillingFrequency(bo
						.getBillingFreqCode());
				pricingInformationCustomDTO.setPlannedGrowthValue(bo
						.getSpecialRate());
				pricingInformationCustomDTO.setGrowthLimitValue(bo
						.getGrowthFactor());
				pricingInformationCustomDTO.setPakid(bo.getPakId());
				pricingInformationCustomDTO
						.setPrimarySalesOrg(bo.getSalesOrg());
				pricingInformationCustomDTO.setTvmRate(bo.getTvmRate());
				//System.out.println("ProposalManagerBean.amendContract():DISCOUNT"+bo.getDiscount());
				pricingInformationCustomDTO.setDiscount(bo.getDiscount());
				pricingInformationCustomDTO.setFreeTextForInvoicePrint(bo
						.getFreeText());
				pricingInformationCustomDTO.setBillingBlock(bo
						.getBillingBlock());
				pricingInformationCustomDTO.setBillingDateRule(bo
						.getBillingType());
				pricingInformationCustomDTO.setDeviatingDateRule(bo
						.getDeviatingDateRule());
				//	changes for s and s starts
				pricingInformationCustomDTO
						.setSAndSAnniversaryContractAmount(bo
								.getSAndsAnniversaryAmount());
				//	changes for s and s ends

				/* CR6153 start change */
				if ((bo.getExtendPeriod() != null)
						&& (bo.getExtendPeriod()
								.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {
					pricingInformationCustomDTO.setExtendPeriod(true);
				} else {
					pricingInformationCustomDTO.setExtendPeriod(false);
				}
				pricingInformationCustomDTO
						.setSAndSAnniversaryContractAmountPeriod2(bo
								.getSAndsAnniversaryAmt2());
				pricingInformationCustomDTO
						.setSAndSAnniversaryContractAmountPeriod3(bo
								.getSAndsAnniversaryAmt3());
				pricingInformationCustomDTO
						.setSAndSAnniversaryContractAmountPeriod4(bo
								.getSAndsAnniversaryAmt4());
				pricingInformationCustomDTO
						.setSAndSAnniversaryContractAmountPeriod5(bo
								.getSAndsAnniversaryAmt5());
				/* CR6153 end change */

				// This was added on purpose pls do not remove
				if (UtilityConstants.ADVANCED_BILLING_SELECTED.equals(bo
						.getAdvanceBilling())) {
					pricingInformationCustomDTO.setAdvance(false);
				} else {
					pricingInformationCustomDTO.setAdvance(true);
				}

				pricingInformationCustomDTO
						.setDetailedInvoice(UtilityConstants.DETAILED_INVOICE_SELECTED
								.equals(bo.getInvoiceInd()));
				pricingInformationCustomDTO
						.setGsa(UtilityConstants.GSA_SELECTED.equals(bo
								.getGsaInd()));

				SecondaryProposalCustomDTO secondaryProposalCustomDTO = amendContractCustomDTO
						.getSecondaryProposalCustomDTO();
				if (secondaryProposalCustomDTO == null) {
					secondaryProposalCustomDTO = new SecondaryProposalCustomDTO();
					amendContractCustomDTO
							.setSecondaryProposalCustomDTO(secondaryProposalCustomDTO);
				}
				secondaryProposalCustomDTO
						.setAddValueDays(bo.getAddValueDays());
				secondaryProposalCustomDTO.setComments(bo.getComments());
				secondaryProposalCustomDTO.setFixedValDate(bo
						.getFixedValueDate());
				secondaryProposalCustomDTO
						.setPaymentTerms(bo.getPayementTerm());
				secondaryProposalCustomDTO.setPrimarySalesOrg(bo.getSalesOrg());
				secondaryProposalCustomDTO.setPurchaseOrderDate(bo.getPoDate());
				secondaryProposalCustomDTO.setPurchaseOrderNumber(bo.getPoNo());

				secondaryProposalCustomDTO
						.setSandsExcluded(UtilityConstants.YES.equals(bo
								.getSandSExcluded()));

				VarianceInformationCustomDTO varianceInformationCustomDTO = amendContractCustomDTO
						.getVarianceInformationCustomDTO();
				if (varianceInformationCustomDTO == null) {
					varianceInformationCustomDTO = new VarianceInformationCustomDTO();
					amendContractCustomDTO
							.setVarianceInformationCustomDTO(varianceInformationCustomDTO);
				}
				varianceInformationCustomDTO.setCapAmount(bo.getCapAmount());
				varianceInformationCustomDTO.setCapMinus(bo.getCapMinus());
				varianceInformationCustomDTO.setCapPlus(bo.getCapPlus());
			} else {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0337);
			}
			return amendContractCustomDTO;
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To process the amend contract
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 24, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param amendContractCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public AmendContractCustomDTO processAmendContract(
			AmendContractCustomDTO amendContractCustomDTO)
			throws ServiceException {
		String methodName = "processAmendContract";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {
			ProposalContractBOFactory factory = new ProposalContractBOFactory();
			ProposalContractBO newProposalContractBO = null;

			BasicProposalCustomDTO proposalDTO = amendContractCustomDTO
					.getBasicProposalCustomDTO();
			String proposalType = proposalDTO.getProposalType();

			java.util.Date amendmentEffectiveDate = amendContractCustomDTO
					.getAmendmentEffectiveDate();
			java.util.Date contractPeriodStartDate = proposalDTO
					.getContractPeriodBeginning();
			java.util.Date contractPeriodEndDate = proposalDTO
					.getContractPeriodEnding();

			boolean isChangeProposal = (amendContractCustomDTO
					.getDisplayOption() == AmendContractCustomDTO.CHANGE_PROPOSAL);

			OPPTLogger.debug("Amendment effective date: "
					+ amendmentEffectiveDate, CLASS_NAME, methodName);

			OPPTCalender calendar = new OPPTCalender();

			boolean isAmendmentGreaterOrEqual = false;

			if (isChangeProposal) {
				newProposalContractBO = factory
						.getProposalContractBO(amendContractCustomDTO
								.getContract().getId());
				if (ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
						.equals(newProposalContractBO.getStatusCode())) {
					newProposalContractBO
							.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				}
				if (newProposalContractBO.getAmendEffectiveDate() != null) {
					isAmendmentGreaterOrEqual = (calendar.isDateGreater(
							amendmentEffectiveDate, newProposalContractBO
									.getAmendEffectiveDate()) || calendar
							.isDateEqual(amendmentEffectiveDate,
									newProposalContractBO
											.getAmendEffectiveDate()));

					if (isAmendmentGreaterOrEqual == false) {
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0313);
					}
				}
			}

			boolean isAmendmentGreater = calendar.isDateGreater(
					amendmentEffectiveDate, contractPeriodStartDate);
			if (isAmendmentGreater == false) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0316);
			}

			boolean isProposalTypeTP = ProposalTypeConstants.TP
					.equals(proposalType);

			boolean isLastOrFirstDay = OPPTCalender
					.isFirstDayOfTheMonth(amendmentEffectiveDate);

			if ((isProposalTypeTP || isLastOrFirstDay) == false) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0315);
			}
			ProposalContractBO originalProposalContractBO = null;
			try {
				originalProposalContractBO = factory
						.getProposalContractBO(amendContractCustomDTO
								.getContract().getId());

				if (isChangeProposal == false) {
					newProposalContractBO = factory
							.getProposalContractBO(amendContractCustomDTO
									.getContract().getId());
				}
			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de
						.getErrorReport());
			}

			String billingFrequency = newProposalContractBO
					.getBillingFreqCode().trim();

			int monthReduceBy = 0;
			if ("A".equalsIgnoreCase(billingFrequency)) {
				monthReduceBy = 12;
			} else if ("S".equalsIgnoreCase(billingFrequency)) {
				monthReduceBy = 6;
			} else if ("Q".equalsIgnoreCase(billingFrequency)) {
				monthReduceBy = 3;
			} else if ("M".equalsIgnoreCase(billingFrequency)) {
				monthReduceBy = 1;
			}

			calendar.setTime(OPPTCalender.addDate(Calendar.MONTH, monthReduceBy
					* -1, contractPeriodEndDate));

			if (isProposalTypeTP == false) {
				calendar.set(Calendar.DAY_OF_MONTH, calendar
						.getActualMaximum(Calendar.DAY_OF_MONTH));
			}

			java.util.Date lastBillingDate = calendar.getTime();
			boolean isAmendmentLessOrEqualToBillingDate = calendar
					.isDateLesser(amendmentEffectiveDate, lastBillingDate)
					|| calendar.isDateEqual(amendmentEffectiveDate,
							lastBillingDate);

			/* CR6153 start change */
			if (!((newProposalContractBO.getExtendPeriod() != null) && (newProposalContractBO
					.getExtendPeriod()
					.equals(UtilityConstants.S_S_EXTEND_PERIOD)))) {
				/* CR6153 end change */
				if (isAmendmentLessOrEqualToBillingDate == false) {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0020);
				}
			}
			/* start change CR6153 */
			else {

				java.util.Date date = new java.util.Date();
				java.util.Date tempCntrPeriodStrtDate = originalProposalContractBO
						.getContrStartPeriod();
				java.util.Date tempCntrPeriodEndDate = originalProposalContractBO
						.getContrEndPeriod();
				OPPTCalender startDateCalender = new OPPTCalender();
				OPPTCalender endDateCalender = new OPPTCalender();

				while (tempCntrPeriodEndDate.getTime() < date.getTime()
						&& tempCntrPeriodEndDate.getTime() < originalProposalContractBO
								.getContrEndDate().getTime()) {
					startDateCalender.setTime(OPPTCalender.addDate(
							OPPTCalender.YEAR, 1, tempCntrPeriodStrtDate));
					endDateCalender.setTime(OPPTCalender.addDate(
							OPPTCalender.YEAR, 1, tempCntrPeriodEndDate));
					if (endDateCalender.getYear() % 4 == 0
							&& (endDateCalender.getYear() % 100 != 0 || endDateCalender
									.getYear() % 400 == 0)) {
						if (startDateCalender.getMonth() == 3
								&& startDateCalender.getDay() == 1
								&& (originalProposalContractBO
										.getContrEndDate().getTime() > tempCntrPeriodEndDate
										.getTime())) {
							endDateCalender.set(endDateCalender.getYear(),
									endDateCalender.getMonth() - 1,
									endDateCalender.getDay() + 1);
							// since month is 0 based in the set method, and
							// starts from 1 in the get method, we subtract 1
						}
					}
					tempCntrPeriodStrtDate.setTime(startDateCalender
							.getTimeInMillis());
					tempCntrPeriodEndDate.setTime(endDateCalender
							.getTimeInMillis());
				}
				boolean isAmendDateInCurrentContractPeriod = (calendar
						.isDateLesser(amendmentEffectiveDate,
								tempCntrPeriodEndDate))
						&& (calendar.isDateGreater(amendmentEffectiveDate,
								tempCntrPeriodStrtDate) || calendar
								.isDateEqual(amendmentEffectiveDate,
										tempCntrPeriodStrtDate));
				if (isAmendDateInCurrentContractPeriod == false) {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0021);
				}

			}
			/* end change CR6153 */

			try {
				JMSConnectorLocal local = HomeProvider.getJMSConnectorLocal();
				ValidateHeaderDataOutputConnectorDTO outputDTO = (ValidateHeaderDataOutputConnectorDTO) local
						.sendReceive(InputConnectorDTOBuildHelper
								.buildValidateHeaderDataInputConnectorDTO(amendContractCustomDTO));

				boolean isHeaderValidated = ConnectorConstants.RFC_SUCCESS_CODE
						.equals(outputDTO.getReturnCode());

				if (isHeaderValidated == false) {
					throwServiceException(outputDTO.getReturnCode(),
							OPPTMessageCatalog.TYPE_BACKEND);
				}
			} catch (Exception e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						methodName, null, e);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}

			boolean canAmendContract = ProposalContractStatusConstants.CHECK_AMENDED_CONTRACT_STATUS
					.equals(amendContractCustomDTO.getContract().getStatus());

			if (isChangeProposal == false) {
				if (canAmendContract) {
					Date oldAmendmentDate = originalProposalContractBO
							.getAmendEffectiveDate();

					if (oldAmendmentDate != null) {
						isAmendmentGreater = calendar.isDateGreater(
								amendmentEffectiveDate, oldAmendmentDate);

						if (isAmendmentGreater == false) {
							throw ExceptionGenerator
									.generateServiceException(ErrorCodeConstants.SE0310);
						}
					}
				}
			}

			if (isChangeProposal == false) {
				originalProposalContractBO
						.setStatusCode(ProposalContractStatusConstants.AMEND_PROPOSAL_TO_REVERT);

				double amendmentNo = originalProposalContractBO
						.getContrAmendNo() + 1;
				newProposalContractBO.setContrAmendNo(amendmentNo);
				newProposalContractBO.setInvoiceAmount(0);

				String contractNo = originalProposalContractBO.getContrNo();
				newProposalContractBO.setOldContrNo(contractNo);
				newProposalContractBO.setContrNo(getNewTypeContractNumber(
						contractNo, amendmentNo,
						ContractTypeConstants.AMENDMENT));
			}
			// BH Wave1 - DAD003 - Bhanu - Begin
			newProposalContractBO.setCpsId(amendContractCustomDTO.getBasicProposalCustomDTO().getCpsID());
			newProposalContractBO.setOcpsId(amendContractCustomDTO.getBasicProposalCustomDTO().getOcpsID());
			//newProposalContractBO.setComplexContractAmendment(amendContractCustomDTO.getBasicProposalCustomDTO().getComplexContractAmendment());
			//newProposalContractBO.setMasterContractId(amendContractCustomDTO.getBasicProposalCustomDTO().getMasterContractID());
			newProposalContractBO.setContractType(amendContractCustomDTO.getBasicProposalCustomDTO().getContractType());
			//newProposalContractBO.setMasterContractAmendment(amendContractCustomDTO.getBasicProposalCustomDTO().getMasterContractAmendment());
			newProposalContractBO.setBlbIndicator(amendContractCustomDTO.getBasicProposalCustomDTO().getBlbIndicator());
			newProposalContractBO.setCciInd(amendContractCustomDTO.getBasicProposalCustomDTO().getCciInd());
			// BH Wave1 - DAD003 - Bhanu - End

			PricingInformationCustomDTO pricingInformationCustomDTO = amendContractCustomDTO
					.getPricingInformationCustomDTO();
			SecondaryProposalCustomDTO secondaryProposalCustomDTO = amendContractCustomDTO
					.getSecondaryProposalCustomDTO();

			if (proposalDTO.getExternalContractNumber() != null) {
				newProposalContractBO.setExtContrNo(proposalDTO
						.getExternalContractNumber());
			}
			newProposalContractBO.setAmendEffectiveDate(new Date(
					amendmentEffectiveDate.getTime()));

			if (pricingInformationCustomDTO != null) {
				if (pricingInformationCustomDTO.getAnniversaryContractAmount() > 0) {
					newProposalContractBO
							.setAnnvAmount(pricingInformationCustomDTO
									.getAnniversaryContractAmount());
				}
				// s and s change starts
				if (pricingInformationCustomDTO
						.getSAndSAnniversaryContractAmount() > 0) {
					newProposalContractBO
							.setSAndsAnniversaryAmount(pricingInformationCustomDTO
									.getSAndSAnniversaryContractAmount());
				}
				// s and s change ends

				/* CR6153 start changes */
				if (pricingInformationCustomDTO
						.getSAndSAnniversaryContractAmountPeriod2() > 0) {
					newProposalContractBO
							.setSAndsAnniversaryAmt2(pricingInformationCustomDTO
									.getSAndSAnniversaryContractAmountPeriod2());
				}
				if (pricingInformationCustomDTO
						.getSAndSAnniversaryContractAmountPeriod3() > 0) {
					newProposalContractBO
							.setSAndsAnniversaryAmt3(pricingInformationCustomDTO
									.getSAndSAnniversaryContractAmountPeriod3());
				}
				if (pricingInformationCustomDTO
						.getSAndSAnniversaryContractAmountPeriod4() > 0) {
					newProposalContractBO
							.setSAndsAnniversaryAmt4(pricingInformationCustomDTO
									.getSAndSAnniversaryContractAmountPeriod4());
				}
				if (pricingInformationCustomDTO
						.getSAndSAnniversaryContractAmountPeriod5() > 0) {
					newProposalContractBO
							.setSAndsAnniversaryAmt5(pricingInformationCustomDTO
									.getSAndSAnniversaryContractAmountPeriod5());
				}
				/* CR6153 end changes */
				if (pricingInformationCustomDTO.getFreeTextForInvoicePrint() != null) {
					newProposalContractBO
							.setFreeText(pricingInformationCustomDTO
									.getFreeTextForInvoicePrint());
				}

				if (pricingInformationCustomDTO.isGsa()) {
					newProposalContractBO
							.setGsaInd(UtilityConstants.GSA_SELECTED);
				} else {
					newProposalContractBO.setGsaInd(null);
				}
				// BH Wave1 - DAD003 - Bhanu - Begin
			/*	if (pricingInformationCustomDTO.isPrebillIndicator()) {
					newProposalContractBO.setPrebillIndicator(UtilityConstants.YES);
				} else {
					newProposalContractBO.setPrebillIndicator(UtilityConstants.NO);
				}*/
				newProposalContractBO.setPrebillIndicator(pricingInformationCustomDTO.isPrebillIndicator());
				// BH Wave1 - DAD003 - Bhanu - Begin
				if (pricingInformationCustomDTO.getBillingBlock() != null) {
					newProposalContractBO
							.setBillingBlock(pricingInformationCustomDTO
									.getBillingBlock());
				}
			}

			if (secondaryProposalCustomDTO != null) {
				if (secondaryProposalCustomDTO.getPurchaseOrderNumber() != null) {
					newProposalContractBO.setPoNo(secondaryProposalCustomDTO
							.getPurchaseOrderNumber());
				}

				if (secondaryProposalCustomDTO.getPurchaseOrderDate() != null) {
					newProposalContractBO.setPoDate(new Date(
							secondaryProposalCustomDTO.getPurchaseOrderDate()
									.getTime()));
				}

			}

			if (isChangeProposal) {
				newProposalContractBO.validateProposalHeader(true);
				factory.updateProposalContractBO(newProposalContractBO);
			} else {
				String operationPerformed = "Amend Contract";

				ProposalContractBO maxProposalContractBO = factory
						.findMaxProposalContractBO();

				originalProposalContractBO
						.setProposalName(originalProposalContractBO
								.getProposalName()
								+ ProposalContractStatusConstants.AMEND_PROPOSAL_TO_REVERT);
				originalProposalContractBO.setProposalId(maxProposalContractBO
						.getProposalId() + 1);

				newProposalContractBO
						.setContrType(ContractTypeConstants.AMENDMENT);
				newProposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				newProposalContractBO.setDatePriced(null);
				newProposalContractBO.setInvoiceAmount(0);

				if (factory.isProposalNameExists(originalProposalContractBO
						.getProposalName())) {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0018);
				}

				newProposalContractBO.validateProposalHeader(true);

				factory.updateProposalContractBO(newProposalContractBO);
				// UD Changes
				originalProposalContractBO.setGroupName(newProposalContractBO
						.getGroupName());
				factory.createProposalContractBO(originalProposalContractBO);
				createAccessHistory(originalProposalContractBO.getProposalId(),
						originalProposalContractBO.getCreatedBy(),
						operationPerformed);

				CopyInventoryDomainDTO copyInventoryDomainDTO = new CopyInventoryDomainDTO();
				copyInventoryDomainDTO
						.setNewProposalID(originalProposalContractBO
								.getProposalId());
				// here the new proposal is the proposal whose status is changed
				// to AD and all the inventory remains same
				// So we copy the inventory to originalProposal contract BO.
				// There is a naming confusion now pls look at factory.update
				// and factory.create that will answer your quries
				copyInventoryDomainDTO.setOldProposalID(newProposalContractBO
						.getProposalId());
				copyInventoryDomainDTO
						.setActionName(ActionNameConstants.AMEND_CONTRACT);

				copyCustomerList(copyInventoryDomainDTO);
				getInventoryManagerLocal()
						.copyInventory(copyInventoryDomainDTO);
			}

			return amendContractCustomDTO;
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					methodName, null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *
	 *
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 19, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param validateTPProposalCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public ValidateTPProposalCustomDTO validateTPProposal(
			ValidateTPProposalCustomDTO validateTPProposalCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "validateTPProposal");

		try {
			ProposalCustomDTO proposalDTO = validateTPProposalCustomDTO
					.getProposalDTO();

			ProposalContractBOFactory factory = new ProposalContractBOFactory();
			ProposalContractBO proposalContractBO = null;
			try {
				proposalContractBO = factory.getProposalContractBO(proposalDTO
						.getId());
			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de
						.getErrorReport());
			}

			try {
				SharingBO sharingBO = getSharingBOFromFactory(proposalDTO
						.getId(), validateTPProposalCustomDTO.getUserId());
				HashMap compareValues = populateCompareValuesForUserAuthInProposalBO(
						validateTPProposalCustomDTO, sharingBO);
				compareValues.put(UtilityConstants.PROPOSAL_TYPE, OPPTHelper
						.trimString(proposalContractBO.getProposalType()));

				boolean isTPOriginal = false;
				boolean isValidTP = false;

				if (proposalContractBO.validateTP(
						UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
						compareValues)) {
					try {
						if (proposalContractBO.validateTPOriginal(
								UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
								compareValues)) {
							isTPOriginal = true;
						}
					} catch (DomainException e) {
						isTPOriginal = false;
					}

					SWODomainDTO swoDTO = new SWODomainDTO();
					swoDTO.setProposalId(proposalDTO.getId());

					HashMap map = new HashMap();
					map.put(UtilityConstants.REGISTRATION_REQUEST, new Boolean(
							false));
					map.put(UtilityConstants.CONTRACT_TYPE, OPPTHelper
							.trimString(proposalContractBO.getContrType()));
					swoDTO.setValues(map);

					SWODTOFactory swoFactory = new SWODTOFactory();
					swoDTO = swoFactory.validateTPProposal(swoDTO);

					Boolean isValid = (Boolean) swoDTO.getValues().get(
							UtilityConstants.TP_VALID_FLAG);

					if (isValid.booleanValue()) {
						map = swoDTO.getValues();
						validateTPProposalCustomDTO.setSwos((List) map
								.get(UtilityConstants.TP_SWO_LIST));
						validateTPProposalCustomDTO
								.setMessageReport((ErrorReport) map
										.get(UtilityConstants.TP_MESSAGE));

						//						if (isTPOriginal == false) {
						//							String creationFlag = (String)
						// swoDTO.getValues().get(UtilityConstants.TP_CREATION_FLAG);
						//							proposalContractBO.setContrCreateFlag(creationFlag);
						//							factory.updateProposalContractBO(proposalContractBO);
						//						}
					} else {
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0320);
					}
				}

			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}

			return validateTPProposalCustomDTO;
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * To Check for certain business rules before removing the userId
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 9, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param UserCustomDTO
	 * @return UserCustomDTO
	 */
	public UserCustomDTO checkForRemovingUser(UserCustomDTO userCustom)
			throws ServiceException {
		List checkProposalContractBOSubmittedByList = new ArrayList();

		String userID = OPPTHelper.trimString(userCustom.getUserId());
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();

		switch (userCustom.getRole()) {
		case RoleConstants.PROPOSAL_APPROVER:
			if (checkForProposalsForApprover(userID)) {
				userCustom.setId(ErrorCodeConstants.SE0205);
			}
			break;

		case RoleConstants.MARKETING_REP:
		case RoleConstants.CSO:
		case RoleConstants.BUSINESS_PARTNER:
		case RoleConstants.BHD:
		case RoleConstants.OPPT_READ:
		case RoleConstants.CREATE_APPROVE:
			boolean checkNext = true;

			try {
				List checkProposalsContractsBOForUsersList = proposalContractBOFactory
						.findProposalsContractsBOForUsers(userID);

				if (checkProposalsContractsBOForUsersList.size() > 0) {
					userCustom.setId(ErrorCodeConstants.SE0205);
					checkNext = false;
				}
			} catch (DomainException ex) {
				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}

			if (checkNext == false) {
				break;
			}

			if (userCustom.getRole() != RoleConstants.BUSINESS_PARTNER) {
				try {
					List checkProposalContractBOLockedByList = proposalContractBOFactory
							.findProposalContractBOLockedBy(userID);

					if (checkProposalContractBOLockedByList.size() > 0) {
						userCustom.setId(ErrorCodeConstants.SE0205);
						checkNext = false;
					}
				} catch (DomainException ex) {
					throw ExceptionGenerator.generateServiceException(ex
							.getErrorReport());
				}
			}

			if (checkNext == false) {
				break;
			}

			if (userCustom.getRole() == RoleConstants.BHD|| userCustom.getRole() == RoleConstants.OPPT_READ) {
				try {
					SharingBOFactory sharingBOFactory = new SharingBOFactory();

					List checkSharingBOForUsersList = sharingBOFactory
							.findSharingBOForUsers(userID);

					if (checkSharingBOForUsersList.size() > 0) {
						userCustom.setId(ErrorCodeConstants.SE0205);
						checkNext = false;
					}
				} catch (DomainException ex) {
					throw ExceptionGenerator.generateServiceException(ex
							.getErrorReport());
				}
			}

			if (checkNext == false) {
				break;
			}

			if (userCustom.getRole() == RoleConstants.CREATE_APPROVE) {
				if (checkForProposalsForApprover(userID)) {
					userCustom.setId(ErrorCodeConstants.SE0205);
				}
			}

		}

		/**
		 * Changes starts from here : Thirumalaikumar It sets the null value,
		 * when users have the reference with the proposal submited by coulmn.
		 */
		try {
			checkProposalContractBOSubmittedByList = proposalContractBOFactory
					.findProposalsSubmittedBy(userID);
			ProposalContractBO proposalContractBO = null;
			if (checkProposalContractBOSubmittedByList.size() > 0) {
				Iterator proposalContractIterator = checkProposalContractBOSubmittedByList
						.iterator();
				while (proposalContractIterator.hasNext()) {
					proposalContractBO = (ProposalContractBO) proposalContractIterator
							.next();
					proposalContractBO.setSubmittedBy(null);
					proposalContractBOFactory
							.updateProposalContractBO(proposalContractBO);
				}
			}
		} catch (DomainException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"checkForRemovingUser", null, ex);
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());

		}
		// Changes end here

		return userCustom;
	}

	private boolean checkForProposalsForApprover(String userID)
			throws ServiceException {
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		boolean isProposalExists = false;

		userID = OPPTHelper.trimString(userID);
		try {
			List list = proposalContractBOFactory
					.findProposalContractWaitingForApproval(userID);

			isProposalExists = (list.size() > 0);

			if (isProposalExists == false) {
				list = proposalContractBOFactory
						.findProposalContractBOApprovedBy(userID);
				isProposalExists = (list.size() > 0);
			}
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}

		return isProposalExists;
	}

	/**
	 * To update proposals/contracts locked by = null
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 9, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param List
	 * @return void
	 */
	public void updateProposalWithGroupName(String userID, String groupName)
			throws ServiceException {
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		Collection proposalManagerList = null;
		try {
			proposalManagerList = proposalContractBOFactory
					.findProposalsContractsBOForUsers(userID);
		} catch (DomainException ex) {
			// ignore this exception if the user doesn't have any proposal
			// locked.
		}

		if (proposalManagerList != null && proposalManagerList.size() > 0) {
			ProposalContractBO proposalContractBO;
			Iterator iterator = proposalManagerList.iterator();

			while (iterator.hasNext()) {
				proposalContractBO = (ProposalContractBO) iterator.next();
				try {
					proposalContractBO.setGroupName(groupName);
					proposalContractBOFactory
							.updateProposalContractBO(proposalContractBO);
				} catch (DomainException ex) {
					// ignore this exception too...
				}
			}
		}
	}

	/**
	 *
	 * This method retrives Alternate Partner and also dose a partner check <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 9, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param alternatePartnerCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public AlternatePartnerCustomDTO fetchAlternatePartner(
			AlternatePartnerCustomDTO alternatePartnerCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "fetchAlternatePartner");
		boolean igfNumberAction = false;
		OPPTLogger.debug("Action Name = "
				+ alternatePartnerCustomDTO.getTransactionName(), CLASS_NAME,
				"fetchAlternatePartner");
		OPPTLogger.debug("alternatePartnerCustomDTO.getPartnerType() = "
				+ alternatePartnerCustomDTO.getPartnerType(), CLASS_NAME,
				"fetchAlternatePartner");
		if (ActionNameConstants.IGF_ACTION.equals(alternatePartnerCustomDTO
				.getTransactionName())) {
			igfNumberAction = true;
		}
		PartnerCheckInputConnectorDTO inputConnectorDTO = new PartnerCheckInputConnectorDTO();

		/*DADO02&DADO09 BlueHarmony sateesh Anne inputConnectorDTO
				.setPartnerAddressSequenceNumber(alternatePartnerCustomDTO
						.getSequenceNumber());
		inputConnectorDTO.setPartnerLegacyNumber(alternatePartnerCustomDTO
				.getLegacyCustomerNumber());
		inputConnectorDTO.setCountryCode(alternatePartnerCustomDTO
				.getCountryCode());*/ /*
									 * Changed for EF0607044559 by Sara on June
									 * 16,2004
									 */

		inputConnectorDTO.setPartnerLegacyNumber(alternatePartnerCustomDTO
				.getSAPCustomerNumber());
		if (UtilityConstants.PARTNER_SOLD_TO_PARTY == alternatePartnerCustomDTO
				.getPartnerType()) {
			inputConnectorDTO
					.setPartnerType(PartnerTypeConstants.SOLD_TO_PARTY);
		} else if (UtilityConstants.PARTNER_BILL_TO_PARTY == alternatePartnerCustomDTO
				.getPartnerType()) {
			inputConnectorDTO
					.setPartnerType(PartnerTypeConstants.BILL_TO_PARTY);
		} else if (UtilityConstants.PARTNER_PAYER == alternatePartnerCustomDTO
				.getPartnerType()) {
			inputConnectorDTO.setPartnerType(PartnerTypeConstants.PAYER);
			//
			if (igfNumberAction
					&& alternatePartnerCustomDTO.isFinancingFlag() == true) {
				inputConnectorDTO.setFinancingContractFlag("F");
			}
		} else if (UtilityConstants.PARTNER_SHIP_TO_PARTY == alternatePartnerCustomDTO
				.getPartnerType()) {
			inputConnectorDTO
					.setPartnerType(PartnerTypeConstants.SHIP_TO_PARTY);
		} else if (UtilityConstants.PARTNER_NINE_D == alternatePartnerCustomDTO
				.getPartnerType()) {
			inputConnectorDTO.setPartnerType(PartnerTypeConstants.PARTNER_9D);
			inputConnectorDTO.setPartnerLegacyNumber(alternatePartnerCustomDTO
					.getSAPCustomerNumber());
		}

		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
		genericConnectorDTO
				.setFunctionModuleName(ConnectorConstants.RFC_PARTNER_CHECK_OPPT);
		genericConnectorDTO.setUserID(alternatePartnerCustomDTO.getUserId());
		genericConnectorDTO.setSessionID(alternatePartnerCustomDTO
				.getSessionId());
		inputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
		orgConnectorDTO.setDistributionChannel(alternatePartnerCustomDTO
				.getDistributionChannel());
		//orgConnectorDTO.setSalesGroup(alternatePartnerCustomDTO.getSalesGroup()); //Added by Ramesh for DSTRCHANNEL
		//orgConnectorDTO.setChannelRole(alternatePartnerCustomDTO.getChannelRole()); //Added by Ramesh DSTRCHANNEL
		//orgConnectorDTO.setSubmitterRole(alternatePartnerCustomDTO.getSubmitterRole()); //Added by Ramesh DSTRCHANNEL
		orgConnectorDTO.setDivision(alternatePartnerCustomDTO.getDivision());
		orgConnectorDTO.setSalesOrg(alternatePartnerCustomDTO
				.getSelectedSalesOrg());
		inputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);
		// Make the ESW Call to the Backend
		JMSConnectorLocal jmsConnectorLocal = null;
		try {
			jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
		} catch (CreateException e) {

		}
		PartnerCheckOutputConnectorDTO outputConnectorDTO = new PartnerCheckOutputConnectorDTO();
		try {
			outputConnectorDTO = (PartnerCheckOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(inputConnectorDTO);
		} catch (Exception e1) {

		}
		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(outputConnectorDTO
				.getReturnCode())) {
			ESWCustomerCustomDTO customerInfoCustomDTO = new ESWCustomerCustomDTO();
			customerInfoCustomDTO.setSAPCustomerNumber(outputConnectorDTO
					.getCustomerNo());
			customerInfoCustomDTO.setCustomerName(outputConnectorDTO
					.getPartnerName());
			customerInfoCustomDTO.setLegacyCustomerNumber(outputConnectorDTO
					.getLegacyNo());
			customerInfoCustomDTO.setAddressSequenceNumber(outputConnectorDTO
					.getAddressSeqNo());
			customerInfoCustomDTO.setCustomerClass(OPPTHelper
					.trimStringToNull(outputConnectorDTO.getClassType()));
			customerInfoCustomDTO.setCountryCode(inputConnectorDTO
					.getCountryCode()); /*
										 * Changed for EF0607044559 by Sara on
										 * June 16,2004
										 */
			if (igfNumberAction) {
				if (PartnerTypeConstants.CLASS_33.equals(outputConnectorDTO
						.getClassType())) {
					alternatePartnerCustomDTO.setBtpEditable(true);
				}
			}
			alternatePartnerCustomDTO.setPartnerInfo(customerInfoCustomDTO);
		} else {
			throwServiceException(outputConnectorDTO.getReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
		}
		log.end();
		return alternatePartnerCustomDTO;
	}

	/**
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 9, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @throws ServiceException
	 * @author balajiv
	 */
	public FetchPartnerInformationCustomDTO fetchPartnerInformationForBP(
			FetchPartnerInformationCustomDTO fetchPartnerInformationCustomDTO)
			throws ServiceException {

		UserManagerLocal userManagerLocal = null;
		ESWCustomerCustomDTO customer = fetchPartnerInformationCustomDTO
				.getCustomer();
		try {
			userManagerLocal = HomeProvider.getUserManagerLocal();
		} catch (CreateException e) {

		}
		UserProfileDomainDTO userProfileDomainDTO = null;
		try {
			userProfileDomainDTO = userManagerLocal
					.getUserProfile(fetchPartnerInformationCustomDTO
							.getUserId());
		} catch (ServiceException e1) {

		}
		if (userProfileDomainDTO.getBPAccessIndicator() != null
				&& userProfileDomainDTO.getBPAccessIndicator().equals("L")) {
			List legacyCustomerList = userProfileDomainDTO.getBPLegactNoList();
			boolean validLegacyNo = false;
			// checking if the user has access to the Legacycustomer number
			// which he entered.
			for (int i = 0; i < legacyCustomerList.size(); i++) {
				BPLegacyBDO bpLegacyBDO = (BPLegacyBDO) legacyCustomerList
						.get(i);

				if (customer.getAddressSequenceNumber().equals(
						bpLegacyBDO.getAddressSeqNumber())
						&& customer.getLegacyCustomerNumber().equals(
								bpLegacyBDO.getLegacyNumber())) {
					validLegacyNo = true;
					break;
				}
			}
			if (!validLegacyNo) {
				// Throw service Exception. Since we do not have data
				// consistency we are leaving this blank
			}
			RetrievePartnerInputConnectorDTO inputConnectorDTO = new RetrievePartnerInputConnectorDTO();
			inputConnectorDTO.setAddressSequenceNo(customer
					.getAddressSequenceNumber());
			inputConnectorDTO.setLegacyNo(customer.getLegacyCustomerNumber());
			TreeMap soldToParty = new TreeMap();
			TreeMap billToParty = new TreeMap();
			TreeMap payer = new TreeMap();
			TreeMap shipToParty = new TreeMap();
			GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
			genericConnectorDTO
					.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_PARTNER_OPPT);
			genericConnectorDTO.setUserID(fetchPartnerInformationCustomDTO
					.getUserId());
			genericConnectorDTO.setSessionID(fetchPartnerInformationCustomDTO
					.getSessionId());
			inputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
			OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
			orgConnectorDTO
					.setDistributionChannel(fetchPartnerInformationCustomDTO
							.getDistributionChannel());
			orgConnectorDTO.setSalesGroup(fetchPartnerInformationCustomDTO.getSalesGroup());
			orgConnectorDTO.setChannelRole(fetchPartnerInformationCustomDTO.getChannelRole());
			orgConnectorDTO.setSubmitterRole(fetchPartnerInformationCustomDTO.getSubmitterRole());
			orgConnectorDTO.setDivision(fetchPartnerInformationCustomDTO
					.getDivisionCode());
			orgConnectorDTO.setSalesOrg(fetchPartnerInformationCustomDTO
					.getSelectedSalesOrg());
			inputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);
			// Make the ESW Call to the Backend
			JMSConnectorLocal jmsConnectorLocal = null;
			try {
				jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
			} catch (CreateException e) {

			}
			RetrievePartnerOutputConnectorDTO outputConnectorDTO = new RetrievePartnerOutputConnectorDTO();
			try {
				outputConnectorDTO = (RetrievePartnerOutputConnectorDTO) jmsConnectorLocal
						.sendReceive(inputConnectorDTO);
			} catch (Exception e1) {

			}
			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(outputConnectorDTO
					.getReturnCode())) {
				//RetrievePartnerConnectorDTO
				List retrievePartnerConnectorDTOList = outputConnectorDTO
						.getRetrievePartnerConnectorDTOList();
				PCMCustomDTOBuilder.populatePartnerInformation(
						retrievePartnerConnectorDTOList,
						fetchPartnerInformationCustomDTO, false, false);
			} else {
				throwServiceException(outputConnectorDTO.getReturnCode(),
						OPPTMessageCatalog.TYPE_BACKEND);
			}
		} else if (userProfileDomainDTO.getBPAccessIndicator() != null
				&& userProfileDomainDTO.getBPAccessIndicator().equals("C")) {
		}
		return fetchPartnerInformationCustomDTO;
	}

	/**
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 10, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param fetchCustomerListCustomDTO
	 * @return FetchCustomerListCustomDTO
	 * @throws ServiceException
	 * @author balajiv
	 */
	public FetchCustomerListCustomDTO fetchCustomerListsForBP(
			FetchCustomerListCustomDTO fetchCustomerListCustomDTO)
			throws ServiceException {

		UserManagerLocal userManagerLocal = null;
		TreeMap customerListMap = new TreeMap();
		try {
			userManagerLocal = HomeProvider.getUserManagerLocal();
		} catch (CreateException e) {

		}
		UserProfileDomainDTO userProfileDomainDTO = null;
		try {
			userProfileDomainDTO = userManagerLocal
					.getUserProfile(fetchCustomerListCustomDTO.getUserId());
		} catch (ServiceException e1) {

		}
		if (userProfileDomainDTO.getBPAccessIndicator() != null
				&& userProfileDomainDTO.getBPAccessIndicator().equals("C")) {
			List customerList = userProfileDomainDTO.getBPCustomerList();
			if (fetchCustomerListCustomDTO.getCustomerListNumber() != null) {
				for (int i = 0; i < customerList.size(); i++) {
					BPCustomerListBDO bpCustomerListBDO = (BPCustomerListBDO) customerList
							.get(i);
					if (fetchCustomerListCustomDTO.getCustomerListNumber()
							.equals(bpCustomerListBDO.getCustListNo())) {
						CustomerListCustomDTO customerListCustomDTO = new CustomerListCustomDTO();
						customerListCustomDTO.setListName(bpCustomerListBDO
								.getCustListName());
						customerListCustomDTO.setListNumber(bpCustomerListBDO
								.getCustListNo());
						customerListMap.put(customerListCustomDTO
								.getListNumber(), customerListCustomDTO);
						break;
					}
				}
			} else if (fetchCustomerListCustomDTO.getCustomerListName() != null) {
				for (int i = 0; i < customerList.size(); i++) {
					BPCustomerListBDO bpCustomerListBDO = (BPCustomerListBDO) customerList
							.get(i);
					if (fetchCustomerListCustomDTO.getCustomerListNumber()
							.equals(bpCustomerListBDO.getCustListNo())) {
						CustomerListCustomDTO customerListCustomDTO = new CustomerListCustomDTO();
						customerListCustomDTO.setListName(bpCustomerListBDO
								.getCustListName());
						customerListCustomDTO.setListNumber(bpCustomerListBDO
								.getCustListNo());
						customerListMap.put(customerListCustomDTO
								.getListNumber(), customerListCustomDTO);
						break;
					}
				}
			} else {
				// get all the details from user profile
				for (int i = 0; i < customerList.size(); i++) {
					BPCustomerListBDO bpCustomerListBDO = (BPCustomerListBDO) customerList
							.get(i);
					CustomerListCustomDTO customerListCustomDTO = new CustomerListCustomDTO();
					customerListCustomDTO.setListName(bpCustomerListBDO
							.getCustListName());
					customerListCustomDTO.setListNumber(bpCustomerListBDO
							.getCustListNo());
					customerListMap.put(customerListCustomDTO.getListNumber(),
							customerListCustomDTO);
				}
			}
		} else {
			// throw Exception
		}
		fetchCustomerListCustomDTO.setCustomerLists(customerListMap);
		return fetchCustomerListCustomDTO;
	}

	/**
	 * This is used to save the proposal <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 10, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @author balajiv
	 */
	public ProposalHeaderCustomDTO saveProposal(
			ProposalHeaderCustomDTO proposalHeaderCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "saveProposal");
		// Getting all the data
		java.util.Date today = new java.util.Date();
		boolean fetchInventory = false;
		ProposalCustomDTO proposalCustomDTO = proposalHeaderCustomDTO
				.getProposal();
		CreateContractInputConnectorDTO createcontractDTO = new CreateContractInputConnectorDTO();
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		CustomerBOFactory customerBOFactory = new CustomerBOFactory();
		boolean changeProposal = false;
		String methodName = "saveProposal";
		if (proposalCustomDTO != null) {
			changeProposal = true;
		}
		/* IGF Test - Start changes */
		String igfOfferNumber = proposalHeaderCustomDTO
				.getSecondaryProposalCustomDTO().getIgfOfferNumber();
		//"".equalsIgnoreCase(
		//System.out.println("ProposalManagerBean.saveProposal()igfOfferNumber"+igfOfferNumber);
		if ("".equalsIgnoreCase(igfOfferNumber)) {
			checkIGFCustomer(proposalHeaderCustomDTO);
			//createcontractDTO.setPaymentMethod("7");
			
		}
		else
		{
			//createcontractDTO.setPaymentMethod("E");
		}
		
		/* IGF Test - End changes */
		
		
		ProposalBO proposalBO = new ProposalBO();
		if (changeProposal) {
			try {
				proposalBO = (ProposalBO) proposalContractBOFactory
						.getProposalContractBO(proposalCustomDTO.getId());
			} catch (DomainException e1) {
				throw ExceptionGenerator.generateServiceException(e1
						.getErrorReport());
			}
			
			String customerName = proposalHeaderCustomDTO.getPartnerInformationCustomDTO().getSlectedCustomerName();
			String soldtoPartyName = proposalBO.getRegCustomerName().trim();
			
			// system.out.println("customerName   "  +soldtoPartyName);
			// system.out.println("customerName   "  +customerName);
			// system.out.println("proposalBO.getAutoPopulate()   "  +proposalBO.getAutoPopulate());
			//if ((proposalBO.getAutoPopulate().equalsIgnoreCase(UtilityConstants.YES))&&(customerName.compareTo(soldtoPartyName)!= 0)){
			if ((proposalBO.getAutoPopulate().equalsIgnoreCase(UtilityConstants.YES))&&(customerName!=null && customerName.compareTo(soldtoPartyName)!= 0)){
				int proposalCount;
			//	String customerName = proposalHeaderCustomDTO.getPartnerInformationCustomDTO().getSlectedCustomerName();
				proposalBO.setSelectedCustomerName(customerName);	
				
			try{
				// system.out.println(" Inside Chantge try  "  +proposalBO.getSalesOrg());
				// system.out.println(" Inside Chantge try  "  +proposalBO.getSelectedCustomerName());
				// system.out.println(" Inside Chantge try  "  +proposalBO.getProposalContent());
				
				
			proposalCount = proposalContractBOFactory.getMaxProposalCount(proposalBO);
			
			// system.out.println("proposal Count   " +proposalCount );
			String proposalContent = proposalBO.getProposalContent().equalsIgnoreCase("M")? "MLC" :"SandS";
			proposalBO.setProposalCount(proposalCount);
			String newProposalName = proposalBO.getSalesOrg()+"_"+customerName+"_"+proposalContent+"_"+proposalBO.getProposalCount();
			proposalBO.setAutoPopulate(UtilityConstants.YES);			
			proposalBO.setProposalName(newProposalName);
			proposalHeaderCustomDTO.getBasicProposalCustomDTO().setProposalName(newProposalName);
			//Mallik-Start
			proposalHeaderCustomDTO.getProposal().setContent(proposalContent);
			//Mallik-End
			// system.out.println("proposal Count   " +proposalBO.getProposalCount());
			// system.out.println("proposal Count   " +newProposalName );
			} catch (DomainException  ex){}
			}
			
			PCMBOBuilder.populateProposalBO(proposalBO,
					proposalHeaderCustomDTO, PCMBOBuilder.CHANGE_PROPOSAL);
			proposalBO.setLastUpdatedDate(new java.sql.Date(today.getTime()));
			try {
				proposalContractBOFactory.updateProposalContractBO(proposalBO);
			} catch (DomainException e) {
				// TODO Auto-generated catch block
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}
		} else {

//			Blue Harmony Wave 1 DAD001 - Start - Anand
			
			String proposalName = proposalHeaderCustomDTO.getBasicProposalCustomDTO().getProposalName();
			
			// system.out.println("Sales org Value" + proposalHeaderCustomDTO.getBasicProposalCustomDTO().getSalesOrganization());
			// system.out.println("Selected customer name" + proposalHeaderCustomDTO.getPartnerInformationCustomDTO().getSlectedCustomerName());
			// system.out.println("Sales org" + proposalHeaderCustomDTO.getBasicProposalCustomDTO().getProposalContent());
			
			if(proposalName == null || proposalName.trim().equalsIgnoreCase("")) {
				
			String proposalContent = proposalHeaderCustomDTO.getBasicProposalCustomDTO().getProposalContent().equalsIgnoreCase("M")? "MLC" :"SandS";
			String salesOrg = proposalHeaderCustomDTO.getBasicProposalCustomDTO().getSalesOrganization();
			
			//String customerName = proposalHeaderCustomDTO.getPartnerInformationCustomDTO().getSlectedCustomerName().substring(0,20).trim();
			int customerNamelength = proposalHeaderCustomDTO.getPartnerInformationCustomDTO().getSlectedCustomerName().length();
			String customerName =null;
			if (customerNamelength>=20){
			
			 customerName =  proposalHeaderCustomDTO.getPartnerInformationCustomDTO().getSlectedCustomerName().substring(0,20).trim();
			}
			else{
				customerName =  proposalHeaderCustomDTO.getPartnerInformationCustomDTO().getSlectedCustomerName().trim();	
			}
			

			
			String proposalcontent1 = proposalHeaderCustomDTO.getBasicProposalCustomDTO().getProposalContent();
			String newProposalName =null;
			//0147_ABC_MLC_1 0147_XYZ_MLC_1
			
			proposalBO.setSelectedCustomerName(customerName);	
			proposalBO.setSalesOrg(salesOrg);
			proposalBO.setProposalContent(proposalcontent1);
			int proposalCount;
			try{
			proposalCount = proposalContractBOFactory.getMaxProposalCount(proposalBO);
			// system.out.println("proposal Count   " +proposalCount );
			
			proposalBO.setProposalCount(proposalCount);
			
			
			//	proposalCount= ProposalDAO.getMaxProposalCount(salesOrg,customerName,proposalContent1);
				newProposalName = salesOrg+"_"+customerName+"_"+proposalContent+"_"+proposalBO.getProposalCount();
				 // system.out.println("New Proposal Name" +newProposalName);
				proposalBO.setProposalName(newProposalName);
				proposalBO.setAutoPopulate(UtilityConstants.YES);
				proposalHeaderCustomDTO.getBasicProposalCustomDTO().setProposalName(newProposalName);
			// system.out.println("proposal Count   " +proposalBO.getProposalCount());
			} catch (DomainException  ex){}
			
			
			}
			else{
				
			proposalBO.setProposalName(proposalHeaderCustomDTO.getBasicProposalCustomDTO().getProposalName());
			proposalBO.setAutoPopulate(UtilityConstants.NO);
			}
//			Blue Harmony Wave 1 DAD001 - End - Anand
			
			String userId = proposalHeaderCustomDTO.getUserId();

			// populate basic data
			PCMBOBuilder.populateProposalBO(proposalBO,
					proposalHeaderCustomDTO, PCMBOBuilder.SAVE_PROPOSAL);
			if (!proposalBO.isSAndSProposal()) {
				// The proposalContent should be M
				proposalBO.setProposalContent(UtilityConstants.MLC_ONLY);
			}

			// UD Changes starts
			if (proposalHeaderCustomDTO.getSelectedGroupName() != null) {
				proposalBO.setGroupName(OPPTHelper
						.trimString(proposalHeaderCustomDTO
								.getSelectedGroupName()));
			} else if (proposalHeaderCustomDTO.getGroupName() != null) {
				proposalBO.setGroupName(OPPTHelper
						.trimString(proposalHeaderCustomDTO.getGroupName()));
			}

			OPPTLogger.debug("proposalBO.getGroupName() = "
					+ proposalBO.getGroupName(),CLASS_NAME, methodName);
			// UD Changes ends
			int proposalId = 0;
			String contractNo = "";
			// Create Replace contract
			try {
				OPPTLogger.debug("proposalBO.getOldContrNo() : "
						+ proposalBO.getOldContrNo(), CLASS_NAME,
						"saveProposal");
				if (null != OPPTHelper.trimStringToNull(proposalBO
						.getOldContrNo())) {
					ProposalContractBO oldContract = proposalContractBOFactory
							.getProposalContractBOForContractNumber(proposalBO
									.getOldContrNo(), true);
					oldContract.validateContractForReplacementRenewal();
					oldContract
							.setStatusCode(ProposalContractStatusConstants.REPLACEMENT_IN_PROGRESS);
					proposalBO.setContrType(ContractTypeConstants.REPLACEMENT);
					double contractReplacementNo = oldContract.getContrReplNo() + 1;
					proposalBO.setContrNo(getNewTypeContractNumber(proposalBO
							.getOldContrNo(), contractReplacementNo,
							ContractTypeConstants.REPLACEMENT));
					proposalBO.setContrReplNo(contractReplacementNo);
					proposalBO.setContrRenewNo(oldContract.getContrRenewNo());
					if (ProposalTypeConstants.EASII.equals(oldContract
							.getProposalType())) {
						oldContract.setTpContrNo(proposalBO.getContrNo());
					}
					oldContract.setLastUpdatedDate((new java.sql.Date(today
							.getTime())));
					if (null != proposalBO.getContrStartPeriod()) {
						//oldContract.setContrReplDate((new
						// java.sql.Date(proposalHeaderCustomDTO.getBasicProposalCustomDTO().getReplacementContractDate().getTime())));
						oldContract.setContrReplDate(proposalBO
								.getContrStartPeriod());
						OPPTLogger.debug("oldContract.setContrReplDate() : "
								+ oldContract.getContrReplDate(), CLASS_NAME,
								"saveProposal");
					}
					proposalContractBOFactory
							.updateProposalContractBO(oldContract);
					proposalBO.setCreatedDate(new Date(System
							.currentTimeMillis()));

				}
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}
			if (null == proposalBO.getOldContrNo()) {
				// Contract Number Generation
				ProposalContractDTOFactory proposalContractDTOFactory = new ProposalContractDTOFactory();
				try {
					ProposalContractBO maxContractBO = proposalContractBOFactory
							.getProposalContractBOWithMaxContractNumber("P01");
					contractNo = maxContractBO.getContrNo();
				} catch (Exception e3) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							methodName, null, e3);
				}
				proposalBO.setContrNo(contractNo);
			}
			// Save the Proposal
			try {
				ProposalContractBO maxBO = proposalContractBOFactory
						.findMaxProposalContractBO();
				proposalId = maxBO.getProposalId() + 1;
				proposalBO.setProposalId(proposalId);
				OPPTLogger.debug("Dstrchannel:"+proposalBO.getDistrChannel(), CLASS_NAME,"saveProposal");
				OPPTLogger.debug("SalesGroup:"+proposalBO.getSalesGroup(), CLASS_NAME,"saveProposal");
				OPPTLogger.debug("ChannelRole:"+proposalBO.getChannelRole(), CLASS_NAME,"saveProposal");
				OPPTLogger.debug("SubmitterRole:"+proposalBO.getSubmitterRole(), CLASS_NAME,"saveProposal");
				proposalContractBOFactory.createProposalContractBO(proposalBO);
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}
			createAccessHistory(proposalId, userId, "Proposal creation");
		}

		TreeMap customerListMap = proposalHeaderCustomDTO.getCustomerLists();
       //DADO02 
		int proposalId = proposalBO.getProposalId();
		// Loop thro the customer List and add the list to the Database
		if (customerListMap != null && (!proposalBO.isVarianceProposal())) {
			Set keySet = customerListMap.keySet();
			Iterator iter = keySet.iterator();
			while (iter.hasNext()) {
				CustomerListCustomDTO customerListCustomDTO = (CustomerListCustomDTO) customerListMap
						.get(iter.next());

				if (!customerListCustomDTO.isAlreadyExists()) {

					CustomerListBO customerListBO = new CustomerListBO();
					customerListBO.setCustomerListDesc(customerListCustomDTO
							.getListName());
					customerListBO.setCustomerListNo(customerListCustomDTO
							.getListNumber());
					customerListBO.setProposalId(proposalBO.getProposalId());
					customerListBO.setLastUpdatedDate((new java.sql.Date(today
							.getTime())));
					CustomerListBOFactory customerListBOFactory = new CustomerListBOFactory();
					/*DADO02&DADO09 try {
						customerListBOFactory
								.createCustomerListBO(customerListBO);
					} catch (DomainException e1) {
						try {
							mySessionCtx.setRollbackOnly();
						} catch (IllegalStateException ilse) {
							// Nothing will be done
						}
						throw ExceptionGenerator.generateServiceException(e1
								.getErrorReport());
					}*/
				}
				// CustomerList can have selectedCustomers each selected
				// customers should be added to the SoldToPartyTable
				/*TreeMap customerListCustomerMap = customerListCustomDTO
						.getCustomers();*/

				try {
					/*boolean customersAdded = addCustomersToProposals(
							customerListCustomerMap, proposalId,
							customerListCustomDTO.getListNumber(), proposalBO);*/
					boolean customersAdded = addCustomersToProposals(
							customerListCustomDTO, proposalId,proposalBO);
					if (!fetchInventory && customersAdded) {
						fetchInventory = customersAdded;
					}

				} catch (ServiceException se) {
					try {
						getSessionContext().setRollbackOnly();
					} catch (IllegalStateException ilse) {
						//	Nothing will be done
					}
					throw se;
				}

			} // End of customerList
		}

		List altPartnerList = proposalHeaderCustomDTO.getAlternatePartnerList();
		InventoryManagerLocal inventoryManagerLocal = getInventoryManagerLocal();
		OPPTLogger.debug("altPartnerList = " + altPartnerList, CLASS_NAME,
				"saveProposal");

		// Alternate Partner

		// If we have alternate STP then that should be also added to STP table
		CustomerDomainDTO customer = new CustomerDomainDTO();
		customer.setProposalId(proposalBO.getProposalId());
		customer.setSapCustomerNo(proposalBO.getRegCustomerNo());
		customer.setCustmerASNo(proposalBO.getRegCustomerASNo());
		customer.setLegacyCustomerNo(proposalBO.getRegCustomerLegNo());
		customer.setSapCustomerName(proposalBO.getRegCustomerName());
		customer.setLastUpdatedDate((new java.sql.Date(today.getTime())));
		customer.setPlanStartDate(proposalBO.getContrStartPeriod());
		customer.setPlanEndDate(proposalBO.getContrEndPeriod());
		/* Changed for EF0607044559S by Sara on June 16,2004 */
		PartnerInformationCustomDTO partnerDTO = proposalHeaderCustomDTO
				.getPartnerInformationCustomDTO();
		ESWCustomerCustomDTO customerDTO = partnerDTO.getSoldToParty();
		customer.setCountryCode(customerDTO.getCountryCode());
		/* EF0607044559E */
		try {
			/* CR6153 start change */
			if ((proposalBO.getExtendPeriod() != null)
					&& (proposalBO.getExtendPeriod()
							.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {

				int contractDurationMonths = OPPTCalender
						.calculateContractPeriodDuration(proposalBO
								.getContrStartDate(), proposalBO
								.getContrEndDate());
				int contractDurationYears = contractDurationMonths / 12;
				CustomerDomainDTO customerDomainDTO = null;
				if (contractDurationMonths % 12 > 0) {
					customerDomainDTO = new CustomerDomainDTO();
					customerDomainDTO.setProposalId(proposalId);
					customerDomainDTO.setCustomerListNo(customer
							.getCustomerListNo());
					customerDomainDTO.setCustmerASNo(customer.getCustmerASNo());
					customerDomainDTO.setLegacyCustomerNo(customer
							.getLegacyCustomerNo());
					customerDomainDTO.setSapCustomerName(customer
							.getSapCustomerName());
					customerDomainDTO.setSapCustomerNo(customer
							.getSapCustomerNo());
					customerDomainDTO.setLastUpdatedDate((new java.sql.Date(
							today.getTime())));
					customerDomainDTO.setCountryCode(customer.getCountryCode()); /*
																				  * Changed
																				  * for
																				  * EF0607044559
																				  * by
																				  * Sara
																				  * on
																				  * June
																				  * 16,2004
																				  */

					if (null != proposalBO) {
						customerDomainDTO.setPlanStartDate(proposalBO
								.getContrStartPeriod());
						customerDomainDTO.setPlanEndDate(proposalBO
								.getContrEndPeriod());
					}
					if (!inventoryManagerLocal
							.isCustomerAvailableForProposalPlanStartEndDate(customerDomainDTO)) {

						inventoryManagerLocal
								.addCustomersToProposalSAndSExtended(customerDomainDTO);

						fetchInventory = true;
					}

					for (int i = 0; i < contractDurationYears; i++) {
						customerDomainDTO = new CustomerDomainDTO();
						customerDomainDTO.setProposalId(proposalId);
						customerDomainDTO.setCustomerListNo(customer
								.getCustomerListNo());
						customerDomainDTO.setCustmerASNo(customer
								.getCustmerASNo());
						customerDomainDTO.setLegacyCustomerNo(customer
								.getLegacyCustomerNo());
						customerDomainDTO.setSapCustomerName(customer
								.getSapCustomerName());
						customerDomainDTO.setSapCustomerNo(customer
								.getSapCustomerNo());
						customerDomainDTO
								.setLastUpdatedDate((new java.sql.Date(today
										.getTime())));
						customerDomainDTO.setCountryCode(customer
								.getCountryCode());

						if (null != proposalBO) {
							java.util.Date startPeriod1 = OPPTCalender.addDate(
									OPPTCalender.DATE, 1, proposalBO
											.getContrEndPeriod());
							java.util.Date startPeriod = OPPTCalender.addDate(
									OPPTCalender.YEAR, i, startPeriod1);
							java.util.Date endPeriod = OPPTCalender.addDate(
									OPPTCalender.YEAR, i + 1, proposalBO
											.getContrEndPeriod());

							customerDomainDTO
									.setPlanStartDate(new java.sql.Date(
											startPeriod.getTime()));
							customerDomainDTO.setPlanEndDate(new java.sql.Date(
									endPeriod.getTime()));
						}
						if (!inventoryManagerLocal
								.isCustomerAvailableForProposalPlanStartEndDate(customerDomainDTO)) {

							inventoryManagerLocal
									.addCustomersToProposalSAndSExtended(customerDomainDTO);

							fetchInventory = true;
						}

					}//End of for-loop

				}
				//if contractDurationMonths % 12 == 0
				else {
					for (int i = 0; i < contractDurationYears; i++) {
						customerDomainDTO = new CustomerDomainDTO();
						customerDomainDTO.setProposalId(proposalId);
						customerDomainDTO.setCustomerListNo(customer
								.getCustomerListNo());
						customerDomainDTO.setCustmerASNo(customer
								.getCustmerASNo());
						customerDomainDTO.setLegacyCustomerNo(customer
								.getLegacyCustomerNo());
						customerDomainDTO.setSapCustomerName(customer
								.getSapCustomerName());
						customerDomainDTO.setSapCustomerNo(customer
								.getSapCustomerNo());
						customerDomainDTO
								.setLastUpdatedDate((new java.sql.Date(today
										.getTime())));
						customerDomainDTO.setCountryCode(customer
								.getCountryCode());

						if (null != proposalBO) {
							java.util.Date startPeriod = OPPTCalender.addDate(
									OPPTCalender.YEAR, i, proposalBO
											.getContrStartPeriod());
							java.util.Date endPeriod = OPPTCalender.addDate(
									OPPTCalender.YEAR, i, proposalBO
											.getContrEndPeriod());

							customerDomainDTO
									.setPlanStartDate(new java.sql.Date(
											startPeriod.getTime()));
							customerDomainDTO.setPlanEndDate(new java.sql.Date(
									endPeriod.getTime()));
						}
						if (!inventoryManagerLocal
								.isCustomerAvailableForProposalPlanStartEndDate(customerDomainDTO)) {

							inventoryManagerLocal
									.addCustomersToProposalSAndSExtended(customerDomainDTO);

							fetchInventory = true;
						}

					}//End of for-loop

				}

			} else {
				/* CR6153 end change */
				if (!inventoryManagerLocal
						.isCustomerAvailableForProposal(customer)) {
					// This is alternate STP we do not have it in Customer Table
					inventoryManagerLocal.addCustomersToProposal(customer);
					fetchInventory = true;
				}
			}
		} catch (ServiceException se) {
			try {
				getSessionContext().setRollbackOnly();
			} catch (IllegalStateException ilse) {
				//Nothing will be done
			}
			throw se;
		}
		// Save Proposal
		if (!changeProposal) {
			proposalCustomDTO = new ProposalCustomDTO();
		}

		if (changeProposal) {
			if (ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS
					.equals(proposalBO.getStatusCode())) {
				proposalHeaderCustomDTO.setProposalDetails(false);
			} else {
				proposalHeaderCustomDTO.setProposalDetails(true);
				OPPTLogger.debug("FETCH INVENTORY = " + fetchInventory,
						CLASS_NAME, "saveProposal");
				proposalHeaderCustomDTO.setFetchInventory(fetchInventory);
			}

			/* CR6153 start change */
			OPPTCalender calender = new OPPTCalender();
			if ((proposalBO.getExtendPeriod() != null)
					&& (proposalBO.getExtendPeriod()
							.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {
				if (proposalHeaderCustomDTO.getBasicProposalCustomDTO()
						.isChangeDate()) {
					populateCustomerForAllYears(proposalBO);
				}
			}
			/* CR6153 end change */
			//  removeAlternatePartner(proposalBO); DADO02 Sateesh Anne BlueHarmony
		}
		//DADO01 Sateesh Anne BlueHarmony
		try{
			List customerBOList = customerBOFactory.findCustomerBOforProposal(proposalId,1);
			List selectedCustomers = new ArrayList();
			if(null!=customerBOList && customerBOList.size()>0){
				Iterator iterator = customerBOList.iterator();
				while(iterator.hasNext()){
					CustomerBO customerBO = (CustomerBO)iterator.next();

					CustomerListCustomDTO customerListCustomDTO  =  new CustomerListCustomDTO();
					customerListCustomDTO.setCustomerName(customerBO.getSapCustomerName());
					customerListCustomDTO.setCustomerNumber(customerBO.getSapCustomerNo());

					selectedCustomers.add(customerListCustomDTO);
				}
				proposalHeaderCustomDTO.setSelectedCustomers(selectedCustomers);
			}
		}catch(DomainException e){
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());

		}//DADO02


		if (changeProposal && proposalBO.isVarianceProposal()) {
			proposalHeaderCustomDTO.setProposalDetails(true);
			proposalHeaderCustomDTO.setFetchInventory(false);
		}

		proposalCustomDTO.setId(proposalId);
		proposalCustomDTO.setStatus(proposalBO.getStatusCode());
		proposalCustomDTO.setAccess(proposalBO.getProposalSharing());
		proposalCustomDTO.setLockedBy(proposalBO.getLockedBy());
		proposalCustomDTO.setOldContractNumber(proposalBO.getOldContrNo());
		proposalHeaderCustomDTO.setProposal(proposalCustomDTO);
		log.end();
		return proposalHeaderCustomDTO;
	}

	/**
	 *
	 * Common method to throw BackendException <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 8, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param errorCode
	 * @throws ServiceException
	 * @author balajiv
	 */
	private void throwServiceException(String errorCode, int messageType)
			throws ServiceException {
		if (messageType == OPPTMessageCatalog.TYPE_BACKEND) {
			OPPTLogger.debug("Message Code = " + errorCode, CLASS_NAME,
					"throwServiceException");
			try {
				Integer.parseInt(errorCode);
			} catch (NumberFormatException ne) {
				errorCode = ErrorCodeConstants.CE0801;
			} catch (Exception e) {
				errorCode = ErrorCodeConstants.CE0801;
			}
		}
		ErrorReport errorReport = new ErrorReport();
		ErrorKey key = new ErrorKey(errorCode, messageType);
		errorReport.addErrorEntry(key, null);
		ServiceException se = new ServiceException();
		se.setErrorReport(errorReport);
		throw se;
	}

	/**
	 *
	 * Common method to throw BackendException <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 8, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public List checkForProposalsForCreateApprove(String userId, String role)
			throws ServiceException {
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		List checkForProposalsForCreateApproveList = null;
		if (role.equals(new Integer(RoleConstants.PROPOSAL_APPROVER))) {
			try {
				checkForProposalsForCreateApproveList = proposalContractBOFactory
						.findProposalContractWaitingForApprovalForProposalApprover(userId);
				//Done
			} catch (DomainException ex) {
				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}
		} else {
			try {
				checkForProposalsForCreateApproveList = proposalContractBOFactory
						.findProposalContractWaitingForCSOAndMark(userId);
				//Done
			} catch (DomainException ex) {

				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}
		}
		return checkForProposalsForCreateApproveList;
	}

	/**
	 *
	 * Common method to throw BackendException <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 8, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param errorCode
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public List checkForProposalsForApproverAndManager(String userId)
			throws ServiceException {
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		List checkForProposalsForApproverAndManagerList = new ArrayList();
		try {
			checkForProposalsForApproverAndManagerList = proposalContractBOFactory
					.findProposalsContractsBOForUsers(userId);

		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}
		return checkForProposalsForApproverAndManagerList;
	}

	/**
	 *
	 * Common method to throw BackendException <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 8, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param errorCode
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public List checkForProposalsForCSOAndMarkAndManager(String userId,
			String role) throws ServiceException {
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		List checkForProposalsForCSOAndMarkAndManagerList = null;
		if (role.equals(new Integer(RoleConstants.CREATE_APPROVE).toString())) {
			try {
				checkForProposalsForCSOAndMarkAndManagerList = proposalContractBOFactory
						.findProposalContractWaitingForApprovalForCreateApprove(userId);
				//Done
			} catch (DomainException ex) {

				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}
		} else {
			try {
				checkForProposalsForCSOAndMarkAndManagerList = proposalContractBOFactory
						.findProposalContractWaitingForApproval(userId);
				//Done
			} catch (DomainException ex) {

				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}
		}
		return checkForProposalsForCSOAndMarkAndManagerList;
	}

	/**
	 *
	 * This method checks the pre-condition for the delta-fetch before
	 * initiating delta fetch request <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Nov 29, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalCustomDTO
	 */
	public ProposalCustomDTO canDeltaFetchBePerformed(
			ProposalCustomDTO proposalCustomDTO) throws ServiceException {
		int proposalId = 0;
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		proposalId = proposalCustomDTO.getId();
		ContractBO contractBO = null;
		try {
			contractBO = (ContractBO) proposalContractBOFactory
					.getProposalContractBO(proposalId);
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de
					.getErrorReport());
		}

		boolean preCondtn = false;
		HashMap map = new HashMap();

		try {
			map.put(UtilityConstants.BO_USERID, proposalCustomDTO.getUserId());
			map.put(UtilityConstants.BO_GROUPNAME, proposalCustomDTO
					.getGroupName());
			SharingBO sharingBO = getSharingBOFromFactory(contractBO
					.getProposalId(), proposalCustomDTO.getUserId());
			if (null != sharingBO) {
				map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}
			contractBO.validateDeltaFetch(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);

		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		return proposalCustomDTO;
	}

	/**
	 *
	 * This method process the delta-fetch request <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Nov 29, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalCustomDTO
	 */
	public DeltaFetchCustomDTO deltaFetch(
			DeltaFetchCustomDTO deltaFetchCustomDTO) throws ServiceException {

		String methodName = "deltaFetch";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		//bean instances
		InventoryManagerLocal inventoryManagerLocal = null;
		JMSConnectorLocalHome jmsConnectorLocalHome = null;
		JMSConnectorLocal jmsConnectorLocal = null;
		//method variable
		int proposalId = 0;
		ProposalDomainDTO proposalDomainDTO = null;
		CustomerDomainDTO customerDomainDTO = null;
		List customerDomainDTOList = null;
		ProposalCustomDTO proposalCustomDTO = null;
		ContractBO contractBO = null;
		boolean custChanged = false;
		//connecto dto instances
		ConnectorDTOInterface connectorDTO = null;
		RetrieveInvenDetailInputConnectorDTO retrieveInventoryDetailInputConnectorDTO = null;
		RetrieveDeltaInventoryInputConnectorDTO retrieveDeltaInventoryInputConnectorDTO = null;
		RetrieveInvenDetailOutputConnectorDTO retrieveInvenDetailOutputConnectorDTO = null;
		RetrieveDeltaInventoryOutputConnectorDTO retrieveDeltaInventoryOutputConnectorDTO = null;

		//factory instances
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		proposalCustomDTO = deltaFetchCustomDTO.getProposalDTO();
		proposalId = proposalCustomDTO.getId();
		boolean isSkip = false;
		isSkip = deltaFetchCustomDTO.isSkip();
		OPPTLogger.debug("Skip option is" + isSkip, CLASS_NAME, methodName);
		contractBO = null;
		try {
			contractBO = (ContractBO) proposalContractBOFactory
					.getProposalContractBO(proposalId);
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de
					.getErrorReport());
		}
		try {

			HashMap map = new HashMap();
			map
					.put(UtilityConstants.BO_USERID, deltaFetchCustomDTO
							.getUserId());
			map.put(UtilityConstants.BO_GROUPNAME, deltaFetchCustomDTO
					.getGroupName());
			SharingBO sharingBO = getSharingBOFromFactory(contractBO
					.getProposalId(), deltaFetchCustomDTO.getUserId());
			if (null != sharingBO) {
				map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}
			contractBO.validateDeltaFetch(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}

		proposalDomainDTO = new ProposalDomainDTO(contractBO);
		try {
			inventoryManagerLocal = getInventoryManagerLocal();
			proposalDomainDTO = inventoryManagerLocal
					.retrieveCustomerForProposal(proposalDomainDTO);
			List customerNoList = new ArrayList();
			if (proposalDomainDTO != null
					&& proposalDomainDTO.getCustomerDTOList() != null) {
				for (int i = 0; i < proposalDomainDTO.getCustomerDTOList()
						.size(); i++) {
					customerDomainDTO = (CustomerDomainDTO) proposalDomainDTO
							.getCustomerDTOList().get(i);
					customerNoList.add(customerDomainDTO.getSapCustomerNo());
				}
			}
			jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
			if (!isSkip) {
				//Create the connector DTO Object and set the values
				retrieveInventoryDetailInputConnectorDTO = InputConnectorDTOBuildHelper
						.buildRetrieveInvenDetailInputConnectorDTO(
								proposalDomainDTO, deltaFetchCustomDTO
										.getSessionId(), deltaFetchCustomDTO
										.getUserId(), false, false,
								customerNoList, custChanged, null);
				retrieveInvenDetailOutputConnectorDTO = (RetrieveInvenDetailOutputConnectorDTO) jmsConnectorLocal
						.sendReceive(retrieveInventoryDetailInputConnectorDTO);

			} else {

				retrieveDeltaInventoryInputConnectorDTO = InputConnectorDTOBuildHelper
						.buildRetrieveDeltaInventoryInputConnectorDTO(
								proposalDomainDTO, deltaFetchCustomDTO
										.getSessionId(), deltaFetchCustomDTO
										.getUserId(), customerNoList);
				retrieveDeltaInventoryOutputConnectorDTO = (RetrieveDeltaInventoryOutputConnectorDTO) jmsConnectorLocal
						.sendReceive(retrieveDeltaInventoryInputConnectorDTO);

			}

		} catch (Exception e) {
			throwServiceException(ErrorCodeConstants.SE0801,
					OPPTMessageCatalog.TYPE_SERVICE);
		}

		if (retrieveInvenDetailOutputConnectorDTO != null
				&& ConnectorConstants.RFC_SUCCESS_CODE
						.equals(retrieveInvenDetailOutputConnectorDTO
								.getReturnCode())) {
			int decimalValue = 0;
			try {
				ProposalDataManagerLocal proposalDataManagerLocal = HomeProvider
						.getProposalDataManagerLocal();
				if (contractBO.getCurrency() != null) {
					CurrencyDomainDTO currencyDomainDTO = proposalDataManagerLocal
							.getCurrencyInformation(contractBO.getCurrency());
					decimalValue = currencyDomainDTO.getDecimalAllowed();
				}
			} catch (CreateException c) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						"Delta-Fetch Inventory", null, c);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}
			DomainDTOBuildHelper.populateProposalDomainDTO(proposalDomainDTO,
					retrieveInvenDetailOutputConnectorDTO, null, isSkip,
					decimalValue, true);
			//DomainDTOBuildHelper.validatePlanDates(proposalDomainDTO);
			contractBO.setEswFetchDate(new Date(
					retrieveInvenDetailOutputConnectorDTO.getSystemDate()
							.getTime()));
			contractBO
					.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
			contractBO.setInvoiceAmount(0.0);
			contractBO.setEswFetchTime(retrieveInvenDetailOutputConnectorDTO
					.getSystemTime());

		} else if (retrieveInvenDetailOutputConnectorDTO != null
				&& UtilityConstants.NO_INVENTORY_AVAIL_CODE
						.equals(retrieveInvenDetailOutputConnectorDTO
								.getReturnCode())) {
			storeErrorList(UtilityConstants.NO_DE_INVENTORY_AVAIL_CODE,
					proposalId, deltaFetchCustomDTO.getUserId(),
					"Delta-Fetch Inventory");
			deltaFetchCustomDTO.addMessageEntry(
					UtilityConstants.NO_DE_INVENTORY_AVAIL_CODE,
					OPPTMessageCatalog.TYPE_BACKEND);

		} else {
			if (retrieveInvenDetailOutputConnectorDTO != null) {
				storeErrorList(retrieveInvenDetailOutputConnectorDTO
						.getReturnCode(), proposalId, deltaFetchCustomDTO
						.getUserId(), "Delta-Fetch Inventory");
				throwServiceException(retrieveInvenDetailOutputConnectorDTO
						.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
			}
		}

		if (retrieveDeltaInventoryOutputConnectorDTO != null
				&& ConnectorConstants.RFC_SUCCESS_CODE
						.equals(retrieveDeltaInventoryOutputConnectorDTO
								.getReturnCode())) {
			int decimalValue = 0;
			try {
				ProposalDataManagerLocal proposalDataManagerLocal = HomeProvider
						.getProposalDataManagerLocal();
				if (contractBO.getCurrency() != null) {
					CurrencyDomainDTO currencyDomainDTO = proposalDataManagerLocal
							.getCurrencyInformation(contractBO.getCurrency());
					decimalValue = currencyDomainDTO.getDecimalAllowed();
				}
			} catch (CreateException c) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						"Delta-Fetch Inventory", null, c);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}
			DomainDTOBuildHelper.populateProposalDomainDTO(proposalDomainDTO,
					retrieveDeltaInventoryOutputConnectorDTO, null, isSkip,
					decimalValue, true);
			//DomainDTOBuildHelper.validatePlanDates(proposalDomainDTO);
			contractBO.setEswFetchDate(new Date(
					retrieveInvenDetailOutputConnectorDTO.getSystemDate()
							.getTime()));
			contractBO
					.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
			contractBO.setInvoiceAmount(0.0);
			contractBO.setEswFetchTime(retrieveInvenDetailOutputConnectorDTO
					.getSystemTime());

		} else if (retrieveDeltaInventoryOutputConnectorDTO != null
				&& UtilityConstants.NO_INVENTORY_AVAIL_CODE
						.equals(retrieveDeltaInventoryOutputConnectorDTO
								.getReturnCode())) {
			storeErrorList(UtilityConstants.NO_DE_INVENTORY_AVAIL_CODE,
					proposalId, deltaFetchCustomDTO.getUserId(),
					"Delta-Fetch Inventory");
			deltaFetchCustomDTO.addMessageEntry(
					UtilityConstants.NO_DE_INVENTORY_AVAIL_CODE,
					OPPTMessageCatalog.TYPE_BACKEND);
		} else {
			if (retrieveDeltaInventoryOutputConnectorDTO != null) {
				storeErrorList(retrieveDeltaInventoryOutputConnectorDTO
						.getReturnCode(), proposalId, deltaFetchCustomDTO
						.getUserId(), "Delta-Fetch Inventory");
				throwServiceException(retrieveDeltaInventoryOutputConnectorDTO
						.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
			}
		}
		OPPTLogger.debug("Customer size:"
				+ proposalDomainDTO.getCustomerDTOList().size(), CLASS_NAME,
				methodName);
		if (proposalDomainDTO.getCustomerDTOList().size() > 0) {
			customerDomainDTOList = proposalDomainDTO.getCustomerDTOList();
			Iterator iterateCustomer = customerDomainDTOList.iterator();
			while (iterateCustomer.hasNext()) {
				customerDomainDTO = (CustomerDomainDTO) iterateCustomer.next();
				try {
					inventoryManagerLocal
							.replaceSkipLicenses(customerDomainDTO);
				} catch (ServiceException se) {
					getSessionContext().setRollbackOnly();
					throw se;
				}
			}
			//update the proposalBO
			contractBO.setFetchDate(new Date(new java.util.Date().getTime()));
			contractBO.setDeltaFetchId(UtilityConstants.YES);
			try {

				proposalContractBOFactory.updateProposalContractBO(contractBO);

			} catch (DomainException d) {
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());
			}
		}
		timeTaken.end();
		return deltaFetchCustomDTO;
	}

	/**
	 * This method is to register a proposal/contract. <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param RegistrationCustomDTO
	 * @return RegistrationCustomDTO
	 * @throws ServiceException
	 * @author Prakash Mall
	 */
	public RegistrationCustomDTO getRegistrationData(
			RegistrationCustomDTO registrationCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "getRegistationData");
		// system.out.println("IN PROPOSAL MANAGER BEANS getRegistrationdata method");
		String salesOrg = null;
		ProposalBO proposalBO = null;
		int proposalContractID = registrationCustomDTO.getProposalDTO().getId();
		String loggedInUser = registrationCustomDTO.getUserId();

		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();

		ProposalContractBO proposalContractBO = null;
		HashMap compareValues = null;
		SharingBO shareBO = null;

		try {
			shareBO = getSharingBOFromFactory(proposalContractID, loggedInUser);
			proposalContractBO = getProposalContractBOFromFactory(proposalContractID);
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					registrationCustomDTO, shareBO);
		} catch (DomainException ex) {
			throwServiceException(ex.getErrorReport());
		}

		if (proposalContractBO.isProposal()) {
			proposalBO = (ProposalBO) proposalContractBO;

			try {
				proposalBO.validateForRegistration(
						UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
						compareValues);
			} catch (DomainException ex) {
				throwServiceException(ex.getErrorReport());
			}

			InventoryManagerLocal inventoryManagerLocal = getInventoryManagerLocal();

			salesOrg = proposalBO.getSalesOrg();
			boolean svcLicenseExist = false;
			boolean quoteExist = false;
			boolean sandsLicense = false;

			if (!proposalBO.isProposalType(ProposalTypeConstants.EASII)) {
				// check if SVC license exist for the proposal
				svcLicenseExist = inventoryManagerLocal
						.isSVCLicenseExistsForProposal(proposalBO
								.getProposalId(),
								UtilityConstants.SVCLICENSE_EXIST);
				// check if Quote exists for the proposal
				quoteExist = inventoryManagerLocal
						.isSVCLicenseExistsForProposal(proposalBO
								.getProposalId(), UtilityConstants.QUOTE_EXIST);
			}

			sandsLicense = inventoryManagerLocal
					.isSandSLicenseExistForProposal(proposalBO.getProposalId(),
							LicenseConstants.SS_LICENSE_FLAG);

			compareValues.put(UtilityConstants.SVCLICENSE_EXIST, new Boolean(
					svcLicenseExist));
			compareValues.put(UtilityConstants.QUOTE_EXIST, new Boolean(
					quoteExist));
			compareValues.put(UtilityConstants.SANDS_IND, new Boolean(
					sandsLicense));

			boolean canProposalBeRegistered = false;
			try {
				canProposalBeRegistered = proposalBO
						.validateForRegistration(
								UtilityConstants.BUSINESSRULE_OTHER_TYPE,
								compareValues);
			} catch (DomainException se) {
				throwServiceException(se.getErrorReport());
			}

		} else {

			ContractBO contractBO = null;
			contractBO = (ContractBO) proposalContractBO;

			salesOrg = contractBO.getSalesOrg();

			OPPTLogger.debug("Contract Extension Date is "
					+ registrationCustomDTO.getExtensionDate() + "#",
					CLASS_NAME, "getRegistrationData");
			if (null != registrationCustomDTO.getExtensionDate()) {
				compareValues.put(UtilityConstants.CONTRACT_EXTEND_DATE,
						registrationCustomDTO.getExtensionDate());
			}
			InventoryManagerLocal inventoryManagerLocal = getInventoryManagerLocal();
			boolean svcLicenseExist = false;
			//	Check if SVC license exist for the proposal
			svcLicenseExist = inventoryManagerLocal
					.isSVCLicenseExistsForProposal(contractBO.getProposalId(),
							UtilityConstants.SVCLICENSE_EXIST);
			compareValues.put(UtilityConstants.SVCLICENSE_EXIST, new Boolean(
					svcLicenseExist));
			try {
				contractBO.validateForRegistration(
						UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
						compareValues);
			} catch (DomainException ex) {
				throwServiceException(ex.getErrorReport());
			}

			try {
				if (ContractTypeConstants.VARIANCE.equals(contractBO
						.getContrType())) {
					// get the original contract for this variance contract
					ContractBO cntrBO = (ContractBO) proposalContractBOFactory
							.getProposalContractBOForContractNumber(contractBO
									.getOrgVarContrNo(), UtilityConstants.TRUE);
					compareValues.put(UtilityConstants.CONTRPERIOD_VARNO,
							new Integer(cntrBO.getContrPeriodVarNo()));
					OPPTLogger.debug("UtilityConstants.CONTRPERIOD_VARNO: #"
							+ UtilityConstants.CONTRPERIOD_VARNO + "#",
							CLASS_NAME, "getRegistrationData");
					OPPTLogger.debug("cntrBO.getContrPeriodVarNo()): #"
							+ cntrBO.getContrPeriodVarNo() + "#", CLASS_NAME,
							"getRegistrationData");

					compareValues.put(UtilityConstants.STATUS, cntrBO
							.getStatusCode());
				}

				contractBO
						.validateForRegistration(
								UtilityConstants.BUSINESSRULE_OTHER_TYPE,
								compareValues);

			} catch (DomainException ex) {
				throwServiceException(ex.getErrorReport());
			}
		}

		UserManagerLocal userManagerLocal = getUserManagerLocal();

		List userProfileDomainDTOList = userManagerLocal.getEligibleApprover();
		// Iterator userProfileBOListIterator = userProfileBOList.iterator();
		for (int i = 0, size = userProfileDomainDTOList.size(); i < size; i++) {
			UserProfileDomainDTO userProfileDomainDTO = (UserProfileDomainDTO) userProfileDomainDTOList
					.get(i);

			OPPTLogger.debug("User for Approval [From DB] : #"
					+ userProfileDomainDTO.getUserId() + "#", CLASS_NAME,
					"getRegistrationData");
			// Fallout of MN22122958 in 51x Starts Balaji
			if (((userProfileDomainDTO.getRole() == RoleConstants.PROPOSAL_APPROVER) || (userProfileDomainDTO
					.getRole() == RoleConstants.CREATE_APPROVE && !isUserAccessHistoryPresent(
					proposalContractID, userProfileDomainDTO.getUserId())))
					&& !userProfileDomainDTO.getUserId().equals(
							registrationCustomDTO.getUserId())) {
				// MN22122958 Ends Balaji
				registrationCustomDTO.addApproverId(userProfileDomainDTO
						.getUserId(), userProfileDomainDTO.getUserId());
				OPPTLogger.debug(
						"User for Approval [RegistrationCustomDTO] : #"
								+ userProfileDomainDTO.getUserId() + "#",
						CLASS_NAME, "getRegistrationData");
			}
		}

		registrationCustomDTO.setBillingFrequency(proposalContractBO
				.getBillingFreqCode());
		registrationCustomDTO
				.setContractType(proposalContractBO.getContrType());
		registrationCustomDTO
				.setContractNumber(proposalContractBO.getContrNo());
		registrationCustomDTO.setExternalContractNumber(proposalContractBO
				.getExtContrNo());

		if (registrationCustomDTO.isVarianceContractClosure()) {
			registrationCustomDTO.setVarianceDate(proposalContractBO
					.getVarDate());
			registrationCustomDTO.setConractClosureDate(OPPTCalender
					.getDayMinusOneSqlDate(proposalContractBO
							.getContrStartPeriod()));
		}

		log.end();
		return registrationCustomDTO;
	}

	//	Create an instance of AccessHistoryBOFactory. This will be used in the
	// validation below.
	private boolean isUserAccessHistoryPresent(int proposalID, String userID)
			throws ServiceException {
		boolean isUserAccessHistoryPresent = true;
		AccessHistoryBOFactory accessHistoryBOFactory = null;
		accessHistoryBOFactory = new AccessHistoryBOFactory();

		List accessHisList = new ArrayList();

		try {
			accessHisList = accessHistoryBOFactory
					.findAccessHistoryForProposal(proposalID, userID);
		} catch (DomainException ex) {
			isUserAccessHistoryPresent = false;
		}

		if (null == accessHisList) {
			isUserAccessHistoryPresent = false;
		} else {
			if (null != accessHisList && 0 == accessHisList.size()) {
				isUserAccessHistoryPresent = false;
			} else {
				Iterator iter = accessHisList.iterator();
				while (iter.hasNext()) {
					AccessHistoryBO historyBO = (AccessHistoryBO) iter.next();
					if (UtilityConstants.REQUEST_APPROVED.equals(historyBO
							.getOperationPerformed().trim())
							|| UtilityConstants.REQUEST_REJECT.equals(historyBO
									.getOperationPerformed().trim())) {
						isUserAccessHistoryPresent = false;
					} else {
						isUserAccessHistoryPresent = true;
					}
				}
			}
		}
		return isUserAccessHistoryPresent;

	}

	/**
	 * Method to Register a Proposal/Contract <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param RegistrationCustomDTO
	 * @return void
	 * @throws ServiceException
	 * @author Prakash Mall
	 */

	public RegistrationCustomDTO proposalRegistration(RegistrationCustomDTO registrationCustomDTO) throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "proposalRegistration");

		OPPTCalender calendar = new OPPTCalender();
		boolean approverSelected = false;

		CustomerDomainDTO customerDomainDTO = null;
		ErrorReport errorReport = new ErrorReport();
		// verify if the required approvers are selected	
		
/*	Commented for the change DAD O11 Remove approval step,Blue Harmony -by Ramesh Gandi
	 	if (null == registrationCustomDTO.getSelectedApproverId()) {
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0401);
		} else {
			approverSelected = true;
		}

		// Verify if the Selected approver has the authority to approver
		if (approverSelected) {  
		
*/
			ProposalBO proposalBO = null;

			int proposalContractID = registrationCustomDTO.getProposalDTO().getId();
		
			OPPTLogger.debug("proposalRegistration:proposalContractID = " + proposalContractID, CLASS_NAME, "proposalRegistration");
			ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
			ProposalContractBO proposalContractBO = null;
			try {
				proposalContractBO = proposalContractBOFactory
						.getProposalContractBO(proposalContractID);
			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de
						.getErrorReport());
			}
			
/*	Commented for the change DAD O11 Remove approval step,Blue Harmony -by Ramesh Gandi
			ProposalDomainDTO proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);

			InventoryManagerLocal inventoryManagerLocal = getInventoryManagerLocal();
			ProposalDomainDTO propDomainDTO = inventoryManagerLocal
					.retrieveCustomerForProposal(proposalDomainDTO);
			List customerDomainDTOList = propDomainDTO.getCustomerDTOList();

			ValidateUserAccessInputConnectorDTO inputConnectorDTO = InputConnectorDTOBuildHelper
					.buildValidateUserAccessInputConnectorDTO(
							proposalDomainDTO, registrationCustomDTO,
							customerDomainDTOList);

			JMSConnectorLocal jmsConnectorLocal = null;
			ValidateUserAccessOutputConnectorDTO validateUserAccessOutputConnectorDTO = new ValidateUserAccessOutputConnectorDTO();
			try {
				jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
				validateUserAccessOutputConnectorDTO = (ValidateUserAccessOutputConnectorDTO) jmsConnectorLocal
						.sendReceive(inputConnectorDTO);
			} catch (CreateException e) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			} catch (Exception ex) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}

			if (!ConnectorConstants.RFC_SUCCESS_CODE
					.equals(validateUserAccessOutputConnectorDTO
							.getReturnCode())) {

				storeErrorList(validateUserAccessOutputConnectorDTO
						.getReturnCode(), proposalContractID,
						registrationCustomDTO.getUserId(),
						"ProposalRegistration");
				throwServiceException(validateUserAccessOutputConnectorDTO
						.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
			}

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(validateUserAccessOutputConnectorDTO.getReturnCode())) {
*/	
			// Bug fix for approved by 
				OPPTLogger.debug("registrationCustomDTO.getSelectedApproverId() = " + registrationCustomDTO.getSelectedApproverId(), CLASS_NAME, "RegisterProposal");
				OPPTLogger.debug("registrationCustomDTO.getSelectedApproverId() = " +registrationCustomDTO.getUserId(), CLASS_NAME, "RegisterProposal");

				//proposalContractBO.setApprovedBy(registrationCustomDTO.getSelectedApproverId()); //Commented by ramesh 
				proposalContractBO.setSubmittedBy(registrationCustomDTO.getUserId());

				OPPTLogger.debug("proposalContractBO.getStatusCode()= " +proposalContractBO.getStatusCode(), CLASS_NAME, "RegisterProposal");
				if (ProposalContractStatusConstants.PRICED.equals(proposalContractBO.getStatusCode())) {
					OPPTLogger.debug("in PRICED", CLASS_NAME, "RegisterProposal");
					//proposalContractBO.setStatusCode(ProposalContractStatusConstants.PENDING_APPROVAL); commented by Ramesh 
				}

				if (ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT.equals(proposalContractBO.getStatusCode())) {
					OPPTLogger.debug("in AMENDED_PRICED_CONTRACT", CLASS_NAME, "RegisterProposal");
					//proposalContractBO.setStatusCode(ProposalContractStatusConstants.AMENDED_CONTRACT_PENDING_APPROVAL); commented by Ramesh
				}

				if (ProposalContractStatusConstants.VARIANCE_CONTRACT.equals(proposalContractBO.getStatusCode())) {
					OPPTLogger.debug("in VARIANCE_CONTRACT", CLASS_NAME, "RegisterProposal");
					proposalContractBO.setContrClsDate(OPPTCalender.convertToSQLDate(registrationCustomDTO.getConractClosureDate()));
					//proposalContractBO.setStatusCode(ProposalContractStatusConstants.VARIANCE_CLOSURE_PENDING_APROVAL);  commented by Ramesh
				}
				// check for Contract Extension
				//java.util.Date cntrPeriodEnd = OPPTCalender.addDate(Calendar.MONTH, 3, proposalContractBO.getContrEndPeriod());

				OPPTLogger.debug("registrationCustomDTO.getExtensionDate = " + registrationCustomDTO.getExtensionDate(), CLASS_NAME, "RegisterProposal");
				//OPPTLogger.debug("Contract Period End date = " + proposalContractBO.getContrEndPeriod(), CLASS_NAME, "RegisterProposal");

				if (ProposalContractStatusConstants.CONTRACT.equals(proposalContractBO.getStatusCode()) || ContractTypeConstants.EXTENDED.equals(proposalContractBO.getContrType())) {
					OPPTLogger.debug("in Contract or Extended"+proposalContractBO.getStatusCode(), CLASS_NAME, "RegisterProposal");
					if (null != registrationCustomDTO.getExtensionDate()) {
						OPPTLogger.debug("Updating values for Contract Extension", CLASS_NAME, "RegisterProposal");

						proposalContractBO.setContrType(ContractTypeConstants.EXTENDED);
						proposalContractBO.setContrRetrDate(proposalContractBO.getContrEndPeriod());
						proposalContractBO.setContrExtDate(new Date(registrationCustomDTO.getExtensionDate().getTime()));
						proposalContractBO.setContrEndPeriod(new Date(registrationCustomDTO.getExtensionDate().getTime()));
						proposalContractBO.setStatusCode(ProposalContractStatusConstants.EXTENDED_CONTRACT_PENDING_APPROVAL); //commented by Ramesh 
					}
				}

				if (ProposalTypeConstants.TP.equals(proposalContractBO.getProposalType())) {
					OPPTLogger.debug("In TP condition", CLASS_NAME, "RegisterProposal");
					SWODomainDTO swoDTO = new SWODomainDTO();
					swoDTO.setProposalId(proposalContractBO.getProposalId());

					HashMap map = new HashMap();
					map.put(UtilityConstants.REGISTRATION_REQUEST, new Boolean(true));
					map.put(UtilityConstants.CONTRACT_TYPE, OPPTHelper.trimString(proposalContractBO.getContrType()));
					swoDTO.setValues(map);

					SWODTOFactory swoFactory = new SWODTOFactory();

					try {
						swoDTO = swoFactory.validateTPProposal(swoDTO);
					} catch (DomainException ex) {
						throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
					}

					Boolean isValid = (Boolean) swoDTO.getValues().get(UtilityConstants.TP_VALID_FLAG);

					if (isValid.booleanValue()) {
						map = swoDTO.getValues();
						String tpCreateFlag = (String) map.get(UtilityConstants.TP_CREATION_FLAG);
						proposalContractBO.setContrCreateFlag(tpCreateFlag);
					}
					OPPTLogger.debug("TP condition exit..", CLASS_NAME, "RegisterProposal");
				}

				proposalContractBO.setLockedBy(null);
				proposalContractBO.setLockedOn(null);

				try {
					OPPTLogger.debug("before calling updateProposalContractBO.", CLASS_NAME, "RegisterProposal");
					proposalContractBOFactory.updateProposalContractBO(proposalContractBO);
					OPPTLogger.debug("after calling updateProposalContractBO.", CLASS_NAME, "RegisterProposal");
					
				} catch (DomainException ex) {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
				}
				
/* 	Commented for the change DAD O11 Remove approval step,Blue Harmony -by Ramesh Gandi
			}
			// send the mail

			CommunicationConnector communicationConnector = new CommunicationConnector();
			MailConnectorDTO mailConnectorDTO = new MailConnectorDTO();

			PreparedString str = new PreparedString(MailMessageConstants.REGISTRATION_MAIL_SUBJECT);
			str.setString(1, proposalContractBO.getProposalName().trim());

			String msgSub = OPPTHelper.getLogString(str.toString());
			OPPTLogger.log("REG_MAIL_MSG_SUB", OPPTLogger.DEBUG, CLASS_NAME, "RegisterProposal", msgSub);
			mailConnectorDTO.setSubject(str.toString());

			str.clear(MailMessageConstants.REGISTRATION_MAIL_TEXT);
			str.setString(1, proposalContractBO.getProposalName().trim());
			str.setString(2, registrationCustomDTO.getUserId().trim());
			str.setString(3, OPPTPropertiesReader.getOpptUrl().trim());

			msgSub = OPPTHelper.getLogString(str.toString());
			OPPTLogger.log("REG_MAIL_MSG_TEXT", OPPTLogger.DEBUG, CLASS_NAME, "RegisterProposal", msgSub);

			mailConnectorDTO.setMsgText(str.toString());

			mailConnectorDTO.setFromAddress(registrationCustomDTO.getEmailAddress());
			mailConnectorDTO.setToAddressID(registrationCustomDTO.getSelectedApproverId());
			mailConnectorDTO.setCcAddress(registrationCustomDTO.getSendContractTo());
			mailConnectorDTO.setSendReplyTo(registrationCustomDTO.getSendReplyTo());

			try {
				mailConnectorDTO = communicationConnector.sendMail(mailConnectorDTO);
			} catch (ConnectorException ex) {
				OPPTLogger.log("MAIL_SERVICE_EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "RegisterProposal", null, ex);
				registrationCustomDTO.setMessageReport(ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.SE0802, OPPTMessageCatalog.TYPE_SERVICE));
			}
			
		}
*/
		log.end();
		return registrationCustomDTO;
	}
	/**
	 * Check if the Proposal/Contract can be deleted and Delete it. If
	 * isConfirmationRequired is true, then check if the Proposal/Contracts can
	 * be deleted, else delete the Proposal/Contract.
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param DeleteProposalCustomDTO
	 * @return void
	 * @throws ServiceException
	 * @author Prakash Mall
	 */
	public void deleteProposalContract(
			DeleteProposalCustomDTO deleteProposalCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "deleteProposalContract");
		ProposalContractBO proposalContractBO = null;
		HashMap compareValues = null;
		SharingBO shareBO = null;

		List proposalListToBeDeleted = deleteProposalCustomDTO.getProposals();
		Iterator iter = proposalListToBeDeleted.iterator();

		if (deleteProposalCustomDTO.isConfirmationRequired()) {
			while (iter.hasNext()) {
				try {
					ProposalCustomDTO proposalCustomDTO = (ProposalCustomDTO) iter
							.next();
					shareBO = getSharingBOFromFactory(
							proposalCustomDTO.getId(), deleteProposalCustomDTO
									.getUserId());
					proposalContractBO = getProposalContractBOFromFactory(proposalCustomDTO
							.getId());
					compareValues = populateCompareValuesForUserAuthInProposalBO(
							deleteProposalCustomDTO, shareBO);
					if (deleteProposalCustomDTO.isConfirmationRequired()) {
						if (proposalContractBO.isProposal()) {
							ProposalBO proposalBO = (ProposalBO) proposalContractBO;
							proposalBO
									.validateForDeletion(
											UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
											compareValues);
						} else {
							ContractBO contractBO = (ContractBO) proposalContractBO;
							contractBO
									.validateForDeletion(
											UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
											compareValues);
						}
					}
				} catch (DomainException ex) {
					throw ExceptionGenerator.generateServiceException(ex
							.getErrorReport());
				}
			}
		} else {

			while (iter.hasNext()) {
				ProposalCustomDTO proposalCustomDTO = (ProposalCustomDTO) iter
						.next();
				ProposalContractBOFactory factory = new ProposalContractBOFactory();
				try {
					proposalContractBO = factory
							.getProposalContractBO(proposalCustomDTO.getId());
				} catch (DomainException de) {
					throw ExceptionGenerator.generateServiceException(de
							.getErrorReport());
				}

				try {
					if (ProposalTypeConstants.EASII.equals(proposalContractBO
							.getProposalType())) {
						// If the proposal type is EASII, then reference for
						// this proposal in the related contract is removed by
						// the system
						// use contract number from EASII proposal and search
						// the original EAS contract. Original EAS contract has
						// the reference in tp_contr_number field

						if (null != proposalContractBO.getContrNo()) {
							ProposalContractBO orgEASContr = null;

							try {
								orgEASContr = factory
										.findByTPContractNo(proposalContractBO
												.getContrNo());
							} catch (DomainException ex) {
								// just log the exception and forget it
								OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR,
										CLASS_NAME, "deleteProposalContract",
										null, ex);
							}

							if (null != orgEASContr) {
								orgEASContr.setTpContrNo(null);
								factory.updateProposalContractBO(orgEASContr);
							}
						}
					}
					factory.deleteProposalContractBO(proposalContractBO);
					try{
						ESWDataFactory eswDataFactory = new ESWDataFactory();
						eswDataFactory.deleteSelectedINV(proposalContractBO.getProposalId());
						//System.out.println("ProposalManagerBean.approveRequest():end of deleteSelectedINV ");
						} catch (DomainException ce) {
								OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,"", null, ce);
						} 
				} catch (DomainException ex) {
					throw ExceptionGenerator.generateServiceException(ex
							.getErrorReport());
				}
			}
		}
		log.end();
	}

	/**
	 *
	 * This method handles edit inventory request from controller layer when
	 * user makes the request for edit customer
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param editCustomerCustomDTO
	 * @return EditDMCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */

	public EditCustomerCustomDTO editInventory(
			EditCustomerCustomDTO editCustomerCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME,
				"editInventory-Customer");
		//instance variables
		int proposalId = 0;
		String methodName = "editInventory";
		HashMap billtoParty = new HashMap();
		HashMap payer = new HashMap();
		ProposalCustomDTO proposalCustomDTO = null;
		ProposalContractBO proposalContractBO = null;
		ProposalContractBOFactory proposalContractBOFactory = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		JMSConnectorLocal jmsConnectorLocal = null;
		JMSConnectorLocalHome jmsConnectorLocalHome = null;
		boolean isProposal = false;
		boolean isEdited = false;
		boolean customerExist = false;
		CustomerDomainDTO customerDomainDTO = null;
		ESWCustomerCustomDTO billtoPartyDTO = null;
		ESWCustomerCustomDTO payerDTO = null;
		//		set the connector dto instance
		RetrievePartnerInputConnectorDTO retrievePartnerInputConnectorDTO = null;
		RetrievePartnerOutputConnectorDTO retrievePartnerOutputConnectorDTO = null;
		RetrievePartnerConnectorDTO retrievePartnerConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = null;
		OrgConnectorDTO orgConnectorDTO = null;
		List customerDomainDTOList = new ArrayList();
		List partnerList = null;
		ProposalDomainDTO proposalDomainDTO = null;
		customerDomainDTO = new CustomerDomainDTO();
		proposalId = editCustomerCustomDTO.getProposal().getId();
		proposalContractBOFactory = new ProposalContractBOFactory();
		HashMap map = new HashMap();
		ESWCustomerCustomDTO defaultBilltoPartyDTO = new ESWCustomerCustomDTO();
		ESWCustomerCustomDTO defaultPayerDTO = new ESWCustomerCustomDTO();

		try {
			map.put(UtilityConstants.BO_USERID, editCustomerCustomDTO
					.getUserId());
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
			try {
				map.put(UtilityConstants.BO_GROUPNAME, editCustomerCustomDTO
						.getGroupName());
				SharingBO sharingBO = getSharingBOFromFactory(
						proposalContractBO.getProposalId(),
						editCustomerCustomDTO.getUserId());
				if (null != sharingBO) {
					map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
							.getAccessType());
				}
				proposalContractBO.validateEditInventory(
						UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);
			} catch (DomainException d) {
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());
			}

			proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
			customerDomainDTO.setProposalId(proposalContractBO.getProposalId());
			customerDomainDTO.setCustomerId(editCustomerCustomDTO
					.getSelectedCustomer().getCustomerId());
			inventoryManagerLocal = getInventoryManagerLocal();
			customerDomainDTO = inventoryManagerLocal
					.retrieveCustomerInfo(customerDomainDTO);

			if (customerDomainDTO != null
					&& customerDomainDTO.getBillToPartyName() != null) {
				defaultBilltoPartyDTO.setSAPCustomerNumber(customerDomainDTO
						.getBillToPartyNo());
				defaultBilltoPartyDTO
						.setAddressSequenceNumber(customerDomainDTO
								.getBillToPartyASNo());
				defaultBilltoPartyDTO.setLegacyCustomerNumber(customerDomainDTO
						.getBillToPartyLNo());
				defaultBilltoPartyDTO.setCustomerName(customerDomainDTO
						.getBillToPartyName());
				OPPTLogger.debug("Bill to Party Name---Customer Level"
						+ defaultBilltoPartyDTO.getCustomerName(), CLASS_NAME,
						methodName);
				OPPTLogger.debug("Bill to Party No---Customer Level"
						+ defaultBilltoPartyDTO.getSAPCustomerNumber(),
						CLASS_NAME, methodName);

			} else {
				defaultBilltoPartyDTO.setSAPCustomerNumber(proposalDomainDTO
						.getRegBillToPartyNo());
				defaultBilltoPartyDTO
						.setAddressSequenceNumber(proposalDomainDTO
								.getRegBillToPartASNo());
				defaultBilltoPartyDTO.setLegacyCustomerNumber(proposalDomainDTO
						.getRegBillToPartyListNo());
				defaultBilltoPartyDTO.setCustomerName(proposalDomainDTO
						.getRegBillToPartyName());
				OPPTLogger.debug("Bill to Party Name---Proposal Level"
						+ defaultBilltoPartyDTO.getCustomerName(), CLASS_NAME,
						methodName);
			}

			if (customerDomainDTO != null
					&& customerDomainDTO.getPayerName() != null) {
				defaultPayerDTO.setSAPCustomerNumber(customerDomainDTO
						.getPayerNo());
				defaultPayerDTO.setAddressSequenceNumber(customerDomainDTO
						.getPayerASNo());
				defaultPayerDTO.setLegacyCustomerNumber(customerDomainDTO
						.getPayerLNo());
				defaultPayerDTO.setCustomerName(customerDomainDTO
						.getPayerName());
				OPPTLogger.debug("Payer Name---Customer Level"
						+ defaultPayerDTO.getCustomerName(), CLASS_NAME,
						methodName);
				OPPTLogger.debug("Payer No---Customer Level"
						+ defaultPayerDTO.getSAPCustomerNumber(), CLASS_NAME,
						methodName);

			} else {
				defaultPayerDTO.setSAPCustomerNumber(proposalDomainDTO
						.getRegPayerNo());
				defaultPayerDTO.setAddressSequenceNumber(proposalDomainDTO
						.getRegPayerASNo());
				defaultPayerDTO.setLegacyCustomerNumber(proposalDomainDTO
						.getRegPayerListNo());
				defaultPayerDTO.setCustomerName(proposalDomainDTO
						.getRegPayerName());
				OPPTLogger.debug("Payer Name---Proposal Level"
						+ defaultPayerDTO.getCustomerName(), CLASS_NAME,
						methodName);
			}

			retrievePartnerInputConnectorDTO = new RetrievePartnerInputConnectorDTO();
			//set the generic values
			genericConnectorDTO = new GenericConnectorDTO();
			genericConnectorDTO
					.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_PARTNER_OPPT);
			genericConnectorDTO.setSessionID(editCustomerCustomDTO
					.getSessionId());
			genericConnectorDTO.setUserID(editCustomerCustomDTO.getUserId());
			//set the org values
			orgConnectorDTO = new OrgConnectorDTO();
			orgConnectorDTO.setDistributionChannel(proposalDomainDTO
					.getDistrChannel());
			orgConnectorDTO.setSalesGroup(proposalDomainDTO.getSalesGroup());
			orgConnectorDTO.setChannelRole(proposalDomainDTO.getChannelRole());
			orgConnectorDTO.setSubmitterRole(proposalDomainDTO.getSubmitterRole());
			orgConnectorDTO.setDivision(proposalDomainDTO.getDivisionCode());
			orgConnectorDTO.setSalesOrg(proposalDomainDTO.getSalesOrg());
			retrievePartnerInputConnectorDTO.setLegacyNo(customerDomainDTO
					.getLegacyCustomerNo());
			retrievePartnerInputConnectorDTO
					.setAddressSequenceNo(customerDomainDTO.getCustmerASNo());
			retrievePartnerInputConnectorDTO
					.setGenericConnectorDTO(genericConnectorDTO);
			retrievePartnerInputConnectorDTO
					.setOrgConnectorDTO(orgConnectorDTO);
			jmsConnectorLocalHome = (JMSConnectorLocalHome) ServiceLocator
					.getEJBHomeFactory().getLocalHome("JMSConnectorLocalHome");
			jmsConnectorLocal = jmsConnectorLocalHome.create();
			retrievePartnerOutputConnectorDTO = (RetrievePartnerOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(retrievePartnerInputConnectorDTO);
		} catch (DomainException d) {

			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"editInventory-Customer", null, e);
			throwServiceException(ErrorCodeConstants.SE0801,
					OPPTMessageCatalog.TYPE_SERVICE);
		}

		if (retrievePartnerOutputConnectorDTO != null
				&& ConnectorConstants.RFC_SUCCESS_CODE
						.equals(retrievePartnerOutputConnectorDTO
								.getReturnCode())) {
			partnerList = retrievePartnerOutputConnectorDTO
					.getRetrievePartnerConnectorDTOList();
			for (int i = 0; i < partnerList.size(); i++) {
				retrievePartnerConnectorDTO = (RetrievePartnerConnectorDTO) partnerList
						.get(i);
				if (retrievePartnerConnectorDTO.getFlag().equalsIgnoreCase(
						PartnerTypeConstants.BILL_TO_PARTY)) {
					billtoPartyDTO = new ESWCustomerCustomDTO();

					billtoPartyDTO
							.setSAPCustomerNumber(retrievePartnerConnectorDTO
									.getCustomerNumber());
					billtoPartyDTO
							.setLegacyCustomerNumber(retrievePartnerConnectorDTO
									.getLegacyNumber());
					billtoPartyDTO
							.setAddressSequenceNumber(retrievePartnerConnectorDTO
									.getSequenceNumber());
					billtoPartyDTO.setCustomerName(retrievePartnerConnectorDTO
							.getCustomerName());
					OPPTLogger.debug("Bill to Party Name---Back End"
							+ billtoPartyDTO.getCustomerName(), CLASS_NAME,
							methodName);
					billtoParty.put(billtoPartyDTO.getSAPCustomerNumber(),
							billtoPartyDTO);
				} else if (retrievePartnerConnectorDTO.getFlag()
						.equalsIgnoreCase(PartnerTypeConstants.PAYER)) {
					payerDTO = new ESWCustomerCustomDTO();

					payerDTO.setSAPCustomerNumber(retrievePartnerConnectorDTO
							.getCustomerNumber());
					payerDTO
							.setLegacyCustomerNumber(retrievePartnerConnectorDTO
									.getLegacyNumber());
					payerDTO
							.setAddressSequenceNumber(retrievePartnerConnectorDTO
									.getSequenceNumber());
					payerDTO.setCustomerName(retrievePartnerConnectorDTO
							.getCustomerName());
					OPPTLogger.debug("Payer Name---Back End"
							+ payerDTO.getCustomerName(), CLASS_NAME,
							methodName);
					payer.put(payerDTO.getSAPCustomerNumber(), payerDTO);
				}
			}
			if (billtoParty != null
					&& billtoParty.containsKey(defaultBilltoPartyDTO
							.getSAPCustomerNumber())) {
				editCustomerCustomDTO.setBillToParty(billtoParty);
			} else {
				billtoParty.put(defaultBilltoPartyDTO.getSAPCustomerNumber(),
						defaultBilltoPartyDTO);
				editCustomerCustomDTO.setBillToParty(billtoParty);
			}
			if (payer != null
					&& payer
							.containsKey(defaultPayerDTO.getSAPCustomerNumber())) {
				editCustomerCustomDTO.setPayer(payer);
			} else {
				payer.put(defaultPayerDTO.getSAPCustomerNumber(),
						defaultPayerDTO);
				editCustomerCustomDTO.setPayer(payer);
			}
			// MN 19640197 Defect 4 Change made by Balaji
			editCustomerCustomDTO.getSelectedCustomer().setPlanStartDate(
					proposalDomainDTO.getContrStartPeriod());
			editCustomerCustomDTO.getSelectedCustomer().setPlanEndDate(
					proposalDomainDTO.getContrEndPeriod());
			editCustomerCustomDTO.setEditPlanStartDate(customerDomainDTO
					.getPlanStartDate());
			editCustomerCustomDTO.setEditPlanEndDate(customerDomainDTO
					.getPlanEndDate());
			// MN 19640197 Defect 4 Change made by Balaji
			editCustomerCustomDTO.getSelectedCustomer().setSAPCustomerNumber(
					customerDomainDTO.getSapCustomerNo());
			editCustomerCustomDTO.getSelectedCustomer().setCustomerName(
					customerDomainDTO.getSapCustomerName());
			editCustomerCustomDTO.getSelectedCustomer()
					.setAddressSequenceNumber(
							customerDomainDTO.getCustmerASNo());
			editCustomerCustomDTO.getSelectedCustomer()
					.setLegacyCustomerNumber(
							customerDomainDTO.getLegacyCustomerNo());
			editCustomerCustomDTO.setSelectedBillToParty(defaultBilltoPartyDTO);
			editCustomerCustomDTO.setSelectedPayer(defaultPayerDTO);
			editCustomerCustomDTO
					.setStartYears(OPPTCalender.getStartYearList());
			editCustomerCustomDTO.setEndYears(OPPTCalender.getEndYearList());
		} else {
			storeErrorList(retrievePartnerOutputConnectorDTO.getReturnCode(),
					editCustomerCustomDTO.getProposal().getId(),
					editCustomerCustomDTO.getUserId(), methodName);
			throwServiceException(retrievePartnerOutputConnectorDTO
					.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
		}
		timeTaken.end();
		return editCustomerCustomDTO;
	}

	/**
	 *
	 * This method handles edit inventory request from controller layer when
	 * user makes the request for edit dm
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param editDMCustomDTO
	 * @return EditDMCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public EditDMCustomDTO editInventory(EditDMCustomDTO editDMCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "editInventory-DM");

		int proposalId = 0;
		ProposalCustomDTO proposalCustomDTO = null;
		ProposalContractBO proposalContractBO = null;
		ProposalContractBOFactory proposalContractBOFactory = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		boolean isProposal = false;
		boolean isEdited = false;
		CustomerDomainDTO customerDomainDTO = null;
		DMDomainDTO dmDomainDTO = null;
		ProposalDomainDTO proposalDomainDTO = null;
		ProposalCustomerCustomDTO poposalCustomerCustomDTO = null;
		List customerDomainDTOList = new ArrayList();
		TreeMap dmMap = new TreeMap();
		ESWCustomerCustomDTO eswCustomer = new ESWCustomerCustomDTO();
		DMCustomDTO dmCustomDTO = new DMCustomDTO();
		proposalId = editDMCustomDTO.getProposal().getId();
		proposalContractBOFactory = new ProposalContractBOFactory();
		HashMap map = new HashMap();
		try {
			map.put(UtilityConstants.BO_USERID, editDMCustomDTO.getUserId());
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
			try {
				map.put(UtilityConstants.BO_GROUPNAME, editDMCustomDTO
						.getGroupName());
				SharingBO sharingBO = getSharingBOFromFactory(
						proposalContractBO.getProposalId(), editDMCustomDTO
								.getUserId());
				if (null != sharingBO) {
					map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
							.getAccessType());
				}
				proposalContractBO.validateEditInventory(
						UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);
			} catch (DomainException d) {
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());
			}
			proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
			inventoryManagerLocal = getInventoryManagerLocal();
			dmDomainDTO = new DMDomainDTO();
			dmDomainDTO.setProposalId(proposalId);
			dmDomainDTO.setCustomerId(Integer.parseInt(editDMCustomDTO
					.getSelectedDM().getCustomerId()));
			dmDomainDTO.setDmId(Integer.parseInt(editDMCustomDTO
					.getSelectedDM().getId()));
			dmDomainDTO.setActionName(ActionNameConstants.EDIT_INVENTORY_DM);

			customerDomainDTO = inventoryManagerLocal
					.retrieveDMEditInfo(dmDomainDTO);
			eswCustomer.setCustomerName(customerDomainDTO.getSapCustomerName());
			eswCustomer.setSAPCustomerNumber(customerDomainDTO
					.getSapCustomerNo());
			eswCustomer.setLegacyCustomerNumber(customerDomainDTO
					.getLegacyCustomerNo());
			eswCustomer.setAddressSequenceNumber(customerDomainDTO
					.getCustmerASNo());

			for (int i = 0; i < customerDomainDTO.getDMDTOList().size(); i++) {
				dmDomainDTO = (DMDomainDTO) customerDomainDTO.getDMDTOList()
						.get(i);
				dmCustomDTO.setId(String.valueOf(dmDomainDTO.getDmId()));
				dmCustomDTO.setCustomerId(String.valueOf(dmDomainDTO
						.getCustomerId()));
				dmCustomDTO.setProposalId(dmDomainDTO.getProposalId());
				dmCustomDTO.setNumber(dmDomainDTO.getDmNo());
				dmCustomDTO.setDescription(dmDomainDTO.getDmDesc());

				// MN 19640197 Fix by Balaji
				dmCustomDTO.setPlanStartDate(customerDomainDTO
						.getPlanStartDate());
				dmCustomDTO.setPlanEndDate(customerDomainDTO.getPlanEndDate());

			}
			editDMCustomDTO.setEditPlanEndDate(dmDomainDTO.getPlanEndDate());
			editDMCustomDTO
					.setEditPlanStartDate(dmDomainDTO.getPlanStartDate());

			// MN 19640197 Fix by Balaji - Ends

			editDMCustomDTO.setCustomer(eswCustomer);
			editDMCustomDTO.setSelectedDM(dmCustomDTO);
			editDMCustomDTO.setStartYears(OPPTCalender.getStartYearList());
			editDMCustomDTO.setEndYears(OPPTCalender.getEndYearList());

		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"editInventory-DM", null, e);
			throwServiceException(ErrorCodeConstants.SE0801,
					OPPTMessageCatalog.TYPE_SERVICE);
		}
		timeTaken.end();
		return editDMCustomDTO;
	}

	/**
	 *
	 * This method handles edit inventory request from controller layer when
	 * user makes the request for edit swo
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param editSWOCustomDTO
	 * @return EditSWOCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public EditSWOCustomDTO editInventory(EditSWOCustomDTO editSWOCustomDTO)
			throws ServiceException {
		//System.out.println("ProposalManagerBean.editInventory()");
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "editInventory-SWO");
		int proposalId = 0;
		ProposalContractBO proposalContractBO = null;
		ProposalContractBOFactory proposalContractBOFactory = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		boolean isProposal = false;
		boolean isEdited = false;
		CustomerDomainDTO customerDomainDTO = null;
		SWODomainDTO swoDomainDTO = null;
		DMDomainDTO dmDomainDTO = null;
		ESWCustomerCustomDTO eswCustomer = new ESWCustomerCustomDTO();
		DMCustomDTO dmCustomDTO = new DMCustomDTO();
		SWOCustomDTO swoCustomDTO = new SWOCustomDTO();
		ProposalDomainDTO proposalDomainDTO = null;
		proposalId = editSWOCustomDTO.getProposalDTO().getId();
		proposalContractBOFactory = new ProposalContractBOFactory();
		HashMap map = new HashMap();

		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
			map.put(UtilityConstants.BO_GROUPNAME, editSWOCustomDTO
					.getGroupName());
			map.put(UtilityConstants.BO_USERID, editSWOCustomDTO.getUserId());
			SharingBO sharingBO = getSharingBOFromFactory(proposalContractBO
					.getProposalId(), editSWOCustomDTO.getUserId());
			if (null != sharingBO) {
				map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}
			proposalContractBO.validateEditInventory(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
		swoDomainDTO = new SWODomainDTO();
		swoDomainDTO.setProposalId(editSWOCustomDTO.getSelectedSWO()
				.getProposalId());
		swoDomainDTO.setCustomerId(Integer.parseInt(editSWOCustomDTO
				.getSelectedSWO().getCustomerId()));
		swoDomainDTO.setDmId(Integer.parseInt(editSWOCustomDTO.getSelectedSWO()
				.getDMId()));
		swoDomainDTO.setSwoId(Integer.parseInt(editSWOCustomDTO
				.getSelectedSWO().getId()));
		swoDomainDTO.setActionName(ActionNameConstants.EDIT_INVENTORY_SWO);
		inventoryManagerLocal = getInventoryManagerLocal();
		customerDomainDTO = inventoryManagerLocal
				.retrieveSWOEditInfo(swoDomainDTO);

		eswCustomer.setCustomerName(customerDomainDTO.getSapCustomerName());
		eswCustomer.setSAPCustomerNumber(customerDomainDTO.getSapCustomerNo());
		eswCustomer.setLegacyCustomerNumber(customerDomainDTO
				.getLegacyCustomerNo());
		eswCustomer
				.setAddressSequenceNumber(customerDomainDTO.getCustmerASNo());

		for (int i = 0; i < customerDomainDTO.getDMDTOList().size(); i++) {
			dmDomainDTO = (DMDomainDTO) customerDomainDTO.getDMDTOList().get(i);
			dmCustomDTO.setId(String.valueOf(dmDomainDTO.getDmId()));
			dmCustomDTO.setCustomerId(String.valueOf(dmDomainDTO
					.getCustomerId()));
			dmCustomDTO.setProposalId(dmDomainDTO.getProposalId());
			dmCustomDTO.setNumber(dmDomainDTO.getDmNo());
			dmCustomDTO.setDescription(dmDomainDTO.getDmDesc());
			dmCustomDTO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
			dmCustomDTO.setPlanEndDate(dmDomainDTO.getPlanEndDate());

			for (int j = 0; j < dmDomainDTO.getSWODTOList().size(); j++) {

				swoDomainDTO = (SWODomainDTO) dmDomainDTO.getSWODTOList()
						.get(j);
				swoCustomDTO.setId(String.valueOf(swoDomainDTO.getSwoId()));
				swoCustomDTO.setDMId(String.valueOf(swoDomainDTO.getDmId()));
				swoCustomDTO.setCustomerId(String.valueOf(swoDomainDTO
						.getCustomerId()));
				swoCustomDTO.setProposalId(swoDomainDTO.getProposalId());
				swoCustomDTO.setSerialNumber(swoDomainDTO.getSerialNo());
				swoCustomDTO.setDescription(swoDomainDTO.getSwoDesc());
				swoCustomDTO.setNumber(swoDomainDTO.getSwoNo());
				swoCustomDTO
						.setAlternatePrice(swoDomainDTO.getAlternatePrice());
				// 31/05/2004 MN 19387428- Defect 351 For Alternate Price change
				// added by Balaji
				if (0 == swoDomainDTO.getAlternatePrice()
						&& (!("Y".equals(swoDomainDTO
								.getAlternatePriceUpdateInd())))) {
					swoCustomDTO.setAlternatePrice(-1);
				}
				// Change Ends

				// MN 19640197 Balaji
				swoCustomDTO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
				swoCustomDTO.setPlanEndDate(dmDomainDTO.getPlanEndDate());
				if (swoDomainDTO.getItemCategory() != null
						&& swoDomainDTO.getItemCategory().equals(
								LicenseConstants.SVC_LICENSE_FLAG)) {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0125);
				}
			}

		}

		editSWOCustomDTO.setEditPlanStartDate(swoDomainDTO.getPlanStartDate());
		editSWOCustomDTO.setEditPlanEndDate(swoDomainDTO.getPlanEndDate());
		// MN 19640197 Balaji - Ends

		editSWOCustomDTO.setCustomerDTO(eswCustomer);
		editSWOCustomDTO.setDMDTO(dmCustomDTO);
		editSWOCustomDTO.setSelectedSWO(swoCustomDTO);
		editSWOCustomDTO.setStartYears(OPPTCalender.getStartYearList());
		editSWOCustomDTO.setEndYears(OPPTCalender.getEndYearList());

		timeTaken.end();
		return editSWOCustomDTO;

	}

	/**
	 *
	 * This method handles edit inventory request from controller layer when
	 * user makes the request for Edit Operation and calls the corresponding
	 * editInventory method
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date July 30,2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param editInventoryCustomDTO
	 * @return EditInventoryCustomDTO
	 * @throws ServiceException
	 * @author Saravanan Viswanathan New method added below for MN20228979 for
	 *         allowing Edit of multiple Items
	 */

	public EditInventoryCustomDTO editInventory(
			EditInventoryCustomDTO editInventoryCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "editInventory");
		TreeMap customerList = null;
		customerList = editInventoryCustomDTO.getSelectedCustomers();
		if (null != customerList) {
			Iterator iterator = customerList.values().iterator();
			while (iterator.hasNext()) {
				EditCustomerCustomDTO editCustomerCustomDTO = (EditCustomerCustomDTO) iterator
						.next();
				editCustomerCustomDTO.setProposal(editInventoryCustomDTO
						.getProposal());
				editCustomerCustomDTO.setUserId(editInventoryCustomDTO
						.getUserId());
				editCustomerCustomDTO.setGroupName(editInventoryCustomDTO
						.getGroupName());
				editCustomerCustomDTO.setSessionId(editInventoryCustomDTO
						.getSessionId());
				editInventory(editCustomerCustomDTO);
				editInventoryCustomDTO.setStartYears(editCustomerCustomDTO
						.getStartYears());
				editInventoryCustomDTO.setEndYears(editCustomerCustomDTO
						.getEndYears());
			}
		}

		TreeMap dmList = null;
		dmList = editInventoryCustomDTO.getSelectedDMs();
		if (null != dmList) {
			Iterator iterator = dmList.values().iterator();
			while (iterator.hasNext()) {
				EditDMCustomDTO editDMCustomDTO = (EditDMCustomDTO) iterator
						.next();
				editDMCustomDTO.setProposal(editInventoryCustomDTO
						.getProposal());
				editDMCustomDTO.setUserId(editInventoryCustomDTO.getUserId());
				editDMCustomDTO.setGroupName(editInventoryCustomDTO
						.getGroupName());
				editInventory(editDMCustomDTO);
				editInventoryCustomDTO.setStartYears(editDMCustomDTO
						.getStartYears());
				editInventoryCustomDTO.setEndYears(editDMCustomDTO
						.getEndYears());
			}
		}

		TreeMap swoList = null;
		swoList = editInventoryCustomDTO.getSelectedSWOs();
		if (null != swoList) {
			Iterator iterator = swoList.values().iterator();
			while (iterator.hasNext()) {
				EditSWOCustomDTO editSWOCustomDTO = (EditSWOCustomDTO) iterator
						.next();
				editSWOCustomDTO.setProposalDTO(editInventoryCustomDTO
						.getProposal());
				editSWOCustomDTO.setUserId(editInventoryCustomDTO.getUserId());
				editSWOCustomDTO.setGroupName(editInventoryCustomDTO
						.getGroupName());
				editInventory(editSWOCustomDTO);
				editInventoryCustomDTO.setStartYears(editSWOCustomDTO
						.getStartYears());
				editInventoryCustomDTO.setEndYears(editSWOCustomDTO
						.getEndYears());
			}
		}
		timeTaken.end();
		return editInventoryCustomDTO;
	}

	/**
	 * This method is used to verify whether create or simulate Variance can be
	 * executed on the selected contract and display the corresponding error
	 * message if create or simualte variance could not be executed on the
	 * selected contract.
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 17, 2003
	 *
	 * Venkat To Implement Create or Simulate Variance usecases
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param varianceCustomDTO
	 * @return varianceCustomDTO
	 * @throws ServiceException
	 */
	public VarianceCustomDTO createOrSimulateVariance(
			VarianceCustomDTO varianceCustomDTO) throws ServiceException {
		String methodName = "createOrSimulateVariance";
		TimeTaken log = new TimeTaken(CLASS_NAME, methodName);
		HashMap map = new HashMap();
		boolean preCondtn = false;
		ProposalContractBOFactory proposalContractBOFactory = null;
		ContractBO contractBO = null;
		if (varianceCustomDTO != null) {

			try {
				proposalContractBOFactory = new ProposalContractBOFactory();
				contractBO = (ContractBO) proposalContractBOFactory
						.getProposalContractBO(varianceCustomDTO
								.getContractDTO().getId());
				map.put(UtilityConstants.BO_USERID, varianceCustomDTO
						.getUserId());
				map.put(UtilityConstants.BO_GROUPNAME, varianceCustomDTO
						.getGroupName());
				SharingBO sharingBO = getSharingBOFromFactory(contractBO
						.getProposalId(), varianceCustomDTO.getUserId());
				if (null != sharingBO) {
					map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
							.getAccessType());
				}
				preCondtn = contractBO.isAllowedForVariance(
						UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);
				OPPTLogger.debug("Pre-Condtn Result" + preCondtn, CLASS_NAME,
						methodName);
			} catch (DomainException d) {
				OPPTLogger.debug("Error report B4 exception"
						+ d.getErrorReport(), CLASS_NAME, methodName);
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());
			}

			if (preCondtn) {

				varianceCustomDTO.setProposalName(contractBO.getProposalName());
				varianceCustomDTO.setProposalType(contractBO.getProposalType());
				varianceCustomDTO.setContractType(contractBO.getContrType());
				varianceCustomDTO.setContractNumber(contractBO.getContrNo());
				varianceCustomDTO.setExternalContractNumber(contractBO
						.getExtContrNo());
				varianceCustomDTO.setContractPeriodStartDate(contractBO
						.getContrStartPeriod());
				varianceCustomDTO.setContractPeriodEndDate(contractBO
						.getContrEndPeriod());

			} else {

				//Set the Corresponding Error Message
				//If Variance Type is Create Variance
				if (VarianceCustomDTO.CREATE_VARIANCE == varianceCustomDTO
						.getVarianceType()) {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0510);
				}
				//If Variance Type is Simualte Variance
				else if (VarianceCustomDTO.SIMULATE_VARIANCE == varianceCustomDTO
						.getVarianceType()) {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0509);
				}
			}
		}
		return varianceCustomDTO;
	} //end of createOrSimulateVariance

	/**
	 * This method is used for validating the variance date before processing
	 * the Variance Request.
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * Venkat
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param varianceCustomDTO
	 * @return
	 */
	private boolean validateVarianceDate(VarianceCustomDTO varianceCustomDTO) {
		boolean isValidVarianceDate = false;
		if (VarianceCustomDTO.SIMULATE_VARIANCE == varianceCustomDTO
				.getVarianceType()) {
			if (varianceCustomDTO.getVarianceDate().compareTo(
					varianceCustomDTO.getContractPeriodStartDate()) >= 0
					&& varianceCustomDTO.getVarianceDate().compareTo(
							varianceCustomDTO.getContractPeriodEndDate()) <= 0) {
				isValidVarianceDate = true;
			}
		} else if (VarianceCustomDTO.CREATE_VARIANCE == varianceCustomDTO
				.getVarianceType()) {
			OPPTCalender opptCalendar = new OPPTCalender();
			if (varianceCustomDTO.getVarianceDate().compareTo(
					varianceCustomDTO.getContractPeriodStartDate()) >= 0
					&& varianceCustomDTO.getVarianceDate().compareTo(
							opptCalendar.getUtilDate()) <= 0) {
				isValidVarianceDate = true;
			}
		}
		return isValidVarianceDate;
	} //end of validateVarianceDate

	/**
	 * This method is used for making the request for Create or Simulate
	 * Variance with Backend And to update the Variance Type and Variance
	 * Indicator information in the Proposal Table <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 17, 2003
	 *
	 * Venkat To Implement the Create or Simualte Variance Request
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param varianceCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public VarianceCustomDTO processVariance(VarianceCustomDTO varianceCustomDTO)
			throws ServiceException {
		final String INCLUDE_QUOTES = "X";
		String VarianceType = null;
		String VarianceIndicator = null;
		String methodName = "processVariance";
		//If Variance Date is Valid
		if (validateVarianceDate(varianceCustomDTO)) {
			//Get the Contract BO object
			ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
			ContractBO contractBO = null;
			try {
				contractBO = (ContractBO) proposalContractBOFactory
						.getProposalContractBO(varianceCustomDTO
								.getContractDTO().getId());
			} catch (DomainException ex) {
				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}

			CreateVarianceReportInputConnectorDTO varianceInputConnectorDTO = new CreateVarianceReportInputConnectorDTO();
			// Data Set using contractBO object
			varianceInputConnectorDTO.setSalesOrg(contractBO.getSalesOrg());
			if (contractBO.getExtContrNo() != null
					&& !(contractBO.getExtContrNo().equals(""))) {
				varianceInputConnectorDTO.setExternalContractNumber(contractBO
						.getExtContrNo());
			} else {
				varianceInputConnectorDTO.setExternalContractNumber(contractBO
						.getContrNo());
			}
			varianceInputConnectorDTO.setProposalType(contractBO
					.getProposalType());
			varianceInputConnectorDTO.setContractPeriodStartDate(contractBO
					.getContrStartPeriod());
			varianceInputConnectorDTO.setContractPeriodEndDate(contractBO
					.getContrEndPeriod());

			/*
			 * MN21109128 - Fixed by Balaji String capAmount = null; capAmount =
			 * String.valueOf(contractBO.getCapAmount()); String
			 * CapAmountAfterDot = capAmount.substring(capAmount.indexOf(".") +
			 * 1); if (CapAmountAfterDot.length() == 1) { capAmount = capAmount +
			 * "0"; } capAmount = capAmount.substring(0, capAmount.indexOf(".")) +
			 * capAmount.substring(capAmount.indexOf(".") + 1);
			 * varianceInputConnectorDTO.setCapAmount(capAmount);
			 *
			 */

			varianceInputConnectorDTO.setCapAmount(PCMConnectorDTOBuilder
					.convertPriceAsPerDecimalAllowed(contractBO.getCapAmount(),
							2));
			/* MN21109128 - Fixed by Balaji Ends */
			varianceInputConnectorDTO.setLegacyCustomerNo(contractBO
					.getRegCustomerNo());
			varianceInputConnectorDTO.setAddressSequenceNo(contractBO
					.getRegCustomerASNo());
			//Data set using VarianceCustomData
			varianceInputConnectorDTO.setVarianceDate(varianceCustomDTO
					.getVarianceDate());
			if (VarianceCustomDTO.CREATE_VARIANCE == varianceCustomDTO
					.getVarianceType()) {
				VarianceType = UtilityConstants.CREATE_VARIANCE;
			} else if (VarianceCustomDTO.SIMULATE_VARIANCE == varianceCustomDTO
					.getVarianceType()) {
				VarianceType = UtilityConstants.SIMULATE_VARIANCE;
			}
			varianceInputConnectorDTO.setIndicatorVarType(VarianceType);
			if (varianceCustomDTO.isIncludeQuotes()) {
				VarianceIndicator = INCLUDE_QUOTES;
			} else {
				VarianceIndicator = "";
			}
			varianceInputConnectorDTO.setIndicatorVarType(VarianceType);
			varianceInputConnectorDTO
					.setIndicatorQuoteIncluded(VarianceIndicator);
			//To Set the Content for Generic Connector DTO
			GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
			genericConnectorDTO
					.setFunctionModuleName(ConnectorConstants.RFC_CREATE_VAR_OPPT);
			genericConnectorDTO.setUserID(varianceCustomDTO.getUserId());
			genericConnectorDTO.setSessionID(varianceCustomDTO.getSessionId());
			varianceInputConnectorDTO
					.setGenericConnectorDTO(genericConnectorDTO);
			// Make the ESW Call to the Backend
			JMSConnectorLocalHome jmsConnectorLocalHome = (JMSConnectorLocalHome) ServiceLocator
					.getEJBHomeFactory().getLocalHome("JMSConnectorLocalHome");
			JMSConnectorLocal jmsConnectorLocal = null;
			try {
				jmsConnectorLocal = jmsConnectorLocalHome.create();
			} catch (CreateException e) {

				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						"processVariance", null, e);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}
			CreateVarianceReportOutputConnectorDTO varianceOutputConnectorDTO = new CreateVarianceReportOutputConnectorDTO();
			try {
				varianceOutputConnectorDTO = (CreateVarianceReportOutputConnectorDTO) jmsConnectorLocal
						.sendReceive(varianceInputConnectorDTO);
			} catch (Exception e1) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						"processVariance", null, e1);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}
			//If no errors received from Backend
			if (ConnectorConstants.RFC_SUCCESS_CODE
					.equals(varianceOutputConnectorDTO.getReturnCode())) {

				contractBO.setVarInd(varianceInputConnectorDTO
						.getIndicatorVarType());
				contractBO.setVarDate(new java.sql.Date(
						varianceInputConnectorDTO.getVarianceDate().getTime()));
				contractBO.setCapVariance(0);
				ProposalContractBO proposalContractBO = contractBO;
				try {
					proposalContractBOFactory
							.updateProposalContractBO(proposalContractBO);
				} catch (Exception e) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							"processVariance", null, e);
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0801);
				}
				//Set the Successful message in the customdata.
				varianceCustomDTO.addMessageEntry(ErrorCodeConstants.SE0512,
						OPPTMessageCatalog.TYPE_SERVICE);
			}
			//If error is returned from Backend
			else {
				storeErrorList(varianceOutputConnectorDTO.getReturnCode(),
						contractBO.getProposalId(), varianceCustomDTO
								.getUserId(), methodName);
				throwServiceException(varianceOutputConnectorDTO
						.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);

			}

		}
		//Variance Date is Invalid
		else {
			//varianceCustomDTO.addErrorEntry(varianceDateErrorKey,
			// OPPTMessageCatalog.TYPE_SERVICE);

			if (VarianceCustomDTO.CREATE_VARIANCE == varianceCustomDTO
					.getVarianceType()) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0511);
			} else if (VarianceCustomDTO.SIMULATE_VARIANCE == varianceCustomDTO
					.getVarianceType()) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0513);
			}

		}
		return varianceCustomDTO;
	} //end of processVariance

	/**
	 *
	 * This method saves the edited DM information during the edit inventory
	 * case
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param editDMCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public EditDMCustomDTO saveEditDM(EditDMCustomDTO editDMCustomDTO)
			throws ServiceException {

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "saveEditDM");

		ProposalContractBO proposalContractBO = null;
		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalCustomDTO proposalCustomDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		DMDomainDTO dmDomainDTO = null;
		int proposalId = 0;
		boolean isProposal = false;
		String status = "Contract";
		HashMap mapValues = new HashMap();
		java.util.Date selStartDate = null;
		java.util.Date selEndDate = null;
		java.util.Date defaultStartDate = null;
		java.util.Date defaultEndDate = null;
		java.util.Date amendDate = null;
		boolean condtn = false;
		proposalContractBOFactory = new ProposalContractBOFactory();
		proposalCustomDTO = editDMCustomDTO.getProposal();
		proposalId = proposalCustomDTO.getId();
		dmDomainDTO = new DMDomainDTO();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de
					.getErrorReport());
		}

		isProposal = proposalContractBO.isProposal();
		if (isProposal) {
			status = "Proposal";
		} else {
			status = "Contract";
		}
		mapValues.put(UtilityConstants.PROPOSAL_TYPE, proposalContractBO
				.getProposalType());
		mapValues.put(UtilityConstants.STATUS, status);
		mapValues.put(UtilityConstants.STATUS_CODE, proposalContractBO
				.getStatusCode());
		dmDomainDTO.setActionName(ActionNameConstants.EDIT_INVENTORY_DM);
		dmDomainDTO.setValues(mapValues);
		dmDomainDTO.setProposalId(editDMCustomDTO.getSelectedDM()
				.getProposalId());
		dmDomainDTO.setCustomerId(Integer.parseInt(editDMCustomDTO
				.getSelectedDM().getCustomerId()));
		dmDomainDTO.setDmId(Integer.parseInt(editDMCustomDTO.getSelectedDM()
				.getId()));
		selStartDate = editDMCustomDTO.getEditPlanStartDate();
		selEndDate = editDMCustomDTO.getEditPlanEndDate();
		defaultStartDate = editDMCustomDTO.getSelectedDM().getPlanStartDate();
		defaultEndDate = editDMCustomDTO.getSelectedDM().getPlanEndDate();
		amendDate = proposalContractBO.getAmendEffectiveDate();
		OPPTCalender calendar = new OPPTCalender();
		if (proposalContractBO.isProposal()) {
			if (selStartDate != null && selEndDate != null) {
				condtn = (calendar
						.isDateGreater(selStartDate, defaultStartDate) || calendar
						.isDateEqual(selStartDate, defaultStartDate))
						&& (calendar.isDateLesser(selEndDate, defaultEndDate) || calendar
								.isDateEqual(selEndDate, defaultEndDate))
						&& (calendar.isDateLesser(selStartDate, selEndDate));
				dmDomainDTO.setPlanStartDate(new Date(editDMCustomDTO
						.getEditPlanStartDate().getTime()));
				dmDomainDTO.setPlanEndDate(new Date(editDMCustomDTO
						.getEditPlanEndDate().getTime()));
			} else {
				condtn = true;
				dmDomainDTO.setPlanStartDate(new Date(defaultStartDate
						.getTime()));
				dmDomainDTO.setPlanEndDate(new Date(defaultEndDate.getTime()));
			}

		} else {
			if (selStartDate != null && selEndDate != null) {
				condtn = (calendar.isDateGreater(selStartDate, amendDate) || calendar
						.isDateEqual(selStartDate, amendDate));
				dmDomainDTO.setPlanStartDate(new Date(editDMCustomDTO
						.getEditPlanStartDate().getTime()));
				dmDomainDTO.setPlanEndDate(new Date(editDMCustomDTO
						.getEditPlanEndDate().getTime()));
			} else {
				condtn = true;
				dmDomainDTO.setPlanStartDate(new Date(defaultStartDate
						.getTime()));
				dmDomainDTO.setPlanEndDate(new Date(defaultEndDate.getTime()));
			}

		}
		if (condtn) {
			inventoryManagerLocal = getInventoryManagerLocal();
			try {
				inventoryManagerLocal.updateDMEditInfo(dmDomainDTO);
			} catch (ServiceException se) {
				getSessionContext().setRollbackOnly();
				throw se;
			}
			if (isProposal) {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT);
				proposalContractBO.setInvoiceAmount(0.0);
			} else {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				proposalContractBO.setInvoiceAmount(0.0);
			}

			try {
				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);
			} catch (DomainException d) {
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());

			}
		} else {
			throwServiceException(ErrorCodeConstants.SE0110,
					OPPTMessageCatalog.TYPE_SERVICE);
		}
		timeTaken.end();
		return editDMCustomDTO;
	}

	/**
	 *
	 * This method saves the edited customer information during edit inventory
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param editCustomerCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public EditCustomerCustomDTO saveEditCustomer(
			EditCustomerCustomDTO editCustomerCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "saveEditCustomer");
		String methodName = "saveEditCustomer";
		ProposalContractBO proposalContractBO = null;
		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalCustomDTO proposalCustomDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		CustomerDomainDTO customerDomainDTO = null;
		int proposalId = 0;
		java.util.Date selStartDate = null;
		java.util.Date selEndDate = null;
		java.util.Date defaultStartDate = null;
		java.util.Date defaultEndDate = null;
		java.util.Date amendDate = null;
		boolean condtn = false;
		proposalContractBOFactory = new ProposalContractBOFactory();
		proposalCustomDTO = editCustomerCustomDTO.getProposal();
		customerDomainDTO = new CustomerDomainDTO();
		OPPTCalender calendar = new OPPTCalender();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalCustomDTO.getId());
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de
					.getErrorReport());
		}

		customerDomainDTO.setProposalId(editCustomerCustomDTO
				.getSelectedCustomer().getProposalId());
		customerDomainDTO.setCustomerId(editCustomerCustomDTO
				.getSelectedCustomer().getCustomerId());

		if (editCustomerCustomDTO.getSelectedBillToParty() != null) {
			customerDomainDTO.setBillToPartyNo(editCustomerCustomDTO
					.getSelectedBillToParty().getSAPCustomerNumber());
			customerDomainDTO.setBillToPartyName(editCustomerCustomDTO
					.getSelectedBillToParty().getCustomerName());
			customerDomainDTO.setBillToPartyLNo(editCustomerCustomDTO
					.getSelectedBillToParty().getLegacyCustomerNumber());
			customerDomainDTO.setBillToPartyASNo(editCustomerCustomDTO
					.getSelectedBillToParty().getAddressSequenceNumber());
		} else {
			customerDomainDTO.setBillToPartyNo(null);
			customerDomainDTO.setBillToPartyName(null);
			customerDomainDTO.setBillToPartyLNo(null);
			customerDomainDTO.setBillToPartyASNo(null);
		}

		OPPTLogger.debug("Bill to Party Name---Save"
				+ customerDomainDTO.getBillToPartyName(), CLASS_NAME,
				methodName);
		OPPTLogger.debug("Bill to Party ASNO---Save"
				+ customerDomainDTO.getBillToPartyASNo(), CLASS_NAME,
				methodName);
		if (editCustomerCustomDTO.getSelectedPayer() != null) {
			customerDomainDTO.setPayerNo(editCustomerCustomDTO
					.getSelectedPayer().getSAPCustomerNumber());
			customerDomainDTO.setPayerName(editCustomerCustomDTO
					.getSelectedPayer().getCustomerName());
			customerDomainDTO.setPayerLNo(editCustomerCustomDTO
					.getSelectedPayer().getLegacyCustomerNumber());
			customerDomainDTO.setPayerASNo(editCustomerCustomDTO
					.getSelectedPayer().getAddressSequenceNumber());
		} else {
			customerDomainDTO.setPayerNo(null);
			customerDomainDTO.setPayerName(null);
			customerDomainDTO.setPayerLNo(null);
			customerDomainDTO.setPayerASNo(null);
		}

		OPPTLogger.debug("Payer---Save" + customerDomainDTO.getPayerName(),
				CLASS_NAME, methodName);
		OPPTLogger.debug(
				"Payer ASNO---Save" + customerDomainDTO.getPayerASNo(),
				CLASS_NAME, methodName);

		selStartDate = editCustomerCustomDTO.getEditPlanStartDate();
		selEndDate = editCustomerCustomDTO.getEditPlanEndDate();
		defaultStartDate = editCustomerCustomDTO.getSelectedCustomer()
				.getPlanStartDate();
		defaultEndDate = editCustomerCustomDTO.getSelectedCustomer()
				.getPlanEndDate();
		amendDate = proposalContractBO.getAmendEffectiveDate();

		if (proposalContractBO.isProposal()) {
			if (editCustomerCustomDTO.getEditPlanStartDate() != null
					&& editCustomerCustomDTO.getEditPlanEndDate() != null) {
				condtn = (calendar
						.isDateGreater(selStartDate, defaultStartDate) || calendar
						.isDateEqual(selStartDate, defaultStartDate))
						&& (calendar.isDateLesser(selEndDate, defaultEndDate) || calendar
								.isDateEqual(selEndDate, defaultEndDate))
						&& (calendar.isDateLesser(selStartDate, selEndDate));
				customerDomainDTO
						.setPlanStartDate(new Date(editCustomerCustomDTO
								.getEditPlanStartDate().getTime()));
				customerDomainDTO.setPlanEndDate(new Date(editCustomerCustomDTO
						.getEditPlanEndDate().getTime()));
			} else {
				condtn = true;
				if (defaultStartDate != null) {
					customerDomainDTO.setPlanStartDate(new Date(
							defaultStartDate.getTime()));
					customerDomainDTO.setPlanEndDate(new Date(defaultEndDate
							.getTime()));
				} else {
					customerDomainDTO.setPlanStartDate(null);
					customerDomainDTO.setPlanEndDate(null);
				}
			}
		} else {
			if (editCustomerCustomDTO.getEditPlanStartDate() != null
					&& editCustomerCustomDTO.getEditPlanEndDate() != null) {
				condtn = (calendar.isDateGreater(selStartDate, amendDate) || calendar
						.isDateEqual(selStartDate, amendDate));
				customerDomainDTO
						.setPlanStartDate(new Date(editCustomerCustomDTO
								.getEditPlanStartDate().getTime()));
				customerDomainDTO.setPlanEndDate(new Date(editCustomerCustomDTO
						.getEditPlanEndDate().getTime()));
			} else {
				condtn = true;
				if (defaultStartDate != null) {
					customerDomainDTO.setPlanStartDate(new Date(
							defaultStartDate.getTime()));
					customerDomainDTO.setPlanEndDate(new Date(defaultEndDate
							.getTime()));
				} else {
					customerDomainDTO.setPlanStartDate(null);
					customerDomainDTO.setPlanEndDate(null);
				}
			}
		}

		if (condtn) {
			inventoryManagerLocal = getInventoryManagerLocal();
			try {
				inventoryManagerLocal.updateCustomer(customerDomainDTO);
			} catch (ServiceException se) {
				getSessionContext().setRollbackOnly();
				throw se;
			}
			boolean isProposal = proposalContractBO.isProposal();
			if (isProposal) {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT);
				proposalContractBO.setInvoiceAmount(0.0);
			} else {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				proposalContractBO.setInvoiceAmount(0.0);
			}

			try {
				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);
			} catch (DomainException d) {
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());

			}
		} else {
			throwServiceException(ErrorCodeConstants.SE0109,
					OPPTMessageCatalog.TYPE_SERVICE);
		}
		timeTaken.end();
		return editCustomerCustomDTO;
	}

	/**
	 *
	 * This method saves the edited customer information during edit inventory
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param editSWOCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public EditSWOCustomDTO saveEditSWO(EditSWOCustomDTO editSWOCustomDTO)
			throws ServiceException {
//System.out.println("ProposalManagerBean.saveEditSWO()");
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "saveEditSWO");

		ProposalContractBO proposalContractBO = null;
		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalCustomDTO proposalCustomDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		SWODomainDTO swoDomainDTO = null;
		int proposalId = 0;
		java.util.Date selStartDate = null;
		java.util.Date selEndDate = null;
		java.util.Date defaultStartDate = null;
		java.util.Date defaultEndDate = null;
		java.util.Date amendDate = null;
		boolean condtn = false;
		proposalContractBOFactory = new ProposalContractBOFactory();
		proposalCustomDTO = editSWOCustomDTO.getProposalDTO();
		OPPTCalender calendar = new OPPTCalender();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalCustomDTO.getId());
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de
					.getErrorReport());
		}
		swoDomainDTO = DomainDTOBuildHelper
				.buildSWODomainDTOFromCustomWithOnlyID(editSWOCustomDTO
						.getSelectedSWO(), editSWOCustomDTO
						.getTransactionName());
		selStartDate = editSWOCustomDTO.getEditPlanStartDate();
		selEndDate = editSWOCustomDTO.getEditPlanEndDate();
		defaultStartDate = editSWOCustomDTO.getSelectedSWO().getPlanStartDate();
		defaultEndDate = editSWOCustomDTO.getSelectedSWO().getPlanEndDate();
		amendDate = proposalContractBO.getAmendEffectiveDate();
		if (proposalContractBO.isProposal()) {
			if (selStartDate != null && selEndDate != null) {
				condtn = (calendar
						.isDateGreater(selStartDate, defaultStartDate) || calendar
						.isDateEqual(selStartDate, defaultStartDate))
						&& (calendar.isDateLesser(selEndDate, defaultEndDate) || calendar
								.isDateEqual(selEndDate, defaultEndDate))
						&& (calendar.isDateLesser(selStartDate, selEndDate));
				swoDomainDTO.setPlanStartDate(new Date(editSWOCustomDTO
						.getEditPlanStartDate().getTime()));
				swoDomainDTO.setPlanEndDate(new Date(editSWOCustomDTO
						.getEditPlanEndDate().getTime()));
			} else {
				condtn = true;
				swoDomainDTO.setPlanStartDate(new Date(defaultStartDate
						.getTime()));
				swoDomainDTO.setPlanEndDate(new Date(defaultEndDate.getTime()));
			}

		} else {
			if (selStartDate != null && selEndDate != null) {
				condtn = (calendar.isDateGreater(selStartDate, amendDate) || calendar
						.isDateEqual(selStartDate, amendDate));
				swoDomainDTO.setPlanStartDate(new Date(editSWOCustomDTO
						.getEditPlanStartDate().getTime()));
				swoDomainDTO.setPlanEndDate(new Date(editSWOCustomDTO
						.getEditPlanEndDate().getTime()));
			} else {
				condtn = true;
				swoDomainDTO.setPlanStartDate(new Date(defaultStartDate
						.getTime()));
				swoDomainDTO.setPlanEndDate(new Date(defaultEndDate.getTime()));
			}
		}

		if (condtn) {
			//System.out.println("ProposalManagerBean.saveEditSWO()"+editSWOCustomDTO.getSelectedSWO().getAlternatePrice());
			swoDomainDTO.setAlternatePrice(editSWOCustomDTO.getSelectedSWO()
					.getAlternatePrice());
			validateAlternateAmount(proposalContractBO.getSalesOrg(),
					editSWOCustomDTO.getSelectedSWO().getAlternatePrice());
			SWODomainDTO[] licenses = new SWODomainDTO[1];
			licenses[0] = swoDomainDTO;
			inventoryManagerLocal = getInventoryManagerLocal();
			try {
				inventoryManagerLocal.updateSWODetails(licenses);
			} catch (ServiceException se) {
				getSessionContext().setRollbackOnly();
				throw se;
			}
			boolean isProposal = proposalContractBO.isProposal();
			if (isProposal) {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT);
				proposalContractBO.setInvoiceAmount(0.0);
			} else {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				proposalContractBO.setInvoiceAmount(0.0);
			}

			try {
				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);
			} catch (DomainException d) {
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());
			}

		} else {
			throwServiceException(ErrorCodeConstants.SE0111,
					OPPTMessageCatalog.TYPE_SERVICE);
		}
		timeTaken.end();
		return editSWOCustomDTO;
	}

	/**
	 *
	 * This method calls the corresponding save method to save the Edit
	 * inventory information
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date July 30,2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param editInventoryCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Saravanan Viswanathan New method added below for MN20228979
	 */

	public EditInventoryCustomDTO saveInventory(
			EditInventoryCustomDTO editInventoryCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "saveInventory");
		TreeMap customerList = null;
		customerList = editInventoryCustomDTO.getSelectedCustomers();
		if (null != customerList) {
			Iterator iterator = customerList.values().iterator();
			while (iterator.hasNext()) {
				EditCustomerCustomDTO editCustomerCustomDTO = (EditCustomerCustomDTO) iterator
						.next();
				editCustomerCustomDTO.setProposal(editInventoryCustomDTO
						.getProposal());
				editCustomerCustomDTO.setUserId(editInventoryCustomDTO
						.getUserId());
				editCustomerCustomDTO.setGroupName(editInventoryCustomDTO
						.getGroupName());
				editCustomerCustomDTO.setSessionId(editInventoryCustomDTO
						.getSessionId());
				editCustomerCustomDTO
						.setTransactionName(ActionNameConstants.EDIT_INVENTORY_CUSTOMER);
				saveEditCustomer(editCustomerCustomDTO);
			}
		}

		TreeMap dmList = null;
		dmList = editInventoryCustomDTO.getSelectedDMs();
		if (null != dmList) {
			Iterator iterator = dmList.values().iterator();
			while (iterator.hasNext()) {
				EditDMCustomDTO editDMCustomDTO = (EditDMCustomDTO) iterator
						.next();
				editDMCustomDTO.setProposal(editInventoryCustomDTO
						.getProposal());
				editDMCustomDTO.setUserId(editInventoryCustomDTO.getUserId());
				editDMCustomDTO.setGroupName(editInventoryCustomDTO
						.getGroupName());
				editDMCustomDTO
						.setTransactionName(ActionNameConstants.EDIT_INVENTORY_DM);
				saveEditDM(editDMCustomDTO);
			}
		}

		TreeMap swoList = null;
		swoList = editInventoryCustomDTO.getSelectedSWOs();
		if (null != swoList) {
			Iterator iterator = swoList.values().iterator();
			while (iterator.hasNext()) {
				EditSWOCustomDTO editSWOCustomDTO = (EditSWOCustomDTO) iterator
						.next();
				editSWOCustomDTO.setProposalDTO(editInventoryCustomDTO
						.getProposal());
				editSWOCustomDTO.setUserId(editInventoryCustomDTO.getUserId());
				editSWOCustomDTO.setGroupName(editInventoryCustomDTO
						.getGroupName());
				editSWOCustomDTO
						.setTransactionName(ActionNameConstants.EDIT_INVENTORY_SWO);
				saveEditSWO(editSWOCustomDTO);
			}
		}
		timeTaken.end();
		return editInventoryCustomDTO;
	}

	/**
	 * This method is used to list all the proposals for a User <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 29, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param UserProposalsCustomDTO
	 * @return UserProposalsCustomDTO
	 * @throws ServiceException
	 * @author balajiv
	 */
	public UserProposalsCustomDTO listAllProposalsOfUser(
			UserProposalsCustomDTO userProposalsCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "listAllProposalsOfUser");
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		GroupUserCustomDTO groupUserCustomDTO = userProposalsCustomDTO
				.getGroupUserInfo();
		TreeMap proposalsMap = new TreeMap();
		TreeMap usersMap = new TreeMap();
		String userId = null;
		String groupName = null;
		List proposalContractBOList = new ArrayList();
		if (groupUserCustomDTO != null
				&& groupUserCustomDTO.getSelectedUser() != null) {
			userId = groupUserCustomDTO.getSelectedUser();
			groupName = groupUserCustomDTO.getGroupName();
			if (null != groupUserCustomDTO.getSelectedGroupName()) {
				groupName = groupUserCustomDTO.getSelectedGroupName();
			}
		} else {
			userId = userProposalsCustomDTO.getUserId();
			groupName = userProposalsCustomDTO.getGroupName();
		}

		// Logic for getting proposals created by the user
		try {
			if (null == OPPTHelper.trimStringToNull(groupName)) {
				proposalContractBOList = proposalContractBOFactory
						.findProposalsContractsBOForUsers(userId);
			} else {
				proposalContractBOList = proposalContractBOFactory
						.findProposalsContractsBOForUsersGroup(userId,
								groupName);
			}
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		//TODO should add logic to seperate the groupName details

		proposalsMap = PCMCustomDTOBuilder.buildCustomDTOMap(
				proposalContractBOList,
				PCMCustomDTOBuilder.PROPOSALS_LIST_FOR_USER);
		UserManagerLocalHome userManagerLocalHome = (UserManagerLocalHome) ServiceLocator
				.getEJBHomeFactory().getLocalHome("UserManagerLocalHome");
		UserManagerLocal userManagerLocal = null;
		try {
			userManagerLocal = userManagerLocalHome.create();
		} catch (CreateException e2) {

		}
		if (groupName != null) {
			// user belongs to a group
			UserGroupProfileDomainDTO userGroupProfileDomainDTO = userManagerLocal
					.findUserForGroup(groupName.trim());
			List users = userGroupProfileDomainDTO
					.getUserGroupProfileDomainDTOList();
			usersMap = PCMCustomDTOBuilder.buildGroupUserCustomDTOMap(users,
					userProposalsCustomDTO.getRole());
			groupUserCustomDTO = new GroupUserCustomDTO();
			groupUserCustomDTO.setGroupUsers(usersMap);
			groupUserCustomDTO.setSelectedUser(userId);
			groupUserCustomDTO.setSelectedGroupName(groupName);
			userProposalsCustomDTO.setGroupUserInfo(groupUserCustomDTO);
		} else {
			userProposalsCustomDTO.addButtonFlag(ButtonConstants.LOCK);
			userProposalsCustomDTO.addButtonFlag(ButtonConstants.REALESE);
			userProposalsCustomDTO
					.addButtonFlag(ButtonConstants.ACCESS_HISTORY);
		}
		// logic for getting the shared proposals
		SharingBOFactory sharingBOFactory = new SharingBOFactory();
		List sharingBOList = new ArrayList();
		try {
			sharingBOList = sharingBOFactory.findSharingBOForUsers(userId);
		} catch (DomainException e1) {
			throw ExceptionGenerator.generateServiceException(e1
					.getErrorReport());
		}
		for (int i = 0, size = sharingBOList.size(); i < size; i++) {
			SharingBO sharingBO = (SharingBO) sharingBOList.get(i);
			int sharedProposalId = sharingBO.getProposalId();
			ProposalContractBO sharedProposalBO = null;
			try {
				sharedProposalBO = proposalContractBOFactory
						.getProposalContractBO(sharedProposalId);
			} catch (DomainException de) {
				throw ExceptionGenerator.generateServiceException(de
						.getErrorReport());
			}

			PCMCustomDTOBuilder.updateProposalsContractMap(proposalsMap,
					sharedProposalBO);
		}
		if (proposalsMap.size() == 0) {
			//TODO set message to the user
			ErrorKey key = new ErrorKey("SE0026",
					OPPTMessageCatalog.TYPE_SERVICE);
			ErrorReport errorReport = new ErrorReport();
			errorReport.addErrorEntry(key, null);
			userProposalsCustomDTO.setMessageReport(errorReport);
			userProposalsCustomDTO.addButtonFlag(ButtonConstants.LOCK);
			userProposalsCustomDTO.addButtonFlag(ButtonConstants.REALESE);
			userProposalsCustomDTO
					.addButtonFlag(ButtonConstants.ACCESS_HISTORY);
			userProposalsCustomDTO.addButtonFlag(ButtonConstants.SHARE);
			userProposalsCustomDTO.addButtonFlag(ButtonConstants.REMOVE_SHARE);
			userProposalsCustomDTO.addButtonFlag(ButtonConstants.RENAME);
			userProposalsCustomDTO.addButtonFlag(ButtonConstants.COPY);
			userProposalsCustomDTO.addButtonFlag(ButtonConstants.DELETE);
			userProposalsCustomDTO
					.addButtonFlag(ButtonConstants.CHANGEPROPOSAL_BUTTON);
			userProposalsCustomDTO.addButtonFlag(ButtonConstants.ERROR_HISTORY);
			userProposalsCustomDTO.addButtonFlag(ButtonConstants.CHECK_STATUS);
		} else {
			userProposalsCustomDTO.setProposals(proposalsMap);
		}

		if (userProposalsCustomDTO.getRole() == RoleConstants.BHD || userProposalsCustomDTO.getRole() == RoleConstants.OPPT_READ) {
			userProposalsCustomDTO.addButtonFlag(ButtonConstants.SHARE);
		}
		log.end();
		return userProposalsCustomDTO;
	}

	/**
	 * This method is used to list all the contracts for a User <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 29, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param UserProposalsCustomDTO
	 * @return UserProposalsCustomDTO
	 * @throws ServiceException
	 * @author balajiv
	 */
	public UserContractsCustomDTO listAllContractsOfUser(UserContractsCustomDTO userContractsCustomDTO , boolean isArchive)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "listAllContractsOfUser");
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		GroupUserCustomDTO groupUserCustomDTO = userContractsCustomDTO
				.getGroupUserInfo();
		TreeMap contractsMap = new TreeMap();
		TreeMap usersMap = new TreeMap();
		List proposalContractBOList = new ArrayList();
		Date startDate = null;
		Date endDate = null;
		if (userContractsCustomDTO.getStartDate() != null
				&& userContractsCustomDTO.getEndDate() != null) {
			startDate = new java.sql.Date(userContractsCustomDTO.getStartDate()
					.getTime());
			endDate = new java.sql.Date(userContractsCustomDTO.getEndDate()
					.getTime());
		}
		String userId = null;
		String groupName = null;
		if (groupUserCustomDTO != null
				&& groupUserCustomDTO.getSelectedUser() != null) {
			userId = groupUserCustomDTO.getSelectedUser();
			groupName = groupUserCustomDTO.getGroupName();
			if (null != groupUserCustomDTO.getSelectedGroupName()) {
				groupName = groupUserCustomDTO.getSelectedGroupName();
			}

		} else {
			userId = userContractsCustomDTO.getUserId();
			groupName = userContractsCustomDTO.getGroupName();
		}

		// Logic for getting contracts created by the user
		if (startDate == null && endDate == null) {
			try {
				if (null == OPPTHelper.trimStringToNull(groupName)) {
					proposalContractBOList = proposalContractBOFactory
							.findProposalsContractsBOForUsers(userId);
				} else {
					proposalContractBOList = proposalContractBOFactory
							.findProposalsContractsBOForUsersGroup(userId,
									groupName);
				}
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());

			}

		} else if (startDate != null && endDate != null) {
			try {
				proposalContractBOList = proposalContractBOFactory
						.findContractBOForUserForDateRange(userId, startDate,
								endDate);
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());

			}
		}
		//DAD-001 BlueHarmony Changed by Anand Sugumaran
		if(isArchive){
			contractsMap = PCMCustomDTOBuilder.buildCustomDTOMap(proposalContractBOList, PCMCustomDTOBuilder.ARCHIVE_LIST_FOR_USER);
		}
		else{
		contractsMap = PCMCustomDTOBuilder.buildCustomDTOMap(proposalContractBOList, PCMCustomDTOBuilder.CONTRACT_LIST_FOR_USER);
		}
		UserManagerLocalHome userManagerLocalHome = (UserManagerLocalHome) ServiceLocator
				.getEJBHomeFactory().getLocalHome("UserManagerLocalHome");
		UserManagerLocal userManagerLocal = null;
		try {
			userManagerLocal = userManagerLocalHome.create();
		} catch (CreateException e2) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"listAllContractsOfUser", null, e2);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);

		}
		if (groupName != null) {
			// user belongs to a group
			UserGroupProfileDomainDTO userGroupProfileDomainDTO = userManagerLocal
					.findUserForGroup(groupName);
			List users = userGroupProfileDomainDTO
					.getUserGroupProfileDomainDTOList();
			usersMap = PCMCustomDTOBuilder.buildGroupUserCustomDTOMap(users,
					userContractsCustomDTO.getRole());
			groupUserCustomDTO = new GroupUserCustomDTO();
			groupUserCustomDTO.setGroupUsers(usersMap);
			groupUserCustomDTO.setSelectedUser(userId);
			groupUserCustomDTO.setSelectedGroupName(groupName);
			userContractsCustomDTO.setGroupUserInfo(groupUserCustomDTO);
		} else {
			userContractsCustomDTO.addButtonFlag(ButtonConstants.LOCK);
			userContractsCustomDTO.addButtonFlag(ButtonConstants.REALESE);
			userContractsCustomDTO
					.addButtonFlag(ButtonConstants.ACCESS_HISTORY);

		}
		if (contractsMap.size() == 0) {
			ErrorKey key = new ErrorKey("SE0030",
					OPPTMessageCatalog.TYPE_SERVICE);
			ErrorReport errorReport = new ErrorReport();
			errorReport.addErrorEntry(key, null);
			userContractsCustomDTO.setMessageReport(errorReport);
			userContractsCustomDTO.addButtonFlag(ButtonConstants.LOCK);
			userContractsCustomDTO.addButtonFlag(ButtonConstants.REALESE);
			userContractsCustomDTO.addButtonFlag(ButtonConstants.COPY);
			userContractsCustomDTO.addButtonFlag(ButtonConstants.EASII_COPY);

			userContractsCustomDTO.addButtonFlag(ButtonConstants.AMEND);
			userContractsCustomDTO.addButtonFlag(ButtonConstants.DELETE);
			userContractsCustomDTO.addButtonFlag(ButtonConstants.CLOSE);
			userContractsCustomDTO.addButtonFlag(ButtonConstants.EXTEND);

			userContractsCustomDTO.addButtonFlag(ButtonConstants.RENEW);
			userContractsCustomDTO.addButtonFlag(ButtonConstants.REPLACE);
			userContractsCustomDTO.addButtonFlag(ButtonConstants.REVERT);
			userContractsCustomDTO.addButtonFlag(ButtonConstants.CHECK_STATUS);

			userContractsCustomDTO
					.addButtonFlag(ButtonConstants.VARIANCE_CHECK);
			userContractsCustomDTO
					.addButtonFlag(ButtonConstants.SIMULATE_VARIANCE);
			userContractsCustomDTO
					.addButtonFlag(ButtonConstants.CREATE_VARIANCE);
			userContractsCustomDTO.addButtonFlag(ButtonConstants.ERROR_HISTORY);
			userContractsCustomDTO
					.addButtonFlag(ButtonConstants.ACCESS_HISTORY);

		} else {
			userContractsCustomDTO.setContractCustomDTO(contractsMap);
		}

		if (userContractsCustomDTO.getRole() == RoleConstants.BHD ||userContractsCustomDTO.getRole() == RoleConstants.OPPT_READ ) {
			userContractsCustomDTO.addButtonFlag(ButtonConstants.SHARE);
		}
		log.end();
		return userContractsCustomDTO;
	}

	/**
	 *
	 * This method is used to list the proposals that are waiting for apprval
	 * for a proposal approver <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 6, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param userProposalsCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public ProposalsForApprovalCustomDTO listProposalsForApproval(
			ProposalsForApprovalCustomDTO proposalsForApprovalCustomDTO)
			throws ServiceException {

		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		GroupUserCustomDTO groupUserCustomDTO = proposalsForApprovalCustomDTO
				.getGroupUserInfo();
		TreeMap proposalsMap = new TreeMap();
		TreeMap usersMap = new TreeMap();
		String userId = null;
		String groupName = null;
		List proposalContractBOList = new ArrayList();
		if (groupUserCustomDTO != null
				&& groupUserCustomDTO.getSelectedUser() != null) {
			userId = groupUserCustomDTO.getSelectedUser();
			groupName = groupUserCustomDTO.getGroupName();
			if (null != groupUserCustomDTO.getSelectedGroupName()) {
				groupName = groupUserCustomDTO.getSelectedGroupName();
			}
		} else {
			userId = proposalsForApprovalCustomDTO.getUserId();
			groupName = proposalsForApprovalCustomDTO.getGroupName();
		}
		// Logic for getting proposals waiting for approval for the user
		try {
			proposalContractBOList = proposalContractBOFactory
					.findProposalContractWaitingForApproval(userId);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());

		}
		proposalsMap = PCMCustomDTOBuilder.buildCustomDTOMap(
				proposalContractBOList,
				PCMCustomDTOBuilder.PROPOSAL_CONTRACT_LIST_FOR_APPROVER);
		UserManagerLocalHome userManagerLocalHome = (UserManagerLocalHome) ServiceLocator
				.getEJBHomeFactory().getLocalHome("UserManagerLocalHome");
		UserManagerLocal userManagerLocal = null;
		try {
			userManagerLocal = userManagerLocalHome.create();
		} catch (CreateException e2) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"listAllContractsOfUser", null, e2);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);

		}
		if (groupName != null
				&& (RoleConstants.CREATE_APPROVE != proposalsForApprovalCustomDTO
						.getRole())) {
			// user belongs to a group
			UserGroupProfileDomainDTO userGroupProfileDomainDTO = userManagerLocal
					.findUserForGroup(groupName.trim());
			List users = userGroupProfileDomainDTO
					.getUserGroupProfileDomainDTOList();
			usersMap = PCMCustomDTOBuilder.buildGroupUserCustomDTOMap(users,
					proposalsForApprovalCustomDTO.getRole());
			groupUserCustomDTO = new GroupUserCustomDTO();
			groupUserCustomDTO.setGroupUsers(usersMap);
			groupUserCustomDTO.setSelectedUser(userId);
			groupUserCustomDTO.setSelectedGroupName(groupName);
			proposalsForApprovalCustomDTO.setGroupUserInfo(groupUserCustomDTO);
		} else {
			proposalsForApprovalCustomDTO.addButtonFlag(ButtonConstants.LOCK);
			proposalsForApprovalCustomDTO
					.addButtonFlag(ButtonConstants.REALESE);
			proposalsForApprovalCustomDTO
					.addButtonFlag(ButtonConstants.ACCESS_HISTORY);
		}

		if (proposalsMap.size() == 0) {

			ErrorKey key = new ErrorKey("SE0031",
					OPPTMessageCatalog.TYPE_SERVICE);
			ErrorReport errorReport = new ErrorReport();
			errorReport.addErrorEntry(key, null);
			proposalsForApprovalCustomDTO.setMessageReport(errorReport);
			proposalsForApprovalCustomDTO.addButtonFlag(ButtonConstants.LOCK);
			proposalsForApprovalCustomDTO
					.addButtonFlag(ButtonConstants.REALESE);
			proposalsForApprovalCustomDTO
					.addButtonFlag(ButtonConstants.ACCESS_HISTORY);
		} else {
			proposalsForApprovalCustomDTO.setProposalsForApproval(proposalsMap);

		}

		if (proposalsForApprovalCustomDTO.getRole() == RoleConstants.BHD || proposalsForApprovalCustomDTO.getRole() == RoleConstants.OPPT_READ ) {
			proposalsForApprovalCustomDTO.addButtonFlag(ButtonConstants.SHARE);
		}
		return proposalsForApprovalCustomDTO;
	}

	/**
	 * This method is used for Variance Check process to be performed
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 23, 2003
	 *
	 * revision date author reason 31/05/2004 Vinod Changed as part of changes
	 * for EF0527041417 - CMVCDEFECT 354. Updated code for setting inventory at
	 * period start date. 20/08/2004 Sara Changed as part of changes for
	 * EF0813045921 - CMVCDEFECT 31. Updated code to delete the data from temp
	 * table if the RFC returns successful data on variance check.
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param VarianceHeaderInformationCustomDTO
	 * @return VarianceHeaderInformationCustomDTO
	 * @throws ServiceException
	 * @author Venkat
	 */
	public VarianceHeaderInformationCustomDTO checkVariance(
			VarianceHeaderInformationCustomDTO varianceHeaderInformationCustomDTO)
			throws ServiceException {

		String methodName = "checkVariance";
		TimeTaken log = new TimeTaken(CLASS_NAME, methodName);
		boolean preCondtn = false;
		//Bean instances
		InventoryManagerLocal inventoryManagerLocal = null;
		JMSConnectorLocal jmsConnectorLocal = null;
		//Method Variables
		ProposalDomainDTO proposalDomainDTO = null;
		CustomerDomainDTO customerDomainDTO = null;
		List customerDomainDTOList = null;
		ContractBO contractBO = null;
		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalContractDTOFactory proposalContractDTOFactory = null;
		boolean varianceCondtn = false;

		//connector dto instances
		ConnectorDTOInterface connectorDTO = null;
		CheckVarianceInputConnectorDTO checkVarianceInputConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = null;
		CheckVarianceConnectorDTO checkVarianceConnectorDTO = null;
		CheckVarianceOutputConnectorDTO checkVarianceOutputConnectorDTO = null;

		try {
			//Get the Contract BO object
			proposalContractBOFactory = new ProposalContractBOFactory();

			contractBO = (ContractBO) proposalContractBOFactory
					.getProposalContractBO(varianceHeaderInformationCustomDTO
							.getContractDTO().getId());
			//Verify Whether Preconditions for Check Variance are satisified or
			// not
			HashMap map = new HashMap();
			map.put(UtilityConstants.BO_USERID,
					varianceHeaderInformationCustomDTO.getUserId());
			map.put(UtilityConstants.BO_GROUPNAME,
					varianceHeaderInformationCustomDTO.getGroupName());
			SharingBO sharingBO = getSharingBOFromFactory(contractBO
					.getProposalId(), varianceHeaderInformationCustomDTO
					.getUserId());
			if (null != sharingBO) {
				map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}

			preCondtn = contractBO.isVarianceCheckAllowed(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}

		if (preCondtn) {
			//If variance Check is done before
			try {
				varianceCondtn = contractBO.isVarianceCheckDone();
			} catch (DomainException d) {
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());
			}
			if (varianceCondtn) {
				//Check whether Variance Request for Create and CAP Variance is
				// + Ve
				if ((UtilityConstants.CREATE_VARIANCE
						.equalsIgnoreCase(contractBO.getVarInd()))
						&& (contractBO.getCapVariance() > 0)) {
					varianceHeaderInformationCustomDTO
							.setExternalContractNumber(contractBO
									.getExtContrNo());
					varianceHeaderInformationCustomDTO
							.setProposalType(contractBO.getProposalType());
					varianceHeaderInformationCustomDTO
							.setSoldToCustomerNumber(contractBO
									.getRegCustomerNo());
					varianceHeaderInformationCustomDTO
							.setVarianceDate(contractBO.getVarDate());
					varianceHeaderInformationCustomDTO
							.setContractPeriodEndDate(contractBO
									.getContrEndPeriod());
					varianceHeaderInformationCustomDTO
							.setContractPeriodStartDate(contractBO
									.getContrStartPeriod());
					// varianceHeaderInformationCustomDTO.setInvAtPeriodStartOfContract(contractBO.getInvoiceAmount());
					proposalContractDTOFactory = new ProposalContractDTOFactory();
					try {
						varianceHeaderInformationCustomDTO
								.setInvAtPeriodStartOfContract(proposalContractDTOFactory
										.getInventoryAtPeriodStart(contractBO
												.getProposalId()));
					} catch (SQLException se) {
						OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR,
								CLASS_NAME, methodName, null, se);
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0801);
					}

					varianceHeaderInformationCustomDTO
							.setCumulativeActualInvAsOfVarianceDate(contractBO
									.getCumValue());
					varianceHeaderInformationCustomDTO.setCapAmount(contractBO
							.getCapAmount());
					varianceHeaderInformationCustomDTO
							.setCapVariance(contractBO.getCapVariance());
					varianceHeaderInformationCustomDTO.setCurrency(contractBO
							.getCurrency());
					if (UtilityConstants.CREATE_VARIANCE
							.equalsIgnoreCase(contractBO.getVarInd())) {
						varianceHeaderInformationCustomDTO
								.setVarianceType(VarianceCustomDTO.CREATE_VARIANCE);
						varianceHeaderInformationCustomDTO
								.addButtonFlag(ButtonConstants.VIEW);
						varianceHeaderInformationCustomDTO
								.addButtonFlag(ButtonConstants.DOWNLOAD);
					} else if (UtilityConstants.SIMULATE_VARIANCE
							.equalsIgnoreCase(contractBO.getVarInd())) {
						varianceHeaderInformationCustomDTO
								.setVarianceType(VarianceCustomDTO.SIMULATE_VARIANCE);
					}

				}
				//Get the data from Backend
				else {

					inventoryManagerLocal = getInventoryManagerLocal();
					proposalDomainDTO = new ProposalDomainDTO(contractBO);
					proposalDomainDTO = inventoryManagerLocal
							.retrieveCustomerForProposal(proposalDomainDTO);
					//Create the connector DTO Object and set the values
					checkVarianceInputConnectorDTO = new CheckVarianceInputConnectorDTO();
					genericConnectorDTO = new GenericConnectorDTO();
					//set the generic connector values
					genericConnectorDTO
							.setFunctionModuleName(ConnectorConstants.RFC_CHECK_VARIANCE_OPPT);
					genericConnectorDTO
							.setSessionID(varianceHeaderInformationCustomDTO
									.getSessionId());
					genericConnectorDTO
							.setUserID(varianceHeaderInformationCustomDTO
									.getUserId());
					//Set the checkVarianceInputConnectorDTO values
					checkVarianceInputConnectorDTO.setSalesOrg(contractBO
							.getSalesOrg());
					if (contractBO.getExtContrNo() != null
							&& !(contractBO.getExtContrNo().equals(""))) {
						checkVarianceInputConnectorDTO
								.setExternalContractNumber(contractBO
										.getExtContrNo());
					} else {
						checkVarianceInputConnectorDTO
								.setExternalContractNumber(contractBO
										.getContrNo());
					}
					checkVarianceInputConnectorDTO
							.setIndicatorVarType(contractBO.getVarInd());
					checkVarianceInputConnectorDTO.setVarianceDate(contractBO
							.getVarDate());
					checkVarianceInputConnectorDTO
							.setGenericConnectorDTO(genericConnectorDTO);

					try {

						jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
						checkVarianceOutputConnectorDTO = (CheckVarianceOutputConnectorDTO) jmsConnectorLocal
								.sendReceive(checkVarianceInputConnectorDTO);

					} catch (CreateException c) {
						OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR,
								CLASS_NAME, methodName, null, c);
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0801);
					} catch (Exception e) {
						OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR,
								CLASS_NAME, methodName, null, e);
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0801);
					}
					//Backend request is success.
					//OPPTLogger.debug("RFC Return code" +
					// checkVarianceOutputConnectorDTO.getReturnCode(),
					// CLASS_NAME, methodName);

					if (checkVarianceOutputConnectorDTO != null
							&& (checkVarianceOutputConnectorDTO.getReturnCode() != null && ConnectorConstants.RFC_SUCCESS_CODE
									.equals(checkVarianceOutputConnectorDTO
											.getReturnCode().trim()))) {
						int decimalValue = 0;
						try {
							OPPTLogger.debug(
									"B4 Creating Proposal DataManager",
									CLASS_NAME, methodName);
							ProposalDataManagerLocal proposalDataManagerLocal = HomeProvider
									.getProposalDataManagerLocal();
							if (contractBO.getCurrency() != null) {
								CurrencyDomainDTO currencyDomainDTO = proposalDataManagerLocal
										.getCurrencyInformation(contractBO
												.getCurrency());
								decimalValue = currencyDomainDTO
										.getDecimalAllowed();
							}
						} catch (CreateException c) {
							OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR,
									CLASS_NAME, methodName, null, c);
							throw ExceptionGenerator
									.generateServiceException(ErrorCodeConstants.SE0801);
						}
						/* EF0813045921S */
						try {
							inventoryManagerLocal
									.deleteVarianceInventory(proposalDomainDTO);
						} catch (ServiceException se) {
							getSessionContext().setRollbackOnly();
							throw se;
						}
						/* EF0813045921E */
						DomainDTOBuildHelper.populateProposalDomainDTO(
								proposalDomainDTO,
								checkVarianceOutputConnectorDTO, null, false,
								decimalValue, true);
						customerDomainDTOList = proposalDomainDTO
								.getCustomerDTOList();
						Iterator iterateCustomer = customerDomainDTOList
								.iterator();
						while (iterateCustomer.hasNext()) {
							customerDomainDTO = (CustomerDomainDTO) iterateCustomer
									.next();
							OPPTLogger.debug("B4 Storing variance info",
									CLASS_NAME, methodName);
							inventoryManagerLocal
									.storeVarianceInfo(customerDomainDTO);
							OPPTLogger.debug("After Storing variance info",
									CLASS_NAME, methodName);
						}
						if (null != checkVarianceOutputConnectorDTO
								.getCheckVarianceConnectorDTO()
								.getCapVariance()) {
							String varAmount = checkVarianceOutputConnectorDTO
									.getCheckVarianceConnectorDTO()
									.getCapVariance();
							if (varAmount != null
									&& varAmount.indexOf("-") != -1) {
								varAmount = "-"
										+ varAmount.substring(0, varAmount
												.indexOf("-"));
							}
							OPPTLogger.debug("Cap variance amount ::"
									+ varAmount, CLASS_NAME, methodName);
							contractBO.setCapVariance(DomainDTOBuildHelper
									.convertToPrice(Double
											.parseDouble(varAmount),
											decimalValue));
						}
						if (null != checkVarianceOutputConnectorDTO
								.getCheckVarianceConnectorDTO()
								.getTotalInventoryAmount()) {
							contractBO
									.setCumValue(DomainDTOBuildHelper
											.convertToPrice(
													Double
															.parseDouble(checkVarianceOutputConnectorDTO
																	.getCheckVarianceConnectorDTO()
																	.getTotalInventoryAmount()),
													decimalValue));
						}
						//contractBO.setExtContrNo(checkVarianceOutputConnectorDTO.getCheckVarianceConnectorDTO().getExternalContractNumber());
						try {
							proposalContractBOFactory
									.updateProposalContractBO(contractBO);
						} catch (DomainException d) {
							throw ExceptionGenerator.generateServiceException(d
									.getErrorReport());
						}
						varianceHeaderInformationCustomDTO
								.setExternalContractNumber(checkVarianceOutputConnectorDTO
										.getCheckVarianceConnectorDTO()
										.getExternalContractNumber());
						varianceHeaderInformationCustomDTO
								.setProposalType(contractBO.getProposalType());
						varianceHeaderInformationCustomDTO
								.setSoldToCustomerNumber(contractBO
										.getRegCustomerNo());
						varianceHeaderInformationCustomDTO
								.setVarianceDate(contractBO.getVarDate());
						varianceHeaderInformationCustomDTO
								.setContractPeriodEndDate(contractBO
										.getContrEndPeriod());
						varianceHeaderInformationCustomDTO
								.setContractPeriodStartDate(contractBO
										.getContrStartPeriod());
						// varianceHeaderInformationCustomDTO.setInvAtPeriodStartOfContract(contractBO.getInvoiceAmount());
						proposalContractDTOFactory = new ProposalContractDTOFactory();
						try {
							varianceHeaderInformationCustomDTO
									.setInvAtPeriodStartOfContract(proposalContractDTOFactory
											.getInventoryAtPeriodStart(contractBO
													.getProposalId()));
						} catch (SQLException se) {
							OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR,
									CLASS_NAME, methodName, null, se);
							throw ExceptionGenerator
									.generateServiceException(ErrorCodeConstants.SE0801);
						}

						varianceHeaderInformationCustomDTO
								.setCumulativeActualInvAsOfVarianceDate(contractBO
										.getCumValue());
						varianceHeaderInformationCustomDTO
								.setCapAmount(contractBO.getCapAmount());
						varianceHeaderInformationCustomDTO
								.setCapVariance(contractBO.getCapVariance());
						varianceHeaderInformationCustomDTO
								.setCurrency(contractBO.getCurrency());
						if (UtilityConstants.CREATE_VARIANCE
								.equalsIgnoreCase(contractBO.getVarInd())) {
							varianceHeaderInformationCustomDTO
									.setVarianceType(VarianceCustomDTO.CREATE_VARIANCE);
							if (contractBO.getCapVariance() > 0) {
								varianceHeaderInformationCustomDTO
										.setPositiveCap(true);
								varianceHeaderInformationCustomDTO
										.addButtonFlag(ButtonConstants.VIEW);
								varianceHeaderInformationCustomDTO
										.addButtonFlag(ButtonConstants.DOWNLOAD);
							} else if (contractBO.getCapVariance() <= 0) {
								varianceHeaderInformationCustomDTO
										.addButtonFlag(ButtonConstants.CREATE_VARIANCE_PROPOSAL_BUTTON);
								varianceHeaderInformationCustomDTO
										.addButtonFlag(ButtonConstants.VIEW);
								varianceHeaderInformationCustomDTO
										.addButtonFlag(ButtonConstants.DOWNLOAD);
							}

						} else if (UtilityConstants.SIMULATE_VARIANCE
								.equalsIgnoreCase(contractBO.getVarInd())) {
							varianceHeaderInformationCustomDTO
									.setVarianceType(VarianceCustomDTO.SIMULATE_VARIANCE);
							if (contractBO.getCapVariance() > 0
									|| contractBO.getCapVariance() < 0) {
								varianceHeaderInformationCustomDTO
										.setShowOption(true);
								varianceHeaderInformationCustomDTO
										.addButtonFlag(ButtonConstants.CREATE_VARIANCE_PROPOSAL_BUTTON);
							} else {
								varianceHeaderInformationCustomDTO
										.setShowOption(false);
								varianceHeaderInformationCustomDTO
										.addButtonFlag(ButtonConstants.VIEW);
								varianceHeaderInformationCustomDTO
										.addButtonFlag(ButtonConstants.DOWNLOAD);
								varianceHeaderInformationCustomDTO
										.addButtonFlag(ButtonConstants.CREATE_VARIANCE_PROPOSAL_BUTTON);
							}
						}
					} //If any errors from Backend
					else {
						storeErrorList(checkVarianceOutputConnectorDTO
								.getReturnCode(), contractBO.getProposalId(),
								varianceHeaderInformationCustomDTO.getUserId(),
								methodName);
						throwServiceException(checkVarianceOutputConnectorDTO
								.getReturnCode(),
								OPPTMessageCatalog.TYPE_BACKEND);
					}
				}
			}
			//if variance check is not done
			else {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0501);

			}
		} else {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0500);
		}

		log.end();
		return varianceHeaderInformationCustomDTO;
	} //end of checkVariance.

	/**
	 * This method is used for delete the variance records(Temp values)
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 23, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param VarianceHeaderInformationCustomDTO
	 * @return VarianceHeaderInformationCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */

	public VarianceHeaderInformationCustomDTO deleteTempVarianceValues(
			VarianceHeaderInformationCustomDTO varianceHeaderInformationCustomDTO)
			throws ServiceException {
		String methodName = "deleteTempVarianceValues";
		TimeTaken log = new TimeTaken(CLASS_NAME, methodName);
		boolean preCondtn = false;
		//Bean instances
		InventoryManagerLocal inventoryManagerLocal = null;
		ProposalContractBO proposalContractBO = null;
		ProposalDomainDTO proposalDomainDTO = null;
		ProposalContractBOFactory proposalContractBOFactory = null;
		try {
			proposalContractBOFactory = new ProposalContractBOFactory();
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(varianceHeaderInformationCustomDTO
							.getContractDTO().getId());
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}

		proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
		try {
			inventoryManagerLocal = getInventoryManagerLocal();
			if ((UtilityConstants.SIMULATE_VARIANCE
					.equalsIgnoreCase(proposalContractBO.getVarInd()) && proposalContractBO
					.getCapVariance() <= 0)) {
				inventoryManagerLocal
						.deleteVarianceInventory(proposalDomainDTO);
				proposalContractBO.setCapVariance(0);
			}

		} catch (ServiceException se) {
			getSessionContext().setRollbackOnly();
			throw se;
		}

		try {
			proposalContractBOFactory
					.updateProposalContractBO(proposalContractBO);

		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		log.end();
		return varianceHeaderInformationCustomDTO;
	}

	/**
	 *
	 * Private method to add error entries to Error Report
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param
	 * @return
	 * @throws
	 * @author prakash
	 */
	private void addErrorEntry(ErrorReport errorReport, String msgID) {
		ErrorKey errorKey = new ErrorKey(msgID, OPPTMessageCatalog.TYPE_SERVICE);
		errorReport.addErrorEntry(errorKey, null);
	}

	private void throwServiceException(ErrorReport errorReport)
			throws ServiceException {
		if (errorReport.size() > 0) {
			ServiceException serviceException = new ServiceException();
			serviceException.setErrorReport(errorReport);
			throw serviceException;
		}
	}

	/**
	 *
	 * Method to check if a proposal can be renamed
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 26, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param ProposalCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author prakash
	 */
	public void renameProposal(ProposalCustomDTO proposalCustomDTO)
			throws ServiceException {

		if (proposalCustomDTO.isConfirmationRequired()) {
			try {

				SharingBO shareBO = getSharingBOFromFactory(proposalCustomDTO
						.getId(), proposalCustomDTO.getUserId());
				ProposalBO proposalBO = (ProposalBO) getProposalContractBOFromFactory(proposalCustomDTO
						.getId());
				HashMap compareValues = populateCompareValuesForUserAuthInProposalBO(
						proposalCustomDTO, shareBO);

				proposalBO.validateForRename(
						UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
						compareValues);

			} catch (DomainException ex) {
				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}
		} else {

			ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
			boolean isNameExist = proposalContractBOFactory
					.isProposalNameExists(proposalCustomDTO.getName());

			if (isNameExist) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0018);
			} else {
				try {
					if (!isNameExist) {
						ProposalBO proposalBO = (ProposalBO) getProposalContractBOFromFactory(proposalCustomDTO
								.getId());
						proposalBO.setProposalName(proposalCustomDTO.getName());
						proposalBO.setAutoPopulate(UtilityConstants.NO);
						proposalContractBOFactory
								.updateProposalContractBO(proposalBO);

					}
				} catch (DomainException ex) {
					throw ExceptionGenerator.generateServiceException(ex
							.getErrorReport());
				}
			}
		}
	}

	/**
	 *
	 * Method to retrieve the Proposal History
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 26, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param ProposalHistoryCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author prakash
	 */
	public ProposalHistoryCustomDTO getProposalHistory(
			ProposalHistoryCustomDTO proposalHistoryCustomDTO)
			throws ServiceException {
		ErrorReport errorReport = new ErrorReport();
		List accessHistoryBOList = null;
		List actionDescriptionBOList=null;
		
		

		AccessHistoryBOFactory accessHistoryBOFactory = new AccessHistoryBOFactory();
		ActionDescriptionBOFactory actionDescriptionBOFactory=new ActionDescriptionBOFactory();
		
		
		ProposalCustomDTO proposalCustomDTO = proposalHistoryCustomDTO
				.getProposalDTO();

		if (null == proposalHistoryCustomDTO.getGroupName()) {
			throw ExceptionGenerator.generateServiceException("SE0402");
		}

		try {
			accessHistoryBOList = accessHistoryBOFactory
					.findAccessHistoryForProposal(proposalCustomDTO.getId(),
							null);
		} catch (DomainException ex) {
			proposalHistoryCustomDTO.setMessageReport(ex.getErrorReport());
		}

		Iterator accessHistoryIterator = accessHistoryBOList.iterator();
		while (accessHistoryIterator.hasNext()) {
			ProposalHistoryDataCustomDTO proposalHistoryDataCustomDTO = new ProposalHistoryDataCustomDTO();
			AccessHistoryBO accessHistoryBO = (AccessHistoryBO) accessHistoryIterator
					.next();
			proposalHistoryDataCustomDTO.setOperationPerformed(accessHistoryBO.getOperationPerformed());
			//System.out.println("ProposalManagerBean.getProposalHistory()==>"+accessHistoryBO.getOperationPerformed());
			String desc = OPPTStaticDataHolder.getOperationDesc(accessHistoryBO.getOperationPerformed()); //retriving data from table
			//System.out.println("ProposalManagerBean.getProposalHistory()desc <=="+desc);
			proposalHistoryDataCustomDTO.setDescription(desc);
			
			proposalHistoryDataCustomDTO.setUserId(accessHistoryBO
					.getUserId());
		
			proposalHistoryDataCustomDTO.setSequenceNo(accessHistoryBO
					.getSequenceNo());
			proposalHistoryDataCustomDTO.setAccessDate(accessHistoryBO
					.getAccessDate());
			
			proposalHistoryDataCustomDTO.setAccessTime(accessHistoryBO
					.getAccessTime());
			//System.out.println("ProposalManagerBean.getProposalHistory()"+proposalCustomDTO.getOldContractNumber());
			proposalHistoryDataCustomDTO.setAdditionalInfo(proposalCustomDTO.getOldContractNumber());
			
			proposalHistoryCustomDTO
					.addAccessHistory(proposalHistoryDataCustomDTO);

		}
		return proposalHistoryCustomDTO;
	}

	/**
	 * This method is called to release a lock on a proposal
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @return
	 * @author Kedar Harischandrakar
	 * @exception DomainException
	 * @param ReleaseLockOnProposalCustomDTO
	 */
	public ReleaseLockOnProposalCustomDTO releaseLockOnProposal(
			ReleaseLockOnProposalCustomDTO releaseLockOnProposalCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "releaseLockOnProposal");

		try {
			ProposalContractBOFactory factory = new ProposalContractBOFactory();

			if (factory.isProposalNameExists(releaseLockOnProposalCustomDTO
					.getProposalName()) == false) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0336);
			}

			try {
				ProposalContractBO proposalContractBO = factory
						.getProposalContractBO(releaseLockOnProposalCustomDTO
								.getProposalName());
				proposalContractBO.setLockedBy(null);
				proposalContractBO.setLockedOn(null);

				factory.updateProposalContractBO(proposalContractBO);
				/* Start change CR0801074150 - CBS OPPT activity logging */
				OPPTLogger.infoActivityLogger("Geo Security officer "
						+ releaseLockOnProposalCustomDTO.getUserId()
						+ " released lock on proposal "
						+ releaseLockOnProposalCustomDTO.getProposalName()
						+ "!", CLASS_NAME, "");
				String message="Geo Security officer "
					+ releaseLockOnProposalCustomDTO.getUserId()
					+ " released lock on proposal "
					+ releaseLockOnProposalCustomDTO.getProposalName()
					+ "!";
				createActivityLog(releaseLockOnProposalCustomDTO.getUserId(),message);
				/* End change CR0801074150 - CBS OPPT activity logging */
				return releaseLockOnProposalCustomDTO;

			} catch (DomainException ex) {
				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *
	 * This method deletes the inventory
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 30, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param deleteInventoryCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public DeleteInventoryCustomDTO deleteInventory(
			DeleteInventoryCustomDTO deleteInventoryCustomDTO)
			throws ServiceException {

		ProposalCustomDTO proposalCustomDTO = null;
		ProposalCustomerCustomDTO customerCustomDTO = null;
		DMCustomDTO dmCustomDTO = null;
		SWOCustomDTO swoCustomDTO = null;
		List customerCustomDTOList = null;
		List dmCustomDTOList = null;
		List swoCustomDTOList = null;
		ProposalContractBO proposalContractBO = null;
		ProposalContractBOFactory proposalContractBOFactory = null;
		CustomerDomainDTO customerDomainDTO = null;
		DMDomainDTO dmDomainDTO = null;
		SWODomainDTO swoDomainDTO = null;
		ProposalBO proposalBO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		boolean authority = false;
		proposalCustomDTO = deleteInventoryCustomDTO.getProposal();
		proposalContractBOFactory = new ProposalContractBOFactory();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalCustomDTO.getId());
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}
		if (deleteInventoryCustomDTO != null
				&& deleteInventoryCustomDTO.isConfirmationRequired()) {
			try {
				HashMap map = new HashMap();
				map.put(UtilityConstants.BO_USERID, deleteInventoryCustomDTO
						.getUserId());
				map.put(UtilityConstants.BO_GROUPNAME, deleteInventoryCustomDTO
						.getGroupName());
				SharingBO sharingBO = getSharingBOFromFactory(
						proposalContractBO.getProposalId(),
						deleteInventoryCustomDTO.getUserId());
				if (null != sharingBO) {
					map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
							.getAccessType());
				}
				proposalContractBO.validateDeleteInventory(
						UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);
				authority = true;

			} catch (DomainException d) {
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());
			}
			if (!authority) {
				throwServiceException(ErrorCodeConstants.SE0112,
						OPPTMessageCatalog.TYPE_SERVICE);
			}

		} else {

			customerCustomDTOList = deleteInventoryCustomDTO.getCustomers();
			dmCustomDTOList = deleteInventoryCustomDTO.getDMs();
			swoCustomDTOList = deleteInventoryCustomDTO.getSwos();
			inventoryManagerLocal = getInventoryManagerLocal();

			if (customerCustomDTOList != null
					&& customerCustomDTOList.size() > 0) {
				for (int i = 0; i < customerCustomDTOList.size(); i++) {
					customerCustomDTO = (ProposalCustomerCustomDTO) customerCustomDTOList
							.get(i);
					if (customerCustomDTO != null
							&& customerCustomDTO.getCustomerId() != -1) {
						customerDomainDTO = new CustomerDomainDTO();
						customerDomainDTO.setCustomerId(customerCustomDTO
								.getCustomerId());
						customerDomainDTO.setProposalId(customerCustomDTO
								.getProposalId());
						customerDomainDTO
								.setActionName(ActionNameConstants.DELETE_INVENTORY_CUSTOMER);
						inventoryManagerLocal
								.copyStoreCustomerInfo(customerDomainDTO);
						inventoryManagerLocal
								.removeCustomerDetail(customerDomainDTO);
					}
				}

			}
			if (dmCustomDTOList != null && dmCustomDTOList.size() > 0) {
				for (int i = 0; i < dmCustomDTOList.size(); i++) {
					dmCustomDTO = (DMCustomDTO) dmCustomDTOList.get(i);
					if (dmCustomDTO != null && dmCustomDTO.getId() != null) {
						dmDomainDTO = new DMDomainDTO();
						dmDomainDTO.setDmId(Integer.parseInt(dmCustomDTO
								.getId()));
						dmDomainDTO.setCustomerId(Integer.parseInt(dmCustomDTO
								.getCustomerId()));
						dmDomainDTO.setProposalId(dmCustomDTO.getProposalId());
						dmDomainDTO
								.setActionName(ActionNameConstants.DELETE_INVENTORY_DM);
						inventoryManagerLocal.removeDMDetails(dmDomainDTO);
					}
				}

			}
			if (swoCustomDTOList != null && swoCustomDTOList.size() > 0) {
				for (int i = 0; i < swoCustomDTOList.size(); i++) {
					swoCustomDTO = (SWOCustomDTO) swoCustomDTOList.get(i);
					if (swoCustomDTO != null && swoCustomDTO.getId() != null) {
						swoDomainDTO = new SWODomainDTO();
						swoDomainDTO.setSwoId(Integer.parseInt(swoCustomDTO
								.getId()));
						swoDomainDTO.setDmId(Integer.parseInt(swoCustomDTO
								.getDMId()));
						swoDomainDTO.setCustomerId(Integer
								.parseInt(swoCustomDTO.getCustomerId()));
						swoDomainDTO
								.setProposalId(swoCustomDTO.getProposalId());
						swoDomainDTO
								.setActionName(ActionNameConstants.DELETE_INVENTORY_SWO);
						//CR2031
						if (ActionNameConstants.CONFIRM_DELETE_DUPLICATE_SERIAL_NUMBER
								.equals(deleteInventoryCustomDTO
										.getTransactionName())) {
							swoDomainDTO.setMarkedForDeletion(true);
						}
						inventoryManagerLocal.removeSWODetails(swoDomainDTO);
					}
				}
			}
			boolean isProposal = proposalContractBO.isProposal();
			if (isProposal) {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT);
				proposalContractBO.setInvoiceAmount(0.0);
			} else {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				proposalContractBO.setInvoiceAmount(0.0);
			}

			try {
				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);
			} catch (DomainException d) {
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());
			}
		}
		return deleteInventoryCustomDTO;
	}

	/**
	 *
	 * Method to list all the Error Details of a Proposal
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 29, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param ErrorHistoryCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author prakash
	 */
	public ErrorHistoryCustomDTO viewErrorHistory(
			ErrorHistoryCustomDTO errorHistoryCustomDTO)
			throws ServiceException {

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "viewErrorHistory");
		ErrorListBOFactory errorListBOFactory = new ErrorListBOFactory();
		ProposalCustomDTO proposalCustomDTO = errorHistoryCustomDTO
				.getProposalDTO();
		List errorList = new ArrayList();
		ErrorListBO errorListBO = null;
		ErrorReport errorReport = new ErrorReport();
		boolean deleteAllowed = true;

		try {
			errorList = errorListBOFactory
					.findErrorListBOForProposal(proposalCustomDTO.getId());

			if (0 == errorList.size()) {
				errorHistoryCustomDTO.addButtonFlag(ButtonConstants.DELETE);
			}
			Iterator iter = errorList.iterator();
			while (iter.hasNext()) {
				errorListBO = (ErrorListBO) iter.next();
				errorHistoryCustomDTO.addErrorInfo(PCMCustomDTOBuilder
						.populateErrorHistoryCustomDTOFromBO(errorListBO));
			}
			if (null != errorHistoryCustomDTO.getGroupName()) {
				if (null == proposalCustomDTO.getLockedBy()) {
					deleteAllowed = false;
				} else if (!proposalCustomDTO.getLockedBy().equals(
						errorHistoryCustomDTO.getUserId())) {
					deleteAllowed = false;
				}
			} else {
				if (ProposalContractStatusConstants.AMENDED_CONTRACT_PENDING_APPROVAL
						.equals(proposalCustomDTO.getStatus())
						|| ProposalContractStatusConstants.EXTENDED_CONTRACT_PENDING_APPROVAL
								.equals(proposalCustomDTO.getStatus())
						|| ProposalContractStatusConstants.VARIANCE_CLOSURE_PENDING_APROVAL
								.equals(proposalCustomDTO.getStatus())) {
					deleteAllowed = false;
				}
			}
			errorHistoryCustomDTO.setEditable(deleteAllowed);
			if (!deleteAllowed) {
				errorHistoryCustomDTO.addButtonFlag(ButtonConstants.DELETE);
			}
		} catch (DomainException ex) {
			errorHistoryCustomDTO.setMessageReport(ex.getErrorReport());
		}
		timeTaken.end();
		return errorHistoryCustomDTO;
	}

	/**
	 *
	 *
	 * Method to Delete the Error History of a Proposal
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 30, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param ErrorHistoryCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author prakash
	 */
	public void deleteErrorHistory(ErrorHistoryCustomDTO errorHistoryCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "DeleteErrorHistory");

		ProposalCustomDTO proposalCustomDTO = errorHistoryCustomDTO
				.getProposalDTO();
		TreeMap errorInfoMap = errorHistoryCustomDTO.getErrorInfos();

		Iterator errorMsgIdIterator = errorInfoMap.keySet().iterator();
		ErrorListBOFactory errorListBOFactory = new ErrorListBOFactory();
		while (errorMsgIdIterator.hasNext()) {
			try {
				errorListBOFactory
						.deleteErrorListBO((Integer) errorMsgIdIterator.next());
			} catch (DomainException ex) {
				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}
		}
		timeTaken.end();

	}

	/**
	 * Method to Price a proposal
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 30, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param PropoalCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author balajiv
	 */
	public ProposalCustomDTO priceProposal(ProposalCustomDTO proposalCustomDTO)
			throws ServiceException {
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		// int proposalId = proposalCustomDTO.getId();
		ProposalContractBO proposalContractBO = null;
		SharingBO shareBO = null;
		HashMap compareValues = null;

		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalCustomDTO.getId());
			shareBO = getSharingBOFromFactory(proposalCustomDTO.getId(),
					proposalCustomDTO.getUserId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					proposalCustomDTO, shareBO);
			if (proposalContractBO.isProposal()) {
				// Proposal
				ProposalBO proposalBO = (ProposalBO) proposalContractBO;
				proposalBO.validateForPricing(
						UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
						compareValues);

			} else {
				// Contract
				ContractBO contracBO = (ContractBO) proposalContractBO;
				contracBO.validateForPricing(
						UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
						compareValues);
			}

		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}
		ProposalDataManagerLocal proposalDataManagerLocal = null;
		try {
			proposalDataManagerLocal = HomeProvider
					.getProposalDataManagerLocal();
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"priceProposal", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		CurrencyDomainDTO currency = proposalDataManagerLocal
				.getCurrencyInformation(proposalContractBO.getCurrency());
		PriceProposalDomainDTO priceProposalDomainDTO = new PriceProposalDomainDTO(
				proposalContractBO);
		priceProposalDomainDTO.setDecimalsAllowed(currency.getDecimalAllowed());

		PriceManagerLocal priceManagerLocal = null;
		try {
			priceManagerLocal = HomeProvider.getPriceManagerLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"priceProposal", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);

		}
		priceManagerLocal.priceProposal(priceProposalDomainDTO);
		ErrorReport messages = priceProposalDomainDTO.getMessageReport();
		if (messages == null) {
			messages = new ErrorReport();
		}

		if (SalesOrgConstants.JAPAN.equals(proposalContractBO.getSalesOrg()) || (SalesOrgConstants.KOREA.equals(proposalContractBO.getSalesOrg()))) {
		if (!OPPTHelper.validNumberRangeForJapan(priceProposalDomainDTO.getAnnualInvoiceAmt())) {
				ExceptionGenerator.addErrorEntry(messages, ErrorCodeConstants.SE0711, OPPTMessageCatalog.TYPE_SERVICE);
				priceProposalDomainDTO.setMessageReport(messages);
			}
			if (!OPPTHelper.validNumberRangeForJapan(priceProposalDomainDTO.getSAndsDiscount())) {
				ExceptionGenerator.addErrorEntry(messages, ErrorCodeConstants.SE0710, OPPTMessageCatalog.TYPE_SERVICE);
				priceProposalDomainDTO.setMessageReport(messages);

			}
		} else if (SalesOrgConstants.VIETNAM.equals(proposalContractBO.getSalesOrg()))  {
		if (!OPPTHelper.validNumberRangeForVietnam(priceProposalDomainDTO.getAnnualInvoiceAmt())) {
				ExceptionGenerator.addErrorEntry(messages, ErrorCodeConstants.SE0716, OPPTMessageCatalog.TYPE_SERVICE);
				priceProposalDomainDTO.setMessageReport(messages);
			}
			if (!OPPTHelper.validNumberRangeForVietnam(priceProposalDomainDTO.getSAndsDiscount())) {
				ExceptionGenerator.addErrorEntry(messages, ErrorCodeConstants.SE0715, OPPTMessageCatalog.TYPE_SERVICE);
				priceProposalDomainDTO.setMessageReport(messages);

			}
		} else {
			if (!OPPTHelper.validNumberRange(priceProposalDomainDTO
					.getAnnualInvoiceAmt())) {
				ExceptionGenerator.addErrorEntry(messages,
						ErrorCodeConstants.SE0706,
						OPPTMessageCatalog.TYPE_SERVICE);
				priceProposalDomainDTO.setMessageReport(messages);
			}
			if (!OPPTHelper.validNumberRange(priceProposalDomainDTO
					.getSAndsDiscount())) {
				ExceptionGenerator.addErrorEntry(messages,
						ErrorCodeConstants.SE0708,
						OPPTMessageCatalog.TYPE_SERVICE);
				priceProposalDomainDTO.setMessageReport(messages);
			}
		}
		PCMCustomDTOBuilder.populateProposalContractForPricing(
				proposalContractBO, priceProposalDomainDTO);
		try {
			proposalContractBOFactory
					.updateProposalContractBO(proposalContractBO);
		} catch (DomainException e2) {
			getSessionContext().setRollbackOnly();
			throw ExceptionGenerator.generateServiceException(e2
					.getErrorReport());
		}

		if (priceProposalDomainDTO.getMessageReport() != null
				&& priceProposalDomainDTO.getMessageReport().size() > 0) {
			proposalCustomDTO.setMessageReport(priceProposalDomainDTO
					.getMessageReport());
		}

		return proposalCustomDTO;
	}

	/**
	 *
	 *
	 * Method to Lock a Proposal/ Contract
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 31, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author prakash
	 */
	public void lockProposal(ProposalCustomDTO proposalCustomDTO)
			throws ServiceException {

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "lockProposal");

		boolean proposalCanBeLocked = false;
		String loggedInUser = proposalCustomDTO.getUserId();
		ErrorReport errorReport = new ErrorReport();

		SharingBO shareBO = null;
		ProposalContractBO proposalContractBO = null;
		HashMap compareValues = null;

		try {
			shareBO = getSharingBOFromFactory(proposalCustomDTO.getId(),
					loggedInUser);
			proposalContractBO = getProposalContractBOFromFactory(proposalCustomDTO
					.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					proposalCustomDTO, shareBO);

			compareValues.put(UtilityConstants.USER_ROLE, new Integer(
					proposalCustomDTO.getRole()));

			proposalCanBeLocked = proposalContractBO
					.validateForLock(compareValues);
		} catch (DomainException ex) {
			throwServiceException(ex.getErrorReport());
		}

		if (proposalCanBeLocked) {

			String proposalCreatedBy = proposalContractBO.getCreatedBy();

			if (!proposalContractBO.isCreatedByLoggedUser(loggedInUser)) {
				if (!proposalContractBO
						.isLoggedUserApproverOfProposal(loggedInUser)) {

					// verify User profile. Call to ESW
					CompareAuthorInputConnectorDTO compareAuthorInputConnectorDTO = new CompareAuthorInputConnectorDTO();
					compareAuthorInputConnectorDTO
							.setFunctionModuleName(ConnectorConstants.RFC_COMPARE_AUTHOR_OPPT);
					compareAuthorInputConnectorDTO
							.setSessionID(proposalCustomDTO.getSessionId());
					compareAuthorInputConnectorDTO
							.setAdminFlag(UtilityConstants.ADMIN_FLAG);
					compareAuthorInputConnectorDTO
							.setUserID1(proposalCreatedBy);
					compareAuthorInputConnectorDTO.setUserID2(loggedInUser);

					JMSConnectorLocal jmsConnectorLocal = null;
					CompareAuthorOutputConnectorDTO compareAuthorOutputConnectorDTO = new CompareAuthorOutputConnectorDTO();

					try {
						jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
						compareAuthorOutputConnectorDTO = (CompareAuthorOutputConnectorDTO) jmsConnectorLocal
								.sendReceive(compareAuthorInputConnectorDTO);
					} catch (Exception e) {
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0801);
					}

					if (UtilityConstants.ZERO != Integer
							.parseInt(compareAuthorOutputConnectorDTO
									.getReturnCode())) {
						// add an error entry
						storeErrorList(compareAuthorOutputConnectorDTO
								.getReturnCode(), proposalCustomDTO.getId(),
								loggedInUser, proposalCustomDTO
										.getTransactionName());
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0403);
					}
				}
			}

			ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
			proposalContractBO.setLockedBy(proposalCustomDTO.getUserId());

			java.util.Date today = new java.util.Date();
			proposalContractBO.setLockedOn(new java.sql.Date(today.getTime()));

			try {
				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);
				// creates Access history
				createAccessHistory(proposalCustomDTO.getId(),
						proposalCustomDTO.getUserId(), proposalCustomDTO
								.getTransactionName());
			} catch (DomainException ex) {
				throw ExceptionGenerator.generateServiceException("SE0801");
			}
		}
		timeTaken.end();
	}

	/**
	 *
	 * This method releases the lock from a proposal
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 6, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param ProposalCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Prakash
	 */
	public void releaseProposal(ProposalCustomDTO proposalCustomDTO)
			throws ServiceException {

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "releaseProposal");

		ProposalContractBO proposalContractBO = null;
		HashMap compareValues = null;
		boolean releaseProposal = false;

		try {
			proposalContractBO = getProposalContractBOFromFactory(proposalCustomDTO
					.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					proposalCustomDTO, null);
			releaseProposal = proposalContractBO
					.validateForRelease(compareValues);
		} catch (DomainException ex) {
			throwServiceException(ex.getErrorReport());
		}

		if (releaseProposal) {

			ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
			Date lockedOn = null;
			String lockedBy = null;

			proposalContractBO.setLockedBy(lockedBy);
			proposalContractBO.setLockedOn(lockedOn);
			try {
				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);
			} catch (DomainException ex) {
				throwServiceException(ex.getErrorReport());
			}
		}
		timeTaken.end();
	}

	/**
	 * This method is called to get the target users for proposal transfer
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @return
	 * @author Kedar Harischandrakar
	 * @exception DomainException
	 * @param TransferProposalsCustomDTO
	 */
	public TransferProposalsCustomDTO getTargetUsers(
			TransferProposalsCustomDTO transferProposalsCustomDTO)
			throws ServiceException {
		String methodName = "getTargetUsers";

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		List createdProposals = null;
		List approveProposals = null;

		UserManagerLocalHome userManagerLocalHome = (UserManagerLocalHome) ServiceLocator
				.getEJBHomeFactory().getLocalHome("UserManagerLocalHome");
		UserManagerLocal userManagerLocal = null;
		try {
			userManagerLocal = userManagerLocalHome.create();
		} catch (CreateException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"listProposalsForReport", null, ex);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		try {
			ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();

			UserCustomDTO userDTO = transferProposalsCustomDTO.getSourceUser();

			String sourceUser = OPPTHelper.trimString(userDTO.getUserId());
			int role = userDTO.getRole();
			boolean proposalsExist = false;

			ErrorReport errorReport = ExceptionGenerator.addErrorEntry(null,
					ErrorCodeConstants.SE0213, OPPTMessageCatalog.TYPE_SERVICE);

			if (role == RoleConstants.PROPOSAL_APPROVER) {
				approveProposals = proposalContractBOFactory
						.findProposalContractBOApprovedBy(sourceUser);
				if (null != approveProposals && 0 < approveProposals.size()) {
					proposalsExist = true;
				}
			} else if (role == RoleConstants.CREATE_APPROVE) {
				createdProposals = proposalContractBOFactory
						.findProposalsContractsBOForUsers(sourceUser);
				approveProposals = proposalContractBOFactory
						.findProposalContractBOApprovedBy(sourceUser);

				if (null != createdProposals && 0 < createdProposals.size()) {
					proposalsExist = true;
				} else if (null != approveProposals
						&& 0 < approveProposals.size()) {
					proposalsExist = true;
				}
			} else {
				createdProposals = proposalContractBOFactory
						.findProposalsContractsBOForUsers(sourceUser);
				if (null != createdProposals && 0 < createdProposals.size()) {
					proposalsExist = true;
				}
			}

			if (!proposalsExist && RoleConstants.BHD == role || !proposalsExist && RoleConstants.OPPT_READ == role) {
				SharingBOFactory sharingBOFactory = new SharingBOFactory();

				List usersSharingList = sharingBOFactory
						.findSharingBOForUsers(sourceUser);
				proposalsExist = (null != usersSharingList && 0 < usersSharingList
						.size());
			}

			if (!proposalsExist) {
				transferProposalsCustomDTO.setMessageReport(errorReport);
			} else {
				UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();

				List userProfileList = userProfileBOFactory
						.findUserProfileBOForSalesOrg(OPPTHelper
								.trimString(userDTO.getSalesOrg()));

				TreeMap targetUsersMap = new TreeMap();
				TreeMap createApproveUsersMap = new TreeMap();
				TreeMap proposalApproveUsersMap = new TreeMap();

				if (null != userProfileList) {
					for (int i = 0; i < userProfileList.size(); i++) {
						UserProfileBO userProfileBO = (UserProfileBO) userProfileList
								.get(i);

						if (userProfileBO.validateForTransferProposal(role,
								sourceUser)) {
							/* Groups Code - Begin changes */
							/*
							 * if(!userManagerLocal.isTargetUserEligibleForTransfer(sourceUser,userProfileBO.getUserId())) {
							 * continue; }
							 */
							/* Groups Code - End changes */
							UserCustomDTO userCustom = new UserCustomDTO();
							userCustom.setUserId(userProfileBO.getUserId());
							userCustom.setRole(userProfileBO.getRole());

							if (role == RoleConstants.CREATE_APPROVE) {
								if (isUserValidForTransfer(approveProposals,
										userProfileBO.getUserId())) {
									if (userProfileBO.getRole() == RoleConstants.CREATE_APPROVE) {
										createApproveUsersMap.put(userCustom
												.getUserId(), userCustom);
									} else if (userProfileBO.getRole() == RoleConstants.PROPOSAL_APPROVER) {
										proposalApproveUsersMap.put(userCustom
												.getUserId(), userCustom);
									} else {
										targetUsersMap.put(userCustom
												.getUserId(), userCustom);
									}
								}
							} else if (role == RoleConstants.PROPOSAL_APPROVER) {
								if (isUserValidForTransfer(approveProposals,
										userProfileBO.getUserId())) {
									targetUsersMap.put(userCustom.getUserId(),
											userCustom);
								}
							} else {
								targetUsersMap.put(userCustom.getUserId(),
										userCustom);
							}
						}
					}
				}

				int targetSize = targetUsersMap.size();
				int proposalApproverSize = proposalApproveUsersMap.size();
				int createApproverSize = createApproveUsersMap.size();

				if (0 == targetSize && 0 == proposalApproverSize
						&& 0 == createApproverSize) {
					ErrorReport report = ExceptionGenerator.addErrorEntry(null,
							ErrorCodeConstants.SE0338,
							OPPTMessageCatalog.TYPE_SERVICE);
					transferProposalsCustomDTO.setMessageReport(report);
					transferProposalsCustomDTO
							.addButtonFlag(ButtonConstants.CONTINUE);
					transferProposalsCustomDTO
							.addButtonFlag(ButtonConstants.CANCEL);
				} else if (RoleConstants.CREATE_APPROVE == role) {
					if (createApproverSize == 0) {
						if (targetSize == 0 || proposalApproverSize == 0) {
							ErrorReport report = ExceptionGenerator
									.addErrorEntry(null,
											ErrorCodeConstants.SE0339,
											OPPTMessageCatalog.TYPE_SERVICE);
							transferProposalsCustomDTO.setMessageReport(report);
							transferProposalsCustomDTO
									.addButtonFlag(ButtonConstants.CONTINUE);
							transferProposalsCustomDTO
									.addButtonFlag(ButtonConstants.CANCEL);
						}
					}
				}

				transferProposalsCustomDTO.setTargetUsers(targetUsersMap);
				transferProposalsCustomDTO
						.setProposalApproveUsers(proposalApproveUsersMap);
				transferProposalsCustomDTO
						.setCreateApproveUsers(createApproveUsersMap);
			}

			return transferProposalsCustomDTO;
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}

	private boolean isUserValidForTransfer(List proposals, String targetUser) {
		boolean validUser = true;

		if (null == targetUser) {
			validUser = false;
		} else {
			if (null != proposals) {
				for (int i = 0; i < proposals.size(); i++) {
					ProposalContractBO proposal = (ProposalContractBO) proposals
							.get(i);
					if (targetUser.equals(proposal.getCreatedBy())
							|| targetUser.equals(proposal.getSubmittedBy())) {
						validUser = false;
						break;
					}
				}
			}
		}

		return validUser;
	}

	/**
	 * This method is called to transfer the proposals to targeted users
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @return
	 * @author Kedar Harischandrakar
	 * @exception DomainException
	 * @param TransferProposalsCustomDTO
	 */
	public TransferProposalsCustomDTO transferProposals(
			TransferProposalsCustomDTO transferProposalsCustomDTO)
			throws ServiceException {
		String methodName = "transferProposals";
		final String ADMIN_FLAG = "ADMIN";

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {

			ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
			ProposalContractBO proposalContractBO;

			JMSConnectorLocalHome connectorHome = (JMSConnectorLocalHome) HomeProvider
					.getLocal(HomeProvider.JMS_CONNECTOR_LOCAL_HOME);

			JMSConnectorLocal connectorLocal = connectorHome.create();

			String sourceUser = OPPTHelper
					.trimString(transferProposalsCustomDTO.getSourceUser()
							.getUserId());
			int sourceUserRole = transferProposalsCustomDTO.getSourceUser()
					.getRole();

			CompareAuthorInputConnectorDTO inputConnectorDTO = new CompareAuthorInputConnectorDTO();
			CompareAuthorOutputConnectorDTO outputConnectorDTO = null;
			inputConnectorDTO
					.setFunctionModuleName(ConnectorConstants.RFC_COMPARE_AUTHOR_OPPT);
			inputConnectorDTO.setSessionID(transferProposalsCustomDTO
					.getSessionId());
			inputConnectorDTO.setAdminFlag(ADMIN_FLAG);
			inputConnectorDTO.setUserID1(sourceUser);

			TreeMap targetUsers = transferProposalsCustomDTO.getTargetUsers();

			String createApproveUser = null;
			String otherUsers = null;
			String proposalApproveUser = null;

			String targetUserGroup = null;

			UserProfileBOFactory factory = new UserProfileBOFactory();
			UserProfileBO userBO;

			if (targetUsers.size() > 0) {
				String user = OPPTHelper.trimString((String) targetUsers
						.firstKey());
				userBO = factory.getUserProfileBO(user);

				//This if condition added by Nayan
				if (userBO.getGroupName() != null) {
					targetUserGroup = userBO.getGroupName();
				}
				/*
				 * if(targetUserGroup != null){ // // system.out.println("The value of
				 * the target group is " + targetUserGroup); } else
				 * // // system.out.println("The value of the target group is null");
				 */

				if (userBO.getRole() == RoleConstants.CREATE_APPROVE) {
					createApproveUser = user;
				} else if (userBO.getRole() == RoleConstants.PROPOSAL_APPROVER) {
					proposalApproveUser = user;
				} else {
					otherUsers = user;
				}

				inputConnectorDTO.setUserID2(user);
			}

			outputConnectorDTO = (CompareAuthorOutputConnectorDTO) connectorLocal
					.sendReceive(inputConnectorDTO);

			String returnCode = OPPTHelper.trimString(outputConnectorDTO
					.getReturnCode());
			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(returnCode) == false) {
				ErrorReport errorReport = ExceptionGenerator.addErrorEntry(
						null, returnCode, OPPTMessageCatalog.TYPE_BACKEND);
				transferProposalsCustomDTO.setMessageReport(errorReport);
				return transferProposalsCustomDTO;
			}

			if (targetUsers.size() > 1
					&& sourceUserRole == RoleConstants.CREATE_APPROVE) {
				String user = OPPTHelper.trimString((String) targetUsers
						.lastKey());

				userBO = factory.getUserProfileBO(user);

				//This if condition added by Nayan
				if (userBO.getGroupName() != null) {
					targetUserGroup = userBO.getGroupName();
				}
				/*
				 * if(targetUserGroup != null){ // // system.out.println("The value of
				 * the target group is " + targetUserGroup); } else
				 * // // system.out.println("The value of the target group is null");
				 */

				if (userBO.getRole() == RoleConstants.CREATE_APPROVE) {
					createApproveUser = user;
				} else if (userBO.getRole() == RoleConstants.PROPOSAL_APPROVER) {
					proposalApproveUser = user;
				} else {
					otherUsers = user;
				}

				inputConnectorDTO.setUserID2(user);

				outputConnectorDTO = (CompareAuthorOutputConnectorDTO) connectorLocal
						.sendReceive(inputConnectorDTO);

				returnCode = OPPTHelper.trimString(outputConnectorDTO
						.getReturnCode());
				if (ConnectorConstants.RFC_SUCCESS_CODE.equals(returnCode) == false) {
					ErrorReport errorReport = ExceptionGenerator.addErrorEntry(
							null, returnCode, OPPTMessageCatalog.TYPE_BACKEND);
					transferProposalsCustomDTO.setMessageReport(errorReport);
					return transferProposalsCustomDTO;
				}
			}

			boolean isProposalApprover = (sourceUserRole == RoleConstants.PROPOSAL_APPROVER);

			OPPTLogger.debug("Source user #" + sourceUser + "#", CLASS_NAME,
					methodName);
			OPPTLogger.debug("Source user role #" + sourceUserRole, CLASS_NAME,
					methodName);
			OPPTLogger.debug("Create approve user #" + createApproveUser + "#",
					CLASS_NAME, methodName);
			OPPTLogger.debug("Proposal approve user #" + proposalApproveUser
					+ "#", CLASS_NAME, methodName);
			OPPTLogger.debug("General user #" + otherUsers + "#", CLASS_NAME,
					methodName);

			List usersProposalList = null;

			if (isProposalApprover) {

				/**
				 * Defect 358 MN19539229 Balaji
				 */
				usersProposalList = proposalContractBOFactory
						.findProposalContractBOApprovedBy(sourceUser);
			} else {
				usersProposalList = proposalContractBOFactory
						.findProposalsContractsBOForUsers(sourceUser);
			}

			Iterator iter;
			if (usersProposalList != null) {
				OPPTLogger.debug("User proposal list size #"
						+ usersProposalList.size(), CLASS_NAME, methodName);

				iter = usersProposalList.iterator();
				while (iter.hasNext()) {
					proposalContractBO = (ProposalContractBO) iter.next();

					if (isProposalApprover) {
						if (proposalApproveUser != null) {
							proposalContractBO
									.setApprovedBy(proposalApproveUser);
						} else {
							proposalContractBO.setApprovedBy(createApproveUser);
						}
					} else {
						if (otherUsers != null) {
							proposalContractBO.setCreatedBy(otherUsers);
						} else {
							proposalContractBO.setCreatedBy(createApproveUser);
						}
					}

					//Added by Nayantara L Pai
					proposalContractBO.setGroupName(targetUserGroup);

					proposalContractBO.setLockedBy(null);
					proposalContractBO.setLockedOn(null);

					proposalContractBOFactory
							.updateProposalContractBO(proposalContractBO);
				}
			}

			/*
			 * MN 19705633 SUBMITTED BY FIX- Defect 7 Balaji
			 */
			if (sourceUserRole != RoleConstants.PROPOSAL_APPROVER) {
				List submittedByProposalsList = proposalContractBOFactory
						.findProposalsSubmittedBy(sourceUser);
				for (int i = 0; i < submittedByProposalsList.size(); i++) {
					ProposalContractBO bo = (ProposalContractBO) submittedByProposalsList
							.get(i);
					if (null != otherUsers) {
						bo.setSubmittedBy(otherUsers);
					} else if (null != createApproveUser) {
						bo.setSubmittedBy(createApproveUser);
					}
					proposalContractBOFactory.updateProposalContractBO(bo);
				}
			}
			/*
			 * SUBMITTED BY FIX- Ends MN 19705633- Ends Balaji
			 */

			if (sourceUserRole == RoleConstants.CREATE_APPROVE) {
				usersProposalList = proposalContractBOFactory
						.findProposalContractBOApprovedBy(sourceUser);

				if (usersProposalList != null) {
					OPPTLogger.debug("Approved by list size #"
							+ usersProposalList.size(), CLASS_NAME, methodName);

					iter = usersProposalList.iterator();
					while (iter.hasNext()) {
						proposalContractBO = (ProposalContractBO) iter.next();

						if (proposalApproveUser != null) {
							proposalContractBO
									.setApprovedBy(proposalApproveUser);
						} else {
							proposalContractBO.setApprovedBy(createApproveUser);
						}

						//Added by Nayantara L Pai
						proposalContractBO.setGroupName(targetUserGroup);

						proposalContractBO.setLockedBy(null);
						proposalContractBO.setLockedOn(null);

						proposalContractBOFactory
								.updateProposalContractBO(proposalContractBO);
					}
				}
			}
			/*
			 * MN 19705633 Balaji
			 */ 
			if (sourceUserRole == RoleConstants.BHD || sourceUserRole == RoleConstants.OPPT_READ) {
				SharingBOFactory sharingBOFactory = new SharingBOFactory();
				List sharingBOList = sharingBOFactory
						.findSharingBOForUsers(sourceUser);
				if (sharingBOList != null) {
					for (int i = 0; i < sharingBOList.size(); i++) {
						SharingBO sharingBO = (SharingBO) sharingBOList.get(i);
						sharingBOFactory.deleteSharingBO(sharingBO
								.getProposalId(), sourceUser);
						sharingBO.setAccessTo(otherUsers);
						sharingBOFactory.createSharingBO(sharingBO);
					}
				}
			}

			/*
			 * MN 19705633 Balaji - Ends
			 */
			try {
				usersProposalList = proposalContractBOFactory
						.findProposalContractBOLockedBy(sourceUser);

				if (usersProposalList != null) {
					iter = usersProposalList.iterator();
					while (iter.hasNext()) {
						proposalContractBO = (ProposalContractBO) iter.next();

						proposalContractBO.setLockedBy(null);
						proposalContractBO.setLockedOn(null);

						proposalContractBOFactory
								.updateProposalContractBO(proposalContractBO);
					}
				}
			} catch (DomainException e) {
				// ignore... There might not be locked by proposal
			}
			/* Start change CR0801074150 - CBS OPPT activity logging */
			StringBuffer targetUsersList = new StringBuffer();
			Iterator iterator = transferProposalsCustomDTO.getTargetUsers()
					.keySet().iterator();
			targetUsersList.append((String) iterator.next());
			while (iterator.hasNext()) {
				targetUsersList.append(",").append((String) iterator.next());
			}
			OPPTLogger.infoActivityLogger("Geo Security officer "
					+ transferProposalsCustomDTO.getUserId()
					+ " successfully transferred the proposals of user id "
					+ transferProposalsCustomDTO.getSourceUser().getUserId()
					+ " to " + targetUsersList.toString(), CLASS_NAME,
					methodName);
			String message="Geo Security officer "
				+ transferProposalsCustomDTO.getUserId()
				+ " successfully transferred the proposals of user id "
				+ transferProposalsCustomDTO.getSourceUser().getUserId()
				+ " to " + targetUsersList.toString();
			createActivityLog(transferProposalsCustomDTO.getUserId(),message);
			/* End change CR0801074150 - CBS OPPT activity logging */
			return transferProposalsCustomDTO;
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} catch (ServiceException e) {
			throw e;
		} catch (Exception ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					methodName, null, ex);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		} finally {
			timeTaken.end();
		}

	}

	/**
	 *
	 * This method copies the customer inventory in to selected customer
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 2, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copyCustomerCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CopyCustomerCustomDTO copyCustomerInventory(
			CopyCustomerCustomDTO copyCustomerCustomDTO)
			throws ServiceException {

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "copyCustomerInventory");

		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalContractBO proposalContractBO = null;
		CopyInventoryDomainDTO copyInventoryDomainDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		ProposalCustomerCustomDTO targetProposalCustomerCustomDTO = null;
		ProposalCustomerCustomDTO sourceProposalCustomerCustomDTO = null;
		HashMap hashMap = null;
		int COPY = 1;
		boolean isProposal = false;
		boolean saveCondtn = false;
		proposalContractBOFactory = new ProposalContractBOFactory();
		copyInventoryDomainDTO = new CopyInventoryDomainDTO();
		targetProposalCustomerCustomDTO = copyCustomerCustomDTO
				.getTargetCustomer();
		sourceProposalCustomerCustomDTO = copyCustomerCustomDTO
				.getSourceCustomer();
		OPPTCalender calendar = new OPPTCalender();

		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(sourceProposalCustomerCustomDTO
							.getProposalId());
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}

		isProposal = proposalContractBO.isProposal();

		if (isProposal) {
			saveCondtn = (calendar.isDateGreater(copyCustomerCustomDTO
					.getPlanStartDate(), sourceProposalCustomerCustomDTO
					.getPlanStartDate()) || calendar.isDateEqual(
					copyCustomerCustomDTO.getPlanStartDate(),
					sourceProposalCustomerCustomDTO.getPlanStartDate()))
					&& (calendar.isDateLesser(copyCustomerCustomDTO
							.getPlanStartDate(), copyCustomerCustomDTO
							.getPlanEndDate()))
					&& (calendar.isDateLesser(copyCustomerCustomDTO
							.getPlanEndDate(), sourceProposalCustomerCustomDTO
							.getPlanEndDate()) || calendar.isDateEqual(
							copyCustomerCustomDTO.getPlanEndDate(),
							sourceProposalCustomerCustomDTO.getPlanEndDate()));
		} else {
			boolean defaultCondtn = false;

			defaultCondtn = (calendar.isDateEqual(copyCustomerCustomDTO
					.getPlanStartDate(), sourceProposalCustomerCustomDTO
					.getPlanStartDate()))
					&& calendar.isDateEqual(copyCustomerCustomDTO
							.getPlanEndDate(), sourceProposalCustomerCustomDTO
							.getPlanEndDate());
			/*
			 * saveCondtn =
			 * (calendar.isDateLesser(proposalContractBO.getAmendEffectiveDate(),
			 * sourceProposalCustomerCustomDTO.getPlanEndDate()) ||
			 * calendar.isDateEqual(proposalContractBO.getAmendEffectiveDate(),
			 * sourceProposalCustomerCustomDTO.getPlanEndDate())) &&
			 * (calendar.isDateLesser(proposalContractBO.getAmendEffectiveDate(),
			 * sourceProposalCustomerCustomDTO.getPlanStartDate())) &&
			 * ((calendar.isDateGreater(copyCustomerCustomDTO.getPlanStartDate(),
			 * sourceProposalCustomerCustomDTO.getPlanStartDate()) ||
			 * calendar.isDateEqual(copyCustomerCustomDTO.getPlanStartDate(),
			 * sourceProposalCustomerCustomDTO.getPlanStartDate())) ||
			 * (calendar.isDateGreater(proposalContractBO.getAmendEffectiveDate(),
			 * sourceProposalCustomerCustomDTO.getPlanStartDate()))) &&
			 * (calendar.isDateGreater(copyCustomerCustomDTO.getPlanStartDate(),
			 * proposalContractBO.getAmendEffectiveDate()) ||
			 * calendar.isDateEqual(copyCustomerCustomDTO.getPlanStartDate(),
			 * proposalContractBO.getAmendEffectiveDate())) &&
			 * (calendar.isDateLesser(copyCustomerCustomDTO.getPlanEndDate(),
			 * sourceProposalCustomerCustomDTO.getPlanEndDate()) ||
			 * calendar.isDateEqual(copyCustomerCustomDTO.getPlanEndDate(),
			 * sourceProposalCustomerCustomDTO.getPlanEndDate())) &&
			 * (calendar.isDateGreater(copyCustomerCustomDTO.getPlanEndDate(),
			 * copyCustomerCustomDTO.getPlanStartDate())) || defaultCondtn;
			 */
			saveCondtn = ((calendar.isDateLesser(proposalContractBO
					.getAmendEffectiveDate(), sourceProposalCustomerCustomDTO
					.getPlanEndDate()) || calendar.isDateEqual(
					proposalContractBO.getAmendEffectiveDate(),
					sourceProposalCustomerCustomDTO.getPlanEndDate()))
					&& (calendar.isDateLesser(proposalContractBO
							.getAmendEffectiveDate(),
							sourceProposalCustomerCustomDTO.getPlanEndDate()) || calendar
							.isDateEqual(proposalContractBO
									.getAmendEffectiveDate(),
									sourceProposalCustomerCustomDTO
											.getPlanEndDate()))
					&& (((calendar.isDateLesser(proposalContractBO
							.getAmendEffectiveDate(),
							sourceProposalCustomerCustomDTO.getPlanStartDate()))
							&& (calendar.isDateGreater(copyCustomerCustomDTO
									.getPlanStartDate(),
									sourceProposalCustomerCustomDTO
											.getPlanStartDate()) || calendar
									.isDateEqual(copyCustomerCustomDTO
											.getPlanStartDate(),
											sourceProposalCustomerCustomDTO
													.getPlanStartDate())) && (calendar
							.isDateLesser(copyCustomerCustomDTO
									.getPlanStartDate(), copyCustomerCustomDTO
									.getPlanEndDate()))) || ((calendar
							.isDateGreater(proposalContractBO
									.getAmendEffectiveDate(),
									sourceProposalCustomerCustomDTO
											.getPlanStartDate()))
							&& (calendar.isDateGreater(copyCustomerCustomDTO
									.getPlanStartDate(), proposalContractBO
									.getAmendEffectiveDate()) || calendar
									.isDateEqual(copyCustomerCustomDTO
											.getPlanStartDate(),
											proposalContractBO
													.getAmendEffectiveDate())) && (calendar
							.isDateLesser(copyCustomerCustomDTO
									.getPlanStartDate(), copyCustomerCustomDTO
									.getPlanEndDate()))))
					&& (calendar.isDateLesser(copyCustomerCustomDTO
							.getPlanEndDate(), sourceProposalCustomerCustomDTO
							.getPlanEndDate()) || calendar.isDateEqual(
							copyCustomerCustomDTO.getPlanEndDate(),
							sourceProposalCustomerCustomDTO.getPlanEndDate())) && (calendar
					.isDateGreater(copyCustomerCustomDTO.getPlanEndDate(),
							copyCustomerCustomDTO.getPlanStartDate())))
					|| defaultCondtn;

			/*
			 *
			 *
			 * calendar.isDateEqual(proposalContractBO.getAmendEffectiveDate(),
			 * sourceProposalCustomerCustomDTO.getPlanEndDate())));
			 *
			 * (calendar.isDateLesser(proposalContractBO.getAmendEffectiveDate(),
			 * sourceProposalCustomerCustomDTO.getPlanStartDate())) &&
			 * (calendar.isDateGreater(copyCustomerCustomDTO.getPlanStartDate(),
			 * sourceProposalCustomerCustomDTO.getPlanStartDate()) ||
			 * calendar.isDateEqual(copyCustomerCustomDTO.getPlanStartDate(),
			 * sourceProposalCustomerCustomDTO.getPlanStartDate())) &&
			 * (calendar.isDateLesser(copyCustomerCustomDTO.getPlanStartDate(),
			 * copyCustomerCustomDTO.getPlanEndDate())) ));
			 *
			 * (calendar.isDateGreater(proposalContractBO.getAmendEffectiveDate(),
			 * sourceProposalCustomerCustomDTO.getPlanStartDate())) &&
			 * (calendar.isDateGreater(copyCustomerCustomDTO.getPlanStartDate(),
			 * proposalContractBO.getAmendEffectiveDate()) ||
			 * calendar.isDateEqual(copyCustomerCustomDTO.getPlanStartDate(),
			 * proposalContractBO.getAmendEffectiveDate())) &&
			 * (calendar.isDateLesser(copyCustomerCustomDTO.getPlanStartDate(),
			 * copyCustomerCustomDTO.getPlanEndDate())) ));
			 *
			 * sourceProposalCustomerCustomDTO.getPlanEndDate()) ||
			 * calendar.isDateEqual(copyCustomerCustomDTO.getPlanEndDate(),
			 * sourceProposalCustomerCustomDTO.getPlanEndDate())));
			 *
			 * copyCustomerCustomDTO.getPlanStartDate())));
			 */
		}

		if (saveCondtn) {

			hashMap = new HashMap();
			hashMap.put(UtilityConstants.PLAN_START_DATE, copyCustomerCustomDTO
					.getPlanStartDate());
			hashMap.put(UtilityConstants.PLAN_END_DATE, copyCustomerCustomDTO
					.getPlanEndDate());
			copyInventoryDomainDTO
					.setActionName(ActionNameConstants.COPY_INVENTORY_CUSTOMER);
			copyInventoryDomainDTO.setChoice(COPY);
			copyInventoryDomainDTO.setValues(hashMap);
			sourceProposalCustomerCustomDTO = copyCustomerCustomDTO
					.getSourceCustomer();

			copyInventoryDomainDTO
					.setOldProposalID(sourceProposalCustomerCustomDTO
							.getProposalId());
			copyInventoryDomainDTO
					.setOldCustomerID(sourceProposalCustomerCustomDTO
							.getCustomerId());
			copyInventoryDomainDTO
					.setNewProposalID(targetProposalCustomerCustomDTO
							.getProposalId());
			copyInventoryDomainDTO
					.setNewCustomerID(targetProposalCustomerCustomDTO
							.getCustomerId());
			inventoryManagerLocal = getInventoryManagerLocal();

			try {
				inventoryManagerLocal.copyInventory(copyInventoryDomainDTO);
			} catch (ServiceException se) {
				getSessionContext().setRollbackOnly();
				throw se;
			}
			if (isProposal) {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT);
				proposalContractBO.setInvoiceAmount(0.0);
			} else {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				//proposalContractBO.setAmendEffectiveDate(new Date(new
				// java.util.Date().getTime()));
				proposalContractBO.setInvoiceAmount(0.0);
			}

			try {
				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}

		} else {
			throwServiceException(ErrorCodeConstants.SE0118,
					OPPTMessageCatalog.TYPE_SERVICE);
		}

		timeTaken.end();
		return copyCustomerCustomDTO;
	}

	/**
	 *
	 * This method copies the dm in to selected dm
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 2, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copyDMCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CopyDMCustomDTO copyDMInventory(CopyDMCustomDTO copyDMCustomDTO)
			throws ServiceException {

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "copyDMInventory");

		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalContractBO proposalContractBO = null;
		CopyInventoryDomainDTO copyInventoryDomainDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		DMCustomDTO targetDMCustomDTO = null;
		DMCustomDTO sourceDMCustomDTO = null;
		ProposalCustomerCustomDTO targetCustomer = null;

		HashMap hashMap = null;
		int COPY = 1;
		boolean isProposal = false;
		boolean saveCondtn = false;

		proposalContractBOFactory = new ProposalContractBOFactory();
		copyInventoryDomainDTO = new CopyInventoryDomainDTO();
		targetDMCustomDTO = copyDMCustomDTO.getTargetDM();
		targetCustomer = copyDMCustomDTO.getTargetCustomer();
		sourceDMCustomDTO = copyDMCustomDTO.getSourceDM();
		OPPTCalender calendar = new OPPTCalender();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(targetCustomer.getProposalId());
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}

		isProposal = proposalContractBO.isProposal();
		if (isProposal) {
			if (targetDMCustomDTO != null
					&& targetDMCustomDTO.getNumber() != null) {
				saveCondtn = (calendar.isDateGreater(copyDMCustomDTO
						.getPlanStartDate(), targetCustomer.getPlanStartDate()) || calendar
						.isDateEqual(copyDMCustomDTO.getPlanStartDate(),
								targetCustomer.getPlanStartDate()))
						&& (calendar.isDateLesser(copyDMCustomDTO
								.getPlanStartDate(), copyDMCustomDTO
								.getPlanEndDate()))
						&& (calendar.isDateLesser(copyDMCustomDTO
								.getPlanEndDate(), targetCustomer
								.getPlanEndDate()) || calendar.isDateEqual(
								copyDMCustomDTO.getPlanEndDate(),
								targetCustomer.getPlanEndDate()))
						&& (calendar.isDateLesser(copyDMCustomDTO
								.getPlanStartDate(), copyDMCustomDTO
								.getPlanEndDate()));

			}
		} else {

			if (targetDMCustomDTO != null
					&& targetDMCustomDTO.getNumber() != null) {
				boolean defaultCondtn = false;
				defaultCondtn = calendar.isDateEqual(copyDMCustomDTO
						.getPlanStartDate(), targetCustomer.getPlanStartDate())
						&& calendar.isDateEqual(copyDMCustomDTO
								.getPlanEndDate(), targetCustomer
								.getPlanEndDate());
				/*
				 * saveCondtn =
				 * (calendar.isDateLesser(proposalContractBO.getAmendEffectiveDate(),
				 * targetCustomer.getPlanEndDate()) ||
				 * calendar.isDateEqual(proposalContractBO.getAmendEffectiveDate(),
				 * targetCustomer.getPlanEndDate())) &&
				 * (calendar.isDateLesser(proposalContractBO.getAmendEffectiveDate(),
				 * copyDMCustomDTO.getSourceDM().getPlanStartDate()) ||
				 * calendar.isDateEqual(proposalContractBO.getAmendEffectiveDate(),
				 * copyDMCustomDTO.getSourceDM().getPlanStartDate())) &&
				 * (calendar.isDateLesser(proposalContractBO.getAmendEffectiveDate(),
				 * targetCustomer.getPlanStartDate())) &&
				 * (calendar.isDateGreater(copyDMCustomDTO.getPlanStartDate(),
				 * copyDMCustomDTO.getPlanEndDate()) ||
				 * calendar.isDateGreater(proposalContractBO.getAmendEffectiveDate(),
				 * targetCustomer.getPlanStartDate())) &&
				 * (calendar.isDateGreater(copyDMCustomDTO.getPlanStartDate(),
				 * proposalContractBO.getAmendEffectiveDate()) ||
				 * calendar.isDateEqual(copyDMCustomDTO.getPlanStartDate(),
				 * proposalContractBO.getAmendEffectiveDate())) &&
				 * (calendar.isDateLesser(copyDMCustomDTO.getPlanEndDate(),
				 * targetCustomer.getPlanEndDate()) ||
				 * calendar.isDateEqual(copyDMCustomDTO.getPlanEndDate(),
				 * targetCustomer.getPlanEndDate())) &&
				 * (calendar.isDateLesser(copyDMCustomDTO.getPlanStartDate(),
				 * copyDMCustomDTO.getPlanEndDate())) || defaultCondtn;
				 */
				saveCondtn = ((calendar.isDateLesser(proposalContractBO
						.getAmendEffectiveDate(), targetCustomer
						.getPlanEndDate()) || calendar.isDateEqual(
						proposalContractBO.getAmendEffectiveDate(),
						targetCustomer.getPlanEndDate()))
						&& (calendar.isDateLesser(proposalContractBO
								.getAmendEffectiveDate(), copyDMCustomDTO
								.getSourceDM().getPlanEndDate()) || calendar
								.isDateEqual(proposalContractBO
										.getAmendEffectiveDate(),
										copyDMCustomDTO.getSourceDM()
												.getPlanEndDate()))
						&& (((calendar.isDateLesser(proposalContractBO
								.getAmendEffectiveDate(), targetCustomer
								.getPlanStartDate()))
								&& (calendar.isDateGreater(copyDMCustomDTO
										.getPlanStartDate(), targetCustomer
										.getPlanStartDate()) || calendar
										.isDateEqual(copyDMCustomDTO
												.getPlanStartDate(),
												targetCustomer
														.getPlanStartDate())) && (calendar
								.isDateLesser(copyDMCustomDTO
										.getPlanStartDate(), copyDMCustomDTO
										.getPlanEndDate()))) || ((calendar
								.isDateGreater(proposalContractBO
										.getAmendEffectiveDate(),
										targetCustomer.getPlanStartDate()))
								&& (calendar.isDateGreater(copyDMCustomDTO
										.getPlanStartDate(), proposalContractBO
										.getAmendEffectiveDate()) || calendar
										.isDateEqual(
												copyDMCustomDTO
														.getPlanStartDate(),
												proposalContractBO
														.getAmendEffectiveDate())) && (calendar
								.isDateLesser(copyDMCustomDTO
										.getPlanStartDate(), copyDMCustomDTO
										.getPlanEndDate())))) && ((calendar
						.isDateLesser(copyDMCustomDTO.getPlanEndDate(),
								targetCustomer.getPlanEndDate())) || (calendar
						.isDateEqual(copyDMCustomDTO.getPlanEndDate(),
								targetCustomer.getPlanEndDate()))
						&& (calendar.isDateGreater(copyDMCustomDTO
								.getPlanEndDate(), copyDMCustomDTO
								.getPlanStartDate()))))
						|| defaultCondtn;
				/*
				 *
				 * targetCustomer.getPlanEndDate()) ||
				 * calendar.isDateEqual(proposalContractBO.getAmendEffectiveDate(),
				 * targetCustomer.getPlanEndDate())));
				 *
				 * copyDMCustomDTO.getSourceDM().getPlanEndDate()) ||
				 * calendar.isDateEqual(proposalContractBO.getAmendEffectiveDate(),
				 * copyDMCustomDTO.getSourceDM().getPlanEndDate())));
				 *
				 * targetCustomer.getPlanStartDate())) &&
				 * (calendar.isDateGreater(copyDMCustomDTO.getPlanStartDate(),
				 * targetCustomer.getPlanStartDate()) ||
				 * calendar.isDateEqual(copyDMCustomDTO.getPlanStartDate(),
				 * targetCustomer.getPlanStartDate())) &&
				 * (calendar.isDateLesser(copyDMCustomDTO.getPlanStartDate(),
				 * copyDMCustomDTO.getPlanEndDate()))));
				 *
				 * targetCustomer.getPlanStartDate())) &&
				 * (calendar.isDateGreater(copyDMCustomDTO.getPlanStartDate(),
				 * proposalContractBO.getAmendEffectiveDate()) ||
				 * calendar.isDateEqual(copyDMCustomDTO.getPlanStartDate(),
				 * proposalContractBO.getAmendEffectiveDate())) &&
				 * (calendar.isDateLesser(copyDMCustomDTO.getPlanStartDate(),
				 * copyDMCustomDTO.getPlanEndDate()))));
				 *
				 * targetCustomer.getPlanEndDate())) ||
				 * (calendar.isDateEqual(copyDMCustomDTO.getPlanEndDate(),
				 * targetCustomer.getPlanEndDate())) &&
				 * (calendar.isDateGreater(copyDMCustomDTO.getPlanEndDate(),
				 * copyDMCustomDTO.getPlanStartDate()))));
				 */
			}

		}

		//if((proposalContractBO.getAmendEffectiveDate().getTime()<=targetDMCustomDTO.getPlanEndDate().getTime())&&(proposalContractBO))
		if (saveCondtn) {

			hashMap = new HashMap();
			hashMap.put(UtilityConstants.PLAN_START_DATE, copyDMCustomDTO
					.getPlanStartDate());
			hashMap.put(UtilityConstants.PLAN_END_DATE, copyDMCustomDTO
					.getPlanEndDate());
			hashMap.put(UtilityConstants.DM_NO, targetDMCustomDTO.getNumber());
			hashMap.put(UtilityConstants.DM_DESC, targetDMCustomDTO
					.getDescription());
			copyInventoryDomainDTO.setValues(hashMap);
			copyInventoryDomainDTO.setChoice(COPY);
			copyInventoryDomainDTO
					.setActionName(ActionNameConstants.COPY_INVENTORY_DM);
			sourceDMCustomDTO = copyDMCustomDTO.getSourceDM();
			copyInventoryDomainDTO.setOldProposalID(sourceDMCustomDTO
					.getProposalId());
			copyInventoryDomainDTO.setOldCustomerID(Integer
					.parseInt(sourceDMCustomDTO.getCustomerId()));
			copyInventoryDomainDTO.setOldDMID(Integer
					.parseInt(sourceDMCustomDTO.getId()));
			copyInventoryDomainDTO.setNewProposalID(targetCustomer
					.getProposalId());
			copyInventoryDomainDTO.setNewCustomerID(targetCustomer
					.getCustomerId());

			inventoryManagerLocal = getInventoryManagerLocal();
			try {
				inventoryManagerLocal.copyInventory(copyInventoryDomainDTO);
			} catch (ServiceException se) {
				getSessionContext().setRollbackOnly();
				throw se;
			}
			isProposal = proposalContractBO.isProposal();
			if (isProposal) {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT);
				proposalContractBO.setInvoiceAmount(0.0);
			} else {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				//proposalContractBO.setAmendEffectiveDate(new Date(new
				// java.util.Date().getTime()));
				proposalContractBO.setInvoiceAmount(0.0);
			}

			try {
				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}
		} else {
			throwServiceException(ErrorCodeConstants.SE0119,
					OPPTMessageCatalog.TYPE_SERVICE);
		}

		timeTaken.end();
		return copyDMCustomDTO;
	}

	/**
	 *
	 * This method copies the swo in to selected swo
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 2, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copySWOCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CopySWOCustomDTO copySWOInventory(CopySWOCustomDTO copySWOCustomDTO)
			throws ServiceException {

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "copySWOInventory");

		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalContractBO proposalContractBO = null;
		CopyInventoryDomainDTO copyInventoryDomainDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		DMCustomDTO targetDMCustomDTO = null;
		SWOCustomDTO sourceSWOCustomDTO = null;
		HashMap hashMap = null;
		int COPY = 1;
		boolean isProposal = false;
		boolean saveCondtn = false;

		copyInventoryDomainDTO = new CopyInventoryDomainDTO();
		targetDMCustomDTO = copySWOCustomDTO.getSelectedTargetDM();
		sourceSWOCustomDTO = copySWOCustomDTO.getSourceSWO();
		proposalContractBOFactory = new ProposalContractBOFactory();
		OPPTCalender calender = new OPPTCalender();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(targetDMCustomDTO.getProposalId());
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}

		isProposal = proposalContractBO.isProposal();

		if (isProposal) {

			saveCondtn = (calender.isDateGreater(copySWOCustomDTO
					.getPlanStartDate(), targetDMCustomDTO.getPlanStartDate()) || calender
					.isDateEqual(copySWOCustomDTO.getPlanStartDate(),
							targetDMCustomDTO.getPlanStartDate()))
					&& (calender.isDateLesser(copySWOCustomDTO
							.getPlanStartDate(), targetDMCustomDTO
							.getPlanEndDate()))
					&& (calender.isDateLesser(
							copySWOCustomDTO.getPlanEndDate(),
							targetDMCustomDTO.getPlanEndDate()) || calender
							.isDateEqual(copySWOCustomDTO.getPlanEndDate(),
									targetDMCustomDTO.getPlanEndDate()))
					&& (calender.isDateGreater(copySWOCustomDTO
							.getPlanEndDate(), copySWOCustomDTO
							.getPlanStartDate()));

		} else {
			boolean defaultCondtn = false;

			defaultCondtn = (calender.isDateEqual(copySWOCustomDTO
					.getPlanStartDate(), targetDMCustomDTO.getPlanStartDate()) && calender
					.isDateEqual(copySWOCustomDTO.getPlanEndDate(),
							targetDMCustomDTO.getPlanEndDate()));
			/*
			 * saveCondtn =
			 * (calender.isDateLesser(proposalContractBO.getAmendEffectiveDate(),
			 * targetDMCustomDTO.getPlanEndDate()) ||
			 * calender.isDateEqual(proposalContractBO.getAmendEffectiveDate(),
			 * targetDMCustomDTO.getPlanEndDate())) &&
			 * (calender.isDateLesser(proposalContractBO.getAmendEffectiveDate(),
			 * targetDMCustomDTO.getPlanStartDate()) ||
			 * calender.isDateEqual(proposalContractBO.getAmendEffectiveDate(),
			 * targetDMCustomDTO.getPlanStartDate())) &&
			 * (calender.isDateGreater(copySWOCustomDTO.getPlanStartDate(),
			 * targetDMCustomDTO.getPlanStartDate()) ||
			 * calender.isDateEqual(copySWOCustomDTO.getPlanStartDate(),
			 * targetDMCustomDTO.getPlanStartDate())) &&
			 * ((calender.isDateLesser(copySWOCustomDTO.getPlanStartDate(),
			 * targetDMCustomDTO.getPlanEndDate()) ||
			 * calender.isDateEqual(copySWOCustomDTO.getPlanStartDate(),
			 * targetDMCustomDTO.getPlanEndDate())) ||
			 * (calender.isDateGreater(proposalContractBO.getAmendEffectiveDate(),
			 * targetDMCustomDTO.getPlanStartDate()) ||
			 * calender.isDateEqual(proposalContractBO.getAmendEffectiveDate(),
			 * targetDMCustomDTO.getPlanStartDate()))) &&
			 * (calender.isDateGreater(copySWOCustomDTO.getPlanStartDate(),
			 * proposalContractBO.getAmendEffectiveDate()) ||
			 * calender.isDateEqual(copySWOCustomDTO.getPlanStartDate(),
			 * proposalContractBO.getAmendEffectiveDate())) &&
			 * (calender.isDateLesser(copySWOCustomDTO.getPlanEndDate(),
			 * targetDMCustomDTO.getPlanEndDate()) ||
			 * calender.isDateEqual(copySWOCustomDTO.getPlanEndDate(),
			 * targetDMCustomDTO.getPlanEndDate())) &&
			 * (calender.isDateGreater(copySWOCustomDTO.getPlanEndDate(),
			 * copySWOCustomDTO.getPlanStartDate()) ||
			 * calender.isDateEqual(copySWOCustomDTO.getPlanEndDate(),
			 * copySWOCustomDTO.getPlanStartDate())) || defaultCondtn;
			 */
			saveCondtn = ((calender.isDateLesser(proposalContractBO
					.getAmendEffectiveDate(), targetDMCustomDTO
					.getPlanEndDate()) || calender.isDateEqual(
					proposalContractBO.getAmendEffectiveDate(),
					targetDMCustomDTO.getPlanEndDate()))
					&& (((calender.isDateLesser(proposalContractBO
							.getAmendEffectiveDate(), targetDMCustomDTO
							.getPlanStartDate()))
							&& (calender.isDateGreater(copySWOCustomDTO
									.getPlanStartDate(), targetDMCustomDTO
									.getPlanStartDate()) || calender
									.isDateEqual(copySWOCustomDTO
											.getPlanStartDate(),
											targetDMCustomDTO
													.getPlanStartDate())) && (calender
							.isDateLesser(copySWOCustomDTO.getPlanStartDate(),
									copySWOCustomDTO.getPlanEndDate()) || calender
							.isDateEqual(copySWOCustomDTO.getPlanStartDate(),
									copySWOCustomDTO.getPlanEndDate()))) || ((calender
							.isDateGreater(proposalContractBO
									.getAmendEffectiveDate(), targetDMCustomDTO
									.getPlanStartDate()))
							&& (calender.isDateGreater(copySWOCustomDTO
									.getPlanStartDate(), proposalContractBO
									.getAmendEffectiveDate()) || calender
									.isDateEqual(copySWOCustomDTO
											.getPlanStartDate(),
											proposalContractBO
													.getAmendEffectiveDate())) && (calender
							.isDateLesser(copySWOCustomDTO.getPlanStartDate(),
									copySWOCustomDTO.getPlanEndDate()) || calender
							.isDateEqual(copySWOCustomDTO.getPlanStartDate(),
									copySWOCustomDTO.getPlanEndDate())))) && ((calender
					.isDateLesser(copySWOCustomDTO.getPlanEndDate(),
							targetDMCustomDTO.getPlanEndDate()) || calender
					.isDateEqual(copySWOCustomDTO.getPlanEndDate(),
							targetDMCustomDTO.getPlanEndDate())) && (calender
					.isDateGreater(copySWOCustomDTO.getPlanEndDate(),
							copySWOCustomDTO.getPlanStartDate()) || calender
					.isDateEqual(copySWOCustomDTO.getPlanStartDate(),
							copySWOCustomDTO.getPlanStartDate()))))
					|| defaultCondtn;
		}

		if (saveCondtn) {

			copyInventoryDomainDTO.setChoice(COPY);
			hashMap = new HashMap();
			hashMap.put(UtilityConstants.PLAN_START_DATE, copySWOCustomDTO
					.getPlanStartDate());
			hashMap.put(UtilityConstants.PLAN_END_DATE, copySWOCustomDTO
					.getPlanEndDate());
			copyInventoryDomainDTO.setValues(hashMap);
			copyInventoryDomainDTO
					.setActionName(ActionNameConstants.COPY_INVENTORY_SWO);
			sourceSWOCustomDTO = copySWOCustomDTO.getSourceSWO();
			copyInventoryDomainDTO.setOldProposalID(sourceSWOCustomDTO
					.getProposalId());
			copyInventoryDomainDTO.setOldCustomerID(Integer
					.parseInt(sourceSWOCustomDTO.getCustomerId()));
			copyInventoryDomainDTO.setOldDMID(Integer
					.parseInt(sourceSWOCustomDTO.getDMId()));
			copyInventoryDomainDTO.setOldSWOID(Integer
					.parseInt(sourceSWOCustomDTO.getId()));
			copyInventoryDomainDTO.setNewProposalID(targetDMCustomDTO
					.getProposalId());
			copyInventoryDomainDTO.setNewCustomerID(Integer
					.parseInt(targetDMCustomDTO.getCustomerId()));
			copyInventoryDomainDTO.setNewDMID(Integer
					.parseInt(targetDMCustomDTO.getId()));

			inventoryManagerLocal = getInventoryManagerLocal();
			try {
				inventoryManagerLocal.copyInventory(copyInventoryDomainDTO);
			} catch (ServiceException se) {
				getSessionContext().setRollbackOnly();
				throw se;
			}
			isProposal = proposalContractBO.isProposal();
			if (isProposal) {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT);
				proposalContractBO.setInvoiceAmount(0.0);
			} else {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				//proposalContractBO.setAmendEffectiveDate(new Date(new
				// java.util.Date().getTime()));
				proposalContractBO.setInvoiceAmount(0.0);
			}

			try {
				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}

		} else {
			throwServiceException(ErrorCodeConstants.SE0120,
					OPPTMessageCatalog.TYPE_SERVICE);
		}

		timeTaken.end();
		return copySWOCustomDTO;
	}

	/**
	 *
	 * This method copies one customer inventory to another customer
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 3, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copyCustomerCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CopyCustomerCustomDTO copyInventory(
			CopyCustomerCustomDTO copyCustomerCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME,
				"copyInventory-Customer");

		int proposalId = 0;
		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalDomainDTO proposalDomainDTO = null;
		ProposalContractBO proposalContractBO = null;
		CustomerDomainDTO customerDomainDTO = null;
		CustomerDomainDTO targetCustomerDomainDTO = null;
		ProposalCustomerCustomDTO customerCustomDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		ProposalCustomerCustomDTO targetCustomers = null;
		TreeMap soldtoParty = null;
		customerCustomDTO = copyCustomerCustomDTO.getSourceCustomer();
		soldtoParty = new TreeMap();
		proposalId = customerCustomDTO.getProposalId();
		proposalContractBOFactory = new ProposalContractBOFactory();
		HashMap map = new HashMap();
		map.put(UtilityConstants.BO_USERID, copyCustomerCustomDTO.getUserId());
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}

		try {
			map.put(UtilityConstants.BO_GROUPNAME, copyCustomerCustomDTO
					.getGroupName());
			SharingBO sharingBO = getSharingBOFromFactory(proposalContractBO
					.getProposalId(), copyCustomerCustomDTO.getUserId());
			if (null != sharingBO) {
				map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}
			proposalContractBO.validateCopyInventory(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
		customerDomainDTO = new CustomerDomainDTO();
		customerDomainDTO.setProposalId(customerCustomDTO.getProposalId());
		customerDomainDTO.setCustomerId(customerCustomDTO.getCustomerId());
		customerDomainDTO
				.setActionName(ActionNameConstants.COPY_INVENTORY_CUSTOMER);
		inventoryManagerLocal = getInventoryManagerLocal();

		customerDomainDTO = inventoryManagerLocal
				.retrieveCustomerInfo(customerDomainDTO);

		customerCustomDTO.setProposalId(customerDomainDTO.getProposalId());
		customerCustomDTO.setCustomerId(customerDomainDTO.getCustomerId());
		customerCustomDTO.setCustomerName(customerDomainDTO
				.getSapCustomerName());
		customerCustomDTO.setLegacyCustomerNumber(customerDomainDTO
				.getLegacyCustomerNo());
		customerCustomDTO.setSAPCustomerNumber(customerDomainDTO
				.getSapCustomerNo());
		customerCustomDTO
				.setPlanStartDate(customerDomainDTO.getPlanStartDate());
		customerCustomDTO.setPlanEndDate(customerDomainDTO.getPlanEndDate());
		customerCustomDTO.setAddressSequenceNumber(customerDomainDTO
				.getCustmerASNo());

		proposalDomainDTO = inventoryManagerLocal
				.retrieveCustomerForProposal(proposalDomainDTO);

		if (proposalDomainDTO.getCustomerDTOList() != null
				&& proposalDomainDTO.getCustomerDTOList().size() > 0) {
			for (int i = 0; i < proposalDomainDTO.getCustomerDTOList().size(); i++) {

				targetCustomerDomainDTO = (CustomerDomainDTO) proposalDomainDTO
						.getCustomerDTOList().get(i);

				if (targetCustomerDomainDTO.getSapCustomerNo() != null
						&& !(customerDomainDTO.getSapCustomerNo()
								.equals(targetCustomerDomainDTO
										.getSapCustomerNo()))) {
					targetCustomers = new ProposalCustomerCustomDTO();
					targetCustomers.setProposalId(targetCustomerDomainDTO
							.getProposalId());
					targetCustomers.setCustomerId(targetCustomerDomainDTO
							.getCustomerId());
					targetCustomers
							.setLegacyCustomerNumber(targetCustomerDomainDTO
									.getLegacyCustomerNo());
					targetCustomers
							.setAddressSequenceNumber(targetCustomerDomainDTO
									.getCustmerASNo());
					targetCustomers.setCustomerName(targetCustomerDomainDTO
							.getSapCustomerName());
					targetCustomers
							.setSAPCustomerNumber(targetCustomerDomainDTO
									.getSapCustomerNo());
					soldtoParty.put(String.valueOf(targetCustomerDomainDTO
							.getCustomerId()), targetCustomers);
				}
			}
		}
		if (soldtoParty != null && soldtoParty.size() < 1) {
			copyCustomerCustomDTO.addMessageEntry(ErrorCodeConstants.SE0121,
					OPPTMessageCatalog.TYPE_SERVICE);
		}

		copyCustomerCustomDTO.setTargetCustomers(soldtoParty);
		copyCustomerCustomDTO.setStartYears(OPPTCalender.getStartYearList());
		copyCustomerCustomDTO.setEndYears(OPPTCalender.getEndYearList());

		timeTaken.end();
		return copyCustomerCustomDTO;
	}

	/**
	 *
	 * This method copies one dm to another dm
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 3, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copyDMCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CopyDMCustomDTO copyInventory(CopyDMCustomDTO copyDMCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "copyInventory-DM");

		int proposalId = 0;
		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalDomainDTO proposalDomainDTO = null;
		ProposalContractBO proposalContractBO = null;
		CustomerDomainDTO targetCustomerDomainDTO = null;
		CustomerDomainDTO customerDomainDTO = null;
		DMDomainDTO dmDomainDTO = null;
		DMCustomDTO dmCustomDTO = null;
		ProposalCustomerCustomDTO targetCustomers = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		TreeMap soldtoParty = null;
		ESWCustomerCustomDTO sourceCustomer = null;

		//for test
		if (copyDMCustomDTO == null) {
			copyDMCustomDTO = new CopyDMCustomDTO();
			dmCustomDTO = new DMCustomDTO();
			dmCustomDTO.setCustomerId("1871");
			dmCustomDTO.setId("3692");
			dmCustomDTO.setProposalId(1335);
			copyDMCustomDTO.setSourceDM(dmCustomDTO);
		}

		dmCustomDTO = copyDMCustomDTO.getSourceDM();

		if (dmCustomDTO.isSAndS()) {
			// Throw ServiceException
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0015);
		}

		soldtoParty = new TreeMap();
		HashMap map = new HashMap();
		map.put(UtilityConstants.BO_USERID, copyDMCustomDTO.getUserId());
		proposalContractBOFactory = new ProposalContractBOFactory();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(dmCustomDTO.getProposalId());
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}

		try {
			map.put(UtilityConstants.BO_GROUPNAME, copyDMCustomDTO
					.getGroupName());
			SharingBO sharingBO = getSharingBOFromFactory(proposalContractBO
					.getProposalId(), copyDMCustomDTO.getUserId());
			if (null != sharingBO) {
				map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}
			proposalContractBO.validateCopyInventory(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);

		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
		dmDomainDTO = new DMDomainDTO();
		dmDomainDTO.setProposalId(dmCustomDTO.getProposalId());
		dmDomainDTO
				.setCustomerId(Integer.parseInt(dmCustomDTO.getCustomerId()));
		dmDomainDTO.setDmId(Integer.parseInt(dmCustomDTO.getId()));
		dmDomainDTO.setActionName(ActionNameConstants.COPY_INVENTORY_DM);
		inventoryManagerLocal = getInventoryManagerLocal();
		customerDomainDTO = inventoryManagerLocal
				.retrieveCustomerAndDMInfo(dmDomainDTO);
		sourceCustomer = new ESWCustomerCustomDTO();
		sourceCustomer.setAddressSequenceNumber(customerDomainDTO
				.getCustmerASNo());
		sourceCustomer.setCustomerName(customerDomainDTO.getSapCustomerName());
		sourceCustomer.setLegacyCustomerNumber(customerDomainDTO
				.getLegacyCustomerNo());
		sourceCustomer.setSAPCustomerNumber(customerDomainDTO
				.getSapCustomerNo());
		for (int i = 0; i < customerDomainDTO.getDMDTOList().size(); i++) {
			dmDomainDTO = (DMDomainDTO) customerDomainDTO.getDMDTOList().get(i);
			dmCustomDTO.setNumber(dmDomainDTO.getDmNo());
			dmCustomDTO.setDescription(dmDomainDTO.getDmDesc());
			dmCustomDTO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
			dmCustomDTO.setPlanEndDate(dmDomainDTO.getPlanEndDate());
		}
		proposalDomainDTO = inventoryManagerLocal
				.retrieveCustomerForProposal(proposalDomainDTO);
		if (proposalDomainDTO.getCustomerDTOList() != null
				&& proposalDomainDTO.getCustomerDTOList().size() > 0) {
			for (int j = 0; j < proposalDomainDTO.getCustomerDTOList().size(); j++) {
				targetCustomerDomainDTO = (CustomerDomainDTO) proposalDomainDTO
						.getCustomerDTOList().get(j);
				if (targetCustomerDomainDTO.getSapCustomerNo() != null
						&& !(customerDomainDTO.getSapCustomerNo()
								.equals(targetCustomerDomainDTO
										.getSapCustomerNo()))) {

					targetCustomers = new ProposalCustomerCustomDTO();
					targetCustomers.setProposalId(targetCustomerDomainDTO
							.getProposalId());
					targetCustomers.setCustomerId(targetCustomerDomainDTO
							.getCustomerId());
					targetCustomers
							.setLegacyCustomerNumber(targetCustomerDomainDTO
									.getLegacyCustomerNo());
					targetCustomers
							.setSAPCustomerNumber(targetCustomerDomainDTO
									.getSapCustomerNo());
					targetCustomers
							.setAddressSequenceNumber(targetCustomerDomainDTO
									.getCustmerASNo());
					targetCustomers.setCustomerName(targetCustomerDomainDTO
							.getSapCustomerName());
					targetCustomers.setPlanStartDate(targetCustomerDomainDTO
							.getPlanStartDate());
					targetCustomers.setPlanEndDate(targetCustomerDomainDTO
							.getPlanEndDate());
					soldtoParty.put(String.valueOf(targetCustomerDomainDTO
							.getCustomerId()), targetCustomers);
				}
			}
		}
		if (soldtoParty != null && soldtoParty.size() < 1) {
			copyDMCustomDTO.addMessageEntry(ErrorCodeConstants.SE0122,
					OPPTMessageCatalog.TYPE_SERVICE);
		}
		copyDMCustomDTO.setTargetCustomers(soldtoParty);
		copyDMCustomDTO.setSourceCustomer(sourceCustomer);
		copyDMCustomDTO.setStartYears(OPPTCalender.getStartYearList());
		copyDMCustomDTO.setEndYears(OPPTCalender.getEndYearList());

		timeTaken.end();
		return copyDMCustomDTO;
	}

	/**
	 *
	 * This method copies one swo dm to another swo
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 3, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copySWOCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CopySWOCustomDTO copyInventory(CopySWOCustomDTO copySWOCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "copyInventory-SWO");

		int proposalId = 0;
		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalDomainDTO proposalDomainDTO = null;
		ProposalContractBO proposalContractBO = null;
		CustomerDomainDTO targetCustomerDomainDTO = null;
		CustomerDomainDTO customerDomainDTO = null;
		DMCustomDTO dmCustomDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		TreeMap soldtoParty = null;
		List swoDTOList = null;
		List dmDTOList = null;
		SWOCustomDTO swoCustomDTO = null;
		SWODomainDTO swoDomainDTO = null;
		DMDomainDTO dmDomainDTO = null;
		TreeMap targetDM = null;
		ProposalCustomerCustomDTO proposalCustomerCustomDTO = null;
		swoCustomDTO = copySWOCustomDTO.getSourceSWO();
		OPPTLogger.debug("SWOCustomDTO is S and S " + swoCustomDTO.isSAndS(),
				CLASS_NAME, "copyInventory-SWO");
		if (swoCustomDTO.isSAndS()) {
			// Throw ServiceException
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0014);
		}

		swoDomainDTO = new SWODomainDTO();
		soldtoParty = new TreeMap();
		proposalId = swoCustomDTO.getProposalId();
		HashMap map = new HashMap();
		map.put(UtilityConstants.BO_USERID, copySWOCustomDTO.getUserId());
		proposalContractBOFactory = new ProposalContractBOFactory();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
			map.put(UtilityConstants.BO_GROUPNAME, copySWOCustomDTO
					.getGroupName());
			SharingBO sharingBO = getSharingBOFromFactory(proposalContractBO
					.getProposalId(), copySWOCustomDTO.getUserId());
			if (null != sharingBO) {
				map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}
			proposalContractBO.validateCopyInventory(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);

		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);
		proposalDomainDTO.setActionName(ActionNameConstants.COPY_INVENTORY_SWO);
		swoDomainDTO.setProposalId(swoCustomDTO.getProposalId());
		swoDomainDTO.setCustomerId(Integer.parseInt(swoCustomDTO
				.getCustomerId()));
		swoDomainDTO.setDmId(Integer.parseInt(swoCustomDTO.getDMId()));
		swoDomainDTO.setSwoId(Integer.parseInt(swoCustomDTO.getId()));
		swoDomainDTO.setActionName(ActionNameConstants.COPY_INVENTORY_SWO);
		inventoryManagerLocal = getInventoryManagerLocal();
		proposalDomainDTO = inventoryManagerLocal
				.retrieveCustomerForProposal(proposalDomainDTO);
		customerDomainDTO = inventoryManagerLocal
				.retrieveSWOCopyInfo(swoDomainDTO);
		dmDTOList = customerDomainDTO.getDMDTOList();
		for (int i = 0; i < dmDTOList.size(); i++) {
			dmDomainDTO = (DMDomainDTO) dmDTOList.get(i);
			swoDTOList = dmDomainDTO.getSWODTOList();
			for (int j = 0; j < swoDTOList.size(); j++) {
				swoDomainDTO = (SWODomainDTO) swoDTOList.get(j);
			}
		}
		ESWCustomerCustomDTO sourceCustomer = new ESWCustomerCustomDTO();
		sourceCustomer.setAddressSequenceNumber(customerDomainDTO
				.getCustmerASNo());
		sourceCustomer.setCustomerName(customerDomainDTO.getSapCustomerName());
		sourceCustomer.setLegacyCustomerNumber(customerDomainDTO
				.getLegacyCustomerNo());
		sourceCustomer.setSAPCustomerNumber(customerDomainDTO
				.getSapCustomerNo());
		copySWOCustomDTO.setSourceCustomer(sourceCustomer);

		copySWOCustomDTO.setSourceDMNumber(dmDomainDTO.getDmNo());
		copySWOCustomDTO.setSourceDMDescription(dmDomainDTO.getDmDesc());
		copySWOCustomDTO.setPlanStartDate(swoDomainDTO.getPlanStartDate());
		copySWOCustomDTO.setPlanEndDate(swoDomainDTO.getPlanEndDate());
		swoCustomDTO.setSerialNumber(swoDomainDTO.getSerialNo());
		swoCustomDTO.setDescription(swoDomainDTO.getSwoDesc());
		swoCustomDTO.setNumber(swoDomainDTO.getSwoNo());
		if (swoDomainDTO.getItemCategory() != null
				&& swoDomainDTO.getItemCategory().equals(
						LicenseConstants.SVC_LICENSE_FLAG)) {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0125);
		}

		for (int i = 0; i < proposalDomainDTO.getCustomerDTOList().size(); i++) {
			targetCustomerDomainDTO = (CustomerDomainDTO) proposalDomainDTO
					.getCustomerDTOList().get(i);
			proposalCustomerCustomDTO = new ProposalCustomerCustomDTO();
			targetDM = new TreeMap();
			if (targetCustomerDomainDTO.getDMDTOList() != null
					&& targetCustomerDomainDTO.getDMDTOList().size() > 0) {
				for (int j = 0; j < targetCustomerDomainDTO.getDMDTOList()
						.size(); j++) {

					dmDomainDTO = (DMDomainDTO) targetCustomerDomainDTO
							.getDMDTOList().get(j);
					dmCustomDTO = new DMCustomDTO();
					dmCustomDTO.setProposalId(dmDomainDTO.getProposalId());
					dmCustomDTO.setCustomerId(String.valueOf(dmDomainDTO
							.getCustomerId()));
					dmCustomDTO.setId(String.valueOf(dmDomainDTO.getDmId()));
					dmCustomDTO.setNumber(dmDomainDTO.getDmNo());
					dmCustomDTO.setDescription(dmDomainDTO.getDmDesc());
					dmCustomDTO
							.setPlanStartDate(dmDomainDTO.getPlanStartDate());
					dmCustomDTO.setPlanEndDate(dmDomainDTO.getPlanEndDate());
					if (copySWOCustomDTO.getSourceDMNumber() != null
							&& !(copySWOCustomDTO.getSourceDMNumber()
									.equals(dmCustomDTO.getNumber()))) {
						targetDM.put(String.valueOf(dmDomainDTO.getDmId()),
								dmCustomDTO);
					}
				}
				proposalCustomerCustomDTO.setProposalId(targetCustomerDomainDTO
						.getProposalId());
				proposalCustomerCustomDTO.setCustomerId(targetCustomerDomainDTO
						.getCustomerId());
				proposalCustomerCustomDTO
						.setLegacyCustomerNumber(targetCustomerDomainDTO
								.getLegacyCustomerNo());
				proposalCustomerCustomDTO
						.setSAPCustomerNumber(targetCustomerDomainDTO
								.getSapCustomerNo());
				proposalCustomerCustomDTO
						.setAddressSequenceNumber(targetCustomerDomainDTO
								.getCustmerASNo());
				if (targetDM != null && targetDM.size() > 0) {
					proposalCustomerCustomDTO.setDMs(targetDM);
					soldtoParty.put(String.valueOf(targetCustomerDomainDTO
							.getCustomerId()), proposalCustomerCustomDTO);
				}
			}
		}
		if (targetDM != null && targetDM.size() < 1) {
			copySWOCustomDTO.addMessageEntry(ErrorCodeConstants.SE0123,
					OPPTMessageCatalog.TYPE_SERVICE);
		}
		copySWOCustomDTO.setTargetCustomers(soldtoParty);
		copySWOCustomDTO.setStartYears(OPPTCalender.getStartYearList());
		copySWOCustomDTO.setEndYears(OPPTCalender.getEndYearList());

		timeTaken.end();

		return copySWOCustomDTO;
	}

	/**
	 * This method is used to get header information of a proposal
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 7, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param ProposalHeaderCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public ProposalHeaderCustomDTO getHeaderInformation(
			ProposalHeaderCustomDTO proposalHeaderCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "getHeaderInformation");
		ProposalDataManagerLocal proposalDataManagerLocal = null;
		HashMap compareValues = new HashMap();
		java.util.Date contractReplacementDate = null;
		OPPTLogger.debug("ProposalId = "
				+ proposalHeaderCustomDTO.getProposal().getId(), CLASS_NAME,
				"getHeaderInformation");
		if (ActionNameConstants.SUBMIT_REPLACE_CONTRACT
				.equals(proposalHeaderCustomDTO.getTransactionName())) {
			contractReplacementDate = proposalHeaderCustomDTO
					.getBasicProposalCustomDTO().getReplacementContractDate();
		}
		try {
			proposalDataManagerLocal = (ProposalDataManagerLocal) HomeProvider
					.getProposalDataManagerLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"getHeaderInformation", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalCustomDTO proposalCustomDTO = proposalHeaderCustomDTO
				.getProposal();
		int proposalId = proposalCustomDTO.getId();

		ProposalContractBO proposalContractBO = null;
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalId);
			SharingBO sharingBO = getSharingBOFromFactory(proposalContractBO
					.getProposalId(), proposalHeaderCustomDTO.getUserId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					proposalHeaderCustomDTO, sharingBO);

		} catch (DomainException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"getHeaderInformation", null, ex);
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}
		if (ActionNameConstants.PROPOSAL_HEADER_DETAILS
				.equals(proposalHeaderCustomDTO.getTransactionName())
				|| ActionNameConstants.CONTRACT_HEADER_DETAILS
						.equals(proposalHeaderCustomDTO.getTransactionName())) {

			compareValues.put(UtilityConstants.BO_USERID,
					proposalHeaderCustomDTO.getUserId());
			compareValues.put(UtilityConstants.BO_GROUPNAME,
					proposalHeaderCustomDTO.getGroupName());
			compareValues.put(UtilityConstants.BO_ROLE, new Integer(
					proposalHeaderCustomDTO.getRole()));

			try {

				proposalContractBO.validateForDisplayProposalHeader(
						UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
						compareValues);
				// Post Condition check
				proposalContractBO.validateForDisplayProposalHeader(
						UtilityConstants.BUSINESSRULE_POST_COND_TYPE,
						compareValues);
				HashMap buttonMap = proposalContractBO.getPostConditionResult();
				proposalHeaderCustomDTO.setButtonFlags(buttonMap);

			} catch (DomainException e1) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						"getHeaderInformation", null, e1);
				throw ExceptionGenerator.generateServiceException(e1
						.getErrorReport());
			}
		}
		if (ActionNameConstants.CHANGE_PROPOSAL.equals(proposalHeaderCustomDTO
				.getTransactionName())
				|| ActionNameConstants.SUBMIT_REPLACE_CONTRACT
						.equals(proposalHeaderCustomDTO.getTransactionName())
				|| proposalContractBO.isVarianceProposal()) {
			compareValues.put(UtilityConstants.BO_USERID,
					proposalHeaderCustomDTO.getUserId());
			compareValues.put(UtilityConstants.BO_GROUPNAME,
					proposalHeaderCustomDTO.getGroupName());
			// For Change Proposal we need form details so that proposal can be
			// changed
			if (!ActionNameConstants.SUBMIT_REPLACE_CONTRACT
					.equals(proposalHeaderCustomDTO.getTransactionName())) {
				try {
					proposalContractBO.validateForChangeProposalHeader(
							UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
							compareValues);
				} catch (DomainException e1) {
					throw ExceptionGenerator.generateServiceException(e1
							.getErrorReport());
				}
				proposalHeaderCustomDTO
						.setProposalFormDataCustomDTO(proposalDataManagerLocal
								.getProposalFormData(false));
			} else {
				proposalHeaderCustomDTO
						.setProposalFormDataCustomDTO(proposalDataManagerLocal
								.getProposalFormData(true));
			}
		}

		if (!ActionNameConstants.SUBMIT_REPLACE_CONTRACT
				.equals(proposalHeaderCustomDTO.getTransactionName())) {
			if (ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS
					.equals(proposalContractBO.getStatusCode())) {
				// All dates are editable
			} else if (ProposalTypeConstants.EASII.equals(proposalContractBO
					.getProposalType())) {
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_START_DATE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_END_DATE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_PERIOD_END_DATE);
				//			Will be Inplimented after confirmation
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_SALES_ORGANIZATION);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_DISTRIBUTION_CHANNEL);
				proposalHeaderCustomDTO
				.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_SALES_GROUP);
				proposalHeaderCustomDTO
				.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CHANNEL_ROLE);
				proposalHeaderCustomDTO
				.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_SUBMITTER_ROLE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_DIVISION);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CURRENCY_CODE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_PROPOAL_NAME);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_PROPOAL_TYPE);
				//proposalHeaderCustomDTO.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_REPORT_NAME);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_PROPOSAL_CONTENT);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_PLANNED_GROWTH_OPTION);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_PLANNED_GROWTH_VALUE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_BILLING_FREQUENCY);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_GROWTH_LIMIT_OPTION);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_GROWTH_LIMIT_VALUE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_ADVANCE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_PAKID);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_TVMRATE);
				proposalHeaderCustomDTO
				.addNonEditableFields(FieldConstants.PRICING_INFORMATION_DISCOUNT);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_SS_ANNIVERSARY_CONTRACT_AMOUNT);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_DETAILED_INVOICE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_GSA);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_DEVIATING_DATE_RULE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_BILLING_DATE_RULE);
				//proposalHeaderCustomDTO.addNonEditableFields(FieldConstants.SECONDARY_PROPOSAL_DATA_PURCHASE_ORDER_NUMBER);
				//proposalHeaderCustomDTO.addNonEditableFields(FieldConstants.SECONDARY_PROPOSAL_DATA_PURCHASE_ORDER_DATE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.SECONDARY_PROPOSAL_DATA_ADD_VALUE_DAYS);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.SECONDARY_PROPOSAL_DATA_FIXED_VALUE_DATE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.SECONDARY_PROPOSAL_DATA_PAYMENT_TERMS);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.SECONDARY_PROPOSAL_DATA_IGF_OFFER_NUMBER);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.VARIANCE_INFORMATION_CAP_AMOUNT);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.VARIANCE_INFORMATION_CAP_PLUS);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.VARIANCE_INFORMATION_CAP_MINUS);

				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.CONTRACT_NUMBER);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.CONTRACT_TYPE);

			} else if (ContractTypeConstants.ORIGINAL.equals(proposalContractBO
					.getContrType())) {
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_PERIOD_END_DATE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_PERIOD_START_DATE);
			}
			if (ContractTypeConstants.RENEWAL.equals(proposalContractBO
					.getContrType())) {
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_START_DATE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_PERIOD_START_DATE);
				/* Start changes CR6153 */
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_EXTEND_PERIOD);
				if ((proposalContractBO.getExtendPeriod() != null)
						&& (proposalContractBO.getExtendPeriod()
								.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {

					proposalHeaderCustomDTO
							.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_PROPOSAL_CONTENT);
					proposalHeaderCustomDTO
							.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_PERIOD_END_DATE);
					proposalHeaderCustomDTO
							.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_END_DATE);
				}
				/* End changes CR6153 */

			} else if (ContractTypeConstants.REPLACEMENT
					.equals(proposalContractBO.getContrType())) {
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_START_DATE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_PERIOD_START_DATE);

				/* Start changes CR6153 */
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_EXTEND_PERIOD);
				/* End changes CR6153 */
			} else if (ContractTypeConstants.VARIANCE.equals(proposalContractBO
					.getContrType())) {
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_START_DATE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_END_DATE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_PERIOD_END_DATE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_PERIOD_START_DATE);
			}
		}
		PCMCustomDTOBuilder.populateProposalHeaderCustomDTO(
				proposalHeaderCustomDTO, proposalContractBO);
		if (proposalContractBO.isSAndSProposal()) {
			proposalHeaderCustomDTO.getBasicProposalCustomDTO()
					.setShowProposalContent(true);
			if (!ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS
					.equals(proposalContractBO.getStatusCode())
					&& (ContractTypeConstants.REPLACEMENT
							.equals(proposalContractBO.getContrType()))) {
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_PROPOSAL_CONTENT);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.PRICING_INFORMATION_EXTEND_PERIOD);
				/* CR6153 start changes */
				if ((proposalContractBO.getExtendPeriod() != null)
						&& (proposalContractBO.getExtendPeriod()
								.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {
					proposalHeaderCustomDTO
							.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_PERIOD_END_DATE);
					proposalHeaderCustomDTO
							.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_START_DATE);
					proposalHeaderCustomDTO
							.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_END_DATE);
				}
				/* CR6153 end changes */

			}
		}

		if ((proposalHeaderCustomDTO.getRole() == RoleConstants.PROPOSAL_APPROVER || proposalHeaderCustomDTO
				.getRole() == RoleConstants.CREATE_APPROVE) == false) {
			proposalHeaderCustomDTO.addButtonFlag(ButtonConstants.APPROVE);
			proposalHeaderCustomDTO.addButtonFlag(ButtonConstants.REJECT);
		}

		if (proposalContractBO.isContractInAmendment()) {
			proposalHeaderCustomDTO.setDisplayAmendmentEffectiveDate(true);
		}
		if (proposalContractBO.displayContractClosureDate()) {
			proposalHeaderCustomDTO.setDisplayContractClosureDate(true);
		}

		if (ActionNameConstants.SUBMIT_REPLACE_CONTRACT
				.equals(proposalHeaderCustomDTO.getTransactionName())) {
			if (proposalContractBO != null) {
				OPPTLogger
						.debug(
								"proposalHeaderCustomDTO.getBasicProposalCustomDTO().getReplacementContractDate() = "
										+ proposalHeaderCustomDTO
												.getBasicProposalCustomDTO()
												.getReplacementContractDate(),
								CLASS_NAME, "getHeaderInformation");
				OPPTLogger.debug("proposalContractBO.getContrNo() = "
						+ proposalContractBO.getContrNo(), CLASS_NAME,
						"getHeaderInformation");
				if (ProposalTypeConstants.EASII.equals(proposalContractBO
						.getProposalType())) {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0036);
				}
				if (null != contractReplacementDate) {
					ReplaceContractCustomDTO replContract = new ReplaceContractCustomDTO();
					ContractCustomDTO contract = new ContractCustomDTO();
					contract.setId(proposalContractBO.getProposalId());
					replContract.setContractDTO(contract);
					replContract
							.setContractReplacementDate(contractReplacementDate);
					replContract.setContractPeriodEndDate(proposalContractBO
							.getContrEndPeriod());
					replContract.setContractPeriodStartDate(proposalContractBO
							.getContrStartPeriod());
					validateReplacementDate(replContract);
					proposalHeaderCustomDTO
							.getBasicProposalCustomDTO()
							.setContractPeriodBeginning(contractReplacementDate);
					proposalHeaderCustomDTO.getBasicProposalCustomDTO()
							.setContractStartDate(contractReplacementDate);
				}
				proposalHeaderCustomDTO.getBasicProposalCustomDTO()
						.setReplacementContractNumber(
								proposalContractBO.getContrNo());
				if (!proposalContractBO.isSAndSProposal()) {
					proposalHeaderCustomDTO.getBasicProposalCustomDTO()
							.setProposalContent(null);
				}

				proposalHeaderCustomDTO.getBasicProposalCustomDTO()
						.setReplacementContractDate(contractReplacementDate);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_START_DATE);
				proposalHeaderCustomDTO
						.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_PERIOD_START_DATE);
				if (proposalContractBO.isSAndSProposal()) {
					//proposalHeaderCustomDTO.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_PROPOAL_TYPE);
					proposalHeaderCustomDTO
							.addNonEditableFields(FieldConstants.PRICING_INFORMATION_EXTEND_PERIOD);
					//proposalHeaderCustomDTO.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_PROPOSAL_CONTENT);
				}
				if (!proposalHeaderCustomDTO.getBasicProposalCustomDTO()
						.getProposalType().equals(ProposalTypeConstants.EASII)) {
					if (proposalHeaderCustomDTO
							.getPricingInformationCustomDTO()
							.getBillingFrequency().equals(
									UtilityConstants.BILLING_FREQ_QUARTERLY)) {
						Date replacementDateSQL = new Date(
								proposalHeaderCustomDTO
										.getBasicProposalCustomDTO()
										.getContractPeriodBeginning().getTime());
						String cntrStartPeriod = replacementDateSQL.toString();
						String cntrStartPeriodMonth = cntrStartPeriod
								.substring(5, 7);

						if (cntrStartPeriodMonth.equals("01")
								|| cntrStartPeriodMonth.equals("04")
								|| cntrStartPeriodMonth.equals("07")
								|| cntrStartPeriodMonth.equals("10")) {
							proposalHeaderCustomDTO
									.getPricingInformationCustomDTO()
									.setBillingDateRule("YE");
						} else {
							proposalHeaderCustomDTO
									.getPricingInformationCustomDTO()
									.setBillingDateRule("9Q");
						}
					}
				}
			}
		}

		//Added for the UI to display starts
		/*
		 * Commented to eliminate customerlist functionality
		 * DADO02 Sateesh Anne
		 * List customerBOList = new ArrayList();
		CustomerListBOFactory customerListBOFactory = new CustomerListBOFactory();
		TreeMap customerListMap = new TreeMap();
		try {
			customerBOList = customerListBOFactory
					.findCustomerListBOForProposal(proposalContractBO
							.getProposalId());
			for (int i = 0, size = customerBOList.size(); i < size; i++) {
				CustomerListBO customerListBO = (CustomerListBO) customerBOList
						.get(i);
				CustomerListCustomDTO customerListCustomDTO = new CustomerListCustomDTO();
				customerListCustomDTO.setAlreadyExists(true);
				customerListCustomDTO.setListName(customerListBO
						.getCustomerListDesc());
				customerListCustomDTO.setListNumber(customerListBO
						.getCustomerListNo());
				customerListMap.put(customerListBO.getCustomerListNo(),
						customerListCustomDTO);
			}
			PartnerInformationCustomDTO partnerInformationCustomDTO = proposalHeaderCustomDTO
					.getPartnerInformationCustomDTO();
			partnerInformationCustomDTO.setCustomerLists(customerListMap);
			proposalHeaderCustomDTO
					.setPartnerInformationCustomDTO(partnerInformationCustomDTO);
		} catch (DomainException e3) {
			// We do not handle this Exception because customerList may not be
			// present for all proposals
			OPPTLogger.debug(e3.toString(), CLASS_NAME, "getHeaderInformation");
		}*/
		// Added for the UI to display ends
		proposalHeaderCustomDTO.addButtonFlag(ButtonConstants.CONTINUE);
		if (proposalContractBO.isVarianceProposal()) {
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_START_DATE);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_END_DATE);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_PERIOD_END_DATE);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CONTRACT_PERIOD_START_DATE);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_SALES_ORGANIZATION);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_DISTRIBUTION_CHANNEL);
			proposalHeaderCustomDTO
			.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_SALES_GROUP);
			proposalHeaderCustomDTO
			.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CHANNEL_ROLE);
			proposalHeaderCustomDTO
			.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_SUBMITTER_ROLE);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_DIVISION);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_CURRENCY_CODE);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_PROPOAL_NAME);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_PROPOAL_TYPE);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_EXTERNAL_CONTRACT_NUMBER);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_REPORT_NAME);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.BASIC_PROPOSAL_DATA_REPORT_NAME);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.PRICING_INFORMATION_VARIANCE_DATE);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.VARIANCE_INFORMATION_CAP_AMOUNT);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.CONTRACT_NUMBER);
			proposalHeaderCustomDTO
					.addNonEditableFields(FieldConstants.CONTRACT_TYPE);
			proposalHeaderCustomDTO.setChangeVarianceProposal(true);

		} else {
			proposalHeaderCustomDTO.setChangeVarianceProposal(false);
		}

		if (RoleConstants.PROPOSAL_APPROVER == proposalHeaderCustomDTO
				.getRole()
				|| RoleConstants.CREATE_APPROVE == proposalHeaderCustomDTO
						.getRole()) {
			proposalHeaderCustomDTO.setDisplayAdditionalGrowthLimit(false);
		}
		if (ActionNameConstants.SUBMIT_REPLACE_CONTRACT
				.equals(proposalHeaderCustomDTO.getTransactionName())) {
			/**
			 * This is for defect 14 in 51x
			 *
			 * @param proposalId
			 * @return
			 * @throws SQLException
			 * @author balajiv
			 */
			if (proposalHeaderCustomDTO.getBasicProposalCustomDTO() != null) {
				ProposalContractDTOFactory proposalContractDTOFactory = new ProposalContractDTOFactory();
				String defaultCurrency = "";
				try {
					defaultCurrency = proposalContractDTOFactory
							.getDefaultCurrencyForSalesOrg(proposalHeaderCustomDTO
									.getBasicProposalCustomDTO()
									.getSalesOrganization());
				} catch (Exception e) {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0801);
				}
				proposalHeaderCustomDTO.getBasicProposalCustomDTO()
						.setDefaultCurrencyCode(defaultCurrency);
			}
		}

		log.end();
		return proposalHeaderCustomDTO;
	}

	/**
	 * This method is used to add the selected customers to the proposal PA010
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 7, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param selectedCustomersCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public AddCustomerCustomDTO addSelectedCustomers(
			AddCustomerCustomDTO addCustomerCustomDTO) throws ServiceException {
		//Retrieve all the customers assosiated with the proposal
		TreeMap customerListMap = addCustomerCustomDTO.getCustomerLists();
		Set keySet = customerListMap.keySet();
		Iterator iter = keySet.iterator();
		ProposalContractBOFactory factory = new ProposalContractBOFactory();
		ProposalContractBO proposalBO = null;
		try {
			proposalBO = factory.getProposalContractBO(addCustomerCustomDTO
					.getProposal().getId());
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de
					.getErrorReport());
		}
		while (iter.hasNext()) {
			CustomerListCustomDTO customerListCustomDTO = (CustomerListCustomDTO) customerListMap
					.get(iter.next());
			// CustomerList can have selectedCustomers each selected customers
			// should be added to the SoldToPartyTable
			TreeMap customerListCustomerMap = customerListCustomDTO
					.getCustomers();
			/*// DADO02 addCustomersToProposals(customerListCustomerMap,
					addCustomerCustomDTO.getProposal().getId(),
					customerListCustomDTO.getListNumber(), proposalBO);*/
		} // End of customerList

		return addCustomerCustomDTO;
	}

	/**
	 * This method is used for PA010 for retrieving the customers
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 8, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param addCustomerCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public AddCustomerCustomDTO getProposalCustomers(
			AddCustomerCustomDTO addCustomerCustomDTO) throws ServiceException {

		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalCustomDTO proposalCustomDTO = addCustomerCustomDTO
				.getProposal();
		// int proposalId = proposalCustomDTO.getId();
		ProposalBO proposalBO = null;
		SharingBO shareBO = null;
		HashMap compareValues = null;

		try {
			proposalBO = (ProposalBO) proposalContractBOFactory
					.getProposalContractBO(proposalCustomDTO.getId());
			shareBO = getSharingBOFromFactory(proposalCustomDTO.getId(),
					addCustomerCustomDTO.getUserId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					addCustomerCustomDTO, shareBO);
			compareValues.put(UtilityConstants.STATUS_CODE, proposalCustomDTO
					.getStatus());
			proposalBO.validateForAddCustomer(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);

		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		TreeMap customerListCustomDTOMap = new TreeMap();
		Map availabelCustomers = new HashMap();

		CustomerListBOFactory customerListBOFactory = new CustomerListBOFactory();
		List customerListBOList = new ArrayList();
		try {
			customerListBOList = customerListBOFactory
					.findCustomerListBOForProposal(proposalCustomDTO.getId());
		} catch (DomainException e1) {
			throw ExceptionGenerator.generateServiceException(e1
					.getErrorReport());

		}

		if (customerListBOList.size() == 0) {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0006);
		}

		// will be used for the RFC call
		List customerListNumbers = new ArrayList();
		for (int i = 0, size = customerListBOList.size(); i < size; i++) {
			CustomerListBO customerListBO = (CustomerListBO) customerListBOList
					.get(i);
			CustomerListCustomDTO customerListCustomDTO = new CustomerListCustomDTO();
			customerListCustomDTO.setAlreadyExists(true);
			customerListCustomDTO.setListName(customerListBO
					.getCustomerListDesc());
			customerListCustomDTO.setListNumber(customerListBO
					.getCustomerListNo());
			customerListCustomDTOMap.put(customerListBO.getCustomerListNo(),
					customerListCustomDTO);
			customerListNumbers.add(customerListBO.getCustomerListNo());

		}
		// Retrieve all the customers assosiated with the proposal
		ProposalDomainDTO proposalDomainDTO = new ProposalDomainDTO();
		proposalDomainDTO.setProposalId(proposalCustomDTO.getId());
		InventoryManagerLocal inventoryManagerLocal = null;
		try {
			inventoryManagerLocal = (InventoryManagerLocal) HomeProvider
					.getInventoryManagerLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"getProposalCustomers", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		proposalDomainDTO = inventoryManagerLocal
				.retrieveCustomerForProposal(proposalDomainDTO);

		for (int i = 0, size = proposalDomainDTO.getCustomerDTOList().size(); i < size; i++) {
			CustomerDomainDTO customerDomainDTO = (CustomerDomainDTO) proposalDomainDTO
					.getCustomerDTOList().get(i);
			availabelCustomers.put(customerDomainDTO.getLegacyCustomerNo(),
					customerDomainDTO.getLegacyCustomerNo());

		}

		RetrieveCustInputConnectorDTO inputConnectorDTO = new RetrieveCustInputConnectorDTO();
		inputConnectorDTO.setCustomerListNumber(customerListNumbers);
		//populate org generic data
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
		genericConnectorDTO
				.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_CUSTOMER_OPPT);
		genericConnectorDTO.setUserID(addCustomerCustomDTO.getUserId());
		genericConnectorDTO.setSessionID(addCustomerCustomDTO.getSessionId());
		inputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		// populate org specific data
		OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
		orgConnectorDTO.setDistributionChannel(proposalBO.getDistrChannel());
		orgConnectorDTO.setSalesGroup(proposalBO.getSalesGroup());
		orgConnectorDTO.setChannelRole(proposalBO.getChannelRole());
		orgConnectorDTO.setSubmitterRole(proposalBO.getSubmitterRole());
		orgConnectorDTO.setDivision(proposalBO.getDivisionCode());
		orgConnectorDTO.setSalesOrg(proposalBO.getSalesOrg());
		inputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);
		JMSConnectorLocal jmsConnectorLocal = null;
		try {
			jmsConnectorLocal = (JMSConnectorLocal) HomeProvider
					.getJMSConnectorLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"getProposalCustomers", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);

		}
		RetrieveCustOutputConnectorDTO outputConnectorDTO = new RetrieveCustOutputConnectorDTO();
		try {
			outputConnectorDTO = (RetrieveCustOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(inputConnectorDTO);
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"getProposalCustomers", null, e1);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);

		}
		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(outputConnectorDTO
				.getReturnCode())) {
			List customerList = outputConnectorDTO
					.getRetrieveCustConnectorDTOList();
			// in Loop
			for (int k = 0; k < customerList.size(); k++) {
				RetrieveCustConnectorDTO retrieveCustConnectorDTO = (RetrieveCustConnectorDTO) customerList
						.get(k);
				CustomerListCustomerCustomDTO customerListCustomerCustomDTO = new CustomerListCustomerCustomDTO();
				customerListCustomerCustomDTO
						.setCustomerName(retrieveCustConnectorDTO
								.getCustomerName());
				customerListCustomerCustomDTO
						.setCustomerNumber(retrieveCustConnectorDTO
								.getCustomerNo());
				customerListCustomerCustomDTO
						.setLegacyCustomerNumber(retrieveCustConnectorDTO
								.getLegacyCustomerNo());
				customerListCustomerCustomDTO
						.setAddressSequenceNumber(retrieveCustConnectorDTO
								.getAddressSeqNo());
				// We populate the custome dto's.
				if (null != availabelCustomers.get(retrieveCustConnectorDTO
						.getLegacyCustomerNo())) {
					customerListCustomerCustomDTO.setAlreadyExists(true);
				}
				//We populate the custome dto's.
				CustomerListCustomDTO customerListCustomDTO = (CustomerListCustomDTO) customerListCustomDTOMap
						.get(retrieveCustConnectorDTO.getCustomerListNo());
				TreeMap customersMap = customerListCustomDTO.getCustomers();
				if (customersMap == null) {
					customersMap = new TreeMap();
					customersMap
							.put(customerListCustomerCustomDTO
									.getCustomerNumber(),
									customerListCustomerCustomDTO);
					customerListCustomDTO.setCustomers(customersMap);
				} else {

					customersMap
							.put(customerListCustomerCustomDTO
									.getCustomerNumber(),
									customerListCustomerCustomDTO);
				}
			}
			// in Loop
			if (availabelCustomers.size() == customerList.size()) {
				// all the customers have been added
				addCustomerCustomDTO
						.addButtonFlag(ButtonConstants.FETCH_INVENTORY);
				addCustomerCustomDTO
						.addButtonFlag(ButtonConstants.FETCH_PLANNED_INVENTORY);
			}
		} else {
			throwServiceException(outputConnectorDTO.getReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
		}

		// Populating the custom DTO
		addCustomerCustomDTO.setCustomerLists(customerListCustomDTOMap);
		return addCustomerCustomDTO;
	}

	/**
	 * This method checks with ESW backend if the request for Proposal/Contract
	 * status is completed successfully. If yes, then change the
	 * Proposal/Contract status as per Business Rule.
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 13, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public StatusCheckCustomDTO checkProposalStatus(
			StatusCheckCustomDTO statusCheckCustomDTO) throws ServiceException {

		TimeTaken log = new TimeTaken(CLASS_NAME, "checkProposalStatus");

		ErrorReport errorReport = new ErrorReport();
		boolean chkPreCondition = false;

		ProposalContractBO proposalBO = null;
		SharingBO shareBO = null;
		HashMap compareValues = null;
		StatusCheckOutputConnectorDTO statusCheckOutputConnectorDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;

		// chk the preconditions for executing the Use Case
		try {
			OPPTLogger.debug("getSharingBOFromFactory", CLASS_NAME,
					"checkProposalStatus");
			shareBO = getSharingBOFromFactory(statusCheckCustomDTO.getId(),
					statusCheckCustomDTO.getUserId());
			OPPTLogger.debug("getContractBOFromFactory", CLASS_NAME,
					"checkProposalStatus");
			proposalBO = getProposalContractBOFromFactory(statusCheckCustomDTO
					.getId());
			OPPTLogger.debug("PopulateCompareValuesForUserAuthInProposalBO",
					CLASS_NAME, "checkProposalStatus");
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					statusCheckCustomDTO, shareBO);
			OPPTLogger.debug("validateCheckProposalStatus", CLASS_NAME,
					"checkProposalStatus");
			proposalBO.validateCheckProposalStatus(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);

		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}

		OPPTLogger.debug("ValidationForProposalCompleted", CLASS_NAME,
				"checkProposalStatus");

		// get ProposalBO for 'Select ext_cntr_number(old) of the proposal
		// having cntr number same as old cntr number of proposal'
		ProposalContractBOFactory factory = new ProposalContractBOFactory();
		String oldExternalContractNumber = null;

		try {

			if (!(ProposalContractStatusConstants.CHECK_CLOSURE_STATUS
					.equals(proposalBO.getStatusCode()) || ProposalContractStatusConstants.CHECK_EXTENSION_STATUS
					.equals(proposalBO.getStatusCode()))) {
				OPPTLogger.debug("ProposalStatus in NOT one of CC or CE",
						CLASS_NAME, "checkProposalStatus");
				if (null != proposalBO.getOldContrNo()) {
					OPPTLogger.debug(
							"oldContractNo is not null. Old Contract number is #"
									+ proposalBO.getOldContrNo().trim() + "#",
							CLASS_NAME, "checkProposalStatus");
					ProposalContractBO propBO = factory
							.getProposalContractBOForContractNumber(OPPTHelper
									.trimString(proposalBO.getOldContrNo()),
									true);

					OPPTLogger.debug("Old External Contract Number is #"
							+ propBO.getExtContrNo() + "#", CLASS_NAME,
							"checkProposalStatus");
					if (null != propBO) {
						oldExternalContractNumber = propBO.getExtContrNo();
					}
				}
			}

			OPPTLogger.debug("Building Status Check Input Connector DTO",
					CLASS_NAME, "checkProposalStatus");

			ProposalDomainDTO domainDTO = new ProposalDomainDTO(proposalBO);
			StatusCheckInputConnectorDTO statusCheckInputConnectorDTO = InputConnectorDTOBuildHelper
					.buildStatusCheckInputConnectorDTO(domainDTO,
							statusCheckCustomDTO, oldExternalContractNumber);

			JMSConnectorLocal jmsConnectorLocal = HomeProvider
					.getJMSConnectorLocal();
			statusCheckOutputConnectorDTO = (StatusCheckOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(statusCheckInputConnectorDTO);
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		} catch (Exception ex1) {
			throw ExceptionGenerator.generateServiceException("SE0801");
		}

		ArrayList proposalBOList = null;

		String messageString = OPPTHelper
				.getLogString(statusCheckOutputConnectorDTO.getReturnCode());
		OPPTLogger.log("STATUS_CHECK_RC", OPPTLogger.DEBUG, CLASS_NAME,
				"checkProposalStatus", messageString);

		messageString = OPPTHelper.getLogString(statusCheckOutputConnectorDTO
				.getReturnCodeSAP());
		OPPTLogger.log("STATUS_CHECK_RC_SAP", OPPTLogger.DEBUG, CLASS_NAME,
				"checkProposalStatus", messageString);

		if (null != statusCheckOutputConnectorDTO
				&& ConnectorConstants.RFC_SUCCESS_CODE
						.equals(statusCheckOutputConnectorDTO.getReturnCode())) {
			StatusCheckHelper statusCheckHelper = new StatusCheckHelper();
			proposalBOList = statusCheckHelper.populateBOForStatusCheck(
					proposalBO, statusCheckOutputConnectorDTO);

			// update the Proposal table for both the Proposal - 1) Proposal
			// that user selected 2) If there is any original proposal for
			// proposal 1.
			Iterator propIterate = proposalBOList.iterator();

			while (propIterate.hasNext()) {
				try {
					ProposalContractBO nextProp = (ProposalContractBO) propIterate
							.next();
					OPPTLogger.debug(
							"Proposal being updated. The proposal/Contract id is #"
									+ nextProp.getProposalId() + "#",
							CLASS_NAME, " populateBOForStatusCheck");

					factory.updateProposalContractBO(nextProp);
				} catch (DomainException e) {
					throw ExceptionGenerator.generateServiceException(e
							.getErrorReport());
				}
			}

		} else {
			//storeErrorList(statusCheckOutputConnectorDTO.getReturnCode(),
			// proposalCustomDTO.getId(), proposalCustomDTO.getUserId(),
			// "statusCheck");
			// getSessionContext().setRollbackOnly();
			throwServiceException(
					statusCheckOutputConnectorDTO.getReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
		}

		if (!ConnectorConstants.RFC_SUCCESS_CODE
				.equals(statusCheckOutputConnectorDTO.getReturnCodeSAP())) {
			OPPTLogger.debug("SAP RC not equal to 0. Making ErrorList Entry",
					CLASS_NAME, " populateBOForStatusCheck");

			if (80 != Integer.valueOf(
					statusCheckOutputConnectorDTO.getReturnCodeSAP())
					.intValue()) {

				List dtoList = statusCheckOutputConnectorDTO
						.getMessageConnectorDTOList();

				if (null != dtoList && 0 != dtoList.size()) {
					Iterator dtoIter = dtoList.iterator();
					StringBuffer buffer = new StringBuffer();

					while (dtoIter.hasNext()) {
						MessageConnectorDTO messageConnectorDTO = (MessageConnectorDTO) dtoIter
								.next();

						buffer.append(messageConnectorDTO.getExceptionCode());
						buffer.append("|");
						buffer.append(messageConnectorDTO.getSalesDocNo());
						buffer.append("|");
						buffer.append(messageConnectorDTO.getItemPositionNo());
						buffer.append("|");
						buffer.append(messageConnectorDTO
								.getInternalContractNo());
						buffer.append("|");
						buffer.append(messageConnectorDTO.getMessage());
						buffer.append("|");
					}

					String messageDetail = buffer.toString();
					storeErrorList(statusCheckOutputConnectorDTO
							.getReturnCodeSAP(), statusCheckCustomDTO.getId(),
							statusCheckCustomDTO.getUserId(), "statusCheck",
							messageDetail);

				} else {
					storeErrorList(statusCheckOutputConnectorDTO
							.getReturnCodeSAP(), statusCheckCustomDTO.getId(),
							statusCheckCustomDTO.getUserId(), "statusCheck");
				}
				ErrorReport rep = ExceptionGenerator.getErrorReport(
						statusCheckOutputConnectorDTO.getReturnCodeSAP(),
						OPPTMessageCatalog.TYPE_BACKEND);
				statusCheckCustomDTO.setMessageReport(rep);
			} else {
				ErrorReport rep = ExceptionGenerator.getErrorReport(
						statusCheckOutputConnectorDTO.getReturnCodeSAP(),
						OPPTMessageCatalog.TYPE_BACKEND);
				statusCheckCustomDTO.setMessageReport(rep);
				statusCheckCustomDTO.setMessageForward(true);
			}

		} else {
			statusCheckCustomDTO.setMessageReport(null);
		}

		log.end();

		return statusCheckCustomDTO;
	}

	/**
	 * To check whether the proposal is eligible for sharing.
	 *
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 21, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param customDTO
	 * @return
	 * @throws ServiceException
	 */
	public ShareProposalCustomDTO getEligibleUserToShareProposal(
			ShareProposalCustomDTO customDTO) throws ServiceException {
		String methodName = "getEligibleUserToShareProposal";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		ProposalCustomDTO proposalDTO = customDTO.getProposalDTO();

		ProposalContractBOFactory factory = new ProposalContractBOFactory();
		String loggedInUser = customDTO.getUserId();
		SharingBOFactory sharingBOFactory = new SharingBOFactory();
		SharingBO sharingBO = null;

		try {
			UserProfileBOFactory userBOFactory = new UserProfileBOFactory();
			UserProfileBO userBO = userBOFactory.getUserProfileBO(loggedInUser);
			boolean isUserInGroup = (userBO.getGroupName() != null && userBO
					.getGroupName().trim().length() > 0);

			ProposalBO bo = (ProposalBO) factory
					.getProposalContractBO(proposalDTO.getId());
			proposalDTO.setUserId(customDTO.getUserId());
			proposalDTO.setGroupName(customDTO.getGroupName());

			HashMap compareValues = populateCompareValuesForUserAuthInProposalBO(
					proposalDTO, null);
			compareValues.put(UtilityConstants.USER_IN_GROUP, new Boolean(
					isUserInGroup));

			bo.validateForProposalSharing(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);

			sharingBO = sharingBOFactory.getSharingBO(proposalDTO.getId(),
					loggedInUser);

			if (sharingBO != null) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0322);
			}

			String createUser = bo.getCreatedBy();

			UserProfileBOFactory userProfileFactory = new UserProfileBOFactory();
			UserProfileBO createUserProfile = userProfileFactory
					.getUserProfileBO(createUser);

			GeoSecOffBOFactory geoFactory = new GeoSecOffBOFactory();
			String user;
			GeoSecOffBO geoBO = geoFactory
					.findGEOSecOffBOForSalesOrg(createUserProfile
							.getPrimarySalesOrg());
			//Collection collection =
			// userProfileFactory.findAllForSalesOrgAndRole(geoBO.getGeoSecOffSO(),
			// Integer.toString(RoleConstants.BHD));
			Collection collection = userProfileFactory.findUserByRole(Integer
					.toString(RoleConstants.BHD));
			Iterator userIterator = collection.iterator();

			while (userIterator.hasNext()) {
				userBO = (UserProfileBO) userIterator.next();
				user = userBO.getUserId();
				if (user.equals(createUser) || user.equals(loggedInUser)) {
					continue;
				} else {
					customDTO.addUser(user, user);
				}
			}
			/*
			 * Collection collection =
			 * geoFactory.findAllGEOSecForSalesOrg(createUserProfile.getPrimarySalesOrg());
			 *
			 * if (collection != null) { Iterator iter = collection.iterator();
			 *
			 * Map salesOrgMap = new HashMap();
			 *
			 * String user;
			 *
			 * while (iter.hasNext()) {
			 *
			 * GeoSecOffBO geoBO = (GeoSecOffBO) iter.next();
			 *
			 * GeoSecOffBO geoBO =
			 * geoFactory.findGEOSecOffBOForSalesOrg(createUserProfile.getPrimarySalesOrg());
			 * if (salesOrgMap.containsKey(geoBO.getSalesOrg()) == false) {
			 * Collection collection =
			 * userProfileFactory.findAllForSalesOrgAndRole(geoBO.getGeoSecOffSO(),
			 * Integer.toString(RoleConstants.BHD)); Iterator userIterator =
			 * collection.iterator();
			 *
			 * while (userIterator.hasNext()) { userBO = (UserProfileBO)
			 * userIterator.next(); user = userBO.getUserId(); if
			 * (user.equals(createUser) || user.equals(loggedInUser)) {
			 * continue; } else { customDTO.addUser(user, user); } } }
			 *
			 * salesOrgMap.put(geoBO.getSalesOrg(), ""); } }
			 */

			List list = sharingBOFactory.findSharingBOByProposalId(proposalDTO
					.getId());

			if (list != null && list.size() > 0) {
				Iterator iter = list.iterator();

				while (iter.hasNext()) {
					sharingBO = (SharingBO) iter.next();
					customDTO.addAccessType(OPPTHelper.trimString(sharingBO
							.getAccessTo()), OPPTHelper.trimString(sharingBO
							.getAccessType()));
				}
			}

			return customDTO;
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					methodName, null, e);
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} catch (ServiceException e) {
			throw e;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *
	 * shareProposal shareProposal
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Feb 3, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param shareProposalCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public ShareProposalCustomDTO shareProposal(
			ShareProposalCustomDTO shareProposalCustomDTO)
			throws ServiceException {
		String methodName = "shareProposal";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {
			ProposalCustomDTO proposalDTO = shareProposalCustomDTO
					.getProposalDTO();
			SharingBOFactory sharingBOFactory = new SharingBOFactory();

			ProposalContractBOFactory proposalBOFactory = new ProposalContractBOFactory();
			ProposalBO proposalBO = (ProposalBO) proposalBOFactory
					.getProposalContractBO(proposalDTO.getId());

			ProposalDomainDTO proposalDomainDTO = new ProposalDomainDTO(
					proposalBO);

			InventoryManagerLocal inventoryManagerLocal = getInventoryManagerLocal();
			ProposalDomainDTO propDomainDTO = inventoryManagerLocal
					.retrieveCustomerForProposal(proposalDomainDTO);
			List customerDomainDTOList = propDomainDTO.getCustomerDTOList();

			String loggedInUser = shareProposalCustomDTO.getUserId();

			HashMap map = populateCompareValuesForUserAuthInProposalBO(
					shareProposalCustomDTO, null);
			map.put(UtilityConstants.USER_IN_GROUP, new Boolean(
					isUserInGroup(loggedInUser)));

			proposalBO.validateForProposalSharing(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);

			TreeMap accessMap = shareProposalCustomDTO.getAccessType();

			List list = sharingBOFactory.findSharingBOByProposalId(proposalDTO
					.getId());
			Map sharingUserMap = new HashMap();

			Iterator iter;

			if (list != null) {
				iter = list.iterator();

				while (iter.hasNext()) {
					SharingBO sharingBO = (SharingBO) iter.next();

					if ((UtilityConstants.SHARED_FULL_MODE.equals(OPPTHelper
							.trimString(sharingBO.getAccessType()))) == false) {
						sharingUserMap.put(OPPTHelper.trimString(sharingBO
								.getAccessTo()), "");
					}
				}
			}

			iter = accessMap.keySet().iterator();

			boolean fullAccessFound = false;

			while (iter.hasNext()) {
				String accessUser = (String) iter.next();
				String accessType = (String) accessMap.get(accessUser);

				accessType = (accessType == null) ? "" : accessType.trim();

				if (UtilityConstants.SHARED_FULL_MODE.equals(accessType)) {
					if (fullAccessFound) {
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0318);
					} else {
						fullAccessFound = true;
					}
				}

			}

			iter = accessMap.keySet().iterator();
			while (iter.hasNext()) {
				String accessUser = (String) iter.next();
				String accessType = (String) accessMap.get(accessUser);

				accessUser = (accessUser == null) ? "" : accessUser.trim();
				accessType = (accessType == null) ? "" : accessType.trim();

				sharingUserMap.remove(accessUser);

				String proposalSharing = OPPTHelper.trimString(proposalBO
						.getProposalSharing());

				boolean isProposalFullyShared = (proposalSharing != null && UtilityConstants.CREATOR_READ_MODE
						.equals(proposalSharing));

				boolean isProfileEligible = false;

				SharingBO accessSharingBO = sharingBOFactory.getSharingBO(
						proposalBO.getProposalId(), accessUser);
				boolean canCreateAccess = false;

				if (accessSharingBO == null) {
					canCreateAccess = true;
					accessSharingBO = new SharingBO();
					accessSharingBO.setAccessTo(accessUser);
					accessSharingBO.setProposalId(proposalBO.getProposalId());
				}

				accessSharingBO.setAccessType(accessType);

				if (UtilityConstants.SHARED_FULL_MODE.equals(accessType)) {
					if (isProposalFullyShared) {
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0318);
					}

					ValidateUserAccessInputConnectorDTO dto = InputConnectorDTOBuildHelper
							.buildValidateUserAccessInputConnectorDTO(
									proposalDomainDTO, shareProposalCustomDTO
											.getSessionId(), accessUser,
									customerDomainDTOList);

					JMSConnectorLocal jmsLocal = HomeProvider
							.getJMSConnectorLocal();
					ValidateUserAccessOutputConnectorDTO outputDTO = (ValidateUserAccessOutputConnectorDTO) jmsLocal
							.sendReceive(dto);

					isProfileEligible = ConnectorConstants.RFC_SUCCESS_CODE
							.equals(outputDTO.getReturnCode());

					if (isProfileEligible) {
						proposalBO
								.setProposalSharing(UtilityConstants.SHARED_FULL_MODE);
						accessSharingBO
								.setAccessType(UtilityConstants.SHARED_FULL_MODE);
					}
				} else if (UtilityConstants.SHARED_READ_MODE.equals(accessType)) {
					//SharingBO sharingBO =
					// sharingBOFactory.getSharingBO(proposalDTO.getId(),
					// accessUser);
					//isProfileEligible = (sharingBO == null);
					isProfileEligible = true;

					if (isProposalFullyShared == false) {
						proposalBO
								.setProposalSharing(UtilityConstants.SHARED_READ_MODE);
					}

					accessSharingBO
							.setAccessType(UtilityConstants.SHARED_READ_MODE);
				} else {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0317);
				}

				if (isProfileEligible) {
					if (isProposalFullyShared == false) {
						proposalBOFactory.updateProposalContractBO(proposalBO);
					}

					if (canCreateAccess) {
						sharingBOFactory.createSharingBO(accessSharingBO);
					} else {
						sharingBOFactory.updateSharingBO(accessSharingBO);
					}
				} else {
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0319);
				}
			}

			if (sharingUserMap.isEmpty() == false) {
				removeShare(proposalDTO.getId(), sharingUserMap);
			}

			return shareProposalCustomDTO;
		} catch (DomainException e) {
			getSessionContext().setRollbackOnly();

			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					methodName, null, e);
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} catch (ServiceException e) {
			getSessionContext().setRollbackOnly();

			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					methodName, null, e);
			throw e;
		} catch (Exception e) {
			getSessionContext().setRollbackOnly();

			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					methodName, null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * canProposalBeCopied This code can be reused for save proposal as well as
	 * add customer use cases
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 20, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param canProposalBeCopied
	 * @return void
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public void canProposalBeCopied(ProposalCustomDTO proposalCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "canProposalBeCopied");

		ProposalContractBOFactory factory = new ProposalContractBOFactory();

		try {
			ProposalContractBO proposalContractBO = factory
					.getProposalContractBO(proposalCustomDTO.getId());

			if (ProposalTypeConstants.EASII.equals(proposalContractBO
					.getProposalType())) {
				if (proposalContractBO.isProposal()) {
					throwServiceException(ErrorCodeConstants.SE0034,
							OPPTMessageCatalog.TYPE_SERVICE);
				} else {
					throwServiceException(ErrorCodeConstants.SE0035,
							OPPTMessageCatalog.TYPE_SERVICE);
				}

			}
			if (ContractTypeConstants.VARIANCE.equals(proposalContractBO
					.getContrType())) {
				throwServiceException(ErrorCodeConstants.SE0301,
						OPPTMessageCatalog.TYPE_SERVICE);
			}
			boolean isClosedStatus = ProposalContractStatusConstants.CLOSED
					.equals(proposalContractBO.getStatusCode());

			boolean isProposal = proposalContractBO.isProposal();
			if (isProposal || (isClosedStatus == false)) {
			} else {
				if (isProposal) {
					throwServiceException(ErrorCodeConstants.SE0302,
							OPPTMessageCatalog.TYPE_SERVICE);
				} else {
					throwServiceException(ErrorCodeConstants.SE0303,
							OPPTMessageCatalog.TYPE_SERVICE);
				}
			}
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}

	/**
	 * addCustomersToProposals This code can be reused for save proposal as well
	 * as add customer use cases
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 20, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param shareProposalCustomDTO
	 * @return void
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	private boolean addCustomersToProposals(CustomerListCustomDTO customerListCustomDTO,int proposalId, ProposalContractBO proposalBO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "addCustomersToProposals");
		 // Set customerListSet = customerListMap.keySet();
		boolean customerAdded = false;
		 // Iterator customerListIterator = customerListSet.iterator();

		InventoryManagerLocal inventoryManagerLocal = null;
		java.util.Date today = new java.util.Date();
		try {
			inventoryManagerLocal = (InventoryManagerLocal) HomeProvider
					.getInventoryManagerLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"addCustomersToProposals", null, e);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}

		/* Start change CR6153 */
		if ((proposalBO.getExtendPeriod() != null)
				&& (proposalBO.getExtendPeriod()
						.equals(UtilityConstants.S_S_EXTEND_PERIOD))) {
			int contractDurationMonths = OPPTCalender
					.calculateContractPeriodDuration(proposalBO
							.getContrStartDate(), proposalBO.getContrEndDate());
			int contractDurationYears = contractDurationMonths / 12;
			if (contractDurationMonths % 12 > 0) {
				/* DADO02 while (customerListIterator.hasNext()) {
					CustomerListCustomerCustomDTO customerListCustomerCustomDTO = (CustomerListCustomerCustomDTO) customerListMap
							.get(customerListIterator.next());*/
					if (customerListCustomDTO.isInventorySelected()
							&& (!customerListCustomDTO
									.isAlreadyExists())) {
						CustomerDomainDTO customerDomainDTO = new CustomerDomainDTO();
						customerDomainDTO.setProposalId(proposalId);
					//	customerDomainDTO.setCustomerListNo(customerListNo); DADO02
						/*customerDomainDTO
								.setCustmerASNo(customerListCustomerCustomDTO
										.getAddressSequenceNumber());*/
						/*DADO02 customerDomainDTO
								.setLegacyCustomerNo(customerListCustomerCustomDTO
										.getLegacyCustomerNumber());*/
						customerDomainDTO
								.setSapCustomerName(customerListCustomDTO
										.getCustomerName());
						customerDomainDTO
								.setSapCustomerNo(customerListCustomDTO
										.getCustomerNumber());
						customerDomainDTO
								.setLastUpdatedDate((new java.sql.Date(today
										.getTime())));
					/*DADO02	customerDomainDTO
								.setCountryCode(customerListCustomerCustomDTO
										.getCountryCode());*/ /*
															 * Changed for
															 * EF0607044559 by
															 * Sara on June
															 * 16,2004
															 */

						if (null != proposalBO) {
							customerDomainDTO.setPlanStartDate(proposalBO
									.getContrStartPeriod());
							customerDomainDTO.setPlanEndDate(proposalBO
									.getContrEndPeriod());
						}
						inventoryManagerLocal
								.addCustomersToProposalSAndSExtended(customerDomainDTO);
						customerAdded = true;

					} // End of if
					for (int i = 0; i < contractDurationYears; i++) {
						if (customerListCustomDTO.isInventorySelected()
								&& (!customerListCustomDTO
										.isAlreadyExists())) {
							CustomerDomainDTO customerDomainDTO = new CustomerDomainDTO();
							customerDomainDTO.setProposalId(proposalId);
							// customerDomainDTO.setCustomerListNo(customerListNo);
							/*customerDomainDTO
									.setCustmerASNo(customerListCustomerCustomDTO
											.getAddressSequenceNumber());
							customerDomainDTO
									.setLegacyCustomerNo(customerListCustomerCustomDTO
											.getLegacyCustomerNumber());*/
							customerDomainDTO
									.setSapCustomerName(customerListCustomDTO
											.getCustomerName());
							customerDomainDTO
									.setSapCustomerNo(customerListCustomDTO
											.getCustomerNumber());
							customerDomainDTO
									.setLastUpdatedDate((new java.sql.Date(
											today.getTime())));
							/*customerDomainDTO
									.setCountryCode(customerListCustomerCustomDTO
											.getCountryCode());*/ /*
																 * Changed for
																 * EF0607044559
																 * by Sara on
																 * June 16,2004
																 */

							if (null != proposalBO) {
								java.util.Date startPeriod1 = OPPTCalender
										.addDate(OPPTCalender.DATE, 1,
												proposalBO.getContrEndPeriod());
								java.util.Date startPeriod = OPPTCalender
										.addDate(OPPTCalender.YEAR, i,
												startPeriod1);
								java.util.Date endPeriod = OPPTCalender
										.addDate(OPPTCalender.YEAR, i + 1,
												proposalBO.getContrEndPeriod());

								customerDomainDTO
										.setPlanStartDate(new java.sql.Date(
												startPeriod.getTime()));
								customerDomainDTO
										.setPlanEndDate(new java.sql.Date(
												endPeriod.getTime()));
							}
							inventoryManagerLocal
									.addCustomersToProposalSAndSExtended(customerDomainDTO);
							customerAdded = true;
						} // End of if
					}//End of for-loop
				//} // end of Iterator
			} else {
				/*DADO02 while (customerListIterator.hasNext()) {
					CustomerListCustomerCustomDTO customerListCustomerCustomDTO = (CustomerListCustomerCustomDTO) customerListMap
							.get(customerListIterator.next());*/
					for (int i = 0; i < contractDurationYears; i++) {
						if (customerListCustomDTO.isInventorySelected()
								&& (!customerListCustomDTO
										.isAlreadyExists())) {
							CustomerDomainDTO customerDomainDTO = new CustomerDomainDTO();
							customerDomainDTO.setProposalId(proposalId);
							// customerDomainDTO.setCustomerListNo(customerListNo);
							/*customerDomainDTO
									.setCustmerASNo(customerListCustomerCustomDTO
											.getAddressSequenceNumber());
							customerDomainDTO
									.setLegacyCustomerNo(customerListCustomerCustomDTO
											.getLegacyCustomerNumber());*/
							customerDomainDTO
									.setSapCustomerName(customerListCustomDTO
											.getCustomerName());
							customerDomainDTO
									.setSapCustomerNo(customerListCustomDTO
											.getCustomerNumber());
							customerDomainDTO
									.setLastUpdatedDate((new java.sql.Date(
											today.getTime())));
							/*customerDomainDTO
									.setCountryCode(customerListCustomerCustomDTO
											.getCountryCode());*/ /*
																 * Changed for
																 * EF0607044559
																 * by Sara on
																 * June 16,2004
																 */

							if (null != proposalBO) {
								java.util.Date startPeriod = OPPTCalender
										.addDate(OPPTCalender.YEAR, i,
												proposalBO
														.getContrStartPeriod());
								java.util.Date endPeriod = OPPTCalender
										.addDate(OPPTCalender.YEAR, i,
												proposalBO.getContrEndPeriod());

								customerDomainDTO
										.setPlanStartDate(new java.sql.Date(
												startPeriod.getTime()));
								customerDomainDTO
										.setPlanEndDate(new java.sql.Date(
												endPeriod.getTime()));
							}
							inventoryManagerLocal
									.addCustomersToProposalSAndSExtended(customerDomainDTO);
							customerAdded = true;
						} // End of if
					}//End of for-loop
				// } // end of Iterator
			}
		} else {
			/* End change CR6153 */
			/*while (customerListIterator.hasNext()) {
				CustomerListCustomerCustomDTO customerListCustomerCustomDTO = (CustomerListCustomerCustomDTO) customerListMap
						.get(customerListIterator.next());
			*/	if (customerListCustomDTO.isInventorySelected()
						&& (!customerListCustomDTO.isAlreadyExists())) {
					CustomerDomainDTO customerDomainDTO = new CustomerDomainDTO();
					customerDomainDTO.setProposalId(proposalId);
					//customerDomainDTO.setCustomerListNo(customerListNo);
					/*customerDomainDTO
							.setCustmerASNo(customerListCustomerCustomDTO
									.getAddressSequenceNumber());
					customerDomainDTO
							.setLegacyCustomerNo(customerListCustomerCustomDTO
									.getLegacyCustomerNumber());*/
					customerDomainDTO
							.setSapCustomerName(customerListCustomDTO
									.getCustomerName());
					customerDomainDTO
							.setSapCustomerNo(customerListCustomDTO
									.getCustomerNumber());

					customerDomainDTO.setLastUpdatedDate((new java.sql.Date(
							today.getTime())));
					/*customerDomainDTO
							.setCountryCode(customerListCustomerCustomDTO
									.getCountryCode());*/ /*
														 * Changed for
														 * EF0607044559 by Sara
														 * on June 16,2004
														 */
					if (null != proposalBO) {
						customerDomainDTO.setPlanStartDate(proposalBO
								.getContrStartPeriod());
						customerDomainDTO.setPlanEndDate(proposalBO
								.getContrEndPeriod());
						/*//DADO02&DADO09 BlueHarmony Sateesh
						customerDomainDTO.setBillToPartyNo(proposalBO.getRegBillToPartyNo());
						customerDomainDTO.setBillToPartyName(proposalBO.getRegBillToPartyName());
						customerDomainDTO.setBillToPartyASNo(proposalBO.getRegBillToPartASNo());
						customerDomainDTO.setBillToPartyLNo(proposalBO.getRegBillToPartyLegNo());
						customerDomainDTO.setPayerNo(proposalBO.getRegPayerNo());
						customerDomainDTO.setPayerName(proposalBO.getRegPayerName());
						customerDomainDTO.setPayerASNo(proposalBO.getRegPayerASNo());
						customerDomainDTO.setPayerLNo(proposalBO.getRegPayerLegNo());
						customerDomainDTO.setShipToPartyNo(proposalBO.getRegShipToPartyNo());
						customerDomainDTO.setShipToPartyName(proposalBO.getRegShipToPartyName());
						customerDomainDTO.setShipToPartyASNo(proposalBO.getRegShipToPartyASNo());
						customerDomainDTO.setShipToPartyLNo(proposalBO.getRegShipToPartyLegNo());
						//END OF DADO02&DADO09
*/
					}
					inventoryManagerLocal
							.addCustomersToProposal(customerDomainDTO);
					customerAdded = true;
				} // End of if
		//} // end of Iterator
			/* Start change CR6153 */
		}
		/* End change CR6153 */
		log.end();
		return customerAdded;

	} // end of method

	/**
	 *
	 * This method initiate Copy Bump Action for the selected DM
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 13, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copyBumpDMCustomDTO
	 * @return CopyBumpDMCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CopyBumpDMCustomDTO copyBumpInventory(
			CopyBumpDMCustomDTO copyBumpDMCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "copyBumpInventory-DM");

		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalContractBO proposalContractBO = null;
		DMDomainDTO dmDomainDTO = null;
		ProposalCustomDTO proposalCustomDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		DMCustomDTO dmCustomDTO = null;

		if (copyBumpDMCustomDTO.getDmDTO() != null
				&& copyBumpDMCustomDTO.getDmDTO().isSAndS()) {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0015);
		}

		proposalContractBOFactory = new ProposalContractBOFactory();
		proposalCustomDTO = copyBumpDMCustomDTO.getProposalDTO();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalCustomDTO.getId());
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}

		HashMap map = new HashMap();
		map.put(UtilityConstants.BO_USERID, copyBumpDMCustomDTO.getUserId());
		try {
			map.put(UtilityConstants.BO_GROUPNAME, copyBumpDMCustomDTO
					.getGroupName());
			SharingBO sharingBO = getSharingBOFromFactory(proposalContractBO
					.getProposalId(), copyBumpDMCustomDTO.getUserId());
			if (null != sharingBO) {
				map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}
			map.put(ActionNameConstants.COPY_BUMP_DM,
					ActionNameConstants.COPY_BUMP_DM);
			proposalContractBO.validateBumpInventory(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}

		dmDomainDTO = new DMDomainDTO();
		dmDomainDTO.setProposalId(copyBumpDMCustomDTO.getDmDTO()
				.getProposalId());
		dmDomainDTO.setCustomerId(Integer.parseInt(copyBumpDMCustomDTO
				.getDmDTO().getCustomerId()));
		dmDomainDTO.setDmId(Integer.parseInt(copyBumpDMCustomDTO.getDmDTO()
				.getId()));

		inventoryManagerLocal = getInventoryManagerLocal();
		dmDomainDTO = inventoryManagerLocal.retrieveDMInfo(dmDomainDTO);

		dmCustomDTO = copyBumpDMCustomDTO.getDmDTO();
		dmCustomDTO.setNumber(dmDomainDTO.getDmNo());
		dmCustomDTO.setDescription(dmDomainDTO.getDmDesc());
		dmCustomDTO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
		dmCustomDTO.setPlanEndDate(dmDomainDTO.getPlanEndDate());

		copyBumpDMCustomDTO.setStartYears(OPPTCalender.getStartYearList());
		copyBumpDMCustomDTO.setEndYears(OPPTCalender.getEndYearList());
		timeTaken.end();
		return copyBumpDMCustomDTO;
	}

	/**
	 *
	 * This method saves the Copy Bump action for the selected DM
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 13, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copyBumpDMCustomDTO
	 * @return CopyBumpDMCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CopyBumpDMCustomDTO saveCopyBumpDM(
			CopyBumpDMCustomDTO copyBumpDMCustomDTO) throws ServiceException {

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "saveCopyBumpDM-DM");

		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalContractBO proposalContractBO = null;
		DMDomainDTO dmDomainDTO = null;
		ProposalCustomDTO proposalCustomDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		HashMap map = new HashMap();
		java.util.Date planEndDate = copyBumpDMCustomDTO.getDmDTO()
				.getPlanEndDate();
		java.util.Date planStartDate = copyBumpDMCustomDTO.getDmDTO()
				.getPlanStartDate();
		java.util.Date editedDate = copyBumpDMCustomDTO
				.getOriginalPlanEndDate();
		java.util.Date bumpStartDate = copyBumpDMCustomDTO
				.getBumpPlanStartDate();
		OPPTCalender calender = new OPPTCalender();

		proposalContractBOFactory = new ProposalContractBOFactory();
		proposalCustomDTO = copyBumpDMCustomDTO.getProposalDTO();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalCustomDTO.getId());
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}
		if (calender.isDateGreater(editedDate, planStartDate)
				&& (calender.isDateEqual(planEndDate, editedDate) || calender
						.isDateEqual(OPPTCalender
								.getDayMinusOneSqlDate(bumpStartDate),
								editedDate))) {
			dmDomainDTO = new DMDomainDTO();
			map
					.put(UtilityConstants.STATUS, proposalContractBO
							.getStatusCode());
			dmDomainDTO.setValues(map);
			dmDomainDTO.setProposalId(copyBumpDMCustomDTO.getDmDTO()
					.getProposalId());
			dmDomainDTO.setCustomerId(Integer.parseInt(copyBumpDMCustomDTO
					.getDmDTO().getCustomerId()));
			dmDomainDTO.setDmId(Integer.parseInt(copyBumpDMCustomDTO.getDmDTO()
					.getId()));
			dmDomainDTO.setPlanStartDate(new Date(copyBumpDMCustomDTO
					.getBumpPlanStartDate().getTime()));
			dmDomainDTO.setPlanEndDate(new Date(copyBumpDMCustomDTO
					.getBumpPlanEndDate().getTime()));
			dmDomainDTO.setActionName(ActionNameConstants.COPY_BUMP_DM);

			inventoryManagerLocal = getInventoryManagerLocal();
			try {
				inventoryManagerLocal.storeBumpInfo(dmDomainDTO);
			} catch (ServiceException se) {
				getSessionContext().setRollbackOnly();
				throw se;
			}
			boolean isProposal = proposalContractBO.isProposal();
			if (isProposal) {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT);
				proposalContractBO.setInvoiceAmount(0.0);
			} else {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				//proposalContractBO.setAmendEffectiveDate(new Date(new
				// java.util.Date().getTime()));
				proposalContractBO.setInvoiceAmount(0.0);
			}

			try {
				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);
			} catch (DomainException d) {
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());
			}
		} else {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0131);
		}
		timeTaken.end();
		return copyBumpDMCustomDTO;
	}

	/**
	 *
	 * This method initiate Copy Bump Action for the selected SWO
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 13, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copyBumpSWOCustomDTO
	 * @return CopyBumpSWOCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CopyBumpSWOCustomDTO copyBumpInventory(
			CopyBumpSWOCustomDTO copyBumpSWOCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "copyBumpInventory-SWO");
//System.out.println("ProposalManagerBean.copyBumpInventory()");
		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalContractBO proposalContractBO = null;
		SWODomainDTO swoDomainDTO = null;
		ProposalCustomDTO proposalCustomDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		SWOCustomDTO swoCustomDTO = null;

		if (copyBumpSWOCustomDTO.getSwoDTO() != null
				&& copyBumpSWOCustomDTO.getSwoDTO().isSAndS()) {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0015);
		}

		proposalContractBOFactory = new ProposalContractBOFactory();
		proposalCustomDTO = copyBumpSWOCustomDTO.getProposalDTO();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalCustomDTO.getId());
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}

		HashMap map = new HashMap();
		map.put(UtilityConstants.BO_USERID, copyBumpSWOCustomDTO.getUserId());
		try {
			map.put(UtilityConstants.BO_GROUPNAME, copyBumpSWOCustomDTO
					.getGroupName());
			SharingBO sharingBO = getSharingBOFromFactory(proposalContractBO
					.getProposalId(), copyBumpSWOCustomDTO.getUserId());
			if (null != sharingBO) {
				map.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}
			map.put(ActionNameConstants.COPY_BUMP_SWO,
					ActionNameConstants.COPY_BUMP_SWO);
			proposalContractBO.validateBumpInventory(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		swoDomainDTO = DomainDTOBuildHelper
				.buildSWODomainDTOFromCustomWithOnlyID(copyBumpSWOCustomDTO
						.getSwoDTO(), copyBumpSWOCustomDTO.getTransactionName());
		swoDomainDTO.setActionName(ActionNameConstants.COPY_BUMP_SWO);
		inventoryManagerLocal = getInventoryManagerLocal();
		SWODomainDTO[] licenses = new SWODomainDTO[1];
		licenses[0] = swoDomainDTO;
		licenses = inventoryManagerLocal.retrieveSWODetails(licenses);

		swoCustomDTO = copyBumpSWOCustomDTO.getSwoDTO();
		if (licenses[0].getItemCategory() != null
				&& licenses[0].getItemCategory().equals(
						LicenseConstants.SVC_LICENSE_FLAG)) {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0125);
		}
		swoCustomDTO.setSerialNumber(licenses[0].getSerialNo());
		swoCustomDTO.setNumber(licenses[0].getSwoNo());
		swoCustomDTO.setDescription(licenses[0].getSwoDesc());
		swoCustomDTO.setPlanStartDate(licenses[0].getPlanStartDate());
		swoCustomDTO.setPlanEndDate(licenses[0].getPlanEndDate());
		swoCustomDTO.setAlternatePrice(licenses[0].getAlternatePrice());
		copyBumpSWOCustomDTO.setStartYears(OPPTCalender.getStartYearList());
		copyBumpSWOCustomDTO.setEndYears(OPPTCalender.getEndYearList());

		timeTaken.end();
		return copyBumpSWOCustomDTO;
	}

	/**
	 *
	 * This method saves the Copy Bump action for the selected swo
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 13, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param copyBumpSWOCustomDTO
	 * @return CopyBumpSWOCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CopyBumpSWOCustomDTO saveCopyBumpSWO(
			CopyBumpSWOCustomDTO copyBumpSWOCustomDTO) throws ServiceException {

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "saveCopyBumpSWO");
//System.out.println("ProposalManagerBean.saveCopyBumpSWO()");
		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalContractBO proposalContractBO = null;
		SWODomainDTO swoDomainDTO = null;
		List swoDomainDTOList = null;
		DMDomainDTO dmDomainDTO = null;
		ProposalCustomDTO proposalCustomDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		java.util.Date planEndDate = copyBumpSWOCustomDTO.getSwoDTO()
				.getPlanEndDate();
		java.util.Date planStartDate = copyBumpSWOCustomDTO.getSwoDTO()
				.getPlanStartDate();
		java.util.Date editedDate = copyBumpSWOCustomDTO
				.getOriginalPlanEndDate();
		java.util.Date bumpStartDate = copyBumpSWOCustomDTO
				.getBumpPlanStartDate();
		OPPTCalender calender = new OPPTCalender();

		proposalContractBOFactory = new ProposalContractBOFactory();
		proposalCustomDTO = copyBumpSWOCustomDTO.getProposalDTO();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(proposalCustomDTO.getId());
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}
		if (calender.isDateGreater(editedDate, planStartDate)
				&& (calender.isDateEqual(planEndDate, editedDate) || calender
						.isDateEqual(OPPTCalender
								.getDayMinusOneSqlDate(bumpStartDate),
								editedDate))) {
			HashMap values = new HashMap();
			values.put(UtilityConstants.SWO_ALTERNATE_PRICE, String
					.valueOf(copyBumpSWOCustomDTO.getSwoDTO()
							.getAlternatePrice()));

			swoDomainDTO = DomainDTOBuildHelper
					.buildSWODomainDTOFromCustomWithOnlyID(copyBumpSWOCustomDTO
							.getSwoDTO(), copyBumpSWOCustomDTO
							.getTransactionName());
			swoDomainDTO.setAlternatePrice(copyBumpSWOCustomDTO
					.getAlternatePrice());
			swoDomainDTO.setPlanStartDate(new Date(copyBumpSWOCustomDTO
					.getBumpPlanStartDate().getTime()));
			swoDomainDTO.setPlanEndDate(new Date(copyBumpSWOCustomDTO
					.getBumpPlanEndDate().getTime()));
			swoDomainDTO.setActionName(ActionNameConstants.COPY_BUMP_SWO);
			swoDomainDTO.setValues(values);

			swoDomainDTOList = new ArrayList();
			swoDomainDTOList.add(swoDomainDTO);
			dmDomainDTO = new DMDomainDTO();
			dmDomainDTO.setSwoDTOList(swoDomainDTOList);

			inventoryManagerLocal = getInventoryManagerLocal();
			try {
				inventoryManagerLocal.storeBumpInfo(dmDomainDTO);
			} catch (ServiceException se) {
				getSessionContext().setRollbackOnly();
				throw se;
			}
			boolean isProposal = proposalContractBO.isProposal();

			if (isProposal) {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT);
				proposalContractBO.setInvoiceAmount(0.0);
			} else {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				//proposalContractBO.setAmendEffectiveDate(new Date(new
				// java.util.Date().getTime()));
				proposalContractBO.setInvoiceAmount(0.0);
			}

			try {
				proposalContractBOFactory
						.updateProposalContractBO(proposalContractBO);
			} catch (DomainException d) {
				throw ExceptionGenerator.generateServiceException(d
						.getErrorReport());
			}
		} else {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0132);
		}
		timeTaken.end();
		return copyBumpSWOCustomDTO;
	}

	/*
	 * This method list the proposals for the report selection
	 *
	 * <br> <b>Known Bugs </b> <br>
	 *
	 * <br><PRE> date Jan 8, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param reportsCustomDTO @return ReportsCustomDTO
	 *
	 * 31/05/2004 Sara Added as part of EF0527044945 - CMVCDEFECT 353 for
	 * displaying proposal name in all cases. Previously only when report name
	 * is not null, then proposal name is displayed else it was Report name.
	 * This is not correct.
	 */
	public ReportsDomainDTO listProposalsForReport(String userId,
			String groupName, int role) throws ServiceException {
		UserManagerLocalHome userManagerLocalHome = (UserManagerLocalHome) ServiceLocator
				.getEJBHomeFactory().getLocalHome("UserManagerLocalHome");
		UserManagerLocal userManagerLocal = null;
		String[] users;
		List userProfiles = new ArrayList();
		ReportsDomainDTO reportsDomainDTO = new ReportsDomainDTO();
		if (groupName != null) {
			UserGroupProfileDomainDTO userGroupProfileDomainDTO = new UserGroupProfileDomainDTO();
			try {
				userManagerLocal = userManagerLocalHome.create();
			} catch (CreateException ex) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						"listProposalsForReport", null, ex);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);

			}
			// Changed by Thirumalai kumar Starts here , we included userid arg
			// for UD -- Starts
			userGroupProfileDomainDTO = userManagerLocal.getUsersFromSameGrp(
					userId, groupName, role);
			// Changed by Thirumalai kumar ends
			userProfiles = userGroupProfileDomainDTO
					.getUserGroupProfileDomainDTOList();

			if (userProfiles.size() > 0) {
				users = new String[userProfiles.size()];
			} else {
				users = new String[1];
			}

			UserProfileBO userprofileBO;
			for (int i = 0; i < userProfiles.size(); i++) {
				UserProfileBO userProfileBO = (UserProfileBO) userProfiles
						.get(i);
				users[i] = userProfileBO.getUserId();
			}
		} else {
			users = new String[1];
			users[0] = userId;
		}

		// For getting proposals/Contract based on role
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		List proposalContractList = new ArrayList();
		List proposalContract = new ArrayList();
		ProposalContractBO proposalContractBO;

		if (role == RoleConstants.PROPOSAL_APPROVER) {

			if (OPPTHelper.trimStringToNull(groupName) == null) {
				try {
					proposalContract = proposalContractBOFactory
							.findProposalContractWaitingForApproval(userId);
				} catch (DomainException ex) {
					throw ExceptionGenerator.generateServiceException(ex
							.getErrorReport());
				}
				proposalContractList.addAll(proposalContract);
			} else {
				for (int i = 0; i < userProfiles.size(); i++) {
					UserProfileBO profile = (UserProfileBO) userProfiles.get(i);
					if (RoleConstants.CREATE_APPROVE == profile.getRole()) {
						continue;
					}
					try {
						proposalContract = proposalContractBOFactory
								.findProposalContractWaitingForApproval(profile
										.getUserId());
					} catch (DomainException ex) {
						throw ExceptionGenerator.generateServiceException(ex
								.getErrorReport());
					}
					proposalContractList.addAll(proposalContract);
				}
			}
		}

		if (role == RoleConstants.BHD ||role == RoleConstants.OPPT_READ ) {
			for (int j = 0; j < users.length; j++) {
				try {
					proposalContract = proposalContractBOFactory
							.findProposalsContractsBOForUsers(users[j]);
				} catch (DomainException ex) {
					throw ExceptionGenerator.generateServiceException(ex
							.getErrorReport());
				}
				proposalContractList.addAll(proposalContract);
			}

			/* Sharing Issue MN21108823 Fix by Balaji starts */
			// logic for getting the shared proposals
			SharingBOFactory sharingBOFactory = new SharingBOFactory();
			List sharingBOList = new ArrayList();
			try {
				sharingBOList = sharingBOFactory.findSharingBOForUsers(userId);
			} catch (DomainException e1) {
				throw ExceptionGenerator.generateServiceException(e1
						.getErrorReport());
			}
			for (int i = 0, size = sharingBOList.size(); i < size; i++) {
				SharingBO sharingBO = (SharingBO) sharingBOList.get(i);
				int sharedProposalId = sharingBO.getProposalId();
				ProposalContractBO sharedProposalBO = null;
				try {
					sharedProposalBO = proposalContractBOFactory
							.getProposalContractBO(sharedProposalId);
					proposalContractList.add(sharedProposalBO);
				} catch (DomainException de) {
					throw ExceptionGenerator.generateServiceException(de
							.getErrorReport());
				}
			}
			/* Sharing Issue MN21108823 Fix by Balaji ends */
		}

		if (role == RoleConstants.CREATE_APPROVE) {
			List proposalsForCreateApprover = new ArrayList();
			for (int j = 0; j < users.length; j++) {
				try {
					proposalContract = proposalContractBOFactory
							.findProposalsContractsBOForUsers(users[j]);
				} catch (DomainException ex) {
					throw ExceptionGenerator.generateServiceException(ex
							.getErrorReport());
				}
				proposalContractList.addAll(proposalContract);
			}
			proposalsForCreateApprover.add(proposalContractList);
			for (int j = 0; j < users.length; j++) {
				try {
					proposalContract = proposalContractBOFactory
							.findProposalContractWaitingForApproval(users[j]);
				} catch (DomainException ex) {
					throw ExceptionGenerator.generateServiceException(ex
							.getErrorReport());
				}
				if (proposalContract != null) {
					for (int i = 0; i < proposalContract.size(); i++) {
						ProposalContractBO proposalForReport = (ProposalContractBO) proposalContract
								.get(i);
						if (proposalForReport.getApprovedBy() != null
								&& proposalForReport.getApprovedBy().trim()
										.equals(userId)) {
							proposalContractList.add(proposalForReport);
						}
					}
				}
			}
			proposalsForCreateApprover.addAll(proposalContractList);

		}

		if (role == RoleConstants.MARKETING_REP
				|| role == RoleConstants.BUSINESS_PARTNER
				|| role == RoleConstants.CSO) {
			for (int j = 0; j < users.length; j++) {
				try {
					proposalContract = proposalContractBOFactory
							.findProposalsContractsBOForUsers(users[j]);
				} catch (DomainException ex) {
					throw ExceptionGenerator.generateServiceException(ex
							.getErrorReport());
				}
				proposalContractList.addAll(proposalContract);
			}
		}

		TreeMap proposalsMap = new TreeMap();
		Iterator iter = proposalContractList.iterator();
		ProposalCustomDTO proposalCustomDTO;
		while (iter.hasNext()) {
			ProposalContractBO proposalBO = (ProposalContractBO) iter.next();
			if (proposalBO.validateForReport()) {
				proposalCustomDTO = new ProposalCustomDTO();
				if (ContractTypeConstants.VARIANCE.equals(proposalBO
						.getContrType())
						|| ProposalContractStatusConstants.AMEND_PROPOSAL_TO_REVERT
								.equals(proposalBO.getStatusCode())) {
					continue;
				}

				proposalCustomDTO.setId(proposalBO.getProposalId());
				/*
				 * if (proposalBO.getReportName() != null &&
				 * proposalBO.getReportName().trim().length() > 0) {
				 * proposalCustomDTO.setName(proposalBO.getReportName()); } else {
				 */
				proposalCustomDTO.setName(proposalBO.getProposalName());
				//}
				proposalCustomDTO.setType(proposalBO.getProposalType());
				proposalCustomDTO.setStatus(proposalBO.getStatusCode());
				proposalsMap.put(String.valueOf(proposalCustomDTO.getId()),
						proposalCustomDTO);
			}
		}
		reportsDomainDTO.setProposalCustomDTO(proposalsMap);

		return reportsDomainDTO;
	}

	/**
	 * removeShare This method retrieves the DM and SWO information during
	 * ConfigureDM Process
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 20, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param shareProposalCustomDTO
	 * @return void
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public ShareProposalCustomDTO removeShare(
			ShareProposalCustomDTO shareProposalCustomDTO)
			throws ServiceException {

		TimeTaken log = new TimeTaken(CLASS_NAME, "removeShare");

		int proposalId = shareProposalCustomDTO.getProposalDTO().getId();
		int role = shareProposalCustomDTO.getRole();
		String loggedUser = shareProposalCustomDTO.getUserId().trim();
		String groupName = shareProposalCustomDTO.getGroupName();
		if (null != groupName) {
			groupName = groupName.trim();
		}

		HashMap compareValue = new HashMap();
		SharingBOFactory sharingBOFactory = new SharingBOFactory();
		List sharingBOList = null;
		boolean result1 = false;
		boolean sameGrp = false;
		ProposalBO proposalBO = null;
		UserManagerLocal userManagerLocal = null;
		SharingBO sharingBO = null;
		boolean removeSharing = false;

		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		try {
			proposalBO = (ProposalBO) proposalContractBOFactory
					.getProposalContractBO(proposalId);
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex
					.getErrorReport());
		}

		try {
			userManagerLocal = HomeProvider.getUserManagerLocal();
			sameGrp = userManagerLocal.isUserFromSameGroup(loggedUser,
					proposalBO.getCreatedBy());
		} catch (CreateException ex) {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}

		if (ActionNameConstants.REMOVE_PROPOSAL_SHARING
				.equals(shareProposalCustomDTO.getTransactionName())) {

			OPPTLogger.debug("Action name is REMOVE_PROPOSAL_SHARING",
					CLASS_NAME, "removeShare");
			OPPTLogger.debug("Logged in user is #" + loggedUser + "#",
					CLASS_NAME, "removeShare");
			OPPTLogger.debug("Group name is #" + groupName + "#", CLASS_NAME,
					"removeShare");

			sharingBOList = sharingBOFactory
					.findSharingBOByProposalId(proposalId);

			if (sharingBOList == null || sharingBOList.size() == 0) {
				OPPTLogger.debug("Proposal is not shared", CLASS_NAME,
						"removeShare");
				// The proposal is not shared so no point in proceeding.
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0003);
			}

			if (sharingBOList.size() > 0) {
				// check if Proposal is shared FULL
				Iterator iter = sharingBOList.iterator();

				while (iter.hasNext()) {
					sharingBO = (SharingBO) iter.next();
					OPPTLogger.debug("Proposal shared to UserId #"
							+ sharingBO.getAccessTo().trim() + "#", CLASS_NAME,
							"removeShare");
					if (UtilityConstants.SHARED_FULL_MODE.equals(sharingBO
							.getAccessType())) {
						OPPTLogger.debug("Proposal shared in FULL mode",
								CLASS_NAME, "removeShare");

						compareValue = populateCompareValuesForUserAuthInProposalBO(
								shareProposalCustomDTO, sharingBO);
						compareValue.put(UtilityConstants.BO_SHARING_ID,
								sharingBO.getAccessTo().trim());

						//chk if proposal shared full to logged user or someone
						// in the same grp as of Logged user
						result1 = userManagerLocal
								.validateForSharing(compareValue);
						OPPTLogger.debug("Validate For sharing checking is "
								+ result1, CLASS_NAME, "removeShare");

						if (result1 && null != groupName
								&& null == proposalBO.getLockedBy()) {
							removeSharing = true;
						} else {
							if (result1 && null == groupName) {
								removeSharing = true;
							}
						}

						try {
							if (removeSharing) {

								OPPTLogger.debug(
										"Removing FULL Sharing Access",
										CLASS_NAME, "removeShare");
								// remove Full sharing access for the user
								sharingBOFactory.deleteSharingBO(proposalId,
										sharingBO.getAccessTo());

								if (1 == sharingBOList.size()) {
									proposalBO.setProposalSharing(null);
									proposalContractBOFactory
											.updateProposalContractBO(proposalBO);
								} else {
									proposalBO
											.setProposalSharing(UtilityConstants.SHARED_READ_MODE);
									proposalContractBOFactory
											.updateProposalContractBO(proposalBO);
								}
								shareProposalCustomDTO
										.setAccessProvidedByAnotherUser(UtilityConstants.TRUE);
							} else {
								// Proposal is sharing FULL but logged user
								// doesnt have the access to remove it.
								if (!result1
										&& RoleConstants.BHD == shareProposalCustomDTO
												.getRole()||(!result1 && RoleConstants.OPPT_READ == shareProposalCustomDTO.getRole())) {
									throw ExceptionGenerator
											.generateServiceException(ErrorCodeConstants.SE0404);
								}
								if (!result1 && 1 == sharingBOList.size()) {
									throw ExceptionGenerator
											.generateServiceException(ErrorCodeConstants.SE0404);
								}
							}
						} catch (DomainException ex) {
							throw ExceptionGenerator
									.generateServiceException(ex
											.getErrorReport());
						}
					}

					if (UtilityConstants.SHARED_READ_MODE.equals(sharingBO
							.getAccessType())) {
						if (sameGrp
								&& RoleConstants.BHD != shareProposalCustomDTO
										.getRole()|| (sameGrp && RoleConstants.OPPT_READ == shareProposalCustomDTO.getRole())) {

							shareProposalCustomDTO.addUser(sharingBO
									.getAccessTo(), null);
						} else if (RoleConstants.BHD == shareProposalCustomDTO
								.getRole()||( RoleConstants.OPPT_READ == shareProposalCustomDTO.getRole())) {

							// Proposal shared in READ and BHD user tries to
							// remove it
							throw ExceptionGenerator
									.generateServiceException(ErrorCodeConstants.SE0404);
						} else if (null == shareProposalCustomDTO
								.getGroupName()) {
							shareProposalCustomDTO.addUser(sharingBO
									.getAccessTo(), null);
						}
					}
				}
			}
		} else {
			if (ActionNameConstants.SUBMIT_REMOVE_PROPOSAL_SHARING
					.equals(shareProposalCustomDTO.getTransactionName())) {
				// get the list of UserIds to remove the share
				removeShare(proposalId, shareProposalCustomDTO.getUsers());
			}
		}
		log.end();

		return shareProposalCustomDTO;
	}

	/**
	 * removeShare This method retrieves the DM and SWO information during
	 * ConfigureDM Process
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 20, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalID
	 * @param map
	 * @return void
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	private void removeShare(int proposalID, Map map) throws ServiceException {
		if (null != map) {
			Iterator iter = map.keySet().iterator();

			try {
				ProposalContractBOFactory factory = new ProposalContractBOFactory();
				SharingBOFactory sharingBOFactory = new SharingBOFactory();
				SharingBO sharingBO;

				ProposalContractBO proposalBO = factory
						.getProposalContractBO(proposalID);
				String user;

				while (iter.hasNext()) {
					user = OPPTHelper.trimString((String) iter.next());
					sharingBOFactory.deleteSharingBO(proposalID, user);
				}

				List sharingBOList = sharingBOFactory
						.findSharingBOByProposalId(proposalID);
				if (null == sharingBOList || 0 == sharingBOList.size()) {
					proposalBO.setProposalSharing(null);
					factory.updateProposalContractBO(proposalBO);
				}
			} catch (DomainException ex) {
				throw ExceptionGenerator.generateServiceException(ex
						.getErrorReport());
			}
		}
	}

	/**
	 *
	 * This method retrieves the DM and SWO information during ConfigureDM
	 * Process
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 20, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param configureDMCustomDTO
	 * @return ConfigureDMCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public ConfigureDMCustomDTO retrieveDM(
			ConfigureDMCustomDTO configureDMCustomDTO) throws ServiceException {

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "retrieveDM");

		ProposalCustomDTO proposalDTO = null;
		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalContractBO proposalContractBO = null;
		DMDomainDTO dmDomainDTO = null;
		DMCustomDTO dmCustomDTO = null;
		SWODomainDTO swoDomainDTO = null;
		EEDomainDTO eeDomainDTO = null;
		List swoCustomList = null;
		List eeCustomList = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		ConfigureDMSWOCustomDTO configureDMSWOCustomDTO = null;
		ConfigureDMEECustomDTO configureDMEECustomDTO = null;
		HashMap values = null;

		proposalContractBOFactory = new ProposalContractBOFactory();
		swoCustomList = new ArrayList();
		if (configureDMCustomDTO.isSAndS()) {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0015);
		}

		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(configureDMCustomDTO.getProposalId());
			values = new HashMap();
			values.put(UtilityConstants.BO_USERID, configureDMCustomDTO
					.getUserId());
			values.put(UtilityConstants.BO_GROUPNAME, configureDMCustomDTO
					.getGroupName());
			SharingBO sharingBO = getSharingBOFromFactory(proposalContractBO
					.getProposalId(), configureDMCustomDTO.getUserId());
			if (null != sharingBO) {
				values.put(UtilityConstants.CREATOR_FULL_MODE, sharingBO
						.getAccessType());
			}
			proposalContractBO.validateConfigureDMProcess(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, values);
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		dmDomainDTO = new DMDomainDTO();
		dmDomainDTO.setDmId(Integer.parseInt(configureDMCustomDTO.getId()));
		dmDomainDTO.setCustomerId(Integer.parseInt(configureDMCustomDTO
				.getCustomerId()));
		dmDomainDTO.setProposalId(configureDMCustomDTO.getProposalId());
		dmDomainDTO.setActionName(ActionNameConstants.CONFIGURE_DM);

		inventoryManagerLocal = getInventoryManagerLocal();
		dmDomainDTO = inventoryManagerLocal
				.retrieveDMAndLicenseInfo(dmDomainDTO);

		if (dmDomainDTO.getSWODTOList() != null
				&& dmDomainDTO.getSWODTOList().size() > 0) {
			for (int i = 0; i < dmDomainDTO.getSWODTOList().size(); i++) {
				swoDomainDTO = (SWODomainDTO) dmDomainDTO.getSWODTOList()
						.get(i);
				if (UtilityConstants.SANDS_IND.equals(swoDomainDTO
						.getSAndSInd())) {
					// we do not consider s and s licenses for configure dm
					continue;
				}
				configureDMSWOCustomDTO = new ConfigureDMSWOCustomDTO();
				eeCustomList = new ArrayList();

				for (int j = 0; j < swoDomainDTO.getEEDTOList().size(); j++) {
					eeDomainDTO = (EEDomainDTO) swoDomainDTO.getEEDTOList()
							.get(j);
					configureDMEECustomDTO = new ConfigureDMEECustomDTO();

					configureDMEECustomDTO.setSalesDocNumber(eeDomainDTO
							.getSalesDocNo());
					configureDMEECustomDTO.setChargeOption(eeDomainDTO
							.getChargeOptionDesc());
					configureDMEECustomDTO.setUseLevel(eeDomainDTO
							.getUseLevel());
					configureDMEECustomDTO.setLicenseType(eeDomainDTO
							.getLicenseType());
					configureDMEECustomDTO.setEeItemNumber(eeDomainDTO
							.getEeItemNo());
					configureDMEECustomDTO.setEeNumber(eeDomainDTO.getEeNo());
					configureDMEECustomDTO
							.setValueMetricDescription(eeDomainDTO
									.getValueMetric());
					configureDMEECustomDTO.setId(String.valueOf(eeDomainDTO
							.getEeId()));

					eeCustomList.add(configureDMEECustomDTO);

				}

				configureDMSWOCustomDTO.setId(String.valueOf(swoDomainDTO
						.getSwoId()));
				configureDMSWOCustomDTO.setSwoSerialNumber(swoDomainDTO
						.getSerialNo());
				configureDMSWOCustomDTO.setSwoNumber(swoDomainDTO.getSwoNo());
				configureDMSWOCustomDTO.setSwoItemNumber(swoDomainDTO
						.getSwoItemNo());
				configureDMSWOCustomDTO.setSwoDescription(swoDomainDTO
						.getSwoDesc());
				configureDMSWOCustomDTO.setEes(eeCustomList);

				swoCustomList.add(configureDMSWOCustomDTO);

			}
		}

		//set the values in configure dm custom dtos
		configureDMCustomDTO.setId(String.valueOf(dmDomainDTO.getDmId()));
		configureDMCustomDTO.setCustomerId(String.valueOf(dmDomainDTO
				.getCustomerId()));
		configureDMCustomDTO.setProposalId(dmDomainDTO.getProposalId());
		configureDMCustomDTO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
		configureDMCustomDTO.setPlanEndDate(dmDomainDTO.getPlanEndDate());
		configureDMCustomDTO.setNumber(dmDomainDTO.getDmNo());
		configureDMCustomDTO.setDescription(dmDomainDTO.getDmDesc());
		configureDMCustomDTO.setSwos(swoCustomList);
		configureDMCustomDTO.setStartYears(OPPTCalender.getStartYearList());
		configureDMCustomDTO.setEndYears(OPPTCalender.getEndYearList());

		timeTaken.end();
		return configureDMCustomDTO;
	}

	/**
	 *
	 * This method retrieves the EE configuration information from the back end
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 20, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param configureDMCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public ConfigureDMCustomDTO retrieveEEConfigWhenConfigureDM(
			ConfigureDMCustomDTO configureDMCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME,
				"retrieveEEConfigWhenConfigureDM");

		int proposalId = 0;
		ConfigureDMSWOCustomDTO configureDMSWOCustomDTO = null;
		List configureDMSWOCustomDTOList = null;
		ConfigureDMEECustomDTO configureDMEECustomDTO = null;
		ConfigureDMEECustomDTO tempConfigureDMEECustomDTO = null;
		RetrieveInvenConfigInputConnectorDTO retrieveInvenConfigInputConnectorDTO = null;
		RetrieveInvenConfigOutputConnectorDTO retrieveInvenConfigOutputConnectorDTO = null;
		JMSConnectorLocal jmsConnectorLocal = null;
		String methodName = "Retrieve EE Config When Config DM";
		List vmConnectorDTOList = null;
		ValueMetricConnectorDTO valueMetricConnectorDTO = null;
		LicenseConnectorDTO licenseConnectorDTO = null;
		ChargeOptionConnectorDTO chargeOptionConnectorDTO = null;
		UseLevelConnectorDTO useLevelConnectorDTO = null;
		List lcConnectorDTOList = null;
		List choConnectorDTOList = null;
		List ulConnectorDTOList = null;
		TempEEDomainDTO tempEEDomainDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;

		proposalId = configureDMCustomDTO.getProposalId();
		configureDMSWOCustomDTOList = configureDMCustomDTO.getSwos();
		Map vmMap = null;
		Map choMap = null;
		Map lcMap = null;
		Map ulMap = null;
		vmMap = new HashMap();
		choMap = new HashMap();
		lcMap = new HashMap();
		ulMap = new HashMap();

		boolean isCopied = false;
		tempConfigureDMEECustomDTO = validateDeFaultedEE(
				configureDMSWOCustomDTOList, isCopied, null, null, null, null,
				vmMap, lcMap, choMap, ulMap);

		if (tempConfigureDMEECustomDTO != null) {
			OPPTLogger.debug("SWO Item No"
					+ tempConfigureDMEECustomDTO.getSwoItemNo(), CLASS_NAME,
					methodName);
			retrieveInvenConfigInputConnectorDTO = InputConnectorDTOBuildHelper
					.buildRetrieveInvenConfigInputConnectorDTO(
							configureDMCustomDTO, tempConfigureDMEECustomDTO
									.getSwoItemNo(), tempConfigureDMEECustomDTO);

		}
		try {
			if (retrieveInvenConfigInputConnectorDTO != null) {
				jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
				retrieveInvenConfigOutputConnectorDTO = (RetrieveInvenConfigOutputConnectorDTO) jmsConnectorLocal
						.sendReceive(retrieveInvenConfigInputConnectorDTO);
			}
		} catch (Exception e) {
			throwServiceException(ErrorCodeConstants.SE0801,
					OPPTMessageCatalog.TYPE_SERVICE);
		}

		if (retrieveInvenConfigOutputConnectorDTO != null
				&& ConnectorConstants.RFC_SUCCESS_CODE
						.equals(retrieveInvenConfigOutputConnectorDTO
								.getReturnCode())) {

			vmConnectorDTOList = retrieveInvenConfigOutputConnectorDTO
					.getValueMetricList();
			lcConnectorDTOList = retrieveInvenConfigOutputConnectorDTO
					.getLicenseList();
			choConnectorDTOList = retrieveInvenConfigOutputConnectorDTO
					.getChargeOptionList();
			ulConnectorDTOList = retrieveInvenConfigOutputConnectorDTO
					.getUseLevelList();

			for (int j = 0; j < vmConnectorDTOList.size(); j++) {
				valueMetricConnectorDTO = (ValueMetricConnectorDTO) vmConnectorDTOList
						.get(j);
				if (!configureDMCustomDTO.isVmChanged()) {
					vmMap.put(valueMetricConnectorDTO.getValueMetric(),
							valueMetricConnectorDTO.getDescription());
				} else {
					vmMap = configureDMCustomDTO.getValueMetricDescription();
				}

				if (valueMetricConnectorDTO.getDefault() != null
						&& valueMetricConnectorDTO.getDefault().equals("X")) {
					tempConfigureDMEECustomDTO.setVm(valueMetricConnectorDTO
							.getValueMetric());
				}
			}

			for (int k = 0; k < lcConnectorDTOList.size(); k++) {
				licenseConnectorDTO = (LicenseConnectorDTO) lcConnectorDTOList
						.get(k);
				if (!configureDMCustomDTO.isLicenseTypeChaged()) {
					lcMap.put(licenseConnectorDTO.getLicenseType(),
							licenseConnectorDTO.getDescription());
				} else {
					lcMap = configureDMCustomDTO.getLicenseType();
				}
				if (licenseConnectorDTO.getDefault() != null
						&& licenseConnectorDTO.getDefault().equals("X")) {
					tempConfigureDMEECustomDTO.setLt(licenseConnectorDTO
							.getLicenseType());
				}
			}

			for (int l = 0; l < choConnectorDTOList.size(); l++) {
				chargeOptionConnectorDTO = (ChargeOptionConnectorDTO) choConnectorDTOList
						.get(l);
				if (!configureDMCustomDTO.isChoChanged()) {
					choMap.put(chargeOptionConnectorDTO.getChargeOption(),
							chargeOptionConnectorDTO.getDescription());
				} else {
					choMap = configureDMCustomDTO.getChargeOption();
				}
				if (chargeOptionConnectorDTO.getDefault() != null
						&& chargeOptionConnectorDTO.getDefault().equals("X")) {
					tempConfigureDMEECustomDTO.setCho(chargeOptionConnectorDTO
							.getChargeOption());
				}

			}

			for (int m = 0; m < ulConnectorDTOList.size(); m++) {
				useLevelConnectorDTO = (UseLevelConnectorDTO) ulConnectorDTOList
						.get(m);
				if (useLevelConnectorDTO != null
						&& useLevelConnectorDTO.getDescription() != null) {
					if (!configureDMCustomDTO.isUseLevelChanged()) {
						ulMap.put(useLevelConnectorDTO.getUseLevel(),
								useLevelConnectorDTO.getDescription());
					} else {
						ulMap = configureDMCustomDTO.getUseLevel();
					}
				}
				if (useLevelConnectorDTO.getDefault() != null
						&& useLevelConnectorDTO.getDefault().equals("X")) {
					tempConfigureDMEECustomDTO.setMt(useLevelConnectorDTO
							.getValueMetricType());
					tempConfigureDMEECustomDTO.setUl(useLevelConnectorDTO
							.getUseLevel());
				}
			}

			if (configureDMCustomDTO.isConfigChange()
					|| !configureDMCustomDTO.isConfigChange()) {
				OPPTLogger.debug("Configuration change :"
						+ configureDMCustomDTO.isConfigChange(), CLASS_NAME,
						methodName);
				tempEEDomainDTO = new TempEEDomainDTO();
				tempEEDomainDTO.setSessionId(configureDMCustomDTO
						.getSessionId());
				tempEEDomainDTO.setProposalId(configureDMCustomDTO
						.getProposalId());
				tempEEDomainDTO.setCustomerId(Integer
						.parseInt(configureDMCustomDTO.getCustomerId()));
				tempEEDomainDTO.setDmId(Integer.parseInt(configureDMCustomDTO
						.getId()));
				tempEEDomainDTO.setValueMetric(tempConfigureDMEECustomDTO
						.getValueMetricDescription());
				tempEEDomainDTO.setSalesDocNo(tempConfigureDMEECustomDTO
						.getSalesDocNumber());
				tempEEDomainDTO.setLicenseType(tempConfigureDMEECustomDTO
						.getLicenseType());
				tempEEDomainDTO.setSwoItemNo(tempConfigureDMEECustomDTO
						.getSwoItemNo());
				tempEEDomainDTO.setEeItemNo(tempConfigureDMEECustomDTO
						.getEeItemNumber());
				tempEEDomainDTO.setChargeOptionDesc(tempConfigureDMEECustomDTO
						.getChargeOption());
				tempEEDomainDTO.setUseLevel(tempConfigureDMEECustomDTO
						.getUseLevel());
				tempEEDomainDTO.setCho(tempConfigureDMEECustomDTO.getCho());
				tempEEDomainDTO.setVm(tempConfigureDMEECustomDTO.getVm());
				tempEEDomainDTO.setUl(tempConfigureDMEECustomDTO.getUl());
				tempEEDomainDTO.setValueMetricType(tempConfigureDMEECustomDTO
						.getMt());
				tempEEDomainDTO.setLcs(tempConfigureDMEECustomDTO.getLt());
				try {
					inventoryManagerLocal = HomeProvider
							.getInventoryManagerLocal();
					inventoryManagerLocal.storeEEConfigInfo(tempEEDomainDTO);
				} catch (Exception e) {
					getSessionContext().setRollbackOnly();
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							methodName, null, e);
					throwServiceException(ErrorCodeConstants.SE0801,
							OPPTMessageCatalog.TYPE_SERVICE);
				}
			}

			configureDMCustomDTO.setValueMetricDescription(vmMap);
			configureDMCustomDTO.setLicenseType(lcMap);
			configureDMCustomDTO.setChargeOption(choMap);
			configureDMCustomDTO.setUseLevel(ulMap);
			if (!configureDMCustomDTO.isConfigChange()) {
				configureDMCustomDTO
						.setSelectedValueMetricDescription(tempConfigureDMEECustomDTO
								.getVm());
				if (ulMap != null && ulMap.size() > 0) {
					configureDMCustomDTO.setSelectedUseLevel(OPPTHelper
							.trimString(tempConfigureDMEECustomDTO.getUl()));
				}
				configureDMCustomDTO.setSelectedChargeOption(OPPTHelper
						.trimString(tempConfigureDMEECustomDTO.getCho()));
				configureDMCustomDTO.setSelectedLicenseType(OPPTHelper
						.trimString(tempConfigureDMEECustomDTO.getLt()));

				tempConfigureDMEECustomDTO = validateDeFaultedEE(
						configureDMSWOCustomDTOList, true, configureDMCustomDTO
								.getSelectedValueMetricDescription(),
						configureDMCustomDTO.getSelectedLicenseType(),
						configureDMCustomDTO.getSelectedChargeOption(),
						configureDMCustomDTO.getSelectedUseLevel(), vmMap,
						lcMap, choMap, ulMap);
			}
			if (configureDMCustomDTO.isConfigChange()) {
				if (configureDMCustomDTO.isVmChanged()) {
					configureDMCustomDTO
							.setSelectedValueMetricDescription(configureDMCustomDTO
									.getSelectedValueMetricDescription());
				}
				if (configureDMCustomDTO.isUseLevelChanged()) {
					configureDMCustomDTO
							.setSelectedUseLevel(configureDMCustomDTO
									.getSelectedUseLevel());
				}
				if (configureDMCustomDTO.isChoChanged()) {
					configureDMCustomDTO
							.setSelectedChargeOption(configureDMCustomDTO
									.getSelectedChargeOption());
				}
				if (configureDMCustomDTO.isLicenseTypeChaged()) {
					configureDMCustomDTO
							.setSelectedLicenseType(configureDMCustomDTO
									.getSelectedLicenseType());
				}
				tempConfigureDMEECustomDTO = validateDeFaultedEE(
						configureDMSWOCustomDTOList, true, configureDMCustomDTO
								.getSelectedValueMetricDescription(),
						configureDMCustomDTO.getSelectedLicenseType(),
						configureDMCustomDTO.getSelectedChargeOption(),
						configureDMCustomDTO.getSelectedUseLevel(), vmMap,
						lcMap, choMap, ulMap);
			}

			configureDMCustomDTO.setStartYears(OPPTCalender.getStartYearList());
			configureDMCustomDTO.setEndYears(OPPTCalender.getEndYearList());

		} else if (retrieveInvenConfigOutputConnectorDTO.getReturnCode()
				.equals(UtilityConstants.NO_DEFAULT_CONFIG_AVAIL_CODE)) {
			configureDMCustomDTO.addMessageEntry(
					retrieveInvenConfigOutputConnectorDTO.getReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
			storeErrorList(retrieveInvenConfigOutputConnectorDTO
					.getReturnCode(), proposalId, configureDMCustomDTO
					.getUserId(), methodName);
		} else {
			storeErrorList(retrieveInvenConfigOutputConnectorDTO
					.getReturnCode(), proposalId, configureDMCustomDTO
					.getUserId(), methodName);
			throwServiceException(retrieveInvenConfigOutputConnectorDTO
					.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
		}
		timeTaken.end();
		configureDMCustomDTO.setDisplayDefaultValues(true);
		return configureDMCustomDTO;
	}

	/**
	 * validateDeFaultedEE This method copies the configuration information to
	 * the selected swos and swos under the dm
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 20, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param configureDMSWOCustomDTOList
	 * @param isCopy
	 * @param vm
	 * @param lc
	 * @param cho
	 * @param ul
	 * @param vmMap
	 * @param lcMap
	 * @param choMap
	 * @param ulMap
	 *
	 * @return ConfigureDMEECustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	private ConfigureDMEECustomDTO validateDeFaultedEE(
			List configureDMSWOCustomDTOList, boolean isCopy, String vm,
			String lc, String cho, String ul, Map vmMap, Map lcMap, Map choMap,
			Map ulMap) {
		String methodName = "validateDeFaultedEE";
		ConfigureDMSWOCustomDTO configureDMSWOCustomDTO = null;
		ConfigureDMEECustomDTO configureDMEECustomDTO = null;
		ConfigureDMEECustomDTO tempConfigureDMEECustomDTO = null;

		if (configureDMSWOCustomDTOList != null
				&& configureDMSWOCustomDTOList.size() > 0) {
			for (int i = 0; i < configureDMSWOCustomDTOList.size(); i++) {
				configureDMSWOCustomDTO = (ConfigureDMSWOCustomDTO) configureDMSWOCustomDTOList
						.get(i);
				List eeCustomList = configureDMSWOCustomDTO.getEes();
				if (eeCustomList != null && eeCustomList.size() > 0) {
					for (int j = 0; j < eeCustomList.size(); j++) {
						configureDMEECustomDTO = (ConfigureDMEECustomDTO) eeCustomList
								.get(j);
						if (configureDMEECustomDTO.isDefaultedEE()) {
							tempConfigureDMEECustomDTO = configureDMEECustomDTO;
							if (isCopy) {
								configureDMEECustomDTO
										.setValueMetricDescription(vmMap
												.get(vm).toString());
								configureDMEECustomDTO.setLicenseType(lcMap
										.get(lc).toString());
								configureDMEECustomDTO.setChargeOption(choMap
										.get(cho).toString());
								OPPTLogger.debug("Use Level BE" + ul,
										CLASS_NAME, methodName);
								if (ul != null && ulMap != null
										&& ulMap.size() > 0) {
									Object ul1 = ulMap.get(ul);
									if (ul1 != null) {
										configureDMEECustomDTO.setUseLevel(ul1
												.toString());
									} else {
										configureDMEECustomDTO
												.setUseLevel(null);
									}
								}
								OPPTLogger.debug("Use Level"
										+ configureDMEECustomDTO.getUseLevel(),
										CLASS_NAME, methodName);
							}
							tempConfigureDMEECustomDTO
									.setSwoItemNo(configureDMSWOCustomDTO
											.getSwoItemNumber());
						} else {
							configureDMEECustomDTO.setCopiedEE(false);
							configureDMEECustomDTO.setInvalidEE(false);
						}
					}
				}
			}
		}

		return tempConfigureDMEECustomDTO;
	}

	/**
	 *
	 * This method copies the configuration information to the selected swos and
	 * swos under the dm
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 20, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param configureDMCustomDTO
	 * @return ConfigureDMCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public ConfigureDMCustomDTO copyConfigToSWOsWhenConfigureDM(
			ConfigureDMCustomDTO configureDMCustomDTO) throws ServiceException {
		String methodName = "copyConfigToSWOsWhenConfigureDM";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		ConfigureDMSWOCustomDTO configureDMSWOCustomDTO = null;
		ConfigureDMEECustomDTO configureDMEECustomDTO = null;
		List swoList = null;
		List eeList = null;
		swoList = configureDMCustomDTO.getSwos();
		ConfigureDMEECustomDTO defaultedEE = null;
		ConfigureDMEECustomDTO oldEEValue = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		defaultedEE = validateDeFaultedEE(swoList, false, null, null, null,
				null, null, null, null, null);

		if (defaultedEE != null) {
			ConfigureDMCustomDTO oldDMValue = retrieveDM(configureDMCustomDTO);
			oldEEValue = validateEEWithOldConfig(oldDMValue, defaultedEE);
			if (swoList != null && swoList.size() > 0) {
				for (int i = 0; i < swoList.size(); i++) {
					configureDMSWOCustomDTO = (ConfigureDMSWOCustomDTO) swoList
							.get(i);

					if (configureDMCustomDTO.isSelectCopy()
							&& !configureDMSWOCustomDTO.isSelected()) {
						continue;
					} else {
						eeList = configureDMSWOCustomDTO.getEes();

						for (int j = 0; j < eeList.size(); j++) {
							configureDMEECustomDTO = (ConfigureDMEECustomDTO) eeList
									.get(j);
							//apply configuration to all ees
							boolean isValueMetric = false;
							boolean isLiscType = false;
							boolean isChargeOption = false;
							boolean isUseLevel = false;
							if ((oldEEValue.getValueMetricDescription() == null && configureDMEECustomDTO
									.getValueMetricDescription() == null)
									|| (oldEEValue.getValueMetricDescription() != null && OPPTHelper
											.trimString(
													oldEEValue
															.getValueMetricDescription())
											.equals(
													OPPTHelper
															.trimString(configureDMEECustomDTO
																	.getValueMetricDescription())))) {
								isValueMetric = true;
							}
							if ((oldEEValue.getLicenseType() == null && configureDMEECustomDTO
									.getLicenseType() == null)
									|| (oldEEValue.getLicenseType() != null && OPPTHelper
											.trimString(
													oldEEValue.getLicenseType())
											.equals(
													OPPTHelper
															.trimString(configureDMEECustomDTO
																	.getLicenseType())))) {
								isLiscType = true;
							}
							if ((oldEEValue.getChargeOption() == null && configureDMEECustomDTO
									.getChargeOption() == null)
									|| (oldEEValue.getChargeOption() != null && OPPTHelper
											.trimString(
													oldEEValue
															.getChargeOption())
											.equals(
													OPPTHelper
															.trimString(configureDMEECustomDTO
																	.getChargeOption())))) {
								isChargeOption = true;
							}
							if ((oldEEValue.getUseLevel() == null && configureDMEECustomDTO
									.getUseLevel() == null)
									|| (oldEEValue.getUseLevel() != null
											&& configureDMEECustomDTO
													.getUseLevel() != null && OPPTHelper
											.trimString(
													oldEEValue.getUseLevel())
											.equals(
													OPPTHelper
															.trimString(configureDMEECustomDTO
																	.getUseLevel())))) {
								isUseLevel = true;
							}

							if (isValueMetric == true && isLiscType == true
									&& isChargeOption == true
									&& isUseLevel == true) {
								configureDMEECustomDTO
										.setValueMetricDescription(defaultedEE
												.getValueMetricDescription());
								configureDMEECustomDTO
										.setLicenseType(defaultedEE
												.getLicenseType());
								configureDMEECustomDTO
										.setChargeOption(defaultedEE
												.getChargeOption());
								configureDMEECustomDTO.setUseLevel(defaultedEE
										.getUseLevel());
								OPPTLogger.debug("Use Level"
										+ configureDMEECustomDTO.getUseLevel(),
										CLASS_NAME, methodName);
								configureDMEECustomDTO.setCopiedEE(true);

							}
							if (configureDMEECustomDTO.isDefaultedEE()) {
								configureDMEECustomDTO
										.setValueMetricDescription(defaultedEE
												.getValueMetricDescription());
								configureDMEECustomDTO
										.setLicenseType(defaultedEE
												.getLicenseType());
								configureDMEECustomDTO
										.setChargeOption(defaultedEE
												.getChargeOption());
								configureDMEECustomDTO.setUseLevel(defaultedEE
										.getUseLevel());
								configureDMEECustomDTO.setCopiedEE(true);
							}

						}
						configureDMSWOCustomDTO.setEes(eeList);
					}

				}
			}
			configureDMCustomDTO.setSwos(swoList);
		} else {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0135);
		}
		configureDMCustomDTO.setDisplayDefaultValues(false);
		timeTaken.end();
		return configureDMCustomDTO;
	}

	/**
	 * verifyInvalidEES This method validates the configuration information for
	 * the swos
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 20, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param configureDMCustomDTO
	 * @return ConfigureDMEECustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */

	private void verifyInvalidEES(ConfigureDMCustomDTO configureDMCustomDTO)
			throws ServiceException {
		ConfigureDMSWOCustomDTO configureDMSWOCustomDTO = null;
		ConfigureDMEECustomDTO configureDMEECustomDTO = null;
		List swoList = null;
		List eeList = null;
		swoList = configureDMCustomDTO.getSwos();
		ConfigureDMEECustomDTO defaultedEE = null;
		if (swoList != null && swoList.size() > 0) {

			for (int i = 0; i < swoList.size(); i++) {
				configureDMSWOCustomDTO = (ConfigureDMSWOCustomDTO) swoList
						.get(i);
				eeList = configureDMSWOCustomDTO.getEes();
				if (eeList != null && eeList.size() > 0) {
					for (int j = 0; j < eeList.size(); j++) {
						configureDMEECustomDTO = (ConfigureDMEECustomDTO) eeList
								.get(j);
						//apply configuration to all ees
						if (configureDMEECustomDTO.isInvalidEE()) {
							throw ExceptionGenerator
									.generateServiceException(ErrorCodeConstants.SE0134);
						}
					}

				}
			}
		}
	}

	/**
	 * validateEEWithOldConfig This method validates the configuration
	 * information for the swos
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 20, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param configureDMCustomDTO
	 * @param defaultedEE
	 * @return ConfigureDMEECustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	private ConfigureDMEECustomDTO validateEEWithOldConfig(
			ConfigureDMCustomDTO configureDMCustomDTO,
			ConfigureDMEECustomDTO defaultedEE) {
		ConfigureDMSWOCustomDTO configureDMSWOCustomDTO = null;
		ConfigureDMEECustomDTO configureDMEECustomDTO = null;
		ConfigureDMEECustomDTO oldEEValue = null;
		String methodName = "validateEEWithOldConfig";
		List swoList = null;
		List eeList = null;
		swoList = configureDMCustomDTO.getSwos();
		if (swoList != null && swoList.size() > 0) {

			for (int i = 0; i < swoList.size(); i++) {
				configureDMSWOCustomDTO = (ConfigureDMSWOCustomDTO) swoList
						.get(i);
				eeList = configureDMSWOCustomDTO.getEes();
				if (eeList != null && eeList.size() > 0) {
					for (int j = 0; j < eeList.size(); j++) {
						configureDMEECustomDTO = (ConfigureDMEECustomDTO) eeList
								.get(j);
						//apply configuration to all ees
						if (OPPTHelper.trimString(
								configureDMEECustomDTO.getSalesDocNumber())
								.equals(
										OPPTHelper.trimString(defaultedEE
												.getSalesDocNumber()))
								&& OPPTHelper.trimString(
										configureDMEECustomDTO
												.getEeItemNumber()).equals(
										OPPTHelper.trimString(defaultedEE
												.getEeItemNumber()))) {
							oldEEValue = configureDMEECustomDTO;
							oldEEValue
									.setValueMetricDescription(configureDMEECustomDTO
											.getValueMetricDescription());
							OPPTLogger.debug("Use Level"
									+ configureDMEECustomDTO.getUseLevel(),
									CLASS_NAME, methodName);
							oldEEValue.setChargeOption(configureDMEECustomDTO
									.getChargeOption());
							oldEEValue.setUseLevel(configureDMEECustomDTO
									.getUseLevel());
							oldEEValue.setLicenseType(configureDMEECustomDTO
									.getLicenseType());
						}
					}

				}
			}
		}
		return oldEEValue;
	}

	/**
	 *
	 * This method validates the configuration information for the swos
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 20, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param configureDMCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public ConfigureDMCustomDTO validateConfigWhenConfigureDM(
			ConfigureDMCustomDTO configureDMCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME,
				"validateConfigWhenConfigureDM");

		int proposalId = 0;
		ConfigureDMSWOCustomDTO configureDMSWOCustomDTO = null;
		ConfigureDMEECustomDTO configureDMEECustomDTO = null;
		List configureDMSWOCustomDTOList = null;
		ValidateInvenConfigInputConnectorDTO validateInvenConfigInputConnectorDTO = null;
		ValidateInvenConfigOutputConnectorDTO validateInvenConfigOutputConnectorDTO = null;
		JMSConnectorLocal jmsConnectorLocal = null;
		String methodName = "Validate EE Configuration When Config DM";
		proposalId = configureDMCustomDTO.getProposalId();
		TempEEDomainDTO tempEEDomainDTO = null;
		InventoryManagerLocal inventoryManagerLocal = null;

		try {
			tempEEDomainDTO = new TempEEDomainDTO();
			tempEEDomainDTO.setProposalId(configureDMCustomDTO.getProposalId());
			tempEEDomainDTO.setCustomerId(Integer.parseInt(configureDMCustomDTO
					.getCustomerId()));
			tempEEDomainDTO.setDmId(Integer.parseInt(configureDMCustomDTO
					.getId()));
			tempEEDomainDTO.setSessionId(configureDMCustomDTO.getSessionId());

			inventoryManagerLocal = HomeProvider.getInventoryManagerLocal();
			tempEEDomainDTO = inventoryManagerLocal
					.retrieveEEConfigInfoFromTemp(tempEEDomainDTO);
			validateInvenConfigInputConnectorDTO = InputConnectorDTOBuildHelper
					.buildValidateInvenConfigInputConnectorDTO(
							configureDMCustomDTO, tempEEDomainDTO);

			jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
			validateInvenConfigOutputConnectorDTO = (ValidateInvenConfigOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(validateInvenConfigInputConnectorDTO);
			if (validateInvenConfigOutputConnectorDTO != null
					&& ConnectorConstants.RFC_SUCCESS_CODE
							.equals(validateInvenConfigOutputConnectorDTO
									.getReturnCode())) {
				for (int i = 0; i < configureDMCustomDTO.getSwos().size(); i++) {
					configureDMSWOCustomDTO = (ConfigureDMSWOCustomDTO) configureDMCustomDTO
							.getSwos().get(i);
					for (int j = 0; j < configureDMSWOCustomDTO.getEes().size(); j++) {
						configureDMEECustomDTO = (ConfigureDMEECustomDTO) configureDMSWOCustomDTO
								.getEes().get(j);
						validateEEConfiguration(configureDMEECustomDTO,
								validateInvenConfigOutputConnectorDTO);
					}
				}
			} else if (validateInvenConfigOutputConnectorDTO != null
					&& UtilityConstants.NO_EE_INFO_AVAIL_CODE
							.equals(validateInvenConfigOutputConnectorDTO
									.getReturnCode())) {
				configureDMCustomDTO.addMessageEntry(
						validateInvenConfigOutputConnectorDTO.getReturnCode(),
						OPPTMessageCatalog.TYPE_BACKEND);
				storeErrorList(validateInvenConfigOutputConnectorDTO
						.getReturnCode(), proposalId, configureDMCustomDTO
						.getUserId(), methodName);
			} else {
				storeErrorList(validateInvenConfigOutputConnectorDTO
						.getReturnCode(), proposalId, configureDMCustomDTO
						.getUserId(), methodName);
				throwServiceException(validateInvenConfigOutputConnectorDTO
						.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
			}
		} catch (ServiceException se) {
			throw ExceptionGenerator.generateServiceException(se
					.getErrorReport());
		} catch (Exception e) {
			throwServiceException(ErrorCodeConstants.SE0801,
					OPPTMessageCatalog.TYPE_SERVICE);
		}
		timeTaken.end();
		return configureDMCustomDTO;
	}

	/**
	 *
	 * This method validates the EE information
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 23, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param configureDMEECustomDTO
	 * @param validateInvenConfigOutputConnectorDTO
	 */
	private void validateEEConfiguration(
			ConfigureDMEECustomDTO configureDMEECustomDTO,
			ValidateInvenConfigOutputConnectorDTO validateInvenConfigOutputConnectorDTO) {
		List validateConfigList = null;
		ValidateInvenConfigConnectorDTO validateInvenConfigConnectorDTO = null;
		boolean isEEInvalid = false;
		validateConfigList = validateInvenConfigOutputConnectorDTO
				.getValidateInvenConfigConnectorDTOList();
		for (int i = 0; i < validateConfigList.size(); i++) {
			validateInvenConfigConnectorDTO = (ValidateInvenConfigConnectorDTO) validateConfigList
					.get(i);
			if (configureDMEECustomDTO.getSalesDocNumber().equals(
					validateInvenConfigConnectorDTO.getSapSalesDocNo())
					&& configureDMEECustomDTO.getEeItemNumber().equals(
							validateInvenConfigConnectorDTO.getSapEEItemNo())) {
				if (validateInvenConfigConnectorDTO.getSapValidIndicator() != null
						&& validateInvenConfigConnectorDTO
								.getSapValidIndicator().equals("X")) {
					isEEInvalid = true;
					configureDMEECustomDTO.setInvalidEE(isEEInvalid);
				}
			}
		}
	}

	/**
	 *
	 * This method fetches the price during the configure dm
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 20, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param configureDMCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public ConfigureDMCustomDTO fetchPriceWhenConfigureDM(
			ConfigureDMCustomDTO configureDMCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME,
				"fetchPriceWhenConfigureDM");

		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalDomainDTO proposalDomainDTO = null;
		TempEEDomainDTO tempEEDomainDTO = null;
		ProposalContractBO proposalContractBO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		JMSConnectorLocal jmsConnectorLocal = null;
		PriceInquiryInputConnectorDTO priceInquiryInputConnectorDTO = null;
		PriceInquiryOutputConnectorDTO priceInquiryOutputConnectorDTO = null;
		String methodName = "Fetch Price When Config DM";
		DMDomainDTO dmDomainDTO = null;
		OPPTCalender calender = new OPPTCalender();
		proposalContractBOFactory = new ProposalContractBOFactory();

		try {

			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(configureDMCustomDTO.getProposalId());

		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		proposalDomainDTO = new ProposalDomainDTO(proposalContractBO);

		tempEEDomainDTO = new TempEEDomainDTO();
		tempEEDomainDTO.setProposalId(configureDMCustomDTO.getProposalId());
		tempEEDomainDTO.setCustomerId(Integer.parseInt(configureDMCustomDTO
				.getCustomerId()));
		tempEEDomainDTO.setDmId(Integer.parseInt(configureDMCustomDTO.getId()));
		tempEEDomainDTO.setSessionId(configureDMCustomDTO.getSessionId());

		if (calender.isDateGreater(configureDMCustomDTO.getPlanEndDate(),
				configureDMCustomDTO.getBumpPlanStartDate())
				&& (calender.isDateGreater(configureDMCustomDTO
						.getBumpPlanStartDate(), configureDMCustomDTO
						.getPlanStartDate()) || calender.isDateEqual(
						configureDMCustomDTO.getBumpPlanStartDate(),
						configureDMCustomDTO.getPlanStartDate()))
				&& calender.isDateGreater(configureDMCustomDTO
						.getBumpPlanEndDate(), configureDMCustomDTO
						.getPlanStartDate())
				&& (calender.isDateLesser(configureDMCustomDTO
						.getBumpPlanEndDate(), configureDMCustomDTO
						.getPlanEndDate()) || calender.isDateEqual(
						configureDMCustomDTO.getBumpPlanEndDate(),
						configureDMCustomDTO.getPlanEndDate()))) {
			verifyInvalidEES(configureDMCustomDTO);
			try {
				inventoryManagerLocal = HomeProvider.getInventoryManagerLocal();
				tempEEDomainDTO = inventoryManagerLocal
						.retrieveEEConfigInfoFromTemp(tempEEDomainDTO);
				priceInquiryInputConnectorDTO = InputConnectorDTOBuildHelper
						.buildPriceInquiryInputConnectorDTO(tempEEDomainDTO,
								proposalDomainDTO, configureDMCustomDTO);
				jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
				priceInquiryOutputConnectorDTO = (PriceInquiryOutputConnectorDTO) jmsConnectorLocal
						.sendReceive(priceInquiryInputConnectorDTO);

			} catch (Exception e) {
				throwServiceException(ErrorCodeConstants.SE0801,
						OPPTMessageCatalog.TYPE_SERVICE);
			}

			if (priceInquiryOutputConnectorDTO != null
					&& ConnectorConstants.RFC_SUCCESS_CODE
							.equals(priceInquiryOutputConnectorDTO
									.getReturnCode())) {
				int decimalValue = 0;
				try {
					ProposalDataManagerLocal proposalDataManagerLocal = HomeProvider
							.getProposalDataManagerLocal();
					if (proposalContractBO.getCurrency() != null) {
						CurrencyDomainDTO currencyDomainDTO = proposalDataManagerLocal
								.getCurrencyInformation(proposalContractBO
										.getCurrency());
						decimalValue = currencyDomainDTO.getDecimalAllowed();
					}
				} catch (CreateException c) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							"fetchInventory", null, c);
					throw ExceptionGenerator
							.generateServiceException(ErrorCodeConstants.SE0801);
				}
				dmDomainDTO = DomainDTOBuildHelper
						.buildDMDomainDTOFromConfigureDMCustomDTO(
								configureDMCustomDTO,
								priceInquiryOutputConnectorDTO, decimalValue);
				dmDomainDTO.setActionName(ActionNameConstants.CONFIGURE_DM);
				try {
					inventoryManagerLocal.storeConfigureDMInfo(dmDomainDTO);

				} catch (ServiceException se) {
					getSessionContext().setRollbackOnly();
					throw se;
				}
				boolean isProposal = proposalContractBO.isProposal();
				if (isProposal) {
					proposalContractBO
							.setStatusCode(ProposalContractStatusConstants.DRAFT);
					proposalContractBO.setInvoiceAmount(0.0);
				} else {
					proposalContractBO
							.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
					//proposalContractBO.setAmendEffectiveDate(new Date(new
					// java.util.Date().getTime()));
					proposalContractBO.setInvoiceAmount(0.0);
				}
				try {
					proposalContractBOFactory
							.updateProposalContractBO(proposalContractBO);
				} catch (DomainException d) {
					throw ExceptionGenerator.generateServiceException(d
							.getErrorReport());
				}
			} else if (priceInquiryOutputConnectorDTO.getReturnCode().equals(
					UtilityConstants.NO_INVENTORY_AVAIL_CODE)) {
				configureDMCustomDTO.addMessageEntry(
						priceInquiryOutputConnectorDTO.getReturnCode(),
						OPPTMessageCatalog.TYPE_BACKEND);
				storeErrorList(priceInquiryOutputConnectorDTO.getReturnCode(),
						configureDMCustomDTO.getProposalId(),
						configureDMCustomDTO.getUserId(), methodName);
			} else {
				storeErrorList(priceInquiryOutputConnectorDTO.getReturnCode(),
						configureDMCustomDTO.getProposalId(),
						configureDMCustomDTO.getUserId(), methodName);
				throwServiceException(priceInquiryOutputConnectorDTO
						.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
			}
		} else {
			throwServiceException(ErrorCodeConstants.SE0101,
					OPPTMessageCatalog.TYPE_SERVICE);
		}

		timeTaken.end();
		return configureDMCustomDTO;
	}

	/**
	 * This method will get the proposal details
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 8, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param reportsCustomDTO
	 * @return ReportsCustomDTO
	 */
	public ProposalContractBO getProposal(int proposalId)
			throws ServiceException {
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalContractBO proposalContractBO;
		try {
			proposalContractBO = getProposalContractBOFromFactory(proposalId);
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}

		return proposalContractBO;
	}

	/**
	 * Gets the ProposalContractBO from the factory and returns
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 8, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalID
	 * @return ProposalContractBO
	 * @throws DomainException
	 */
	private ProposalContractBO getProposalContractBOFromFactory(int proposalID)
			throws DomainException {
		ProposalContractBOFactory proposalBOFactory = new ProposalContractBOFactory();
		return proposalBOFactory.getProposalContractBO(proposalID);
	}

	/**
	 * Gets the SharingBO from the factory and returns
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 8, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalID
	 * @param userid
	 * @return SharingBO
	 * @throws DomainException
	 */
	private SharingBO getSharingBOFromFactory(int proposalID, String userid)
			throws DomainException {
		SharingBOFactory sharingBOFactory = new SharingBOFactory();
		return sharingBOFactory.getSharingBO(proposalID, userid);
	}

	/**
	 * Checks and Populates the customer details
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 16, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param compareValue
	 * @param proposal
	 * @param domainCustomer
	 * @param eswCustomer
	 * @param type
	 */
	private void checkAndPopulateESWCustomerCustomDTO(String compareValue,
			ProposalContractBO proposal, CustomerDomainDTO domainCustomer,
			ESWCustomerCustomDTO eswCustomer, int type) {
				if (compareValue != null) {
			PCMCustomDTOBuilder
					.populateCustomDTOForCustomerDetailsFromDomainDTO(
							eswCustomer, domainCustomer, type);
		} else {
					PCMCustomDTOBuilder.populateCustomDTOForCustomerDetailsFromPCBO(
					eswCustomer, proposal, type);
		}
	}

	/**
	 * Gets the ProposalContractBO from the factory and returns. Also assign the
	 * factory used to the array for future use
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 21, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param factories
	 * @param proposalID
	 * @return ProposalContractBO
	 * @throws DomainException
	 */
	private ProposalContractBO getProposalContractBOFromFactory(
			ProposalContractBOFactory[] factories, int proposalID)
			throws DomainException {
		ProposalContractBOFactory proposalBOFactory = new ProposalContractBOFactory();
		factories[0] = proposalBOFactory;
		return proposalBOFactory.getProposalContractBO(proposalID);
	}

	/**
	 * populateCompareValuesForUserAuthInProposalBO Populate the values to be
	 * compared in ProposalBO
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 8, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param customDTO
	 * @param shareBO
	 * @return HashMap
	 */
	private HashMap populateCompareValuesForUserAuthInProposalBO(
			OPPTCustomDTO customDTO, SharingBO shareBO) {
		HashMap compareValues = new HashMap();
		String accessType = null;

		if (customDTO == null) {
			return compareValues;
		}

		compareValues.put(UtilityConstants.BO_USERID, customDTO.getUserId());
		compareValues.put(UtilityConstants.BO_GROUPNAME, customDTO
				.getGroupName());
		compareValues.put(UtilityConstants.BO_ROLE, new Integer(customDTO
				.getRole()));
		if (shareBO != null) {
			accessType = shareBO.getAccessType();
		}
		compareValues.put(UtilityConstants.BO_SHARING, accessType);

		return compareValues;
	}

	/**
	 * removeSVCLicenses Removes SVC Licenses from the proposal
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 16, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalInformation
	 * @return ProposalCustomDTO
	 * @throws ServiceException
	 */
	public ProposalCustomDTO removeSVCLicenses(
			ProposalCustomDTO proposalInformation) throws ServiceException {
		ProposalContractBO proposal = null;
		SharingBO shareBO = null;
		HashMap compareValues = null;
		String transactionName = proposalInformation.getTransactionName();

		try {
			shareBO = getSharingBOFromFactory(proposalInformation.getId(),
					proposalInformation.getUserId());
			proposal = getProposalContractBOFromFactory(proposalInformation
					.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					proposalInformation, shareBO);
			proposal.validateRemoveSVC(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		if (proposalInformation.isConfirmationRequired()) {
			return proposalInformation;
		} else {
			try {
				InventoryManagerLocal inventoryManagerLocal = getInventoryManagerLocal();
				ProposalDomainDTO proposalDomainDTO = new ProposalDomainDTO();
				proposalDomainDTO.setProposalId(proposal.getProposalId());
				inventoryManagerLocal.removeSVCLicenses(proposalDomainDTO);
			} catch (ServiceException e) {
				getSessionContext().setRollbackOnly();
				throw e;
			}
		}
		return proposalInformation;
	}

	/**
	 * retrieveCustomerDetails Retrieves the customer details
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 16, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param customer
	 * @return ProposalCustomerCustomDTO
	 * @throws ServiceException
	 */
	public ProposalCustomerCustomDTO retrieveCustomerDetails(
			ProposalCustomerCustomDTO customer) throws ServiceException {
		ProposalContractBO proposal = null;
		CustomerDomainDTO customerDomainDTO = null;

		InventoryManagerLocal inventoryManagerLocal = getInventoryManagerLocal();
		customerDomainDTO = DomainDTOBuildHelper
				.buildCustomerDomainDTOFromCustomWithOnlyID(customer, customer
						.getTransactionName());
		customerDomainDTO = inventoryManagerLocal
				.retrieveCustomerInfo(customerDomainDTO);

		try {
			if (customerDomainDTO.getBillToPartyLNo() == null
					|| customerDomainDTO.getShipToPartyLNo() == null
					|| customerDomainDTO.getPayerLNo() == null
					|| customerDomainDTO.getPlanStartDate() == null
					|| customerDomainDTO.getPlanEndDate() == null) {
				proposal = getProposalContractBOFromFactory(customer
						.getProposalId());
			}

		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}
		customer = (ProposalCustomerCustomDTO) PCMCustomDTOBuilder
				.populateCustomDTOForCustomerDetailsFromDomainDTO(customer,
						customerDomainDTO,
						UtilityConstants.PARTNER_SOLD_TO_PARTY);
		ESWCustomerCustomDTO[] partners = new ESWCustomerCustomDTO[3];
		for (int i = 0; i < 3; i++) {
			partners[i] = new ESWCustomerCustomDTO();
		}
		checkAndPopulateESWCustomerCustomDTO(customerDomainDTO
				.getBillToPartyLNo(), proposal, customerDomainDTO, partners[0],
				UtilityConstants.PARTNER_BILL_TO_PARTY);
		checkAndPopulateESWCustomerCustomDTO(customerDomainDTO.getPayerLNo(),
				proposal, customerDomainDTO, partners[1],
				UtilityConstants.PARTNER_PAYER);
		checkAndPopulateESWCustomerCustomDTO(customerDomainDTO.getPayerLNo(),
				proposal, customerDomainDTO, partners[2],
				UtilityConstants.PARTNER_SHIP_TO_PARTY);
		customer.setESWCustomerCustomDTOs(partners);
		return customer;
	}

	/**
	 * excludeIncludeSWO Exclude and Includes the licenses from special pricing
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 16, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param includeExcludeLicenses
	 * @throws ServiceException
	 */
	public void excludeIncludeSWO(
			IncludeExcludeSWOCustomDTO includeExcludeLicenses)
			throws ServiceException {
		ProposalContractBO proposal = null;
		ProposalCustomDTO selectedProposal = null;
		SharingBO shareBO = null;
		HashMap compareValues = null;

		ProposalContractBOFactory[] factories = new ProposalContractBOFactory[1];
		try {
			selectedProposal = includeExcludeLicenses.getProposalDTO();
			shareBO = getSharingBOFromFactory(selectedProposal.getId(),
					includeExcludeLicenses.getUserId());
			proposal = getProposalContractBOFromFactory(factories,
					selectedProposal.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					includeExcludeLicenses, shareBO);
			proposal.validateForIncludeExclude(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		InventoryManagerLocal inventoryManagerLocal = getInventoryManagerLocal();
		SWODomainDTO[] licenses = null;
		DMDomainDTO[] machines = null;
		CustomerDomainDTO[] customers = null;
		String transactionName = includeExcludeLicenses.getTransactionName();

		licenses = DomainDTOBuildHelper.buildSWODomainDTOsWithIDFromCustomDTO(
				includeExcludeLicenses.getSelectedSWOs(), transactionName);
		machines = DomainDTOBuildHelper.buildDMDomainDTOsWithIDFromCustomDTO(
				includeExcludeLicenses.getSelectedDMs(), transactionName);
		customers = DomainDTOBuildHelper
				.buildCustomerDomainDTOsWithIDFromCustomDTO(
						includeExcludeLicenses.getSelectedCustomers(),
						transactionName);

		boolean result = false;
		try {
			result = inventoryManagerLocal.excludeIncludeLicenses(licenses,
					machines, customers);
		} catch (ServiceException e) {
			getSessionContext().setRollbackOnly();
			throw e;
		}
		if (result) {
			if (proposal instanceof ProposalBO) {
				proposal.setStatusCode(ProposalContractStatusConstants.DRAFT);
			} else {
				proposal
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
			}
			proposal.setInvoiceAmount(0);
			try {
				factories[0].updateProposalContractBO(proposal);
			} catch (DomainException e) {
				getSessionContext().setRollbackOnly();
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}
		}
	}

	/**
	 * getSWODetails Retrieves the details of a SWO
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 16, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param customDTO
	 * @return SWODetailsCustomDTO
	 * @throws ServiceException
	 */
	public SWODetailsCustomDTO getSWODetails(SWODetailsCustomDTO customDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "getSWODetails()");
		InventoryManagerLocal inventoryManager = null;
		SWODomainDTO[] licenses = null;
		SWOCustomDTO[] customLicenses = null;
		CustomerDomainDTO customer = null;
		DMDomainDTO machine = null;
		ProposalContractBO proposal = null;
		boolean nextActionAllowed = false, amendSWOAction = false, changeSWOAction = false, exceptionThrown = false;
		ErrorReport errorReport = null;

		String transactionName = customDTO.getTransactionName();
		if (ActionNameConstants.SWO_DETAILS.equals(transactionName)) {
			changeSWOAction = true;
		} else if (ActionNameConstants.AMEND_SWO.equals(transactionName)) {
			amendSWOAction = true;
		}
		customLicenses = new SWOCustomDTO[1];
		customLicenses[0] = customDTO;

		try {
			HashMap compareValues = null;
			ProposalCustomDTO customProposal = customDTO.getProposal();
			SharingBO shareBO = getSharingBOFromFactory(customProposal.getId(),
					customDTO.getUserId());
			proposal = getProposalContractBOFromFactory(customProposal.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					customDTO, shareBO);
			if (changeSWOAction) {
				//It is handled as post condition type because if the
				// validation fails, the user can view.
				//If true, user can change the details
				nextActionAllowed = proposal.validateForChangeSWO(
						UtilityConstants.BUSINESSRULE_POST_COND_TYPE,
						compareValues);
			} else if (amendSWOAction) {
				nextActionAllowed = ((ContractBO) proposal)
						.validateForAmendSWO(
								UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
								compareValues);
			}
		} catch (DomainException e) {
			nextActionAllowed = false;
			exceptionThrown = true;
			if (errorReport != null) {
				errorReport.appendErrorReport(e.getErrorReport());
			} else {
				errorReport = e.getErrorReport();
			}
		}

		licenses = DomainDTOBuildHelper.buildSWODomainDTOsWithIDFromCustomDTO(
				customLicenses, transactionName);
		inventoryManager = getInventoryManagerLocal();

		try {
			if (changeSWOAction || (amendSWOAction && !exceptionThrown)) {
				licenses = inventoryManager.retrieveSWODetails(licenses);
			}
		} catch (ServiceException e) {
			exceptionThrown = true;
			errorReport = e.getErrorReport();
		}

		if (changeSWOAction) {
			machine = DomainDTOBuildHelper.buildDMDomainDTOWithOnlyID(customDTO
					.getProposalId(), customDTO.getCustomerId(), customDTO
					.getDMId(), transactionName);
			machine = inventoryManager.retrieveDMInfo(machine);
			customer = DomainDTOBuildHelper.buildCustomerDomainDTOWithOnlyID(
					customDTO.getProposalId(), customDTO.getCustomerId(),
					transactionName);
			customer = inventoryManager.retrieveCustomerInfo(customer);
		}

		if (exceptionThrown) {
			throw ExceptionGenerator.generateServiceException(errorReport);
		}
		if (changeSWOAction) {
			boolean finalResult = nextActionAllowed
					& licenses[0].isActionAllowed();
			licenses[0].setActionAllowed(finalResult);
			PCMCustomDTOBuilder.populateSWODetailsCustomDTOFromDomainDTO(
					customer, machine, licenses[0], proposal, customDTO);
		} else if (amendSWOAction) {
			PCMCustomDTOBuilder.populateSWOCustomDTOFromDomainDTO(licenses[0],
					customDTO);
		}

		if (!customDTO.isSWOEditable()) {
			customDTO.addButtonFlag(ButtonConstants.SAVE);
			customDTO.addButtonFlag(ButtonConstants.CLEAR_ALL);
			customDTO.addButtonFlag(ButtonConstants.CANCEL);
		} else if (amendSWOAction
				|| (changeSWOAction && nextActionAllowed && licenses[0]
						.isActionAllowed())) {
			customDTO.addButtonFlag(ButtonConstants.CONTINUE);
		} else {
			customDTO.addButtonFlag(ButtonConstants.SAVE);
			customDTO.addButtonFlag(ButtonConstants.CLEAR_ALL);
			customDTO.addButtonFlag(ButtonConstants.CANCEL);
		}
		log.end();

		return customDTO;
	}

	/**
	 * saveSWODetails Saves the changes to the SWO and EE
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 16, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param customDTO
	 * @throws ServiceException
	 */
	public void saveSWODetails(SWODetailsCustomDTO customDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "saveSWODetails");
		InventoryManagerLocal inventoryManager = null;
		SWODomainDTO[] licenses = null;
		ProposalContractBO proposal = null;
		ProposalCustomDTO customProposal = null;
		HashMap compareValues = null;
		boolean saveActionAllowed = false;
		ProposalContractBOFactory[] factories = new ProposalContractBOFactory[1];
		String transactionName = customDTO.getTransactionName();

		try {
			customProposal = customDTO.getProposal();
			SharingBO shareBO = getSharingBOFromFactory(customProposal.getId(),
					customDTO.getUserId());
			proposal = getProposalContractBOFromFactory(factories,
					customProposal.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					customDTO, shareBO);
			saveActionAllowed = proposal.validateForChangeSWO(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		if (saveActionAllowed) {
			licenses = new SWODomainDTO[1];
			licenses[0] = DomainDTOBuildHelper.buildSWODomainDTOWithOnlyID(
					customProposal.getId(), customDTO.getCustomerId(),
					customDTO.getDMId(), customDTO.getId(), transactionName);
			OPPTLogger.debug("customDTO.getEEs() :" + customDTO.getEEs(),
					CLASS_NAME, "saveSWODetails");
			List domainEEs = DomainDTOBuildHelper
					.buildEEDomainDTOsFromCustomDTO(customDTO, customDTO
							.getEEs(), transactionName);

			if (null != domainEEs) {
				for (int i = 0; i < domainEEs.size(); i++) {
					EEDomainDTO eeDomain = (EEDomainDTO) domainEEs.get(i);
					//System.out.println("ProposalManagerBean.saveSWODetails():AlternatePrice:"+eeDomain.getAlternatePrice());
					//System.out.println("ProposalManagerBean.saveSWODetails():Discount:"+proposal.getDiscount());
					/*if((proposal.getDiscount() > 0) &&( proposal.getAnnvAmount()==0)) {
						eeDomain.setCalculatedPrice(eeDomain.getAlternatePrice());
						System.out.println("ProposalManagerBean.saveSWODetails()1"+eeDomain.getAlternatePrice());
					}*/
					validateAlternateAmount(proposal.getSalesOrg(), eeDomain
							.getAlternatePrice());
				}
			}
			licenses[0].setEEDTOList(domainEEs);
			try {
				inventoryManager = getInventoryManagerLocal();
				inventoryManager.updateSWODetails(licenses);
			} catch (ServiceException e) {
				getSessionContext().setRollbackOnly();
				throw e;
			}
		}

		try {
			if (proposal instanceof ProposalBO) {
				if((proposal.getDiscount() > 0) &&( proposal.getAnnvAmount()==0))
				{
					proposal.setStatusCode(ProposalContractStatusConstants.PRICED);
				}
				else{
				proposal.setStatusCode(ProposalContractStatusConstants.DRAFT);
				proposal.setInvoiceAmount(0.0);
				}
			} else {
				proposal
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				proposal.setInvoiceAmount(0.0);
			}
			factories[0].updateProposalContractBO(proposal);
		} catch (DomainException e) {
			getSessionContext().setRollbackOnly();
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		log.end();
	}

	/**
	 * amendSWO Amends the SWO
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 7, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param amendSWOCustomDTO
	 * @return AmendSWOCustomDTO
	 * @throws ServiceException
	 */
	public AmendSWOCustomDTO amendSWO(AmendSWOCustomDTO amendSWOCustomDTO)
			throws ServiceException {
		ContractBO contractBO = null;
		SharingBO shareBO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		HashMap compareValues = null;
		ErrorReport errorReport = null;

		ProposalContractBOFactory[] factories = new ProposalContractBOFactory[1];
		ContractCustomDTO contractCustom = amendSWOCustomDTO.getContractDTO();
		SWOCustomDTO swoCustom = amendSWOCustomDTO.getSwoDTO();
		try {
			shareBO = getSharingBOFromFactory(contractCustom.getId(),
					amendSWOCustomDTO.getUserId());
			contractBO = (ContractBO) getProposalContractBOFromFactory(
					factories, contractCustom.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					amendSWOCustomDTO, shareBO);
			contractBO.validateForAmendSWO(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}
		SWODomainDTO[] licenses = new SWODomainDTO[1];
		licenses[0] = DomainDTOBuildHelper.buildSWODomainDTOWithOnlyID(
				contractCustom.getId(), swoCustom.getCustomerId(), swoCustom
						.getDMId(), swoCustom.getId(), amendSWOCustomDTO
						.getTransactionName());
		if (amendSWOCustomDTO.getToDate() == null
				|| amendSWOCustomDTO.getFromDate() == null) {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		} else {
			Date amendSDate = new Date(amendSWOCustomDTO.getFromDate()
					.getTime());
			Date amendEDate = new Date(amendSWOCustomDTO.getToDate().getTime());
			licenses[0].setAmendEndDate(amendEDate);
			licenses[0].setAmendStartDate(amendSDate);
			compareValues.put(UtilityConstants.LICENSE_AMEND_END, amendEDate);
			compareValues.put(UtilityConstants.LICENSE_AMEND_START, amendSDate);
		}
		compareValues.put(UtilityConstants.CONTRACT_PERIOD_START, contractBO
				.getContrStartPeriod());
		compareValues.put(UtilityConstants.CONTRACT_PERIOD_END, contractBO
				.getContrEndPeriod());
		licenses[0].setValues(compareValues);

		try {
			inventoryManagerLocal = getInventoryManagerLocal();
			inventoryManagerLocal.updateSWODetails(licenses);
		} catch (ServiceException e) {
			getSessionContext().setRollbackOnly();
			throw e;
		}

		try {
			contractBO
					.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
			factories[0].updateProposalContractBO(contractBO);
		} catch (DomainException e) {
			getSessionContext().setRollbackOnly();
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}
		return amendSWOCustomDTO;
	}

	/**
	 * revertProposal Reverts the changes made to the contract
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 22, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param customContract
	 * @throws ServiceException
	 */
	public void revertProposal(ContractCustomDTO customContract)
			throws ServiceException {
		ContractBO contract = null;
		ProposalBO relatedProposal = null;
		HashMap compareValues = null;
		ProposalContractBOFactory[] factories = new ProposalContractBOFactory[1];
		String errorCodeFromBE = null;
		boolean result = true;

		try {
			contract = (ContractBO) getProposalContractBOFromFactory(factories,
					customContract.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					customContract, null);
			contract.validateForRevert(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		if (customContract.isConfirmationRequired()) {
			return;
		} else {
			try {
				if (contract.isContractInVariance()) {
					relatedProposal = (ProposalBO) factories[0]
							.getProposalContractBOOfVarianceProposal(contract
									.getContrNo());
					if (ProposalContractStatusConstants.PENDING_APPROVAL
							.equals(relatedProposal.getStatusCode())) {
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0602);
					}
					factories[0].deleteProposalContractBO(relatedProposal);
					try {
						InventoryManagerLocal invMgr = getInventoryManagerLocal();
						ProposalDomainDTO proposalDomainDTO = new ProposalDomainDTO();
						proposalDomainDTO.setProposalId(customContract.getId());
						invMgr.deleteVarianceInventory(proposalDomainDTO);
					} catch (ServiceException e) {
						getSessionContext().setRollbackOnly();
						throw e;
					}
					contract.checkAndSetOldContractAfterRevert();
					factories[0].updateProposalContractBO(contract);
					RefreshVarianceOutputConnectorDTO outputConnector = null;
					try {
						RefreshVarianceInputConnectorDTO inputConnector = PCMConnectorDTOBuilder
								.buildRevertVarianceInputConnectorDTO(contract,
										relatedProposal, customContract
												.getSessionId(), customContract
												.getUserId());
						JMSConnectorLocal jmsConnectorLocal = HomeProvider
								.getJMSConnectorLocal();
						outputConnector = (RefreshVarianceOutputConnectorDTO) jmsConnectorLocal
								.sendReceive(inputConnector);
					} catch (ConnectorException e) {
						getSessionContext().setRollbackOnly();
						throw ExceptionGenerator.generateServiceException(e
								.getErrorReport());
					} catch (Exception e) {
						OPPTLogger.log(
								ErrorCodeConstants.APP_GENERAL_EXCEPTION,
								OPPTLogger.ERROR, CLASS_NAME, "revertProposal",
								null, e);
						result = false;
					}
					if (outputConnector != null) {
						errorCodeFromBE = outputConnector.getReturnCode();
						if (!ConnectorConstants.RFC_SUCCESS_CODE
								.equals(errorCodeFromBE)) {
							storeErrorList(errorCodeFromBE, contract
									.getProposalId(), customContract
									.getUserId(), "Revert Proposal");
							result = false;
						} else {
							result = true;
						}
					}
				} else if (contract.isContractInAmendment()) {
					ContractBO origContract = (ContractBO) factories[0]
							.getProposalContractBOForContractNumber(contract
									.getOldContrNo(), true);
					origContract.setProposalName(contract.getProposalName());
					factories[0].deleteProposalContractBO(contract);
					origContract.checkAndSetOldContractAfterRevert();
					factories[0].updateProposalContractBO(origContract);
				} else {
					relatedProposal = (ProposalBO) factories[0]
							.getProposalContractBOForRelatedProposal(contract
									.getContrNo());
					if (ProposalContractStatusConstants.PENDING_APPROVAL
							.equals(relatedProposal.getStatusCode())) {
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0602);
					}
					factories[0].deleteProposalContractBO(relatedProposal);
					contract.checkAndSetOldContractAfterRevert();
					factories[0].updateProposalContractBO(contract);
				}
			} catch (DomainException e) {
				getSessionContext().setRollbackOnly();
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}
			if (!result) {
				getSessionContext().setRollbackOnly();
				ErrorReport errorReport = null;
				if (errorCodeFromBE != null && !errorCodeFromBE.equals("")) {
					errorReport = ExceptionGenerator.getErrorReport(
							errorCodeFromBE, OPPTMessageCatalog.TYPE_BACKEND);
				} else {
					errorReport = ExceptionGenerator.getErrorReport(
							ErrorCodeConstants.SE0801,
							OPPTMessageCatalog.TYPE_SERVICE);
				}
				throw ExceptionGenerator.generateServiceException(errorReport);
			}
		}
	}

	/**
	 * closeContract Processes the request to close the contract
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 22, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param closeContract
	 * @return CloseContractCustomDTO
	 * @throws ServiceException
	 */
	public CloseContractCustomDTO closeContract(
			CloseContractCustomDTO closeContract) throws ServiceException {
		ContractBO contract = null;
		ProposalContractBO relatedProposalContract = null;
		HashMap compareValues = null;
		ProposalContractBOFactory[] factories = new ProposalContractBOFactory[1];
		ContractCustomDTO contractDTO = null;
		boolean result = false;
		boolean firstAction = false;
		String errorCodeFromBE = null;

		if (ActionNameConstants.CLOSE_CONTRACT.equals(closeContract
				.getTransactionName())) {
			firstAction = true;
		}

		try {
			contractDTO = closeContract.getContractDTO();
			contract = (ContractBO) getProposalContractBOFromFactory(factories,
					contractDTO.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					closeContract, null);
			if ((ProposalTypeConstants.EAS.equals(contract.getProposalType()) && firstAction)
					|| (!firstAction && !ProposalTypeConstants.TP
							.equals(contract.getProposalType()))) {
				try {
					relatedProposalContract = factories[0]
							.getProposalContractBOForContractNumber(contract
									.getTpContrNo(), true);
					compareValues.put(
							UtilityConstants.RELATED_PNAME_FOR_OVERLAY,
							relatedProposalContract.getProposalName());
				} catch (DomainException e) {
					//Exception is ignored as there might not be a related
					// contract
				}
			}
			if (firstAction) {
				contract.validateForContractClosure(
						UtilityConstants.BUSINESSRULE_PRE_COND_TYPE,
						compareValues);
			} else {
				if (relatedProposalContract != null) {
					if (ProposalContractStatusConstants.CONTRACT
							.equals(relatedProposalContract.getStatusCode())) {
						compareValues.put(UtilityConstants.CONTRACT_PERIOD_END,
								relatedProposalContract.getContrEndPeriod());
					} else {
						throw ExceptionGenerator
								.generateServiceException(ErrorCodeConstants.SE0601);
					}
				}
				compareValues.put(UtilityConstants.CONTRACT_CLS_DATE,
						closeContract.getContractClosureDate());
				contract
						.validateForContractClosure(
								UtilityConstants.BUSINESSRULE_OTHER_TYPE,
								compareValues);
			}
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		if (firstAction) {
			PCMCustomDTOBuilder.populateCloseContractCustomDTOFromBO(
					closeContract, contract);
			if (ProposalContractStatusConstants.CONTRACT_CLOSURE_FAILED_RETRY
					.equals(contract.getStatusCode())) {
				closeContract.addButtonFlag(ButtonConstants.SAVE);
				closeContract.addButtonFlag(ButtonConstants.CLEAR_ALL);
				closeContract.addButtonFlag(ButtonConstants.CANCEL);
				closeContract.setClosureDateEditable(false);
			} else {
				closeContract.setClosureDateEditable(true);
				closeContract.addButtonFlag(ButtonConstants.CONTINUE);
			}
		} else {

			try {
				contract.setContrClsDate(new Date(closeContract
						.getContractClosureDate().getTime()));
				contract
						.setStatusCode(ProposalContractStatusConstants.CHECK_CLOSURE_STATUS);
				factories[0].updateProposalContractBO(contract);

			} catch (DomainException e) {
				getSessionContext().setRollbackOnly();
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}

			ChangeContractOutputConnectorDTO outputConnDTO = null;
			try {
				int count = 0;
				if (closeContract.isCloseVarianceContract())  {				
				 count = contract.getContrPeriodVarNo();
				}			
			
				
				ChangeContractInputConnectorDTO changeContractConnDTO = PCMConnectorDTOBuilder
						.buildChangeContractInputConnectorDTO(contract, count,
								closeContract.getSessionId(), closeContract
										.getUserId(), closeContract
										.getContractClosureDate(),
								UtilityConstants.ESW_STATUS_CLSD);
				JMSConnectorLocal jmsConnectorLocal = HomeProvider
						.getJMSConnectorLocal();
				outputConnDTO = (ChangeContractOutputConnectorDTO) jmsConnectorLocal
						.sendReceive(changeContractConnDTO);
			} catch (ConnectorException e) {
				getSessionContext().setRollbackOnly();
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			} catch (Exception e) {
				result = false;
			}
			if (outputConnDTO != null) {
				errorCodeFromBE = outputConnDTO.getIReturnCode();
				if (!ConnectorConstants.RFC_SUCCESS_CODE
						.equals(errorCodeFromBE)) {
					storeErrorList(errorCodeFromBE, contract.getProposalId(),
							closeContract.getUserId(), "Contract Closure");
					result = false;
				} else {
					result = true;
				}
			}
			if (!result) {
				getSessionContext().setRollbackOnly();
				ErrorReport errorReport = null;
				if (errorCodeFromBE != null && !errorCodeFromBE.equals("")) {
					errorReport = ExceptionGenerator.getErrorReport(
							errorCodeFromBE, OPPTMessageCatalog.TYPE_BACKEND);
				} else {
					errorReport = ExceptionGenerator.getErrorReport(
							ErrorCodeConstants.SE0801,
							OPPTMessageCatalog.TYPE_SERVICE);
				}
				throw ExceptionGenerator.generateServiceException(errorReport);
			}
		}
		return closeContract;
	}

	/**
	 * rejectRequest Processes the request for rejection
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 23, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param requestInfo
	 * @throws ServiceException
	 */
	public void rejectRequest(RejectProposalCustomDTO requestInfo)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "rejectRequest");
		ProposalContractBOFactory[] factories = null;
		ProposalContractBO proposalContract = null;
		HashMap compareValues = null;
		ProposalCustomDTO proposalContractCustom = null;

		try {
			factories = new ProposalContractBOFactory[1];
			proposalContractCustom = requestInfo.getProposalDTO();
			proposalContract = getProposalContractBOFromFactory(factories,
					proposalContractCustom.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					requestInfo, null);
			//	Commented for the change DAD O11 Remove approval step,Blue Harmony -by Ramesh Gandi
			//proposalContract.validateRequestForApproveOrReject(UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		if (requestInfo.isConfirmationRequired()) {
			return;
		} else {
			try {
				proposalContract.checkAndSetAfterRequestRejection();
				factories[0].updateProposalContractBO(proposalContract);
				createAccessHistory(proposalContractCustom.getId(), requestInfo
						.getUserId(), "Reject request For approval");
			} catch (DomainException e) {
				getSessionContext().setRollbackOnly();
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			} catch (ServiceException e) {
				getSessionContext().setRollbackOnly();
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}
			/* Commented for the change DAD O11 Remove approval step,Blue Harmony -by Ramesh Gandi
			String rejectionReason = requestInfo.getRejectionReason();
			int type = 0;
			if (proposalContract.isProposal()) {
				type = UtilityConstants.MAIL_PROP_REJECT;
			} else {
				type = UtilityConstants.MAIL_CNTR_REJECT;
			}
			MailConnectorDTO mailCarrier = PCMConnectorDTOBuilder
					.buildMailConnectorDTO(proposalContract, requestInfo
							.getEmailAddress(), proposalContract
							.getSubmittedBy(), type);
			String construct = mailCarrier.getMsgText();
			PreparedString mailModify = new PreparedString(construct);
			mailModify.setString(2, requestInfo.getUserId());
			mailModify.setString(3, rejectionReason);
			mailCarrier.setMsgText(mailModify.toString());

			CommunicationConnector mailSender = new CommunicationConnector();
			try {
				mailSender.sendMail(mailCarrier);
			} catch (ConnectorException e) {
				//Exception is not thrown as mail is not a key part
				OPPTLogger.log("MAIL_SERVICE_EXCEPTION", OPPTLogger.ERROR,
						CLASS_NAME, "rejectRequest", null, e);
				requestInfo.setMessageReport(ExceptionGenerator.addErrorEntry(
						null, ErrorCodeConstants.SE0802,
						OPPTMessageCatalog.TYPE_SERVICE));
			} catch (Exception e) {
				//Exception is not thrown as mail is not a key part
				OPPTLogger.log("MAIL_SERVICE_EXCEPTION", OPPTLogger.ERROR,
						CLASS_NAME, "rejectRequest", null, e);
				requestInfo.setMessageReport(ExceptionGenerator.addErrorEntry(
						null, ErrorCodeConstants.SE0802,
						OPPTMessageCatalog.TYPE_SERVICE));
			}
			*/
		}
		log.end();
	}

	/**
	 * cancelConfigureDM This method cancels the Configure DM Process
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 25, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param configureDMCustomDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public ConfigureDMCustomDTO cancelConfigureDM(
			ConfigureDMCustomDTO configureDMCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "cancelConfigureDM");

		ProposalContractBOFactory proposalContractBOFactory = null;
		ProposalContractBO proposalContractBO = null;
		InventoryManagerLocal inventoryManagerLocal = null;
		TempEEDomainDTO tempEEDomainDTO = null;

		proposalContractBOFactory = new ProposalContractBOFactory();
		try {
			proposalContractBO = proposalContractBOFactory
					.getProposalContractBO(configureDMCustomDTO.getProposalId());
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d
					.getErrorReport());
		}
		if (!configureDMCustomDTO.isConfirmationRequired()) {

			tempEEDomainDTO = new TempEEDomainDTO();
			tempEEDomainDTO.setSessionId(configureDMCustomDTO.getSessionId());
			tempEEDomainDTO.setProposalId(configureDMCustomDTO.getProposalId());
			tempEEDomainDTO.setCustomerId(Integer.parseInt(configureDMCustomDTO
					.getCustomerId()));
			tempEEDomainDTO.setDmId(Integer.parseInt(configureDMCustomDTO
					.getId()));
			try {
				inventoryManagerLocal = getInventoryManagerLocal();
				if (configureDMCustomDTO.isConfigChange()) {
					inventoryManagerLocal
							.removeEEConfigDetails(tempEEDomainDTO);
				}
			} catch (Exception e) {
				//un handle exception
			}
		}
		timeTaken.end();
		return configureDMCustomDTO;
	}

	/**
	 * deleteCustomerList This method deletes the customer list values
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 26, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param deleteCustomerListCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 *
	 */
	public void deleteCustomerList(
			DeleteCustomerListCustomDTO deleteCustomerListCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "deleteCustomerList");

		ProposalCustomDTO proposalCustomDTO = deleteCustomerListCustomDTO
				.getProposal();
		int proposalId = proposalCustomDTO.getId();
		TreeMap customerListsToBeDeleted = deleteCustomerListCustomDTO
				.getSelectedCustomerList();
		CustomerListBOFactory customerListBOFactory = new CustomerListBOFactory();
		Set keySet = customerListsToBeDeleted.keySet();
		Iterator iter = keySet.iterator();
		while (iter.hasNext()) {
			CustomerListCustomDTO customerListCustomDTO = (CustomerListCustomDTO) customerListsToBeDeleted
					.get(iter.next());
			CustomerListBO customerListBO = new CustomerListBO();

			customerListBO.setCustomerListNo(customerListCustomDTO
					.getListNumber());
			customerListBO.setProposalId(proposalId);
			try {
				customerListBOFactory.deleteCustomerListBO(customerListBO);
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}
		}

		log.end();
	}

	/**
	 * deleteTempValues This method deletes the temp values during log out
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 26, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param opptCustomDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 *
	 */
	public void deleteTempValues(OPPTCustomDTO opptCustomDTO)
			throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "deleteTempValues");
		/*
		 * ESWDataFactory eswDataFactory = new ESWDataFactory(); try {
		 * eswDataFactory.deleteESWData(opptCustomDTO.getSessionId(), 0, null); }
		 * catch (DomainException d) { throw
		 * ExceptionGenerator.generateServiceException(d.getErrorReport()); }
		 */
		try {
			ESWDataLocal eswDataLocal = HomeProvider.getESWDataLocal();
			eswDataLocal.deleteESWData(opptCustomDTO.getSessionId(), 0, null);
		} catch (CreateException ce) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"deleteTempValues", null, ce);
			ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		} finally {
			timeTaken.end();
		}

	}

	/**
	 * checkVarianceForReport This method Checks variance for variance report
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 26, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param varianceRptCustomDTO
	 * @throws ServiceException
	 * @author
	 *
	 */
	public void checkVarianceForReport(VarianceRptCustomDTO varianceRptCustomDTO)
			throws ServiceException {
		CheckVarianceInputConnectorDTO checkVarianceInputConnectorDTO = new CheckVarianceInputConnectorDTO();
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
		CheckVarianceOutputConnectorDTO checkVarianceOutputConnectorDTO = new CheckVarianceOutputConnectorDTO();
		String methodName = "checkVarianceForReport";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME,
				"checkVarianceForReport");

		ProposalManagerLocal proposalManagerLocal = null;
		try {
			proposalManagerLocal = HomeProvider.getProposalManagerLocal();
		} catch (CreateException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					methodName, null, ex);
		}

		ProposalContractBO proposalContractBO = new ProposalContractBO();
		proposalContractBO = proposalManagerLocal
				.getProposal(varianceRptCustomDTO.getProposalDTO().getId());

		ContractBO contractBO = new ContractBO();
		contractBO = (ContractBO) proposalContractBO;

		genericConnectorDTO
				.setFunctionModuleName(ConnectorConstants.RFC_CHECK_VARIANCE_OPPT);
		genericConnectorDTO.setSessionID(varianceRptCustomDTO.getSessionId());
		genericConnectorDTO.setUserID(varianceRptCustomDTO.getUserId());

		checkVarianceInputConnectorDTO
				.setGenericConnectorDTO(genericConnectorDTO);
		checkVarianceInputConnectorDTO.setSalesOrg(contractBO.getSalesOrg());

		if (contractBO.getExtContrNo() == null
				|| contractBO.getExtContrNo().equals("")) {
			checkVarianceInputConnectorDTO.setExternalContractNumber(contractBO
					.getContrNo());
		} else {
			checkVarianceInputConnectorDTO.setExternalContractNumber(contractBO
					.getExtContrNo());
		}

		checkVarianceInputConnectorDTO.setIndicatorVarType(contractBO
				.getVarInd());
		checkVarianceInputConnectorDTO.setVarianceDate(contractBO.getVarDate());

		JMSConnectorLocal jmsConnectorLocal = null;
		try {
			jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
		} catch (CreateException ex) {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}

		try {
			checkVarianceOutputConnectorDTO = (CheckVarianceOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(checkVarianceInputConnectorDTO);
		} catch (Exception ex) {
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}

		InventoryManagerLocal inventoryManagerLocal = null;
		List customerDomainDTOList = new ArrayList();
		ProposalDomainDTO proposalDomainDTO;
		CustomerDomainDTO customerDomainDTO;
		if (ConnectorConstants.RFC_SUCCESS_CODE
				.equals(checkVarianceOutputConnectorDTO.getReturnCode())) {
			inventoryManagerLocal = getInventoryManagerLocal();
			proposalDomainDTO = new ProposalDomainDTO(contractBO);
			proposalDomainDTO = inventoryManagerLocal
					.retrieveCustomerForProposal(proposalDomainDTO);
			int decimalValue = 0;
			try {
				ProposalDataManagerLocal proposalDataManagerLocal = HomeProvider
						.getProposalDataManagerLocal();
				if (contractBO.getCurrency() != null) {
					CurrencyDomainDTO currencyDomainDTO = proposalDataManagerLocal
							.getCurrencyInformation(contractBO.getCurrency());
					decimalValue = currencyDomainDTO.getDecimalAllowed();
				}
			} catch (CreateException c) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						methodName, null, c);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0801);
			}
			DomainDTOBuildHelper.populateProposalDomainDTO(proposalDomainDTO,
					checkVarianceOutputConnectorDTO, null, false, decimalValue,
					true);
			customerDomainDTOList = proposalDomainDTO.getCustomerDTOList();
			Iterator iterateCustomer = customerDomainDTOList.iterator();
			while (iterateCustomer.hasNext()) {
				customerDomainDTO = (CustomerDomainDTO) iterateCustomer.next();
				inventoryManagerLocal.storeVarianceInfo(customerDomainDTO);
			}
		}
	}

	/**
	 * approveRequest This method creates Variance Proposal. <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Feb 6, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param varianceHeaderInformationCustomDTO
	 * @return
	 * @throws ServiceException
	 */

	public VarianceHeaderInformationCustomDTO createVarianceProposal(
			VarianceHeaderInformationCustomDTO varianceHeaderInformationCustomDTO)
			throws ServiceException, SQLException {

		TimeTaken log = new TimeTaken(CLASS_NAME, "createVarianceProposal");
		ContractCustomDTO contractCustomDTO = varianceHeaderInformationCustomDTO
				.getContractDTO();
		String proposalName = varianceHeaderInformationCustomDTO
				.getNewProposalName();
		int proposalId = contractCustomDTO.getId();
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ContractBO contractBO = null;
		ProposalContractBO newProposalBO = null;
		ProposalContractBO lastVarianceContractForOriginal = null;
		boolean firstVariance = false;
		SharingBO shareBO = null;
		HashMap compareValues = null;
		try {
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					varianceHeaderInformationCustomDTO, null);
			contractBO = (ContractBO) proposalContractBOFactory
					.getProposalContractBO(proposalId);
			OPPTLogger.debug("Contract Number for Contract :"
					+ contractBO.getContrNo(), CLASS_NAME,
					"createVarianceProposal");
			OPPTLogger.debug("contractBO.getContrPeriodVarNo() = "
					+ contractBO.getContrPeriodVarNo(), CLASS_NAME,
					"createVarianceProposal");
			if (0 == contractBO.getContrPeriodVarNo()) {
				firstVariance = true;
			}
			if (!firstVariance) {
				List contractList = proposalContractBOFactory
						.findLastVarianceContract(contractBO.getContrNo(),
								contractBO.getContrPeriodVarNo());
				if (contractList != null && contractList.size() > 0) {
					for (int k = 0; k < contractList.size(); k++) {
						lastVarianceContractForOriginal = (ProposalContractBO) contractList
								.get(k);
						compareValues
								.put(
										UtilityConstants.BO_STATUS_OF_LAST_CONTRACT,
										lastVarianceContractForOriginal
												.getStatusCode());
						if (lastVarianceContractForOriginal != null
								&& ProposalContractStatusConstants.VARIANCE_CONTRACT
										.equals(lastVarianceContractForOriginal
												.getStatusCode())) {
							OPPTLogger.debug(
									"lastVarianceContractForOriginal.getStatusCode() = "
											+ lastVarianceContractForOriginal
													.getStatusCode(),
									CLASS_NAME, "createVarianceProposal");
							break;
						}
					}
				}
			}
			newProposalBO = PCMBOBuilder
					.createBOForVarianceProposal(contractBO);
			contractBO.validateForCreateVarianceProposal(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);
		} catch (DomainException e1) {
			throw ExceptionGenerator.generateServiceException(e1
					.getErrorReport());
		}
		if (!varianceHeaderInformationCustomDTO.isConfirmationRequired()) {
			// This is a real action
			if (proposalContractBOFactory.isProposalNameExists(proposalName)) {
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0018);
			}
			ProposalContractBO maxBO = null;
			try {
				maxBO = proposalContractBOFactory.findMaxProposalContractBO();
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}
//			Blue Harmony Wave 1 DAD001 - Start - Anand
			int newProposalId = maxBO.getProposalId() + 1;
			int newContractPeriodVarNo = contractBO.getContrPeriodVarNo() + 1;
			String proposalContent1 = contractBO.getProposalContent().equalsIgnoreCase("M")? "MLC" :"SandS"; 
			if ((proposalName== null ||proposalName.trim().equalsIgnoreCase(""))&&contractBO.getAutoPopulate().equalsIgnoreCase(UtilityConstants.NO) ){
				
		//	String customerName = contractBO.getRegCustomerName().substring(0,20).trim();
				int customerNamelength = contractBO.getRegCustomerName().length();
				String customerName =null;
				if (customerNamelength>=20){
				
				 customerName = contractBO.getRegCustomerName().substring(0,20).trim();
				}
				else{
					customerName = contractBO.getRegCustomerName().trim();	
				}
				
				
				
			String salesOrg =  contractBO.getSalesOrg();
			String proposalContent =contractBO.getProposalContent();
			newProposalBO.setSelectedCustomerName(customerName);	
			newProposalBO.setSalesOrg(salesOrg);
			newProposalBO.setProposalContent(proposalContent);
			int proposalCount;
			try{
				
			proposalCount = proposalContractBOFactory.getMaxProposalCount(newProposalBO);
			newProposalBO.setProposalCount(proposalCount);
			
			String newProposalName =	salesOrg+"_"+customerName+"_"+proposalContent1+"_"+proposalCount+"_CAP_"+newContractPeriodVarNo;
			newProposalBO.setProposalName(newProposalName);
			newProposalBO.setAutoPopulate(UtilityConstants.YES);
			varianceHeaderInformationCustomDTO.setNewProposalName(newProposalName);
		
			} catch (DomainException  ex){}
			
			}
		else if ((proposalName== null ||proposalName.trim().equalsIgnoreCase(""))&&contractBO.getAutoPopulate().equalsIgnoreCase(UtilityConstants.YES) ){
			// system.out.println("Inside elseif  " );
			//0147_ABC_MLC_1_RNW_2_RPL_1 or 0147_ABC_MLC_1_RPL_1  0147_ABC_MLC_1_RNW_2
			
		int renewindex = 	contractBO.getProposalName().lastIndexOf("_RNW_");
		int replaceindex = contractBO.getProposalName().lastIndexOf("_RPL_");
		String newProposalName =null;
		if (renewindex== -1 && replaceindex == -1  ){
		
			newProposalName = contractBO.getProposalName()+"_CAP_"+newContractPeriodVarNo;
			newProposalBO.setProposalName(newProposalName);
			newProposalBO.setAutoPopulate(UtilityConstants.YES);
			// system.out.println("newProposalName"  +newProposalName);
		//	varianceHeaderInformationCustomDTO.setNewProposalName(newProposalName);
		
		}
		else if(replaceindex!= -1 && renewindex== -1){
			//0147_ABC_MLC_1_RNW_1
		String  oldProposalName = contractBO.getProposalName().substring(0,contractBO.getProposalName().lastIndexOf("_RPL_"));
		// system.out.println("orgProposalBO.getProposalName()  " +contractBO.getProposalName());
		// system.out.println("oldProposalName    "   +oldProposalName);
		 newProposalName = oldProposalName+"_CAP_"+newContractPeriodVarNo;
		newProposalBO.setProposalName(newProposalName);
		newProposalBO.setAutoPopulate(UtilityConstants.YES);
	//	varianceHeaderInformationCustomDTO.setNewProposalName(newProposalName);
		}
		
		else {
			String  oldProposalName = contractBO.getProposalName().substring(0,contractBO.getProposalName().lastIndexOf("_RNW_"));
			// system.out.println("orgProposalBO.getProposalName()  " +contractBO.getProposalName());
			// system.out.println("oldProposalName    "   +oldProposalName);
			 newProposalName = oldProposalName+"_CAP_"+newContractPeriodVarNo;
			 newProposalBO.setProposalName(newProposalName);
			 newProposalBO.setAutoPopulate(UtilityConstants.YES);
			// varianceHeaderInformationCustomDTO.setNewProposalName(newProposalName);
			
		
		
		}
		
		
		
		
			}	
			else {
				// system.out.println("Inside wrong else");
				newProposalBO.setProposalName(proposalName);
				newProposalBO.setAutoPopulate(UtilityConstants.NO);
			}

//			Blue Harmony Wave 1 DAD001 - End - Anand
			//newProposalBO.setProposalName(proposalName);
			newProposalBO.setProposalId(newProposalId);
			newProposalBO.setContrEndPeriod((new java.sql.Date(
					varianceHeaderInformationCustomDTO.getVarianceDate()
							.getTime())));
			newProposalBO.setContrType(ContractTypeConstants.VARIANCE);
			newProposalBO.setBillingFreqCode("A");
		//	int newContractPeriodVarNo = contractBO.getContrPeriodVarNo() + 1;
			//	newProposalBO.setContrPeriodVarNo(ProposalContractDAO.getMaxContrPeriodVarNo(contractBO.getContrNo().substring(0,
			// 7).concat("V")));
			newProposalBO.setContrPeriodVarNo(newContractPeriodVarNo);
			OPPTLogger.debug("newProposalBO.getContrPeriodVarNo() = "
					+ newProposalBO.getContrPeriodVarNo(), CLASS_NAME,
					"createVarianceProposal");
			contractBO.setContrPeriodVarNo(newContractPeriodVarNo);
			OPPTLogger.debug("contractBO.getContrPeriodVarNo() = "
					+ contractBO.getContrPeriodVarNo(), CLASS_NAME,
					"createVarianceProposal");
			newProposalBO.setContrVarNo(contractBO.getContrVarNo());
			OPPTLogger.debug("contractBO.getContrVarNo() = "
					+ contractBO.getContrVarNo(), CLASS_NAME,
					"createVarianceProposal");
			String newContractVarNo = String.valueOf((Integer
					.parseInt(contractBO.getContrVarNo()) + 1));
			contractBO.setContrVarNo(newContractVarNo);
			OPPTLogger.debug("contractBO.getContrVarNo() = "
					+ contractBO.getContrVarNo(), CLASS_NAME,
					"createVarianceProposal");
			contractBO
					.setStatusCode(ProposalContractStatusConstants.VARIANCE_IN_PROGRESS);
			newProposalBO.setStatusCode(ProposalContractStatusConstants.DRAFT);
			String contractNumberAppender = "";
			if (newContractPeriodVarNo >= 10) {
				contractNumberAppender = (contractNumberAppender.concat("V"))
						.concat(contractBO.getContrVarNo());
			} else {
				contractNumberAppender = (contractNumberAppender.concat("V0"))
						.concat(contractBO.getContrVarNo());
			}
			String newContractNumber = (contractBO.getContrNo().substring(0, 7))
					.concat(contractNumberAppender);
			OPPTLogger.debug("New Contract Number for Variance Proposal is :"
					+ newContractNumber, CLASS_NAME, "createVarianceProposal");
			newProposalBO.setContrNo(newContractNumber);
			newProposalBO.setCreatedBy(varianceHeaderInformationCustomDTO
					.getUserId());
			newProposalBO.setLockedBy(varianceHeaderInformationCustomDTO
					.getUserId());
			newProposalBO.setOrgVarContrNo(contractBO.getContrNo());
			newProposalBO.setProposalContent(contractBO.getProposalContent());
			// Contract Period start date rules
			newProposalBO.setContrStartPeriod(contractBO.getContrStartPeriod());
			if (!firstVariance && null != lastVarianceContractForOriginal
					&& null != lastVarianceContractForOriginal.getVarDate()) {
				java.sql.Date contractPeriodStDate = OPPTCalender
						.getDayPlusOneSqlDate(lastVarianceContractForOriginal
								.getVarDate());
				newProposalBO.setContrStartPeriod(contractPeriodStDate);
			}
			CopyInventoryDomainDTO copyInventoryDomainDTO = new CopyInventoryDomainDTO();
			copyInventoryDomainDTO
					.setActionName(ActionNameConstants.CREATE_VARIANCEPROPOSAL);
			copyInventoryDomainDTO.setOldProposalID(contractBO.getProposalId());
			copyInventoryDomainDTO.setNewProposalID(newProposalBO
					.getProposalId());
			try {
				//UDChanges
				newProposalBO.setGroupName(contractBO.getGroupName());

				proposalContractBOFactory
						.createProposalContractBO(newProposalBO);
				proposalContractBOFactory.updateProposalContractBO(contractBO);
				copyCustomerList(copyInventoryDomainDTO);
			} catch (DomainException e2) {
				throw ExceptionGenerator.generateServiceException(e2
						.getErrorReport());
			}
			HashMap values = new HashMap();
			values.put(UtilityConstants.PLAN_START_DATE, newProposalBO
					.getContrStartPeriod());
			values.put(UtilityConstants.PLAN_END_DATE, newProposalBO
					.getContrEndPeriod());
			copyInventoryDomainDTO.setValues(values);

			getInventoryManagerLocal().copyInventory(copyInventoryDomainDTO);
			// NOW we should update the esw price of EE and Licence
			ProposalDomainDTO proposalDomainDTO = new ProposalDomainDTO();
			proposalDomainDTO.setProposalId(newProposalBO.getProposalId());
			getInventoryManagerLocal().updateESWPriceForVarianceProposal(
					proposalDomainDTO);
			createAccessHistory(newProposalBO.getProposalId(),
					varianceHeaderInformationCustomDTO.getUserId(),
					"Variance proposal created");
			
				

			contractCustomDTO.setId(newProposalBO.getProposalId());
			contractCustomDTO.setName(newProposalBO.getProposalName());
			contractCustomDTO.setLockedBy(newProposalBO.getLockedBy());
			contractCustomDTO.setOldContractNumber(newProposalBO
					.getOldContrNo());
			contractCustomDTO.setStatus(newProposalBO.getStatusCode());
			contractCustomDTO.setType(newProposalBO.getProposalType());
			varianceHeaderInformationCustomDTO
					.setContractDTO(contractCustomDTO);
		}
		log.end();
		return varianceHeaderInformationCustomDTO;
	}

	/**
	 * approveRequest Processes the request for approval
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 27, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param approveInfo
	 * @throws ServiceException
	 */
	public void approveRequest(ProposalCustomDTO approveInfo)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "approveRequest");
		ProposalContractBOFactory[] factories = null;
		ProposalContractBO proposalContractForApproval = null;
		HashMap compareValues = null;
		ContractBO relatedContract = null;
		boolean result = false;
		String operationPerformed = "Approve Request";
		String errorCodeFromBE = null;
		boolean changeRelatedContractStatusRequired = false;

		try {
			factories = new ProposalContractBOFactory[1];
			proposalContractForApproval = getProposalContractBOFromFactory(factories, approveInfo.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(approveInfo, null);
//			 Commented for the change DAD O11 Remove approval step,Blue Harmony -Ramesh Gandi
			//proposalContractForApproval.validateRequestForApproveOrReject(UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		if (approveInfo.isConfirmationRequired()) {
			return;
		} else {
			try {
				boolean createContract = isCreationRequired(proposalContractForApproval);
				boolean changeContract = isChangeRequired(proposalContractForApproval);
				OPPTLogger.debug("In approveRequest():createContract:"+createContract, CLASS_NAME, "approveRequest");
				OPPTLogger.debug("approveRequest():changeContract:"+changeContract, CLASS_NAME, "approveRequest");
				proposalContractForApproval.checkAndSetAfterRequestApproval();
				OPPTLogger.debug("proposalContractForApproval.getStatus = "
						+ proposalContractForApproval.getStatusCode(),
						CLASS_NAME, "approveRequest");
				if (proposalContractForApproval instanceof ProposalBO) {
					OPPTLogger
							.debug(
									"proposalContractForApproval instanceof ProposalBO",
									CLASS_NAME, "approveRequest");
					ProposalBO proposal = (ProposalBO) proposalContractForApproval;
					String relatedCntrNumber = null;
					if (proposal.isVarianceProposal()) {
						relatedCntrNumber = proposal.getOrgVarContrNo();
						changeRelatedContractStatusRequired = true;
					} else if (proposal.isRenewalProposal()
							|| proposal.isReplacementProposal()) {
						relatedCntrNumber = proposal.getOldContrNo();
						changeRelatedContractStatusRequired = true;
						OPPTLogger.debug("ProposalManagerBean.approveRequest().renewal&Replace proposal", CLASS_NAME, "approveRequest");
					}
					if (changeRelatedContractStatusRequired) {
						relatedContract = (ContractBO) factories[0]
								.getProposalContractBOForContractNumber(
										relatedCntrNumber, true);
						relatedContract.checkAndSetAfterRequestApproval();
					}
				} else {
					if (proposalContractForApproval.isContractInAmendment()) {
						OPPTLogger.debug("ProposalManagerBean.approveRequest().isContractInAmendment()", CLASS_NAME, "approveRequest");
						relatedContract = (ContractBO) factories[0].getProposalContractBOForContractNumber(proposalContractForApproval.getOldContrNo(), true);	
					}
				}

				CreateContractInputConnectorDTO createContractConnDTO = null;
				ChangeContractInputConnectorDTO changeContractConnDTO = null;
				ChangeCreateContractInputConnectorDTO changeCreateContractConnDTO = null;
				OPPTLogger.debug("createContract =" + createContract,
						CLASS_NAME, "approveRequest");
				if (createContract) {
					SWODTOFactory swoDTOFactory = new SWODTOFactory();
					ProposalDomainDTO proposalDomain = new ProposalDomainDTO(
							proposalContractForApproval);
					CreateContractEEDomainDTO[] createContractLicenses = swoDTOFactory
							.retrieveLicensesForContractCreation(proposalDomain);
					List customerLists = null;
					try {
						customerLists = getCustomerList(proposalContractForApproval
								.getProposalId());
						OPPTLogger.debug("customerLists =" + customerLists,
								CLASS_NAME, "approveRequest");
					} catch (DomainException e) {
						throw ExceptionGenerator.generateServiceException(e
								.getErrorReport());
					}
					createContractConnDTO = PCMConnectorDTOBuilder
							.buildCreateContractInputConnectorDTO(
									proposalContractForApproval, customerLists,
									createContractLicenses, approveInfo
											.getSessionId(), approveInfo
											.getUserId());
				}

				if (changeContract) {
					changeContractConnDTO = processChangeContract(
							proposalContractForApproval, relatedContract,
							approveInfo);
				}
				if (createContract && changeContract) {
					changeCreateContractConnDTO = processChangeCreateContract(
							createContractConnDTO, changeContractConnDTO);
				}

				try {
					JMSConnectorLocal jmsConnectorLocal = HomeProvider
							.getJMSConnectorLocal();
					if (changeContract && !createContract) {
						ChangeContractOutputConnectorDTO outputConnDTO = (ChangeContractOutputConnectorDTO) jmsConnectorLocal
								.sendReceive(changeContractConnDTO);
						if (outputConnDTO != null) {
							errorCodeFromBE = outputConnDTO.getIReturnCode();
						}
					} else if (createContract && !changeContract) {
						CreateContractOutputConnectorDTO createOuputConnDTO = (CreateContractOutputConnectorDTO) jmsConnectorLocal
								.sendReceive(createContractConnDTO);
						if (createOuputConnDTO != null) {
							errorCodeFromBE = createOuputConnDTO
									.getReturnCode();
						}
					} else if (createContract && changeContract) {
						ChangeContractOutputConnectorDTO outputConnDTO = (ChangeContractOutputConnectorDTO) jmsConnectorLocal
								.sendReceive(changeCreateContractConnDTO);
						if (outputConnDTO != null) {
							errorCodeFromBE = outputConnDTO.getIReturnCode();
						}
					}
					if (ConnectorConstants.RFC_SUCCESS_CODE
							.equals(errorCodeFromBE)) {
						result = true;
					} else {
						if (errorCodeFromBE != null
								&& !errorCodeFromBE.equals("")) {
							storeErrorList(
									errorCodeFromBE,
									proposalContractForApproval.getProposalId(),
									approveInfo.getUserId(), "Approve Proposal");
						}
						result = false;
					}
				} catch (ConnectorException e) {
					getSessionContext().setRollbackOnly();
					throw ExceptionGenerator.generateServiceException(e
							.getErrorReport());
				} catch (Exception e) {
					OPPTLogger
							.debug(e.toString(), CLASS_NAME, "approveRequest");
					result = false;
				}
			} catch (DomainException e) {
				getSessionContext().setRollbackOnly();
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			} catch (ServiceException e) {
				getSessionContext().setRollbackOnly();
				throw ExceptionGenerator.generateServiceException(e
						.getErrorReport());
			}
			OPPTLogger.debug("result =" + result, CLASS_NAME, "approveRequest");
			if (result) {
				/**
				 * Changed By Balaji for EF EF0524044224
				 */
				try {
					factories[0]
							.updateProposalContractBO(proposalContractForApproval);
					if (changeRelatedContractStatusRequired) {
						factories[0].updateProposalContractBO(relatedContract);
					}
					/*createAccessHistory(approveInfo.getId(), approveInfo
							.getUserId(), operationPerformed);
					*/
					OPPTLogger.debug("Access History Created", CLASS_NAME,
							"approveRequest");
				} catch (DomainException e) {
					getSessionContext().setRollbackOnly();
					throw ExceptionGenerator.generateServiceException(e
							.getErrorReport());
				}
//This code is belongs to mailing so it has commetned for the change DAD O11 Remove approval step,Blue Harmony -Ramesh Gandi
/*				int type = 0;
				if (proposalContractForApproval.isProposal()) {
					type = UtilityConstants.MAIL_PROP_APPV;
				} else if (ContractTypeConstants.VARIANCE
						.equals(proposalContractForApproval.getContrType())
						&& ProposalContractStatusConstants.CHECK_CLOSURE_STATUS
								.equals(proposalContractForApproval
										.getStatusCode())) {
					type = UtilityConstants.MAIL_CLS_CNTR_APPV;
				} else {
					type = UtilityConstants.MAIL_CNTR_APPV;
				}
				MailConnectorDTO mailCarrier = PCMConnectorDTOBuilder
						.buildMailConnectorDTO(proposalContractForApproval,
								approveInfo.getEmailAddress(),
								proposalContractForApproval.getSubmittedBy(),
								type);
				CommunicationConnector mailSender = new CommunicationConnector();
				try {
					mailSender.sendMail(mailCarrier);
					OPPTLogger.debug("MAIL SENT SUCCESFULY ", CLASS_NAME,
							"approveRequest");
				} catch (ConnectorException e) {
					//Exception is not thrown as mail is not a key part
					OPPTLogger.log("MAIL_SERVICE_EXCEPTION", OPPTLogger.ERROR,
							CLASS_NAME, "approveRequest", null, e);
					approveInfo.setMessageReport(ExceptionGenerator
							.addErrorEntry(null, ErrorCodeConstants.SE0802,
									OPPTMessageCatalog.TYPE_SERVICE));
				} catch (Exception e) {
					//Exception is not thrown as mail is not a key part
					OPPTLogger.log("MAIL_SERVICE_EXCEPTION", OPPTLogger.ERROR,
							CLASS_NAME, "approveRequest", null, e);
					approveInfo.setMessageReport(ExceptionGenerator
							.addErrorEntry(null, ErrorCodeConstants.SE0802,
									OPPTMessageCatalog.TYPE_SERVICE));
				}
*/
			} else {
				getSessionContext().setRollbackOnly();
				ErrorReport errorReport = null;
				if (errorCodeFromBE != null && !errorCodeFromBE.equals("")) {
					errorReport = ExceptionGenerator.getErrorReport(
							errorCodeFromBE, OPPTMessageCatalog.TYPE_BACKEND);
				} else {
					errorReport = ExceptionGenerator.getErrorReport(
							ErrorCodeConstants.SE0801,
							OPPTMessageCatalog.TYPE_SERVICE);
				}
				// added exception
				throw ExceptionGenerator.generateServiceException(errorReport);
			}
		}

		log.end();
	}


	/**
	 * processChangeContract Processes the request for change contract
	 *
	 * <br>
	 * <b>Known Bugs </b> <br>
	 *
	 * <br>
	 *
	 * <PRE>
	 *
	 * date Jan 28, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE>
	 *
	 * <br>
	 *
	 * @param proposalContract
	 * @param relatedContract
	 * @param customDTO
	 * @return ChangeContractInputConnectorDTO
	 */
	private ChangeContractInputConnectorDTO processChangeContract(
			ProposalContractBO proposalContract, ContractBO relatedContract,
			OPPTCustomDTO customDTO) {
		Date changeDate = null;
		int changeCounter = 0;
		String eswStatus = null;
		ProposalContractBO changeContract = null;
		String cntrType = proposalContract.getContrType();

		if (ContractTypeConstants.AMENDMENT.equals(cntrType)) {
			if (isOldExconSameAsNewExcon(proposalContract, relatedContract)) {
				changeCounter = (new Double(proposalContract.getContrAmendNo()))
						.intValue();
			}
			changeDate = proposalContract.getAmendEffectiveDate();
			eswStatus = UtilityConstants.ESW_STATUS_RECL;
			changeContract = relatedContract;
		} else if (ContractTypeConstants.EXTENDED.equals(cntrType)) {
			changeDate = proposalContract.getContrExtDate();
			eswStatus = UtilityConstants.ESW_STATUS_EXTN;
			changeContract = proposalContract;
		} else if (ContractTypeConstants.RENEWAL.equals(cntrType)) {
			changeDate = relatedContract.getContrEndPeriod();
			if (isOldExconSameAsNewExcon(proposalContract, relatedContract)) {
				changeCounter = (new Double(proposalContract.getContrRenewNo()))
						.intValue();
			}
			eswStatus = UtilityConstants.ESW_STATUS_RENW;
			changeContract = relatedContract;
		} else if (ContractTypeConstants.REPLACEMENT.equals(cntrType)) {
			changeDate = relatedContract.getContrReplDate();
			if (changeDate != null) {
				changeDate = OPPTCalender.getDayMinusOneSqlDate(changeDate);
			}
			if (isOldExconSameAsNewExcon(proposalContract, relatedContract)) {
				changeCounter = (new Double(proposalContract.getContrReplNo()))
						.intValue();
			}
			eswStatus = UtilityConstants.ESW_STATUS_REPL;
			changeContract = relatedContract;
		} else if (ContractTypeConstants.VARIANCE.equals(cntrType)) {
			changeCounter = proposalContract.getContrPeriodVarNo();
			changeDate = proposalContract.getContrClsDate();
			eswStatus = UtilityConstants.ESW_STATUS_CLSD;
			changeContract = proposalContract;
		}

		return PCMConnectorDTOBuilder.buildChangeContractInputConnectorDTO(
				changeContract, changeCounter, customDTO.getSessionId(),
				customDTO.getUserId(), changeDate, eswStatus);
	}

	/**
	 * isOldExconSameAsNewExcon
	 * Checks whether the external contract number of new and old are same
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Mar 31, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param newContract
	 * @param oldContract
	 * @return
	 */
	private boolean isOldExconSameAsNewExcon(ProposalContractBO newContract,
			ProposalContractBO oldContract) {
		boolean result = false;
		if (oldContract.getExtContrNo() != null
				&& !oldContract.getExtContrNo().equals("")) {
			if (oldContract.getExtContrNo().equals(newContract.getExtContrNo())) {
				return true;
			}
		}
		return result;
	}

	/*
	 * Create the Connector DTO
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Mar 12, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param create
	 * @param change
	 * @return ChangeCreateContractInputConnectorDTO
	 */
	private ChangeCreateContractInputConnectorDTO processChangeCreateContract(
			CreateContractInputConnectorDTO create,
			ChangeContractInputConnectorDTO change) {
		ChangeCreateContractInputConnectorDTO changeCreate = new ChangeCreateContractInputConnectorDTO();
		changeCreate.setChangeContractDTO(change);
		changeCreate.setCreateContractDTO(create);
		return changeCreate;
	}

	/**
	 * isCreationRequired
	 * Verifies whether contract creation is required
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Jan 28, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param proposalContract
	 * @return boolean
	 */
	private boolean isCreationRequired(ProposalContractBO proposalContract) {
		String cntrType = proposalContract.getContrType();
		if (ContractTypeConstants.EXTENDED.equals(cntrType)
				|| (ContractTypeConstants.VARIANCE.equals(cntrType) && ProposalContractStatusConstants.VARIANCE_CLOSURE_PENDING_APROVAL
						.equals(proposalContract.getStatusCode()))) {
			return false;
		}
		return true;
	}

	/**
	 * isChangeRequired
	 * Verifies whether contract change is needed
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Jan 28, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param proposalContract
	 * @return boolean
	 */
	private boolean isChangeRequired(ProposalContractBO proposalContract) {
		String cntrType = proposalContract.getContrType();
		OPPTLogger.debug("Contract Type = " + cntrType, CLASS_NAME,
				"isChangeRequired");
		if (ContractTypeConstants.ORIGINAL.equals(cntrType)
				|| (ContractTypeConstants.VARIANCE.equals(cntrType) && ProposalContractStatusConstants.PRICED
						.equals(proposalContract.getStatusCode()))) {
			return false;
		}
		return true;
	}

	/**
	 * removeQuotes
	 * Removes Quotes from the proposal
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Feb 14, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param proposalInformation
	 * @return ProposalCustomDTO
	 * @throws ServiceException
	 * @author Saravanan Viswanathan
	 */
	public void removeQuotes(ProposalCustomDTO proposalCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "removeQuotes");
		ProposalContractBO proposalContractBO = null;
		SharingBO shareBO = null;
		HashMap compareValues = null;
		String transactionName = proposalCustomDTO.getTransactionName();
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		boolean resultvalue = false;

		try {
			shareBO = getSharingBOFromFactory(proposalCustomDTO.getId(),
					proposalCustomDTO.getUserId());
			proposalContractBO = getProposalContractBOFromFactory(proposalCustomDTO
					.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					proposalCustomDTO, shareBO);
			proposalContractBO.validateForRemoveQuotes(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"removeQuotes", null, e);
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		if (!proposalCustomDTO.isConfirmationRequired()) {
			try {
				InventoryManagerLocal inventoryManagerLocal = getInventoryManagerLocal();
				ProposalDomainDTO proposalDomainDTO = new ProposalDomainDTO();
				proposalDomainDTO.setProposalId(proposalContractBO
						.getProposalId());
				resultvalue = inventoryManagerLocal
						.removeQuotes(proposalDomainDTO);
			} catch (ServiceException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
						"removeQuotes", null, e);
				getSessionContext().setRollbackOnly();
				throw e;
			}
			if (resultvalue) {
				if (proposalContractBO instanceof ProposalBO) {
					proposalContractBO
							.setStatusCode(ProposalContractStatusConstants.DRAFT);
				} else {
					proposalContractBO
							.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
				}
				try {
					proposalContractBOFactory
							.updateProposalContractBO(proposalContractBO);
				} catch (DomainException e) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
							"removeQuotes", null, e);
					getSessionContext().setRollbackOnly();
					throw ExceptionGenerator.generateServiceException(e
							.getErrorReport());
				}
			}
		}
		log.end();
	}

	/**
	 * fetchSAndSDetails
	 * Fetch S&S Details for the Proposal
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Feb 21, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param sAndSInformation
	 * @return SAndSDetailsCustomDTO
	 * @throws ServiceException
	 * @author Saravanan Viswanathan
	 */

	public SAndSDetailsCustomDTO fetchSAndSDetails(
			SAndSDetailsCustomDTO sAndSInformation) throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "fetchSAndSDetails");
		ProposalContractBO proposalContractBO = null;
		SharingBO shareBO = null;
		HashMap compareValues = null;
		String transactionName = sAndSInformation.getTransactionName();
		List dmList = new ArrayList();
		List swoList = new ArrayList();
		List swoDomainDTOList = new ArrayList();
		SWOCustomDTO swoCustomDTO = null;
		DMDomainDTO[] dmDomainDTOArray = null;
		SWODomainDTO[] swoDomainDTOArray = null;
		SAndSDetailsCustomDTO sAndSDetailsCustomDTO = null;
		int swoCount = 0;
		ProposalCustomDTO proposalCustomDTO = new ProposalCustomDTO();
		proposalCustomDTO = sAndSInformation.getProposal();
		proposalCustomDTO.setUserId(sAndSInformation.getUserId());
		try {
			shareBO = getSharingBOFromFactory(proposalCustomDTO.getId(),
					proposalCustomDTO.getUserId());
			proposalContractBO = getProposalContractBOFromFactory(proposalCustomDTO
					.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					proposalCustomDTO, shareBO);
			proposalContractBO.validateForSAndS(
					UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchSAndSDetails", null, e);
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		// Get list of DMCustomDTO and SWOCustomDTO from SAndSDetailsCustomDTO
		dmList = sAndSInformation.getDMs();
		swoList = sAndSInformation.getSwos();

		if (dmList != null && swoList != null) {
			for (int x = 0; x < dmList.size(); x++) {
				for (int y = 0; y < swoList.size(); y++) {
					DMCustomDTO tempDMCustomDTO = (DMCustomDTO) dmList.get(x);
					SWOCustomDTO tempSWOCustomDTO = (SWOCustomDTO) swoList
							.get(y);
					if (tempDMCustomDTO.getId() == tempSWOCustomDTO.getDMId()) {
						swoList.remove(y);
					}
				}
			}
		}

		DMCustomDTO[] dmCustomDTOArray = new DMCustomDTO[0];
		SWOCustomDTO[] swoCustomDTOArray = new SWOCustomDTO[0];

		// Get array of DMCustomDTO and SWOCustomDTO
		if (dmList != null) {
			dmCustomDTOArray = (DMCustomDTO[]) dmList.toArray(dmCustomDTOArray);
		}
		if (swoList != null) {
			swoCustomDTOArray = (SWOCustomDTO[]) swoList
					.toArray(swoCustomDTOArray);
		}

		//	Build list of DMDomainDTO and SWODomainDTO from CustomDTO
		dmDomainDTOArray = DomainDTOBuildHelper
				.buildDMDomainDTOsWithIDFromCustomDTO(dmCustomDTOArray,
						transactionName);
		swoDomainDTOArray = DomainDTOBuildHelper
				.buildSWODomainDTOsWithIDFromCustomDTO(swoCustomDTOArray,
						transactionName);

		try {
			InventoryManagerLocal inventoryManagerLocal = getInventoryManagerLocal();
			// Here we get the list of SWODomainDTO's which are valid for S&S planning process
			swoDomainDTOList = inventoryManagerLocal.fetchSAndSDetails(
					dmDomainDTOArray, swoDomainDTOArray);
			// Here we call populate method in PCMCustomDTOBuilder to populate TreeMap and set it for SAndSDetailsCustomDTO which will then be sent to FE
			sAndSDetailsCustomDTO = PCMCustomDTOBuilder
					.populateSAndSEECustomDTOFromSWODomainDTO(swoDomainDTOList,
							sAndSDetailsCustomDTO);
		} catch (ServiceException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"fetchSAndSDetails", null, e);
			getSessionContext().setRollbackOnly();
			throw e;
		}
		log.end();
		return sAndSDetailsCustomDTO;
	}

	/**
	 * applySAndSDiscount
	 * Apply discount percent to all selected EE's
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Feb 21, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param sAndSPlanningCustomDTO
	 * @throws ServiceException
	 * @author Saravanan Viswanathan
	 */

	public void applySAndSDiscount(SAndSPlanningCustomDTO sAndSPlanningCustomDTO)
			throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME, "applySAndSDiscount");
		ProposalContractBO proposalContractBO = null;
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		SharingBO shareBO = null;
		HashMap compareValues = null;
		String transactionName = sAndSPlanningCustomDTO.getTransactionName();
		ProposalCustomDTO proposalCustomDTO = new ProposalCustomDTO();
		proposalCustomDTO = sAndSPlanningCustomDTO.getProposal();
		proposalCustomDTO.setUserId(sAndSPlanningCustomDTO.getUserId());
		try {
			shareBO = getSharingBOFromFactory(proposalCustomDTO.getId(),
					proposalCustomDTO.getUserId());
			proposalContractBO = getProposalContractBOFromFactory(proposalCustomDTO
					.getId());
			compareValues = populateCompareValuesForUserAuthInProposalBO(
					proposalCustomDTO, shareBO);
			//proposalContractBO.validateForRemoveQuotes(UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, compareValues);
			if (proposalContractBO instanceof ProposalBO) {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT);
			} else {
				proposalContractBO
						.setStatusCode(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT);
			}
			proposalContractBO.setSAndsDiscount(0);
			proposalContractBOFactory
					.updateProposalContractBO(proposalContractBO);
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"applySAndSDiscount", null, e);
			getSessionContext().setRollbackOnly();
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		}

		try {
			SAndSEECustomDTO[] sAndSEECustomDTOArray = sAndSPlanningCustomDTO
					.getSelectedEE();
			EEDomainDTO[] eeDomainDTOArray = new EEDomainDTO[sAndSEECustomDTOArray.length];
			proposalCustomDTO = sAndSPlanningCustomDTO.getProposal();
			for (int x = 0; x < sAndSEECustomDTOArray.length; x++) {
				eeDomainDTOArray[x] = new EEDomainDTO();
				eeDomainDTOArray[x].setProposalId(proposalCustomDTO.getId());
				eeDomainDTOArray[x].setCustomerId(sAndSEECustomDTOArray[x]
						.getSoldToPartyId());
				eeDomainDTOArray[x].setDmId(sAndSEECustomDTOArray[x].getDMId());
				eeDomainDTOArray[x].setSwoId(sAndSEECustomDTOArray[x]
						.getSWOId());
				eeDomainDTOArray[x].setEeId(sAndSEECustomDTOArray[x].getId());
			}
			InventoryManagerLocal inventoryManagerLocal = getInventoryManagerLocal();
			inventoryManagerLocal.applySAndSDiscount(eeDomainDTOArray,
					sAndSPlanningCustomDTO.getSAndSDiscount());
		} catch (ServiceException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"applySAndSDiscount", null, e);
			getSessionContext().setRollbackOnly();
			throw e;
		}
		log.end();
	}

	/**
	 * removeAlternatePartner
	 * Removes alternate partner
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Feb 21, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 * @param proposalBO
	 * @return void
	 * @throws ServiceException
	 * @author Saravanan Viswanathan
	 */
	private void removeAlternatePartner(ProposalBO proposalBO)
			throws ServiceException {

		InventoryManagerLocal invLocal = getInventoryManagerLocal();
		ProposalDomainDTO proposalDomainDTO = new ProposalDomainDTO();
		proposalDomainDTO.setProposalId(proposalBO.getProposalId());
		proposalDomainDTO = invLocal
				.retrieveCustomerForProposal(proposalDomainDTO);
		List customerList = proposalDomainDTO.getCustomerDTOList();
		try {
			for (int i = 0; i < customerList.size(); i++) {
				CustomerDomainDTO customerDomainDTO = (CustomerDomainDTO) customerList
						.get(i);
				if (customerDomainDTO.getCustomerListNo() == null
						|| customerDomainDTO.getCustomerListNo().trim()
								.length() == 0) {
					// Can be alternate Partner
					if (proposalBO.getRegCustomerNo().equals(
							customerDomainDTO.getSapCustomerNo().trim())) {
						continue;
					}
					invLocal.removeCustomerDetail(customerDomainDTO);
				}
			}
		} catch (ServiceException se) {
			try {
				getSessionContext().setRollbackOnly();
			} catch (IllegalStateException ile) {
				// Nothing will be done
			}
			throw se;
		}
	}

	/**
	 * findProposalsCreatedFromGroup
	 * Apply discount percent to all selected EE's
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Feb 21, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param userId
	 * @param groupName
	 * @param role
	 * @return ProposalDomainDTO []
	 * @throws ServiceException
	 * @author Saravanan Viswanathan
	 */

	public ProposalDomainDTO[] findProposalsCreatedFromGroup(String userId,
			String groupName, int role) throws ServiceException {

		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalContractBO proposalContractBO[] = proposalContractBOFactory
				.findProposalsCreatedFromGroup(userId, groupName, role);
		ProposalDomainDTO proposalDomainDTO[] = null;
		if (proposalContractBO != null) {
			proposalDomainDTO = new ProposalDomainDTO[proposalContractBO.length];
			for (int i = 0; i < proposalContractBO.length; i++) {
				proposalDomainDTO[i] = new ProposalDomainDTO(
						proposalContractBO[i]);
			}
		}
		return proposalDomainDTO;

	}

	private void validateAlternateAmount(String salesOrg, double altPrice)
			throws ServiceException {
		ErrorReport errorReport = new ErrorReport();
		if ((SalesOrgConstants.JAPAN.equals(OPPTHelper.trimString(salesOrg)))
				|| (SalesOrgConstants.KOREA.equals(OPPTHelper
						.trimString(salesOrg)))) {
			if ((-1 != altPrice)
					&& (!OPPTHelper.validNumberRangeForJapan(altPrice))) {
				errorReport = ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.SE0712,
						OPPTMessageCatalog.TYPE_SERVICE);
			}
			if (OPPTHelper.decimalCheck(altPrice)) {
				errorReport = ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.SE0709,
						OPPTMessageCatalog.TYPE_SERVICE);
			}
		} 
		
		else if(SalesOrgConstants.VIETNAM.equals(OPPTHelper.trimString(salesOrg))){
		if ((-1 != altPrice)
				&& (!OPPTHelper.validNumberRangeForVietnam(altPrice))) {
			errorReport = ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.SE0714,
					OPPTMessageCatalog.TYPE_SERVICE);
		}
		if (OPPTHelper.decimalCheck(altPrice)) {
			errorReport = ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.SE0713,
					OPPTMessageCatalog.TYPE_SERVICE);
		}
	} 
		
		else {
			if ((-1 != altPrice) && (!OPPTHelper.validNumberRange(altPrice))) {
				errorReport = ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.SE0707,
						OPPTMessageCatalog.TYPE_SERVICE);
			}
		}
		if (errorReport.size() > 0) {
			throw ExceptionGenerator.generateServiceException(errorReport);
		}
	}

	/* New method for validations of replacement or renewal.
	 * This is to stop users using 2 browsers and do 2 renewals or replacements
	 * Balaji Defect 91
	 *
	 */
	private void validateContractForReplacementRenewal(
			ProposalContractBO proposalContractBO) throws ServiceException {
		if (ProposalContractStatusConstants.REPLACEMENT_IN_PROGRESS
				.equals(proposalContractBO.getStatusCode())
				|| ProposalContractStatusConstants.RENEWAL_IN_PROGRESS
						.equals(proposalContractBO.getStatusCode())) {
			ServiceException ex = new ServiceException();
			ErrorEntry entry = new ErrorEntry(new String[] { proposalContractBO
					.getContrNo() });
			ErrorReport report = ex.getErrorReport();
			report.addErrorEntry(new ErrorKey(ErrorCodeConstants.SE0039,
					OPPTMessageCatalog.TYPE_SERVICE), entry);
			throw ex;
		}
	}

	/*Begin change CR6153*/
	private static void populateInventoryForAllYears(
			ProposalDomainDTO proposalDomainDTO) {
		//System.out.println("ProposalManagerBean.populateInventoryForAllYears()");
		List list = proposalDomainDTO.getCustomerDTOList();
		CustomerDomainDTO customerDTO1, customerDTO2 = null;
		List dmList1, swoList1, eeList1, priceList1;
		DMDomainDTO dmDomainDTO1;
		SWODomainDTO swoDomainDTO1;
		EEDomainDTO eeDomainDTO1;
		PriceDomainDTO priceDomainDTO1;
		java.util.Date startDate, endDate;
		String tempCustomerNumber = "";

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				customerDTO1 = (CustomerDomainDTO) list.get(i);
				String customerNumber = customerDTO1.getSapCustomerNo().trim();
				if (customerDTO1.getDMDTOList() != null
						&& !(customerNumber.equals(tempCustomerNumber))) {
					tempCustomerNumber = customerNumber;
					for (int j = i + 1; j < list.size(); j++) {
						customerDTO2 = (CustomerDomainDTO) list.get(j);
						if (customerNumber.equals(customerDTO2
								.getSapCustomerNo())) {
							dmList1 = customerDTO1.getDMDTOList();
							ArrayList dmList2 = new ArrayList();
							if (dmList1 != null) {
								for (int k = 0; k < dmList1.size(); k++) {

									DMDomainDTO dmDomainDTO2 = new DMDomainDTO();
									dmDomainDTO1 = (DMDomainDTO) dmList1.get(k);

									dmDomainDTO2.setCustomerId(customerDTO2
											.getCustomerId());
									dmDomainDTO2.setProposalId(dmDomainDTO1
											.getProposalId());
									dmDomainDTO2
											.setDmNo(dmDomainDTO1.getDmNo());
									dmDomainDTO2.setDmDesc(dmDomainDTO1
											.getDmDesc());
									dmDomainDTO2.setPlanStartDate(customerDTO2
											.getPlanStartDate());
									dmDomainDTO2.setPlanEndDate(customerDTO2
											.getPlanEndDate());
									dmDomainDTO2.setPlannedInd(dmDomainDTO1
											.getPlannedInd());
									dmDomainDTO2
											.setLastUpdatedDate(dmDomainDTO1
													.getLastUpdatedDate());
									dmDomainDTO2.setDmAddedDate(dmDomainDTO1
											.getDmAddedDate());
									dmDomainDTO2.setExclusionID(dmDomainDTO1
											.getExclusionID());
									dmDomainDTO2.setDmCopyIncrNo(dmDomainDTO1
											.getDmCopyIncrNo());

									swoList1 = dmDomainDTO1.getSWODTOList();
									ArrayList swoList2 = new ArrayList();
									if (swoList1 != null) {
										for (int m = 0; m < swoList1.size(); m++) {
											SWODomainDTO swoDomainDTO2 = new SWODomainDTO();
											swoDomainDTO1 = (SWODomainDTO) swoList1
													.get(m);

											swoDomainDTO2
													.setCustomerId(customerDTO2
															.getCustomerId());
											swoDomainDTO2
													.setProposalId(swoDomainDTO1
															.getProposalId());
											swoDomainDTO2.setDmId(swoDomainDTO1
													.getDmId());
											swoDomainDTO2
													.setSwoNo(swoDomainDTO1
															.getSwoNo());
											swoDomainDTO2
													.setSwoItemNo(swoDomainDTO1
															.getSwoItemNo());
											swoDomainDTO2
													.setSwoDesc(swoDomainDTO1
															.getSwoDesc());
											swoDomainDTO2
													.setEswPrice(swoDomainDTO1
															.getEswPrice());
											swoDomainDTO2
													.setCalcPrice(swoDomainDTO1
															.getCalcPrice());
											swoDomainDTO2
													.setSAndSInd(swoDomainDTO1
															.getSAndSInd());
											swoDomainDTO2
													.setSerialNo(swoDomainDTO1
															.getSerialNo());
											swoDomainDTO2
													.setPlanStartDate(customerDTO2
															.getPlanStartDate());
											swoDomainDTO2
													.setPlanEndDate(customerDTO2
															.getPlanEndDate());
											swoDomainDTO2
													.setSalesDocNo(swoDomainDTO1
															.getSalesDocNo());
											swoDomainDTO2
													.setEquipmentNo(swoDomainDTO1
															.getEquipmentNo());
											swoDomainDTO2
													.setLockedInd(swoDomainDTO1
															.getLockedInd());
											swoDomainDTO2
													.setDeltaFetchId(swoDomainDTO1
															.getDeltaFetchId());
											swoDomainDTO2
													.setAdjustmentAmount(swoDomainDTO1
															.getAdjustmentAmount());
											swoDomainDTO2
													.setPlanDateInd(swoDomainDTO1
															.getPlanDateInd());
											swoDomainDTO2
													.setSwoContrType(swoDomainDTO1
															.getSwoContrType());
											swoDomainDTO2
													.setAlternatePriceUpdateInd(swoDomainDTO1
															.getAlternatePriceUpdateInd());
											swoDomainDTO2
													.setSwoContrStatus(swoDomainDTO1
															.getSwoContrStatus());
											swoDomainDTO2
													.setSwoExtContrNo(swoDomainDTO1
															.getSwoExtContrNo());
											swoDomainDTO2
													.setAmendEndDate(swoDomainDTO1
															.getAmendEndDate());
											swoDomainDTO2
													.setRefetchId(swoDomainDTO1
															.getRefetchId());
											swoDomainDTO2
													.setSwoAddedDate(swoDomainDTO1
															.getSwoAddedDate());
											swoDomainDTO2
													.setBumpInd(swoDomainDTO1
															.getBumpInd());
											swoDomainDTO2
													.setAmendStartDate(swoDomainDTO1
															.getAmendStartDate());
											swoDomainDTO2
													.setAmendInd(swoDomainDTO1
															.getAmendInd());
											swoDomainDTO2
													.setExclusionId(swoDomainDTO1
															.getExclusionId());
											swoDomainDTO2
													.setLastUpdatedDate(swoDomainDTO1
															.getLastUpdatedDate());
											swoDomainDTO2
													.setOldCalcPrice(swoDomainDTO1
															.getOldCalcPrice());
											swoDomainDTO2
													.setPlannedInd(swoDomainDTO1
															.getPlannedInd());
											swoDomainDTO2
													.setAlternatePriceInd(swoDomainDTO1
															.getAlternatePriceInd());
											swoDomainDTO2
													.setReferenceSerialNo(swoDomainDTO1
															.getReferenceSerialNo());
											swoDomainDTO2
													.setReferenceSerialNoDM(swoDomainDTO1
															.getReferenceSerialNoDM());
											swoDomainDTO2
													.setAlternatePrice(swoDomainDTO1
															.getAlternatePrice());
											swoDomainDTO2
													.setSequenceNo(swoDomainDTO1
															.getSequenceNo());
											swoDomainDTO2
													.setItemCategory(swoDomainDTO1
															.getItemCategory());
											swoDomainDTO2
													.setCustomerPoNo(swoDomainDTO1
															.getCustomerPoNo());
											swoDomainDTO2
													.setRequestDeliveryDate(swoDomainDTO1
															.getRequestDeliveryDate());
											swoDomainDTO2
													.setIneligFlag(swoDomainDTO1
															.getIneligFlag());
											swoDomainDTO2
													.setComments(swoDomainDTO1
															.getComments());
											swoDomainDTO2
													.setLicenseEffectiveDate(swoDomainDTO1
															.getLicenseEffectiveDate());
											swoDomainDTO2
													.setSkipOption(swoDomainDTO1
															.getSkipOption());
											swoDomainDTO2
													.setDuplicateDeletedInd(swoDomainDTO1
															.getDuplicateDeletedInd());
											swoDomainDTO2
													.setMarkedForDeletion(swoDomainDTO1
															.isMarkedForDeletion());

											eeList1 = swoDomainDTO1
													.getEEDTOList();
											ArrayList eeList2 = new ArrayList();
											if (eeList1 != null) {
												for (int n = 0; n < eeList1
														.size(); n++) {
													EEDomainDTO eeDomainDTO2 = new EEDomainDTO();
													eeDomainDTO1 = (EEDomainDTO) eeList1
															.get(n);

													eeDomainDTO2
															.setCustomerId(customerDTO2
																	.getCustomerId());
													eeDomainDTO2
															.setProposalId(eeDomainDTO1
																	.getProposalId());
													eeDomainDTO2
															.setDmId(eeDomainDTO1
																	.getDmId());
													eeDomainDTO2
															.setSwoId(eeDomainDTO1
																	.getSwoId());
													eeDomainDTO2
															.setEeNo(eeDomainDTO1
																	.getEeNo());
													eeDomainDTO2
															.setEswPrice(eeDomainDTO1
																	.getEswPrice());
													eeDomainDTO2
															.setCalculatedPrice(eeDomainDTO1
																	.getCalculatedPrice());
													eeDomainDTO2
															.setListPrice(eeDomainDTO1
																	.getListPrice());
													eeDomainDTO2
															.setPlanStartDate(customerDTO2
																	.getPlanStartDate());
													eeDomainDTO2
															.setPlanEndDate(customerDTO2
																	.getPlanEndDate());
													eeDomainDTO2
															.setEeItemNo(eeDomainDTO1
																	.getEeItemNo());
													eeDomainDTO2
															.setSwoItemNo(eeDomainDTO1
																	.getSwoItemNo());
													eeDomainDTO2
															.setSalesDocNo(eeDomainDTO1
																	.getSalesDocNo());
													eeDomainDTO2
															.setEeDesc(eeDomainDTO1
																	.getEeDesc());
													eeDomainDTO2
															.setReqstDeliveryDate(eeDomainDTO1
																	.getReqstDeliveryDate());
													eeDomainDTO2
															.setValueMetric(eeDomainDTO1
																	.getValueMetric());
													eeDomainDTO2
															.setUseLevel(eeDomainDTO1
																	.getUseLevel());
													eeDomainDTO2
															.setLicenseType(eeDomainDTO1
																	.getLicenseType());
													eeDomainDTO2
															.setAlternatePrice(eeDomainDTO1
																	.getAlternatePrice());
													eeDomainDTO2
															.setBillingStartDate(eeDomainDTO1
																	.getBillingStartDate());
													eeDomainDTO2
															.setBillingEndDate(eeDomainDTO1
																	.getBillingEndDate());
													eeDomainDTO2
															.setExclusionId(eeDomainDTO1
																	.getExclusionId());
													eeDomainDTO2
															.setSequenceNo(eeDomainDTO1
																	.getSequenceNo());
													eeDomainDTO2
															.setBumpId(eeDomainDTO1
																	.getBumpId());
													eeDomainDTO2
															.setChargeOption(eeDomainDTO1
																	.getChargeOption());
													eeDomainDTO2
															.setChargeOptionDesc(eeDomainDTO1
																	.getChargeOptionDesc());
													eeDomainDTO2
															.setAlternatePriceUpdateInd(eeDomainDTO1
																	.getAlternatePriceUpdateInd());
													eeDomainDTO2
															.setPletNo(eeDomainDTO1
																	.getPletNo());
													eeDomainDTO2
															.setSAndSDiscountPercent(eeDomainDTO1
																	.getSAndSDiscountPercent());

													priceList1 = eeDomainDTO1
															.getPriceDTOList();
													ArrayList priceList2 = new ArrayList();
													if (priceList1 != null) {
														for (int x = 0; x < priceList1
																.size(); x++) {
															PriceDomainDTO priceDomainDTO2 = new PriceDomainDTO();
															priceDomainDTO1 = (PriceDomainDTO) priceList1
																	.get(x);

															priceDomainDTO2
																	.setCustomerId(customerDTO2
																			.getCustomerId());
															priceDomainDTO2
																	.setProposalId(priceDomainDTO1
																			.getProposalId());
															priceDomainDTO2
																	.setDmId(priceDomainDTO1
																			.getDmId());
															priceDomainDTO2
																	.setSwoId(priceDomainDTO1
																			.getSwoId());
															priceDomainDTO2
																	.setEeId(priceDomainDTO1
																			.getEeId());
															priceDomainDTO2
																	.setSalesDocNo(priceDomainDTO1
																			.getSalesDocNo());
															priceDomainDTO2
																	.setEswPrice(priceDomainDTO1
																			.getEswPrice());
															priceDomainDTO2
																	.setEeItemNo(priceDomainDTO1
																			.getEeItemNo());
															//priceDomainDTO2.setBillingStatus(priceDomainDTO1.getBillingStatus());
															priceDomainDTO2
																	.setCurrency(priceDomainDTO1
																			.getCurrency());
															priceDomainDTO2
																	.setExclusionId(priceDomainDTO1
																			.getExclusionId());
															priceDomainDTO2
																	.setBillPlanStartDate(customerDTO2
																			.getPlanStartDate());
															priceDomainDTO2
																	.setBillPlanEndDate(customerDTO2
																			.getPlanEndDate());

															priceList2
																	.add(priceDomainDTO2);
														}
													}
													eeDomainDTO2
															.setPriceDTOList(priceList2);
													eeList2.add(eeDomainDTO2);
												}
											}
											swoDomainDTO2.setEEDTOList(eeList2);
											swoList2.add(swoDomainDTO2);
										}
									}
									dmDomainDTO2.setSwoDTOList(swoList2);
									dmList2.add(dmDomainDTO2);
								}
							}
							customerDTO2.setDMDTOList(dmList2);
						}

					}//for
				}//if
			}//for

		}//if
	}

	private void populateCustomerForAllYears(ProposalBO proposalBO)
			throws ServiceException {
		InventoryManagerLocal invLocal = getInventoryManagerLocal();
		ProposalDomainDTO proposalDomainDTO = new ProposalDomainDTO();
		proposalDomainDTO.setProposalId(proposalBO.getProposalId());
		proposalDomainDTO = invLocal
				.retrieveCustomerForProposal(proposalDomainDTO);
		List customerList = proposalDomainDTO.getCustomerDTOList();
		CustomerBOFactory customerBOFactory = new CustomerBOFactory();
		List customerBOList = new ArrayList();

		try {
			customerBOList = customerBOFactory
					.findCustomerBOForProposalStartEndDate(proposalBO
							.getProposalId(), proposalBO.getContrStartPeriod(),
							proposalBO.getContrEndPeriod());

		} catch (DomainException e1) {
			throw ExceptionGenerator.generateServiceException(e1
					.getErrorReport());
		}

		try {
			for (int i = 0; i < customerList.size(); i++) {
				CustomerDomainDTO customerDomainDTO = (CustomerDomainDTO) customerList
						.get(i);
				invLocal.removeCustomerDetail(customerDomainDTO);
			}
		} catch (ServiceException se) {
			try {
				getSessionContext().setRollbackOnly();
			} catch (IllegalStateException ile) {
				// Nothing will be done
			}
			throw se;
		}

		int contractDurationMonths = OPPTCalender
				.calculateContractPeriodDuration(
						proposalBO.getContrStartDate(), proposalBO
								.getContrEndDate());
		int contractDurationYears = contractDurationMonths / 12;
		java.util.Date today = new java.util.Date();

		for (int j = 0; j < customerBOList.size(); j++) {
			CustomerBO customerBO = (CustomerBO) customerBOList.get(j);
			for (int i = 0; i < contractDurationYears; i++) {
				CustomerDomainDTO customerDomainDTO = new CustomerDomainDTO();
				customerDomainDTO.setProposalId(customerBO.getProposalId());
				customerDomainDTO.setCustomerListNo(customerBO
						.getCustomerListNo());
				customerDomainDTO.setCustmerASNo(customerBO.getCustmerASNo());
				customerDomainDTO.setLegacyCustomerNo(customerBO
						.getLegacyCustomerNo());
				customerDomainDTO.setSapCustomerName(customerBO
						.getSapCustomerName());
				customerDomainDTO.setSapCustomerNo(customerBO
						.getSapCustomerNo());
				customerDomainDTO.setLastUpdatedDate((new java.sql.Date(today
						.getTime())));
				customerDomainDTO.setCountryCode(customerBO.getCountryCode());

				if (null != proposalBO) {
					java.util.Date startPeriod = OPPTCalender.addDate(
							OPPTCalender.YEAR, i, proposalBO
									.getContrStartPeriod());
					java.util.Date endPeriod = OPPTCalender.addDate(
							OPPTCalender.YEAR, i, proposalBO
									.getContrEndPeriod());

					customerDomainDTO.setPlanStartDate(new java.sql.Date(
							startPeriod.getTime()));
					customerDomainDTO.setPlanEndDate(new java.sql.Date(
							endPeriod.getTime()));
				}
				invLocal.addCustomersToProposalSAndSExtended(customerDomainDTO);

			}//End of for-loop
		} // end of Iterator

	}

	/*End change CR6153*/

	/* IGF Test - Start changes */
	private void checkIGFCustomer(
						ProposalHeaderCustomDTO proposalHeaderCustomDTO)
			throws ServiceException {

		PartnerCheckInputConnectorDTO inputConnectorDTO = new PartnerCheckInputConnectorDTO();
		ESWCustomerCustomDTO partnerCustomDTO = proposalHeaderCustomDTO
				.getPartnerInformationCustomDTO().getPayer();
		/*DADO02&DADO09 inputConnectorDTO.setPartnerAddressSequenceNumber(partnerCustomDTO
				.getAddressSequenceNumber());
		inputConnectorDTO.setPartnerLegacyNumber(partnerCustomDTO
				.getLegacyCustomerNumber());
		inputConnectorDTO.setCountryCode(partnerCustomDTO.getCountryCode());*/
		inputConnectorDTO.setPartnerLegacyNumber(partnerCustomDTO
				.getSAPCustomerNumber());
		inputConnectorDTO.setPartnerType(PartnerTypeConstants.PAYER);
		inputConnectorDTO.setFinancingContractFlag("F");
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
		genericConnectorDTO
				.setFunctionModuleName(ConnectorConstants.RFC_PARTNER_CHECK_OPPT);
		genericConnectorDTO.setUserID(proposalHeaderCustomDTO.getUserId());
		genericConnectorDTO
				.setSessionID(proposalHeaderCustomDTO.getSessionId());
		inputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
		orgConnectorDTO.setDistributionChannel(proposalHeaderCustomDTO
				.getBasicProposalCustomDTO().getDistributionChannel());
		//orgConnectorDTO.setSalesGroup(proposalHeaderCustomDTO.getBasicProposalCustomDTO().getSalesGroup());
		//orgConnectorDTO.setChannelRole(proposalHeaderCustomDTO.getBasicProposalCustomDTO().getChannelRole());
		//orgConnectorDTO.setSubmitterRole(proposalHeaderCustomDTO.getBasicProposalCustomDTO().getSubmitterRole());
		orgConnectorDTO.setDivision(proposalHeaderCustomDTO
				.getBasicProposalCustomDTO().getDivision());
		orgConnectorDTO.setSalesOrg(proposalHeaderCustomDTO
				.getBasicProposalCustomDTO().getSalesOrganization());
		inputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);
		// Make the ESW Call to the Backend
		JMSConnectorLocal jmsConnectorLocal = null;
		try {
			jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
		} catch (CreateException e) {

		}
		PartnerCheckOutputConnectorDTO outputConnectorDTO = new PartnerCheckOutputConnectorDTO();
		try {
			outputConnectorDTO = (PartnerCheckOutputConnectorDTO) jmsConnectorLocal
					.sendReceive(inputConnectorDTO);
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME,
					"checkIGFCustomer", null, e1);
			throw ExceptionGenerator
					.generateServiceException(ErrorCodeConstants.SE0801);
		}
		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(outputConnectorDTO
				.getReturnCode())) {
			if (PartnerTypeConstants.CLASS_33.equals(outputConnectorDTO
					.getClassType())
					|| PartnerTypeConstants.CLASS_35.equals(outputConnectorDTO
							.getClassType())) {
				//throwServiceException(outputConnectorDTO.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
				throw ExceptionGenerator
						.generateServiceException(ErrorCodeConstants.SE0810);
			}

		}
	}
	/* IGF Test - End changes */


	/*creating activity Log added by Nomita*/
	private void createActivityLog(String userID,
			String message) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "createActivityLog");
		ActivityLogBO activityLogBO = new ActivityLogBO();
		activityLogBO.setUserId(userID);
		activityLogBO.setMessage(message);
		try {
			iActivityLogBOFactory.create(activityLogBO);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}
/*added by Nomita*/
}
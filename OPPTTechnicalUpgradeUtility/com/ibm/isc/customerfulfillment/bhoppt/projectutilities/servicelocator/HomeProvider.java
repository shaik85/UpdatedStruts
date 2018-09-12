/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Time;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;

import com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocal;
import com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingTypeLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingTypeLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CurrencyLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CurrencyLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DivisionLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DivisionLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.RoleLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.RoleLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.StatusLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.StatusLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserProfileLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserProfileLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ActionDescriptionLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ActionDescriptionLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEELocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEELocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEELocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEELocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEELocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEELocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.PriceManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.PriceManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.*;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOInfoLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOInfoLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocalHome;


/** 
 * 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 6, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class HomeProvider
{
	// Local
	/**
     * constant
     *
     */
    public static final String INVENTORY_MANAGER_LOCAL_HOME = "InventoryManagerLocalHome";  /* NOI18N */
	/** constant */   public static final String PROPOSAL_DATA_MANAGER_LOCAL_HOME = "ProposalDataManagerLocalHome";  /* NOI18N */
	/** constant */   public static final String JMS_CONNECTOR_LOCAL_HOME = "JMSConnectorLocalHome";  /* NOI18N */
	/** constant */   public static final String PROPOSAL_LOCAL_HOME = "ProposalLocalHome";  /* NOI18N */
	/** constant */   public static final String PRICE_MANAGER_LOCAL_HOME = "PriceManagerLocalHome";  /* NOI18N */
	/** constant */   public static final String SALES_ORG_LOCAL_HOME = "SalesOrgLocalHome";  /* NOI18N */
	/** constant */   public static final String DIVISION_LOCAL_HOME = "DivisionLocalHome";  /* NOI18N */
	/** constant */   public static final String DSTR_CHANNEL_LOCAL_HOME = "DstrChannelLocalHome";  /* NOI18N */
	/** constant */   public static final String CURRENCY_LOCAL_HOME = "CurrencyLocalHome";  /* NOI18N */
	/** constant */   public static final String USER_PROFILE_LOCAL_HOME = "UserProfileLocalHome";  /* NOI18N */
	/** constant */   public static final String BP_LEGACY_NO_LOCAL_HOME = "BPLegacyNoLocalHome";  /* NOI18N */
	/** constant */   public static final String BP_CUST_LIST_LOCAL_HOME = "BPCustListLocalHome";  /* NOI18N */
	/** constant */   public static final String DM_LOCAL_HOME = "DMLocalHome";  /* NOI18N */
	/** constant */   public static final String HISTORY_DM_LOCAL_HOME = "HistoryDMLocalHome";  /* NOI18N */
	/** constant */   public static final String VARIANCE_DM_LOCAL_HOME = "VarianceDMLocalHome";  /* NOI18N */
	/** constant */   public static final String USER_MANAGER_LOCAL_HOME = "UserManagerLocalHome";  /* NOI18N */
	/** constant */   public static final String CUSTOMER_LOCAL_HOME = "CustomerLocalHome";  /* NOI18N */
	/** constant */   public static final String HISTORY_CUSTOMER_LOCAL_HOME = "HistoryCustomerLocalHome";  /* NOI18N */
	/** constant */   public static final String PAYMENT_TERM_LOCAL_HOME = "PaymentTermLocalHome";  /* NOI18N */
	/** constant */   public static final String BILLING_TYPE_LOCAL_HOME = "BillingTypeLocalHome";  /* NOI18N */
	/** constant */   public static final String ACTIVITY_LOG_LOCAL_HOME = "ActivityLogLocalHome";  /* NOI18N */
	/** constant */   public static final String BILLING_FREQUENCY_LOCAL_HOME = "BillingFrequencyLocalHome";  /* NOI18N */
	/** constant */   public static final String BILLING_BLOCK_LOCAL_HOME = "BillingBlockLocalHome";  /* NOI18N */
	/** constant */   public static final String GEO_SEC_OFF_LOCAL_HOME = "GeoSecOffLocalHome";  /* NOI18N */
	/** constant */   public static final String GROUP_LOCAL_HOME = "GroupLocalHome";  /* NOI18N */
	/** constant */   public static final String ROLE_LOCAL_HOME = "RoleLocalHome";  /* NOI18N */
	/** constant */   public static final String OFFERING_TYPE_LOCAL_HOME = "OfferingTypeLocalHome";  /* NOI18N */
	/** constant */   public static final String SALES_AREA_LOCAL_HOME = "SalesAreaLocalHome";  /* NOI18N */
	/** constant */   public static final String ACCESS_HISTORY_LOCAL_HOME = "AccessHistoryLocalHome";  /* NOI18N */
	/** constant */   public static final String CUSTOMER_LIST_LOCAL_HOME = "CustomerListLocalHome";  /* NOI18N */
	/** constant */   public static final String ERROR_LIST_LOCAL_HOME = "ErrorListLocalHome";  /* NOI18N */
	/** constant */   public static final String STATUS_LOCAL_HOME = "StatusLocalHome";  /* NOI18N */
	/** constant */   public static final String SHARING_LOCAL_HOME = "SharingLocalHome";  /* NOI18N */	
	/** constant */   public static final String EE_LOCAL_HOME = "EELocalHome";  /* NOI18N */
	/** constant */   public static final String VARIABLE_EE_LOCAL_HOME = "VarianceEELocalHome";  /* NOI18N */
	/** constant */   public static final String HISTORY_EE_LOCAL_HOME = "HistoryEELocalHome";  /* NOI18N */
	/** constant */   public static final String PRICE_LOCAL_HOME = "PriceLocalHome";  /* NOI18N */
	/** constant */   public static final String VARIANCE_PRICE_LOCAL_HOME = "VariancePriceLocalHome";  /* NOI18N */
	/** constant */   public static final String SWO_LOCAL_HOME = "SWOLocalHome";  /* NOI18N */
	/** constant */   public static final String HISTORY_SWO_LOCAL_HOME = "HistorySWOLocalHome";  /* NOI18N */
	/** constant */   public static final String VARIANCE_SWO_LOCAL_HOME = "VarianceSWOLocalHome";  /* NOI18N */		
	/** constant */   public static final String SWO_MANAGER_LOCAL_HOME = "SWOManagerLocalHome";  /* NOI18N */
	/** constant */   public static final String SWO_INFO_LOCAL_HOME = "SWOInfoLocalHome";  /* NOI18N */
	/** constant */   public static final String DM_MANAGER_LOCAL_HOME = "DMManagerLocalHome";  /* NOI18N */
	/** constant */   public static final String EE_PRICE_MANAGER_LOCAL_HOME = "EEPriceManagerLocalHome";  /* NOI18N */
	/** constant */   public static final String PROPOSAL_MANAGER_HOME = "ProposalManagerHome";  /* NOI18N */
	/** constant */   public static final String ERROR_LIST_MANAGER_LOCAL_HOME = "ErrorListManagerLocalHome";  /* NOI18N */
	/** constant */   public static final String PROPOSAL_MANAGER_HOME_LOCAL = "ProposalManagerLocalHome";  /* NOI18N */
	/** constant */   public static final String TEMP_EE_LOCAL_HOME="TempEELocalHome";  /* NOI18N */
	
	// UD Changes
	/** constant */   public static final String USER_GROUP_LOCAL_HOME="UserGroupLocalHome";  /* NOI18N */
	
	
	/** constant */   public static final String ESW_DATA_LOCAL_HOME = "ESWDataLocalHome";  /* NOI18N */ // GWA Change for XADataSource by Sara 
			
	// Remote
	/** constant */   public static final String USER_MANAGER_REMOTE_HOME = "UserManagerHome";  /* NOI18N */

	// Base agreement
	
	/** constant */   public static final String USER_TYPE_LOCAL_HOME = "UserTypeLocalHome";  /* NOI18N */
	/** constant */   public static final String BA_ROLE_LOCAL_HOME = "BARoleLocalHome";  /* NOI18N */
	/** constant */   public static final String BASE_AGREEMENT_LOCAL_HOME = "BaseAgreementLocalHome";  /* NOI18N */
	/** constant */   public static final String BASE_AGREEMENT_COVERAGE_TYPE_LOCAL_HOME = "BaseAgreementCoverageTypeLocalHome";  /* NOI18N */
	/** constant */   public static final String BASE_AGREEMENT_FORM_LOCAL_HOME = "BaseAgreementFormLocalHome";  /* NOI18N */
	/** constant */   public static final String BASE_AGREEMENT_MODIFICATION_DETAILS_LOCAL_HOME = "BaseAgreementModificationDetailsLocalHome";  /* NOI18N */
	/** constant */   public static final String BASE_AGREEMENT_MODIFICATION_TYPE_LOCAL_HOME = "BaseAgreementModificationTypeLocalHome";  /* NOI18N */
	/** constant */   public static final String BASE_AGREEMENT_STATUS_LOCAL_HOME = "BaseAgreementStatusLocalHome";  /* NOI18N */
	/** constant */   public static final String MODIFICATION_OPTIONS_LOCAL_HOME = "ModificationOptionsLocalHome";  /* NOI18N */
	/** constant */   public static final String BASE_AGREEMENT_REMOTE_HOME = "BaseAgreementManagerHome";  /* NOI18N */
	/** constant */   public static final String BASE_AGREEMENT_CHANGELOG_LOCAL_HOME = "BaseAgreementChangeLogLocalHome";  /* NOI18N */
	// BH Wave1 - DAD003 - Complex Contract Identifiers - Begin - Bhanu
	/** constant */   public static final String CC_TYPE_LOCAL_HOME = "CCTypeLocalHome";  /* NOI18N */
	/** constant */   public static final String MC_TYPE_LOCAL_HOME = "MCTypeLocalHome";  /* NOI18N */
	/** constant */   public static final String BLB_Indicator_LOCAL_HOME = "BLBIndicatorLocalHome";  /* NOI18N */
	// BH Wave1 - DAD003 - Complex Contract Identifiers - End - Bhanu
	public static final String ACTION_DESCRIPTION_LOCAL_HOME = "ActionDescriptionLocalHome";

	
	
	/**
	 * To get the JMS ConnectorLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return JMSConnectorLocal
	 * @throws CreateException
	 */
	public static JMSConnectorLocal getJMSConnectorLocal() throws CreateException
	{
		JMSConnectorLocalHome jmsConnectorLocalHome = (JMSConnectorLocalHome) getLocal(JMS_CONNECTOR_LOCAL_HOME);
		return jmsConnectorLocalHome.create();
	}

	/**
     * To get the UserManager
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 6, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return UserManager
     * @throws CreateException
     * @throws java.rmi.RemoteException 
     */
	public static UserManager getUserManagerRemote() throws RemoteException, CreateException
	{
		UserManagerHome userManagerHome = (UserManagerHome) getRemote(USER_MANAGER_REMOTE_HOME);
		return userManagerHome.create();
	}

	/**
	 * To get the UserManagerLocal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return UserManagerLocal
	 * @throws CreateException
	 */
	public static UserManagerLocal getUserManagerLocal() throws CreateException
	{
		UserManagerLocalHome userManagerLocalHome = (UserManagerLocalHome) getLocal(USER_MANAGER_LOCAL_HOME);
		return userManagerLocalHome.create();
	}

	/**
	 * To get the ProposalLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @param proposalName
	 * @return ProposalLocal
	 * @throws CreateException
	 */
	public static ProposalLocal getProposalLocal(int proposalID, String proposalName) throws CreateException
	{
		ProposalLocalHome proposalLocalHome = (ProposalLocalHome) getLocal(PROPOSAL_LOCAL_HOME);
		return proposalLocalHome.create(proposalID, proposalName);
	}

	/**
	 * To get the InventoryManagerLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return InventoryManagerLocal
	 * @throws CreateException
	 */
	public static InventoryManagerLocal getInventoryManagerLocal() throws CreateException
	{
		InventoryManagerLocalHome inventoryManagerLocalHome =
			(InventoryManagerLocalHome) getLocal(INVENTORY_MANAGER_LOCAL_HOME);
		return inventoryManagerLocalHome.create();
	}

	/**
	 * To get the ProposalDataManagerLocal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalDataManagerLocal
	 * @throws CreateException
	 */
	public static ProposalDataManagerLocal getProposalDataManagerLocal() throws CreateException
	{
		ProposalDataManagerLocalHome proposalDataManagerLocalHome =
			(ProposalDataManagerLocalHome) getLocal(PROPOSAL_DATA_MANAGER_LOCAL_HOME);
		return proposalDataManagerLocalHome.create();
	}

	/**
	 * To get the PriceManagerLocal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PriceManagerLocal
	 * @throws CreateException
	 */
	public static PriceManagerLocal getPriceManagerLocal() throws CreateException
	{
		PriceManagerLocalHome priceManagerLocalHome = (PriceManagerLocalHome) getLocal(PRICE_MANAGER_LOCAL_HOME);
		return priceManagerLocalHome.create();
	}

	/**
	 * To get the SalesOrgLocal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param salesOrg
	 * @return SalesOrgLocal
	 * @throws CreateException
	 */
	public static SalesOrgLocal getSalesOrgLocal(String salesOrg) throws CreateException
	{
		SalesOrgLocalHome salesOrgLocalHome = (SalesOrgLocalHome) getLocal(SALES_ORG_LOCAL_HOME);
		return salesOrgLocalHome.create(salesOrg);
	}

	/**
	 * To get the DivisionLocal  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param division
	 * @return DivisionLocal
	 * @throws CreateException
	 */
	public static DivisionLocal getDivisionLocal(String division) throws CreateException
	{
		DivisionLocalHome divisionLocalHome = (DivisionLocalHome) getLocal(DIVISION_LOCAL_HOME);
		return divisionLocalHome.create(division);
	}

	/**
	 * To get the DstrChannelLocal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param distributionChannel
	 * @return DstrChannelLocal
	 * @throws CreateException
	 */
	public static DstrChannelLocal getDstrChannelLocal(String distributionChannel, String SalesGroup, String channelRole,String submitterRole) throws CreateException
	{
		DstrChannelLocalHome dstrChannelLocalHome = (DstrChannelLocalHome) getLocal(DSTR_CHANNEL_LOCAL_HOME);
		return dstrChannelLocalHome.create(distributionChannel,SalesGroup,channelRole,submitterRole);
	}

	/**
	 * To get the CurrencyLocal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param currency
	 * @return CurrencyLocal
	 * @throws CreateException
	 */
	public static CurrencyLocal getCurrencyLocal(String currency) throws CreateException
	{
		CurrencyLocalHome currencyLocalHome = (CurrencyLocalHome) getLocal(CURRENCY_LOCAL_HOME);
		return currencyLocalHome.create(currency);
	}

	/**
     * To get the UserProfileLocal
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 6, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param userID
     * @return UserProfileLocal
     * @throws CreateException
     * @param role 
     */
	public static UserProfileLocal getUserProfileLocal(String userID,String role) throws CreateException
	{
		UserProfileLocalHome userProfileLocalHome = (UserProfileLocalHome) getLocal(USER_PROFILE_LOCAL_HOME);
		return userProfileLocalHome.create(userID,role);
	}

	/**
	 * To get the BPLegacyNoLocal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userID
	 * @param legacyNo
	 * @param addressSeqNo
	 * @return BPLegacyNoLocal
	 * @throws CreateException
	 */
	public static BPLegacyNoLocal getBPLegacyNoLocal(String userID, String legacyNo, String addressSeqNo)
		throws CreateException
	{
		BPLegacyNoLocalHome bpLegacyNoLocalHome = (BPLegacyNoLocalHome) getLocal(BP_LEGACY_NO_LOCAL_HOME);
		return bpLegacyNoLocalHome.create(userID, legacyNo, addressSeqNo);
	}

	/**
	 * To get the BPCustListLocal
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userID
	 * @param custListNo
	 * @return BPCustListLocal
	 * @throws CreateException
	 */
	public static BPCustListLocal getBPCustListLocal(String userID, String custListNo) throws CreateException
	{
		BPCustListLocalHome bpCustListLocalHome = (BPCustListLocalHome) getLocal(BP_CUST_LIST_LOCAL_HOME);
		return bpCustListLocalHome.create(userID, custListNo);
	}

	/**
	 * To get the DMLocal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmID
	 * @param customerID
	 * @param proposalID
	 * @param dmNo
	 * @return DMLocal
	 * @throws CreateException
	 */
	public static DMLocal getDMLocal(int dmID, int customerID, int proposalID, String dmNo) throws CreateException
	{
		DMLocalHome dmLocalHome = (DMLocalHome) getLocal(DM_LOCAL_HOME);
		return dmLocalHome.create(dmID, customerID, proposalID, dmNo);
	}

	/**
     * To get the HistoryDMLocal
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 6, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param dmID
     * @param customerID
     * @param proposalID
     * @return HistoryDMLocal
     * @throws CreateException
     * @param dmNo
     * @param lastUpdatedDate 
     */
	public static HistoryDMLocal getHistoryDMLocal(int dmID, int customerID, int proposalID,String dmNo,java.sql.Date lastUpdatedDate)
		throws CreateException
	{
		HistoryDMLocalHome historyDMLocalHome = (HistoryDMLocalHome) getLocal(HISTORY_DM_LOCAL_HOME);
		return historyDMLocalHome.create(dmID, customerID, proposalID,dmNo,lastUpdatedDate);
	}

	/**
     * To get the VarianceDMLocal
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 6, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param dmID
     * @param customerID
     * @param proposalID
     * @return VarianceDMLocal
     * @throws CreateException
     * @param dmNo 
     */
	public static VarianceDMLocal getVarianceDMLocal(int dmID, int customerID, int proposalID,String dmNo)
		throws CreateException
	{
		VarianceDMLocalHome varianceDMLocalHome = (VarianceDMLocalHome) getLocal(VARIANCE_DM_LOCAL_HOME);
		return varianceDMLocalHome.create(dmID, customerID, proposalID,dmNo);
	}

	/**
	 * To get the CustomerLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @param customerID
	 * @param sapCustomerNo
	 * @return CustomerLocal
	 * @throws CreateException
	 */
	/* start change CR6153 */
	public static CustomerLocal getCustomerLocal(int proposalID, int customerID, String sapCustomerNo, Date planStartDate, Date planEndDate)
		throws CreateException
	/* end change CR6153 */
	{
		CustomerLocalHome customerLocalHome = (CustomerLocalHome) getLocal(CUSTOMER_LOCAL_HOME);
		/* start change CR6153 */
		return customerLocalHome.create(proposalID, customerID, sapCustomerNo,planStartDate, planEndDate);
		/* end change CR6153 */
	}

	/**
	 * To get the HistoryCustomerLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerID
	 * @param proposalID
	 * @return HistoryCustomerLocal
	 * @throws CreateException
	 */
	public static HistoryCustomerLocal getHistoryCustomerLocal(int customerID, int proposalID)
		throws CreateException
	{
		HistoryCustomerLocalHome historyCustomerLocalHome =
			(HistoryCustomerLocalHome) getLocal(HISTORY_CUSTOMER_LOCAL_HOME);
		return historyCustomerLocalHome.create(customerID, proposalID);
	}

	/**
	 * To get the PaymentTermLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param paymentTerm
	 * @return PaymentTermLocal
	 * @throws CreateException
	 */
	public static PaymentTermLocal getPaymentTermLocal(String paymentTerm) throws CreateException
	{
		PaymentTermLocalHome paymentTermLocalHome = (PaymentTermLocalHome) getLocal(PAYMENT_TERM_LOCAL_HOME);
		return paymentTermLocalHome.create(paymentTerm);
	}

	/**
	 * To get the BillingTypeLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billingType
	 * @return BillingTypeLocal
	 * @throws CreateException
	 */
	public static BillingTypeLocal getBillingTypeLocal(String billingType) throws CreateException
	{
		BillingTypeLocalHome billingTypeLocalHome = (BillingTypeLocalHome) getLocal(BILLING_TYPE_LOCAL_HOME);
		return billingTypeLocalHome.create(billingType);
	}

	/**
	 * To get the BillingFrequencyLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billingFrequencyCode
	 * @return BillingFrequencyLocal
	 * @throws CreateException
	 */
	public static BillingFrequencyLocal getBillingFrequencyLocal(String billingFrequencyCode)
		throws CreateException
	{
		BillingFrequencyLocalHome billingFrequencyLocalHome =
			(BillingFrequencyLocalHome) getLocal(BILLING_FREQUENCY_LOCAL_HOME);
		return billingFrequencyLocalHome.create(billingFrequencyCode);
	}

	/**
	 * To get the BillingBlockLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billingBlock
	 * @return BillingBlockLocal
	 * @throws CreateException
	 */
	public static BillingBlockLocal getBillingBlockLocal(String billingBlock) throws CreateException
	{
		BillingBlockLocalHome billingBlockLocalHome = (BillingBlockLocalHome) getLocal(BILLING_BLOCK_LOCAL_HOME);
		return billingBlockLocalHome.create(billingBlock);
	}

	/**
	 * To get the GeoSecOffLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param salesOrg
	 * @return GeoSecOffLocal
	 * @throws CreateException
	 */
	public static GeoSecOffLocal getGeoSecOffLocal(String salesOrg) throws CreateException
	{
		GeoSecOffLocalHome geoSecOffLocalHome = (GeoSecOffLocalHome) getLocal(GEO_SEC_OFF_LOCAL_HOME);
		return geoSecOffLocalHome.create(salesOrg);
	}

	/**
	 * To get the GroupLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param groupName
	 * @return GroupLocal
	 * @throws CreateException
	 */
	public static GroupLocal getGroupLocal(String groupName) throws CreateException
	{
		GroupLocalHome groupLocalHome = (GroupLocalHome) getLocal(GROUP_LOCAL_HOME);
		return groupLocalHome.create(groupName);
	}

	/**
	 * To get the RoleLocal 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param role
	 * @return RoleLocal
	 * @throws CreateException
	 */
	public static RoleLocal getRoleLocal(String role) throws CreateException
	{
		RoleLocalHome roleLocalHome = (RoleLocalHome) getLocal(ROLE_LOCAL_HOME);
		return roleLocalHome.create(role);
	}

	/**
	 * To get the OfferingTypeLocal 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param offeringType
	 * @return OfferingTypeLocal
	 * @throws CreateException
	 */
	public static OfferingTypeLocal getOfferingTypeLocal(String offeringType,String offeringDesc) throws CreateException
	{
		OfferingTypeLocalHome offeringTypeLocalHome = (OfferingTypeLocalHome) getLocal(OFFERING_TYPE_LOCAL_HOME);
		return offeringTypeLocalHome.create(offeringType,offeringDesc);
	}
	
	/**
	 * To get the SalesAreaLocal 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param salesOrg
	 * @param divisionCode
	 * @param distributionChannelCode
	 * @return SalesAreaLocal
	 * @throws CreateException
	 */
	public static SalesAreaLocal getSalesAreaLocal(String salesOrg, String divisionCode, String distributionChannelCode) throws CreateException
	{
		SalesAreaLocalHome salesAreaLocalHome = (SalesAreaLocalHome) getLocal(SALES_AREA_LOCAL_HOME);
		return salesAreaLocalHome.create(salesOrg, divisionCode, distributionChannelCode);
	}
	
	/**
	 * To get the AccessHistoryLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @param userID
	 * @param accessDate
	 * @param accessTime
	 * @return AccessHistoryLocal
	 * @throws CreateException
	 */
	public static AccessHistoryLocal getAccessHistoryLocal(int proposalID, String userID, Date accessDate, Time accessTime) throws CreateException
	{
		AccessHistoryLocalHome accessHistoryLocalHome = (AccessHistoryLocalHome) getLocal(ACCESS_HISTORY_LOCAL_HOME);
		return accessHistoryLocalHome.create(proposalID, userID, accessDate, accessTime, 0);
	}
	
	/**
	 * To get the ActionDescriptionLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2011 
	 * Nomita
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * 
	 */
	public static ActionDescriptionLocal getActionDescriptionLocal(String actionDescription) throws CreateException
	{
		ActionDescriptionLocalHome actionDescriptionLocalHome = (ActionDescriptionLocalHome) getLocal(ACTION_DESCRIPTION_LOCAL_HOME);
		return actionDescriptionLocalHome.create(actionDescription);
	}
	
	/**
	 * To get the ActionDescriptionLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2011
	 * Nomita
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * 
	 */
	public static ActivityLogLocal getActivityLogLocal(String userId, Date activityDate, Time activityTime) throws CreateException
	{
		ActivityLogLocalHome activityLogLocalHome = (ActivityLogLocalHome) getLocal(ACTIVITY_LOG_LOCAL_HOME);
		return activityLogLocalHome.create(userId, activityDate, activityTime);
	}
	/**
	 * To get the CustomerListLocal
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @param customerListNo
	 * @return CustomerListLocal
	 * @throws CreateException
	 */
	public static CustomerListLocal getCustomerListLocal(int proposalID, String customerListNo) throws CreateException
	{
		CustomerListLocalHome customerListLocalHome = (CustomerListLocalHome) getLocal(CUSTOMER_LIST_LOCAL_HOME);
		return customerListLocalHome.create(proposalID, customerListNo);
	}
	
	/**
     * To get the ErrorListLocal
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 6, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param messageID
     * @return ErrorListLocal
     * @throws CreateException
     * @param proposalId 
     */
	public static ErrorListLocal getErrorListLocal(Integer messageID, int proposalId) throws CreateException
	{
		ErrorListLocalHome errorListLocalHome = (ErrorListLocalHome) getLocal(ERROR_LIST_LOCAL_HOME);
		return errorListLocalHome.create(messageID,proposalId);
	}
	
	/**
	 * To get the StatusLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param statusCode
	 * @return StatusLocal
	 * @throws CreateException
	 */
	public static StatusLocal getStatusLocal(String statusCode) throws CreateException
	{
		StatusLocalHome statusLocalHome = (StatusLocalHome) getLocal(STATUS_LOCAL_HOME);
		return statusLocalHome.create(statusCode);
	}

	/**
	 * To get the SharingLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @param accessTo
	 * @return SharingLocal
	 * @throws CreateException
	 */
	public static SharingLocal getSharingLocal(int proposalID, String accessTo) throws CreateException
	{
		SharingLocalHome sharingLocalHome = (SharingLocalHome) getLocal(SHARING_LOCAL_HOME);
		return sharingLocalHome.create(proposalID, accessTo);
	}

	/**
	 * To get the EELocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeID
	 * @param swoID
	 * @param dmID
	 * @param customerID
	 * @param proposalID
	 * @param eeNo
	 * @return EELocal
	 * @throws CreateException
	 */
	public static EELocal getEELocal(int eeID, int swoID, int dmID, int customerID, int proposalID, String eeNo) throws CreateException
	{
		EELocalHome eeLocalHome = (EELocalHome) getLocal(EE_LOCAL_HOME);
		return eeLocalHome.create(eeID, swoID, dmID, customerID, proposalID, eeNo);
	}
	
	/**
     * To get the VarianceEELocal
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 6, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param eeID
     * @param swoID
     * @param dmID
     * @param customerID
     * @param proposalID
     * @return VarianceEELocal
     * @throws CreateException
     * @param eeNo 
     */
	public static VarianceEELocal getVarianceEELocal(int eeID, int swoID, int dmID, int customerID, int proposalID,String eeNo) throws CreateException
	{
		VarianceEELocalHome varianceEELocalHome = (VarianceEELocalHome) getLocal(VARIABLE_EE_LOCAL_HOME);
		return varianceEELocalHome.create(eeID, swoID, dmID, customerID, proposalID,eeNo);
	}
	
	/**
     * To get the HistoryEELocal
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 6, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param eeID
     * @param swoID
     * @param dmID
     * @param customerID
     * @param proposalID
     * @return HistoryEELocal
     * @throws CreateException
     * @param eeNo 
     */
	public static HistoryEELocal getHistoryEELocal(int eeID, int swoID, int dmID, int customerID, int proposalID,String eeNo) throws CreateException
	{
		HistoryEELocalHome historyEELocalHome = (HistoryEELocalHome) getLocal(HISTORY_EE_LOCAL_HOME);
		return historyEELocalHome.create(eeID, swoID, dmID, customerID, proposalID,eeNo);
	}

	/**
	 * To get the PriceLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param priceID
	 * @param eeID
	 * @param swoID
	 * @param dmID
	 * @param customerID
	 * @param proposalID
	 * @return PriceLocal
	 * @throws CreateException
	 */
	public static PriceLocal getPriceLocal(int priceID, int eeID, int swoID, int dmID, int customerID, int proposalID) throws CreateException
	{
		PriceLocalHome priceLocalHome = (PriceLocalHome) getLocal(PRICE_LOCAL_HOME);
		return priceLocalHome.create(priceID, eeID, swoID, dmID, customerID, proposalID);
	}
	
	/**
	 * To get the VariancePriceLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param priceID
	 * @param eeID
	 * @param swoID
	 * @param dmID
	 * @param customerID
	 * @param proposalID
	 * @return VariancePriceLocal
	 * @throws CreateException
	 */
	public static VariancePriceLocal getVariancePriceLocal(int priceID, int eeID, int swoID, int dmID, int customerID, int proposalID) throws CreateException
	{
		VariancePriceLocalHome variancePriceLocalHome = (VariancePriceLocalHome) getLocal(VARIANCE_PRICE_LOCAL_HOME);
		return variancePriceLocalHome.create(priceID, eeID, swoID, dmID, customerID, proposalID);
	}

	/**
	 * To get the SWOLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoID
	 * @param dmID
	 * @param customerID
	 * @param proposalID
	 * @param swoNo
	 * @return SWOLocal
	 * @throws CreateException
	 */
	public static SWOLocal getSWOLocal(int swoID, int dmID, int customerID, int proposalID, String swoNo) throws CreateException
	{
		SWOLocalHome swoLocalHome = (SWOLocalHome) getLocal(SWO_LOCAL_HOME);
		return swoLocalHome.create(swoID, dmID, customerID, proposalID, swoNo);
	}
	
	/**
     * To get the HistorySWOLocal
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 6, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param swoID
     * @param dmID
     * @param customerID
     * @param proposalID
     * @return HistorySWOLocal
     * @throws CreateException
     * @param lastUpdatedDate
     * @param swoNo 
     */
	public static HistorySWOLocal getHistorySWOLocal(int swoID, int dmID, int customerID, int proposalID,String swoNo,java.sql.Date lastUpdatedDate) throws CreateException
	{
		HistorySWOLocalHome historySWOLocalHome = (HistorySWOLocalHome) getLocal(HISTORY_SWO_LOCAL_HOME);
		return historySWOLocalHome.create(swoID, dmID, customerID, proposalID,swoNo,lastUpdatedDate);
	}
	
	/**
     * To get the VarianceSWOLocal
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 6, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param swoID
     * @param dmID
     * @param customerID
     * @param proposalID
     * @return VarianceSWOLocal
     * @throws CreateException
     * @param swoNo 
     */
	public static VarianceSWOLocal getVarianceSWOLocal(int swoID, int dmID, int customerID, int proposalID,String swoNo) throws CreateException
	{
		VarianceSWOLocalHome varianceSWOLocalHome = (VarianceSWOLocalHome) getLocal(VARIANCE_SWO_LOCAL_HOME);
		return varianceSWOLocalHome.create(swoID, dmID, customerID, proposalID,swoNo);
	}

	/**
	 * To get the SWOInfoLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SWOInfoLocal
	 * @throws CreateException
	 */
	public static SWOInfoLocal getSWOinfoLocal() throws CreateException
	{
		SWOInfoLocalHome swoInfoLocalHome = (SWOInfoLocalHome) getLocal(SWO_INFO_LOCAL_HOME);
		return swoInfoLocalHome.create();
	}
	
		
	/**
	 * To get the SWOManagerLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SWOManagerLocal
	 * @throws CreateException
	 */
	public static SWOManagerLocal getSWOManagerLocal() throws CreateException
	{
		SWOManagerLocalHome swoManagerLocalHome = (SWOManagerLocalHome) getLocal(SWO_MANAGER_LOCAL_HOME);
		return swoManagerLocalHome.create();
	}
	
	/**
	 * To get the DMManagerLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DMManagerLocal
	 * @throws CreateException
	 */
	public static DMManagerLocal getDMManagerLocal() throws CreateException
	{
		DMManagerLocalHome dmManagerLocalHome = (DMManagerLocalHome) getLocal(DM_MANAGER_LOCAL_HOME);
		return dmManagerLocalHome.create();
	}
	
	/**
	 * To get the EEPriceManagerLocal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return EEPriceManagerLocal
	 * @throws CreateException
	 */
	public static EEPriceManagerLocal getEEPriceManagerLocal() throws CreateException
	{
		EEPriceManagerLocalHome eePriceManagerLocalHome = (EEPriceManagerLocalHome) getLocal(EE_PRICE_MANAGER_LOCAL_HOME);
		return eePriceManagerLocalHome.create();
	}
	
	/**
     * This method returns TempEELocal
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 22, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return
     * @throws CreateException
     * @param customerId
     * @param dmId
     * @param proposalId 
     */
	public static TempEELocal getTempEELocal(int proposalId,int customerId,int dmId)throws CreateException
	{
		TempEELocalHome tempEELocalHome=(TempEELocalHome)getLocal(TEMP_EE_LOCAL_HOME);
		return tempEELocalHome.create(proposalId,customerId,dmId);
	}
	
	/**
	 *  
	 * This method get Proposal Manager Local
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 * @throws CreateException
	 */
	public static ProposalManagerLocal getProposalManagerLocal()throws CreateException
	{
		ProposalManagerLocalHome proposalManagerLocalHome=(ProposalManagerLocalHome)getLocal(PROPOSAL_MANAGER_HOME_LOCAL);
		return proposalManagerLocalHome.create();
	}
	
	/**
	 * To get the ProposalManager 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalManager
	 * @throws RemoteException
	 * @throws CreateException
	 */
	
	public static ProposalManager getProposalManagerRemote() throws RemoteException, CreateException
	{
		ProposalManagerHome proposalManagerHome = (ProposalManagerHome) getRemote(PROPOSAL_MANAGER_HOME);
		return proposalManagerHome.create();
	}
	
	/**
	 * To get the ProposalManager 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @return ErrorListManagerLocal
	 * @throws CreateException
	 */
	
	public static ErrorListManagerLocal getErrorListManagerLocal() throws CreateException
	{
		ErrorListManagerLocalHome errorListManagerLocalHome = (ErrorListManagerLocalHome) getLocal(ERROR_LIST_MANAGER_LOCAL_HOME);
		return errorListManagerLocalHome.create();
	}
	
		
	/**
	 * To get the local home
	 * 
	 * Usage:
	 * 		HomeProvider.getLocal(HomeProvider.JMS_CONNECTOR_LOCAL_HOME); 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param jndiName
	 * @return EJBLocalHome
	 */
	public static EJBLocalHome getLocal(String jndiName)
	{
		return ServiceLocator.getEJBHomeFactory().getLocalHome(jndiName);
	}

	/**
	 * To get the remote home 
	 * 
	 * Usage:
	 * 		HomeProvider.getRemote(HomeProvider.USER_MANAGER_REMOTE_HOME);
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param jndiName
	 * @return EJBHome
	 */
	public static EJBHome getRemote(String jndiName)
	{
		return ServiceLocator.getEJBHomeFactory().getRemoteHome(jndiName);
	}
	
	/**
     * esw data local
     *
     * @return ESWDataLocal
     * @throws CreateException
     * GWA Fix for XA
     * @author Saravanan
     * This is done to avoid problem caused by XA Datasource the new Bean will give us flexibility. The methods
     * added in this bean will be used as TX NOT_SUPPORTED.
     */
	public static ESWDataLocal getESWDataLocal() throws CreateException
	{
		ESWDataLocalHome eswDataLocalHome = (ESWDataLocalHome) getLocal(ESW_DATA_LOCAL_HOME);
		return eswDataLocalHome.create();
	}
	
	//	 BH Wave1 - DAD003 - Complex Contract Identifiers - Begin - Bhanu
	/**
     * CBS data local
     *
     * @return CCTypeLocal
     * @throws CreateException
     * 
     * @author Bhanu
     * 
     */
	/*public static CCTypeLocal getCCTypeLocal(String ccType) throws CreateException
	{
		CCTypeLocalHome ccTypeLocalHome = (CCTypeLocalHome) getLocal(CC_TYPE_LOCAL_HOME);
		return ccTypeLocalHome.create(ccType);
	}*/
	
	/**
     * CBS data local
     *
     * @return MCTypeLocal
     * @throws CreateException
     * 
     * @author Bhanu
     * 
     */
	/*public static MCTypeLocal getMCTypeLocal(String mcType) throws CreateException
	{
		MCTypeLocalHome mcTypeLocalHome = (MCTypeLocalHome) getLocal(MC_TYPE_LOCAL_HOME);
		return mcTypeLocalHome.create(mcType);
	}*/
	
	/**
     * CBS data local
     *
     * @return BLBIndicatorLocal
     * @throws CreateException
     * 
     * @author Bhanu
     * 
     */
	public static BLBIndicatorLocal getBLBIndicatorLocal(String blbIndicator) throws CreateException
	{
		BLBIndicatorLocalHome blbIndicatorLocalHome = (BLBIndicatorLocalHome) getLocal(BLB_Indicator_LOCAL_HOME);
		return blbIndicatorLocalHome.create(blbIndicator);		
	}
	// BH Wave1 - DAD003 - Complex Contract Identifiers - End - Bhanu
	
}

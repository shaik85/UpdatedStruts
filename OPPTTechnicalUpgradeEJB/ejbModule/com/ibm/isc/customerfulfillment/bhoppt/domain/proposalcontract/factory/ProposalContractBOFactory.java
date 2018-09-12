/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.StatusLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.StatusLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;


/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */


public class ProposalContractBOFactory {
	private static final String CLASS_NAME = "ProposalContractBOFactory";

	private static final String PROPOSAL_LOCAL_HOME = "ProposalLocalHome";
	private static final String PROPOSAL_COUNT_LOCAL_HOME = "ProposalCountLocalHome";
	private static final String STATUS_LOCAL_HOME = "StatusLocalHome";
//	Mallik //DAD001 start
	static final long MILLIS_IN_A_DAY = 1000*60*60*24; 
	
//	Mallik //DAD001 End

	/**
	 *  
	 * This method is used to find if the proposal name is already present in OPPT
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalName
	 * @return boolean
	 * @author balajiv
	 */

	public boolean isProposalNameExists(String proposalName) {
		String methodName = "isProposalNameExists";

		boolean proposalNameExists = true;

		StringBuffer buffer = new StringBuffer("Proposal Name #");
		buffer.append(proposalName);
		buffer.append("#");

		OPPTLogger.debug(buffer.toString(), CLASS_NAME, methodName);

		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		ProposalLocal proposalLocal = null;

		try {
			proposalLocal = proposalLocalHome.findByName(proposalName);
		} catch (FinderException e) {
			//We do not handle this exception
			proposalNameExists = false;

		}

		if (proposalLocal == null) {
			proposalNameExists = false;
		}

		return proposalNameExists;

	}

	/**
	 * This Factory method is used to get the data proposal or contract. based on the status we either form
	 * ProposalBO or ContractBO 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 * @return ProposalContractBO
	 */

	public ProposalContractBO getProposalContractBO(int proposalId) throws DomainException {
        ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		ProposalLocal proposalLocal = null;
		ProposalKey key = new ProposalKey(proposalId);
		ProposalContractBO proposalContractBO = null;

		try {
			proposalLocal = proposalLocalHome.findByPrimaryKey(key);
			proposalContractBO = getProposalOrContractBO(proposalLocal.getStatusCode().trim());
			populateDataFromEntity(proposalContractBO, proposalLocal);
		} catch (FinderException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractBO", null, e);
			//throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		return proposalContractBO;

	}

	/** 
	 * 
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
	 * @param statusCode
	 * @return 
	 */
	private ProposalContractBO getProposalOrContractBO(String statusCode) {
		ProposalContractBO proposalContractBO = new ProposalContractBO();
		proposalContractBO.setStatusCode(statusCode);

		if (proposalContractBO.isProposal()) {
			proposalContractBO = new ProposalBO();
		} else {
			proposalContractBO = new ContractBO();
		}

		return proposalContractBO;
	}

	/**
	 *  
	 * This method can be used by the factory to populate the data got from the
	 * finder methods.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalContractBO
	 * @param proposalLocal
	 * @author balajiv
	 */
	private void populateDataFromEntity(ProposalContractBO proposalContractBO, ProposalLocal proposalLocal) {
		
		// Set all the data from proposal to the BO.
		StatusLocalHome statusLocalHome = (StatusLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome("StatusLocalHome");
		StatusLocal statusLocal = null;

		proposalContractBO.setProposalId(proposalLocal.getProposalId());
		proposalContractBO.setProposalType(OPPTHelper.trimString(proposalLocal.getProposalType()));
		proposalContractBO.setBillingFreqCode(OPPTHelper.trimString(proposalLocal.getBillingFreqCode()));
		proposalContractBO.setCreatedBy(OPPTHelper.trimString(proposalLocal.getCreatedBy()));
		proposalContractBO.setApprovedBy(OPPTHelper.trimString(proposalLocal.getApprovedBy()));
		proposalContractBO.setStatusCode(OPPTHelper.trimString(proposalLocal.getStatusCode().trim()));
		proposalContractBO.setSalesOrg(OPPTHelper.trimString(proposalLocal.getSalesOrg()));
		proposalContractBO.setDistrChannel(OPPTHelper.trimString(proposalLocal.getDistrChannel()));
		proposalContractBO.setSalesGroup(OPPTHelper.trimString(proposalLocal.getSalesGroup()));
		proposalContractBO.setChannelRole(OPPTHelper.trimString(proposalLocal.getChannelRole()));
		proposalContractBO.setSubmitterRole(OPPTHelper.trimString(proposalLocal.getSubmitterRole()));
		proposalContractBO.setDivisionCode(OPPTHelper.trimString(proposalLocal.getDivisionCode()));
		proposalContractBO.setProposalName(OPPTHelper.trimString(proposalLocal.getProposalName()));
		proposalContractBO.setContrStartDate(proposalLocal.getContractStartDate());
		proposalContractBO.setContrEndDate(proposalLocal.getContractEndDate());
		proposalContractBO.setContrStartPeriod(proposalLocal.getContractStartPeriod());
		proposalContractBO.setContrEndPeriod(proposalLocal.getContractEndPeriod());
		proposalContractBO.setTvmRate(proposalLocal.getTvmRate());
		proposalContractBO.setDiscount(proposalLocal.getDiscount());
		proposalContractBO.setGrowthFactor(proposalLocal.getGrowthFactor());
		proposalContractBO.setSpecialRate(proposalLocal.getSpecialRate());
		proposalContractBO.setAnnvAmount(proposalLocal.getAnniversaryAmt());
		proposalContractBO.setInvoiceAmount(proposalLocal.getInvoiceAmt());
		proposalContractBO.setAmendInd(OPPTHelper.trimString(proposalLocal.getAmentIndicatior()));
		proposalContractBO.setAmendEffectiveDate(proposalLocal.getAmendEffectiveDate());
		proposalContractBO.setDatePriced(proposalLocal.getDatePriced());
		proposalContractBO.setComments(proposalLocal.getComments());
		proposalContractBO.setCreatedDate(proposalLocal.getCreatedDate());
		proposalContractBO.setApprovedDate(proposalLocal.getApprovedDate());
		proposalContractBO.setRegCustomerNo(OPPTHelper.trimString(proposalLocal.getRegCustomerNo()));
		proposalContractBO.setRegCustomerName(proposalLocal.getRegCustomerName());
		proposalContractBO.setRegBillToPartyNo(OPPTHelper.trimString(proposalLocal.getRegBilltoPartyNo()));
		proposalContractBO.setRegBillToPartyName(proposalLocal.getRegBillToPartyName());
		proposalContractBO.setRegPayerNo(OPPTHelper.trimString(proposalLocal.getRegPayerNo()));
		proposalContractBO.setRegPayerName(proposalLocal.getRegPayerName());
		proposalContractBO.setRegShipToPartyNo(OPPTHelper.trimString(proposalLocal.getRegShipToPartyNo()));
		proposalContractBO.setRegShipToPartyName(proposalLocal.getRegShipToPartyName());
		proposalContractBO.setCurrency(OPPTHelper.trimString(proposalLocal.getCurrency()));
		proposalContractBO.setLastUpdatedDate(proposalLocal.getLastUpdatedDate());
		proposalContractBO.setRefetchId(proposalLocal.getRefetchInd());
		proposalContractBO.setFetchDate(proposalLocal.getFetchDate());
		proposalContractBO.setDeltaFetchId(proposalLocal.getDeltaFetchInd());
		proposalContractBO.setContrType(OPPTHelper.trimString(proposalLocal.getContrType()));
		proposalContractBO.setReportName(OPPTHelper.trimString(proposalLocal.getReportName()));
		proposalContractBO.setCapAmount(proposalLocal.getCapAmt());
		proposalContractBO.setCapPlus(proposalLocal.getCapPlus());
		proposalContractBO.setCapMinus(proposalLocal.getCapMinus());
		proposalContractBO.setPreTVM(proposalLocal.getPreTvm());
		proposalContractBO.setContrExtDate(proposalLocal.getContrExtnDate());
		proposalContractBO.setContrRetrDate(proposalLocal.getContrRetrDate());
		proposalContractBO.setContrReplDate(proposalLocal.getContrReplDate());

		proposalContractBO.setContrClsDate(proposalLocal.getContrClsDate());
		
		proposalContractBO.setContrNo(OPPTHelper.trimString(proposalLocal.getContrNo()));
		proposalContractBO.setContrAmendNo(proposalLocal.getContrAmendNo());
		proposalContractBO.setContrRenewNo(proposalLocal.getContrRenewNo());
		proposalContractBO.setRegCustomerLegNo(proposalLocal.getRegCustomerListNo());
		proposalContractBO.setRegBillToPartyLegNo(proposalLocal.getRegBillToPartyListNo());
		proposalContractBO.setRegPayerLegNo(proposalLocal.getRegPayerListNo());
		proposalContractBO.setRegShipToPartyLegNo(proposalLocal.getRegShipToPartyListNo());
		proposalContractBO.setAnnvInvoiceAmount(proposalLocal.getAnnivInvoiceAmount());
		proposalContractBO.setSemiAnnInvoiceAmount(proposalLocal.getSemiAnnivInvoiceAmount());
		proposalContractBO.setQuarterInvoiceAmount(proposalLocal.getQuarterlyInvoiceAmount());
		proposalContractBO.setMonthlyInvoiceAmount(proposalLocal.getMonthlyInvoiceAmount());
		proposalContractBO.setOldContrNo(OPPTHelper.trimString(proposalLocal.getOldContractNo()));
		proposalContractBO.setContrReplNo(proposalLocal.getContractReplNo());
		proposalContractBO.setPreTVMInvoiceAmount(proposalLocal.getPreTVMInvoiceAmt());
		proposalContractBO.setPropTypeApprover(OPPTHelper.trimString(proposalLocal.getApprovedBy()));
		proposalContractBO.setProposalSharing(OPPTHelper.trimString(proposalLocal.getProposalSharing()));
		proposalContractBO.setExtContrNo(OPPTHelper.trimString(proposalLocal.getExtContractNo()));
		proposalContractBO.setContrCreateFlag(OPPTHelper.trimString(proposalLocal.getContractCreateFlag()));
		proposalContractBO.setPakId(OPPTHelper.trimString(proposalLocal.getPakId()));
		proposalContractBO.setAdvanceBilling(OPPTHelper.trimString(proposalLocal.getAdvancedBilling()));
		proposalContractBO.setBillingType(OPPTHelper.trimString(proposalLocal.getBillingType()));
		proposalContractBO.setPayementTerm(OPPTHelper.trimString(proposalLocal.getPaymentTerm()));
		proposalContractBO.setAddValueDays(proposalLocal.getAddValueDays());
		proposalContractBO.setFixedValueDate(proposalLocal.getFixedValueDate());
		proposalContractBO.setTpContrNo(OPPTHelper.trimString(proposalLocal.getTpContractNo()));
		proposalContractBO.setIneligibleInd(OPPTHelper.trimString(proposalLocal.getIneligibleInd()));
		proposalContractBO.setInvoiceInd(proposalLocal.getInvoiceInd());
		proposalContractBO.setDeviatingDateRule(OPPTHelper.trimString(proposalLocal.getDeviationDateRule()));
		proposalContractBO.setBillingBlock(OPPTHelper.trimString(proposalLocal.getBillingBlock()));
		proposalContractBO.setSAndSExcluded(proposalLocal.getSAndSIncluded());
		proposalContractBO.setLockedBy(OPPTHelper.trimString(proposalLocal.getLockedBy()));
		proposalContractBO.setLockedOn(proposalLocal.getLockedOn());
		proposalContractBO.setPoNo(OPPTHelper.trimString(proposalLocal.getPoNo()));
		proposalContractBO.setPoDate(proposalLocal.getPoDate());
		proposalContractBO.setFreeText(OPPTHelper.trimString(proposalLocal.getFreeText()));
		proposalContractBO.setRegCustomerASNo(OPPTHelper.trimString(proposalLocal.getRegCustomerASNO()));
		proposalContractBO.setRegBillToPartASNo(OPPTHelper.trimString(proposalLocal.getRegBillToPartyASNo()));
		proposalContractBO.setRegPayerASNo(OPPTHelper.trimString(proposalLocal.getRegPayerASNo()));
		proposalContractBO.setRegShipToPartyASNo(OPPTHelper.trimString(proposalLocal.getRegShipTOPartyASNo()));
		proposalContractBO.setGsaInd(OPPTHelper.trimString(proposalLocal.getGsaInd()));
		proposalContractBO.setEswFetchDate(proposalLocal.getEswFetchDate());
		proposalContractBO.setEswFetchTime(proposalLocal.getEswFetchTime());
		proposalContractBO.setVarInd(proposalLocal.getVarInd());
		proposalContractBO.setContrVarNo(String.valueOf(proposalLocal.getContractVarNo()));
		proposalContractBO.setSupressInvoice(OPPTHelper.trimString(proposalLocal.getSuppressInvoice()));
		proposalContractBO.setContrPeriodVarNo(proposalLocal.getContractPeriodVarNo());
		proposalContractBO.setVarDate(proposalLocal.getVarDate());
		proposalContractBO.setOrgVarContrNo(OPPTHelper.trimString(proposalLocal.getOrgVarContractNo()));
		proposalContractBO.setCapVariance(proposalLocal.getCapVariance());
		proposalContractBO.setCumValue(proposalLocal.getCumVariance());
		proposalContractBO.setReg9DPartnerNo(OPPTHelper.trimString(proposalLocal.getReg9DPartnerNo()));
		proposalContractBO.setReg9DPartnerName(OPPTHelper.trimString(proposalLocal.getReg9DPartmerName()));
		proposalContractBO.setIGFNumber(OPPTHelper.trimString(proposalLocal.getIgfNumber()));
		proposalContractBO.setSAndsAnniversaryAmount(proposalLocal.getSandsanniversaryamt());
		/*CR6153 start changes  */
		proposalContractBO.setExtendPeriod(proposalLocal.getSandsExtendPeriod());
		proposalContractBO.setSAndsAnniversaryAmt2(proposalLocal.getSandsAnniversaryAmt2());
		proposalContractBO.setSAndsAnniversaryAmt3(proposalLocal.getSandsAnniversaryAmt3());
		proposalContractBO.setSAndsAnniversaryAmt4(proposalLocal.getSandsAnniversaryAmt4());
		proposalContractBO.setSAndsAnniversaryAmt5(proposalLocal.getSandsAnniversaryAmt5());
		proposalContractBO.setSAndSDiscountAmount1(proposalLocal.getSandsDiscountAmount1());
		proposalContractBO.setSAndSDiscountAmount2(proposalLocal.getSandsDiscountAmount2());
		proposalContractBO.setSAndSDiscountAmount3(proposalLocal.getSandsDiscountAmount3());
		proposalContractBO.setSAndSDiscountAmount4(proposalLocal.getSandsDiscountAmount4());
		proposalContractBO.setSAndSDiscountAmount5(proposalLocal.getSandsDiscountAmount5());		
		/*CR6153 end changes */
		proposalContractBO.setSAndsDiscount(proposalLocal.getSandsdiscountamount());
		proposalContractBO.setProposalContent(OPPTHelper.trimString(proposalLocal.getProposalContent()));
		proposalContractBO.setSubmittedBy(OPPTHelper.trimString(proposalLocal.getSubmittedBy()));
		proposalContractBO.setGroupName(OPPTHelper.trimString(proposalLocal.getGroupName()));
		
		// BH Wave1 - DAD 003 - Begin - Manoj
		proposalContractBO.setCpsId(OPPTHelper.trimString(proposalLocal.getCpsId()));
		proposalContractBO.setOcpsId(OPPTHelper.trimString(proposalLocal.getOcpsID()));
		proposalContractBO.setContractType(OPPTHelper.trimString(proposalLocal.getContractType()));
		proposalContractBO.setBlbIndicator(OPPTHelper.trimString(proposalLocal.getBlbIndicator()));
		proposalContractBO.setPrebillIndicator(OPPTHelper.trimString(proposalLocal.getPrebillIndicator()));
		proposalContractBO.setCciInd(OPPTHelper.trimString(proposalLocal.getCciInd()));
		proposalContractBO.setAutoPopulate(OPPTHelper.trimString(proposalLocal.getAutoPopulateInd()));
		// BH Wave1 - DAD 003 - End - Manoj

	}
	/**
	 * This Factory method is used to get the proposals/contracts waiting for the approval for a particular userId
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param String userId
	 * @throws DomainException
	 * @return List
	 */

	public List findProposalContractWaitingForApproval(String userId) throws DomainException {
		ProposalContractBO proposalContractBO = null;
		List proposalContractList = null;
		ProposalLocal proposalLocal = null;
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();

		Collection proposalCollection = null;

		try {
			proposalCollection = proposalLocalHome.findByWaitingForApproval(userId);
		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findProposalContractWaitingForApproval", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if (proposalCollection != null) {
			Iterator proposalContractIterator = proposalCollection.iterator();
			proposalContractList = new ArrayList();
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractList.add(proposalContractBO);
			}
		}
		return proposalContractList;
	}
	/**
	 * This Factory method is used to get the proposals/contracts which are approved by particular userId
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  String userId
	 * @throws DomainException
	 * @return List
	 */

	public List findProposalContractBOApprovedBy(String userId) throws DomainException {
		ProposalContractBO proposalContractBO = null;
		List proposalContractList = null;
		ProposalLocal proposalLocal = null;
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		Collection proposalCollection = null;

		try {
			proposalCollection = proposalLocalHome.findByApprover(userId);
		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findProposalContractBOApprovedBy", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if (proposalCollection != null) {
			Iterator proposalContractIterator = proposalCollection.iterator();
			proposalContractList = new ArrayList();
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractList.add(proposalContractBO);
			}
		}
		return proposalContractList;
	}
	/**
	 * This Factory method is used to get the proposals/contracts which are created by particular userId
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  String userId
	 * @throws DomainException
	 * @return List
	 */

	public List findProposalsContractsBOForUsers(String userId) throws DomainException {
		ProposalContractBO proposalContractBO = null;
		List proposalContractList = null;
		ProposalLocal proposalLocal = null;
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		Collection proposalCollection = null;
		try {
			proposalCollection = proposalLocalHome.findByUser(userId);
		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findProposalsContractsBOForUsers", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if (proposalCollection != null) {
			Iterator proposalContractIterator = proposalCollection.iterator();
			proposalContractList = new ArrayList();
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractList.add(proposalContractBO);
			}
		}
		return proposalContractList;
	}
	
	/**
	 * @param userId
	 * @param groupName
	 * @return
	 * @throws DomainException
	 */
	public List findProposalsContractsBOForUsersGroup(String userId,String groupName) throws DomainException {
			ProposalContractBO proposalContractBO = null;
			List proposalContractList = null;
			ProposalLocal proposalLocal = null;
			ProposalLocalHome proposalLocalHome = getProposalLocalHome();
			Collection proposalCollection = null;
			try {
				proposalCollection = proposalLocalHome.findByUserGroup(userId,groupName);
			} catch (FinderException ex) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findProposalsContractsBOForUsers", null, ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if (proposalCollection != null) {
				Iterator proposalContractIterator = proposalCollection.iterator();
				proposalContractList = new ArrayList();
				while (proposalContractIterator.hasNext()) {
					proposalLocal = (ProposalLocal) proposalContractIterator.next();
					proposalContractBO = new ProposalContractBO();
					populateDataFromEntity(proposalContractBO, proposalLocal);
					proposalContractList.add(proposalContractBO);
				}
			}
			return proposalContractList;
		}
	
	/**
	 * This Factory method is used to get the proposals/contracts which are locked by particular userId
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  String userId
	 * @throws DomainException
	 * @return List
	 */

	public List findProposalContractBOLockedBy(String userId) throws DomainException {
		ProposalContractBO proposalContractBO = null;
		List proposalContractList = null;
		ProposalLocal proposalLocal = null;
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		Collection proposalCollection = null;
		try {
			proposalCollection = proposalLocalHome.findByLockedBy(userId);
		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findProposalContractBOLockedBy", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if (proposalCollection != null) {
			Iterator proposalContractIterator = proposalCollection.iterator();
			proposalContractList = new ArrayList();
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractList.add(proposalContractBO);
			}
		}
		return proposalContractList;
	}
	/**
	 * This Factory method is used to get the proposals/contracts which are locked by particular userId
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param String
	 * @return List
	 */

	public List findProposalForUserAndSalesOrg(String userId) throws DomainException {
		ProposalContractBO proposalContractBO = null;
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		ProposalLocal proposalLocal = null;
		List proposalContractList = null;
		Collection proposalCollection = null;
		try {
			proposalCollection = proposalLocalHome.findByUserAndSalesOrg(userId);
		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findProposalForUserAndSalesOrg", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if (proposalCollection != null) {
			Iterator proposalContractIterator = proposalCollection.iterator();
			proposalContractList = new ArrayList();
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractList.add(proposalContractBO);
			}
		}
		return proposalContractList;
	}

	/**
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalContractBO
	 * @throws DomainException
	 * @author balajiv
	 * 
	 */
	public void createProposalContractBO(ProposalContractBO proposalContractBO) throws DomainException {
       	ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		ProposalLocal proposalLocal = null;
		try {

			proposalLocal = proposalLocalHome.create(proposalContractBO.getProposalId(), proposalContractBO.getProposalName());

			populateDataToEntity(proposalContractBO, proposalLocal);
		

		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "createProposalContractBO", null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

	}

	/**
	 * @param proposalContractBO
	 * @throws DomainException
	 */
	public void updateProposalContractBO(ProposalContractBO proposalContractBO) throws DomainException {

		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		ProposalLocal proposalLocal = null;

		try {

			ProposalKey key = new ProposalKey(proposalContractBO.getProposalId());
			proposalLocal = proposalLocalHome.findByPrimaryKey(key);
			populateDataToEntity(proposalContractBO, proposalLocal);

		} catch (FinderException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "updateProposalContractBO", null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}

	/**
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalContractBO
	 * @throws DomainException
	 * @author balajiv
	 * 
	 */
	public ProposalContractBO findMaxProposalContractBO() throws DomainException {

		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		ProposalContractBO proposalContractBO = new ProposalContractBO();
		ProposalLocal proposalLocal = null;

		try {
			proposalLocal = proposalLocalHome.findMaxProposalId();
			proposalContractBO.setProposalId(proposalLocal.getProposalId());

		} catch (FinderException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findMaxProposalContractBO", null, e);
			proposalContractBO.setProposalId(0);
		}

		return proposalContractBO;

	}

	/**
	 *  
	 * This method can be used by the factory to populate the data got from the
	 * finder methods.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalContractBO
	 * @param proposalLocal
	 * @author balajiv
	 */

	private void populateDataToEntity(ProposalContractBO proposalContractBO, ProposalLocal proposalLocal) {
		proposalLocal.setProposalType(OPPTHelper.trimString(proposalContractBO.getProposalType()));
		proposalLocal.setBillingFreqCode(OPPTHelper.trimString(proposalContractBO.getBillingFreqCode()));
		proposalLocal.setCreatedBy(OPPTHelper.trimString(proposalContractBO.getCreatedBy()));
		proposalLocal.setApprovedBy(OPPTHelper.trimString(proposalContractBO.getApprovedBy()));
		proposalLocal.setStatusCode(OPPTHelper.trimString(proposalContractBO.getStatusCode()));
		proposalLocal.setSalesOrg(OPPTHelper.trimString(OPPTHelper.trimString(proposalContractBO.getSalesOrg())));
		proposalLocal.setDistrChannel(OPPTHelper.trimString(proposalContractBO.getDistrChannel()));
		proposalLocal.setSalesGroup(OPPTHelper.trimString(proposalContractBO.getSalesGroup()));
		proposalLocal.setChannelRole(OPPTHelper.trimString(proposalContractBO.getChannelRole()));
		proposalLocal.setSubmitterRole(OPPTHelper.trimString(proposalContractBO.getSubmitterRole()));
		proposalLocal.setDivisionCode(OPPTHelper.trimString(proposalContractBO.getDivisionCode()));
		proposalLocal.setProposalName(OPPTHelper.trimString(proposalContractBO.getProposalName()));
		proposalLocal.setContractStartDate(proposalContractBO.getContrStartDate());
		proposalLocal.setContractEndDate(proposalContractBO.getContrEndDate());
		proposalLocal.setContractStartPeriod(proposalContractBO.getContrStartPeriod());
		proposalLocal.setContractEndPeriod(proposalContractBO.getContrEndPeriod());
		proposalLocal.setTvmRate(proposalContractBO.getTvmRate());
		proposalLocal.setDiscount(proposalContractBO.getDiscount());
		proposalLocal.setGrowthFactor(proposalContractBO.getGrowthFactor());
		proposalLocal.setSpecialRate(proposalContractBO.getSpecialRate());
		proposalLocal.setAnniversaryAmt(proposalContractBO.getAnnvAmount());
		proposalLocal.setInvoiceAmt(proposalContractBO.getInvoiceAmount());
		proposalLocal.setAmentIndicatior(OPPTHelper.trimString(proposalContractBO.getAmendInd()));
		proposalLocal.setAmendEffectiveDate(proposalContractBO.getAmendEffectiveDate());
		proposalLocal.setDatePriced(proposalContractBO.getDatePriced());
		proposalLocal.setComments(proposalContractBO.getComments());
		proposalLocal.setCreatedDate(proposalContractBO.getCreatedDate());
		proposalLocal.setApprovedDate(proposalContractBO.getApprovedDate());
		proposalLocal.setRegCustomerNo(OPPTHelper.trimString(proposalContractBO.getRegCustomerNo()));
		proposalLocal.setRegCustomerName(OPPTHelper.trimString(proposalContractBO.getRegCustomerName()));
		proposalLocal.setRegBilltoPartyNo(OPPTHelper.trimString(proposalContractBO.getRegBillToPartyNo()));
		proposalLocal.setRegBillToPartyName(OPPTHelper.trimString(proposalContractBO.getRegBillToPartyName()));
		proposalLocal.setRegPayerNo(OPPTHelper.trimString(proposalContractBO.getRegPayerNo()));
		proposalLocal.setRegPayerName(OPPTHelper.trimString(proposalContractBO.getRegPayerName()));
		proposalLocal.setRegShipToPartyNo(OPPTHelper.trimString(proposalContractBO.getRegShipToPartyNo()));
		proposalLocal.setRegShipToPartyName(OPPTHelper.trimString(proposalContractBO.getRegShipToPartyName()));
		proposalLocal.setCurrency(OPPTHelper.trimString(proposalContractBO.getCurrency()));
		proposalLocal.setLastUpdatedDate(proposalContractBO.getLastUpdatedDate());
		proposalLocal.setRefetchInd(OPPTHelper.trimString(proposalContractBO.getRefetchId()));
		proposalLocal.setFetchDate(proposalContractBO.getFetchDate());
		proposalLocal.setDeltaFetchInd(OPPTHelper.trimString(proposalContractBO.getDeltaFetchId()));
		proposalLocal.setContrType(OPPTHelper.trimString(proposalContractBO.getContrType()));
		proposalLocal.setReportName(OPPTHelper.trimString(proposalContractBO.getReportName()));
		proposalLocal.setCapAmt(proposalContractBO.getCapAmount());
		proposalLocal.setCapPlus(proposalContractBO.getCapPlus());
		proposalLocal.setCapMinus(proposalContractBO.getCapMinus());
		proposalLocal.setPreTvm(proposalContractBO.getPreTVM());
		proposalLocal.setContrExtnDate(proposalContractBO.getContrExtDate());
		proposalLocal.setContrRetrDate(proposalContractBO.getContrRetrDate());
		proposalLocal.setContrReplDate(proposalContractBO.getContrReplDate());
//MALLIK //DAD001 Start		
if(proposalContractBO.getStatusCode().equals("CL")&& null!=proposalContractBO.getContrReplDate()){
	proposalLocal.setContrClsDate((new java.sql.Date(proposalContractBO.getContrReplDate().getTime()-MILLIS_IN_A_DAY)));
}else if(proposalContractBO.getStatusCode().equals("CL")&& null==proposalContractBO.getContrClsDate()){
	proposalLocal.setContrClsDate(proposalContractBO.getContrEndPeriod());
}else{
		proposalLocal.setContrClsDate(proposalContractBO.getContrClsDate());
}
//MALLIK //DAD001 End
		proposalLocal.setContrNo(OPPTHelper.trimString(proposalContractBO.getContrNo()));
		proposalLocal.setContrAmendNo(proposalContractBO.getContrAmendNo());
		proposalLocal.setContrRenewNo((int) proposalContractBO.getContrRenewNo());
		proposalLocal.setRegCustomerListNo(OPPTHelper.trimString(proposalContractBO.getRegCustomerLegNo()));
		proposalLocal.setRegBillToPartyListNo(OPPTHelper.trimString(proposalContractBO.getRegBillToPartyLegNo()));
		proposalLocal.setRegPayerListNo(OPPTHelper.trimString(proposalContractBO.getRegPayerLegNo()));
		proposalLocal.setRegShipToPartyListNo(OPPTHelper.trimString(proposalContractBO.getRegShipToPartyLegNo()));
		proposalLocal.setAnnivInvoiceAmount(proposalContractBO.getAnnvInvoiceAmount());
		proposalLocal.setSemiAnnivInvoiceAmount(proposalContractBO.getSemiAnnInvoiceAmount());
		proposalLocal.setQuarterlyInvoiceAmount(proposalContractBO.getQuarterInvoiceAmount());
		proposalLocal.setMonthlyInvoiceAmount(proposalContractBO.getMonthlyInvoiceAmount());
		proposalLocal.setOldContractNo(OPPTHelper.trimString(proposalContractBO.getOldContrNo()));
		proposalLocal.setContractReplNo((int) proposalContractBO.getContrReplNo());
		proposalLocal.setPreTVMInvoiceAmt(proposalContractBO.getPreTVMInvoiceAmount());
		proposalLocal.setProposalSharing(proposalContractBO.getProposalSharing());
		proposalLocal.setExtContractNo(OPPTHelper.trimStringToNull(proposalContractBO.getExtContrNo()));
		proposalLocal.setContractCreateFlag(proposalContractBO.getContrCreateFlag());
		proposalLocal.setPakId(proposalContractBO.getPakId());
		proposalLocal.setAdvancedBilling(proposalContractBO.getAdvanceBilling());
		proposalLocal.setBillingType(proposalContractBO.getBillingType());
		proposalLocal.setPaymentTerm(proposalContractBO.getPayementTerm());
		proposalLocal.setAddValueDays(proposalContractBO.getAddValueDays());
		proposalLocal.setFixedValueDate(proposalContractBO.getFixedValueDate());
		proposalLocal.setTpContractNo(proposalContractBO.getTpContrNo());
		proposalLocal.setIneligibleInd(proposalContractBO.getIneligibleInd());
		proposalLocal.setInvoiceInd(proposalContractBO.getInvoiceInd());
		proposalLocal.setDeviationDateRule(proposalContractBO.getDeviatingDateRule());
		proposalLocal.setBillingBlock(proposalContractBO.getBillingBlock());
		proposalLocal.setSAndSIncluded(proposalContractBO.getSandSExcluded());
		proposalLocal.setLockedBy(proposalContractBO.getLockedBy());
		proposalLocal.setLockedOn(proposalContractBO.getLockedOn());
		proposalLocal.setPoNo(proposalContractBO.getPoNo());
		proposalLocal.setPoDate(proposalContractBO.getPoDate());
		proposalLocal.setFreeText(proposalContractBO.getFreeText());
		proposalLocal.setRegCustomerASNO(proposalContractBO.getRegCustomerASNo());
		proposalLocal.setRegBillToPartyASNo(proposalContractBO.getRegBillToPartASNo());
		proposalLocal.setRegPayerASNo(proposalContractBO.getRegPayerASNo());
		proposalLocal.setRegShipTOPartyASNo(proposalContractBO.getRegShipToPartyASNo());
		proposalLocal.setGsaInd(proposalContractBO.getGsaInd());
		proposalLocal.setEswFetchDate(proposalContractBO.getEswFetchDate());
		proposalLocal.setEswFetchTime(proposalContractBO.getEswFetchTime());
		proposalLocal.setVarInd(proposalContractBO.getVarInd());
		if (proposalContractBO.getContrVarNo() != null) {
			proposalLocal.setContractVarNo(Integer.parseInt(proposalContractBO.getContrVarNo()));
		}

		proposalLocal.setSuppressInvoice(proposalContractBO.getSupressInvoice());
		proposalLocal.setContractPeriodVarNo(proposalContractBO.getContrPeriodVarNo());
		proposalLocal.setVarDate(proposalContractBO.getVarDate());
		proposalLocal.setOrgVarContractNo(proposalContractBO.getOrgVarContrNo());
		proposalLocal.setCapVariance(proposalContractBO.getCapVariance());
		proposalLocal.setCumVariance(proposalContractBO.getCumValue());
		proposalLocal.setReg9DPartnerNo(proposalContractBO.getReg9DPartnerNo());
		proposalLocal.setReg9DPartmerName(proposalContractBO.getReg9DPartnerName());
		proposalLocal.setIgfNumber(proposalContractBO.getIGFNumber());
		//Nomita Changes for payment method and cal no
	//	System.out.println("ProposalContractBOFactory.populateDataToEntity():payment:"+proposalContractBO.getIGFNumber());
		String paymentMethod;
		if("".equalsIgnoreCase(proposalContractBO.getIGFNumber()))
		//if( proposalContractBO.getIGFNumber()==""  && )
		{
			paymentMethod = "7";
		}
		else
		{
			paymentMethod ="E";
		}
	//	System.out.println("ProposalContractBOFactory.populateDataToEntity():paymentMethod:"+paymentMethod);
		 proposalLocal.setPaymentMethod(paymentMethod);
		 //
		
		// UI Change so we may get -1 which is null
		/*if (proposalContractBO.getSAndsAnniversaryAmount() == -1) {
			proposalLocal.setSandsanniversaryamt(0);
		} else {
			proposalLocal.setSandsanniversaryamt(proposalContractBO.getSAndsAnniversaryAmount());
		}
		CR6153 start changes  
		
		
		if (proposalContractBO.getSAndsAnniversaryAmt2() == -1) {
			proposalLocal.setSandsAnniversaryAmt2(0);
		} else {
		proposalLocal.setSandsAnniversaryAmt2(proposalContractBO.getSAndsAnniversaryAmt2());
		}
		
		if (proposalContractBO.getSAndsAnniversaryAmt3() == -1) {
			proposalLocal.setSandsAnniversaryAmt3(0);
		} else {
		proposalLocal.setSandsAnniversaryAmt3(proposalContractBO.getSAndsAnniversaryAmt3());
		}
		if (proposalContractBO.getSAndsAnniversaryAmt4() == -1) {
			proposalLocal.setSandsAnniversaryAmt4(0);
		} else {
		proposalLocal.setSandsAnniversaryAmt4(proposalContractBO.getSAndsAnniversaryAmt4());
		}
		if (proposalContractBO.getSAndsAnniversaryAmt5() == -1) {
			proposalLocal.setSandsAnniversaryAmt5(0);
		} else {
		proposalLocal.setSandsAnniversaryAmt5(proposalContractBO.getSAndsAnniversaryAmt5());
		}*/
		proposalLocal.setSandsExtendPeriod(proposalContractBO.getExtendPeriod());
		proposalLocal.setSandsAnniversaryAmt2(proposalContractBO.getSAndSDiscountAmount2());
		proposalLocal.setSandsAnniversaryAmt3(proposalContractBO.getSAndSDiscountAmount3());
		proposalLocal.setSandsAnniversaryAmt4(proposalContractBO.getSAndSDiscountAmount4());
		proposalLocal.setSandsAnniversaryAmt5(proposalContractBO.getSAndSDiscountAmount5());
		proposalLocal.setSandsanniversaryamt(proposalContractBO.getSAndsDiscount());
		
		
		proposalLocal.setSandsDiscountAmount1(proposalContractBO.getSAndSDiscountAmount1());
		proposalLocal.setSandsDiscountAmount2(proposalContractBO.getSAndSDiscountAmount2());
		proposalLocal.setSandsDiscountAmount3(proposalContractBO.getSAndSDiscountAmount3());
		proposalLocal.setSandsDiscountAmount4(proposalContractBO.getSAndSDiscountAmount4());
		proposalLocal.setSandsDiscountAmount5(proposalContractBO.getSAndSDiscountAmount5());
		/*CR6153 end changes */
		proposalLocal.setSandsdiscountamount(proposalContractBO.getSAndsDiscount());
		proposalLocal.setProposalContent(proposalContractBO.getProposalContent());
		proposalLocal.setSubmittedBy(proposalContractBO.getSubmittedBy());
		proposalLocal.setGroupName(proposalContractBO.getGroupName());
		
		// BH Wave1 - DAD 003 - Begin - Manoj
		proposalLocal.setCpsId(proposalContractBO.getCpsId());
		//System.out.println("ProposalContractBOFactory.populateDataToEntity():cps:"+proposalContractBO.getCpsId());
		if("".equalsIgnoreCase(proposalContractBO.getCpsId()))
		{
		proposalLocal.setOcpsID("");
		}else
			{proposalLocal.setOcpsID(proposalContractBO.getOcpsId());}
		if("".equalsIgnoreCase(proposalContractBO.getCpsId()))
		{
		proposalLocal.setContractType("");
		}else		
		{proposalLocal.setContractType(proposalContractBO.getContractType());}
		if("".equalsIgnoreCase(proposalContractBO.getCpsId())){
			proposalLocal.setBlbIndicator("");
		}else
		{proposalLocal.setBlbIndicator(proposalContractBO.getBlbIndicator());}
	//	System.out.println("ProposalContractBOFactory.populateDataToEntity():prebill!!!!:"+proposalContractBO.getPrebillIndicator());
		if(!("Select one".equalsIgnoreCase(proposalContractBO.getPrebillIndicator()))){
		//	System.out.println("ProposalContractBOFactory.populateDataToEntity()inside condi::"+proposalContractBO.getPrebillIndicator());
				proposalLocal.setPrebillIndicator(proposalContractBO.getPrebillIndicator());
			}else{
				proposalLocal.setPrebillIndicator("");
			}
		proposalLocal.setCciInd(OPPTHelper.trimString(proposalContractBO.getCciInd()));
		proposalLocal.setAutoPopulateInd(OPPTHelper.trimString(proposalContractBO.getAutoPopulate()));
		// BH Wave1 - DAD 003 - End - Manoj

	}
	/**
	 * This Factory method is used to get the proposals/contracts which are approved by particular userId and not in US sales org
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  String userId
	 * @throws DomainException
	 * @return List
	 */

	public List findProposalContractWaitingForApprovalForProposalApprover(String userId) throws DomainException {
		ProposalContractBO proposalContractBO = null;
		List proposalContractList = null;
		ProposalLocal proposalLocal = null;
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		Collection proposalCollection = null;
		try {
			proposalCollection = proposalLocalHome.findByWaitingForApprovalForProposalApprover(userId);
		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findProposalContractWaitingForApprovalForProposalApprover", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if (proposalCollection != null) {
			Iterator proposalContractIterator = proposalCollection.iterator();
			proposalContractList = new ArrayList();
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractList.add(proposalContractBO);
			}
		}
		return proposalContractList;
	}
	/**
	 * This Factory method is used to get the proposals/contracts which are approved by particular userId and not in US sales org
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  String userId
	 * @throws DomainException
	 * @return List
	 */

	public List findProposalContractWaitingForApprovalForCreateApprove(String userId) throws DomainException {
		ProposalContractBO proposalContractBO = null;
		List proposalContractList = null;
		ProposalLocal proposalLocal = null;
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		Collection proposalCollection = null;
		try {
			proposalCollection = proposalLocalHome.findByWaitingForApprovalForCreateApprove(userId);
		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findProposalContractWaitingForApprovalForCreateApprove", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if (proposalCollection != null) {
			Iterator proposalContractIterator = proposalCollection.iterator();
			proposalContractList = new ArrayList();
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractList.add(proposalContractBO);
			}
		}
		return proposalContractList;
	}
	/**
	 * This Factory method is used to get the proposals/contracts which are approved by particular userId and not in US sales org
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  String userId
	 * @throws DomainException
	 * @return List
	 */

	public List findProposalContractWaitingForCSOAndMark(String userId) throws DomainException {
		ProposalContractBO proposalContractBO = null;
		List proposalContractList = null;
		ProposalLocal proposalLocal = null;
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		Collection proposalCollection = null;
		try {
			proposalCollection = proposalLocalHome.findProposalContractWaitingForCSOAndMark(userId);
		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findProposalContractWaitingForCSOAndMark", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if (proposalCollection != null) {
			Iterator proposalContractIterator = proposalCollection.iterator();
			proposalContractList = new ArrayList();
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractList.add(proposalContractBO);
			}
		}
		return proposalContractList;
	}

	/** 
	 * To get the proposal local home 
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
	 */
	private ProposalLocalHome getProposalLocalHome() {
		return (ProposalLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(PROPOSAL_LOCAL_HOME);
	}

	
	private ProposalCountLocalHome getProposalCountLocalHome() {
		return (ProposalCountLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(PROPOSAL_COUNT_LOCAL_HOME);
	}
	/** 
	 * Delete a proposal or a contract 
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
	 * @author prakash
	 * @exception DomainException
	 * @param ProposalBO 
	 */

	public void deleteProposalContractBO(ProposalContractBO proposalBO) throws DomainException {
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		try {
			ProposalLocal proposalLocal = proposalLocalHome.findByPrimaryKey(new ProposalKey(proposalBO.getProposalId()));
			proposalLocal.remove();
		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "deleteProposalContractBO", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);

		} catch (RemoveException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "deleteProposalContractBO", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

	}

	/** 
	 *  
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
	 * @param ProposalContractBO 
	 */
	public ProposalContractBO getProposalContractBO(String proposalName) throws DomainException {
		String methodName = "getProposalContractBO";
		
		StringBuffer buffer = new StringBuffer("Proposal Name #");
		buffer.append(proposalName);
		buffer.append("#");

		OPPTLogger.debug(buffer.toString(), CLASS_NAME, methodName);

		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		ProposalContractBO proposalContractBO = new ProposalContractBO();
		ProposalLocal proposalLocal = null;
		try {
			proposalLocal = proposalLocalHome.findByName(proposalName);
		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractBO", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		populateDataFromEntity(proposalContractBO, proposalLocal);

		return proposalContractBO;
	}

	/**
	 * @param userId
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws DomainException
	 */
	public List findContractBOForUserForDateRange(String userId, Date startDate, Date endDate) throws DomainException {
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		ProposalContractBO proposalContractBO = null;
		ProposalLocal proposalLocal = null;
		Collection proposalCollection = null;
		List proposalContractList = null;
		try {
			proposalCollection = proposalLocalHome.findByUserForDateRange(userId, startDate, endDate);
		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findContractBOForUserForDateRange", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		if (proposalCollection != null) {
			Iterator proposalContractIterator = proposalCollection.iterator();
			proposalContractList = new ArrayList();
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractList.add(proposalContractBO);
			}
		}
		return proposalContractList;
	}
	
	/**
	 * @param userId
	 * @param groupName
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws DomainException
	 */
	public List findContractBOForUserForDateRangeinGroup(String userId, String groupName, Date startDate, Date endDate) throws DomainException {
			ProposalLocalHome proposalLocalHome = getProposalLocalHome();
			ProposalContractBO proposalContractBO = null;
			ProposalLocal proposalLocal = null;
			Collection proposalCollection = null;
			List proposalContractList = null;
			try {
				proposalCollection = proposalLocalHome.findByDateRangeForGroup(userId,groupName, startDate, endDate);
			} catch (FinderException ex) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findContractBOForUserForDateRange", null, ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			if (proposalCollection != null) {
				Iterator proposalContractIterator = proposalCollection.iterator();
				proposalContractList = new ArrayList();
				while (proposalContractIterator.hasNext()) {
					proposalLocal = (ProposalLocal) proposalContractIterator.next();
					proposalContractBO = new ProposalContractBO();
					populateDataFromEntity(proposalContractBO, proposalLocal);
					proposalContractList.add(proposalContractBO);
				}
			}
			return proposalContractList;
		}

	/** 
	 *  
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
	 * @param ProposalContractBO 
	 */
	public List findProposalBOForProposalIDs(String[] proposalIds) throws DomainException {
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		ProposalBO proposalBO;
		ProposalLocal proposalLocal = null;

		List proposalIdsList = new ArrayList();
		for (int i = 0; i < proposalIds.length; i++) {
			if (null != proposalIds[i]) {
				ProposalKey proposalKey = new ProposalKey(Integer.parseInt(proposalIds[i]));
				try {
					proposalLocal = proposalLocalHome.findByPrimaryKey(proposalKey);
				} catch (FinderException ex) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "findProposalBOForProposalIDs", null, ex);
					throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
				}
				proposalBO = new ProposalBO();
				populateDataFromEntity(proposalBO, proposalLocal);
				proposalIdsList.add(proposalBO);
			}
		}

		return proposalIdsList;
	}

	/** 
	 * Returns the ProposalContractBO for a variance proposal, which has relation with
	 * original contract
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param orgVarContractNumber
	 * @return ProposalContractBO
	 * @throws DomainException 
	 */
	public ProposalContractBO getProposalContractBOOfVarianceProposal(String orgVarContractNumber) throws DomainException {
		ProposalLocalHome home = getProposalLocalHome();
		ProposalContractBO proposalContractBO = null;
		OPPTLogger.debug("Original ContractNumber = " + orgVarContractNumber, "ProposalContractBOFactory", "getProposalContractBOOfVarianceProposal");
		if (orgVarContractNumber == null) {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractBOOfVarianceProposal", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		try {
			ProposalLocal local = home.findRelatedVarianceProposal(orgVarContractNumber);
			proposalContractBO = getProposalOrContractBO(local.getStatusCode().trim());
			populateDataFromEntity(proposalContractBO, local);
		} catch (FinderException ex) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractBOOfVarianceProposal", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		} catch (Exception e) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractBOOfVarianceProposal", null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		return proposalContractBO;
	}

	/** 
	 * Returns the ProposalContractBO of a related proposal to an overlay contract
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldContractNumber
	 * @return ProposalContractBO
	 * @throws DomainException 
	 */
	public ProposalContractBO getProposalContractBOForRelatedProposal(String oldContractNumber) throws DomainException {
		ProposalLocalHome home = getProposalLocalHome();
		ProposalContractBO proposalContractBO = null;

		if (oldContractNumber == null) {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractBOForRelatedProposal", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		try {
			ProposalLocal local = home.findRelatedProposalForContract(oldContractNumber);
			proposalContractBO = getProposalOrContractBO(local.getStatusCode().trim());
			populateDataFromEntity(proposalContractBO, local);
		} catch (FinderException ex) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractBOForRelatedProposal", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		} catch (Exception e) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractBOForRelatedProposal", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		return proposalContractBO;
	}

	/** 
	 * Retrieves the object based on the contract number provided. If boolean is true, finds by 
	 * OPPT contract number. Else, finds by both OPPT contract number or External contract number 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contractNumber
	 * @param byContrNum
	 * @return ProposalContractBO
	 * @throws DomainException 
	 */
	public ProposalContractBO getProposalContractBOForContractNumber(String contractNumber, boolean byContrNum) throws DomainException {
		ProposalLocalHome home = null;
		ProposalContractBO proposalContractBO = null;
		ProposalLocal local = null;

		if (contractNumber == null) {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractBOForContractNumber", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0636);
		}

		try {
			home = getProposalLocalHome();
			if (byContrNum) {
				local = home.findByContractNumber(contractNumber);
			} else {
				local = home.findByContrORExternalContrNum(contractNumber);
			}
			proposalContractBO = getProposalOrContractBO(local.getStatusCode().trim());
			populateDataFromEntity(proposalContractBO, local);
		} catch (FinderException ex) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractBOForContractNumber", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0636);
		} catch (Exception e) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractBOForContractNumber", null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		return proposalContractBO;
	}

	/**
	 * @param contractNumber
	 * @return
	 * @throws DomainException
	 */
	public ProposalContractBO getOriginalProposalContractForTP(String contractNumber) throws DomainException {
		ProposalLocalHome home = null;
		ProposalContractBO proposalContractBO = null;
		ProposalLocal local = null;

		if (contractNumber == null) {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractForTP", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0636);
		}

		try {
			home = getProposalLocalHome();
			local = home.findByCntrNumberORExternalCntrNumAndStatus(contractNumber);
			proposalContractBO = getProposalOrContractBO(local.getStatusCode().trim());
			populateDataFromEntity(proposalContractBO, local);
		} catch (FinderException ex) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractForTP", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0435);
		} catch (Exception e) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "getProposalContractForTP", null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		return proposalContractBO;
	}

	/**
	 * This method is used to generate contract Number
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param appender
	 * @return
	 * @throws Exception
	 */
	public ProposalContractBO getProposalContractBOWithMaxContractNumber(String appender) throws Exception {
		ProposalLocalHome home = null;
		ProposalContractBO proposalContractBO = new ProposalContractBO();
		ProposalLocal local = null;
		String contractNo = null;
		try {
			home = getProposalLocalHome();
			Collection col = home.findMaxContractNumber();
			Iterator iter = col.iterator();
			if (iter.hasNext()) {
				local = (ProposalLocal) iter.next();
				contractNo = local.getContrNo();
			} else {
				contractNo = "0000001P01";
			}
		} catch (FinderException ex) {
			contractNo = "0000001P01";
		}

		StringBuffer buffer = new StringBuffer();
		int newContractNumberPrefix = Integer.parseInt(contractNo.substring(0, 7)) + 1;
		buffer.append(newContractNumberPrefix);

		int padding = 7 - buffer.length();

		for (int i = 0; i < padding; i++) {
			buffer.insert(0, "0");
		}

		buffer.append(appender);
		OPPTLogger.debug(buffer.toString(), "ProposalContractBOFactory", "getProposalContractBOWithMaxContractNumber");
		proposalContractBO.setContrNo(buffer.toString());

		return proposalContractBO;
	}

	/**
		 * This method finds by TP contractNumber
		 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Feb 6, 2004 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param tpContrNo
		 * @return
		 * @throws DomainException
		 */
	public ProposalContractBO findByTPContractNo(String tpContrNo) throws DomainException {
		ProposalLocalHome home = null;
		ProposalContractBO proposalContractBO = new ProposalContractBO();
		ProposalLocal local = null;

		if (tpContrNo == null) {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "ProposalContractBOFactory", "findByTPContractNo", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		try {
			home = getProposalLocalHome();
			local = home.findBytpContractNo(tpContrNo);
			populateDataFromEntity(proposalContractBO, local);
		} catch (FinderException ex) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "findByTPContractNo", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		} catch (Exception e) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "findByTPContractNo", null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		return proposalContractBO;

	}

	/**
	 * @param contractNo
	 * @return
	 * @throws DomainException
	 */
	public List findAllVarianceContract(String contractNo) throws DomainException {

		ProposalContractBO proposalContractBO = null;
		List proposalContractList = null;
		ProposalLocal proposalLocal = null;
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		Collection proposalCollection = null;

		try {
			proposalCollection = proposalLocalHome.findAllVarianceContracts(contractNo);
		} catch (FinderException ex) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "findAllVarianceContract", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if (proposalCollection != null) {
			Iterator proposalContractIterator = proposalCollection.iterator();
			proposalContractList = new ArrayList();
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractList.add(proposalContractBO);
			}
		}
		return proposalContractList;
	}

	/**
	 * @param contractNo
	 * @param contractPeriodVarNo
	 * @return
	 * @throws DomainException
	 */
	public List findLastVarianceContract(String contractNo, int contractPeriodVarNo) throws DomainException {

		ProposalContractBO proposalContractBO = null;
		List proposalContractList = null;
		ProposalLocal proposalLocal = null;
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		Collection proposalCollection = null;

		try {
			proposalCollection = proposalLocalHome.findByVarContractNo(contractNo, contractPeriodVarNo);
		} catch (FinderException ex) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "findAllVarianceContract", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if (proposalCollection != null) {
			Iterator proposalContractIterator = proposalCollection.iterator();
			proposalContractList = new ArrayList();
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractList.add(proposalContractBO);
			}
		}
		return proposalContractList;
	}
	/*
		 * MN 19705633
		 * Balaji- Starts 
		 */
	/**
	 * @param submittedBy
	 * @return
	 * @throws DomainException
	 */
	public List findProposalsSubmittedBy(String submittedBy) throws DomainException {

		ProposalContractBO proposalContractBO = null;
		List proposalContractList = new ArrayList();
		ProposalLocal proposalLocal = null;
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		Collection proposalCollection = null;

		try {
			proposalCollection = proposalLocalHome.findBySubmittedBy(submittedBy);
		} catch (FinderException ex) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "ProposalContractBOFactory", "findAllVarianceContract", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if (proposalCollection != null) {
			Iterator proposalContractIterator = proposalCollection.iterator();
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractList.add(proposalContractBO);
			}
		}
		return proposalContractList;
	}

	/*
	 *  
	 * For UD 
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Apr 20, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Balaji Venkatesan
	 * @version 5.1A
	 */

	public ProposalContractBO[] findProposalsCreatedFromGroup(String userId, String groupName, int role) {

		ProposalContractBO proposalContractBO = null;
		ProposalContractBO proposalContractBOArray [] = null;
		ProposalLocal proposalLocal = null;
		ProposalLocalHome proposalLocalHome = getProposalLocalHome();
		Collection proposalCollection = null;

		try {
			proposalCollection = proposalLocalHome.findByUserGroup(userId,groupName);
				
		} catch (FinderException ex) {
			// NO issues as some users may not have any proposals assosiated
		}
		if (proposalCollection != null && proposalCollection.size() >0) {
			proposalContractBOArray  = new ProposalContractBO [ proposalCollection.size()];  
			Iterator proposalContractIterator = proposalCollection.iterator();
			int i=0;
			while (proposalContractIterator.hasNext()) {
				proposalLocal = (ProposalLocal) proposalContractIterator.next();
				proposalContractBO = new ProposalContractBO();
				populateDataFromEntity(proposalContractBO, proposalLocal);
				proposalContractBOArray [i] = proposalContractBO;
				i++;
			}
		}

		return proposalContractBOArray;

	}
	
	
	/*
	 *  
	 * For DAD001 -BH-OPPT 
	 *
	 * To create new row in the proposalcount Table
	 * 
	 * @author Anand Sugumaran
	 * @version1.0
	 */
	
	
	public void createProposalCount(ProposalContractBO proposalContractBO)throws DomainException {
		
		
       	ProposalCountLocalHome proposalCountLocalHome = getProposalCountLocalHome();
		ProposalCountLocal proposalCountLocal = null;
		
		try {			
						
			proposalCountLocal = proposalCountLocalHome.create(proposalContractBO.getSalesOrg(),proposalContractBO.getProposalContent(),proposalContractBO.getSelectedCustomerName());

			proposalCountLocal.setProposalCount(1);
			

		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ProposalContractBOFactory", "createProposalCount", null, e);
			
		}

	}
	
	
	

	/*
	 *  
	 * For DAD001 -BH-OPPT 
	 *
	 * 
	 * To get the Maximum count in the proposalcount Table.
	 * @author Anand Sugumaran
	 * @version1.0
	 */
	
	
	
	
	public  int getMaxProposalCount(ProposalContractBO proposalContractBO)throws DomainException  {
		int proposalCount;
		ProposalCountLocalHome proposalCountLocalHome = getProposalCountLocalHome();
		
		
		
		ProposalCountKey proposalCountKey = new ProposalCountKey(proposalContractBO.getSalesOrg(),proposalContractBO.getProposalContent(),proposalContractBO.getSelectedCustomerName());
		// ProposalDAO.getMaxProposalCount(salesOrg,customerName,proposalcontent1);
		try{
		
		ProposalCountLocal proposalCountLocal = proposalCountLocalHome.findByPrimaryKey(proposalCountKey);
		//update the proposal count table by incrementing the count value
	
		proposalCount = proposalCountLocal.getProposalCount()+1;
	
		proposalCountLocal.setProposalCount(proposalCount);
		
		
		}catch (FinderException ex){
		
			//Create the proposl count table
			proposalCount =1;
			try {
			
				
				createProposalCount(proposalContractBO);
			} catch (DomainException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
return proposalCount;
	
	}
	
	

	
	
	
	
	
	
	
}

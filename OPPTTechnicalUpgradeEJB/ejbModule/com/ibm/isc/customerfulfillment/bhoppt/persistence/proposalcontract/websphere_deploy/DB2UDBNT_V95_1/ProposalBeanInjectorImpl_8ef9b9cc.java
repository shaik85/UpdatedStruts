package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ProposalBeanInjectorImpl_8ef9b9cc
 */
public class ProposalBeanInjectorImpl_8ef9b9cc implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ProposalBeanInjector_8ef9b9cc {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc)cb;
		record.set(0,new Integer(concreteBean.getAddValueDays()));
		record.set(1,concreteBean.getAdvancedBilling());
		record.set(2,concreteBean.getAmentIndicatior());
		record.set(3,concreteBean.getAmendEffectiveDate());
		record.set(4,concreteBean.getApprovedBy());
		record.set(5,new Integer(concreteBean.getProposalId()));
		record.set(6,concreteBean.getProposalType());
		record.set(7,concreteBean.getBillingFreqCode());
		record.set(8,concreteBean.getCreatedBy());
		record.set(9,concreteBean.getStatusCode());
		record.set(10,concreteBean.getSalesOrg());
		record.set(11,concreteBean.getDistrChannel());
		record.set(12,concreteBean.getDivisionCode());
		record.set(13,concreteBean.getProposalName());
		record.set(14,concreteBean.getContractStartDate());
		record.set(15,concreteBean.getContractEndDate());
		record.set(16,concreteBean.getContractStartPeriod());
		record.set(17,concreteBean.getContractEndPeriod());
		record.set(18,new Double(concreteBean.getTvmRate()));
		record.set(19,new Double(concreteBean.getGrowthFactor()));
		record.set(20,new Double(concreteBean.getSpecialRate()));
		record.set(21,new Double(concreteBean.getInvoiceAmt()));
		record.set(22,concreteBean.getDatePriced());
		record.set(23,concreteBean.getComments());
		record.set(24,concreteBean.getCreatedDate());
		record.set(25,concreteBean.getApprovedDate());
		record.set(26,concreteBean.getDeletedInd());
		record.set(27,concreteBean.getRegCustomerNo());
		record.set(28,concreteBean.getRegCustomerName());
		record.set(29,concreteBean.getRegBilltoPartyNo());
		record.set(30,concreteBean.getRegBillToPartyName());
		record.set(31,concreteBean.getRegPayerNo());
		record.set(32,concreteBean.getRegPayerName());
		record.set(33,concreteBean.getRegShipToPartyNo());
		record.set(34,concreteBean.getRegShipToPartyName());
		record.set(35,concreteBean.getCurrency());
		record.set(36,concreteBean.getLastUpdatedDate());
		record.set(37,concreteBean.getRefetchInd());
		record.set(38,concreteBean.getFetchDate());
		record.set(39,concreteBean.getDeltaFetchInd());
		record.set(40,concreteBean.getContrType());
		record.set(41,concreteBean.getReportName());
		record.set(42,new Double(concreteBean.getCapAmt()));
		record.set(43,new Double(concreteBean.getCapPlus()));
		record.set(44,new Double(concreteBean.getCapMinus()));
		record.set(45,new Double(concreteBean.getPreTvm()));
		record.set(46,concreteBean.getContrExtnDate());
		record.set(47,concreteBean.getContrRetrDate());
		record.set(48,concreteBean.getContrReplDate());
		record.set(49,concreteBean.getContrClsDate());
		record.set(50,concreteBean.getContrNo());
		record.set(51,new Double(concreteBean.getContrAmendNo()));
		record.set(52,concreteBean.getRegCustomerListNo());
		record.set(53,concreteBean.getRegBillToPartyListNo());
		record.set(54,concreteBean.getRegPayerListNo());
		record.set(55,concreteBean.getRegShipToPartyListNo());
		record.set(56,new Double(concreteBean.getSemiAnnivInvoiceAmount()));
		record.set(57,new Double(concreteBean.getAnnivInvoiceAmount()));
		record.set(58,new Double(concreteBean.getMonthlyInvoiceAmount()));
		record.set(59,new Double(concreteBean.getQuarterlyInvoiceAmount()));
		record.set(60,concreteBean.getOldContractNo());
		record.set(61,new Double(concreteBean.getPreTVMInvoiceAmt()));
		record.set(62,concreteBean.getProposalSharing());
		record.set(63,concreteBean.getExtContractNo());
		record.set(64,concreteBean.getContractCreateFlag());
		record.set(65,concreteBean.getPakId());
		record.set(66,concreteBean.getBillingType());
		record.set(67,concreteBean.getPaymentTerm());
		record.set(68,concreteBean.getFixedValueDate());
		record.set(69,concreteBean.getTpContractNo());
		record.set(70,concreteBean.getIneligibleInd());
		record.set(71,concreteBean.getInvoiceInd());
		record.set(72,concreteBean.getAutoPopulateInd());
		record.set(73,concreteBean.getCciInd());
		record.set(74,concreteBean.getPrebillIndicator());
		record.set(75,concreteBean.getBlbIndicator());
		record.set(76,concreteBean.getContractType());
		record.set(77,concreteBean.getOcpsID());
		record.set(78,concreteBean.getCpsId());
		record.set(79,new Double(concreteBean.getSandsDiscountAmount5()));
		record.set(80,new Double(concreteBean.getSandsDiscountAmount4()));
		record.set(81,new Double(concreteBean.getSandsDiscountAmount3()));
		record.set(82,new Double(concreteBean.getSandsDiscountAmount2()));
		record.set(83,new Double(concreteBean.getSandsDiscountAmount1()));
		record.set(84,new Double(concreteBean.getSandsAnniversaryAmt5()));
		record.set(85,new Double(concreteBean.getSandsAnniversaryAmt4()));
		record.set(86,new Double(concreteBean.getSandsAnniversaryAmt3()));
		record.set(87,new Double(concreteBean.getSandsAnniversaryAmt2()));
		record.set(88,concreteBean.getSandsExtendPeriod());
		record.set(89,concreteBean.getGroupName());
		record.set(90,concreteBean.getSubmittedBy());
		record.set(91,concreteBean.getProposalContent());
		record.set(92,new Double(concreteBean.getSandsdiscountamount()));
		record.set(93,new Double(concreteBean.getSandsanniversaryamt()));
		record.set(94,concreteBean.getReg9DPartnerNo());
		record.set(95,concreteBean.getReg9DPartmerName());
		record.set(96,new Double(concreteBean.getCumVariance()));
		record.set(97,new Double(concreteBean.getCapVariance()));
		record.set(98,concreteBean.getOrgVarContractNo());
		record.set(99,concreteBean.getVarDate());
		record.set(100,concreteBean.getVarInd());
		record.set(101,concreteBean.getRegCustomerASNO());
		record.set(102,concreteBean.getRegBillToPartyASNo());
		record.set(103,concreteBean.getRegPayerASNo());
		record.set(104,concreteBean.getRegShipTOPartyASNo());
		record.set(105,concreteBean.getSuppressInvoice());
		record.set(106,concreteBean.getEswFetchDate());
		record.set(107,concreteBean.getEswFetchTime());
		record.set(108,concreteBean.getGsaInd());
		record.set(109,concreteBean.getFreeText());
		record.set(110,concreteBean.getLockedBy());
		record.set(111,concreteBean.getLockedOn());
		record.set(112,concreteBean.getPoNo());
		record.set(113,concreteBean.getPoDate());
		record.set(114,new Double(concreteBean.getAnniversaryAmt()));
		record.set(115,new Integer(concreteBean.getContrRenewNo()));
		record.set(116,concreteBean.getBillingBlock());
		record.set(117,new Integer(concreteBean.getContractPeriodVarNo()));
		record.set(118,new Integer(concreteBean.getContractVarNo()));
		record.set(119,concreteBean.getDeviationDateRule());
		record.set(120,concreteBean.getSAndSIncluded());
		record.set(121,new Integer(concreteBean.getContractReplNo()));
		record.set(122,concreteBean.getIgfNumber());
		record.set(123,concreteBean.getSalesGroup());
		record.set(124,concreteBean.getChannelRole());
		record.set(125,concreteBean.getSubmitterRole());
		record.set(126,concreteBean.getPaymentMethod());
		record.set(127,new Double(concreteBean.getDiscount()));
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc)cb;
		record.set(0,new Integer(concreteBean.getAddValueDays()));
		record.set(1,concreteBean.getAdvancedBilling());
		record.set(2,concreteBean.getAmentIndicatior());
		record.set(3,concreteBean.getAmendEffectiveDate());
		record.set(4,concreteBean.getApprovedBy());
		record.set(5,new Integer(concreteBean.getProposalId()));
		record.set(6,concreteBean.getProposalType());
		record.set(7,concreteBean.getBillingFreqCode());
		record.set(8,concreteBean.getCreatedBy());
		record.set(9,concreteBean.getStatusCode());
		record.set(10,concreteBean.getSalesOrg());
		record.set(11,concreteBean.getDistrChannel());
		record.set(12,concreteBean.getDivisionCode());
		record.set(13,concreteBean.getProposalName());
		record.set(14,concreteBean.getContractStartDate());
		record.set(15,concreteBean.getContractEndDate());
		record.set(16,concreteBean.getContractStartPeriod());
		record.set(17,concreteBean.getContractEndPeriod());
		record.set(18,new Double(concreteBean.getTvmRate()));
		record.set(19,new Double(concreteBean.getGrowthFactor()));
		record.set(20,new Double(concreteBean.getSpecialRate()));
		record.set(21,new Double(concreteBean.getInvoiceAmt()));
		record.set(22,concreteBean.getDatePriced());
		record.set(23,concreteBean.getComments());
		record.set(24,concreteBean.getCreatedDate());
		record.set(25,concreteBean.getApprovedDate());
		record.set(26,concreteBean.getDeletedInd());
		record.set(27,concreteBean.getRegCustomerNo());
		record.set(28,concreteBean.getRegCustomerName());
		record.set(29,concreteBean.getRegBilltoPartyNo());
		record.set(30,concreteBean.getRegBillToPartyName());
		record.set(31,concreteBean.getRegPayerNo());
		record.set(32,concreteBean.getRegPayerName());
		record.set(33,concreteBean.getRegShipToPartyNo());
		record.set(34,concreteBean.getRegShipToPartyName());
		record.set(35,concreteBean.getCurrency());
		record.set(36,concreteBean.getLastUpdatedDate());
		record.set(37,concreteBean.getRefetchInd());
		record.set(38,concreteBean.getFetchDate());
		record.set(39,concreteBean.getDeltaFetchInd());
		record.set(40,concreteBean.getContrType());
		record.set(41,concreteBean.getReportName());
		record.set(42,new Double(concreteBean.getCapAmt()));
		record.set(43,new Double(concreteBean.getCapPlus()));
		record.set(44,new Double(concreteBean.getCapMinus()));
		record.set(45,new Double(concreteBean.getPreTvm()));
		record.set(46,concreteBean.getContrExtnDate());
		record.set(47,concreteBean.getContrRetrDate());
		record.set(48,concreteBean.getContrReplDate());
		record.set(49,concreteBean.getContrClsDate());
		record.set(50,concreteBean.getContrNo());
		record.set(51,new Double(concreteBean.getContrAmendNo()));
		record.set(52,concreteBean.getRegCustomerListNo());
		record.set(53,concreteBean.getRegBillToPartyListNo());
		record.set(54,concreteBean.getRegPayerListNo());
		record.set(55,concreteBean.getRegShipToPartyListNo());
		record.set(56,new Double(concreteBean.getSemiAnnivInvoiceAmount()));
		record.set(57,new Double(concreteBean.getAnnivInvoiceAmount()));
		record.set(58,new Double(concreteBean.getMonthlyInvoiceAmount()));
		record.set(59,new Double(concreteBean.getQuarterlyInvoiceAmount()));
		record.set(60,concreteBean.getOldContractNo());
		record.set(61,new Double(concreteBean.getPreTVMInvoiceAmt()));
		record.set(62,concreteBean.getProposalSharing());
		record.set(63,concreteBean.getExtContractNo());
		record.set(64,concreteBean.getContractCreateFlag());
		record.set(65,concreteBean.getPakId());
		record.set(66,concreteBean.getBillingType());
		record.set(67,concreteBean.getPaymentTerm());
		record.set(68,concreteBean.getFixedValueDate());
		record.set(69,concreteBean.getTpContractNo());
		record.set(70,concreteBean.getIneligibleInd());
		record.set(71,concreteBean.getInvoiceInd());
		record.set(72,concreteBean.getAutoPopulateInd());
		record.set(73,concreteBean.getCciInd());
		record.set(74,concreteBean.getPrebillIndicator());
		record.set(75,concreteBean.getBlbIndicator());
		record.set(76,concreteBean.getContractType());
		record.set(77,concreteBean.getOcpsID());
		record.set(78,concreteBean.getCpsId());
		record.set(79,new Double(concreteBean.getSandsDiscountAmount5()));
		record.set(80,new Double(concreteBean.getSandsDiscountAmount4()));
		record.set(81,new Double(concreteBean.getSandsDiscountAmount3()));
		record.set(82,new Double(concreteBean.getSandsDiscountAmount2()));
		record.set(83,new Double(concreteBean.getSandsDiscountAmount1()));
		record.set(84,new Double(concreteBean.getSandsAnniversaryAmt5()));
		record.set(85,new Double(concreteBean.getSandsAnniversaryAmt4()));
		record.set(86,new Double(concreteBean.getSandsAnniversaryAmt3()));
		record.set(87,new Double(concreteBean.getSandsAnniversaryAmt2()));
		record.set(88,concreteBean.getSandsExtendPeriod());
		record.set(89,concreteBean.getGroupName());
		record.set(90,concreteBean.getSubmittedBy());
		record.set(91,concreteBean.getProposalContent());
		record.set(92,new Double(concreteBean.getSandsdiscountamount()));
		record.set(93,new Double(concreteBean.getSandsanniversaryamt()));
		record.set(94,concreteBean.getReg9DPartnerNo());
		record.set(95,concreteBean.getReg9DPartmerName());
		record.set(96,new Double(concreteBean.getCumVariance()));
		record.set(97,new Double(concreteBean.getCapVariance()));
		record.set(98,concreteBean.getOrgVarContractNo());
		record.set(99,concreteBean.getVarDate());
		record.set(100,concreteBean.getVarInd());
		record.set(101,concreteBean.getRegCustomerASNO());
		record.set(102,concreteBean.getRegBillToPartyASNo());
		record.set(103,concreteBean.getRegPayerASNo());
		record.set(104,concreteBean.getRegShipTOPartyASNo());
		record.set(105,concreteBean.getSuppressInvoice());
		record.set(106,concreteBean.getEswFetchDate());
		record.set(107,concreteBean.getEswFetchTime());
		record.set(108,concreteBean.getGsaInd());
		record.set(109,concreteBean.getFreeText());
		record.set(110,concreteBean.getLockedBy());
		record.set(111,concreteBean.getLockedOn());
		record.set(112,concreteBean.getPoNo());
		record.set(113,concreteBean.getPoDate());
		record.set(114,new Double(concreteBean.getAnniversaryAmt()));
		record.set(115,new Integer(concreteBean.getContrRenewNo()));
		record.set(116,concreteBean.getBillingBlock());
		record.set(117,new Integer(concreteBean.getContractPeriodVarNo()));
		record.set(118,new Integer(concreteBean.getContractVarNo()));
		record.set(119,concreteBean.getDeviationDateRule());
		record.set(120,concreteBean.getSAndSIncluded());
		record.set(121,new Integer(concreteBean.getContractReplNo()));
		record.set(122,concreteBean.getIgfNumber());
		record.set(123,concreteBean.getSalesGroup());
		record.set(124,concreteBean.getChannelRole());
		record.set(125,concreteBean.getSubmitterRole());
		record.set(126,concreteBean.getPaymentMethod());
		record.set(127,new Double(concreteBean.getDiscount()));
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc)cb;
		record.set(5,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbFindByContrORExternalContrNum
	 */
	public void ejbFindByContrORExternalContrNum(java.lang.String cntrNum, javax.resource.cci.IndexedRecord record) {
		record.set(0,cntrNum);
		record.set(1,cntrNum);
	}
	/**
	 * ejbFindByUserGroup
	 */
	public void ejbFindByUserGroup(java.lang.String createdBy, java.lang.String groupName, javax.resource.cci.IndexedRecord record) {
		record.set(0,createdBy);
		record.set(1,groupName);
	}
	/**
	 * ejbFindByUserForDateRange
	 */
	public void ejbFindByUserForDateRange(java.lang.String createdBy, java.sql.Date startDate, java.sql.Date endDate, javax.resource.cci.IndexedRecord record) {
		record.set(0,createdBy);
		record.set(1,startDate);
		record.set(2,endDate);
	}
	/**
	 * ejbFindByVarContractNo
	 */
	public void ejbFindByVarContractNo(java.lang.String orgVarContractNo, int contractPeriodVarNo, javax.resource.cci.IndexedRecord record) {
		record.set(0,orgVarContractNo);
		record.set(1,new Integer(contractPeriodVarNo));
	}
	/**
	 * ejbFindAllVarianceContracts
	 */
	public void ejbFindAllVarianceContracts(java.lang.String contractNumber, javax.resource.cci.IndexedRecord record) {
		record.set(0,contractNumber);
	}
	/**
	 * ejbFindByApproverFromGroup
	 */
	public void ejbFindByApproverFromGroup(java.lang.String approverId, java.lang.String groupName, javax.resource.cci.IndexedRecord record) {
		record.set(0,approverId);
		record.set(1,groupName);
	}
	/**
	 * ejbFindByContractNumber
	 */
	public void ejbFindByContractNumber(java.lang.String contractNumber, javax.resource.cci.IndexedRecord record) {
		record.set(0,contractNumber);
	}
	/**
	 * ejbFindByWaitingForApproval
	 */
	public void ejbFindByWaitingForApproval(java.lang.String userId, javax.resource.cci.IndexedRecord record) {
		record.set(0,userId);
	}
	/**
	 * ejbFindByWaitingForApprovalForProposalApprover
	 */
	public void ejbFindByWaitingForApprovalForProposalApprover(java.lang.String approver, javax.resource.cci.IndexedRecord record) {
		record.set(0,approver);
	}
	/**
	 * ejbFindByLockedBy
	 */
	public void ejbFindByLockedBy(java.lang.String userId, javax.resource.cci.IndexedRecord record) {
		record.set(0,userId);
	}
	/**
	 * ejbFindByUserAndSalesOrg
	 */
	public void ejbFindByUserAndSalesOrg(java.lang.String userId, javax.resource.cci.IndexedRecord record) {
		record.set(0,userId);
	}
	/**
	 * ejbFindRelatedVarianceProposal
	 */
	public void ejbFindRelatedVarianceProposal(java.lang.String orgVarianceContractNumber, javax.resource.cci.IndexedRecord record) {
		record.set(0,orgVarianceContractNumber);
	}
	/**
	 * ejbFindByApprover
	 */
	public void ejbFindByApprover(java.lang.String userId, javax.resource.cci.IndexedRecord record) {
		record.set(0,userId);
	}
	/**
	 * ejbFindByWaitingForApprovalForCreateApprove
	 */
	public void ejbFindByWaitingForApprovalForCreateApprove(java.lang.String userId, javax.resource.cci.IndexedRecord record) {
		record.set(0,userId);
		record.set(1,userId);
	}
	/**
	 * ejbFindRelatedProposalForContract
	 */
	public void ejbFindRelatedProposalForContract(java.lang.String oldContractNumber, javax.resource.cci.IndexedRecord record) {
		record.set(0,oldContractNumber);
	}
	/**
	 * ejbFindByDateRangeForGroup
	 */
	public void ejbFindByDateRangeForGroup(java.lang.String createdBy, java.lang.String groupName, java.sql.Date startDate, java.sql.Date endDate, javax.resource.cci.IndexedRecord record) {
		record.set(0,createdBy);
		record.set(1,groupName);
		record.set(2,startDate);
		record.set(3,endDate);
	}
	/**
	 * ejbFindByUser
	 */
	public void ejbFindByUser(java.lang.String userId, javax.resource.cci.IndexedRecord record) {
		record.set(0,userId);
	}
	/**
	 * ejbFindByName
	 */
	public void ejbFindByName(java.lang.String proposalName, javax.resource.cci.IndexedRecord record) {
		record.set(0,proposalName);
	}
	/**
	 * ejbFindByCntrNumberORExternalCntrNumAndStatus
	 */
	public void ejbFindByCntrNumberORExternalCntrNumAndStatus(java.lang.String cntrNum, javax.resource.cci.IndexedRecord record) {
		record.set(0,cntrNum);
		record.set(1,cntrNum);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey)pkeyObject;
		record.set(0,new Integer(pkey.proposalId));
	}
	/**
	 * ejbFindProposalContractWaitingForCSOAndMark
	 */
	public void ejbFindProposalContractWaitingForCSOAndMark(java.lang.String createdBy, javax.resource.cci.IndexedRecord record) {
		record.set(0,createdBy);
	}
	/**
	 * ejbFindBytpContractNo
	 */
	public void ejbFindBytpContractNo(java.lang.String tpContractNo, javax.resource.cci.IndexedRecord record) {
		record.set(0,tpContractNo);
	}
	/**
	 * ejbFindBySubmittedBy
	 */
	public void ejbFindBySubmittedBy(java.lang.String submittedBy, javax.resource.cci.IndexedRecord record) {
		record.set(0,submittedBy);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,new Integer(concreteBean.getAddValueDays()));
		record.set(2,new Double(concreteBean.getTvmRate()));
		record.set(3,new Double(concreteBean.getGrowthFactor()));
		record.set(4,new Double(concreteBean.getSpecialRate()));
		record.set(5,new Double(concreteBean.getInvoiceAmt()));
		record.set(6,new Double(concreteBean.getCapAmt()));
		record.set(7,new Double(concreteBean.getCapPlus()));
		record.set(8,new Double(concreteBean.getCapMinus()));
		record.set(9,new Double(concreteBean.getPreTvm()));
		record.set(10,new Double(concreteBean.getContrAmendNo()));
		record.set(11,new Double(concreteBean.getSemiAnnivInvoiceAmount()));
		record.set(12,new Double(concreteBean.getAnnivInvoiceAmount()));
		record.set(13,new Double(concreteBean.getMonthlyInvoiceAmount()));
		record.set(14,new Double(concreteBean.getQuarterlyInvoiceAmount()));
		record.set(15,new Double(concreteBean.getPreTVMInvoiceAmt()));
		record.set(16,new Double(concreteBean.getSandsDiscountAmount5()));
		record.set(17,new Double(concreteBean.getSandsDiscountAmount4()));
		record.set(18,new Double(concreteBean.getSandsDiscountAmount3()));
		record.set(19,new Double(concreteBean.getSandsDiscountAmount2()));
		record.set(20,new Double(concreteBean.getSandsDiscountAmount1()));
		record.set(21,new Double(concreteBean.getSandsAnniversaryAmt5()));
		record.set(22,new Double(concreteBean.getSandsAnniversaryAmt4()));
		record.set(23,new Double(concreteBean.getSandsAnniversaryAmt3()));
		record.set(24,new Double(concreteBean.getSandsAnniversaryAmt2()));
		record.set(25,new Double(concreteBean.getSandsdiscountamount()));
		record.set(26,new Double(concreteBean.getSandsanniversaryamt()));
		record.set(27,new Double(concreteBean.getCumVariance()));
		record.set(28,new Double(concreteBean.getCapVariance()));
		record.set(29,new Double(concreteBean.getAnniversaryAmt()));
		record.set(30,new Integer(concreteBean.getContrRenewNo()));
		record.set(31,new Integer(concreteBean.getContractPeriodVarNo()));
		record.set(32,new Integer(concreteBean.getContractVarNo()));
		record.set(33,new Integer(concreteBean.getContractReplNo()));
		record.set(34,new Double(concreteBean.getDiscount()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		if(instanceExtension.isDirty(0))
		{
			record.set(0,new Integer(concreteBean.getAddValueDays()));
		}
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getAdvancedBilling());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(2,concreteBean.getAmentIndicatior());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(3,concreteBean.getAmendEffectiveDate());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(4,concreteBean.getApprovedBy());
		}
		record.set(5,new Integer(concreteBean.getProposalId()));
		if(instanceExtension.isDirty(66))
		{
			record.set(6,concreteBean.getProposalType());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(7,concreteBean.getBillingFreqCode());
		}
		if(instanceExtension.isDirty(31))
		{
			record.set(8,concreteBean.getCreatedBy());
		}
		if(instanceExtension.isDirty(92))
		{
			record.set(9,concreteBean.getStatusCode());
		}
		if(instanceExtension.isDirty(89))
		{
			record.set(10,concreteBean.getSalesOrg());
		}
		if(instanceExtension.isDirty(39))
		{
			record.set(11,concreteBean.getDistrChannel());
		}
		if(instanceExtension.isDirty(40))
		{
			record.set(12,concreteBean.getDivisionCode());
		}
		if(instanceExtension.isDirty(63))
		{
			record.set(13,concreteBean.getProposalName());
		}
		if(instanceExtension.isDirty(29))
		{
			record.set(14,concreteBean.getContractStartDate());
		}
		if(instanceExtension.isDirty(25))
		{
			record.set(15,concreteBean.getContractEndDate());
		}
		if(instanceExtension.isDirty(30))
		{
			record.set(16,concreteBean.getContractStartPeriod());
		}
		if(instanceExtension.isDirty(26))
		{
			record.set(17,concreteBean.getContractEndPeriod());
		}
		if(instanceExtension.isDirty(95))
		{
			record.set(18,new Double(concreteBean.getTvmRate()));
		}
		if(instanceExtension.isDirty(47))
		{
			record.set(19,new Double(concreteBean.getGrowthFactor()));
		}
		if(instanceExtension.isDirty(91))
		{
			record.set(20,new Double(concreteBean.getSpecialRate()));
		}
		if(instanceExtension.isDirty(50))
		{
			record.set(21,new Double(concreteBean.getInvoiceAmt()));
		}
		if(instanceExtension.isDirty(35))
		{
			record.set(22,concreteBean.getDatePriced());
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(23,concreteBean.getComments());
		}
		if(instanceExtension.isDirty(32))
		{
			record.set(24,concreteBean.getCreatedDate());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(25,concreteBean.getApprovedDate());
		}
		if(instanceExtension.isDirty(36))
		{
			record.set(26,concreteBean.getDeletedInd());
		}
		if(instanceExtension.isDirty(78))
		{
			record.set(27,concreteBean.getRegCustomerNo());
		}
		if(instanceExtension.isDirty(77))
		{
			record.set(28,concreteBean.getRegCustomerName());
		}
		if(instanceExtension.isDirty(74))
		{
			record.set(29,concreteBean.getRegBilltoPartyNo());
		}
		if(instanceExtension.isDirty(73))
		{
			record.set(30,concreteBean.getRegBillToPartyName());
		}
		if(instanceExtension.isDirty(82))
		{
			record.set(31,concreteBean.getRegPayerNo());
		}
		if(instanceExtension.isDirty(81))
		{
			record.set(32,concreteBean.getRegPayerName());
		}
		if(instanceExtension.isDirty(86))
		{
			record.set(33,concreteBean.getRegShipToPartyNo());
		}
		if(instanceExtension.isDirty(85))
		{
			record.set(34,concreteBean.getRegShipToPartyName());
		}
		if(instanceExtension.isDirty(34))
		{
			record.set(35,concreteBean.getCurrency());
		}
		if(instanceExtension.isDirty(52))
		{
			record.set(36,concreteBean.getLastUpdatedDate());
		}
		if(instanceExtension.isDirty(68))
		{
			record.set(37,concreteBean.getRefetchInd());
		}
		if(instanceExtension.isDirty(44))
		{
			record.set(38,concreteBean.getFetchDate());
		}
		if(instanceExtension.isDirty(37))
		{
			record.set(39,concreteBean.getDeltaFetchInd());
		}
		if(instanceExtension.isDirty(23))
		{
			record.set(40,concreteBean.getContrType());
		}
		if(instanceExtension.isDirty(87))
		{
			record.set(41,concreteBean.getReportName());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(42,new Double(concreteBean.getCapAmt()));
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(43,new Double(concreteBean.getCapPlus()));
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(44,new Double(concreteBean.getCapMinus()));
		}
		if(instanceExtension.isDirty(62))
		{
			record.set(45,new Double(concreteBean.getPreTvm()));
		}
		if(instanceExtension.isDirty(18))
		{
			record.set(46,concreteBean.getContrExtnDate());
		}
		if(instanceExtension.isDirty(22))
		{
			record.set(47,concreteBean.getContrRetrDate());
		}
		if(instanceExtension.isDirty(21))
		{
			record.set(48,concreteBean.getContrReplDate());
		}
		if(instanceExtension.isDirty(17))
		{
			record.set(49,concreteBean.getContrClsDate());
		}
		if(instanceExtension.isDirty(19))
		{
			record.set(50,concreteBean.getContrNo());
		}
		if(instanceExtension.isDirty(16))
		{
			record.set(51,new Double(concreteBean.getContrAmendNo()));
		}
		if(instanceExtension.isDirty(76))
		{
			record.set(52,concreteBean.getRegCustomerListNo());
		}
		if(instanceExtension.isDirty(72))
		{
			record.set(53,concreteBean.getRegBillToPartyListNo());
		}
		if(instanceExtension.isDirty(80))
		{
			record.set(54,concreteBean.getRegPayerListNo());
		}
		if(instanceExtension.isDirty(84))
		{
			record.set(55,concreteBean.getRegShipToPartyListNo());
		}
		if(instanceExtension.isDirty(90))
		{
			record.set(56,new Double(concreteBean.getSemiAnnivInvoiceAmount()));
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(57,new Double(concreteBean.getAnnivInvoiceAmount()));
		}
		if(instanceExtension.isDirty(54))
		{
			record.set(58,new Double(concreteBean.getMonthlyInvoiceAmount()));
		}
		if(instanceExtension.isDirty(67))
		{
			record.set(59,new Double(concreteBean.getQuarterlyInvoiceAmount()));
		}
		if(instanceExtension.isDirty(55))
		{
			record.set(60,concreteBean.getOldContractNo());
		}
		if(instanceExtension.isDirty(61))
		{
			record.set(61,new Double(concreteBean.getPreTVMInvoiceAmt()));
		}
		if(instanceExtension.isDirty(65))
		{
			record.set(62,concreteBean.getProposalSharing());
		}
		if(instanceExtension.isDirty(43))
		{
			record.set(63,concreteBean.getExtContractNo());
		}
		if(instanceExtension.isDirty(24))
		{
			record.set(64,concreteBean.getContractCreateFlag());
		}
		if(instanceExtension.isDirty(58))
		{
			record.set(65,concreteBean.getPakId());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(66,concreteBean.getBillingType());
		}
		if(instanceExtension.isDirty(59))
		{
			record.set(67,concreteBean.getPaymentTerm());
		}
		if(instanceExtension.isDirty(45))
		{
			record.set(68,concreteBean.getFixedValueDate());
		}
		if(instanceExtension.isDirty(94))
		{
			record.set(69,concreteBean.getTpContractNo());
		}
		if(instanceExtension.isDirty(49))
		{
			record.set(70,concreteBean.getIneligibleInd());
		}
		if(instanceExtension.isDirty(51))
		{
			record.set(71,concreteBean.getInvoiceInd());
		}
		if(instanceExtension.isDirty(122))
		{
			record.set(72,concreteBean.getAutoPopulateInd());
		}
		if(instanceExtension.isDirty(121))
		{
			record.set(73,concreteBean.getCciInd());
		}
		if(instanceExtension.isDirty(120))
		{
			record.set(74,concreteBean.getPrebillIndicator());
		}
		if(instanceExtension.isDirty(119))
		{
			record.set(75,concreteBean.getBlbIndicator());
		}
		if(instanceExtension.isDirty(118))
		{
			record.set(76,concreteBean.getContractType());
		}
		if(instanceExtension.isDirty(117))
		{
			record.set(77,concreteBean.getOcpsID());
		}
		if(instanceExtension.isDirty(116))
		{
			record.set(78,concreteBean.getCpsId());
		}
		if(instanceExtension.isDirty(115))
		{
			record.set(79,new Double(concreteBean.getSandsDiscountAmount5()));
		}
		if(instanceExtension.isDirty(114))
		{
			record.set(80,new Double(concreteBean.getSandsDiscountAmount4()));
		}
		if(instanceExtension.isDirty(113))
		{
			record.set(81,new Double(concreteBean.getSandsDiscountAmount3()));
		}
		if(instanceExtension.isDirty(112))
		{
			record.set(82,new Double(concreteBean.getSandsDiscountAmount2()));
		}
		if(instanceExtension.isDirty(111))
		{
			record.set(83,new Double(concreteBean.getSandsDiscountAmount1()));
		}
		if(instanceExtension.isDirty(110))
		{
			record.set(84,new Double(concreteBean.getSandsAnniversaryAmt5()));
		}
		if(instanceExtension.isDirty(109))
		{
			record.set(85,new Double(concreteBean.getSandsAnniversaryAmt4()));
		}
		if(instanceExtension.isDirty(108))
		{
			record.set(86,new Double(concreteBean.getSandsAnniversaryAmt3()));
		}
		if(instanceExtension.isDirty(107))
		{
			record.set(87,new Double(concreteBean.getSandsAnniversaryAmt2()));
		}
		if(instanceExtension.isDirty(106))
		{
			record.set(88,concreteBean.getSandsExtendPeriod());
		}
		if(instanceExtension.isDirty(105))
		{
			record.set(89,concreteBean.getGroupName());
		}
		if(instanceExtension.isDirty(104))
		{
			record.set(90,concreteBean.getSubmittedBy());
		}
		if(instanceExtension.isDirty(103))
		{
			record.set(91,concreteBean.getProposalContent());
		}
		if(instanceExtension.isDirty(102))
		{
			record.set(92,new Double(concreteBean.getSandsdiscountamount()));
		}
		if(instanceExtension.isDirty(101))
		{
			record.set(93,new Double(concreteBean.getSandsanniversaryamt()));
		}
		if(instanceExtension.isDirty(70))
		{
			record.set(94,concreteBean.getReg9DPartnerNo());
		}
		if(instanceExtension.isDirty(69))
		{
			record.set(95,concreteBean.getReg9DPartmerName());
		}
		if(instanceExtension.isDirty(33))
		{
			record.set(96,new Double(concreteBean.getCumVariance()));
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(97,new Double(concreteBean.getCapVariance()));
		}
		if(instanceExtension.isDirty(57))
		{
			record.set(98,concreteBean.getOrgVarContractNo());
		}
		if(instanceExtension.isDirty(96))
		{
			record.set(99,concreteBean.getVarDate());
		}
		if(instanceExtension.isDirty(97))
		{
			record.set(100,concreteBean.getVarInd());
		}
		if(instanceExtension.isDirty(75))
		{
			record.set(101,concreteBean.getRegCustomerASNO());
		}
		if(instanceExtension.isDirty(71))
		{
			record.set(102,concreteBean.getRegBillToPartyASNo());
		}
		if(instanceExtension.isDirty(79))
		{
			record.set(103,concreteBean.getRegPayerASNo());
		}
		if(instanceExtension.isDirty(83))
		{
			record.set(104,concreteBean.getRegShipTOPartyASNo());
		}
		if(instanceExtension.isDirty(93))
		{
			record.set(105,concreteBean.getSuppressInvoice());
		}
		if(instanceExtension.isDirty(41))
		{
			record.set(106,concreteBean.getEswFetchDate());
		}
		if(instanceExtension.isDirty(42))
		{
			record.set(107,concreteBean.getEswFetchTime());
		}
		if(instanceExtension.isDirty(48))
		{
			record.set(108,concreteBean.getGsaInd());
		}
		if(instanceExtension.isDirty(46))
		{
			record.set(109,concreteBean.getFreeText());
		}
		if(instanceExtension.isDirty(53))
		{
			record.set(110,concreteBean.getLockedBy());
		}
		if(instanceExtension.isDirty(98))
		{
			record.set(111,concreteBean.getLockedOn());
		}
		if(instanceExtension.isDirty(60))
		{
			record.set(112,concreteBean.getPoNo());
		}
		if(instanceExtension.isDirty(56))
		{
			record.set(113,concreteBean.getPoDate());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(114,new Double(concreteBean.getAnniversaryAmt()));
		}
		if(instanceExtension.isDirty(20))
		{
			record.set(115,new Integer(concreteBean.getContrRenewNo()));
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(116,concreteBean.getBillingBlock());
		}
		if(instanceExtension.isDirty(27))
		{
			record.set(117,new Integer(concreteBean.getContractPeriodVarNo()));
		}
		if(instanceExtension.isDirty(28))
		{
			record.set(118,new Integer(concreteBean.getContractVarNo()));
		}
		if(instanceExtension.isDirty(38))
		{
			record.set(119,concreteBean.getDeviationDateRule());
		}
		if(instanceExtension.isDirty(88))
		{
			record.set(120,concreteBean.getSAndSIncluded());
		}
		if(instanceExtension.isDirty(99))
		{
			record.set(121,new Integer(concreteBean.getContractReplNo()));
		}
		if(instanceExtension.isDirty(100))
		{
			record.set(122,concreteBean.getIgfNumber());
		}
		if(instanceExtension.isDirty(123))
		{
			record.set(123,concreteBean.getSalesGroup());
		}
		if(instanceExtension.isDirty(124))
		{
			record.set(124,concreteBean.getChannelRole());
		}
		if(instanceExtension.isDirty(125))
		{
			record.set(125,concreteBean.getSubmitterRole());
		}
		if(instanceExtension.isDirty(126))
		{
			record.set(126,concreteBean.getPaymentMethod());
		}
		if(instanceExtension.isDirty(127))
		{
			record.set(127,new Double(concreteBean.getDiscount()));
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

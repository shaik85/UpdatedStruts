/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Local Home interface for Enterprise Bean: Proposal
 */
public interface ProposalLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Proposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal create(int proposalId, String proposalName) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Proposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey primaryKey) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByName(java.lang.String proposalName) throws javax.ejb.FinderException;
	public java.util.Collection findByApprover(java.lang.String userId) throws javax.ejb.FinderException;
	public java.util.Collection findByLockedBy(java.lang.String userId) throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.String userId) throws javax.ejb.FinderException;
	public java.util.Collection findByWaitingForApproval(java.lang.String userId) throws javax.ejb.FinderException;
	public java.util.Collection findByUserAndSalesOrg(java.lang.String userId) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findMaxProposalId() throws javax.ejb.FinderException;
	public java.util.Collection findByWaitingForApprovalForCreateApprove(java.lang.String userId) throws javax.ejb.FinderException;
	public java.util.Collection findByWaitingForApprovalForProposalApprover(java.lang.String approver) throws javax.ejb.FinderException;
	public java.util.Collection findProposalContractWaitingForCSOAndMark(java.lang.String createdBy) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByContractNumber(java.lang.String contractNumber) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findBytpContractNo(java.lang.String tpContractNo) throws javax.ejb.FinderException;
	public java.util.Collection findByUserForDateRange(java.lang.String createdBy, java.sql.Date startDate, java.sql.Date endDate) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByContrORExternalContrNum(java.lang.String cntrNum) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findRelatedVarianceProposal(java.lang.String orgVarianceContractNumber) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findRelatedProposalForContract(java.lang.String oldContractNumber) throws javax.ejb.FinderException;
	public java.util.Collection findMaxContractNumber() throws javax.ejb.FinderException;
	public java.util.Collection findAllVarianceContracts(java.lang.String contractNumber) throws javax.ejb.FinderException;
	public java.util.Collection findByVarContractNo(java.lang.String orgVarContractNo, int contractPeriodVarNo) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByCntrNumberORExternalCntrNumAndStatus(java.lang.String cntrNum) throws javax.ejb.FinderException;
	public java.util.Collection findBySubmittedBy(java.lang.String submittedBy) throws javax.ejb.FinderException;
	public java.util.Collection findByApproverFromGroup(java.lang.String approverId, java.lang.String groupName) throws javax.ejb.FinderException;
	public java.util.Collection findByDateRangeForGroup(java.lang.String createdBy, java.lang.String groupName, java.sql.Date startDate, java.sql.Date endDate) throws javax.ejb.FinderException;
	public java.util.Collection findByUserGroup(java.lang.String createdBy, java.lang.String groupName) throws javax.ejb.FinderException;
}

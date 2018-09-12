package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Proposal
 */
public interface ProposalBeanInjector_8ef9b9cc extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByCntrNumberORExternalCntrNumAndStatus
	 */
	public void ejbFindByCntrNumberORExternalCntrNumAndStatus(java.lang.String cntrNum, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByContrORExternalContrNum
	 */
	public void ejbFindByContrORExternalContrNum(java.lang.String cntrNum, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByContractNumber
	 */
	public void ejbFindByContractNumber(java.lang.String contractNumber, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByName
	 */
	public void ejbFindByName(java.lang.String proposalName, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindBytpContractNo
	 */
	public void ejbFindBytpContractNo(java.lang.String tpContractNo, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindRelatedProposalForContract
	 */
	public void ejbFindRelatedProposalForContract(java.lang.String oldContractNumber, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindRelatedVarianceProposal
	 */
	public void ejbFindRelatedVarianceProposal(java.lang.String orgVarianceContractNumber, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindAllVarianceContracts
	 */
	public void ejbFindAllVarianceContracts(java.lang.String contractNumber, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByApprover
	 */
	public void ejbFindByApprover(java.lang.String userId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByApproverFromGroup
	 */
	public void ejbFindByApproverFromGroup(java.lang.String approverId, java.lang.String groupName, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByDateRangeForGroup
	 */
	public void ejbFindByDateRangeForGroup(java.lang.String createdBy, java.lang.String groupName, java.sql.Date startDate, java.sql.Date endDate, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByLockedBy
	 */
	public void ejbFindByLockedBy(java.lang.String userId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindBySubmittedBy
	 */
	public void ejbFindBySubmittedBy(java.lang.String submittedBy, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByUser
	 */
	public void ejbFindByUser(java.lang.String userId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByUserAndSalesOrg
	 */
	public void ejbFindByUserAndSalesOrg(java.lang.String userId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByUserForDateRange
	 */
	public void ejbFindByUserForDateRange(java.lang.String createdBy, java.sql.Date startDate, java.sql.Date endDate, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByUserGroup
	 */
	public void ejbFindByUserGroup(java.lang.String createdBy, java.lang.String groupName, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByVarContractNo
	 */
	public void ejbFindByVarContractNo(java.lang.String orgVarContractNo, int contractPeriodVarNo, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByWaitingForApproval
	 */
	public void ejbFindByWaitingForApproval(java.lang.String userId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByWaitingForApprovalForCreateApprove
	 */
	public void ejbFindByWaitingForApprovalForCreateApprove(java.lang.String userId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByWaitingForApprovalForProposalApprover
	 */
	public void ejbFindByWaitingForApprovalForProposalApprover(java.lang.String approver, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindProposalContractWaitingForCSOAndMark
	 */
	public void ejbFindProposalContractWaitingForCSOAndMark(java.lang.String createdBy, javax.resource.cci.IndexedRecord record);
}

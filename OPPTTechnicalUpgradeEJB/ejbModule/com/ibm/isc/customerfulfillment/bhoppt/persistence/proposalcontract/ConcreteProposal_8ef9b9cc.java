package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ProposalBeanCacheEntry_8ef9b9cc;

/**
 * Bean implementation class for Enterprise Bean: Proposal
 */
public class ConcreteProposal_8ef9b9cc extends com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean implements javax.ejb.EntityBean, ConcreteBean {
	static final long serialVersionUID = 61;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
		instanceExtension.setEntityContext(ctx);
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		super.unsetEntityContext();
		instanceExtension.unsetEntityContext();
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
			super.ejbActivate();
			instanceExtension.ejbActivate();
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
		instanceExtension.ejbLoad();
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
		super.ejbPassivate();
		instanceExtension.ejbPassivate();
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
		super.ejbRemove();
		instanceExtension.ejbRemove();
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
		super.ejbStore();
		instanceExtension.ejbStore();
	}
	private ConcreteBeanInstanceExtension instanceExtension;
	private ProposalBeanCacheEntry_8ef9b9cc dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteProposal_8ef9b9cc
	 */
	public ConcreteProposal_8ef9b9cc() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ProposalBeanInjector_8ef9b9cc getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ProposalBeanInjector_8ef9b9cc)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ProposalBeanCacheEntry_8ef9b9cc) inRecord;
		super.ejbLoad();
	}
	/**
	 * resetCMP
	 */
	public void resetCMP() {
			dataCacheEntry = null;
	}
	/**
	 * resetCMR
	 */
	public void resetCMR() {
	}
	/**
	 * ejbFindByCntrNumberORExternalCntrNumAndStatus_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey ejbFindByCntrNumberORExternalCntrNumAndStatus_Local(java.lang.String cntrNum) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByCntrNumberORExternalCntrNumAndStatus");
		getInjector().ejbFindByCntrNumberORExternalCntrNumAndStatus(cntrNum, record);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey) instanceExtension.executeFind("FindByCntrNumberORExternalCntrNumAndStatus", record);
	}
	/**
	 * ejbFindByContrORExternalContrNum_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey ejbFindByContrORExternalContrNum_Local(java.lang.String cntrNum) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByContrORExternalContrNum");
		getInjector().ejbFindByContrORExternalContrNum(cntrNum, record);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey) instanceExtension.executeFind("FindByContrORExternalContrNum", record);
	}
	/**
	 * ejbFindByContractNumber_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey ejbFindByContractNumber_Local(java.lang.String contractNumber) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByContractNumber");
		getInjector().ejbFindByContractNumber(contractNumber, record);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey) instanceExtension.executeFind("FindByContractNumber", record);
	}
	/**
	 * ejbFindByName_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey ejbFindByName_Local(java.lang.String proposalName) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByName");
		getInjector().ejbFindByName(proposalName, record);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey) instanceExtension.executeFind("FindByName", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindBytpContractNo_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey ejbFindBytpContractNo_Local(java.lang.String tpContractNo) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindBytpContractNo");
		getInjector().ejbFindBytpContractNo(tpContractNo, record);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey) instanceExtension.executeFind("FindBytpContractNo", record);
	}
	/**
	 * ejbFindMaxProposalId_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey ejbFindMaxProposalId_Local() throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey) instanceExtension.executeFind("FindMaxProposalId", null);
	}
	/**
	 * ejbFindRelatedProposalForContract_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey ejbFindRelatedProposalForContract_Local(java.lang.String oldContractNumber) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindRelatedProposalForContract");
		getInjector().ejbFindRelatedProposalForContract(oldContractNumber, record);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey) instanceExtension.executeFind("FindRelatedProposalForContract", record);
	}
	/**
	 * ejbFindRelatedVarianceProposal_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey ejbFindRelatedVarianceProposal_Local(java.lang.String orgVarianceContractNumber) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindRelatedVarianceProposal");
		getInjector().ejbFindRelatedVarianceProposal(orgVarianceContractNumber, record);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey) instanceExtension.executeFind("FindRelatedVarianceProposal", record);
	}
	/**
	 * ejbFindAllVarianceContracts_Local
	 */
	public java.util.Collection ejbFindAllVarianceContracts_Local(java.lang.String contractNumber) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindAllVarianceContracts");
		getInjector().ejbFindAllVarianceContracts(contractNumber, record);
		return (java.util.Collection) instanceExtension.executeFind("FindAllVarianceContracts", record);
	}
	/**
	 * ejbFindByApprover_Local
	 */
	public java.util.Collection ejbFindByApprover_Local(java.lang.String userId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByApprover");
		getInjector().ejbFindByApprover(userId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByApprover", record);
	}
	/**
	 * ejbFindByApproverFromGroup_Local
	 */
	public java.util.Collection ejbFindByApproverFromGroup_Local(java.lang.String approverId, java.lang.String groupName) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByApproverFromGroup");
		getInjector().ejbFindByApproverFromGroup(approverId, groupName, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByApproverFromGroup", record);
	}
	/**
	 * ejbFindByDateRangeForGroup_Local
	 */
	public java.util.Collection ejbFindByDateRangeForGroup_Local(java.lang.String createdBy, java.lang.String groupName, java.sql.Date startDate, java.sql.Date endDate) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByDateRangeForGroup");
		getInjector().ejbFindByDateRangeForGroup(createdBy, groupName, startDate, endDate, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByDateRangeForGroup", record);
	}
	/**
	 * ejbFindByLockedBy_Local
	 */
	public java.util.Collection ejbFindByLockedBy_Local(java.lang.String userId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByLockedBy");
		getInjector().ejbFindByLockedBy(userId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByLockedBy", record);
	}
	/**
	 * ejbFindBySubmittedBy_Local
	 */
	public java.util.Collection ejbFindBySubmittedBy_Local(java.lang.String submittedBy) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindBySubmittedBy");
		getInjector().ejbFindBySubmittedBy(submittedBy, record);
		return (java.util.Collection) instanceExtension.executeFind("FindBySubmittedBy", record);
	}
	/**
	 * ejbFindByUser_Local
	 */
	public java.util.Collection ejbFindByUser_Local(java.lang.String userId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByUser");
		getInjector().ejbFindByUser(userId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByUser", record);
	}
	/**
	 * ejbFindByUserAndSalesOrg_Local
	 */
	public java.util.Collection ejbFindByUserAndSalesOrg_Local(java.lang.String userId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByUserAndSalesOrg");
		getInjector().ejbFindByUserAndSalesOrg(userId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByUserAndSalesOrg", record);
	}
	/**
	 * ejbFindByUserForDateRange_Local
	 */
	public java.util.Collection ejbFindByUserForDateRange_Local(java.lang.String createdBy, java.sql.Date startDate, java.sql.Date endDate) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByUserForDateRange");
		getInjector().ejbFindByUserForDateRange(createdBy, startDate, endDate, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByUserForDateRange", record);
	}
	/**
	 * ejbFindByUserGroup_Local
	 */
	public java.util.Collection ejbFindByUserGroup_Local(java.lang.String createdBy, java.lang.String groupName) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByUserGroup");
		getInjector().ejbFindByUserGroup(createdBy, groupName, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByUserGroup", record);
	}
	/**
	 * ejbFindByVarContractNo_Local
	 */
	public java.util.Collection ejbFindByVarContractNo_Local(java.lang.String orgVarContractNo, int contractPeriodVarNo) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByVarContractNo");
		getInjector().ejbFindByVarContractNo(orgVarContractNo, contractPeriodVarNo, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByVarContractNo", record);
	}
	/**
	 * ejbFindByWaitingForApproval_Local
	 */
	public java.util.Collection ejbFindByWaitingForApproval_Local(java.lang.String userId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByWaitingForApproval");
		getInjector().ejbFindByWaitingForApproval(userId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByWaitingForApproval", record);
	}
	/**
	 * ejbFindByWaitingForApprovalForCreateApprove_Local
	 */
	public java.util.Collection ejbFindByWaitingForApprovalForCreateApprove_Local(java.lang.String userId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByWaitingForApprovalForCreateApprove");
		getInjector().ejbFindByWaitingForApprovalForCreateApprove(userId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByWaitingForApprovalForCreateApprove", record);
	}
	/**
	 * ejbFindByWaitingForApprovalForProposalApprover_Local
	 */
	public java.util.Collection ejbFindByWaitingForApprovalForProposalApprover_Local(java.lang.String approver) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByWaitingForApprovalForProposalApprover");
		getInjector().ejbFindByWaitingForApprovalForProposalApprover(approver, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByWaitingForApprovalForProposalApprover", record);
	}
	/**
	 * ejbFindMaxContractNumber_Local
	 */
	public java.util.Collection ejbFindMaxContractNumber_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindMaxContractNumber", null);
	}
	/**
	 * ejbFindProposalContractWaitingForCSOAndMark_Local
	 */
	public java.util.Collection ejbFindProposalContractWaitingForCSOAndMark_Local(java.lang.String createdBy) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindProposalContractWaitingForCSOAndMark");
		getInjector().ejbFindProposalContractWaitingForCSOAndMark(createdBy, record);
		return (java.util.Collection) instanceExtension.executeFind("FindProposalContractWaitingForCSOAndMark", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey ejbCreate(int proposalId, java.lang.String proposalName) throws javax.ejb.CreateException {
		dataCacheEntry = (ProposalBeanCacheEntry_8ef9b9cc) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(proposalId, proposalName);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int proposalId, java.lang.String proposalName) throws javax.ejb.CreateException {
		super.ejbPostCreate(proposalId, proposalName);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey();
		pk.proposalId = getProposalId();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 128;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: addValueDays
	 */
	public int getAddValueDays() {
		return dataCacheEntry.getAddValueDays();
	}
	/**
	 * Set accessor for persistent attribute: addValueDays
	 */
	public void setAddValueDays(int newAddValueDays) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getAddValueDays(),newAddValueDays);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setAddValueDays(newAddValueDays);
	}
	/**
	 * Get accessor for persistent attribute: advancedBilling
	 */
	public java.lang.String getAdvancedBilling() {
		return dataCacheEntry.getAdvancedBilling();
	}
	/**
	 * Set accessor for persistent attribute: advancedBilling
	 */
	public void setAdvancedBilling(java.lang.String newAdvancedBilling) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getAdvancedBilling(),newAdvancedBilling);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setAdvancedBilling(newAdvancedBilling);
	}
	/**
	 * Get accessor for persistent attribute: amendEffectiveDate
	 */
	public java.sql.Date getAmendEffectiveDate() {
		return dataCacheEntry.getAmendEffectiveDate();
	}
	/**
	 * Set accessor for persistent attribute: amendEffectiveDate
	 */
	public void setAmendEffectiveDate(java.sql.Date newAmendEffectiveDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getAmendEffectiveDate(),newAmendEffectiveDate);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setAmendEffectiveDate(newAmendEffectiveDate);
	}
	/**
	 * Get accessor for persistent attribute: amentIndicatior
	 */
	public java.lang.String getAmentIndicatior() {
		return dataCacheEntry.getAmentIndicatior();
	}
	/**
	 * Set accessor for persistent attribute: amentIndicatior
	 */
	public void setAmentIndicatior(java.lang.String newAmentIndicatior) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getAmentIndicatior(),newAmentIndicatior);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setAmentIndicatior(newAmentIndicatior);
	}
	/**
	 * Get accessor for persistent attribute: annivInvoiceAmount
	 */
	public double getAnnivInvoiceAmount() {
		return dataCacheEntry.getAnnivInvoiceAmount();
	}
	/**
	 * Set accessor for persistent attribute: annivInvoiceAmount
	 */
	public void setAnnivInvoiceAmount(double newAnnivInvoiceAmount) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getAnnivInvoiceAmount(),newAnnivInvoiceAmount);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setAnnivInvoiceAmount(newAnnivInvoiceAmount);
	}
	/**
	 * Get accessor for persistent attribute: anniversaryAmt
	 */
	public double getAnniversaryAmt() {
		return dataCacheEntry.getAnniversaryAmt();
	}
	/**
	 * Set accessor for persistent attribute: anniversaryAmt
	 */
	public void setAnniversaryAmt(double newAnniversaryAmt) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getAnniversaryAmt(),newAnniversaryAmt);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setAnniversaryAmt(newAnniversaryAmt);
	}
	/**
	 * Get accessor for persistent attribute: approvedBy
	 */
	public java.lang.String getApprovedBy() {
		return dataCacheEntry.getApprovedBy();
	}
	/**
	 * Set accessor for persistent attribute: approvedBy
	 */
	public void setApprovedBy(java.lang.String newApprovedBy) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getApprovedBy(),newApprovedBy);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setApprovedBy(newApprovedBy);
	}
	/**
	 * Get accessor for persistent attribute: approvedDate
	 */
	public java.sql.Date getApprovedDate() {
		return dataCacheEntry.getApprovedDate();
	}
	/**
	 * Set accessor for persistent attribute: approvedDate
	 */
	public void setApprovedDate(java.sql.Date newApprovedDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getApprovedDate(),newApprovedDate);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setApprovedDate(newApprovedDate);
	}
	/**
	 * Get accessor for persistent attribute: billingBlock
	 */
	public java.lang.String getBillingBlock() {
		return dataCacheEntry.getBillingBlock();
	}
	/**
	 * Set accessor for persistent attribute: billingBlock
	 */
	public void setBillingBlock(java.lang.String newBillingBlock) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getBillingBlock(),newBillingBlock);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setBillingBlock(newBillingBlock);
	}
	/**
	 * Get accessor for persistent attribute: billingFreqCode
	 */
	public java.lang.String getBillingFreqCode() {
		return dataCacheEntry.getBillingFreqCode();
	}
	/**
	 * Set accessor for persistent attribute: billingFreqCode
	 */
	public void setBillingFreqCode(java.lang.String newBillingFreqCode) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getBillingFreqCode(),newBillingFreqCode);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setBillingFreqCode(newBillingFreqCode);
	}
	/**
	 * Get accessor for persistent attribute: billingType
	 */
	public java.lang.String getBillingType() {
		return dataCacheEntry.getBillingType();
	}
	/**
	 * Set accessor for persistent attribute: billingType
	 */
	public void setBillingType(java.lang.String newBillingType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getBillingType(),newBillingType);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setBillingType(newBillingType);
	}
	/**
	 * Get accessor for persistent attribute: capAmt
	 */
	public double getCapAmt() {
		return dataCacheEntry.getCapAmt();
	}
	/**
	 * Set accessor for persistent attribute: capAmt
	 */
	public void setCapAmt(double newCapAmt) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getCapAmt(),newCapAmt);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setCapAmt(newCapAmt);
	}
	/**
	 * Get accessor for persistent attribute: capMinus
	 */
	public double getCapMinus() {
		return dataCacheEntry.getCapMinus();
	}
	/**
	 * Set accessor for persistent attribute: capMinus
	 */
	public void setCapMinus(double newCapMinus) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getCapMinus(),newCapMinus);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setCapMinus(newCapMinus);
	}
	/**
	 * Get accessor for persistent attribute: capPlus
	 */
	public double getCapPlus() {
		return dataCacheEntry.getCapPlus();
	}
	/**
	 * Set accessor for persistent attribute: capPlus
	 */
	public void setCapPlus(double newCapPlus) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(13,getCapPlus(),newCapPlus);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setCapPlus(newCapPlus);
	}
	/**
	 * Get accessor for persistent attribute: capVariance
	 */
	public double getCapVariance() {
		return dataCacheEntry.getCapVariance();
	}
	/**
	 * Set accessor for persistent attribute: capVariance
	 */
	public void setCapVariance(double newCapVariance) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(14,getCapVariance(),newCapVariance);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setCapVariance(newCapVariance);
	}
	/**
	 * Get accessor for persistent attribute: comments
	 */
	public java.lang.String getComments() {
		return dataCacheEntry.getComments();
	}
	/**
	 * Set accessor for persistent attribute: comments
	 */
	public void setComments(java.lang.String newComments) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(15,getComments(),newComments);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setComments(newComments);
	}
	/**
	 * Get accessor for persistent attribute: contrAmendNo
	 */
	public double getContrAmendNo() {
		return dataCacheEntry.getContrAmendNo();
	}
	/**
	 * Set accessor for persistent attribute: contrAmendNo
	 */
	public void setContrAmendNo(double newContrAmendNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(16,getContrAmendNo(),newContrAmendNo);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setContrAmendNo(newContrAmendNo);
	}
	/**
	 * Get accessor for persistent attribute: contrClsDate
	 */
	public java.sql.Date getContrClsDate() {
		return dataCacheEntry.getContrClsDate();
	}
	/**
	 * Set accessor for persistent attribute: contrClsDate
	 */
	public void setContrClsDate(java.sql.Date newContrClsDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(17,getContrClsDate(),newContrClsDate);
		else
			instanceExtension.markDirty(17);
		dataCacheEntry.setContrClsDate(newContrClsDate);
	}
	/**
	 * Get accessor for persistent attribute: contrExtnDate
	 */
	public java.sql.Date getContrExtnDate() {
		return dataCacheEntry.getContrExtnDate();
	}
	/**
	 * Set accessor for persistent attribute: contrExtnDate
	 */
	public void setContrExtnDate(java.sql.Date newContrExtnDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(18,getContrExtnDate(),newContrExtnDate);
		else
			instanceExtension.markDirty(18);
		dataCacheEntry.setContrExtnDate(newContrExtnDate);
	}
	/**
	 * Get accessor for persistent attribute: contrNo
	 */
	public java.lang.String getContrNo() {
		return dataCacheEntry.getContrNo();
	}
	/**
	 * Set accessor for persistent attribute: contrNo
	 */
	public void setContrNo(java.lang.String newContrNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(19,getContrNo(),newContrNo);
		else
			instanceExtension.markDirty(19);
		dataCacheEntry.setContrNo(newContrNo);
	}
	/**
	 * Get accessor for persistent attribute: contrRenewNo
	 */
	public int getContrRenewNo() {
		return dataCacheEntry.getContrRenewNo();
	}
	/**
	 * Set accessor for persistent attribute: contrRenewNo
	 */
	public void setContrRenewNo(int newContrRenewNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(20,getContrRenewNo(),newContrRenewNo);
		else
			instanceExtension.markDirty(20);
		dataCacheEntry.setContrRenewNo(newContrRenewNo);
	}
	/**
	 * Get accessor for persistent attribute: contrReplDate
	 */
	public java.sql.Date getContrReplDate() {
		return dataCacheEntry.getContrReplDate();
	}
	/**
	 * Set accessor for persistent attribute: contrReplDate
	 */
	public void setContrReplDate(java.sql.Date newContrReplDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(21,getContrReplDate(),newContrReplDate);
		else
			instanceExtension.markDirty(21);
		dataCacheEntry.setContrReplDate(newContrReplDate);
	}
	/**
	 * Get accessor for persistent attribute: contrRetrDate
	 */
	public java.sql.Date getContrRetrDate() {
		return dataCacheEntry.getContrRetrDate();
	}
	/**
	 * Set accessor for persistent attribute: contrRetrDate
	 */
	public void setContrRetrDate(java.sql.Date newContrRetrDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(22,getContrRetrDate(),newContrRetrDate);
		else
			instanceExtension.markDirty(22);
		dataCacheEntry.setContrRetrDate(newContrRetrDate);
	}
	/**
	 * Get accessor for persistent attribute: contrType
	 */
	public java.lang.String getContrType() {
		return dataCacheEntry.getContrType();
	}
	/**
	 * Set accessor for persistent attribute: contrType
	 */
	public void setContrType(java.lang.String newContrType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(23,getContrType(),newContrType);
		else
			instanceExtension.markDirty(23);
		dataCacheEntry.setContrType(newContrType);
	}
	/**
	 * Get accessor for persistent attribute: contractCreateFlag
	 */
	public java.lang.String getContractCreateFlag() {
		return dataCacheEntry.getContractCreateFlag();
	}
	/**
	 * Set accessor for persistent attribute: contractCreateFlag
	 */
	public void setContractCreateFlag(java.lang.String newContractCreateFlag) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(24,getContractCreateFlag(),newContractCreateFlag);
		else
			instanceExtension.markDirty(24);
		dataCacheEntry.setContractCreateFlag(newContractCreateFlag);
	}
	/**
	 * Get accessor for persistent attribute: contractEndDate
	 */
	public java.sql.Date getContractEndDate() {
		return dataCacheEntry.getContractEndDate();
	}
	/**
	 * Set accessor for persistent attribute: contractEndDate
	 */
	public void setContractEndDate(java.sql.Date newContractEndDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(25,getContractEndDate(),newContractEndDate);
		else
			instanceExtension.markDirty(25);
		dataCacheEntry.setContractEndDate(newContractEndDate);
	}
	/**
	 * Get accessor for persistent attribute: contractEndPeriod
	 */
	public java.sql.Date getContractEndPeriod() {
		return dataCacheEntry.getContractEndPeriod();
	}
	/**
	 * Set accessor for persistent attribute: contractEndPeriod
	 */
	public void setContractEndPeriod(java.sql.Date newContractEndPeriod) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(26,getContractEndPeriod(),newContractEndPeriod);
		else
			instanceExtension.markDirty(26);
		dataCacheEntry.setContractEndPeriod(newContractEndPeriod);
	}
	/**
	 * Get accessor for persistent attribute: contractPeriodVarNo
	 */
	public int getContractPeriodVarNo() {
		return dataCacheEntry.getContractPeriodVarNo();
	}
	/**
	 * Set accessor for persistent attribute: contractPeriodVarNo
	 */
	public void setContractPeriodVarNo(int newContractPeriodVarNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(27,getContractPeriodVarNo(),newContractPeriodVarNo);
		else
			instanceExtension.markDirty(27);
		dataCacheEntry.setContractPeriodVarNo(newContractPeriodVarNo);
	}
	/**
	 * Get accessor for persistent attribute: contractVarNo
	 */
	public int getContractVarNo() {
		return dataCacheEntry.getContractVarNo();
	}
	/**
	 * Set accessor for persistent attribute: contractVarNo
	 */
	public void setContractVarNo(int newContractVarNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(28,getContractVarNo(),newContractVarNo);
		else
			instanceExtension.markDirty(28);
		dataCacheEntry.setContractVarNo(newContractVarNo);
	}
	/**
	 * Get accessor for persistent attribute: contractStartDate
	 */
	public java.sql.Date getContractStartDate() {
		return dataCacheEntry.getContractStartDate();
	}
	/**
	 * Set accessor for persistent attribute: contractStartDate
	 */
	public void setContractStartDate(java.sql.Date newContractStartDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(29,getContractStartDate(),newContractStartDate);
		else
			instanceExtension.markDirty(29);
		dataCacheEntry.setContractStartDate(newContractStartDate);
	}
	/**
	 * Get accessor for persistent attribute: contractStartPeriod
	 */
	public java.sql.Date getContractStartPeriod() {
		return dataCacheEntry.getContractStartPeriod();
	}
	/**
	 * Set accessor for persistent attribute: contractStartPeriod
	 */
	public void setContractStartPeriod(java.sql.Date newContractStartPeriod) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(30,getContractStartPeriod(),newContractStartPeriod);
		else
			instanceExtension.markDirty(30);
		dataCacheEntry.setContractStartPeriod(newContractStartPeriod);
	}
	/**
	 * Get accessor for persistent attribute: createdBy
	 */
	public java.lang.String getCreatedBy() {
		return dataCacheEntry.getCreatedBy();
	}
	/**
	 * Set accessor for persistent attribute: createdBy
	 */
	public void setCreatedBy(java.lang.String newCreatedBy) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(31,getCreatedBy(),newCreatedBy);
		else
			instanceExtension.markDirty(31);
		dataCacheEntry.setCreatedBy(newCreatedBy);
	}
	/**
	 * Get accessor for persistent attribute: createdDate
	 */
	public java.sql.Date getCreatedDate() {
		return dataCacheEntry.getCreatedDate();
	}
	/**
	 * Set accessor for persistent attribute: createdDate
	 */
	public void setCreatedDate(java.sql.Date newCreatedDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(32,getCreatedDate(),newCreatedDate);
		else
			instanceExtension.markDirty(32);
		dataCacheEntry.setCreatedDate(newCreatedDate);
	}
	/**
	 * Get accessor for persistent attribute: cumVariance
	 */
	public double getCumVariance() {
		return dataCacheEntry.getCumVariance();
	}
	/**
	 * Set accessor for persistent attribute: cumVariance
	 */
	public void setCumVariance(double newCumVariance) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(33,getCumVariance(),newCumVariance);
		else
			instanceExtension.markDirty(33);
		dataCacheEntry.setCumVariance(newCumVariance);
	}
	/**
	 * Get accessor for persistent attribute: currency
	 */
	public java.lang.String getCurrency() {
		return dataCacheEntry.getCurrency();
	}
	/**
	 * Set accessor for persistent attribute: currency
	 */
	public void setCurrency(java.lang.String newCurrency) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(34,getCurrency(),newCurrency);
		else
			instanceExtension.markDirty(34);
		dataCacheEntry.setCurrency(newCurrency);
	}
	/**
	 * Get accessor for persistent attribute: datePriced
	 */
	public java.sql.Date getDatePriced() {
		return dataCacheEntry.getDatePriced();
	}
	/**
	 * Set accessor for persistent attribute: datePriced
	 */
	public void setDatePriced(java.sql.Date newDatePriced) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(35,getDatePriced(),newDatePriced);
		else
			instanceExtension.markDirty(35);
		dataCacheEntry.setDatePriced(newDatePriced);
	}
	/**
	 * Get accessor for persistent attribute: deletedInd
	 */
	public java.lang.String getDeletedInd() {
		return dataCacheEntry.getDeletedInd();
	}
	/**
	 * Set accessor for persistent attribute: deletedInd
	 */
	public void setDeletedInd(java.lang.String newDeletedInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(36,getDeletedInd(),newDeletedInd);
		else
			instanceExtension.markDirty(36);
		dataCacheEntry.setDeletedInd(newDeletedInd);
	}
	/**
	 * Get accessor for persistent attribute: deltaFetchInd
	 */
	public java.lang.String getDeltaFetchInd() {
		return dataCacheEntry.getDeltaFetchInd();
	}
	/**
	 * Set accessor for persistent attribute: deltaFetchInd
	 */
	public void setDeltaFetchInd(java.lang.String newDeltaFetchInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(37,getDeltaFetchInd(),newDeltaFetchInd);
		else
			instanceExtension.markDirty(37);
		dataCacheEntry.setDeltaFetchInd(newDeltaFetchInd);
	}
	/**
	 * Get accessor for persistent attribute: deviationDateRule
	 */
	public java.lang.String getDeviationDateRule() {
		return dataCacheEntry.getDeviationDateRule();
	}
	/**
	 * Set accessor for persistent attribute: deviationDateRule
	 */
	public void setDeviationDateRule(java.lang.String newDeviationDateRule) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(38,getDeviationDateRule(),newDeviationDateRule);
		else
			instanceExtension.markDirty(38);
		dataCacheEntry.setDeviationDateRule(newDeviationDateRule);
	}
	/**
	 * Get accessor for persistent attribute: distrChannel
	 */
	public java.lang.String getDistrChannel() {
		return dataCacheEntry.getDistrChannel();
	}
	/**
	 * Set accessor for persistent attribute: distrChannel
	 */
	public void setDistrChannel(java.lang.String newDistrChannel) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(39,getDistrChannel(),newDistrChannel);
		else
			instanceExtension.markDirty(39);
		dataCacheEntry.setDistrChannel(newDistrChannel);
	}
	/**
	 * Get accessor for persistent attribute: divisionCode
	 */
	public java.lang.String getDivisionCode() {
		return dataCacheEntry.getDivisionCode();
	}
	/**
	 * Set accessor for persistent attribute: divisionCode
	 */
	public void setDivisionCode(java.lang.String newDivisionCode) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(40,getDivisionCode(),newDivisionCode);
		else
			instanceExtension.markDirty(40);
		dataCacheEntry.setDivisionCode(newDivisionCode);
	}
	/**
	 * Get accessor for persistent attribute: eswFetchDate
	 */
	public java.sql.Date getEswFetchDate() {
		return dataCacheEntry.getEswFetchDate();
	}
	/**
	 * Set accessor for persistent attribute: eswFetchDate
	 */
	public void setEswFetchDate(java.sql.Date newEswFetchDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(41,getEswFetchDate(),newEswFetchDate);
		else
			instanceExtension.markDirty(41);
		dataCacheEntry.setEswFetchDate(newEswFetchDate);
	}
	/**
	 * Get accessor for persistent attribute: eswFetchTime
	 */
	public java.sql.Time getEswFetchTime() {
		return dataCacheEntry.getEswFetchTime();
	}
	/**
	 * Set accessor for persistent attribute: eswFetchTime
	 */
	public void setEswFetchTime(java.sql.Time newEswFetchTime) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(42,getEswFetchTime(),newEswFetchTime);
		else
			instanceExtension.markDirty(42);
		dataCacheEntry.setEswFetchTime(newEswFetchTime);
	}
	/**
	 * Get accessor for persistent attribute: extContractNo
	 */
	public java.lang.String getExtContractNo() {
		return dataCacheEntry.getExtContractNo();
	}
	/**
	 * Set accessor for persistent attribute: extContractNo
	 */
	public void setExtContractNo(java.lang.String newExtContractNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(43,getExtContractNo(),newExtContractNo);
		else
			instanceExtension.markDirty(43);
		dataCacheEntry.setExtContractNo(newExtContractNo);
	}
	/**
	 * Get accessor for persistent attribute: fetchDate
	 */
	public java.sql.Date getFetchDate() {
		return dataCacheEntry.getFetchDate();
	}
	/**
	 * Set accessor for persistent attribute: fetchDate
	 */
	public void setFetchDate(java.sql.Date newFetchDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(44,getFetchDate(),newFetchDate);
		else
			instanceExtension.markDirty(44);
		dataCacheEntry.setFetchDate(newFetchDate);
	}
	/**
	 * Get accessor for persistent attribute: fixedValueDate
	 */
	public java.sql.Date getFixedValueDate() {
		return dataCacheEntry.getFixedValueDate();
	}
	/**
	 * Set accessor for persistent attribute: fixedValueDate
	 */
	public void setFixedValueDate(java.sql.Date newFixedValueDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(45,getFixedValueDate(),newFixedValueDate);
		else
			instanceExtension.markDirty(45);
		dataCacheEntry.setFixedValueDate(newFixedValueDate);
	}
	/**
	 * Get accessor for persistent attribute: freeText
	 */
	public java.lang.String getFreeText() {
		return dataCacheEntry.getFreeText();
	}
	/**
	 * Set accessor for persistent attribute: freeText
	 */
	public void setFreeText(java.lang.String newFreeText) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(46,getFreeText(),newFreeText);
		else
			instanceExtension.markDirty(46);
		dataCacheEntry.setFreeText(newFreeText);
	}
	/**
	 * Get accessor for persistent attribute: growthFactor
	 */
	public double getGrowthFactor() {
		return dataCacheEntry.getGrowthFactor();
	}
	/**
	 * Set accessor for persistent attribute: growthFactor
	 */
	public void setGrowthFactor(double newGrowthFactor) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(47,getGrowthFactor(),newGrowthFactor);
		else
			instanceExtension.markDirty(47);
		dataCacheEntry.setGrowthFactor(newGrowthFactor);
	}
	/**
	 * Get accessor for persistent attribute: gsaInd
	 */
	public java.lang.String getGsaInd() {
		return dataCacheEntry.getGsaInd();
	}
	/**
	 * Set accessor for persistent attribute: gsaInd
	 */
	public void setGsaInd(java.lang.String newGsaInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(48,getGsaInd(),newGsaInd);
		else
			instanceExtension.markDirty(48);
		dataCacheEntry.setGsaInd(newGsaInd);
	}
	/**
	 * Get accessor for persistent attribute: ineligibleInd
	 */
	public java.lang.String getIneligibleInd() {
		return dataCacheEntry.getIneligibleInd();
	}
	/**
	 * Set accessor for persistent attribute: ineligibleInd
	 */
	public void setIneligibleInd(java.lang.String newIneligibleInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(49,getIneligibleInd(),newIneligibleInd);
		else
			instanceExtension.markDirty(49);
		dataCacheEntry.setIneligibleInd(newIneligibleInd);
	}
	/**
	 * Get accessor for persistent attribute: invoiceAmt
	 */
	public double getInvoiceAmt() {
		return dataCacheEntry.getInvoiceAmt();
	}
	/**
	 * Set accessor for persistent attribute: invoiceAmt
	 */
	public void setInvoiceAmt(double newInvoiceAmt) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(50,getInvoiceAmt(),newInvoiceAmt);
		else
			instanceExtension.markDirty(50);
		dataCacheEntry.setInvoiceAmt(newInvoiceAmt);
	}
	/**
	 * Get accessor for persistent attribute: invoiceInd
	 */
	public java.lang.String getInvoiceInd() {
		return dataCacheEntry.getInvoiceInd();
	}
	/**
	 * Set accessor for persistent attribute: invoiceInd
	 */
	public void setInvoiceInd(java.lang.String newInvoiceInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(51,getInvoiceInd(),newInvoiceInd);
		else
			instanceExtension.markDirty(51);
		dataCacheEntry.setInvoiceInd(newInvoiceInd);
	}
	/**
	 * Get accessor for persistent attribute: lastUpdatedDate
	 */
	public java.sql.Date getLastUpdatedDate() {
		return dataCacheEntry.getLastUpdatedDate();
	}
	/**
	 * Set accessor for persistent attribute: lastUpdatedDate
	 */
	public void setLastUpdatedDate(java.sql.Date newLastUpdatedDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(52,getLastUpdatedDate(),newLastUpdatedDate);
		else
			instanceExtension.markDirty(52);
		dataCacheEntry.setLastUpdatedDate(newLastUpdatedDate);
	}
	/**
	 * Get accessor for persistent attribute: lockedBy
	 */
	public java.lang.String getLockedBy() {
		return dataCacheEntry.getLockedBy();
	}
	/**
	 * Set accessor for persistent attribute: lockedBy
	 */
	public void setLockedBy(java.lang.String newLockedBy) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(53,getLockedBy(),newLockedBy);
		else
			instanceExtension.markDirty(53);
		dataCacheEntry.setLockedBy(newLockedBy);
	}
	/**
	 * Get accessor for persistent attribute: monthlyInvoiceAmount
	 */
	public double getMonthlyInvoiceAmount() {
		return dataCacheEntry.getMonthlyInvoiceAmount();
	}
	/**
	 * Set accessor for persistent attribute: monthlyInvoiceAmount
	 */
	public void setMonthlyInvoiceAmount(double newMonthlyInvoiceAmount) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(54,getMonthlyInvoiceAmount(),newMonthlyInvoiceAmount);
		else
			instanceExtension.markDirty(54);
		dataCacheEntry.setMonthlyInvoiceAmount(newMonthlyInvoiceAmount);
	}
	/**
	 * Get accessor for persistent attribute: oldContractNo
	 */
	public java.lang.String getOldContractNo() {
		return dataCacheEntry.getOldContractNo();
	}
	/**
	 * Set accessor for persistent attribute: oldContractNo
	 */
	public void setOldContractNo(java.lang.String newOldContractNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(55,getOldContractNo(),newOldContractNo);
		else
			instanceExtension.markDirty(55);
		dataCacheEntry.setOldContractNo(newOldContractNo);
	}
	/**
	 * Get accessor for persistent attribute: poDate
	 */
	public java.sql.Date getPoDate() {
		return dataCacheEntry.getPoDate();
	}
	/**
	 * Set accessor for persistent attribute: poDate
	 */
	public void setPoDate(java.sql.Date newPoDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(56,getPoDate(),newPoDate);
		else
			instanceExtension.markDirty(56);
		dataCacheEntry.setPoDate(newPoDate);
	}
	/**
	 * Get accessor for persistent attribute: orgVarContractNo
	 */
	public java.lang.String getOrgVarContractNo() {
		return dataCacheEntry.getOrgVarContractNo();
	}
	/**
	 * Set accessor for persistent attribute: orgVarContractNo
	 */
	public void setOrgVarContractNo(java.lang.String newOrgVarContractNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(57,getOrgVarContractNo(),newOrgVarContractNo);
		else
			instanceExtension.markDirty(57);
		dataCacheEntry.setOrgVarContractNo(newOrgVarContractNo);
	}
	/**
	 * Get accessor for persistent attribute: pakId
	 */
	public java.lang.String getPakId() {
		return dataCacheEntry.getPakId();
	}
	/**
	 * Set accessor for persistent attribute: pakId
	 */
	public void setPakId(java.lang.String newPakId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(58,getPakId(),newPakId);
		else
			instanceExtension.markDirty(58);
		dataCacheEntry.setPakId(newPakId);
	}
	/**
	 * Get accessor for persistent attribute: paymentTerm
	 */
	public java.lang.String getPaymentTerm() {
		return dataCacheEntry.getPaymentTerm();
	}
	/**
	 * Set accessor for persistent attribute: paymentTerm
	 */
	public void setPaymentTerm(java.lang.String newPaymentTerm) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(59,getPaymentTerm(),newPaymentTerm);
		else
			instanceExtension.markDirty(59);
		dataCacheEntry.setPaymentTerm(newPaymentTerm);
	}
	/**
	 * Get accessor for persistent attribute: poNo
	 */
	public java.lang.String getPoNo() {
		return dataCacheEntry.getPoNo();
	}
	/**
	 * Set accessor for persistent attribute: poNo
	 */
	public void setPoNo(java.lang.String newPoNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(60,getPoNo(),newPoNo);
		else
			instanceExtension.markDirty(60);
		dataCacheEntry.setPoNo(newPoNo);
	}
	/**
	 * Get accessor for persistent attribute: preTVMInvoiceAmt
	 */
	public double getPreTVMInvoiceAmt() {
		return dataCacheEntry.getPreTVMInvoiceAmt();
	}
	/**
	 * Set accessor for persistent attribute: preTVMInvoiceAmt
	 */
	public void setPreTVMInvoiceAmt(double newPreTVMInvoiceAmt) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(61,getPreTVMInvoiceAmt(),newPreTVMInvoiceAmt);
		else
			instanceExtension.markDirty(61);
		dataCacheEntry.setPreTVMInvoiceAmt(newPreTVMInvoiceAmt);
	}
	/**
	 * Get accessor for persistent attribute: preTvm
	 */
	public double getPreTvm() {
		return dataCacheEntry.getPreTvm();
	}
	/**
	 * Set accessor for persistent attribute: preTvm
	 */
	public void setPreTvm(double newPreTvm) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(62,getPreTvm(),newPreTvm);
		else
			instanceExtension.markDirty(62);
		dataCacheEntry.setPreTvm(newPreTvm);
	}
	/**
	 * Get accessor for persistent attribute: proposalName
	 */
	public java.lang.String getProposalName() {
		return dataCacheEntry.getProposalName();
	}
	/**
	 * Set accessor for persistent attribute: proposalName
	 */
	public void setProposalName(java.lang.String newProposalName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(63,getProposalName(),newProposalName);
		else
			instanceExtension.markDirty(63);
		dataCacheEntry.setProposalName(newProposalName);
	}
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public int getProposalId() {
		return dataCacheEntry.getProposalId();
	}
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public void setProposalId(int newProposalId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(64,getProposalId(),newProposalId);
		else
			instanceExtension.markDirty(64);
		dataCacheEntry.setProposalId(newProposalId);
	}
	/**
	 * Get accessor for persistent attribute: proposalSharing
	 */
	public java.lang.String getProposalSharing() {
		return dataCacheEntry.getProposalSharing();
	}
	/**
	 * Set accessor for persistent attribute: proposalSharing
	 */
	public void setProposalSharing(java.lang.String newProposalSharing) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(65,getProposalSharing(),newProposalSharing);
		else
			instanceExtension.markDirty(65);
		dataCacheEntry.setProposalSharing(newProposalSharing);
	}
	/**
	 * Get accessor for persistent attribute: proposalType
	 */
	public java.lang.String getProposalType() {
		return dataCacheEntry.getProposalType();
	}
	/**
	 * Set accessor for persistent attribute: proposalType
	 */
	public void setProposalType(java.lang.String newProposalType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(66,getProposalType(),newProposalType);
		else
			instanceExtension.markDirty(66);
		dataCacheEntry.setProposalType(newProposalType);
	}
	/**
	 * Get accessor for persistent attribute: quarterlyInvoiceAmount
	 */
	public double getQuarterlyInvoiceAmount() {
		return dataCacheEntry.getQuarterlyInvoiceAmount();
	}
	/**
	 * Set accessor for persistent attribute: quarterlyInvoiceAmount
	 */
	public void setQuarterlyInvoiceAmount(double newQuarterlyInvoiceAmount) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(67,getQuarterlyInvoiceAmount(),newQuarterlyInvoiceAmount);
		else
			instanceExtension.markDirty(67);
		dataCacheEntry.setQuarterlyInvoiceAmount(newQuarterlyInvoiceAmount);
	}
	/**
	 * Get accessor for persistent attribute: refetchInd
	 */
	public java.lang.String getRefetchInd() {
		return dataCacheEntry.getRefetchInd();
	}
	/**
	 * Set accessor for persistent attribute: refetchInd
	 */
	public void setRefetchInd(java.lang.String newRefetchInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(68,getRefetchInd(),newRefetchInd);
		else
			instanceExtension.markDirty(68);
		dataCacheEntry.setRefetchInd(newRefetchInd);
	}
	/**
	 * Get accessor for persistent attribute: reg9DPartmerName
	 */
	public java.lang.String getReg9DPartmerName() {
		return dataCacheEntry.getReg9DPartmerName();
	}
	/**
	 * Set accessor for persistent attribute: reg9DPartmerName
	 */
	public void setReg9DPartmerName(java.lang.String newReg9DPartmerName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(69,getReg9DPartmerName(),newReg9DPartmerName);
		else
			instanceExtension.markDirty(69);
		dataCacheEntry.setReg9DPartmerName(newReg9DPartmerName);
	}
	/**
	 * Get accessor for persistent attribute: reg9DPartnerNo
	 */
	public java.lang.String getReg9DPartnerNo() {
		return dataCacheEntry.getReg9DPartnerNo();
	}
	/**
	 * Set accessor for persistent attribute: reg9DPartnerNo
	 */
	public void setReg9DPartnerNo(java.lang.String newReg9DPartnerNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(70,getReg9DPartnerNo(),newReg9DPartnerNo);
		else
			instanceExtension.markDirty(70);
		dataCacheEntry.setReg9DPartnerNo(newReg9DPartnerNo);
	}
	/**
	 * Get accessor for persistent attribute: regBillToPartyASNo
	 */
	public java.lang.String getRegBillToPartyASNo() {
		return dataCacheEntry.getRegBillToPartyASNo();
	}
	/**
	 * Set accessor for persistent attribute: regBillToPartyASNo
	 */
	public void setRegBillToPartyASNo(java.lang.String newRegBillToPartyASNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(71,getRegBillToPartyASNo(),newRegBillToPartyASNo);
		else
			instanceExtension.markDirty(71);
		dataCacheEntry.setRegBillToPartyASNo(newRegBillToPartyASNo);
	}
	/**
	 * Get accessor for persistent attribute: regBillToPartyListNo
	 */
	public java.lang.String getRegBillToPartyListNo() {
		return dataCacheEntry.getRegBillToPartyListNo();
	}
	/**
	 * Set accessor for persistent attribute: regBillToPartyListNo
	 */
	public void setRegBillToPartyListNo(java.lang.String newRegBillToPartyListNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(72,getRegBillToPartyListNo(),newRegBillToPartyListNo);
		else
			instanceExtension.markDirty(72);
		dataCacheEntry.setRegBillToPartyListNo(newRegBillToPartyListNo);
	}
	/**
	 * Get accessor for persistent attribute: regBillToPartyName
	 */
	public java.lang.String getRegBillToPartyName() {
		return dataCacheEntry.getRegBillToPartyName();
	}
	/**
	 * Set accessor for persistent attribute: regBillToPartyName
	 */
	public void setRegBillToPartyName(java.lang.String newRegBillToPartyName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(73,getRegBillToPartyName(),newRegBillToPartyName);
		else
			instanceExtension.markDirty(73);
		dataCacheEntry.setRegBillToPartyName(newRegBillToPartyName);
	}
	/**
	 * Get accessor for persistent attribute: regBilltoPartyNo
	 */
	public java.lang.String getRegBilltoPartyNo() {
		return dataCacheEntry.getRegBilltoPartyNo();
	}
	/**
	 * Set accessor for persistent attribute: regBilltoPartyNo
	 */
	public void setRegBilltoPartyNo(java.lang.String newRegBilltoPartyNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(74,getRegBilltoPartyNo(),newRegBilltoPartyNo);
		else
			instanceExtension.markDirty(74);
		dataCacheEntry.setRegBilltoPartyNo(newRegBilltoPartyNo);
	}
	/**
	 * Get accessor for persistent attribute: regCustomerASNO
	 */
	public java.lang.String getRegCustomerASNO() {
		return dataCacheEntry.getRegCustomerASNO();
	}
	/**
	 * Set accessor for persistent attribute: regCustomerASNO
	 */
	public void setRegCustomerASNO(java.lang.String newRegCustomerASNO) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(75,getRegCustomerASNO(),newRegCustomerASNO);
		else
			instanceExtension.markDirty(75);
		dataCacheEntry.setRegCustomerASNO(newRegCustomerASNO);
	}
	/**
	 * Get accessor for persistent attribute: regCustomerListNo
	 */
	public java.lang.String getRegCustomerListNo() {
		return dataCacheEntry.getRegCustomerListNo();
	}
	/**
	 * Set accessor for persistent attribute: regCustomerListNo
	 */
	public void setRegCustomerListNo(java.lang.String newRegCustomerListNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(76,getRegCustomerListNo(),newRegCustomerListNo);
		else
			instanceExtension.markDirty(76);
		dataCacheEntry.setRegCustomerListNo(newRegCustomerListNo);
	}
	/**
	 * Get accessor for persistent attribute: regCustomerName
	 */
	public java.lang.String getRegCustomerName() {
		return dataCacheEntry.getRegCustomerName();
	}
	/**
	 * Set accessor for persistent attribute: regCustomerName
	 */
	public void setRegCustomerName(java.lang.String newRegCustomerName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(77,getRegCustomerName(),newRegCustomerName);
		else
			instanceExtension.markDirty(77);
		dataCacheEntry.setRegCustomerName(newRegCustomerName);
	}
	/**
	 * Get accessor for persistent attribute: regCustomerNo
	 */
	public java.lang.String getRegCustomerNo() {
		return dataCacheEntry.getRegCustomerNo();
	}
	/**
	 * Set accessor for persistent attribute: regCustomerNo
	 */
	public void setRegCustomerNo(java.lang.String newRegCustomerNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(78,getRegCustomerNo(),newRegCustomerNo);
		else
			instanceExtension.markDirty(78);
		dataCacheEntry.setRegCustomerNo(newRegCustomerNo);
	}
	/**
	 * Get accessor for persistent attribute: regPayerASNo
	 */
	public java.lang.String getRegPayerASNo() {
		return dataCacheEntry.getRegPayerASNo();
	}
	/**
	 * Set accessor for persistent attribute: regPayerASNo
	 */
	public void setRegPayerASNo(java.lang.String newRegPayerASNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(79,getRegPayerASNo(),newRegPayerASNo);
		else
			instanceExtension.markDirty(79);
		dataCacheEntry.setRegPayerASNo(newRegPayerASNo);
	}
	/**
	 * Get accessor for persistent attribute: regPayerListNo
	 */
	public java.lang.String getRegPayerListNo() {
		return dataCacheEntry.getRegPayerListNo();
	}
	/**
	 * Set accessor for persistent attribute: regPayerListNo
	 */
	public void setRegPayerListNo(java.lang.String newRegPayerListNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(80,getRegPayerListNo(),newRegPayerListNo);
		else
			instanceExtension.markDirty(80);
		dataCacheEntry.setRegPayerListNo(newRegPayerListNo);
	}
	/**
	 * Get accessor for persistent attribute: regPayerName
	 */
	public java.lang.String getRegPayerName() {
		return dataCacheEntry.getRegPayerName();
	}
	/**
	 * Set accessor for persistent attribute: regPayerName
	 */
	public void setRegPayerName(java.lang.String newRegPayerName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(81,getRegPayerName(),newRegPayerName);
		else
			instanceExtension.markDirty(81);
		dataCacheEntry.setRegPayerName(newRegPayerName);
	}
	/**
	 * Get accessor for persistent attribute: regPayerNo
	 */
	public java.lang.String getRegPayerNo() {
		return dataCacheEntry.getRegPayerNo();
	}
	/**
	 * Set accessor for persistent attribute: regPayerNo
	 */
	public void setRegPayerNo(java.lang.String newRegPayerNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(82,getRegPayerNo(),newRegPayerNo);
		else
			instanceExtension.markDirty(82);
		dataCacheEntry.setRegPayerNo(newRegPayerNo);
	}
	/**
	 * Get accessor for persistent attribute: regShipTOPartyASNo
	 */
	public java.lang.String getRegShipTOPartyASNo() {
		return dataCacheEntry.getRegShipTOPartyASNo();
	}
	/**
	 * Set accessor for persistent attribute: regShipTOPartyASNo
	 */
	public void setRegShipTOPartyASNo(java.lang.String newRegShipTOPartyASNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(83,getRegShipTOPartyASNo(),newRegShipTOPartyASNo);
		else
			instanceExtension.markDirty(83);
		dataCacheEntry.setRegShipTOPartyASNo(newRegShipTOPartyASNo);
	}
	/**
	 * Get accessor for persistent attribute: regShipToPartyListNo
	 */
	public java.lang.String getRegShipToPartyListNo() {
		return dataCacheEntry.getRegShipToPartyListNo();
	}
	/**
	 * Set accessor for persistent attribute: regShipToPartyListNo
	 */
	public void setRegShipToPartyListNo(java.lang.String newRegShipToPartyListNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(84,getRegShipToPartyListNo(),newRegShipToPartyListNo);
		else
			instanceExtension.markDirty(84);
		dataCacheEntry.setRegShipToPartyListNo(newRegShipToPartyListNo);
	}
	/**
	 * Get accessor for persistent attribute: regShipToPartyName
	 */
	public java.lang.String getRegShipToPartyName() {
		return dataCacheEntry.getRegShipToPartyName();
	}
	/**
	 * Set accessor for persistent attribute: regShipToPartyName
	 */
	public void setRegShipToPartyName(java.lang.String newRegShipToPartyName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(85,getRegShipToPartyName(),newRegShipToPartyName);
		else
			instanceExtension.markDirty(85);
		dataCacheEntry.setRegShipToPartyName(newRegShipToPartyName);
	}
	/**
	 * Get accessor for persistent attribute: regShipToPartyNo
	 */
	public java.lang.String getRegShipToPartyNo() {
		return dataCacheEntry.getRegShipToPartyNo();
	}
	/**
	 * Set accessor for persistent attribute: regShipToPartyNo
	 */
	public void setRegShipToPartyNo(java.lang.String newRegShipToPartyNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(86,getRegShipToPartyNo(),newRegShipToPartyNo);
		else
			instanceExtension.markDirty(86);
		dataCacheEntry.setRegShipToPartyNo(newRegShipToPartyNo);
	}
	/**
	 * Get accessor for persistent attribute: reportName
	 */
	public java.lang.String getReportName() {
		return dataCacheEntry.getReportName();
	}
	/**
	 * Set accessor for persistent attribute: reportName
	 */
	public void setReportName(java.lang.String newReportName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(87,getReportName(),newReportName);
		else
			instanceExtension.markDirty(87);
		dataCacheEntry.setReportName(newReportName);
	}
	/**
	 * Get accessor for persistent attribute: sAndSIncluded
	 */
	public java.lang.String getSAndSIncluded() {
		return dataCacheEntry.getSAndSIncluded();
	}
	/**
	 * Set accessor for persistent attribute: sAndSIncluded
	 */
	public void setSAndSIncluded(java.lang.String newSAndSIncluded) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(88,getSAndSIncluded(),newSAndSIncluded);
		else
			instanceExtension.markDirty(88);
		dataCacheEntry.setSAndSIncluded(newSAndSIncluded);
	}
	/**
	 * Get accessor for persistent attribute: salesOrg
	 */
	public java.lang.String getSalesOrg() {
		return dataCacheEntry.getSalesOrg();
	}
	/**
	 * Set accessor for persistent attribute: salesOrg
	 */
	public void setSalesOrg(java.lang.String newSalesOrg) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(89,getSalesOrg(),newSalesOrg);
		else
			instanceExtension.markDirty(89);
		dataCacheEntry.setSalesOrg(newSalesOrg);
	}
	/**
	 * Get accessor for persistent attribute: semiAnnivInvoiceAmount
	 */
	public double getSemiAnnivInvoiceAmount() {
		return dataCacheEntry.getSemiAnnivInvoiceAmount();
	}
	/**
	 * Set accessor for persistent attribute: semiAnnivInvoiceAmount
	 */
	public void setSemiAnnivInvoiceAmount(double newSemiAnnivInvoiceAmount) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(90,getSemiAnnivInvoiceAmount(),newSemiAnnivInvoiceAmount);
		else
			instanceExtension.markDirty(90);
		dataCacheEntry.setSemiAnnivInvoiceAmount(newSemiAnnivInvoiceAmount);
	}
	/**
	 * Get accessor for persistent attribute: specialRate
	 */
	public double getSpecialRate() {
		return dataCacheEntry.getSpecialRate();
	}
	/**
	 * Set accessor for persistent attribute: specialRate
	 */
	public void setSpecialRate(double newSpecialRate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(91,getSpecialRate(),newSpecialRate);
		else
			instanceExtension.markDirty(91);
		dataCacheEntry.setSpecialRate(newSpecialRate);
	}
	/**
	 * Get accessor for persistent attribute: statusCode
	 */
	public java.lang.String getStatusCode() {
		return dataCacheEntry.getStatusCode();
	}
	/**
	 * Set accessor for persistent attribute: statusCode
	 */
	public void setStatusCode(java.lang.String newStatusCode) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(92,getStatusCode(),newStatusCode);
		else
			instanceExtension.markDirty(92);
		dataCacheEntry.setStatusCode(newStatusCode);
	}
	/**
	 * Get accessor for persistent attribute: suppressInvoice
	 */
	public java.lang.String getSuppressInvoice() {
		return dataCacheEntry.getSuppressInvoice();
	}
	/**
	 * Set accessor for persistent attribute: suppressInvoice
	 */
	public void setSuppressInvoice(java.lang.String newSuppressInvoice) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(93,getSuppressInvoice(),newSuppressInvoice);
		else
			instanceExtension.markDirty(93);
		dataCacheEntry.setSuppressInvoice(newSuppressInvoice);
	}
	/**
	 * Get accessor for persistent attribute: tpContractNo
	 */
	public java.lang.String getTpContractNo() {
		return dataCacheEntry.getTpContractNo();
	}
	/**
	 * Set accessor for persistent attribute: tpContractNo
	 */
	public void setTpContractNo(java.lang.String newTpContractNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(94,getTpContractNo(),newTpContractNo);
		else
			instanceExtension.markDirty(94);
		dataCacheEntry.setTpContractNo(newTpContractNo);
	}
	/**
	 * Get accessor for persistent attribute: tvmRate
	 */
	public double getTvmRate() {
		return dataCacheEntry.getTvmRate();
	}
	/**
	 * Set accessor for persistent attribute: tvmRate
	 */
	public void setTvmRate(double newTvmRate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(95,getTvmRate(),newTvmRate);
		else
			instanceExtension.markDirty(95);
		dataCacheEntry.setTvmRate(newTvmRate);
	}
	/**
	 * Get accessor for persistent attribute: varDate
	 */
	public java.sql.Date getVarDate() {
		return dataCacheEntry.getVarDate();
	}
	/**
	 * Set accessor for persistent attribute: varDate
	 */
	public void setVarDate(java.sql.Date newVarDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(96,getVarDate(),newVarDate);
		else
			instanceExtension.markDirty(96);
		dataCacheEntry.setVarDate(newVarDate);
	}
	/**
	 * Get accessor for persistent attribute: varInd
	 */
	public java.lang.String getVarInd() {
		return dataCacheEntry.getVarInd();
	}
	/**
	 * Set accessor for persistent attribute: varInd
	 */
	public void setVarInd(java.lang.String newVarInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(97,getVarInd(),newVarInd);
		else
			instanceExtension.markDirty(97);
		dataCacheEntry.setVarInd(newVarInd);
	}
	/**
	 * Get accessor for persistent attribute: lockedOn
	 */
	public java.sql.Date getLockedOn() {
		return dataCacheEntry.getLockedOn();
	}
	/**
	 * Set accessor for persistent attribute: lockedOn
	 */
	public void setLockedOn(java.sql.Date newLockedOn) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(98,getLockedOn(),newLockedOn);
		else
			instanceExtension.markDirty(98);
		dataCacheEntry.setLockedOn(newLockedOn);
	}
	/**
	 * Get accessor for persistent attribute: contractReplNo
	 */
	public int getContractReplNo() {
		return dataCacheEntry.getContractReplNo();
	}
	/**
	 * Set accessor for persistent attribute: contractReplNo
	 */
	public void setContractReplNo(int newContractReplNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(99,getContractReplNo(),newContractReplNo);
		else
			instanceExtension.markDirty(99);
		dataCacheEntry.setContractReplNo(newContractReplNo);
	}
	/**
	 * Get accessor for persistent attribute: igfNumber
	 */
	public java.lang.String getIgfNumber() {
		return dataCacheEntry.getIgfNumber();
	}
	/**
	 * Set accessor for persistent attribute: igfNumber
	 */
	public void setIgfNumber(java.lang.String newIgfNumber) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(100,getIgfNumber(),newIgfNumber);
		else
			instanceExtension.markDirty(100);
		dataCacheEntry.setIgfNumber(newIgfNumber);
	}
	/**
	 * Get accessor for persistent attribute: sandsanniversaryamt
	 */
	public double getSandsanniversaryamt() {
		return dataCacheEntry.getSandsanniversaryamt();
	}
	/**
	 * Set accessor for persistent attribute: sandsanniversaryamt
	 */
	public void setSandsanniversaryamt(double newSandsanniversaryamt) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(101,getSandsanniversaryamt(),newSandsanniversaryamt);
		else
			instanceExtension.markDirty(101);
		dataCacheEntry.setSandsanniversaryamt(newSandsanniversaryamt);
	}
	/**
	 * Get accessor for persistent attribute: sandsdiscountamount
	 */
	public double getSandsdiscountamount() {
		return dataCacheEntry.getSandsdiscountamount();
	}
	/**
	 * Set accessor for persistent attribute: sandsdiscountamount
	 */
	public void setSandsdiscountamount(double newSandsdiscountamount) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(102,getSandsdiscountamount(),newSandsdiscountamount);
		else
			instanceExtension.markDirty(102);
		dataCacheEntry.setSandsdiscountamount(newSandsdiscountamount);
	}
	/**
	 * Get accessor for persistent attribute: proposalContent
	 */
	public java.lang.String getProposalContent() {
		return dataCacheEntry.getProposalContent();
	}
	/**
	 * Set accessor for persistent attribute: proposalContent
	 */
	public void setProposalContent(java.lang.String newProposalContent) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(103,getProposalContent(),newProposalContent);
		else
			instanceExtension.markDirty(103);
		dataCacheEntry.setProposalContent(newProposalContent);
	}
	/**
	 * Get accessor for persistent attribute: submittedBy
	 */
	public java.lang.String getSubmittedBy() {
		return dataCacheEntry.getSubmittedBy();
	}
	/**
	 * Set accessor for persistent attribute: submittedBy
	 */
	public void setSubmittedBy(java.lang.String newSubmittedBy) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(104,getSubmittedBy(),newSubmittedBy);
		else
			instanceExtension.markDirty(104);
		dataCacheEntry.setSubmittedBy(newSubmittedBy);
	}
	/**
	 * Get accessor for persistent attribute: groupName
	 */
	public java.lang.String getGroupName() {
		return dataCacheEntry.getGroupName();
	}
	/**
	 * Set accessor for persistent attribute: groupName
	 */
	public void setGroupName(java.lang.String newGroupName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(105,getGroupName(),newGroupName);
		else
			instanceExtension.markDirty(105);
		dataCacheEntry.setGroupName(newGroupName);
	}
	/**
	 * Get accessor for persistent attribute: sandsExtendPeriod
	 */
	public java.lang.String getSandsExtendPeriod() {
		return dataCacheEntry.getSandsExtendPeriod();
	}
	/**
	 * Set accessor for persistent attribute: sandsExtendPeriod
	 */
	public void setSandsExtendPeriod(java.lang.String newSandsExtendPeriod) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(106,getSandsExtendPeriod(),newSandsExtendPeriod);
		else
			instanceExtension.markDirty(106);
		dataCacheEntry.setSandsExtendPeriod(newSandsExtendPeriod);
	}
	/**
	 * Get accessor for persistent attribute: sandsAnniversaryAmt2
	 */
	public double getSandsAnniversaryAmt2() {
		return dataCacheEntry.getSandsAnniversaryAmt2();
	}
	/**
	 * Set accessor for persistent attribute: sandsAnniversaryAmt2
	 */
	public void setSandsAnniversaryAmt2(double newSandsAnniversaryAmt2) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(107,getSandsAnniversaryAmt2(),newSandsAnniversaryAmt2);
		else
			instanceExtension.markDirty(107);
		dataCacheEntry.setSandsAnniversaryAmt2(newSandsAnniversaryAmt2);
	}
	/**
	 * Get accessor for persistent attribute: sandsAnniversaryAmt3
	 */
	public double getSandsAnniversaryAmt3() {
		return dataCacheEntry.getSandsAnniversaryAmt3();
	}
	/**
	 * Set accessor for persistent attribute: sandsAnniversaryAmt3
	 */
	public void setSandsAnniversaryAmt3(double newSandsAnniversaryAmt3) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(108,getSandsAnniversaryAmt3(),newSandsAnniversaryAmt3);
		else
			instanceExtension.markDirty(108);
		dataCacheEntry.setSandsAnniversaryAmt3(newSandsAnniversaryAmt3);
	}
	/**
	 * Get accessor for persistent attribute: sandsAnniversaryAmt4
	 */
	public double getSandsAnniversaryAmt4() {
		return dataCacheEntry.getSandsAnniversaryAmt4();
	}
	/**
	 * Set accessor for persistent attribute: sandsAnniversaryAmt4
	 */
	public void setSandsAnniversaryAmt4(double newSandsAnniversaryAmt4) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(109,getSandsAnniversaryAmt4(),newSandsAnniversaryAmt4);
		else
			instanceExtension.markDirty(109);
		dataCacheEntry.setSandsAnniversaryAmt4(newSandsAnniversaryAmt4);
	}
	/**
	 * Get accessor for persistent attribute: sandsAnniversaryAmt5
	 */
	public double getSandsAnniversaryAmt5() {
		return dataCacheEntry.getSandsAnniversaryAmt5();
	}
	/**
	 * Set accessor for persistent attribute: sandsAnniversaryAmt5
	 */
	public void setSandsAnniversaryAmt5(double newSandsAnniversaryAmt5) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(110,getSandsAnniversaryAmt5(),newSandsAnniversaryAmt5);
		else
			instanceExtension.markDirty(110);
		dataCacheEntry.setSandsAnniversaryAmt5(newSandsAnniversaryAmt5);
	}
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount1
	 */
	public double getSandsDiscountAmount1() {
		return dataCacheEntry.getSandsDiscountAmount1();
	}
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount1
	 */
	public void setSandsDiscountAmount1(double newSandsDiscountAmount1) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(111,getSandsDiscountAmount1(),newSandsDiscountAmount1);
		else
			instanceExtension.markDirty(111);
		dataCacheEntry.setSandsDiscountAmount1(newSandsDiscountAmount1);
	}
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount2
	 */
	public double getSandsDiscountAmount2() {
		return dataCacheEntry.getSandsDiscountAmount2();
	}
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount2
	 */
	public void setSandsDiscountAmount2(double newSandsDiscountAmount2) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(112,getSandsDiscountAmount2(),newSandsDiscountAmount2);
		else
			instanceExtension.markDirty(112);
		dataCacheEntry.setSandsDiscountAmount2(newSandsDiscountAmount2);
	}
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount3
	 */
	public double getSandsDiscountAmount3() {
		return dataCacheEntry.getSandsDiscountAmount3();
	}
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount3
	 */
	public void setSandsDiscountAmount3(double newSandsDiscountAmount3) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(113,getSandsDiscountAmount3(),newSandsDiscountAmount3);
		else
			instanceExtension.markDirty(113);
		dataCacheEntry.setSandsDiscountAmount3(newSandsDiscountAmount3);
	}
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount4
	 */
	public double getSandsDiscountAmount4() {
		return dataCacheEntry.getSandsDiscountAmount4();
	}
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount4
	 */
	public void setSandsDiscountAmount4(double newSandsDiscountAmount4) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(114,getSandsDiscountAmount4(),newSandsDiscountAmount4);
		else
			instanceExtension.markDirty(114);
		dataCacheEntry.setSandsDiscountAmount4(newSandsDiscountAmount4);
	}
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount5
	 */
	public double getSandsDiscountAmount5() {
		return dataCacheEntry.getSandsDiscountAmount5();
	}
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount5
	 */
	public void setSandsDiscountAmount5(double newSandsDiscountAmount5) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(115,getSandsDiscountAmount5(),newSandsDiscountAmount5);
		else
			instanceExtension.markDirty(115);
		dataCacheEntry.setSandsDiscountAmount5(newSandsDiscountAmount5);
	}
	/**
	 * Get accessor for persistent attribute: cpsId
	 */
	public java.lang.String getCpsId() {
		return dataCacheEntry.getCpsId();
	}
	/**
	 * Set accessor for persistent attribute: cpsId
	 */
	public void setCpsId(java.lang.String newCpsId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(116,getCpsId(),newCpsId);
		else
			instanceExtension.markDirty(116);
		dataCacheEntry.setCpsId(newCpsId);
	}
	/**
	 * Get accessor for persistent attribute: ocpsID
	 */
	public java.lang.String getOcpsID() {
		return dataCacheEntry.getOcpsID();
	}
	/**
	 * Set accessor for persistent attribute: ocpsID
	 */
	public void setOcpsID(java.lang.String newOcpsID) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(117,getOcpsID(),newOcpsID);
		else
			instanceExtension.markDirty(117);
		dataCacheEntry.setOcpsID(newOcpsID);
	}
	/**
	 * Get accessor for persistent attribute: contractType
	 */
	public java.lang.String getContractType() {
		return dataCacheEntry.getContractType();
	}
	/**
	 * Set accessor for persistent attribute: contractType
	 */
	public void setContractType(java.lang.String newContractType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(118,getContractType(),newContractType);
		else
			instanceExtension.markDirty(118);
		dataCacheEntry.setContractType(newContractType);
	}
	/**
	 * Get accessor for persistent attribute: blbIndicator
	 */
	public java.lang.String getBlbIndicator() {
		return dataCacheEntry.getBlbIndicator();
	}
	/**
	 * Set accessor for persistent attribute: blbIndicator
	 */
	public void setBlbIndicator(java.lang.String newBlbIndicator) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(119,getBlbIndicator(),newBlbIndicator);
		else
			instanceExtension.markDirty(119);
		dataCacheEntry.setBlbIndicator(newBlbIndicator);
	}
	/**
	 * Get accessor for persistent attribute: prebillIndicator
	 */
	public java.lang.String getPrebillIndicator() {
		return dataCacheEntry.getPrebillIndicator();
	}
	/**
	 * Set accessor for persistent attribute: prebillIndicator
	 */
	public void setPrebillIndicator(java.lang.String newPrebillIndicator) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(120,getPrebillIndicator(),newPrebillIndicator);
		else
			instanceExtension.markDirty(120);
		dataCacheEntry.setPrebillIndicator(newPrebillIndicator);
	}
	/**
	 * Get accessor for persistent attribute: cciInd
	 */
	public java.lang.String getCciInd() {
		return dataCacheEntry.getCciInd();
	}
	/**
	 * Set accessor for persistent attribute: cciInd
	 */
	public void setCciInd(java.lang.String newCciInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(121,getCciInd(),newCciInd);
		else
			instanceExtension.markDirty(121);
		dataCacheEntry.setCciInd(newCciInd);
	}
	/**
	 * Get accessor for persistent attribute: autoPopulateInd
	 */
	public java.lang.String getAutoPopulateInd() {
		return dataCacheEntry.getAutoPopulateInd();
	}
	/**
	 * Set accessor for persistent attribute: autoPopulateInd
	 */
	public void setAutoPopulateInd(java.lang.String newAutoPopulateInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(122,getAutoPopulateInd(),newAutoPopulateInd);
		else
			instanceExtension.markDirty(122);
		dataCacheEntry.setAutoPopulateInd(newAutoPopulateInd);
	}
	/**
	 * Get accessor for persistent attribute: salesGroup
	 */
	public java.lang.String getSalesGroup() {
		return dataCacheEntry.getSalesGroup();
	}
	/**
	 * Set accessor for persistent attribute: salesGroup
	 */
	public void setSalesGroup(java.lang.String newSalesGroup) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(123,getSalesGroup(),newSalesGroup);
		else
			instanceExtension.markDirty(123);
		dataCacheEntry.setSalesGroup(newSalesGroup);
	}
	/**
	 * Get accessor for persistent attribute: channelRole
	 */
	public java.lang.String getChannelRole() {
		return dataCacheEntry.getChannelRole();
	}
	/**
	 * Set accessor for persistent attribute: channelRole
	 */
	public void setChannelRole(java.lang.String newChannelRole) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(124,getChannelRole(),newChannelRole);
		else
			instanceExtension.markDirty(124);
		dataCacheEntry.setChannelRole(newChannelRole);
	}
	/**
	 * Get accessor for persistent attribute: submitterRole
	 */
	public java.lang.String getSubmitterRole() {
		return dataCacheEntry.getSubmitterRole();
	}
	/**
	 * Set accessor for persistent attribute: submitterRole
	 */
	public void setSubmitterRole(java.lang.String newSubmitterRole) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(125,getSubmitterRole(),newSubmitterRole);
		else
			instanceExtension.markDirty(125);
		dataCacheEntry.setSubmitterRole(newSubmitterRole);
	}
	/**
	 * Get accessor for persistent attribute: paymentMethod
	 */
	public java.lang.String getPaymentMethod() {
		return dataCacheEntry.getPaymentMethod();
	}
	/**
	 * Set accessor for persistent attribute: paymentMethod
	 */
	public void setPaymentMethod(java.lang.String newPaymentMethod) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(126,getPaymentMethod(),newPaymentMethod);
		else
			instanceExtension.markDirty(126);
		dataCacheEntry.setPaymentMethod(newPaymentMethod);
	}
	/**
	 * Get accessor for persistent attribute: discount
	 */
	public double getDiscount() {
		return dataCacheEntry.getDiscount();
	}
	/**
	 * Set accessor for persistent attribute: discount
	 */
	public void setDiscount(double newDiscount) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(127,getDiscount(),newDiscount);
		else
			instanceExtension.markDirty(127);
		dataCacheEntry.setDiscount(newDiscount);
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.SWOBeanCacheEntry_05de4b81;

/**
 * Bean implementation class for Enterprise Bean: SWO
 */
public class ConcreteSWO_05de4b81 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private SWOBeanCacheEntry_05de4b81 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteSWO_05de4b81
	 */
	public ConcreteSWO_05de4b81() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.SWOBeanInjector_05de4b81 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.SWOBeanInjector_05de4b81)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.SWOBeanCacheEntry_05de4b81) inRecord;
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
	 * ejbFindByEquimentAndSalesDocNo_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey ejbFindByEquimentAndSalesDocNo_Local(java.lang.String equipmentNo, java.lang.String salesDocNo, int proposalID) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByEquimentAndSalesDocNo");
		getInjector().ejbFindByEquimentAndSalesDocNo(equipmentNo, salesDocNo, proposalID, record);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey) instanceExtension.executeFind("FindByEquimentAndSalesDocNo", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindMaxSquenceNo_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey ejbFindMaxSquenceNo_Local(java.lang.String salesDocNo, java.lang.String swoItemNo, int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindMaxSquenceNo");
		getInjector().ejbFindMaxSquenceNo(salesDocNo, swoItemNo, proposalId, record);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey) instanceExtension.executeFind("FindMaxSquenceNo", record);
	}
	/**
	 * ejbFindByCustomer_Local
	 */
	public java.util.Collection ejbFindByCustomer_Local(int proposalId, int customerId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByCustomer");
		getInjector().ejbFindByCustomer(proposalId, customerId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByCustomer", record);
	}
	/**
	 * ejbFindByDM_Local
	 */
	public java.util.Collection ejbFindByDM_Local(int dmId, int customerId, int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByDM");
		getInjector().ejbFindByDM(dmId, customerId, proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByDM", record);
	}
	/**
	 * ejbFindByEquipSoldToPartyDM_Local
	 */
	public java.util.Collection ejbFindByEquipSoldToPartyDM_Local(java.lang.String equipmentNo, int proposalId, int customerId, int dmId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByEquipSoldToPartyDM");
		getInjector().ejbFindByEquipSoldToPartyDM(equipmentNo, proposalId, customerId, dmId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByEquipSoldToPartyDM", record);
	}
	/**
	 * ejbFindByEquipmentNo_Local
	 */
	public java.util.Collection ejbFindByEquipmentNo_Local(java.lang.String equipmentNo, int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByEquipmentNo");
		getInjector().ejbFindByEquipmentNo(equipmentNo, proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByEquipmentNo", record);
	}
	/**
	 * ejbFindByExtContrNumber_Local
	 */
	public java.util.Collection ejbFindByExtContrNumber_Local(int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByExtContrNumber");
		getInjector().ejbFindByExtContrNumber(proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByExtContrNumber", record);
	}
	/**
	 * ejbFindByProposal_Local
	 */
	public java.util.Collection ejbFindByProposal_Local(int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByProposal");
		getInjector().ejbFindByProposal(proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByProposal", record);
	}
	/**
	 * ejbFindByQuotes_Local
	 */
	public java.util.Collection ejbFindByQuotes_Local(java.lang.String salesDocNo, int proposalId, java.lang.String swoItemNo) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByQuotes");
		getInjector().ejbFindByQuotes(salesDocNo, proposalId, swoItemNo, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByQuotes", record);
	}
	/**
	 * ejbFindByQuotesSoldToPartyDM_Local
	 */
	public java.util.Collection ejbFindByQuotesSoldToPartyDM_Local(java.lang.String salesDocNo, int proposalId, java.lang.String swoItemNo, int customerId, int dmId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByQuotesSoldToPartyDM");
		getInjector().ejbFindByQuotesSoldToPartyDM(salesDocNo, proposalId, swoItemNo, customerId, dmId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByQuotesSoldToPartyDM", record);
	}
	/**
	 * ejbFindBySWONoSalesDocSwoItemNo_Local
	 */
	public java.util.Collection ejbFindBySWONoSalesDocSwoItemNo_Local(int proposalId, java.lang.String swoNo, java.lang.String salesDocNo, java.lang.String swoItemNo) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindBySWONoSalesDocSwoItemNo");
		getInjector().ejbFindBySWONoSalesDocSwoItemNo(proposalId, swoNo, salesDocNo, swoItemNo, record);
		return (java.util.Collection) instanceExtension.executeFind("FindBySWONoSalesDocSwoItemNo", record);
	}
	/**
	 * ejbFindBySalesDocNo_Local
	 */
	public java.util.Collection ejbFindBySalesDocNo_Local(java.lang.String salesDocNo, int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindBySalesDocNo");
		getInjector().ejbFindBySalesDocNo(salesDocNo, proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindBySalesDocNo", record);
	}
	/**
	 * ejbFindBySandSIndicator_Local
	 */
	public java.util.Collection ejbFindBySandSIndicator_Local(int proposalId, java.lang.String indicator) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindBySandSIndicator");
		getInjector().ejbFindBySandSIndicator(proposalId, indicator, record);
		return (java.util.Collection) instanceExtension.executeFind("FindBySandSIndicator", record);
	}
	/**
	 * ejbFindBySwoNoSerialNo_Local
	 */
	public java.util.Collection ejbFindBySwoNoSerialNo_Local(int proposalId, java.lang.String swoNo, java.lang.String serialNo) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindBySwoNoSerialNo");
		getInjector().ejbFindBySwoNoSerialNo(proposalId, swoNo, serialNo, record);
		return (java.util.Collection) instanceExtension.executeFind("FindBySwoNoSerialNo", record);
	}
	/**
	 * ejbFindExcludedLicenses_Local
	 */
	public java.util.Collection ejbFindExcludedLicenses_Local(int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindExcludedLicenses");
		getInjector().ejbFindExcludedLicenses(proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindExcludedLicenses", record);
	}
	/**
	 * ejbFindMaxBumpInd_Local
	 */
	public java.util.Collection ejbFindMaxBumpInd_Local(java.lang.String salesDocNo, java.lang.String swoItemNo, int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindMaxBumpInd");
		getInjector().ejbFindMaxBumpInd(salesDocNo, swoItemNo, proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindMaxBumpInd", record);
	}
	/**
	 * ejbFindMaxSWOId_Local
	 */
	public java.util.Collection ejbFindMaxSWOId_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindMaxSWOId", null);
	}
	/**
	 * ejbFindSVCLicenseForProposal_Local
	 */
	public java.util.Collection ejbFindSVCLicenseForProposal_Local(int proposalId, java.lang.String itemCategory) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindSVCLicenseForProposal");
		getInjector().ejbFindSVCLicenseForProposal(proposalId, itemCategory, record);
		return (java.util.Collection) instanceExtension.executeFind("FindSVCLicenseForProposal", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey ejbCreate(int swoId, int dmId, int customerId, int proposalId, java.lang.String swoNo) throws javax.ejb.CreateException {
		dataCacheEntry = (SWOBeanCacheEntry_05de4b81) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(swoId, dmId, customerId, proposalId, swoNo);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int swoId, int dmId, int customerId, int proposalId, java.lang.String swoNo) throws javax.ejb.CreateException {
		super.ejbPostCreate(swoId, dmId, customerId, proposalId, swoNo);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey();
		pk.swoId = getSwoId();
		pk.dmId = getDmId();
		pk.customerId = getCustomerId();
		pk.proposalId = getProposalId();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 42;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: swoId
	 */
	public int getSwoId() {
		return dataCacheEntry.getSwoId();
	}
	/**
	 * Set accessor for persistent attribute: swoId
	 */
	public void setSwoId(int newSwoId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getSwoId(),newSwoId);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setSwoId(newSwoId);
	}
	/**
	 * Get accessor for persistent attribute: dmId
	 */
	public int getDmId() {
		return dataCacheEntry.getDmId();
	}
	/**
	 * Set accessor for persistent attribute: dmId
	 */
	public void setDmId(int newDmId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getDmId(),newDmId);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setDmId(newDmId);
	}
	/**
	 * Get accessor for persistent attribute: customerId
	 */
	public int getCustomerId() {
		return dataCacheEntry.getCustomerId();
	}
	/**
	 * Set accessor for persistent attribute: customerId
	 */
	public void setCustomerId(int newCustomerId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getCustomerId(),newCustomerId);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setCustomerId(newCustomerId);
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
			instanceExtension.markDirty(3,getProposalId(),newProposalId);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setProposalId(newProposalId);
	}
	/**
	 * Get accessor for persistent attribute: lockedInd
	 */
	public java.lang.String getLockedInd() {
		return dataCacheEntry.getLockedInd();
	}
	/**
	 * Set accessor for persistent attribute: lockedInd
	 */
	public void setLockedInd(java.lang.String newLockedInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getLockedInd(),newLockedInd);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setLockedInd(newLockedInd);
	}
	/**
	 * Get accessor for persistent attribute: deltaFetchId
	 */
	public java.lang.String getDeltaFetchId() {
		return dataCacheEntry.getDeltaFetchId();
	}
	/**
	 * Set accessor for persistent attribute: deltaFetchId
	 */
	public void setDeltaFetchId(java.lang.String newDeltaFetchId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getDeltaFetchId(),newDeltaFetchId);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setDeltaFetchId(newDeltaFetchId);
	}
	/**
	 * Get accessor for persistent attribute: adjustmentAmount
	 */
	public double getAdjustmentAmount() {
		return dataCacheEntry.getAdjustmentAmount();
	}
	/**
	 * Set accessor for persistent attribute: adjustmentAmount
	 */
	public void setAdjustmentAmount(double newAdjustmentAmount) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getAdjustmentAmount(),newAdjustmentAmount);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setAdjustmentAmount(newAdjustmentAmount);
	}
	/**
	 * Get accessor for persistent attribute: planDateInd
	 */
	public java.lang.String getPlanDateInd() {
		return dataCacheEntry.getPlanDateInd();
	}
	/**
	 * Set accessor for persistent attribute: planDateInd
	 */
	public void setPlanDateInd(java.lang.String newPlanDateInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getPlanDateInd(),newPlanDateInd);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setPlanDateInd(newPlanDateInd);
	}
	/**
	 * Get accessor for persistent attribute: swoContrType
	 */
	public java.lang.String getSwoContrType() {
		return dataCacheEntry.getSwoContrType();
	}
	/**
	 * Set accessor for persistent attribute: swoContrType
	 */
	public void setSwoContrType(java.lang.String newSwoContrType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getSwoContrType(),newSwoContrType);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setSwoContrType(newSwoContrType);
	}
	/**
	 * Get accessor for persistent attribute: alternatePriceUpdateInd
	 */
	public java.lang.String getAlternatePriceUpdateInd() {
		return dataCacheEntry.getAlternatePriceUpdateInd();
	}
	/**
	 * Set accessor for persistent attribute: alternatePriceUpdateInd
	 */
	public void setAlternatePriceUpdateInd(java.lang.String newAlternatePriceUpdateInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getAlternatePriceUpdateInd(),newAlternatePriceUpdateInd);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setAlternatePriceUpdateInd(newAlternatePriceUpdateInd);
	}
	/**
	 * Get accessor for persistent attribute: swoContrStatus
	 */
	public java.lang.String getSwoContrStatus() {
		return dataCacheEntry.getSwoContrStatus();
	}
	/**
	 * Set accessor for persistent attribute: swoContrStatus
	 */
	public void setSwoContrStatus(java.lang.String newSwoContrStatus) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getSwoContrStatus(),newSwoContrStatus);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setSwoContrStatus(newSwoContrStatus);
	}
	/**
	 * Get accessor for persistent attribute: swoExtContrNo
	 */
	public java.lang.String getSwoExtContrNo() {
		return dataCacheEntry.getSwoExtContrNo();
	}
	/**
	 * Set accessor for persistent attribute: swoExtContrNo
	 */
	public void setSwoExtContrNo(java.lang.String newSwoExtContrNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getSwoExtContrNo(),newSwoExtContrNo);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setSwoExtContrNo(newSwoExtContrNo);
	}
	/**
	 * Get accessor for persistent attribute: amendEndDate
	 */
	public java.sql.Date getAmendEndDate() {
		return dataCacheEntry.getAmendEndDate();
	}
	/**
	 * Set accessor for persistent attribute: amendEndDate
	 */
	public void setAmendEndDate(java.sql.Date newAmendEndDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getAmendEndDate(),newAmendEndDate);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setAmendEndDate(newAmendEndDate);
	}
	/**
	 * Get accessor for persistent attribute: refetchId
	 */
	public java.lang.String getRefetchId() {
		return dataCacheEntry.getRefetchId();
	}
	/**
	 * Set accessor for persistent attribute: refetchId
	 */
	public void setRefetchId(java.lang.String newRefetchId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(13,getRefetchId(),newRefetchId);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setRefetchId(newRefetchId);
	}
	/**
	 * Get accessor for persistent attribute: swoAddedDate
	 */
	public java.sql.Date getSwoAddedDate() {
		return dataCacheEntry.getSwoAddedDate();
	}
	/**
	 * Set accessor for persistent attribute: swoAddedDate
	 */
	public void setSwoAddedDate(java.sql.Date newSwoAddedDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(14,getSwoAddedDate(),newSwoAddedDate);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setSwoAddedDate(newSwoAddedDate);
	}
	/**
	 * Get accessor for persistent attribute: bumpInd
	 */
	public java.lang.String getBumpInd() {
		return dataCacheEntry.getBumpInd();
	}
	/**
	 * Set accessor for persistent attribute: bumpInd
	 */
	public void setBumpInd(java.lang.String newBumpInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(15,getBumpInd(),newBumpInd);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setBumpInd(newBumpInd);
	}
	/**
	 * Get accessor for persistent attribute: amendStartDate
	 */
	public java.sql.Date getAmendStartDate() {
		return dataCacheEntry.getAmendStartDate();
	}
	/**
	 * Set accessor for persistent attribute: amendStartDate
	 */
	public void setAmendStartDate(java.sql.Date newAmendStartDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(16,getAmendStartDate(),newAmendStartDate);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setAmendStartDate(newAmendStartDate);
	}
	/**
	 * Get accessor for persistent attribute: amendInd
	 */
	public java.lang.String getAmendInd() {
		return dataCacheEntry.getAmendInd();
	}
	/**
	 * Set accessor for persistent attribute: amendInd
	 */
	public void setAmendInd(java.lang.String newAmendInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(17,getAmendInd(),newAmendInd);
		else
			instanceExtension.markDirty(17);
		dataCacheEntry.setAmendInd(newAmendInd);
	}
	/**
	 * Get accessor for persistent attribute: exclusionId
	 */
	public java.lang.String getExclusionId() {
		return dataCacheEntry.getExclusionId();
	}
	/**
	 * Set accessor for persistent attribute: exclusionId
	 */
	public void setExclusionId(java.lang.String newExclusionId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(18,getExclusionId(),newExclusionId);
		else
			instanceExtension.markDirty(18);
		dataCacheEntry.setExclusionId(newExclusionId);
	}
	/**
	 * Get accessor for persistent attribute: swoNo
	 */
	public java.lang.String getSwoNo() {
		return dataCacheEntry.getSwoNo();
	}
	/**
	 * Set accessor for persistent attribute: swoNo
	 */
	public void setSwoNo(java.lang.String newSwoNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(19,getSwoNo(),newSwoNo);
		else
			instanceExtension.markDirty(19);
		dataCacheEntry.setSwoNo(newSwoNo);
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
			instanceExtension.markDirty(20,getLastUpdatedDate(),newLastUpdatedDate);
		else
			instanceExtension.markDirty(20);
		dataCacheEntry.setLastUpdatedDate(newLastUpdatedDate);
	}
	/**
	 * Get accessor for persistent attribute: oldCalcPrice
	 */
	public double getOldCalcPrice() {
		return dataCacheEntry.getOldCalcPrice();
	}
	/**
	 * Set accessor for persistent attribute: oldCalcPrice
	 */
	public void setOldCalcPrice(double newOldCalcPrice) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(21,getOldCalcPrice(),newOldCalcPrice);
		else
			instanceExtension.markDirty(21);
		dataCacheEntry.setOldCalcPrice(newOldCalcPrice);
	}
	/**
	 * Get accessor for persistent attribute: eswPrice
	 */
	public double getEswPrice() {
		return dataCacheEntry.getEswPrice();
	}
	/**
	 * Set accessor for persistent attribute: eswPrice
	 */
	public void setEswPrice(double newEswPrice) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(22,getEswPrice(),newEswPrice);
		else
			instanceExtension.markDirty(22);
		dataCacheEntry.setEswPrice(newEswPrice);
	}
	/**
	 * Get accessor for persistent attribute: plannedInd
	 */
	public java.lang.String getPlannedInd() {
		return dataCacheEntry.getPlannedInd();
	}
	/**
	 * Set accessor for persistent attribute: plannedInd
	 */
	public void setPlannedInd(java.lang.String newPlannedInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(23,getPlannedInd(),newPlannedInd);
		else
			instanceExtension.markDirty(23);
		dataCacheEntry.setPlannedInd(newPlannedInd);
	}
	/**
	 * Get accessor for persistent attribute: alternatePriceInd
	 */
	public java.lang.String getAlternatePriceInd() {
		return dataCacheEntry.getAlternatePriceInd();
	}
	/**
	 * Set accessor for persistent attribute: alternatePriceInd
	 */
	public void setAlternatePriceInd(java.lang.String newAlternatePriceInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(24,getAlternatePriceInd(),newAlternatePriceInd);
		else
			instanceExtension.markDirty(24);
		dataCacheEntry.setAlternatePriceInd(newAlternatePriceInd);
	}
	/**
	 * Get accessor for persistent attribute: referenceSerialNo
	 */
	public java.lang.String getReferenceSerialNo() {
		return dataCacheEntry.getReferenceSerialNo();
	}
	/**
	 * Set accessor for persistent attribute: referenceSerialNo
	 */
	public void setReferenceSerialNo(java.lang.String newReferenceSerialNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(25,getReferenceSerialNo(),newReferenceSerialNo);
		else
			instanceExtension.markDirty(25);
		dataCacheEntry.setReferenceSerialNo(newReferenceSerialNo);
	}
	/**
	 * Get accessor for persistent attribute: referenceSerialNoDM
	 */
	public java.lang.String getReferenceSerialNoDM() {
		return dataCacheEntry.getReferenceSerialNoDM();
	}
	/**
	 * Set accessor for persistent attribute: referenceSerialNoDM
	 */
	public void setReferenceSerialNoDM(java.lang.String newReferenceSerialNoDM) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(26,getReferenceSerialNoDM(),newReferenceSerialNoDM);
		else
			instanceExtension.markDirty(26);
		dataCacheEntry.setReferenceSerialNoDM(newReferenceSerialNoDM);
	}
	/**
	 * Get accessor for persistent attribute: alternatePrice
	 */
	public double getAlternatePrice() {
		return dataCacheEntry.getAlternatePrice();
	}
	/**
	 * Set accessor for persistent attribute: alternatePrice
	 */
	public void setAlternatePrice(double newAlternatePrice) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(27,getAlternatePrice(),newAlternatePrice);
		else
			instanceExtension.markDirty(27);
		dataCacheEntry.setAlternatePrice(newAlternatePrice);
	}
	/**
	 * Get accessor for persistent attribute: calcPrice
	 */
	public double getCalcPrice() {
		return dataCacheEntry.getCalcPrice();
	}
	/**
	 * Set accessor for persistent attribute: calcPrice
	 */
	public void setCalcPrice(double newCalcPrice) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(28,getCalcPrice(),newCalcPrice);
		else
			instanceExtension.markDirty(28);
		dataCacheEntry.setCalcPrice(newCalcPrice);
	}
	/**
	 * Get accessor for persistent attribute: swoDesc
	 */
	public java.lang.String getSwoDesc() {
		return dataCacheEntry.getSwoDesc();
	}
	/**
	 * Set accessor for persistent attribute: swoDesc
	 */
	public void setSwoDesc(java.lang.String newSwoDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(29,getSwoDesc(),newSwoDesc);
		else
			instanceExtension.markDirty(29);
		dataCacheEntry.setSwoDesc(newSwoDesc);
	}
	/**
	 * Get accessor for persistent attribute: salesDocNo
	 */
	public java.lang.String getSalesDocNo() {
		return dataCacheEntry.getSalesDocNo();
	}
	/**
	 * Set accessor for persistent attribute: salesDocNo
	 */
	public void setSalesDocNo(java.lang.String newSalesDocNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(30,getSalesDocNo(),newSalesDocNo);
		else
			instanceExtension.markDirty(30);
		dataCacheEntry.setSalesDocNo(newSalesDocNo);
	}
	/**
	 * Get accessor for persistent attribute: swoItemNo
	 */
	public java.lang.String getSwoItemNo() {
		return dataCacheEntry.getSwoItemNo();
	}
	/**
	 * Set accessor for persistent attribute: swoItemNo
	 */
	public void setSwoItemNo(java.lang.String newSwoItemNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(31,getSwoItemNo(),newSwoItemNo);
		else
			instanceExtension.markDirty(31);
		dataCacheEntry.setSwoItemNo(newSwoItemNo);
	}
	/**
	 * Get accessor for persistent attribute: equipmentNo
	 */
	public java.lang.String getEquipmentNo() {
		return dataCacheEntry.getEquipmentNo();
	}
	/**
	 * Set accessor for persistent attribute: equipmentNo
	 */
	public void setEquipmentNo(java.lang.String newEquipmentNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(32,getEquipmentNo(),newEquipmentNo);
		else
			instanceExtension.markDirty(32);
		dataCacheEntry.setEquipmentNo(newEquipmentNo);
	}
	/**
	 * Get accessor for persistent attribute: sequenceNo
	 */
	public int getSequenceNo() {
		return dataCacheEntry.getSequenceNo();
	}
	/**
	 * Set accessor for persistent attribute: sequenceNo
	 */
	public void setSequenceNo(int newSequenceNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(33,getSequenceNo(),newSequenceNo);
		else
			instanceExtension.markDirty(33);
		dataCacheEntry.setSequenceNo(newSequenceNo);
	}
	/**
	 * Get accessor for persistent attribute: itemCategory
	 */
	public java.lang.String getItemCategory() {
		return dataCacheEntry.getItemCategory();
	}
	/**
	 * Set accessor for persistent attribute: itemCategory
	 */
	public void setItemCategory(java.lang.String newItemCategory) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(34,getItemCategory(),newItemCategory);
		else
			instanceExtension.markDirty(34);
		dataCacheEntry.setItemCategory(newItemCategory);
	}
	/**
	 * Get accessor for persistent attribute: planStartDate
	 */
	public java.sql.Date getPlanStartDate() {
		return dataCacheEntry.getPlanStartDate();
	}
	/**
	 * Set accessor for persistent attribute: planStartDate
	 */
	public void setPlanStartDate(java.sql.Date newPlanStartDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(35,getPlanStartDate(),newPlanStartDate);
		else
			instanceExtension.markDirty(35);
		dataCacheEntry.setPlanStartDate(newPlanStartDate);
	}
	/**
	 * Get accessor for persistent attribute: customerPONo
	 */
	public java.lang.String getCustomerPONo() {
		return dataCacheEntry.getCustomerPONo();
	}
	/**
	 * Set accessor for persistent attribute: customerPONo
	 */
	public void setCustomerPONo(java.lang.String newCustomerPONo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(36,getCustomerPONo(),newCustomerPONo);
		else
			instanceExtension.markDirty(36);
		dataCacheEntry.setCustomerPONo(newCustomerPONo);
	}
	/**
	 * Get accessor for persistent attribute: planEndDate
	 */
	public java.sql.Date getPlanEndDate() {
		return dataCacheEntry.getPlanEndDate();
	}
	/**
	 * Set accessor for persistent attribute: planEndDate
	 */
	public void setPlanEndDate(java.sql.Date newPlanEndDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(37,getPlanEndDate(),newPlanEndDate);
		else
			instanceExtension.markDirty(37);
		dataCacheEntry.setPlanEndDate(newPlanEndDate);
	}
	/**
	 * Get accessor for persistent attribute: serialNo
	 */
	public java.lang.String getSerialNo() {
		return dataCacheEntry.getSerialNo();
	}
	/**
	 * Set accessor for persistent attribute: serialNo
	 */
	public void setSerialNo(java.lang.String newSerialNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(38,getSerialNo(),newSerialNo);
		else
			instanceExtension.markDirty(38);
		dataCacheEntry.setSerialNo(newSerialNo);
	}
	/**
	 * Get accessor for persistent attribute: requestDeliveryDate
	 */
	public java.sql.Date getRequestDeliveryDate() {
		return dataCacheEntry.getRequestDeliveryDate();
	}
	/**
	 * Set accessor for persistent attribute: requestDeliveryDate
	 */
	public void setRequestDeliveryDate(java.sql.Date newRequestDeliveryDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(39,getRequestDeliveryDate(),newRequestDeliveryDate);
		else
			instanceExtension.markDirty(39);
		dataCacheEntry.setRequestDeliveryDate(newRequestDeliveryDate);
	}
	/**
	 * Get accessor for persistent attribute: sandsIndicator
	 */
	public java.lang.String getSandsIndicator() {
		return dataCacheEntry.getSandsIndicator();
	}
	/**
	 * Set accessor for persistent attribute: sandsIndicator
	 */
	public void setSandsIndicator(java.lang.String newSandsIndicator) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(40,getSandsIndicator(),newSandsIndicator);
		else
			instanceExtension.markDirty(40);
		dataCacheEntry.setSandsIndicator(newSandsIndicator);
	}
	/**
	 * Get accessor for persistent attribute: duplicateDeletedInd
	 */
	public java.lang.String getDuplicateDeletedInd() {
		return dataCacheEntry.getDuplicateDeletedInd();
	}
	/**
	 * Set accessor for persistent attribute: duplicateDeletedInd
	 */
	public void setDuplicateDeletedInd(java.lang.String newDuplicateDeletedInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(41,getDuplicateDeletedInd(),newDuplicateDeletedInd);
		else
			instanceExtension.markDirty(41);
		dataCacheEntry.setDuplicateDeletedInd(newDuplicateDeletedInd);
	}
}

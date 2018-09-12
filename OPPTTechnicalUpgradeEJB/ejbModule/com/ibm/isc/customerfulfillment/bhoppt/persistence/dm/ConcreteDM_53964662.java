package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DMBeanCacheEntry_53964662;

/**
 * Bean implementation class for Enterprise Bean: DM
 */
public class ConcreteDM_53964662 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private DMBeanCacheEntry_53964662 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteDM_53964662
	 */
	public ConcreteDM_53964662() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DMBeanInjector_53964662 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DMBeanInjector_53964662)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DMBeanCacheEntry_53964662) inRecord;
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
	 * ejbFindByPrimaryKey
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByCustomer_Local
	 */
	public java.util.Collection ejbFindByCustomer_Local(int customerId, int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByCustomer");
		getInjector().ejbFindByCustomer(customerId, proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByCustomer", record);
	}
	/**
	 * ejbFindByDMNo_Local
	 */
	public java.util.Collection ejbFindByDMNo_Local(java.lang.String dmNo, int proposalId, int customerId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByDMNo");
		getInjector().ejbFindByDMNo(dmNo, proposalId, customerId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByDMNo", record);
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
	 * ejbFindMaxDMId_Local
	 */
	public java.util.Collection ejbFindMaxDMId_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindMaxDMId", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey ejbCreate(int dmId, int customerId, int proposalId, java.lang.String dmNo) throws javax.ejb.CreateException {
		dataCacheEntry = (DMBeanCacheEntry_53964662) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(dmId, customerId, proposalId, dmNo);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int dmId, int customerId, int proposalId, java.lang.String dmNo) throws javax.ejb.CreateException {
		super.ejbPostCreate(dmId, customerId, proposalId, dmNo);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey();
		pk.dmId = getDmId();
		pk.customerId = getCustomerId();
		pk.proposalId = getProposalId();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 12;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
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
			instanceExtension.markDirty(0,getDmId(),newDmId);
		else
			instanceExtension.markDirty(0);
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
			instanceExtension.markDirty(1,getCustomerId(),newCustomerId);
		else
			instanceExtension.markDirty(1);
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
			instanceExtension.markDirty(2,getProposalId(),newProposalId);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setProposalId(newProposalId);
	}
	/**
	 * Get accessor for persistent attribute: dmDesc
	 */
	public java.lang.String getDmDesc() {
		return dataCacheEntry.getDmDesc();
	}
	/**
	 * Set accessor for persistent attribute: dmDesc
	 */
	public void setDmDesc(java.lang.String newDmDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getDmDesc(),newDmDesc);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setDmDesc(newDmDesc);
	}
	/**
	 * Get accessor for persistent attribute: dmNo
	 */
	public java.lang.String getDmNo() {
		return dataCacheEntry.getDmNo();
	}
	/**
	 * Set accessor for persistent attribute: dmNo
	 */
	public void setDmNo(java.lang.String newDmNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getDmNo(),newDmNo);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setDmNo(newDmNo);
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
			instanceExtension.markDirty(5,getPlanStartDate(),newPlanStartDate);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setPlanStartDate(newPlanStartDate);
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
			instanceExtension.markDirty(6,getPlanEndDate(),newPlanEndDate);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setPlanEndDate(newPlanEndDate);
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
			instanceExtension.markDirty(7,getPlannedInd(),newPlannedInd);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setPlannedInd(newPlannedInd);
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
			instanceExtension.markDirty(8,getLastUpdatedDate(),newLastUpdatedDate);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setLastUpdatedDate(newLastUpdatedDate);
	}
	/**
	 * Get accessor for persistent attribute: dmAddedDate
	 */
	public java.sql.Date getDmAddedDate() {
		return dataCacheEntry.getDmAddedDate();
	}
	/**
	 * Set accessor for persistent attribute: dmAddedDate
	 */
	public void setDmAddedDate(java.sql.Date newDmAddedDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getDmAddedDate(),newDmAddedDate);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setDmAddedDate(newDmAddedDate);
	}
	/**
	 * Get accessor for persistent attribute: exclusionID
	 */
	public java.lang.String getExclusionID() {
		return dataCacheEntry.getExclusionID();
	}
	/**
	 * Set accessor for persistent attribute: exclusionID
	 */
	public void setExclusionID(java.lang.String newExclusionID) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getExclusionID(),newExclusionID);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setExclusionID(newExclusionID);
	}
	/**
	 * Get accessor for persistent attribute: dmCopyIncrNo
	 */
	public double getDmCopyIncrNo() {
		return dataCacheEntry.getDmCopyIncrNo();
	}
	/**
	 * Set accessor for persistent attribute: dmCopyIncrNo
	 */
	public void setDmCopyIncrNo(double newDmCopyIncrNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getDmCopyIncrNo(),newDmCopyIncrNo);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setDmCopyIncrNo(newDmCopyIncrNo);
	}
}

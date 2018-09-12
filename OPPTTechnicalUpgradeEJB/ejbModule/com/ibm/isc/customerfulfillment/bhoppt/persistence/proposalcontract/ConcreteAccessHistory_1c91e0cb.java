package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.AccessHistoryBeanCacheEntry_1c91e0cb;

/**
 * Bean implementation class for Enterprise Bean: AccessHistory
 */
public class ConcreteAccessHistory_1c91e0cb extends com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private AccessHistoryBeanCacheEntry_1c91e0cb dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteAccessHistory_1c91e0cb
	 */
	public ConcreteAccessHistory_1c91e0cb() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.AccessHistoryBeanInjector_1c91e0cb getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.AccessHistoryBeanInjector_1c91e0cb)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.AccessHistoryBeanCacheEntry_1c91e0cb) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByProposalID_Local
	 */
	public java.util.Collection ejbFindByProposalID_Local(int proposalID) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByProposalID");
		getInjector().ejbFindByProposalID(proposalID, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByProposalID", record);
	}
	/**
	 * ejbFindByProposalIDAndUserID_Local
	 */
	public java.util.Collection ejbFindByProposalIDAndUserID_Local(int proposalId, java.lang.String userId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByProposalIDAndUserID");
		getInjector().ejbFindByProposalIDAndUserID(proposalId, userId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByProposalIDAndUserID", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey ejbCreate(int proposalId, java.lang.String userId, java.sql.Date accessDate, java.sql.Time accessTime, int sequenceNo) throws javax.ejb.CreateException {
		dataCacheEntry = (AccessHistoryBeanCacheEntry_1c91e0cb) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(proposalId, userId, accessDate, accessTime, sequenceNo);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int proposalId, java.lang.String userId, java.sql.Date accessDate, java.sql.Time accessTime, int sequenceNo) throws javax.ejb.CreateException {
		super.ejbPostCreate(proposalId, userId, accessDate, accessTime, sequenceNo);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey();
		pk.proposalId = getProposalId();
		pk.userId = getUserId();
		pk.accessDate = getAccessDate();
		pk.accessTime = getAccessTime();
		pk.seqNo = getSeqNo();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 6;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
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
			instanceExtension.markDirty(0,getProposalId(),newProposalId);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setProposalId(newProposalId);
	}
	/**
	 * Get accessor for persistent attribute: userId
	 */
	public java.lang.String getUserId() {
		return dataCacheEntry.getUserId();
	}
	/**
	 * Set accessor for persistent attribute: userId
	 */
	public void setUserId(java.lang.String newUserId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getUserId(),newUserId);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setUserId(newUserId);
	}
	/**
	 * Get accessor for persistent attribute: operationPerformed
	 */
	public java.lang.String getOperationPerformed() {
		return dataCacheEntry.getOperationPerformed();
	}
	/**
	 * Set accessor for persistent attribute: operationPerformed
	 */
	public void setOperationPerformed(java.lang.String newOperationPerformed) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getOperationPerformed(),newOperationPerformed);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setOperationPerformed(newOperationPerformed);
	}
	/**
	 * Get accessor for persistent attribute: accessDate
	 */
	public java.sql.Date getAccessDate() {
		return dataCacheEntry.getAccessDate();
	}
	/**
	 * Set accessor for persistent attribute: accessDate
	 */
	public void setAccessDate(java.sql.Date newAccessDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getAccessDate(),newAccessDate);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setAccessDate(newAccessDate);
	}
	/**
	 * Get accessor for persistent attribute: accessTime
	 */
	public java.sql.Time getAccessTime() {
		return dataCacheEntry.getAccessTime();
	}
	/**
	 * Set accessor for persistent attribute: accessTime
	 */
	public void setAccessTime(java.sql.Time newAccessTime) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getAccessTime(),newAccessTime);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setAccessTime(newAccessTime);
	}
	/**
	 * Get accessor for persistent attribute: seqNo
	 */
	public int getSeqNo() {
		return dataCacheEntry.getSeqNo();
	}
	/**
	 * Set accessor for persistent attribute: seqNo
	 */
	public void setSeqNo(int newSeqNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getSeqNo(),newSeqNo);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setSeqNo(newSeqNo);
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementChangeLogBeanCacheEntry_508109ee;

/**
 * Bean implementation class for Enterprise Bean: BaseAgreementChangeLog
 */
public class ConcreteBaseAgreementChangeLog_508109ee extends com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BaseAgreementChangeLogBeanCacheEntry_508109ee dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBaseAgreementChangeLog_508109ee
	 */
	public ConcreteBaseAgreementChangeLog_508109ee() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementChangeLogBeanInjector_508109ee getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementChangeLogBeanInjector_508109ee)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementChangeLogBeanCacheEntry_508109ee) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindMaxChangeId_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey ejbFindMaxChangeId_Local() throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey) instanceExtension.executeFind("FindMaxChangeId", null);
	}
	/**
	 * ejbFindByAgreementId_Local
	 */
	public java.util.Collection ejbFindByAgreementId_Local(java.lang.Integer agreementId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByAgreementId");
		getInjector().ejbFindByAgreementId(agreementId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByAgreementId", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey ejbCreate(java.lang.Integer changeId, java.lang.Integer agreementId) throws javax.ejb.CreateException {
		dataCacheEntry = (BaseAgreementChangeLogBeanCacheEntry_508109ee) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(changeId, agreementId);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer changeId, java.lang.Integer agreementId) throws javax.ejb.CreateException {
		super.ejbPostCreate(changeId, agreementId);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey();
		pk.changeId = getChangeId();
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
	 * Get accessor for persistent attribute: changeId
	 */
	public java.lang.Integer getChangeId() {
		return dataCacheEntry.getChangeId();
	}
	/**
	 * Set accessor for persistent attribute: changeId
	 */
	public void setChangeId(java.lang.Integer newChangeId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getChangeId(),newChangeId);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setChangeId(newChangeId);
	}
	/**
	 * Get accessor for persistent attribute: agreementId
	 */
	public java.lang.Integer getAgreementId() {
		return dataCacheEntry.getAgreementId();
	}
	/**
	 * Set accessor for persistent attribute: agreementId
	 */
	public void setAgreementId(java.lang.Integer newAgreementId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getAgreementId(),newAgreementId);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setAgreementId(newAgreementId);
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
			instanceExtension.markDirty(2,getCreatedBy(),newCreatedBy);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setCreatedBy(newCreatedBy);
	}
	/**
	 * Get accessor for persistent attribute: changedDate
	 */
	public java.sql.Date getChangedDate() {
		return dataCacheEntry.getChangedDate();
	}
	/**
	 * Set accessor for persistent attribute: changedDate
	 */
	public void setChangedDate(java.sql.Date newChangedDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getChangedDate(),newChangedDate);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setChangedDate(newChangedDate);
	}
	/**
	 * Get accessor for persistent attribute: changedTime
	 */
	public java.sql.Time getChangedTime() {
		return dataCacheEntry.getChangedTime();
	}
	/**
	 * Set accessor for persistent attribute: changedTime
	 */
	public void setChangedTime(java.sql.Time newChangedTime) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getChangedTime(),newChangedTime);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setChangedTime(newChangedTime);
	}
	/**
	 * Get accessor for persistent attribute: changedDetails
	 */
	public java.lang.String getChangedDetails() {
		return dataCacheEntry.getChangedDetails();
	}
	/**
	 * Set accessor for persistent attribute: changedDetails
	 */
	public void setChangedDetails(java.lang.String newChangedDetails) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getChangedDetails(),newChangedDetails);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setChangedDetails(newChangedDetails);
	}
}

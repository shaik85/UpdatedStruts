package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ErrorListBeanCacheEntry_889e0b9b;

/**
 * Bean implementation class for Enterprise Bean: ErrorList
 */
public class ConcreteErrorList_889e0b9b extends com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private ErrorListBeanCacheEntry_889e0b9b dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteErrorList_889e0b9b
	 */
	public ConcreteErrorList_889e0b9b() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ErrorListBeanInjector_889e0b9b getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ErrorListBeanInjector_889e0b9b)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ErrorListBeanCacheEntry_889e0b9b) inRecord;
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
	public java.lang.Integer ejbFindByPrimaryKey(java.lang.Integer primaryKey) throws javax.ejb.FinderException {
		return (java.lang.Integer)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindMax_Local
	 */
	public java.lang.Integer ejbFindMax_Local() throws javax.ejb.FinderException {
		return (java.lang.Integer) instanceExtension.executeFind("FindMax", null);
	}
	/**
	 * ejbFindByProposalId_Local
	 */
	public java.util.Collection ejbFindByProposalId_Local(int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByProposalId");
		getInjector().ejbFindByProposalId(proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByProposalId", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((java.lang.Integer)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public java.lang.Integer ejbFindByPrimaryKeyForCMR_Local(java.lang.Integer pk) throws javax.ejb.FinderException {
		return (java.lang.Integer)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public java.lang.Integer ejbCreate(java.lang.Integer messageId, int proposalId) throws javax.ejb.CreateException {
		dataCacheEntry = (ErrorListBeanCacheEntry_889e0b9b) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(messageId, proposalId);
		return (java.lang.Integer)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer messageId, int proposalId) throws javax.ejb.CreateException {
		super.ejbPostCreate(messageId, proposalId);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getMessageId();
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 10;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: messageId
	 */
	public java.lang.Integer getMessageId() {
		return dataCacheEntry.getMessageId();
	}
	/**
	 * Set accessor for persistent attribute: messageId
	 */
	public void setMessageId(java.lang.Integer newMessageId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getMessageId(),newMessageId);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setMessageId(newMessageId);
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
			instanceExtension.markDirty(1,getProposalId(),newProposalId);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setProposalId(newProposalId);
	}
	/**
	 * Get accessor for persistent attribute: messageNO
	 */
	public double getMessageNO() {
		return dataCacheEntry.getMessageNO();
	}
	/**
	 * Set accessor for persistent attribute: messageNO
	 */
	public void setMessageNO(double newMessageNO) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getMessageNO(),newMessageNO);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setMessageNO(newMessageNO);
	}
	/**
	 * Get accessor for persistent attribute: className
	 */
	public java.lang.String getClassName() {
		return dataCacheEntry.getClassName();
	}
	/**
	 * Set accessor for persistent attribute: className
	 */
	public void setClassName(java.lang.String newClassName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getClassName(),newClassName);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setClassName(newClassName);
	}
	/**
	 * Get accessor for persistent attribute: methodName
	 */
	public java.lang.String getMethodName() {
		return dataCacheEntry.getMethodName();
	}
	/**
	 * Set accessor for persistent attribute: methodName
	 */
	public void setMethodName(java.lang.String newMethodName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getMethodName(),newMethodName);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setMethodName(newMethodName);
	}
	/**
	 * Get accessor for persistent attribute: messageDesc
	 */
	public java.lang.String getMessageDesc() {
		return dataCacheEntry.getMessageDesc();
	}
	/**
	 * Set accessor for persistent attribute: messageDesc
	 */
	public void setMessageDesc(java.lang.String newMessageDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getMessageDesc(),newMessageDesc);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setMessageDesc(newMessageDesc);
	}
	/**
	 * Get accessor for persistent attribute: messageDetail
	 */
	public java.lang.String getMessageDetail() {
		return dataCacheEntry.getMessageDetail();
	}
	/**
	 * Set accessor for persistent attribute: messageDetail
	 */
	public void setMessageDetail(java.lang.String newMessageDetail) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getMessageDetail(),newMessageDetail);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setMessageDetail(newMessageDetail);
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
			instanceExtension.markDirty(7,getUserId(),newUserId);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setUserId(newUserId);
	}
	/**
	 * Get accessor for persistent attribute: date
	 */
	public java.sql.Date getDate() {
		return dataCacheEntry.getDate();
	}
	/**
	 * Set accessor for persistent attribute: date
	 */
	public void setDate(java.sql.Date newDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getDate(),newDate);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setDate(newDate);
	}
	/**
	 * Get accessor for persistent attribute: time
	 */
	public java.sql.Time getTime() {
		return dataCacheEntry.getTime();
	}
	/**
	 * Set accessor for persistent attribute: time
	 */
	public void setTime(java.sql.Time newTime) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getTime(),newTime);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setTime(newTime);
	}
}

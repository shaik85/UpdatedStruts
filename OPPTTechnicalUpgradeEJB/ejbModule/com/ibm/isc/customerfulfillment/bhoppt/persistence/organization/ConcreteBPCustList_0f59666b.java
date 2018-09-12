package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BPCustListBeanCacheEntry_0f59666b;

/**
 * Bean implementation class for Enterprise Bean: BPCustList
 */
public class ConcreteBPCustList_0f59666b extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BPCustListBeanCacheEntry_0f59666b dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBPCustList_0f59666b
	 */
	public ConcreteBPCustList_0f59666b() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BPCustListBeanInjector_0f59666b getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BPCustListBeanInjector_0f59666b)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BPCustListBeanCacheEntry_0f59666b) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
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
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey ejbCreate(java.lang.String userId, java.lang.String custListNo) throws javax.ejb.CreateException {
		dataCacheEntry = (BPCustListBeanCacheEntry_0f59666b) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(userId, custListNo);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String userId, java.lang.String custListNo) throws javax.ejb.CreateException {
		super.ejbPostCreate(userId, custListNo);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey();
		pk.userId = getUserId();
		pk.custListNo = getCustListNo();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 3;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
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
			instanceExtension.markDirty(0,getUserId(),newUserId);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setUserId(newUserId);
	}
	/**
	 * Get accessor for persistent attribute: custListNo
	 */
	public java.lang.String getCustListNo() {
		return dataCacheEntry.getCustListNo();
	}
	/**
	 * Set accessor for persistent attribute: custListNo
	 */
	public void setCustListNo(java.lang.String newCustListNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getCustListNo(),newCustListNo);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setCustListNo(newCustListNo);
	}
	/**
	 * Get accessor for persistent attribute: custListName
	 */
	public java.lang.String getCustListName() {
		return dataCacheEntry.getCustListName();
	}
	/**
	 * Set accessor for persistent attribute: custListName
	 */
	public void setCustListName(java.lang.String newCustListName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getCustListName(),newCustListName);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setCustListName(newCustListName);
	}
}

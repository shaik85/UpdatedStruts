package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BPLegacyNoBeanCacheEntry_f2446ac8;

/**
 * Bean implementation class for Enterprise Bean: BPLegacyNo
 */
public class ConcreteBPLegacyNo_f2446ac8 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BPLegacyNoBeanCacheEntry_f2446ac8 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBPLegacyNo_f2446ac8
	 */
	public ConcreteBPLegacyNo_f2446ac8() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BPLegacyNoBeanInjector_f2446ac8 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BPLegacyNoBeanInjector_f2446ac8)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BPLegacyNoBeanCacheEntry_f2446ac8) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
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
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey ejbCreate(java.lang.String userId, java.lang.String legacyNo, java.lang.String addressSeqNo) throws javax.ejb.CreateException {
		dataCacheEntry = (BPLegacyNoBeanCacheEntry_f2446ac8) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(userId, legacyNo, addressSeqNo);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String userId, java.lang.String legacyNo, java.lang.String addressSeqNo) throws javax.ejb.CreateException {
		super.ejbPostCreate(userId, legacyNo, addressSeqNo);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey();
		pk.userId = getUserId();
		pk.legacyNo = getLegacyNo();
		pk.addressSeqNo = getAddressSeqNo();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 4;
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
	 * Get accessor for persistent attribute: legacyNo
	 */
	public java.lang.String getLegacyNo() {
		return dataCacheEntry.getLegacyNo();
	}
	/**
	 * Set accessor for persistent attribute: legacyNo
	 */
	public void setLegacyNo(java.lang.String newLegacyNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getLegacyNo(),newLegacyNo);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setLegacyNo(newLegacyNo);
	}
	/**
	 * Get accessor for persistent attribute: addressSeqNo
	 */
	public java.lang.String getAddressSeqNo() {
		return dataCacheEntry.getAddressSeqNo();
	}
	/**
	 * Set accessor for persistent attribute: addressSeqNo
	 */
	public void setAddressSeqNo(java.lang.String newAddressSeqNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getAddressSeqNo(),newAddressSeqNo);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setAddressSeqNo(newAddressSeqNo);
	}
	/**
	 * Get accessor for persistent attribute: customerName
	 */
	public java.lang.String getCustomerName() {
		return dataCacheEntry.getCustomerName();
	}
	/**
	 * Set accessor for persistent attribute: customerName
	 */
	public void setCustomerName(java.lang.String newCustomerName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getCustomerName(),newCustomerName);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setCustomerName(newCustomerName);
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingTypeBeanCacheEntry_9d28f63a;

/**
 * Bean implementation class for Enterprise Bean: BillingType
 */
public class ConcreteBillingType_9d28f63a extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingTypeBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BillingTypeBeanCacheEntry_9d28f63a dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBillingType_9d28f63a
	 */
	public ConcreteBillingType_9d28f63a() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingTypeBeanInjector_9d28f63a getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingTypeBeanInjector_9d28f63a)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingTypeBeanCacheEntry_9d28f63a) inRecord;
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
	public java.lang.String ejbFindByPrimaryKey(java.lang.String primaryKey) throws javax.ejb.FinderException {
		return (java.lang.String)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllBillingType_Local
	 */
	public java.util.Collection ejbFindAllBillingType_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllBillingType", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((java.lang.String)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public java.lang.String ejbFindByPrimaryKeyForCMR_Local(java.lang.String pk) throws javax.ejb.FinderException {
		return (java.lang.String)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public java.lang.String ejbCreate(java.lang.String billingType) throws javax.ejb.CreateException {
		dataCacheEntry = (BillingTypeBeanCacheEntry_9d28f63a) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(billingType);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String billingType) throws javax.ejb.CreateException {
		super.ejbPostCreate(billingType);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getBillingType();
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 2;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
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
			instanceExtension.markDirty(0,getBillingType(),newBillingType);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setBillingType(newBillingType);
	}
	/**
	 * Get accessor for persistent attribute: billingDesc
	 */
	public java.lang.String getBillingDesc() {
		return dataCacheEntry.getBillingDesc();
	}
	/**
	 * Set accessor for persistent attribute: billingDesc
	 */
	public void setBillingDesc(java.lang.String newBillingDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getBillingDesc(),newBillingDesc);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setBillingDesc(newBillingDesc);
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingBlockBeanCacheEntry_fa467edc;

/**
 * Bean implementation class for Enterprise Bean: BillingBlock
 */
public class ConcreteBillingBlock_fa467edc extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BillingBlockBeanCacheEntry_fa467edc dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBillingBlock_fa467edc
	 */
	public ConcreteBillingBlock_fa467edc() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingBlockBeanInjector_fa467edc getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingBlockBeanInjector_fa467edc)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingBlockBeanCacheEntry_fa467edc) inRecord;
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
	 * ejbFindAllBillingBlock_Local
	 */
	public java.util.Collection ejbFindAllBillingBlock_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllBillingBlock", null);
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
	public java.lang.String ejbCreate(java.lang.String billingBlock) throws javax.ejb.CreateException {
		dataCacheEntry = (BillingBlockBeanCacheEntry_fa467edc) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(billingBlock);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String billingBlock) throws javax.ejb.CreateException {
		super.ejbPostCreate(billingBlock);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getBillingBlock();
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
			instanceExtension.markDirty(0,getBillingBlock(),newBillingBlock);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setBillingBlock(newBillingBlock);
	}
	/**
	 * Get accessor for persistent attribute: billingBlockDescription
	 */
	public java.lang.String getBillingBlockDescription() {
		return dataCacheEntry.getBillingBlockDescription();
	}
	/**
	 * Set accessor for persistent attribute: billingBlockDescription
	 */
	public void setBillingBlockDescription(java.lang.String newBillingBlockDescription) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getBillingBlockDescription(),newBillingBlockDescription);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setBillingBlockDescription(newBillingBlockDescription);
	}
}

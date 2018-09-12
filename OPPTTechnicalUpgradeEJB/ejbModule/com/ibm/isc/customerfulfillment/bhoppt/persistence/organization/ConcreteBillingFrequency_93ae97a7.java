package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingFrequencyBeanCacheEntry_93ae97a7;

/**
 * Bean implementation class for Enterprise Bean: BillingFrequency
 */
public class ConcreteBillingFrequency_93ae97a7 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BillingFrequencyBeanCacheEntry_93ae97a7 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBillingFrequency_93ae97a7
	 */
	public ConcreteBillingFrequency_93ae97a7() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingFrequencyBeanInjector_93ae97a7 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingFrequencyBeanInjector_93ae97a7)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingFrequencyBeanCacheEntry_93ae97a7) inRecord;
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
	 * ejbFindAllBillingFreq_Local
	 */
	public java.util.Collection ejbFindAllBillingFreq_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllBillingFreq", null);
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
	public java.lang.String ejbCreate(java.lang.String billingFreqCode) throws javax.ejb.CreateException {
		dataCacheEntry = (BillingFrequencyBeanCacheEntry_93ae97a7) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(billingFreqCode);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String billingFreqCode) throws javax.ejb.CreateException {
		super.ejbPostCreate(billingFreqCode);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getBillingFreqCode();
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
			instanceExtension.markDirty(0,getBillingFreqCode(),newBillingFreqCode);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setBillingFreqCode(newBillingFreqCode);
	}
	/**
	 * Get accessor for persistent attribute: billingFreqDescription
	 */
	public java.lang.String getBillingFreqDescription() {
		return dataCacheEntry.getBillingFreqDescription();
	}
	/**
	 * Set accessor for persistent attribute: billingFreqDescription
	 */
	public void setBillingFreqDescription(java.lang.String newBillingFreqDescription) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getBillingFreqDescription(),newBillingFreqDescription);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setBillingFreqDescription(newBillingFreqDescription);
	}
}

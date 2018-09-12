package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.PaymentTermBeanCacheEntry_d86e7748;

/**
 * Bean implementation class for Enterprise Bean: PaymentTerm
 */
public class ConcretePaymentTerm_d86e7748 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private PaymentTermBeanCacheEntry_d86e7748 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcretePaymentTerm_d86e7748
	 */
	public ConcretePaymentTerm_d86e7748() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.PaymentTermBeanInjector_d86e7748 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.PaymentTermBeanInjector_d86e7748)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.PaymentTermBeanCacheEntry_d86e7748) inRecord;
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
	 * ejbFindAllPaymentTerm_Local
	 */
	public java.util.Collection ejbFindAllPaymentTerm_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllPaymentTerm", null);
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
	public java.lang.String ejbCreate(java.lang.String paymentTerm) throws javax.ejb.CreateException {
		dataCacheEntry = (PaymentTermBeanCacheEntry_d86e7748) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(paymentTerm);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String paymentTerm) throws javax.ejb.CreateException {
		super.ejbPostCreate(paymentTerm);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getPaymentTerm();
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
	 * Get accessor for persistent attribute: paymentTerm
	 */
	public java.lang.String getPaymentTerm() {
		return dataCacheEntry.getPaymentTerm();
	}
	/**
	 * Set accessor for persistent attribute: paymentTerm
	 */
	public void setPaymentTerm(java.lang.String newPaymentTerm) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getPaymentTerm(),newPaymentTerm);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setPaymentTerm(newPaymentTerm);
	}
	/**
	 * Get accessor for persistent attribute: paymentTermDesc
	 */
	public java.lang.String getPaymentTermDesc() {
		return dataCacheEntry.getPaymentTermDesc();
	}
	/**
	 * Set accessor for persistent attribute: paymentTermDesc
	 */
	public void setPaymentTermDesc(java.lang.String newPaymentTermDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getPaymentTermDesc(),newPaymentTermDesc);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setPaymentTermDesc(newPaymentTermDesc);
	}
}

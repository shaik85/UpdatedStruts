package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.PaymentMethodBeanCacheEntry_11426d9d;

/**
 * Bean implementation class for Enterprise Bean: PaymentMethod
 */
public class ConcretePaymentMethod_11426d9d extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentMethodBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private PaymentMethodBeanCacheEntry_11426d9d dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcretePaymentMethod_11426d9d
	 */
	public ConcretePaymentMethod_11426d9d() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.PaymentMethodBeanInjector_11426d9d getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.PaymentMethodBeanInjector_11426d9d)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.PaymentMethodBeanCacheEntry_11426d9d) inRecord;
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
	 * ejbFindAllPaymentMethod_Local
	 */
	public java.util.Collection ejbFindAllPaymentMethod_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllPaymentMethod", null);
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
	public java.lang.String ejbCreate(java.lang.String id) throws javax.ejb.CreateException {
		dataCacheEntry = (PaymentMethodBeanCacheEntry_11426d9d) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(id);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String id) throws javax.ejb.CreateException {
		super.ejbPostCreate(id);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getId();
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
	 * Get accessor for persistent attribute: id
	 */
	public java.lang.String getId() {
		return dataCacheEntry.getId();
	}
	/**
	 * Set accessor for persistent attribute: id
	 */
	public void setId(java.lang.String newId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getId(),newId);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setId(newId);
	}
	/**
	 * Get accessor for persistent attribute: description
	 */
	public java.lang.String getDescription() {
		return dataCacheEntry.getDescription();
	}
	/**
	 * Set accessor for persistent attribute: description
	 */
	public void setDescription(java.lang.String newDescription) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getDescription(),newDescription);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setDescription(newDescription);
	}
	/**
	 * Get accessor for persistent attribute: status
	 */
	public java.lang.String getStatus() {
		return dataCacheEntry.getStatus();
	}
	/**
	 * Set accessor for persistent attribute: status
	 */
	public void setStatus(java.lang.String newStatus) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getStatus(),newStatus);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setStatus(newStatus);
	}
}

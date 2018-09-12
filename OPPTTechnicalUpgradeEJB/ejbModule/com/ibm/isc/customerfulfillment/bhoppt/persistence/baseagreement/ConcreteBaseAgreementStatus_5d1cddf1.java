package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementStatusBeanCacheEntry_5d1cddf1;

/**
 * Bean implementation class for Enterprise Bean: BaseAgreementStatus
 */
public class ConcreteBaseAgreementStatus_5d1cddf1 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BaseAgreementStatusBeanCacheEntry_5d1cddf1 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBaseAgreementStatus_5d1cddf1
	 */
	public ConcreteBaseAgreementStatus_5d1cddf1() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementStatusBeanInjector_5d1cddf1 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementStatusBeanInjector_5d1cddf1)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementStatusBeanCacheEntry_5d1cddf1) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey ejbCreate(java.lang.String statusCode) throws javax.ejb.CreateException {
		dataCacheEntry = (BaseAgreementStatusBeanCacheEntry_5d1cddf1) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(statusCode);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String statusCode) throws javax.ejb.CreateException {
		super.ejbPostCreate(statusCode);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey();
		pk.statusCode = getStatusCode();
		return pk;
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
	 * Get accessor for persistent attribute: statusCode
	 */
	public java.lang.String getStatusCode() {
		return dataCacheEntry.getStatusCode();
	}
	/**
	 * Set accessor for persistent attribute: statusCode
	 */
	public void setStatusCode(java.lang.String newStatusCode) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getStatusCode(),newStatusCode);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setStatusCode(newStatusCode);
	}
	/**
	 * Get accessor for persistent attribute: statusDescription
	 */
	public java.lang.String getStatusDescription() {
		return dataCacheEntry.getStatusDescription();
	}
	/**
	 * Set accessor for persistent attribute: statusDescription
	 */
	public void setStatusDescription(java.lang.String newStatusDescription) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getStatusDescription(),newStatusDescription);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setStatusDescription(newStatusDescription);
	}
}

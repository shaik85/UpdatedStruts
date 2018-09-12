package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.CurrencyBeanCacheEntry_679da69e;

/**
 * Bean implementation class for Enterprise Bean: Currency
 */
public class ConcreteCurrency_679da69e extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CurrencyBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private CurrencyBeanCacheEntry_679da69e dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteCurrency_679da69e
	 */
	public ConcreteCurrency_679da69e() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.CurrencyBeanInjector_679da69e getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.CurrencyBeanInjector_679da69e)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.CurrencyBeanCacheEntry_679da69e) inRecord;
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
	 * ejbFindAllCurrency_Local
	 */
	public java.util.Collection ejbFindAllCurrency_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllCurrency", null);
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
	public java.lang.String ejbCreate(java.lang.String currency) throws javax.ejb.CreateException {
		dataCacheEntry = (CurrencyBeanCacheEntry_679da69e) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(currency);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String currency) throws javax.ejb.CreateException {
		super.ejbPostCreate(currency);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getCurrency();
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
	 * Get accessor for persistent attribute: currency
	 */
	public java.lang.String getCurrency() {
		return dataCacheEntry.getCurrency();
	}
	/**
	 * Set accessor for persistent attribute: currency
	 */
	public void setCurrency(java.lang.String newCurrency) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCurrency(),newCurrency);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCurrency(newCurrency);
	}
	/**
	 * Get accessor for persistent attribute: currencyDesc
	 */
	public java.lang.String getCurrencyDesc() {
		return dataCacheEntry.getCurrencyDesc();
	}
	/**
	 * Set accessor for persistent attribute: currencyDesc
	 */
	public void setCurrencyDesc(java.lang.String newCurrencyDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getCurrencyDesc(),newCurrencyDesc);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setCurrencyDesc(newCurrencyDesc);
	}
	/**
	 * Get accessor for persistent attribute: decimalsAllowed
	 */
	public java.lang.Integer getDecimalsAllowed() {
		return dataCacheEntry.getDecimalsAllowed();
	}
	/**
	 * Set accessor for persistent attribute: decimalsAllowed
	 */
	public void setDecimalsAllowed(java.lang.Integer newDecimalsAllowed) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getDecimalsAllowed(),newDecimalsAllowed);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setDecimalsAllowed(newDecimalsAllowed);
	}
}

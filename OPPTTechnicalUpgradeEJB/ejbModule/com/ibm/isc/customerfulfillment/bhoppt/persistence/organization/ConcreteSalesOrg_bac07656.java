package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.SalesOrgBeanCacheEntry_bac07656;

/**
 * Bean implementation class for Enterprise Bean: SalesOrg
 */
public class ConcreteSalesOrg_bac07656 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private SalesOrgBeanCacheEntry_bac07656 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteSalesOrg_bac07656
	 */
	public ConcreteSalesOrg_bac07656() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.SalesOrgBeanInjector_bac07656 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.SalesOrgBeanInjector_bac07656)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.SalesOrgBeanCacheEntry_bac07656) inRecord;
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
	 * ejbFindAllSalesOrg_Local
	 */
	public java.util.Collection ejbFindAllSalesOrg_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllSalesOrg", null);
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
	public java.lang.String ejbCreate(java.lang.String salesOrg) throws javax.ejb.CreateException {
		dataCacheEntry = (SalesOrgBeanCacheEntry_bac07656) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(salesOrg);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String salesOrg) throws javax.ejb.CreateException {
		super.ejbPostCreate(salesOrg);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getSalesOrg();
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
	 * Get accessor for persistent attribute: salesOrg
	 */
	public java.lang.String getSalesOrg() {
		return dataCacheEntry.getSalesOrg();
	}
	/**
	 * Set accessor for persistent attribute: salesOrg
	 */
	public void setSalesOrg(java.lang.String newSalesOrg) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getSalesOrg(),newSalesOrg);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setSalesOrg(newSalesOrg);
	}
	/**
	 * Get accessor for persistent attribute: salesOrgDesc
	 */
	public java.lang.String getSalesOrgDesc() {
		return dataCacheEntry.getSalesOrgDesc();
	}
	/**
	 * Set accessor for persistent attribute: salesOrgDesc
	 */
	public void setSalesOrgDesc(java.lang.String newSalesOrgDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getSalesOrgDesc(),newSalesOrgDesc);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setSalesOrgDesc(newSalesOrgDesc);
	}
	/**
	 * Get accessor for persistent attribute: defaultCurrency
	 */
	public java.lang.String getDefaultCurrency() {
		return dataCacheEntry.getDefaultCurrency();
	}
	/**
	 * Set accessor for persistent attribute: defaultCurrency
	 */
	public void setDefaultCurrency(java.lang.String newDefaultCurrency) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getDefaultCurrency(),newDefaultCurrency);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setDefaultCurrency(newDefaultCurrency);
	}
}

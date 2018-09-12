package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.SalesAreaBeanCacheEntry_ac159cf0;

/**
 * Bean implementation class for Enterprise Bean: SalesArea
 */
public class ConcreteSalesArea_ac159cf0 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private SalesAreaBeanCacheEntry_ac159cf0 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteSalesArea_ac159cf0
	 */
	public ConcreteSalesArea_ac159cf0() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.SalesAreaBeanInjector_ac159cf0 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.SalesAreaBeanInjector_ac159cf0)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.SalesAreaBeanCacheEntry_ac159cf0) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey ejbCreate(java.lang.String salesOrg, java.lang.String divisionCode, java.lang.String distributionChannelCode) throws javax.ejb.CreateException {
		dataCacheEntry = (SalesAreaBeanCacheEntry_ac159cf0) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(salesOrg, divisionCode, distributionChannelCode);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String salesOrg, java.lang.String divisionCode, java.lang.String distributionChannelCode) throws javax.ejb.CreateException {
		super.ejbPostCreate(salesOrg, divisionCode, distributionChannelCode);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey();
		pk.salesOrg = getSalesOrg();
		pk.divisionCode = getDivisionCode();
		pk.distributionChannelCode = getDistributionChannelCode();
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
	 * Get accessor for persistent attribute: divisionCode
	 */
	public java.lang.String getDivisionCode() {
		return dataCacheEntry.getDivisionCode();
	}
	/**
	 * Set accessor for persistent attribute: divisionCode
	 */
	public void setDivisionCode(java.lang.String newDivisionCode) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getDivisionCode(),newDivisionCode);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setDivisionCode(newDivisionCode);
	}
	/**
	 * Get accessor for persistent attribute: distributionChannelCode
	 */
	public java.lang.String getDistributionChannelCode() {
		return dataCacheEntry.getDistributionChannelCode();
	}
	/**
	 * Set accessor for persistent attribute: distributionChannelCode
	 */
	public void setDistributionChannelCode(java.lang.String newDistributionChannelCode) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getDistributionChannelCode(),newDistributionChannelCode);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setDistributionChannelCode(newDistributionChannelCode);
	}
}

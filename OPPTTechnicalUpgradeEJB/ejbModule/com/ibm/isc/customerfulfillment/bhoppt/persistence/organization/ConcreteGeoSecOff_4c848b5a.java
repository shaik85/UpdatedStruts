package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.GeoSecOffBeanCacheEntry_4c848b5a;

/**
 * Bean implementation class for Enterprise Bean: GeoSecOff
 */
public class ConcreteGeoSecOff_4c848b5a extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private GeoSecOffBeanCacheEntry_4c848b5a dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteGeoSecOff_4c848b5a
	 */
	public ConcreteGeoSecOff_4c848b5a() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.GeoSecOffBeanInjector_4c848b5a getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.GeoSecOffBeanInjector_4c848b5a)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.GeoSecOffBeanCacheEntry_4c848b5a) inRecord;
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
	 * ejbFindBySalesOrg_Local
	 */
	public java.lang.String ejbFindBySalesOrg_Local(java.lang.String salesOrg) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindBySalesOrg");
		getInjector().ejbFindBySalesOrg(salesOrg, record);
		return (java.lang.String) instanceExtension.executeFind("FindBySalesOrg", record);
	}
	/**
	 * ejbFindAllGeoSecOfficer_Local
	 */
	public java.util.Collection ejbFindAllGeoSecOfficer_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllGeoSecOfficer", null);
	}
	/**
	 * ejbFindByGeoSec_Local
	 */
	public java.util.Collection ejbFindByGeoSec_Local(java.lang.String salesOrg) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByGeoSec");
		getInjector().ejbFindByGeoSec(salesOrg, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByGeoSec", record);
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
		dataCacheEntry = (GeoSecOffBeanCacheEntry_4c848b5a) instanceExtension.createDataCacheEntry();
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
		return 2;
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
	 * Get accessor for persistent attribute: geoSecOffSo
	 */
	public java.lang.String getGeoSecOffSo() {
		return dataCacheEntry.getGeoSecOffSo();
	}
	/**
	 * Set accessor for persistent attribute: geoSecOffSo
	 */
	public void setGeoSecOffSo(java.lang.String newGeoSecOffSo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getGeoSecOffSo(),newGeoSecOffSo);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setGeoSecOffSo(newGeoSecOffSo);
	}
}

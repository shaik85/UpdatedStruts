package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BLBIndicatorBeanCacheEntry_83ccad1d;

/**
 * Bean implementation class for Enterprise Bean: BLBIndicator
 */
public class ConcreteBLBIndicator_83ccad1d extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BLBIndicatorBeanCacheEntry_83ccad1d dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBLBIndicator_83ccad1d
	 */
	public ConcreteBLBIndicator_83ccad1d() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BLBIndicatorBeanInjector_83ccad1d getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BLBIndicatorBeanInjector_83ccad1d)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BLBIndicatorBeanCacheEntry_83ccad1d) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey key) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey)instanceExtension.ejbFindByPrimaryKey(key);
	}
	/**
	 * ejbFindAllBLBIndicator_Local
	 */
	public java.util.Collection ejbFindAllBLBIndicator_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllBLBIndicator", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey ejbCreate(java.lang.String blbType) throws javax.ejb.CreateException {
		dataCacheEntry = (BLBIndicatorBeanCacheEntry_83ccad1d) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(blbType);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String blbType) throws javax.ejb.CreateException {
		super.ejbPostCreate(blbType);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey();
		pk.blbType = getBlbType();
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
	 * Get accessor for persistent attribute: blbType
	 */
	public java.lang.String getBlbType() {
		return dataCacheEntry.getBlbType();
	}
	/**
	 * Set accessor for persistent attribute: blbType
	 */
	public void setBlbType(java.lang.String newBlbType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getBlbType(),newBlbType);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setBlbType(newBlbType);
	}
	/**
	 * Get accessor for persistent attribute: blbDesc
	 */
	public java.lang.String getBlbDesc() {
		return dataCacheEntry.getBlbDesc();
	}
	/**
	 * Set accessor for persistent attribute: blbDesc
	 */
	public void setBlbDesc(java.lang.String newBlbDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getBlbDesc(),newBlbDesc);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setBlbDesc(newBlbDesc);
	}
}

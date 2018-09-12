package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.MCTypeBeanCacheEntry_b8a50e19;

/**
 * Bean implementation class for Enterprise Bean: MCType
 */
public class ConcreteMCType_b8a50e19 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private MCTypeBeanCacheEntry_b8a50e19 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteMCType_b8a50e19
	 */
	public ConcreteMCType_b8a50e19() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.MCTypeBeanInjector_b8a50e19 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.MCTypeBeanInjector_b8a50e19)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.MCTypeBeanCacheEntry_b8a50e19) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey key) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey)instanceExtension.ejbFindByPrimaryKey(key);
	}
	/**
	 * ejbFindAllMCType_Local
	 */
	public java.util.Collection ejbFindAllMCType_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllMCType", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey ejbCreate(java.lang.String mcType) throws javax.ejb.CreateException {
		dataCacheEntry = (MCTypeBeanCacheEntry_b8a50e19) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(mcType);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String mcType) throws javax.ejb.CreateException {
		super.ejbPostCreate(mcType);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey();
		pk.mcType = getMcType();
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
	 * Get accessor for persistent attribute: mcType
	 */
	public java.lang.String getMcType() {
		return dataCacheEntry.getMcType();
	}
	/**
	 * Set accessor for persistent attribute: mcType
	 */
	public void setMcType(java.lang.String newMcType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getMcType(),newMcType);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setMcType(newMcType);
	}
	/**
	 * Get accessor for persistent attribute: mcDesc
	 */
	public java.lang.String getMcDesc() {
		return dataCacheEntry.getMcDesc();
	}
	/**
	 * Set accessor for persistent attribute: mcDesc
	 */
	public void setMcDesc(java.lang.String newMcDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getMcDesc(),newMcDesc);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setMcDesc(newMcDesc);
	}
}

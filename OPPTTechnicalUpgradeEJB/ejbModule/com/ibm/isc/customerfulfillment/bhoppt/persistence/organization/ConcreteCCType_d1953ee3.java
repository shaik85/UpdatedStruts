package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.CCTypeBeanCacheEntry_d1953ee3;

/**
 * Bean implementation class for Enterprise Bean: CCType
 */
public class ConcreteCCType_d1953ee3 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private CCTypeBeanCacheEntry_d1953ee3 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteCCType_d1953ee3
	 */
	public ConcreteCCType_d1953ee3() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.CCTypeBeanInjector_d1953ee3 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.CCTypeBeanInjector_d1953ee3)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.CCTypeBeanCacheEntry_d1953ee3) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey key) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey)instanceExtension.ejbFindByPrimaryKey(key);
	}
	/**
	 * ejbFindAllCCType_Local
	 */
	public java.util.Collection ejbFindAllCCType_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllCCType", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey ejbCreate(java.lang.String ccType) throws javax.ejb.CreateException {
		dataCacheEntry = (CCTypeBeanCacheEntry_d1953ee3) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(ccType);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String ccType) throws javax.ejb.CreateException {
		super.ejbPostCreate(ccType);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey();
		pk.ccType = getCcType();
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
	 * Get accessor for persistent attribute: ccType
	 */
	public java.lang.String getCcType() {
		return dataCacheEntry.getCcType();
	}
	/**
	 * Set accessor for persistent attribute: ccType
	 */
	public void setCcType(java.lang.String newCcType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCcType(),newCcType);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCcType(newCcType);
	}
	/**
	 * Get accessor for persistent attribute: ccDesc
	 */
	public java.lang.String getCcDesc() {
		return dataCacheEntry.getCcDesc();
	}
	/**
	 * Set accessor for persistent attribute: ccDesc
	 */
	public void setCcDesc(java.lang.String newCcDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getCcDesc(),newCcDesc);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setCcDesc(newCcDesc);
	}
}

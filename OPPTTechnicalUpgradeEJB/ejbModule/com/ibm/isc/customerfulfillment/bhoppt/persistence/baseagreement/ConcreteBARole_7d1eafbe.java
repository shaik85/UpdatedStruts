package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BARoleBeanCacheEntry_7d1eafbe;

/**
 * Bean implementation class for Enterprise Bean: BARole
 */
public class ConcreteBARole_7d1eafbe extends com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BARoleBeanCacheEntry_7d1eafbe dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBARole_7d1eafbe
	 */
	public ConcreteBARole_7d1eafbe() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BARoleBeanInjector_7d1eafbe getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BARoleBeanInjector_7d1eafbe)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BARoleBeanCacheEntry_7d1eafbe) inRecord;
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
	 * ejbFindAllBARoles_Local
	 */
	public java.util.Collection ejbFindAllBARoles_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllBARoles", null);
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
	public java.lang.String ejbCreate(java.lang.String baseAgreementRole) throws javax.ejb.CreateException {
		dataCacheEntry = (BARoleBeanCacheEntry_7d1eafbe) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(baseAgreementRole);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String baseAgreementRole) throws javax.ejb.CreateException {
		super.ejbPostCreate(baseAgreementRole);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getBaseAgreementRole();
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
	 * Get accessor for persistent attribute: baseAgreementRole
	 */
	public java.lang.String getBaseAgreementRole() {
		return dataCacheEntry.getBaseAgreementRole();
	}
	/**
	 * Set accessor for persistent attribute: baseAgreementRole
	 */
	public void setBaseAgreementRole(java.lang.String newBaseAgreementRole) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getBaseAgreementRole(),newBaseAgreementRole);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setBaseAgreementRole(newBaseAgreementRole);
	}
	/**
	 * Get accessor for persistent attribute: baseAgreementRoleDescription
	 */
	public java.lang.String getBaseAgreementRoleDescription() {
		return dataCacheEntry.getBaseAgreementRoleDescription();
	}
	/**
	 * Set accessor for persistent attribute: baseAgreementRoleDescription
	 */
	public void setBaseAgreementRoleDescription(java.lang.String newBaseAgreementRoleDescription) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getBaseAgreementRoleDescription(),newBaseAgreementRoleDescription);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setBaseAgreementRoleDescription(newBaseAgreementRoleDescription);
	}
}

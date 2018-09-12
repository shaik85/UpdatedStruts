package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.RoleBeanCacheEntry_5c00fd7a;

/**
 * Bean implementation class for Enterprise Bean: Role
 */
public class ConcreteRole_5c00fd7a extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.RoleBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private RoleBeanCacheEntry_5c00fd7a dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteRole_5c00fd7a
	 */
	public ConcreteRole_5c00fd7a() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.RoleBeanInjector_5c00fd7a getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.RoleBeanInjector_5c00fd7a)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.RoleBeanCacheEntry_5c00fd7a) inRecord;
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
	 * ejbFindAllRoles_Local
	 */
	public java.util.Collection ejbFindAllRoles_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllRoles", null);
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
	public java.lang.String ejbCreate(java.lang.String role) throws javax.ejb.CreateException {
		dataCacheEntry = (RoleBeanCacheEntry_5c00fd7a) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(role);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String role) throws javax.ejb.CreateException {
		super.ejbPostCreate(role);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getRole();
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
	 * Get accessor for persistent attribute: role
	 */
	public java.lang.String getRole() {
		return dataCacheEntry.getRole();
	}
	/**
	 * Set accessor for persistent attribute: role
	 */
	public void setRole(java.lang.String newRole) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getRole(),newRole);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setRole(newRole);
	}
	/**
	 * Get accessor for persistent attribute: roleDesc
	 */
	public java.lang.String getRoleDesc() {
		return dataCacheEntry.getRoleDesc();
	}
	/**
	 * Set accessor for persistent attribute: roleDesc
	 */
	public void setRoleDesc(java.lang.String newRoleDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getRoleDesc(),newRoleDesc);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setRoleDesc(newRoleDesc);
	}
	/**
	 * Get accessor for persistent attribute: active
	 */
	public java.lang.String getActive() {
		return dataCacheEntry.getActive();
	}
	/**
	 * Set accessor for persistent attribute: active
	 */
	public void setActive(java.lang.String newActive) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getActive(),newActive);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setActive(newActive);
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DivisionBeanCacheEntry_31212604;

/**
 * Bean implementation class for Enterprise Bean: Division
 */
public class ConcreteDivision_31212604 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DivisionBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private DivisionBeanCacheEntry_31212604 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteDivision_31212604
	 */
	public ConcreteDivision_31212604() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DivisionBeanInjector_31212604 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DivisionBeanInjector_31212604)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DivisionBeanCacheEntry_31212604) inRecord;
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
	 * ejbFindAllDivision_Local
	 */
	public java.util.Collection ejbFindAllDivision_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllDivision", null);
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
	public java.lang.String ejbCreate(java.lang.String division) throws javax.ejb.CreateException {
		dataCacheEntry = (DivisionBeanCacheEntry_31212604) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(division);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String division) throws javax.ejb.CreateException {
		super.ejbPostCreate(division);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getDivision();
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
	 * Get accessor for persistent attribute: division
	 */
	public java.lang.String getDivision() {
		return dataCacheEntry.getDivision();
	}
	/**
	 * Set accessor for persistent attribute: division
	 */
	public void setDivision(java.lang.String newDivision) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getDivision(),newDivision);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setDivision(newDivision);
	}
	/**
	 * Get accessor for persistent attribute: divisionDesc
	 */
	public java.lang.String getDivisionDesc() {
		return dataCacheEntry.getDivisionDesc();
	}
	/**
	 * Set accessor for persistent attribute: divisionDesc
	 */
	public void setDivisionDesc(java.lang.String newDivisionDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getDivisionDesc(),newDivisionDesc);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setDivisionDesc(newDivisionDesc);
	}
}

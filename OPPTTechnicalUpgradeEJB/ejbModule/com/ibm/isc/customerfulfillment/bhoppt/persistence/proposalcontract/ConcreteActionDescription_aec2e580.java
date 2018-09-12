package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ActionDescriptionBeanCacheEntry_aec2e580;

/**
 * Bean implementation class for Enterprise Bean: ActionDescription
 */
public class ConcreteActionDescription_aec2e580 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ActionDescriptionBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private ActionDescriptionBeanCacheEntry_aec2e580 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteActionDescription_aec2e580
	 */
	public ConcreteActionDescription_aec2e580() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ActionDescriptionBeanInjector_aec2e580 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ActionDescriptionBeanInjector_aec2e580)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ActionDescriptionBeanCacheEntry_aec2e580) inRecord;
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
	 * ejbFindAllActions_Local
	 */
	public java.util.Collection ejbFindAllActions_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllActions", null);
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
	public java.lang.String ejbCreate(java.lang.String actionDescription) throws javax.ejb.CreateException {
		dataCacheEntry = (ActionDescriptionBeanCacheEntry_aec2e580) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(actionDescription);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String actionDescription) throws javax.ejb.CreateException {
		super.ejbPostCreate(actionDescription);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getOperationPerformed();
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
	 * Get accessor for persistent attribute: description
	 */
	public java.lang.String getDescription() {
		return dataCacheEntry.getDescription();
	}
	/**
	 * Set accessor for persistent attribute: description
	 */
	public void setDescription(java.lang.String newDescription) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getDescription(),newDescription);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setDescription(newDescription);
	}
	/**
	 * Get accessor for persistent attribute: operationPerformed
	 */
	public java.lang.String getOperationPerformed() {
		return dataCacheEntry.getOperationPerformed();
	}
	/**
	 * Set accessor for persistent attribute: operationPerformed
	 */
	public void setOperationPerformed(java.lang.String newOperationPerformed) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getOperationPerformed(),newOperationPerformed);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setOperationPerformed(newOperationPerformed);
	}
}

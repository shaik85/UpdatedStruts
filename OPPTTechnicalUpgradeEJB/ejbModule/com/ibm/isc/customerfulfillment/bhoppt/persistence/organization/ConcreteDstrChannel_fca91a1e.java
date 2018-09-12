package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DstrChannelBeanCacheEntry_fca91a1e;

/**
 * Bean implementation class for Enterprise Bean: DstrChannel
 */
public class ConcreteDstrChannel_fca91a1e extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private DstrChannelBeanCacheEntry_fca91a1e dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteDstrChannel_fca91a1e
	 */
	public ConcreteDstrChannel_fca91a1e() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DstrChannelBeanInjector_fca91a1e getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DstrChannelBeanInjector_fca91a1e)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DstrChannelBeanCacheEntry_fca91a1e) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllDstrChannel_Local
	 */
	public java.util.Collection ejbFindAllDstrChannel_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllDstrChannel", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey ejbCreate(java.lang.String distributionChannel, java.lang.String salesGroup, java.lang.String channelRole, java.lang.String submitterRole) throws javax.ejb.CreateException {
		dataCacheEntry = (DstrChannelBeanCacheEntry_fca91a1e) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(distributionChannel, salesGroup, channelRole, submitterRole);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String distributionChannel, java.lang.String salesGroup, java.lang.String channelRole, java.lang.String submitterRole) throws javax.ejb.CreateException {
		super.ejbPostCreate(distributionChannel, salesGroup, channelRole, submitterRole);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey();
		pk.salesGroup = getSalesGroup();
		pk.channelRole = getChannelRole();
		pk.submitterRole = getSubmitterRole();
		pk.distributionChannel = getDistributionChannel();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 5;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: distributionChannel
	 */
	public java.lang.String getDistributionChannel() {
		return dataCacheEntry.getDistributionChannel();
	}
	/**
	 * Set accessor for persistent attribute: distributionChannel
	 */
	public void setDistributionChannel(java.lang.String newDistributionChannel) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getDistributionChannel(),newDistributionChannel);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setDistributionChannel(newDistributionChannel);
	}
	/**
	 * Get accessor for persistent attribute: distributionChannelDesc
	 */
	public java.lang.String getDistributionChannelDesc() {
		return dataCacheEntry.getDistributionChannelDesc();
	}
	/**
	 * Set accessor for persistent attribute: distributionChannelDesc
	 */
	public void setDistributionChannelDesc(java.lang.String newDistributionChannelDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getDistributionChannelDesc(),newDistributionChannelDesc);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setDistributionChannelDesc(newDistributionChannelDesc);
	}
	/**
	 * Get accessor for persistent attribute: salesGroup
	 */
	public java.lang.String getSalesGroup() {
		return dataCacheEntry.getSalesGroup();
	}
	/**
	 * Set accessor for persistent attribute: salesGroup
	 */
	public void setSalesGroup(java.lang.String newSalesGroup) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getSalesGroup(),newSalesGroup);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setSalesGroup(newSalesGroup);
	}
	/**
	 * Get accessor for persistent attribute: channelRole
	 */
	public java.lang.String getChannelRole() {
		return dataCacheEntry.getChannelRole();
	}
	/**
	 * Set accessor for persistent attribute: channelRole
	 */
	public void setChannelRole(java.lang.String newChannelRole) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getChannelRole(),newChannelRole);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setChannelRole(newChannelRole);
	}
	/**
	 * Get accessor for persistent attribute: submitterRole
	 */
	public java.lang.String getSubmitterRole() {
		return dataCacheEntry.getSubmitterRole();
	}
	/**
	 * Set accessor for persistent attribute: submitterRole
	 */
	public void setSubmitterRole(java.lang.String newSubmitterRole) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getSubmitterRole(),newSubmitterRole);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setSubmitterRole(newSubmitterRole);
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.SharingBeanCacheEntry_a437b4b5;

/**
 * Bean implementation class for Enterprise Bean: Sharing
 */
public class ConcreteSharing_a437b4b5 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private SharingBeanCacheEntry_a437b4b5 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteSharing_a437b4b5
	 */
	public ConcreteSharing_a437b4b5() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.SharingBeanInjector_a437b4b5 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.SharingBeanInjector_a437b4b5)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.SharingBeanCacheEntry_a437b4b5) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByProposalAndAccess_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey ejbFindByProposalAndAccess_Local(int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByProposalAndAccess");
		getInjector().ejbFindByProposalAndAccess(proposalId, record);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey) instanceExtension.executeFind("FindByProposalAndAccess", record);
	}
	/**
	 * ejbFindByProposalId_Local
	 */
	public java.util.Collection ejbFindByProposalId_Local(int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByProposalId");
		getInjector().ejbFindByProposalId(proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByProposalId", record);
	}
	/**
	 * ejbFindByUser_Local
	 */
	public java.util.Collection ejbFindByUser_Local(java.lang.String userId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByUser");
		getInjector().ejbFindByUser(userId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByUser", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey ejbCreate(int proposalId, java.lang.String accessTo) throws javax.ejb.CreateException {
		dataCacheEntry = (SharingBeanCacheEntry_a437b4b5) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(proposalId, accessTo);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int proposalId, java.lang.String accessTo) throws javax.ejb.CreateException {
		super.ejbPostCreate(proposalId, accessTo);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey();
		pk.proposalId = getProposalId();
		pk.accessTo = getAccessTo();
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
	 * Get accessor for persistent attribute: proposalId
	 */
	public int getProposalId() {
		return dataCacheEntry.getProposalId();
	}
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public void setProposalId(int newProposalId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getProposalId(),newProposalId);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setProposalId(newProposalId);
	}
	/**
	 * Get accessor for persistent attribute: accessTo
	 */
	public java.lang.String getAccessTo() {
		return dataCacheEntry.getAccessTo();
	}
	/**
	 * Set accessor for persistent attribute: accessTo
	 */
	public void setAccessTo(java.lang.String newAccessTo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getAccessTo(),newAccessTo);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setAccessTo(newAccessTo);
	}
	/**
	 * Get accessor for persistent attribute: accessType
	 */
	public java.lang.String getAccessType() {
		return dataCacheEntry.getAccessType();
	}
	/**
	 * Set accessor for persistent attribute: accessType
	 */
	public void setAccessType(java.lang.String newAccessType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getAccessType(),newAccessType);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setAccessType(newAccessType);
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.VarianceDMBeanCacheEntry_384e6a37;

/**
 * Bean implementation class for Enterprise Bean: VarianceDM
 */
public class ConcreteVarianceDM_384e6a37 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private VarianceDMBeanCacheEntry_384e6a37 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteVarianceDM_384e6a37
	 */
	public ConcreteVarianceDM_384e6a37() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.VarianceDMBeanInjector_384e6a37 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.VarianceDMBeanInjector_384e6a37)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.VarianceDMBeanCacheEntry_384e6a37) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByCustomer_Local
	 */
	public java.util.Collection ejbFindByCustomer_Local(int proposalId, int customerId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByCustomer");
		getInjector().ejbFindByCustomer(proposalId, customerId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByCustomer", record);
	}
	/**
	 * ejbFindByDMNo_Local
	 */
	public java.util.Collection ejbFindByDMNo_Local(java.lang.String dmNo, int proposalId, int customerId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByDMNo");
		getInjector().ejbFindByDMNo(dmNo, proposalId, customerId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByDMNo", record);
	}
	/**
	 * ejbFindByProposal_Local
	 */
	public java.util.Collection ejbFindByProposal_Local(int proposalID) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByProposal");
		getInjector().ejbFindByProposal(proposalID, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByProposal", record);
	}
	/**
	 * ejbFindMaxVarianceDMId_Local
	 */
	public java.util.Collection ejbFindMaxVarianceDMId_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindMaxVarianceDMId", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey ejbCreate(int dmId, int customerId, int proposalId, java.lang.String dmNo) throws javax.ejb.CreateException {
		dataCacheEntry = (VarianceDMBeanCacheEntry_384e6a37) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(dmId, customerId, proposalId, dmNo);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int dmId, int customerId, int proposalId, java.lang.String dmNo) throws javax.ejb.CreateException {
		super.ejbPostCreate(dmId, customerId, proposalId, dmNo);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey();
		pk.dmId = getDmId();
		pk.customerId = getCustomerId();
		pk.proposalId = getProposalId();
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
	 * Get accessor for persistent attribute: customerId
	 */
	public int getCustomerId() {
		return dataCacheEntry.getCustomerId();
	}
	/**
	 * Set accessor for persistent attribute: customerId
	 */
	public void setCustomerId(int newCustomerId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCustomerId(),newCustomerId);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCustomerId(newCustomerId);
	}
	/**
	 * Get accessor for persistent attribute: dmId
	 */
	public int getDmId() {
		return dataCacheEntry.getDmId();
	}
	/**
	 * Set accessor for persistent attribute: dmId
	 */
	public void setDmId(int newDmId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getDmId(),newDmId);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setDmId(newDmId);
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
			instanceExtension.markDirty(2,getProposalId(),newProposalId);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setProposalId(newProposalId);
	}
	/**
	 * Get accessor for persistent attribute: dmNo
	 */
	public java.lang.String getDmNo() {
		return dataCacheEntry.getDmNo();
	}
	/**
	 * Set accessor for persistent attribute: dmNo
	 */
	public void setDmNo(java.lang.String newDmNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getDmNo(),newDmNo);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setDmNo(newDmNo);
	}
	/**
	 * Get accessor for persistent attribute: dmDesc
	 */
	public java.lang.String getDmDesc() {
		return dataCacheEntry.getDmDesc();
	}
	/**
	 * Set accessor for persistent attribute: dmDesc
	 */
	public void setDmDesc(java.lang.String newDmDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getDmDesc(),newDmDesc);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setDmDesc(newDmDesc);
	}
}

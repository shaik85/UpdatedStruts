package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.CustomerListBeanCacheEntry_93c2f859;

/**
 * Bean implementation class for Enterprise Bean: CustomerList
 */
public class ConcreteCustomerList_93c2f859 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private CustomerListBeanCacheEntry_93c2f859 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteCustomerList_93c2f859
	 */
	public ConcreteCustomerList_93c2f859() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.CustomerListBeanInjector_93c2f859 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.CustomerListBeanInjector_93c2f859)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.CustomerListBeanCacheEntry_93c2f859) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
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
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey ejbCreate(int proposalId, java.lang.String customerListNo) throws javax.ejb.CreateException {
		dataCacheEntry = (CustomerListBeanCacheEntry_93c2f859) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(proposalId, customerListNo);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int proposalId, java.lang.String customerListNo) throws javax.ejb.CreateException {
		super.ejbPostCreate(proposalId, customerListNo);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey();
		pk.proposalId = getProposalId();
		pk.customerListNo = getCustomerListNo();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 4;
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
	 * Get accessor for persistent attribute: customerListNo
	 */
	public java.lang.String getCustomerListNo() {
		return dataCacheEntry.getCustomerListNo();
	}
	/**
	 * Set accessor for persistent attribute: customerListNo
	 */
	public void setCustomerListNo(java.lang.String newCustomerListNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getCustomerListNo(),newCustomerListNo);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setCustomerListNo(newCustomerListNo);
	}
	/**
	 * Get accessor for persistent attribute: customerListName
	 */
	public java.lang.String getCustomerListName() {
		return dataCacheEntry.getCustomerListName();
	}
	/**
	 * Set accessor for persistent attribute: customerListName
	 */
	public void setCustomerListName(java.lang.String newCustomerListName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getCustomerListName(),newCustomerListName);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setCustomerListName(newCustomerListName);
	}
	/**
	 * Get accessor for persistent attribute: lastUpdatedDate
	 */
	public java.sql.Date getLastUpdatedDate() {
		return dataCacheEntry.getLastUpdatedDate();
	}
	/**
	 * Set accessor for persistent attribute: lastUpdatedDate
	 */
	public void setLastUpdatedDate(java.sql.Date newLastUpdatedDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getLastUpdatedDate(),newLastUpdatedDate);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setLastUpdatedDate(newLastUpdatedDate);
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ProposalCountBeanCacheEntry_761cb22e;

/**
 * Bean implementation class for Enterprise Bean: ProposalCount
 */
public class ConcreteProposalCount_761cb22e extends com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private ProposalCountBeanCacheEntry_761cb22e dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteProposalCount_761cb22e
	 */
	public ConcreteProposalCount_761cb22e() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ProposalCountBeanInjector_761cb22e getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ProposalCountBeanInjector_761cb22e)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ProposalCountBeanCacheEntry_761cb22e) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey ejbCreate(java.lang.String salesOrg, java.lang.String proposalContent, java.lang.String customerName) throws javax.ejb.CreateException {
		dataCacheEntry = (ProposalCountBeanCacheEntry_761cb22e) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(salesOrg, proposalContent, customerName);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String salesOrg, java.lang.String proposalContent, java.lang.String customerName) throws javax.ejb.CreateException {
		super.ejbPostCreate(salesOrg, proposalContent, customerName);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey();
		pk.salesOrg = getSalesOrg();
		pk.proposalContent = getProposalContent();
		pk.customerName = getCustomerName();
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
	 * Get accessor for persistent attribute: proposalCount
	 */
	public int getProposalCount() {
		return dataCacheEntry.getProposalCount();
	}
	/**
	 * Set accessor for persistent attribute: proposalCount
	 */
	public void setProposalCount(int newProposalCount) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getProposalCount(),newProposalCount);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setProposalCount(newProposalCount);
	}
	/**
	 * Get accessor for persistent attribute: salesOrg
	 */
	public java.lang.String getSalesOrg() {
		return dataCacheEntry.getSalesOrg();
	}
	/**
	 * Set accessor for persistent attribute: salesOrg
	 */
	public void setSalesOrg(java.lang.String newSalesOrg) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getSalesOrg(),newSalesOrg);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setSalesOrg(newSalesOrg);
	}
	/**
	 * Get accessor for persistent attribute: proposalContent
	 */
	public java.lang.String getProposalContent() {
		return dataCacheEntry.getProposalContent();
	}
	/**
	 * Set accessor for persistent attribute: proposalContent
	 */
	public void setProposalContent(java.lang.String newProposalContent) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getProposalContent(),newProposalContent);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setProposalContent(newProposalContent);
	}
	/**
	 * Get accessor for persistent attribute: customerName
	 */
	public java.lang.String getCustomerName() {
		return dataCacheEntry.getCustomerName();
	}
	/**
	 * Set accessor for persistent attribute: customerName
	 */
	public void setCustomerName(java.lang.String newCustomerName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getCustomerName(),newCustomerName);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setCustomerName(newCustomerName);
	}
}

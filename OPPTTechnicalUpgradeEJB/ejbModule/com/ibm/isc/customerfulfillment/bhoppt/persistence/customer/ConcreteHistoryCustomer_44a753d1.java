package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.HistoryCustomerBeanCacheEntry_44a753d1;

/**
 * Bean implementation class for Enterprise Bean: HistoryCustomer
 */
public class ConcreteHistoryCustomer_44a753d1 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private HistoryCustomerBeanCacheEntry_44a753d1 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteHistoryCustomer_44a753d1
	 */
	public ConcreteHistoryCustomer_44a753d1() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.HistoryCustomerBeanInjector_44a753d1 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.HistoryCustomerBeanInjector_44a753d1)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.HistoryCustomerBeanCacheEntry_44a753d1) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindMaxCustomerId_Local
	 */
	public java.util.Collection ejbFindMaxCustomerId_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindMaxCustomerId", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey ejbCreate(int customerId, int proposalId) throws javax.ejb.CreateException {
		dataCacheEntry = (HistoryCustomerBeanCacheEntry_44a753d1) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(customerId, proposalId);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int customerId, int proposalId) throws javax.ejb.CreateException {
		super.ejbPostCreate(customerId, proposalId);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey();
		pk.customerId = getCustomerId();
		pk.proposalId = getProposalId();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 22;
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
			instanceExtension.markDirty(1,getProposalId(),newProposalId);
		else
			instanceExtension.markDirty(1);
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
			instanceExtension.markDirty(2,getCustomerListNo(),newCustomerListNo);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setCustomerListNo(newCustomerListNo);
	}
	/**
	 * Get accessor for persistent attribute: legacyCustomerNo
	 */
	public java.lang.String getLegacyCustomerNo() {
		return dataCacheEntry.getLegacyCustomerNo();
	}
	/**
	 * Set accessor for persistent attribute: legacyCustomerNo
	 */
	public void setLegacyCustomerNo(java.lang.String newLegacyCustomerNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getLegacyCustomerNo(),newLegacyCustomerNo);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setLegacyCustomerNo(newLegacyCustomerNo);
	}
	/**
	 * Get accessor for persistent attribute: sapCustomerNo
	 */
	public java.lang.String getSapCustomerNo() {
		return dataCacheEntry.getSapCustomerNo();
	}
	/**
	 * Set accessor for persistent attribute: sapCustomerNo
	 */
	public void setSapCustomerNo(java.lang.String newSapCustomerNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getSapCustomerNo(),newSapCustomerNo);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setSapCustomerNo(newSapCustomerNo);
	}
	/**
	 * Get accessor for persistent attribute: sapCustomerName
	 */
	public java.lang.String getSapCustomerName() {
		return dataCacheEntry.getSapCustomerName();
	}
	/**
	 * Set accessor for persistent attribute: sapCustomerName
	 */
	public void setSapCustomerName(java.lang.String newSapCustomerName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getSapCustomerName(),newSapCustomerName);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setSapCustomerName(newSapCustomerName);
	}
	/**
	 * Get accessor for persistent attribute: billToPartyNo
	 */
	public java.lang.String getBillToPartyNo() {
		return dataCacheEntry.getBillToPartyNo();
	}
	/**
	 * Set accessor for persistent attribute: billToPartyNo
	 */
	public void setBillToPartyNo(java.lang.String newBillToPartyNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getBillToPartyNo(),newBillToPartyNo);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setBillToPartyNo(newBillToPartyNo);
	}
	/**
	 * Get accessor for persistent attribute: billToPartyName
	 */
	public java.lang.String getBillToPartyName() {
		return dataCacheEntry.getBillToPartyName();
	}
	/**
	 * Set accessor for persistent attribute: billToPartyName
	 */
	public void setBillToPartyName(java.lang.String newBillToPartyName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getBillToPartyName(),newBillToPartyName);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setBillToPartyName(newBillToPartyName);
	}
	/**
	 * Get accessor for persistent attribute: payerNo
	 */
	public java.lang.String getPayerNo() {
		return dataCacheEntry.getPayerNo();
	}
	/**
	 * Set accessor for persistent attribute: payerNo
	 */
	public void setPayerNo(java.lang.String newPayerNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getPayerNo(),newPayerNo);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setPayerNo(newPayerNo);
	}
	/**
	 * Get accessor for persistent attribute: payerName
	 */
	public java.lang.String getPayerName() {
		return dataCacheEntry.getPayerName();
	}
	/**
	 * Set accessor for persistent attribute: payerName
	 */
	public void setPayerName(java.lang.String newPayerName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getPayerName(),newPayerName);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setPayerName(newPayerName);
	}
	/**
	 * Get accessor for persistent attribute: shipToPartyNo
	 */
	public java.lang.String getShipToPartyNo() {
		return dataCacheEntry.getShipToPartyNo();
	}
	/**
	 * Set accessor for persistent attribute: shipToPartyNo
	 */
	public void setShipToPartyNo(java.lang.String newShipToPartyNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getShipToPartyNo(),newShipToPartyNo);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setShipToPartyNo(newShipToPartyNo);
	}
	/**
	 * Get accessor for persistent attribute: shipToPartyName
	 */
	public java.lang.String getShipToPartyName() {
		return dataCacheEntry.getShipToPartyName();
	}
	/**
	 * Set accessor for persistent attribute: shipToPartyName
	 */
	public void setShipToPartyName(java.lang.String newShipToPartyName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getShipToPartyName(),newShipToPartyName);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setShipToPartyName(newShipToPartyName);
	}
	/**
	 * Get accessor for persistent attribute: planStartDate
	 */
	public java.sql.Date getPlanStartDate() {
		return dataCacheEntry.getPlanStartDate();
	}
	/**
	 * Set accessor for persistent attribute: planStartDate
	 */
	public void setPlanStartDate(java.sql.Date newPlanStartDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getPlanStartDate(),newPlanStartDate);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setPlanStartDate(newPlanStartDate);
	}
	/**
	 * Get accessor for persistent attribute: planEndDate
	 */
	public java.sql.Date getPlanEndDate() {
		return dataCacheEntry.getPlanEndDate();
	}
	/**
	 * Set accessor for persistent attribute: planEndDate
	 */
	public void setPlanEndDate(java.sql.Date newPlanEndDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(13,getPlanEndDate(),newPlanEndDate);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setPlanEndDate(newPlanEndDate);
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
			instanceExtension.markDirty(14,getLastUpdatedDate(),newLastUpdatedDate);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setLastUpdatedDate(newLastUpdatedDate);
	}
	/**
	 * Get accessor for persistent attribute: payerLNo
	 */
	public java.lang.String getPayerLNo() {
		return dataCacheEntry.getPayerLNo();
	}
	/**
	 * Set accessor for persistent attribute: payerLNo
	 */
	public void setPayerLNo(java.lang.String newPayerLNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(15,getPayerLNo(),newPayerLNo);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setPayerLNo(newPayerLNo);
	}
	/**
	 * Get accessor for persistent attribute: billToPartyLNo
	 */
	public java.lang.String getBillToPartyLNo() {
		return dataCacheEntry.getBillToPartyLNo();
	}
	/**
	 * Set accessor for persistent attribute: billToPartyLNo
	 */
	public void setBillToPartyLNo(java.lang.String newBillToPartyLNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(16,getBillToPartyLNo(),newBillToPartyLNo);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setBillToPartyLNo(newBillToPartyLNo);
	}
	/**
	 * Get accessor for persistent attribute: shipToPartyLNo
	 */
	public java.lang.String getShipToPartyLNo() {
		return dataCacheEntry.getShipToPartyLNo();
	}
	/**
	 * Set accessor for persistent attribute: shipToPartyLNo
	 */
	public void setShipToPartyLNo(java.lang.String newShipToPartyLNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(17,getShipToPartyLNo(),newShipToPartyLNo);
		else
			instanceExtension.markDirty(17);
		dataCacheEntry.setShipToPartyLNo(newShipToPartyLNo);
	}
	/**
	 * Get accessor for persistent attribute: customerASNo
	 */
	public java.lang.String getCustomerASNo() {
		return dataCacheEntry.getCustomerASNo();
	}
	/**
	 * Set accessor for persistent attribute: customerASNo
	 */
	public void setCustomerASNo(java.lang.String newCustomerASNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(18,getCustomerASNo(),newCustomerASNo);
		else
			instanceExtension.markDirty(18);
		dataCacheEntry.setCustomerASNo(newCustomerASNo);
	}
	/**
	 * Get accessor for persistent attribute: billToPartyASNo
	 */
	public java.lang.String getBillToPartyASNo() {
		return dataCacheEntry.getBillToPartyASNo();
	}
	/**
	 * Set accessor for persistent attribute: billToPartyASNo
	 */
	public void setBillToPartyASNo(java.lang.String newBillToPartyASNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(19,getBillToPartyASNo(),newBillToPartyASNo);
		else
			instanceExtension.markDirty(19);
		dataCacheEntry.setBillToPartyASNo(newBillToPartyASNo);
	}
	/**
	 * Get accessor for persistent attribute: shipToPartyASNo
	 */
	public java.lang.String getShipToPartyASNo() {
		return dataCacheEntry.getShipToPartyASNo();
	}
	/**
	 * Set accessor for persistent attribute: shipToPartyASNo
	 */
	public void setShipToPartyASNo(java.lang.String newShipToPartyASNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(20,getShipToPartyASNo(),newShipToPartyASNo);
		else
			instanceExtension.markDirty(20);
		dataCacheEntry.setShipToPartyASNo(newShipToPartyASNo);
	}
	/**
	 * Get accessor for persistent attribute: payerASNo
	 */
	public java.lang.String getPayerASNo() {
		return dataCacheEntry.getPayerASNo();
	}
	/**
	 * Set accessor for persistent attribute: payerASNo
	 */
	public void setPayerASNo(java.lang.String newPayerASNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(21,getPayerASNo(),newPayerASNo);
		else
			instanceExtension.markDirty(21);
		dataCacheEntry.setPayerASNo(newPayerASNo);
	}
}

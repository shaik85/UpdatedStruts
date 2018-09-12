package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VariancePriceBeanCacheEntry_1913c3b9;

/**
 * Bean implementation class for Enterprise Bean: VariancePrice
 */
public class ConcreteVariancePrice_1913c3b9 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private VariancePriceBeanCacheEntry_1913c3b9 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteVariancePrice_1913c3b9
	 */
	public ConcreteVariancePrice_1913c3b9() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VariancePriceBeanInjector_1913c3b9 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VariancePriceBeanInjector_1913c3b9)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VariancePriceBeanCacheEntry_1913c3b9) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByEE_Local
	 */
	public java.util.Collection ejbFindByEE_Local(int eeId, int swoid, int dmid, int custometId, int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByEE");
		getInjector().ejbFindByEE(eeId, swoid, dmid, custometId, proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByEE", record);
	}
	/**
	 * ejbFindByEEForVariance_Local
	 */
	public java.util.Collection ejbFindByEEForVariance_Local(int eeId, int swoid, int dmid, int custometId, int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByEEForVariance");
		getInjector().ejbFindByEEForVariance(eeId, swoid, dmid, custometId, proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByEEForVariance", record);
	}
	/**
	 * ejbFindMaxVariancePrice_Local
	 */
	public java.util.Collection ejbFindMaxVariancePrice_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindMaxVariancePrice", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey ejbCreate(int priceId, int eeId, int swoId, int dmId, int customerId, int proposalId) throws javax.ejb.CreateException {
		dataCacheEntry = (VariancePriceBeanCacheEntry_1913c3b9) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(priceId, eeId, swoId, dmId, customerId, proposalId);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int priceId, int eeId, int swoId, int dmId, int customerId, int proposalId) throws javax.ejb.CreateException {
		super.ejbPostCreate(priceId, eeId, swoId, dmId, customerId, proposalId);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey();
		pk.priceId = getPriceId();
		pk.eeId = getEeId();
		pk.swoId = getSwoId();
		pk.dmId = getDmId();
		pk.customerId = getCustomerId();
		pk.proposalId = getProposalId();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 13;
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
	 * Get accessor for persistent attribute: eeId
	 */
	public int getEeId() {
		return dataCacheEntry.getEeId();
	}
	/**
	 * Set accessor for persistent attribute: eeId
	 */
	public void setEeId(int newEeId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getEeId(),newEeId);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setEeId(newEeId);
	}
	/**
	 * Get accessor for persistent attribute: priceId
	 */
	public int getPriceId() {
		return dataCacheEntry.getPriceId();
	}
	/**
	 * Set accessor for persistent attribute: priceId
	 */
	public void setPriceId(int newPriceId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getPriceId(),newPriceId);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setPriceId(newPriceId);
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
			instanceExtension.markDirty(4,getProposalId(),newProposalId);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setProposalId(newProposalId);
	}
	/**
	 * Get accessor for persistent attribute: swoId
	 */
	public int getSwoId() {
		return dataCacheEntry.getSwoId();
	}
	/**
	 * Set accessor for persistent attribute: swoId
	 */
	public void setSwoId(int newSwoId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getSwoId(),newSwoId);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setSwoId(newSwoId);
	}
	/**
	 * Get accessor for persistent attribute: salesDocNo
	 */
	public java.lang.String getSalesDocNo() {
		return dataCacheEntry.getSalesDocNo();
	}
	/**
	 * Set accessor for persistent attribute: salesDocNo
	 */
	public void setSalesDocNo(java.lang.String newSalesDocNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getSalesDocNo(),newSalesDocNo);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setSalesDocNo(newSalesDocNo);
	}
	/**
	 * Get accessor for persistent attribute: eeItemNo
	 */
	public java.lang.String getEeItemNo() {
		return dataCacheEntry.getEeItemNo();
	}
	/**
	 * Set accessor for persistent attribute: eeItemNo
	 */
	public void setEeItemNo(java.lang.String newEeItemNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getEeItemNo(),newEeItemNo);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setEeItemNo(newEeItemNo);
	}
	/**
	 * Get accessor for persistent attribute: billPlanStartDate
	 */
	public java.sql.Date getBillPlanStartDate() {
		return dataCacheEntry.getBillPlanStartDate();
	}
	/**
	 * Set accessor for persistent attribute: billPlanStartDate
	 */
	public void setBillPlanStartDate(java.sql.Date newBillPlanStartDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getBillPlanStartDate(),newBillPlanStartDate);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setBillPlanStartDate(newBillPlanStartDate);
	}
	/**
	 * Get accessor for persistent attribute: billPlanEndDate
	 */
	public java.sql.Date getBillPlanEndDate() {
		return dataCacheEntry.getBillPlanEndDate();
	}
	/**
	 * Set accessor for persistent attribute: billPlanEndDate
	 */
	public void setBillPlanEndDate(java.sql.Date newBillPlanEndDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getBillPlanEndDate(),newBillPlanEndDate);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setBillPlanEndDate(newBillPlanEndDate);
	}
	/**
	 * Get accessor for persistent attribute: eswPrice
	 */
	public double getEswPrice() {
		return dataCacheEntry.getEswPrice();
	}
	/**
	 * Set accessor for persistent attribute: eswPrice
	 */
	public void setEswPrice(double newEswPrice) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getEswPrice(),newEswPrice);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setEswPrice(newEswPrice);
	}
	/**
	 * Get accessor for persistent attribute: currency
	 */
	public java.lang.String getCurrency() {
		return dataCacheEntry.getCurrency();
	}
	/**
	 * Set accessor for persistent attribute: currency
	 */
	public void setCurrency(java.lang.String newCurrency) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getCurrency(),newCurrency);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setCurrency(newCurrency);
	}
	/**
	 * Get accessor for persistent attribute: indicator
	 */
	public java.lang.String getIndicator() {
		return dataCacheEntry.getIndicator();
	}
	/**
	 * Set accessor for persistent attribute: indicator
	 */
	public void setIndicator(java.lang.String newIndicator) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getIndicator(),newIndicator);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setIndicator(newIndicator);
	}
}

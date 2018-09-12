package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.HistoryEEBeanCacheEntry_2f4f3e31;

/**
 * Bean implementation class for Enterprise Bean: HistoryEE
 */
public class ConcreteHistoryEE_2f4f3e31 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private HistoryEEBeanCacheEntry_2f4f3e31 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteHistoryEE_2f4f3e31
	 */
	public ConcreteHistoryEE_2f4f3e31() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.HistoryEEBeanInjector_2f4f3e31 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.HistoryEEBeanInjector_2f4f3e31)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.HistoryEEBeanCacheEntry_2f4f3e31) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindMaxEEId_Local
	 */
	public java.util.Collection ejbFindMaxEEId_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindMaxEEId", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey ejbCreate(int eeId, int swoId, int dmId, int customerId, int proposalId, java.lang.String eeNo) throws javax.ejb.CreateException {
		dataCacheEntry = (HistoryEEBeanCacheEntry_2f4f3e31) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(eeId, swoId, dmId, customerId, proposalId, eeNo);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int eeId, int swoId, int dmId, int customerId, int proposalId, java.lang.String eeNo) throws javax.ejb.CreateException {
		super.ejbPostCreate(eeId, swoId, dmId, customerId, proposalId, eeNo);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey();
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
		return 28;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
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
			instanceExtension.markDirty(0,getEeId(),newEeId);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setEeId(newEeId);
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
			instanceExtension.markDirty(1,getSwoId(),newSwoId);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setSwoId(newSwoId);
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
			instanceExtension.markDirty(2,getDmId(),newDmId);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setDmId(newDmId);
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
			instanceExtension.markDirty(3,getCustomerId(),newCustomerId);
		else
			instanceExtension.markDirty(3);
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
			instanceExtension.markDirty(4,getProposalId(),newProposalId);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setProposalId(newProposalId);
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
			instanceExtension.markDirty(5,getSalesDocNo(),newSalesDocNo);
		else
			instanceExtension.markDirty(5);
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
			instanceExtension.markDirty(6,getEeItemNo(),newEeItemNo);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setEeItemNo(newEeItemNo);
	}
	/**
	 * Get accessor for persistent attribute: swoItemNo
	 */
	public java.lang.String getSwoItemNo() {
		return dataCacheEntry.getSwoItemNo();
	}
	/**
	 * Set accessor for persistent attribute: swoItemNo
	 */
	public void setSwoItemNo(java.lang.String newSwoItemNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getSwoItemNo(),newSwoItemNo);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setSwoItemNo(newSwoItemNo);
	}
	/**
	 * Get accessor for persistent attribute: eeNo
	 */
	public java.lang.String getEeNo() {
		return dataCacheEntry.getEeNo();
	}
	/**
	 * Set accessor for persistent attribute: eeNo
	 */
	public void setEeNo(java.lang.String newEeNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getEeNo(),newEeNo);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setEeNo(newEeNo);
	}
	/**
	 * Get accessor for persistent attribute: eeDesc
	 */
	public java.lang.String getEeDesc() {
		return dataCacheEntry.getEeDesc();
	}
	/**
	 * Set accessor for persistent attribute: eeDesc
	 */
	public void setEeDesc(java.lang.String newEeDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getEeDesc(),newEeDesc);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setEeDesc(newEeDesc);
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
			instanceExtension.markDirty(10,getPlanStartDate(),newPlanStartDate);
		else
			instanceExtension.markDirty(10);
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
			instanceExtension.markDirty(11,getPlanEndDate(),newPlanEndDate);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setPlanEndDate(newPlanEndDate);
	}
	/**
	 * Get accessor for persistent attribute: reqstDeliveryDate
	 */
	public java.sql.Date getReqstDeliveryDate() {
		return dataCacheEntry.getReqstDeliveryDate();
	}
	/**
	 * Set accessor for persistent attribute: reqstDeliveryDate
	 */
	public void setReqstDeliveryDate(java.sql.Date newReqstDeliveryDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getReqstDeliveryDate(),newReqstDeliveryDate);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setReqstDeliveryDate(newReqstDeliveryDate);
	}
	/**
	 * Get accessor for persistent attribute: valueMetric
	 */
	public java.lang.String getValueMetric() {
		return dataCacheEntry.getValueMetric();
	}
	/**
	 * Set accessor for persistent attribute: valueMetric
	 */
	public void setValueMetric(java.lang.String newValueMetric) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(13,getValueMetric(),newValueMetric);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setValueMetric(newValueMetric);
	}
	/**
	 * Get accessor for persistent attribute: useLevel
	 */
	public java.lang.String getUseLevel() {
		return dataCacheEntry.getUseLevel();
	}
	/**
	 * Set accessor for persistent attribute: useLevel
	 */
	public void setUseLevel(java.lang.String newUseLevel) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(14,getUseLevel(),newUseLevel);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setUseLevel(newUseLevel);
	}
	/**
	 * Get accessor for persistent attribute: licenseType
	 */
	public java.lang.String getLicenseType() {
		return dataCacheEntry.getLicenseType();
	}
	/**
	 * Set accessor for persistent attribute: licenseType
	 */
	public void setLicenseType(java.lang.String newLicenseType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(15,getLicenseType(),newLicenseType);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setLicenseType(newLicenseType);
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
			instanceExtension.markDirty(16,getEswPrice(),newEswPrice);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setEswPrice(newEswPrice);
	}
	/**
	 * Get accessor for persistent attribute: calculatedPrice
	 */
	public double getCalculatedPrice() {
		return dataCacheEntry.getCalculatedPrice();
	}
	/**
	 * Set accessor for persistent attribute: calculatedPrice
	 */
	public void setCalculatedPrice(double newCalculatedPrice) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(17,getCalculatedPrice(),newCalculatedPrice);
		else
			instanceExtension.markDirty(17);
		dataCacheEntry.setCalculatedPrice(newCalculatedPrice);
	}
	/**
	 * Get accessor for persistent attribute: alternatePrice
	 */
	public double getAlternatePrice() {
		return dataCacheEntry.getAlternatePrice();
	}
	/**
	 * Set accessor for persistent attribute: alternatePrice
	 */
	public void setAlternatePrice(double newAlternatePrice) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(18,getAlternatePrice(),newAlternatePrice);
		else
			instanceExtension.markDirty(18);
		dataCacheEntry.setAlternatePrice(newAlternatePrice);
	}
	/**
	 * Get accessor for persistent attribute: billingStartDate
	 */
	public java.sql.Date getBillingStartDate() {
		return dataCacheEntry.getBillingStartDate();
	}
	/**
	 * Set accessor for persistent attribute: billingStartDate
	 */
	public void setBillingStartDate(java.sql.Date newBillingStartDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(19,getBillingStartDate(),newBillingStartDate);
		else
			instanceExtension.markDirty(19);
		dataCacheEntry.setBillingStartDate(newBillingStartDate);
	}
	/**
	 * Get accessor for persistent attribute: billingEndDate
	 */
	public java.sql.Date getBillingEndDate() {
		return dataCacheEntry.getBillingEndDate();
	}
	/**
	 * Set accessor for persistent attribute: billingEndDate
	 */
	public void setBillingEndDate(java.sql.Date newBillingEndDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(20,getBillingEndDate(),newBillingEndDate);
		else
			instanceExtension.markDirty(20);
		dataCacheEntry.setBillingEndDate(newBillingEndDate);
	}
	/**
	 * Get accessor for persistent attribute: exclusionId
	 */
	public java.lang.String getExclusionId() {
		return dataCacheEntry.getExclusionId();
	}
	/**
	 * Set accessor for persistent attribute: exclusionId
	 */
	public void setExclusionId(java.lang.String newExclusionId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(21,getExclusionId(),newExclusionId);
		else
			instanceExtension.markDirty(21);
		dataCacheEntry.setExclusionId(newExclusionId);
	}
	/**
	 * Get accessor for persistent attribute: sequenceNo
	 */
	public int getSequenceNo() {
		return dataCacheEntry.getSequenceNo();
	}
	/**
	 * Set accessor for persistent attribute: sequenceNo
	 */
	public void setSequenceNo(int newSequenceNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(22,getSequenceNo(),newSequenceNo);
		else
			instanceExtension.markDirty(22);
		dataCacheEntry.setSequenceNo(newSequenceNo);
	}
	/**
	 * Get accessor for persistent attribute: bumpId
	 */
	public java.lang.String getBumpId() {
		return dataCacheEntry.getBumpId();
	}
	/**
	 * Set accessor for persistent attribute: bumpId
	 */
	public void setBumpId(java.lang.String newBumpId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(23,getBumpId(),newBumpId);
		else
			instanceExtension.markDirty(23);
		dataCacheEntry.setBumpId(newBumpId);
	}
	/**
	 * Get accessor for persistent attribute: chargeOptionDesc
	 */
	public java.lang.String getChargeOptionDesc() {
		return dataCacheEntry.getChargeOptionDesc();
	}
	/**
	 * Set accessor for persistent attribute: chargeOptionDesc
	 */
	public void setChargeOptionDesc(java.lang.String newChargeOptionDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(24,getChargeOptionDesc(),newChargeOptionDesc);
		else
			instanceExtension.markDirty(24);
		dataCacheEntry.setChargeOptionDesc(newChargeOptionDesc);
	}
	/**
	 * Get accessor for persistent attribute: alternatePriceId
	 */
	public java.lang.String getAlternatePriceId() {
		return dataCacheEntry.getAlternatePriceId();
	}
	/**
	 * Set accessor for persistent attribute: alternatePriceId
	 */
	public void setAlternatePriceId(java.lang.String newAlternatePriceId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(25,getAlternatePriceId(),newAlternatePriceId);
		else
			instanceExtension.markDirty(25);
		dataCacheEntry.setAlternatePriceId(newAlternatePriceId);
	}
	/**
	 * Get accessor for persistent attribute: priceEffectiveDate
	 */
	public java.sql.Date getPriceEffectiveDate() {
		return dataCacheEntry.getPriceEffectiveDate();
	}
	/**
	 * Set accessor for persistent attribute: priceEffectiveDate
	 */
	public void setPriceEffectiveDate(java.sql.Date newPriceEffectiveDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(26,getPriceEffectiveDate(),newPriceEffectiveDate);
		else
			instanceExtension.markDirty(26);
		dataCacheEntry.setPriceEffectiveDate(newPriceEffectiveDate);
	}
	/**
	 * Get accessor for persistent attribute: sandsdiscountpercent
	 */
	public double getSandsdiscountpercent() {
		return dataCacheEntry.getSandsdiscountpercent();
	}
	/**
	 * Set accessor for persistent attribute: sandsdiscountpercent
	 */
	public void setSandsdiscountpercent(double newSandsdiscountpercent) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(27,getSandsdiscountpercent(),newSandsdiscountpercent);
		else
			instanceExtension.markDirty(27);
		dataCacheEntry.setSandsdiscountpercent(newSandsdiscountpercent);
	}
}

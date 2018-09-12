package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VarianceEEBeanCacheEntry_4da349e6;

/**
 * Bean implementation class for Enterprise Bean: VarianceEE
 */
public class ConcreteVarianceEE_4da349e6 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private VarianceEEBeanCacheEntry_4da349e6 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteVarianceEE_4da349e6
	 */
	public ConcreteVarianceEE_4da349e6() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VarianceEEBeanInjector_4da349e6 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VarianceEEBeanInjector_4da349e6)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VarianceEEBeanCacheEntry_4da349e6) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindBySWO_Local
	 */
	public java.util.Collection ejbFindBySWO_Local(int swoid, int dmid, int custometId, int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindBySWO");
		getInjector().ejbFindBySWO(swoid, dmid, custometId, proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindBySWO", record);
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
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey ejbCreate(int eeId, int swoId, int dmId, int customerId, int proposalId, java.lang.String eeNo) throws javax.ejb.CreateException {
		dataCacheEntry = (VarianceEEBeanCacheEntry_4da349e6) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(eeId, swoId, dmId, customerId, proposalId, eeNo);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey)instanceExtension.ejbCreate();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey();
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
		return 17;
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
			instanceExtension.markDirty(3,getProposalId(),newProposalId);
		else
			instanceExtension.markDirty(3);
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
			instanceExtension.markDirty(4,getSwoId(),newSwoId);
		else
			instanceExtension.markDirty(4);
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
			instanceExtension.markDirty(10,getValueMetric(),newValueMetric);
		else
			instanceExtension.markDirty(10);
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
			instanceExtension.markDirty(11,getUseLevel(),newUseLevel);
		else
			instanceExtension.markDirty(11);
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
			instanceExtension.markDirty(12,getLicenseType(),newLicenseType);
		else
			instanceExtension.markDirty(12);
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
			instanceExtension.markDirty(13,getEswPrice(),newEswPrice);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setEswPrice(newEswPrice);
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
			instanceExtension.markDirty(14,getSequenceNo(),newSequenceNo);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setSequenceNo(newSequenceNo);
	}
	/**
	 * Get accessor for persistent attribute: chargeOption
	 */
	public java.lang.String getChargeOption() {
		return dataCacheEntry.getChargeOption();
	}
	/**
	 * Set accessor for persistent attribute: chargeOption
	 */
	public void setChargeOption(java.lang.String newChargeOption) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(15,getChargeOption(),newChargeOption);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setChargeOption(newChargeOption);
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
			instanceExtension.markDirty(16,getChargeOptionDesc(),newChargeOptionDesc);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setChargeOptionDesc(newChargeOptionDesc);
	}
}

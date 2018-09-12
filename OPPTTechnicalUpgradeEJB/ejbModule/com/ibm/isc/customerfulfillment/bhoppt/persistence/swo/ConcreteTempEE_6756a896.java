package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.TempEEBeanCacheEntry_6756a896;

/**
 * Bean implementation class for Enterprise Bean: TempEE
 */
public class ConcreteTempEE_6756a896 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private TempEEBeanCacheEntry_6756a896 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTempEE_6756a896
	 */
	public ConcreteTempEE_6756a896() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.TempEEBeanInjector_6756a896 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.TempEEBeanInjector_6756a896)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.TempEEBeanCacheEntry_6756a896) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey ejbCreate(int proposalId, int customerId, int dmId) throws javax.ejb.CreateException {
		dataCacheEntry = (TempEEBeanCacheEntry_6756a896) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(proposalId, customerId, dmId);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int proposalId, int customerId, int dmId) throws javax.ejb.CreateException {
		super.ejbPostCreate(proposalId, customerId, dmId);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey();
		pk.proposalId = getProposalId();
		pk.customerId = getCustomerId();
		pk.dmId = getDmId();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 21;
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
			instanceExtension.markDirty(1,getCustomerId(),newCustomerId);
		else
			instanceExtension.markDirty(1);
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
			instanceExtension.markDirty(2,getDmId(),newDmId);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setDmId(newDmId);
	}
	/**
	 * Get accessor for persistent attribute: sessionId
	 */
	public java.lang.String getSessionId() {
		return dataCacheEntry.getSessionId();
	}
	/**
	 * Set accessor for persistent attribute: sessionId
	 */
	public void setSessionId(java.lang.String newSessionId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getSessionId(),newSessionId);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setSessionId(newSessionId);
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
			instanceExtension.markDirty(5,getEeId(),newEeId);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setEeId(newEeId);
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
			instanceExtension.markDirty(6,getEeNo(),newEeNo);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setEeNo(newEeNo);
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
			instanceExtension.markDirty(7,getSalesDocNo(),newSalesDocNo);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setSalesDocNo(newSalesDocNo);
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
			instanceExtension.markDirty(8,getSwoItemNo(),newSwoItemNo);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setSwoItemNo(newSwoItemNo);
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
			instanceExtension.markDirty(9,getEeItemNo(),newEeItemNo);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setEeItemNo(newEeItemNo);
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
			instanceExtension.markDirty(11,getLicenseType(),newLicenseType);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setLicenseType(newLicenseType);
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
			instanceExtension.markDirty(12,getChargeOptionDesc(),newChargeOptionDesc);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setChargeOptionDesc(newChargeOptionDesc);
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
			instanceExtension.markDirty(13,getUseLevel(),newUseLevel);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setUseLevel(newUseLevel);
	}
	/**
	 * Get accessor for persistent attribute: validInd
	 */
	public java.lang.String getValidInd() {
		return dataCacheEntry.getValidInd();
	}
	/**
	 * Set accessor for persistent attribute: validInd
	 */
	public void setValidInd(java.lang.String newValidInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(14,getValidInd(),newValidInd);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setValidInd(newValidInd);
	}
	/**
	 * Get accessor for persistent attribute: valueMetricType
	 */
	public java.lang.String getValueMetricType() {
		return dataCacheEntry.getValueMetricType();
	}
	/**
	 * Set accessor for persistent attribute: valueMetricType
	 */
	public void setValueMetricType(java.lang.String newValueMetricType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(15,getValueMetricType(),newValueMetricType);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setValueMetricType(newValueMetricType);
	}
	/**
	 * Get accessor for persistent attribute: vm
	 */
	public java.lang.String getVm() {
		return dataCacheEntry.getVm();
	}
	/**
	 * Set accessor for persistent attribute: vm
	 */
	public void setVm(java.lang.String newVm) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(16,getVm(),newVm);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setVm(newVm);
	}
	/**
	 * Get accessor for persistent attribute: lcs
	 */
	public java.lang.String getLcs() {
		return dataCacheEntry.getLcs();
	}
	/**
	 * Set accessor for persistent attribute: lcs
	 */
	public void setLcs(java.lang.String newLcs) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(17,getLcs(),newLcs);
		else
			instanceExtension.markDirty(17);
		dataCacheEntry.setLcs(newLcs);
	}
	/**
	 * Get accessor for persistent attribute: cho
	 */
	public java.lang.String getCho() {
		return dataCacheEntry.getCho();
	}
	/**
	 * Set accessor for persistent attribute: cho
	 */
	public void setCho(java.lang.String newCho) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(18,getCho(),newCho);
		else
			instanceExtension.markDirty(18);
		dataCacheEntry.setCho(newCho);
	}
	/**
	 * Get accessor for persistent attribute: ul
	 */
	public java.lang.String getUl() {
		return dataCacheEntry.getUl();
	}
	/**
	 * Set accessor for persistent attribute: ul
	 */
	public void setUl(java.lang.String newUl) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(19,getUl(),newUl);
		else
			instanceExtension.markDirty(19);
		dataCacheEntry.setUl(newUl);
	}
	/**
	 * Get accessor for persistent attribute: defaultFlag
	 */
	public java.lang.String getDefaultFlag() {
		return dataCacheEntry.getDefaultFlag();
	}
	/**
	 * Set accessor for persistent attribute: defaultFlag
	 */
	public void setDefaultFlag(java.lang.String newDefaultFlag) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(20,getDefaultFlag(),newDefaultFlag);
		else
			instanceExtension.markDirty(20);
		dataCacheEntry.setDefaultFlag(newDefaultFlag);
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VarianceSWOBeanCacheEntry_c577a175;

/**
 * Bean implementation class for Enterprise Bean: VarianceSWO
 */
public class ConcreteVarianceSWO_c577a175 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private VarianceSWOBeanCacheEntry_c577a175 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteVarianceSWO_c577a175
	 */
	public ConcreteVarianceSWO_c577a175() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VarianceSWOBeanInjector_c577a175 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VarianceSWOBeanInjector_c577a175)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VarianceSWOBeanCacheEntry_c577a175) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByDM_Local
	 */
	public java.util.Collection ejbFindByDM_Local(int dmID, int customerId, int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByDM");
		getInjector().ejbFindByDM(dmID, customerId, proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByDM", record);
	}
	/**
	 * ejbFindByEquipmentNo_Local
	 */
	public java.util.Collection ejbFindByEquipmentNo_Local(java.lang.String equipmentNo, int proposalId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByEquipmentNo");
		getInjector().ejbFindByEquipmentNo(equipmentNo, proposalId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByEquipmentNo", record);
	}
	/**
	 * ejbFindMaxVarianceSWOId_Local
	 */
	public java.util.Collection ejbFindMaxVarianceSWOId_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindMaxVarianceSWOId", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey ejbCreate(int swoId, int dmId, int customerId, int proposalId, java.lang.String swoNo) throws javax.ejb.CreateException {
		dataCacheEntry = (VarianceSWOBeanCacheEntry_c577a175) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(swoId, dmId, customerId, proposalId, swoNo);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int swoId, int dmId, int customerId, int proposalId, java.lang.String swoNo) throws javax.ejb.CreateException {
		super.ejbPostCreate(swoId, dmId, customerId, proposalId, swoNo);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey();
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
		return 16;
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
			instanceExtension.markDirty(3,getSwoId(),newSwoId);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setSwoId(newSwoId);
	}
	/**
	 * Get accessor for persistent attribute: swoNo
	 */
	public java.lang.String getSwoNo() {
		return dataCacheEntry.getSwoNo();
	}
	/**
	 * Set accessor for persistent attribute: swoNo
	 */
	public void setSwoNo(java.lang.String newSwoNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getSwoNo(),newSwoNo);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setSwoNo(newSwoNo);
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
	 * Get accessor for persistent attribute: swoDesc
	 */
	public java.lang.String getSwoDesc() {
		return dataCacheEntry.getSwoDesc();
	}
	/**
	 * Set accessor for persistent attribute: swoDesc
	 */
	public void setSwoDesc(java.lang.String newSwoDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getSwoDesc(),newSwoDesc);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setSwoDesc(newSwoDesc);
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
			instanceExtension.markDirty(8,getSequenceNo(),newSequenceNo);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setSequenceNo(newSequenceNo);
	}
	/**
	 * Get accessor for persistent attribute: itemCategory
	 */
	public java.lang.String getItemCategory() {
		return dataCacheEntry.getItemCategory();
	}
	/**
	 * Set accessor for persistent attribute: itemCategory
	 */
	public void setItemCategory(java.lang.String newItemCategory) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getItemCategory(),newItemCategory);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setItemCategory(newItemCategory);
	}
	/**
	 * Get accessor for persistent attribute: serialNo
	 */
	public java.lang.String getSerialNo() {
		return dataCacheEntry.getSerialNo();
	}
	/**
	 * Set accessor for persistent attribute: serialNo
	 */
	public void setSerialNo(java.lang.String newSerialNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getSerialNo(),newSerialNo);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setSerialNo(newSerialNo);
	}
	/**
	 * Get accessor for persistent attribute: customerPONo
	 */
	public java.lang.String getCustomerPONo() {
		return dataCacheEntry.getCustomerPONo();
	}
	/**
	 * Set accessor for persistent attribute: customerPONo
	 */
	public void setCustomerPONo(java.lang.String newCustomerPONo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getCustomerPONo(),newCustomerPONo);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setCustomerPONo(newCustomerPONo);
	}
	/**
	 * Get accessor for persistent attribute: equipmentNo
	 */
	public java.lang.String getEquipmentNo() {
		return dataCacheEntry.getEquipmentNo();
	}
	/**
	 * Set accessor for persistent attribute: equipmentNo
	 */
	public void setEquipmentNo(java.lang.String newEquipmentNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getEquipmentNo(),newEquipmentNo);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setEquipmentNo(newEquipmentNo);
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
	 * Get accessor for persistent attribute: referenceSerialNo
	 */
	public java.lang.String getReferenceSerialNo() {
		return dataCacheEntry.getReferenceSerialNo();
	}
	/**
	 * Set accessor for persistent attribute: referenceSerialNo
	 */
	public void setReferenceSerialNo(java.lang.String newReferenceSerialNo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(14,getReferenceSerialNo(),newReferenceSerialNo);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setReferenceSerialNo(newReferenceSerialNo);
	}
	/**
	 * Get accessor for persistent attribute: referenceSerialNoDM
	 */
	public java.lang.String getReferenceSerialNoDM() {
		return dataCacheEntry.getReferenceSerialNoDM();
	}
	/**
	 * Set accessor for persistent attribute: referenceSerialNoDM
	 */
	public void setReferenceSerialNoDM(java.lang.String newReferenceSerialNoDM) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(15,getReferenceSerialNoDM(),newReferenceSerialNoDM);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setReferenceSerialNoDM(newReferenceSerialNoDM);
	}
}

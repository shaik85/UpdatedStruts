package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementModificationDetailsBeanCacheEntry_6b44584e;

/**
 * Bean implementation class for Enterprise Bean: BaseAgreementModificationDetails
 */
public class ConcreteBaseAgreementModificationDetails_6b44584e extends com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BaseAgreementModificationDetailsBeanCacheEntry_6b44584e dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBaseAgreementModificationDetails_6b44584e
	 */
	public ConcreteBaseAgreementModificationDetails_6b44584e() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementModificationDetailsBeanInjector_6b44584e getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementModificationDetailsBeanInjector_6b44584e)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementModificationDetailsBeanCacheEntry_6b44584e) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByAgreementId_Local
	 */
	public java.util.Collection ejbFindByAgreementId_Local(java.lang.Integer agreementId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByAgreementId");
		getInjector().ejbFindByAgreementId(agreementId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByAgreementId", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey ejbCreate(java.lang.Integer agreementId, java.lang.String modificationTypeCode) throws javax.ejb.CreateException {
		dataCacheEntry = (BaseAgreementModificationDetailsBeanCacheEntry_6b44584e) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(agreementId, modificationTypeCode);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer agreementId, java.lang.String modificationTypeCode) throws javax.ejb.CreateException {
		super.ejbPostCreate(agreementId, modificationTypeCode);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey();
		pk.agreementId = getAgreementId();
		pk.modificationTypeCode = getModificationTypeCode();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 15;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: agreementId
	 */
	public java.lang.Integer getAgreementId() {
		return dataCacheEntry.getAgreementId();
	}
	/**
	 * Set accessor for persistent attribute: agreementId
	 */
	public void setAgreementId(java.lang.Integer newAgreementId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getAgreementId(),newAgreementId);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setAgreementId(newAgreementId);
	}
	/**
	 * Get accessor for persistent attribute: modificationTypeCode
	 */
	public java.lang.String getModificationTypeCode() {
		return dataCacheEntry.getModificationTypeCode();
	}
	/**
	 * Set accessor for persistent attribute: modificationTypeCode
	 */
	public void setModificationTypeCode(java.lang.String newModificationTypeCode) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getModificationTypeCode(),newModificationTypeCode);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setModificationTypeCode(newModificationTypeCode);
	}
	/**
	 * Get accessor for persistent attribute: legalContract
	 */
	public java.lang.String getLegalContract() {
		return dataCacheEntry.getLegalContract();
	}
	/**
	 * Set accessor for persistent attribute: legalContract
	 */
	public void setLegalContract(java.lang.String newLegalContract) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getLegalContract(),newLegalContract);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setLegalContract(newLegalContract);
	}
	/**
	 * Get accessor for persistent attribute: accountingContact
	 */
	public java.lang.String getAccountingContact() {
		return dataCacheEntry.getAccountingContact();
	}
	/**
	 * Set accessor for persistent attribute: accountingContact
	 */
	public void setAccountingContact(java.lang.String newAccountingContact) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getAccountingContact(),newAccountingContact);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setAccountingContact(newAccountingContact);
	}
	/**
	 * Get accessor for persistent attribute: revenueRecognition
	 */
	public java.lang.String getRevenueRecognition() {
		return dataCacheEntry.getRevenueRecognition();
	}
	/**
	 * Set accessor for persistent attribute: revenueRecognition
	 */
	public void setRevenueRecognition(java.lang.String newRevenueRecognition) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getRevenueRecognition(),newRevenueRecognition);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setRevenueRecognition(newRevenueRecognition);
	}
	/**
	 * Get accessor for persistent attribute: modifiedIBMLetterHead
	 */
	public java.lang.String getModifiedIBMLetterHead() {
		return dataCacheEntry.getModifiedIBMLetterHead();
	}
	/**
	 * Set accessor for persistent attribute: modifiedIBMLetterHead
	 */
	public void setModifiedIBMLetterHead(java.lang.String newModifiedIBMLetterHead) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getModifiedIBMLetterHead(),newModifiedIBMLetterHead);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setModifiedIBMLetterHead(newModifiedIBMLetterHead);
	}
	/**
	 * Get accessor for persistent attribute: modificationOption
	 */
	public java.lang.String getModificationOption() {
		return dataCacheEntry.getModificationOption();
	}
	/**
	 * Set accessor for persistent attribute: modificationOption
	 */
	public void setModificationOption(java.lang.String newModificationOption) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getModificationOption(),newModificationOption);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setModificationOption(newModificationOption);
	}
	/**
	 * Get accessor for persistent attribute: details
	 */
	public java.lang.String getDetails() {
		return dataCacheEntry.getDetails();
	}
	/**
	 * Set accessor for persistent attribute: details
	 */
	public void setDetails(java.lang.String newDetails) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getDetails(),newDetails);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setDetails(newDetails);
	}
	/**
	 * Get accessor for persistent attribute: createdBy
	 */
	public java.lang.String getCreatedBy() {
		return dataCacheEntry.getCreatedBy();
	}
	/**
	 * Set accessor for persistent attribute: createdBy
	 */
	public void setCreatedBy(java.lang.String newCreatedBy) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getCreatedBy(),newCreatedBy);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setCreatedBy(newCreatedBy);
	}
	/**
	 * Get accessor for persistent attribute: createdDate
	 */
	public java.sql.Date getCreatedDate() {
		return dataCacheEntry.getCreatedDate();
	}
	/**
	 * Set accessor for persistent attribute: createdDate
	 */
	public void setCreatedDate(java.sql.Date newCreatedDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getCreatedDate(),newCreatedDate);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setCreatedDate(newCreatedDate);
	}
	/**
	 * Get accessor for persistent attribute: changedBy
	 */
	public java.lang.String getChangedBy() {
		return dataCacheEntry.getChangedBy();
	}
	/**
	 * Set accessor for persistent attribute: changedBy
	 */
	public void setChangedBy(java.lang.String newChangedBy) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getChangedBy(),newChangedBy);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setChangedBy(newChangedBy);
	}
	/**
	 * Get accessor for persistent attribute: changedDate
	 */
	public java.sql.Date getChangedDate() {
		return dataCacheEntry.getChangedDate();
	}
	/**
	 * Set accessor for persistent attribute: changedDate
	 */
	public void setChangedDate(java.sql.Date newChangedDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getChangedDate(),newChangedDate);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setChangedDate(newChangedDate);
	}
	/**
	 * Get accessor for persistent attribute: rolStartDate
	 */
	public java.sql.Date getRolStartDate() {
		return dataCacheEntry.getRolStartDate();
	}
	/**
	 * Set accessor for persistent attribute: rolStartDate
	 */
	public void setRolStartDate(java.sql.Date newRolStartDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getRolStartDate(),newRolStartDate);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setRolStartDate(newRolStartDate);
	}
	/**
	 * Get accessor for persistent attribute: rolEndDate
	 */
	public java.sql.Date getRolEndDate() {
		return dataCacheEntry.getRolEndDate();
	}
	/**
	 * Set accessor for persistent attribute: rolEndDate
	 */
	public void setRolEndDate(java.sql.Date newRolEndDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(13,getRolEndDate(),newRolEndDate);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setRolEndDate(newRolEndDate);
	}
	/**
	 * Get accessor for persistent attribute: status
	 */
	public java.lang.String getStatus() {
		return dataCacheEntry.getStatus();
	}
	/**
	 * Set accessor for persistent attribute: status
	 */
	public void setStatus(java.lang.String newStatus) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(14,getStatus(),newStatus);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setStatus(newStatus);
	}
}

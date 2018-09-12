package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementBeanCacheEntry_2e70ac6a;

/**
 * Bean implementation class for Enterprise Bean: BaseAgreement
 */
public class ConcreteBaseAgreement_2e70ac6a extends com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BaseAgreementBeanCacheEntry_2e70ac6a dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBaseAgreement_2e70ac6a
	 */
	public ConcreteBaseAgreement_2e70ac6a() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementBeanInjector_2e70ac6a getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementBeanInjector_2e70ac6a)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementBeanCacheEntry_2e70ac6a) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindMaxAgreementId_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey ejbFindMaxAgreementId_Local() throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey) instanceExtension.executeFind("FindMaxAgreementId", null);
	}
	/**
	 * ejbFindByCustomerNumberandFormNumber_Local
	 */
	public java.util.Collection ejbFindByCustomerNumberandFormNumber_Local(java.lang.String customerNumber, java.lang.String formNumber) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByCustomerNumberandFormNumber");
		getInjector().ejbFindByCustomerNumberandFormNumber(customerNumber, formNumber, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByCustomerNumberandFormNumber", record);
	}
	/**
	 * ejbFindBySalesOrgAndFormNumber_Local
	 */
	public java.util.Collection ejbFindBySalesOrgAndFormNumber_Local(java.lang.String salesOrganization, java.lang.String formNumber) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindBySalesOrgAndFormNumber");
		getInjector().ejbFindBySalesOrgAndFormNumber(salesOrganization, formNumber, record);
		return (java.util.Collection) instanceExtension.executeFind("FindBySalesOrgAndFormNumber", record);
	}
	/**
	 * ejbFindBySearch_Local
	 */
	public java.util.Collection ejbFindBySearch_Local(java.lang.String agreementNumber, java.lang.String formNumber, java.lang.String customerNumber, java.lang.String enterpriseNumber) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindBySearch");
		getInjector().ejbFindBySearch(agreementNumber, formNumber, customerNumber, enterpriseNumber, record);
		return (java.util.Collection) instanceExtension.executeFind("FindBySearch", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey ejbCreate(java.lang.Integer agreementId, java.lang.String salesOrg, java.lang.String agreementNumber, java.lang.String agreementStatus, java.lang.String coverageType, java.lang.String isModified, java.lang.String createdBy, java.sql.Date createdDate) throws javax.ejb.CreateException {
		dataCacheEntry = (BaseAgreementBeanCacheEntry_2e70ac6a) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(agreementId, salesOrg, agreementNumber, agreementStatus, coverageType, isModified, createdBy, createdDate);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer agreementId, java.lang.String salesOrg, java.lang.String agreementNumber, java.lang.String agreementStatus, java.lang.String coverageType, java.lang.String isModified, java.lang.String createdBy, java.sql.Date createdDate) throws javax.ejb.CreateException {
		super.ejbPostCreate(agreementId, salesOrg, agreementNumber, agreementStatus, coverageType, isModified, createdBy, createdDate);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey();
		pk.agreementId = getAgreementId();
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
	 * Get accessor for persistent attribute: agreementNumber
	 */
	public java.lang.String getAgreementNumber() {
		return dataCacheEntry.getAgreementNumber();
	}
	/**
	 * Set accessor for persistent attribute: agreementNumber
	 */
	public void setAgreementNumber(java.lang.String newAgreementNumber) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getAgreementNumber(),newAgreementNumber);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setAgreementNumber(newAgreementNumber);
	}
	/**
	 * Get accessor for persistent attribute: formNumber
	 */
	public java.lang.String getFormNumber() {
		return dataCacheEntry.getFormNumber();
	}
	/**
	 * Set accessor for persistent attribute: formNumber
	 */
	public void setFormNumber(java.lang.String newFormNumber) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getFormNumber(),newFormNumber);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setFormNumber(newFormNumber);
	}
	/**
	 * Get accessor for persistent attribute: enterpriseNumber
	 */
	public java.lang.String getEnterpriseNumber() {
		return dataCacheEntry.getEnterpriseNumber();
	}
	/**
	 * Set accessor for persistent attribute: enterpriseNumber
	 */
	public void setEnterpriseNumber(java.lang.String newEnterpriseNumber) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getEnterpriseNumber(),newEnterpriseNumber);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setEnterpriseNumber(newEnterpriseNumber);
	}
	/**
	 * Get accessor for persistent attribute: customerNumber
	 */
	public java.lang.String getCustomerNumber() {
		return dataCacheEntry.getCustomerNumber();
	}
	/**
	 * Set accessor for persistent attribute: customerNumber
	 */
	public void setCustomerNumber(java.lang.String newCustomerNumber) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getCustomerNumber(),newCustomerNumber);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setCustomerNumber(newCustomerNumber);
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
			instanceExtension.markDirty(5,getCreatedDate(),newCreatedDate);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setCreatedDate(newCreatedDate);
	}
	/**
	 * Get accessor for persistent attribute: enterpriseName
	 */
	public java.lang.String getEnterpriseName() {
		return dataCacheEntry.getEnterpriseName();
	}
	/**
	 * Set accessor for persistent attribute: enterpriseName
	 */
	public void setEnterpriseName(java.lang.String newEnterpriseName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getEnterpriseName(),newEnterpriseName);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setEnterpriseName(newEnterpriseName);
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
			instanceExtension.markDirty(7,getCreatedBy(),newCreatedBy);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setCreatedBy(newCreatedBy);
	}
	/**
	 * Get accessor for persistent attribute: acceptedDate
	 */
	public java.sql.Date getAcceptedDate() {
		return dataCacheEntry.getAcceptedDate();
	}
	/**
	 * Set accessor for persistent attribute: acceptedDate
	 */
	public void setAcceptedDate(java.sql.Date newAcceptedDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getAcceptedDate(),newAcceptedDate);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setAcceptedDate(newAcceptedDate);
	}
	/**
	 * Get accessor for persistent attribute: isElectronicSubmitter
	 */
	public java.lang.String getIsElectronicSubmitter() {
		return dataCacheEntry.getIsElectronicSubmitter();
	}
	/**
	 * Set accessor for persistent attribute: isElectronicSubmitter
	 */
	public void setIsElectronicSubmitter(java.lang.String newIsElectronicSubmitter) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getIsElectronicSubmitter(),newIsElectronicSubmitter);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setIsElectronicSubmitter(newIsElectronicSubmitter);
	}
	/**
	 * Get accessor for persistent attribute: agreementStatus
	 */
	public java.lang.String getAgreementStatus() {
		return dataCacheEntry.getAgreementStatus();
	}
	/**
	 * Set accessor for persistent attribute: agreementStatus
	 */
	public void setAgreementStatus(java.lang.String newAgreementStatus) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getAgreementStatus(),newAgreementStatus);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setAgreementStatus(newAgreementStatus);
	}
	/**
	 * Get accessor for persistent attribute: branchOffice
	 */
	public java.lang.String getBranchOffice() {
		return dataCacheEntry.getBranchOffice();
	}
	/**
	 * Set accessor for persistent attribute: branchOffice
	 */
	public void setBranchOffice(java.lang.String newBranchOffice) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getBranchOffice(),newBranchOffice);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setBranchOffice(newBranchOffice);
	}
	/**
	 * Get accessor for persistent attribute: isModifiedAgreement
	 */
	public java.lang.String getIsModifiedAgreement() {
		return dataCacheEntry.getIsModifiedAgreement();
	}
	/**
	 * Set accessor for persistent attribute: isModifiedAgreement
	 */
	public void setIsModifiedAgreement(java.lang.String newIsModifiedAgreement) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getIsModifiedAgreement(),newIsModifiedAgreement);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setIsModifiedAgreement(newIsModifiedAgreement);
	}
	/**
	 * Get accessor for persistent attribute: previousAgreementId
	 */
	public java.lang.Integer getPreviousAgreementId() {
		return dataCacheEntry.getPreviousAgreementId();
	}
	/**
	 * Set accessor for persistent attribute: previousAgreementId
	 */
	public void setPreviousAgreementId(java.lang.Integer newPreviousAgreementId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(13,getPreviousAgreementId(),newPreviousAgreementId);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setPreviousAgreementId(newPreviousAgreementId);
	}
	/**
	 * Get accessor for persistent attribute: coverageType
	 */
	public java.lang.String getCoverageType() {
		return dataCacheEntry.getCoverageType();
	}
	/**
	 * Set accessor for persistent attribute: coverageType
	 */
	public void setCoverageType(java.lang.String newCoverageType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(14,getCoverageType(),newCoverageType);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setCoverageType(newCoverageType);
	}
	/**
	 * Get accessor for persistent attribute: customerRepresentative
	 */
	public java.lang.String getCustomerRepresentative() {
		return dataCacheEntry.getCustomerRepresentative();
	}
	/**
	 * Set accessor for persistent attribute: customerRepresentative
	 */
	public void setCustomerRepresentative(java.lang.String newCustomerRepresentative) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(15,getCustomerRepresentative(),newCustomerRepresentative);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setCustomerRepresentative(newCustomerRepresentative);
	}
	/**
	 * Get accessor for persistent attribute: imageReferenceNumber
	 */
	public java.lang.String getImageReferenceNumber() {
		return dataCacheEntry.getImageReferenceNumber();
	}
	/**
	 * Set accessor for persistent attribute: imageReferenceNumber
	 */
	public void setImageReferenceNumber(java.lang.String newImageReferenceNumber) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(16,getImageReferenceNumber(),newImageReferenceNumber);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setImageReferenceNumber(newImageReferenceNumber);
	}
	/**
	 * Get accessor for persistent attribute: fileNumber
	 */
	public java.lang.String getFileNumber() {
		return dataCacheEntry.getFileNumber();
	}
	/**
	 * Set accessor for persistent attribute: fileNumber
	 */
	public void setFileNumber(java.lang.String newFileNumber) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(17,getFileNumber(),newFileNumber);
		else
			instanceExtension.markDirty(17);
		dataCacheEntry.setFileNumber(newFileNumber);
	}
	/**
	 * Get accessor for persistent attribute: oneway
	 */
	public java.lang.String getOneway() {
		return dataCacheEntry.getOneway();
	}
	/**
	 * Set accessor for persistent attribute: oneway
	 */
	public void setOneway(java.lang.String newOneway) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(18,getOneway(),newOneway);
		else
			instanceExtension.markDirty(18);
		dataCacheEntry.setOneway(newOneway);
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
			instanceExtension.markDirty(19,getCustomerName(),newCustomerName);
		else
			instanceExtension.markDirty(19);
		dataCacheEntry.setCustomerName(newCustomerName);
	}
	/**
	 * Get accessor for persistent attribute: salesOrganization
	 */
	public java.lang.String getSalesOrganization() {
		return dataCacheEntry.getSalesOrganization();
	}
	/**
	 * Set accessor for persistent attribute: salesOrganization
	 */
	public void setSalesOrganization(java.lang.String newSalesOrganization) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(20,getSalesOrganization(),newSalesOrganization);
		else
			instanceExtension.markDirty(20);
		dataCacheEntry.setSalesOrganization(newSalesOrganization);
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
			instanceExtension.markDirty(21,getChangedBy(),newChangedBy);
		else
			instanceExtension.markDirty(21);
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
			instanceExtension.markDirty(22,getChangedDate(),newChangedDate);
		else
			instanceExtension.markDirty(22);
		dataCacheEntry.setChangedDate(newChangedDate);
	}
	/**
	 * Get accessor for persistent attribute: expirationDate
	 */
	public java.sql.Date getExpirationDate() {
		return dataCacheEntry.getExpirationDate();
	}
	/**
	 * Set accessor for persistent attribute: expirationDate
	 */
	public void setExpirationDate(java.sql.Date newExpirationDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(23,getExpirationDate(),newExpirationDate);
		else
			instanceExtension.markDirty(23);
		dataCacheEntry.setExpirationDate(newExpirationDate);
	}
	/**
	 * Get accessor for persistent attribute: inac
	 */
	public java.lang.String getInac() {
		return dataCacheEntry.getInac();
	}
	/**
	 * Set accessor for persistent attribute: inac
	 */
	public void setInac(java.lang.String newInac) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(24,getInac(),newInac);
		else
			instanceExtension.markDirty(24);
		dataCacheEntry.setInac(newInac);
	}
	/**
	 * Get accessor for persistent attribute: legacyCustomerNumber
	 */
	public java.lang.String getLegacyCustomerNumber() {
		return dataCacheEntry.getLegacyCustomerNumber();
	}
	/**
	 * Set accessor for persistent attribute: legacyCustomerNumber
	 */
	public void setLegacyCustomerNumber(java.lang.String newLegacyCustomerNumber) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(25,getLegacyCustomerNumber(),newLegacyCustomerNumber);
		else
			instanceExtension.markDirty(25);
		dataCacheEntry.setLegacyCustomerNumber(newLegacyCustomerNumber);
	}
	/**
	 * Get accessor for persistent attribute: legalContactHdr
	 */
	public java.lang.String getLegalContactHdr() {
		return dataCacheEntry.getLegalContactHdr();
	}
	/**
	 * Set accessor for persistent attribute: legalContactHdr
	 */
	public void setLegalContactHdr(java.lang.String newLegalContactHdr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(26,getLegalContactHdr(),newLegalContactHdr);
		else
			instanceExtension.markDirty(26);
		dataCacheEntry.setLegalContactHdr(newLegalContactHdr);
	}
	/**
	 * Get accessor for persistent attribute: accountingContactHdr
	 */
	public java.lang.String getAccountingContactHdr() {
		return dataCacheEntry.getAccountingContactHdr();
	}
	/**
	 * Set accessor for persistent attribute: accountingContactHdr
	 */
	public void setAccountingContactHdr(java.lang.String newAccountingContactHdr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(27,getAccountingContactHdr(),newAccountingContactHdr);
		else
			instanceExtension.markDirty(27);
		dataCacheEntry.setAccountingContactHdr(newAccountingContactHdr);
	}
}

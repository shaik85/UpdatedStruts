package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementModificationTypeBeanCacheEntry_56acdccc;

/**
 * Bean implementation class for Enterprise Bean: BaseAgreementModificationType
 */
public class ConcreteBaseAgreementModificationType_56acdccc extends com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BaseAgreementModificationTypeBeanCacheEntry_56acdccc dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBaseAgreementModificationType_56acdccc
	 */
	public ConcreteBaseAgreementModificationType_56acdccc() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementModificationTypeBeanInjector_56acdccc getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementModificationTypeBeanInjector_56acdccc)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementModificationTypeBeanCacheEntry_56acdccc) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindBySalesOrganisation_Local
	 */
	public java.util.Collection ejbFindBySalesOrganisation_Local(java.lang.String salesOrganization) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindBySalesOrganisation");
		getInjector().ejbFindBySalesOrganisation(salesOrganization, record);
		return (java.util.Collection) instanceExtension.executeFind("FindBySalesOrganisation", record);
	}
	/**
	 * ejbFindExistModificationType_Local
	 */
	public java.util.Collection ejbFindExistModificationType_Local(java.lang.String salesOrganization, java.lang.String modificationTypeCode) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindExistModificationType");
		getInjector().ejbFindExistModificationType(salesOrganization, modificationTypeCode, record);
		return (java.util.Collection) instanceExtension.executeFind("FindExistModificationType", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey ejbCreate(java.lang.String modificationTypeCode, java.lang.String salesOrganization) throws javax.ejb.CreateException {
		dataCacheEntry = (BaseAgreementModificationTypeBeanCacheEntry_56acdccc) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(modificationTypeCode, salesOrganization);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String modificationTypeCode, java.lang.String salesOrganization) throws javax.ejb.CreateException {
		super.ejbPostCreate(modificationTypeCode, salesOrganization);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey();
		pk.modificationTypeCode = getModificationTypeCode();
		pk.salesOrganization = getSalesOrganization();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 3;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
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
			instanceExtension.markDirty(0,getModificationTypeCode(),newModificationTypeCode);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setModificationTypeCode(newModificationTypeCode);
	}
	/**
	 * Get accessor for persistent attribute: modificationTypeDescription
	 */
	public java.lang.String getModificationTypeDescription() {
		return dataCacheEntry.getModificationTypeDescription();
	}
	/**
	 * Set accessor for persistent attribute: modificationTypeDescription
	 */
	public void setModificationTypeDescription(java.lang.String newModificationTypeDescription) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getModificationTypeDescription(),newModificationTypeDescription);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setModificationTypeDescription(newModificationTypeDescription);
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
			instanceExtension.markDirty(2,getSalesOrganization(),newSalesOrganization);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setSalesOrganization(newSalesOrganization);
	}
}

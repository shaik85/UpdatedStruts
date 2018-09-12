package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementFormBeanCacheEntry_5d3cd1d7;

/**
 * Bean implementation class for Enterprise Bean: BaseAgreementForm
 */
public class ConcreteBaseAgreementForm_5d3cd1d7 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BaseAgreementFormBeanCacheEntry_5d3cd1d7 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBaseAgreementForm_5d3cd1d7
	 */
	public ConcreteBaseAgreementForm_5d3cd1d7() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementFormBeanInjector_5d3cd1d7 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementFormBeanInjector_5d3cd1d7)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementFormBeanCacheEntry_5d3cd1d7) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllForm_Local
	 */
	public java.util.Collection ejbFindAllForm_Local(java.lang.String salesOrganization) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindAllForm");
		getInjector().ejbFindAllForm(salesOrganization, record);
		return (java.util.Collection) instanceExtension.executeFind("FindAllForm", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey ejbCreate(java.lang.String formNumber, java.lang.String salesOrganization) throws javax.ejb.CreateException {
		dataCacheEntry = (BaseAgreementFormBeanCacheEntry_5d3cd1d7) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(formNumber, salesOrganization);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String formNumber, java.lang.String salesOrganization) throws javax.ejb.CreateException {
		super.ejbPostCreate(formNumber, salesOrganization);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey();
		pk.formNumber = getFormNumber();
		pk.salesOrganization = getSalesOrganization();
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
			instanceExtension.markDirty(0,getFormNumber(),newFormNumber);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setFormNumber(newFormNumber);
	}
	/**
	 * Get accessor for persistent attribute: formShortDescription
	 */
	public java.lang.String getFormShortDescription() {
		return dataCacheEntry.getFormShortDescription();
	}
	/**
	 * Set accessor for persistent attribute: formShortDescription
	 */
	public void setFormShortDescription(java.lang.String newFormShortDescription) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getFormShortDescription(),newFormShortDescription);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setFormShortDescription(newFormShortDescription);
	}
	/**
	 * Get accessor for persistent attribute: formLongDescription
	 */
	public java.lang.String getFormLongDescription() {
		return dataCacheEntry.getFormLongDescription();
	}
	/**
	 * Set accessor for persistent attribute: formLongDescription
	 */
	public void setFormLongDescription(java.lang.String newFormLongDescription) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getFormLongDescription(),newFormLongDescription);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setFormLongDescription(newFormLongDescription);
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
			instanceExtension.markDirty(3,getSalesOrganization(),newSalesOrganization);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setSalesOrganization(newSalesOrganization);
	}
}

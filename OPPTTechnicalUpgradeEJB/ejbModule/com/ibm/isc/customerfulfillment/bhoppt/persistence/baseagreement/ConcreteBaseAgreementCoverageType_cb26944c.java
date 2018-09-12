package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementCoverageTypeBeanCacheEntry_cb26944c;

/**
 * Bean implementation class for Enterprise Bean: BaseAgreementCoverageType
 */
public class ConcreteBaseAgreementCoverageType_cb26944c extends com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private BaseAgreementCoverageTypeBeanCacheEntry_cb26944c dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteBaseAgreementCoverageType_cb26944c
	 */
	public ConcreteBaseAgreementCoverageType_cb26944c() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementCoverageTypeBeanInjector_cb26944c getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementCoverageTypeBeanInjector_cb26944c)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementCoverageTypeBeanCacheEntry_cb26944c) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey ejbCreate(java.lang.String coverageType) throws javax.ejb.CreateException {
		dataCacheEntry = (BaseAgreementCoverageTypeBeanCacheEntry_cb26944c) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(coverageType);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String coverageType) throws javax.ejb.CreateException {
		super.ejbPostCreate(coverageType);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey();
		pk.coverageType = getCoverageType();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 2;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
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
			instanceExtension.markDirty(0,getCoverageType(),newCoverageType);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCoverageType(newCoverageType);
	}
	/**
	 * Get accessor for persistent attribute: coverageTypeDescription
	 */
	public java.lang.String getCoverageTypeDescription() {
		return dataCacheEntry.getCoverageTypeDescription();
	}
	/**
	 * Set accessor for persistent attribute: coverageTypeDescription
	 */
	public void setCoverageTypeDescription(java.lang.String newCoverageTypeDescription) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getCoverageTypeDescription(),newCoverageTypeDescription);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setCoverageTypeDescription(newCoverageTypeDescription);
	}
}

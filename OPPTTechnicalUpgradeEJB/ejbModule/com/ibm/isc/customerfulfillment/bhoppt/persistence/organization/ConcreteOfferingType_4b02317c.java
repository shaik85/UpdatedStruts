package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.OfferingTypeBeanCacheEntry_4b02317c;

/**
 * Bean implementation class for Enterprise Bean: OfferingType
 */
public class ConcreteOfferingType_4b02317c extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private OfferingTypeBeanCacheEntry_4b02317c dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteOfferingType_4b02317c
	 */
	public ConcreteOfferingType_4b02317c() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.OfferingTypeBeanInjector_4b02317c getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.OfferingTypeBeanInjector_4b02317c)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.OfferingTypeBeanCacheEntry_4b02317c) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllOfferingType_Local
	 */
	public java.util.Collection ejbFindAllOfferingType_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllOfferingType", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey ejbCreate(java.lang.String offeringType, java.lang.String offeringDesc) throws javax.ejb.CreateException {
		dataCacheEntry = (OfferingTypeBeanCacheEntry_4b02317c) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(offeringType, offeringDesc);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String offeringType, java.lang.String offeringDesc) throws javax.ejb.CreateException {
		super.ejbPostCreate(offeringType, offeringDesc);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey();
		pk.offeringDesc = getOfferingDesc();
		pk.offeringType = getOfferingType();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 6;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: offeringType
	 */
	public java.lang.String getOfferingType() {
		return dataCacheEntry.getOfferingType();
	}
	/**
	 * Set accessor for persistent attribute: offeringType
	 */
	public void setOfferingType(java.lang.String newOfferingType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getOfferingType(),newOfferingType);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setOfferingType(newOfferingType);
	}
	/**
	 * Get accessor for persistent attribute: offeringDesc
	 */
	public java.lang.String getOfferingDesc() {
		return dataCacheEntry.getOfferingDesc();
	}
	/**
	 * Set accessor for persistent attribute: offeringDesc
	 */
	public void setOfferingDesc(java.lang.String newOfferingDesc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getOfferingDesc(),newOfferingDesc);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setOfferingDesc(newOfferingDesc);
	}
	/**
	 * Get accessor for persistent attribute: tvmAllowed
	 */
	public java.lang.String getTvmAllowed() {
		return dataCacheEntry.getTvmAllowed();
	}
	/**
	 * Set accessor for persistent attribute: tvmAllowed
	 */
	public void setTvmAllowed(java.lang.String newTvmAllowed) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getTvmAllowed(),newTvmAllowed);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setTvmAllowed(newTvmAllowed);
	}
	/**
	 * Get accessor for persistent attribute: specialRateInd
	 */
	public java.lang.String getSpecialRateInd() {
		return dataCacheEntry.getSpecialRateInd();
	}
	/**
	 * Set accessor for persistent attribute: specialRateInd
	 */
	public void setSpecialRateInd(java.lang.String newSpecialRateInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getSpecialRateInd(),newSpecialRateInd);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setSpecialRateInd(newSpecialRateInd);
	}
	/**
	 * Get accessor for persistent attribute: annivContractAmtInd
	 */
	public java.lang.String getAnnivContractAmtInd() {
		return dataCacheEntry.getAnnivContractAmtInd();
	}
	/**
	 * Set accessor for persistent attribute: annivContractAmtInd
	 */
	public void setAnnivContractAmtInd(java.lang.String newAnnivContractAmtInd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getAnnivContractAmtInd(),newAnnivContractAmtInd);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setAnnivContractAmtInd(newAnnivContractAmtInd);
	}
	/**
	 * Get accessor for persistent attribute: duration
	 */
	public int getDuration() {
		return dataCacheEntry.getDuration();
	}
	/**
	 * Set accessor for persistent attribute: duration
	 */
	public void setDuration(int newDuration) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getDuration(),newDuration);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setDuration(newDuration);
	}
}

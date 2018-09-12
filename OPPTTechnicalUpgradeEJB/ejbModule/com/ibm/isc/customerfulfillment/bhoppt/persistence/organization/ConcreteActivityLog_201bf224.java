package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.ActivityLogBeanCacheEntry_201bf224;

/**
 * Bean implementation class for Enterprise Bean: ActivityLog
 */
public class ConcreteActivityLog_201bf224 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private ActivityLogBeanCacheEntry_201bf224 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteActivityLog_201bf224
	 */
	public ConcreteActivityLog_201bf224() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.ActivityLogBeanInjector_201bf224 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.ActivityLogBeanInjector_201bf224)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.ActivityLogBeanCacheEntry_201bf224) inRecord;
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey ejbFindByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey primaryKey) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllActivities_Local
	 */
	public java.util.Collection ejbFindAllActivities_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllActivities", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey ejbFindByPrimaryKeyForCMR_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey pk) throws javax.ejb.FinderException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey ejbCreate(java.lang.String userId, java.sql.Date activityDate, java.sql.Time activityTime) throws javax.ejb.CreateException {
		dataCacheEntry = (ActivityLogBeanCacheEntry_201bf224) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(userId, activityDate, activityTime);
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String userId, java.sql.Date activityDate, java.sql.Time activityTime) throws javax.ejb.CreateException {
		super.ejbPostCreate(userId, activityDate, activityTime);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey pk = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey();
		pk.activityTime = getActivityTime();
		pk.activityDate = getActivityDate();
		pk.userId = getUserId();
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
	 * Get accessor for persistent attribute: activityDate
	 */
	public java.sql.Date getActivityDate() {
		return dataCacheEntry.getActivityDate();
	}
	/**
	 * Set accessor for persistent attribute: activityDate
	 */
	public void setActivityDate(java.sql.Date newActivityDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getActivityDate(),newActivityDate);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setActivityDate(newActivityDate);
	}
	/**
	 * Get accessor for persistent attribute: activityTime
	 */
	public java.sql.Time getActivityTime() {
		return dataCacheEntry.getActivityTime();
	}
	/**
	 * Set accessor for persistent attribute: activityTime
	 */
	public void setActivityTime(java.sql.Time newActivityTime) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getActivityTime(),newActivityTime);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setActivityTime(newActivityTime);
	}
	/**
	 * Get accessor for persistent attribute: message
	 */
	public java.lang.String getMessage() {
		return dataCacheEntry.getMessage();
	}
	/**
	 * Set accessor for persistent attribute: message
	 */
	public void setMessage(java.lang.String newMessage) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getMessage(),newMessage);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setMessage(newMessage);
	}
	/**
	 * Get accessor for persistent attribute: userId
	 */
	public java.lang.String getUserId() {
		return dataCacheEntry.getUserId();
	}
	/**
	 * Set accessor for persistent attribute: userId
	 */
	public void setUserId(java.lang.String newUserId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getUserId(),newUserId);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setUserId(newUserId);
	}
}

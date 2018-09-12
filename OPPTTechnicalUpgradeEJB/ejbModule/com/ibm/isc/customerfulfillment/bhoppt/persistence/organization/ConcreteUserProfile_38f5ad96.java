package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.UserProfileBeanCacheEntry_38f5ad96;

/**
 * Bean implementation class for Enterprise Bean: UserProfile
 */
public class ConcreteUserProfile_38f5ad96 extends com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserProfileBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private UserProfileBeanCacheEntry_38f5ad96 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteUserProfile_38f5ad96
	 */
	public ConcreteUserProfile_38f5ad96() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.UserProfileBeanInjector_38f5ad96 getInjector() {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.UserProfileBeanInjector_38f5ad96)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.UserProfileBeanCacheEntry_38f5ad96) inRecord;
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
	public java.lang.String ejbFindByPrimaryKey(java.lang.String primaryKey) throws javax.ejb.FinderException {
		return (java.lang.String)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllForSalesOrgAndRole_Local
	 */
	public java.util.Collection ejbFindAllForSalesOrgAndRole_Local(java.lang.String salesOrg, java.lang.String role) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindAllForSalesOrgAndRole");
		getInjector().ejbFindAllForSalesOrgAndRole(salesOrg, role, record);
		return (java.util.Collection) instanceExtension.executeFind("FindAllForSalesOrgAndRole", record);
	}
	/**
	 * ejbFindByGroupName_Local
	 */
	public java.util.Collection ejbFindByGroupName_Local(java.lang.String groupName) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByGroupName");
		getInjector().ejbFindByGroupName(groupName, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByGroupName", record);
	}
	/**
	 * ejbFindByRole_Local
	 */
	public java.util.Collection ejbFindByRole_Local(java.lang.String userid1, java.lang.String userid2) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByRole");
		getInjector().ejbFindByRole(userid1, userid2, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByRole", record);
	}
	/**
	 * ejbFindBySalesOrg_Local
	 */
	public java.util.Collection ejbFindBySalesOrg_Local(java.lang.String salesOrg) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindBySalesOrg");
		getInjector().ejbFindBySalesOrg(salesOrg, record);
		return (java.util.Collection) instanceExtension.executeFind("FindBySalesOrg", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((java.lang.String)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public java.lang.String ejbFindByPrimaryKeyForCMR_Local(java.lang.String pk) throws javax.ejb.FinderException {
		return (java.lang.String)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public java.lang.String ejbCreate(java.lang.String userId, java.lang.String role) throws javax.ejb.CreateException {
		dataCacheEntry = (UserProfileBeanCacheEntry_38f5ad96) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(userId, role);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String userId, java.lang.String role) throws javax.ejb.CreateException {
		super.ejbPostCreate(userId, role);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getUserId();
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 12;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
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
			instanceExtension.markDirty(0,getUserId(),newUserId);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setUserId(newUserId);
	}
	/**
	 * Get accessor for persistent attribute: role
	 */
	public java.lang.String getRole() {
		return dataCacheEntry.getRole();
	}
	/**
	 * Set accessor for persistent attribute: role
	 */
	public void setRole(java.lang.String newRole) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getRole(),newRole);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setRole(newRole);
	}
	/**
	 * Get accessor for persistent attribute: assoSalesOrg
	 */
	public java.lang.String getAssoSalesOrg() {
		return dataCacheEntry.getAssoSalesOrg();
	}
	/**
	 * Set accessor for persistent attribute: assoSalesOrg
	 */
	public void setAssoSalesOrg(java.lang.String newAssoSalesOrg) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getAssoSalesOrg(),newAssoSalesOrg);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setAssoSalesOrg(newAssoSalesOrg);
	}
	/**
	 * Get accessor for persistent attribute: authorization
	 */
	public java.lang.String getAuthorization() {
		return dataCacheEntry.getAuthorization();
	}
	/**
	 * Set accessor for persistent attribute: authorization
	 */
	public void setAuthorization(java.lang.String newAuthorization) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getAuthorization(),newAuthorization);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setAuthorization(newAuthorization);
	}
	/**
	 * Get accessor for persistent attribute: approverId
	 */
	public java.lang.String getApproverId() {
		return dataCacheEntry.getApproverId();
	}
	/**
	 * Set accessor for persistent attribute: approverId
	 */
	public void setApproverId(java.lang.String newApproverId) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getApproverId(),newApproverId);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setApproverId(newApproverId);
	}
	/**
	 * Get accessor for persistent attribute: groupName
	 */
	public java.lang.String getGroupName() {
		return dataCacheEntry.getGroupName();
	}
	/**
	 * Set accessor for persistent attribute: groupName
	 */
	public void setGroupName(java.lang.String newGroupName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getGroupName(),newGroupName);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setGroupName(newGroupName);
	}
	/**
	 * Get accessor for persistent attribute: bpAccessIndicator
	 */
	public java.lang.String getBpAccessIndicator() {
		return dataCacheEntry.getBpAccessIndicator();
	}
	/**
	 * Set accessor for persistent attribute: bpAccessIndicator
	 */
	public void setBpAccessIndicator(java.lang.String newBpAccessIndicator) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getBpAccessIndicator(),newBpAccessIndicator);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setBpAccessIndicator(newBpAccessIndicator);
	}
	/**
	 * Get accessor for persistent attribute: lastLoginDate
	 */
	public java.sql.Date getLastLoginDate() {
		return dataCacheEntry.getLastLoginDate();
	}
	/**
	 * Set accessor for persistent attribute: lastLoginDate
	 */
	public void setLastLoginDate(java.sql.Date newLastLoginDate) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getLastLoginDate(),newLastLoginDate);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setLastLoginDate(newLastLoginDate);
	}
	/**
	 * Get accessor for persistent attribute: firstName
	 */
	public java.lang.String getFirstName() {
		return dataCacheEntry.getFirstName();
	}
	/**
	 * Set accessor for persistent attribute: firstName
	 */
	public void setFirstName(java.lang.String newFirstName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getFirstName(),newFirstName);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setFirstName(newFirstName);
	}
	/**
	 * Get accessor for persistent attribute: lastName
	 */
	public java.lang.String getLastName() {
		return dataCacheEntry.getLastName();
	}
	/**
	 * Set accessor for persistent attribute: lastName
	 */
	public void setLastName(java.lang.String newLastName) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getLastName(),newLastName);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setLastName(newLastName);
	}
	/**
	 * Get accessor for persistent attribute: baRole
	 */
	public java.lang.String getBaRole() {
		return dataCacheEntry.getBaRole();
	}
	/**
	 * Set accessor for persistent attribute: baRole
	 */
	public void setBaRole(java.lang.String newBaRole) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getBaRole(),newBaRole);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setBaRole(newBaRole);
	}
	/**
	 * Get accessor for persistent attribute: userType
	 */
	public java.lang.String getUserType() {
		return dataCacheEntry.getUserType();
	}
	/**
	 * Set accessor for persistent attribute: userType
	 */
	public void setUserType(java.lang.String newUserType) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getUserType(),newUserType);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setUserType(newUserType);
	}
}

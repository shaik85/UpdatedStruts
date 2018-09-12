package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * UserProfileBeanInjectorImpl_38f5ad96
 */
public class UserProfileBeanInjectorImpl_38f5ad96 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.UserProfileBeanInjector_38f5ad96 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getRole());
		record.set(2,concreteBean.getAssoSalesOrg());
		record.set(3,concreteBean.getAuthorization());
		record.set(4,concreteBean.getApproverId());
		record.set(5,concreteBean.getGroupName());
		record.set(6,concreteBean.getBpAccessIndicator());
		record.set(7,concreteBean.getLastLoginDate());
		record.set(8,concreteBean.getFirstName());
		record.set(9,concreteBean.getLastName());
		record.set(10,concreteBean.getBaRole());
		record.set(11,concreteBean.getUserType());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getRole());
		record.set(2,concreteBean.getAssoSalesOrg());
		record.set(3,concreteBean.getAuthorization());
		record.set(4,concreteBean.getApproverId());
		record.set(5,concreteBean.getGroupName());
		record.set(6,concreteBean.getBpAccessIndicator());
		record.set(7,concreteBean.getLastLoginDate());
		record.set(8,concreteBean.getFirstName());
		record.set(9,concreteBean.getLastName());
		record.set(10,concreteBean.getBaRole());
		record.set(11,concreteBean.getUserType());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96)cb;
		record.set(0,concreteBean.getUserId());
	}
	/**
	 * ejbFindAllForSalesOrgAndRole
	 */
	public void ejbFindAllForSalesOrgAndRole(java.lang.String salesOrg, java.lang.String role, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesOrg);
		record.set(1,role);
	}
	/**
	 * ejbFindBySalesOrg
	 */
	public void ejbFindBySalesOrg(java.lang.String salesOrg, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesOrg);
	}
	/**
	 * ejbFindByGroupName
	 */
	public void ejbFindByGroupName(java.lang.String groupName, javax.resource.cci.IndexedRecord record) {
		record.set(0,groupName);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		java.lang.String pkey=(java.lang.String)pkeyObject;
		record.set(0,pkey);
	}
	/**
	 * ejbFindByRole
	 */
	public void ejbFindByRole(java.lang.String userid1, java.lang.String userid2, javax.resource.cci.IndexedRecord record) {
		record.set(0,userid1);
		record.set(1,userid2);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96)cb;
		record.set(0,concreteBean.getUserId());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getUserId());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getRole());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getAssoSalesOrg());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getAuthorization());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getApproverId());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getGroupName());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getBpAccessIndicator());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getLastLoginDate());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getFirstName());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getLastName());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getBaRole());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getUserType());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

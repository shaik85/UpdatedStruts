package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: UserProfile
 */
public interface UserProfileBeanInjector_38f5ad96 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindAllForSalesOrgAndRole
	 */
	public void ejbFindAllForSalesOrgAndRole(java.lang.String salesOrg, java.lang.String role, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByGroupName
	 */
	public void ejbFindByGroupName(java.lang.String groupName, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByRole
	 */
	public void ejbFindByRole(java.lang.String userid1, java.lang.String userid2, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindBySalesOrg
	 */
	public void ejbFindBySalesOrg(java.lang.String salesOrg, javax.resource.cci.IndexedRecord record);
}

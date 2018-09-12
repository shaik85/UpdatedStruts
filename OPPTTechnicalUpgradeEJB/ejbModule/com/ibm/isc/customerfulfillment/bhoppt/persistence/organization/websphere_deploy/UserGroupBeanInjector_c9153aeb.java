package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: UserGroup
 */
public interface UserGroupBeanInjector_c9153aeb extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByGroup
	 */
	public void ejbFindByGroup(java.lang.String groupName, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByUser
	 */
	public void ejbFindByUser(java.lang.String userId, javax.resource.cci.IndexedRecord record);
}

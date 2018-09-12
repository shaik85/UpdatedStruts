package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Group
 */
public interface GroupBeanInjector_e8523fb7 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByGroupName
	 */
	public void ejbFindByGroupName(java.lang.String groupName, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindBySalesOrg
	 */
	public void ejbFindBySalesOrg(java.lang.String salesOrg, javax.resource.cci.IndexedRecord record);
}

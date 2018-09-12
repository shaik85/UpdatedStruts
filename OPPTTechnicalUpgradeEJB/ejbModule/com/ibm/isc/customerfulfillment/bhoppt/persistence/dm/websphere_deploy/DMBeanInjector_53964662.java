package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: DM
 */
public interface DMBeanInjector_53964662 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByCustomer
	 */
	public void ejbFindByCustomer(int customerId, int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByDMNo
	 */
	public void ejbFindByDMNo(java.lang.String dmNo, int proposalId, int customerId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByProposal
	 */
	public void ejbFindByProposal(int proposalId, javax.resource.cci.IndexedRecord record);
}

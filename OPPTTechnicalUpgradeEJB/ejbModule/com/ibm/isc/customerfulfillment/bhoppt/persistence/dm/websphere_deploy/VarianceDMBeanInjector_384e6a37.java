package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: VarianceDM
 */
public interface VarianceDMBeanInjector_384e6a37 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByCustomer
	 */
	public void ejbFindByCustomer(int proposalId, int customerId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByDMNo
	 */
	public void ejbFindByDMNo(java.lang.String dmNo, int proposalId, int customerId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByProposal
	 */
	public void ejbFindByProposal(int proposalID, javax.resource.cci.IndexedRecord record);
}

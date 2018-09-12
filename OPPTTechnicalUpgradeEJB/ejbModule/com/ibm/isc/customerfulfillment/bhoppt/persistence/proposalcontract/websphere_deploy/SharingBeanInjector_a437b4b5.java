package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Sharing
 */
public interface SharingBeanInjector_a437b4b5 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByProposalAndAccess
	 */
	public void ejbFindByProposalAndAccess(int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByProposalId
	 */
	public void ejbFindByProposalId(int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByUser
	 */
	public void ejbFindByUser(java.lang.String userId, javax.resource.cci.IndexedRecord record);
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: AccessHistory
 */
public interface AccessHistoryBeanInjector_1c91e0cb extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByProposalID
	 */
	public void ejbFindByProposalID(int proposalID, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByProposalIDAndUserID
	 */
	public void ejbFindByProposalIDAndUserID(int proposalId, java.lang.String userId, javax.resource.cci.IndexedRecord record);
}

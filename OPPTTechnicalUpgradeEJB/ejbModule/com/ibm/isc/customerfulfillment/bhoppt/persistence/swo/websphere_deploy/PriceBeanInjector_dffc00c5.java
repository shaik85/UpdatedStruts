package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Price
 */
public interface PriceBeanInjector_dffc00c5 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByEE
	 */
	public void ejbFindByEE(int eeId, int swoId, int dmId, int customerId, int proposalId, javax.resource.cci.IndexedRecord record);
}

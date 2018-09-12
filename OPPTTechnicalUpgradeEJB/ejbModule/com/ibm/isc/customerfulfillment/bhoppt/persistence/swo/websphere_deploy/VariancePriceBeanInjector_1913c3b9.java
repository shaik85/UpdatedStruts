package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: VariancePrice
 */
public interface VariancePriceBeanInjector_1913c3b9 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByEE
	 */
	public void ejbFindByEE(int eeId, int swoid, int dmid, int custometId, int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByEEForVariance
	 */
	public void ejbFindByEEForVariance(int eeId, int swoid, int dmid, int custometId, int proposalId, javax.resource.cci.IndexedRecord record);
}

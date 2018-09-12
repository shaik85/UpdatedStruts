package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: VarianceSWO
 */
public interface VarianceSWOBeanInjector_c577a175 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByDM
	 */
	public void ejbFindByDM(int dmID, int customerId, int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByEquipmentNo
	 */
	public void ejbFindByEquipmentNo(java.lang.String equipmentNo, int proposalId, javax.resource.cci.IndexedRecord record);
}

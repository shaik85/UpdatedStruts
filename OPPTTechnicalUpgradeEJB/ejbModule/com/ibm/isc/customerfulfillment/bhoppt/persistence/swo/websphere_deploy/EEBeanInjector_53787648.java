package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: EE
 */
public interface EEBeanInjector_53787648 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByEENoSalesDocEEItemSwoItem
	 */
	public void ejbFindByEENoSalesDocEEItemSwoItem(int proposalId, java.lang.String eeNo, java.lang.String salesDocNo, java.lang.String eeItemNo, java.lang.String swoItemNo, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByProposal
	 */
	public void ejbFindByProposal(int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindBySWO
	 */
	public void ejbFindBySWO(int swoId, int dmId, int customerId, int proposalId, javax.resource.cci.IndexedRecord record);
}

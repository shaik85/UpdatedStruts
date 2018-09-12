package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Customer
 */
public interface CustomerBeanInjector_20fed8a5 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindBySapCustNo
	 */
	public void ejbFindBySapCustNo(int proposalId, java.lang.String sapCustomerNo, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindBySapCustNoAndPlanStartEndDate
	 */
	public void ejbFindBySapCustNoAndPlanStartEndDate(int proposalId, java.lang.String sapCustomerNo, java.sql.Date planStartDate, java.sql.Date planEndDate, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByProposal
	 */
	public void ejbFindByProposal(int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByProposalAndCustomerList
	 */
	public void ejbFindByProposalAndCustomerList(int proposalId, java.lang.String customerListNo, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByProposalStartEndDate
	 */
	public void ejbFindByProposalStartEndDate(int proposalId, java.sql.Date planStartDate, java.sql.Date planEndDate, javax.resource.cci.IndexedRecord record);
}

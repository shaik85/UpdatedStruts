package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: SWO
 */
public interface SWOBeanInjector_05de4b81 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByEquimentAndSalesDocNo
	 */
	public void ejbFindByEquimentAndSalesDocNo(java.lang.String equipmentNo, java.lang.String salesDocNo, int proposalID, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindMaxSquenceNo
	 */
	public void ejbFindMaxSquenceNo(java.lang.String salesDocNo, java.lang.String swoItemNo, int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByCustomer
	 */
	public void ejbFindByCustomer(int proposalId, int customerId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByDM
	 */
	public void ejbFindByDM(int dmId, int customerId, int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByEquipSoldToPartyDM
	 */
	public void ejbFindByEquipSoldToPartyDM(java.lang.String equipmentNo, int proposalId, int customerId, int dmId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByEquipmentNo
	 */
	public void ejbFindByEquipmentNo(java.lang.String equipmentNo, int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByExtContrNumber
	 */
	public void ejbFindByExtContrNumber(int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByProposal
	 */
	public void ejbFindByProposal(int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByQuotes
	 */
	public void ejbFindByQuotes(java.lang.String salesDocNo, int proposalId, java.lang.String swoItemNo, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByQuotesSoldToPartyDM
	 */
	public void ejbFindByQuotesSoldToPartyDM(java.lang.String salesDocNo, int proposalId, java.lang.String swoItemNo, int customerId, int dmId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindBySWONoSalesDocSwoItemNo
	 */
	public void ejbFindBySWONoSalesDocSwoItemNo(int proposalId, java.lang.String swoNo, java.lang.String salesDocNo, java.lang.String swoItemNo, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindBySalesDocNo
	 */
	public void ejbFindBySalesDocNo(java.lang.String salesDocNo, int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindBySandSIndicator
	 */
	public void ejbFindBySandSIndicator(int proposalId, java.lang.String indicator, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindBySwoNoSerialNo
	 */
	public void ejbFindBySwoNoSerialNo(int proposalId, java.lang.String swoNo, java.lang.String serialNo, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindExcludedLicenses
	 */
	public void ejbFindExcludedLicenses(int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindMaxBumpInd
	 */
	public void ejbFindMaxBumpInd(java.lang.String salesDocNo, java.lang.String swoItemNo, int proposalId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindSVCLicenseForProposal
	 */
	public void ejbFindSVCLicenseForProposal(int proposalId, java.lang.String itemCategory, javax.resource.cci.IndexedRecord record);
}

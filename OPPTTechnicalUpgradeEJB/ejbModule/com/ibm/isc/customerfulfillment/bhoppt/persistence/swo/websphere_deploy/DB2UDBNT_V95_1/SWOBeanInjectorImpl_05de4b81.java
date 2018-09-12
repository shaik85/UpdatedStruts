package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * SWOBeanInjectorImpl_05de4b81
 */
public class SWOBeanInjectorImpl_05de4b81 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.SWOBeanInjector_05de4b81 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81)cb;
		record.set(0,new Integer(concreteBean.getSwoId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getCustomerId()));
		record.set(3,new Integer(concreteBean.getProposalId()));
		record.set(4,concreteBean.getLockedInd());
		record.set(5,concreteBean.getDeltaFetchId());
		record.set(6,new Double(concreteBean.getAdjustmentAmount()));
		record.set(7,concreteBean.getLastUpdatedDate());
		record.set(8,concreteBean.getExclusionId());
		record.set(9,concreteBean.getBumpInd());
		record.set(10,concreteBean.getAmendStartDate());
		record.set(11,concreteBean.getSwoNo());
		record.set(12,new Double(concreteBean.getOldCalcPrice()));
		record.set(13,concreteBean.getAmendInd());
		record.set(14,new Double(concreteBean.getEswPrice()));
		record.set(15,concreteBean.getPlannedInd());
		record.set(16,concreteBean.getAlternatePriceInd());
		record.set(17,concreteBean.getReferenceSerialNoDM());
		record.set(18,concreteBean.getReferenceSerialNo());
		record.set(19,new Double(concreteBean.getAlternatePrice()));
		record.set(20,new Double(concreteBean.getCalcPrice()));
		record.set(21,concreteBean.getCustomerPONo());
		record.set(22,concreteBean.getPlanStartDate());
		record.set(23,concreteBean.getItemCategory());
		record.set(24,new Integer(concreteBean.getSequenceNo()));
		record.set(25,concreteBean.getEquipmentNo());
		record.set(26,concreteBean.getSwoItemNo());
		record.set(27,concreteBean.getSalesDocNo());
		record.set(28,concreteBean.getSwoDesc());
		record.set(29,concreteBean.getPlanEndDate());
		record.set(30,concreteBean.getRequestDeliveryDate());
		record.set(31,concreteBean.getDuplicateDeletedInd());
		record.set(32,concreteBean.getSandsIndicator());
		record.set(33,concreteBean.getSerialNo());
		record.set(34,concreteBean.getAmendEndDate());
		record.set(35,concreteBean.getSwoAddedDate());
		record.set(36,concreteBean.getRefetchId());
		record.set(37,concreteBean.getSwoExtContrNo());
		record.set(38,concreteBean.getSwoContrStatus());
		record.set(39,concreteBean.getSwoContrType());
		record.set(40,concreteBean.getAlternatePriceUpdateInd());
		record.set(41,concreteBean.getPlanDateInd());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81)cb;
		record.set(0,new Integer(concreteBean.getSwoId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getCustomerId()));
		record.set(3,new Integer(concreteBean.getProposalId()));
		record.set(4,concreteBean.getLockedInd());
		record.set(5,concreteBean.getDeltaFetchId());
		record.set(6,new Double(concreteBean.getAdjustmentAmount()));
		record.set(7,concreteBean.getLastUpdatedDate());
		record.set(8,concreteBean.getExclusionId());
		record.set(9,concreteBean.getBumpInd());
		record.set(10,concreteBean.getAmendStartDate());
		record.set(11,concreteBean.getSwoNo());
		record.set(12,new Double(concreteBean.getOldCalcPrice()));
		record.set(13,concreteBean.getAmendInd());
		record.set(14,new Double(concreteBean.getEswPrice()));
		record.set(15,concreteBean.getPlannedInd());
		record.set(16,concreteBean.getAlternatePriceInd());
		record.set(17,concreteBean.getReferenceSerialNoDM());
		record.set(18,concreteBean.getReferenceSerialNo());
		record.set(19,new Double(concreteBean.getAlternatePrice()));
		record.set(20,new Double(concreteBean.getCalcPrice()));
		record.set(21,concreteBean.getCustomerPONo());
		record.set(22,concreteBean.getPlanStartDate());
		record.set(23,concreteBean.getItemCategory());
		record.set(24,new Integer(concreteBean.getSequenceNo()));
		record.set(25,concreteBean.getEquipmentNo());
		record.set(26,concreteBean.getSwoItemNo());
		record.set(27,concreteBean.getSalesDocNo());
		record.set(28,concreteBean.getSwoDesc());
		record.set(29,concreteBean.getPlanEndDate());
		record.set(30,concreteBean.getRequestDeliveryDate());
		record.set(31,concreteBean.getDuplicateDeletedInd());
		record.set(32,concreteBean.getSandsIndicator());
		record.set(33,concreteBean.getSerialNo());
		record.set(34,concreteBean.getAmendEndDate());
		record.set(35,concreteBean.getSwoAddedDate());
		record.set(36,concreteBean.getRefetchId());
		record.set(37,concreteBean.getSwoExtContrNo());
		record.set(38,concreteBean.getSwoContrStatus());
		record.set(39,concreteBean.getSwoContrType());
		record.set(40,concreteBean.getAlternatePriceUpdateInd());
		record.set(41,concreteBean.getPlanDateInd());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81)cb;
		record.set(0,new Integer(concreteBean.getSwoId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getCustomerId()));
		record.set(3,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbFindSVCLicenseForProposal
	 */
	public void ejbFindSVCLicenseForProposal(int proposalId, java.lang.String itemCategory, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
		record.set(1,itemCategory);
	}
	/**
	 * ejbFindByProposal
	 */
	public void ejbFindByProposal(int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
	}
	/**
	 * ejbFindByQuotes
	 */
	public void ejbFindByQuotes(java.lang.String salesDocNo, int proposalId, java.lang.String swoItemNo, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesDocNo);
		record.set(1,new Integer(proposalId));
		record.set(2,swoItemNo);
	}
	/**
	 * ejbFindByDM
	 */
	public void ejbFindByDM(int dmId, int customerId, int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(dmId));
		record.set(1,new Integer(customerId));
		record.set(2,new Integer(proposalId));
	}
	/**
	 * ejbFindMaxBumpInd
	 */
	public void ejbFindMaxBumpInd(java.lang.String salesDocNo, java.lang.String swoItemNo, int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesDocNo);
		record.set(3,salesDocNo);
		record.set(1,swoItemNo);
		record.set(4,swoItemNo);
		record.set(2,new Integer(proposalId));
		record.set(5,new Integer(proposalId));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey)pkeyObject;
		record.set(0,new Integer(pkey.swoId));
		record.set(1,new Integer(pkey.dmId));
		record.set(2,new Integer(pkey.customerId));
		record.set(3,new Integer(pkey.proposalId));
	}
	/**
	 * ejbFindByQuotesSoldToPartyDM
	 */
	public void ejbFindByQuotesSoldToPartyDM(java.lang.String salesDocNo, int proposalId, java.lang.String swoItemNo, int customerId, int dmId, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesDocNo);
		record.set(1,new Integer(proposalId));
		record.set(2,swoItemNo);
		record.set(3,new Integer(customerId));
		record.set(4,new Integer(dmId));
	}
	/**
	 * ejbFindMaxSquenceNo
	 */
	public void ejbFindMaxSquenceNo(java.lang.String salesDocNo, java.lang.String swoItemNo, int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesDocNo);
		record.set(3,salesDocNo);
		record.set(1,swoItemNo);
		record.set(4,swoItemNo);
		record.set(2,new Integer(proposalId));
		record.set(5,new Integer(proposalId));
	}
	/**
	 * ejbFindByExtContrNumber
	 */
	public void ejbFindByExtContrNumber(int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
	}
	/**
	 * ejbFindByEquimentAndSalesDocNo
	 */
	public void ejbFindByEquimentAndSalesDocNo(java.lang.String equipmentNo, java.lang.String salesDocNo, int proposalID, javax.resource.cci.IndexedRecord record) {
		record.set(0,equipmentNo);
		record.set(1,salesDocNo);
		record.set(2,new Integer(proposalID));
	}
	/**
	 * ejbFindExcludedLicenses
	 */
	public void ejbFindExcludedLicenses(int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
	}
	/**
	 * ejbFindBySandSIndicator
	 */
	public void ejbFindBySandSIndicator(int proposalId, java.lang.String indicator, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
		record.set(1,indicator);
	}
	/**
	 * ejbFindByCustomer
	 */
	public void ejbFindByCustomer(int proposalId, int customerId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
		record.set(1,new Integer(customerId));
	}
	/**
	 * ejbFindBySwoNoSerialNo
	 */
	public void ejbFindBySwoNoSerialNo(int proposalId, java.lang.String swoNo, java.lang.String serialNo, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
		record.set(1,swoNo);
		record.set(2,serialNo);
	}
	/**
	 * ejbFindByEquipSoldToPartyDM
	 */
	public void ejbFindByEquipSoldToPartyDM(java.lang.String equipmentNo, int proposalId, int customerId, int dmId, javax.resource.cci.IndexedRecord record) {
		record.set(0,equipmentNo);
		record.set(1,new Integer(proposalId));
		record.set(2,new Integer(customerId));
		record.set(3,new Integer(dmId));
	}
	/**
	 * ejbFindBySWONoSalesDocSwoItemNo
	 */
	public void ejbFindBySWONoSalesDocSwoItemNo(int proposalId, java.lang.String swoNo, java.lang.String salesDocNo, java.lang.String swoItemNo, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
		record.set(1,swoNo);
		record.set(2,salesDocNo);
		record.set(3,swoItemNo);
	}
	/**
	 * ejbFindBySalesDocNo
	 */
	public void ejbFindBySalesDocNo(java.lang.String salesDocNo, int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesDocNo);
		record.set(1,new Integer(proposalId));
	}
	/**
	 * ejbFindByEquipmentNo
	 */
	public void ejbFindByEquipmentNo(java.lang.String equipmentNo, int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,equipmentNo);
		record.set(1,new Integer(proposalId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81)cb;
		record.set(0,new Integer(concreteBean.getSwoId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getCustomerId()));
		record.set(3,new Integer(concreteBean.getProposalId()));
		record.set(4,new Double(concreteBean.getAdjustmentAmount()));
		record.set(5,new Double(concreteBean.getOldCalcPrice()));
		record.set(6,new Double(concreteBean.getEswPrice()));
		record.set(7,new Double(concreteBean.getAlternatePrice()));
		record.set(8,new Double(concreteBean.getCalcPrice()));
		record.set(9,new Integer(concreteBean.getSequenceNo()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getSwoId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getCustomerId()));
		record.set(3,new Integer(concreteBean.getProposalId()));
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getLockedInd());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getDeltaFetchId());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,new Double(concreteBean.getAdjustmentAmount()));
		}
		if(instanceExtension.isDirty(20))
		{
			record.set(7,concreteBean.getLastUpdatedDate());
		}
		if(instanceExtension.isDirty(18))
		{
			record.set(8,concreteBean.getExclusionId());
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(9,concreteBean.getBumpInd());
		}
		if(instanceExtension.isDirty(16))
		{
			record.set(10,concreteBean.getAmendStartDate());
		}
		if(instanceExtension.isDirty(19))
		{
			record.set(11,concreteBean.getSwoNo());
		}
		if(instanceExtension.isDirty(21))
		{
			record.set(12,new Double(concreteBean.getOldCalcPrice()));
		}
		if(instanceExtension.isDirty(17))
		{
			record.set(13,concreteBean.getAmendInd());
		}
		if(instanceExtension.isDirty(22))
		{
			record.set(14,new Double(concreteBean.getEswPrice()));
		}
		if(instanceExtension.isDirty(23))
		{
			record.set(15,concreteBean.getPlannedInd());
		}
		if(instanceExtension.isDirty(24))
		{
			record.set(16,concreteBean.getAlternatePriceInd());
		}
		if(instanceExtension.isDirty(26))
		{
			record.set(17,concreteBean.getReferenceSerialNoDM());
		}
		if(instanceExtension.isDirty(25))
		{
			record.set(18,concreteBean.getReferenceSerialNo());
		}
		if(instanceExtension.isDirty(27))
		{
			record.set(19,new Double(concreteBean.getAlternatePrice()));
		}
		if(instanceExtension.isDirty(28))
		{
			record.set(20,new Double(concreteBean.getCalcPrice()));
		}
		if(instanceExtension.isDirty(36))
		{
			record.set(21,concreteBean.getCustomerPONo());
		}
		if(instanceExtension.isDirty(35))
		{
			record.set(22,concreteBean.getPlanStartDate());
		}
		if(instanceExtension.isDirty(34))
		{
			record.set(23,concreteBean.getItemCategory());
		}
		if(instanceExtension.isDirty(33))
		{
			record.set(24,new Integer(concreteBean.getSequenceNo()));
		}
		if(instanceExtension.isDirty(32))
		{
			record.set(25,concreteBean.getEquipmentNo());
		}
		if(instanceExtension.isDirty(31))
		{
			record.set(26,concreteBean.getSwoItemNo());
		}
		if(instanceExtension.isDirty(30))
		{
			record.set(27,concreteBean.getSalesDocNo());
		}
		if(instanceExtension.isDirty(29))
		{
			record.set(28,concreteBean.getSwoDesc());
		}
		if(instanceExtension.isDirty(37))
		{
			record.set(29,concreteBean.getPlanEndDate());
		}
		if(instanceExtension.isDirty(39))
		{
			record.set(30,concreteBean.getRequestDeliveryDate());
		}
		if(instanceExtension.isDirty(41))
		{
			record.set(31,concreteBean.getDuplicateDeletedInd());
		}
		if(instanceExtension.isDirty(40))
		{
			record.set(32,concreteBean.getSandsIndicator());
		}
		if(instanceExtension.isDirty(38))
		{
			record.set(33,concreteBean.getSerialNo());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(34,concreteBean.getAmendEndDate());
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(35,concreteBean.getSwoAddedDate());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(36,concreteBean.getRefetchId());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(37,concreteBean.getSwoExtContrNo());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(38,concreteBean.getSwoContrStatus());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(39,concreteBean.getSwoContrType());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(40,concreteBean.getAlternatePriceUpdateInd());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(41,concreteBean.getPlanDateInd());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

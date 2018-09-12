package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * HistorySWOBeanInjectorImpl_2fe0d772
 */
public class HistorySWOBeanInjectorImpl_2fe0d772 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.HistorySWOBeanInjector_2fe0d772 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
		record.set(4,concreteBean.getRequestDeliveryDate());
		record.set(5,concreteBean.getSerialNo());
		record.set(6,concreteBean.getPlanEndDate());
		record.set(7,concreteBean.getCustomerPONo());
		record.set(8,concreteBean.getPlanStartDate());
		record.set(9,concreteBean.getItemCategory());
		record.set(10,new Integer(concreteBean.getSequenceNo()));
		record.set(11,concreteBean.getEquipmentNo());
		record.set(12,concreteBean.getSwoItemNo());
		record.set(13,concreteBean.getSalesDocNo());
		record.set(14,concreteBean.getSwoDesc());
		record.set(15,new Double(concreteBean.getCalcPrice()));
		record.set(16,new Double(concreteBean.getAlternatePrice()));
		record.set(17,concreteBean.getReferenceSerialNoDM());
		record.set(18,concreteBean.getReferenceSerialNo());
		record.set(19,concreteBean.getAlternatePriceInd());
		record.set(20,concreteBean.getPlannedInd());
		record.set(21,new Double(concreteBean.getEswPrice()));
		record.set(22,new Double(concreteBean.getOldCalcPrice()));
		record.set(23,concreteBean.getLastUpdatedDate());
		record.set(24,concreteBean.getSwoNo());
		record.set(25,concreteBean.getExclusionId());
		record.set(26,concreteBean.getAmendInd());
		record.set(27,concreteBean.getAmendStartDate());
		record.set(28,concreteBean.getBumpInd());
		record.set(29,concreteBean.getSwoAddedDate());
		record.set(30,concreteBean.getRefetchId());
		record.set(31,concreteBean.getAmendEndDate());
		record.set(32,concreteBean.getSwoExtContrNo());
		record.set(33,concreteBean.getSwoContrStatus());
		record.set(34,concreteBean.getSwoContrType());
		record.set(35,new Double(concreteBean.getAdjustmentAmount()));
		record.set(36,concreteBean.getDeltaFetchId());
		record.set(37,concreteBean.getSandsIndicator());
		record.set(38,concreteBean.getLockedInd());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
		record.set(4,concreteBean.getRequestDeliveryDate());
		record.set(5,concreteBean.getSerialNo());
		record.set(6,concreteBean.getPlanEndDate());
		record.set(7,concreteBean.getCustomerPONo());
		record.set(8,concreteBean.getPlanStartDate());
		record.set(9,concreteBean.getItemCategory());
		record.set(10,new Integer(concreteBean.getSequenceNo()));
		record.set(11,concreteBean.getEquipmentNo());
		record.set(12,concreteBean.getSwoItemNo());
		record.set(13,concreteBean.getSalesDocNo());
		record.set(14,concreteBean.getSwoDesc());
		record.set(15,new Double(concreteBean.getCalcPrice()));
		record.set(16,new Double(concreteBean.getAlternatePrice()));
		record.set(17,concreteBean.getReferenceSerialNoDM());
		record.set(18,concreteBean.getReferenceSerialNo());
		record.set(19,concreteBean.getAlternatePriceInd());
		record.set(20,concreteBean.getPlannedInd());
		record.set(21,new Double(concreteBean.getEswPrice()));
		record.set(22,new Double(concreteBean.getOldCalcPrice()));
		record.set(23,concreteBean.getLastUpdatedDate());
		record.set(24,concreteBean.getSwoNo());
		record.set(25,concreteBean.getExclusionId());
		record.set(26,concreteBean.getAmendInd());
		record.set(27,concreteBean.getAmendStartDate());
		record.set(28,concreteBean.getBumpInd());
		record.set(29,concreteBean.getSwoAddedDate());
		record.set(30,concreteBean.getRefetchId());
		record.set(31,concreteBean.getAmendEndDate());
		record.set(32,concreteBean.getSwoExtContrNo());
		record.set(33,concreteBean.getSwoContrStatus());
		record.set(34,concreteBean.getSwoContrType());
		record.set(35,new Double(concreteBean.getAdjustmentAmount()));
		record.set(36,concreteBean.getDeltaFetchId());
		record.set(37,concreteBean.getSandsIndicator());
		record.set(38,concreteBean.getLockedInd());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOKey)pkeyObject;
		record.set(0,new Integer(pkey.swoId));
		record.set(1,new Integer(pkey.dmId));
		record.set(2,new Integer(pkey.customerId));
		record.set(3,new Integer(pkey.proposalId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772)cb;
		record.set(0,new Integer(concreteBean.getSwoId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getCustomerId()));
		record.set(3,new Integer(concreteBean.getProposalId()));
		record.set(4,new Integer(concreteBean.getSequenceNo()));
		record.set(5,new Double(concreteBean.getCalcPrice()));
		record.set(6,new Double(concreteBean.getAlternatePrice()));
		record.set(7,new Double(concreteBean.getEswPrice()));
		record.set(8,new Double(concreteBean.getOldCalcPrice()));
		record.set(9,new Double(concreteBean.getAdjustmentAmount()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getRequestDeliveryDate());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getSerialNo());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getPlanEndDate());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getCustomerPONo());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getPlanStartDate());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getItemCategory());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,new Integer(concreteBean.getSequenceNo()));
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getEquipmentNo());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(12,concreteBean.getSwoItemNo());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(13,concreteBean.getSalesDocNo());
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(14,concreteBean.getSwoDesc());
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(15,new Double(concreteBean.getCalcPrice()));
		}
		if(instanceExtension.isDirty(16))
		{
			record.set(16,new Double(concreteBean.getAlternatePrice()));
		}
		if(instanceExtension.isDirty(17))
		{
			record.set(17,concreteBean.getReferenceSerialNoDM());
		}
		if(instanceExtension.isDirty(18))
		{
			record.set(18,concreteBean.getReferenceSerialNo());
		}
		if(instanceExtension.isDirty(19))
		{
			record.set(19,concreteBean.getAlternatePriceInd());
		}
		if(instanceExtension.isDirty(20))
		{
			record.set(20,concreteBean.getPlannedInd());
		}
		if(instanceExtension.isDirty(21))
		{
			record.set(21,new Double(concreteBean.getEswPrice()));
		}
		if(instanceExtension.isDirty(22))
		{
			record.set(22,new Double(concreteBean.getOldCalcPrice()));
		}
		if(instanceExtension.isDirty(23))
		{
			record.set(23,concreteBean.getLastUpdatedDate());
		}
		if(instanceExtension.isDirty(24))
		{
			record.set(24,concreteBean.getSwoNo());
		}
		if(instanceExtension.isDirty(25))
		{
			record.set(25,concreteBean.getExclusionId());
		}
		if(instanceExtension.isDirty(26))
		{
			record.set(26,concreteBean.getAmendInd());
		}
		if(instanceExtension.isDirty(27))
		{
			record.set(27,concreteBean.getAmendStartDate());
		}
		if(instanceExtension.isDirty(28))
		{
			record.set(28,concreteBean.getBumpInd());
		}
		if(instanceExtension.isDirty(29))
		{
			record.set(29,concreteBean.getSwoAddedDate());
		}
		if(instanceExtension.isDirty(30))
		{
			record.set(30,concreteBean.getRefetchId());
		}
		if(instanceExtension.isDirty(31))
		{
			record.set(31,concreteBean.getAmendEndDate());
		}
		if(instanceExtension.isDirty(32))
		{
			record.set(32,concreteBean.getSwoExtContrNo());
		}
		if(instanceExtension.isDirty(33))
		{
			record.set(33,concreteBean.getSwoContrStatus());
		}
		if(instanceExtension.isDirty(34))
		{
			record.set(34,concreteBean.getSwoContrType());
		}
		if(instanceExtension.isDirty(35))
		{
			record.set(35,new Double(concreteBean.getAdjustmentAmount()));
		}
		if(instanceExtension.isDirty(36))
		{
			record.set(36,concreteBean.getDeltaFetchId());
		}
		if(instanceExtension.isDirty(38))
		{
			record.set(37,concreteBean.getSandsIndicator());
		}
		if(instanceExtension.isDirty(37))
		{
			record.set(38,concreteBean.getLockedInd());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

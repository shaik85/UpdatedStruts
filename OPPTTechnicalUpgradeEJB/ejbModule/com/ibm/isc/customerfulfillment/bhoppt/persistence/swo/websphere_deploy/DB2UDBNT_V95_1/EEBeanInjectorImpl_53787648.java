package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * EEBeanInjectorImpl_53787648
 */
public class EEBeanInjectorImpl_53787648 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.EEBeanInjector_53787648 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648)cb;
		record.set(0,new Integer(concreteBean.getEeId()));
		record.set(1,new Integer(concreteBean.getSwoId()));
		record.set(2,new Integer(concreteBean.getDmId()));
		record.set(3,new Integer(concreteBean.getCustomerId()));
		record.set(4,new Integer(concreteBean.getProposalId()));
		record.set(5,concreteBean.getSalesDocNo());
		record.set(6,concreteBean.getEeItemNo());
		record.set(7,concreteBean.getSwoItemNo());
		record.set(8,concreteBean.getEeNo());
		record.set(9,concreteBean.getEeDesc());
		record.set(10,concreteBean.getPlanStartDate());
		record.set(11,concreteBean.getPlanEndDate());
		record.set(12,concreteBean.getReqstDeliveryDate());
		record.set(13,concreteBean.getValueMetric());
		record.set(14,concreteBean.getUseLevel());
		record.set(15,concreteBean.getLicenseType());
		record.set(16,new Double(concreteBean.getEswPrice()));
		record.set(17,new Double(concreteBean.getCalculatedPrice()));
		record.set(18,new Double(concreteBean.getAlternatePrice()));
		record.set(19,concreteBean.getBillingStartDate());
		record.set(20,concreteBean.getBillingEndDate());
		record.set(21,concreteBean.getExclusionId());
		record.set(22,new Integer(concreteBean.getSequenceNo()));
		record.set(23,concreteBean.getBumpId());
		record.set(24,concreteBean.getChargeOption());
		record.set(25,concreteBean.getChargeOptionDesc());
		record.set(26,concreteBean.getAlternatePriceUpdateInd());
		record.set(27,new Double(concreteBean.getListPrice()));
		record.set(28,concreteBean.getPletNo());
		record.set(29,new Double(concreteBean.getSAndSDiscountPercent()));
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648)cb;
		record.set(0,new Integer(concreteBean.getEeId()));
		record.set(1,new Integer(concreteBean.getSwoId()));
		record.set(2,new Integer(concreteBean.getDmId()));
		record.set(3,new Integer(concreteBean.getCustomerId()));
		record.set(4,new Integer(concreteBean.getProposalId()));
		record.set(5,concreteBean.getSalesDocNo());
		record.set(6,concreteBean.getEeItemNo());
		record.set(7,concreteBean.getSwoItemNo());
		record.set(8,concreteBean.getEeNo());
		record.set(9,concreteBean.getEeDesc());
		record.set(10,concreteBean.getPlanStartDate());
		record.set(11,concreteBean.getPlanEndDate());
		record.set(12,concreteBean.getReqstDeliveryDate());
		record.set(13,concreteBean.getValueMetric());
		record.set(14,concreteBean.getUseLevel());
		record.set(15,concreteBean.getLicenseType());
		record.set(16,new Double(concreteBean.getEswPrice()));
		record.set(17,new Double(concreteBean.getCalculatedPrice()));
		record.set(18,new Double(concreteBean.getAlternatePrice()));
		record.set(19,concreteBean.getBillingStartDate());
		record.set(20,concreteBean.getBillingEndDate());
		record.set(21,concreteBean.getExclusionId());
		record.set(22,new Integer(concreteBean.getSequenceNo()));
		record.set(23,concreteBean.getBumpId());
		record.set(24,concreteBean.getChargeOption());
		record.set(25,concreteBean.getChargeOptionDesc());
		record.set(26,concreteBean.getAlternatePriceUpdateInd());
		record.set(27,new Double(concreteBean.getListPrice()));
		record.set(28,concreteBean.getPletNo());
		record.set(29,new Double(concreteBean.getSAndSDiscountPercent()));
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648)cb;
		record.set(0,new Integer(concreteBean.getEeId()));
		record.set(1,new Integer(concreteBean.getSwoId()));
		record.set(2,new Integer(concreteBean.getDmId()));
		record.set(3,new Integer(concreteBean.getCustomerId()));
		record.set(4,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbFindByProposal
	 */
	public void ejbFindByProposal(int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
	}
	/**
	 * ejbFindByEENoSalesDocEEItemSwoItem
	 */
	public void ejbFindByEENoSalesDocEEItemSwoItem(int proposalId, java.lang.String eeNo, java.lang.String salesDocNo, java.lang.String eeItemNo, java.lang.String swoItemNo, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
		record.set(1,eeNo);
		record.set(2,salesDocNo);
		record.set(3,eeItemNo);
		record.set(4,swoItemNo);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EEKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EEKey)pkeyObject;
		record.set(0,new Integer(pkey.eeId));
		record.set(1,new Integer(pkey.swoId));
		record.set(2,new Integer(pkey.dmId));
		record.set(3,new Integer(pkey.customerId));
		record.set(4,new Integer(pkey.proposalId));
	}
	/**
	 * ejbFindBySWO
	 */
	public void ejbFindBySWO(int swoId, int dmId, int customerId, int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(swoId));
		record.set(1,new Integer(dmId));
		record.set(2,new Integer(customerId));
		record.set(3,new Integer(proposalId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648)cb;
		record.set(0,new Integer(concreteBean.getEeId()));
		record.set(1,new Integer(concreteBean.getSwoId()));
		record.set(2,new Integer(concreteBean.getDmId()));
		record.set(3,new Integer(concreteBean.getCustomerId()));
		record.set(4,new Integer(concreteBean.getProposalId()));
		record.set(5,new Double(concreteBean.getEswPrice()));
		record.set(6,new Double(concreteBean.getCalculatedPrice()));
		record.set(7,new Double(concreteBean.getAlternatePrice()));
		record.set(8,new Integer(concreteBean.getSequenceNo()));
		record.set(9,new Double(concreteBean.getListPrice()));
		record.set(10,new Double(concreteBean.getSAndSDiscountPercent()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getEeId()));
		record.set(1,new Integer(concreteBean.getSwoId()));
		record.set(2,new Integer(concreteBean.getDmId()));
		record.set(3,new Integer(concreteBean.getCustomerId()));
		record.set(4,new Integer(concreteBean.getProposalId()));
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getSalesDocNo());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getEeItemNo());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getSwoItemNo());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getEeNo());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getEeDesc());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getPlanStartDate());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getPlanEndDate());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(12,concreteBean.getReqstDeliveryDate());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(13,concreteBean.getValueMetric());
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(14,concreteBean.getUseLevel());
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(15,concreteBean.getLicenseType());
		}
		if(instanceExtension.isDirty(16))
		{
			record.set(16,new Double(concreteBean.getEswPrice()));
		}
		if(instanceExtension.isDirty(17))
		{
			record.set(17,new Double(concreteBean.getCalculatedPrice()));
		}
		if(instanceExtension.isDirty(18))
		{
			record.set(18,new Double(concreteBean.getAlternatePrice()));
		}
		if(instanceExtension.isDirty(19))
		{
			record.set(19,concreteBean.getBillingStartDate());
		}
		if(instanceExtension.isDirty(20))
		{
			record.set(20,concreteBean.getBillingEndDate());
		}
		if(instanceExtension.isDirty(21))
		{
			record.set(21,concreteBean.getExclusionId());
		}
		if(instanceExtension.isDirty(22))
		{
			record.set(22,new Integer(concreteBean.getSequenceNo()));
		}
		if(instanceExtension.isDirty(23))
		{
			record.set(23,concreteBean.getBumpId());
		}
		if(instanceExtension.isDirty(24))
		{
			record.set(24,concreteBean.getChargeOption());
		}
		if(instanceExtension.isDirty(25))
		{
			record.set(25,concreteBean.getChargeOptionDesc());
		}
		if(instanceExtension.isDirty(26))
		{
			record.set(26,concreteBean.getAlternatePriceUpdateInd());
		}
		if(instanceExtension.isDirty(27))
		{
			record.set(27,new Double(concreteBean.getListPrice()));
		}
		if(instanceExtension.isDirty(28))
		{
			record.set(28,concreteBean.getPletNo());
		}
		if(instanceExtension.isDirty(29))
		{
			record.set(29,new Double(concreteBean.getSAndSDiscountPercent()));
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

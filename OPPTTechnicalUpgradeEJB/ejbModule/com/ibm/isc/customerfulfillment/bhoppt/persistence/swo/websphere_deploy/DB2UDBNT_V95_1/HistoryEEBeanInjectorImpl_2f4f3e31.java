package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * HistoryEEBeanInjectorImpl_2f4f3e31
 */
public class HistoryEEBeanInjectorImpl_2f4f3e31 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.HistoryEEBeanInjector_2f4f3e31 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31)cb;
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
		record.set(24,concreteBean.getChargeOptionDesc());
		record.set(25,concreteBean.getAlternatePriceId());
		record.set(26,concreteBean.getPriceEffectiveDate());
		record.set(27,new Double(concreteBean.getSandsdiscountpercent()));
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31)cb;
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
		record.set(24,concreteBean.getChargeOptionDesc());
		record.set(25,concreteBean.getAlternatePriceId());
		record.set(26,concreteBean.getPriceEffectiveDate());
		record.set(27,new Double(concreteBean.getSandsdiscountpercent()));
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31)cb;
		record.set(0,new Integer(concreteBean.getEeId()));
		record.set(1,new Integer(concreteBean.getSwoId()));
		record.set(2,new Integer(concreteBean.getDmId()));
		record.set(3,new Integer(concreteBean.getCustomerId()));
		record.set(4,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey)pkeyObject;
		record.set(0,new Integer(pkey.eeId));
		record.set(1,new Integer(pkey.swoId));
		record.set(2,new Integer(pkey.dmId));
		record.set(3,new Integer(pkey.customerId));
		record.set(4,new Integer(pkey.proposalId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31)cb;
		record.set(0,new Integer(concreteBean.getEeId()));
		record.set(1,new Integer(concreteBean.getSwoId()));
		record.set(2,new Integer(concreteBean.getDmId()));
		record.set(3,new Integer(concreteBean.getCustomerId()));
		record.set(4,new Integer(concreteBean.getProposalId()));
		record.set(5,new Double(concreteBean.getEswPrice()));
		record.set(6,new Double(concreteBean.getCalculatedPrice()));
		record.set(7,new Double(concreteBean.getAlternatePrice()));
		record.set(8,new Integer(concreteBean.getSequenceNo()));
		record.set(9,new Double(concreteBean.getSandsdiscountpercent()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31)cb;
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
			record.set(24,concreteBean.getChargeOptionDesc());
		}
		if(instanceExtension.isDirty(25))
		{
			record.set(25,concreteBean.getAlternatePriceId());
		}
		if(instanceExtension.isDirty(26))
		{
			record.set(26,concreteBean.getPriceEffectiveDate());
		}
		if(instanceExtension.isDirty(27))
		{
			record.set(27,new Double(concreteBean.getSandsdiscountpercent()));
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

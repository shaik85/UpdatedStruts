package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * PriceBeanInjectorImpl_dffc00c5
 */
public class PriceBeanInjectorImpl_dffc00c5 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.PriceBeanInjector_dffc00c5 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5)cb;
		record.set(0,new Integer(concreteBean.getPriceId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,new Integer(concreteBean.getEeId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
		record.set(4,new Integer(concreteBean.getDmId()));
		record.set(5,new Integer(concreteBean.getCustomerId()));
		record.set(6,concreteBean.getSalesDocNo());
		record.set(7,concreteBean.getEeItemNo());
		record.set(8,concreteBean.getBillPlanStartDate());
		record.set(9,concreteBean.getBillPlanEndDate());
		record.set(10,new Double(concreteBean.getEswPrice()));
		record.set(11,concreteBean.getCurrency());
		record.set(12,concreteBean.getExclusionId());
		record.set(13,concreteBean.getBillingStatus());
		record.set(14,concreteBean.getMonthId());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5)cb;
		record.set(0,new Integer(concreteBean.getPriceId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,new Integer(concreteBean.getEeId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
		record.set(4,new Integer(concreteBean.getDmId()));
		record.set(5,new Integer(concreteBean.getCustomerId()));
		record.set(6,concreteBean.getSalesDocNo());
		record.set(7,concreteBean.getEeItemNo());
		record.set(8,concreteBean.getBillPlanStartDate());
		record.set(9,concreteBean.getBillPlanEndDate());
		record.set(10,new Double(concreteBean.getEswPrice()));
		record.set(11,concreteBean.getCurrency());
		record.set(12,concreteBean.getExclusionId());
		record.set(13,concreteBean.getBillingStatus());
		record.set(14,concreteBean.getMonthId());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5)cb;
		record.set(0,new Integer(concreteBean.getPriceId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,new Integer(concreteBean.getEeId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
		record.set(4,new Integer(concreteBean.getDmId()));
		record.set(5,new Integer(concreteBean.getCustomerId()));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey)pkeyObject;
		record.set(0,new Integer(pkey.priceId));
		record.set(1,new Integer(pkey.eeId));
		record.set(2,new Integer(pkey.swoId));
		record.set(3,new Integer(pkey.dmId));
		record.set(4,new Integer(pkey.customerId));
		record.set(5,new Integer(pkey.proposalId));
	}
	/**
	 * ejbFindByEE
	 */
	public void ejbFindByEE(int eeId, int swoId, int dmId, int customerId, int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(eeId));
		record.set(1,new Integer(swoId));
		record.set(2,new Integer(dmId));
		record.set(3,new Integer(customerId));
		record.set(4,new Integer(proposalId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5)cb;
		record.set(0,new Integer(concreteBean.getPriceId()));
		record.set(1,new Integer(concreteBean.getEeId()));
		record.set(2,new Integer(concreteBean.getSwoId()));
		record.set(3,new Integer(concreteBean.getDmId()));
		record.set(4,new Integer(concreteBean.getCustomerId()));
		record.set(5,new Integer(concreteBean.getProposalId()));
		record.set(6,new Double(concreteBean.getEswPrice()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getPriceId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,new Integer(concreteBean.getEeId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
		record.set(4,new Integer(concreteBean.getDmId()));
		record.set(5,new Integer(concreteBean.getCustomerId()));
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getSalesDocNo());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getEeItemNo());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getBillPlanStartDate());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getBillPlanEndDate());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,new Double(concreteBean.getEswPrice()));
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getCurrency());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(12,concreteBean.getExclusionId());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(13,concreteBean.getBillingStatus());
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(14,concreteBean.getMonthId());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * VariancePriceBeanInjectorImpl_1913c3b9
 */
public class VariancePriceBeanInjectorImpl_1913c3b9 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VariancePriceBeanInjector_1913c3b9 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getEeId()));
		record.set(3,new Integer(concreteBean.getPriceId()));
		record.set(4,new Integer(concreteBean.getProposalId()));
		record.set(5,new Integer(concreteBean.getSwoId()));
		record.set(6,concreteBean.getSalesDocNo());
		record.set(7,concreteBean.getEeItemNo());
		record.set(8,concreteBean.getBillPlanStartDate());
		record.set(9,concreteBean.getBillPlanEndDate());
		record.set(10,new Double(concreteBean.getEswPrice()));
		record.set(11,concreteBean.getCurrency());
		record.set(12,concreteBean.getIndicator());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getEeId()));
		record.set(3,new Integer(concreteBean.getPriceId()));
		record.set(4,new Integer(concreteBean.getProposalId()));
		record.set(5,new Integer(concreteBean.getSwoId()));
		record.set(6,concreteBean.getSalesDocNo());
		record.set(7,concreteBean.getEeItemNo());
		record.set(8,concreteBean.getBillPlanStartDate());
		record.set(9,concreteBean.getBillPlanEndDate());
		record.set(10,new Double(concreteBean.getEswPrice()));
		record.set(11,concreteBean.getCurrency());
		record.set(12,concreteBean.getIndicator());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getEeId()));
		record.set(3,new Integer(concreteBean.getPriceId()));
		record.set(4,new Integer(concreteBean.getProposalId()));
		record.set(5,new Integer(concreteBean.getSwoId()));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey)pkeyObject;
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
	public void ejbFindByEE(int eeId, int swoid, int dmid, int custometId, int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(eeId));
		record.set(5,new Integer(eeId));
		record.set(1,new Integer(swoid));
		record.set(6,new Integer(swoid));
		record.set(2,new Integer(dmid));
		record.set(7,new Integer(dmid));
		record.set(3,new Integer(custometId));
		record.set(8,new Integer(custometId));
		record.set(4,new Integer(proposalId));
		record.set(9,new Integer(proposalId));
	}
	/**
	 * ejbFindByEEForVariance
	 */
	public void ejbFindByEEForVariance(int eeId, int swoid, int dmid, int custometId, int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(eeId));
		record.set(5,new Integer(eeId));
		record.set(1,new Integer(swoid));
		record.set(6,new Integer(swoid));
		record.set(2,new Integer(dmid));
		record.set(7,new Integer(dmid));
		record.set(3,new Integer(custometId));
		record.set(8,new Integer(custometId));
		record.set(4,new Integer(proposalId));
		record.set(9,new Integer(proposalId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9)cb;
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getEeId()));
		record.set(3,new Integer(concreteBean.getPriceId()));
		record.set(4,new Integer(concreteBean.getProposalId()));
		record.set(5,new Integer(concreteBean.getSwoId()));
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
			record.set(12,concreteBean.getIndicator());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

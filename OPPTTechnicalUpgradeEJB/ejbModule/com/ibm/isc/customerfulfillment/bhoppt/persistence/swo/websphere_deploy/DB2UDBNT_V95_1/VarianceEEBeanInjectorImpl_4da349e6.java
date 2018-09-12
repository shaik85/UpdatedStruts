package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * VarianceEEBeanInjectorImpl_4da349e6
 */
public class VarianceEEBeanInjectorImpl_4da349e6 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VarianceEEBeanInjector_4da349e6 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getEeId()));
		record.set(3,new Integer(concreteBean.getProposalId()));
		record.set(4,new Integer(concreteBean.getSwoId()));
		record.set(5,concreteBean.getSalesDocNo());
		record.set(6,concreteBean.getEeItemNo());
		record.set(7,concreteBean.getSwoItemNo());
		record.set(8,concreteBean.getEeNo());
		record.set(9,concreteBean.getEeDesc());
		record.set(10,concreteBean.getValueMetric());
		record.set(11,concreteBean.getUseLevel());
		record.set(12,concreteBean.getLicenseType());
		record.set(13,new Double(concreteBean.getEswPrice()));
		record.set(14,new Integer(concreteBean.getSequenceNo()));
		record.set(15,concreteBean.getChargeOption());
		record.set(16,concreteBean.getChargeOptionDesc());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getEeId()));
		record.set(3,new Integer(concreteBean.getProposalId()));
		record.set(4,new Integer(concreteBean.getSwoId()));
		record.set(5,concreteBean.getSalesDocNo());
		record.set(6,concreteBean.getEeItemNo());
		record.set(7,concreteBean.getSwoItemNo());
		record.set(8,concreteBean.getEeNo());
		record.set(9,concreteBean.getEeDesc());
		record.set(10,concreteBean.getValueMetric());
		record.set(11,concreteBean.getUseLevel());
		record.set(12,concreteBean.getLicenseType());
		record.set(13,new Double(concreteBean.getEswPrice()));
		record.set(14,new Integer(concreteBean.getSequenceNo()));
		record.set(15,concreteBean.getChargeOption());
		record.set(16,concreteBean.getChargeOptionDesc());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getEeId()));
		record.set(3,new Integer(concreteBean.getProposalId()));
		record.set(4,new Integer(concreteBean.getSwoId()));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey)pkeyObject;
		record.set(0,new Integer(pkey.eeId));
		record.set(1,new Integer(pkey.swoId));
		record.set(2,new Integer(pkey.dmId));
		record.set(3,new Integer(pkey.customerId));
		record.set(4,new Integer(pkey.proposalId));
	}
	/**
	 * ejbFindBySWO
	 */
	public void ejbFindBySWO(int swoid, int dmid, int custometId, int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(swoid));
		record.set(1,new Integer(dmid));
		record.set(2,new Integer(custometId));
		record.set(3,new Integer(proposalId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6)cb;
		record.set(0,new Integer(concreteBean.getEeId()));
		record.set(1,new Integer(concreteBean.getSwoId()));
		record.set(2,new Integer(concreteBean.getDmId()));
		record.set(3,new Integer(concreteBean.getCustomerId()));
		record.set(4,new Integer(concreteBean.getProposalId()));
		record.set(5,new Double(concreteBean.getEswPrice()));
		record.set(6,new Integer(concreteBean.getSequenceNo()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getEeId()));
		record.set(3,new Integer(concreteBean.getProposalId()));
		record.set(4,new Integer(concreteBean.getSwoId()));
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
			record.set(10,concreteBean.getValueMetric());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getUseLevel());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(12,concreteBean.getLicenseType());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(13,new Double(concreteBean.getEswPrice()));
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(14,new Integer(concreteBean.getSequenceNo()));
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(15,concreteBean.getChargeOption());
		}
		if(instanceExtension.isDirty(16))
		{
			record.set(16,concreteBean.getChargeOptionDesc());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

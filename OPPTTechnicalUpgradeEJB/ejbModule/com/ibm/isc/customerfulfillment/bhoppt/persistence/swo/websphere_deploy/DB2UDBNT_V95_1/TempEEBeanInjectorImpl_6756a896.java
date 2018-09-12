package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * TempEEBeanInjectorImpl_6756a896
 */
public class TempEEBeanInjectorImpl_6756a896 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.TempEEBeanInjector_6756a896 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteTempEE_6756a896 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteTempEE_6756a896)cb;
		record.set(0,concreteBean.getSessionId());
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,new Integer(concreteBean.getCustomerId()));
		record.set(3,new Integer(concreteBean.getDmId()));
		record.set(4,new Integer(concreteBean.getSwoId()));
		record.set(5,new Integer(concreteBean.getEeId()));
		record.set(6,concreteBean.getEeNo());
		record.set(7,concreteBean.getSalesDocNo());
		record.set(8,concreteBean.getSwoItemNo());
		record.set(9,concreteBean.getEeItemNo());
		record.set(10,concreteBean.getValueMetric());
		record.set(11,concreteBean.getLicenseType());
		record.set(12,concreteBean.getChargeOptionDesc());
		record.set(13,concreteBean.getUseLevel());
		record.set(14,concreteBean.getValidInd());
		record.set(15,concreteBean.getValueMetricType());
		record.set(16,concreteBean.getVm());
		record.set(17,concreteBean.getLcs());
		record.set(18,concreteBean.getCho());
		record.set(19,concreteBean.getUl());
		record.set(20,concreteBean.getDefaultFlag());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteTempEE_6756a896 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteTempEE_6756a896)cb;
		record.set(0,concreteBean.getSessionId());
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,new Integer(concreteBean.getCustomerId()));
		record.set(3,new Integer(concreteBean.getDmId()));
		record.set(4,new Integer(concreteBean.getSwoId()));
		record.set(5,new Integer(concreteBean.getEeId()));
		record.set(6,concreteBean.getEeNo());
		record.set(7,concreteBean.getSalesDocNo());
		record.set(8,concreteBean.getSwoItemNo());
		record.set(9,concreteBean.getEeItemNo());
		record.set(10,concreteBean.getValueMetric());
		record.set(11,concreteBean.getLicenseType());
		record.set(12,concreteBean.getChargeOptionDesc());
		record.set(13,concreteBean.getUseLevel());
		record.set(14,concreteBean.getValidInd());
		record.set(15,concreteBean.getValueMetricType());
		record.set(16,concreteBean.getVm());
		record.set(17,concreteBean.getLcs());
		record.set(18,concreteBean.getCho());
		record.set(19,concreteBean.getUl());
		record.set(20,concreteBean.getDefaultFlag());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteTempEE_6756a896 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteTempEE_6756a896)cb;
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,new Integer(concreteBean.getCustomerId()));
		record.set(3,new Integer(concreteBean.getDmId()));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey)pkeyObject;
		record.set(0,new Integer(pkey.proposalId));
		record.set(1,new Integer(pkey.customerId));
		record.set(2,new Integer(pkey.dmId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteTempEE_6756a896 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteTempEE_6756a896)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
		record.set(2,new Integer(concreteBean.getDmId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
		record.set(4,new Integer(concreteBean.getEeId()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteTempEE_6756a896 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteTempEE_6756a896)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		if(instanceExtension.isDirty(3))
		{
			record.set(0,concreteBean.getSessionId());
		}
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,new Integer(concreteBean.getCustomerId()));
		record.set(3,new Integer(concreteBean.getDmId()));
		if(instanceExtension.isDirty(4))
		{
			record.set(4,new Integer(concreteBean.getSwoId()));
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,new Integer(concreteBean.getEeId()));
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getEeNo());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getSalesDocNo());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getSwoItemNo());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getEeItemNo());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getValueMetric());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getLicenseType());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(12,concreteBean.getChargeOptionDesc());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(13,concreteBean.getUseLevel());
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(14,concreteBean.getValidInd());
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(15,concreteBean.getValueMetricType());
		}
		if(instanceExtension.isDirty(16))
		{
			record.set(16,concreteBean.getVm());
		}
		if(instanceExtension.isDirty(17))
		{
			record.set(17,concreteBean.getLcs());
		}
		if(instanceExtension.isDirty(18))
		{
			record.set(18,concreteBean.getCho());
		}
		if(instanceExtension.isDirty(19))
		{
			record.set(19,concreteBean.getUl());
		}
		if(instanceExtension.isDirty(20))
		{
			record.set(20,concreteBean.getDefaultFlag());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

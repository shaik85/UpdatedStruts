package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * VarianceSWOBeanInjectorImpl_c577a175
 */
public class VarianceSWOBeanInjectorImpl_c577a175 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VarianceSWOBeanInjector_c577a175 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
		record.set(4,concreteBean.getSwoNo());
		record.set(5,concreteBean.getSalesDocNo());
		record.set(6,concreteBean.getSwoDesc());
		record.set(7,concreteBean.getSwoItemNo());
		record.set(8,new Integer(concreteBean.getSequenceNo()));
		record.set(9,concreteBean.getItemCategory());
		record.set(10,concreteBean.getSerialNo());
		record.set(11,concreteBean.getCustomerPONo());
		record.set(12,concreteBean.getEquipmentNo());
		record.set(13,new Double(concreteBean.getEswPrice()));
		record.set(14,concreteBean.getReferenceSerialNo());
		record.set(15,concreteBean.getReferenceSerialNoDM());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
		record.set(4,concreteBean.getSwoNo());
		record.set(5,concreteBean.getSalesDocNo());
		record.set(6,concreteBean.getSwoDesc());
		record.set(7,concreteBean.getSwoItemNo());
		record.set(8,new Integer(concreteBean.getSequenceNo()));
		record.set(9,concreteBean.getItemCategory());
		record.set(10,concreteBean.getSerialNo());
		record.set(11,concreteBean.getCustomerPONo());
		record.set(12,concreteBean.getEquipmentNo());
		record.set(13,new Double(concreteBean.getEswPrice()));
		record.set(14,concreteBean.getReferenceSerialNo());
		record.set(15,concreteBean.getReferenceSerialNoDM());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
	}
	/**
	 * ejbFindByDM
	 */
	public void ejbFindByDM(int dmID, int customerId, int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(dmID));
		record.set(1,new Integer(customerId));
		record.set(2,new Integer(proposalId));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey)pkeyObject;
		record.set(0,new Integer(pkey.swoId));
		record.set(1,new Integer(pkey.dmId));
		record.set(2,new Integer(pkey.customerId));
		record.set(3,new Integer(pkey.proposalId));
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175)cb;
		record.set(0,new Integer(concreteBean.getSwoId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getCustomerId()));
		record.set(3,new Integer(concreteBean.getProposalId()));
		record.set(4,new Integer(concreteBean.getSequenceNo()));
		record.set(5,new Double(concreteBean.getEswPrice()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,new Integer(concreteBean.getSwoId()));
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getSwoNo());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getSalesDocNo());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getSwoDesc());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getSwoItemNo());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,new Integer(concreteBean.getSequenceNo()));
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getItemCategory());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getSerialNo());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getCustomerPONo());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(12,concreteBean.getEquipmentNo());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(13,new Double(concreteBean.getEswPrice()));
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(14,concreteBean.getReferenceSerialNo());
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(15,concreteBean.getReferenceSerialNoDM());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ErrorListBeanInjectorImpl_889e0b9b
 */
public class ErrorListBeanInjectorImpl_889e0b9b implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ErrorListBeanInjector_889e0b9b {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b)cb;
		record.set(0,concreteBean.getMessageId());
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,new Double(concreteBean.getMessageNO()));
		record.set(3,concreteBean.getClassName());
		record.set(4,concreteBean.getMethodName());
		record.set(5,concreteBean.getMessageDesc());
		record.set(6,concreteBean.getMessageDetail());
		record.set(7,concreteBean.getUserId());
		record.set(8,concreteBean.getDate());
		record.set(9,concreteBean.getTime());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b)cb;
		record.set(0,concreteBean.getMessageId());
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,new Double(concreteBean.getMessageNO()));
		record.set(3,concreteBean.getClassName());
		record.set(4,concreteBean.getMethodName());
		record.set(5,concreteBean.getMessageDesc());
		record.set(6,concreteBean.getMessageDetail());
		record.set(7,concreteBean.getUserId());
		record.set(8,concreteBean.getDate());
		record.set(9,concreteBean.getTime());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b)cb;
		record.set(0,concreteBean.getMessageId());
	}
	/**
	 * ejbFindByProposalId
	 */
	public void ejbFindByProposalId(int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		java.lang.Integer pkey=(java.lang.Integer)pkeyObject;
		record.set(0,pkey);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b)cb;
		record.set(0,concreteBean.getMessageId());
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,new Double(concreteBean.getMessageNO()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getMessageId());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,new Integer(concreteBean.getProposalId()));
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,new Double(concreteBean.getMessageNO()));
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getClassName());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getMethodName());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getMessageDesc());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getMessageDetail());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getUserId());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getDate());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getTime());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

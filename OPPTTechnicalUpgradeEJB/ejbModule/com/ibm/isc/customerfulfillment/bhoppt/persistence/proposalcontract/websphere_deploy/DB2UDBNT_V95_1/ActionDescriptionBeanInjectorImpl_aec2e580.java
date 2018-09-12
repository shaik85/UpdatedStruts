package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ActionDescriptionBeanInjectorImpl_aec2e580
 */
public class ActionDescriptionBeanInjectorImpl_aec2e580 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ActionDescriptionBeanInjector_aec2e580 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteActionDescription_aec2e580 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteActionDescription_aec2e580)cb;
		record.set(0,concreteBean.getDescription());
		record.set(1,concreteBean.getOperationPerformed());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteActionDescription_aec2e580 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteActionDescription_aec2e580)cb;
		record.set(0,concreteBean.getDescription());
		record.set(1,concreteBean.getOperationPerformed());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteActionDescription_aec2e580 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteActionDescription_aec2e580)cb;
		record.set(1,concreteBean.getOperationPerformed());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		java.lang.String pkey=(java.lang.String)pkeyObject;
		record.set(0,pkey);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteActionDescription_aec2e580 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteActionDescription_aec2e580)cb;
		record.set(0,concreteBean.getOperationPerformed());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteActionDescription_aec2e580 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteActionDescription_aec2e580)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		if(instanceExtension.isDirty(0))
		{
			record.set(0,concreteBean.getDescription());
		}
		record.set(1,concreteBean.getOperationPerformed());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

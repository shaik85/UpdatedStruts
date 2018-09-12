package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1;

/**
 * HistoryDMBeanInjectorImpl_73caf94c
 */
public class HistoryDMBeanInjectorImpl_73caf94c implements com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.HistoryDMBeanInjector_73caf94c {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,concreteBean.getDmNo());
		record.set(3,new Integer(concreteBean.getDmId()));
		record.set(4,concreteBean.getDmDesc());
		record.set(5,concreteBean.getPlanStartDate());
		record.set(6,concreteBean.getPlanEndDate());
		record.set(7,concreteBean.getPlannedInd());
		record.set(8,concreteBean.getLastUpdatedDate());
		record.set(9,concreteBean.getDmAddedDate());
		record.set(10,concreteBean.getExclusionId());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,concreteBean.getDmNo());
		record.set(3,new Integer(concreteBean.getDmId()));
		record.set(4,concreteBean.getDmDesc());
		record.set(5,concreteBean.getPlanStartDate());
		record.set(6,concreteBean.getPlanEndDate());
		record.set(7,concreteBean.getPlannedInd());
		record.set(8,concreteBean.getLastUpdatedDate());
		record.set(9,concreteBean.getDmAddedDate());
		record.set(10,concreteBean.getExclusionId());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(3,new Integer(concreteBean.getDmId()));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMKey)pkeyObject;
		record.set(0,new Integer(pkey.dmId));
		record.set(1,new Integer(pkey.customerId));
		record.set(2,new Integer(pkey.proposalId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c)cb;
		record.set(0,new Integer(concreteBean.getDmId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
		if(instanceExtension.isDirty(3))
		{
			record.set(2,concreteBean.getDmNo());
		}
		record.set(3,new Integer(concreteBean.getDmId()));
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getDmDesc());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getPlanStartDate());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getPlanEndDate());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getPlannedInd());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getLastUpdatedDate());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getDmAddedDate());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getExclusionId());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

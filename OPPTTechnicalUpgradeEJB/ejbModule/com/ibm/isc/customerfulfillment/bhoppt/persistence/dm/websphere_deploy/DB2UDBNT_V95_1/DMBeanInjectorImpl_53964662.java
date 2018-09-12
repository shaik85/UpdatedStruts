package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1;

/**
 * DMBeanInjectorImpl_53964662
 */
public class DMBeanInjectorImpl_53964662 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DMBeanInjector_53964662 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662)cb;
		record.set(0,new Integer(concreteBean.getDmId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,concreteBean.getDmDesc());
		record.set(4,concreteBean.getDmNo());
		record.set(5,concreteBean.getPlanStartDate());
		record.set(6,concreteBean.getPlanEndDate());
		record.set(7,concreteBean.getPlannedInd());
		record.set(8,concreteBean.getLastUpdatedDate());
		record.set(9,concreteBean.getDmAddedDate());
		record.set(10,concreteBean.getExclusionID());
		record.set(11,new Double(concreteBean.getDmCopyIncrNo()));
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662)cb;
		record.set(0,new Integer(concreteBean.getDmId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,concreteBean.getDmDesc());
		record.set(4,concreteBean.getDmNo());
		record.set(5,concreteBean.getPlanStartDate());
		record.set(6,concreteBean.getPlanEndDate());
		record.set(7,concreteBean.getPlannedInd());
		record.set(8,concreteBean.getLastUpdatedDate());
		record.set(9,concreteBean.getDmAddedDate());
		record.set(10,concreteBean.getExclusionID());
		record.set(11,new Double(concreteBean.getDmCopyIncrNo()));
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662)cb;
		record.set(0,new Integer(concreteBean.getDmId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbFindByProposal
	 */
	public void ejbFindByProposal(int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
	}
	/**
	 * ejbFindByDMNo
	 */
	public void ejbFindByDMNo(java.lang.String dmNo, int proposalId, int customerId, javax.resource.cci.IndexedRecord record) {
		record.set(0,dmNo);
		record.set(1,new Integer(proposalId));
		record.set(2,new Integer(customerId));
	}
	/**
	 * ejbFindByCustomer
	 */
	public void ejbFindByCustomer(int customerId, int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(customerId));
		record.set(1,new Integer(proposalId));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey)pkeyObject;
		record.set(0,new Integer(pkey.dmId));
		record.set(1,new Integer(pkey.customerId));
		record.set(2,new Integer(pkey.proposalId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662)cb;
		record.set(0,new Integer(concreteBean.getDmId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,new Double(concreteBean.getDmCopyIncrNo()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getDmId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getDmDesc());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getDmNo());
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
			record.set(10,concreteBean.getExclusionID());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,new Double(concreteBean.getDmCopyIncrNo()));
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}

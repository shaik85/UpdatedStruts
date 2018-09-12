package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;

import com.ibm.ejs.container.*;

/**
 * EJSCMPDMHomeBean_53964662
 */
public class EJSCMPDMHomeBean_53964662 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPDMHomeBean_53964662
	 */
	public EJSCMPDMHomeBean_53964662() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findMaxDMId_Local
	 */
	public java.util.Collection findMaxDMId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMaxDMId_Local();
			result = super.getCMP20Collection_Local(pKeys);
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
		}
		catch (javax.ejb.FinderException finderEx) {
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
			throw finderEx;
		}
		finally {
			if (beanO != null )
				super.discardFinderEntityBeanO(beanO);
		}
		return result;
	}
	/**
	 * findByProposal_Local
	 */
	public java.util.Collection findByProposal_Local(int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByProposal_Local(proposalId);
			result = super.getCMP20Collection_Local(pKeys);
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
		}
		catch (javax.ejb.FinderException finderEx) {
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
			throw finderEx;
		}
		finally {
			if (beanO != null )
				super.discardFinderEntityBeanO(beanO);
		}
		return result;
	}
	/**
	 * findByDMNo_Local
	 */
	public java.util.Collection findByDMNo_Local(java.lang.String dmNo, int proposalId, int customerId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByDMNo_Local(dmNo, proposalId, customerId);
			result = super.getCMP20Collection_Local(pKeys);
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
		}
		catch (javax.ejb.FinderException finderEx) {
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
			throw finderEx;
		}
		finally {
			if (beanO != null )
				super.discardFinderEntityBeanO(beanO);
		}
		return result;
	}
	/**
	 * findByCustomer_Local
	 */
	public java.util.Collection findByCustomer_Local(int customerId, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByCustomer_Local(customerId, proposalId);
			result = super.getCMP20Collection_Local(pKeys);
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
		}
		catch (javax.ejb.FinderException finderEx) {
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
			throw finderEx;
		}
		finally {
			if (beanO != null )
				super.discardFinderEntityBeanO(beanO);
		}
		return result;
	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMLocal create_Local(int dmId, int customerId, int proposalId, java.lang.String dmNo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(dmId, customerId, proposalId, dmNo);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(dmId, customerId, proposalId, dmNo);
			super.afterPostCreate(beanO, ejsKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if(preCreateFlag && !createFailed)
				super.afterPostCreateCompletion(beanO);
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return result;
	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteDM_53964662) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey();
		keyClass.dmId = tmpEJB.getDmId();
		keyClass.customerId = tmpEJB.getCustomerId();
		keyClass.proposalId = tmpEJB.getProposalId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey keyFromFields(int f0, int f1, int f2) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey();
		keyClass.dmId = f0;
		keyClass.customerId = f1;
		keyClass.proposalId = f2;
		return keyClass;
	}
}

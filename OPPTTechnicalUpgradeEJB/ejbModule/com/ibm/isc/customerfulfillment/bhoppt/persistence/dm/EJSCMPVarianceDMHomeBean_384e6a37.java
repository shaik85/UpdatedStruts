package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;

import com.ibm.ejs.container.*;

/**
 * EJSCMPVarianceDMHomeBean_384e6a37
 */
public class EJSCMPVarianceDMHomeBean_384e6a37 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPVarianceDMHomeBean_384e6a37
	 */
	public EJSCMPVarianceDMHomeBean_384e6a37() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByProposal_Local
	 */
	public java.util.Collection findByProposal_Local(int proposalID) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByProposal_Local(proposalID);
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
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37) beanO.getEnterpriseBean();
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
	public java.util.Collection findByCustomer_Local(int proposalId, int customerId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByCustomer_Local(proposalId, customerId);
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
	 * findMaxVarianceDMId_Local
	 */
	public java.util.Collection findMaxVarianceDMId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMaxVarianceDMId_Local();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocal create_Local(int dmId, int customerId, int proposalId, java.lang.String dmNo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(dmId, customerId, proposalId, dmNo);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocal) super.postCreate_Local(beanO, ejsKey, true);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey();
		keyClass.dmId = tmpEJB.getDmId();
		keyClass.customerId = tmpEJB.getCustomerId();
		keyClass.proposalId = tmpEJB.getProposalId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey keyFromFields(int f0, int f1, int f2) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey();
		keyClass.dmId = f0;
		keyClass.customerId = f1;
		keyClass.proposalId = f2;
		return keyClass;
	}
}

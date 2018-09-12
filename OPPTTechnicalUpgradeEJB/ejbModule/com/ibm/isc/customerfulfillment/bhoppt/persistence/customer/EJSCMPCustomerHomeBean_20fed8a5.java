package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCustomerHomeBean_20fed8a5
 */
public class EJSCMPCustomerHomeBean_20fed8a5 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPCustomerHomeBean_20fed8a5
	 */
	public EJSCMPCustomerHomeBean_20fed8a5() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByProposalAndCustomerList_Local
	 */
	public java.util.Collection findByProposalAndCustomerList_Local(int proposalId, java.lang.String customerListNo) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByProposalAndCustomerList_Local(proposalId, customerListNo);
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
			com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5) beanO.getEnterpriseBean();
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
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal create_Local(int proposalId, int customerId, java.lang.String sapCustomerNo, java.sql.Date planStartDate, java.sql.Date planEndDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(proposalId, customerId, sapCustomerNo, planStartDate, planEndDate);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(proposalId, customerId, sapCustomerNo, planStartDate, planEndDate);
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
	 * findBySapCustNoAndPlanStartEndDate_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal findBySapCustNoAndPlanStartEndDate_Local(int proposalId, java.lang.String sapCustomerNo, java.sql.Date planStartDate, java.sql.Date planEndDate) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5) beanO.getEnterpriseBean();
			pKey = bean.ejbFindBySapCustNoAndPlanStartEndDate_Local(proposalId, sapCustomerNo, planStartDate, planEndDate);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal)activateBean_Local(pKey);
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
	 * findBySapCustNo_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal findBySapCustNo_Local(int proposalId, java.lang.String sapCustomerNo) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5) beanO.getEnterpriseBean();
			pKey = bean.ejbFindBySapCustNo_Local(proposalId, sapCustomerNo);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal)activateBean_Local(pKey);
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
	 * findMaxCustomerId_Local
	 */
	public java.util.Collection findMaxCustomerId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMaxCustomerId_Local();
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
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findByProposalStartEndDate_Local
	 */
	public java.util.Collection findByProposalStartEndDate_Local(int proposalId, java.sql.Date planStartDate, java.sql.Date planEndDate) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByProposalStartEndDate_Local(proposalId, planStartDate, planEndDate);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey();
		keyClass.proposalId = tmpEJB.getProposalId();
		keyClass.customerId = tmpEJB.getCustomerId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey keyFromFields(int f0, int f1) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey();
		keyClass.proposalId = f0;
		keyClass.customerId = f1;
		return keyClass;
	}
}

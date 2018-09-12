package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer;

import com.ibm.ejs.container.*;

/**
 * EJSCMPHistoryCustomerHomeBean_44a753d1
 */
public class EJSCMPHistoryCustomerHomeBean_44a753d1 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPHistoryCustomerHomeBean_44a753d1
	 */
	public EJSCMPHistoryCustomerHomeBean_44a753d1() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerLocal create_Local(int customerId, int proposalId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(customerId, proposalId);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(customerId, proposalId);
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
	 * findMaxCustomerId_Local
	 */
	public java.util.Collection findMaxCustomerId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1) beanO.getEnterpriseBean();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey();
		keyClass.customerId = tmpEJB.getCustomerId();
		keyClass.proposalId = tmpEJB.getProposalId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey keyFromFields(int f0, int f1) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey();
		keyClass.customerId = f0;
		keyClass.proposalId = f1;
		return keyClass;
	}
}

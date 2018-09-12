package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCustomerListHomeBean_93c2f859
 */
public class EJSCMPCustomerListHomeBean_93c2f859 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPCustomerListHomeBean_93c2f859
	 */
	public EJSCMPCustomerListHomeBean_93c2f859() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findByProposalId_Local
	 */
	public java.util.Collection findByProposalId_Local(int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByProposalId_Local(proposalId);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListLocal create_Local(int proposalId, java.lang.String customerListNo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(proposalId, customerListNo);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(proposalId, customerListNo);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey();
		keyClass.proposalId = tmpEJB.getProposalId();
		keyClass.customerListNo = tmpEJB.getCustomerListNo();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey keyFromFields(int f0, java.lang.String f1) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey();
		keyClass.proposalId = f0;
		keyClass.customerListNo = f1;
		return keyClass;
	}
}

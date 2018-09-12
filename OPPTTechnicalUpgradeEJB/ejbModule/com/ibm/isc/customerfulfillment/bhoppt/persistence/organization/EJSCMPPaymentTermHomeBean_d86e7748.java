package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPaymentTermHomeBean_d86e7748
 */
public class EJSCMPPaymentTermHomeBean_d86e7748 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPPaymentTermHomeBean_d86e7748
	 */
	public EJSCMPPaymentTermHomeBean_d86e7748() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermLocal create_Local(java.lang.String paymentTerm) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(paymentTerm);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(paymentTerm);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermLocal findByPrimaryKey_Local(java.lang.String primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findAllPaymentTerm_Local
	 */
	public java.util.Collection findAllPaymentTerm_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllPaymentTerm_Local();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748) generalEJB;
		return tmpEJB.getPaymentTerm();
	}
	/**
	 * keyFromFields
	 */
	public java.lang.String keyFromFields(java.lang.String f0) {
		return f0;
	}
}

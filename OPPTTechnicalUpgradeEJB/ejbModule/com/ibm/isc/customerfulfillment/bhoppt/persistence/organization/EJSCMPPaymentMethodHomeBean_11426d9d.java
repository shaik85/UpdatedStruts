package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPaymentMethodHomeBean_11426d9d
 */
public class EJSCMPPaymentMethodHomeBean_11426d9d extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPPaymentMethodHomeBean_11426d9d
	 */
	public EJSCMPPaymentMethodHomeBean_11426d9d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findAllPaymentMethod_Local
	 */
	public java.util.Collection findAllPaymentMethod_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllPaymentMethod_Local();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentMethodLocal create_Local(java.lang.String id) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentMethodLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentMethodBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentMethodBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(id);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentMethodLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(id);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentMethodLocal findByPrimaryKey_Local(java.lang.String primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentMethodLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d) generalEJB;
		return tmpEJB.getId();
	}
	/**
	 * keyFromFields
	 */
	public java.lang.String keyFromFields(java.lang.String f0) {
		return f0;
	}
}

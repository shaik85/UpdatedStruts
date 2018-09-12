package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBillingTypeHomeBean_9d28f63a
 */
public class EJSCMPBillingTypeHomeBean_9d28f63a extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPBillingTypeHomeBean_9d28f63a
	 */
	public EJSCMPBillingTypeHomeBean_9d28f63a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingTypeLocal create_Local(java.lang.String billingType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingTypeLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingTypeBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingTypeBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(billingType);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingTypeLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(billingType);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingTypeLocal findByPrimaryKey_Local(java.lang.String primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingTypeLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findAllBillingType_Local
	 */
	public java.util.Collection findAllBillingType_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllBillingType_Local();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a) generalEJB;
		return tmpEJB.getBillingType();
	}
	/**
	 * keyFromFields
	 */
	public java.lang.String keyFromFields(java.lang.String f0) {
		return f0;
	}
}

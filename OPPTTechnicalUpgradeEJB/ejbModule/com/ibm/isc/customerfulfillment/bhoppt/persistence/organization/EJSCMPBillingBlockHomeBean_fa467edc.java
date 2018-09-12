package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBillingBlockHomeBean_fa467edc
 */
public class EJSCMPBillingBlockHomeBean_fa467edc extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPBillingBlockHomeBean_fa467edc
	 */
	public EJSCMPBillingBlockHomeBean_fa467edc() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockLocal create_Local(java.lang.String billingBlock) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(billingBlock);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(billingBlock);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockLocal findByPrimaryKey_Local(java.lang.String primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findAllBillingBlock_Local
	 */
	public java.util.Collection findAllBillingBlock_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllBillingBlock_Local();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc) generalEJB;
		return tmpEJB.getBillingBlock();
	}
	/**
	 * keyFromFields
	 */
	public java.lang.String keyFromFields(java.lang.String f0) {
		return f0;
	}
}

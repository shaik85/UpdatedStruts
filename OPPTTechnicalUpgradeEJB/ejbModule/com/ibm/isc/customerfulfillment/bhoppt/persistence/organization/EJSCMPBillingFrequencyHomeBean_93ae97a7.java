package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBillingFrequencyHomeBean_93ae97a7
 */
public class EJSCMPBillingFrequencyHomeBean_93ae97a7 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPBillingFrequencyHomeBean_93ae97a7
	 */
	public EJSCMPBillingFrequencyHomeBean_93ae97a7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyLocal create_Local(java.lang.String billingFreqCode) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(billingFreqCode);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(billingFreqCode);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyLocal findByPrimaryKey_Local(java.lang.String primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findAllBillingFreq_Local
	 */
	public java.util.Collection findAllBillingFreq_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllBillingFreq_Local();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7) generalEJB;
		return tmpEJB.getBillingFreqCode();
	}
	/**
	 * keyFromFields
	 */
	public java.lang.String keyFromFields(java.lang.String f0) {
		return f0;
	}
}

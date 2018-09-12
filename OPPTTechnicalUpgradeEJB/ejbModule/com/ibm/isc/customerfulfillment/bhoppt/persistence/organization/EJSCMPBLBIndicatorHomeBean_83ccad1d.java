package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBLBIndicatorHomeBean_83ccad1d
 */
public class EJSCMPBLBIndicatorHomeBean_83ccad1d extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPBLBIndicatorHomeBean_83ccad1d
	 */
	public EJSCMPBLBIndicatorHomeBean_83ccad1d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findAllBLBIndicator_Local
	 */
	public java.util.Collection findAllBLBIndicator_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllBLBIndicator_Local();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocal create_Local(java.lang.String blbType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(blbType);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(blbType);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocal)super.activateBean_Local(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey();
		keyClass.blbType = tmpEJB.getBlbType();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey keyFromFields(java.lang.String f0) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey();
		keyClass.blbType = f0;
		return keyClass;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCCTypeHomeBean_d1953ee3
 */
public class EJSCMPCCTypeHomeBean_d1953ee3 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPCCTypeHomeBean_d1953ee3
	 */
	public EJSCMPCCTypeHomeBean_d1953ee3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocal)super.activateBean_Local(key);
	}
	/**
	 * findAllCCType_Local
	 */
	public java.util.Collection findAllCCType_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllCCType_Local();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocal create_Local(java.lang.String ccType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(ccType);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(ccType);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey();
		keyClass.ccType = tmpEJB.getCcType();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey keyFromFields(java.lang.String f0) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey();
		keyClass.ccType = f0;
		return keyClass;
	}
}

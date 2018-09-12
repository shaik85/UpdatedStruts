package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPMCTypeHomeBean_b8a50e19
 */
public class EJSCMPMCTypeHomeBean_b8a50e19 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPMCTypeHomeBean_b8a50e19
	 */
	public EJSCMPMCTypeHomeBean_b8a50e19() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocal)super.activateBean_Local(key);
	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocal create_Local(java.lang.String mcType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(mcType);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(mcType);
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
	 * findAllMCType_Local
	 */
	public java.util.Collection findAllMCType_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllMCType_Local();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey();
		keyClass.mcType = tmpEJB.getMcType();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey keyFromFields(java.lang.String f0) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey();
		keyClass.mcType = f0;
		return keyClass;
	}
}

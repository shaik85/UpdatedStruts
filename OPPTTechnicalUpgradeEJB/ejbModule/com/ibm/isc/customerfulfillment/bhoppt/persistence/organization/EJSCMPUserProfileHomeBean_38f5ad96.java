package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPUserProfileHomeBean_38f5ad96
 */
public class EJSCMPUserProfileHomeBean_38f5ad96 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPUserProfileHomeBean_38f5ad96
	 */
	public EJSCMPUserProfileHomeBean_38f5ad96() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findAllForSalesOrgAndRole_Local
	 */
	public java.util.Collection findAllForSalesOrgAndRole_Local(java.lang.String salesOrg, java.lang.String role) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllForSalesOrgAndRole_Local(salesOrg, role);
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
	 * findBySalesOrg_Local
	 */
	public java.util.Collection findBySalesOrg_Local(java.lang.String salesOrg) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindBySalesOrg_Local(salesOrg);
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
	 * findByGroupName_Local
	 */
	public java.util.Collection findByGroupName_Local(java.lang.String groupName) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByGroupName_Local(groupName);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserProfileLocal findByPrimaryKey_Local(java.lang.String primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserProfileLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserProfileLocal create_Local(java.lang.String userId, java.lang.String role) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserProfileLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserProfileBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserProfileBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(userId, role);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserProfileLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(userId, role);
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
	 * findByRole_Local
	 */
	public java.util.Collection findByRole_Local(java.lang.String userid1, java.lang.String userid2) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByRole_Local(userid1, userid2);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserProfile_38f5ad96) generalEJB;
		return tmpEJB.getUserId();
	}
	/**
	 * keyFromFields
	 */
	public java.lang.String keyFromFields(java.lang.String f0) {
		return f0;
	}
}

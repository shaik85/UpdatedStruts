package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPUserGroupHomeBean_c9153aeb
 */
public class EJSCMPUserGroupHomeBean_c9153aeb extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPUserGroupHomeBean_c9153aeb
	 */
	public EJSCMPUserGroupHomeBean_c9153aeb() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findByUser_Local
	 */
	public java.util.Collection findByUser_Local(java.lang.String userId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByUser_Local(userId);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupLocal create_Local(java.lang.String userId, java.lang.String groupName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(userId, groupName);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(userId, groupName);
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
	 * findByGroup_Local
	 */
	public java.util.Collection findByGroup_Local(java.lang.String groupName) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByGroup_Local(groupName);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupKey();
		keyClass.userId = tmpEJB.getUserId();
		keyClass.groupName = tmpEJB.getGroupName();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupKey keyFromFields(java.lang.String f0, java.lang.String f1) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupKey();
		keyClass.userId = f0;
		keyClass.groupName = f1;
		return keyClass;
	}
}

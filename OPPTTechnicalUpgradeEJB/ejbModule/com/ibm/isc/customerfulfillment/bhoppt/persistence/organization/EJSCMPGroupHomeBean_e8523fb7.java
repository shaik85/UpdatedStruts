package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPGroupHomeBean_e8523fb7
 */
public class EJSCMPGroupHomeBean_e8523fb7 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPGroupHomeBean_e8523fb7
	 */
	public EJSCMPGroupHomeBean_e8523fb7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findBySalesOrg_Local
	 */
	public java.util.Collection findBySalesOrg_Local(java.lang.String salesOrg) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7) beanO.getEnterpriseBean();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal findByGroupName_Local(java.lang.String groupName) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal result = null;
		EntityBeanO beanO = null;

		java.lang.String pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByGroupName_Local(groupName);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal)activateBean_Local(pKey);
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
	 * findAllGroup_Local
	 */
	public java.util.Collection findAllGroup_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllGroup_Local();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal create_Local(java.lang.String groupName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(groupName);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(groupName);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal findByPrimaryKey_Local(java.lang.String primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7) generalEJB;
		return tmpEJB.getGroupName();
	}
	/**
	 * keyFromFields
	 */
	public java.lang.String keyFromFields(java.lang.String f0) {
		return f0;
	}
}

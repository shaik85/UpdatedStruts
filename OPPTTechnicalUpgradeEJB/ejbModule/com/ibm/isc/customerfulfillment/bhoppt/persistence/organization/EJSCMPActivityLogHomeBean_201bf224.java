package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPActivityLogHomeBean_201bf224
 */
public class EJSCMPActivityLogHomeBean_201bf224 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPActivityLogHomeBean_201bf224
	 */
	public EJSCMPActivityLogHomeBean_201bf224() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findAllActivities_Local
	 */
	public java.util.Collection findAllActivities_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllActivities_Local();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogLocal create_Local(java.lang.String userId, java.sql.Date activityDate, java.sql.Time activityTime) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(userId, activityDate, activityTime);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(userId, activityDate, activityTime);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey();
		keyClass.activityTime = tmpEJB.getActivityTime();
		keyClass.activityDate = tmpEJB.getActivityDate();
		keyClass.userId = tmpEJB.getUserId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey keyFromFields(java.sql.Time f0, java.sql.Date f1, java.lang.String f2) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey();
		keyClass.activityTime = f0;
		keyClass.activityDate = f1;
		keyClass.userId = f2;
		return keyClass;
	}
}

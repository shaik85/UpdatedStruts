package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOfferingTypeHomeBean_4b02317c
 */
public class EJSCMPOfferingTypeHomeBean_4b02317c extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPOfferingTypeHomeBean_4b02317c
	 */
	public EJSCMPOfferingTypeHomeBean_4b02317c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findAllOfferingType_Local
	 */
	public java.util.Collection findAllOfferingType_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllOfferingType_Local();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeLocal create_Local(java.lang.String offeringType, java.lang.String offeringDesc) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(offeringType, offeringDesc);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(offeringType, offeringDesc);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey();
		keyClass.offeringDesc = tmpEJB.getOfferingDesc();
		keyClass.offeringType = tmpEJB.getOfferingType();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey keyFromFields(java.lang.String f0, java.lang.String f1) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey();
		keyClass.offeringDesc = f0;
		keyClass.offeringType = f1;
		return keyClass;
	}
}

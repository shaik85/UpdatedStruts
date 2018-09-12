package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPGeoSecOffHomeBean_4c848b5a
 */
public class EJSCMPGeoSecOffHomeBean_4c848b5a extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPGeoSecOffHomeBean_4c848b5a
	 */
	public EJSCMPGeoSecOffHomeBean_4c848b5a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findBySalesOrg_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal findBySalesOrg_Local(java.lang.String salesOrg) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal result = null;
		EntityBeanO beanO = null;

		java.lang.String pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a) beanO.getEnterpriseBean();
			pKey = bean.ejbFindBySalesOrg_Local(salesOrg);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal)activateBean_Local(pKey);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal create_Local(java.lang.String salesOrg) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(salesOrg);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(salesOrg);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal findByPrimaryKey_Local(java.lang.String primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findByGeoSec_Local
	 */
	public java.util.Collection findByGeoSec_Local(java.lang.String salesOrg) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByGeoSec_Local(salesOrg);
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
	 * findAllGeoSecOfficer_Local
	 */
	public java.util.Collection findAllGeoSecOfficer_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllGeoSecOfficer_Local();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a) generalEJB;
		return tmpEJB.getSalesOrg();
	}
	/**
	 * keyFromFields
	 */
	public java.lang.String keyFromFields(java.lang.String f0) {
		return f0;
	}
}

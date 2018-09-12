package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSalesOrgHomeBean_bac07656
 */
public class EJSCMPSalesOrgHomeBean_bac07656 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPSalesOrgHomeBean_bac07656
	 */
	public EJSCMPSalesOrgHomeBean_bac07656() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findAllSalesOrg_Local
	 */
	public java.util.Collection findAllSalesOrg_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllSalesOrg_Local();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgLocal create_Local(java.lang.String salesOrg) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(salesOrg);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgLocal) super.postCreate_Local(beanO, ejsKey, true);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgLocal findByPrimaryKey_Local(java.lang.String primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656) generalEJB;
		return tmpEJB.getSalesOrg();
	}
	/**
	 * keyFromFields
	 */
	public java.lang.String keyFromFields(java.lang.String f0) {
		return f0;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSalesAreaHomeBean_ac159cf0
 */
public class EJSCMPSalesAreaHomeBean_ac159cf0 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPSalesAreaHomeBean_ac159cf0
	 */
	public EJSCMPSalesAreaHomeBean_ac159cf0() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaLocal create_Local(java.lang.String salesOrg, java.lang.String divisionCode, java.lang.String distributionChannelCode) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(salesOrg, divisionCode, distributionChannelCode);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(salesOrg, divisionCode, distributionChannelCode);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesArea_ac159cf0 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesArea_ac159cf0) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey();
		keyClass.salesOrg = tmpEJB.getSalesOrg();
		keyClass.divisionCode = tmpEJB.getDivisionCode();
		keyClass.distributionChannelCode = tmpEJB.getDistributionChannelCode();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey keyFromFields(java.lang.String f0, java.lang.String f1, java.lang.String f2) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey();
		keyClass.salesOrg = f0;
		keyClass.divisionCode = f1;
		keyClass.distributionChannelCode = f2;
		return keyClass;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBaseAgreementHomeBean_2e70ac6a
 */
public class EJSCMPBaseAgreementHomeBean_2e70ac6a extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPBaseAgreementHomeBean_2e70ac6a
	 */
	public EJSCMPBaseAgreementHomeBean_2e70ac6a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findByCustomerNumberandFormNumber_Local
	 */
	public java.util.Collection findByCustomerNumberandFormNumber_Local(java.lang.String customerNumber, java.lang.String formNumber) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByCustomerNumberandFormNumber_Local(customerNumber, formNumber);
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
	 * findBySalesOrgAndFormNumber_Local
	 */
	public java.util.Collection findBySalesOrgAndFormNumber_Local(java.lang.String salesOrganization, java.lang.String formNumber) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindBySalesOrgAndFormNumber_Local(salesOrganization, formNumber);
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
	 * findMaxAgreementId_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocal findMaxAgreementId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a) beanO.getEnterpriseBean();
			pKey = bean.ejbFindMaxAgreementId_Local();
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocal)activateBean_Local(pKey);
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
	 * findBySearch_Local
	 */
	public java.util.Collection findBySearch_Local(java.lang.String agreementNumber, java.lang.String formNumber, java.lang.String customerNumber, java.lang.String enterpriseNumber) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindBySearch_Local(agreementNumber, formNumber, customerNumber, enterpriseNumber);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocal create_Local(java.lang.Integer agreementId, java.lang.String salesOrg, java.lang.String agreementNumber, java.lang.String agreementStatus, java.lang.String coverageType, java.lang.String isModified, java.lang.String createdBy, java.sql.Date createdDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(agreementId, salesOrg, agreementNumber, agreementStatus, coverageType, isModified, createdBy, createdDate);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(agreementId, salesOrg, agreementNumber, agreementStatus, coverageType, isModified, createdBy, createdDate);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey();
		keyClass.agreementId = tmpEJB.getAgreementId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey keyFromFields(java.lang.Integer f0) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey();
		keyClass.agreementId = f0;
		return keyClass;
	}
}

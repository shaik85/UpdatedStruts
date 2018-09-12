package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBaseAgreementModificationDetailsHomeBean_6b44584e
 */
public class EJSCMPBaseAgreementModificationDetailsHomeBean_6b44584e extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPBaseAgreementModificationDetailsHomeBean_6b44584e
	 */
	public EJSCMPBaseAgreementModificationDetailsHomeBean_6b44584e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByAgreementId_Local
	 */
	public java.util.Collection findByAgreementId_Local(java.lang.Integer agreementId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByAgreementId_Local(agreementId);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsLocal create_Local(java.lang.Integer agreementId, java.lang.String modificationTypeCode) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(agreementId, modificationTypeCode);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(agreementId, modificationTypeCode);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey();
		keyClass.agreementId = tmpEJB.getAgreementId();
		keyClass.modificationTypeCode = tmpEJB.getModificationTypeCode();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey keyFromFields(java.lang.Integer f0, java.lang.String f1) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey();
		keyClass.agreementId = f0;
		keyClass.modificationTypeCode = f1;
		return keyClass;
	}
}

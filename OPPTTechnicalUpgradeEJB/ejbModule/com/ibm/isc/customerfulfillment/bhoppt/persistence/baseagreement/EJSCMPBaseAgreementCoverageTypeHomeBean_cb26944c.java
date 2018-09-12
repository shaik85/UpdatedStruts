package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBaseAgreementCoverageTypeHomeBean_cb26944c
 */
public class EJSCMPBaseAgreementCoverageTypeHomeBean_cb26944c extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPBaseAgreementCoverageTypeHomeBean_cb26944c
	 */
	public EJSCMPBaseAgreementCoverageTypeHomeBean_cb26944c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeLocal create_Local(java.lang.String coverageType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(coverageType);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(coverageType);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementCoverageType_cb26944c tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementCoverageType_cb26944c) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey();
		keyClass.coverageType = tmpEJB.getCoverageType();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey keyFromFields(java.lang.String f0) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey();
		keyClass.coverageType = f0;
		return keyClass;
	}
}

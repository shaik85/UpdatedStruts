package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ejs.container.*;

/**
 * EJSCMPModificationOptionsHomeBean_2c56bd25
 */
public class EJSCMPModificationOptionsHomeBean_2c56bd25 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPModificationOptionsHomeBean_2c56bd25
	 */
	public EJSCMPModificationOptionsHomeBean_2c56bd25() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByTypeCode_Local
	 */
	public java.util.Collection findByTypeCode_Local(java.lang.String modificationTypeCode) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByTypeCode_Local(modificationTypeCode);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsLocal create_Local(java.lang.String modificationTypeCode, java.lang.String modificationOption) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(modificationTypeCode, modificationOption);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(modificationTypeCode, modificationOption);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey();
		keyClass.modificationTypeCode = tmpEJB.getModificationTypeCode();
		keyClass.modificationOption = tmpEJB.getModificationOption();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey keyFromFields(java.lang.String f0, java.lang.String f1) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey();
		keyClass.modificationTypeCode = f0;
		keyClass.modificationOption = f1;
		return keyClass;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPriceHomeBean_dffc00c5
 */
public class EJSCMPPriceHomeBean_dffc00c5 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPPriceHomeBean_dffc00c5
	 */
	public EJSCMPPriceHomeBean_dffc00c5() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findByEE_Local
	 */
	public java.util.Collection findByEE_Local(int eeId, int swoId, int dmId, int customerId, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByEE_Local(eeId, swoId, dmId, customerId, proposalId);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocal create_Local(int priceId, int eeId, int swoId, int dmId, int customerId, int proposalId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(priceId, eeId, swoId, dmId, customerId, proposalId);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(priceId, eeId, swoId, dmId, customerId, proposalId);
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
	 * findMaxPriceId_Local
	 */
	public java.util.Collection findMaxPriceId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMaxPriceId_Local();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcretePrice_dffc00c5) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey();
		keyClass.priceId = tmpEJB.getPriceId();
		keyClass.eeId = tmpEJB.getEeId();
		keyClass.swoId = tmpEJB.getSwoId();
		keyClass.dmId = tmpEJB.getDmId();
		keyClass.customerId = tmpEJB.getCustomerId();
		keyClass.proposalId = tmpEJB.getProposalId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey keyFromFields(int f0, int f1, int f2, int f3, int f4, int f5) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey();
		keyClass.priceId = f0;
		keyClass.eeId = f1;
		keyClass.swoId = f2;
		keyClass.dmId = f3;
		keyClass.customerId = f4;
		keyClass.proposalId = f5;
		return keyClass;
	}
}

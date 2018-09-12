package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;

/**
 * EJSCMPHistorySWOHomeBean_2fe0d772
 */
public class EJSCMPHistorySWOHomeBean_2fe0d772 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPHistorySWOHomeBean_2fe0d772
	 */
	public EJSCMPHistorySWOHomeBean_2fe0d772() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocal create_Local(int swoId, int dmId, int customerId, int proposalId, java.lang.String swoNo, java.sql.Date lastUpdatedDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(swoId, dmId, customerId, proposalId, swoNo, lastUpdatedDate);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(swoId, dmId, customerId, proposalId, swoNo, lastUpdatedDate);
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
	 * findMaxSWOId_Local
	 */
	public java.util.Collection findMaxSWOId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMaxSWOId_Local();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistorySWO_2fe0d772) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOKey();
		keyClass.swoId = tmpEJB.getSwoId();
		keyClass.dmId = tmpEJB.getDmId();
		keyClass.customerId = tmpEJB.getCustomerId();
		keyClass.proposalId = tmpEJB.getProposalId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOKey keyFromFields(int f0, int f1, int f2, int f3) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOKey();
		keyClass.swoId = f0;
		keyClass.dmId = f1;
		keyClass.customerId = f2;
		keyClass.proposalId = f3;
		return keyClass;
	}
}

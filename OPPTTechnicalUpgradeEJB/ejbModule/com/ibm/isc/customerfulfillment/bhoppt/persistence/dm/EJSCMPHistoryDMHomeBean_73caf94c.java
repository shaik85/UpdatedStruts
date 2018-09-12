package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;

import com.ibm.ejs.container.*;

/**
 * EJSCMPHistoryDMHomeBean_73caf94c
 */
public class EJSCMPHistoryDMHomeBean_73caf94c extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPHistoryDMHomeBean_73caf94c
	 */
	public EJSCMPHistoryDMHomeBean_73caf94c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findMaxDMId_Local
	 */
	public java.util.Collection findMaxDMId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMaxDMId_Local();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMLocal create_Local(int dmId, int customerId, int proposalId, java.lang.String dmNo, java.sql.Date lastUpdatedDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(dmId, customerId, proposalId, dmNo, lastUpdatedDate);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(dmId, customerId, proposalId, dmNo, lastUpdatedDate);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteHistoryDM_73caf94c) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMKey();
		keyClass.dmId = tmpEJB.getDmId();
		keyClass.customerId = tmpEJB.getCustomerId();
		keyClass.proposalId = tmpEJB.getProposalId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMKey keyFromFields(int f0, int f1, int f2) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMKey();
		keyClass.dmId = f0;
		keyClass.customerId = f1;
		keyClass.proposalId = f2;
		return keyClass;
	}
}

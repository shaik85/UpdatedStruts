package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAccessHistoryHomeBean_1c91e0cb
 */
public class EJSCMPAccessHistoryHomeBean_1c91e0cb extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPAccessHistoryHomeBean_1c91e0cb
	 */
	public EJSCMPAccessHistoryHomeBean_1c91e0cb() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByProposalID_Local
	 */
	public java.util.Collection findByProposalID_Local(int proposalID) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByProposalID_Local(proposalID);
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
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryLocal create_Local(int proposalId, java.lang.String userId, java.sql.Date accessDate, java.sql.Time accessTime, int sequenceNo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(proposalId, userId, accessDate, accessTime, sequenceNo);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(proposalId, userId, accessDate, accessTime, sequenceNo);
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
	 * findByProposalIDAndUserID_Local
	 */
	public java.util.Collection findByProposalIDAndUserID_Local(int proposalId, java.lang.String userId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByProposalIDAndUserID_Local(proposalId, userId);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey();
		keyClass.proposalId = tmpEJB.getProposalId();
		keyClass.userId = tmpEJB.getUserId();
		keyClass.accessDate = tmpEJB.getAccessDate();
		keyClass.accessTime = tmpEJB.getAccessTime();
		keyClass.seqNo = tmpEJB.getSeqNo();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey keyFromFields(int f0, java.lang.String f1, java.sql.Date f2, java.sql.Time f3, int f4) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey();
		keyClass.proposalId = f0;
		keyClass.userId = f1;
		keyClass.accessDate = f2;
		keyClass.accessTime = f3;
		keyClass.seqNo = f4;
		return keyClass;
	}
}

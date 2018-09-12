package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;

/**
 * EJSCMPHistoryEEHomeBean_2f4f3e31
 */
public class EJSCMPHistoryEEHomeBean_2f4f3e31 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPHistoryEEHomeBean_2f4f3e31
	 */
	public EJSCMPHistoryEEHomeBean_2f4f3e31() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findMaxEEId_Local
	 */
	public java.util.Collection findMaxEEId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMaxEEId_Local();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEELocal create_Local(int eeId, int swoId, int dmId, int customerId, int proposalId, java.lang.String eeNo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEELocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(eeId, swoId, dmId, customerId, proposalId, eeNo);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEELocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(eeId, swoId, dmId, customerId, proposalId, eeNo);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEELocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEELocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteHistoryEE_2f4f3e31) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey keyFromFields(int f0, int f1, int f2, int f3, int f4) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey();
		keyClass.eeId = f0;
		keyClass.swoId = f1;
		keyClass.dmId = f2;
		keyClass.customerId = f3;
		keyClass.proposalId = f4;
		return keyClass;
	}
}

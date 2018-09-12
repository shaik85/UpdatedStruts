package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;

/**
 * EJSCMPEEHomeBean_53787648
 */
public class EJSCMPEEHomeBean_53787648 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPEEHomeBean_53787648
	 */
	public EJSCMPEEHomeBean_53787648() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByProposal_Local
	 */
	public java.util.Collection findByProposal_Local(int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByProposal_Local(proposalId);
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
	 * findByEENoSalesDocEEItemSwoItem_Local
	 */
	public java.util.Collection findByEENoSalesDocEEItemSwoItem_Local(int proposalId, java.lang.String eeNo, java.lang.String salesDocNo, java.lang.String eeItemNo, java.lang.String swoItemNo) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByEENoSalesDocEEItemSwoItem_Local(proposalId, eeNo, salesDocNo, eeItemNo, swoItemNo);
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
	 * findMaxEEId_Local
	 */
	public java.util.Collection findMaxEEId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648) beanO.getEnterpriseBean();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocal create_Local(int eeId, int swoId, int dmId, int customerId, int proposalId, java.lang.String eeNo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EEBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EEBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(eeId, swoId, dmId, customerId, proposalId, eeNo);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocal) super.postCreate_Local(beanO, ejsKey, true);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EEKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findBySWO_Local
	 */
	public java.util.Collection findBySWO_Local(int swoId, int dmId, int customerId, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindBySWO_Local(swoId, dmId, customerId, proposalId);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteEE_53787648) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EEKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EEKey();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EEKey keyFromFields(int f0, int f1, int f2, int f3, int f4) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EEKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EEKey();
		keyClass.eeId = f0;
		keyClass.swoId = f1;
		keyClass.dmId = f2;
		keyClass.customerId = f3;
		keyClass.proposalId = f4;
		return keyClass;
	}
}

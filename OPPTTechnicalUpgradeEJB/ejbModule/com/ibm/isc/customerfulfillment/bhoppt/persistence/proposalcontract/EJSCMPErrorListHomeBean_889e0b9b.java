package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ejs.container.*;

/**
 * EJSCMPErrorListHomeBean_889e0b9b
 */
public class EJSCMPErrorListHomeBean_889e0b9b extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPErrorListHomeBean_889e0b9b
	 */
	public EJSCMPErrorListHomeBean_889e0b9b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByProposalId_Local
	 */
	public java.util.Collection findByProposalId_Local(int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByProposalId_Local(proposalId);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocal create_Local(java.lang.Integer messageId, int proposalId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(messageId, proposalId);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(messageId, proposalId);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocal findByPrimaryKey_Local(java.lang.Integer primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findMax_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocal findMax_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocal result = null;
		EntityBeanO beanO = null;

		java.lang.Integer pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b) beanO.getEnterpriseBean();
			pKey = bean.ejbFindMax_Local();
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocal)activateBean_Local(pKey);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteErrorList_889e0b9b) generalEJB;
		return tmpEJB.getMessageId();
	}
	/**
	 * keyFromFields
	 */
	public java.lang.Integer keyFromFields(java.lang.Integer f0) {
		return f0;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSharingHomeBean_a437b4b5
 */
public class EJSCMPSharingHomeBean_a437b4b5 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPSharingHomeBean_a437b4b5
	 */
	public EJSCMPSharingHomeBean_a437b4b5() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByProposalId_Local
	 */
	public java.util.Collection findByProposalId_Local(int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5) beanO.getEnterpriseBean();
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
	 * findByUser_Local
	 */
	public java.util.Collection findByUser_Local(java.lang.String userId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByUser_Local(userId);
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
	 * findByProposalAndAccess_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal findByProposalAndAccess_Local(int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByProposalAndAccess_Local(proposalId);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal)activateBean_Local(pKey);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal create_Local(int proposalId, java.lang.String accessTo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(proposalId, accessTo);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(proposalId, accessTo);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey();
		keyClass.proposalId = tmpEJB.getProposalId();
		keyClass.accessTo = tmpEJB.getAccessTo();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey keyFromFields(int f0, java.lang.String f1) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey();
		keyClass.proposalId = f0;
		keyClass.accessTo = f1;
		return keyClass;
	}
}

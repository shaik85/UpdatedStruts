package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;

/**
 * EJSCMPVarianceEEHomeBean_4da349e6
 */
public class EJSCMPVarianceEEHomeBean_4da349e6 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPVarianceEEHomeBean_4da349e6
	 */
	public EJSCMPVarianceEEHomeBean_4da349e6() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findMaxEEId_Local
	 */
	public java.util.Collection findMaxEEId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6) beanO.getEnterpriseBean();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEELocal create_Local(int eeId, int swoId, int dmId, int customerId, int proposalId, java.lang.String eeNo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEELocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(eeId, swoId, dmId, customerId, proposalId, eeNo);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEELocal) super.postCreate_Local(beanO, ejsKey, true);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEELocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEELocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findBySWO_Local
	 */
	public java.util.Collection findBySWO_Local(int swoid, int dmid, int custometId, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindBySWO_Local(swoid, dmid, custometId, proposalId);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceEE_4da349e6) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey keyFromFields(int f0, int f1, int f2, int f3, int f4) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey();
		keyClass.eeId = f0;
		keyClass.swoId = f1;
		keyClass.dmId = f2;
		keyClass.customerId = f3;
		keyClass.proposalId = f4;
		return keyClass;
	}
}

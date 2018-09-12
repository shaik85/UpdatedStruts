package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;

/**
 * EJSCMPVarianceSWOHomeBean_c577a175
 */
public class EJSCMPVarianceSWOHomeBean_c577a175 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPVarianceSWOHomeBean_c577a175
	 */
	public EJSCMPVarianceSWOHomeBean_c577a175() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByDM_Local
	 */
	public java.util.Collection findByDM_Local(int dmID, int customerId, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByDM_Local(dmID, customerId, proposalId);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocal create_Local(int swoId, int dmId, int customerId, int proposalId, java.lang.String swoNo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(swoId, dmId, customerId, proposalId, swoNo);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(swoId, dmId, customerId, proposalId, swoNo);
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
	 * findByEquipmentNo_Local
	 */
	public java.util.Collection findByEquipmentNo_Local(java.lang.String equipmentNo, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByEquipmentNo_Local(equipmentNo, proposalId);
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
	 * findMaxVarianceSWOId_Local
	 */
	public java.util.Collection findMaxVarianceSWOId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMaxVarianceSWOId_Local();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVarianceSWO_c577a175) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey();
		keyClass.swoId = tmpEJB.getSwoId();
		keyClass.dmId = tmpEJB.getDmId();
		keyClass.customerId = tmpEJB.getCustomerId();
		keyClass.proposalId = tmpEJB.getProposalId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey keyFromFields(int f0, int f1, int f2, int f3) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey();
		keyClass.swoId = f0;
		keyClass.dmId = f1;
		keyClass.customerId = f2;
		keyClass.proposalId = f3;
		return keyClass;
	}
}

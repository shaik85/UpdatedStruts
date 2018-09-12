package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBPCustListHomeBean_0f59666b
 */
public class EJSCMPBPCustListHomeBean_0f59666b extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPBPCustListHomeBean_0f59666b
	 */
	public EJSCMPBPCustListHomeBean_0f59666b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByUser_Local
	 */
	public java.util.Collection findByUser_Local(java.lang.String userId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b) beanO.getEnterpriseBean();
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
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListLocal create_Local(java.lang.String userId, java.lang.String custListNo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(userId, custListNo);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(userId, custListNo);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey();
		keyClass.userId = tmpEJB.getUserId();
		keyClass.custListNo = tmpEJB.getCustListNo();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey keyFromFields(java.lang.String f0, java.lang.String f1) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey();
		keyClass.userId = f0;
		keyClass.custListNo = f1;
		return keyClass;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBPLegacyNoHomeBean_f2446ac8
 */
public class EJSCMPBPLegacyNoHomeBean_f2446ac8 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPBPLegacyNoHomeBean_f2446ac8
	 */
	public EJSCMPBPLegacyNoHomeBean_f2446ac8() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findByUser_Local
	 */
	public java.util.Collection findByUser_Local(java.lang.String userId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8) beanO.getEnterpriseBean();
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
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoLocal create_Local(java.lang.String userId, java.lang.String legacyNo, java.lang.String addressSeqNo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(userId, legacyNo, addressSeqNo);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(userId, legacyNo, addressSeqNo);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey();
		keyClass.userId = tmpEJB.getUserId();
		keyClass.legacyNo = tmpEJB.getLegacyNo();
		keyClass.addressSeqNo = tmpEJB.getAddressSeqNo();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey keyFromFields(java.lang.String f0, java.lang.String f1, java.lang.String f2) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey();
		keyClass.userId = f0;
		keyClass.legacyNo = f1;
		keyClass.addressSeqNo = f2;
		return keyClass;
	}
}

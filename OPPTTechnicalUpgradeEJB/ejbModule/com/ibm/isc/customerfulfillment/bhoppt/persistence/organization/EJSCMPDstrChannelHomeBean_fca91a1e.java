package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;

/**
 * EJSCMPDstrChannelHomeBean_fca91a1e
 */
public class EJSCMPDstrChannelHomeBean_fca91a1e extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPDstrChannelHomeBean_fca91a1e
	 */
	public EJSCMPDstrChannelHomeBean_fca91a1e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelLocal create_Local(java.lang.String distributionChannel, java.lang.String salesGroup, java.lang.String channelRole, java.lang.String submitterRole) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(distributionChannel, salesGroup, channelRole, submitterRole);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(distributionChannel, salesGroup, channelRole, submitterRole);
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
	 * findAllDstrChannel_Local
	 */
	public java.util.Collection findAllDstrChannel_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllDstrChannel_Local();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey();
		keyClass.salesGroup = tmpEJB.getSalesGroup();
		keyClass.channelRole = tmpEJB.getChannelRole();
		keyClass.submitterRole = tmpEJB.getSubmitterRole();
		keyClass.distributionChannel = tmpEJB.getDistributionChannel();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey keyFromFields(java.lang.String f0, java.lang.String f1, java.lang.String f2, java.lang.String f3) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey();
		keyClass.salesGroup = f0;
		keyClass.channelRole = f1;
		keyClass.submitterRole = f2;
		keyClass.distributionChannel = f3;
		return keyClass;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;

/**
 * EJSCMPVariancePriceHomeBean_1913c3b9
 */
public class EJSCMPVariancePriceHomeBean_1913c3b9 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPVariancePriceHomeBean_1913c3b9
	 */
	public EJSCMPVariancePriceHomeBean_1913c3b9() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findByEE_Local
	 */
	public java.util.Collection findByEE_Local(int eeId, int swoid, int dmid, int custometId, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByEE_Local(eeId, swoid, dmid, custometId, proposalId);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceLocal create_Local(int priceId, int eeId, int swoId, int dmId, int customerId, int proposalId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(priceId, eeId, swoId, dmId, customerId, proposalId);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(priceId, eeId, swoId, dmId, customerId, proposalId);
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
	 * findByEEForVariance_Local
	 */
	public java.util.Collection findByEEForVariance_Local(int eeId, int swoid, int dmid, int custometId, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByEEForVariance_Local(eeId, swoid, dmid, custometId, proposalId);
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
	 * findMaxVariancePrice_Local
	 */
	public java.util.Collection findMaxVariancePrice_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMaxVariancePrice_Local();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteVariancePrice_1913c3b9) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey();
		keyClass.priceId = tmpEJB.getPriceId();
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey keyFromFields(int f0, int f1, int f2, int f3, int f4, int f5) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey();
		keyClass.priceId = f0;
		keyClass.eeId = f1;
		keyClass.swoId = f2;
		keyClass.dmId = f3;
		keyClass.customerId = f4;
		keyClass.proposalId = f5;
		return keyClass;
	}
}

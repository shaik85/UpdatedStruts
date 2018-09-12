package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTempEEHomeBean_6756a896
 */
public class EJSCMPTempEEHomeBean_6756a896 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTempEEHomeBean_6756a896
	 */
	public EJSCMPTempEEHomeBean_6756a896() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEELocal create_Local(int proposalId, int customerId, int dmId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEELocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(proposalId, customerId, dmId);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEELocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(proposalId, customerId, dmId);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEELocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEELocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteTempEE_6756a896 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteTempEE_6756a896) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey();
		keyClass.proposalId = tmpEJB.getProposalId();
		keyClass.customerId = tmpEJB.getCustomerId();
		keyClass.dmId = tmpEJB.getDmId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey keyFromFields(int f0, int f1, int f2) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey();
		keyClass.proposalId = f0;
		keyClass.customerId = f1;
		keyClass.dmId = f2;
		return keyClass;
	}
}

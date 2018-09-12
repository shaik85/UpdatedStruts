package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSWOHomeBean_05de4b81
 */
public class EJSCMPSWOHomeBean_05de4b81 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPSWOHomeBean_05de4b81
	 */
	public EJSCMPSWOHomeBean_05de4b81() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByProposal_Local
	 */
	public java.util.Collection findByProposal_Local(int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
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
	 * findSVCLicenseForProposal_Local
	 */
	public java.util.Collection findSVCLicenseForProposal_Local(int proposalId, java.lang.String itemCategory) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindSVCLicenseForProposal_Local(proposalId, itemCategory);
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
	 * findByQuotes_Local
	 */
	public java.util.Collection findByQuotes_Local(java.lang.String salesDocNo, int proposalId, java.lang.String swoItemNo) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByQuotes_Local(salesDocNo, proposalId, swoItemNo);
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
	 * findByDM_Local
	 */
	public java.util.Collection findByDM_Local(int dmId, int customerId, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByDM_Local(dmId, customerId, proposalId);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal create_Local(int swoId, int dmId, int customerId, int proposalId, java.lang.String swoNo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(swoId, dmId, customerId, proposalId, swoNo);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal) super.postCreate_Local(beanO, ejsKey, true);
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
	 * findMaxBumpInd_Local
	 */
	public java.util.Collection findMaxBumpInd_Local(java.lang.String salesDocNo, java.lang.String swoItemNo, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMaxBumpInd_Local(salesDocNo, swoItemNo, proposalId);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findByQuotesSoldToPartyDM_Local
	 */
	public java.util.Collection findByQuotesSoldToPartyDM_Local(java.lang.String salesDocNo, int proposalId, java.lang.String swoItemNo, int customerId, int dmId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByQuotesSoldToPartyDM_Local(salesDocNo, proposalId, swoItemNo, customerId, dmId);
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
	 * findByExtContrNumber_Local
	 */
	public java.util.Collection findByExtContrNumber_Local(int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByExtContrNumber_Local(proposalId);
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
	 * findMaxSquenceNo_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal findMaxSquenceNo_Local(java.lang.String salesDocNo, java.lang.String swoItemNo, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			pKey = bean.ejbFindMaxSquenceNo_Local(salesDocNo, swoItemNo, proposalId);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal)activateBean_Local(pKey);
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
	 * findByEquimentAndSalesDocNo_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal findByEquimentAndSalesDocNo_Local(java.lang.String equipmentNo, java.lang.String salesDocNo, int proposalID) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByEquimentAndSalesDocNo_Local(equipmentNo, salesDocNo, proposalID);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal)activateBean_Local(pKey);
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
	 * findExcludedLicenses_Local
	 */
	public java.util.Collection findExcludedLicenses_Local(int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindExcludedLicenses_Local(proposalId);
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
	 * findBySandSIndicator_Local
	 */
	public java.util.Collection findBySandSIndicator_Local(int proposalId, java.lang.String indicator) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindBySandSIndicator_Local(proposalId, indicator);
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
	 * findBySwoNoSerialNo_Local
	 */
	public java.util.Collection findBySwoNoSerialNo_Local(int proposalId, java.lang.String swoNo, java.lang.String serialNo) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindBySwoNoSerialNo_Local(proposalId, swoNo, serialNo);
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
	 * findByCustomer_Local
	 */
	public java.util.Collection findByCustomer_Local(int proposalId, int customerId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByCustomer_Local(proposalId, customerId);
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
	 * findByEquipSoldToPartyDM_Local
	 */
	public java.util.Collection findByEquipSoldToPartyDM_Local(java.lang.String equipmentNo, int proposalId, int customerId, int dmId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByEquipSoldToPartyDM_Local(equipmentNo, proposalId, customerId, dmId);
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
	 * findBySWONoSalesDocSwoItemNo_Local
	 */
	public java.util.Collection findBySWONoSalesDocSwoItemNo_Local(int proposalId, java.lang.String swoNo, java.lang.String salesDocNo, java.lang.String swoItemNo) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindBySWONoSalesDocSwoItemNo_Local(proposalId, swoNo, salesDocNo, swoItemNo);
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
	 * findBySalesDocNo_Local
	 */
	public java.util.Collection findBySalesDocNo_Local(java.lang.String salesDocNo, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindBySalesDocNo_Local(salesDocNo, proposalId);
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
	 * findByEquipmentNo_Local
	 */
	public java.util.Collection findByEquipmentNo_Local(java.lang.String equipmentNo, int proposalId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
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
	 * findMaxSWOId_Local
	 */
	public java.util.Collection findMaxSWOId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMaxSWOId_Local();
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81 tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.ConcreteSWO_05de4b81) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey();
		keyClass.swoId = tmpEJB.getSwoId();
		keyClass.dmId = tmpEJB.getDmId();
		keyClass.customerId = tmpEJB.getCustomerId();
		keyClass.proposalId = tmpEJB.getProposalId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey keyFromFields(int f0, int f1, int f2, int f3) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey();
		keyClass.swoId = f0;
		keyClass.dmId = f1;
		keyClass.customerId = f2;
		keyClass.proposalId = f3;
		return keyClass;
	}
}

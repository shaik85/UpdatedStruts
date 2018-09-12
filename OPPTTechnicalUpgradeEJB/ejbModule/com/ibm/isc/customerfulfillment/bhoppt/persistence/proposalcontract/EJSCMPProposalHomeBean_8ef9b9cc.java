package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProposalHomeBean_8ef9b9cc
 */
public class EJSCMPProposalHomeBean_8ef9b9cc extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPProposalHomeBean_8ef9b9cc
	 */
	public EJSCMPProposalHomeBean_8ef9b9cc() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByContrORExternalContrNum_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByContrORExternalContrNum_Local(java.lang.String cntrNum) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByContrORExternalContrNum_Local(cntrNum);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal)activateBean_Local(pKey);
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
	 * findByUserForDateRange_Local
	 */
	public java.util.Collection findByUserForDateRange_Local(java.lang.String createdBy, java.sql.Date startDate, java.sql.Date endDate) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByUserForDateRange_Local(createdBy, startDate, endDate);
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
	 * findByVarContractNo_Local
	 */
	public java.util.Collection findByVarContractNo_Local(java.lang.String orgVarContractNo, int contractPeriodVarNo) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByVarContractNo_Local(orgVarContractNo, contractPeriodVarNo);
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
	 * findByContractNumber_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByContractNumber_Local(java.lang.String contractNumber) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByContractNumber_Local(contractNumber);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal)activateBean_Local(pKey);
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
	 * findMaxContractNumber_Local
	 */
	public java.util.Collection findMaxContractNumber_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMaxContractNumber_Local();
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
	 * findByWaitingForApprovalForProposalApprover_Local
	 */
	public java.util.Collection findByWaitingForApprovalForProposalApprover_Local(java.lang.String approver) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByWaitingForApprovalForProposalApprover_Local(approver);
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
	 * findByLockedBy_Local
	 */
	public java.util.Collection findByLockedBy_Local(java.lang.String userId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByLockedBy_Local(userId);
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
	 * findByUserAndSalesOrg_Local
	 */
	public java.util.Collection findByUserAndSalesOrg_Local(java.lang.String userId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByUserAndSalesOrg_Local(userId);
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
	 * findByApprover_Local
	 */
	public java.util.Collection findByApprover_Local(java.lang.String userId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByApprover_Local(userId);
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
	 * findRelatedVarianceProposal_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findRelatedVarianceProposal_Local(java.lang.String orgVarianceContractNumber) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			pKey = bean.ejbFindRelatedVarianceProposal_Local(orgVarianceContractNumber);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal)activateBean_Local(pKey);
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
	 * findRelatedProposalForContract_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findRelatedProposalForContract_Local(java.lang.String oldContractNumber) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			pKey = bean.ejbFindRelatedProposalForContract_Local(oldContractNumber);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal)activateBean_Local(pKey);
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
	 * findByDateRangeForGroup_Local
	 */
	public java.util.Collection findByDateRangeForGroup_Local(java.lang.String createdBy, java.lang.String groupName, java.sql.Date startDate, java.sql.Date endDate) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByDateRangeForGroup_Local(createdBy, groupName, startDate, endDate);
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
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
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
	 * findByName_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByName_Local(java.lang.String proposalName) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByName_Local(proposalName);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal)activateBean_Local(pKey);
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
	 * findByCntrNumberORExternalCntrNumAndStatus_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByCntrNumberORExternalCntrNumAndStatus_Local(java.lang.String cntrNum) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByCntrNumberORExternalCntrNumAndStatus_Local(cntrNum);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal)activateBean_Local(pKey);
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
	 * findBySubmittedBy_Local
	 */
	public java.util.Collection findBySubmittedBy_Local(java.lang.String submittedBy) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindBySubmittedBy_Local(submittedBy);
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
	 * findByUserGroup_Local
	 */
	public java.util.Collection findByUserGroup_Local(java.lang.String createdBy, java.lang.String groupName) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByUserGroup_Local(createdBy, groupName);
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
	 * findAllVarianceContracts_Local
	 */
	public java.util.Collection findAllVarianceContracts_Local(java.lang.String contractNumber) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllVarianceContracts_Local(contractNumber);
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
	 * findByApproverFromGroup_Local
	 */
	public java.util.Collection findByApproverFromGroup_Local(java.lang.String approverId, java.lang.String groupName) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByApproverFromGroup_Local(approverId, groupName);
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
	 * findByWaitingForApproval_Local
	 */
	public java.util.Collection findByWaitingForApproval_Local(java.lang.String userId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByWaitingForApproval_Local(userId);
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
	 * findByWaitingForApprovalForCreateApprove_Local
	 */
	public java.util.Collection findByWaitingForApprovalForCreateApprove_Local(java.lang.String userId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByWaitingForApprovalForCreateApprove_Local(userId);
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
	 * findMaxProposalId_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findMaxProposalId_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			pKey = bean.ejbFindMaxProposalId_Local();
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal)activateBean_Local(pKey);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findProposalContractWaitingForCSOAndMark_Local
	 */
	public java.util.Collection findProposalContractWaitingForCSOAndMark_Local(java.lang.String createdBy) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindProposalContractWaitingForCSOAndMark_Local(createdBy);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal create_Local(int proposalId, java.lang.String proposalName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(proposalId, proposalName);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(proposalId, proposalName);
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
	 * findBytpContractNo_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findBytpContractNo_Local(java.lang.String tpContractNo) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal result = null;
		EntityBeanO beanO = null;

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) beanO.getEnterpriseBean();
			pKey = bean.ejbFindBytpContractNo_Local(tpContractNo);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal)activateBean_Local(pKey);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposal_8ef9b9cc) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey();
		keyClass.proposalId = tmpEJB.getProposalId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey keyFromFields(int f0) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey();
		keyClass.proposalId = f0;
		return keyClass;
	}
}

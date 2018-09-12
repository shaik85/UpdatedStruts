package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPProposalHome_8ef9b9cc
 */
public class EJSLocalCMPProposalHome_8ef9b9cc extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocalHome, com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ProposalBeanInternalLocalHome_8ef9b9cc {
	/**
	 * EJSLocalCMPProposalHome_8ef9b9cc
	 */
	public EJSLocalCMPProposalHome_8ef9b9cc() {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal create(int proposalId, java.lang.String proposalName) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(proposalId);
				_jacc_parms[1] = proposalName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(proposalId, proposalName);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 0, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByCntrNumberORExternalCntrNumAndStatus
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByCntrNumberORExternalCntrNumAndStatus(java.lang.String cntrNum) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cntrNum;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByCntrNumberORExternalCntrNumAndStatus_Local(cntrNum);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 1, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByContrORExternalContrNum
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByContrORExternalContrNum(java.lang.String cntrNum) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cntrNum;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByContrORExternalContrNum_Local(cntrNum);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 2, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByContractNumber
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByContractNumber(java.lang.String contractNumber) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = contractNumber;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByContractNumber_Local(contractNumber);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 3, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByName
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByName(java.lang.String proposalName) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByName_Local(proposalName);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 4, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByPrimaryKey_Local(primaryKey);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 5, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findBytpContractNo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findBytpContractNo(java.lang.String tpContractNo) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = tpContractNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findBytpContractNo_Local(tpContractNo);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 6, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findMaxProposalId
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findMaxProposalId() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findMaxProposalId_Local();
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 7, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findRelatedProposalForContract
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findRelatedProposalForContract(java.lang.String oldContractNumber) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = oldContractNumber;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findRelatedProposalForContract_Local(oldContractNumber);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 8, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findRelatedVarianceProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal findRelatedVarianceProposal(java.lang.String orgVarianceContractNumber) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = orgVarianceContractNumber;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findRelatedVarianceProposal_Local(orgVarianceContractNumber);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 9, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllVarianceContracts
	 */
	public java.util.Collection findAllVarianceContracts(java.lang.String contractNumber) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = contractNumber;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findAllVarianceContracts_Local(contractNumber);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 10, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByApprover
	 */
	public java.util.Collection findByApprover(java.lang.String userId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = userId;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByApprover_Local(userId);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 11, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByApproverFromGroup
	 */
	public java.util.Collection findByApproverFromGroup(java.lang.String approverId, java.lang.String groupName) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = approverId;
				_jacc_parms[1] = groupName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByApproverFromGroup_Local(approverId, groupName);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 12, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByDateRangeForGroup
	 */
	public java.util.Collection findByDateRangeForGroup(java.lang.String createdBy, java.lang.String groupName, java.sql.Date startDate, java.sql.Date endDate) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = createdBy;
				_jacc_parms[1] = groupName;
				_jacc_parms[2] = startDate;
				_jacc_parms[3] = endDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByDateRangeForGroup_Local(createdBy, groupName, startDate, endDate);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 13, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByLockedBy
	 */
	public java.util.Collection findByLockedBy(java.lang.String userId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = userId;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByLockedBy_Local(userId);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 14, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findBySubmittedBy
	 */
	public java.util.Collection findBySubmittedBy(java.lang.String submittedBy) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = submittedBy;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findBySubmittedBy_Local(submittedBy);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 15, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByUser
	 */
	public java.util.Collection findByUser(java.lang.String userId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = userId;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByUser_Local(userId);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 16, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByUserAndSalesOrg
	 */
	public java.util.Collection findByUserAndSalesOrg(java.lang.String userId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = userId;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByUserAndSalesOrg_Local(userId);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 17, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByUserForDateRange
	 */
	public java.util.Collection findByUserForDateRange(java.lang.String createdBy, java.sql.Date startDate, java.sql.Date endDate) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = createdBy;
				_jacc_parms[1] = startDate;
				_jacc_parms[2] = endDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByUserForDateRange_Local(createdBy, startDate, endDate);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 18, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByUserGroup
	 */
	public java.util.Collection findByUserGroup(java.lang.String createdBy, java.lang.String groupName) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = createdBy;
				_jacc_parms[1] = groupName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByUserGroup_Local(createdBy, groupName);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 19, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByVarContractNo
	 */
	public java.util.Collection findByVarContractNo(java.lang.String orgVarContractNo, int contractPeriodVarNo) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = orgVarContractNo;
				_jacc_parms[1] = new java.lang.Integer(contractPeriodVarNo);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByVarContractNo_Local(orgVarContractNo, contractPeriodVarNo);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 20, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByWaitingForApproval
	 */
	public java.util.Collection findByWaitingForApproval(java.lang.String userId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = userId;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByWaitingForApproval_Local(userId);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 21, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByWaitingForApprovalForCreateApprove
	 */
	public java.util.Collection findByWaitingForApprovalForCreateApprove(java.lang.String userId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = userId;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 22, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByWaitingForApprovalForCreateApprove_Local(userId);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 22, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByWaitingForApprovalForProposalApprover
	 */
	public java.util.Collection findByWaitingForApprovalForProposalApprover(java.lang.String approver) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = approver;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 23, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByWaitingForApprovalForProposalApprover_Local(approver);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 23, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findMaxContractNumber
	 */
	public java.util.Collection findMaxContractNumber() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 24, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findMaxContractNumber_Local();
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 24, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findProposalContractWaitingForCSOAndMark
	 */
	public java.util.Collection findProposalContractWaitingForCSOAndMark(java.lang.String createdBy) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = createdBy;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 25, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findProposalContractWaitingForCSOAndMark_Local(createdBy);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 25, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * remove
	 */
	public void remove(java.lang.Object primaryKey) throws javax.ejb.RemoveException, javax.ejb.EJBException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.EJSCMPProposalHomeBean_8ef9b9cc)container.preInvoke(this, 26, _EJS_s, _jacc_parms);
			_EJS_beanRef.remove(primaryKey);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.EJBException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 26, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

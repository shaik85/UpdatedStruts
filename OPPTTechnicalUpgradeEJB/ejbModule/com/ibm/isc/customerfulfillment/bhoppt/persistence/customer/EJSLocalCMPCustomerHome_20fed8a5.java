package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPCustomerHome_20fed8a5
 */
public class EJSLocalCMPCustomerHome_20fed8a5 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocalHome, com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.CustomerBeanInternalLocalHome_20fed8a5 {
	/**
	 * EJSLocalCMPCustomerHome_20fed8a5
	 */
	public EJSLocalCMPCustomerHome_20fed8a5() {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal create(int proposalId, int customerId, java.lang.String sapCustomerNo, java.sql.Date planStartDate, java.sql.Date planEndDate) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = new java.lang.Integer(proposalId);
				_jacc_parms[1] = new java.lang.Integer(customerId);
				_jacc_parms[2] = sapCustomerNo;
				_jacc_parms[3] = planStartDate;
				_jacc_parms[4] = planEndDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(proposalId, customerId, sapCustomerNo, planStartDate, planEndDate);
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
	 * findByPrimaryKey
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal findByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
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
	 * findBySapCustNo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal findBySapCustNo(int proposalId, java.lang.String sapCustomerNo) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(proposalId);
				_jacc_parms[1] = sapCustomerNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findBySapCustNo_Local(proposalId, sapCustomerNo);
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
	 * findBySapCustNoAndPlanStartEndDate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal findBySapCustNoAndPlanStartEndDate(int proposalId, java.lang.String sapCustomerNo, java.sql.Date planStartDate, java.sql.Date planEndDate) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = new java.lang.Integer(proposalId);
				_jacc_parms[1] = sapCustomerNo;
				_jacc_parms[2] = planStartDate;
				_jacc_parms[3] = planEndDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findBySapCustNoAndPlanStartEndDate_Local(proposalId, sapCustomerNo, planStartDate, planEndDate);
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
	 * findByProposal
	 */
	public java.util.Collection findByProposal(int proposalId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(proposalId);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByProposal_Local(proposalId);
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
	 * findByProposalAndCustomerList
	 */
	public java.util.Collection findByProposalAndCustomerList(int proposalId, java.lang.String customerListNo) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(proposalId);
				_jacc_parms[1] = customerListNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByProposalAndCustomerList_Local(proposalId, customerListNo);
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
	 * findByProposalStartEndDate
	 */
	public java.util.Collection findByProposalStartEndDate(int proposalId, java.sql.Date planStartDate, java.sql.Date planEndDate) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = new java.lang.Integer(proposalId);
				_jacc_parms[1] = planStartDate;
				_jacc_parms[2] = planEndDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByProposalStartEndDate_Local(proposalId, planStartDate, planEndDate);
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
	 * findMaxCustomerId
	 */
	public java.util.Collection findMaxCustomerId() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findMaxCustomerId_Local();
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
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.EJSCMPCustomerHomeBean_20fed8a5)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 8, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

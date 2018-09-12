package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPEEHome_53787648
 */
public class EJSLocalCMPEEHome_53787648 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocalHome, com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.EEBeanInternalLocalHome_53787648 {
	/**
	 * EJSLocalCMPEEHome_53787648
	 */
	public EJSLocalCMPEEHome_53787648() {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocal create(int eeId, int swoId, int dmId, int customerId, int proposalId, java.lang.String eeNo) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = new java.lang.Integer(eeId);
				_jacc_parms[1] = new java.lang.Integer(swoId);
				_jacc_parms[2] = new java.lang.Integer(dmId);
				_jacc_parms[3] = new java.lang.Integer(customerId);
				_jacc_parms[4] = new java.lang.Integer(proposalId);
				_jacc_parms[5] = eeNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(eeId, swoId, dmId, customerId, proposalId, eeNo);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocal findByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EEKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
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
	 * findByEENoSalesDocEEItemSwoItem
	 */
	public java.util.Collection findByEENoSalesDocEEItemSwoItem(int proposalId, java.lang.String eeNo, java.lang.String salesDocNo, java.lang.String eeItemNo, java.lang.String swoItemNo) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = new java.lang.Integer(proposalId);
				_jacc_parms[1] = eeNo;
				_jacc_parms[2] = salesDocNo;
				_jacc_parms[3] = eeItemNo;
				_jacc_parms[4] = swoItemNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByEENoSalesDocEEItemSwoItem_Local(proposalId, eeNo, salesDocNo, eeItemNo, swoItemNo);
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
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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
	 * findBySWO
	 */
	public java.util.Collection findBySWO(int swoId, int dmId, int customerId, int proposalId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = new java.lang.Integer(swoId);
				_jacc_parms[1] = new java.lang.Integer(dmId);
				_jacc_parms[2] = new java.lang.Integer(customerId);
				_jacc_parms[3] = new java.lang.Integer(proposalId);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findBySWO_Local(swoId, dmId, customerId, proposalId);
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
	 * findMaxEEId
	 */
	public java.util.Collection findMaxEEId() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findMaxEEId_Local();
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
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPEEHomeBean_53787648)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 6, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

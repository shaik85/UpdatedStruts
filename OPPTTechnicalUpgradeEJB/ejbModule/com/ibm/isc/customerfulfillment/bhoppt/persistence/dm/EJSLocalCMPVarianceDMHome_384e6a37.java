package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPVarianceDMHome_384e6a37
 */
public class EJSLocalCMPVarianceDMHome_384e6a37 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocalHome, com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.VarianceDMBeanInternalLocalHome_384e6a37 {
	/**
	 * EJSLocalCMPVarianceDMHome_384e6a37
	 */
	public EJSLocalCMPVarianceDMHome_384e6a37() {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocal create(int dmId, int customerId, int proposalId, java.lang.String dmNo) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = new java.lang.Integer(dmId);
				_jacc_parms[1] = new java.lang.Integer(customerId);
				_jacc_parms[2] = new java.lang.Integer(proposalId);
				_jacc_parms[3] = dmNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(dmId, customerId, proposalId, dmNo);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocal findByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
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
	 * findByCustomer
	 */
	public java.util.Collection findByCustomer(int proposalId, int customerId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(proposalId);
				_jacc_parms[1] = new java.lang.Integer(customerId);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByCustomer_Local(proposalId, customerId);
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
	 * findByDMNo
	 */
	public java.util.Collection findByDMNo(java.lang.String dmNo, int proposalId, int customerId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = dmNo;
				_jacc_parms[1] = new java.lang.Integer(proposalId);
				_jacc_parms[2] = new java.lang.Integer(customerId);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByDMNo_Local(dmNo, proposalId, customerId);
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
	public java.util.Collection findByProposal(int proposalID) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(proposalID);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByProposal_Local(proposalID);
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
	 * findMaxVarianceDMId
	 */
	public java.util.Collection findMaxVarianceDMId() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findMaxVarianceDMId_Local();
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
	com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.EJSCMPVarianceDMHomeBean_384e6a37)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
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

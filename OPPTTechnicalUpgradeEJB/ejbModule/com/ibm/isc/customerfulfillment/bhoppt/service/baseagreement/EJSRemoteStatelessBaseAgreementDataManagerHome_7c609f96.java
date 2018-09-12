package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessBaseAgreementDataManagerHome_7c609f96
 */
public class EJSRemoteStatelessBaseAgreementDataManagerHome_7c609f96 extends EJSWrapper implements com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerHome {
	/**
	 * EJSRemoteStatelessBaseAgreementDataManagerHome_7c609f96
	 */
	public EJSRemoteStatelessBaseAgreementDataManagerHome_7c609f96() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create();
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try {
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getEJBMetaData
	 */
	public javax.ejb.EJBMetaData getEJBMetaData() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		javax.ejb.EJBMetaData _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.getEJBMetaData();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try {
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getHomeHandle
	 */
	public javax.ejb.HomeHandle getHomeHandle() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		javax.ejb.HomeHandle _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.getHomeHandle();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try {
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * remove
	 */
	public void remove(java.lang.Object primaryKey) throws java.rmi.RemoteException, javax.ejb.RemoveException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_beanRef.remove(primaryKey);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try {
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * remove
	 */
	public void remove(javax.ejb.Handle handle) throws java.rmi.RemoteException, javax.ejb.RemoveException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = handle;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_beanRef.remove(handle);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try {
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPPriceHome_dffc00c5
 */
public class EJSLocalCMPPriceHome_dffc00c5 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocalHome, com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.PriceBeanInternalLocalHome_dffc00c5 {
	/**
	 * EJSLocalCMPPriceHome_dffc00c5
	 */
	public EJSLocalCMPPriceHome_dffc00c5() {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocal create(int priceId, int eeId, int swoId, int dmId, int customerId, int proposalId) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = new java.lang.Integer(priceId);
				_jacc_parms[1] = new java.lang.Integer(eeId);
				_jacc_parms[2] = new java.lang.Integer(swoId);
				_jacc_parms[3] = new java.lang.Integer(dmId);
				_jacc_parms[4] = new java.lang.Integer(customerId);
				_jacc_parms[5] = new java.lang.Integer(proposalId);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPPriceHomeBean_dffc00c5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPPriceHomeBean_dffc00c5)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(priceId, eeId, swoId, dmId, customerId, proposalId);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocal findByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPPriceHomeBean_dffc00c5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPPriceHomeBean_dffc00c5)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
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
	 * findByEE
	 */
	public java.util.Collection findByEE(int eeId, int swoId, int dmId, int customerId, int proposalId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = new java.lang.Integer(eeId);
				_jacc_parms[1] = new java.lang.Integer(swoId);
				_jacc_parms[2] = new java.lang.Integer(dmId);
				_jacc_parms[3] = new java.lang.Integer(customerId);
				_jacc_parms[4] = new java.lang.Integer(proposalId);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPPriceHomeBean_dffc00c5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPPriceHomeBean_dffc00c5)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByEE_Local(eeId, swoId, dmId, customerId, proposalId);
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
	 * findMaxPriceId
	 */
	public java.util.Collection findMaxPriceId() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPPriceHomeBean_dffc00c5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPPriceHomeBean_dffc00c5)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findMaxPriceId_Local();
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
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPPriceHomeBean_dffc00c5 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPPriceHomeBean_dffc00c5)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 4, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPHistorySWOHome_2fe0d772
 */
public class EJSLocalCMPHistorySWOHome_2fe0d772 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocalHome, com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.HistorySWOBeanInternalLocalHome_2fe0d772 {
	/**
	 * EJSLocalCMPHistorySWOHome_2fe0d772
	 */
	public EJSLocalCMPHistorySWOHome_2fe0d772() {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocal create(int swoId, int dmId, int customerId, int proposalId, java.lang.String swoNo, java.sql.Date lastUpdatedDate) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = new java.lang.Integer(swoId);
				_jacc_parms[1] = new java.lang.Integer(dmId);
				_jacc_parms[2] = new java.lang.Integer(customerId);
				_jacc_parms[3] = new java.lang.Integer(proposalId);
				_jacc_parms[4] = swoNo;
				_jacc_parms[5] = lastUpdatedDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPHistorySWOHomeBean_2fe0d772 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPHistorySWOHomeBean_2fe0d772)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(swoId, dmId, customerId, proposalId, swoNo, lastUpdatedDate);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocal findByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPHistorySWOHomeBean_2fe0d772 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPHistorySWOHomeBean_2fe0d772)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
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
	 * findMaxSWOId
	 */
	public java.util.Collection findMaxSWOId() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPHistorySWOHomeBean_2fe0d772 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPHistorySWOHomeBean_2fe0d772)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findMaxSWOId_Local();
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
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPHistorySWOHomeBean_2fe0d772 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPHistorySWOHomeBean_2fe0d772)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 3, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

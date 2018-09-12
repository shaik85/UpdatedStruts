package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPBPLegacyNoHome_f2446ac8
 */
public class EJSLocalCMPBPLegacyNoHome_f2446ac8 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoLocalHome, com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BPLegacyNoBeanInternalLocalHome_f2446ac8 {
	/**
	 * EJSLocalCMPBPLegacyNoHome_f2446ac8
	 */
	public EJSLocalCMPBPLegacyNoHome_f2446ac8() {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoLocal create(java.lang.String userId, java.lang.String legacyNo, java.lang.String addressSeqNo) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = userId;
				_jacc_parms[1] = legacyNo;
				_jacc_parms[2] = addressSeqNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.EJSCMPBPLegacyNoHomeBean_f2446ac8 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.EJSCMPBPLegacyNoHomeBean_f2446ac8)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(userId, legacyNo, addressSeqNo);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoLocal findByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.EJSCMPBPLegacyNoHomeBean_f2446ac8 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.EJSCMPBPLegacyNoHomeBean_f2446ac8)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
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
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.EJSCMPBPLegacyNoHomeBean_f2446ac8 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.EJSCMPBPLegacyNoHomeBean_f2446ac8)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
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
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.EJSCMPBPLegacyNoHomeBean_f2446ac8 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.EJSCMPBPLegacyNoHomeBean_f2446ac8)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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

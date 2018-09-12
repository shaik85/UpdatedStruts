package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPUserType_178cdb2e
 */
public class EJSLocalCMPUserType_178cdb2e extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeLocal {
	/**
	 * EJSLocalCMPUserType_178cdb2e
	 */
	public EJSLocalCMPUserType_178cdb2e() {
		super();	}
	/**
	 * getUserType
	 */
	public java.lang.String getUserType() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getUserType();
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
	 * getUserTypeDescription
	 */
	public java.lang.String getUserTypeDescription() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getUserTypeDescription();
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
	 * setUserType
	 */
	public void setUserType(java.lang.String newUserType) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newUserType;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			beanRef.setUserType(newUserType);
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
		return ;
	}
	/**
	 * setUserTypeDescription
	 */
	public void setUserTypeDescription(java.lang.String newUserTypeDescription) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newUserTypeDescription;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			beanRef.setUserTypeDescription(newUserTypeDescription);
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

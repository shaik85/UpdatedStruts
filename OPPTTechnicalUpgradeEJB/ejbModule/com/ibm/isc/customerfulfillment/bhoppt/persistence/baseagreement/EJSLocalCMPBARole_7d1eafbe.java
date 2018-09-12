package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPBARole_7d1eafbe
 */
public class EJSLocalCMPBARole_7d1eafbe extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleLocal {
	/**
	 * EJSLocalCMPBARole_7d1eafbe
	 */
	public EJSLocalCMPBARole_7d1eafbe() {
		super();	}
	/**
	 * getBaseAgreementRole
	 */
	public java.lang.String getBaseAgreementRole() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBaseAgreementRole();
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
	 * getBaseAgreementRoleDescription
	 */
	public java.lang.String getBaseAgreementRoleDescription() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBaseAgreementRoleDescription();
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
	 * setBaseAgreementRole
	 */
	public void setBaseAgreementRole(java.lang.String newBaseAgreementRole) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBaseAgreementRole;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			beanRef.setBaseAgreementRole(newBaseAgreementRole);
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
	 * setBaseAgreementRoleDescription
	 */
	public void setBaseAgreementRoleDescription(java.lang.String newBaseAgreementRoleDescription) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBaseAgreementRoleDescription;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			beanRef.setBaseAgreementRoleDescription(newBaseAgreementRoleDescription);
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

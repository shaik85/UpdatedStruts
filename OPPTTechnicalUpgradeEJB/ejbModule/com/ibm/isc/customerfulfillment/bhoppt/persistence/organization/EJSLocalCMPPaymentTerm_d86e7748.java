package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPPaymentTerm_d86e7748
 */
public class EJSLocalCMPPaymentTerm_d86e7748 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermLocal {
	/**
	 * EJSLocalCMPPaymentTerm_d86e7748
	 */
	public EJSLocalCMPPaymentTerm_d86e7748() {
		super();	}
	/**
	 * getPaymentTerm
	 */
	public java.lang.String getPaymentTerm() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPaymentTerm();
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
	 * getPaymentTermDesc
	 */
	public java.lang.String getPaymentTermDesc() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPaymentTermDesc();
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
	 * setPaymentTerm
	 */
	public void setPaymentTerm(java.lang.String newPaymentTerm) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPaymentTerm;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			beanRef.setPaymentTerm(newPaymentTerm);
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
	 * setPaymentTermDesc
	 */
	public void setPaymentTermDesc(java.lang.String newPaymentTermDesc) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPaymentTermDesc;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			beanRef.setPaymentTermDesc(newPaymentTermDesc);
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

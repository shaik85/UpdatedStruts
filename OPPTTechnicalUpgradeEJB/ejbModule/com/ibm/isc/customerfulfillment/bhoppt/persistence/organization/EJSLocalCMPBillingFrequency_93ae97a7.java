package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPBillingFrequency_93ae97a7
 */
public class EJSLocalCMPBillingFrequency_93ae97a7 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyLocal {
	/**
	 * EJSLocalCMPBillingFrequency_93ae97a7
	 */
	public EJSLocalCMPBillingFrequency_93ae97a7() {
		super();	}
	/**
	 * getBillingFreqCode
	 */
	public java.lang.String getBillingFreqCode() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBillingFreqCode();
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
	 * getBillingFreqDescription
	 */
	public java.lang.String getBillingFreqDescription() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBillingFreqDescription();
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
	 * setBillingFreqCode
	 */
	public void setBillingFreqCode(java.lang.String newBillingFreqCode) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBillingFreqCode;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			beanRef.setBillingFreqCode(newBillingFreqCode);
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
	 * setBillingFreqDescription
	 */
	public void setBillingFreqDescription(java.lang.String newBillingFreqDesc) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBillingFreqDesc;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			beanRef.setBillingFreqDescription(newBillingFreqDesc);
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

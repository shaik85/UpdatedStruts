package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPBillingBlock_fa467edc
 */
public class EJSLocalCMPBillingBlock_fa467edc extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockLocal {
	/**
	 * EJSLocalCMPBillingBlock_fa467edc
	 */
	public EJSLocalCMPBillingBlock_fa467edc() {
		super();	}
	/**
	 * getBillingBlock
	 */
	public java.lang.String getBillingBlock() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBillingBlock();
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
	 * getBillingBlockDescription
	 */
	public java.lang.String getBillingBlockDescription() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBillingBlockDescription();
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
	 * setBillingBlock
	 */
	public void setBillingBlock(java.lang.String newBillingBlock) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBillingBlock;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			beanRef.setBillingBlock(newBillingBlock);
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
	 * setBillingBlockDescription
	 */
	public void setBillingBlockDescription(java.lang.String newBillingBlockDesc) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBillingBlockDesc;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			beanRef.setBillingBlockDescription(newBillingBlockDesc);
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

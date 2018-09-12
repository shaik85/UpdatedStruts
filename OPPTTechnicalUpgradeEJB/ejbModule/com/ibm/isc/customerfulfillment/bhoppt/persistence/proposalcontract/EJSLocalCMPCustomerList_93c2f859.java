package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPCustomerList_93c2f859
 */
public class EJSLocalCMPCustomerList_93c2f859 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListLocal {
	/**
	 * EJSLocalCMPCustomerList_93c2f859
	 */
	public EJSLocalCMPCustomerList_93c2f859() {
		super();	}
	/**
	 * getCustomerListName
	 */
	public java.lang.String getCustomerListName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCustomerListName();
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
	 * getLastUpdatedDate
	 */
	public java.sql.Date getLastUpdatedDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getLastUpdatedDate();
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
	 * setCustomerListName
	 */
	public void setCustomerListName(java.lang.String newCustomerListName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCustomerListName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			beanRef.setCustomerListName(newCustomerListName);
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
	 * setLastUpdatedDate
	 */
	public void setLastUpdatedDate(java.sql.Date newLastUpdatedDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newLastUpdatedDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			beanRef.setLastUpdatedDate(newLastUpdatedDate);
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

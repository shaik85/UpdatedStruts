package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPHistoryCustomer_44a753d1
 */
public class EJSLocalCMPHistoryCustomer_44a753d1 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerLocal {
	/**
	 * EJSLocalCMPHistoryCustomer_44a753d1
	 */
	public EJSLocalCMPHistoryCustomer_44a753d1() {
		super();	}
	/**
	 * getCustomerId
	 */
	public int getCustomerId() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCustomerId();
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
	 * getProposalId
	 */
	public int getProposalId() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getProposalId();
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
	 * getBillToPartyASNo
	 */
	public java.lang.String getBillToPartyASNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBillToPartyASNo();
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
	 * getBillToPartyLNo
	 */
	public java.lang.String getBillToPartyLNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBillToPartyLNo();
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
	 * getBillToPartyName
	 */
	public java.lang.String getBillToPartyName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBillToPartyName();
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
		return _EJS_result;
	}
	/**
	 * getBillToPartyNo
	 */
	public java.lang.String getBillToPartyNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBillToPartyNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 5, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCustomerASNo
	 */
	public java.lang.String getCustomerASNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCustomerASNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 6, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCustomerListNo
	 */
	public java.lang.String getCustomerListNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCustomerListNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 7, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLegacyCustomerNo
	 */
	public java.lang.String getLegacyCustomerNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getLegacyCustomerNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 8, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPayerASNo
	 */
	public java.lang.String getPayerASNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPayerASNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 9, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPayerLNo
	 */
	public java.lang.String getPayerLNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPayerLNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 10, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPayerName
	 */
	public java.lang.String getPayerName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPayerName();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 11, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPayerNo
	 */
	public java.lang.String getPayerNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPayerNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 12, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSapCustomerName
	 */
	public java.lang.String getSapCustomerName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSapCustomerName();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 13, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSapCustomerNo
	 */
	public java.lang.String getSapCustomerNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSapCustomerNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 14, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getShipToPartyASNo
	 */
	public java.lang.String getShipToPartyASNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getShipToPartyASNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 15, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getShipToPartyLNo
	 */
	public java.lang.String getShipToPartyLNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getShipToPartyLNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 16, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getShipToPartyName
	 */
	public java.lang.String getShipToPartyName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getShipToPartyName();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 17, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getShipToPartyNo
	 */
	public java.lang.String getShipToPartyNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getShipToPartyNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 18, _EJS_s);
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
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 19, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPlanEndDate
	 */
	public java.sql.Date getPlanEndDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPlanEndDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 20, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPlanStartDate
	 */
	public java.sql.Date getPlanStartDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPlanStartDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 21, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * setBillToPartyASNo
	 */
	public void setBillToPartyASNo(java.lang.String newBillToPartyASNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBillToPartyASNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 22, _EJS_s, _jacc_parms);
			beanRef.setBillToPartyASNo(newBillToPartyASNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 22, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setBillToPartyLNo
	 */
	public void setBillToPartyLNo(java.lang.String newBillToPartyLNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBillToPartyLNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 23, _EJS_s, _jacc_parms);
			beanRef.setBillToPartyLNo(newBillToPartyLNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 23, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setBillToPartyName
	 */
	public void setBillToPartyName(java.lang.String newBillToPartyName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBillToPartyName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 24, _EJS_s, _jacc_parms);
			beanRef.setBillToPartyName(newBillToPartyName);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 24, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setBillToPartyNo
	 */
	public void setBillToPartyNo(java.lang.String newBillToPartyNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBillToPartyNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 25, _EJS_s, _jacc_parms);
			beanRef.setBillToPartyNo(newBillToPartyNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 25, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCustomerASNo
	 */
	public void setCustomerASNo(java.lang.String newCustomerASNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCustomerASNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 26, _EJS_s, _jacc_parms);
			beanRef.setCustomerASNo(newCustomerASNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 26, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCustomerId
	 */
	public void setCustomerId(int newCustomerId) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(newCustomerId);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 27, _EJS_s, _jacc_parms);
			beanRef.setCustomerId(newCustomerId);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 27, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCustomerListNo
	 */
	public void setCustomerListNo(java.lang.String newCustomerListNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCustomerListNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 28, _EJS_s, _jacc_parms);
			beanRef.setCustomerListNo(newCustomerListNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 28, _EJS_s);
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
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 29, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 29, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setLegacyCustomerNo
	 */
	public void setLegacyCustomerNo(java.lang.String newLegacyCustomerNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newLegacyCustomerNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 30, _EJS_s, _jacc_parms);
			beanRef.setLegacyCustomerNo(newLegacyCustomerNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 30, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPayerASNo
	 */
	public void setPayerASNo(java.lang.String newPayerASNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPayerASNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 31, _EJS_s, _jacc_parms);
			beanRef.setPayerASNo(newPayerASNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 31, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPayerLNo
	 */
	public void setPayerLNo(java.lang.String newPayerLNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPayerLNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 32, _EJS_s, _jacc_parms);
			beanRef.setPayerLNo(newPayerLNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 32, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPayerName
	 */
	public void setPayerName(java.lang.String newPayerName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPayerName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 33, _EJS_s, _jacc_parms);
			beanRef.setPayerName(newPayerName);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 33, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPayerNo
	 */
	public void setPayerNo(java.lang.String newPayerNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPayerNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 34, _EJS_s, _jacc_parms);
			beanRef.setPayerNo(newPayerNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 34, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPlanEndDate
	 */
	public void setPlanEndDate(java.sql.Date newPlanEndDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPlanEndDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 35, _EJS_s, _jacc_parms);
			beanRef.setPlanEndDate(newPlanEndDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 35, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPlanStartDate
	 */
	public void setPlanStartDate(java.sql.Date newPlanStartDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPlanStartDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 36, _EJS_s, _jacc_parms);
			beanRef.setPlanStartDate(newPlanStartDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 36, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setProposalId
	 */
	public void setProposalId(int newProposalId) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(newProposalId);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 37, _EJS_s, _jacc_parms);
			beanRef.setProposalId(newProposalId);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 37, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSapCustomerName
	 */
	public void setSapCustomerName(java.lang.String newSapCustomerName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSapCustomerName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 38, _EJS_s, _jacc_parms);
			beanRef.setSapCustomerName(newSapCustomerName);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 38, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSapCustomerNo
	 */
	public void setSapCustomerNo(java.lang.String newSapCustomerNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSapCustomerNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 39, _EJS_s, _jacc_parms);
			beanRef.setSapCustomerNo(newSapCustomerNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 39, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setShipToPartyASNo
	 */
	public void setShipToPartyASNo(java.lang.String newShipToPartyASNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newShipToPartyASNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 40, _EJS_s, _jacc_parms);
			beanRef.setShipToPartyASNo(newShipToPartyASNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 40, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setShipToPartyLNo
	 */
	public void setShipToPartyLNo(java.lang.String newShipToPartyLNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newShipToPartyLNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 41, _EJS_s, _jacc_parms);
			beanRef.setShipToPartyLNo(newShipToPartyLNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 41, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setShipToPartyName
	 */
	public void setShipToPartyName(java.lang.String newShipToPartyName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newShipToPartyName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 42, _EJS_s, _jacc_parms);
			beanRef.setShipToPartyName(newShipToPartyName);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 42, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setShipToPartyNo
	 */
	public void setShipToPartyNo(java.lang.String newShipToPartyNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newShipToPartyNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerBean)container.preInvoke(this, 43, _EJS_s, _jacc_parms);
			beanRef.setShipToPartyNo(newShipToPartyNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 43, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

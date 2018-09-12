package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPBaseAgreementForm_5d3cd1d7
 */
public class EJSLocalCMPBaseAgreementForm_5d3cd1d7 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormLocal {
	/**
	 * EJSLocalCMPBaseAgreementForm_5d3cd1d7
	 */
	public EJSLocalCMPBaseAgreementForm_5d3cd1d7() {
		super();	}
	/**
	 * getFormLongDescription
	 */
	public java.lang.String getFormLongDescription() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getFormLongDescription();
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
	 * getFormNumber
	 */
	public java.lang.String getFormNumber() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getFormNumber();
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
	 * getFormShortDescription
	 */
	public java.lang.String getFormShortDescription() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getFormShortDescription();
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
	 * getSalesOrganization
	 */
	public java.lang.String getSalesOrganization() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSalesOrganization();
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
	 * setFormLongDescription
	 */
	public void setFormLongDescription(java.lang.String newFormLongDescription) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newFormLongDescription;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			beanRef.setFormLongDescription(newFormLongDescription);
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
	/**
	 * setFormNumber
	 */
	public void setFormNumber(java.lang.String newFormNumber) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newFormNumber;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			beanRef.setFormNumber(newFormNumber);
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
		return ;
	}
	/**
	 * setFormShortDescription
	 */
	public void setFormShortDescription(java.lang.String newFormShortDescription) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newFormShortDescription;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			beanRef.setFormShortDescription(newFormShortDescription);
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
		return ;
	}
	/**
	 * setSalesOrganization
	 */
	public void setSalesOrganization(java.lang.String newSalesOrganization) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSalesOrganization;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			beanRef.setSalesOrganization(newSalesOrganization);
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
		return ;
	}
}

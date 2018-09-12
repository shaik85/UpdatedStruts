package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPGeoSecOff_4c848b5a
 */
public class EJSLocalCMPGeoSecOff_4c848b5a extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal {
	/**
	 * EJSLocalCMPGeoSecOff_4c848b5a
	 */
	public EJSLocalCMPGeoSecOff_4c848b5a() {
		super();	}
	/**
	 * getGeoSecOffSo
	 */
	public java.lang.String getGeoSecOffSo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getGeoSecOffSo();
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
	 * getSalesOrg
	 */
	public java.lang.String getSalesOrg() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSalesOrg();
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
	 * setGeoSecOffSo
	 */
	public void setGeoSecOffSo(java.lang.String newGeoSecOffSo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newGeoSecOffSo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			beanRef.setGeoSecOffSo(newGeoSecOffSo);
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
	 * setSalesOrg
	 */
	public void setSalesOrg(java.lang.String newSalesOrg) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSalesOrg;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			beanRef.setSalesOrg(newSalesOrg);
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

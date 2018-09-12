package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalStatelessESWData_17c58614
 */
public class EJSLocalStatelessESWData_17c58614 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ESWDataLocal {
	/**
	 * EJSLocalStatelessESWData_17c58614
	 */
	public EJSLocalStatelessESWData_17c58614() {
		super();	}
	/**
	 * retrieveESWData
	 */
	public java.util.Map retrieveESWData(java.lang.String sessionId, int proposalId, java.lang.String transAttribute) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Map _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = sessionId;
				_jacc_parms[1] = new java.lang.Integer(proposalId);
				_jacc_parms[2] = transAttribute;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ESWDataBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ESWDataBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveESWData(sessionId, proposalId, transAttribute);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
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
	 * deleteESWData
	 */
	public void deleteESWData(java.lang.String sessionId, int proposalId, java.lang.String transAttribute) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = sessionId;
				_jacc_parms[1] = new java.lang.Integer(proposalId);
				_jacc_parms[2] = transAttribute;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ESWDataBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ESWDataBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			beanRef.deleteESWData(sessionId, proposalId, transAttribute);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
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
		return ;
	}
	/**
	 * storeESWData
	 */
	public void storeESWData(java.lang.String sessionId, com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface dtoList, int proposalId, java.lang.String transAttribute) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = sessionId;
				_jacc_parms[1] = dtoList;
				_jacc_parms[2] = new java.lang.Integer(proposalId);
				_jacc_parms[3] = transAttribute;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ESWDataBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ESWDataBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			beanRef.storeESWData(sessionId, dtoList, proposalId, transAttribute);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
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
		return ;
	}
}

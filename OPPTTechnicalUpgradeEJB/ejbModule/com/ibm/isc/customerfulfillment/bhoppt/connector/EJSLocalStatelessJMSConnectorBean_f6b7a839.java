package com.ibm.isc.customerfulfillment.bhoppt.connector;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalStatelessJMSConnectorBean_f6b7a839
 */
public class EJSLocalStatelessJMSConnectorBean_f6b7a839 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocal {
	/**
	 * EJSLocalStatelessJMSConnectorBean_f6b7a839
	 */
	public EJSLocalStatelessJMSConnectorBean_f6b7a839() {
		super();	}
	/**
	 * sendReceive
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface sendReceive(com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface aConnectorDTO) throws java.lang.Exception {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = aConnectorDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.sendReceive(aConnectorDTO);
		}
		catch (java.lang.RuntimeException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (java.lang.Exception ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
}

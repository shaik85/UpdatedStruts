package com.ibm.isc.customerfulfillment.bhoppt.connector;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessJMSConnectorBeanHomeBean_f6b7a839
 */
public class EJSStatelessJMSConnectorBeanHomeBean_f6b7a839 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessJMSConnectorBeanHomeBean_f6b7a839
	 */
	public EJSStatelessJMSConnectorBeanHomeBean_f6b7a839() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocal) super.createWrapper_Local(null);
}
catch (javax.ejb.CreateException ex) {
	createFailed = true;
	throw ex;
} catch (java.rmi.RemoteException ex) {
	createFailed = true;
	throw ex;
} catch (Throwable ex) {
	createFailed = true;
	throw new CreateFailureException(ex);
} finally {
	if (createFailed) {
		super.createFailure(beanO);
	}
}
return result;	}
}

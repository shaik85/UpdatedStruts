package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessErrorListManagerHomeBean_99e95df1
 */
public class EJSStatelessErrorListManagerHomeBean_99e95df1 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessErrorListManagerHomeBean_99e95df1
	 */
	public EJSStatelessErrorListManagerHomeBean_99e95df1() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ErrorListManagerLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ErrorListManagerLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ErrorListManagerLocal) super.createWrapper_Local(null);
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

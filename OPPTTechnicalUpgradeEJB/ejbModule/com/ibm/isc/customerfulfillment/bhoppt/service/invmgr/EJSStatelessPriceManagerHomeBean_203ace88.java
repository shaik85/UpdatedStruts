package com.ibm.isc.customerfulfillment.bhoppt.service.invmgr;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessPriceManagerHomeBean_203ace88
 */
public class EJSStatelessPriceManagerHomeBean_203ace88 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessPriceManagerHomeBean_203ace88
	 */
	public EJSStatelessPriceManagerHomeBean_203ace88() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.PriceManagerLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.PriceManagerLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.PriceManagerLocal) super.createWrapper_Local(null);
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

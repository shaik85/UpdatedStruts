package com.ibm.isc.customerfulfillment.bhoppt.service.swomgr;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessEEPriceManagerHomeBean_4822c50e
 */
public class EJSStatelessEEPriceManagerHomeBean_4822c50e extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessEEPriceManagerHomeBean_4822c50e
	 */
	public EJSStatelessEEPriceManagerHomeBean_4822c50e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerLocal) super.createWrapper_Local(null);
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

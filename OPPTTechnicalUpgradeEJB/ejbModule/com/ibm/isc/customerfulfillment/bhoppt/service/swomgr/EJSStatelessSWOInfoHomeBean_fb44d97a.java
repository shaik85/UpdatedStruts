package com.ibm.isc.customerfulfillment.bhoppt.service.swomgr;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSWOInfoHomeBean_fb44d97a
 */
public class EJSStatelessSWOInfoHomeBean_fb44d97a extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSWOInfoHomeBean_fb44d97a
	 */
	public EJSStatelessSWOInfoHomeBean_fb44d97a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOInfoLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOInfoLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOInfoLocal) super.createWrapper_Local(null);
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

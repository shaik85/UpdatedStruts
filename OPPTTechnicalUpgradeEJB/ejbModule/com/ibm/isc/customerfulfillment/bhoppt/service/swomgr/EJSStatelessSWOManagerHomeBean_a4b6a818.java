package com.ibm.isc.customerfulfillment.bhoppt.service.swomgr;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSWOManagerHomeBean_a4b6a818
 */
public class EJSStatelessSWOManagerHomeBean_a4b6a818 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSWOManagerHomeBean_a4b6a818
	 */
	public EJSStatelessSWOManagerHomeBean_a4b6a818() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocal) super.createWrapper_Local(null);
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

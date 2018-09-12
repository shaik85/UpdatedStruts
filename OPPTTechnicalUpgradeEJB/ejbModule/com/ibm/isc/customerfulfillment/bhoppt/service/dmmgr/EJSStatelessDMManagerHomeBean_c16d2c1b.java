package com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessDMManagerHomeBean_c16d2c1b
 */
public class EJSStatelessDMManagerHomeBean_c16d2c1b extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessDMManagerHomeBean_c16d2c1b
	 */
	public EJSStatelessDMManagerHomeBean_c16d2c1b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerLocal) super.createWrapper_Local(null);
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

package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessGroupManagerHomeBean_7a4fb73f
 */
public class EJSStatelessGroupManagerHomeBean_7a4fb73f extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessGroupManagerHomeBean_7a4fb73f
	 */
	public EJSStatelessGroupManagerHomeBean_7a4fb73f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManager create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManager result = null;
boolean createFailed = false;
try {
	result = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManager) super.createWrapper(null);
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

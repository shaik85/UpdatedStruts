package com.ibm.isc.customerfulfillment.bhoppt.service.invmgr;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessInventoryManagerHomeBean_20b0cef5
 */
public class EJSStatelessInventoryManagerHomeBean_20b0cef5 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessInventoryManagerHomeBean_20b0cef5
	 */
	public EJSStatelessInventoryManagerHomeBean_20b0cef5() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerLocal) super.createWrapper_Local(null);
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

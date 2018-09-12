package com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessReportManagerHomeBean_9f8cce5a
 */
public class EJSStatelessReportManagerHomeBean_9f8cce5a extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessReportManagerHomeBean_9f8cce5a
	 */
	public EJSStatelessReportManagerHomeBean_9f8cce5a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManager create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManager result = null;
boolean createFailed = false;
try {
	result = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManager) super.createWrapper(null);
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

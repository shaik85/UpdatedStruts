package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessBaseAgreementManagerHomeBean_40bf7af9
 */
public class EJSStatelessBaseAgreementManagerHomeBean_40bf7af9 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessBaseAgreementManagerHomeBean_40bf7af9
	 */
	public EJSStatelessBaseAgreementManagerHomeBean_40bf7af9() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManager create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManager result = null;
boolean createFailed = false;
try {
	result = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManager) super.createWrapper(null);
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

package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96
 */
public class EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96
	 */
	public EJSStatelessBaseAgreementDataManagerHomeBean_7c609f96() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager result = null;
boolean createFailed = false;
try {
	result = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager) super.createWrapper(null);
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

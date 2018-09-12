package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalStatelessErrorListManager_99e95df1
 */
public class EJSLocalStatelessErrorListManager_99e95df1 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ErrorListManagerLocal {
	/**
	 * EJSLocalStatelessErrorListManager_99e95df1
	 */
	public EJSLocalStatelessErrorListManager_99e95df1() {
		super();	}
	/**
	 * storeErrorList
	 */
	public void storeErrorList(com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ErrorListBO errorListBO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = errorListBO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ErrorListManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ErrorListManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			beanRef.storeErrorList(errorListBO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 0, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

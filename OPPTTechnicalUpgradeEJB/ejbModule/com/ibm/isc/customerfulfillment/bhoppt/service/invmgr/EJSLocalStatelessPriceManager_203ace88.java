package com.ibm.isc.customerfulfillment.bhoppt.service.invmgr;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalStatelessPriceManager_203ace88
 */
public class EJSLocalStatelessPriceManager_203ace88 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.PriceManagerLocal {
	/**
	 * EJSLocalStatelessPriceManager_203ace88
	 */
	public EJSLocalStatelessPriceManager_203ace88() {
		super();	}
	/**
	 * priceProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO priceProposal(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO priceProposalDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = priceProposalDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.PriceManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.PriceManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.priceProposal(priceProposalDomainDTO);
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
		return _EJS_result;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.service.swomgr;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalStatelessEEPriceManager_4822c50e
 */
public class EJSLocalStatelessEEPriceManager_4822c50e extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerLocal {
	/**
	 * EJSLocalStatelessEEPriceManager_4822c50e
	 */
	public EJSLocalStatelessEEPriceManager_4822c50e() {
		super();	}
	/**
	 * calculatePrice
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO calculatePrice(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO priceProposalDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = priceProposalDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.calculatePrice(priceProposalDomainDTO);
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
	/**
	 * priceAnnivAmtProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO priceAnnivAmtProposal(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO priceProposalDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = priceProposalDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.priceAnnivAmtProposal(priceProposalDomainDTO);
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
				container.postInvoke(this, 1, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * priceAnnivEASExcludedProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO priceAnnivEASExcludedProposal(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO priceProposalDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = priceProposalDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.priceAnnivEASExcludedProposal(priceProposalDomainDTO);
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
				container.postInvoke(this, 2, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * priceVariance
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO priceVariance(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO priceProposalDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = priceProposalDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.priceVariance(priceProposalDomainDTO);
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
				container.postInvoke(this, 3, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * updateProposalPricingDetails
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO updateProposalPricingDetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO priceProposalDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = priceProposalDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateProposalPricingDetails(priceProposalDomainDTO);
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
				container.postInvoke(this, 4, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}

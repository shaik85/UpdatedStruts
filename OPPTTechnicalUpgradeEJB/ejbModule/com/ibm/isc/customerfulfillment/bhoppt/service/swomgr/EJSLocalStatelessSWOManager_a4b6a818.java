package com.ibm.isc.customerfulfillment.bhoppt.service.swomgr;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalStatelessSWOManager_a4b6a818
 */
public class EJSLocalStatelessSWOManager_a4b6a818 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocal {
	/**
	 * EJSLocalStatelessSWOManager_a4b6a818
	 */
	public EJSLocalStatelessSWOManager_a4b6a818() {
		super();	}
	/**
	 * chkSVCLicense
	 */
	public boolean chkSVCLicense(int ProposalID, java.lang.String transactionName) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(ProposalID);
				_jacc_parms[1] = transactionName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.chkSVCLicense(ProposalID, transactionName);
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
	 * chkSandSLicense
	 */
	public boolean chkSandSLicense(int ProposalID, java.lang.String flag) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(ProposalID);
				_jacc_parms[1] = flag;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.chkSandSLicense(ProposalID, flag);
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
	 * excludeIncludeSWO
	 */
	public boolean excludeIncludeSWO(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO[] licenses) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = licenses;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.excludeIncludeSWO(licenses);
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
	 * excludeIncludeSWOsOfCustomer
	 */
	public boolean excludeIncludeSWOsOfCustomer(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customer) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customer;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.excludeIncludeSWOsOfCustomer(customer);
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
	 * excludeIncludeSWOsOfDM
	 */
	public boolean excludeIncludeSWOsOfDM(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO machine) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = machine;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.excludeIncludeSWOsOfDM(machine);
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
	/**
	 * removeQuotes
	 */
	public boolean removeQuotes(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO proposalDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.removeQuotes(proposalDTO);
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
				container.postInvoke(this, 5, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * verifyLicenseAreExists
	 */
	public boolean verifyLicenseAreExists(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO swoDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.verifyLicenseAreExists(swoDomainDTO);
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
				container.postInvoke(this, 6, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * retrieveSWOForCopyInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO retrieveSWOForCopyInventory(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveSWOForCopyInventory(dmDomainDTO);
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
				container.postInvoke(this, 7, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * retrieveVarianceForSWO
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO retrieveVarianceForSWO(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveVarianceForSWO(dmDTO);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 8, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * retrieveSWODetailsForPricing
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO retrieveSWODetailsForPricing(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO priceProposalDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = priceProposalDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveSWODetailsForPricing(priceProposalDomainDTO);
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
				container.postInvoke(this, 9, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * retrieveSWOEditInfo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO retrieveSWOEditInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO swoDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveSWOEditInfo(swoDomainDTO);
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
				container.postInvoke(this, 10, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * validateAndPopulateSWOForStatusCheck
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO validateAndPopulateSWOForStatusCheck(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO swoDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.validateAndPopulateSWOForStatusCheck(swoDomainDTO);
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
				container.postInvoke(this, 11, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * retrieveSWODetails
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO[] retrieveSWODetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO[] licenses) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO[] _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = licenses;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveSWODetails(licenses);
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
				container.postInvoke(this, 12, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * retrieveEEConfigInfoFromTemp
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.TempEEDomainDTO retrieveEEConfigInfoFromTemp(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.TempEEDomainDTO tempEEDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.TempEEDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = tempEEDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveEEConfigInfoFromTemp(tempEEDomainDTO);
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
				container.postInvoke(this, 13, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * chkSWOExternalCntrNumber
	 */
	public java.lang.String chkSWOExternalCntrNumber(int ProposalID) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(ProposalID);
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.chkSWOExternalCntrNumber(ProposalID);
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
				container.postInvoke(this, 14, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchSAndSDetails
	 */
	public java.util.List fetchSAndSDetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO[] dmDomainDTOList, com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO[] swoDomainDTOList) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.List _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = dmDomainDTOList;
				_jacc_parms[1] = swoDomainDTOList;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchSAndSDetails(dmDomainDTOList, swoDomainDTOList);
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
				container.postInvoke(this, 15, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * retrieveSWODetails
	 */
	public java.util.List retrieveSWODetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.List _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveSWODetails(dmDTO);
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
				container.postInvoke(this, 16, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * applySAndSDiscount
	 */
	public void applySAndSDiscount(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.EEDomainDTO[] eeDomainDTOArray, double sAndSDiscount) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = eeDomainDTOArray;
				_jacc_parms[1] = new java.lang.Double(sAndSDiscount);
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			beanRef.applySAndSDiscount(eeDomainDTOArray, sAndSDiscount);
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
				container.postInvoke(this, 17, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * calculateSWOPrice
	 */
	public void calculateSWOPrice(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO priceProposalDTO) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = priceProposalDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			beanRef.calculateSWOPrice(priceProposalDTO);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 18, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * copyInventory
	 */
	public void copyInventory(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CopyInventoryDomainDTO copyInventoryDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copyInventoryDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
			beanRef.copyInventory(copyInventoryDomainDTO);
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
				container.postInvoke(this, 19, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * copyInventory
	 */
	public void copyInventory(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDomainDTO, com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CopyInventoryDomainDTO copyInventoryDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = dmDomainDTO;
				_jacc_parms[1] = copyInventoryDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			beanRef.copyInventory(dmDomainDTO, copyInventoryDomainDTO);
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
				container.postInvoke(this, 20, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * copyStoreSWOHistoryInfo
	 */
	public void copyStoreSWOHistoryInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO swoDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
			beanRef.copyStoreSWOHistoryInfo(swoDTO);
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
				container.postInvoke(this, 21, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * insertBumpLicenseInfo
	 */
	public void insertBumpLicenseInfo(java.util.List bumpSWODTOList) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = bumpSWODTOList;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 22, _EJS_s, _jacc_parms);
			beanRef.insertBumpLicenseInfo(bumpSWODTOList);
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
				container.postInvoke(this, 22, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeConfigurationDetails
	 */
	public void removeConfigurationDetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.TempEEDomainDTO tempEEDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = tempEEDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 23, _EJS_s, _jacc_parms);
			beanRef.removeConfigurationDetails(tempEEDomainDTO);
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
				container.postInvoke(this, 23, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeLicenses
	 */
	public void removeLicenses(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO swoDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 24, _EJS_s, _jacc_parms);
			beanRef.removeLicenses(swoDTO);
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
				container.postInvoke(this, 24, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeSVCLicenses
	 */
	public void removeSVCLicenses(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO proposalDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 25, _EJS_s, _jacc_parms);
			beanRef.removeSVCLicenses(proposalDTO);
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
				container.postInvoke(this, 25, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * replaceSkipLicenses
	 */
	public void replaceSkipLicenses(java.util.List swoDTOList) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDTOList;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 26, _EJS_s, _jacc_parms);
			beanRef.replaceSkipLicenses(swoDTOList);
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
				container.postInvoke(this, 26, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * storeConfigSWODetails
	 */
	public void storeConfigSWODetails(java.util.List swoDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 27, _EJS_s, _jacc_parms);
			beanRef.storeConfigSWODetails(swoDTO);
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
				container.postInvoke(this, 27, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * storeEEConfigInfo
	 */
	public void storeEEConfigInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.TempEEDomainDTO tempEEDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = tempEEDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 28, _EJS_s, _jacc_parms);
			beanRef.storeEEConfigInfo(tempEEDTO);
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
				container.postInvoke(this, 28, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * storeIneligibleLicense
	 */
	public void storeIneligibleLicense(java.util.List swoDTOList) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDTOList;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 29, _EJS_s, _jacc_parms);
			beanRef.storeIneligibleLicense(swoDTOList);
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
				container.postInvoke(this, 29, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * storeSWODetails
	 */
	public void storeSWODetails(java.util.List swoDTOList) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDTOList;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 30, _EJS_s, _jacc_parms);
			beanRef.storeSWODetails(swoDTOList);
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
				container.postInvoke(this, 30, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * storeVarianceInfoSWO
	 */
	public void storeVarianceInfoSWO(java.util.List swoDTOList) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDTOList;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 31, _EJS_s, _jacc_parms);
			beanRef.storeVarianceInfoSWO(swoDTOList);
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
				container.postInvoke(this, 31, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateESWPriceForVarianceProposal
	 */
	public void updateESWPriceForVarianceProposal(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO proposalDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 32, _EJS_s, _jacc_parms);
			beanRef.updateESWPriceForVarianceProposal(proposalDomainDTO);
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
				container.postInvoke(this, 32, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateSWODetails
	 */
	public void updateSWODetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO[] licenses) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = licenses;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 33, _EJS_s, _jacc_parms);
			beanRef.updateSWODetails(licenses);
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
				container.postInvoke(this, 33, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateSWOForCustomer
	 */
	public void updateSWOForCustomer(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 34, _EJS_s, _jacc_parms);
			beanRef.updateSWOForCustomer(customerDTO);
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
				container.postInvoke(this, 34, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateSWOForDM
	 */
	public void updateSWOForDM(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerBean)container.preInvoke(this, 35, _EJS_s, _jacc_parms);
			beanRef.updateSWOForDM(dmDTO);
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
				container.postInvoke(this, 35, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.service.invmgr;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalStatelessInventoryManager_20b0cef5
 */
public class EJSLocalStatelessInventoryManager_20b0cef5 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerLocal {
	/**
	 * EJSLocalStatelessInventoryManager_20b0cef5
	 */
	public EJSLocalStatelessInventoryManager_20b0cef5() {
		super();	}
	/**
	 * excludeIncludeLicenses
	 */
	public boolean excludeIncludeLicenses(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO[] licenses, com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO[] machines, com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO[] customers) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = licenses;
				_jacc_parms[1] = machines;
				_jacc_parms[2] = customers;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.excludeIncludeLicenses(licenses, machines, customers);
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
	 * isCustomerAvailableForProposal
	 */
	public boolean isCustomerAvailableForProposal(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customer) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customer;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.isCustomerAvailableForProposal(customer);
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
	 * isCustomerAvailableForProposalPlanStartEndDate
	 */
	public boolean isCustomerAvailableForProposalPlanStartEndDate(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customer) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customer;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.isCustomerAvailableForProposalPlanStartEndDate(customer);
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
	 * isSVCLicenseExistsForProposal
	 */
	public boolean isSVCLicenseExistsForProposal(int proposalID, java.lang.String transactionName) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(proposalID);
				_jacc_parms[1] = transactionName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.isSVCLicenseExistsForProposal(proposalID, transactionName);
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
	 * isSandSLicenseExistForProposal
	 */
	public boolean isSandSLicenseExistForProposal(int proposalID, java.lang.String flag) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(proposalID);
				_jacc_parms[1] = flag;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.isSandSLicenseExistForProposal(proposalID, flag);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
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
	 * verifyLicensesAlreadyExists
	 */
	public boolean verifyLicensesAlreadyExists(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO swoDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.verifyLicensesAlreadyExists(swoDomainDTO);
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
	 * retrieveCustomerNumberForCustomerList
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO[] retrieveCustomerNumberForCustomerList(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO[] _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveCustomerNumberForCustomerList(customerDomainDTO);
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
	 * findSTPForProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO findSTPForProposal(int proposalId, java.lang.String sapCustomerNo) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(proposalId);
				_jacc_parms[1] = sapCustomerNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findSTPForProposal(proposalId, sapCustomerNo);
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
	 * findSTPForProposalPlanStartEndDate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO findSTPForProposalPlanStartEndDate(int proposalId, java.lang.String sapCustomerNo, java.sql.Date planStartDate, java.sql.Date planEndDate) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = new java.lang.Integer(proposalId);
				_jacc_parms[1] = sapCustomerNo;
				_jacc_parms[2] = planStartDate;
				_jacc_parms[3] = planEndDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findSTPForProposalPlanStartEndDate(proposalId, sapCustomerNo, planStartDate, planEndDate);
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
	 * retrieveCustomerAndDMInfo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO retrieveCustomerAndDMInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveCustomerAndDMInfo(dmDTO);
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
	 * retrieveCustomerInfo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO retrieveCustomerInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customer) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customer;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveCustomerInfo(customer);
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
	 * retrieveDMEditInfo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO retrieveDMEditInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveDMEditInfo(dmDomainDTO);
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
	 * retrieveSWOCopyInfo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO retrieveSWOCopyInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO swoDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveSWOCopyInfo(swoDomainDTO);
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
	 * retrieveSWOEditInfo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO retrieveSWOEditInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO swoDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
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
	 * retrieveCustomerDetails
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO[] retrieveCustomerDetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO[] customers) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO[] _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customers;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveCustomerDetails(customers);
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
	 * retrieveDMAndLicenseInfo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO retrieveDMAndLicenseInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveDMAndLicenseInfo(dmDTO);
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
	 * retrieveDMInfo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO retrieveDMInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO machine) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = machine;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveDMInfo(machine);
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
		return _EJS_result;
	}
	/**
	 * retrieveDMDetails
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO[] retrieveDMDetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO[] machines) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO[] _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = machines;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveDMDetails(machines);
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
				container.postInvoke(this, 18, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * retrieveCustomerForCopyInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO retrieveCustomerForCopyInventory(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO proposalDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveCustomerForCopyInventory(proposalDTO);
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
		return _EJS_result;
	}
	/**
	 * retrieveCustomerForProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO retrieveCustomerForProposal(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO proposalDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveCustomerForProposal(proposalDTO);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 21, _EJS_s);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 22, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 22, _EJS_s);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 23, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 23, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSWOExternalCntrNumber
	 */
	public java.lang.String getSWOExternalCntrNumber(int proposalID) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(proposalID);
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 24, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSWOExternalCntrNumber(proposalID);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 25, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 25, _EJS_s);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 26, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 26, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * addCustomersToProposal
	 */
	public void addCustomersToProposal(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 27, _EJS_s, _jacc_parms);
			beanRef.addCustomersToProposal(customerDTO);
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
	 * addCustomersToProposalSAndSExtended
	 */
	public void addCustomersToProposalSAndSExtended(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 28, _EJS_s, _jacc_parms);
			beanRef.addCustomersToProposalSAndSExtended(customerDTO);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 29, _EJS_s, _jacc_parms);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 30, _EJS_s, _jacc_parms);
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
	 * copyStoreCustomerInfo
	 */
	public void copyStoreCustomerInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 31, _EJS_s, _jacc_parms);
			beanRef.copyStoreCustomerInfo(customerDTO);
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
	 * deleteVarianceInventory
	 */
	public void deleteVarianceInventory(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO proposal) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposal;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 32, _EJS_s, _jacc_parms);
			beanRef.deleteVarianceInventory(proposal);
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
	 * removeCustomerDetail
	 */
	public void removeCustomerDetail(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 33, _EJS_s, _jacc_parms);
			beanRef.removeCustomerDetail(customerDTO);
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
	 * removeDMDetails
	 */
	public void removeDMDetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 34, _EJS_s, _jacc_parms);
			beanRef.removeDMDetails(dmDTO);
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
	 * removeEEConfigDetails
	 */
	public void removeEEConfigDetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.TempEEDomainDTO tempEEDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = tempEEDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 35, _EJS_s, _jacc_parms);
			beanRef.removeEEConfigDetails(tempEEDomainDTO);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 36, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 36, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeSWODetails
	 */
	public void removeSWODetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO swoDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 37, _EJS_s, _jacc_parms);
			beanRef.removeSWODetails(swoDTO);
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
				container.postInvoke(this, 37, _EJS_s);
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
	public void replaceSkipLicenses(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 38, _EJS_s, _jacc_parms);
			beanRef.replaceSkipLicenses(customerDTO);
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
				container.postInvoke(this, 38, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * storeBumpInfo
	 */
	public void storeBumpInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO bumpDMDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = bumpDMDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 39, _EJS_s, _jacc_parms);
			beanRef.storeBumpInfo(bumpDMDTO);
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
				container.postInvoke(this, 39, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * storeConfigureDMInfo
	 */
	public void storeConfigureDMInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 40, _EJS_s, _jacc_parms);
			beanRef.storeConfigureDMInfo(dmDTO);
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
				container.postInvoke(this, 40, _EJS_s);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 41, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 41, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * storeIneligibleInventory
	 */
	public void storeIneligibleInventory(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 42, _EJS_s, _jacc_parms);
			beanRef.storeIneligibleInventory(customerDTO);
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
				container.postInvoke(this, 42, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * storeInventory
	 */
	public void storeInventory(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 43, _EJS_s, _jacc_parms);
			beanRef.storeInventory(customerDTO);
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
				container.postInvoke(this, 43, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * storeVarianceInfo
	 */
	public void storeVarianceInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 44, _EJS_s, _jacc_parms);
			beanRef.storeVarianceInfo(customerDTO);
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
				container.postInvoke(this, 44, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateCustomer
	 */
	public void updateCustomer(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 45, _EJS_s, _jacc_parms);
			beanRef.updateCustomer(customerDTO);
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
				container.postInvoke(this, 45, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateDMEditInfo
	 */
	public void updateDMEditInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 46, _EJS_s, _jacc_parms);
			beanRef.updateDMEditInfo(dmDTO);
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
				container.postInvoke(this, 46, _EJS_s);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 47, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 47, _EJS_s);
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
	public void updateSWODetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO[] swoDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerBean)container.preInvoke(this, 48, _EJS_s, _jacc_parms);
			beanRef.updateSWODetails(swoDTO);
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
				container.postInvoke(this, 48, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

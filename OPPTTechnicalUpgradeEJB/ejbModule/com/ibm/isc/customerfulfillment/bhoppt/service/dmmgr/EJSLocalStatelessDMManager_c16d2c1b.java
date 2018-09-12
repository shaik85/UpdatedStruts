package com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalStatelessDMManager_c16d2c1b
 */
public class EJSLocalStatelessDMManager_c16d2c1b extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerLocal {
	/**
	 * EJSLocalStatelessDMManager_c16d2c1b
	 */
	public EJSLocalStatelessDMManager_c16d2c1b() {
		super();	}
	/**
	 * retrieveDMForCopyInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO retrieveDMForCopyInventory(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveDMForCopyInventory(customerDomainDTO);
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
	 * retrieveDMForCustomer
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO retrieveDMForCustomer(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveDMForCustomer(customerDomainDTO);
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
	 * retrieveDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO retrieveDM(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveDM(dmDTO);
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
	 * retrieveEditSWOInfo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO retrieveEditSWOInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO swoDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveEditSWOInfo(swoDomainDTO);
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
	 * retrieveSWOInfo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO retrieveSWOInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO swoDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveSWOInfo(swoDomainDTO);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 5, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * copyStoreDMHistoryInfo
	 */
	public void copyStoreDMHistoryInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			beanRef.copyStoreDMHistoryInfo(dmDTO);
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
		return ;
	}
	/**
	 * deleteVarianceDM
	 */
	public void deleteVarianceDM(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO proposal) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposal;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			beanRef.deleteVarianceDM(proposal);
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
		return ;
	}
	/**
	 * removeDMInfo
	 */
	public void removeDMInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			beanRef.removeDMInfo(dmDTO);
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
		return ;
	}
	/**
	 * removeLicenses
	 */
	public void removeLicenses(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO swoDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = swoDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			beanRef.removeLicenses(swoDomainDTO);
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
		return ;
	}
	/**
	 * repalceSkipLicenses
	 */
	public void repalceSkipLicenses(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			beanRef.repalceSkipLicenses(dmDTO);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 11, _EJS_s);
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
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 12, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * storeDMInfo
	 */
	public void storeDMInfo(java.util.List dmDTOList) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTOList;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			beanRef.storeDMInfo(dmDTOList);
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
		return ;
	}
	/**
	 * storeIneligibleLicenseInfo
	 */
	public void storeIneligibleLicenseInfo(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			beanRef.storeIneligibleLicenseInfo(dmDTO);
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
		return ;
	}
	/**
	 * storeVarianceInfoForDM
	 */
	public void storeVarianceInfoForDM(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dto) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dto;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			beanRef.storeVarianceInfoForDM(dto);
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
		return ;
	}
	/**
	 * updateDMDetails
	 */
	public void updateDMDetails(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO dmDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = dmDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			beanRef.updateDMDetails(dmDTO);
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
		return ;
	}
	/**
	 * updateDMForCustomer
	 */
	public void updateDMForCustomer(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO customerDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customerDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			beanRef.updateDMForCustomer(customerDomainDTO);
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
}

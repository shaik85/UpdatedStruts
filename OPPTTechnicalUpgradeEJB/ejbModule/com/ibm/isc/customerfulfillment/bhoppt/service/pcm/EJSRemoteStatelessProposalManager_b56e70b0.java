package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessProposalManager_b56e70b0
 */
public class EJSRemoteStatelessProposalManager_b56e70b0 extends EJSWrapper implements ProposalManager {
	/**
	 * EJSRemoteStatelessProposalManager_b56e70b0
	 */
	public EJSRemoteStatelessProposalManager_b56e70b0() throws java.rmi.RemoteException {
		super();	}
	/**
	 * addSelectedCustomers
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AddCustomerCustomDTO addSelectedCustomers(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AddCustomerCustomDTO addCustomerCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AddCustomerCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = addCustomerCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.addSelectedCustomers(addCustomerCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getProposalCustomers
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AddCustomerCustomDTO getProposalCustomers(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AddCustomerCustomDTO addCustomerCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AddCustomerCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = addCustomerCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getProposalCustomers(addCustomerCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchAlternatePartner
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AlternatePartnerCustomDTO fetchAlternatePartner(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AlternatePartnerCustomDTO alternatePartnerCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AlternatePartnerCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = alternatePartnerCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchAlternatePartner(alternatePartnerCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * amendContract
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendContractCustomDTO amendContract(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendContractCustomDTO amendContractCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendContractCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = amendContractCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.amendContract(amendContractCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * processAmendContract
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendContractCustomDTO processAmendContract(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendContractCustomDTO amendContractCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendContractCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = amendContractCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.processAmendContract(amendContractCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * amendSWO
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendSWOCustomDTO amendSWO(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendSWOCustomDTO amendSWOCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendSWOCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = amendSWOCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.amendSWO(amendSWOCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * validateComplexContractIdentifiers
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BasicProposalCustomDTO validateComplexContractIdentifiers(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BasicProposalCustomDTO basicProposalCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BasicProposalCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = basicProposalCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.validateComplexContractIdentifiers(basicProposalCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * closeContract
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CloseContractCustomDTO closeContract(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CloseContractCustomDTO closeContract) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CloseContractCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = closeContract;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.closeContract(closeContract);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * cancelConfigureDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO cancelConfigureDM(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO configureDMCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = configureDMCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.cancelConfigureDM(configureDMCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * copyConfigToSWOsWhenConfigureDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO copyConfigToSWOsWhenConfigureDM(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO configureDMCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = configureDMCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.copyConfigToSWOsWhenConfigureDM(configureDMCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchPriceWhenConfigureDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO fetchPriceWhenConfigureDM(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO configureDMCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = configureDMCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchPriceWhenConfigureDM(configureDMCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * retrieveDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO retrieveDM(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO configureDMCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = configureDMCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveDM(configureDMCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * retrieveEEConfigWhenConfigureDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO retrieveEEConfigWhenConfigureDM(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO configureDMCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = configureDMCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveEEConfigWhenConfigureDM(configureDMCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * validateConfigWhenConfigureDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO validateConfigWhenConfigureDM(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO configureDMCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = configureDMCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.validateConfigWhenConfigureDM(configureDMCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * canEASIICopyPerformed
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO canEASIICopyPerformed(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO contractDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = contractDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.canEASIICopyPerformed(contractDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * copyBumpInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpDMCustomDTO copyBumpInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpDMCustomDTO copyBumpDMCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpDMCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copyBumpDMCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.copyBumpInventory(copyBumpDMCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * saveCopyBumpDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpDMCustomDTO saveCopyBumpDM(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpDMCustomDTO copyBumpDMCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpDMCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copyBumpDMCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.saveCopyBumpDM(copyBumpDMCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * copyBumpInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpSWOCustomDTO copyBumpInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpSWOCustomDTO copyBumpSWOCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpSWOCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copyBumpSWOCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.copyBumpInventory(copyBumpSWOCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * saveCopyBumpSWO
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpSWOCustomDTO saveCopyBumpSWO(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpSWOCustomDTO copyBumpSWOCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpSWOCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copyBumpSWOCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.saveCopyBumpSWO(copyBumpSWOCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 18, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * copyCustomerInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyCustomerCustomDTO copyCustomerInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyCustomerCustomDTO copyCustomerCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyCustomerCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copyCustomerCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.copyCustomerInventory(copyCustomerCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 19, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * copyInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyCustomerCustomDTO copyInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyCustomerCustomDTO copyCustomerCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyCustomerCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copyCustomerCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.copyInventory(copyCustomerCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 20, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * copyDMInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyDMCustomDTO copyDMInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyDMCustomDTO copyDMCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyDMCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copyDMCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.copyDMInventory(copyDMCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 21, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * copyInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyDMCustomDTO copyInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyDMCustomDTO copyDMCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyDMCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copyDMCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 22, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.copyInventory(copyDMCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 22, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * copyProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyProposalCustomDTO copyProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyProposalCustomDTO copyProposalCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyProposalCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copyProposalCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 23, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.copyProposal(copyProposalCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 23, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * copyReplaceContract
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyReplacementCustomDTO copyReplaceContract(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyReplacementCustomDTO copyReplacementCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyReplacementCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copyReplacementCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 24, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.copyReplaceContract(copyReplacementCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 24, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * copyInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopySWOCustomDTO copyInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopySWOCustomDTO copySWOCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopySWOCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copySWOCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 25, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.copyInventory(copySWOCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 25, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * copySWOInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopySWOCustomDTO copySWOInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopySWOCustomDTO copySWOCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopySWOCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = copySWOCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 26, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.copySWOInventory(copySWOCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 26, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * deleteInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteInventoryCustomDTO deleteInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteInventoryCustomDTO deleteInventoryCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteInventoryCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = deleteInventoryCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 27, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.deleteInventory(deleteInventoryCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 27, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * deltaFetch
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeltaFetchCustomDTO deltaFetch(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeltaFetchCustomDTO deltaFetchCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeltaFetchCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = deltaFetchCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 28, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.deltaFetch(deltaFetchCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 28, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * easIICopy
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EASIICopyCustomDTO easIICopy(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EASIICopyCustomDTO easIICopyCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EASIICopyCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = easIICopyCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 29, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.easIICopy(easIICopyCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 29, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * editInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditCustomerCustomDTO editInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditCustomerCustomDTO editCustomerCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditCustomerCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = editCustomerCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 30, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.editInventory(editCustomerCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 30, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * saveEditCustomer
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditCustomerCustomDTO saveEditCustomer(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditCustomerCustomDTO editCustomerCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditCustomerCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = editCustomerCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 31, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.saveEditCustomer(editCustomerCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 31, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * editInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditDMCustomDTO editInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditDMCustomDTO editDMCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditDMCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = editDMCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 32, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.editInventory(editDMCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 32, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * saveEditDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditDMCustomDTO saveEditDM(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditDMCustomDTO editDMCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditDMCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = editDMCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 33, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.saveEditDM(editDMCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 33, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * editInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditInventoryCustomDTO editInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditInventoryCustomDTO editInventoryCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditInventoryCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = editInventoryCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 34, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.editInventory(editInventoryCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 34, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * saveInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditInventoryCustomDTO saveInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditInventoryCustomDTO editInventoryCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditInventoryCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = editInventoryCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 35, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.saveInventory(editInventoryCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 35, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * editInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditSWOCustomDTO editInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditSWOCustomDTO editSWOCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditSWOCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = editSWOCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 36, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.editInventory(editSWOCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 36, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * saveEditSWO
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditSWOCustomDTO saveEditSWO(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditSWOCustomDTO editSWOCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditSWOCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = editSWOCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 37, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.saveEditSWO(editSWOCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 37, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * viewErrorHistory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ErrorHistoryCustomDTO viewErrorHistory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ErrorHistoryCustomDTO errorHistoryCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ErrorHistoryCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = errorHistoryCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 38, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.viewErrorHistory(errorHistoryCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 38, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * extendContract
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ExtendContractCustomDTO extendContract(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ExtendContractCustomDTO extendContractCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ExtendContractCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = extendContractCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 39, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.extendContract(extendContractCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 39, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * submitExtendContract
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ExtendContractCustomDTO submitExtendContract(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ExtendContractCustomDTO extendContractCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ExtendContractCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = extendContractCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 40, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.submitExtendContract(extendContractCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 40, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchCustomerListsForBP
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomerListCustomDTO fetchCustomerListsForBP(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomerListCustomDTO fetchCustomerListCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomerListCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = fetchCustomerListCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 41, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchCustomerListsForBP(fetchCustomerListCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 41, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchSiteIDLists
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomerListCustomDTO fetchSiteIDLists(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomerListCustomDTO fetchCustomerListCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomerListCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = fetchCustomerListCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 42, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchSiteIDLists(fetchCustomerListCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 42, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchCustomes
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomersCustomDTO fetchCustomes(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomersCustomDTO fetchCustomersCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomersCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = fetchCustomersCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 43, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchCustomes(fetchCustomersCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 43, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchPartnerInformationForBP
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO fetchPartnerInformationForBP(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO fetchPartnerInformationCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = fetchPartnerInformationCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 44, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchPartnerInformationForBP(fetchPartnerInformationCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 44, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchPartnerInformationForCustomer
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO fetchPartnerInformationForCustomer(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO fetchPartnerInformationCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = fetchPartnerInformationCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 45, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchPartnerInformationForCustomer(fetchPartnerInformationCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 45, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * addIneligibleInventoryToProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleLicensesCustomDTO addIneligibleInventoryToProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleLicensesCustomDTO ineligibleLicensesCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleLicensesCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = ineligibleLicensesCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 46, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.addIneligibleInventoryToProposal(ineligibleLicensesCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 46, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchIneligibleInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleLicensesCustomDTO fetchIneligibleInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleLicensesCustomDTO ineligibleLicensesCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleLicensesCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = ineligibleLicensesCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 47, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchIneligibleInventory(ineligibleLicensesCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 47, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO fetchInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO inventoryCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = inventoryCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 48, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchInventory(inventoryCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 48, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * initiateFetchPlannedInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryDateRangeCustomDTO initiateFetchPlannedInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryDateRangeCustomDTO inventoryDateRangeCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryDateRangeCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = inventoryDateRangeCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 49, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.initiateFetchPlannedInventory(inventoryDateRangeCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 49, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * addPlannedInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PlannedInventoryCustomDTO addPlannedInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PlannedInventoryCustomDTO plannedInventoryCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PlannedInventoryCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = plannedInventoryCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 50, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.addPlannedInventory(plannedInventoryCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 50, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * printProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PrintProposalCustomDTO printProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PrintProposalCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PrintProposalCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 51, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.printProposal(customDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 51, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * canDeltaFetchBePerformed
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO canDeltaFetchBePerformed(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO proposalCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 52, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.canDeltaFetchBePerformed(proposalCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 52, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * priceProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO priceProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO proposalCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 53, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.priceProposal(proposalCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 53, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * removeSVCLicenses
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO removeSVCLicenses(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO proposalInformation) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalInformation;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 54, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.removeSVCLicenses(proposalInformation);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 54, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * retrieveCustomerDetails
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomerCustomDTO retrieveCustomerDetails(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomerCustomDTO customer) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomerCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customer;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 55, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrieveCustomerDetails(customer);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 55, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchProposalDetails
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalDetailsCustomDTO fetchProposalDetails(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalDetailsCustomDTO proposalDetailsCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalDetailsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalDetailsCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 56, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchProposalDetails(proposalDetailsCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 56, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getProposalFormData
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalFormDataCustomDTO getProposalFormData() throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalFormDataCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 57, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getProposalFormData();
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 57, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getHeaderInformation
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO getHeaderInformation(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO proposalHeaderCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalHeaderCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 58, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getHeaderInformation(proposalHeaderCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 58, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * saveProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO saveProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO proposalHeaderCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalHeaderCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 59, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.saveProposal(proposalHeaderCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 59, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * validateProposalHeader
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO validateProposalHeader(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO proposalHeaderCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalHeaderCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 60, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.validateProposalHeader(proposalHeaderCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 60, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getProposalHistory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHistoryCustomDTO getProposalHistory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHistoryCustomDTO proposalHistoryCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHistoryCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalHistoryCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 61, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getProposalHistory(proposalHistoryCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 61, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * listProposalsForApproval
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalsForApprovalCustomDTO listProposalsForApproval(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalsForApprovalCustomDTO proposalsForApprovalCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalsForApprovalCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalsForApprovalCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 62, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listProposalsForApproval(proposalsForApprovalCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 62, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchPlannedInventory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.QuotesListCustomDTO fetchPlannedInventory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.QuotesListCustomDTO quotesListCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.QuotesListCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = quotesListCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 63, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchPlannedInventory(quotesListCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 63, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegistrationData
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RegistrationCustomDTO getRegistrationData(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RegistrationCustomDTO registrationCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RegistrationCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = registrationCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 64, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegistrationData(registrationCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 64, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * proposalRegistration
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RegistrationCustomDTO proposalRegistration(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RegistrationCustomDTO registrationCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RegistrationCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = registrationCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 65, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.proposalRegistration(registrationCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 65, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * releaseLockOnProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReleaseLockOnProposalCustomDTO releaseLockOnProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReleaseLockOnProposalCustomDTO releaseLockOnProposalCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReleaseLockOnProposalCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = releaseLockOnProposalCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 66, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.releaseLockOnProposal(releaseLockOnProposalCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 66, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * enterRenewContractInfo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RenewContractCustomDTO enterRenewContractInfo(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RenewContractCustomDTO renewContractCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RenewContractCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = renewContractCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 67, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.enterRenewContractInfo(renewContractCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 67, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * renewContract
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RenewContractCustomDTO renewContract(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RenewContractCustomDTO renewContractCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RenewContractCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = renewContractCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 68, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.renewContract(renewContractCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 68, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getHeaderForReplacement
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReplaceContractCustomDTO getHeaderForReplacement(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReplaceContractCustomDTO replaceContractCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReplaceContractCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = replaceContractCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 69, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getHeaderForReplacement(replaceContractCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 69, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * validateReplacementDate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReplaceContractCustomDTO validateReplacementDate(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReplaceContractCustomDTO replacementCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReplaceContractCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = replacementCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 70, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.validateReplacementDate(replacementCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 70, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fetchSAndSDetails
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSDetailsCustomDTO fetchSAndSDetails(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSDetailsCustomDTO sAndSInformation) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSDetailsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = sAndSInformation;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 71, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.fetchSAndSDetails(sAndSInformation);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 71, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSWODetails
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWODetailsCustomDTO getSWODetails(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWODetailsCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWODetailsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 72, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSWODetails(customDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 72, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getEligibleUserToShareProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO getEligibleUserToShareProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 73, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getEligibleUserToShareProposal(customDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 73, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * removeShare
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO removeShare(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 74, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.removeShare(customDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 74, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * shareProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO shareProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 75, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.shareProposal(customDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 75, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * checkProposalStatus
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.StatusCheckCustomDTO checkProposalStatus(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.StatusCheckCustomDTO statusCheckCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.StatusCheckCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = statusCheckCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 76, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.checkProposalStatus(statusCheckCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 76, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getTargetUsers
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.TransferProposalsCustomDTO getTargetUsers(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.TransferProposalsCustomDTO transferProposalsCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.TransferProposalsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = transferProposalsCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 77, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getTargetUsers(transferProposalsCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 77, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * transferProposals
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.TransferProposalsCustomDTO transferProposals(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.TransferProposalsCustomDTO transferProposalsCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.TransferProposalsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = transferProposalsCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 78, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.transferProposals(transferProposalsCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 78, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * listAllContractsOfUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserContractsCustomDTO listAllContractsOfUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserContractsCustomDTO userContractsCustomDTO, boolean isArchive) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserContractsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = userContractsCustomDTO;
				_jacc_parms[1] = new java.lang.Boolean(isArchive);
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 79, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listAllContractsOfUser(userContractsCustomDTO, isArchive);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 79, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * checkForRemovingUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO checkForRemovingUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO userCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = userCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 80, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.checkForRemovingUser(userCustom);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 80, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * listAllProposalsOfUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserProposalsCustomDTO listAllProposalsOfUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserProposalsCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserProposalsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 81, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listAllProposalsOfUser(customDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 81, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * validateTPProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ValidateTPProposalCustomDTO validateTPProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ValidateTPProposalCustomDTO validateTPProposalCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ValidateTPProposalCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = validateTPProposalCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 82, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.validateTPProposal(validateTPProposalCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 82, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * createOrSimulateVariance
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceCustomDTO createOrSimulateVariance(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceCustomDTO varianceCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = varianceCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 83, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createOrSimulateVariance(varianceCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 83, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * processVariance
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceCustomDTO processVariance(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceCustomDTO varianceCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = varianceCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 84, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.processVariance(varianceCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 84, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * checkVariance
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceHeaderInformationCustomDTO checkVariance(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceHeaderInformationCustomDTO varianceHeaderInformationCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceHeaderInformationCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = varianceHeaderInformationCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 85, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.checkVariance(varianceHeaderInformationCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 85, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * createVarianceProposal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceHeaderInformationCustomDTO createVarianceProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceHeaderInformationCustomDTO varianceHeaderInformationCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceHeaderInformationCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = varianceHeaderInformationCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 86, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createVarianceProposal(varianceHeaderInformationCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 86, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * deleteTempVarianceValues
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceHeaderInformationCustomDTO deleteTempVarianceValues(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceHeaderInformationCustomDTO varianceHeaderInformationCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceHeaderInformationCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = varianceHeaderInformationCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 87, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.deleteTempVarianceValues(varianceHeaderInformationCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 87, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * checkForProposalsForApproverAndManager
	 */
	public java.util.List checkForProposalsForApproverAndManager(java.lang.String userId) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.List _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = userId;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 88, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.checkForProposalsForApproverAndManager(userId);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 88, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * checkForProposalsForCSOAndMarkAndManager
	 */
	public java.util.List checkForProposalsForCSOAndMarkAndManager(java.lang.String userId, java.lang.String role) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.List _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = userId;
				_jacc_parms[1] = role;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 89, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.checkForProposalsForCSOAndMarkAndManager(userId, role);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 89, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * checkForProposalsForCreateApprove
	 */
	public java.util.List checkForProposalsForCreateApprove(java.lang.String userId, java.lang.String role) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.List _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = userId;
				_jacc_parms[1] = role;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 90, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.checkForProposalsForCreateApprove(userId, role);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 90, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * applySAndSDiscount
	 */
	public void applySAndSDiscount(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSPlanningCustomDTO sAndSPlanningCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = sAndSPlanningCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 91, _EJS_s, _jacc_parms);
			beanRef.applySAndSDiscount(sAndSPlanningCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 91, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * approveRequest
	 */
	public void approveRequest(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO approveInfo) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = approveInfo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 92, _EJS_s, _jacc_parms);
			beanRef.approveRequest(approveInfo);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 92, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * canProposalBeCopied
	 */
	public void canProposalBeCopied(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 93, _EJS_s, _jacc_parms);
			beanRef.canProposalBeCopied(customDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 93, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * deleteCustomerList
	 */
	public void deleteCustomerList(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteCustomerListCustomDTO deleteCustomerListCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = deleteCustomerListCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 94, _EJS_s, _jacc_parms);
			beanRef.deleteCustomerList(deleteCustomerListCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 94, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * deleteErrorHistory
	 */
	public void deleteErrorHistory(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ErrorHistoryCustomDTO errorHistoryCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = errorHistoryCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 95, _EJS_s, _jacc_parms);
			beanRef.deleteErrorHistory(errorHistoryCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 95, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * deleteProposalContract
	 */
	public void deleteProposalContract(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteProposalCustomDTO deleteProposalCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = deleteProposalCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 96, _EJS_s, _jacc_parms);
			beanRef.deleteProposalContract(deleteProposalCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 96, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * deleteTempValues
	 */
	public void deleteTempValues(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO opptCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = opptCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 97, _EJS_s, _jacc_parms);
			beanRef.deleteTempValues(opptCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 97, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * excludeIncludeSWO
	 */
	public void excludeIncludeSWO(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IncludeExcludeSWOCustomDTO includeExcludeLicenses) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = includeExcludeLicenses;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 98, _EJS_s, _jacc_parms);
			beanRef.excludeIncludeSWO(includeExcludeLicenses);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 98, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * lockProposal
	 */
	public void lockProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO proposalCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 99, _EJS_s, _jacc_parms);
			beanRef.lockProposal(proposalCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 99, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * rejectRequest
	 */
	public void rejectRequest(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RejectProposalCustomDTO rejectInfo) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = rejectInfo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 100, _EJS_s, _jacc_parms);
			beanRef.rejectRequest(rejectInfo);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 100, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * releaseProposal
	 */
	public void releaseProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO proposalCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 101, _EJS_s, _jacc_parms);
			beanRef.releaseProposal(proposalCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 101, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeQuotes
	 */
	public void removeQuotes(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO proposalCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 102, _EJS_s, _jacc_parms);
			beanRef.removeQuotes(proposalCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 102, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * renameProposal
	 */
	public void renameProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO proposalCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposalCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 103, _EJS_s, _jacc_parms);
			beanRef.renameProposal(proposalCustomDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 103, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * revertProposal
	 */
	public void revertProposal(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO customContract) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customContract;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 104, _EJS_s, _jacc_parms);
			beanRef.revertProposal(customContract);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 104, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * saveSWODetails
	 */
	public void saveSWODetails(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWODetailsCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 105, _EJS_s, _jacc_parms);
			beanRef.saveSWODetails(customDTO);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 105, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * throwExceptionForService
	 */
	public void throwExceptionForService(java.lang.String str, int i) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = str;
				_jacc_parms[1] = new java.lang.Integer(i);
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 106, _EJS_s, _jacc_parms);
			beanRef.throwExceptionForService(str, i);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 106, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateProposalWithGroupName
	 */
	public void updateProposalWithGroupName(java.lang.String userID, java.lang.String groupName) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = userID;
				_jacc_parms[1] = groupName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerBean)container.preInvoke(this, 107, _EJS_s, _jacc_parms);
			beanRef.updateProposalWithGroupName(userID, groupName);
		}
		catch (com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 107, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

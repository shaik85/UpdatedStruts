package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessBaseAgreementManager_40bf7af9
 */
public class EJSRemoteStatelessBaseAgreementManager_40bf7af9 extends EJSWrapper implements BaseAgreementManager {
	/**
	 * EJSRemoteStatelessBaseAgreementManager_40bf7af9
	 */
	public EJSRemoteStatelessBaseAgreementManager_40bf7af9() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getBaseAgreementChangeLogDetails
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementChangeLogDetailsCustomDTO getBaseAgreementChangeLogDetails(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementChangeLogDetailsCustomDTO baChangeLogDetailsCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementChangeLogDetailsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = baChangeLogDetailsCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBaseAgreementChangeLogDetails(baChangeLogDetailsCustomDTO);
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
	 * inActivateBaseAgreement
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementCustomDTO inActivateBaseAgreement(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementCustomDTO baCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = baCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.inActivateBaseAgreement(baCustomDTO);
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
	 * reActivateBaseAgreement
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementCustomDTO reActivateBaseAgreement(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementCustomDTO baCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = baCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reActivateBaseAgreement(baCustomDTO);
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
	 * amendBaseAgreement
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO amendBaseAgreement(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO baDetailsCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = baDetailsCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.amendBaseAgreement(baDetailsCustomDTO);
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
	 * getBaseAgreement
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO getBaseAgreement(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO baDetailsCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = baDetailsCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBaseAgreement(baDetailsCustomDTO);
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
	 * registerBaseAgreement
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO registerBaseAgreement(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO baDetailsCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = baDetailsCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.registerBaseAgreement(baDetailsCustomDTO);
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
	 * validateAgreementHeader
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO validateAgreementHeader(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = baseAgreementDetailsCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.validateAgreementHeader(baseAgreementDetailsCustomDTO);
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
	 * getAllBaseAgreements
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SearchBaseAgreementCustomDTO getAllBaseAgreements(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SearchBaseAgreementCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SearchBaseAgreementCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAllBaseAgreements(customDTO);
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
}

package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessBaseAgreementDataManager_7c609f96
 */
public class EJSRemoteStatelessBaseAgreementDataManager_7c609f96 extends EJSWrapper implements BaseAgreementDataManager {
	/**
	 * EJSRemoteStatelessBaseAgreementDataManager_7c609f96
	 */
	public EJSRemoteStatelessBaseAgreementDataManager_7c609f96() throws java.rmi.RemoteException {
		super();	}
	/**
	 * addForm
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO addForm(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO formDetailsCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = formDetailsCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.addForm(formDetailsCustomDTO);
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
	 * updateForm
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO updateForm(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateForm(customDTO);
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
	 * getAllForms
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormMaintenanceCustomDTO getAllForms(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormMaintenanceCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormMaintenanceCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAllForms(customDTO);
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
	 * getFormNumbersBySalesOrg
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormNumbersBySalesOrgCustomDTO getFormNumbersBySalesOrg(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SalesOrgForReportsCustomDTO salesOrgForReportsCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormNumbersBySalesOrgCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = salesOrgForReportsCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getFormNumbersBySalesOrg(salesOrgForReportsCustomDTO);
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
	 * addModificationOption
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationOptionCustomDTO addModificationOption(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationOptionCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationOptionCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.addModificationOption(customDTO);
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
	 * updateModificationOptions
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationOptionCustomDTO updateModificationOptions(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationOptionCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationOptionCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateModificationOptions(customDTO);
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
	 * addModificationType
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO addModificationType(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO modificationTypeCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = modificationTypeCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.addModificationType(modificationTypeCustomDTO);
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
	 * getModificationOptions
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO getModificationOptions(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getModificationOptions(customDTO);
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
	 * updateModificationType
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO updateModificationType(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO modificationTypeCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = modificationTypeCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateModificationType(modificationTypeCustomDTO);
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
	 * getAllModificationTypes
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypesCustomDTO getAllModificationTypes(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypesCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypesCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAllModificationTypes(customDTO);
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
	 * getModificationsBySalesOrg
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationsBySalesOrgCustomDTO getModificationsBySalesOrg(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SalesOrgForReportsCustomDTO salesOrgForReportsCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationsBySalesOrgCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = salesOrgForReportsCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getModificationsBySalesOrg(salesOrgForReportsCustomDTO);
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
	 * deleteForm
	 */
	public void deleteForm(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			beanRef.deleteForm(customDTO);
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
		return ;
	}
	/**
	 * deleteModificationType
	 */
	public void deleteModificationType(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO modificationTypeCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = modificationTypeCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			beanRef.deleteModificationType(modificationTypeCustomDTO);
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
		return ;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessProposalDataManager_615f29e3
 */
public class EJSRemoteStatelessProposalDataManager_615f29e3 extends EJSWrapper implements ProposalDataManager {
	/**
	 * EJSRemoteStatelessProposalDataManager_615f29e3
	 */
	public EJSRemoteStatelessProposalDataManager_615f29e3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * updateBilling
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO updateBilling(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO opptCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = opptCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateBilling(opptCustomDTO);
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
	 * updateBillingBlock
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO updateBillingBlock(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO opptCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = opptCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateBillingBlock(opptCustomDTO);
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
	 * updateComplexTypes
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO updateComplexTypes(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO opptCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = opptCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateComplexTypes(opptCustomDTO);
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
	 * updateCurrency
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO updateCurrency(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO opptCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = opptCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateCurrency(opptCustomDTO);
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
	 * updatePayment
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO updatePayment(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO opptCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = opptCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updatePayment(opptCustomDTO);
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
	 * updateSalesOrg
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO updateSalesOrg(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO opptCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = opptCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateSalesOrg(opptCustomDTO);
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
	 * populateStaticData
	 */
	public void populateStaticData() throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			beanRef.populateStaticData();
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
		return ;
	}
}

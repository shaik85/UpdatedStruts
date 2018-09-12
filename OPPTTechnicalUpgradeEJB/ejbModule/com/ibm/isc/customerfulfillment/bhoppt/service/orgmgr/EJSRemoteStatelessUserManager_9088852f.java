package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessUserManager_9088852f
 */
public class EJSRemoteStatelessUserManager_9088852f extends EJSWrapper implements UserManager {
	/**
	 * EJSRemoteStatelessUserManager_9088852f
	 */
	public EJSRemoteStatelessUserManager_9088852f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getUserProfile
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserProfileDomainDTO getUserProfile(java.lang.String userId) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserProfileDomainDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = userId;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getUserProfile(userId);
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
	 * getActivityLog
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ActivityLogCustomDTO getActivityLog(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ActivityLogCustomDTO activityLogCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ActivityLogCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = activityLogCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getActivityLog(activityLogCustom);
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
	 * createBPUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO createBPUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO bpUserCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = bpUserCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createBPUser(bpUserCustom);
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
	 * editBPUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO editBPUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO bpUserCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = bpUserCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.editBPUser(bpUserCustom);
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
	 * registerBPUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO registerBPUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO bpUserCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = bpUserCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.registerBPUser(bpUserCustom);
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
	 * saveEditBPUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO saveEditBPUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO bpUserCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = bpUserCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.saveEditBPUser(bpUserCustom);
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
	 * createNewUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO createNewUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO createUserCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = createUserCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createNewUser(createUserCustom);
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
	 * processCreateNewUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO processCreateNewUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO createUserCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = createUserCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.processCreateNewUser(createUserCustom);
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
	 * createNonBPUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO createNonBPUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO nonBPUserCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = nonBPUserCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createNonBPUser(nonBPUserCustom);
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
	 * editNonBPUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO editNonBPUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO nonBPUserCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = nonBPUserCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.editNonBPUser(nonBPUserCustom);
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
	 * registerNonBPUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO registerNonBPUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO nonBPUserCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = nonBPUserCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.registerNonBPUser(nonBPUserCustom);
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
	 * saveEditNonBPUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO saveEditNonBPUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO nonBPUserCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = nonBPUserCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.saveEditNonBPUser(nonBPUserCustom);
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
	 * listAllSalesOrgs
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReverificationCustomDTO listAllSalesOrgs(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReverificationCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReverificationCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listAllSalesOrgs(customDTO);
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
	 * signIn
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SigninCustomDTO signIn(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SigninCustomDTO customDto) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SigninCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDto;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.signIn(customDto);
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
	 * removeUser
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO removeUser(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO userCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = userCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.removeUser(userCustom);
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
	 * listUsersInSalesOrg
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UsersCustomDTO listUsersInSalesOrg(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UsersCustomDTO usersCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UsersCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = usersCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listUsersInSalesOrg(usersCustom);
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
}

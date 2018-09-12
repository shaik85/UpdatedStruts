package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalStatelessUserManager_9088852f
 */
public class EJSLocalStatelessUserManager_9088852f extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerLocal {
	/**
	 * EJSLocalStatelessUserManager_9088852f
	 */
	public EJSLocalStatelessUserManager_9088852f() {
		super();	}
	/**
	 * isTargetUserEligibleForTransfer
	 */
	public boolean isTargetUserEligibleForTransfer(java.lang.String user, java.lang.String targetUser) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = user;
				_jacc_parms[1] = targetUser;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.isTargetUserEligibleForTransfer(user, targetUser);
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
	 * isUserFromSameGroup
	 */
	public boolean isUserFromSameGroup(java.lang.String user1, java.lang.String user2) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = user1;
				_jacc_parms[1] = user2;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.isUserFromSameGroup(user1, user2);
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
	 * validateForSharing
	 */
	public boolean validateForSharing(java.util.HashMap compareValues) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = compareValues;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.validateForSharing(compareValues);
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
	 * findUserForGroup
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserGroupProfileDomainDTO findUserForGroup(java.lang.String groupName) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserGroupProfileDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = groupName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findUserForGroup(groupName);
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
	 * getUsersFromSameGrp
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserGroupProfileDomainDTO getUsersFromSameGrp(java.lang.String userId, java.lang.String groupName, int role) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserGroupProfileDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = userId;
				_jacc_parms[1] = groupName;
				_jacc_parms[2] = new java.lang.Integer(role);
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getUsersFromSameGrp(userId, groupName, role);
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
	 * getUserProfile
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserProfileDomainDTO getUserProfile(java.lang.String userId) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserProfileDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = userId;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getUserProfile(userId);
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
	 * getEligibleApprover
	 */
	public java.util.List getEligibleApprover() throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.List _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getEligibleApprover();
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
}

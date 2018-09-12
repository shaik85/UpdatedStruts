package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessGroupManager_7a4fb73f
 */
public class EJSRemoteStatelessGroupManager_7a4fb73f extends EJSWrapper implements GroupManager {
	/**
	 * EJSRemoteStatelessGroupManager_7a4fb73f
	 */
	public EJSRemoteStatelessGroupManager_7a4fb73f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * createGroup
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateGroupCustomDTO createGroup(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateGroupCustomDTO createGroupCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateGroupCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = createGroupCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createGroup(createGroupCustomDTO);
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
	 * removeGroup
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupCustomDTO removeGroup(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupCustomDTO groupCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = groupCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.removeGroup(groupCustomDTO);
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
	 * listGroupsInSalesOrg
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupsCustomDTO listGroupsInSalesOrg(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupsCustomDTO groupsCustom) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = groupsCustom;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listGroupsInSalesOrg(groupsCustom);
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
	 * getUsersOfGroup
	 */
	public void getUsersOfGroup() throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManagerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			beanRef.getUsersOfGroup();
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
		return ;
	}
}

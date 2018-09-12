package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPVarianceSWOHome_c577a175
 */
public class EJSLocalCMPVarianceSWOHome_c577a175 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocalHome, com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.VarianceSWOBeanInternalLocalHome_c577a175 {
	/**
	 * EJSLocalCMPVarianceSWOHome_c577a175
	 */
	public EJSLocalCMPVarianceSWOHome_c577a175() {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocal create(int swoId, int dmId, int customerId, int proposalId, java.lang.String swoNo) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = new java.lang.Integer(swoId);
				_jacc_parms[1] = new java.lang.Integer(dmId);
				_jacc_parms[2] = new java.lang.Integer(customerId);
				_jacc_parms[3] = new java.lang.Integer(proposalId);
				_jacc_parms[4] = swoNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPVarianceSWOHomeBean_c577a175 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPVarianceSWOHomeBean_c577a175)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(swoId, dmId, customerId, proposalId, swoNo);
		}
		catch (javax.ejb.CreateException ex) {
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
	 * findByPrimaryKey
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocal findByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPVarianceSWOHomeBean_c577a175 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPVarianceSWOHomeBean_c577a175)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByPrimaryKey_Local(primaryKey);
		}
		catch (javax.ejb.FinderException ex) {
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
	 * findByDM
	 */
	public java.util.Collection findByDM(int dmID, int customerId, int proposalId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = new java.lang.Integer(dmID);
				_jacc_parms[1] = new java.lang.Integer(customerId);
				_jacc_parms[2] = new java.lang.Integer(proposalId);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPVarianceSWOHomeBean_c577a175 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPVarianceSWOHomeBean_c577a175)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByDM_Local(dmID, customerId, proposalId);
		}
		catch (javax.ejb.FinderException ex) {
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
	 * findByEquipmentNo
	 */
	public java.util.Collection findByEquipmentNo(java.lang.String equipmentNo, int proposalId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = equipmentNo;
				_jacc_parms[1] = new java.lang.Integer(proposalId);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPVarianceSWOHomeBean_c577a175 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPVarianceSWOHomeBean_c577a175)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByEquipmentNo_Local(equipmentNo, proposalId);
		}
		catch (javax.ejb.FinderException ex) {
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
	 * findMaxVarianceSWOId
	 */
	public java.util.Collection findMaxVarianceSWOId() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPVarianceSWOHomeBean_c577a175 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPVarianceSWOHomeBean_c577a175)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findMaxVarianceSWOId_Local();
		}
		catch (javax.ejb.FinderException ex) {
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
	 * remove
	 */
	public void remove(java.lang.Object primaryKey) throws javax.ejb.RemoveException, javax.ejb.EJBException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPVarianceSWOHomeBean_c577a175 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EJSCMPVarianceSWOHomeBean_c577a175)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_beanRef.remove(primaryKey);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.EJBException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
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
}

package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalStatelessProposalManagerHome_b56e70b0
 */
public class EJSLocalStatelessProposalManagerHome_b56e70b0 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerLocalHome {
	/**
	 * EJSLocalStatelessProposalManagerHome_b56e70b0
	 */
	public EJSLocalStatelessProposalManagerHome_b56e70b0() {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerLocal create() throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.EJSStatelessProposalManagerHomeBean_b56e70b0 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.EJSStatelessProposalManagerHomeBean_b56e70b0)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local();
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
	com.ibm.isc.customerfulfillment.bhoppt.service.pcm.EJSStatelessProposalManagerHomeBean_b56e70b0 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.pcm.EJSStatelessProposalManagerHomeBean_b56e70b0)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 1, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPBaseAgreementFormHome_5d3cd1d7
 */
public class EJSLocalCMPBaseAgreementFormHome_5d3cd1d7 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormLocalHome, com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementFormBeanInternalLocalHome_5d3cd1d7 {
	/**
	 * EJSLocalCMPBaseAgreementFormHome_5d3cd1d7
	 */
	public EJSLocalCMPBaseAgreementFormHome_5d3cd1d7() {
		super();	}
	/**
	 * create
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormLocal create(java.lang.String formNumber, java.lang.String salesOrganization) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = formNumber;
				_jacc_parms[1] = salesOrganization;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.EJSCMPBaseAgreementFormHomeBean_5d3cd1d7 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.EJSCMPBaseAgreementFormHomeBean_5d3cd1d7)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(formNumber, salesOrganization);
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormLocal findByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.EJSCMPBaseAgreementFormHomeBean_5d3cd1d7 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.EJSCMPBaseAgreementFormHomeBean_5d3cd1d7)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
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
	 * findAllForm
	 */
	public java.util.Collection findAllForm(java.lang.String salesOrganization) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = salesOrganization;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.EJSCMPBaseAgreementFormHomeBean_5d3cd1d7 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.EJSCMPBaseAgreementFormHomeBean_5d3cd1d7)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findAllForm_Local(salesOrganization);
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
	com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.EJSCMPBaseAgreementFormHomeBean_5d3cd1d7 _EJS_beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.EJSCMPBaseAgreementFormHomeBean_5d3cd1d7)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 3, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

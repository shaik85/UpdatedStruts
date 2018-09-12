package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalStatelessProposalDataManager_615f29e3
 */
public class EJSLocalStatelessProposalDataManager_615f29e3 extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerLocal {
	/**
	 * EJSLocalStatelessProposalDataManager_615f29e3
	 */
	public EJSLocalStatelessProposalDataManager_615f29e3() {
		super();	}
	/**
	 * checkValidCombination
	 */
	public boolean checkValidCombination(com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ValidCombinationDomainDTO validCombinationDomainDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = validCombinationDomainDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.checkValidCombination(validCombinationDomainDTO);
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
	 * getCurrencyInformation
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CurrencyDomainDTO getCurrencyInformation(java.lang.String currency) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CurrencyDomainDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = currency;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCurrencyInformation(currency);
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
	 * getProposalFormData
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalFormDataCustomDTO getProposalFormData(boolean createProposal) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalFormDataCustomDTO _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Boolean(createProposal);
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getProposalFormData(createProposal);
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
}

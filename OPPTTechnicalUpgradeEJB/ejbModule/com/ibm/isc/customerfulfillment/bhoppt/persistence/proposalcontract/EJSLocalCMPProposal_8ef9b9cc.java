package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPProposal_8ef9b9cc
 */
public class EJSLocalCMPProposal_8ef9b9cc extends EJSLocalWrapper implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalLocal {
	/**
	 * EJSLocalCMPProposal_8ef9b9cc
	 */
	public EJSLocalCMPProposal_8ef9b9cc() {
		super();	}
	/**
	 * getAnnivInvoiceAmount
	 */
	public double getAnnivInvoiceAmount() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAnnivInvoiceAmount();
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
	 * getAnniversaryAmt
	 */
	public double getAnniversaryAmt() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAnniversaryAmt();
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
	 * getCapAmt
	 */
	public double getCapAmt() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCapAmt();
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
	 * getCapMinus
	 */
	public double getCapMinus() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCapMinus();
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
	 * getCapPlus
	 */
	public double getCapPlus() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCapPlus();
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
	 * getCapVariance
	 */
	public double getCapVariance() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCapVariance();
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
	 * getContrAmendNo
	 */
	public double getContrAmendNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContrAmendNo();
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
	/**
	 * getCumVariance
	 */
	public double getCumVariance() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCumVariance();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 7, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDiscount
	 */
	public double getDiscount() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDiscount();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 8, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getGrowthFactor
	 */
	public double getGrowthFactor() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getGrowthFactor();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 9, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getInvoiceAmt
	 */
	public double getInvoiceAmt() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getInvoiceAmt();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 10, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getMonthlyInvoiceAmount
	 */
	public double getMonthlyInvoiceAmount() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getMonthlyInvoiceAmount();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 11, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPreTVMInvoiceAmt
	 */
	public double getPreTVMInvoiceAmt() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPreTVMInvoiceAmt();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 12, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPreTvm
	 */
	public double getPreTvm() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPreTvm();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 13, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getQuarterlyInvoiceAmount
	 */
	public double getQuarterlyInvoiceAmount() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getQuarterlyInvoiceAmount();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 14, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSandsAnniversaryAmt2
	 */
	public double getSandsAnniversaryAmt2() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSandsAnniversaryAmt2();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 15, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSandsAnniversaryAmt3
	 */
	public double getSandsAnniversaryAmt3() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSandsAnniversaryAmt3();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 16, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSandsAnniversaryAmt4
	 */
	public double getSandsAnniversaryAmt4() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSandsAnniversaryAmt4();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 17, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSandsAnniversaryAmt5
	 */
	public double getSandsAnniversaryAmt5() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSandsAnniversaryAmt5();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 18, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSandsDiscountAmount1
	 */
	public double getSandsDiscountAmount1() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSandsDiscountAmount1();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 19, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSandsDiscountAmount2
	 */
	public double getSandsDiscountAmount2() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSandsDiscountAmount2();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 20, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSandsDiscountAmount3
	 */
	public double getSandsDiscountAmount3() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSandsDiscountAmount3();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 21, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSandsDiscountAmount4
	 */
	public double getSandsDiscountAmount4() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 22, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSandsDiscountAmount4();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 22, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSandsDiscountAmount5
	 */
	public double getSandsDiscountAmount5() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 23, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSandsDiscountAmount5();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 23, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSandsanniversaryamt
	 */
	public double getSandsanniversaryamt() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 24, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSandsanniversaryamt();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 24, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSandsdiscountamount
	 */
	public double getSandsdiscountamount() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 25, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSandsdiscountamount();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 25, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSemiAnnivInvoiceAmount
	 */
	public double getSemiAnnivInvoiceAmount() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 26, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSemiAnnivInvoiceAmount();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 26, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSpecialRate
	 */
	public double getSpecialRate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 27, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSpecialRate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 27, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getTvmRate
	 */
	public double getTvmRate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		double _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 28, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getTvmRate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 28, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAddValueDays
	 */
	public int getAddValueDays() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 29, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAddValueDays();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 29, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContrRenewNo
	 */
	public int getContrRenewNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 30, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContrRenewNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 30, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContractPeriodVarNo
	 */
	public int getContractPeriodVarNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 31, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContractPeriodVarNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 31, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContractReplNo
	 */
	public int getContractReplNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 32, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContractReplNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 32, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContractVarNo
	 */
	public int getContractVarNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 33, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContractVarNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 33, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getProposalId
	 */
	public int getProposalId() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 34, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getProposalId();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 34, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAdvancedBilling
	 */
	public java.lang.String getAdvancedBilling() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 35, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAdvancedBilling();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 35, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAmentIndicatior
	 */
	public java.lang.String getAmentIndicatior() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 36, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAmentIndicatior();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 36, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getApprovedBy
	 */
	public java.lang.String getApprovedBy() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 37, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getApprovedBy();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 37, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAutoPopulateInd
	 */
	public java.lang.String getAutoPopulateInd() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 38, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAutoPopulateInd();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 38, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBillingBlock
	 */
	public java.lang.String getBillingBlock() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 39, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBillingBlock();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 39, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBillingFreqCode
	 */
	public java.lang.String getBillingFreqCode() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 40, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBillingFreqCode();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 40, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBillingType
	 */
	public java.lang.String getBillingType() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 41, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBillingType();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 41, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBlbIndicator
	 */
	public java.lang.String getBlbIndicator() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 42, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBlbIndicator();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 42, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCciInd
	 */
	public java.lang.String getCciInd() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 43, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCciInd();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 43, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getChannelRole
	 */
	public java.lang.String getChannelRole() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 44, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getChannelRole();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 44, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getComments
	 */
	public java.lang.String getComments() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 45, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getComments();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 45, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContrNo
	 */
	public java.lang.String getContrNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 46, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContrNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 46, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContrType
	 */
	public java.lang.String getContrType() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 47, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContrType();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 47, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContractCreateFlag
	 */
	public java.lang.String getContractCreateFlag() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 48, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContractCreateFlag();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 48, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContractType
	 */
	public java.lang.String getContractType() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 49, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContractType();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 49, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCpsId
	 */
	public java.lang.String getCpsId() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 50, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCpsId();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 50, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCreatedBy
	 */
	public java.lang.String getCreatedBy() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 51, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCreatedBy();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 51, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCurrency
	 */
	public java.lang.String getCurrency() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 52, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCurrency();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 52, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDeletedInd
	 */
	public java.lang.String getDeletedInd() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 53, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDeletedInd();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 53, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDeltaFetchInd
	 */
	public java.lang.String getDeltaFetchInd() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 54, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDeltaFetchInd();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 54, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDeviationDateRule
	 */
	public java.lang.String getDeviationDateRule() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 55, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDeviationDateRule();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 55, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDistrChannel
	 */
	public java.lang.String getDistrChannel() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 56, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDistrChannel();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 56, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDivisionCode
	 */
	public java.lang.String getDivisionCode() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 57, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDivisionCode();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 57, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getExtContractNo
	 */
	public java.lang.String getExtContractNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 58, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getExtContractNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 58, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getFreeText
	 */
	public java.lang.String getFreeText() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 59, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getFreeText();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 59, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getGroupName
	 */
	public java.lang.String getGroupName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 60, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getGroupName();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 60, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getGsaInd
	 */
	public java.lang.String getGsaInd() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 61, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getGsaInd();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 61, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getIgfNumber
	 */
	public java.lang.String getIgfNumber() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 62, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getIgfNumber();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 62, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getIneligibleInd
	 */
	public java.lang.String getIneligibleInd() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 63, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getIneligibleInd();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 63, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getInvoiceInd
	 */
	public java.lang.String getInvoiceInd() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 64, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getInvoiceInd();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 64, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLockedBy
	 */
	public java.lang.String getLockedBy() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 65, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getLockedBy();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 65, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getOcpsID
	 */
	public java.lang.String getOcpsID() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 66, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getOcpsID();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 66, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getOldContractNo
	 */
	public java.lang.String getOldContractNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 67, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getOldContractNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 67, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getOrgVarContractNo
	 */
	public java.lang.String getOrgVarContractNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 68, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getOrgVarContractNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 68, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPakId
	 */
	public java.lang.String getPakId() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 69, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPakId();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 69, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPaymentMethod
	 */
	public java.lang.String getPaymentMethod() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 70, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPaymentMethod();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 70, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPaymentTerm
	 */
	public java.lang.String getPaymentTerm() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 71, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPaymentTerm();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 71, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPoNo
	 */
	public java.lang.String getPoNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 72, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPoNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 72, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPrebillIndicator
	 */
	public java.lang.String getPrebillIndicator() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 73, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPrebillIndicator();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 73, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getProposalContent
	 */
	public java.lang.String getProposalContent() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 74, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getProposalContent();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 74, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getProposalName
	 */
	public java.lang.String getProposalName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 75, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getProposalName();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 75, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getProposalSharing
	 */
	public java.lang.String getProposalSharing() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 76, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getProposalSharing();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 76, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getProposalType
	 */
	public java.lang.String getProposalType() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 77, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getProposalType();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 77, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRefetchInd
	 */
	public java.lang.String getRefetchInd() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 78, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRefetchInd();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 78, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getReg9DPartmerName
	 */
	public java.lang.String getReg9DPartmerName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 79, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getReg9DPartmerName();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 79, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getReg9DPartnerNo
	 */
	public java.lang.String getReg9DPartnerNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 80, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getReg9DPartnerNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 80, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegBillToPartyASNo
	 */
	public java.lang.String getRegBillToPartyASNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 81, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegBillToPartyASNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 81, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegBillToPartyListNo
	 */
	public java.lang.String getRegBillToPartyListNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 82, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegBillToPartyListNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 82, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegBillToPartyName
	 */
	public java.lang.String getRegBillToPartyName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 83, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegBillToPartyName();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 83, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegBilltoPartyNo
	 */
	public java.lang.String getRegBilltoPartyNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 84, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegBilltoPartyNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 84, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegCustomerASNO
	 */
	public java.lang.String getRegCustomerASNO() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 85, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegCustomerASNO();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 85, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegCustomerListNo
	 */
	public java.lang.String getRegCustomerListNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 86, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegCustomerListNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 86, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegCustomerName
	 */
	public java.lang.String getRegCustomerName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 87, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegCustomerName();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 87, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegCustomerNo
	 */
	public java.lang.String getRegCustomerNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 88, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegCustomerNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 88, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegPayerASNo
	 */
	public java.lang.String getRegPayerASNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 89, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegPayerASNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 89, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegPayerListNo
	 */
	public java.lang.String getRegPayerListNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 90, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegPayerListNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 90, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegPayerName
	 */
	public java.lang.String getRegPayerName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 91, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegPayerName();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 91, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegPayerNo
	 */
	public java.lang.String getRegPayerNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 92, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegPayerNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 92, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegShipTOPartyASNo
	 */
	public java.lang.String getRegShipTOPartyASNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 93, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegShipTOPartyASNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 93, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegShipToPartyListNo
	 */
	public java.lang.String getRegShipToPartyListNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 94, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegShipToPartyListNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 94, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegShipToPartyName
	 */
	public java.lang.String getRegShipToPartyName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 95, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegShipToPartyName();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 95, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRegShipToPartyNo
	 */
	public java.lang.String getRegShipToPartyNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 96, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRegShipToPartyNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 96, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getReportName
	 */
	public java.lang.String getReportName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 97, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getReportName();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 97, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSAndSIncluded
	 */
	public java.lang.String getSAndSIncluded() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 98, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSAndSIncluded();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 98, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSalesGroup
	 */
	public java.lang.String getSalesGroup() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 99, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSalesGroup();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 99, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSalesOrg
	 */
	public java.lang.String getSalesOrg() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 100, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSalesOrg();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 100, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSandsExtendPeriod
	 */
	public java.lang.String getSandsExtendPeriod() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 101, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSandsExtendPeriod();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 101, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getStatusCode
	 */
	public java.lang.String getStatusCode() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 102, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getStatusCode();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 102, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSubmittedBy
	 */
	public java.lang.String getSubmittedBy() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 103, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSubmittedBy();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 103, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSubmitterRole
	 */
	public java.lang.String getSubmitterRole() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 104, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSubmitterRole();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 104, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSuppressInvoice
	 */
	public java.lang.String getSuppressInvoice() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 105, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSuppressInvoice();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 105, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getTpContractNo
	 */
	public java.lang.String getTpContractNo() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 106, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getTpContractNo();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 106, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVarInd
	 */
	public java.lang.String getVarInd() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 107, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVarInd();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 107, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAmendEffectiveDate
	 */
	public java.sql.Date getAmendEffectiveDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 108, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAmendEffectiveDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 108, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getApprovedDate
	 */
	public java.sql.Date getApprovedDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 109, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getApprovedDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 109, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContrClsDate
	 */
	public java.sql.Date getContrClsDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 110, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContrClsDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 110, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContrExtnDate
	 */
	public java.sql.Date getContrExtnDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 111, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContrExtnDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 111, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContrReplDate
	 */
	public java.sql.Date getContrReplDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 112, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContrReplDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 112, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContrRetrDate
	 */
	public java.sql.Date getContrRetrDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 113, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContrRetrDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 113, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContractEndDate
	 */
	public java.sql.Date getContractEndDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 114, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContractEndDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 114, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContractEndPeriod
	 */
	public java.sql.Date getContractEndPeriod() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 115, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContractEndPeriod();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 115, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContractStartDate
	 */
	public java.sql.Date getContractStartDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 116, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContractStartDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 116, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContractStartPeriod
	 */
	public java.sql.Date getContractStartPeriod() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 117, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContractStartPeriod();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 117, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCreatedDate
	 */
	public java.sql.Date getCreatedDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 118, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCreatedDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 118, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDatePriced
	 */
	public java.sql.Date getDatePriced() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 119, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDatePriced();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 119, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getEswFetchDate
	 */
	public java.sql.Date getEswFetchDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 120, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getEswFetchDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 120, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getFetchDate
	 */
	public java.sql.Date getFetchDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 121, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getFetchDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 121, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getFixedValueDate
	 */
	public java.sql.Date getFixedValueDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 122, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getFixedValueDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 122, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLastUpdatedDate
	 */
	public java.sql.Date getLastUpdatedDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 123, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getLastUpdatedDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 123, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLockedOn
	 */
	public java.sql.Date getLockedOn() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 124, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getLockedOn();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 124, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPoDate
	 */
	public java.sql.Date getPoDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 125, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPoDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 125, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVarDate
	 */
	public java.sql.Date getVarDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Date _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 126, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVarDate();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 126, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getEswFetchTime
	 */
	public java.sql.Time getEswFetchTime() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.sql.Time _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 127, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getEswFetchTime();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 127, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * setAddValueDays
	 */
	public void setAddValueDays(int newAddValueDays) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(newAddValueDays);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 128, _EJS_s, _jacc_parms);
			beanRef.setAddValueDays(newAddValueDays);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 128, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAdvancedBilling
	 */
	public void setAdvancedBilling(java.lang.String newAdvancedBilling) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newAdvancedBilling;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 129, _EJS_s, _jacc_parms);
			beanRef.setAdvancedBilling(newAdvancedBilling);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 129, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAmendEffectiveDate
	 */
	public void setAmendEffectiveDate(java.sql.Date newAmendEffectiveDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newAmendEffectiveDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 130, _EJS_s, _jacc_parms);
			beanRef.setAmendEffectiveDate(newAmendEffectiveDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 130, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAmentIndicatior
	 */
	public void setAmentIndicatior(java.lang.String newAmentIndicatior) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newAmentIndicatior;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 131, _EJS_s, _jacc_parms);
			beanRef.setAmentIndicatior(newAmentIndicatior);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 131, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAnnivInvoiceAmount
	 */
	public void setAnnivInvoiceAmount(double newAnnivInvoiceAmount) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newAnnivInvoiceAmount);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 132, _EJS_s, _jacc_parms);
			beanRef.setAnnivInvoiceAmount(newAnnivInvoiceAmount);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 132, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAnniversaryAmt
	 */
	public void setAnniversaryAmt(double newAnniversaryAmt) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newAnniversaryAmt);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 133, _EJS_s, _jacc_parms);
			beanRef.setAnniversaryAmt(newAnniversaryAmt);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 133, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setApprovedBy
	 */
	public void setApprovedBy(java.lang.String newApprovedBy) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newApprovedBy;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 134, _EJS_s, _jacc_parms);
			beanRef.setApprovedBy(newApprovedBy);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 134, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setApprovedDate
	 */
	public void setApprovedDate(java.sql.Date newApprovedDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newApprovedDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 135, _EJS_s, _jacc_parms);
			beanRef.setApprovedDate(newApprovedDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 135, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAutoPopulateInd
	 */
	public void setAutoPopulateInd(java.lang.String newAutoPopulateInd) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newAutoPopulateInd;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 136, _EJS_s, _jacc_parms);
			beanRef.setAutoPopulateInd(newAutoPopulateInd);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 136, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setBillingBlock
	 */
	public void setBillingBlock(java.lang.String newBillingBlock) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBillingBlock;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 137, _EJS_s, _jacc_parms);
			beanRef.setBillingBlock(newBillingBlock);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 137, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setBillingFreqCode
	 */
	public void setBillingFreqCode(java.lang.String newBillingFreqCode) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBillingFreqCode;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 138, _EJS_s, _jacc_parms);
			beanRef.setBillingFreqCode(newBillingFreqCode);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 138, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setBillingType
	 */
	public void setBillingType(java.lang.String newBillingType) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newBillingType;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 139, _EJS_s, _jacc_parms);
			beanRef.setBillingType(newBillingType);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 139, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setBlbIndicator
	 */
	public void setBlbIndicator(java.lang.String blbIndicator) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = blbIndicator;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 140, _EJS_s, _jacc_parms);
			beanRef.setBlbIndicator(blbIndicator);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 140, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCapAmt
	 */
	public void setCapAmt(double newCapAmt) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newCapAmt);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 141, _EJS_s, _jacc_parms);
			beanRef.setCapAmt(newCapAmt);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 141, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCapMinus
	 */
	public void setCapMinus(double newCapMinus) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newCapMinus);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 142, _EJS_s, _jacc_parms);
			beanRef.setCapMinus(newCapMinus);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 142, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCapPlus
	 */
	public void setCapPlus(double newCapPlus) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newCapPlus);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 143, _EJS_s, _jacc_parms);
			beanRef.setCapPlus(newCapPlus);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 143, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCapVariance
	 */
	public void setCapVariance(double newCapVariance) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newCapVariance);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 144, _EJS_s, _jacc_parms);
			beanRef.setCapVariance(newCapVariance);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 144, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCciInd
	 */
	public void setCciInd(java.lang.String cciInd) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cciInd;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 145, _EJS_s, _jacc_parms);
			beanRef.setCciInd(cciInd);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 145, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setChannelRole
	 */
	public void setChannelRole(java.lang.String newChannelRole) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newChannelRole;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 146, _EJS_s, _jacc_parms);
			beanRef.setChannelRole(newChannelRole);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 146, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setComments
	 */
	public void setComments(java.lang.String newComments) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newComments;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 147, _EJS_s, _jacc_parms);
			beanRef.setComments(newComments);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 147, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContrAmendNo
	 */
	public void setContrAmendNo(double newContrAmendNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newContrAmendNo);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 148, _EJS_s, _jacc_parms);
			beanRef.setContrAmendNo(newContrAmendNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 148, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContrClsDate
	 */
	public void setContrClsDate(java.sql.Date newContrClsDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newContrClsDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 149, _EJS_s, _jacc_parms);
			beanRef.setContrClsDate(newContrClsDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 149, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContrExtnDate
	 */
	public void setContrExtnDate(java.sql.Date newContrExtnDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newContrExtnDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 150, _EJS_s, _jacc_parms);
			beanRef.setContrExtnDate(newContrExtnDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 150, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContrNo
	 */
	public void setContrNo(java.lang.String newContrNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newContrNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 151, _EJS_s, _jacc_parms);
			beanRef.setContrNo(newContrNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 151, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContrRenewNo
	 */
	public void setContrRenewNo(int newContrRenewNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(newContrRenewNo);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 152, _EJS_s, _jacc_parms);
			beanRef.setContrRenewNo(newContrRenewNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 152, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContrReplDate
	 */
	public void setContrReplDate(java.sql.Date newContrReplDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newContrReplDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 153, _EJS_s, _jacc_parms);
			beanRef.setContrReplDate(newContrReplDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 153, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContrRetrDate
	 */
	public void setContrRetrDate(java.sql.Date newContrRetrDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newContrRetrDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 154, _EJS_s, _jacc_parms);
			beanRef.setContrRetrDate(newContrRetrDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 154, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContrType
	 */
	public void setContrType(java.lang.String newContrType) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newContrType;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 155, _EJS_s, _jacc_parms);
			beanRef.setContrType(newContrType);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 155, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContractCreateFlag
	 */
	public void setContractCreateFlag(java.lang.String newContractCreateFlag) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newContractCreateFlag;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 156, _EJS_s, _jacc_parms);
			beanRef.setContractCreateFlag(newContractCreateFlag);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 156, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContractEndDate
	 */
	public void setContractEndDate(java.sql.Date newContractEndDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newContractEndDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 157, _EJS_s, _jacc_parms);
			beanRef.setContractEndDate(newContractEndDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 157, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContractEndPeriod
	 */
	public void setContractEndPeriod(java.sql.Date newContractEndPeriod) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newContractEndPeriod;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 158, _EJS_s, _jacc_parms);
			beanRef.setContractEndPeriod(newContractEndPeriod);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 158, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContractPeriodVarNo
	 */
	public void setContractPeriodVarNo(int newContractPeriodVarNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(newContractPeriodVarNo);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 159, _EJS_s, _jacc_parms);
			beanRef.setContractPeriodVarNo(newContractPeriodVarNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 159, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContractReplNo
	 */
	public void setContractReplNo(int newContractReplNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(newContractReplNo);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 160, _EJS_s, _jacc_parms);
			beanRef.setContractReplNo(newContractReplNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 160, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContractStartDate
	 */
	public void setContractStartDate(java.sql.Date newContractStartDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newContractStartDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 161, _EJS_s, _jacc_parms);
			beanRef.setContractStartDate(newContractStartDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 161, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContractStartPeriod
	 */
	public void setContractStartPeriod(java.sql.Date newContractStartPeriod) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newContractStartPeriod;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 162, _EJS_s, _jacc_parms);
			beanRef.setContractStartPeriod(newContractStartPeriod);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 162, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContractType
	 */
	public void setContractType(java.lang.String contractType) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = contractType;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 163, _EJS_s, _jacc_parms);
			beanRef.setContractType(contractType);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 163, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContractVarNo
	 */
	public void setContractVarNo(int newContractVarNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(newContractVarNo);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 164, _EJS_s, _jacc_parms);
			beanRef.setContractVarNo(newContractVarNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 164, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCpsId
	 */
	public void setCpsId(java.lang.String cpsId) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cpsId;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 165, _EJS_s, _jacc_parms);
			beanRef.setCpsId(cpsId);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 165, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCreatedBy
	 */
	public void setCreatedBy(java.lang.String newCreatedBy) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCreatedBy;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 166, _EJS_s, _jacc_parms);
			beanRef.setCreatedBy(newCreatedBy);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 166, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCreatedDate
	 */
	public void setCreatedDate(java.sql.Date newCreatedDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCreatedDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 167, _EJS_s, _jacc_parms);
			beanRef.setCreatedDate(newCreatedDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 167, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCumVariance
	 */
	public void setCumVariance(double newCumVariance) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newCumVariance);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 168, _EJS_s, _jacc_parms);
			beanRef.setCumVariance(newCumVariance);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 168, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCurrency
	 */
	public void setCurrency(java.lang.String newCurrency) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCurrency;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 169, _EJS_s, _jacc_parms);
			beanRef.setCurrency(newCurrency);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 169, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDatePriced
	 */
	public void setDatePriced(java.sql.Date newDatePriced) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newDatePriced;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 170, _EJS_s, _jacc_parms);
			beanRef.setDatePriced(newDatePriced);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 170, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDeletedInd
	 */
	public void setDeletedInd(java.lang.String newDeletedInd) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newDeletedInd;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 171, _EJS_s, _jacc_parms);
			beanRef.setDeletedInd(newDeletedInd);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 171, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDeltaFetchInd
	 */
	public void setDeltaFetchInd(java.lang.String newDeltaFetchInd) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newDeltaFetchInd;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 172, _EJS_s, _jacc_parms);
			beanRef.setDeltaFetchInd(newDeltaFetchInd);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 172, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDeviationDateRule
	 */
	public void setDeviationDateRule(java.lang.String newDeviationDateRule) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newDeviationDateRule;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 173, _EJS_s, _jacc_parms);
			beanRef.setDeviationDateRule(newDeviationDateRule);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 173, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDiscount
	 */
	public void setDiscount(double newDiscount) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newDiscount);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 174, _EJS_s, _jacc_parms);
			beanRef.setDiscount(newDiscount);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 174, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDistrChannel
	 */
	public void setDistrChannel(java.lang.String newDistrChannel) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newDistrChannel;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 175, _EJS_s, _jacc_parms);
			beanRef.setDistrChannel(newDistrChannel);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 175, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDivisionCode
	 */
	public void setDivisionCode(java.lang.String newDivisionCode) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newDivisionCode;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 176, _EJS_s, _jacc_parms);
			beanRef.setDivisionCode(newDivisionCode);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 176, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setEswFetchDate
	 */
	public void setEswFetchDate(java.sql.Date newEswFetchDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newEswFetchDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 177, _EJS_s, _jacc_parms);
			beanRef.setEswFetchDate(newEswFetchDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 177, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setEswFetchTime
	 */
	public void setEswFetchTime(java.sql.Time newEswFetchTime) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newEswFetchTime;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 178, _EJS_s, _jacc_parms);
			beanRef.setEswFetchTime(newEswFetchTime);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 178, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setExtContractNo
	 */
	public void setExtContractNo(java.lang.String newExtContractNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newExtContractNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 179, _EJS_s, _jacc_parms);
			beanRef.setExtContractNo(newExtContractNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 179, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setFetchDate
	 */
	public void setFetchDate(java.sql.Date newFetchDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newFetchDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 180, _EJS_s, _jacc_parms);
			beanRef.setFetchDate(newFetchDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 180, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setFixedValueDate
	 */
	public void setFixedValueDate(java.sql.Date newFixedValueDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newFixedValueDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 181, _EJS_s, _jacc_parms);
			beanRef.setFixedValueDate(newFixedValueDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 181, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setFreeText
	 */
	public void setFreeText(java.lang.String newFreeText) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newFreeText;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 182, _EJS_s, _jacc_parms);
			beanRef.setFreeText(newFreeText);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 182, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setGroupName
	 */
	public void setGroupName(java.lang.String newGroupName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newGroupName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 183, _EJS_s, _jacc_parms);
			beanRef.setGroupName(newGroupName);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 183, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setGrowthFactor
	 */
	public void setGrowthFactor(double newGrowthFactor) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newGrowthFactor);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 184, _EJS_s, _jacc_parms);
			beanRef.setGrowthFactor(newGrowthFactor);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 184, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setGsaInd
	 */
	public void setGsaInd(java.lang.String newGsaInd) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newGsaInd;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 185, _EJS_s, _jacc_parms);
			beanRef.setGsaInd(newGsaInd);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 185, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setIgfNumber
	 */
	public void setIgfNumber(java.lang.String newIgfNumber) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newIgfNumber;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 186, _EJS_s, _jacc_parms);
			beanRef.setIgfNumber(newIgfNumber);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 186, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setIneligibleInd
	 */
	public void setIneligibleInd(java.lang.String newIneligibleInd) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newIneligibleInd;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 187, _EJS_s, _jacc_parms);
			beanRef.setIneligibleInd(newIneligibleInd);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 187, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setInvoiceAmt
	 */
	public void setInvoiceAmt(double newInvoiceAmt) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newInvoiceAmt);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 188, _EJS_s, _jacc_parms);
			beanRef.setInvoiceAmt(newInvoiceAmt);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 188, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setInvoiceInd
	 */
	public void setInvoiceInd(java.lang.String newInvoiceInd) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newInvoiceInd;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 189, _EJS_s, _jacc_parms);
			beanRef.setInvoiceInd(newInvoiceInd);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 189, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setLastUpdatedDate
	 */
	public void setLastUpdatedDate(java.sql.Date newLastUpdatedDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newLastUpdatedDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 190, _EJS_s, _jacc_parms);
			beanRef.setLastUpdatedDate(newLastUpdatedDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 190, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setLockedBy
	 */
	public void setLockedBy(java.lang.String newLockedBy) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newLockedBy;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 191, _EJS_s, _jacc_parms);
			beanRef.setLockedBy(newLockedBy);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 191, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setLockedOn
	 */
	public void setLockedOn(java.sql.Date newLockedOn) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newLockedOn;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 192, _EJS_s, _jacc_parms);
			beanRef.setLockedOn(newLockedOn);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 192, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setMonthlyInvoiceAmount
	 */
	public void setMonthlyInvoiceAmount(double newMonthlyInvoiceAmount) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newMonthlyInvoiceAmount);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 193, _EJS_s, _jacc_parms);
			beanRef.setMonthlyInvoiceAmount(newMonthlyInvoiceAmount);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 193, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setOcpsID
	 */
	public void setOcpsID(java.lang.String ocpsID) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = ocpsID;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 194, _EJS_s, _jacc_parms);
			beanRef.setOcpsID(ocpsID);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 194, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setOldContractNo
	 */
	public void setOldContractNo(java.lang.String newOldContractNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newOldContractNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 195, _EJS_s, _jacc_parms);
			beanRef.setOldContractNo(newOldContractNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 195, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setOrgVarContractNo
	 */
	public void setOrgVarContractNo(java.lang.String newOrgVarContractNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newOrgVarContractNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 196, _EJS_s, _jacc_parms);
			beanRef.setOrgVarContractNo(newOrgVarContractNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 196, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPakId
	 */
	public void setPakId(java.lang.String newPakId) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPakId;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 197, _EJS_s, _jacc_parms);
			beanRef.setPakId(newPakId);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 197, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPaymentMethod
	 */
	public void setPaymentMethod(java.lang.String newPaymentMethod) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPaymentMethod;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 198, _EJS_s, _jacc_parms);
			beanRef.setPaymentMethod(newPaymentMethod);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 198, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPaymentTerm
	 */
	public void setPaymentTerm(java.lang.String newPaymentTerm) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPaymentTerm;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 199, _EJS_s, _jacc_parms);
			beanRef.setPaymentTerm(newPaymentTerm);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 199, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPoDate
	 */
	public void setPoDate(java.sql.Date newPoDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPoDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 200, _EJS_s, _jacc_parms);
			beanRef.setPoDate(newPoDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 200, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPoNo
	 */
	public void setPoNo(java.lang.String newPoNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPoNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 201, _EJS_s, _jacc_parms);
			beanRef.setPoNo(newPoNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 201, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPreTVMInvoiceAmt
	 */
	public void setPreTVMInvoiceAmt(double newPreTVMInvoiceAmt) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newPreTVMInvoiceAmt);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 202, _EJS_s, _jacc_parms);
			beanRef.setPreTVMInvoiceAmt(newPreTVMInvoiceAmt);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 202, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPreTvm
	 */
	public void setPreTvm(double newPreTvm) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newPreTvm);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 203, _EJS_s, _jacc_parms);
			beanRef.setPreTvm(newPreTvm);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 203, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPrebillIndicator
	 */
	public void setPrebillIndicator(java.lang.String prebillIndicator) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = prebillIndicator;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 204, _EJS_s, _jacc_parms);
			beanRef.setPrebillIndicator(prebillIndicator);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 204, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setProposalContent
	 */
	public void setProposalContent(java.lang.String newProposalContent) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newProposalContent;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 205, _EJS_s, _jacc_parms);
			beanRef.setProposalContent(newProposalContent);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 205, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setProposalId
	 */
	public void setProposalId(int newProposalId) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(newProposalId);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 206, _EJS_s, _jacc_parms);
			beanRef.setProposalId(newProposalId);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 206, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setProposalName
	 */
	public void setProposalName(java.lang.String newProposalName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newProposalName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 207, _EJS_s, _jacc_parms);
			beanRef.setProposalName(newProposalName);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 207, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setProposalSharing
	 */
	public void setProposalSharing(java.lang.String newProposalSharing) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newProposalSharing;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 208, _EJS_s, _jacc_parms);
			beanRef.setProposalSharing(newProposalSharing);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 208, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setProposalType
	 */
	public void setProposalType(java.lang.String newProposalType) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newProposalType;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 209, _EJS_s, _jacc_parms);
			beanRef.setProposalType(newProposalType);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 209, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setQuarterlyInvoiceAmount
	 */
	public void setQuarterlyInvoiceAmount(double newQuarterlyInvoiceAmount) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newQuarterlyInvoiceAmount);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 210, _EJS_s, _jacc_parms);
			beanRef.setQuarterlyInvoiceAmount(newQuarterlyInvoiceAmount);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 210, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRefetchInd
	 */
	public void setRefetchInd(java.lang.String newRefetchInd) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRefetchInd;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 211, _EJS_s, _jacc_parms);
			beanRef.setRefetchInd(newRefetchInd);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 211, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setReg9DPartmerName
	 */
	public void setReg9DPartmerName(java.lang.String newReg9DPartmerName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newReg9DPartmerName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 212, _EJS_s, _jacc_parms);
			beanRef.setReg9DPartmerName(newReg9DPartmerName);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 212, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setReg9DPartnerNo
	 */
	public void setReg9DPartnerNo(java.lang.String newReg9DPartnerNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newReg9DPartnerNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 213, _EJS_s, _jacc_parms);
			beanRef.setReg9DPartnerNo(newReg9DPartnerNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 213, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegBillToPartyASNo
	 */
	public void setRegBillToPartyASNo(java.lang.String newRegBillToPartyASNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegBillToPartyASNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 214, _EJS_s, _jacc_parms);
			beanRef.setRegBillToPartyASNo(newRegBillToPartyASNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 214, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegBillToPartyListNo
	 */
	public void setRegBillToPartyListNo(java.lang.String newRegBillToPartyListNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegBillToPartyListNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 215, _EJS_s, _jacc_parms);
			beanRef.setRegBillToPartyListNo(newRegBillToPartyListNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 215, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegBillToPartyName
	 */
	public void setRegBillToPartyName(java.lang.String newRegBillToPartyName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegBillToPartyName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 216, _EJS_s, _jacc_parms);
			beanRef.setRegBillToPartyName(newRegBillToPartyName);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 216, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegBilltoPartyNo
	 */
	public void setRegBilltoPartyNo(java.lang.String newRegBilltoPartyNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegBilltoPartyNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 217, _EJS_s, _jacc_parms);
			beanRef.setRegBilltoPartyNo(newRegBilltoPartyNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 217, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegCustomerASNO
	 */
	public void setRegCustomerASNO(java.lang.String newRegCustomerASNO) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegCustomerASNO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 218, _EJS_s, _jacc_parms);
			beanRef.setRegCustomerASNO(newRegCustomerASNO);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 218, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegCustomerListNo
	 */
	public void setRegCustomerListNo(java.lang.String newRegCustomerListNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegCustomerListNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 219, _EJS_s, _jacc_parms);
			beanRef.setRegCustomerListNo(newRegCustomerListNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 219, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegCustomerName
	 */
	public void setRegCustomerName(java.lang.String newRegCustomerName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegCustomerName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 220, _EJS_s, _jacc_parms);
			beanRef.setRegCustomerName(newRegCustomerName);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 220, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegCustomerNo
	 */
	public void setRegCustomerNo(java.lang.String newRegCustomerNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegCustomerNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 221, _EJS_s, _jacc_parms);
			beanRef.setRegCustomerNo(newRegCustomerNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 221, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegPayerASNo
	 */
	public void setRegPayerASNo(java.lang.String newRegPayerASNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegPayerASNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 222, _EJS_s, _jacc_parms);
			beanRef.setRegPayerASNo(newRegPayerASNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 222, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegPayerListNo
	 */
	public void setRegPayerListNo(java.lang.String newRegPayerListNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegPayerListNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 223, _EJS_s, _jacc_parms);
			beanRef.setRegPayerListNo(newRegPayerListNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 223, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegPayerName
	 */
	public void setRegPayerName(java.lang.String newRegPayerName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegPayerName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 224, _EJS_s, _jacc_parms);
			beanRef.setRegPayerName(newRegPayerName);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 224, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegPayerNo
	 */
	public void setRegPayerNo(java.lang.String newRegPayerNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegPayerNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 225, _EJS_s, _jacc_parms);
			beanRef.setRegPayerNo(newRegPayerNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 225, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegShipTOPartyASNo
	 */
	public void setRegShipTOPartyASNo(java.lang.String newRegShipTOPartyASNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegShipTOPartyASNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 226, _EJS_s, _jacc_parms);
			beanRef.setRegShipTOPartyASNo(newRegShipTOPartyASNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 226, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegShipToPartyListNo
	 */
	public void setRegShipToPartyListNo(java.lang.String newRegShipToPartyListNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegShipToPartyListNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 227, _EJS_s, _jacc_parms);
			beanRef.setRegShipToPartyListNo(newRegShipToPartyListNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 227, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegShipToPartyName
	 */
	public void setRegShipToPartyName(java.lang.String newRegShipToPartyName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegShipToPartyName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 228, _EJS_s, _jacc_parms);
			beanRef.setRegShipToPartyName(newRegShipToPartyName);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 228, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegShipToPartyNo
	 */
	public void setRegShipToPartyNo(java.lang.String newRegShipToPartyNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRegShipToPartyNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 229, _EJS_s, _jacc_parms);
			beanRef.setRegShipToPartyNo(newRegShipToPartyNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 229, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setReportName
	 */
	public void setReportName(java.lang.String newReportName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newReportName;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 230, _EJS_s, _jacc_parms);
			beanRef.setReportName(newReportName);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 230, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSAndSIncluded
	 */
	public void setSAndSIncluded(java.lang.String newSAndSIncluded) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSAndSIncluded;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 231, _EJS_s, _jacc_parms);
			beanRef.setSAndSIncluded(newSAndSIncluded);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 231, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSalesGroup
	 */
	public void setSalesGroup(java.lang.String newSalesGroup) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSalesGroup;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 232, _EJS_s, _jacc_parms);
			beanRef.setSalesGroup(newSalesGroup);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 232, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSalesOrg
	 */
	public void setSalesOrg(java.lang.String newSalesOrg) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSalesOrg;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 233, _EJS_s, _jacc_parms);
			beanRef.setSalesOrg(newSalesOrg);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 233, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSandsAnniversaryAmt2
	 */
	public void setSandsAnniversaryAmt2(double newSandsAnniversaryAmt2) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSandsAnniversaryAmt2);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 234, _EJS_s, _jacc_parms);
			beanRef.setSandsAnniversaryAmt2(newSandsAnniversaryAmt2);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 234, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSandsAnniversaryAmt3
	 */
	public void setSandsAnniversaryAmt3(double newSandsAnniversaryAmt3) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSandsAnniversaryAmt3);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 235, _EJS_s, _jacc_parms);
			beanRef.setSandsAnniversaryAmt3(newSandsAnniversaryAmt3);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 235, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSandsAnniversaryAmt4
	 */
	public void setSandsAnniversaryAmt4(double newSandsAnniversaryAmt4) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSandsAnniversaryAmt4);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 236, _EJS_s, _jacc_parms);
			beanRef.setSandsAnniversaryAmt4(newSandsAnniversaryAmt4);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 236, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSandsAnniversaryAmt5
	 */
	public void setSandsAnniversaryAmt5(double newSandsAnniversaryAmt5) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSandsAnniversaryAmt5);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 237, _EJS_s, _jacc_parms);
			beanRef.setSandsAnniversaryAmt5(newSandsAnniversaryAmt5);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 237, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSandsDiscountAmount1
	 */
	public void setSandsDiscountAmount1(double newSandsDiscountAmount1) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSandsDiscountAmount1);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 238, _EJS_s, _jacc_parms);
			beanRef.setSandsDiscountAmount1(newSandsDiscountAmount1);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 238, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSandsDiscountAmount2
	 */
	public void setSandsDiscountAmount2(double newSandsDiscountAmount2) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSandsDiscountAmount2);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 239, _EJS_s, _jacc_parms);
			beanRef.setSandsDiscountAmount2(newSandsDiscountAmount2);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 239, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSandsDiscountAmount3
	 */
	public void setSandsDiscountAmount3(double newSandsDiscountAmount3) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSandsDiscountAmount3);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 240, _EJS_s, _jacc_parms);
			beanRef.setSandsDiscountAmount3(newSandsDiscountAmount3);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 240, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSandsDiscountAmount4
	 */
	public void setSandsDiscountAmount4(double newSandsDiscountAmount4) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSandsDiscountAmount4);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 241, _EJS_s, _jacc_parms);
			beanRef.setSandsDiscountAmount4(newSandsDiscountAmount4);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 241, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSandsDiscountAmount5
	 */
	public void setSandsDiscountAmount5(double newSandsDiscountAmount5) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSandsDiscountAmount5);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 242, _EJS_s, _jacc_parms);
			beanRef.setSandsDiscountAmount5(newSandsDiscountAmount5);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 242, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSandsExtendPeriod
	 */
	public void setSandsExtendPeriod(java.lang.String newSandsExtendPeriod) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSandsExtendPeriod;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 243, _EJS_s, _jacc_parms);
			beanRef.setSandsExtendPeriod(newSandsExtendPeriod);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 243, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSandsanniversaryamt
	 */
	public void setSandsanniversaryamt(double newSandsanniversaryamt) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSandsanniversaryamt);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 244, _EJS_s, _jacc_parms);
			beanRef.setSandsanniversaryamt(newSandsanniversaryamt);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 244, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSandsdiscountamount
	 */
	public void setSandsdiscountamount(double newSandsdiscountamount) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSandsdiscountamount);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 245, _EJS_s, _jacc_parms);
			beanRef.setSandsdiscountamount(newSandsdiscountamount);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 245, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSemiAnnivInvoiceAmount
	 */
	public void setSemiAnnivInvoiceAmount(double newSemiAnnivInvoiceAmount) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSemiAnnivInvoiceAmount);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 246, _EJS_s, _jacc_parms);
			beanRef.setSemiAnnivInvoiceAmount(newSemiAnnivInvoiceAmount);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 246, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSpecialRate
	 */
	public void setSpecialRate(double newSpecialRate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newSpecialRate);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 247, _EJS_s, _jacc_parms);
			beanRef.setSpecialRate(newSpecialRate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 247, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setStatusCode
	 */
	public void setStatusCode(java.lang.String newStatusCode) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newStatusCode;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 248, _EJS_s, _jacc_parms);
			beanRef.setStatusCode(newStatusCode);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 248, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSubmittedBy
	 */
	public void setSubmittedBy(java.lang.String newSubmittedBy) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSubmittedBy;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 249, _EJS_s, _jacc_parms);
			beanRef.setSubmittedBy(newSubmittedBy);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 249, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSubmitterRole
	 */
	public void setSubmitterRole(java.lang.String newSubmitterRole) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSubmitterRole;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 250, _EJS_s, _jacc_parms);
			beanRef.setSubmitterRole(newSubmitterRole);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 250, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSuppressInvoice
	 */
	public void setSuppressInvoice(java.lang.String newSuppressInvoice) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSuppressInvoice;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 251, _EJS_s, _jacc_parms);
			beanRef.setSuppressInvoice(newSuppressInvoice);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 251, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setTpContractNo
	 */
	public void setTpContractNo(java.lang.String newTpContractNo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newTpContractNo;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 252, _EJS_s, _jacc_parms);
			beanRef.setTpContractNo(newTpContractNo);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 252, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setTvmRate
	 */
	public void setTvmRate(double newTvmRate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Double(newTvmRate);
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 253, _EJS_s, _jacc_parms);
			beanRef.setTvmRate(newTvmRate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 253, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVarDate
	 */
	public void setVarDate(java.sql.Date newVarDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVarDate;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 254, _EJS_s, _jacc_parms);
			beanRef.setVarDate(newVarDate);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 254, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVarInd
	 */
	public void setVarInd(java.lang.String newVarInd) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVarInd;
			}
	com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalBean)container.preInvoke(this, 255, _EJS_s, _jacc_parms);
			beanRef.setVarInd(newVarInd);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 255, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

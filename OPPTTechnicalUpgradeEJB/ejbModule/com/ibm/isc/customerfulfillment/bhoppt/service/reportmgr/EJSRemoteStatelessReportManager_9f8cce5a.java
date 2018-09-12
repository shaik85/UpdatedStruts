package com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessReportManager_9f8cce5a
 */
public class EJSRemoteStatelessReportManager_9f8cce5a extends EJSWrapper implements ReportManager {
	/**
	 * EJSRemoteStatelessReportManager_9f8cce5a
	 */
	public EJSRemoteStatelessReportManager_9f8cce5a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * checkForDownload
	 */
	public boolean checkForDownload(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO proposal) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = proposal;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.checkForDownload(proposal);
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
	 * getCompareTPRpt
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CompareTPReportCustomDTO getCompareTPRpt(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CompareTPReportCustomDTO compareTPReportCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CompareTPReportCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = compareTPReportCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCompareTPRpt(compareTPReportCustomDTO);
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
	 * getContractAmdRpt
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractAmendmentReportCustomDTO getContractAmdRpt(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractAmendmentReportCustomDTO contractAmendmentReportCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractAmendmentReportCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = contractAmendmentReportCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContractAmdRpt(contractAmendmentReportCustomDTO);
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
	 * getContractAttachRpt
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractAttachmentReportCustomDTO getContractAttachRpt(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractAttachmentReportCustomDTO contractAttachmentReportCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractAttachmentReportCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = contractAttachmentReportCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContractAttachRpt(contractAttachmentReportCustomDTO);
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
	 * getContractPlanningRpt
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractPlanningReportCustomDTO getContractPlanningRpt(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractPlanningReportCustomDTO contractPlanningReportCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractPlanningReportCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = contractPlanningReportCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getContractPlanningRpt(contractPlanningReportCustomDTO);
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
	 * getDeletedSWORpt
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeletedSWOReportCustomDTO getDeletedSWORpt(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeletedSWOReportCustomDTO deletedSWOReportCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeletedSWOReportCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = deletedSWOReportCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDeletedSWORpt(deletedSWOReportCustomDTO);
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
	 * getdeletedUsersReport
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeletedUsersReportCustomDTO getdeletedUsersReport(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeletedUsersReportCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeletedUsersReportCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getdeletedUsersReport(customDTO);
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
	 * getInventoryListRpt
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryListReportCustomDTO getInventoryListRpt(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryListReportCustomDTO inventoryListReportCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryListReportCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = inventoryListReportCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getInventoryListRpt(inventoryListReportCustomDTO);
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
	 * getListEntitledRpt
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ListEntitledPricesReportCustomDTO getListEntitledRpt(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ListEntitledPricesReportCustomDTO listEntitledPricesReportCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ListEntitledPricesReportCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = listEntitledPricesReportCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getListEntitledRpt(listEntitledPricesReportCustomDTO);
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
	 * listProposals
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReportsCustomDTO listProposals(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReportsCustomDTO reportsCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReportsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = reportsCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listProposals(reportsCustomDTO);
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
	 * getReverificationReport
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReverificationReportCustomDTO getReverificationReport(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReverificationReportCustomDTO customDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReverificationReportCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getReverificationReport(customDTO);
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
	 * getSysplexRpt
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SysplexReportCustomDTO getSysplexRpt(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SysplexReportCustomDTO sysplexReportCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SysplexReportCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = sysplexReportCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSysplexRpt(sysplexReportCustomDTO);
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
	 * getVarianceAllRpt
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceRptCustomDTO getVarianceAllRpt(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceRptCustomDTO varianceRptCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceRptCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = varianceRptCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVarianceAllRpt(varianceRptCustomDTO);
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
	 * getVariancePriceRpt
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceRptCustomDTO getVariancePriceRpt(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceRptCustomDTO varianceRptCustomDTO) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceRptCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = varianceRptCustomDTO;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVariancePriceRpt(varianceRptCustomDTO);
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
	 * getAllBAModificationReports
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO getAllBAModificationReports(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportCustomDTO customDto) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDto;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAllBAModificationReports(customDto);
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
	 * getAllBAReports
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO getAllBAReports(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportCustomDTO customDto) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDto;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAllBAReports(customDto);
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
	/**
	 * getBAReportsbyFormNumbers
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO getBAReportsbyFormNumbers(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportCustomDTO customDto) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDto;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBAReportsbyFormNumbers(customDto);
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
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBAReportsbyModTypes
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO getBAReportsbyModTypes(com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportCustomDTO customDto) throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = customDto;
			}
	com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean beanRef = (com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getBAReportsbyModTypes(customDto);
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
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}

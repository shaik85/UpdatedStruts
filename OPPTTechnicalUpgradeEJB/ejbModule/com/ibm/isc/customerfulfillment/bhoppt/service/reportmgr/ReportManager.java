/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr;

import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractAttachmentReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CompareTPReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractPlanningReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReportsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractAmendmentReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceRptCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeletedSWOReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ListEntitledPricesReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryListReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SysplexReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReverificationReportCustomDTO;
/**
 * Remote interface for Enterprise Bean: ReportManager
 */
public interface ReportManager extends javax.ejb.EJBObject
{


	public ContractAttachmentReportCustomDTO getContractAttachRpt(ContractAttachmentReportCustomDTO contractAttachmentReportCustomDTO)
		throws ServiceException, java.rmi.RemoteException;

	public ContractPlanningReportCustomDTO getContractPlanningRpt(ContractPlanningReportCustomDTO contractPlanningReportCustomDTO)
		throws ServiceException, java.rmi.RemoteException;

	public ReportsCustomDTO listProposals(ReportsCustomDTO reportsCustomDTO)
		throws ServiceException, java.rmi.RemoteException;

	public ContractAmendmentReportCustomDTO getContractAmdRpt(ContractAmendmentReportCustomDTO contractAmendmentReportCustomDTO)
		throws ServiceException, java.rmi.RemoteException;

	public CompareTPReportCustomDTO getCompareTPRpt(CompareTPReportCustomDTO compareTPReportCustomDTO)
		throws ServiceException, java.rmi.RemoteException;

	public VarianceRptCustomDTO getVarianceAllRpt(VarianceRptCustomDTO varianceRptCustomDTO)
		throws ServiceException, java.rmi.RemoteException;

	public VarianceRptCustomDTO getVariancePriceRpt(VarianceRptCustomDTO varianceRptCustomDTO)
		throws ServiceException, java.rmi.RemoteException;

	public DeletedSWOReportCustomDTO getDeletedSWORpt(DeletedSWOReportCustomDTO deletedSWOReportCustomDTO)
		throws ServiceException, java.rmi.RemoteException;

	public ListEntitledPricesReportCustomDTO getListEntitledRpt(ListEntitledPricesReportCustomDTO listEntitledPricesReportCustomDTO)
		throws ServiceException, java.rmi.RemoteException;

	public InventoryListReportCustomDTO getInventoryListRpt(InventoryListReportCustomDTO inventoryListReportCustomDTO)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 *  Method to get the List Entitled  report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ListEntitledPricesReportCustomDTO
	 * @return ListEntitledPricesReportCustomDTO
	 *	  
	 */
	public SysplexReportCustomDTO getSysplexRpt(SysplexReportCustomDTO sysplexReportCustomDTO)
		throws ServiceException, java.rmi.RemoteException;
		
	public boolean checkForDownload(ProposalCustomDTO proposal) throws ServiceException, java.rmi.RemoteException;	
	
	public ReverificationReportCustomDTO getReverificationReport(ReverificationReportCustomDTO customDTO)
		throws ServiceException, java.rmi.RemoteException;
	
	public DeletedUsersReportCustomDTO getdeletedUsersReport(DeletedUsersReportCustomDTO customDTO)
	throws ServiceException, java.rmi.RemoteException;
	
	
	/**
	 *  method to get all baseagreement reports
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date oct 17, 2006 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ReportsCustomDTO
	 * @return ReportsCustomDTO
	 * @throws ServiceException	  
	 */
 public BaseAgreementReportsCustomDTO getAllBAReports(BaseAgreementReportCustomDTO customDto)throws ServiceException,java.rmi.RemoteException;

 
 /**
	 *  method to get all active/inactive baseagreement reports
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date oct 17, 2006 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ReportsCustomDTO
	 * @return ReportsCustomDTO
	 * @throws ServiceException	  
	 */
 public BaseAgreementReportsCustomDTO getAllBAModificationReports(BaseAgreementReportCustomDTO customDto)throws ServiceException,java.rmi.RemoteException;

 
 /**
	 *  method to get all active/inactive baseagreement reports
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date oct 17, 2006 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ReportsCustomDTO
	 * @return ReportsCustomDTO
	 * @throws ServiceException	  
	 */
 public BaseAgreementReportsCustomDTO getBAReportsbyFormNumbers(BaseAgreementReportCustomDTO customDto)throws ServiceException,java.rmi.RemoteException;
 	

 /**
	 *  method to get all active/inactive baseagreement reports
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date oct 17, 2006 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ReportsCustomDTO
	 * @return ReportsCustomDTO
	 * @throws ServiceException	  
	 */
public BaseAgreementReportsCustomDTO getBAReportsbyModTypes(BaseAgreementReportCustomDTO customDto)throws ServiceException,java.rmi.RemoteException;
}

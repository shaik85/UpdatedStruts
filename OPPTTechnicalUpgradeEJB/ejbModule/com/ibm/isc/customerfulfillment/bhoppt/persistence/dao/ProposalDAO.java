/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import javax.sql.DataSource;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/** 
 * This DAO is responsible for getting Proposal information for reports
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 3, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Kedar Harischandrakar
 * @version 5.1A 
 */
public class ProposalDAO extends OPPTDAO
{
//Changed to SAP Customer No for DAD002 changed by Anand Sugumaran
	private static final String CONTRACT_PLANNING_REPORT = "select proposal_name, Cntr_Start_period, Cntr_End_period, reg_bill_to_p_name, reg_payer_name, REG_BILL_TO_P_NO, REG_PAYER_NO, tvm_rate, special_rate, REPORT_NAME ,CNTR_NUMBER, INVOICE_AMOUNT_ANN,INVOICE_AMOUNT_SEM,INVOICE_AMOUNT_QRT,INVOICE_AMOUNT_MON,BILLING_FREQ_CODE,reg_bill_to_p_asno,reg_payer_asno,proposal_content from  BH.proposal where proposal_id=? with ur";
	private static final String CONTRACT_ATTACH_REPORT = "select proposal_name, Cntr_Start_period, Cntr_End_period, reg_bill_to_p_name, reg_payer_name, REG_BILL_TO_P_NO, REG_PAYER_NO, tvm_rate, special_rate, REPORT_NAME ,CNTR_NUMBER, INVOICE_AMOUNT_ANN,INVOICE_AMOUNT_SEM,INVOICE_AMOUNT_QRT,INVOICE_AMOUNT_MON,BILLING_FREQ_CODE,reg_bill_to_p_asno,reg_payer_asno,proposal_content from  BH.proposal where proposal_id=? with ur";
	private static final String CONTRACT_AMENDMENT_REPORT = "select proposal_name, Cntr_Start_period, Cntr_End_period, reg_bill_to_p_name, reg_payer_name, REG_BILL_TO_P_NO, REG_PAYER_NO, tvm_rate, special_rate, REPORT_NAME ,CNTR_NUMBER, INVOICE_AMOUNT_ANN,INVOICE_AMOUNT_SEM,INVOICE_AMOUNT_QRT,INVOICE_AMOUNT_MON,BILLING_FREQ_CODE,AMDT_EFFC_DATE,reg_bill_to_p_asno,reg_payer_asno,proposal_content from  BH.proposal where proposal_id=? with ur";
	private static final String SYSPLEX_REPORT = "select cntr_start_period,cntr_end_period,proposal_name,cntr_number from BH.proposal  where proposal_id=? with ur";
	private static final String DELETED_SWO_REPORT = "select cntr_start_period,cntr_end_period,reg_bill_to_p_name,reg_payer_name,REG_BILL_TO_P_NO,REG_PAYER_NO,proposal_name,tvm_rate,special_rate,report_name,cntr_number, reg_bill_to_p_asno, reg_payer_asno, proposal_content from BH.proposal where proposal_id=? with ur";
	private static final String INVENTORY_LIST_REPORT = "select cntr_start_period, cntr_end_period,reg_bill_to_p_name,reg_payer_name,REG_BILL_TO_P_NO,REG_PAYER_NO,proposal_name, tvm_rate,special_rate,report_name,cntr_number,invoice_amount_ann,invoice_amount_sem,invoice_amount_qrt,invoice_amount_mon, billing_freq_code, ext_cntr_number, currency,proposal_content from BH.proposal  where proposal_id=? with ur";
	private static final String LIST_ENTILED_REPORT = "select cntr_start_period, cntr_end_period,reg_bill_to_p_name,reg_payer_name,REG_BILL_TO_P_NO,REG_PAYER_NO,proposal_name, tvm_rate,special_rate,report_name,cntr_number,invoice_amount_ann,invoice_amount_sem,invoice_amount_qrt,invoice_amount_mon, billing_freq_code, ext_cntr_number, currency,proposal_content from BH.proposal  where proposal_id=? with ur";
	private static final String VARIANCE_ALL_REPORT = "select var_ind,cap_variance,created_by,sales_org,ext_cntr_number,var_date,cntr_start_period,cntr_end_period,cap_amount,reg_sold_to_p_no,reg_sold_to_p_asno,cum_value,cntr_period_var_no,status_code,currency,cntr_number from BH.proposal  where proposal_id=? with ur";
	private static final String VARIANCE_PRICE_REPORT = "select var_ind,cap_variance,created_by,sales_org,ext_cntr_number,var_date,cntr_start_period,cntr_end_period,cap_amount,reg_sold_to_p_no,reg_sold_to_p_asno,cum_value,cntr_period_var_no,status_code,currency,cntr_number from BH.proposal  where proposal_id=? with ur";
	private static final String VARIANCE_REPORT_SWO_PRICE = "select sum(esw_price) from BH.systemswo where proposal_id=?";
	/** 
	 * ProposalDAO Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Jan 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public ProposalDAO() 
	{	
	
	}

	/**
	 *  Method to get  proposal information for Contract Attachment report
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return ContractAttchRptDomainDTO
	 *	  
	 */
	public static ContractAttchRptDomainDTO retriveDataForContractAttchRpt(String proposalID)
	{
		ContractAttchRptDomainDTO contractAttchRptDomainDTO = new ContractAttchRptDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_ATTACH_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())			
			{				
				contractAttchRptDomainDTO.setProposalName(resultSet.getString("proposal_name"));		
				contractAttchRptDomainDTO.setContractStartDate(resultSet.getDate("cntr_start_period"));
				contractAttchRptDomainDTO.setContractEndDate(resultSet.getDate("cntr_end_period"));
				contractAttchRptDomainDTO.setTvmRate(resultSet.getDouble("tvm_rate"));
				contractAttchRptDomainDTO.setBillingFreq(resultSet.getString("billing_freq_code"));
				contractAttchRptDomainDTO.setContractNumber(resultSet.getString("cntr_number"));
				contractAttchRptDomainDTO.setPlannedGrowthRate(resultSet.getDouble("special_rate"));						
				contractAttchRptDomainDTO.setMonthlyInvoiceFreqAmt(resultSet.getDouble("invoice_amount_mon"));
				contractAttchRptDomainDTO.setQurtInvoiceFreqAmt(resultSet.getDouble("invoice_amount_qrt"));
				contractAttchRptDomainDTO.setSemiAnnualInvoiceFreqAmt(resultSet.getDouble("invoice_amount_sem"));
				contractAttchRptDomainDTO.setAnnualInvoiceFreqAmt(resultSet.getDouble("invoice_amount_ann"));
				contractAttchRptDomainDTO.setBillToPartyLegNo(resultSet.getString("REG_BILL_TO_P_NO"));  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				contractAttchRptDomainDTO.setBillToPartySeqNo(resultSet.getString("reg_bill_to_p_asno"));
				contractAttchRptDomainDTO.setBillToPartyName(resultSet.getString("reg_bill_to_p_name"));
				contractAttchRptDomainDTO.setPayerLegNo(resultSet.getString("REG_PAYER_NO")); // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				contractAttchRptDomainDTO.setPayerSeqNo(resultSet.getString("reg_payer_asno"));
				contractAttchRptDomainDTO.setPayerName(resultSet.getString("reg_payer_name"));
				contractAttchRptDomainDTO.setProposalContent(resultSet.getString("proposal_content"));																			
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ProposalDAO","retriveDataForContractAttchRpt",null,ex);
		}					
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);		
		}
		return contractAttchRptDomainDTO;
	}
	
	
	/**
	 *  Method to get  proposal Information for Contract Planning report
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return ContractPlanningRptDomainDTO
	 *	  
	 */
	public static ContractPlanningRptDomainDTO  retriveDataForContractPlnRpt(String proposalID)
	{
		ContractPlanningRptDomainDTO contractPlanningRptDomainDTO = new ContractPlanningRptDomainDTO();	
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_PLANNING_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				contractPlanningRptDomainDTO.setProposalName(resultSet.getString("proposal_name"));		
				contractPlanningRptDomainDTO.setContractStartDate(resultSet.getDate("cntr_start_period"));
				contractPlanningRptDomainDTO.setContractEndDate(resultSet.getDate("cntr_end_period"));
				contractPlanningRptDomainDTO.setTvmRate(resultSet.getDouble("tvm_rate"));
				contractPlanningRptDomainDTO.setBillingFreq(resultSet.getString("billing_freq_code"));
				contractPlanningRptDomainDTO.setContractNumber(resultSet.getString("cntr_number"));
				contractPlanningRptDomainDTO.setPlannedGrowthRate(resultSet.getDouble("special_rate"));
				contractPlanningRptDomainDTO.setPriceAsOf(resultSet.getDate("cntr_end_period"));			
				contractPlanningRptDomainDTO.setMonthlyInvoiceFreqAmt(resultSet.getDouble("invoice_amount_mon"));
				contractPlanningRptDomainDTO.setQurtInvoiceFreqAmt(resultSet.getDouble("invoice_amount_qrt"));
				contractPlanningRptDomainDTO.setSemiAnnualFreqAmt(resultSet.getDouble("invoice_amount_sem"));
				contractPlanningRptDomainDTO.setAnnualInvoiceFreqAmt(resultSet.getDouble("invoice_amount_ann"));
				contractPlanningRptDomainDTO.setBillToPartyLegNo(resultSet.getString("REG_BILL_TO_P_NO"));  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				contractPlanningRptDomainDTO.setBillToPartySeqNo(resultSet.getString("reg_bill_to_p_asno"));
				contractPlanningRptDomainDTO.setBillToPartyName(resultSet.getString("reg_bill_to_p_name"));
				contractPlanningRptDomainDTO.setPayerLegNo(resultSet.getString("REG_PAYER_NO"));  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				contractPlanningRptDomainDTO.setPayerSeqNo(resultSet.getString("reg_payer_asno"));
				contractPlanningRptDomainDTO.setPayerName(resultSet.getString("reg_payer_name"));	
				contractPlanningRptDomainDTO.setProposalContent(resultSet.getString("proposal_content"));	
				
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ProposalDAO","retriveDataForContractPlnRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);		
		}					
		return contractPlanningRptDomainDTO;
	}
	
	/**
	 *  Method to get  proposal information for Contract Amendment report
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return ContractAmendmentRptDomainDTO
	 *	  
	 */
	public static ContractAmendmentRptDomainDTO  retriveDataForContractAmdRpt(String proposalID)
	{
		ContractAmendmentRptDomainDTO contractAmendmentRptDomainDTO = new ContractAmendmentRptDomainDTO();	
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_AMENDMENT_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				contractAmendmentRptDomainDTO.setContractName(resultSet.getString("proposal_name"));		
				contractAmendmentRptDomainDTO.setContractStartDate(resultSet.getDate("cntr_start_period"));
				contractAmendmentRptDomainDTO.setContractEndDate(resultSet.getDate("cntr_end_period"));
				contractAmendmentRptDomainDTO.setTvmRate(resultSet.getDouble("tvm_rate"));				
				contractAmendmentRptDomainDTO.setContractNo(resultSet.getString("cntr_number"));
				contractAmendmentRptDomainDTO.setPlannedGrowthRate(resultSet.getDouble("special_rate"));
				contractAmendmentRptDomainDTO.setAmmendmentEffectiveDate(resultSet.getDate("amdt_effc_date"));
				contractAmendmentRptDomainDTO.setBillingFreq(resultSet.getString("BILLING_FREQ_CODE"));
				contractAmendmentRptDomainDTO.setBillToPartyLegNo(resultSet.getString("REG_BILL_TO_P_NO"));  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				contractAmendmentRptDomainDTO.setBillToPartySeqNo(resultSet.getString("reg_bill_to_p_asno"));
				contractAmendmentRptDomainDTO.setBillToPartyName(resultSet.getString("reg_bill_to_p_name"));
 				contractAmendmentRptDomainDTO.setPayerLegNo(resultSet.getString("REG_PAYER_NO"));   // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				contractAmendmentRptDomainDTO.setPayerSeqNo(resultSet.getString("reg_payer_asno"));
				contractAmendmentRptDomainDTO.setPayerName(resultSet.getString("reg_payer_name"));
				contractAmendmentRptDomainDTO.setProposalContent(resultSet.getString("proposal_content"));						
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ProposalDAO","retriveDataForContractAmdRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);		
		}					
		return contractAmendmentRptDomainDTO;
	}
	
	/**
	 *  Method to get proposal details for Sysplex report
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return SysplexRptDomainDTO
	 *	  
	 */
	public static SysplexRptDomainDTO  retriveDataForSysplexRpt(String proposalID)
	{		
		SysplexRptDomainDTO sysplexRptDomainDTO = new SysplexRptDomainDTO();	
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SYSPLEX_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				sysplexRptDomainDTO.setProposalName(resultSet.getString("proposal_name"));		
				sysplexRptDomainDTO.setContractStartDate(resultSet.getDate("cntr_start_period"));
				sysplexRptDomainDTO.setContractEndDate(resultSet.getDate("cntr_end_period"));								
				sysplexRptDomainDTO.setContractNo(resultSet.getString("cntr_number"));
				sysplexRptDomainDTO.setPriceAsOf(resultSet.getDate("cntr_end_period"));															
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ProposalDAO","retriveDataForSysplexRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);		
		}		
		return sysplexRptDomainDTO;
	}
	
	/**
	 *  Method to get proposal details for Deleted SWO report
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return DeletedSWORptDomainDTO
	 *	  
	 */
	public static DeletedSWORptDomainDTO  retriveDataForDelSWORpt(String proposalID)
	{
		DeletedSWORptDomainDTO deletedSWORptDomainDTO = new DeletedSWORptDomainDTO();	
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(DELETED_SWO_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{					
				deletedSWORptDomainDTO.setContractStartDate(resultSet.getDate("cntr_start_period"));
				deletedSWORptDomainDTO.setContractEndDate(resultSet.getDate("cntr_end_period"));								
				deletedSWORptDomainDTO.setContractNumer(resultSet.getString("cntr_number"));
				deletedSWORptDomainDTO.setPlannedGrowthRate(resultSet.getDouble("special_rate"));
				deletedSWORptDomainDTO.setTvmRate(resultSet.getDouble("tvm_rate"));
				deletedSWORptDomainDTO.setPricesAsOf(resultSet.getDate("cntr_end_period"));
				deletedSWORptDomainDTO.setBillToPartyLegNo(resultSet.getString("REG_BILL_TO_P_NO"));   // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				deletedSWORptDomainDTO.setBillToPartySeqNo(resultSet.getString("reg_bill_to_p_asno"));
				deletedSWORptDomainDTO.setBillToPartyName(resultSet.getString("reg_bill_to_p_name"));
				deletedSWORptDomainDTO.setPayerLegNo(resultSet.getString("REG_PAYER_NO"));  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				deletedSWORptDomainDTO.setPayerSeqNo(resultSet.getString("reg_payer_asno"));
				deletedSWORptDomainDTO.setPayerName(resultSet.getString("reg_payer_name"));
				deletedSWORptDomainDTO.setProposalContent(resultSet.getString("proposal_content"));																			
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ProposalDAO","retriveDataForDelSWORpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);		
		}					
		return deletedSWORptDomainDTO;
	}
	
	/**
	 *  Method to get proposal details for Inventory List report
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return InventoryListRptDomainDTO
	 *	  
	 */
	public static InventoryListRptDomainDTO  retriveDataForInventoryRpt(String proposalID)
	{
		InventoryListRptDomainDTO inventoryListRptDomainDTO = new InventoryListRptDomainDTO();	
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(INVENTORY_LIST_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{					
				inventoryListRptDomainDTO.setExternalContractNumber(resultSet.getString("ext_cntr_number"));			
				inventoryListRptDomainDTO.setCurrency(resultSet.getString("currency"));
				inventoryListRptDomainDTO.setProposalName(resultSet.getString("proposal_name"));
				inventoryListRptDomainDTO.setPriceAsOf(resultSet.getDate("cntr_end_period"));
				inventoryListRptDomainDTO.setContractStartDate(resultSet.getDate("cntr_start_period"));
				inventoryListRptDomainDTO.setContractEndDate(resultSet.getDate("cntr_end_period"));
				inventoryListRptDomainDTO.setContractNumber(resultSet.getString("cntr_number"));
				inventoryListRptDomainDTO.setProposalContent(resultSet.getString("proposal_content"));																	
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ProposalDAO","retriveDataForInventoryRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);		
		}					
		return inventoryListRptDomainDTO;
	}
	
	/**
	 *  Method to get proposal details for List Entitled report
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return ListEntitledPricesRptDomainDTO
	 *	  
	 */
	public static ListEntitledPricesRptDomainDTO  retriveDataForEERpt(String proposalID)
	{
		ListEntitledPricesRptDomainDTO listEntitledPricesRptDomainDTO = new ListEntitledPricesRptDomainDTO();	
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(LIST_ENTILED_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{	
				listEntitledPricesRptDomainDTO.setContractStartDate(resultSet.getDate("cntr_start_period"));
				listEntitledPricesRptDomainDTO.setContractEndDate(resultSet.getDate("cntr_end_period"));												
				listEntitledPricesRptDomainDTO.setExternalContractNumber(resultSet.getString("ext_cntr_number"));			
				listEntitledPricesRptDomainDTO.setCurrency(resultSet.getString("currency"));
				listEntitledPricesRptDomainDTO.setProposalName(resultSet.getString("proposal_name"));
				listEntitledPricesRptDomainDTO.setPricesAsOf(resultSet.getDate("cntr_end_period"));
				listEntitledPricesRptDomainDTO.setContractNumber(resultSet.getString("cntr_number"));
				listEntitledPricesRptDomainDTO.setProposalContent(resultSet.getString("proposal_content"));																			
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ProposalDAO","retriveDataForEERpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);		
		}					
		return listEntitledPricesRptDomainDTO;
	}
	
	/**
	 *  Method to get proposal details for Variance All report
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return VarianceRptDomainDTO
	 *	  
	 */
	public static VarianceRptDomainDTO  retriveDataForVarianceAllRpt(String proposalID)
	{
		VarianceRptDomainDTO varianceRptDomainDTO = new VarianceRptDomainDTO();	
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(VARIANCE_ALL_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{	
				varianceRptDomainDTO.setContractStartDate(resultSet.getDate("cntr_start_period"));
				varianceRptDomainDTO.setContractEndDate(resultSet.getDate("cntr_end_period"));												
				varianceRptDomainDTO.setExternalContractNo(resultSet.getString("ext_cntr_number"));			
				varianceRptDomainDTO.setCurrency(resultSet.getString("currency"));
				varianceRptDomainDTO.setVariancedate(resultSet.getDate("var_date"));
				varianceRptDomainDTO.setSoldToCustomer(resultSet.getString("reg_sold_to_p_no") + "  " + resultSet.getString("reg_sold_to_p_asno") ); //Changed to SAP Customer No for DAD002 changed by Anand Sugumaran
				varianceRptDomainDTO.setCapAmount(resultSet.getDouble("cap_amount"));
				varianceRptDomainDTO.setCapVariance(resultSet.getDouble("cap_variance"));
				varianceRptDomainDTO.setCumulativeInventory(resultSet.getDouble("cum_value"));
				varianceRptDomainDTO.setContractNo(resultSet.getString("cntr_number"));
				varianceRptDomainDTO.setCntrPeriodVarNo(resultSet.getInt("cntr_period_var_no"));
				varianceRptDomainDTO.setStatusCode(resultSet.getString("status_code"));
			}
			preparedStatement = connection.prepareStatement(VARIANCE_REPORT_SWO_PRICE);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				varianceRptDomainDTO.setInventoryAtStart(resultSet.getDouble("1"));
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ProposalDAO","retriveDataForVarianceAllRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);		
		}					
		return varianceRptDomainDTO;
	}
	
	/**
	 *  Method to get proposal details for Variance All report
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return VarianceRptDomainDTO
	 *	  
	 */
	public static VarianceRptDomainDTO  retriveDataForVariancePriceRpt(String proposalID)
	{
		VarianceRptDomainDTO varianceRptDomainDTO = new VarianceRptDomainDTO();	
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(VARIANCE_PRICE_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{	
				varianceRptDomainDTO.setContractStartDate(resultSet.getDate("cntr_start_period"));
				varianceRptDomainDTO.setContractEndDate(resultSet.getDate("cntr_end_period"));												
				varianceRptDomainDTO.setExternalContractNo(resultSet.getString("ext_cntr_number"));			
				varianceRptDomainDTO.setCurrency(resultSet.getString("currency"));
				varianceRptDomainDTO.setVariancedate(resultSet.getDate("var_date"));
				varianceRptDomainDTO.setSoldToCustomer(resultSet.getString("reg_sold_to_p_no") + "  " + resultSet.getString("reg_sold_to_p_asno") ); //Changed to SAP Customer No for DAD002 changed by Anand Sugumaran
				varianceRptDomainDTO.setCapAmount(resultSet.getDouble("cap_amount"));
				varianceRptDomainDTO.setCapVariance(resultSet.getDouble("cap_variance"));
				varianceRptDomainDTO.setCumulativeInventory(resultSet.getDouble("cum_value"));
				varianceRptDomainDTO.setContractNo(resultSet.getString("cntr_number"));
				varianceRptDomainDTO.setCntrPeriodVarNo(resultSet.getInt("cntr_period_var_no"));
				varianceRptDomainDTO.setStatusCode(resultSet.getString("status_code"));			
			}
			preparedStatement = connection.prepareStatement(VARIANCE_REPORT_SWO_PRICE);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				varianceRptDomainDTO.setInventoryAtStart(resultSet.getDouble("1"));
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ProposalDAO","retriveDataForVariancePriceRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);				
		}					
		return varianceRptDomainDTO;
	}
	
	
}

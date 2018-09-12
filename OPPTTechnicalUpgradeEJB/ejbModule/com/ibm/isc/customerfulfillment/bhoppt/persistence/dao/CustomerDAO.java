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
import javax.sql.DataSource;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/** 
 * This DAO is responsible for getting Customer information for reports  
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
public class CustomerDAO  extends OPPTDAO
{
	//Changed  Legacy No to SAP Customer No for DAD002 changed by Anand Sugumaran
	
	private static final String CONTRACT_PLANNING_REPORT = "select sold_to_party_id, sap_sold_to_p_name, SAP_SOLD_TO_P_NO, sold_to_p_asno, bill_to_p_name, bill_to_p_lno, bill_to_p_asno, payer_name, payer_lno, payer_asno from BH.soldtoparty where proposal_id=? order by SAP_SOLD_TO_P_NO with ur";
	private static final String CONTRACT_ATTACH_DRAFT_REPORT = "select sold_to_party_id, sap_sold_to_p_name, SAP_SOLD_TO_P_NO, sold_to_p_asno, bill_to_p_name, bill_to_p_lno, bill_to_p_asno, payer_name, payer_lno, payer_asno from BH.soldtoparty where proposal_id=? order by SAP_SOLD_TO_P_NO with ur";
	private static final String CONTRACT_ATTACH_FINAL_REPORT = "select sold_to_party_id, sap_sold_to_p_name,sap_sold_to_p_no, sold_to_p_asno, bill_to_p_name, bill_to_p_lno, bill_to_p_asno, payer_name, payer_lno, payer_asno from BH.soldtoparty where proposal_id=? order by sap_sold_to_p_no with ur";
	private static final String CONTRACT_AMENDMENT_REPORT = "select sold_to_party_id, sap_sold_to_p_name, sap_sold_to_p_no, sold_to_p_asno, bill_to_p_name, bill_to_p_lno, bill_to_p_asno, payer_name, payer_lno, payer_asno from BH.soldtoparty where proposal_id=? order by sap_sold_to_p_no with ur";
	private static final String DELETED_SWO_REPORT = "select sold_to_party_id,sap_sold_to_p_no,bill_to_p_lno ,payer_lno, plan_start_date,plan_end_date,sap_sold_to_p_name,bill_to_p_name,payer_name, sold_to_p_asno,bill_to_p_asno,payer_asno from BH.hissoldtoparty where proposal_id=? order by sap_sold_to_p_no with ur";
	private static final String INVENTORY_LIST_REPORT = "select sap_sold_to_p_no,sold_to_party_id,sold_to_p_asno from BH.soldtoparty where proposal_id=? order by sap_sold_to_p_no with ur";
	private static final String LIST_ENTILED_REPORT = "select sap_sold_to_p_no,sold_to_party_id,sold_to_p_asno from BH.soldtoparty where proposal_id=? order by sap_sold_to_p_no with ur";
	private static final String VARIANCE_ALL_REPORT = "select sap_sold_to_p_no, sold_to_party_id  from BH.soldtoparty where proposal_id=? order by sap_sold_to_p_no with ur";
	private static final String VARIANCE_PRICE_REPORT = "select sap_sold_to_p_no, sold_to_party_id  from BH.soldtoparty where proposal_id=? order by sap_sold_to_p_no with ur";
		
	/** 
	 * CustomerDAO Constructor	  
	 * 
	 * <br/><PRE> 
	 * date Jan 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public CustomerDAO() 
	{	
	
	}

	/**
	 *  Method to get  Customers for  Contract Attachment Final Report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForContractAttchFinalRpt(String proposalID)
	{
		ContractAttchRptCustomerDomainDTO contractAttchRptCustomerDomainDTO = new ContractAttchRptCustomerDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		List contractAttchRptCustomerDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_ATTACH_FINAL_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				contractAttchRptCustomerDomainDTO = new ContractAttchRptCustomerDomainDTO();					
				contractAttchRptCustomerDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));									
				contractAttchRptCustomerDomainDTO.setPayerName(resultSet.getString("payer_name"));
				contractAttchRptCustomerDomainDTO.setPayerLegNo(resultSet.getString("payer_lno"));
				contractAttchRptCustomerDomainDTO.setPayerASNO(resultSet.getString("payer_asno"));
					
				contractAttchRptCustomerDomainDTO.setBillToPartyName(resultSet.getString("bill_to_p_name"));
				contractAttchRptCustomerDomainDTO.setBillToPartyLegNo(resultSet.getString("bill_to_p_lno"));
				contractAttchRptCustomerDomainDTO.setBillToPartyASNO(resultSet.getString("bill_to_p_asno"));
					
				contractAttchRptCustomerDomainDTO.setSoldToPartyName(resultSet.getString("sap_sold_to_p_name"));
				contractAttchRptCustomerDomainDTO.setSoldToPartyLegNo(resultSet.getString("SAP_SOLD_TO_P_NO")); // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				contractAttchRptCustomerDomainDTO.setSoldToPartyASNO(resultSet.getString("sold_to_p_asno"));
				contractAttchRptCustomerDomainDTOList.add(contractAttchRptCustomerDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"CustomerDAO","retriveDataForContractAttchDraftRpt",null,ex);
		}	
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}
		return contractAttchRptCustomerDomainDTOList;
	}
	
	/**
	 *  Method to get  Customers for Contract Attachment Draft Report 
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForContractAttchDraftRpt(String proposalID)
	{
		ContractAttchRptCustomerDomainDTO contractAttchRptCustomerDomainDTO = new ContractAttchRptCustomerDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		List contractAttchRptCustomerDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_ATTACH_DRAFT_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				contractAttchRptCustomerDomainDTO = new ContractAttchRptCustomerDomainDTO();		
				contractAttchRptCustomerDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));
								
				contractAttchRptCustomerDomainDTO.setPayerName(resultSet.getString("payer_name"));
				contractAttchRptCustomerDomainDTO.setPayerLegNo(resultSet.getString("payer_lno"));
				contractAttchRptCustomerDomainDTO.setPayerASNO(resultSet.getString("payer_asno"));
				
				contractAttchRptCustomerDomainDTO.setBillToPartyName(resultSet.getString("bill_to_p_name"));
				contractAttchRptCustomerDomainDTO.setBillToPartyLegNo(resultSet.getString("bill_to_p_lno"));
				contractAttchRptCustomerDomainDTO.setBillToPartyASNO(resultSet.getString("bill_to_p_asno"));
				
				contractAttchRptCustomerDomainDTO.setSoldToPartyName(resultSet.getString("sap_sold_to_p_name"));
				contractAttchRptCustomerDomainDTO.setSoldToPartyLegNo(resultSet.getString("SAP_SOLD_TO_P_NO"));  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				contractAttchRptCustomerDomainDTO.setSoldToPartyASNO(resultSet.getString("sold_to_p_asno"));
				contractAttchRptCustomerDomainDTOList.add(contractAttchRptCustomerDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"CustomerDAO","retriveDataForContractAttchDraftRpt",null,ex);
		}	
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);
		}			
		return contractAttchRptCustomerDomainDTOList;
	}
	
	/**
	 *  Method to get  Customers for  Contract Planning report
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
	 * @return List
	 *	  
	 */
	public static List  retriveDataForContractPlnRpt(String proposalID)
	{
		ContractPlanningRptCustomerDomainDTO contractPlanningRptCustomerDomainDTO;
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		List contractPlanningRptCustomerDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_PLANNING_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				contractPlanningRptCustomerDomainDTO = new ContractPlanningRptCustomerDomainDTO();			
				
				contractPlanningRptCustomerDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));								
				contractPlanningRptCustomerDomainDTO.setPayerName(resultSet.getString("payer_name"));
				contractPlanningRptCustomerDomainDTO.setPayerLegNo(resultSet.getString("payer_lno"));
				contractPlanningRptCustomerDomainDTO.setPayerASNO(resultSet.getString("payer_asno"));
				
				contractPlanningRptCustomerDomainDTO.setBillToPartyName(resultSet.getString("bill_to_p_name"));
				contractPlanningRptCustomerDomainDTO.setBillToPartyLegNo(resultSet.getString("bill_to_p_lno"));
				contractPlanningRptCustomerDomainDTO.setBillToPartyASNO(resultSet.getString("bill_to_p_asno"));
				
				contractPlanningRptCustomerDomainDTO.setSoldToPartyName(resultSet.getString("sap_sold_to_p_name"));
				contractPlanningRptCustomerDomainDTO.setSoldToPartyLegNo(resultSet.getString("SAP_SOLD_TO_P_NO"));  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				contractPlanningRptCustomerDomainDTO.setSoldToPartyASNO(resultSet.getString("sold_to_p_asno"));
				contractPlanningRptCustomerDomainDTOList.add(contractPlanningRptCustomerDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"CustomerDAO","retriveDataForContractPlnRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);
		}				
		return contractPlanningRptCustomerDomainDTOList;
	}
	
	/**
	 *  Method to get Customers for  Contract Amendment Report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForContractAmdRpt(String proposalID)
	{
		ContractAmendmentRptCustomerDomainDTO contractAmendmentRptCustomerDomainDTO;
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		List contractAmendmentRptCustomerDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_AMENDMENT_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				contractAmendmentRptCustomerDomainDTO = new ContractAmendmentRptCustomerDomainDTO();			
				
				contractAmendmentRptCustomerDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));								
				contractAmendmentRptCustomerDomainDTO.setPayerName(resultSet.getString("payer_name"));
				contractAmendmentRptCustomerDomainDTO.setPayerLegNo(resultSet.getString("payer_lno"));
				contractAmendmentRptCustomerDomainDTO.setPayerAsNO(resultSet.getString("payer_asno"));
				
				contractAmendmentRptCustomerDomainDTO.setBillToPartyName(resultSet.getString("bill_to_p_name"));
				contractAmendmentRptCustomerDomainDTO.setBillToPartyLegNo(resultSet.getString("bill_to_p_lno"));
				contractAmendmentRptCustomerDomainDTO.setBillToPartyAsNo(resultSet.getString("bill_to_p_asno"));
				
				contractAmendmentRptCustomerDomainDTO.setSoldToPartyName(resultSet.getString("sap_sold_to_p_name"));
				contractAmendmentRptCustomerDomainDTO.setSoldToPartyLegNo(resultSet.getString("SAP_SOLD_TO_P_NO"));  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				contractAmendmentRptCustomerDomainDTO.setSoldToPartyAsNo(resultSet.getString("sold_to_p_asno"));
				contractAmendmentRptCustomerDomainDTOList.add(contractAmendmentRptCustomerDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"CustomerDAO","retriveDataForContractAmdRpt",null,ex);
		}	
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);
		}			
		return contractAmendmentRptCustomerDomainDTOList;
	}
	
	/**
	 *  Method to get Customers for Sysplex report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForSysplexRpt(String proposalID)
	{
		SysplexRptCustomerDomainDTO sysplexRptCustomerDomainDTO;
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		List sysplexRptCustomerDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_AMENDMENT_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				sysplexRptCustomerDomainDTO = new SysplexRptCustomerDomainDTO();				
				sysplexRptCustomerDomainDTOList.add(sysplexRptCustomerDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"CustomerDAO","retriveDataForSysplexRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);
		}				
		return sysplexRptCustomerDomainDTOList;
	}
	
	/**
	 *  Method to get  Customer for Deleted SWO Report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForDelSWORpt(String proposalID)
	{
		DeletedSWORptCustomerDomainDTO deletedSWORptCustomerDomainDTO;
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		List deletedSWORptCustomerDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(DELETED_SWO_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				deletedSWORptCustomerDomainDTO = new DeletedSWORptCustomerDomainDTO();			
				
				deletedSWORptCustomerDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));								
				deletedSWORptCustomerDomainDTO.setPayerName(resultSet.getString("payer_name"));
				deletedSWORptCustomerDomainDTO.setPayerLegNo(resultSet.getString("payer_lno"));
				deletedSWORptCustomerDomainDTO.setPayerAsNo(resultSet.getString("payer_asno"));
				
				deletedSWORptCustomerDomainDTO.setBillToPartyName(resultSet.getString("bill_to_p_name"));
				deletedSWORptCustomerDomainDTO.setBillToPartyLegNo(resultSet.getString("bill_to_p_lno"));
				deletedSWORptCustomerDomainDTO.setBillToPartyAsNo(resultSet.getString("bill_to_p_asno"));
				
				deletedSWORptCustomerDomainDTO.setSoldToPartyName(resultSet.getString("sap_sold_to_p_name"));
				deletedSWORptCustomerDomainDTO.setSoldToPartyLegNo(resultSet.getString("SAP_SOLD_TO_P_NO"));  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				deletedSWORptCustomerDomainDTO.setSoldToPartyAsNo(resultSet.getString("sold_to_p_asno"));
				deletedSWORptCustomerDomainDTOList.add(deletedSWORptCustomerDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"CustomerDAO","retriveDataForDelSWORpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);
		}				
		return deletedSWORptCustomerDomainDTOList;
	}
	
	/**
	 *  Method to get  Customer for Inventory List Report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForInventoryRpt(String proposalID)
	{		
		InventoryListRptCustomerDomainDTO inventoryListRptCustomerDomainDTO;
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		List inventoryListRptCustomerDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(INVENTORY_LIST_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				inventoryListRptCustomerDomainDTO = new InventoryListRptCustomerDomainDTO();			
				inventoryListRptCustomerDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));			
				inventoryListRptCustomerDomainDTO.setLegNo(resultSet.getString("SAP_SOLD_TO_P_NO"));  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				inventoryListRptCustomerDomainDTO.setASNO(resultSet.getString("sold_to_p_asno"));
				inventoryListRptCustomerDomainDTOList.add(inventoryListRptCustomerDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"CustomerDAO","retriveDataForInventoryRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);
		}
					
		return inventoryListRptCustomerDomainDTOList;
	}
	
	/**
	 *  Method to get  Customer for List Entitled Report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForEERpt(String proposalID)
	{
		ListEntitledPricesRptCustomerDomainDTO listEntitledPricesRptCustomerDomainDTO;
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		List listEntitledPricesRptCustomerDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(LIST_ENTILED_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				listEntitledPricesRptCustomerDomainDTO = new ListEntitledPricesRptCustomerDomainDTO();				
				listEntitledPricesRptCustomerDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));			
				listEntitledPricesRptCustomerDomainDTO.setLegNo(resultSet.getString("SAP_SOLD_TO_P_NO"));  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				listEntitledPricesRptCustomerDomainDTO.setAsNo(resultSet.getString("sold_to_p_asno"));
				listEntitledPricesRptCustomerDomainDTOList.add(listEntitledPricesRptCustomerDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"CustomerDAO","retriveDataForEERpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);
		}				
		return listEntitledPricesRptCustomerDomainDTOList;
	}
	
	/**
	 *  Method to get  Customer for Variance All Report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForVarianceAllRp(String proposalID)
	{
		VarianceRptCustomerDomainDTO varianceRptCustomerDomainDTO;
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		List varianceRptCustomerDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(VARIANCE_ALL_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				varianceRptCustomerDomainDTO = new VarianceRptCustomerDomainDTO();
				
				varianceRptCustomerDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));			
				varianceRptCustomerDomainDTO.setCustomerNo(resultSet.getString("sap_sold_to_p_no"));
				varianceRptCustomerDomainDTOList.add(varianceRptCustomerDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"CustomerDAO","retriveDataForVarianceAllRp",null,ex);
		}	
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);
		}			
		return varianceRptCustomerDomainDTOList;
	}
	
	/**
	 *  Method to get  Customer for Variance Price Report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForVariancePriceRpt(String proposalID)
	{
		VarianceRptCustomerDomainDTO varianceRptCustomerDomainDTO;
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		List varianceRptCustomerDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(VARIANCE_PRICE_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				varianceRptCustomerDomainDTO = new VarianceRptCustomerDomainDTO();	
				
				varianceRptCustomerDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));			
				varianceRptCustomerDomainDTO.setCustomerNo(resultSet.getString("sap_sold_to_p_no"));
				varianceRptCustomerDomainDTOList.add(varianceRptCustomerDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"CustomerDAO","retriveDataForVariancePriceRpt",null,ex);
		}	
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);
		}			
		return varianceRptCustomerDomainDTOList;
	}
}

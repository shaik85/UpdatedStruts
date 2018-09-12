/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 *	This DAO is responsible for getting SWOEE information for reports 
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
public class SWOEEDAO extends OPPTDAO
{
	
	private static final String CONTRACT_PLANNING_REPORT = "select value_metric,use_level,EE_NO,EE_DESC,ESW_PRICE, ALT_PRICE, CALC_PRICE from BH.systemSWOEE where proposal_id=? and SOLD_TO_PARTY_ID =? and DESG_MACHINE_ID=? and swo_id=? with ur";
	private static final String CONTRACT_ATTACH_REPORT_FINAL = "select value_metric,use_level,EE_NO,EE_DESC,ESW_PRICE, ALT_PRICE, CALC_PRICE from BH.systemSWOEE where proposal_id=? and SOLD_TO_PARTY_ID =? and DESG_MACHINE_ID=? and swo_id=? with ur";
	private static final String CONTRACT_ATTACH_REPORT_DRAFT =  "select value_metric,use_level,EE_NO,EE_DESC,ESW_PRICE, ALT_PRICE, CALC_PRICE from BH.systemSWOEE where proposal_id=? and SOLD_TO_PARTY_ID =? and DESG_MACHINE_ID=? and swo_id=? with ur";
	private static final String CONTRACT_AMENDMENT_REPORT =  "select value_metric,use_level,EE_NO,EE_DESC,ESW_PRICE, ALT_PRICE, CALC_PRICE from BH.systemSWOEE where proposal_id=? and SOLD_TO_PARTY_ID =? and DESG_MACHINE_ID=? and swo_id=? with ur";
	private static final String DELETED_SWO_REPORT = "select value_metric,use_level,ee_no,esw_price,alt_price,calc_price from BH.hissystemswoee where proposal_id=? and sold_to_party_id=? and desg_machine_id=? and swo_id=? with ur";
	private static final String INVENTORY_LIST_REPORT = "select ee_no,value_metric,use_level,ee_desc,list_price,alt_price, plet_no from BH.systemswoee where proposal_id=? and sold_to_party_id =? and desg_machine_id=? and swo_id=? with ur";
	private static final String LIST_ENTILED_REPORT = "select ee_no,value_metric,use_level,ee_desc,list_price,alt_price,esw_price  from BH.systemswoee where proposal_id=? and sold_to_party_id =? and desg_machine_id=? and swo_id=? with ur";
	private static final String VARIANCE_ALL_REPORT = "select ee_no, ee_desc, swoee_id,esw_price  from BH.tempvarsystemswoee where proposal_id=? and 	sold_to_party_id=? and desg_machine_id=? and swo_id =? with ur";
	private static final String VARIANCE_PRICE_REPORT = "select ee_no, ee_desc, swoee_id,esw_price  from BH.tempvarsystemswoee where proposal_id=? and 	sold_to_party_id=? and desg_machine_id=? and swo_id =? with ur";	
	private static final String SYSPLEX_REPORT = "Select distinct e.ee_no,e.calc_price,s.swo_no,s.serial_no,s.ref_serial_no,d.desg_machine_no,e.ee_desc from BH.systemswoee e,BH.systemswo s,BH.custdesgmachine d where s.proposal_id= ? and e.swo_id=s.swo_id and s.desg_machine_id=d.desg_machine_id and e.ee_no = ? and (s.serial_no = ? or s.ref_serial_no = ?) order by 6 with ur";
	/** 
	 * SWOEEDAO Constructor	 
	 * 
	 * <br/><PRE> 
	 * date Jan 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public SWOEEDAO() 
	{	
	
	}	
	/**
	 *  Method to get  SWOEE information for Contract Attachment Final Report
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
	 * @param soldToParty
	 * @param dmID
	 * @param swoID
	 * @return List
	 *	  
	 */
	public static List retriveDataForContractAttchFinalRpt(String proposalID,String soldToParty,String dmID,String swoID)
	{
		ContractAttchRptSWOEEDomainDTO contractAttchRptSWOEEDomainDTO = new ContractAttchRptSWOEEDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		List contractAttchRptSWOEEDomainDTODTOList = new ArrayList();		
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_ATTACH_REPORT_FINAL);
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			preparedStatement.setInt(3,Integer.parseInt(dmID));
			preparedStatement.setInt(4,Integer.parseInt(swoID));
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{	
				contractAttchRptSWOEEDomainDTO = new ContractAttchRptSWOEEDomainDTO();
											
				contractAttchRptSWOEEDomainDTO.setValueMetricDesc(resultSet.getString("value_metric"));
				contractAttchRptSWOEEDomainDTO.setUseLevel(resultSet.getString("use_level"));
					
				contractAttchRptSWOEEDomainDTODTOList.add(contractAttchRptSWOEEDomainDTO);
								
			}
		}
		catch(SQLException ex)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"SWOEEDAO","retriveDataForContractAttchFinalRpt",null,ex);			
		}	
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);
		}
		return contractAttchRptSWOEEDomainDTODTOList;
	}
	
	/**
	 *  Method to get SWOEE information for Contract Attachment Draft Report 
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
	 * @param soldToParty
	 * @param dmID
	 * @param swoID
	 * @return List	  
	 */
	public static List retriveDataForContractAttchDraftRpt(String proposalID,String soldToParty,String dmID,String swoID)
	{
		ContractAttchRptSWOEEDomainDTO contractAttchRptSWOEEDomainDTO = new ContractAttchRptSWOEEDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		List contractAttchRptSWOEEDomainDTODTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_ATTACH_REPORT_DRAFT);
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			preparedStatement.setInt(3,Integer.parseInt(dmID));
			preparedStatement.setInt(4,Integer.parseInt(swoID));
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{	
				contractAttchRptSWOEEDomainDTO = new ContractAttchRptSWOEEDomainDTO();
											
				contractAttchRptSWOEEDomainDTO.setValueMetricDesc(resultSet.getString("value_metric"));
				contractAttchRptSWOEEDomainDTO.setUseLevel(resultSet.getString("use_level"));
				contractAttchRptSWOEEDomainDTODTOList.add(contractAttchRptSWOEEDomainDTO);								
			}
		}
		catch(SQLException ex)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"SWOEEDAO","retriveDataForContractAttchDraftRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);		
		}	
		return contractAttchRptSWOEEDomainDTODTOList;
	}
	
	/**
	 *  Method to get  SWOEE information for Contract Planning Report
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
	 * @param soldToParty
	 * @param dmID
	 * @param swoID
	 * @return List	  
	 *	  
	 */
	public static List  retriveDataForContractPlnRpt(String proposalID,String soldToParty,String dmID,String swoID)
	{
		ContractPlanningRptSWOEEDomainDTO contractPlanningRptSWOEEDomainDTO = new ContractPlanningRptSWOEEDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		List contractPlanningRptSWOEEDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_PLANNING_REPORT);
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			preparedStatement.setInt(3,Integer.parseInt(dmID));
			preparedStatement.setInt(4,Integer.parseInt(swoID));
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{	
				contractPlanningRptSWOEEDomainDTO = new ContractPlanningRptSWOEEDomainDTO();
											
				contractPlanningRptSWOEEDomainDTO.setValueMetricDescription(resultSet.getString("value_metric"));
				contractPlanningRptSWOEEDomainDTO.setUseLevel(resultSet.getString("use_level"));
				contractPlanningRptSWOEEDomainDTO.setEENo(resultSet.getString("ee_no"));				
				contractPlanningRptSWOEEDomainDTO.setESWPrice(resultSet.getDouble("esw_price"));
				contractPlanningRptSWOEEDomainDTO.setAlternatePrice(resultSet.getDouble("alt_price"));
				contractPlanningRptSWOEEDomainDTO.setCalculatedPrice(resultSet.getDouble("calc_price"));								
				contractPlanningRptSWOEEDomainDTOList.add(contractPlanningRptSWOEEDomainDTO);								
			}
		}
		catch(SQLException ex)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"SWOEEDAO","retriveDataForContractPlnRpt",null,ex);			
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}					
		return contractPlanningRptSWOEEDomainDTOList;
	}

	/**
	 *  Method to get SWOEE information for Contract Amendment Report  
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
	 * @param soldToParty
	 * @param dmID
	 * @param swoID
	 * @return List	  
	 */
	public static List  retriveDataForContractAmdRpt(String proposalID,String soldToParty,String dmID,String swoID)
	{
		ContractAmendmentRptSWOEEDomainDTO contractAmendmentRptSWOEEDomainDTO = new ContractAmendmentRptSWOEEDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		List contractAmendmentRptSWOEEDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_AMENDMENT_REPORT);
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			preparedStatement.setInt(3,Integer.parseInt(dmID));
			preparedStatement.setInt(4,Integer.parseInt(swoID));
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{	
				contractAmendmentRptSWOEEDomainDTO = new ContractAmendmentRptSWOEEDomainDTO();											
				contractAmendmentRptSWOEEDomainDTO.setValueMetricDescription(resultSet.getString("value_metric"));
				contractAmendmentRptSWOEEDomainDTO.setUseLevel(resultSet.getString("use_level"));
		
				contractAmendmentRptSWOEEDomainDTOList.add(contractAmendmentRptSWOEEDomainDTO);								
			}
		}
		catch(SQLException ex)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"SWOEEDAO","retriveDataForContractAmdRpt",null,ex);			
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}					
		return contractAmendmentRptSWOEEDomainDTOList;
	}
	
	/**
	 *  Method to get  SWOEE's for Deleted SWO report
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
	 * @param soldToParty
	 * @param dmID
	 * @param swoID
	 * @return List
	 *	  
	 */
	public static List  retriveDataForDelSWORpt(String proposalID,String soldToParty,String dmID,String swoID)
	{
		DeletedSWORptSWOEEDomainDTO deletedSWORptSWOEEDomainDTO = new DeletedSWORptSWOEEDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		List deletedSWORptSWOEEDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(DELETED_SWO_REPORT);
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			preparedStatement.setInt(3,Integer.parseInt(dmID));
			preparedStatement.setInt(4,Integer.parseInt(swoID));
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{	
				deletedSWORptSWOEEDomainDTO = new DeletedSWORptSWOEEDomainDTO();
											
				deletedSWORptSWOEEDomainDTO.setValueMetricDesc(resultSet.getString("value_metric"));
				deletedSWORptSWOEEDomainDTO.setUseLevel(resultSet.getString("use_level"));
				deletedSWORptSWOEEDomainDTO.setEENo(resultSet.getString("ee_no"));
				deletedSWORptSWOEEDomainDTO.setEswPrice(resultSet.getDouble("esw_price"));
				deletedSWORptSWOEEDomainDTO.setAlternatePrice(resultSet.getDouble("alt_price"));				
				deletedSWORptSWOEEDomainDTO.setCalculatedPrice(resultSet.getDouble("calc_price"));
							
				deletedSWORptSWOEEDomainDTOList.add(deletedSWORptSWOEEDomainDTO);
								
			}
		}
		catch(SQLException ex)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"SWOEEDAO","retriveDataForDelSWORpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}					
		return deletedSWORptSWOEEDomainDTOList;
	}
	
	/**
	 *  Method to get  SWOEE's for Inventory List report
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
	 * @param soldToParty
	 * @param dmID
	 * @param swoID
	 * @return List	  
	 */
	public static List  retriveDataForInventoryRpt(String proposalID,String soldToParty,String dmID,String swoID)
	{
		InventoryListRptSWOEEDomainDTO inventoryListRptSWOEEDomainDTO = new InventoryListRptSWOEEDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		List inventoryListRptSWOEEDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(INVENTORY_LIST_REPORT);
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			preparedStatement.setInt(3,Integer.parseInt(dmID));
			preparedStatement.setInt(4,Integer.parseInt(swoID));
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{	
				inventoryListRptSWOEEDomainDTO = new InventoryListRptSWOEEDomainDTO();
											
				inventoryListRptSWOEEDomainDTO.setValueMetricDescription(resultSet.getString("value_metric"));
				inventoryListRptSWOEEDomainDTO.setUseLevel(resultSet.getString("use_level"));
				inventoryListRptSWOEEDomainDTO.setEENo(resultSet.getString("ee_no"));
				inventoryListRptSWOEEDomainDTO.setDescription(resultSet.getString("ee_desc"));				
				inventoryListRptSWOEEDomainDTO.setAlternatePrice(resultSet.getDouble("alt_price"));				
				inventoryListRptSWOEEDomainDTO.setListPrice(resultSet.getDouble("list_price"));
				inventoryListRptSWOEEDomainDTO.setPletNo(resultSet.getString("plet_no"));
								
				inventoryListRptSWOEEDomainDTOList.add(inventoryListRptSWOEEDomainDTO);								
			}
		}
		catch(SQLException ex)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"SWOEEDAO","retriveDataForInventoryRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);					
		}					
		return inventoryListRptSWOEEDomainDTOList;
	}
	
	/**
	 *  Method to get  SWOEE's for List Entitled report
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
	 * @param soldToParty
	 * @param dmID
	 * @param swoID
	 * @return List
	 *	  
	 */
	public static List  retriveDataForEERpt(String proposalID,String soldToParty,String dmID,String swoID)
	{
		ListEntitledPricesRptSWOEEDomainDTO listEntitledPricesRptSWOEEDomainDTO = new ListEntitledPricesRptSWOEEDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		List listEntitledPricesRptSWOEEDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(LIST_ENTILED_REPORT);
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			preparedStatement.setInt(3,Integer.parseInt(dmID));
			preparedStatement.setInt(4,Integer.parseInt(swoID));
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{	
				listEntitledPricesRptSWOEEDomainDTO = new ListEntitledPricesRptSWOEEDomainDTO();
											
				listEntitledPricesRptSWOEEDomainDTO.setValueMetric(resultSet.getString("value_metric"));
				listEntitledPricesRptSWOEEDomainDTO.setUseLevel(resultSet.getString("use_level"));
				listEntitledPricesRptSWOEEDomainDTO.setEENo(resultSet.getString("ee_no"));
				listEntitledPricesRptSWOEEDomainDTO.setDescription(resultSet.getString("ee_desc"));				
				listEntitledPricesRptSWOEEDomainDTO.setAlternatePrice(resultSet.getDouble("alt_price"));				
				listEntitledPricesRptSWOEEDomainDTO.setListPrice(resultSet.getDouble("list_price"));
				listEntitledPricesRptSWOEEDomainDTO.setESWPrice(resultSet.getDouble("esw_price"));
						
				listEntitledPricesRptSWOEEDomainDTOList.add(listEntitledPricesRptSWOEEDomainDTO);								
			}
		}
		catch(SQLException ex)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"SWOEEDAO","retriveDataForEERpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);				
		}					
		return listEntitledPricesRptSWOEEDomainDTOList;
	}
	
	/**
	 *  Method to get  SWOEE's for Variance All report
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
	 * @param soldToParty
	 * @param dmID
	 * @param swoID
	 * @return List
	 *	  
	 */
	public static List  retriveDataForVarianceAllRpt(String proposalID,String soldToParty,String dmID,String swoID)
	{
		VarianceRptSWOEEDomainDTO varianceRptSWOEEDomainDTO = new VarianceRptSWOEEDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		List varianceRptSWOEEDomainDTOList = new ArrayList();

		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(VARIANCE_ALL_REPORT);
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			preparedStatement.setInt(3,Integer.parseInt(dmID));
			preparedStatement.setInt(4,Integer.parseInt(swoID));
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{	
				varianceRptSWOEEDomainDTO = new VarianceRptSWOEEDomainDTO();											
				varianceRptSWOEEDomainDTO.setEENo(resultSet.getString("ee_no"));
				varianceRptSWOEEDomainDTO.setDescription(resultSet.getString("ee_desc"));				
				varianceRptSWOEEDomainDTO.setESWPrice(resultSet.getDouble("esw_price"));
				varianceRptSWOEEDomainDTO.setSwoEEID(resultSet.getString("swoee_id"));			
				varianceRptSWOEEDomainDTOList.add(varianceRptSWOEEDomainDTO);								
			}
		}
		catch(SQLException ex)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"SWOEEDAO","retriveDataForVarianceAllRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);				
		}					
		return varianceRptSWOEEDomainDTOList;
	}
	
	/**
	 *  Method to get  SWOEE's for  Variance Price report
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
	 * @param soldToParty
	 * @param dmID
	 * @param swoID
	 * @return List	  
	 */
	public static List  retriveDataForVariancePriceRpt(String proposalID,String soldToParty,String dmID,String swoID)
	{
		VarianceRptSWOEEDomainDTO varianceRptSWOEEDomainDTO = new VarianceRptSWOEEDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		List varianceRptSWOEEDomainDTOList = new ArrayList();

		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(VARIANCE_PRICE_REPORT);
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			preparedStatement.setInt(3,Integer.parseInt(dmID));
			preparedStatement.setInt(4,Integer.parseInt(swoID));
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{	
				varianceRptSWOEEDomainDTO = new VarianceRptSWOEEDomainDTO();											
				varianceRptSWOEEDomainDTO.setEENo(resultSet.getString("ee_no"));
				varianceRptSWOEEDomainDTO.setDescription(resultSet.getString("ee_desc"));				
				varianceRptSWOEEDomainDTO.setESWPrice(resultSet.getDouble("esw_price"));
				varianceRptSWOEEDomainDTO.setSwoEEID(resultSet.getString("swoee_id"));			
				varianceRptSWOEEDomainDTOList.add(varianceRptSWOEEDomainDTO);								
			}
		}
		catch(SQLException ex)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"SWOEEDAO","retriveDataForVariancePriceRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}					
		return varianceRptSWOEEDomainDTOList;
	}
	
	
	/**
	 *  Method to get  SWOEE's for  Sysplex report
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
	public static List  retriveDataForSysplexRpt(String proposalID,String eeNo,String serialNo)
	{

		SysplexRptSWOEEDomainDTO sysplexRptSWOEEDomainDTO = new SysplexRptSWOEEDomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		List sysplexRptSWOEEDomainDTOList = new ArrayList();

		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SYSPLEX_REPORT);
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setString(2,eeNo);
			preparedStatement.setString(3,serialNo);
			preparedStatement.setString(4,serialNo);
		
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{	
				sysplexRptSWOEEDomainDTO = new SysplexRptSWOEEDomainDTO();											
				sysplexRptSWOEEDomainDTO.setEENo(resultSet.getString("ee_no"));
				sysplexRptSWOEEDomainDTO.setDescription(resultSet.getString("ee_desc"));				
				sysplexRptSWOEEDomainDTO.setPrice(resultSet.getDouble("calc_price"));
						
				sysplexRptSWOEEDomainDTOList.add(sysplexRptSWOEEDomainDTO);
			}
		}
		catch(SQLException ex)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"SWOEEDAO","retriveDataForSysplexRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}					

		return sysplexRptSWOEEDomainDTOList;
	}

}

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
 * This DAO is responsible for getting DM information for reports  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 3, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author 	Kedar Harischandrakar
 * @version 5.1A 
 */
public class DMDAO extends OPPTDAO
{
	private static final String CONTRACT_PLANNING_REPORT = "select distinct(a.desg_machine_id),a.Desg_machine_no,a.desg_machine_desc ,a.plan_start_date,a.plan_end_date,a.sold_to_party_id from BH.custdesgmachine a,BH.systemswo b where a.proposal_id=? and a.sold_to_party_id = ? and a.desg_machine_id= b.desg_machine_id and b.s_s_indicator is null order by Desg_machine_no with ur";
	private static final String CONTRACT_PLANNING_REPORT_SS = "select distinct(a.desg_machine_id),a.Desg_machine_no,a.desg_machine_desc ,a.plan_start_date,a.plan_end_date,a.sold_to_party_id from BH.custdesgmachine a,BH.systemswo b where a.proposal_id=? and a.sold_to_party_id = ? and a.desg_machine_id= b.desg_machine_id and b.s_s_indicator='04' order by Desg_machine_no with ur";
	private static final String CONTRACT_ATTACH_DRAFT_REPORT = "select distinct(a.desg_machine_id),a.Desg_machine_no,a.desg_machine_desc ,a.plan_start_date,a.plan_end_date,a.sold_to_party_id from BH.custdesgmachine a ,BH.systemswo b where a.proposal_id=? and a.sold_to_party_id =? and a.desg_machine_id= b.desg_machine_id and b.s_s_indicator is null order by Desg_machine_no with ur";
	private static final String CONTRACT_ATTACH_DRAFT_REPORT_SS = "select distinct(a.desg_machine_id),a.Desg_machine_no,a.desg_machine_desc ,a.plan_start_date,a.plan_end_date,a.sold_to_party_id from BH.custdesgmachine a ,BH.systemswo b where a.proposal_id=? and a.sold_to_party_id =? and a.desg_machine_id= b.desg_machine_id and b.s_s_indicator='04' order by Desg_machine_no with ur";
	private static final String CONTRACT_ATTACH_FINAL_REPORT = "select desg_machine_id,Desg_machine_no,desg_machine_desc,plan_start_date,plan_end_date,	sold_to_party_id from BH.custdesgmachine where proposal_id=? and sold_to_party_id =? order by Desg_machine_no with ur";
	private static final String CONTRACT_AMENDMENT_REPORT = "select distinct(a.desg_machine_id),a.Desg_machine_no,a.desg_machine_desc,a.plan_start_date,a.plan_end_date,a.sold_to_party_id from BH.custdesgmachine a,BH.systemswo b where a.proposal_id=? and a.sold_to_party_id = ? and a.desg_machine_id= b.desg_machine_id and b.s_s_indicator is null order by Desg_machine_no with ur";
	private static final String CONTRACT_AMENDMENT_REPORT_SS = "select distinct(a.desg_machine_id),a.Desg_machine_no,a.desg_machine_desc,a.plan_start_date,a.plan_end_date,a.sold_to_party_id from BH.custdesgmachine a,BH.systemswo b where a.proposal_id=? and a.sold_to_party_id = ? and a.desg_machine_id= b.desg_machine_id and b.s_s_indicator='04' order by Desg_machine_no with ur";
	private static final String DELETED_SWO_REPORT = "select distinct(a.desg_machine_id),a.Desg_machine_no,a.desg_machine_desc ,a.plan_start_date,a.plan_end_date,a.sold_to_party_id from BH.hiscustdesgmachine a,BH.hissystemswo b where a.proposal_id=? and a.sold_to_party_id = ? and a.desg_machine_id= b.desg_machine_id and b.s_s_indicator is null order by Desg_machine_no with ur";
	private static final String DELETED_SWO_REPORT_SS = "select distinct(a.desg_machine_id),a.Desg_machine_no,a.desg_machine_desc ,a.plan_start_date,a.plan_end_date,a.sold_to_party_id from BH.hiscustdesgmachine a,BH.hissystemswo b where a.proposal_id=? and a.sold_to_party_id = ? and a.desg_machine_id= b.desg_machine_id and b.s_s_indicator='04' order by Desg_machine_no with ur";
	private static final String INVENTORY_LIST_REPORT = "select distinct(a.Desg_machine_no),a.desg_machine_id,a.sold_to_party_id from BH.custdesgmachine a , BH.systemswo b where a.proposal_id=? and a.sold_to_party_id = ? and a.desg_machine_id= b.desg_machine_id and b.s_s_indicator is null order by Desg_machine_no with ur";
	private static final String INVENTORY_LIST_REPORT_SS = "select distinct(a.Desg_machine_no),a.desg_machine_id,a.sold_to_party_id from BH.custdesgmachine a , BH.systemswo b where a.proposal_id=? and a.sold_to_party_id = ? and a.desg_machine_id= b.desg_machine_id and b.s_s_indicator='04' order by Desg_machine_no with ur";
	private static final String LIST_ENTILED_REPORT = "select distinct(a.Desg_machine_no),a.desg_machine_id,a.sold_to_party_id from BH.custdesgmachine a,BH.systemswo b where a.proposal_id=? and a.sold_to_party_id = ? and a.desg_machine_id= b.desg_machine_id and b.s_s_indicator is null order by Desg_machine_no with ur";
	private static final String LIST_ENTILED_REPORT_SS = "select distinct(a.Desg_machine_no),a.desg_machine_id,a.sold_to_party_id from BH.custdesgmachine a,BH.systemswo b where a.proposal_id=? and a.sold_to_party_id = ? and a.desg_machine_id= b.desg_machine_id and b.s_s_indicator='04' order by Desg_machine_no with ur"; 
	private static final String VARIANCE_ALL_REPORT = "select desg_machine_id,desg_machine_no, desg_machine_desc  from BH.tempvarcustdesgmachine where proposal_id=? and sold_to_party_id =? order by desg_machine_no with ur";
	private static final String VARIANCE_PRICE_REPORT = "select desg_machine_id,desg_machine_no, desg_machine_desc  from BH.tempvarcustdesgmachine where proposal_id=? and sold_to_party_id =? order by desg_machine_no with ur";
	private static final String SYSPLEX_REPORT = "select distinct  s.desg_machine_id, d.desg_machine_no, d.desg_machine_desc from BH.systemswo s, BH.custdesgmachine d  where s.proposal_id = ? and s.desg_machine_id = d.desg_machine_id  and s.ref_serial_no is not null and s.ref_ser_no_desgmc is not null 	union 	select distinct  desg_machine_id, desg_machine_no, desg_machine_desc from BH.custdesgmachine where proposal_id = ? and desg_machine_no in (select distinct ref_ser_no_desgmc  from BH.systemswo  where proposal_id= ? and ref_serial_no is not null  and ref_ser_no_desgmc is not null ) order by 2 with ur";
	
	/** 
	 * DMDAO Constructor	  
	 * 
	 * <br/><PRE> 
	 * date Jan 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public DMDAO() 
	{	
	
	}

	/**
	 *  Method to get  DM's for Contract Attachment Final Report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForContractAttchFinalRpt(String proposalID,String soldToParty)
	{
		ContractAttchRptDMDDomainTO contractAttchRptDMDDomainTO = new ContractAttchRptDMDDomainTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;	
		List contractAttchRptDMDDomainTOList  = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_ATTACH_FINAL_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				contractAttchRptDMDDomainTO = new ContractAttchRptDMDDomainTO();						
				
				contractAttchRptDMDDomainTO.setDesgMcID(resultSet.getString("desg_machine_id"));
				contractAttchRptDMDDomainTO.setDesgMcNo(resultSet.getString("desg_machine_no"));
				contractAttchRptDMDDomainTO.setDescMcDesc(resultSet.getString("desg_machine_desc"));
				contractAttchRptDMDDomainTO.setPlanStartDate(resultSet.getDate("plan_start_date"));
				contractAttchRptDMDDomainTO.setPlanEndDate(resultSet.getDate("plan_end_date"));				
				contractAttchRptDMDDomainTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));				
				contractAttchRptDMDDomainTOList.add(contractAttchRptDMDDomainTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"DMDAO","retriveDataForContractAttchFinalRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}	
		return contractAttchRptDMDDomainTOList;
	}
	
	/**
	 *  Method to get DM's for Contract Attachment Draft report 
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForContractAttchDraftRpt(String proposalID,String soldToParty,boolean b)
	{
		ContractAttchRptDMDDomainTO contractAttchRptDMDDomainTO = new ContractAttchRptDMDDomainTO();
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;	
		List contractAttchRptDMDDomainTOList  = new ArrayList();
		try
		{
			connection = getConnection();
			if(b==true) {
				preparedStatement = connection.prepareStatement(CONTRACT_ATTACH_DRAFT_REPORT);
			}
			else {
				preparedStatement = connection.prepareStatement(CONTRACT_ATTACH_DRAFT_REPORT_SS);
			}	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				contractAttchRptDMDDomainTO = new ContractAttchRptDMDDomainTO();					
				
				contractAttchRptDMDDomainTO.setDesgMcID(resultSet.getString("desg_machine_id"));
				contractAttchRptDMDDomainTO.setDesgMcNo(resultSet.getString("desg_machine_no"));
				contractAttchRptDMDDomainTO.setDescMcDesc(resultSet.getString("desg_machine_desc"));
				contractAttchRptDMDDomainTO.setPlanStartDate(resultSet.getDate("plan_start_date"));
				contractAttchRptDMDDomainTO.setPlanEndDate(resultSet.getDate("plan_end_date"));				
				contractAttchRptDMDDomainTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));				
				contractAttchRptDMDDomainTOList.add(contractAttchRptDMDDomainTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"DMDAO","retriveDataForContractAttchDraftRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}	
		return contractAttchRptDMDDomainTOList;
	}
	
	/**
	 *  Method to get  DM for contract planning report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForContractPlnRpt(String proposalID,String soldToParty,boolean b)
	{
		ContractPlanningRptDMDomainDTO contractPlanningRptDMDomainDTO;		
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;	
		List contractPlanningRptDMDomainDTOList  = new ArrayList();
		try
		{
			connection = getConnection();
			if(b==true) {
				preparedStatement = connection.prepareStatement(CONTRACT_PLANNING_REPORT);
			}
			else {
				preparedStatement = connection.prepareStatement(CONTRACT_PLANNING_REPORT_SS);
			}
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				contractPlanningRptDMDomainDTO = new ContractPlanningRptDMDomainDTO();							
				
				contractPlanningRptDMDomainDTO.setDesgMcID(resultSet.getString("desg_machine_id"));
				contractPlanningRptDMDomainDTO.setDesgMcNo(resultSet.getString("desg_machine_no"));
				contractPlanningRptDMDomainDTO.setDesgMcNoDesc(resultSet.getString("desg_machine_desc"));
				contractPlanningRptDMDomainDTO.setPlanStartDate(resultSet.getDate("plan_start_date"));
				contractPlanningRptDMDomainDTO.setPlanEndDate(resultSet.getDate("plan_end_date"));				
				contractPlanningRptDMDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));				
				contractPlanningRptDMDomainDTOList.add(contractPlanningRptDMDomainDTO);						
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"DMDAO","retriveDataForContractPlnRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);					
		}								
		return contractPlanningRptDMDomainDTOList;
	}
	
	/**
	 *  Method to get  DMs for Contract Amendment report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForContractAmdRpt(String proposalID,String soldToParty,boolean b)
	{
		ContractAmendmentRptDMDomainDTO contractAmendmentRptDMDomainDTO;		
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;	
		List contractAmendmentRptDMDomainDTOList  = new ArrayList();
		try
		{
			connection = getConnection();
			if(b ==  true) {
				preparedStatement = connection.prepareStatement(CONTRACT_AMENDMENT_REPORT);
			}
			else {
				preparedStatement = connection.prepareStatement(CONTRACT_AMENDMENT_REPORT_SS);
			}
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				contractAmendmentRptDMDomainDTO = new ContractAmendmentRptDMDomainDTO();							
				
				contractAmendmentRptDMDomainDTO.setDesgMcID(resultSet.getString("desg_machine_id"));
				contractAmendmentRptDMDomainDTO.setDesgMcNo(resultSet.getString("desg_machine_no"));
				contractAmendmentRptDMDomainDTO.setDesgMcDesc(resultSet.getString("desg_machine_desc"));
				contractAmendmentRptDMDomainDTO.setPlanStartDate(resultSet.getDate("plan_start_date"));
				contractAmendmentRptDMDomainDTO.setPlanEndDate(resultSet.getDate("plan_end_date"));				
				contractAmendmentRptDMDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));				
				contractAmendmentRptDMDomainDTOList.add(contractAmendmentRptDMDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"DMDAO","retriveDataForContractAmdRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}								
		return contractAmendmentRptDMDomainDTOList;
	}
	
	/**
	 *  Method to get  DMs for Deleted SWO report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForDelSWORpt(String proposalID,String soldToParty,boolean b)
	{
		DeletedSWORptDMDomainDTO deletedSWORptDMDomainDTO;		
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;	
		List deletedSWORptDMDomainDTOList  = new ArrayList();
		try
		{
			connection = getConnection();
			if(b == true) {
				preparedStatement = connection.prepareStatement(DELETED_SWO_REPORT);	
			}
			else {
				preparedStatement = connection.prepareStatement(DELETED_SWO_REPORT_SS);
			}
				
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				deletedSWORptDMDomainDTO = new DeletedSWORptDMDomainDTO();						
				
				deletedSWORptDMDomainDTO.setDesgMcID(resultSet.getString("desg_machine_id"));
				deletedSWORptDMDomainDTO.setDesgMcNo(resultSet.getString("desg_machine_no"));
				deletedSWORptDMDomainDTO.setDesgMcNoDesc(resultSet.getString("desg_machine_desc"));
				deletedSWORptDMDomainDTO.setPlanStartDate(resultSet.getDate("plan_start_date"));
				deletedSWORptDMDomainDTO.setPlanEndDate(resultSet.getDate("plan_end_date"));				
				deletedSWORptDMDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));				
				deletedSWORptDMDomainDTOList.add(deletedSWORptDMDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"DMDAO","retriveDataForDelSWORpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}								
		return deletedSWORptDMDomainDTOList;
	}
	
	/**
	 *  Method to get  DMs for Inventory report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForInventoryRpt(String proposalID,String soldToParty,boolean b)
	{
		InventoryListRptDMDomainDTO inventoryListRptDMDomainDTO;		
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;	
		List inventoryListRptDMDomainDTOList  = new ArrayList();
		try
		{
			connection = getConnection();
			if(b == true) {
				preparedStatement = connection.prepareStatement(INVENTORY_LIST_REPORT);	
			}
			else {
				preparedStatement = connection.prepareStatement(INVENTORY_LIST_REPORT_SS);
			}
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				inventoryListRptDMDomainDTO = new InventoryListRptDMDomainDTO();	
				
				inventoryListRptDMDomainDTO.setDesgMcID(resultSet.getString("desg_machine_id"));
				inventoryListRptDMDomainDTO.setDesgMcNo(resultSet.getString("desg_machine_no"));				
				inventoryListRptDMDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));				
				inventoryListRptDMDomainDTOList.add(inventoryListRptDMDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"DMDAO","retriveDataForInventoryRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}								
		return inventoryListRptDMDomainDTOList;
	}
	
	/**
	 *  Method to get  DMs for List Entitled report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForEERpt(String proposalID,String soldToParty,boolean b)
	{
		ListEntitledPricesRptDMDomainDTO listEntitledPricesRptDMDomainDTO;		
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;	
		List listEntitledPricesRptDMDomainDTOList  = new ArrayList();
		try
		{
			connection = getConnection();
			if(b == true) {
				preparedStatement = connection.prepareStatement(LIST_ENTILED_REPORT);	
			}
			else {
				preparedStatement = connection.prepareStatement(LIST_ENTILED_REPORT_SS);
			}
				
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				listEntitledPricesRptDMDomainDTO = new ListEntitledPricesRptDMDomainDTO();							
				
				listEntitledPricesRptDMDomainDTO.setDesgMcID(resultSet.getString("desg_machine_id"));
				listEntitledPricesRptDMDomainDTO.setDesgMcNo(resultSet.getString("desg_machine_no"));				
				listEntitledPricesRptDMDomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));				
				listEntitledPricesRptDMDomainDTOList.add(listEntitledPricesRptDMDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"DMDAO","retriveDataForEERpt",null,ex);
		}	
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);					
		}							
		return listEntitledPricesRptDMDomainDTOList;
	}
	
	/**
	 *  Method to get  DMs for Variance All report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForVarianceAllRpt(String proposalID,String soldToParty)
	{
		VarianceRptDMDomainDTO varianceRptDMDomainDTO;		
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;	
		List varianceRptDMDomainDTOList  = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(VARIANCE_ALL_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				varianceRptDMDomainDTO = new VarianceRptDMDomainDTO();							
				
				varianceRptDMDomainDTO.setDesgMcID(resultSet.getString("desg_machine_id"));
				varianceRptDMDomainDTO.setDesgMcNo(resultSet.getString("desg_machine_no"));
				varianceRptDMDomainDTO.setDesgMcDesc(resultSet.getString("desg_machine_desc"));				
				varianceRptDMDomainDTOList.add(varianceRptDMDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"DMDAO","retriveDataForVarianceAllRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);				
		}								
		return varianceRptDMDomainDTOList;
	}
	
	/**
	 *  Method to get  DMs for Variance Price report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForVariancePriceRpt(String proposalID,String soldToParty)
	{
		VarianceRptDMDomainDTO varianceRptDMDomainDTO;		
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;	
		List varianceRptDMDomainDTOList  = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(VARIANCE_PRICE_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				varianceRptDMDomainDTO = new VarianceRptDMDomainDTO();						
				
				varianceRptDMDomainDTO.setDesgMcID(resultSet.getString("desg_machine_id"));
				varianceRptDMDomainDTO.setDesgMcNo(resultSet.getString("desg_machine_no"));
				varianceRptDMDomainDTO.setDesgMcDesc(resultSet.getString("desg_machine_desc"));				
				varianceRptDMDomainDTOList.add(varianceRptDMDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"DMDAO","retriveDataForVariancePriceRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}								
		return varianceRptDMDomainDTOList;
	}
	
	/**
	 *  Method to get  DMs for SysPlex report
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForSysplexRpt(String proposalID)
	{		
		SysplexRptDMDomainDTO sysplexRptDMDomainDTO;		
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;	
		List sysplexRptDMDomainDTOList  = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SYSPLEX_REPORT);	
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(proposalID));
			preparedStatement.setInt(3,Integer.parseInt(proposalID));	
			resultSet = preparedStatement.executeQuery();			
			while(resultSet.next())
			{
				sysplexRptDMDomainDTO = new SysplexRptDMDomainDTO();				
				
				sysplexRptDMDomainDTO.setDmID(resultSet.getString("desg_machine_id"));
				sysplexRptDMDomainDTO.setDesgMcNo(resultSet.getString("desg_machine_no"));
				sysplexRptDMDomainDTO.setDesgMcDesc(resultSet.getString("desg_machine_desc"));								
				sysplexRptDMDomainDTOList.add(sysplexRptDMDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"DMDAO","retriveDataForSysplexRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);			
		}						
		
		return sysplexRptDMDomainDTOList;
	}

	
}

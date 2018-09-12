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

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.VarianceRptPriceDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
/** 
 * This DAO is responsible for getting price information for reports
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 22, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class PriceDAO extends OPPTDAO
{
	private static final String VARIANCE_ALL_REPORT = "select bill_plan_st_date,esw_price,indicator from BH.tempvarprice where proposal_id=? and sold_to_party_id=? and desg_machine_id=? and swo_id=? and swoee_id = ? order by bill_plan_st_date with ur";
	private static final String VARIANCE_PRICE_REPORT = "select bill_plan_st_date,esw_price,indicator from BH.tempvarprice where proposal_id=? and sold_to_party_id=? and desg_machine_id=? and swo_id=? and swoee_id = ? order by bill_plan_st_date with ur";

	/** 
	 * PriceDAO Constructor 
	 * 
	 * <br/><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public PriceDAO() 
	{
		
	}
	/**
	 *  Method to get  price informtaion  for Variance All Report
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 * @param soldToParty
	 * @param dmID
	 * @param swoID
	 * @param swoEEID
	 * @return List	
	 *	  
	 */
	public static List retriveDataForVarianceAllRp(String proposalID,String soldToParty,String dmID,String swoID,String swoEEID)
	{
		VarianceRptPriceDomainDTO varianceRptPriceDomainDTO;
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		List varianceRptPriceDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(VARIANCE_ALL_REPORT);
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			preparedStatement.setInt(3,Integer.parseInt(dmID));
			preparedStatement.setInt(4,Integer.parseInt(swoID));
			preparedStatement.setInt(5,Integer.parseInt(swoEEID));
			resultSet = preparedStatement.executeQuery();	
			while(resultSet.next())
			{
				varianceRptPriceDomainDTO = new VarianceRptPriceDomainDTO();		
				
				varianceRptPriceDomainDTO.setIndicator(resultSet.getString("indicator"));			
				varianceRptPriceDomainDTO.setPlanStartDate(resultSet.getDate("bill_plan_st_date"));
				varianceRptPriceDomainDTO.setESWPrice(resultSet.getDouble("esw_price"));
				varianceRptPriceDomainDTOList.add(varianceRptPriceDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"PriceDAO","retriveDataForVarianceAllRp",null,ex);
		}				
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);				
		}
		return varianceRptPriceDomainDTOList;
	}
	
	/**
	 *  Method to get  price information for Variance Price Report
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 * @param soldToParty
	 * @param dmID
	 * @param swoID
	 * @param swoEEID
	 * @return List	  
	 */
	public static List retriveDataForVariancePriceRpt(String proposalID,String soldToParty,String dmID,String swoID,String swoEEID)
	{
		VarianceRptPriceDomainDTO varianceRptPriceDomainDTO;
		Connection connection = null;
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;		
		List varianceRptPriceDomainDTOList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(VARIANCE_PRICE_REPORT);
			preparedStatement.setInt(1,Integer.parseInt(proposalID));
			preparedStatement.setInt(2,Integer.parseInt(soldToParty));
			preparedStatement.setInt(3,Integer.parseInt(dmID));
			preparedStatement.setInt(4,Integer.parseInt(swoID));
			preparedStatement.setInt(5,Integer.parseInt(swoEEID));
			resultSet = preparedStatement.executeQuery();	
			while(resultSet.next())
			{
				varianceRptPriceDomainDTO = new VarianceRptPriceDomainDTO();		
				
				varianceRptPriceDomainDTO.setIndicator(resultSet.getString("indicator"));			
				varianceRptPriceDomainDTO.setPlanStartDate(resultSet.getDate("bill_plan_st_date"));
				varianceRptPriceDomainDTO.setESWPrice(resultSet.getDouble("esw_price"));
				varianceRptPriceDomainDTOList.add(varianceRptPriceDomainDTO);		
			}
		}
		catch(SQLException ex)
		{		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"PriceDAO","retriveDataForVariancePriceRpt",null,ex);
		}
		finally
		{
			closeConnection(connection , resultSet ,preparedStatement);				
		}				
		return varianceRptPriceDomainDTOList;
	}
	
}

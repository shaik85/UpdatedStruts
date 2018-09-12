/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.dao;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CreateContractEEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.EEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.service.helper.PricingComponentHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ContractTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWOTPCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.CompareTPRptDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ContractAmendmentRptSWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ContractAttchRptSWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ContractPlanningRptSWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.DeletedSWORptSWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.InventoryListRptSWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ListEntitledPricesRptSWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.SysplexRptSWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.VarianceRptSWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;


/** 
 * This DAO is responsible for getting SWO information for reports
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


public class SWODAO extends OPPTDAO
{
	private static final String CLASS_NAME = "SWODAO";

	private static final int QUERY_CONTRACT_NO = 1;
	private static final int QUERY_CONTRACT_TYPE = 2;
	private static final int QUERY_COUNT = 3;
	private static final int QUERY_DETAIL_SWO_INFO = 4;

	private static final int FIRST_INDEX = 1;

	private static final int SWO_NO_INDEX = 1;
	private static final int SERIAL_NO_INDEX = 2;
	private static final int EXT_CONTR_NO_INDEX = 3;
	private static final int CONTR_TYPE_INDEX = 4;

	private static final String CONTRACT_PLANNING_REPORT =
		"select desg_machine_id,sold_to_party_id,swo_no,swo_desc,plan_start_date,plan_end_date,esw_price,alt_price,calc_price,serial_no,ref_serial_no,ref_ser_no_desgmc,swo_id, item_category from BH.systemSWO where proposal_id=? and sold_to_party_id =? and desg_machine_id=? and s_s_indicator is null order by swo_no,serial_no with ur";
	private static final String CONTRACT_PLANNING_REPORT_SS =
		"select desg_machine_id,sold_to_party_id,swo_no,swo_desc,plan_start_date,plan_end_date,esw_price,alt_price,calc_price,serial_no,ref_serial_no,ref_ser_no_desgmc,swo_id, item_category from BH.systemSWO where proposal_id=? and sold_to_party_id =? and desg_machine_id=? and s_s_indicator='04' order by swo_no,serial_no with ur";
	private static final String CONTRACT_ATTACH_DRAFT_REPORT =
		"select desg_machine_id,sold_to_party_id,swo_no,swo_desc,plan_start_date,plan_end_date,esw_price,alt_price,calc_price,serial_no,ref_serial_no,ref_ser_no_desgmc,swo_id, item_category from BH.systemSWO where proposal_id=? and sold_to_party_id =? and desg_machine_id=? and s_s_indicator is null order by swo_no,serial_no with ur";
	private static final String CONTRACT_ATTACH_DRAFT_REPORT_SS =
		"select desg_machine_id,sold_to_party_id,swo_no,swo_desc,plan_start_date,plan_end_date,esw_price,alt_price,calc_price,serial_no,ref_serial_no,ref_ser_no_desgmc,swo_id, item_category from BH.systemSWO where proposal_id=? and sold_to_party_id =? and desg_machine_id=? and s_s_indicator='04' order by swo_no,serial_no with ur";
	private static final String CONTRACT_ATTACH_FINAL_REPORT =
		"select desg_machine_id,sold_to_party_id,swo_no,swo_desc,plan_start_date,plan_end_date,esw_price,alt_price,calc_price,serial_no,ref_serial_no,ref_ser_no_desgmc,swo_id, item_category from BH.systemSWO where proposal_id=? and sold_to_party_id =? and desg_machine_id=? order by swo_no,serial_no with ur";
	private static final String CONTRACT_AMENDMENT_REPORT =
		"select desg_machine_id,sold_to_party_id,swo_no,swo_desc,plan_start_date,plan_end_date,esw_price,alt_price,calc_price,serial_no,ref_serial_no,ref_ser_no_desgmc,swo_id, item_category,adjustment_amt,old_calc_price from BH.systemSWO where proposal_id=? and sold_to_party_id =? and desg_machine_id=? and s_s_indicator is null order by swo_no,serial_no with ur";
	private static final String CONTRACT_AMENDMENT_REPORT_SS =
		"select desg_machine_id,sold_to_party_id,swo_no,swo_desc,plan_start_date,plan_end_date,esw_price,alt_price,calc_price,serial_no,ref_serial_no,ref_ser_no_desgmc,swo_id, item_category,adjustment_amt,old_calc_price from BH.systemSWO where proposal_id=? and sold_to_party_id =? and desg_machine_id=? and s_s_indicator='04' order by swo_no,serial_no with ur";
	private static final String DELETED_SWO_REPORT =
		"select desg_machine_id,sold_to_party_id,swo_no,swo_desc, plan_start_date,plan_end_date,esw_price,alt_price,calc_price, serial_no,ref_serial_no,ref_ser_no_desgmc,swo_id from BH.hissystemSWO where proposal_id=? and sold_to_party_id =? and desg_machine_id=? and s_s_indicator is null order by swo_no,serial_no with ur";
	private static final String DELETED_SWO_REPORT_SS =
		"select desg_machine_id,sold_to_party_id,swo_no,swo_desc, plan_start_date,plan_end_date,esw_price,alt_price,calc_price, serial_no,ref_serial_no,ref_ser_no_desgmc,swo_id from BH.hissystemSWO where proposal_id=? and sold_to_party_id =? and desg_machine_id=? and s_s_indicator='04' order by swo_no,serial_no with ur";
	private static final String INVENTORY_LIST_REPORT =
		"select sold_to_party_id,desg_machine_id,swo_no,swo_id,serial_no,item_category from BH.systemSWO where proposal_id=? and sold_to_party_id =? and desg_machine_id=? and s_s_indicator is null order by swo_no with ur";
	private static final String INVENTORY_LIST_REPORT_SS =
		"select sold_to_party_id,desg_machine_id,swo_no,swo_id,serial_no,item_category from BH.systemSWO where proposal_id=? and sold_to_party_id =? and desg_machine_id=? and s_s_indicator='04' order by swo_no with ur";
	private static final String LIST_ENTILED_REPORT =
		"select desg_machine_id,sold_to_party_id,swo_no,swo_id,serial_no,swo_desc from BH.systemSWO where proposal_id=?  and sold_to_party_id =? and desg_machine_id=? and s_s_indicator is null order by swo_no with ur";
	private static final String LIST_ENTILED_REPORT_SS =
		"select desg_machine_id,sold_to_party_id,swo_no,swo_id,serial_no,swo_desc from BH.systemSWO where proposal_id=?  and sold_to_party_id =? and desg_machine_id=? and s_s_indicator='04' order by swo_no with ur";

	private static final String VARIANCE_ALL_REPORT =
		"select  desg_machine_id,sold_to_party_id,swo_no,swo_id,serial_no	from BH.tempvarsystemSWO where proposal_id=?  and sold_to_party_id =? and desg_machine_id=?  order by swo_no with ur";

	private static final String VARIANCE_PRICE_REPORT =
		"select  desg_machine_id,sold_to_party_id,swo_no,swo_id,serial_no	from BH.tempvarsystemSWO where proposal_id=?  and sold_to_party_id =? and desg_machine_id=?  order by swo_no with ur";

	private static final String SYSPLEX_REPORT =
		"select distinct  e.ee_no,e.ee_desc,s.swo_no,s.serial_no, d.desg_machine_id, d.desg_machine_no from BH.systemswoee e,BH.systemswo s,BH.custdesgmachine d where e.proposal_id = ? and e.swo_id = s.swo_id and s.desg_machine_id = d.desg_machine_id and s.ref_serial_no is null and s.ref_ser_no_desgmc is null and d.desg_machine_no in (select distinct ref_ser_no_desgmc from BH.systemswo where proposal_id = ? and ref_serial_no is not null and ref_ser_no_desgmc is not null ) union select distinct  e.ee_no,e.ee_desc, s.swo_no, s.serial_no,d.desg_machine_id,d.desg_machine_no from BH.systemswoee e, BH.systemswo s, BH.custdesgmachine d where e.proposal_id = ? and e.swo_id = s.swo_id and s.desg_machine_id = d.desg_machine_id and s.ref_serial_no is null and s.ref_ser_no_desgmc is null and d.desg_machine_id in (select distinct s.desg_machine_id  from BH.systemswo s,BH.custdesgmachine d where s.proposal_id = ? and s.desg_machine_id = d.desg_machine_id and s.ref_serial_no is not null and s.ref_ser_no_desgmc is not null) order by 3,1,6 with ur";

	private static final String CUSTOMER_PARTNER_INFO =
		"select bill_to_p_no,payer_no from BH.soldtoparty where proposal_id=? and sold_to_party_id=?";

	/** 
	 * SWODAO Constructor	 
	 * 
	 * <br/><PRE> 
	 * date Jan 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public SWODAO()
	{

	}

	/**
	 *  Method to get Contract Attachment Final report 
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForContractAttchFinalRpt(String proposalID, String soldToParty, String dmID)
	{
		ContractAttchRptSWODomainDTO contractAttchRptSWODomainDTO = new ContractAttchRptSWODomainDTO();
		List contractAttchRptSWODomainDTOList = new ArrayList();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CONTRACT_ATTACH_FINAL_REPORT);
			preparedStatement.setInt(1, Integer.parseInt(proposalID));
			preparedStatement.setInt(2, Integer.parseInt(soldToParty));
			preparedStatement.setInt(3, Integer.parseInt(dmID));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				contractAttchRptSWODomainDTO = new ContractAttchRptSWODomainDTO();

				contractAttchRptSWODomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));
				contractAttchRptSWODomainDTO.setDmID(resultSet.getString("desg_machine_id"));
				contractAttchRptSWODomainDTO.setSWONo(resultSet.getString("swo_no"));
				contractAttchRptSWODomainDTO.setDesc(resultSet.getString("swo_desc"));
				contractAttchRptSWODomainDTO.setPlanStartDate(resultSet.getDate("plan_start_date"));
				contractAttchRptSWODomainDTO.setPlanEndDate(resultSet.getDate("plan_end_date"));
				contractAttchRptSWODomainDTO.setCalculatedPrice(resultSet.getDouble("calc_price"));
				contractAttchRptSWODomainDTO.setSerialNo(resultSet.getString("serial_no"));
				contractAttchRptSWODomainDTO.setSwoID(resultSet.getString("swo_id"));
				contractAttchRptSWODomainDTO.setESWPrice(resultSet.getDouble("esw_price"));
				contractAttchRptSWODomainDTO.setAlternatePrice(resultSet.getDouble("alt_price"));
				contractAttchRptSWODomainDTO.setIndicator(resultSet.getString("item_category"));
				contractAttchRptSWODomainDTOList.add(contractAttchRptSWODomainDTO);
			}
		}
		catch (SQLException ex)
		{
			OPPTLogger.log(
				"EXCEPTION",
				OPPTLogger.ERROR,
				"SWODAO",
				"retriveDataForContractAttchFinalRpt",
				null,
				ex);
		}
		finally
		{
			closeConnection(connection, resultSet, preparedStatement);
		}
		return contractAttchRptSWODomainDTOList;
	}

	/**
	 *  Method to get SWO's for Contract Attachment Draft Report  
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
	 * @return List	  
	 */
	public static List retriveDataForContractAttchDraftRpt(
		String proposalID,
		String soldToParty,
		String dmID,
		boolean b)
	{
		ContractAttchRptSWODomainDTO contractAttchRptSWODomainDTO = new ContractAttchRptSWODomainDTO();
		List contractAttchRptSWODomainDTOList = new ArrayList();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try
		{
			connection = getConnection();
			if (b == true)
			{
				preparedStatement = connection.prepareStatement(CONTRACT_ATTACH_DRAFT_REPORT);
			}
			else
			{
				preparedStatement = connection.prepareStatement(CONTRACT_ATTACH_DRAFT_REPORT_SS);
			}
			preparedStatement.setInt(1, Integer.parseInt(proposalID));
			preparedStatement.setInt(2, Integer.parseInt(soldToParty));
			preparedStatement.setInt(3, Integer.parseInt(dmID));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				contractAttchRptSWODomainDTO = new ContractAttchRptSWODomainDTO();

				contractAttchRptSWODomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));
				contractAttchRptSWODomainDTO.setDmID(resultSet.getString("desg_machine_id"));
				contractAttchRptSWODomainDTO.setSWONo(resultSet.getString("swo_no"));
				contractAttchRptSWODomainDTO.setDesc(resultSet.getString("swo_desc"));
				contractAttchRptSWODomainDTO.setPlanStartDate(resultSet.getDate("plan_start_date"));
				contractAttchRptSWODomainDTO.setPlanEndDate(resultSet.getDate("plan_end_date"));
				contractAttchRptSWODomainDTO.setCalculatedPrice(resultSet.getDouble("calc_price"));
				contractAttchRptSWODomainDTO.setSerialNo(resultSet.getString("serial_no"));
				contractAttchRptSWODomainDTO.setSwoID(resultSet.getString("swo_id"));
				contractAttchRptSWODomainDTO.setESWPrice(resultSet.getDouble("esw_price"));
				contractAttchRptSWODomainDTO.setAlternatePrice(resultSet.getDouble("alt_price"));
				contractAttchRptSWODomainDTO.setIndicator(resultSet.getString("item_category"));
				contractAttchRptSWODomainDTOList.add(contractAttchRptSWODomainDTO);
			}
		}
		catch (SQLException ex)
		{
			OPPTLogger.log(
				"EXCEPTION",
				OPPTLogger.ERROR,
				"SWODAO",
				"retriveDataForContractAttchDraftRpt",
				null,
				ex);
		}
		finally
		{
			closeConnection(connection, resultSet, preparedStatement);
		}
		return contractAttchRptSWODomainDTOList;
	}

	/**
	 *  Method to get SWO's for Contract Planning Report  
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForContractPlnRpt(String proposalID, String soldToParty, String dmID, boolean b)
	{
		ContractPlanningRptSWODomainDTO contractPlanningRptSWODomainDTO;
		List contractPlanningRptSWODomainDTOList = new ArrayList();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try
		{
			connection = getConnection();
			if (b == true)
			{
				preparedStatement = connection.prepareStatement(CONTRACT_PLANNING_REPORT);
			}
			else
			{
				preparedStatement = connection.prepareStatement(CONTRACT_PLANNING_REPORT_SS);
			}

			preparedStatement.setInt(1, Integer.parseInt(proposalID));
			preparedStatement.setInt(2, Integer.parseInt(soldToParty));
			preparedStatement.setInt(3, Integer.parseInt(dmID));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				contractPlanningRptSWODomainDTO = new ContractPlanningRptSWODomainDTO();

				contractPlanningRptSWODomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));
				contractPlanningRptSWODomainDTO.setDmID(resultSet.getString("desg_machine_id"));
				contractPlanningRptSWODomainDTO.setSWONumber(resultSet.getString("swo_no"));
				contractPlanningRptSWODomainDTO.setSWODesc(resultSet.getString("swo_desc"));
				contractPlanningRptSWODomainDTO.setPlanStartDate(resultSet.getDate("plan_start_date"));
				contractPlanningRptSWODomainDTO.setPlanEndDate(resultSet.getDate("plan_end_date"));
				contractPlanningRptSWODomainDTO.setESWPrice(resultSet.getDouble("esw_price"));
				contractPlanningRptSWODomainDTO.setAlternatePrice(resultSet.getDouble("alt_price"));
				contractPlanningRptSWODomainDTO.setCalculatedPrice(resultSet.getDouble("calc_price"));
				contractPlanningRptSWODomainDTO.setSerialNo(resultSet.getString("serial_no"));
				contractPlanningRptSWODomainDTO.setSwoID(resultSet.getString("swo_id"));
				contractPlanningRptSWODomainDTO.setIndicator(resultSet.getString("item_category"));

				contractPlanningRptSWODomainDTOList.add(contractPlanningRptSWODomainDTO);
			}
		}
		catch (SQLException ex)
		{
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "SWODAO", "retriveDataForContractPlnRpt", null, ex);
		}
		finally
		{
			closeConnection(connection, resultSet, preparedStatement);
		}
		return contractPlanningRptSWODomainDTOList;
	}

	/**
	 *  Method to get SWO for Contract Amendment Report  
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
	 * @return List	  
	 */
	public static List retriveDataForContractAmdRpt(String proposalID, String soldToParty, String dmID, boolean b)
	{
		ContractAmendmentRptSWODomainDTO contractAmendmentRptSWODomainDTO;
		List contractAmendmentRptSWODomainDTOList = new ArrayList();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			connection = getConnection();
			if (b == true)
			{
				preparedStatement = connection.prepareStatement(CONTRACT_AMENDMENT_REPORT);
			}
			else
			{
				preparedStatement = connection.prepareStatement(CONTRACT_AMENDMENT_REPORT_SS);
			}
			preparedStatement.setInt(1, Integer.parseInt(proposalID));
			preparedStatement.setInt(2, Integer.parseInt(soldToParty));
			preparedStatement.setInt(3, Integer.parseInt(dmID));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				contractAmendmentRptSWODomainDTO = new ContractAmendmentRptSWODomainDTO();

				contractAmendmentRptSWODomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));
				contractAmendmentRptSWODomainDTO.setDmID(resultSet.getString("desg_machine_id"));
				contractAmendmentRptSWODomainDTO.setSWONo(resultSet.getString("swo_no"));
				contractAmendmentRptSWODomainDTO.setDescription(resultSet.getString("swo_desc"));
				contractAmendmentRptSWODomainDTO.setPlanStartDate(resultSet.getDate("plan_start_date"));
				contractAmendmentRptSWODomainDTO.setPlanEndDate(resultSet.getDate("plan_end_date"));
				contractAmendmentRptSWODomainDTO.setESWPrice(resultSet.getDouble("esw_price"));
				contractAmendmentRptSWODomainDTO.setAlternatePrice(resultSet.getDouble("alt_price"));
				contractAmendmentRptSWODomainDTO.setCalculatedPrice(resultSet.getDouble("calc_price"));
				contractAmendmentRptSWODomainDTO.setSerialNo(resultSet.getString("serial_no"));
				contractAmendmentRptSWODomainDTO.setSwoID(resultSet.getString("swo_id"));
				contractAmendmentRptSWODomainDTO.setAdjustmentAmt(resultSet.getDouble("adjustment_amt"));
				contractAmendmentRptSWODomainDTO.setOldCalculatedPrice(resultSet.getDouble("old_calc_price"));
				contractAmendmentRptSWODomainDTOList.add(contractAmendmentRptSWODomainDTO);
			}
		}
		catch (SQLException ex)
		{
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "SWODAO", "retriveDataForContractAmdRpt", null, ex);
		}
		finally
		{
			closeConnection(connection, resultSet, preparedStatement);
		}
		return contractAmendmentRptSWODomainDTOList;
	}

	/**
	 *  Method to get  SWO's for Deleted SWO report
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
	 * @return List	 	  
	 */
	public static List retriveDataForDelSWORpt(String proposalID, String soldToParty, String dmID, boolean b)
	{
		DeletedSWORptSWODomainDTO deletedSWORptSWODomainDTO;
		List deletedSWORptSWODomainDTOList = new ArrayList();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			connection = getConnection();
			if (b == true)
			{
				preparedStatement = connection.prepareStatement(DELETED_SWO_REPORT);
			}
			else
			{
				preparedStatement = connection.prepareStatement(DELETED_SWO_REPORT_SS);
			}

			preparedStatement.setInt(1, Integer.parseInt(proposalID));
			preparedStatement.setInt(2, Integer.parseInt(soldToParty));
			preparedStatement.setInt(3, Integer.parseInt(dmID));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				deletedSWORptSWODomainDTO = new DeletedSWORptSWODomainDTO();
				deletedSWORptSWODomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));
				deletedSWORptSWODomainDTO.setDmID(resultSet.getString("desg_machine_id"));
				deletedSWORptSWODomainDTO.setSWONo(resultSet.getString("swo_no"));
				deletedSWORptSWODomainDTO.setPlanStartDate(resultSet.getDate("plan_start_date"));
				deletedSWORptSWODomainDTO.setPlanEndDate(resultSet.getDate("plan_end_date"));
				deletedSWORptSWODomainDTO.setESWPrice(resultSet.getDouble("esw_price"));
				deletedSWORptSWODomainDTO.setAlternatePrice(resultSet.getDouble("alt_price"));
				deletedSWORptSWODomainDTO.setCalculatedPrice(resultSet.getDouble("calc_price"));
				deletedSWORptSWODomainDTO.setSerialNumber(resultSet.getString("serial_no"));
				deletedSWORptSWODomainDTO.setSwoID(resultSet.getString("swo_id"));

				deletedSWORptSWODomainDTOList.add(deletedSWORptSWODomainDTO);
			}
		}
		catch (SQLException ex)
		{
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "SWODAO", "retriveDataForDelSWORpt", null, ex);
		}
		finally
		{
			closeConnection(connection, resultSet, preparedStatement);
		}
		return deletedSWORptSWODomainDTOList;
	}

	/**
	 *  Method to get  SWO's for Inventory List report
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
	 * @return List	  
	 */
	public static List retriveDataForInventoryRpt(String proposalID, String soldToParty, String dmID, boolean b)
	{
		InventoryListRptSWODomainDTO inventoryListRptSWODomainDTO;
		List inventoryListRptSWODomainDTOList = new ArrayList();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			connection = getConnection();
			if (b == true)
			{
				preparedStatement = connection.prepareStatement(INVENTORY_LIST_REPORT);
			}
			else
			{
				preparedStatement = connection.prepareStatement(INVENTORY_LIST_REPORT_SS);
			}

			preparedStatement.setInt(1, Integer.parseInt(proposalID));
			preparedStatement.setInt(2, Integer.parseInt(soldToParty));
			preparedStatement.setInt(3, Integer.parseInt(dmID));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				inventoryListRptSWODomainDTO = new InventoryListRptSWODomainDTO();

				inventoryListRptSWODomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));
				inventoryListRptSWODomainDTO.setDmID(resultSet.getString("desg_machine_id"));
				inventoryListRptSWODomainDTO.setSWoNumber(resultSet.getString("swo_no"));
				inventoryListRptSWODomainDTO.setSerialNumber(resultSet.getString("serial_no"));
				inventoryListRptSWODomainDTO.setSwoID(resultSet.getString("swo_id"));
				inventoryListRptSWODomainDTO.setIndicator(resultSet.getString("item_category"));
				inventoryListRptSWODomainDTOList.add(inventoryListRptSWODomainDTO);
			}
		}
		catch (SQLException ex)
		{
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "SWODAO", "retriveDataForInventoryRpt", null, ex);
		}
		finally
		{
			closeConnection(connection, resultSet, preparedStatement);
		}
		return inventoryListRptSWODomainDTOList;
	}

	/**
	 *  Method to get  SWO's for List Entitled report
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
	 * @return List	  
	 */
	public static List retriveDataForEERpt(String proposalID, String soldToParty, String dmID, boolean b)
	{
		ListEntitledPricesRptSWODomainDTO listEntitledPricesRptSWODomainDTO;
		List listEntitledPricesRptSWODomainDTOList = new ArrayList();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			connection = getConnection();
			if (b == true)
			{
				preparedStatement = connection.prepareStatement(LIST_ENTILED_REPORT);
			}
			else
			{
				preparedStatement = connection.prepareStatement(LIST_ENTILED_REPORT_SS);
			}

			preparedStatement.setInt(1, Integer.parseInt(proposalID));
			preparedStatement.setInt(2, Integer.parseInt(soldToParty));
			preparedStatement.setInt(3, Integer.parseInt(dmID));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				listEntitledPricesRptSWODomainDTO = new ListEntitledPricesRptSWODomainDTO();

				listEntitledPricesRptSWODomainDTO.setSwoID(resultSet.getString("swo_id"));
				listEntitledPricesRptSWODomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));
				listEntitledPricesRptSWODomainDTO.setDmID(resultSet.getString("desg_machine_id"));
				listEntitledPricesRptSWODomainDTO.setSWONo(resultSet.getString("swo_no"));
				listEntitledPricesRptSWODomainDTO.setSerialNo(resultSet.getString("serial_no"));
				listEntitledPricesRptSWODomainDTO.setDescription(resultSet.getString("swo_desc"));

				listEntitledPricesRptSWODomainDTOList.add(listEntitledPricesRptSWODomainDTO);
			}
		}
		catch (SQLException ex)
		{
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "SWODAO", "retriveDataForEERpt", null, ex);
		}
		finally
		{
			closeConnection(connection, resultSet, preparedStatement);
		}
		return listEntitledPricesRptSWODomainDTOList;
	}

	/**
	 * Verify the TP Proposal 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @param isOriginalProposal
	 * @return boolean
	 * @throws Exception
	 */
	public SWODomainDTO verifyTPProposalForValidity(SWODomainDTO swoDomainDTO) throws Exception
	{
		Connection connection = null;

		try
		{
			boolean isValid = true;
			HashMap map = swoDomainDTO.getValues();

			int proposalID = swoDomainDTO.getProposalId();
			Boolean isRegistrationRequest = (Boolean) map.get(UtilityConstants.REGISTRATION_REQUEST);

			connection = getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery(getMainQuery(proposalID, QUERY_COUNT));

			// strSwoCount
			int totalCount = getCount(rs);

			OPPTLogger.debug(
				new StringBuffer("totalCount: ").append(totalCount).toString(),
				CLASS_NAME,
				"verifyTPProposalForValidity");

			rs = stmt.executeQuery(getQueryForNonTP(proposalID, true));

			// strSwoNonTpCount
			int nonTPCount = getCount(rs);

			OPPTLogger.debug(
				new StringBuffer("nonTPCount: ").append(nonTPCount).toString(),
				CLASS_NAME,
				"verifyTPProposalForValidity");

			rs = stmt.executeQuery(getQueryForSameExternalContractNumber(proposalID, QUERY_COUNT, true));

			// strSwoNullCount 
			int nullSwoCount = getCount(rs);

			rs = stmt.executeQuery(getQueryForNonTP(proposalID, false));

			// strSwoTpCount
			int tpCount = getCount(rs);

			String createFlag = "";
			String contractType = (String) map.get(UtilityConstants.CONTRACT_TYPE);

			boolean isRenewal = ContractTypeConstants.RENEWAL.equals(contractType);
			boolean isOriginalProposal = ContractTypeConstants.ORIGINAL.equals(contractType);
			boolean isReplaced = ContractTypeConstants.REPLACEMENT.equals(contractType);

			isValid = (nonTPCount == totalCount && (isOriginalProposal == false));

			boolean checkExternalContractNumber = false;
			boolean checkContractType = false;

			if (isOriginalProposal)
			{
				checkExternalContractNumber =
					isAllSameData(
						stmt.executeQuery(
							getQueryForSameExternalContractNumber(proposalID, QUERY_CONTRACT_NO, false)));
			}

			if (checkExternalContractNumber)
			{
				checkContractType = isAllSameData(stmt.executeQuery(getQueryForSameContractType(proposalID)));
			}

			boolean canSetMessage = false;
			if (isOriginalProposal)
			{
				if (nonTPCount == totalCount)
				{
					if (checkExternalContractNumber && checkContractType)
					{
						if (isRegistrationRequest.booleanValue())
						{
							createFlag = "A";
						}
						else
						{
							canSetMessage = true;
						}
					}
				}
				else if (totalCount == nullSwoCount)
				{
					if (isRegistrationRequest.booleanValue())
					{
						createFlag = "B";
					}
					else
					{
						canSetMessage = true;
					}
				}
			}
			else if (isRenewal)
			{
				if (nonTPCount == totalCount)
				{
					if (isRegistrationRequest.booleanValue())
					{
						createFlag = "A";
					}
					else
					{
						canSetMessage = true;
					}
				}
				else if (totalCount == nullSwoCount || totalCount == tpCount)
				{
					if (isRegistrationRequest.booleanValue())
					{
						createFlag = "C";
					}
					else
					{
						canSetMessage = true;
					}
				}

			}
			else if (isReplaced)
			{
				if (isRegistrationRequest.booleanValue())
				{
					createFlag = null;
				}
				else
				{
					canSetMessage = true;
				}
			}

			if (isValid == false)
			{
				rs = stmt.executeQuery(getQueryForNonContract(proposalID));
				int count = getCount(rs);
				isValid = (totalCount == count);

				OPPTLogger.debug(
					new StringBuffer("don't belong to any contract: ").append(count).toString(),
					CLASS_NAME,
					"verifyTPProposalForValidity");
			}

			if (isValid == false && isOriginalProposal)
			{
				boolean canSet = true;

				if (checkExternalContractNumber)
				{
					if (checkContractType)
					{
						isValid = true;

						if (isRegistrationRequest.booleanValue() == false)
						{
							rs =
								stmt.executeQuery(
									getQueryForSameExternalContractNumber(
										proposalID,
										QUERY_DETAIL_SWO_INFO,
										false));

							List list = new ArrayList();

							while (rs.next())
							{
								SWOTPCustomDTO dto = new SWOTPCustomDTO();

								dto.setNumber(rs.getString(SWO_NO_INDEX));
								dto.setSerialNumber(rs.getString(SERIAL_NO_INDEX));
								dto.setExternalContractNumber(rs.getString(EXT_CONTR_NO_INDEX));
								dto.setContractType(rs.getString(CONTR_TYPE_INDEX));

								list.add(dto);
							}

							map.put(UtilityConstants.TP_SWO_LIST, list);
							
							rs.close();
						}

						stmt.close();
					}
				}
			}

			map.put(UtilityConstants.TP_CREATION_FLAG, createFlag);
			map.put(UtilityConstants.TP_VALID_FLAG, new Boolean(isValid));

			if (canSetMessage)
			{
				ErrorReport report =
					ExceptionGenerator.addErrorEntry(
						null,
						ErrorCodeConstants.DE0304,
						OPPTMessageCatalog.TYPE_DOMAIN);
				map.put(UtilityConstants.TP_MESSAGE, report);
			}

			swoDomainDTO.setValues(map);

			return swoDomainDTO;
		}
		catch (Exception err)
		{
			throw err;
		}
		finally
		{
			closeConnection(connection);
		}
	}

	/**
	 * To close the connection 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	private void closeConnection(Connection connection) throws SQLException
	{
		if (connection != null)
		{
			connection.close();
		}
	}

	/** 
	 * To check all the data in the resultset are same
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br>
	 * 
	 * @param rs 
	 */
	private boolean isAllSameData(ResultSet rs) throws SQLException
	{
		Map map = new HashMap();
		String data;

		while (rs.next())
		{
			data = rs.getString(FIRST_INDEX);
			data = (data == null) ? "" : data.trim();
			map.put(data, "");
		}

		rs.close();

		OPPTLogger.debug(map.toString(), CLASS_NAME, "isAllSameData");

		return (map.size() == 1);
	}

	/**
	 * To get the value from the result set 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private int getCount(ResultSet rs) throws SQLException
	{
		int count = -1;

		if (rs.next())
		{
			count = rs.getInt(FIRST_INDEX);
		}
		rs.close();

		return count;
	}

	/**
	 * If all licenses in the proposal belong to a non-TP contract 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return
	 */
	private String getQueryForNonTP(int proposalID, boolean isNonTp)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(getMainQuery(proposalID, QUERY_COUNT));
		buffer.append(" AND ");
		buffer.append("  (swo_ext_cntr_num is NOT NULL OR swo_ext_cntr_num != \'\') AND ");
		buffer.append(" swo_cntr_type ");
		if (isNonTp)
		{
			buffer.append(" <> \'");
		}
		else
		{
			buffer.append(" = \'");
		}

		buffer.append(ProposalTypeConstants.TP);
		buffer.append("\' ");
		buffer.append(" AND (swo_cntr_status = \'");
		buffer.append(UtilityConstants.ESW_CONTRACT_STATUS);
		buffer.append("\' OR swo_cntr_status = \'");
		buffer.append(UtilityConstants.ESW_EXTENSION_IN_PROGRESS);
		buffer.append("\') ");

		OPPTLogger.debug(buffer.toString(), CLASS_NAME, "getQueryForNonTP");

		return buffer.toString();
	}

	/**
	 * If all licenses in the proposal don't belong to any contract 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return
	 */
	private String getQueryForNonContract(int proposalID)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(getMainQuery(proposalID, QUERY_COUNT));
		buffer.append(" AND ");
		buffer.append(" (swo_ext_cntr_num IS NULL OR swo_ext_cntr_num = \'\')");

		OPPTLogger.debug(buffer.toString(), CLASS_NAME, "getQueryForNonContract");
		return buffer.toString();
	}

	/**
	 * If all licenses have the same external contract number 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return
	 */
	private String getQueryForSameExternalContractNumber(int proposalID, int option, boolean isForNull)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(getMainQuery(proposalID, option));
		buffer.append(" AND ");
		buffer.append(" (swo_ext_cntr_num IS ");
		if (isForNull == false)
		{
			buffer.append(" NOT ");
		}
		buffer.append(" NULL OR swo_ext_cntr_num ");
		if (isForNull == false)
		{
			buffer.append(" !");
		}

		buffer.append("= \'\')");

		OPPTLogger.debug(buffer.toString(), CLASS_NAME, "getQueryForSameExternalContractNumber");
		return buffer.toString();
	}

	/**
	 * same contract type 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return
	 */
	private String getQueryForSameContractType(int proposalID)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(getMainQuery(proposalID, QUERY_CONTRACT_TYPE));
		buffer.append(" AND ");
		buffer.append(" swo_cntr_type IS NOT NULL");

		OPPTLogger.debug(buffer.toString(), CLASS_NAME, "getQueryForSameContractType");
		return buffer.toString();
	}

	/**
	 * To obtain the main query 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @param queryType
	 * @return
	 */
	private String getMainQuery(int proposalID, int queryType)
	{
		StringBuffer buffer = new StringBuffer();

		switch (queryType)
		{
			case QUERY_CONTRACT_TYPE :
				buffer.append("select swo_cntr_type");
				break;

			case QUERY_CONTRACT_NO :
				buffer.append("select swo_ext_cntr_num");
				break;

			case QUERY_DETAIL_SWO_INFO :
				buffer.append("select swo_no, serial_no, swo_ext_cntr_num, swo_cntr_type");
				break;

			case QUERY_COUNT :
			default :
				buffer.append("select count(*)");
		}

		buffer.append(" from BH.systemswo");
		buffer.append(" where proposal_id = ");
		buffer.append(proposalID);

		return buffer.toString();
	}

	/**
	 * @param proposalID
	 * @param oldProposalID
	 * @param domainDTO
	 * @return
	 * @throws Exception
	 */
	public CompareTPRptDomainDTO getCompareTPRpt(
		int proposalID,
		int oldProposalID,
		CompareTPRptDomainDTO domainDTO)
		throws Exception
	{
		Connection connection = null;
		try
		{
			connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(getDecimalAllowedQuery(proposalID));

			int decimalAllowed = -1;

			if (rs.next())
			{
				decimalAllowed = rs.getInt(FIRST_INDEX);
			}
			rs.close();

			rs = stmt.executeQuery(getSWOQuery(proposalID, oldProposalID));

			List swoList = domainDTO.getSWODomainDTOList();

			if (swoList == null)
			{
				swoList = new ArrayList();
				domainDTO.setSWODomainDTOList(swoList);
			}

			String prevSWONo = null;

			SWODomainDTO swoDomainDTO = null;
			List eeList = null;

			while (rs.next())
			{
				String swoNo = rs.getString(1);
				String serialNo = rs.getString(2);
				String eeNo = rs.getString(3);
				proposalID = rs.getInt(4);
				String eeDesc = rs.getString(5);

				if (rs.next())
				{
					String oldSWONo = rs.getString(1);
					String oldSerialNo = rs.getString(2);
					String oldEENo = rs.getString(3);
					oldProposalID = rs.getInt(4);
					String oldEEDesc = rs.getString(5);

					if (swoNo.equals(oldSWONo) && serialNo.equals(oldSerialNo) && eeNo.equals(oldEENo))
					{
						Statement swoStmt = connection.createStatement();
						ResultSet swoRs =
							swoStmt.executeQuery(getESWPriceQuery(proposalID, swoNo, eeNo, decimalAllowed));

						String eswPrice = null;
						if (swoRs.next())
						{
							eswPrice = swoRs.getString(FIRST_INDEX);
						}
						swoRs.close();

						swoRs =
							swoStmt.executeQuery(
								getESWPriceQuery(oldProposalID, oldSWONo, oldEENo, decimalAllowed));
						String oldEswPrice = null;

						if (swoRs.next())
						{
							oldEswPrice = swoRs.getString(FIRST_INDEX);
						}
						swoRs.close();
						swoStmt.close();

						if (eswPrice != null && oldEswPrice != null && eswPrice.equals(oldEswPrice))
						{
							String message =
								new StringBuffer("ESW Price matching....")
									.append(eswPrice)
									.append("==")
									.append(oldEswPrice)
									.toString();
							OPPTLogger.debug(message, CLASS_NAME, "getCompareTPRpt");
						}
						else
						{
							String message =
								new StringBuffer("ESW Price not matching....")
									.append(eswPrice)
									.append("==")
									.append(oldEswPrice)
									.toString();
							OPPTLogger.debug(message, CLASS_NAME, "getCompareTPRpt");
						}

						if (swoNo.equals(prevSWONo) == false)
						{
							swoDomainDTO = new SWODomainDTO();
							swoList.add(swoDomainDTO);

							prevSWONo = swoNo;

							swoDomainDTO.setSwoNo(swoNo);
							swoDomainDTO.setSerialNo(serialNo);

							eeList = new ArrayList();
							swoDomainDTO.setEEDTOList(eeList);

							EEDomainDTO eeDomainDTO = new EEDomainDTO();
							eeDomainDTO.setEeNo(eeNo);
							eeDomainDTO.setEeDesc(eeDesc);
						}
					}
				}
			}
		}
		catch (SQLException ex)
		{
			throw ex;
		}
		finally
		{
			closeConnection(connection);
		}

		return domainDTO;
	}

	private String getSWOQuery(int proposalID, int oldProposalID)
	{
		StringBuffer buffer = new StringBuffer();

		buffer.append("select distinct o.swo_no, o.serial_no, e.ee_no, o.proposal_id, e.ee_desc ");
		buffer.append(" from BH.systemswo o,BH.systemswoee e where (o.proposal_id = ");
		buffer.append(proposalID);
		buffer.append(" and e.proposal_id = ");
		buffer.append(proposalID);
		buffer.append(" and o.swo_id = e.swo_id");
		buffer.append(" union all ");
		buffer.append("select distinct o.swo_no, o.serial_no, e.ee_no, o.proposal_id, e.ee_desc ");
		buffer.append(" from BH.systemswo o, BH.systemswoee e where  (o.proposal_id = ");
		buffer.append(oldProposalID);
		buffer.append(" and e.proposal_id = ");
		buffer.append(oldProposalID);
		buffer.append(") and o.swo_id = e.swo_id order by 1,2,3,4");

		return buffer.toString();
	}

	private String getDecimalAllowedQuery(int proposalID)
	{
		StringBuffer buffer = new StringBuffer();

		buffer.append("select decimal_allowed from BH.currency where currency_code = (select currency ");
		buffer.append(" from BH.proposal where proposal_id = ");
		buffer.append(proposalID);

		return buffer.toString();
	}

	private String getESWPriceQuery(int proposalID, String swoNo, String eeNo, int decimalAllowed)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("select ");

		if (decimalAllowed > -1)
		{
			buffer.append("DECIMAL(e.esw_price, 19, ");
			buffer.append(decimalAllowed);
		}
		else
		{
			buffer.append("INTEGER(e.esw_price) ");
		}

		buffer.append(" from BH.systemswoee e, BH.systemswo o ");
		buffer.append(" where o.proposal_id = ");
		buffer.append(proposalID);
		buffer.append(" and o.swo_no = \'");
		buffer.append(swoNo);
		buffer.append("\' and ee_no = \'");
		buffer.append(eeNo);
		buffer.append("\'");

		return buffer.toString();
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
	 * @return List
	 *	  
	 */
	public static List retriveDataForVarianceAllRpt(String proposalID, String soldToParty, String dmID)
	{
		VarianceRptSWODomainDTO varianceRptSWODomainDTO = new VarianceRptSWODomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List varianceRptSWODomainDTOList = new ArrayList();

		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(VARIANCE_ALL_REPORT);
			preparedStatement.setInt(1, Integer.parseInt(proposalID));
			preparedStatement.setInt(2, Integer.parseInt(soldToParty));
			preparedStatement.setInt(3, Integer.parseInt(dmID));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				varianceRptSWODomainDTO = new VarianceRptSWODomainDTO();
				varianceRptSWODomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));
				varianceRptSWODomainDTO.setDmID(resultSet.getString("desg_machine_id"));
				varianceRptSWODomainDTO.setSwoID(resultSet.getString("swo_id"));
				varianceRptSWODomainDTO.setSWONo(resultSet.getString("swo_no"));
				varianceRptSWODomainDTO.setSerialNo(resultSet.getString("serial_no"));

				varianceRptSWODomainDTOList.add(varianceRptSWODomainDTO);
			}
		}
		catch (SQLException ex)
		{
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "SWODAO", "retriveDataForVarianceAllRpt", null, ex);
		}
		finally
		{
			closeConnection(connection, resultSet, preparedStatement);
		}
		return varianceRptSWODomainDTOList;
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
	 * @return List	  
	 */
	public static List retriveDataForVariancePriceRpt(String proposalID, String soldToParty, String dmID)
	{
		VarianceRptSWODomainDTO varianceRptSWODomainDTO = new VarianceRptSWODomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List varianceRptSWODomainDTOList = new ArrayList();

		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(VARIANCE_PRICE_REPORT);
			preparedStatement.setInt(1, Integer.parseInt(proposalID));
			preparedStatement.setInt(2, Integer.parseInt(soldToParty));
			preparedStatement.setInt(3, Integer.parseInt(dmID));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				varianceRptSWODomainDTO = new VarianceRptSWODomainDTO();
				varianceRptSWODomainDTO.setSoldToPartyID(resultSet.getString("sold_to_party_id"));
				varianceRptSWODomainDTO.setDmID(resultSet.getString("desg_machine_id"));
				varianceRptSWODomainDTO.setSwoID(resultSet.getString("swo_id"));
				varianceRptSWODomainDTO.setSWONo(resultSet.getString("swo_no"));
				varianceRptSWODomainDTO.setSerialNo(resultSet.getString("serial_no"));

				varianceRptSWODomainDTOList.add(varianceRptSWODomainDTO);
			}
		}
		catch (SQLException ex)
		{
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "SWODAO", "retriveDataForVariancePriceRpt", null, ex);
		}
		finally
		{
			closeConnection(connection, resultSet, preparedStatement);
		}
		return varianceRptSWODomainDTOList;
	}

	/**
	 *  Method to get  SWO's for  Sysplex report
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
	 */
	public static List retriveDataForSysplexRpt(String proposalID)
	{
		SysplexRptSWODomainDTO sysplexRptSWODomainDTO = new SysplexRptSWODomainDTO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List sysplexRptSWODomainDTOList = new ArrayList();

		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SYSPLEX_REPORT);
			preparedStatement.setInt(1, Integer.parseInt(proposalID));
			preparedStatement.setInt(2, Integer.parseInt(proposalID));
			preparedStatement.setInt(3, Integer.parseInt(proposalID));
			preparedStatement.setInt(4, Integer.parseInt(proposalID));

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				sysplexRptSWODomainDTO = new SysplexRptSWODomainDTO();

				sysplexRptSWODomainDTO.setSWONo(resultSet.getString("swo_no"));
				sysplexRptSWODomainDTO.setSerialNo(resultSet.getString("serial_no"));
				sysplexRptSWODomainDTO.setEENo(resultSet.getString("ee_no"));

				sysplexRptSWODomainDTOList.add(sysplexRptSWODomainDTO);
			}
		}
		catch (SQLException ex)
		{
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "SWODAO", "retriveDataForSysplexRpt", null, ex);
		}
		finally
		{
			closeConnection(connection, resultSet, preparedStatement);
		}
		return sysplexRptSWODomainDTOList;
	}

	/** 
	 * Retrieves the EE information for contract creation
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposal
	 * @return CreateContractEEDomainDTO[]
	 * @throws DomainException 
	 */
	public CreateContractEEDomainDTO[] retrieveLicensesForContractCreation(ProposalDomainDTO proposal)
		throws DomainException
	{
		Connection connection = null;
		ResultSet mainResults = null;
		ResultSet diffResults = null;
		PreparedStatement statement = null;
		Statement currencyStatement = null;
		Statement mainStatement = null;
		String currencyCode = null;
		int decimalAllowed = 2; // default one
		CreateContractEEDomainDTO[] createContractEEArray = null;
		CreateContractEEDomainDTO createContractEE = null;

		if (proposal == null)
		{
			OPPTLogger.log(
				ErrorCodeConstants.APP_INSUFFICIENT_INPUT,
				OPPTLogger.ERROR,
				"SWODAO",
				"retrieveLicensesForContractCreation",
				null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		int proposalID = proposal.getProposalId();
		currencyCode = proposal.getCurrency();
		try
		{
			connection = getConnection();
			currencyStatement = connection.createStatement();
			diffResults = currencyStatement.executeQuery(getDecimalAllowedQuery(currencyCode));
			while (diffResults.next())
			{
				decimalAllowed = diffResults.getInt(1);
			}
			diffResults.close();
			currencyStatement.close();

			mainStatement = connection.createStatement();
			statement = connection.prepareStatement(CUSTOMER_PARTNER_INFO);
			statement.setInt(1, proposalID);
			List allEEs = new ArrayList();
			String priceConditionType = UtilityConstants.MLC_PRICE_COND_TYPE;
			if (ContractTypeConstants.VARIANCE.equals(proposal.getContrType()))
			{
				priceConditionType = UtilityConstants.VARIANCE_PRICE_COND_TYPE;
			}
			String billingFreqCode = proposal.getBillingFreqCode();
			int multiplier = getMultiplier(billingFreqCode);
			int prevSTPID = 0;
			int currentSTPID = 0;
			int currentSWOID = 0;
			int currentSWOEEID = 0;
			String btpSAPNo = null;
			String payerSAPNo = null;
			OPPTLogger.debug(
				"SQL = " + getEEInfoSQL(proposalID, decimalAllowed),
				CLASS_NAME,
				"retrieveLicensesForContractCreation");
			mainResults = mainStatement.executeQuery(getEEInfoSQL(proposalID, decimalAllowed));
			while (mainResults.next())
			{
				createContractEE = new CreateContractEEDomainDTO();
				createContractEE.setSalesDocNo(mainResults.getString(1));
				createContractEE.setEeItemNo(mainResults.getString(2));
				createContractEE.setSequenceNo(mainResults.getInt(3));
				currentSTPID = mainResults.getInt(5);
				if (currentSTPID != prevSTPID)
				{
					prevSTPID = currentSTPID;
					OPPTLogger.debug(
						"currentSTPID = " + currentSTPID,
						CLASS_NAME,
						"retrieveLicensesForContractCreation");
					statement.setInt(2, currentSTPID);
					diffResults = statement.executeQuery();
					while (diffResults.next())
					{
						btpSAPNo = diffResults.getString(1);
						payerSAPNo = diffResults.getString(2);
					}
					diffResults.close();
				}
				currentSWOID = mainResults.getInt(6);
				currentSWOEEID = mainResults.getInt(7);
				/* Start change CR6153 */
				createContractEE.setPlanStartDate(mainResults.getDate(8));
			    createContractEE.setPlanEndDate(mainResults.getDate(9));
			    /* End change CR6153 */
			    
				//	S and S changes starts
				if (UtilityConstants.SANDS_ONLY.equals(proposal.getProposalContent())
					|| UtilityConstants.MLC_AND_SANDS.equals(proposal.getProposalContent()))
				{
					java.sql.Date sAndSUptoDate =
						OPPTCalender.getDayMinusOneSqlDate(proposal.getContrStartPeriod());
					java.sql.Date swoPlanStartDate = null;
					String sAndSInd = "";
					Statement licenceStatement = connection.createStatement();
					ResultSet licenceInfo = licenceStatement.executeQuery(getSANDSInfo(proposalID, currentSWOID));
					if (licenceInfo.next())
					{
						sAndSInd = licenceInfo.getString(1);
						swoPlanStartDate = licenceInfo.getDate(2);
						if (UtilityConstants.SANDS_IND.equals(sAndSInd))
						{
							priceConditionType = UtilityConstants.S_AND_S_PRICE_COND_TYPE;
							multiplier = 1;
						}
						else{
							   /* To fix Variance contract issue for MLC & S&S Proposals 
						        * MN 26447514 
						        */ 
						       if(ContractTypeConstants.VARIANCE.equals(proposal.getContrType())) {
						        priceConditionType = UtilityConstants.VARIANCE_PRICE_COND_TYPE; 
						       }else {
						        priceConditionType = UtilityConstants.MLC_PRICE_COND_TYPE;
						       }
						       multiplier = getMultiplier(billingFreqCode);
						}
					}

					Statement pricingStatement = connection.createStatement();
					ResultSet pricingResult =
						pricingStatement.executeQuery(
							getSANDSPricingInfo(proposalID, currentSWOID, currentSWOEEID));
					while (pricingResult.next())
					{
						if (swoPlanStartDate != null)
						{
							sAndSUptoDate = OPPTCalender.getDayMinusOneSqlDate(swoPlanStartDate);
						}
					}
					if (UtilityConstants.SANDS_IND.equals(sAndSInd))
					{
						createContractEE.setSAndSUptoDate(sAndSUptoDate);
					}
					else
					{
						createContractEE.setSAndSUptoDate(null);
					}

				}
				// S and S changes ends
				if (UtilityConstants.MLC_ONLY.equals(proposal.getProposalContent()))
				{
					createContractEE.setSAndSUptoDate(null);
				}

				createContractEE.setBillToPartySAPNo(btpSAPNo);
				createContractEE.setPayerSAPNo(payerSAPNo);
				createContractEE.setCurrency(currencyCode);
				createContractEE.setDecimalAllowed(decimalAllowed);
				createContractEE.setPriceConditionType(priceConditionType);
//				FIX FOR DECIMAL ISSUE
				BigDecimal calcPriceForApproval = PricingComponentHelper.convertToBigDecimal(0);
				if(mainResults.getDouble(4) > 0 ) {
					 calcPriceForApproval = PricingComponentHelper.convertToBigDecimal(mainResults.getDouble(4));
					/*
					 * This is a fix for display issue of rounding
					 * Balaji 
					 */
					calcPriceForApproval = calcPriceForApproval.setScale(decimalAllowed, BigDecimal.ROUND_HALF_EVEN);
				 }
				BigDecimal bigMultiplier = PricingComponentHelper.convertToBigDecimal(multiplier);
				calcPriceForApproval = calcPriceForApproval.multiply(bigMultiplier);
				createContractEE.setCalculatedPriceForApproval(calcPriceForApproval);
				
				allEEs.add(createContractEE);
			}
			CreateContractEEDomainDTO[] createContractEEArrayConverter = {
			};
			createContractEEArray = (CreateContractEEDomainDTO[]) allEEs.toArray(createContractEEArrayConverter);
		}
		catch (SQLException e)
		{
			OPPTLogger.log(
				ErrorCodeConstants.APP_GENERAL_EXCEPTION,
				OPPTLogger.ERROR,
				"SWODAO",
				"retrieveLicensesForContractCreation",
				null,
				e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		catch (Exception e)
		{
			OPPTLogger.log(
				ErrorCodeConstants.APP_GENERAL_EXCEPTION,
				OPPTLogger.ERROR,
				"SWODAO",
				"retrieveLicensesForContractCreation",
				null,
				e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		finally
		{
			closeConnection(connection, mainResults, mainStatement);
		}
		return createContractEEArray;
	}

	/* 
	 * Constructs the SQL for retrieving EE Info 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @param decimalAllowed
	 * @return String
	 */
	private String getEEInfoSQL(int proposalID, int decimalAllowed)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("select sales_doc_no,ee_item_no,sequence_no,");
		buffer.append("round(calc_price,");
		buffer.append(decimalAllowed);
		/* Start change CR6153 */
		buffer.append("),sold_to_party_id, swo_id, swoee_id, plan_start_date, plan_end_date from BH.systemswoee ");
		/* End change CR6153 */
		buffer.append(" where proposal_id=");
		buffer.append(proposalID);
		buffer.append(" order by sold_to_party_id");

		return buffer.toString();
	}

	private String getSANDSInfo(int proposalId, int swoId)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("select s_s_indicator,plan_start_date from ");
		buffer.append(" BH.systemswo ");
		buffer.append(" where proposal_id = ");
		buffer.append(proposalId);
		buffer.append(" and swo_id = ");
		buffer.append(swoId);
		return buffer.toString();
	}

	private String getSANDSPricingInfo(int proposalId, int swoId, int swoeeId)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from ");
		buffer.append(" BH.price ");
		buffer.append(" where proposal_id = ");
		buffer.append(proposalId);
		buffer.append(" and swo_id = ");
		buffer.append(swoId);
		buffer.append(" and swoee_id = ");
		buffer.append(swoeeId);
		buffer.append(" and billing_status = 'C' ");
		return buffer.toString();
	}

	/* 
	 * Builds the query to retrieve the decimal allowed for curreny code
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param currencyCode
	 * @return String
	 */
	private String getDecimalAllowedQuery(String currencyCode)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("select decimal_allowed from BH.currency where currency_code='");
		buffer.append(currencyCode);
		buffer.append("'");

		return buffer.toString();
	}

	/* 
	 * Returns the multiplier for billing frequency 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param frequency
	 * @return int
	 */
	private int getMultiplier(String frequency)
	{
		int multiplier = 1;
		if (UtilityConstants.BILLING_FREQ_MONTHLY.equals(frequency))
		{
			multiplier = 12;
		}
		else if (UtilityConstants.BILLING_FREQ_QUARTERLY.equals(frequency))
		{
			multiplier = 4;
		}
		else if (UtilityConstants.BILLING_FREQ_SEMIANNUAL.equals(frequency))
		{
			multiplier = 2;
		}
		return multiplier;
	}
}

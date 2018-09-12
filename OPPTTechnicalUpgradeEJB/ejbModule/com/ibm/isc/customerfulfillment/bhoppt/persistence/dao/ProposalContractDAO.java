/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.LicenseConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * Data Access Object for Proposal and Contract.  This DAO
 * is mainly used for providing data for pagination.  It
 * supports Search, Previous, Next, and Goto Page.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 28, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class ProposalContractDAO extends OPPTDAO {
	private static final String CLASS_NAME = "ProposalContractDAO";

	private static final int MAX_RECORDS_PER_PAGE = 8;

	// Indexes in the Query - START
	private static final int SOLD_TO_PARTY_SOLD_TO_PARTY_ID_IDX = 1;
	private static final int SOLD_TO_PARTY_LEGACY_SOLD_P_NO_IDX = 2;
	private static final int SOLD_TO_PARTY_SAP_SOLD_TO_P_NAME_IDX = 3;
	private static final int SOLD_TO_PARTY_PLAN_START_DATE_IDX = 4;
	private static final int SOLD_TO_PARTY_PLAN_END_DATE_IDX = 5;

	private static final int DM_DESG_MACHINE_ID_IDX = 6;
	private static final int DM_DESG_MACHINE_NO_IDX = 7;
	private static final int DM_DESG_MACHINE_DESC_IDX = 8;
	private static final int DM_PLAN_START_DATE_IDX = 9;
	private static final int DM_PLAN_END_DATE_IDX = 10;

	private static final int SWO_SWO_ID_IDX = 11;
	private static final int SWO_SWO_NO_IDX = 12;
	private static final int SWO_SERIAL_NO_IDX = 13;
	private static final int SWO_SWO_DESC_IDX = 14;
	private static final int SWO_ESW_PRICE_IDX = 15;
	private static final int SWO_ALT_PRICE_IDX = 16;
	private static final int SWO_CALC_PRICE_IDX = 17;
	private static final int SWO_PLAN_START_DATE_IDX = 18;
	private static final int SWO_PLAN_END_DATE_IDX = 19;
	private static final int SWO_PLANNED_IND_IDX = 20;
	private static final int SWO_LOCKED_IND_IDX = 21;
	private static final int SWO_ALT_PRICE_IND_IDX = 22;
	private static final int SWO_EXCLUSION_ID_IDX = 23;
	private static final int SWO_BUMP_IND_IDX = 24;

	private static final int DM_PLANNED_IND_IDX = 25;

	private static final int SWO_RE_FETCH_ID_IDX = 26;
	private static final int SWO_DELTA_FETCH_ID_IDX = 27;
	private static final int SWO_AMDT_START_DATE_IDX = 28;
	private static final int SWO_AMDT_END_DATE_IDX = 29;

	private static final int DM_DM_ADDED_DATE_IDX = 30;

	private static final int SOLD_TO_PARTY_SOLD_TO_P_ASNO_IDX = 31;
	private static final int SWO_ITEM_CATEGORY_IDX = 32;
	private static final int SWO_PROPOSAL_ID_IDX = 33;
	private static final int SWO_AMENDED_INDEX_IDX = 34;

	private static final int SWO_EXT_CNTR_NUM = 35;
	private static final int SWO_CNTR_STATUS = 36;
	private static final int SWO_CNTR_TYPE = 37;
	private static final int SWO_REF_SERIAL_NO = 38;
	private static final int SWO_REF_SER_NO_DESGMC = 39;
	private static final int SWO_S_S_INDICATOR = 40;
	private static final int SWO_ADDED_DATE = 41;
	private static final int SWO_ALT_PRICE_UPDATE_IND = 42;
	private static final int DUPLICATE_DELETED_IND = 43;

	private static final String STP_UPDATE_QUERY = "update BH.soldtoparty set plan_start_date = ? , plan_end_date = ? where proposal_id = ? ";
	private static final String DM_UPDATE_QUERY = "update BH.custdesgmachine set plan_start_date = ? , plan_end_date = ? where proposal_id = ? ";
	private static final String SWO_UPDATE_QUERY = "update BH.systemswo set plan_start_date = ? , plan_end_date = ? where proposal_id = ? ";
	private static final String INVENTORY_AT_PERIOD_START = "select sum(esw_price) from BH.systemswo where proposal_id=?";
	
	//	Indexes in the Query - END

	private Connection connection = null;
	OPPTCalender cal = new OPPTCalender();

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public ProposalContractDAO() {
	}

	/**
	 * This method is used to get the given page for the given arguments  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aProposalID
	 * @param aPageNo
	 * @param aSearchString
	 * @return Proposal DomainDTO
	 * @throws Exception
	 */
	public ProposalDomainDTO retrieveProposalContractDetails(
		int aProposalID,
		int aPageNo,
		String aSearchString,
		int aChoice,
		int pageTotal,
		int mlcPageTotal,
		int mlcExcess,
		boolean isSandS,
		String proposalContent,
		boolean duplicateSerial)
		throws Exception {
		if (connection != null)
			closeConnection();

		ResultSet rs = null;
		ProposalDomainDTO domainDTO = null;
		boolean mlcLicenses = true;
		boolean setPageIndex = false;
		int pageNumber[] = new int[2];

		OPPTLogger.debug("aPageNo = " + aPageNo, "ProposalContractDAO", "retrieveProposalContractDetails");
		OPPTLogger.debug("aSearchString = " + aSearchString, "ProposalContractDAO", "retrieveProposalContractDetails");
		OPPTLogger.debug("aChoice = " + aChoice, "ProposalContractDAO", "retrieveProposalContractDetails");
		OPPTLogger.debug("pageTotal = " + pageTotal, "ProposalContractDAO", "retrieveProposalContractDetails");
		OPPTLogger.debug("mlcPageTotal = " + mlcPageTotal, "ProposalContractDAO", "retrieveProposalContractDetails");
		OPPTLogger.debug("mlcExcess = " + mlcExcess, "ProposalContractDAO", "retrieveProposalContractDetails");
		OPPTLogger.debug("isSandS = " + isSandS, "ProposalContractDAO", "retrieveProposalContractDetails");
		OPPTLogger.debug("proposalContent = " + proposalContent, "ProposalContractDAO", "retrieveProposalContractDetails");
		OPPTLogger.debug("duplicateSerial = " + duplicateSerial, "ProposalContractDAO", "retrieveProposalContractDetails");

		try {
			if (aChoice != UtilityConstants.PRINT_PAGE && pageTotal <= 0) {
				Statement stmt = getStatement();
				rs = stmt.executeQuery(getProposalContractDetailsSQL(aProposalID, aPageNo, aSearchString, true, false, 0,duplicateSerial));
				pageNumber = getPageCount(rs);
				pageTotal = pageNumber[0];

				if (isSandS) {
					rs = stmt.executeQuery(getProposalContractDetailsSQL(aProposalID, aPageNo, aSearchString, true, true, 0,duplicateSerial));
					pageNumber = getPageCount(rs);
					mlcPageTotal = pageNumber[0];
					mlcExcess = pageNumber[1];
				}
				rs.close();
				stmt.close();
				OPPTLogger.debug("aPageNo = " + aPageNo, "ProposalContractDAO", "retrieveProposalContractDetails");
				OPPTLogger.debug("pageTotal = " + pageTotal, "ProposalContractDAO", "retrieveProposalContractDetails");
			}
			if (pageTotal < aPageNo) {
				aPageNo = pageTotal;
				setPageIndex = true;
			}
			if (!isSandS) {
				domainDTO = populateProposalDomainDTO(domainDTO, aProposalID, aPageNo, aSearchString, aChoice, mlcLicenses, 0,duplicateSerial);
			} else {
				if (UtilityConstants.MLC_ONLY.equals(proposalContent)) {
					domainDTO = populateProposalDomainDTO(domainDTO, aProposalID, aPageNo, aSearchString, aChoice, mlcLicenses, 0,duplicateSerial);
				} else if (UtilityConstants.MLC_AND_SANDS.equals(proposalContent)) {
					if (UtilityConstants.GOTO_PAGE == aChoice || UtilityConstants.SEARCH_PAGE == aChoice) {
						if (aPageNo == mlcPageTotal && mlcExcess > 0) {
							domainDTO = populateProposalDomainDTO(domainDTO, aProposalID, aPageNo, aSearchString, aChoice, true, 0,duplicateSerial);
							domainDTO = populateProposalDomainDTO(domainDTO, aProposalID, 1, aSearchString, aChoice, false, mlcExcess,duplicateSerial);
						} else if (aPageNo == mlcPageTotal && mlcExcess == 0) {
							domainDTO = populateProposalDomainDTO(domainDTO, aProposalID, aPageNo, aSearchString, aChoice, true, 0,duplicateSerial);

						} else if (aPageNo > mlcPageTotal) {
							if (mlcPageTotal > 0 && mlcExcess > 0) {
								aPageNo = aPageNo - mlcPageTotal + 1;
							}
							if (mlcPageTotal > 0 && mlcExcess == 0) {
								aPageNo = aPageNo - mlcPageTotal;
							}
							domainDTO = populateProposalDomainDTO(domainDTO, aProposalID, aPageNo, aSearchString, aChoice, false, mlcExcess,duplicateSerial);
						} else if (aPageNo < mlcPageTotal) {
							domainDTO = populateProposalDomainDTO(domainDTO, aProposalID, aPageNo, aSearchString, aChoice, true, 0,duplicateSerial);
						}
					} else if (UtilityConstants.PRINT_PAGE == aChoice) {
						OPPTLogger.debug("PRINT PAGE ", "ProposalContractDAO", "retrieveProposalContractDetails");
						domainDTO = populateProposalDomainDTO(domainDTO, aProposalID, -1, aSearchString, aChoice, true, 0,false);
						domainDTO = populateProposalDomainDTO(domainDTO, aProposalID, -1, aSearchString, aChoice, false, 0,false);
					}
				} else if (UtilityConstants.SANDS_ONLY.equals(proposalContent)) {
					domainDTO = populateProposalDomainDTO(domainDTO, aProposalID, aPageNo, aSearchString, aChoice, false, 0,duplicateSerial);
				}
			}
		} catch (Exception err) {
			throw err;
		} finally {
			closeConnection();
		}
		HashMap map = domainDTO.getValues();
		if (map == null) {
			map = new HashMap();
			domainDTO.setValues(map);
		}

		map.put(UtilityConstants.PROPOSAL_DETAILS_TOTAL_PAGE, new Integer(pageTotal));
		if (setPageIndex) {
			map.put(UtilityConstants.PROPOSAL_DETAILS_PAGE_INDEX, new Integer(aPageNo));
		}
		if (isSandS) {
			map.put(UtilityConstants.MLC_TOTAL_PAGE, new Integer(mlcPageTotal));
			map.put(UtilityConstants.MLC_EXCESS, new Integer(mlcExcess));
			OPPTLogger.debug("map.get(UtilityConstants.MLC_EXCESS) =" + map.get(UtilityConstants.MLC_EXCESS), "ProposalContractDAO", "retrieveProposalContractDetails");

		}

		return domainDTO;
	}

	/** 
	 * Closes the connection
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @throws SQLException
	 *   
	 */
	private void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

	/** 
	 * Returns the resultset for the given proposal-id.
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aProposalID
	 * @return ResultSet 
	 */
	private ResultSet getProposalContractDetails(int aProposalID, int aPageNo, boolean isPageCount, boolean mlcLicenses, int mlcExcess,boolean duplicateSerial) throws SQLException {
		return getStatement().executeQuery(getProposalContractDetailsSQL(aProposalID, aPageNo, null, isPageCount, mlcLicenses, mlcExcess,duplicateSerial));
	}

	private Statement getStatement() throws SQLException {
		connection = getConnection();
		return connection.createStatement();
	}

	//  ONLY FOR LOCAL TESTING PURPOSE	
	//	private Connection getODBCConnection() throws SQLException
	//	{
	//		try
	//		{
	//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		}
	//		catch (ClassNotFoundException e)
	//		{
	//		}
	//		
	//		return DriverManager.getConnection("jdbc:odbc:opptdb", "db2inst1", "xxxxxx");
	//	}

	/** 
	 * To return the resultset for the given proposal-id and search string.
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aProposalID
	 * @param aPageNo
	 * @param aSearchString
	 * @return ResultSet 
	 */
	private ResultSet getSearchDetailsOfProposalContract(int aProposalID, int aPageNo, String aSearchString, boolean mlcLicenses, int mlcExcess, boolean duplicateSerial) throws SQLException {
		String sql = getProposalContractDetailsSQL(aProposalID, aPageNo, aSearchString, false, mlcLicenses, mlcExcess,duplicateSerial);
		Statement stmt = getStatement();
		return stmt.executeQuery(sql);
	}

	/** 
	 * This method builds the ProposalDomainDTO out of Resultset data. 
	 * And returns the ProposalDomainDTO.
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ResultSet
	 * @param 
	 * @return ProposalDomainDTO
	 */
	private ProposalDomainDTO buildProposalDomainDTO(ProposalDomainDTO proposalDomainDTO, ResultSet rs, int aProposalID, boolean mlcLicenses) throws SQLException {
		if (proposalDomainDTO == null) {
			proposalDomainDTO = new ProposalDomainDTO();
		}

		proposalDomainDTO.setProposalId(aProposalID);

		CustomerDomainDTO customerDomainDTO = null;
		DMDomainDTO dmDomainDTO = null;
		SWODomainDTO swoDomainDTO = null;

		while (rs.next()) {
			customerDomainDTO = populateCustomers(rs, proposalDomainDTO, mlcLicenses);
			dmDomainDTO = populateDM(rs, customerDomainDTO);
			swoDomainDTO = populateSWO(rs, dmDomainDTO);
		}
		if (mlcLicenses) {
			if (proposalDomainDTO.getValues() == null) {
				proposalDomainDTO.setValues(new HashMap());
			}

			int size = 0;
			if (proposalDomainDTO.getCustomerDTOList() != null) {
				size = proposalDomainDTO.getCustomerDTOList().size();
			}
			proposalDomainDTO.getValues().put(UtilityConstants.MLC_EXCESS, new Integer(size));
		}
		return proposalDomainDTO;
	}

	/** 
	 * Populates the CustomerDomain DTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param rs
	 * @param proposalDomainDTO
	 * @return 
	 */
	private CustomerDomainDTO populateCustomers(ResultSet rs, ProposalDomainDTO proposalDomainDTO, boolean mlcLicenses) throws SQLException {
		List list = null;

		if (mlcLicenses) {
			list = proposalDomainDTO.getCustomerDTOList();
		} else {
			list = proposalDomainDTO.getSAndSCustomerList();
		}

		if (list == null) {
			list = new ArrayList();
			if (mlcLicenses) {
				proposalDomainDTO.setCustomerDTOList(list);
			} else {
				proposalDomainDTO.setSAndSCustomerList(list);
			}
		}

		CustomerDomainDTO lastCustomerDTO = null;

		if (list.size() > 0)
			lastCustomerDTO = (CustomerDomainDTO) list.get(list.size() - 1);

		int lastCustomerID = -1;

		if (lastCustomerDTO != null) {
			lastCustomerID = lastCustomerDTO.getCustomerId();
		}

		int customerID = rs.getInt(SOLD_TO_PARTY_SOLD_TO_PARTY_ID_IDX);

		if (lastCustomerID != customerID) {
			CustomerDomainDTO customerDomainDTO = new CustomerDomainDTO();
			customerDomainDTO.setCustomerId(customerID);
			customerDomainDTO.setLegacyCustomerNo(checkNullAndTrim(rs.getString(SOLD_TO_PARTY_LEGACY_SOLD_P_NO_IDX)));
			customerDomainDTO.setSapCustomerName(checkNullAndTrim(rs.getString(SOLD_TO_PARTY_SAP_SOLD_TO_P_NAME_IDX)));
			customerDomainDTO.setPlanStartDate(rs.getDate(SOLD_TO_PARTY_PLAN_START_DATE_IDX));
			customerDomainDTO.setPlanEndDate(rs.getDate(SOLD_TO_PARTY_PLAN_END_DATE_IDX));
			customerDomainDTO.setCustmerASNo(checkNullAndTrim(rs.getString(SOLD_TO_PARTY_SOLD_TO_P_ASNO_IDX)));
			customerDomainDTO.setProposalId(proposalDomainDTO.getProposalId());

			list.add(customerDomainDTO);

			lastCustomerDTO = customerDomainDTO;
		}

		return lastCustomerDTO;
	}

	private String checkNullAndTrim(String value) {
		return (value == null ? value : value.trim());
	}

	/** 
	 * Populates Designated Machines Domain DTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param rs
	 * @param customerDomainDTO
	 * @return 
	 */
	private DMDomainDTO populateDM(ResultSet rs, CustomerDomainDTO customerDomainDTO) throws SQLException {
		List list = customerDomainDTO.getDMDTOList();

		if (list == null) {
			list = new ArrayList();
			customerDomainDTO.setDMDTOList(list);
		}

		DMDomainDTO lastDMDomainDTO = null;

		if (list.size() > 0)
			lastDMDomainDTO = (DMDomainDTO) list.get(list.size() - 1);

		int lastDMID = -1;

		if (lastDMDomainDTO != null) {
			lastDMID = lastDMDomainDTO.getDmId();
		}

		int dmID = rs.getInt(DM_DESG_MACHINE_ID_IDX);

		if (lastDMID != dmID) {
			DMDomainDTO dmDomainDTO = new DMDomainDTO();
			dmDomainDTO.setDmId(dmID);
			dmDomainDTO.setDmNo(checkNullAndTrim(rs.getString(DM_DESG_MACHINE_NO_IDX)));
			dmDomainDTO.setDmDesc(checkNullAndTrim(rs.getString(DM_DESG_MACHINE_DESC_IDX)));
			dmDomainDTO.setPlanStartDate(rs.getDate(DM_PLAN_START_DATE_IDX));
			dmDomainDTO.setPlanEndDate(rs.getDate(DM_PLAN_END_DATE_IDX));
			dmDomainDTO.setPlannedInd(checkNullAndTrim(rs.getString(DM_PLANNED_IND_IDX)));
			dmDomainDTO.setDmAddedDate(rs.getDate(DM_DM_ADDED_DATE_IDX));
			dmDomainDTO.setProposalId(customerDomainDTO.getProposalId());
			dmDomainDTO.setCustomerId(customerDomainDTO.getCustomerId());

			list.add(dmDomainDTO);

			lastDMDomainDTO = dmDomainDTO;
		}

		return lastDMDomainDTO;
	}

	/** 
	 * Populates the Software Offering Domain DTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param rs
	 * @param dmDomainDTO
	 * @return 
	 */
	private SWODomainDTO populateSWO(ResultSet rs, DMDomainDTO dmDomainDTO) throws SQLException {
		List list = dmDomainDTO.getSWODTOList();

		if (list == null) {
			list = new ArrayList();
			dmDomainDTO.setSwoDTOList(list);
		}

		SWODomainDTO swoDomainDTO = new SWODomainDTO();
		swoDomainDTO.setSwoId(rs.getInt(SWO_SWO_ID_IDX));
		swoDomainDTO.setSwoNo(checkNullAndTrim(rs.getString(SWO_SWO_NO_IDX)));
		swoDomainDTO.setSerialNo(checkNullAndTrim(rs.getString(SWO_SERIAL_NO_IDX)));
		swoDomainDTO.setSwoDesc(checkNullAndTrim(rs.getString(SWO_SWO_DESC_IDX)));
		swoDomainDTO.setEswPrice(rs.getDouble(SWO_ESW_PRICE_IDX));
		swoDomainDTO.setAlternatePrice(rs.getDouble(SWO_ALT_PRICE_IDX));
		swoDomainDTO.setCalcPrice(rs.getDouble(SWO_CALC_PRICE_IDX));
		swoDomainDTO.setPlanStartDate(rs.getDate(SWO_PLAN_START_DATE_IDX));
		swoDomainDTO.setPlanEndDate(rs.getDate(SWO_PLAN_END_DATE_IDX));
		swoDomainDTO.setPlannedInd(checkNullAndTrim(rs.getString(SWO_PLANNED_IND_IDX)));
		swoDomainDTO.setLockedInd(checkNullAndTrim(rs.getString(SWO_LOCKED_IND_IDX)));
		swoDomainDTO.setAlternatePriceInd(checkNullAndTrim(rs.getString(SWO_ALT_PRICE_IND_IDX)));
		swoDomainDTO.setExclusionId(checkNullAndTrim(rs.getString(SWO_EXCLUSION_ID_IDX)));
		swoDomainDTO.setBumpInd(checkNullAndTrim(rs.getString(SWO_BUMP_IND_IDX)));
		swoDomainDTO.setRefetchId(checkNullAndTrim(rs.getString(SWO_RE_FETCH_ID_IDX)));
		swoDomainDTO.setDeltaFetchId(checkNullAndTrim(rs.getString(SWO_DELTA_FETCH_ID_IDX)));
		swoDomainDTO.setAmendStartDate(rs.getDate(SWO_AMDT_START_DATE_IDX));
		swoDomainDTO.setAmendEndDate(rs.getDate(SWO_AMDT_END_DATE_IDX));

		swoDomainDTO.setSwoExtContrNo(checkNullAndTrim(rs.getString(SWO_EXT_CNTR_NUM)));
		swoDomainDTO.setSwoContrStatus(checkNullAndTrim(rs.getString(SWO_CNTR_STATUS)));
		swoDomainDTO.setSwoContrType(checkNullAndTrim(rs.getString(SWO_CNTR_TYPE)));
		swoDomainDTO.setReferenceSerialNo(checkNullAndTrim(rs.getString(SWO_REF_SERIAL_NO)));
		swoDomainDTO.setReferenceSerialNoDM(checkNullAndTrim(rs.getString(SWO_REF_SER_NO_DESGMC)));
		swoDomainDTO.setSAndSInd(checkNullAndTrim(rs.getString(SWO_S_S_INDICATOR)));
		swoDomainDTO.setSwoAddedDate(rs.getDate(SWO_ADDED_DATE));
		/**
		  * 31/05/2004
		  * MN 19387428- Defect 351
		  * For Alternate Price change added by Balaji
		  */
		swoDomainDTO.setAlternatePriceUpdateInd(rs.getString(SWO_ALT_PRICE_UPDATE_IND));
		
		swoDomainDTO.setDuplicateDeletedInd(rs.getString(DUPLICATE_DELETED_IND));
		
		swoDomainDTO.setProposalId(dmDomainDTO.getProposalId());
		swoDomainDTO.setCustomerId(dmDomainDTO.getCustomerId());
		swoDomainDTO.setDmId(dmDomainDTO.getDmId());

		String quote = OPPTHelper.trimString(rs.getString(SWO_ITEM_CATEGORY_IDX));
		String amendedIndex = OPPTHelper.trimString(rs.getString(SWO_AMENDED_INDEX_IDX));

		HashMap map = new HashMap();
		swoDomainDTO.setValues(map);

		map.put(UtilityConstants.SWO_AMENDED_INDEX, new Boolean(amendedIndex != null));
		map.put(UtilityConstants.SWO_DELTA_FETCH_INDEX, new Boolean(LicenseConstants.LICENSE_DELTAFETCH.equals(OPPTHelper.trimString(swoDomainDTO.getDeltaFetchId()))));
		map.put(UtilityConstants.SWO_EXCLUDED, new Boolean(LicenseConstants.LICENSE_EXCLUDED.equals(OPPTHelper.trimString(swoDomainDTO.getExclusionId()))));
		map.put(UtilityConstants.SWO_REFETCH_LICENSE, new Boolean(LicenseConstants.LICENSE_REFETCHED.equals(OPPTHelper.trimString(swoDomainDTO.getRefetchId()))));
		map.put(UtilityConstants.SWO_QUOTE_FLAG, new Boolean(LicenseConstants.QUOTE_FLAG.equals(quote)));
		map.put(UtilityConstants.SWO_SVC_LICENSE, new Boolean(LicenseConstants.SVC_LICENSE_FLAG.equals(quote)));
		map.put(UtilityConstants.SWO_EDITED_LICENSE, new Boolean(LicenseConstants.LICENSE_PLANNED.equals(OPPTHelper.trimString(swoDomainDTO.getPlannedInd()))));
		
		map.put(UtilityConstants.DUPLICATE_DELETED_IND, new Boolean(LicenseConstants.DUPLICATE_DELETED_IND.equals(OPPTHelper.trimString(swoDomainDTO.getDuplicateDeletedInd()))));

		// S and S 
		if (UtilityConstants.SANDS_IND.equals(swoDomainDTO.getSAndSInd())) {
			// for s and s licences we should find billied indicator and if it is C we show A to user
			String billedStatus = getBilledInd(swoDomainDTO.getSwoId(), swoDomainDTO.getProposalId());
			if ("C".equals(billedStatus)) {
				map.put(UtilityConstants.SWO_ALREADY_BILLED, new Boolean(true));
			}
		}
		// S and S

		String bumpInd = (swoDomainDTO.getBumpInd() == null) ? "" : swoDomainDTO.getBumpInd();
		boolean bumpIndicator = bumpInd.startsWith(LicenseConstants.LICENSE_BUMPED);
		boolean firstBumpIndicator = false;

		if (bumpIndicator) {
			firstBumpIndicator = bumpInd.equals(LicenseConstants.LICENSE_BUMPED);
		}

		map.put(UtilityConstants.FIRST_BUMP_INDICATOR, new Boolean(firstBumpIndicator));

		map.put(UtilityConstants.BUMP_INDICATOR, new Boolean(bumpIndicator));
		map.put(UtilityConstants.SWO_LOCKED_INDICATOR, new Boolean(UtilityConstants.YES.equalsIgnoreCase(swoDomainDTO.getLockedInd())));

		map.put(UtilityConstants.SWO_FOR_CONTRACT, new Boolean(false));

		if (swoDomainDTO.getPlanStartDate() == null) {
			swoDomainDTO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
		}

		if (swoDomainDTO.getPlanEndDate() == null) {
			swoDomainDTO.setPlanEndDate(dmDomainDTO.getPlanEndDate());
		}

		list.add(swoDomainDTO);

		return swoDomainDTO;
	}

	/**
	 * Gives the print and details SQL  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aProposalID
	 * @param aPageNo
	 * @return Search or Print SQL
	 */
	private String getProposalContractDetailsSQL(int aProposalID, int aPageNo, String aSearchString, boolean isPageCount, boolean mlcLicenses, int mlcExcess, boolean duplicateSerial) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("select ");

		if (isPageCount) {
			buffer.append(" count(*) ");
		} else {
			buffer.append(" c.sold_to_party_id, c.Legacy_Sold_P_No, SUBSTR(c.SAP_SOLD_TO_P_NAME,1,20),");
			buffer.append(" CHAR(c.PLAN_START_DATE,ISO), CHAR(c.PLAN_END_DATE,ISO), d.desg_machine_id, ");
			buffer.append(" d.desg_machine_no, SUBSTR(d.desg_machine_desc,1,20), CHAR(d.PLAN_START_DATE,ISO), ");
			buffer.append(" CHAR(d.PLAN_END_DATE,ISO), s.swo_id, s.swo_no, s.serial_no, SUBSTR(s.swo_desc,1,20),");
			buffer.append(" s.esw_price, s.alt_price, s.calc_price, CHAR(s.PLAN_START_DATE,ISO), ");
			buffer.append(" CHAR(s.PLAN_END_DATE,ISO), s.planned_ind, s.locked_ind, s.alt_price_ind, ");
			buffer.append(" s.exclusion_id, s.bump_ind, d.planned_ind, s.RE_FETCH_ID, s.DELTA_FETCH_ID, ");
			buffer.append(" CHAR(s.AMDT_START_DATE,ISO), CHAR(s.AMDT_END_DATE,ISO), CHAR(d.DM_ADDED_DATE,ISO), ");
			buffer.append(" c.SOLD_TO_P_ASNO, s.item_category, s.proposal_id, s.amdt_ind, ");
			buffer.append(" s.SWO_EXT_CNTR_NUM, s.SWO_CNTR_STATUS, s.SWO_CNTR_TYPE, ");
			buffer.append(" s.REF_SERIAL_NO, s.REF_SER_NO_DESGMC, s.s_s_indicator, s.SWO_ADDED_DATE, s.ALT_PRICE_UPDATE_IND, s.DUPLICATE_DELETED_IND, ");
			buffer.append(" rownumber() over (ORDER BY c.SAP_SOLD_TO_P_NO, d.desg_machine_no, ");
			buffer.append(" s.swo_no, s.serial_no, s.bump_ind) AS ROW_NEXT ");
		}

		buffer.append(" from ((BH.soldtoparty c LEFT OUTER JOIN BH.custdesgmachine d ON ");
		buffer.append(" d.proposal_id = c.proposal_id and d.sold_to_party_id=c.sold_to_party_id) ");
		buffer.append(" LEFT OUTER JOIN BH.systemswo s ON s.proposal_id=d.proposal_id");
		buffer.append(" and s.sold_to_party_id=d.sold_to_party_id and s.desg_machine_id=d.desg_machine_id ) ");
		buffer.append(" where c.proposal_id = ");
		buffer.append(aProposalID);
		// Logic to get the records that matches the given creteria
		if (aSearchString != null && aSearchString.trim().length() > 0) {
			if (!isPageCount) {
				if (mlcLicenses) {
					buffer.append(" AND s.s_s_indicator IS NULL");
				} else {
					buffer.append(" AND s.s_s_indicator = '04' ");
				}
			}
			buffer.append(" AND (c.Legacy_Sold_P_No ");
			buffer.append(getSearchString(aSearchString));
			buffer.append(" OR c.SAP_SOLD_TO_P_NAME ");
			buffer.append(getSearchString(aSearchString));
			buffer.append(" OR c.SOLD_TO_P_ASNO ");
			buffer.append(getSearchString(aSearchString));
			buffer.append(" OR d.desg_machine_no ");
			buffer.append(getSearchString(aSearchString));
			buffer.append(" OR d.desg_machine_desc ");
			buffer.append(getSearchString(aSearchString));
			buffer.append(" OR s.swo_no ");
			buffer.append(getSearchString(aSearchString));
			buffer.append(" OR  s.serial_no ");
			buffer.append(getSearchString(aSearchString));
			buffer.append(" OR s.swo_desc ");
			buffer.append(getSearchString(aSearchString));
			buffer.append(") ");
		} else {

			if (isPageCount && mlcLicenses) {
				buffer.append(" and s.s_s_indicator IS NULL ");
			}
			if (!isPageCount) {
				if (mlcLicenses) {
					buffer.append(" and s.s_s_indicator IS NULL ");
				} else {
					buffer.append(" and s.s_s_indicator = '04' ");
				}
			}
			if(duplicateSerial) {
				buffer.append(" and s.swo_id in (select distinct (s1.swo_id) from BH.systemswo s1,BH.systemswo s2 where s1.serial_no = s2.serial_no and s1.swo_no = s2.swo_no and s1.proposal_id = "+ aProposalID);
				buffer.append(" and s1.proposal_id=s2.proposal_id and s1.swo_id <> s2.swo_id) ");
			}

		}

		/* start change CR6153 */
		try	{
			if (isPageCount == false){
				if(isSandSExtended(aProposalID))
				{
						buffer.append(" order by c.SAP_SOLD_TO_P_NO,d.desg_machine_id, d.desg_machine_no, s.swo_no, s.serial_no, s.bump_ind");
						//buffer.append(" order by c.SAP_SOLD_TO_P_NO, d.desg_machine_no, s.swo_no, s.serial_no, s.bump_ind");
				}
				else
				{
						//buffer.append(" order by c.SAP_SOLD_TO_P_NO,d.desg_machine_id, d.desg_machine_no, s.swo_no, s.serial_no, s.bump_ind");
						buffer.append(" order by c.SAP_SOLD_TO_P_NO, d.desg_machine_no, s.swo_no, s.serial_no, s.bump_ind");
				}
			}
		}
		catch(SQLException se){	
			se.printStackTrace();
		} 		
		/* end change CR6153 */

		// Logic for append the SQL for page resutls
		if (aPageNo > -1 && (isPageCount == false)) {

			if (mlcLicenses) {
				int lastRecord = aPageNo * MAX_RECORDS_PER_PAGE;
				buffer.insert(0, "SELECT * FROM ( ");
				buffer.append(") AS PROPOSALCONTRACT_TEMP WHERE ROW_NEXT BETWEEN ");
				buffer.append((lastRecord - MAX_RECORDS_PER_PAGE + 1));
				buffer.append(" AND ");
				buffer.append(lastRecord);

			} else {
				int lastRecord = 0;
				if (mlcExcess > 0) {
					lastRecord = aPageNo * MAX_RECORDS_PER_PAGE - mlcExcess;
				} else {
					lastRecord = aPageNo * MAX_RECORDS_PER_PAGE;
				}
				int firstRecord = lastRecord - MAX_RECORDS_PER_PAGE + 1;
				if (firstRecord <= 0) {
					firstRecord = 1;
				}
				buffer.insert(0, "SELECT * FROM ( ");
				buffer.append(") AS PROPOSALCONTRACT_TEMP WHERE ROW_NEXT BETWEEN ");
				buffer.append(firstRecord);
				buffer.append(" AND ");
				buffer.append(lastRecord);
			}
		}

		OPPTLogger.debug(buffer.toString(), CLASS_NAME, "getProposalContractDetailsSQL");

		return buffer.toString();
	}

	/* start change CR6153 */
	private boolean isSandSExtended(int proposalId) throws SQLException {
		String extendIndicator = "";
		StringBuffer buf = new StringBuffer();
		buf.append("select S_S_EXTEND_CNTR_IND from BH.proposal where proposal_id = ");
		buf.append(proposalId);

		Statement statement = null;
		ResultSet rs = null;
		if (connection == null) {
			connection = getConnection();
		}
		statement = connection.createStatement();
		rs = statement.executeQuery(buf.toString());
		if (rs.next()) {
			extendIndicator = rs.getString(1);
		}
		if(extendIndicator != null && extendIndicator.equals(UtilityConstants.S_S_EXTEND_PERIOD))
			return true;
		else
			return false;
	}
	/* end change CR6153 */
	
	/** 
	 * Builds specific to the Database and returns the search db string
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aSearchString
	 * @return DB Search String 
	 */
	private String getSearchString(String aSearchString) {
		StringBuffer buffer = new StringBuffer();
		return buffer.append("LIKE \'%").append(aSearchString).append("%\'").toString();
	}

	/**
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 * @throws Exception
	 * @author balajiv
	 */
	public int generateMaxContractNumber() throws Exception {
		int contractNumber = 0;

		if (connection != null) {
			closeConnection();
		}

		ResultSet rs;
		try {
			rs = getStatement().executeQuery("select MAX(SUBSTR(CNTR_NUMBER,1,7)) from BH.Proposal");
			while (rs.next()) {
				contractNumber = rs.getInt(1);
			}
		} catch (SQLException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "generateMaxContractNumber", null, e);
		} finally {
			closeConnection();
		}

		return contractNumber;
	}

	private int[] getPageCount(ResultSet rs) throws SQLException {
		int pageTotalAray[] = new int[2];
		if (rs.next()) {
			pageTotalAray[0] = rs.getInt(1);
			OPPTLogger.debug("Total Records  = " + pageTotalAray[0], "ProposalContractDAO", "getPageCount");
			pageTotalAray[1] = pageTotalAray[0] % MAX_RECORDS_PER_PAGE;
			OPPTLogger.debug("MLC Excess  = " + pageTotalAray[1], "ProposalContractDAO", "getPageCount");
			if (pageTotalAray[0] > 0) {
				int total = pageTotalAray[0] / MAX_RECORDS_PER_PAGE;
				if ((pageTotalAray[0] % MAX_RECORDS_PER_PAGE) > 0) {
					total++;
				}

				pageTotalAray[0] = total;

			}
		}

		return pageTotalAray;
	}

	private ProposalDomainDTO populateProposalDomainDTO(ProposalDomainDTO proposalDTO, int aProposalID, int aPageNo, String aSearchString, int aChoice, boolean mlcLicenses, int mlcExcess,boolean duplicateSerial)
		throws SQLException, ServiceException {
		ResultSet rs = null;
		switch (aChoice) {
			case UtilityConstants.PRINT_PAGE :
				aPageNo = -1;
			case UtilityConstants.GOTO_PAGE :
				rs = getProposalContractDetails(aProposalID, aPageNo, false, mlcLicenses, mlcExcess,duplicateSerial);
				break;

			case UtilityConstants.SEARCH_PAGE :
				rs = getSearchDetailsOfProposalContract(aProposalID, aPageNo, aSearchString, mlcLicenses, mlcExcess,duplicateSerial);
				break;

			default :
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0331);
		}
		return buildProposalDomainDTO(proposalDTO, rs, aProposalID, mlcLicenses);

	}

	/**
	 * @param proposalId
	 * @param planStartDate
	 * @param planEndDate
	 * @throws SQLException
	 */
	public void updatePlanDates(int proposalId, java.sql.Date planStartDate, java.sql.Date planEndDate) throws SQLException {
		if (connection != null) {
			closeConnection();
		}
		connection = getConnection();
		Statement statement = connection.createStatement();
		try {
			int stpUpdated = statement.executeUpdate(getSTPQuery(proposalId, planStartDate, planEndDate));
			int dmUpdated = statement.executeUpdate(getDMQuery(proposalId, planStartDate, planEndDate));
			int swoUpdated = statement.executeUpdate(getSWOQuery(proposalId, planStartDate, planEndDate));
			OPPTLogger.debug("STP :" + stpUpdated + " DM : " + dmUpdated + "SWO :" + swoUpdated + "Updated for proposal " + proposalId, CLASS_NAME, "updatePlanDates");
			statement.close();
		} catch (SQLException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "updatePlanDates", null, e);
			throw e;
		} finally {
			connection.close();
		}
	}

	private String getSTPQuery(int proposalId, java.sql.Date planStartDate, java.sql.Date planEndDate) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("update BH.soldtoparty set plan_start_date = ");
		buffer.append(" '" + cal.getDateString(planStartDate) + "' ");
		buffer.append(", plan_end_date = '" + cal.getDateString(planEndDate) + "' ");
		buffer.append("where proposal_id = " + proposalId);
		return buffer.toString();
	}
	
	private String getDMQuery(int proposalId, java.sql.Date planStartDate, java.sql.Date planEndDate) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update BH.custdesgmachine set plan_start_date = ");
		buffer.append(" '" + cal.getDateString(planStartDate) + "' ");
		buffer.append(", plan_end_date = '" + cal.getDateString(planEndDate) + "' ");
		buffer.append("where proposal_id = " + proposalId);

		return buffer.toString();

	}
	private String getSWOQuery(int proposalId, java.sql.Date planStartDate, java.sql.Date planEndDate) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update BH.systemswo set plan_start_date = ");
		buffer.append(" '" + cal.getDateString(planStartDate) + "' ");
		buffer.append(", plan_end_date = '" + cal.getDateString(planEndDate) + "' ");
		buffer.append("where proposal_id = " + proposalId);

		return buffer.toString();

	}

	private String getBilledInd(int swoId, int proposalId) throws SQLException {

		TimeTaken log = new TimeTaken(CLASS_NAME, "getBilledInd");

		String billingStatus = "";
		StringBuffer buffer = new StringBuffer();
		buffer.append("select BILLING_STATUS from  BH.price where proposal_id = ");
		buffer.append(proposalId);
		buffer.append(" and swo_id = " + swoId);
		Statement statement = null;
		ResultSet rs = null;

		if (connection == null) {
			connection = getConnection();
		}
		statement = connection.createStatement();
		rs = statement.executeQuery(buffer.toString());
		if (rs.next()) {
			billingStatus = rs.getString(1);
		}
		log.end();
		return billingStatus;
	}

	/**
	 * @param proposalId
	 * @return
	 * @throws SQLException
	 */
	public boolean isInventoryPresent(int proposalId) throws SQLException {

		TimeTaken log = new TimeTaken(CLASS_NAME, "isInventoryPresent");
		boolean inventoryPresent = false;
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		buffer.append("select count(*) from  BH.soldtoparty where proposal_id = ");
		buffer.append(proposalId);

		Statement statement = null;
		ResultSet rs = null;

		if (connection == null) {
			connection = getConnection();
		}
		statement = connection.createStatement();
		rs = statement.executeQuery(buffer.toString());
		if (rs.next()) {
			count = rs.getInt(1);
			if (count > 0) {
				inventoryPresent = true;
			}
		}

		rs.close();
		statement.close();
		connection.close();

		log.end();
		return inventoryPresent;
	}
	
	/**
	 * @param proposalId
	 * @return
	 * @throws SQLException
	 */
	public int findNumberOfSWO(int proposalId) throws SQLException {

		boolean inventoryPresent = false;
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		buffer.append("select count(*) from  BH.systemswo where proposal_id = ");
		buffer.append(proposalId);
		Statement statement = null;
		ResultSet rs = null;
		if (connection == null) {
			connection = getConnection();
		}
		statement = connection.createStatement();
		rs = statement.executeQuery(buffer.toString());
		if (rs.next()) {
			count = rs.getInt(1);
		}
		rs.close();
		statement.close();
		connection.close();
		OPPTLogger.debug("Number of swos for proposal "+proposalId+" is "+ count ,CLASS_NAME, "findNumberOfSWO");
		return count;
	}

	/**
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 31, 2004 
	 * 
	 * revision date author reason
	 * 31/05/2004 	 Vinod	New method added as part of changes for EF0527041417 - CMVCDEFECT 354. 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 * @return
	 * @throws SQLException
	 */
	public double getInventoryAtPeriodStart(int proposalId) throws SQLException {
		double inventoryAtPeriodStart = 0;
		
		Connection connection = getConnection();
		PreparedStatement preparedStatement  = connection.prepareStatement(INVENTORY_AT_PERIOD_START);;
		preparedStatement.setInt(1, proposalId);
		ResultSet resultSet = preparedStatement.executeQuery();		

		while(resultSet.next()){	
			inventoryAtPeriodStart = resultSet.getDouble("1");
		}

		closeConnection(connection , resultSet ,preparedStatement);				
		
		return inventoryAtPeriodStart;
	}
	/**
	 * This is for defect 14 in 51x
	 * @param proposalId
	 * @return
	 * @throws SQLException
	 * @author balajiv
	 */
	public String getDefaultCurrencyForSalesOrg(String salesOrg) throws SQLException {
		String currency = "";

		Connection connection = getConnection();
		Statement statement  = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select default_currency from BH.sales_org where sales_org = '"+OPPTHelper.trimString(salesOrg)+"'");		

		while(null != resultSet && resultSet.next()){
			currency = resultSet.getString(1);
		}

		closeConnection(connection , resultSet ,statement);		
	
		return currency;
	}
	
	public String fetchPrimarySalesOrg(String userId) throws SQLException {
		String primarySalesOrg = "";

		Connection connection = getConnection();
		Statement statement  = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select asso_sales_org from BH.userprofile where user_id = '"+userId+"'");		

		while(null != resultSet && resultSet.next()){
			primarySalesOrg = resultSet.getString(1);
		}

		closeConnection(connection , resultSet ,statement);		
	
		return primarySalesOrg;
	}

	
	public static int getMaxContrPeriodVarNo(String contNumber) throws SQLException {
		int maxContrPeriodVarNo = 0;

		Connection connection = getConnection();
		Statement statement  = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select CAST(max(substr(CNTR_NUMBER,9,2)) AS INTEGER)  from BH.proposal where substr(CNTR_NUMBER,1,8)='"+OPPTHelper.trimString(contNumber)+"'");		

		while(null != resultSet && resultSet.next()){
			maxContrPeriodVarNo = resultSet.getInt(1);
		}

		closeConnection(connection , resultSet ,statement);		
	
		return maxContrPeriodVarNo+1;
	}
	
	public static void main(String[] args) throws Exception {
		ProposalContractDAO dao = new ProposalContractDAO();
		//dao.retrieveProposalContractDetails(37, -1, null, 3, -1,false);
	}
}
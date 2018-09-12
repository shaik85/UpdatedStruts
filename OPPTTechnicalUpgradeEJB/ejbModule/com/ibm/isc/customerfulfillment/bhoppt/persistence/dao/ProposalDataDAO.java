/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;


/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 19, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */


public class ProposalDataDAO extends OPPTDAO {

	private Connection connection = null;

	public void populateStaticData() throws Exception {
		if (connection != null) {
			closeConnection();
		}
		long start = System.currentTimeMillis();
		ResultSet rs = null;
		try {
			String query = "SELECT STATUS_CODE,STATUS_DESC FROM BH.STATUS";
			rs = execute(query);
			OPPTStaticDataHolder.proposalStatusMap = buildMap(rs);
			//Added by nomita
			query = "SELECT OPERATION_PERFORMED,DESCRIPTION FROM BH.ACTIONDESCRIPTION";
			rs = execute(query);
			OPPTStaticDataHolder.operationMap = buildMap(rs);
			
			// end
			//Added by Manoj
			query = "SELECT SALES_ORG,SALES_ORG_DESC FROM BH.CPS_SALES_ORG";
			rs = execute(query);
			OPPTStaticDataHolder.cpsSalesorg = buildMap(rs);
			// Manoj end
			query =
				"SELECT BILLING_BLOCK,BILLING_BLOCK_DESC FROM BH.BILLINGBLOCK";
			rs = execute(query);
			OPPTStaticDataHolder.billingBlockMap = buildMap(rs);
			 // BH Wave1 - DAD003 - Complex Contract Identifiers - Begin - Bhanu
			query = "SELECT BLB_TYPE,BLB_DESC FROM BH.BLBINDICATOR";
			rs = execute(query);
			OPPTStaticDataHolder.blbIndicatorMap = buildMap(rs);
			 // BH Wave1 - DAD003 - Complex Contract Identifiers - End - Bhanu
			query = "SELECT BILLING_TYPE,BILLING_DESC FROM BH.BILLINGTYPE";
			rs = execute(query);
			OPPTStaticDataHolder.billingTypeMap = buildMap(rs);
			query =
				"SELECT PAYMENT_TERM,PAYMENT_TERM_DESC FROM BH.PAYMENTTERM";
			rs = execute(query);
			OPPTStaticDataHolder.paymentTermMap = buildMap(rs);
			query = "SELECT CURRENCY_CODE,CURRENCY_NAME FROM BH.CURRENCY";
			rs = execute(query);
			OPPTStaticDataHolder.currencyMap = buildMap(rs);
			query = "SELECT DIVISION_CODE, DIVISION_DESC FROM BH.division";
			rs = execute(query);
			OPPTStaticDataHolder.divisionCodeMap = buildMap(rs);
		/*	commented by Ramesh For distrubution Channel Requirement
		 	query =
				"SELECT DSTR_CHANNEL, DSTR_CHANNEL_DESC FROM BH.dstr_channel";
			rs = execute(query);
			OPPTStaticDataHolder.distributionChannelMap = buildMap(rs);
			*/
			//Added by Ramesh For Distribution Channel
			query =
				"SELECT DSTR_CHANNEL, SALES_GROUP, CHANNEL_ROLE, SUBMITTER_ROLE, DSTR_CHANNEL_DESC FROM BH.dstr_channel";
			rs = execute(query);
			OPPTStaticDataHolder.distributionChannelMap = buildMapForDistributionChannel(rs);
			
			query =
				"SELECT BILLING_FREQ_CODE,BILLING_FREQ_DESC FROM BH.billingfrequency";
			rs = execute(query);
			OPPTStaticDataHolder.billingFreqMap = buildMap(rs);
			query = "SELECT SALES_ORG ,SALES_ORG_DESC FROM BH.sales_org";
			rs = execute(query);
			OPPTStaticDataHolder.salesOrgMap = buildMap(rs);
			query = "SELECT OFFERING_TYPE,OFFERING_DESC FROM BH.offeringtype order by OFFERING_INDEX";
			rs = execute(query);
			OPPTStaticDataHolder.proposalTypeMap = buildMap(rs);
			query = "SELECT ROLE,ROLE_DESC FROM BH.role";
			rs = execute(query);
			OPPTStaticDataHolder.roleMap = buildMap(rs);
			Map contractTypeMap = new HashMap();
			contractTypeMap.put("R", "Replaced");
			contractTypeMap.put("N", "Renewed");
			contractTypeMap.put("A", "Amended");
			contractTypeMap.put("O", "Original");
			contractTypeMap.put("C", "Contract");
			contractTypeMap.put("E", "Extended");
			contractTypeMap.put("V", "Variance");
			OPPTStaticDataHolder.contractTypeMap = contractTypeMap;
			HashMap map = new HashMap();
			//Added By Srinivas-OPPT BH DAD001
		map.put("M","MLC  contract only");
		map.put("S","S&S contract only");
			//map.put("A","MLC and S&S contract");
			
			OPPTStaticDataHolder.sAndSMap = map;
			// Changes Start Added by Sasi R Challa for BaseAgreement 			
			query = "SELECT STATUS_CODE,STATUS_DESC FROM BH.BASTATUS";
			rs = execute(query);
			OPPTStaticDataHolder.baseAgreementStatusMap = buildMap(rs);			
			query = "SELECT COVERAGE_TYPE,COVERAGE_TYPE_DESC FROM BH.COVERAGETYPE";
			rs = execute(query);
			OPPTStaticDataHolder.coverageTypeMap = buildMap(rs);			
			query = "SELECT FORM_NUMBER,FORM_LONG_DESCRIPTION,FORM_SHORT_DESCRIPTION,SALES_ORG FROM BH.FORMNUMBERS";
			rs = execute(query);
			OPPTStaticDataHolder.formNumberMap = buildMapForFormNumbers(rs);		
			query = "SELECT MODIFICATION_TYPE_CODE,MODIFICATION_TYPE_DESC FROM BH.MODIFICATIONTYPES";
			rs = execute(query);
			OPPTStaticDataHolder.modificationTypeMap = buildMap(rs);
			query = "SELECT USER_TYPE,USER_TYPE_DESC FROM BH.USERTYPE";
			rs = execute(query);
			OPPTStaticDataHolder.userTypeMap = buildMap(rs);
			query = "SELECT BA_ROLE,BA_ROLE_DESC FROM BH.BAROLE";
			rs = execute(query);
			OPPTStaticDataHolder.baRoleMap = buildMap(rs);

			// for rol options
			//HashMap rolMap = new HashMap();
			query = "SELECT MODIFICATION_OPTION,MODIFICATION_OPTION_DESC FROM BH.MODIFICATIONOPTIONS";
			rs = execute(query);
			OPPTStaticDataHolder.rolOptionsMap = buildMap(rs);
		/*	rolMap.put("CA","Customer Acceptance");
			rolMap.put("IP","Inspection");
			rolMap.put("DE","Delivery");
			rolMap.put("IN","Installation");
			rolMap.put("OT","Others");*/
			
			HashMap statusMap = new HashMap();
			statusMap.put("","All");
			statusMap.put("A","Active");
			statusMap.put("I","Inactive");
			OPPTStaticDataHolder.statusMap = statusMap;
			
			
			HashMap salesOrgMapForBaseAgreement = new HashMap();
			salesOrgMapForBaseAgreement.put("0147","USA");
			salesOrgMapForBaseAgreement.put("0026","Canada"); 
			OPPTStaticDataHolder.salesOrgMapForBaseAgreement = salesOrgMapForBaseAgreement;
			
			HashMap countryCodeMap = new HashMap();
			countryCodeMap.put("897","United States");
			countryCodeMap.put("649","Canada"); 
			countryCodeMap.put("724","Germany"); 
			OPPTStaticDataHolder.countryCodeMap = countryCodeMap;
			
			
			
			//Changes End

		} catch (Exception err) {
			throw err;
		} finally {
			closeConnection();
		}

	}

	private Statement getStatement() throws SQLException {
		connection = getConnection();
		return connection.createStatement();
	}

	private void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

	private Map buildMap(ResultSet rs) throws SQLException {
		Map map = new HashMap();
		while (rs.next()) {
			map.put(
				OPPTHelper.trimString(rs.getString(1)),
				OPPTHelper.trimString(rs.getString(2)));

		}

		return map;
	}
	
	private Map buildMapForDistributionChannel(ResultSet rs) throws SQLException {
		Map map = new HashMap();
		while (rs.next()) {
			String key = OPPTHelper.trimString(rs.getString(1))+"|"+OPPTHelper.trimString(rs.getString(2))+"|"+
						OPPTHelper.trimString(rs.getString(3)+"|"+OPPTHelper.trimString(rs.getString(4)));
			map.put(
				OPPTHelper.trimString(key),
				OPPTHelper.trimString(rs.getString(5)));

		}

		return map;
	}

	/**
	 * Added by Sasi R Chlla
	 * This method is used to set the form details in the Map
	 * @param rs
	 * @return Map
	 * @throws SQLException
	 */
	private Map buildMapForFormNumbers(ResultSet rs) throws SQLException {
		Map map = new HashMap();
		
		while (rs.next()) {
			   String key = OPPTHelper.trimString(rs.getString(1));
			   StringBuffer valueBuffer = new StringBuffer(key).append("|").append(OPPTHelper.trimString(rs.getString(2)))
			               .append("|").append(OPPTHelper.trimString(rs.getString(3))).append("|")
			               .append(OPPTHelper.trimString(rs.getString(4)));
			   String value = valueBuffer.toString();
			   map.put(
			    OPPTHelper.trimString(key),
			    OPPTHelper.trimString(value));
			 
			  }
			 
			  return map;
	}
	private ResultSet execute(String query) throws SQLException {
		
		ResultSet rs = getStatement().executeQuery(query);
		return rs;
	}
	
}

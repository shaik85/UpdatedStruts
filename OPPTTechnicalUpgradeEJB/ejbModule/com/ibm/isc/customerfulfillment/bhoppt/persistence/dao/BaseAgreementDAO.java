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
import java.sql.Statement;
import java.util.ArrayList;

import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementChangeLogBO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;

/**
 * BaseAgreementDAO
 * @author Administrator
 */
public class BaseAgreementDAO extends OPPTDAO {
	/**
	 * Connection connection
	 */
	
	private Connection connection = null;
	/**
	 * Query BASEAGREEMENTCHANGELOG_FINDBYAGREEMENTID
	 */
	private static final String BASEAGREEMENTCHANGELOG_FINDBYAGREEMENTID = "SELECT CHANGE_ID,AGREEMENT_ID,CREATED_BY,CHANGED_DATE,CHANGED_TIME,CHANGED_DETAILS FROM BH.BASEAGREEMENTCHANGELOG WHERE AGREEMENT_ID = ? ORDER BY CHANGED_DATE DESC,CHANGED_TIME DESC";
	                                                                                                                                                 
	/**
	 * getAllBaseAgreementsBO
	 * @author getAllBaseAgreementsBO
	 * @param agreementNumber
	 * @param formNumber
	 * @param customerNumber
	 * @param enterpriseNumber
	 * @param imageReferenceNumber
	 * @param customerName
	 * @return ArrayList
	 * @throws Exception
	 */
	public ArrayList getAllBaseAgreementsBO(String agreementNumber, String formNumber, String customerNumber, String enterpriseNumber,String imageReferenceNumber,String customerName) throws Exception {
		
		String formNumber1 =null;
		boolean andClause = false;
		ArrayList baseAgreementList = new ArrayList();
		ResultSet rs = null;
		if (connection != null) {
			connection.close();
		}
		StringBuffer queryBuffer = new StringBuffer("SELECT AGREEMENT_ID,AGREEMENT_NUMBER,CUSTOMER_NAME,CUSTOMER_NUMBER,FORM_NUMBER,ENTERPRISE_NUMBER,STATUS_CODE,IMAGE_REFERENCE_NO,INAC,LEGACY_CUSTOMER_NUMBER FROM BH.BASEAGREEMENT WHERE ");
		if(agreementNumber != null) {
			queryBuffer.append (" AGREEMENT_NUMBER = '"+OPPTHelper.toUpperCase(agreementNumber)+"' ");
			andClause = true;
		}
		if(formNumber != null) 
		{	StringBuffer buffer = new StringBuffer();
			boolean queryChange = false;
			char [] chars = formNumber.toCharArray();
			
			for (int i = 0; i < chars.length; ++i)
			{
				if (chars[i] == '*')
				{
					buffer.append("%");
				  queryChange = true; 
				}
				else if (chars[i] == '?')
				{
					buffer.append("_");
					 queryChange = true;
				}
				else
					buffer.append(chars[i]);
			}if(chars[0]=='*' && !(chars[chars.length-1]=='*')){
		        buffer.append('%');
		     }
			
			 formNumber1 = buffer.toString();
			if(andClause) {
				queryBuffer.append (" AND ");
			}
			if(queryChange) {
				queryBuffer.append (" UCASE(FORM_NUMBER) like '"+OPPTHelper.toUpperCase(formNumber1)+"'");
				andClause = true;
			}
			else {
			queryBuffer.append (" FORM_NUMBER = '"+OPPTHelper.toUpperCase(formNumber1)+"' ");
			andClause = true;
			}
		}
		if(customerNumber != null) {
			if(andClause) {
				queryBuffer.append (" AND ");
			}
			queryBuffer.append (" CUSTOMER_NUMBER = '"+OPPTHelper.toUpperCase(customerNumber)+"' ");
			andClause = true;
		}
		if(enterpriseNumber != null) {
			if(andClause) {
				queryBuffer.append (" AND ");
			}
			queryBuffer.append (" ENTERPRISE_NUMBER = '"+OPPTHelper.toUpperCase(enterpriseNumber)+"' ");
			andClause = true;
		}
		if(imageReferenceNumber != null) {
			if(andClause) {
				queryBuffer.append (" AND ");
			}
			queryBuffer.append (" IMAGE_REFERENCE_NO = '"+OPPTHelper.toUpperCase(imageReferenceNumber)+"' ");
			andClause = true;
		}
		/* if(iNAC != null){
			if(andClause) {
				queryBuffer.append (" AND ");
			}
			queryBuffer.append (" INAC = '"+OPPTHelper.toUpperCase(iNAC)+"' ");
			andClause = true;
		} */
		if(customerName != null){
		    StringBuffer buffer = new StringBuffer();
			boolean queryChange = false;
			char [] chars = customerName.toCharArray();
			
			for (int i = 0; i < chars.length; ++i)
			{
				if (chars[i] == '*')
				{
					buffer.append("%");
				  queryChange = true; 
				}
				else if (chars[i] == '?')
				{
					buffer.append("_");
					 queryChange = true;
				}
				else
					buffer.append(chars[i]);
			}if(chars[0]=='*' && !(chars[chars.length-1]=='*')){
		        buffer.append('%');
		     }
			customerName = buffer.toString();
		    
		    if(andClause) {
				queryBuffer.append (" AND ");
			}
			queryBuffer.append (" UCASE(CUSTOMER_NAME) LIKE '"+OPPTHelper.toUpperCase(customerName)+"' ");
			andClause = true;
		}
		/*	if (customerLegacyNumber != null ){
			if(andClause) {
				queryBuffer.append (" AND ");
			}
			queryBuffer.append (" LEGACY_CUSTOMER_NUMBER = '"+OPPTHelper.toUpperCase(customerLegacyNumber)+"' ");
			andClause = true;
		} */
		queryBuffer.append("ORDER BY STATUS_CODE");
		try {
			connection = getConnection();
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(queryBuffer.toString());
			while (rs.next()) {
				BaseAgreementBO baseAgreementBO = new BaseAgreementBO();
				baseAgreementBO.setAgreementId(rs.getInt(1));
				baseAgreementBO.setAgreementNumber(OPPTHelper.trimString(rs.getString(2)));
				baseAgreementBO.setCustomerName(OPPTHelper.trimString(rs.getString(3)));
				baseAgreementBO.setCustomerNumber(OPPTHelper.trimString(rs.getString(4)));
				baseAgreementBO.setFormNumber(OPPTHelper.trimString(rs.getString(5)));
				baseAgreementBO.setEnterpriseNumber(OPPTHelper.trimString(rs.getString(6)));
				baseAgreementBO.setAgreementStatus(OPPTHelper.trimString(rs.getString(7)));
				baseAgreementBO.setImageReferenceNumber(OPPTHelper.trimString(rs.getString(8)));
		      //baseAgreementBO.setInac(OPPTHelper.trimString(rs.getString(9)));
				//baseAgreementBO.setLegacyCustomerNumber(OPPTHelper.trimString(rs.getString(10)));
				baseAgreementList.add(baseAgreementBO);
			}
			
		} catch (Exception err) {
			throw err;
		} finally {
			closeConnection();
		}
		return baseAgreementList;
	}
	/**
	 * getAllBaseAgreementsBO
	 * @author getAllBaseAgreementsBO
	 * @param agreementNumber
	 * @param formNumber
	 * @param customerNumber
	 * @param enterpriseNumber
	 * @param imageReferenceNumber
	 * @param customerName
	 * @return ArrayList
	 * @throws Exception
	 */	
	public ArrayList getBaseAgreementId(String agreementNumber, String salesOrg, String customerNumber, String enterpriseNumber) throws Exception 
	{
	    ArrayList baChangeList = null;
	    boolean andClause = false;
		ResultSet rs = null;
		Statement stmt = null;
		int agreementId = 0;
		BaseAgreementBO baseAgreementBO = new BaseAgreementBO();
		if (connection != null) {
			closeConnection();
		}
		StringBuffer queryBuffer = new StringBuffer("SELECT AGREEMENT_ID FROM BH.BASEAGREEMENT WHERE ");
		
		if(salesOrg != null) {
			queryBuffer.append (" SALES_ORG = '"+OPPTHelper.toUpperCase(salesOrg)+"' ");
			andClause = true;
		}
			
		if(agreementNumber != null) {
			if(andClause) {
				queryBuffer.append (" AND ");
			}
			queryBuffer.append (" AGREEMENT_NUMBER = '"+OPPTHelper.toUpperCase(agreementNumber)+"' ");
			andClause = true;
		}
			
		if(customerNumber != null) {
			if(andClause) {
				queryBuffer.append (" AND ");
			}
			queryBuffer.append (" CUSTOMER_NUMBER = '"+OPPTHelper.toUpperCase(customerNumber)+"' ");
			andClause = true;
		}
			
		if(enterpriseNumber != null) {
			if(andClause) {
				queryBuffer.append (" AND ");
			}
			queryBuffer.append (" ENTERPRISE_NUMBER = '"+OPPTHelper.toUpperCase(enterpriseNumber)+"' ");
			andClause = true;
		}
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(queryBuffer.toString());
			if(rs.next()) {
				agreementId = rs.getInt(1);
			}
			if(agreementId!=0){
			    baChangeList=getAllBAChangeDetailsBO(agreementId,connection);
			}else{
			    
			    throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0807);
			}
			    
			
		} catch (Exception err) {
			throw err;
		} finally {
			OPPTDAO.closeConnection(connection,rs,stmt);
			
		}
		return baChangeList;
	}
	/**
	 * getAllBAChangeDetailsBO
	 * @author getAllBaseAgreementsBO
	 * @param agreementId
	 * @param connection
	 * @return ArrayList
	 * @throws Exception
	 */
	public ArrayList getAllBAChangeDetailsBO(int agreementId,Connection connection) throws Exception {
	    ArrayList baChangeDetailsList = new ArrayList();
	    ResultSet rs = null;
		Statement stmt = null;
		BaseAgreementChangeLogBO baseAgreementChangeLogBO = null;
		PreparedStatement pstmt  = null;
		ResultSet resultSet = null;	
		try {
		    pstmt = connection.prepareStatement(BASEAGREEMENTCHANGELOG_FINDBYAGREEMENTID);
		    pstmt.setInt(1,agreementId);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()){
			    baseAgreementChangeLogBO = new BaseAgreementChangeLogBO();
			    baseAgreementChangeLogBO.setChangeId(resultSet.getInt("CHANGE_ID"));
			    baseAgreementChangeLogBO.setAgreementId(resultSet.getInt("AGREEMENT_ID"));
			    baseAgreementChangeLogBO.setChangedBy(resultSet.getString("CREATED_BY"));
			    baseAgreementChangeLogBO.setChangedDate(resultSet.getDate("CHANGED_DATE"));
			    baseAgreementChangeLogBO.setChangedTime(resultSet.getTime("CHANGED_TIME"));
			    baseAgreementChangeLogBO.setChangedDetails(resultSet.getString("CHANGED_DETAILS"));
			    baChangeDetailsList.add(baseAgreementChangeLogBO);
			}
			
		} catch (Exception err) {
		    err.printStackTrace();
		    throw err;
		} finally {
			OPPTDAO.closeConnection(connection,resultSet,pstmt);
		}
   	return baChangeDetailsList;
	}
	/**
	 * getStatement
	 * @return Statement
	 * @throws SQLException
	 */
	private Statement getStatement() throws SQLException {
		connection = getConnection();
		return connection.createStatement();
	}
	/**
	 * closeConnection
	 * @throws SQLException
	 */
	private void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}
	/**
	 * execute
	 * @param query
	 * @return ResultSet
	 * @throws SQLException
	 */
	private ResultSet execute(String query) throws SQLException {
		ResultSet rs = getStatement().executeQuery(query);
		return rs;
	}
}

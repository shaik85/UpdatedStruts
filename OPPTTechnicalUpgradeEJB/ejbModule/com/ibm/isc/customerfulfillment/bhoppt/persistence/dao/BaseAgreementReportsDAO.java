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
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportDetailCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ContractAttchRptCustomerDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import java.util.HashMap;
import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementReportConstants;
;

/**
 * Dao class to hold methods for baseagreement Report generation
 * @author Gavaskar Bhojan
 */
public class BaseAgreementReportsDAO extends OPPTDAO{
/**
 * query REGD_BASEAGREEMENTS
 * 
 */
private static final String REGD_BASEAGREEMENTS = "SELECT A.ENTERPRISE_NUMBER,A.CUSTOMER_NAME,A.CUSTOMER_NUMBER,A.FORM_NUMBER,B.FORM_SHORT_DESCRIPTION,A.AGREEMENT_NUMBER,A.ACCEPTED_DATE,A.EXPIRATION_DATE,A.CREATED_DATE,A.INAC,A.IS_MODIFIED_AGREEMENT FROM BH.BASEAGREEMENT A,BH.FORMNUMBERS B WHERE A.FORM_NUMBER=B.FORM_NUMBER AND A.SALES_ORG=B.SALES_ORG AND "; 
/**
 * query REGD_BASEAGREEMENTS_BYFORMNO
 * 
 */
private static final String REGD_BASEAGREEMENTS_BYFORMNO = "SELECT A.ENTERPRISE_NUMBER,A.CUSTOMER_NAME,A.CUSTOMER_NUMBER,A.FORM_NUMBER,B.FORM_SHORT_DESCRIPTION,A.AGREEMENT_NUMBER,A.ACCEPTED_DATE,A.EXPIRATION_DATE,A.CREATED_DATE,A.INAC,A.IS_MODIFIED_AGREEMENT FROM BH.BASEAGREEMENT A,BH.FORMNUMBERS B WHERE A.FORM_NUMBER=B.FORM_NUMBER AND A.SALES_ORG=B.SALES_ORG AND A.SALES_ORG=? AND A.STATUS_CODE=? AND A.FORM_NUMBER IN(?) ORDER BY B.FORM_NUMBER";
/**
 * query REGD_MODIFICATIONS
 * 
 */
private static final String REGD_MODIFICATIONS = "SELECT A.AGREEMENT_ID,A.ENTERPRISE_NUMBER,A.CUSTOMER_NAME,A.CUSTOMER_NUMBER,A.FORM_NUMBER,A.AGREEMENT_NUMBER,C.FORM_SHORT_DESCRIPTION,A.ACCEPTED_DATE,A.EXPIRATION_DATE,A.CREATED_DATE AS AGRCREATEDDATE,A.INAC,B.MODIFICATION_TYPE_CODE,B.DETAILS ,B.CREATED_DATE AS MODCREATEDDATE,B.CHANGED_DATE,B.STATUS,B.ROL_END_DATE,B.ROL_START_DATE,B.REVENUE_RECOGNITION,B.MODIFIED_IBM_LETTER_HEAD,B.ACCOUNTING_CONTACT,B.LEGAL_CONTACT,B.AGREEMENT_ID FROM BH.BASEAGREEMENT A,BH.BAMODIFICATIONDETAILS B,BH.FORMNUMBERS C,BH.MODIFICATIONTYPES D WHERE A.AGREEMENT_ID=B.AGREEMENT_ID AND A.SALES_ORG = D.SALES_ORG  AND A.SALES_ORG = C.SALES_ORG AND A.FORM_NUMBER=C.FORM_NUMBER AND B.MODIFICATION_TYPE_CODE=D.MODIFICATION_TYPE_CODE AND ";  
/**
 * query REGD_MODIFICATIONS_BYMODTYPE
 * 
 */
private static final String REGD_MODIFICATIONS_BYMODTYPE = "SELECT A.ENTERPRISE_NUMBER,A.CUSTOMER_NAME,A.CUSTOMER_NUMBER,A.FORM_NUMBER,A.AGREEMENT_NUMBER,C.FORM_SHORT_DESCRIPTION,A.ACCEPTED_DATE,A.EXPIRATION_DATE,A.CREATED_DATE,A.INAC,A.IS_MODIFIED_AGREEMENT,B.MODIFICATION_TYPE_CODE,B.DETAILS ,B.CHANGED_DATE FROM BH.BASEAGREEMENT A,BH.BAMODIFICATIONDETAILS B,BH.FORMNUMBERS C,BH.MODIFICATIONTYPES D WHERE A.AGREEMENT_ID=B.AGREEMENT_ID AND A.SALES_ORG = D.SALES_ORG  AND A.SALES_ORG = C.SALES_ORG AND A.FORM_NUMBER=C.FORM_NUMBER AND B.MODIFICATION_TYPE_CODE=D.MODIFICATION_TYPE_CODE AND A.SALES_ORG=? AND A.STATUS_CODE=? AND D.MODIFICATION_TYPE_CODE =? ORDER BY D.MODIFICATION_TYPE_CODE";

/**
 * Condition to generate complete query for report by form number
 * @param status
 * @author Gavaskar Bhojan
 */
private static String getCondition(String status){
	
    String input = new String();
 	if (status.equals(BaseAgreementReportConstants.ALL)) {
 		input = "A.SALES_ORG="+"?"+"ORDER BY A.CREATED_DATE DESC";	
 	}
 	else if(status.equals(BaseAgreementReportConstants.ACTIVE)){ 
       input = "A.SALES_ORG="+"?"+" AND A.STATUS_CODE="+"?"+"ORDER BY A.CREATED_DATE DESC"; }
 	else {
 		input = "A.SALES_ORG="+"?"+" AND A.STATUS_CODE="+"?"+"ORDER BY A.CREATED_DATE DESC"; }
 	return input;	
}
/**
 * Condition to generate complete query for report by modification types
 * @param status
 * @author Gavaskar Bhojan
 */
 private static String getModificationCondition(String status){
	
    String input = new String();
 	if (status.equals(BaseAgreementReportConstants.ALL)) {
 		input = "A.SALES_ORG="+"?"+"ORDER BY B.CREATED_DATE DESC";
 	}
 	else if(status.equals(BaseAgreementReportConstants.ACTIVE)){ 
       input = "A.SALES_ORG="+"?"+" AND B.STATUS="+"?"+"ORDER BY B.CREATED_DATE DESC"; }
 	else {
 		input = "A.SALES_ORG="+"?"+" AND B.STATUS="+"?"+"ORDER BY B.CREATED_DATE DESC"; }
  	return input;
}
 /**
  * method which generates IN set for SQL Query
  * @param status
  * @author Gavaskar Bhojan
  */
 private static String getSelectedList(String[] list){
 	StringBuffer elements = new StringBuffer();
 	for(int i=0; i < list.length; i++){
  		String element = (String) list[i];
 		elements.append("'").append(element).append("'");
 		if(i != list.length-1 )
 			elements.append(",");
  	}
 	return elements.toString();
 }
 
 
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
 * @param status
 * @param salesOrg
 * @return List 
 */

public static List retriveDataForAllBaseAgreements(String status,String salesOrg)
{	
	BaseAgreementReportCustomDTO baseAgreementReportCustomDTO = new BaseAgreementReportCustomDTO();
	Connection connection = null;
	PreparedStatement preparedStatement  = null;
	ResultSet resultSet = null;		
	List ReportDtoList = new ArrayList();
	try
	{
		connection = getConnection();
		preparedStatement = connection.prepareStatement(REGD_BASEAGREEMENTS+getCondition(status));	
		preparedStatement.setString(1,salesOrg);
		if(!status.equals("")){
			preparedStatement.setString(2,status);
		}
		resultSet = preparedStatement.executeQuery();	
		while(resultSet.next())
		{
			baseAgreementReportCustomDTO = new BaseAgreementReportCustomDTO();	
			baseAgreementReportCustomDTO.setSalesOrg(salesOrg); 
			baseAgreementReportCustomDTO.setStatus(status);
			baseAgreementReportCustomDTO.setAcceptedDate(resultSet.getDate("ACCEPTED_DATE"));
			baseAgreementReportCustomDTO.setAgreementNumber(resultSet.getString("AGREEMENT_NUMBER"));
			baseAgreementReportCustomDTO.setCreatedDate(resultSet.getDate("CREATED_DATE"));
			baseAgreementReportCustomDTO.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
			baseAgreementReportCustomDTO.setEnterpriseNumber(resultSet.getString("ENTERPRISE_NUMBER"));
			baseAgreementReportCustomDTO.setExpirationDate(resultSet.getDate("EXPIRATION_DATE"));
		//	baseAgreementReportCustomDTO.setFormLongDescription(resultSet.getString("FORM_LONG_DESCRIPTION"));
			String formNumber= resultSet.getString("FORM_NUMBER");
			baseAgreementReportCustomDTO.setFormNumber(formNumber.substring(0,formNumber.lastIndexOf("-")));
			baseAgreementReportCustomDTO.setVersionNo( formNumber.substring(formNumber.lastIndexOf("-")+1));
		    baseAgreementReportCustomDTO.setIsModifiedAgreement(resultSet.getString("IS_MODIFIED_AGREEMENT"));
			baseAgreementReportCustomDTO.setFormShortDescription(resultSet.getString("FORM_SHORT_DESCRIPTION"));
			baseAgreementReportCustomDTO.setInac(resultSet.getString("INAC"));
			//baseAgreementReportCustomDTO.setLegacyCustomerNumber(resultSet.getString("LEGACY_CUSTOMER_NUMBER"));
			baseAgreementReportCustomDTO.setCustomerNumber(resultSet.getString("CUSTOMER_NUMBER"));
			ReportDtoList.add(baseAgreementReportCustomDTO);		
		}
	}
	catch(SQLException ex)
	{		
		OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"BaseAgreementReportDAO","retriveDataForAllBaseAgreements",null,ex);
	}	
	finally
	{
		closeConnection(connection , resultSet ,preparedStatement);
	}
	if(ReportDtoList == null || ReportDtoList.size() == 0){
		baseAgreementReportCustomDTO.setSalesOrg(salesOrg); 
	    baseAgreementReportCustomDTO.setStatus(status);
	    ReportDtoList.add(baseAgreementReportCustomDTO);
	}
	return ReportDtoList;
}
/**
 * 
 * Dec 27, 2006
 * retriveDataForAllModifications
 * @param status
 * @param salesOrg
 * @return List
 */
public static List retriveDataForAllModifications(String status,String salesOrg)
{
	Connection connection = null;
	PreparedStatement preparedStatement  = null;
	ResultSet resultSet = null;		
	List resultList = new ArrayList();
	try
	{
		connection = getConnection();
		preparedStatement = connection.prepareStatement(REGD_MODIFICATIONS+getModificationCondition(status));	
		preparedStatement.setString(1,salesOrg);
		if(!status.equals("")){
			preparedStatement.setString(2,status);
		}
		resultSet = preparedStatement.executeQuery();			
		while(resultSet.next())
		{
			BaseAgreementReportDetailCustomDTO customDTO = new BaseAgreementReportDetailCustomDTO();
			customDTO.setSalesOrg(salesOrg); 
			customDTO.setStatus(status);
			customDTO.setAcceptedDate(resultSet.getDate("ACCEPTED_DATE"));
			customDTO.setAgreementNumber(resultSet.getString("AGREEMENT_NUMBER"));
				customDTO.setChangedDate(resultSet.getDate("CHANGED_DATE"));
				customDTO.setCreatedDate(resultSet.getDate("AGRCREATEDDATE"));
				customDTO.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
				customDTO.setEnterpriseNumber(resultSet.getString("ENTERPRISE_NUMBER"));
				customDTO.setExpirationDate(resultSet.getDate("EXPIRATION_DATE"));
				String formNumber= resultSet.getString("FORM_NUMBER");
				customDTO.setVersionNo( formNumber.substring(formNumber.lastIndexOf("-")+1));
				customDTO.setFormNumber(formNumber.substring(0,formNumber.lastIndexOf("-")));
				customDTO.setFormShortDescription(resultSet.getString("FORM_SHORT_DESCRIPTION"));
				customDTO.setInac(resultSet.getString("INAC"));
				customDTO.setCustomerNumber(resultSet.getString("CUSTOMER_NUMBER"));
				customDTO.setModChangedDate(resultSet.getDate("CHANGED_DATE"));
				customDTO.setModCreatedDate(resultSet.getDate("MODCREATEDDATE"));
				customDTO.setDetails(resultSet.getString("DETAILS"));
				customDTO.setModificationTypeCode(resultSet.getString("MODIFICATION_TYPE_CODE"));
				customDTO.setAccountingContact(resultSet.getString("ACCOUNTING_CONTACT"));
				customDTO.setLegalContract(resultSet.getString("LEGAL_CONTACT"));
				customDTO.setAgreementId(resultSet.getInt("AGREEMENT_ID"));
				customDTO.setRevenueRecognition(resultSet.getString("REVENUE_RECOGNITION"));
				customDTO.setStatus(resultSet.getString("STATUS"));
				customDTO.setModifiedLetterHead(resultSet.getString("MODIFIED_IBM_LETTER_HEAD"));
				resultList.add(customDTO);  
		}
		
	}
	catch(SQLException ex)
	{		
		OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"BaseAgreementReportDAO","retriveDataForAllBaseAgreements",null,ex);
	}	
	finally
	{
		closeConnection(connection , resultSet ,preparedStatement);
	}			
	if(resultList == null || resultList.size() == 0){
		BaseAgreementReportDetailCustomDTO customDTO = new BaseAgreementReportDetailCustomDTO();
		customDTO.setSalesOrg(salesOrg); 
		customDTO.setStatus(status);
		resultList.add(customDTO);
	}
	return  resultList;
}	
/**
 * 
 * Dec 27, 2006
 * retriveDataByFormNumbers
 * @param status
 * @param salesOrg
 * @param formNumbers
 * @return List
 */
public static List retriveDataByFormNumbers(String status,String salesOrg,String[] formNumbers)
{
	
	BaseAgreementReportCustomDTO baseAgreementReportCustomDTO = new BaseAgreementReportCustomDTO();
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultSet = null;		
	List ReportDtoList = new ArrayList();
	String REGD_BASEAGREEMENTS_BYFORMNO = null;
	try
	{
		if(!status.equals("")){
			REGD_BASEAGREEMENTS_BYFORMNO = "SELECT A.ENTERPRISE_NUMBER,A.STATUS_CODE,A.CUSTOMER_NAME,A.CUSTOMER_NUMBER,A.FORM_NUMBER,B.FORM_SHORT_DESCRIPTION,A.AGREEMENT_NUMBER,A.ACCEPTED_DATE,A.EXPIRATION_DATE,A.CREATED_DATE,A.INAC,A.IS_MODIFIED_AGREEMENT FROM BH.BASEAGREEMENT A,BH.FORMNUMBERS B WHERE A.FORM_NUMBER=B.FORM_NUMBER AND A.SALES_ORG = B.SALES_ORG AND A.SALES_ORG="+"'"+salesOrg+"'"+" AND A.STATUS_CODE="+"'"+status+"'"+" AND A.FORM_NUMBER IN("+getSelectedList(formNumbers)+") ORDER BY B.FORM_NUMBER";
		}
		else{			
			REGD_BASEAGREEMENTS_BYFORMNO = "SELECT A.ENTERPRISE_NUMBER,A.STATUS_CODE,A.CUSTOMER_NAME,A.CUSTOMER_NUMBER,A.FORM_NUMBER,B.FORM_SHORT_DESCRIPTION,A.AGREEMENT_NUMBER,A.ACCEPTED_DATE,A.EXPIRATION_DATE,A.CREATED_DATE,A.INAC,A.IS_MODIFIED_AGREEMENT FROM BH.BASEAGREEMENT A,BH.FORMNUMBERS B WHERE A.FORM_NUMBER=B.FORM_NUMBER AND A.SALES_ORG = B.SALES_ORG AND A.SALES_ORG="+"'"+salesOrg+"'"+" AND A.FORM_NUMBER IN("+getSelectedList(formNumbers)+") ORDER BY B.FORM_NUMBER";    		
		}
		connection = getConnection();
		stmt = connection.createStatement();
		resultSet =stmt.executeQuery(REGD_BASEAGREEMENTS_BYFORMNO);
		while(resultSet.next())
		{
			baseAgreementReportCustomDTO = new BaseAgreementReportCustomDTO();		
			baseAgreementReportCustomDTO.setSalesOrg(salesOrg); 
			baseAgreementReportCustomDTO.setInputStatus(status);
			baseAgreementReportCustomDTO.setStatus(resultSet.getString("STATUS_CODE"));
			baseAgreementReportCustomDTO.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
			baseAgreementReportCustomDTO.setAcceptedDate(resultSet.getDate("ACCEPTED_DATE"));
			baseAgreementReportCustomDTO.setAgreementNumber(resultSet.getString("AGREEMENT_NUMBER"));
			baseAgreementReportCustomDTO.setCreatedDate(resultSet.getDate("CREATED_DATE"));
			baseAgreementReportCustomDTO.setEnterpriseNumber(resultSet.getString("ENTERPRISE_NUMBER"));
			baseAgreementReportCustomDTO.setExpirationDate(resultSet.getDate("EXPIRATION_DATE"));
			String formNumber= resultSet.getString("FORM_NUMBER");
			baseAgreementReportCustomDTO.setVersionNo( formNumber.substring(formNumber.lastIndexOf("-")+1));
		    baseAgreementReportCustomDTO.setFormNumber(formNumber.substring(0,formNumber.lastIndexOf("-")));
			baseAgreementReportCustomDTO.setFormShortDescription(resultSet.getString("FORM_SHORT_DESCRIPTION"));
			baseAgreementReportCustomDTO.setInac(resultSet.getString("INAC"));
			baseAgreementReportCustomDTO.setIsModifiedAgreement(resultSet.getString("IS_MODIFIED_AGREEMENT"));
			//baseAgreementReportCustomDTO.setLegacyCustomerNumber(resultSet.getString("LEGACY_CUSTOMER_NUMBER"));
			baseAgreementReportCustomDTO.setCustomerNumber(resultSet.getString("CUSTOMER_NUMBER"));
			ReportDtoList.add(baseAgreementReportCustomDTO);		
		}
	}
	catch(SQLException ex)
	{		
		OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"BaseAgreementReportDAO","retriveDataForAllBaseAgreements",null,ex);
	}	
	finally
	{
		closeConnection(connection , resultSet ,stmt);
	}
	if(ReportDtoList == null || ReportDtoList.size() == 0){
		baseAgreementReportCustomDTO.setSalesOrg(salesOrg); 
		baseAgreementReportCustomDTO.setInputStatus(status);
	    ReportDtoList.add(baseAgreementReportCustomDTO);
	}
	return ReportDtoList;
} 
/**
 * 
 * Dec 27, 2006
 * retriveDataByModTypes
 * @param status
 * @param salesOrg
 * @param modTypes
 * @return List
 */

public static List retriveDataByModTypes(String status,String salesOrg,String[] modTypes)
{	
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultSet = null;		
	String REGD_MODIFICATIONS_BYMODTYPE = null;
	List  resultList = new ArrayList();
	try
	{
		if(!status.equals("")){
		REGD_MODIFICATIONS_BYMODTYPE = "SELECT A.AGREEMENT_ID,A.ENTERPRISE_NUMBER,A.CUSTOMER_NAME,A.CUSTOMER_NUMBER,A.FORM_NUMBER,A.AGREEMENT_NUMBER,C.FORM_SHORT_DESCRIPTION,A.ACCEPTED_DATE,A.EXPIRATION_DATE,A.CREATED_DATE AS AGRCREATEDDATE,A.INAC,A.IS_MODIFIED_AGREEMENT,B.MODIFICATION_TYPE_CODE,B.DETAILS ,B.CREATED_DATE AS MODCREATEDDATE,B.STATUS,B.ROL_END_DATE,B.ROL_START_DATE,B.REVENUE_RECOGNITION,B.MODIFIED_IBM_LETTER_HEAD,B.ACCOUNTING_CONTACT,B.LEGAL_CONTACT,B.AGREEMENT_ID FROM BH.BASEAGREEMENT A,BH.BAMODIFICATIONDETAILS B,BH.FORMNUMBERS C,BH.MODIFICATIONTYPES D WHERE A.AGREEMENT_ID=B.AGREEMENT_ID AND A.FORM_NUMBER=C.FORM_NUMBER AND B.MODIFICATION_TYPE_CODE=D.MODIFICATION_TYPE_CODE AND A.SALES_ORG = D.SALES_ORG  AND A.SALES_ORG = C.SALES_ORG AND A.SALES_ORG="+"'"+salesOrg+"'"+" AND B.STATUS="+"'"+status+"'"+" AND D.MODIFICATION_TYPE_CODE IN("+getSelectedList(modTypes)+") ORDER BY D.MODIFICATION_TYPE_CODE ";
		}
		else{			
			REGD_MODIFICATIONS_BYMODTYPE = "SELECT A.AGREEMENT_ID,A.ENTERPRISE_NUMBER,A.CUSTOMER_NAME,A.CUSTOMER_NUMBER,A.FORM_NUMBER,A.AGREEMENT_NUMBER,C.FORM_SHORT_DESCRIPTION,A.ACCEPTED_DATE,A.EXPIRATION_DATE,A.CREATED_DATE AS AGRCREATEDDATE,A.INAC,A.IS_MODIFIED_AGREEMENT,B.MODIFICATION_TYPE_CODE,B.DETAILS ,B.CREATED_DATE AS MODCREATEDDATE,B.STATUS,B.ROL_END_DATE,B.ROL_START_DATE,B.REVENUE_RECOGNITION,B.MODIFIED_IBM_LETTER_HEAD,B.ACCOUNTING_CONTACT,B.LEGAL_CONTACT,B.AGREEMENT_ID FROM BH.BASEAGREEMENT A,BH.BAMODIFICATIONDETAILS B,BH.FORMNUMBERS C,BH.MODIFICATIONTYPES D WHERE A.AGREEMENT_ID=B.AGREEMENT_ID AND A.FORM_NUMBER=C.FORM_NUMBER AND B.MODIFICATION_TYPE_CODE=D.MODIFICATION_TYPE_CODE AND A.SALES_ORG = D.SALES_ORG  AND A.SALES_ORG = C.SALES_ORG AND A.SALES_ORG="+"'"+salesOrg+"'"+" AND D.MODIFICATION_TYPE_CODE IN("+getSelectedList(modTypes)+") ORDER BY D.MODIFICATION_TYPE_CODE ";	
		}
		connection = getConnection();
		stmt = connection.createStatement();
		resultSet =stmt.executeQuery(REGD_MODIFICATIONS_BYMODTYPE);
		while(resultSet.next())
		{
			BaseAgreementReportDetailCustomDTO customDTO = new BaseAgreementReportDetailCustomDTO();
			customDTO.setSalesOrg(salesOrg); 
			customDTO.setInputStatus(status);
			customDTO.setAcceptedDate(resultSet.getDate("ACCEPTED_DATE"));
			customDTO.setAgreementNumber(resultSet.getString("AGREEMENT_NUMBER"));
			customDTO.setCreatedDate(resultSet.getDate("AGRCREATEDDATE"));
			customDTO.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
			customDTO.setEnterpriseNumber(resultSet.getString("ENTERPRISE_NUMBER"));
			customDTO.setExpirationDate(resultSet.getDate("EXPIRATION_DATE"));
			String formNumber= resultSet.getString("FORM_NUMBER");
			customDTO.setVersionNo( formNumber.substring(formNumber.lastIndexOf("-")+1));
			customDTO.setFormNumber(formNumber.substring(0,formNumber.lastIndexOf("-")));
			customDTO.setFormShortDescription(resultSet.getString("FORM_SHORT_DESCRIPTION"));
			customDTO.setCustomerNumber(resultSet.getString("CUSTOMER_NUMBER"));
			customDTO.setModCreatedDate(resultSet.getDate("MODCREATEDDATE"));
			customDTO.setDetails(resultSet.getString("DETAILS"));
			customDTO.setModificationTypeCode(resultSet.getString("MODIFICATION_TYPE_CODE"));
			customDTO.setAccountingContact(resultSet.getString("ACCOUNTING_CONTACT"));
			customDTO.setLegalContract(resultSet.getString("LEGAL_CONTACT"));
			customDTO.setAgreementId(resultSet.getInt("AGREEMENT_ID"));
			customDTO.setRevenueRecognition(resultSet.getString("REVENUE_RECOGNITION"));
			customDTO.setStatus(resultSet.getString("STATUS"));
			customDTO.setModifiedLetterHead(resultSet.getString("MODIFIED_IBM_LETTER_HEAD"));
			resultList.add(customDTO);
		}	
	}
	catch(SQLException ex)
	{		
		OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"BaseAgreementReportDAO","retriveDataForAllBaseAgreements",null,ex);
	}	
	finally
	{
		closeConnection(connection , resultSet ,stmt);
	}			
	if(resultList == null || resultList.size() == 0){
		BaseAgreementReportDetailCustomDTO customDTO = new BaseAgreementReportDetailCustomDTO();
		customDTO.setSalesOrg(salesOrg); 
		customDTO.setInputStatus(status);
		resultList.add(customDTO);
	}
	return  resultList;
}   
}

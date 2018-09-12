/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementChangeLogBO;

/**
 *  BaseAgreementDataDAO
 *  @author Ravi Yandapalli
 */
public class BaseAgreementDataDAO extends OPPTDAO {
	/**
	 *  Connection connection
	 */
	private Connection connection = null;
	/**
	 *  Query FINDMODIFICATIONTYPE_INBASEAGREEMENT
	 */
	private static final String FINDMODIFICATIONTYPE_INBASEAGREEMENT = "SELECT COUNT(*) FROM  BH.BASEAGREEMENT BA,BH.BAMODIFICATIONDETAILS MD WHERE BA.AGREEMENT_ID = MD.AGREEMENT_ID AND BA.SALES_ORG= ? AND MD.MODIFICATION_TYPE_CODE = ?";
	
	/**
	 *  validateModificationType
	 *  @author Ravi Yandapalli
	 *  @param salesOrg
	 *  @param modificationTypeCode
	 *  @return boolean
	 *  @throws Exception
	 */
	public boolean validateModificationType(String salesOrg, String modificationTypeCode) throws Exception {
	    //ArrayList baChangeDetailsList = new ArrayList();
	    boolean value = false;
	    ResultSet rs = null;
		Statement stmt = null;
		BaseAgreementChangeLogBO baseAgreementChangeLogBO = null;
		PreparedStatement pstmt  = null;
		ResultSet resultSet = null;	
		if (connection != null) {
		    connection.close();
		}
		
		try {
		    connection = getConnection();
		    pstmt = connection.prepareStatement(FINDMODIFICATIONTYPE_INBASEAGREEMENT);
		    pstmt.setString(1,salesOrg);
		    pstmt.setString(2,modificationTypeCode);
		 	resultSet = pstmt.executeQuery();
		 	resultSet.next();
		 	int count =  resultSet.getInt(1);
		 	if(count==0){
		 	    value = true;
		 	}
			/*if((resultSet!=null) && resultSet.next()){
			    value = false;
			}else{
			    value = true;
			}
			*/    
			
			
		} catch (Exception err) {
		    err.printStackTrace();
		    throw err;
		} finally {
			OPPTDAO.closeConnection(connection,resultSet,pstmt);
		}
   	return value;
	}
    
}

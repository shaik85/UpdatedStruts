/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.CCMSDataCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;

/**
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CCMSDataDAO extends OPPTDAO {
    
    private Connection connection = null;
    
    private String Key = OPPTPropertiesReader.getEncryptionAlgorithm(); 
    
    private String CCMS_DATA = "SELECT URL,USER_ID,DECRYPT_CHAR(PASSWORD,'"+Key+"') FROM BH.CCMSWEBSERVICE";
    
    public CCMSDataCustomDTO retriveCCMSData() throws Exception {
        CCMSDataCustomDTO customDTO = null;
    	Statement stmt = null;
		ResultSet resultSet = null;	
		if (connection != null) {
		    connection.close();
		}
		try {
		    connection = getConnection();
		    stmt = connection.createStatement();
		    resultSet = stmt.executeQuery(CCMS_DATA);
		    customDTO = new CCMSDataCustomDTO();
		 while(resultSet.next()){
		     customDTO.setURL(OPPTHelper.trimString(resultSet.getString(1)));
		     customDTO.setCCMSUserID(OPPTHelper.trimString(resultSet.getString(2)));
		     customDTO.setPassWord(OPPTHelper.trimString(resultSet.getString(3)));
     		 }
		} catch (Exception err) {
		    err.printStackTrace();
		    throw err;
		} finally {
			OPPTDAO.closeConnection(connection,resultSet,stmt);
		}
    return customDTO;
    }
}

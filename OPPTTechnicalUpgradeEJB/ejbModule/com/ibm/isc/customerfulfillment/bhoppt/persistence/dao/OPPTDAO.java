/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.dao;


import java.sql.*;

import javax.sql.DataSource;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/**
 * @author prakash
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class OPPTDAO {
	
	/**
	 *  
	 * This method retrieves the connection objects from datasource 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 10, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 * @throws SQLException
	 */
	protected static Connection getConnection() throws SQLException {
		Connection connection = null;
		DataSource dataSource = null;
		dataSource = ServiceLocator.getDataSourceFactory().getDataSource();		
		connection = dataSource.getConnection();		
		return connection;
	}

	/**
	 *  Method to Close the ResultSet ,PreparedStatement and Connection object
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param 
	 * @return void
	 *	  
	 */
	protected static void closeConnection(
		Connection connection,
		ResultSet resultSet,
		PreparedStatement preparedStatement) {
		try {	
			if (resultSet != null) {
				resultSet.close();	 		
			}							
			
			preparedStatement.close();
			connection.close();
		} catch (SQLException ex) {
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"OPPTDAO","closeConnection",null,ex);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
					
				if (preparedStatement != null) {
					preparedStatement.close();
				}
					
				if (connection != null) {
					connection.close();
				}
					
			} catch (SQLException ex) {
				ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);

			}
		}
	}

	/**
	 * @param connection
	 * @param resultSet
	 * @param statement
	 */
	protected static void closeConnection(
		Connection connection,
		ResultSet resultSet,
		Statement statement) {
		try {	
			if (resultSet != null) {
				resultSet.close();	 		
			}							
			
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"OPPTDAO","closeConnection",null,ex);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
					
				if (statement != null) {
					statement.close();
				}
					
				if (connection != null) {
					connection.close();
				}
					
			} catch (SQLException ex) {
				ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);

			}
		}
	}
}

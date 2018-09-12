/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dao;

import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/** 
 * Common DAO for the application 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 5, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class UtilityDAO
{
	private static final String CLASS_NAME = "UtilityDAO";  /* NOI18N */  /* NOI18N */

	/**
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public UtilityDAO()
	{
	}
	/**
	 * it's return connection
	 * 
	 * <br/><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *@return Connection
	 *@throws SQLException
	 */
	private Connection getConnection() throws SQLException
	{
		DataSource dataSource = ServiceLocator.getDataSourceFactory().getDataSource();
		return dataSource.getConnection();
	}

	/**
	 * To get the application password for WI 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param applicationID
	 * @param encryption
	 * @return
	 */
	public String getApplicationPassword(String applicationID, String encryption)
	{
		Connection connection = null;
		String password = null;

		try
		{
			connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(getApplicationPasswordSQL(applicationID, encryption));

			if (rs.next())
			{
				password = rs.getString(1);
			}

			rs.close();
			stmt.close();
		}
		catch (SQLException e)
		{
			OPPTLogger.log("SQL_EXCEPTION", OPPTLogger.FATAL, CLASS_NAME, "getApplicationPassword", null, e);  /* NOI18N */  /* NOI18N */
		}
		finally
		{
			try
			{
				if (connection != null)
				{
					connection.close();
				}
			}
			catch (Exception ex)
			{
				OPPTLogger.log("SQL_EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "getApplicationPassword", null, ex);  /* NOI18N */  /* NOI18N */
			}
		}

		return password;
	}

	/**
	 *  
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sessionID
	 * @param userID
	 * @param sessionKey
	 * @param sessionObject
	 * @throws SQLException
	 * @throws IOException
	 */
	public void createSessionData(String sessionID, String userID, String sessionKey, Object sessionObject)
		throws SQLException, IOException
	{
		Connection connection = null;

		try
		{
			connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(getSessionDataInsertSQL());
			stmt.setString(1, sessionID);
			stmt.setString(2, userID);
			stmt.setString(3, sessionKey);

			InputStream input = getInputStream(sessionObject);
			stmt.setBinaryStream(4, input, input.available());

			stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

			if (stmt.executeUpdate() == 1)
			{
				OPPTLogger.debug("Insertion of session data succeeded!", CLASS_NAME, "createSessionData");  /* NOI18N */  /* NOI18N */
			}
			else
			{
				OPPTLogger.debug("Insertion of session data not succeeded!", CLASS_NAME, "createSessionData");  /* NOI18N */  /* NOI18N */
			}

			stmt.close();
		}
		catch (SQLException e)
		{
			throw e;
		}
		finally
		{
			if (connection != null)
			{
				connection.close();
			}
		}
	}

	/**
	 *  
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sessionID
	 * @param userID
	 * @param sessionKey
	 * @return
	 * @throws Exception
	 */
	public Object getSessionData(String sessionID, String userID, String sessionKey) throws Exception
	{
		Connection connection = null;
		Object returnObject = null;

		try
		{
			connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(getSessionDataReadSQL());
			stmt.setString(1, sessionID);
			stmt.setString(2, userID);
			stmt.setString(3, sessionKey);

			ResultSet rs = stmt.executeQuery();

			if (rs.next())
			{
				ObjectInputStream input = new ObjectInputStream(rs.getBinaryStream(1));
				returnObject = input.readObject();
			}
			rs.close();
			stmt.close();

			return returnObject;
		}
		catch (SQLException e)
		{
			throw e;
		}
		finally
		{
			if (connection != null)
			{
				connection.close();
			}
		}
	}

	/**
	 *  
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sessionID
	 * @param userID
	 * @param sessionKey
	 * @throws SQLException
	 */
	public void deleteSessionData(String sessionID, String userID, String sessionKey) throws SQLException
	{
		Connection connection = null;
		Object returnObject = null;

		try
		{
			connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(getSessionDataDeleteSQL());

			stmt.setString(1, sessionID);
			stmt.setString(2, userID);
			stmt.setString(3, sessionKey);

			if (stmt.executeUpdate() == 1)
			{
				OPPTLogger.debug("Deletion of session data succeeded!", CLASS_NAME, "deleteSessionData");  /* NOI18N */  /* NOI18N */
			}
			else
			{
				OPPTLogger.debug("Deletion of session data not succeeded!", CLASS_NAME, "deleteSessionData");  /* NOI18N */  /* NOI18N */
			}

			stmt.close();
		}
		catch (SQLException e)
		{
			throw e;
		}
		finally
		{
			if (connection != null)
			{
				connection.close();
			}
		}

	}

	/**
	 *  
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sessionID
	 * @param userID
	 * @param sessionKey
	 * @param sessionObject
	 * @throws SQLException
	 * @throws IOException
	 */
	public void updateSessionData(String sessionID, String userID, String sessionKey, Object sessionObject)
		throws SQLException, IOException
	{
		Connection connection = null;

		try
		{
			connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(getSessionDataUpdateSQL());

			InputStream input = getInputStream(sessionObject);
			stmt.setBinaryStream(1, input, input.available());
			stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			
			stmt.setString(3, sessionID);
			stmt.setString(4, userID);
			stmt.setString(5, sessionKey);

			if (stmt.executeUpdate() == 1)
			{
				OPPTLogger.debug("Updation of session data succeeded!", CLASS_NAME, "updateSessionData");  /* NOI18N */  /* NOI18N */
			}
			else
			{
				OPPTLogger.debug("Updation of session data not succeeded!", CLASS_NAME, "updateSessionData");  /* NOI18N */  /* NOI18N */
			}

			stmt.close();
		}
		catch (SQLException e)
		{
			throw e;
		}
		finally
		{
			if (connection != null)
			{
				connection.close();
			}
		}
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sessionObject
	 * @return InputStream
	 */
	private InputStream getInputStream(Object sessionObject) throws IOException
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
		objectOutputStream.writeObject(sessionObject);

		return new ByteArrayInputStream(out.toByteArray());
	}

	private void closeConnection(Connection connection) throws SQLException
	{
		if (connection != null)
		{
			connection.close();
		}
	}

	private String getApplicationPasswordSQL(String applicationID, String encryption)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("select decrypt_char(apppasswd, ");  /* NOI18N */
		buffer.append("\'");  /* NOI18N */
		buffer.append(encryption);
		buffer.append("\')  from BH.opptapp where appid = \'");  /* NOI18N */
		buffer.append(applicationID);
		buffer.append("\'");  /* NOI18N */

		return buffer.toString();
	}

	private String getSessionDataInsertSQL()
	{
		return "insert into BH.session values(?, ?, ?, ?, ?)";  /* NOI18N */
	}

	private String getSessionDataReadSQL()
	{
		return "select session_object from BH.session where session_id = ? and user_id = ? and session_key = ?";  /* NOI18N */
	}

	private String getSessionDataDeleteSQL()
	{
		return "delete from BH.session where session_id = ? and user_id = ? and session_key = ?";  /* NOI18N */
	}
	
	private String getSessionDataUpdateSQL()
	{
		return "update BH.session set session_object = ?, update_timestamp = ? where session_id = ? and user_id = ? and session_key = ?";  /* NOI18N */
	}
}
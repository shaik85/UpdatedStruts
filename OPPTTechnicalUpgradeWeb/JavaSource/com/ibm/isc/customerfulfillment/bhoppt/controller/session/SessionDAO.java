/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.controller.session;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
/**
 * DAO class for handling session.
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date Mar 1, 2004
 * 
 * revision date author reason
 * 
 * </PRE>
 * 
 * <br/>
 * 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class SessionDAO {
    private static final String CLASS_NAME = "SessionDAO"; /* NOI18N */
    
    /**
     * Constructor
     * 
     * <br/>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br/>
     *  
     */
    public SessionDAO() {
    }
    
    /**
     * getConnection
     *  
     */
    private Connection getConnection() throws SQLException {
        DataSource dataSource = ServiceLocator.getDataSourceFactory()
        .getDataSource();
        return dataSource.getConnection();
    }
    
    /**
     * createSessionData
     * 
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param sessionID
     * @param userID
     * @param sessionKey
     * @param sessionObject
     * @throws SQLException
     * @throws IOException
     */
    public void createSessionData(String sessionID, String userID,
            String sessionKey, Object sessionObject) throws SQLException,
            IOException {
        // TimeTaken log = new TimeTaken("SessionDAO","createSessionData");
        Connection connection = null;
        PreparedStatement stmt = null;
        
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(getSessionDataInsertSQL());
            stmt.setString(1, sessionID);
            stmt.setString(2, sessionKey);
            stmt.setString(3, userID);
            
            InputStream input = getInputStream(sessionObject);
            stmt.setBinaryStream(4, input, input.available());
            
            stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            
            if (stmt.executeUpdate() != 1) {
                //				OPPTLogger.debug("Insertion of session data not succeeded!",
                // CLASS_NAME, "createSessionData");
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
                stmt.close();
                //				log.end();
            }
        }
    }
    
    /**
     * setSessionData <br>
     * <b>Known Bugs </b> <br>
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004 revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param sessionID
     * @param sessionKey
     * @param sessionObject
     * @throws SQLException
     * @throws java.lang.Exception
     * @param userID
     */
    public void setSessionData(String sessionID, String userID,
            String sessionKey, Object sessionObject) throws Exception {
    	//System.out.println("SessionDAO.setSessionData()");
        if (isKeyPresent(sessionID, sessionKey)) {
            updateSessionData(sessionID, sessionKey, sessionObject);
        } else {
            createSessionData(sessionID, userID, sessionKey, sessionObject);
        }
    }
    
    /**
     * getSessionData
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param sessionID
     * @param sessionKey
     * @return
     * @throws Exception
     */
    public Object getSessionData(String sessionID, String sessionKey)
    throws Exception {
        Connection connection = null;
        Object returnObject = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(getSessionDataReadSQL());
            stmt.setString(1, sessionID);
            stmt.setString(2, sessionKey);
            
            rs = stmt.executeQuery();
            
            if (null != rs && rs.next()) {
                Blob blob = rs.getBlob(1);
                InputStream in = blob.getBinaryStream();
                ObjectInputStream input = new ObjectInputStream(in);
                returnObject = input.readObject();
            }
            return returnObject;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
                rs.close();
                stmt.close();
            }
        }
    }
    
    /**
     * isKeyPresent
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param sessionID
     * @param sessionKey
     * @return
     * @throws Exception
     */
    
    public boolean isKeyPresent(String sessionID, String sessionKey)
    throws Exception {
        boolean keyPresent = false;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Object returnObject = null;
        
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(getSessionDataReadSQL());
            stmt.setString(1, sessionID);
            stmt.setString(2, sessionKey);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                keyPresent = true;
            }
            return keyPresent;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
                rs.close();
                stmt.close();
            }
        }
    }
    
    /**
     * deleteSessionData
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param sessionID
     * @throws SQLException
     */
    public void deleteSessionData(String sessionID) throws SQLException {
        Connection connection = null;
        Object returnObject = null;
        PreparedStatement stmt = null;
        
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(getUserSessionDataDeleteSQL());
            
            stmt.setString(1, sessionID);
            
            if (stmt.executeUpdate() != 1) {
                // OPPTLogger.debug("Deletion of session data not succeeded!",
                // CLASS_NAME, "deleteSessionData");
            }
            
        } catch (SQLException e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
                stmt.close();
            }
        }
        
    }
    
    /**
     * deleteSessionData
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param sessionID
     * @param sessionKey
     * @throws SQLException
     */
    public void deleteSessionData(String sessionID, String sessionKey)
    throws SQLException {
        Connection connection = null;
        Object returnObject = null;
        PreparedStatement stmt = null;
        
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(getSessionDataDeleteSQL());
            
            stmt.setString(1, sessionID);
            stmt.setString(2, sessionKey);
            
            if (stmt.executeUpdate() != 1) {
                // OPPTLogger.debug("Deletion of session data not succeeded!",
                // CLASS_NAME, "deleteSessionData");
            }
            
        } catch (SQLException e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
                stmt.close();
            }
        }
        
    }
    
    /**
     * deleteTempData
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param sessionID
     * @throws SQLException
     */
    public void deleteTempData(String sessionID) throws SQLException {
        Connection connection = null;
        Object returnObject = null;
        PreparedStatement stmt = null;
        
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(getTempDataDeleteSQL());
            stmt.setString(1, sessionID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
                stmt.close();
            }
        }
        
    }
    
    /**
     * deleteSessionData
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @throws SQLException
     */
    
    public void deleteSessionData() throws SQLException {
        Connection connection = null;
        Object returnObject = null;
        PreparedStatement stmt = null;
        
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(getCleanSessionDataSQL());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
                stmt.close();
            }
        }
    }
    
    /**
     * deleteTempData
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @throws SQLException
     */
    public void deleteTempData() throws SQLException {
        Connection connection = null;
        Object returnObject = null;
        PreparedStatement stmt = null;
        
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(getCleanTempDataSQL());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
                stmt.close();
            }
        }
    }
    
    /**
     * updateSessionData
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param sessionID
     * @param sessionKey
     * @param sessionObject
     * @throws SQLException
     * @throws IOException
     */
    public void updateSessionData(String sessionID, String sessionKey,
            Object sessionObject) throws SQLException, IOException {
        Connection connection = null;
        PreparedStatement stmt = null;
      /*System.out.println(" I am called ..."+sessionObject.getClass());
      // if (sessionObject.isInstance(SWODetailsViewBean.class))
     if(sessionObject instanceof SWODetailsViewBean)
        {
        	System.out.println("Hello....CFSW OPPT");
        SWODetailsViewBean swb= (SWODetailsViewBean)sessionObject;
        System.out.println("1. "+swb.getAlternatePrice());
        System.out.println("2. "+swb.getCalculatedPrice());
        if(swb.getAlternatePrice()== 0){
        	System.out.println("SessionDAO.updateSessionData():1:");
        	swb.setAlternatePrice(1000);
        	swb.setCalculatedPrice(1000);
        }
        	
        }*/
     
        try {
            connection = getConnection();
            stmt = connection.prepareStatement(getSessionDataUpdateSQL());
            
            InputStream input = getInputStream(sessionObject);
            stmt.setBinaryStream(1, input, input.available());
            stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            stmt.setString(3, sessionID);
            stmt.setString(4, sessionKey);
            
            if (stmt.executeUpdate() != 1) {
                // OPPTLogger.debug("Updation of session data not succeeded!",
                // CLASS_NAME, "updateSessionData");
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
                stmt.close();
            }
        }
    }
    
    /**
     * getInputStream
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param sessionObject
     * @throws IOException
     * @return
     */
    private InputStream getInputStream(Object sessionObject) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream object = new ObjectOutputStream(out);
        object.writeObject(sessionObject);
        
        return new ByteArrayInputStream(out.toByteArray());
    }
    
    /**
     * closeConnection
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param connection
     * @throws SQLException
     */
    private void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
    /**
     * getSessionDataInsertSQL
     * 
     * @return
     */
    private String getSessionDataInsertSQL() {
        return "insert into BH.session values(?, ?, ?, ?, ?)"; /* NOI18N */
    }
    
    /**
     * getSessionDataReadSQL
     * 
     * @return
     */
    private String getSessionDataReadSQL() {
        return "select session_object from BH.session where session_id = ? and session_key = ?"; /* NOI18N */
    }
    
    /**
     * getSessionDataDeleteSQL
     * 
     * @return
     */
    private String getSessionDataDeleteSQL() {
        return "delete from BH.session where session_id = ? and session_key = ?"; /* NOI18N */
    }
    
    /**
     * getUserSessionDataDeleteSQL
     * 
     * @return
     */
    private String getUserSessionDataDeleteSQL() {
        return "delete from BH.session where session_id = ?"; /* NOI18N */
    }
    
    /**
     * getSessionDataUpdateSQL
     * 
     * @return
     */
    private String getSessionDataUpdateSQL() {
        return "update BH.session set session_object = ?, update_timestamp = ? where session_id = ? and session_key = ?"; /* NOI18N */
    }
    
    /**
     * getTempDataDeleteSQL
     * 
     * @return
     */
    private String getTempDataDeleteSQL() {
        return "delete from BH.temp where SESSION_ID = ?"; /* NOI18N */
    }
    
    /**
     * getCleanTempDataSQL
     * 
     * @return
     */
    private String getCleanTempDataSQL() {
        return "delete from BH.temp"; /* NOI18N */
    }
    
    /**
     * getCleanSessionDataSQL
     * 
     * @return
     */
    private String getCleanSessionDataSQL() {
        return "delete from BH.session"; /* NOI18N */
    }
}
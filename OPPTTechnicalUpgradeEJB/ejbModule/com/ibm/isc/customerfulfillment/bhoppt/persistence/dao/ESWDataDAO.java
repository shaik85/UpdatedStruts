/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dao;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.DuplicateKeyException;
import javax.sql.DataSource;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/** 
 * This DAO responsible for storing,retrieving and deleting the esw data for the
 * particular session 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 10, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar J
 * @version 5.1A 
 */
public class ESWDataDAO extends OPPTDAO {

	private static final int insert = 1;
	private static final int select = 2;
	private static final int delete = 3;

	/**
	 *  
	 * This method stores the esw data 
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
	 * @param sessionId
	 * @param swoConnectorDTOList
	 * @param eeConnectorDTOList
	 * @param priceConnectorList
	 * @throws DomainException
	 */
	public static void storeESWData(String sessionId, ConnectorDTOInterface dtoList, int proposalId, String transAttribute) throws DomainException {
		PreparedStatement preparestatement = null;
		Connection con = null;
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		byte[] bte = null;
		try {
			con = getConnection();
			preparestatement = con.prepareStatement(getInsertSQL());

			preparestatement.setString(1, sessionId);
			preparestatement.setInt(2, proposalId);
			preparestatement.setString(3, transAttribute);
			try {
				ObjectOutputStream objStream = new ObjectOutputStream(bytes);
				objStream.writeObject(dtoList);
				bte = bytes.toByteArray();
				ByteArrayInputStream bytein = new ByteArrayInputStream(bte);
				preparestatement.setBinaryStream(4, bytein, bytein.available());

			} catch (IOException e) {
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ESWDataDAO","storeESWData",null,e);
			} 
			int i = preparestatement.executeUpdate();
			if (i == 1) {
				OPPTLogger.debug("insertion is success", "ESWDataDAO", "storeESWData");
			}
			
			
		} catch (SQLException e) {
			OPPTLogger.debug("insertion is failed", "ESWDataDAO", "storeESWData");
		} finally {
			closeConnection(con, null, preparestatement);
		}

	}

	/**
	 *  
	 * This method retrieves the esw data list form database 
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
	 * @param sessionId
	 * @return
	 * @throws DomainException
	 */
	public static Map retrieveESWData(String sessionId, int proposalId, String transAttribute) throws DomainException {
		PreparedStatement preparestatement = null;
		Connection con = null;
		ResultSet rs = null;
		Map resultMap = new HashMap();
		try {
			con = getConnection();
			preparestatement = con.prepareStatement(getSelectSQL());
			preparestatement.setString(1, sessionId);
			preparestatement.setInt(2, proposalId);
			preparestatement.setString(3, transAttribute);
			rs = preparestatement.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					try {
						Blob blob = rs.getBlob("DTOLIST");
						InputStream in = blob.getBinaryStream();
						ObjectInputStream objin = new ObjectInputStream(in);
						ConnectorDTOInterface dto = (ConnectorDTOInterface) objin.readObject();
						resultMap.put(UtilityConstants.CONNECTOR_DTO, dto);
					} catch (Exception e) {
						OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ESWDataDAO","retrieveESWData",null,e);
					}
				}
			}
		} catch (SQLException e) {
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ESWDataDAO","retrieveESWData",null,e);
			throw new DomainException();
		} finally {
			closeConnection(con, rs, preparestatement);
		}

		return resultMap;
	}

	/**
	 *  
	 * This method deletes the ESW data list for the particular session 
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
	 * @param sessionId
	 * @throws DomainException
	 */
	public static void deleteESWData(String sessionId, int proposalId, String transAttribute) throws DomainException {
		PreparedStatement preparestatement = null;
		Connection con = null;
		try {
			con = getConnection();
			preparestatement = con.prepareStatement(getDeleteSQL(transAttribute));
			preparestatement.setString(1, sessionId);

			if (transAttribute != null) {
				preparestatement.setInt(2, proposalId);
				preparestatement.setString(3, transAttribute);
			}
			preparestatement.execute();

		} catch (SQLException e) {
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ESWDataDAO","deleteESWData",null,e);
			throw new DomainException();
		} finally {
			closeConnection(con, null, preparestatement);
		}

	}

	/**
	 *  
	 * This method returns the insert query 
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
	 * @param sessionId
	 * @param swoConnectorDTOList
	 * @param eeConnectorDTOList
	 * @param pricConnectorDTOList
	 * @return
	 */
	private static String getInsertSQL() {
		StringBuffer insertBuffer = new StringBuffer();
		insertBuffer.append("insert into BH.temp values(?,?,?,?)");
		return insertBuffer.toString();
	}

	/**
	 *  
	 * This method returns select query 
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
	 * @param sessionId
	 * @return
	 */
	private static String getSelectSQL() {
		StringBuffer selectBuffer = new StringBuffer();

		selectBuffer.append("select a.DTOLIST from BH.temp a ");
		selectBuffer.append("where a.SESSION_ID=? ");
		selectBuffer.append("AND a.PROPOSAL_ID=? ");
		selectBuffer.append("AND a.TRANS_ATTRIBUTE=?");

		return selectBuffer.toString();
	}

	/**
	 *  
	 * This method returns delete sql 
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
	 * @param sessionId
	 * @return
	 */
	private static String getDeleteSQL(String transAttribute) {
		StringBuffer deleteBuffer = new StringBuffer();

		deleteBuffer.append("delete from BH.temp a ");
		deleteBuffer.append("where a.SESSION_ID=? ");

		if (transAttribute != null) {
			deleteBuffer.append("AND a.PROPOSAL_ID=? ");
			deleteBuffer.append("AND a.TRANS_ATTRIBUTE=?");
		}

		return deleteBuffer.toString();
	}
	
	/**
	 *  
	 * This method storeInventory 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * <br><PRE> 
	 * date Dec 8, 2010 
	 * 
	 * revision date author reason 
	 * @author Ramesh Gandi
	 * </PRE><br> 
	 * 
	 * @param void
	 * @return
	 */
	public static void storeInventory(int  proposalid ,InventoryCustomDTO inventoryCustomDTO){
		PreparedStatement preparestatement = null;
		Connection con = null;
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		byte[] bte = null;
		try {
			con = getConnection();
			preparestatement = con.prepareStatement(getInvInsertSQL());
			preparestatement.setInt(1, proposalid);
			try {
				ObjectOutputStream objStream = new ObjectOutputStream(bytes);
				objStream.writeObject(inventoryCustomDTO);
				bte = bytes.toByteArray();
				ByteArrayInputStream bytein = new ByteArrayInputStream(bte);
				preparestatement.setBinaryStream(2, bytein, bytein.available());
			} catch (IOException e) {
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ESWDataDAO","storeInventory",null,e);
			}
			int i = preparestatement.executeUpdate();
			OPPTLogger.debug("ExecuteUpdate successfully executed", "ESWDataDAO", "storeInventory");
			if (i == 1) {
				OPPTLogger.debug("insertion is success", "ESWDataDAO", "storeInventory");
			}
		} catch (SQLException e) {
			OPPTLogger.debug(e.getSQLState(), "ESWDataDAO", "storeInventory catch exception");
		} finally {
			closeConnection(con, null, preparestatement);
		}
	}
	
	/**
	 *  
	 * This method returns the delete query 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2010
	 * 
	 * revision date author reason 
	 * @author Ramesh Gandi
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public static InventoryCustomDTO retrieveSelectedInv(int proposalid) throws DomainException {
		PreparedStatement preparestatement = null;
		Connection con = null;
		ResultSet rs = null;
		InventoryCustomDTO inventoryCustomDTO=null;
		try {
			con = getConnection();
			preparestatement = con.prepareStatement("SELECT * FROM BH.SELECTEDINVENTORY WHERE PROPOSAL_ID=?");
			preparestatement.setInt(1, proposalid);
			rs = preparestatement.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					try { 
						Blob blob = rs.getBlob("INVENTORYDTO");
						InputStream in = blob.getBinaryStream();
						ObjectInputStream objin = new ObjectInputStream(in);
						inventoryCustomDTO = (InventoryCustomDTO) objin.readObject();
					} catch (IOException e) {
						OPPTLogger.log(e.getMessage(),OPPTLogger.ERROR,"ESWDataDAO","retrieveESWData catch 1",null,e);
					} catch (Exception e) {
					OPPTLogger.log(e.getMessage(),OPPTLogger.ERROR,"ESWDataDAO","retrieveESWData catch2",null,e);
				}
				}
			}
		} catch (SQLException e) {
			OPPTLogger.log(e.getSQLState(),OPPTLogger.ERROR,"ESWDataDAO","retrieveESWData:catch3",null,e);
		} finally {
			closeConnection(con, rs, preparestatement);
		}
		return inventoryCustomDTO;
	}
	/**
	 *  
	 * This method returns the delete query 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2010
	 * 
	 * revision date author reason 
	 * @author Ramesh Gandi
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public static void deleteSelectedINV(int proposalId) throws DomainException {
		PreparedStatement preparestatement = null;
		Connection con = null;
		try {
			con = getConnection();
			preparestatement = con.prepareStatement("delete from BH.SELECTEDINVENTORY where PROPOSAL_ID=?");
			preparestatement.setInt(1, proposalId);
			preparestatement.execute();
		} catch (SQLException e) {
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"ESWDataDAO","deleteSelectedINV",null,e);
		} finally {
			closeConnection(con, null, preparestatement);
		}
	}
	
	/**
	 *  
	 * This method returns the insert query 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2010
	 * 
	 * revision date author reason 
	 * @author Ramesh Gandi
	 * </PRE><br> 
	 * 
	 * @return
	 */
	private static String getInvInsertSQL() {
		StringBuffer insertBuffer = new StringBuffer();
		insertBuffer.append("insert into BH.selectedinventory values(?,?)");
		return insertBuffer.toString();
	}

	public static void main(String arg[]) throws Exception {

		ESWDataDAO.retrieveESWData("XXXXXXXXXXXXXXXXXXXXXXXXXXXX", 1200, "FP");

	}
}

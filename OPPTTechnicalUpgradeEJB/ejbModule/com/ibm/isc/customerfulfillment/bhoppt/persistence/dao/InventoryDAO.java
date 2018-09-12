/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dao;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.BatchUpdateException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.EEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;


/** 
 * This DAO responsible for storing inventory information and retrieving max id for the table
 *  
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


public class InventoryDAO extends OPPTDAO {
	private static Connection con = null;
	
	private static int maxSWOID = 0;
	private static int maxSWOEEID = 0;
	private static int maxDMID = 0;
	private static int maxPriceOID = 0;
	private static int maxCustomerID = 0;
	
	private static ResultSet getResultSet(String sql) throws SQLException {
		ResultSet rs = null;
		Statement statement = null;
		statement = getStatement();
		rs = statement.executeQuery(sql);

		return rs;
	}

	private static Statement getStatement() throws SQLException {
		Statement statement = null;

		con = getConnection();
		statement = con.createStatement();

		return statement;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public  static int getMaxProposalId() throws SQLException {
		int proposalId = 0;
		String tableName = "BH.PROPOSAL";
		String colName = "PROPOSAL_ID";
		String sql = getSQL(colName, tableName);
		ResultSet rs = getResultSet(sql);
		while (rs.next()) {
			proposalId = rs.getInt(1);
		}
		rs.close();
		con.close();

		return proposalId;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public static int getMaxSoldToPartyId() throws SQLException {
		int customerId = 0;
		String tableName = "BH.SOLDTOPARTY";
		String colName = "SOLD_TO_PARTY_ID";

		String sql = getSQL(colName, tableName);
		ResultSet rs = getResultSet(sql);
		while (rs.next()) {
			customerId = rs.getInt(1);
		}
		rs.close();
		con.close();

		return customerId;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public static int getMaxCustDesgMachineId() throws SQLException {
		int dmId = 0;
		String tableName = "BH.CUSTDESGMACHINE";
		String colName = "DESG_MACHINE_ID";

		String sql = getSQL(colName, tableName);
		
		ResultSet rs = getResultSet(sql);
		while (rs.next()) {
			dmId = rs.getInt(1);
		}
		rs.close();
		con.close();

		return dmId;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public static int getMaxSwoId() throws SQLException {
		int swoId = 0;
		String tableName = "BH.SYSTEMSWO";
		String colName = "SWO_ID";
		String sql = getSQL(colName, tableName);
		ResultSet rs = getResultSet(sql);
		while (rs.next()) {
			swoId = rs.getInt(1);
		}
		rs.close();
		con.close();

		return swoId;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public static int getMaxSwoEEId() throws SQLException {
		int eeId = 0;
		String tableName = "BH.SYSTEMSWOEE";
		String colName = "SWOEE_ID";

		String sql = getSQL(colName, tableName);
		ResultSet rs = getResultSet(sql);
		while (rs.next()) {
			eeId = rs.getInt(1);
		}
		rs.close();
		con.close();

		return eeId;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public static int getMaxPriceId() throws SQLException {
		int priceId = 0;
		String tableName = "BH.PRICE";
		String colName = "PRICE_ID";
		String sql = getSQL(colName, tableName);
		ResultSet rs = getResultSet(sql);
		while (rs.next()) {
			priceId = rs.getInt(1);
		}
		rs.close();
		con.close();

		return priceId;
	}

	private static String getSQL(String columnName, String tableName) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT MAX(");
		buffer.append(columnName);
		buffer.append(") FROM ");
		buffer.append(tableName);

		return buffer.toString();
	}
	
	private static void initMaxId() throws SQLException {
		maxSWOID = getMaxSwoId();
		maxSWOEEID = getMaxSwoEEId();
		maxDMID = getMaxCustDesgMachineId();
		maxPriceOID = getMaxPriceId();
		maxCustomerID = getMaxSoldToPartyId();
	}	

	/**
	 * @param proposalDomainDTO
	 * @throws DomainException
	 */
	public static void storeInventory(ProposalDomainDTO proposalDomainDTO) throws DomainException {
		TimeTaken log = new TimeTaken("InventoryDAO", "storeInventory");
		List customerList = null;
		Statement st = null;
		customerList = proposalDomainDTO.getCustomerDTOList();

		try {
			initMaxId();
			int customerId =  maxCustomerID+1;
			if (customerList != null && customerList.size() > 0) {
				Connection con = getConnection();
				con.setAutoCommit(false);
				st = con.createStatement();
				for (int i = 0; i < customerList.size(); i++) {
					CustomerDomainDTO customerDomianDTO = (CustomerDomainDTO) customerList.get(i);
					if (proposalDomainDTO.isActionAllowed()) {
						customerDomianDTO.setCustomerId(customerId);
						customerDomianDTO.setProposalId(proposalDomainDTO.getProposalId());
						String sql = customerDomianDTO.getSQL();
						OPPTLogger.debug(sql, "InventoryDAO", "storeInventory");

						addStatement(st, sql);
						addDMDomainDTO(customerDomianDTO, st);
						customerId ++;
						maxCustomerID++;
					} else {
						addDMDomainDTO(customerDomianDTO, st);
					}
					st.executeBatch();
					OPPTLogger.debug((i+1)+" th Batch Executed" , "InventoryDAO", "storeInventory");
					st.clearBatch();
				}
				st.close();
				con.close();
				
			}
		}catch(BatchUpdateException b){
			OPPTLogger.debug(b.getMessage(), "InventoryDAO", "storeInventory");
			OPPTLogger.debug(b.getSQLState(), "InventoryDAO", "storeInventory");
			OPPTLogger.debug(b.getMessage(), "InventoryDAO", "storeInventory");
			OPPTLogger.debug(String.valueOf(b.getErrorCode()), "InventoryDAO", "storeInventory");
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		} catch (SQLException sql) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "InventoryDAO", "storeInventory", null, sql);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		log.end();
	}

	private static void addDMDomainDTO(CustomerDomainDTO customerDomainDTO, Statement st) throws SQLException {
		int dmId = maxDMID+1;	
		List dmList = null;

		dmList = customerDomainDTO.getDMDTOList();

		if (dmList != null && dmList.size() > 0) {
			for (int i = 0; i < dmList.size(); i++) {
				DMDomainDTO dmDomainDTO = (DMDomainDTO) dmList.get(i);
				
				dmDomainDTO.setDmId(dmId);
				dmDomainDTO.setCustomerId(customerDomainDTO.getCustomerId());
				dmDomainDTO.setProposalId(customerDomainDTO.getProposalId());
				String sql = dmDomainDTO.getSQL();
				OPPTLogger.debug(sql, "InventoryDAO", "addDMDomainDTO");
				addStatement(st, sql);
				addSWODomainDTO(dmDomainDTO, st);
				dmId++;
				maxDMID++;
			}
			st.executeBatch();
		}

	}

	/**
	 * @param dmDomainDTO
	 * @param st
	 * @throws SQLException
	 */
	public static void addSWODomainDTO(DMDomainDTO dmDomainDTO, Statement st) throws SQLException {
		int swoId = maxSWOID+1;
		List swoList = null;

		swoList = dmDomainDTO.getSWODTOList();
		if (swoList != null && swoList.size() > 0) {
			for (int i = 0; i < swoList.size(); i++) {
				SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
				swoDomainDTO.setSwoId(swoId);
				swoDomainDTO.setDmId(dmDomainDTO.getDmId());
				swoDomainDTO.setCustomerId(dmDomainDTO.getCustomerId());
				swoDomainDTO.setProposalId(dmDomainDTO.getProposalId());
				String sql = swoDomainDTO.getSQL();
				OPPTLogger.debug(sql, "InventoryDAO", "addSWODomainDTO");
				addStatement(st, sql);
				addEEDomainDTO(swoDomainDTO, st);
				
				swoId++;
				maxSWOID++;
			}
			st.executeBatch();
		}
	}

	/**
	 * @param swoDomainDTO
	 * @param st
	 * @throws SQLException
	 */
	public static void addEEDomainDTO(SWODomainDTO swoDomainDTO, Statement st) throws SQLException {
		int eeId = maxSWOEEID +1;
		List eeList = null;
		eeList = swoDomainDTO.getEEDTOList();

		if (eeList != null && eeList.size() > 0) {
			for (int i = 0; i < eeList.size(); i++) {
				EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(i);
				eeDomainDTO.setEeId(eeId);
				eeDomainDTO.setSwoId(swoDomainDTO.getSwoId());
				eeDomainDTO.setDmId(swoDomainDTO.getDmId());
				eeDomainDTO.setCustomerId(swoDomainDTO.getCustomerId());
				eeDomainDTO.setProposalId(swoDomainDTO.getProposalId());
				String sql = eeDomainDTO.getSQL();
				OPPTLogger.debug(sql, "InventoryDAO", "addEEDomainDTO");
				addStatement(st, sql);
				addPriceDomain(eeDomainDTO, st);
				eeId++;
				maxSWOEEID++;
			}
		}

	}

	/**
	 * @param eeDomainDTO
	 * @param st
	 * @throws SQLException
	 */
	public static void addPriceDomain(EEDomainDTO eeDomainDTO, Statement st) throws SQLException {
		int priceId = maxPriceOID +1;
		List priceList = null;

		priceList = eeDomainDTO.getPriceDTOList();

		if (priceList != null && priceList.size() > 0) {
			for (int i = 0; i < priceList.size(); i++) {
				PriceDomainDTO priceDomainDTO = (PriceDomainDTO) priceList.get(i);
				priceDomainDTO.setPriceId(priceId);
				priceDomainDTO.setDmId(eeDomainDTO.getDmId());
				priceDomainDTO.setSwoId(eeDomainDTO.getSwoId());
				priceDomainDTO.setEeId(eeDomainDTO.getEeId());
				priceDomainDTO.setCustomerId(eeDomainDTO.getCustomerId());
				priceDomainDTO.setProposalId(eeDomainDTO.getProposalId());
				String sql = priceDomainDTO.getSQL();
				OPPTLogger.debug(sql, "InventoryDAO", "addPriceDomain");
				addStatement(st, sql);
				priceId++;
				maxPriceOID++;
			}
		}

	}
	
	/*Added by jagdeesh
	 * This method will store selected Inventory details in the proposal Table
	 * 
	 */
	public  void storeSelectedInventory(Object inventoryCustomDTO, String propsalId)throws SQLException, IOException{
		PreparedStatement pstmt=null;
		try{
		con = getConnection();
		 pstmt= con.prepareStatement("update BH.proposal set selected_inv=? where proposal_id=?");
		
         
		 InputStream input = getInputStream(inventoryCustomDTO);
		
		 pstmt.setBinaryStream(1, input, input.available());
		 pstmt.setString(2,propsalId);
	
		 if (pstmt.executeUpdate() != 1) {
            
        }
		 
	    } catch (SQLException e) {
            throw e;
        } 
	    finally {
            if (con != null) {
            	con.close();
                pstmt.close();
            }
        }
	}
		/*
		 * 
		 */
		 private InputStream getInputStream(Object sessionObject) throws IOException {
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        ObjectOutputStream object = new ObjectOutputStream(out);
	        object.writeObject(sessionObject);
	        
	        return new ByteArrayInputStream(out.toByteArray());
	    }
		 
		/*
		 * Added by 
		 */ 
		 public Object getSelectedInventory(String proposalID)
		    throws Exception {
		        Connection connection = null;
		        Object returnObject = null;
		        PreparedStatement stmt = null;
		        ResultSet rs = null;
		        
		        try {
		            connection = getConnection();
		            stmt = connection.prepareStatement("select selected_inv from BH.proposal where proposal_id=?");
		            stmt.setString(1, proposalID);
		          
		            
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
	 * @param st
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static Statement addStatement(Statement st, String sql) throws SQLException {

		st.addBatch(sql);

		return st;
	}

}

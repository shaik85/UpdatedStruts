/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory;


import java.util.Map;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.ESWDataDAO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;


/** 
 * This factory class is responsible delegates the call to DAO class
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


public class ESWDataFactory {
	/**
	 *  
	 * This method returns the ESW data from table 
	 * During fetch ineligible and fetch planned operation 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sessionId
	 * @return
	 * @throws DomainException
	 */
	public Map getESWData(String sessionId,int proposalId,String transAttribute)throws DomainException{
		Map result=null;
		result=ESWDataDAO.retrieveESWData(sessionId,proposalId,transAttribute);
	
	return result; 	
	}

	/**
	 *  
	 * This method stores the ESW data in db2 table 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
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
	public void storeESWData(String sessionId,ConnectorDTOInterface dtoList,int proposalId,String transAttribute)throws DomainException{
	     ESWDataDAO.storeESWData(sessionId,dtoList,proposalId,transAttribute);
	}

	/**
	 *  
	 * This method delete the ESW data stored in back end 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sessionId
	 * @throws DomainException
	 */
	public void deleteESWData(String sessionId,int proposalId,String transAttribute)throws DomainException{
		ESWDataDAO.deleteESWData(sessionId,proposalId,transAttribute);
	}	
	public void storeInventory(int  proposalid ,InventoryCustomDTO inventoryCustomDTO)throws DomainException{
		ESWDataDAO.storeInventory(proposalid,inventoryCustomDTO);
		}
		/**
		 * 
		 * @author administrator
		 *
		 * TODO To change the template for this generated type comment go to
		 * Window - Preferences - Java - Code Style - Code Templates
		 */
		public InventoryCustomDTO retrieveSelectedInv(int  proposalid )throws DomainException{
			return ESWDataDAO.retrieveSelectedInv(proposalid);
			}
		/**
		 * 
		 * @author administrator
		 *
		 * TODO To change the template for this generated type comment go to
		 * Window - Preferences - Java - Code Style - Code Templates
		 */
		public void deleteSelectedINV(int  proposalid )throws DomainException{
			 ESWDataDAO.deleteSelectedINV(proposalid);
			}

}

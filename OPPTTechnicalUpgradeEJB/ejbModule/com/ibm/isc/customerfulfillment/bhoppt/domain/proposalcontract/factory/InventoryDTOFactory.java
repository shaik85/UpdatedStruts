/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory;


import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.InventoryDAO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;


/** 
 * This DTO Factory is responsible for storing inventory information
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


public class InventoryDTOFactory {


/**
 * @param proposalDomainDTO
 * @throws DomainException
 */
public static void storeInventory(ProposalDomainDTO proposalDomainDTO)throws DomainException{
	    InventoryDAO.storeInventory(proposalDomainDTO);
}
}

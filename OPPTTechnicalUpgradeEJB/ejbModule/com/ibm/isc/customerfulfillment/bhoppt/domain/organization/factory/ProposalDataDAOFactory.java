/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory;

import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.ProposalDataDAO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 19, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */
public class ProposalDataDAOFactory {
	private static final String CLASS_NAME="ProposalDataDAOFactory";
	
	public void populateStaticData() throws DomainException {
		ProposalDataDAO proposalDataDAO = new ProposalDataDAO();
		try{
			proposalDataDAO.populateStaticData();
		}catch(Exception ex) {
			throw new DomainException();
		}
		
	}
	

}

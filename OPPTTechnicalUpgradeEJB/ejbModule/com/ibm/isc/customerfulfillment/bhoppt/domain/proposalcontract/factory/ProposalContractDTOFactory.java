/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory;


import java.sql.SQLException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.ProposalContractDAO;


/** 
 * Proposal contract DTO Factory
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 9, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham K Mani
 * @version 5.1A 
 */


public class ProposalContractDTOFactory {
	/**
	 * This method is used to get the details of proposal.
	 * It also supports the print, goto page, and search licenses.
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
	 * @param aProposalID
	 * @param aPageNo
	 * @param aSearchString
	 * @param aChoice
	 * @return Proposal DomainDTO
	 * @throws Exception
	 */
    
    
	public ProposalDomainDTO getProposalContractDomainDTO(
		int aProposalID,
		int aPageNo,
		String aSearchString,
		int aChoice,
		int totalPages,
		int mlcTotal,
		int mlcExcess,
		boolean isSandS,
		String proposalContent,
		boolean duplicateSerial)
		throws Exception {
		ProposalContractDAO proposalContractDAO = new ProposalContractDAO();
		return proposalContractDAO.retrieveProposalContractDetails(aProposalID, aPageNo, aSearchString, aChoice, totalPages, mlcTotal, mlcExcess, isSandS, proposalContent,duplicateSerial);
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public String generateContractNumber() throws Exception {
		ProposalContractDAO proposalContractDAO = new ProposalContractDAO();

		StringBuffer buffer = new StringBuffer();
		buffer.append((proposalContractDAO.generateMaxContractNumber() + 1));

		int padding = 7 - buffer.length();

		for (int i = 0; i < padding; i++) {
			buffer.insert(0, "0");
		}

		buffer.append("P01");

		return buffer.toString();
	}

	/**
	 * @param proposalId
	 * @param planStartDate
	 * @param planEndDate
	 * @throws SQLException
	 */
	public void updatePlanDates(int proposalId, java.sql.Date planStartDate, java.sql.Date planEndDate) throws SQLException {
		ProposalContractDAO proposalContractDAO = new ProposalContractDAO();
		proposalContractDAO.updatePlanDates(proposalId, planStartDate, planEndDate);
	}

	/**
	 * @param proposalId
	 * @return
	 * @throws SQLException
	 */
	public boolean isInventoryPresent(int proposalId) throws SQLException {
		ProposalContractDAO proposalContractDAO = new ProposalContractDAO();
		return proposalContractDAO.isInventoryPresent(proposalId);
	}

	/**
	 * @param proposalId
	 * @return
	 * @throws SQLException
	 */
	public int getSWOCount(int proposalId) throws SQLException {
		ProposalContractDAO proposalContractDAO = new ProposalContractDAO();
		return proposalContractDAO.findNumberOfSWO(proposalId);
	}

	/**
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 31, 2004 
	 * 
	 * revision date author reason 
	 * 31/05/2004 	 Vinod	New method added as part of changes for EF0527041417 - CMVCDEFECT 354. 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 * @return
	 * @throws SQLException
	 */
	public double getInventoryAtPeriodStart(int proposalId) throws SQLException {
		ProposalContractDAO proposalContractDAO = new ProposalContractDAO();
		return proposalContractDAO.getInventoryAtPeriodStart(proposalId);
	}
	
	/**
	 * @param salesOrg
	 * @return
	 * @throws SQLException
	 */
	public String getDefaultCurrencyForSalesOrg(String salesOrg) throws SQLException {
		ProposalContractDAO proposalContractDAO = new ProposalContractDAO();
		return proposalContractDAO.getDefaultCurrencyForSalesOrg(salesOrg);
	}
}
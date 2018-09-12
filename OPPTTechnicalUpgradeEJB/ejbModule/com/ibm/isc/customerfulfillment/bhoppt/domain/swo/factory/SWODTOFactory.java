/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.swo.factory;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CreateContractEEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.SWODAO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ContractTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalContractStatusConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;

/** 
 * 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 19, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class SWODTOFactory
{
	private static final String CLASS_NAME="SWODTOFactory";

	public SWODTOFactory()
	{
	}
	
	/**
	 * To validate the TP 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @param isOriginalProposal
	 * @return
	 * @throws DomainException
	 */	
	public SWODomainDTO validateTPProposal(SWODomainDTO swoDomainDTO) throws DomainException
	{
		SWODAO dao = new SWODAO();
		
		try
		{
			return dao.verifyTPProposalForValidity(swoDomainDTO);
		}
		catch (Exception e)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"validateTPProposal",null,e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}
	
	public static void main(String[] args) throws DomainException
	{

	}
	
	/** 
	 * Retrieves the EE information for contract creation
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposal
	 * @return CreateContractEEDomainDTO[]
	 * @throws DomainException 
	 */
	public CreateContractEEDomainDTO[] retrieveLicensesForContractCreation(ProposalDomainDTO proposal) throws DomainException{
		SWODAO licenseDAO = null;
		
		if(proposal != null){
			licenseDAO = new SWODAO();
			return licenseDAO.retrieveLicensesForContractCreation(proposal);
		}else{
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT,OPPTLogger.ERROR,"SWODTOFactory",
				"retrieveLicensesForContractCreation",null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}
}
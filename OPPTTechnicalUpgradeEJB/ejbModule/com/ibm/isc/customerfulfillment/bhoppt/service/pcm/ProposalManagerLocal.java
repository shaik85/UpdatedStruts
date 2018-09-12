/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import java.util.List;

import javax.ejb.EJBLocalObject;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ReportsDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceRptCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
/** 
 * Local object for ProposalManager
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 18, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham K Mani
 * @version 5.1A 
 */
public interface ProposalManagerLocal extends EJBLocalObject
{

	/* 
	 * This method list the proposals for the report selection
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param reportsCustomDTO		 
	 * @return ReportsCustomDTO
	 */
	public ReportsDomainDTO listProposalsForReport(
		String userId,
		String groupName,
		int role)
		throws ServiceException;
	/* 
	 * This method will get the proposal details
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param reportsCustomDTO		 
	 * @return ReportsCustomDTO
	 */
	public ProposalContractBO getProposal(int proposalId) throws ServiceException;

	/**
	 *  
	 * This method Checks variance for variance report
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param 
	 * @throws ServiceException
	 * @author 
	 * 
	 */
	public void checkVarianceForReport(VarianceRptCustomDTO varianceRptCustomDTO)
		throws ServiceException;
		
	
			
	/**
	 *  
	 * Common method to throw BackendException 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	 
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public List checkForProposalsForCreateApprove(String userId, String role)
		throws ServiceException;
	/**
	 *  
	 * Common method to throw BackendException 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public List checkForProposalsForApproverAndManager(String userId)
		throws ServiceException;
	/**
	 *  
	 * Common method to throw BackendException 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public List checkForProposalsForCSOAndMarkAndManager(
		String userId,
		String role)
		throws ServiceException;
	/** 
	 * To update proposals/contracts locked by = null
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
	 * @param List
	 * @return void  
	 */
	public void updateProposalWithGroupName(String userID,String groupName) throws ServiceException;
	/** 
	 * To Check for certain business rules before removing the userId
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
	 * @param UserCustomDTO
	 * @return UserCustomDTO  
	 */
	public UserCustomDTO checkForRemovingUser(UserCustomDTO userCustom)
		throws ServiceException;
		
	public ProposalDomainDTO [] findProposalsCreatedFromGroup(String userId,String groupName,int role) throws ServiceException ;
}

/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.*;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalDetailsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SSPlanningViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;



/**
 *  
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
 * @author Anshuman Singh
 * @version 5.1A
 */
public class SSPlanningAction extends OPPTLongAction 
{
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
		throws Exception {
		OPPTViewBean viewBean=null;
		ProposalDetailsActionForm actionForm = (ProposalDetailsActionForm)form;
		
		if(null != actionForm)
		{
			if(null != actionForm.getSelectedIds()){
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA35));
				setForwardName(session.getCurrentForward());
			}
			else if(null == actionForm.getSelectedSandSIds()){
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA17));
				setForwardName(session.getCurrentForward());
			}
			else if(checkForCustomerList(actionForm.getSelectedSandSIds())){
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PAF82));
				setForwardName(session.getCurrentForward());
			}
			else{
				SAndSDetailsCustomDTO customDTO = getSSPlanningDetail(session, actionForm.getSelectedSandSIds());
				if(null != customDTO)
				{
					setTransactionInformation(customDTO, session);
					customDTO.setProposal(getCurrentProposal(session));
					customDTO.setConfirmationRequired(true);

					try{
						customDTO = getProposalManager().fetchSAndSDetails(customDTO);
						populateLeftData(customDTO);
						viewBean = new SSPlanningViewBean(customDTO);
						setForwardName(getRole(session));
						setToSession(customDTO, session);
					}
					catch(ServiceException se){
						if(isBackEndError(se.getErrorReport())){
							viewBean = new ErrorViewBean();
							viewBean.setErrorReport(se.getErrorReport());
							setForwardName("error");  //$NON-NLS-1$
						}
						else{
							viewBean = session.getCurrentViewBean();
							viewBean.setErrorReport(se.getErrorReport());
							setForwardName(session.getCurrentForward());
						}
					}
				}
				else{
					viewBean = session.getCurrentViewBean();
					viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PAF17));
					setForwardName(session.getCurrentForward());
				}
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PAF17));
			setForwardName(session.getCurrentForward());
		}

		return viewBean;	
	
			
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return 
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.SS_PLANNING;
	}
	
	
	private void populateLeftData(SAndSDetailsCustomDTO customDto){
		TreeMap leftMap = new TreeMap();
		SAndSEECustomDTO eeCustomDto;
		TreeMap mapFromDto = customDto.getSAndSEEMap();

		Iterator itr = mapFromDto.keySet().iterator();
		while(itr.hasNext()){
			Integer key = (Integer)itr.next();
			eeCustomDto = (SAndSEECustomDTO)mapFromDto.get(key);
			leftMap.put(key.toString(),eeCustomDto.getDescription());
		}
		
		customDto.setLeftDataTree(leftMap);
	}
	
	
	private SAndSDetailsCustomDTO getSSPlanningDetail(OPPTSession session, String selectedIds[]) 
	{
		SAndSDetailsCustomDTO customDTO = null;
	
		if(null != session && null != selectedIds){
			int size = selectedIds.length;
			if(0 < size){
				ProposalDetailsCustomDTO proposalDetails = (ProposalDetailsCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS);
				if(null != proposalDetails)
				{
					for(int i=0; i<size; i++){
						StringTokenizer st = new StringTokenizer(selectedIds[i], Constants.STRING_SEPERATOR);
						if(3 == st.countTokens()){
							SWOCustomDTO swoCustomDTO = getSWO(proposalDetails, st.nextToken().trim(), st.nextToken().trim(), st.nextToken().trim());
							if(null == customDTO){
								customDTO = new SAndSDetailsCustomDTO();
							}
							customDTO.addSWO(swoCustomDTO);
						}
						else if(2 == st.countTokens()){
							DMCustomDTO dmCustomDTO = getDM(proposalDetails, st.nextToken().trim(), st.nextToken().trim());
							if(null == customDTO){
								customDTO = new SAndSDetailsCustomDTO();
							}
							customDTO.addDM(dmCustomDTO);
						}
					}
				}
			}
		}
		return customDTO;
	}
	
	private SWOCustomDTO getSWO(ProposalDetailsCustomDTO proposalDetails, String customerId, String dmId, String swoId) 
	{
		SWOCustomDTO customDTO = null;
		if(null != customerId && null != dmId && null != swoId)
		{
			TreeMap customers = proposalDetails.getSAndSCustomers();
			if(null != customers){
				ProposalCustomerCustomDTO customer = (ProposalCustomerCustomDTO)customers.get(customerId);
				if(null != customer){
					TreeMap dms = customer.getDMs();
					if(null != dms){
						DMCustomDTO dm = (DMCustomDTO)dms.get(dmId);
						if(null != dm){
							TreeMap swos = dm.getSwos();
							if(null != swos){
								customDTO = (SWOCustomDTO)swos.get(swoId);
							}
						}
					}
				}
			}
		}
		return customDTO;
	}
	
	private DMCustomDTO getDM(ProposalDetailsCustomDTO proposalDetails, String customerId, String dmId) 
	{
		DMCustomDTO customDTO = null;
		if(null != customerId && null != dmId)
		{
			TreeMap customers = proposalDetails.getSAndSCustomers();
			if(null != customers){;
				ProposalCustomerCustomDTO customer = (ProposalCustomerCustomDTO)customers.get(customerId);
				if(null != customer){
					TreeMap dms = customer.getDMs();
					if(null != dms){
						customDTO = (DMCustomDTO)dms.get(dmId);
					}
				}
			}
		}
		return customDTO;
	}
	
	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);			
		}
		return currentProposal;
	}
	
	private boolean checkForCustomerList(String [] selectedIds){
		boolean result=false;
		if(null != selectedIds){
			int size = selectedIds.length;
			
			for(int i=0; i<size; i++){
				StringTokenizer st = new StringTokenizer(selectedIds[i], Constants.STRING_SEPERATOR);
				if(1 == st.countTokens()){
					result = true;
				}
			}
		}
		return result;
	}
	
	private void setToSession(SAndSDetailsCustomDTO customDto, OPPTSession session){
		if(null != session){
			session.storeObjectToSession(SessionConstants.SS_PLANNING, customDto);
		}
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_SS_PLANNING);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_SS_PLANNING);
								break;
		}
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Feb 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param session
	 * @return 
	 * 
	 */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		return true;
	}
}

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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SSPlanningActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 12, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */

public class SubmitSSPlanningAction extends OPPTLongAction 
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
			
		ErrorReport errorReport=null;
		
		OPPTViewBean viewBean=null;
		UserInfoDataBean userInfo;
		SAndSPlanningCustomDTO customDto;
		SSPlanningActionForm actionForm;
		
		actionForm = (SSPlanningActionForm)form;
		customDto = new SAndSPlanningCustomDTO();
		setTransactionInformation(customDto, session);
		popolateDto(customDto, actionForm, session);
		
		try {
			getProposalManager().applySAndSDiscount(customDto);
			setForwardName(ForwardNameConstants.ACTION_PROPOSAL_DETAILS);
		}
		catch(ServiceException ex){
			if(isBackEndError(ex.getErrorReport())){
				viewBean = new ErrorViewBean();
				viewBean.setErrorReport(ex.getErrorReport());
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
			else{
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(ex.getErrorReport());
				setForwardName(session.getCurrentForward());
			}
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
		return "SubmitSSPlanningAction";  //$NON-NLS-1$
	}
	
	private void popolateDto(SAndSPlanningCustomDTO customDto, SSPlanningActionForm actionForm, OPPTSession session){
		SAndSDetailsCustomDTO ssCustomDto;
		ProposalCustomDTO currentProposal;
		ArrayList eeCustomDtoList = null;
		SAndSEECustomDTO []eeCustomDtoArray = new SAndSEECustomDTO[0];
		double discountValue=0;
		TreeMap rightSelectData=null;
		String selectedEE;
		TreeMap swoMap=null;

		selectedEE = actionForm.getSwoList();
		discountValue = Double.parseDouble(actionForm.getDiscount());
		ssCustomDto = (SAndSDetailsCustomDTO)session.getObjectFromSession(SessionConstants.SS_PLANNING);
		currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);
		if(null != ssCustomDto){
			swoMap = ssCustomDto.getSAndSEEMap();
			rightSelectData = ssCustomDto.getRightDataTree();		
		}
		
		if(null != swoMap){
			Integer key;
			int counter=0;
			eeCustomDtoList = new ArrayList();
				
			if(null != rightSelectData){
				Iterator itr = rightSelectData.keySet().iterator();
				
				while(itr.hasNext()){
					key = new Integer((String)itr.next());
					eeCustomDtoList.add((SAndSEECustomDTO)swoMap.get(key));
				}
			}
			eeCustomDtoList.add((SAndSEECustomDTO)swoMap.get(new Integer(selectedEE)));
			eeCustomDtoArray = (SAndSEECustomDTO[]) eeCustomDtoList.toArray(eeCustomDtoArray);
		}
		customDto.setSelectedEE(eeCustomDtoArray);
		customDto.setSAndSDiscount(discountValue);
		customDto.setProposal(currentProposal);
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

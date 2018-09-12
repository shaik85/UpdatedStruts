/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SWODetailsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SWODetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EECustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWODetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Action to class to change the swo details.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 20, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ChangeSWODetailsAction extends OPPTLongAction 
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		SWODetailsActionForm actionForm = (SWODetailsActionForm)form;
		
		
		SWODetailsCustomDTO customDTO = getSWODetails(session);
		updateSWODetails(customDTO, actionForm);
		if(null != customDTO){
			setTransactionInformation(customDTO, session);
			
			try{
				getProposalManager().saveSWODetails(customDTO);
				removeSWODetails(session);
				setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
			}
			catch(ServiceException se){
				viewBean = handleServiceException(session, se.getErrorReport());
			}
		}
		else{
			viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA00));
			setForwardName(ForwardNameConstants.PAGE_ERROR);
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
		return ActionNameConstants.CHANGE_SWODETAILS;
	}

	private SWODetailsCustomDTO getSWODetails(OPPTSession session) 
	{
		SWODetailsCustomDTO customDTO = null;
		if(null != session){
			customDTO = (SWODetailsCustomDTO)session.getObjectFromSession(SessionConstants.SWO_DETAILS);
		}
	 	return customDTO;
	}
	private void removeSWODetails(OPPTSession session) 
	{
		if(null != session){
			session.removeObjectFromSession(SessionConstants.SWO_DETAILS);
		}
	}
	
	private SWODetailsCustomDTO updateSWODetails(SWODetailsCustomDTO customDTO, SWODetailsActionForm actionForm){
		if(null != customDTO && null != actionForm){
			//System.out.println("ChangeSWODetailsAction.updateSWODetails()1");
			TreeMap ees = customDTO.getEEs();
			if(null != ees){
				
				String eeIds[] = actionForm.getEeIds();
				String prices[] = actionForm.getAlternatePrices();
				String discount[] = actionForm.getDiscount();
				if(null != eeIds && null != prices){
					int length = eeIds.length;
					if(null == discount){
						//System.out.println("ChangeSWODetailsAction.updateSWODetails()2");
						if(length == prices.length){
							for(int i=0; i<length; i++){
								EECustomDTO ee = (EECustomDTO)ees.get(eeIds[i]);
								ee.setAlternatePrice(getDefaultDoubleValue(prices[i]));
							}
						}
					}
					else{
						//System.out.println("ChangeSWODetailsAction.updateSWODetails()3");
						if(length == prices.length && length == discount.length){
							for(int i=0; i<length; i++){
								EECustomDTO ee = (EECustomDTO)ees.get(eeIds[i]);
								ee.setAlternatePrice(getDefaultDoubleValue(prices[i]));
								ee.setSAndSDiscountPercent(getDefaultDoubleValue(discount[i]));
							}
						}
					}
				}
			}
		}
		return customDTO;
	}

	/**
     * validateCurrentViewContent
     * 
     * @param session
     * @return boolean
     * @author thirumalai
     */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = getCurrentForwardName(getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof SWODetailsViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.SWO_DETAILS);
			if(null != dataStoreEntry && dataStoreEntry instanceof SWODetailsCustomDTO){
				session.setCurrentViewBean(new SWODetailsViewBean((SWODetailsCustomDTO)dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}
		
		return valid;
	}

	private String getCurrentForwardName(int role){
		String currentForwardName = null;
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_SWO_DETAILS;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_SWO_DETAILS;
								break;
		}
		
		return currentForwardName;
	}
	
	private double getDefaultDoubleValue(String stringValue){
		double doubleValue = -1;
		
		if(null != stringValue && 0 < stringValue.trim().length()){
			doubleValue = Double.parseDouble(stringValue);
		}
		
		return doubleValue;
	}
}

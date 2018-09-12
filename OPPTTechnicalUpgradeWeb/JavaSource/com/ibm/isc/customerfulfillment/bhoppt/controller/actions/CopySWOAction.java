/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Map;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CopySWOActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CopySWOViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class CopySWOAction extends OPPTLongAction {
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
		
		CopySWOActionForm actionForm = (CopySWOActionForm)form;
		ErrorReport errorReport = validateInput(actionForm);
		if(null != errorReport && 0 < errorReport.size()){
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(errorReport);
			setForwardName(session.getCurrentForward());
		}
		else{
			CopySWOCustomDTO customDTO = getCopySWO(session);
			customDTO.setTransactionName(getActionName());
			customDTO = getInputData(customDTO, actionForm, session);

			try {
				customDTO = getProposalManager().copySWOInventory(customDTO);
				removeCopySWO(session);
				setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
			}
			catch(ServiceException se){
				viewBean = handleServiceException(session, se.getErrorReport());
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
		return ActionNameConstants.COPY_INVENTORY_SWO;
	}

	private CopySWOCustomDTO getCopySWO(OPPTSession session) {
		CopySWOCustomDTO customDTO = null;
		
		if(null != session){
			customDTO = (CopySWOCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_COPY_INVENTIORY_SWO);
		}
		
		return customDTO;
	}

	private void removeCopySWO(OPPTSession session) {
		if(null != session){
			session.removeObjectFromSession(SessionConstants.SESSION_COPY_INVENTIORY_SWO);
		}
	}

	private CopySWOCustomDTO getInputData(CopySWOCustomDTO customDTO, CopySWOActionForm actionForm, OPPTSession session){
		if(null != actionForm && null != session && null != customDTO)
		{
			String soldToParty = actionForm.getSoldToParty();
			Map soldToPartys = customDTO.getTargetCustomers();
			if(null != soldToPartys && null != soldToParty){
				ProposalCustomerCustomDTO targetCustomer = (ProposalCustomerCustomDTO)soldToPartys.get(soldToParty);
				
				if(null != targetCustomer){
					String dm = actionForm.getDmNumber();
					Map dms = targetCustomer.getDMs();
					if(null != dms && null != dm){
						customDTO.setSelectedTargetDM((DMCustomDTO)dms.get(dm));
					}
				}
			}

			customDTO.setPlanEndDate(actionForm.getPlanEndDate().getDate());
			customDTO.setPlanStartDate(actionForm.getPlanStartDate().getDate());

			DMCustomDTO targetDM = customDTO.getSelectedTargetDM();
			if(null != targetDM){
				if(null == customDTO.getPlanEndDate()){ 
					customDTO.setPlanEndDate(targetDM.getPlanEndDate());
				}
				if(null == customDTO.getPlanStartDate()){
					customDTO.setPlanStartDate(targetDM.getPlanStartDate());
				}
			}
		}
	
		return customDTO;
	}
	
	private ErrorReport validateInput(CopySWOActionForm actionForm){
		ErrorReport errorReport = new ErrorReport();
		
		if(null != actionForm){
			String soldToParty = actionForm.getSoldToParty();
			String dmNumber = actionForm.getDmNumber();
			String dmDescription = actionForm.getDmDescription();
			if(null == soldToParty){
				errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF59, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
			else{
				if(null == dmNumber || dmNumber.equalsIgnoreCase(Constants.DEFAULT_SELECT)){
					errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF73, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
				else{
					if(null != dmDescription && !dmDescription.equalsIgnoreCase(Constants.DEFAULT_SELECT)){
						if(!dmNumber.equalsIgnoreCase(dmDescription)){
							errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF74, OPPTMessageCatalog.TYPE_PRESENTATION), null);
						}
					}
				}
			}
		}
		
		return errorReport;
	}

	
	/** 
	 * Overridden method - Usage of back button is not allowed for this action. So return false. 
	 * 
	 * <br/><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#isBackButtonAllowed() 
	 * @return 
	 * 
	 */
	protected boolean isBackButtonAllowed() {
		return false;
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
			if(viewBean instanceof CopySWOViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.COPY_INVENTORY);
			if(null != dataStoreEntry && dataStoreEntry instanceof CopySWOCustomDTO){
				session.setCurrentViewBean(new CopySWOViewBean((CopySWOCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_COPY_SWO;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_COPY_SWO;
								break;
		}
		
		return currentForwardName;
	}
}
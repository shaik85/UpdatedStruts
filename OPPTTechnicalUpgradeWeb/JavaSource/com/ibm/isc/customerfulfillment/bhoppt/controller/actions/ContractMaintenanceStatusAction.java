/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ContractMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserContractsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ContractMaintenanceStatusAction extends OPPTLongAction 
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
		UserInfoDataBean userInfo=null;
		
		UserContractsCustomDTO customDto = new UserContractsCustomDTO();
		setTransactionInformation(customDto, session);
			
		try {
			//DAD001- Blue Harmony - Changed by Anand Sugumaran
			
			
			
			
			customDto = getProposalManager().listAllContractsOfUser(customDto,false);
			// DAD001- Blue Harmony - Changed by Anand Sugumaran
			
			session.addDataStoreEntry(ActionNameConstants.CONTRACT_MAINTENANCE, customDto);
			saveUserContract(session, customDto);
			viewBean = new ContractMaintenanceViewBean(customDto);
			setForwardName(getRole(session));
		}
		catch(ServiceException ex){
			viewBean = handleErrorReport(ex.getErrorReport());
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
		return ActionNameConstants.CONTRACT_MAINTENANCE;
	}
	

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#isFirstActionOfProcess() 
	 * @return 
	 * 
	 */
	protected boolean isFirstActionOfProcess() {
		return true;
	}
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#getFirstActionForwardName() 
	 * @return 
	 * 
	 */
	protected String getFirstActionForwardName() {
		return ForwardNameConstants.ACTION_CONTRACT_MAINTENANCE_STATUS;
	}

	private void saveUserContract(OPPTSession session, UserContractsCustomDTO dto) {
		if(null != session && null != dto){
			session.storeObjectToSession(SessionConstants.USER_CONTRACT, dto);
		}
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_MAINTENANCE);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CONTRACT_MAINTENANCE);
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

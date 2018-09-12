/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ChangeContractGroupActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ContractMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserContractsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ChangeContractGroupAction extends OPPTLongAction 
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
		UserInfoDataBean userInfo = session.getUserInfo();
		UserContractsCustomDTO customDto = getUserContract(session);
		setTransactionInformation(customDto, session);
		ChangeContractGroupActionForm actionForm = (ChangeContractGroupActionForm)form;
		
		if(null != actionForm){
			if(null != actionForm.getGroupUser() && !"".equals(actionForm.getGroupUser())){  //$NON-NLS-1$
				customDto.getGroupUserInfo().setSelectedUser(actionForm.getGroupUser());
				customDto.getGroupUserInfo().setSelectedGroupName(actionForm.getSelectedGroup());
			}
		}
		
		customDto.setButtonFlags(null);
		
		try {
			
			
		customDto = getProposalManager().listAllContractsOfUser(customDto,false);
			
			
			if(null != customDto.getGroupUserInfo() ) {
				//customDto.getGroupUserInfo().setUserGroups(userInfo.getUserGroups());
				customDto.setUserGroups(userInfo.getUserGroups());				
			}
			viewBean = new ContractMaintenanceViewBean(customDto);
			setForwardName(getRole(session));
			
			saveUserContract(session, customDto);
		}
		catch(ServiceException ex){
			viewBean = new ErrorViewBean();
			viewBean.setErrorReport(ex.getErrorReport());
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
		return "ChangeContractGroupAction";  //$NON-NLS-1$
	}



	private void saveUserContract(OPPTSession session, UserContractsCustomDTO dto) {
		if(null != session && null != dto){
			session.storeObjectToSession(SessionConstants.USER_CONTRACT, dto);
		}
	}

	private UserContractsCustomDTO getUserContract(OPPTSession session){
		UserContractsCustomDTO customDTO = null;
		UserContractsCustomDTO tempDto = null;

		if(null != session){
			customDTO = (UserContractsCustomDTO)session.getObjectFromSession(SessionConstants.USER_CONTRACT);
			customDTO.setContractCustomDTO(null);
			customDTO.setMessageReport(null);
		}
	
		return customDTO;
	}

	private void setForwardName(int role){
		switch(role){
		//DAD-001 BlueHarmony Changed by Anand Sugumaran
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

/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteDuplicateSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteInventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 3, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1x
 */
public class ConfirmDeleteDuplicateSerialAction extends OPPTAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 3, 2003 
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

		session.storeObjectToSession(SessionConstants.DUPLICATE_SERIAL_NUMBERS, new Boolean(false));
		DeleteDuplicateSWOCustomDTO deleteDuplicateSWOCustomDTO = (DeleteDuplicateSWOCustomDTO) session.getObjectFromSession(SessionConstants.MARKED_FOR_DELETION);
		if (deleteDuplicateSWOCustomDTO != null) {
			List swoList = deleteDuplicateSWOCustomDTO.getSwos();
			if (null != swoList && swoList.size() > 0) {
				DeleteInventoryCustomDTO deleteInventoryCustomDTO = new DeleteInventoryCustomDTO();
				setTransactionInformation(deleteInventoryCustomDTO, session);
				deleteInventoryCustomDTO.setProposal(getCurrentProposal(session));
				deleteInventoryCustomDTO.setSwos(swoList);
				try {
					getProposalManager().deleteInventory(deleteInventoryCustomDTO);

				} catch (ServiceException se) {
					viewBean = handleServiceException(session, se.getErrorReport());
				}
			}

		}

		session.removeObjectFromSession(SessionConstants.MARKED_FOR_DELETION);
		setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
		return viewBean;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param session
	 * @return 
	 */

	protected boolean validateCurrentViewContent(OPPTSession session) {
		return true;
	}

	/**
     * setTransactionInformation
     * 
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#setTransactionInformation(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO, com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession)
     * @author thirumalai
     */
    protected void setTransactionInformation(OPPTCustomDTO customDTO, OPPTSession session) {
		if (null != customDTO && null != session) {
			UserInfoDataBean userInfo = session.getUserInfo();
			if (null != userInfo) {
				customDTO.setUserInfo(userInfo.getGroupName(), userInfo.getUserId(), userInfo.getRole(), userInfo.getEmailAddress(), userInfo.getPrimarySalesOrg(),userInfo.getUserGroups());
				customDTO.setFirstName(userInfo.getFirstName());
				customDTO.setLastName(userInfo.getLastName());
			}

			customDTO.setSessionId(session.getSessionId());
			customDTO.setTransactionName(getActionName());
		}
	}

	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		if (null != session) {
			currentProposal = (ProposalCustomDTO) session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);
		}
		return currentProposal;
	}

	/**
     * getActionName
     * 
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#getActionName()
     * @author thirumalai
     */
    protected String getActionName() {
		return ActionNameConstants.CONFIRM_DELETE_DUPLICATE_SERIAL_NUMBER;
	}
}

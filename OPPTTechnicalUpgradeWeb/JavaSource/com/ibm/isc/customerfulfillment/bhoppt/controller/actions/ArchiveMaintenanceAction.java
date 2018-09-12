/*
 * Created on Jul 14, 2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/*
* IBM Confidential
*
* ©  Copyright IBM Corp. 2004, 2005  All Rights Reserved.

* The source code for this program is not published or otherwise divested of
* its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
*/
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ContractMaintenaceDateRangeActionForm;
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
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ArchiveMaintenanceAction extends OPPTLongAction {

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#executeAction(org.apache.struts.action.ActionForm, com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession)
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
			throws Exception {
		OPPTViewBean viewBean=null;
		UserInfoDataBean userInfo=null;
		
		UserContractsCustomDTO customDto = new UserContractsCustomDTO();
		customDto = setDates(customDto, form);
		setTransactionInformation(customDto, session);
		
		//CR 2031
		session.removeObjectFromSession(SessionConstants.DUPLICATE_SERIAL_NUMBERS);
			
		try {
			
			customDto = getProposalManager().listAllContractsOfUser(customDto,true);
			addDataStoreEntry(session, customDto);
			saveUserContract(session, customDto);
			viewBean = new ContractMaintenanceViewBean(customDto);
		//	setForwardName(getRole(session));     //commented by sateesh
			setForwardName(ForwardNameConstants.PAGE_ARCHIVE_CONTRACT);
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
		return ActionNameConstants.ARCHIVE_MAINTENANCE;
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
		return ForwardNameConstants.ARCHIVE_CONTRACT_MAINTENANCE;
	}

	private void saveUserContract(OPPTSession session, UserContractsCustomDTO dto) {
		if(null != session && null != dto){
			session.removeObjectFromSession(SessionConstants.USER_CONTRACT);
			session.storeObjectToSession(SessionConstants.USER_ARCHIVE, dto);
		}
	}

	
	private UserContractsCustomDTO setDates(UserContractsCustomDTO customDto, ActionForm form){
		if(null != form){
			ContractMaintenaceDateRangeActionForm actionForm = (ContractMaintenaceDateRangeActionForm)form;
			customDto.setStartDate(actionForm.getFromDate().getDate());
			customDto.setEndDate(actionForm.getToDate().getDate());
		}
		return customDto;
	}
/* Commented to forward by default Archive page- sateesh
	private void setForwardName(int role){
		
		switch(role){
		
			case Constants.PROPOSAL_CREATE_APPROVER: 
				
				
								setForwardName(ForwardNameConstants.PAGE_ARCHIVE_CONTRACT);
			  					break;
			default:
							//sateesh 	setForwardName(ForwardNameConstants.PAGE_CONTRACT_MAINTENANCE);
								setForwardName(ForwardNameConstants.PAGE_ARCHIVE_CONTRACT);
								break;
		}
	}
	*/

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

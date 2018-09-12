/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ShowIneligibleLicensesActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.IneligibleLicencesViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleLicensesCustomDTO;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 19, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class ShowIneligibleLicensesAction extends OPPTLongAction{

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 19, 2003 
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
		IneligibleLicencesViewBean viewBean = (IneligibleLicencesViewBean)session.getCurrentViewBean();
		
		ShowIneligibleLicensesActionForm actionForm = (ShowIneligibleLicensesActionForm)form;
		if(null != actionForm){
			boolean show = actionForm.isShow();
			
			if(IneligibleLicencesViewBean.MLC_BLOCK == actionForm.getBlock()){
				switch(actionForm.getType()){
					case IneligibleLicensesCustomDTO.EXISTING_CONTRACT_COVERAGE: viewBean.setShowExistingContractCoverage(show);
																				break;
																
					case IneligibleLicensesCustomDTO.LICENSES_FAILING_DUE_TO_DELIVERY_BLOCK_DATE: viewBean.setShowLicensesFailingDueToDeliveryBlockDate(show);
																				break;
																
					case IneligibleLicensesCustomDTO.LICENSES_FAILING_LICENSE_EFFECTIVE_DATE_CHECK: viewBean.setShowLicensesFailingLicenseEffectiveDateCheck(show);
																				break;
																
					case IneligibleLicensesCustomDTO.LICENSES_FAILING_REMOVAL_DATE_CHECK: viewBean.setShowLicensesFailingRemovalDateCheck(show);
																				break;
	
					case IneligibleLicensesCustomDTO.LICENSES_WITH_REJECTION_REASON: viewBean.setShowLicensesWithRejectionReason(show);
																				break;	
																				
					case IneligibleLicensesCustomDTO.LICENSES_FAILING_WITH_SVC: viewBean.setShowLicensesFailingWithSvc(show);
					                                                             break;	
				    default :
                        break;
                }
			}
			else if(IneligibleLicencesViewBean.SANDS_BLOCK == actionForm.getBlock()){
				switch(actionForm.getType()){
					case IneligibleLicensesCustomDTO.EXISTING_CONTRACT_COVERAGE: viewBean.setSandSShowExistingContractCoverage(show);
																				break;
												
					case IneligibleLicensesCustomDTO.LICENSES_FAILING_DUE_TO_DELIVERY_BLOCK_DATE: viewBean.setSandSShowLicensesFailingDueToDeliveryBlockDate(show);
																				break;
												
					case IneligibleLicensesCustomDTO.LICENSES_FAILING_LICENSE_EFFECTIVE_DATE_CHECK: viewBean.setSandSShowLicensesFailingLicenseEffectiveDateCheck(show);
																				break;
												
					case IneligibleLicensesCustomDTO.LICENSES_FAILING_REMOVAL_DATE_CHECK: viewBean.setSandSShowLicensesFailingRemovalDateCheck(show);
																				break;

					case IneligibleLicensesCustomDTO.LICENSES_WITH_REJECTION_REASON: viewBean.setSandSShowLicensesWithRejectionReason(show);
																				break;	
																				
					case IneligibleLicensesCustomDTO.LICENSES_FAILING_WITH_SVC: viewBean.setSandSShowLicensesFailingWithSvc(show);
					                                                            break;
				    default :
                        break;
                }
			}
			
		}
		setForwardName(session.getCurrentForward());
		
		return viewBean;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#getActionName() 
	 * @return 
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.SHOW_INELIGIBLE_LICENSES;
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
			if(viewBean instanceof IneligibleLicencesViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.INELIGIBLE_LICENSES);
			if(null != dataStoreEntry && dataStoreEntry instanceof IneligibleLicensesCustomDTO){
				session.setCurrentViewBean(new IneligibleLicencesViewBean((IneligibleLicensesCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_INELIGIBLE_LICENSES;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_INELIGIBLE_LICENSES;
								break;
		}
		
		return currentForwardName;
	}
}
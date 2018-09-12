/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.IneligibleLicensesActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.IneligibleLicencesViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleLicensesCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class SubmitIneligibleLicensesAction extends OPPTLongAction {
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
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception 
	{
		OPPTViewBean viewBean = null;
		
		IneligibleLicensesActionForm actionForm = (IneligibleLicensesActionForm)form;
		if(null != form){
			String selectedLicenseIds[] = actionForm.getSelectedLicensesIds();
			if(null != selectedLicenseIds && 0<selectedLicenseIds.length){
				IneligibleLicensesCustomDTO customDTO = getIneligibleLicences(session);
				getSelectedIneligibleLicenses(customDTO, selectedLicenseIds);

				try {
					customDTO = getProposalManager().addIneligibleInventoryToProposal(customDTO);
					ErrorReport errorReport = null;
					errorReport = customDTO.getMessageReport();
					if(null == errorReport){
						removeIneligibleLicenses(session);
						setForwardName(ForwardNameConstants.ACTION_PRICE_PROPOSAL);
					}
					else{
						viewBean = new MessageViewBean();
						viewBean.setErrorReport(errorReport);
						setForwardName(ForwardNameConstants.PAGE_MESSAGE);
					}
				}
				catch(ServiceException se){
					viewBean = handleServiceException(session, se.getErrorReport());
				}
			}
			else{
				removeIneligibleLicenses(session);
				setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
			}
		}
		else{
			removeIneligibleLicenses(session);
			setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
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
		return ActionNameConstants.SUBMIT_INELIGIBLE_LICENSES;
	}

	private IneligibleLicensesCustomDTO getIneligibleLicences(OPPTSession session){
		IneligibleLicensesCustomDTO customDTO = null;
		if(null != session){
			customDTO = (IneligibleLicensesCustomDTO)session.getObjectFromSession(SessionConstants.INELIGIBLE_LICENSES);
		}
		return customDTO;
	}
	
	private IneligibleLicensesCustomDTO getSelectedIneligibleLicenses(IneligibleLicensesCustomDTO customDTO, String []selectedIds){
		if(null != customDTO && selectedIds != null)
		{
			TreeMap licenseFailingLicenseEffectiveDate = new TreeMap();
			TreeMap licenseFailingDueToDeliveryBlockDate = new TreeMap();
			TreeMap sAndSlicenseFailingLicenseEffectiveDate = new TreeMap();
			TreeMap sAndSlicenseFailingDueToDeliveryBlockDate = new TreeMap();
			
			for(int i=0, size=selectedIds.length; i<size; i++)
			{
				StringTokenizer st = new StringTokenizer(selectedIds[i], Constants.STRING_SEPERATOR_PLUS);
				if(null != st)
				{
					if(2 == st.countTokens())
					{
						int type = -1;
						try
						{
							type = Integer.parseInt(st.nextToken().trim());
						}
						catch(Exception e){}
						String selectedId = st.nextToken().trim();
						switch(type){
							case IneligibleLicensesCustomDTO.LICENSES_FAILING_LICENSE_EFFECTIVE_DATE_CHECK:
										getSelectedIneligbleLicense(customDTO.getLicensesFailingLicenseEffectiveDateCheck(), licenseFailingLicenseEffectiveDate, selectedId);
										break;
				
							case IneligibleLicensesCustomDTO.LICENSES_FAILING_DUE_TO_DELIVERY_BLOCK_DATE:
										getSelectedIneligbleLicense(customDTO.getLicensesFailingDueToDeleveryBlockDate(), licenseFailingDueToDeliveryBlockDate, selectedId);
										break;
							case IneligibleLicensesCustomDTO.S_AND_S_LICENSES_FAILING_LICENSE_EFFECTIVE_DATE_CHECK:
										getSelectedIneligbleLicense(customDTO.getSAndSLicensesFailingLicenseEffectiveDateCheck(), sAndSlicenseFailingLicenseEffectiveDate, selectedId);
										break;
				
							case IneligibleLicensesCustomDTO.S_AND_S_LICENSES_FAILING_DUE_TO_DELIVERY_BLOCK_DATE:
										getSelectedIneligbleLicense(customDTO.getSAndSLicensesFailingDueToDeleveryBlockDate(), sAndSlicenseFailingDueToDeliveryBlockDate, selectedId);
										break;
						    default :
                                break;
                        }
					}
				}
			}
			customDTO.setExistingContractCoverage(null);
			customDTO.setLicensesFailingRemovalDateCheck(null);
			customDTO.setLicensesWithRejectionReason(null);
			customDTO.setLicensesFailingLicenseEffectiveDateCheck(licenseFailingLicenseEffectiveDate);
			customDTO.setLicensesFailingDueToDeleveryBlockDate(licenseFailingDueToDeliveryBlockDate);
			customDTO.setSAndSExistingContractCoverage(null);
			customDTO.setSAndSLicensesFailingRemovalDateCheck(null);
			customDTO.setSAndSLicensesWithRejectionReason(null);
			customDTO.setSAndSLicensesFailingLicenseEffectiveDateCheck(sAndSlicenseFailingLicenseEffectiveDate);
			customDTO.setSAndSLicensesFailingDueToDeleveryBlockDate(sAndSlicenseFailingDueToDeliveryBlockDate);
		}
		
		return customDTO;
	}
	
	private void getSelectedIneligbleLicense(TreeMap sourceIneligibleLicenses, TreeMap targetIneligibleLicenses, String selectedId){
		if(null != sourceIneligibleLicenses || null != selectedId)
		{
			IneligibleSWOCustomDTO ineligibleSwo = (IneligibleSWOCustomDTO)sourceIneligibleLicenses.get(selectedId);
			if(null != ineligibleSwo){
				targetIneligibleLicenses.put(selectedId, ineligibleSwo);
			}
		}
	}
	
	private void removeIneligibleLicenses(OPPTSession session){
		if(null != session){
			session.removeObjectFromSession(SessionConstants.INELIGIBLE_LICENSES);
		}
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
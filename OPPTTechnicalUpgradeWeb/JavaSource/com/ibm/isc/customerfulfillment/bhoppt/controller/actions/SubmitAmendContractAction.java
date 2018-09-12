/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.AmendContractActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ComplexContractIdentifiers;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class SubmitAmendContractAction extends OPPTLongAction 
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
		
		AmendContractActionForm actionForm = (AmendContractActionForm)form;
		AmendContractCustomDTO contractDto = getFromSession(session);
		setTransactionInformation(contractDto, session);
		populateContractDto(contractDto, actionForm);
		setTransactionInformation(contractDto.getBasicProposalCustomDTO(),session);

		try {
			// BH Wave1 - DAD003 - Complex Contract Identifiers - Begin -Manoj	
			try {
				BasicProposalCustomDTO bpCustomDTO = getProposalManager().validateComplexContractIdentifiers(contractDto.getBasicProposalCustomDTO());
				contractDto.setBasicProposalCustomDTO(bpCustomDTO);
				ErrorReport messageReport = bpCustomDTO.getMessageReport();
				ComplexContractIdentifiers complexContractIdentifiers = ComplexContractIdentifiers.getComplexContractIdentifiers();
				if(null != messageReport && messageReport.size()>0){				
					bpCustomDTO.getMessageReport().clear();				
					getProposalManager().throwExceptionForService(complexContractIdentifiers.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
				}
				if (complexContractIdentifiers.IsAllValueNull(contractDto.getBasicProposalCustomDTO()) || ConnectorConstants.RFC_SUCCESS_CODE.equals(complexContractIdentifiers.getReturnCode())){
					// Either if all the Complex contract Identifiers fields are empty or the return code is success then allow Register using CCI_IND
					contractDto.getBasicProposalCustomDTO().setCciInd("Y");
					contractDto.getBasicProposalCustomDTO().setOcpsID(complexContractIdentifiers.getOcpsID());
					contractDto.getBasicProposalCustomDTO().setContractType(complexContractIdentifiers.getContractType());
					contractDto.getBasicProposalCustomDTO().setBlbIndicator(complexContractIdentifiers.getBlbIndicator());
				} else {
					// Else Donot allow Register
					contractDto.getBasicProposalCustomDTO().setCciInd("N");
				}
			}catch(ServiceException se){
				// - Display the BH-OPPT Message screen for CCI Warning Message
				viewBean = handleServiceExceptionForMessage(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
				return viewBean;
			}
			
			//BH Wave1 - DAD003 - Complex Contract Identifiers - End -Manoj
			contractDto = getProposalManager().processAmendContract(contractDto);
			ErrorReport errorReport = contractDto.getMessageReport();

			if(null == errorReport){
				setForwardName(ForwardNameConstants.ACTION_CONTRACT_DETAIL);
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}
		}
		catch(ServiceException ex){
			viewBean = handleServiceException(session, ex.getErrorReport());
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
		return ActionNameConstants.SUBMIT__AMEND_CONTRACT;
	}
	
	/**
	 *  
	 * Retrieve AmendContractCustomDTO from session
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session
	 * @return
	 */
	private AmendContractCustomDTO getFromSession(OPPTSession session){
		AmendContractCustomDTO customDto = null;
		customDto = (AmendContractCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_AMEND_CONTRACT);
		return customDto;
	}
	
	private void populateContractDto(AmendContractCustomDTO customDto, AmendContractActionForm actionForm){
		VarianceInformationCustomDTO varianceCustomDTO = customDto.getVarianceInformationCustomDTO();
		BasicProposalCustomDTO basicCustomDTO = customDto.getBasicProposalCustomDTO();
		PricingInformationCustomDTO pricingCustomDTO = customDto.getPricingInformationCustomDTO();
		SecondaryProposalCustomDTO secondaryCustomDTO = customDto.getSecondaryProposalCustomDTO();
		
		customDto.setAmendmentEffectiveDate(actionForm.getAmendmentEffectiveDate().getDate());
		basicCustomDTO.setExternalContractNumber(actionForm.getExternalContractNumber());
		// BH Wave1 - DAD003 - Begin - Manoj
		basicCustomDTO.setCpsID(actionForm.getBasicProposalData().getCpsID());
		basicCustomDTO.setOcpsID(actionForm.getBasicProposalData().getOcpsID());
		basicCustomDTO.setContractType(actionForm.getBasicProposalData().getContractType());
		basicCustomDTO.setBlbIndicator(actionForm.getBasicProposalData().getBlbIndicator());
		// BH Wave1 - DAD003 - End - Manoj
		
		if(null != actionForm.getAnniversaryContractAmount() && actionForm.getAnniversaryContractAmount().trim().length() > 0 ){
			pricingCustomDTO.setAnniversaryContractAmount(Double.parseDouble(actionForm.getAnniversaryContractAmount()));
		}
		
		if(null != actionForm.getSsAnniversaryContractAmount() && actionForm.getSsAnniversaryContractAmount().trim().length() > 0 ){
			pricingCustomDTO.setSAndSAnniversaryContractAmount(Double.parseDouble(actionForm.getSsAnniversaryContractAmount()));
		}
		else{
			pricingCustomDTO.setSAndSAnniversaryContractAmount(-1);			
		}
		/* CR6153 changes starts */
		if(null != actionForm.getSsAnninversaryAmountPeriod2() && actionForm.getSsAnninversaryAmountPeriod2().trim().length() > 0 ){
			pricingCustomDTO.setSAndSAnniversaryContractAmountPeriod2(Double.parseDouble(actionForm.getSsAnninversaryAmountPeriod2()));
		}
		else{
			pricingCustomDTO.setSAndSAnniversaryContractAmountPeriod2(-1);			
		}
		if(null != actionForm.getSsAnninversaryAmountPeriod3() && actionForm.getSsAnninversaryAmountPeriod3().trim().length() > 0 ){
			pricingCustomDTO.setSAndSAnniversaryContractAmountPeriod3(Double.parseDouble(actionForm.getSsAnninversaryAmountPeriod3()));
		}
		else{
			pricingCustomDTO.setSAndSAnniversaryContractAmountPeriod3(-1);			
		}
		if(null != actionForm.getSsAnninversaryAmountPeriod4() && actionForm.getSsAnninversaryAmountPeriod4().trim().length() > 0 ){
			pricingCustomDTO.setSAndSAnniversaryContractAmountPeriod4(Double.parseDouble(actionForm.getSsAnninversaryAmountPeriod4()));
		}
		else{
			pricingCustomDTO.setSAndSAnniversaryContractAmountPeriod4(-1);			
		}
		if(null != actionForm.getSsAnninversaryAmountPeriod5() && actionForm.getSsAnninversaryAmountPeriod5().trim().length() > 0 ){
			pricingCustomDTO.setSAndSAnniversaryContractAmountPeriod5(Double.parseDouble(actionForm.getSsAnninversaryAmountPeriod5()));
		}
		else{
			pricingCustomDTO.setSAndSAnniversaryContractAmountPeriod5(-1);			
		}	
		/*CR6153 changes ends */
		
		pricingCustomDTO.setGsa(actionForm.isGsa());
		// BH Wave1 - DAD003 - Begin - Manoj
		pricingCustomDTO.setPrebillIndicator(actionForm.isPrebillIndicator());
		// BH Wave1 - DAD003 - Begin - Manoj
		pricingCustomDTO.setBillingBlock(actionForm.getBillingBlock());
		pricingCustomDTO.setFreeTextForInvoicePrint(actionForm.getFreeTextForInvoicePrint());
		secondaryCustomDTO.setPurchaseOrderNumber(actionForm.getPurchaseOrderNumber());
		secondaryCustomDTO.setPurchaseOrderDate(actionForm.getPurchaseOrderDate().getDate());
		
		customDto.setBasicProposalCustomDTO(basicCustomDTO);
		customDto.setVarianceInformationCustomDTO(varianceCustomDTO);
		customDto.setPricingInformationCustomDTO(pricingCustomDTO);
		customDto.setSecondaryProposalCustomDTO(secondaryCustomDTO);
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

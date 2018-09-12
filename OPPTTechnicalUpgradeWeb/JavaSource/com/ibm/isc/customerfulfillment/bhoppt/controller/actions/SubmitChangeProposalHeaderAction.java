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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class SubmitChangeProposalHeaderAction extends OPPTLongAction 
{
	ComplexContractIdentifiers complexContractIdentifiers = ComplexContractIdentifiers.getComplexContractIdentifiers();
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)throws Exception 
	{
		OPPTViewBean viewBean = null;
		ProposalHeaderActionForm actionForm = (ProposalHeaderActionForm)form;
		ProposalHeaderCustomDTO customDTO = getChangeProposalHeader(session); 
		customDTO = getInputValues(customDTO, actionForm);
		setTransactionInformation(customDTO.getBasicProposalCustomDTO(),session);
		if(null != customDTO){
			// BH Wave1 - DAD003 - Complex Contract Identifiers - Begin -Manoj
			try {				
				//First evaluate the Complex contract Identifiers fields
				BasicProposalCustomDTO bpCustomDTO = getProposalManager().validateComplexContractIdentifiers(customDTO.getBasicProposalCustomDTO());
				customDTO.setBasicProposalCustomDTO(bpCustomDTO);
				ErrorReport messageReport = bpCustomDTO.getMessageReport();
				
				if(null != messageReport && messageReport.size()>0){					
					bpCustomDTO.getMessageReport().clear();
					addDataStoreEntry(session, customDTO);
					setChangeProposalHeader(session, customDTO);
					getProposalManager().throwExceptionForService(complexContractIdentifiers.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
				}
				if (complexContractIdentifiers.IsAllValueNull(customDTO.getBasicProposalCustomDTO()) || ConnectorConstants.RFC_SUCCESS_CODE.equals(complexContractIdentifiers.getReturnCode())){
					// Either if all the Complex contract Identifiers fields are empty or the return code is success then allow Register using CCI_IND
					customDTO.getBasicProposalCustomDTO().setCciInd("Y");
				} else {
					// Else Donot allow Register
					customDTO.getBasicProposalCustomDTO().setCciInd("N");
				}				
			} catch(ServiceException se){				
				viewBean = handleServiceExceptionForMessage(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
				return viewBean;
			}
			// BH Wave1 - DAD003 - Complex Contract Identifiers - End -Manoj
			if(isProposalHeaderChanged(session, actionForm)){
				customDTO.setConfirmationRequired(true);
		
				try{
					customDTO = getProposalManager().validateProposalHeader(customDTO);
					addDataStoreEntry(session, customDTO);
					setChangeProposalHeader(session, customDTO);
									viewBean = new ConfirmationViewBean(ConfirmationConstants.CHANGE_PROPOSAL_HEADER);
					ErrorReport messageReport = customDTO.getMessageReport();
					if(null != messageReport){
						messageReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA43, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
					else{
						messageReport = getErrorReport(ErrorCodeConstants.PA43);
					}
					viewBean.setErrorReport(messageReport);
					setForwardName(ForwardNameConstants.PAGE_CONFIRMATION);
				}
				catch(ServiceException se){
					viewBean = handleServiceException(session, se.getErrorReport());
				}
			}
			else{
				customDTO.setConfirmationRequired(false);
				try {
					customDTO = getProposalManager().validateProposalHeader(customDTO);
					addDataStoreEntry(session, customDTO);
					if(customDTO.isProposalDetails()){
						setForwardName(ForwardNameConstants.ACTION_PROPOSAL_DETAILS);
					}
					else{ 
						viewBean = new PartnerDetailsViewBean(session.getUserInfo().getRole() == RoleConstants.BUSINESS_PARTNER, true, customDTO.getPartnerInformationCustomDTO(), customDTO.getSecondaryProposalCustomDTO().getComments());
						setPartnerDetailsForwardName(getRole(session));
					}
				}
				catch(ServiceException se){
					viewBean = handleErrorReport(se.getErrorReport());
				}
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			setForwardName(session.getCurrentForward());
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
		return ActionNameConstants.SUBMIT_CHANGE_PROPOSAL_HEADER;
	}

	private ProposalHeaderCustomDTO getInputValues(ProposalHeaderCustomDTO customDTO, ProposalHeaderActionForm actionForm){
		if(null != customDTO  && null != actionForm){
			// Getting basic proposal data input values
			BasicProposalCustomDTO basicProposalCustomDTO = customDTO.getBasicProposalCustomDTO();
			if(null != basicProposalCustomDTO){
				BasicProposalDataBean basicProposalData = actionForm.getBasicProposalData();
				basicProposalCustomDTO.setProposalType(basicProposalData.getProposalType());
				basicProposalCustomDTO.setReportName(basicProposalData.getReportName());
				basicProposalCustomDTO.setExternalContractNumber(basicProposalData.getExternalContractNumber());
				basicProposalCustomDTO.setContractStartDate(actionForm.getContractStartDate().getDate());
				basicProposalCustomDTO.setContractEndDate(actionForm.getContractEndDate().getDate());
				basicProposalCustomDTO.setContractPeriodBeginning(actionForm.getContractPeriodStartDate().getDate());
				basicProposalCustomDTO.setContractPeriodEnding(actionForm.getContractPeriodEndDate().getDate());
				basicProposalCustomDTO.setProposalContent(basicProposalData.getProposalContent());
				// BH Wave1 - DAD003 - Begin - Manoj
				basicProposalCustomDTO.setCpsID(basicProposalData.getCpsID());
				basicProposalCustomDTO.setOcpsID(basicProposalData.getOcpsID());
				//System.out.println("SubmitChangeProposalHeaderAction.getInputValues():ContractType:"+basicProposalData.getContractType());
				basicProposalCustomDTO.setContractType(basicProposalData.getContractType());
				//System.out.println("SubmitChangeProposalHeaderAction.getInputValues():BLB:"+complexContractIdentifiers.getBlbIndicator());
				basicProposalCustomDTO.setBlbIndicator(complexContractIdentifiers.getBlbIndicator());
				basicProposalCustomDTO.setIsPreBillIndicator(basicProposalData.isPreBillIndicator());
				// BH Wave1 - DAD003 - End - Manoj
			}

			// Getting pricing input values
			PricingInformationCustomDTO pricingCustomDTO = customDTO.getPricingInformationCustomDTO();
			if(null != customDTO){
				PricingInformationDataBean pricingDataBean = actionForm.getPricingInformation();
				pricingCustomDTO.setPlannedGrowthOption(pricingDataBean.getPlannedGrowthOption());
				pricingCustomDTO.setPlannedGrowthValue(getDoubleValue(pricingDataBean.getPlannedGrowthValue()));
				pricingCustomDTO.setBillingFrequency(pricingDataBean.getBillingFrequency());
				pricingCustomDTO.setGrowthLimitValue(getDoubleValue(pricingDataBean.getGrowthLimitValue()));
				pricingCustomDTO.setGrowthLimitOption(pricingDataBean.getGrowthLimitOption());
				pricingCustomDTO.setTvmRate(getDoubleValue(pricingDataBean.getTvmRate()));
				pricingCustomDTO.setAdditionalGrowthLimit(getDoubleValue(pricingDataBean.getAdditionalGrowthLimit()));
				pricingCustomDTO.setPakid(pricingDataBean.getPakid());
				System.out.println("SubmitChangeProposalHeaderAction.getInputValues():DISCOUNT::"+getDoubleValue(pricingDataBean.getDiscount()));
				pricingCustomDTO.setDiscount(getDoubleValue(pricingDataBean.getDiscount()));
				pricingCustomDTO.setAnniversaryContractAmount(getDoubleValue(pricingDataBean.getAnniversaryContractAmount()));
				pricingCustomDTO.setSAndSAnniversaryContractAmount(getDoubleValue(pricingDataBean.getSsAnninversaryContractAmount(), -1));
				/*CR6153 start changes  */
				pricingCustomDTO.setExtendPeriod(pricingDataBean.isExtendPeriod());
				pricingCustomDTO.setSAndSAnniversaryContractAmountPeriod2(getDoubleValue(pricingDataBean.getSsAnninversaryAmountPeriod2(), -1));
				pricingCustomDTO.setSAndSAnniversaryContractAmountPeriod3(getDoubleValue(pricingDataBean.getSsAnninversaryAmountPeriod3(), -1));
				pricingCustomDTO.setSAndSAnniversaryContractAmountPeriod4(getDoubleValue(pricingDataBean.getSsAnninversaryAmountPeriod4(), -1));
				pricingCustomDTO.setSAndSAnniversaryContractAmountPeriod5(getDoubleValue(pricingDataBean.getSsAnninversaryAmountPeriod5(), -1));
                /*CR6153 start changes */
				pricingCustomDTO.setDetailedInvoice(pricingDataBean.isDetailedInvoice());
				pricingCustomDTO.setGsa(pricingDataBean.isGsa());
				// BH Wave1 - DAD003 - Begin - Manoj
				pricingCustomDTO.setPrebillIndicator(pricingDataBean.isPrebillIndicator());
				// BH Wave1 - DAD003 - End - Manoj
				pricingCustomDTO.setBillingBlock(pricingDataBean.getBillingBlock());
				pricingCustomDTO.setDeviatingDateRule(pricingDataBean.getDeviatingDateRule());
				pricingCustomDTO.setBillingDateRule(pricingDataBean.getBillingDateRule());
				pricingCustomDTO.setFreeTextForInvoicePrint(pricingDataBean.getFreeTextForInvoicePrint());
				pricingCustomDTO.setAdvance(pricingDataBean.isAdvance());
				pricingCustomDTO.setExceedingAmount(getDoubleValue(pricingDataBean.getExceedingAmount()));
				pricingCustomDTO.setInvoiceSuppression(pricingDataBean.isInvoiceSuppression());
				pricingCustomDTO.setVarianceDate(actionForm.getVarianceDate().getDate());
			}
			
			// Getting variance input values
			VarianceInformationCustomDTO varianceCustomDTO = customDTO.getVarianceInformationCustomDTO();
			if(null != varianceCustomDTO){
				VarianceDataBean varianceDataBean = actionForm.getVarianceData();
				varianceCustomDTO.setCapAmount(varianceDataBean.getCapAmount());
				varianceCustomDTO.setCapPlus(varianceDataBean.getCapPlus());
				varianceCustomDTO.setCapMinus(varianceDataBean.getCapMinus());
			}
			
			// Getting secondary proposal data input values
			SecondaryProposalCustomDTO secondaryProposalCustomDTO = customDTO.getSecondaryProposalCustomDTO();
			if(null != secondaryProposalCustomDTO){
				SecondaryProposalDataBean secondaryProposalDataBean = actionForm.getSecondaryProposalData();
				secondaryProposalCustomDTO.setPurchaseOrderNumber(secondaryProposalDataBean.getPurchaseOrderNumber());
				secondaryProposalCustomDTO.setPaymentTerms(secondaryProposalDataBean.getPaymentTerms());
				secondaryProposalCustomDTO.setIgfOfferNumber(secondaryProposalDataBean.getIgfOfferNumber());
				secondaryProposalCustomDTO.setComments(secondaryProposalDataBean.getComments());
				secondaryProposalCustomDTO.setAddValueDays(secondaryProposalDataBean.getAddValueDays());
				secondaryProposalCustomDTO.setSandsExcluded(secondaryProposalDataBean.isSandsExcluded());
				secondaryProposalCustomDTO.setFixedValDate(actionForm.getFixedValueDate().getDate());
				secondaryProposalCustomDTO.setPurchaseOrderDate(actionForm.getPurchaseOrderDate().getDate());
			}
			
			customDTO.setBasicProposalCustomDTO(basicProposalCustomDTO);
			customDTO.setSecondaryProposalCustomDTO(secondaryProposalCustomDTO);
			customDTO.setVarianceInformationCustomDTO(varianceCustomDTO);
			customDTO.setPricingInformationCustomDTO(pricingCustomDTO);
		}
		
		return customDTO;
	}

	private ProposalHeaderCustomDTO getChangeProposalHeader(OPPTSession session){
		ProposalHeaderCustomDTO customDTO = null;
		if(null != session){
			customDTO = (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
		}
		return customDTO;
	}

	private void setChangeProposalHeader(OPPTSession session, ProposalHeaderCustomDTO customDTO){
		if(null != session && null != customDTO){
			session.storeObjectToSession(SessionConstants.PROPOSAL_HEADER, customDTO);
		}
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
		String actualForward = getCurrentForwardName(session, getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof ProposalHeaderDetailsViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.CHANGE_PROPOSAL);
			if(null != dataStoreEntry && dataStoreEntry instanceof ProposalHeaderCustomDTO){
				session.setCurrentViewBean(new ProposalHeaderDetailsViewBean((ProposalHeaderCustomDTO)dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}
		
		return valid;
	}

	private void setPartnerDetailsForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PARTNER_DETAILS);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_PARTNER_DETAILS);
								break;
		}
	}

	private String getCurrentForwardName(OPPTSession session, int role){
		ProposalHeaderCustomDTO proposalHeader = getChangeProposalHeader(session);
		String currentForwardName = null;
		if(null != proposalHeader && proposalHeader.isChangeVarianceProposal()){
			switch(role){
				case Constants.PROPOSAL_CREATE_APPROVER: 
									currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CHANGE_VARIANCE_PROPOSAL;
									break;
			
				case Constants.PROPOSAL_ADMINISTRATOR:
				default:
									currentForwardName = ForwardNameConstants.PAGE_CHANGE_VARIANCE_PROPOSAL;
									break;
			}
		}
		else{		
			switch(role){
				case Constants.PROPOSAL_CREATE_APPROVER: 
									currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CHANGE_PROPOSAL;
									break;
			
				case Constants.PROPOSAL_ADMINISTRATOR:
				default:
									currentForwardName = ForwardNameConstants.PAGE_CHANGE_PROPOSAL;
									break;
			}
		}
		
		return currentForwardName;
	}
	
	private boolean isProposalHeaderChanged(OPPTSession session, ProposalHeaderActionForm actionForm){
		boolean proposalHeaderChanged = false;
		
		ProposalHeaderActionForm oldActionForm = (ProposalHeaderActionForm)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER_ACTION_FORM);
		if(null != oldActionForm && null != actionForm){
			if(!oldActionForm.getBasicProposalData().equals(actionForm.getBasicProposalData())){
				proposalHeaderChanged = true;
			}
			else if(!oldActionForm.getSecondaryProposalData().equals(actionForm.getSecondaryProposalData())){
				proposalHeaderChanged = true;
			}
			else if(!oldActionForm.getPricingInformation().equals(actionForm.getPricingInformation())){
				proposalHeaderChanged = true;
			}
			else if(!oldActionForm.getContractPeriodStartDate().equals(actionForm.getContractPeriodStartDate())){
				proposalHeaderChanged = true;
			}
			else if(!oldActionForm.getContractPeriodEndDate().equals(actionForm.getContractPeriodEndDate())){
				proposalHeaderChanged = true;
			}
			else if(!oldActionForm.getContractStartDate().equals(actionForm.getContractStartDate())){
				proposalHeaderChanged = true;
			}
			else if(!oldActionForm.getContractEndDate().equals(actionForm.getContractEndDate())){
				proposalHeaderChanged = true;
			}
			else if(!oldActionForm.getPurchaseOrderDate().equals(actionForm.getPurchaseOrderDate())){
				proposalHeaderChanged = true;
			}
			else if(!oldActionForm.getFixedValueDate().equals(actionForm.getFixedValueDate())){
				proposalHeaderChanged = true;
			}
			else if(!oldActionForm.getReplacementDate().equals(actionForm.getReplacementDate())){
				proposalHeaderChanged = true;
			}
		}
		else{
			proposalHeaderChanged = true;
		}
		
		return proposalHeaderChanged;
	}
}
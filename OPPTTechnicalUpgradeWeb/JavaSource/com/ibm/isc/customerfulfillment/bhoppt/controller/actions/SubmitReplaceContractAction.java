/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ContractReplacementActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class SubmitReplaceContractAction extends OPPTLongAction 
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
		ProposalHeaderCustomDTO headerCustomDto;
		ContractReplacementActionForm actionForm = (ContractReplacementActionForm)form;
		ReplaceContractCustomDTO customDto = getCustomDtoFromSession(session);
		setTransactionInformation(customDto,session);
		String option = actionForm.getCopyCreate();
		
		
		try {
			
			if("Copy".equalsIgnoreCase(option)){  //$NON-NLS-1$
				customDto.setContractReplacementDate(actionForm.getReplacementDate().getDate());
				customDto = getProposalManager().validateReplacementDate(customDto);
				ErrorReport errorReport = customDto.getMessageReport();

				if(null == errorReport){
					setDtoInSession(customDto,session);
					viewBean = new NewProposalNameViewBean(NewProposalNameConstants.COPY_REPLACE_CONTRACT,NewProposalNameConstants.COPY_REPLACE_CONTRACT_DESC);
					setForwardName(ForwardNameConstants.PAGE_NEW_PROPOSAL_NAME);
				}
				else{
					viewBean = new MessageViewBean();
					viewBean.setErrorReport(errorReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			}
			if("Create".equalsIgnoreCase(option)){  //$NON-NLS-1$
				headerCustomDto = new ProposalHeaderCustomDTO();
				setTransactionInformation(headerCustomDto, session);
				headerCustomDto =  populateHeaderDto(headerCustomDto, customDto);
				// added to test by Balaji - Starts
				BasicProposalCustomDTO basic = new BasicProposalCustomDTO();
				basic.setReplacementContractDate(actionForm.getReplacementDate().getDate());
				headerCustomDto.setBasicProposalCustomDTO(basic);
				// added to test by Balaji - Ends

				headerCustomDto = getProposalManager().getHeaderInformation(headerCustomDto);
				ErrorReport errorReport = headerCustomDto.getMessageReport();

				if(null == errorReport){
					addDataStoreEntry(session, headerCustomDto.getProposalFormDataCustomDTO());
					viewBean = getCreateProposalViewBean(headerCustomDto, actionForm.getReplacementDate().getDate());
					setForwardName(getRole(session));
				}
				else{
					viewBean = new MessageViewBean();
					viewBean.setErrorReport(errorReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			}

		}
		catch(ServiceException ex){
			viewBean = handleServiceException(session, ex.getErrorReport());
		}
		
		return viewBean;	
	}

	/** 
	 * Returns the action name. 
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
		return ActionNameConstants.SUBMIT_REPLACE_CONTRACT;
	}
	
	private CreateProposalViewBean getCreateProposalViewBean(ProposalHeaderCustomDTO customDTO, Date replaceContractDate){
		CreateProposalViewBean viewBean = null;
		
		if(null != customDTO){
			viewBean = new CreateProposalViewBean(customDTO.getProposalFormDataCustomDTO());
			viewBean.setNonEditableFields(customDTO.getNonEditableFields());

			ProposalHeaderActionForm actionForm = new ProposalHeaderActionForm();
			actionForm.setBasicProposalData(new BasicProposalDataBean(customDTO.getBasicProposalCustomDTO()));
			actionForm.setPricingInformation(new PricingInformationDataBean(customDTO.getPricingInformationCustomDTO()));
			actionForm.setVarianceData(new VarianceDataBean(customDTO.getVarianceInformationCustomDTO()));
			actionForm.setSecondaryProposalData(new SecondaryProposalDataBean(customDTO.getSecondaryProposalCustomDTO()));
			actionForm.setPurchaseOrderDate(new DateDataBean(actionForm.getSecondaryProposalData().getPurchaseOrderDate()));
			actionForm.setFixedValueDate(new DateDataBean(actionForm.getSecondaryProposalData().getFixedValDate()));
			actionForm.getBasicProposalData().setSalesOrganization(customDTO.getBasicProposalCustomDTO().getSalesOrganizationValue());
			
			/** Changes starts from here : Thirumalaikumar
			 *  For Double value in CAP during replacemnet 
			 */ 
			// actionForm.setCapAmount(String.valueOf(actionForm.getVarianceData().getCapAmount()));
			// actionForm.setCapMinus(String.valueOf(actionForm.getVarianceData().getCapMinus()));
			// actionForm.setCapPlus(String.valueOf(actionForm.getVarianceData().getCapPlus()));
			
			actionForm.setCapAmount(getDoubleValue(actionForm.getVarianceData().getCapAmount()));
			actionForm.setCapMinus(getDoubleValue(actionForm.getVarianceData().getCapMinus()));
			actionForm.setCapPlus(getDoubleValue(actionForm.getVarianceData().getCapPlus()));
			// Changes end here
			
			actionForm.setContractStartDate(new DateDataBean(actionForm.getBasicProposalData().getContractStartDate()));
			actionForm.setContractEndDate(new DateDataBean(actionForm.getBasicProposalData().getContractEndDate()));
			actionForm.setContractPeriodStartDate(new DateDataBean(actionForm.getBasicProposalData().getContractPeriodBeginning()));
			actionForm.setContractPeriodEndDate(new DateDataBean(actionForm.getBasicProposalData().getContractPeriodEnding()));
			actionForm.getBasicProposalData().setProposalName(null);
			
			actionForm.getBasicProposalData().setReplacementContractDate(replaceContractDate);
			viewBean.setActionForm(actionForm);
		}
		
		return viewBean;
	}

	/**
	 *  Retrieves ReplaceContractCustomDTO from session
	 * 
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
	private ReplaceContractCustomDTO getCustomDtoFromSession(OPPTSession session){
		ReplaceContractCustomDTO customDto = (ReplaceContractCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_REPLACE_CONTRACT);
		
		return customDto;
	}
	
	/**
	 *  
	 * Sets ReplaceContractCustomDTO in session after populating Replacement Date
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
	 * @param customDto
	 * @param session
	 */
	private void setDtoInSession(ReplaceContractCustomDTO customDto,OPPTSession session){
		session.storeObjectToSession(SessionConstants.SESSION_REPLACE_CONTRACT, customDto);
	}
	
	private ProposalHeaderCustomDTO populateHeaderDto(ProposalHeaderCustomDTO headerDto, ReplaceContractCustomDTO customDto){
		headerDto.setProposal(customDto.getContractDTO());
		headerDto.setContractNumber(customDto.getContractDTO().getContractNumber());
		return headerDto;
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

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CREATE_PROPOSAL);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CREATE_PROPOSAL);
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
	
	private String getDoubleValue(double doubleValue) {
		BigDecimal initialDouble = new BigDecimal((new Double(doubleValue)).toString());
		BigDecimal scaledDouble = initialDouble.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return scaledDouble.toString();
	}

}
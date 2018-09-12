
/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationStatusConstant;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ConfirmationActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationContactActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationTypeCodeActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SearchListActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ConfirmationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerSelectionViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteInventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserContractsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ROLModificationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SearchBaseAgreementCustomDTO;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class YesConfirmationAction extends OPPTLongAction 
{
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception 
	{
				
		OPPTViewBean viewBean = null;
		
		ConfirmationActionForm actionForm = (ConfirmationActionForm)form;
		if(null != actionForm){
			String initiator = actionForm.getInitiator();
			if(null != initiator){
				if(ConfirmationConstants.DELETE_PROPOSALS.equalsIgnoreCase(initiator)){
					viewBean = deleteProposals(session);
				}
				else if(ConfirmationConstants.DELETE_ARCHIVE.equalsIgnoreCase(initiator)){
					viewBean = deleteArchives(session);
				}
				else if(ConfirmationConstants.REMOVE_SVC_LICENSES.equalsIgnoreCase(initiator)){
					viewBean = removeSVCLicenses(session);
				}
				else if(ConfirmationConstants.DELETE_INVENTORY.equalsIgnoreCase(initiator)){
					viewBean = deleteInventory(session);
				}
				else if(ConfirmationConstants.CANCEL_CONFIGURE_DM.equalsIgnoreCase(initiator)){
					viewBean = cancelConfigureDM(session);
				}
				else if(ConfirmationConstants.CHANGE_PROPOSAL_HEADER.equalsIgnoreCase(initiator)){
					viewBean = changeProposalHeader(session);
				}
				else if(ConfirmationConstants.APPROVE_PROPOSAL.equalsIgnoreCase(initiator)){
					viewBean = approveProposal(session);
				}
				else if(ConfirmationConstants.REVERT_PROPOSAL.equalsIgnoreCase(initiator)){
					viewBean = revertProposal(session);
				}
				else if(ConfirmationConstants.REMOVE_QUOTES.equalsIgnoreCase(initiator)){
					viewBean = removeQuotes(session);
				}
				else if(ConfirmationConstants.CREATE_PROPOSAL.equalsIgnoreCase(initiator)){
					viewBean = createProposal(session);
				}
				//Added by Nayanatara L Pai to display Confirmation page
				else if(ConfirmationConstants.CONFIRM_INACTIVATE.equalsIgnoreCase(initiator)){
					viewBean = inactivateBaseAgreement(session);
				}
				else if(ConfirmationConstants.INACTIVE_MODIFICATION_DETAILS.equalsIgnoreCase(initiator)){
					viewBean = inactiveModificationDetails(session);
				}
				
				else if(ConfirmationConstants.CONFIRM_DELETE_FORM_ACTION.equalsIgnoreCase(initiator)){
					viewBean = deleteForm(session);
				}	
				else if(ConfirmationConstants.CONFIRM_REACTIVE_ACTION.equalsIgnoreCase(initiator)){
				    viewBean = reactivateBaseAgreement(session);
				}
				else if(ConfirmationConstants.APPLYTOALL_MODIFICATION.equalsIgnoreCase(initiator)){
					viewBean = applyToAllModification(session);
				}
				else if(ConfirmationConstants.CONFIRM_REACTIVATE_MODIFICATION.equalsIgnoreCase(initiator)){
					viewBean = reactiveModificationDetails(session);
				}
				}
		}
		
		return viewBean;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 24, 2003 
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
		return ActionNameConstants.YES_CONFIRMATION;
	}
	
	private DeleteProposalCustomDTO getProposalToBeDeleted(OPPTSession session){
		DeleteProposalCustomDTO customDTO = null;
		if(null != session){
			customDTO = (DeleteProposalCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_PROPOSALS_TO_BE_DELETED);
		}
		return customDTO;
	}
	
	
	private void removeProposalToBeDeleted(OPPTSession session){
		if(null != session){
			session.removeObjectFromSession(SessionConstants.SESSION_PROPOSALS_TO_BE_DELETED);
		}
	}
	private OPPTViewBean deleteProposals(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		DeleteProposalCustomDTO customDTO = getProposalToBeDeleted(session);
		if(null != customDTO){
			//setTransactionInformation(customDTO, session);
			customDTO.setConfirmationRequired(false);
			
			try {
				getProposalManager().deleteProposalContract(customDTO);
				removeProposalToBeDeleted(session);
				if(customDTO.getTransactionName().equalsIgnoreCase(ActionNameConstants.DELETE_PROPOSAL)){
					setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE);
				}
				else{
					setForwardName(ForwardNameConstants.ACTION_CONTRACT_MAINTENANCE);
				}
			}
			catch(ServiceException se){
				viewBean = new ErrorViewBean();
				viewBean.setErrorReport(se.getErrorReport());
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
		}
		
		return viewBean;
	}
	
	private OPPTViewBean deleteArchives(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		DeleteProposalCustomDTO customDTO = getProposalToBeDeleted(session);
		if(null != customDTO){
			//setTransactionInformation(customDTO, session);
			customDTO.setConfirmationRequired(false);
			
			try {
				getProposalManager().deleteProposalContract(customDTO);
				removeProposalToBeDeleted(session);
				setForwardName(ForwardNameConstants.ARCHIVE_CONTRACT_MAINTENANCE);				
			}
			catch(ServiceException se){
				viewBean = new ErrorViewBean();
				viewBean.setErrorReport(se.getErrorReport());
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
		}
		
		return viewBean;
	}
	
	//Method was added by Nayanatara L Pai
	private OPPTViewBean inactivateBaseAgreement(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		ErrorReport errorReport = null;
		BaseAgreementCustomDTO baseAgreementCustomDto = null;
		SearchListActionForm actionForm = (SearchListActionForm)session.getObjectFromSession(SessionConstants.SESSION_SEARCHLIST_ACTIONFORM);	
		SearchBaseAgreementCustomDTO searchBaseAgreementCustomDTO = (SearchBaseAgreementCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_SEARCH_BASE_AGREEMENT);
		//Integer agreementId =new Integer(actionForm.getAgreementId());
		ArrayList baseAgreementList = searchBaseAgreementCustomDTO.getBaseAgreementList(); 
		Iterator baseAgreementiterator=baseAgreementList.iterator();
		while(baseAgreementiterator.hasNext()){
		    BaseAgreementCustomDTO CustomDto =(BaseAgreementCustomDTO)baseAgreementiterator.next();  
		    if(actionForm.getAgreementId()==CustomDto.getAgreementId()){
		        baseAgreementCustomDto = CustomDto;
		    }
		}
		setTransactionInformation(baseAgreementCustomDto, session);
					
		try {
		    
		    baseAgreementCustomDto = getBaseAgreementManager().inActivateBaseAgreement(baseAgreementCustomDto);
			    
		    errorReport = baseAgreementCustomDto.getMessageReport();
		    if(null == errorReport){
		        
				viewBean = new BaseAgreementViewBean(baseAgreementCustomDto);
				setForwardName(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT);  //$NON-NLS-1$
				
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);  //$NON-NLS-1$
			}
    }catch(ServiceException ex){
		viewBean = handleServiceException(session, ex.getErrorReport());
	}
   // session.storeObjectToSession(SessionConstants.SESSION_BASEAGREEMENT_CUSTOMDTO,baseAgreementCustomDto);
    
          return viewBean;
	}
	
	//ravi yandapalli for reactivate
	
	private OPPTViewBean reactivateBaseAgreement(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		BaseAgreementCustomDTO baseAgreementCustomDto = null;
		ErrorReport errorReport = null;
		SearchListActionForm actionForm = (SearchListActionForm)session.getObjectFromSession(SessionConstants.SESSION_SEARCHLIST_ACTIONFORM);	
		SearchBaseAgreementCustomDTO searchBaseAgreementCustomDTO = (SearchBaseAgreementCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_SEARCH_BASE_AGREEMENT);
		//Integer agreementId =new Integer(actionForm.getAgreementId());
		ArrayList baseAgreementList = searchBaseAgreementCustomDTO.getBaseAgreementList(); 
		Iterator baseAgreementiterator=baseAgreementList.iterator();
		while(baseAgreementiterator.hasNext()){
		    BaseAgreementCustomDTO CustomDto =(BaseAgreementCustomDTO)baseAgreementiterator.next();  
		    if(actionForm.getAgreementId()==CustomDto.getAgreementId()){
		        baseAgreementCustomDto = CustomDto;
		    }
		}
		
		setTransactionInformation(baseAgreementCustomDto, session);
					
		try {
		    
		    baseAgreementCustomDto = getBaseAgreementManager().reActivateBaseAgreement(baseAgreementCustomDto);
			    
		    errorReport = baseAgreementCustomDto.getMessageReport();
		    if(null == errorReport){
		        
				viewBean = new BaseAgreementViewBean(baseAgreementCustomDto);
				setForwardName(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT);  //$NON-NLS-1$
				
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);  //$NON-NLS-1$
			}
    }catch(ServiceException ex){
		viewBean = handleServiceException(session, ex.getErrorReport());
	}
   // session.storeObjectToSession(SessionConstants.SESSION_BASEAGREEMENT_CUSTOMDTO,baseAgreementCustomDto);
    
          return viewBean;
	}
//	ravi yandapalli for inactivate
	private OPPTViewBean inactiveModificationDetails(OPPTSession session) throws Exception {
		
		ErrorReport errorReport = null;
        OPPTViewBean viewBean = null;
        DisplayModificationViewBean displayModificationViewBean = (DisplayModificationViewBean)session.getObjectFromSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN);
		ModificationTypeCodeActionForm actionForm =(ModificationTypeCodeActionForm) session.getObjectFromSession(SessionConstants.SESSION_MODIFICATIONTYPECODE_ACTIONFORM); 
		BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDTO = (BaseAgreementDetailsCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
		session.setFirstActionForwardName(ForwardNameConstants.PAGE_REFRESH_DETAILS_MODIFICATION);
		TreeMap selectedModificationsMap = baseAgreementDetailsCustomDTO.getModificationDetailsMap();
		
		if(baseAgreementDetailsCustomDTO!=null && baseAgreementDetailsCustomDTO.getAgreementId()>0){  
		    if(actionForm.getModificationTypeCode().equals(BaseAgreementModificationConstants.ROL)){
		        ROLModificationCustomDTO rOLcustomDTO =(ROLModificationCustomDTO)selectedModificationsMap.get(actionForm.getModificationTypeCode());
		        rOLcustomDTO.setStatus(BaseAgreementModificationStatusConstant.Inactive);
				selectedModificationsMap.remove(actionForm.getModificationTypeCode());
				selectedModificationsMap.put(actionForm.getModificationTypeCode(),rOLcustomDTO);
		    }else{
		    ModificationCustomDTO customDTO =(ModificationCustomDTO)selectedModificationsMap.get(actionForm.getModificationTypeCode());
		    customDTO.setStatus(BaseAgreementModificationStatusConstant.Inactive);
			selectedModificationsMap.remove(actionForm.getModificationTypeCode());
			selectedModificationsMap.put(actionForm.getModificationTypeCode(),customDTO);
			}
		}else{
		    selectedModificationsMap.remove(actionForm.getModificationTypeCode());
		}    
		//this for amend
		baseAgreementDetailsCustomDTO.setModificationDetailsMap(selectedModificationsMap);
			session.storeObjectToSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS,baseAgreementDetailsCustomDTO);
			TreeMap SelectedMap = displayModificationViewBean.getSelectedModifications();
			if(baseAgreementDetailsCustomDTO!=null && baseAgreementDetailsCustomDTO.getAgreementId()>0){
				DisplayModificationDetailViewBean displayViewBean=(DisplayModificationDetailViewBean)SelectedMap.get(actionForm.getModificationTypeCode());	
				displayViewBean.setStatus(BaseAgreementModificationStatusConstant.Inactive);
				SelectedMap.remove(actionForm.getModificationTypeCode());
				SelectedMap.put(actionForm.getModificationTypeCode(),displayViewBean);
			}else{
			    SelectedMap.remove(actionForm.getModificationTypeCode());
			}
			//this for amend
			ModificationCustomDTO modificationCustomDTO=null;			
			displayModificationViewBean.setSelectedModifications(SelectedMap);
			session.storeObjectToSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN,displayModificationViewBean);
			viewBean = displayModificationViewBean;
		// Added by Balaji for UI standards - Starts
	    BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
	    if(customDto != null && customDto.getAgreementId() > 0) {
	      	setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION_FOR_AMEND);
	      	session.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,new Boolean(true));
	    }else {
          setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION);
	    }
        
	    // Added by Balaji for UI standards - Ends
        return viewBean;
    }

	
	//	ravi yandapalli for reactivate
	private OPPTViewBean reactiveModificationDetails(OPPTSession session) throws Exception {
		
	    ErrorReport errorReport = null;
        OPPTViewBean viewBean = null;
        DisplayModificationViewBean displayModificationViewBean = (DisplayModificationViewBean)session.getObjectFromSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN);
        ModificationTypeCodeActionForm actionForm =(ModificationTypeCodeActionForm)session.getObjectFromSession(SessionConstants.SESSION_MODIFICATIONTYPECODE_ACTIONFORM); 
        BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDTO = (BaseAgreementDetailsCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);

     TreeMap selectedModificationsMap = baseAgreementDetailsCustomDTO.getModificationDetailsMap();
     if(actionForm.getModificationTypeCode().equals(BaseAgreementModificationConstants.ROL)){
         ROLModificationCustomDTO rolmodificationCustomDTO =(ROLModificationCustomDTO)selectedModificationsMap.get(actionForm.getModificationTypeCode());
         rolmodificationCustomDTO.setStatus(BaseAgreementModificationStatusConstant.Active);
         selectedModificationsMap.put(actionForm.getModificationTypeCode(),rolmodificationCustomDTO);
         baseAgreementDetailsCustomDTO.setModificationDetailsMap(selectedModificationsMap);
     }else{
         ModificationCustomDTO modificationCustomDTO =(ModificationCustomDTO)selectedModificationsMap.get(actionForm.getModificationTypeCode());
         modificationCustomDTO.setStatus(BaseAgreementModificationStatusConstant.Active);
         selectedModificationsMap.put(actionForm.getModificationTypeCode(),modificationCustomDTO);
         baseAgreementDetailsCustomDTO.setModificationDetailsMap(selectedModificationsMap);
     }
 	session.storeObjectToSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS,baseAgreementDetailsCustomDTO);

	
		  TreeMap SelectedMap = displayModificationViewBean.getSelectedModifications();
		  DisplayModificationDetailViewBean displayModificationDetailViewBean =  (DisplayModificationDetailViewBean)SelectedMap.get(actionForm.getModificationTypeCode());
		  displayModificationDetailViewBean.setStatus(BaseAgreementModificationStatusConstant.Active);
		  SelectedMap.put(actionForm.getModificationTypeCode(),displayModificationDetailViewBean);
		  displayModificationViewBean.setSelectedModifications(SelectedMap);
		  session.storeObjectToSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN,displayModificationViewBean);
		  viewBean = displayModificationViewBean;

			 if(baseAgreementDetailsCustomDTO != null && baseAgreementDetailsCustomDTO.getAgreementId() > 0) {
				setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION_FOR_AMEND);
				session.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,new Boolean(true));
			  }else {
				setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION);
			 }
				    // Added by Balaji for UI standards - Ends
	 return viewBean;
	}

	
	//Method added by Tapan Malhotra
	private OPPTViewBean applyToAllModification(OPPTSession session)throws Exception {
		ErrorReport errorReport = null;
		OPPTViewBean viewBean = null;
		DisplayModificationDetailViewBean displayModificationDetailViewBean = null;
		
		//ModificationContactActionForm actionForm =(ModificationContactActionForm)form;
		//session.storeObjectToSession(SessionConstants.SESSION_MODIFICATIONADDCONTACT_ACTIONFORM,actionForm);
		ModificationContactActionForm actionForm =(ModificationContactActionForm) session.getObjectFromSession(SessionConstants.SESSION_MODIFICATIONCONTACT_ACTIONFORM);
		displayModificationDetailViewBean = new DisplayModificationDetailViewBean();
		DisplayModificationViewBean displayModificationViewBean = (DisplayModificationViewBean)session.getObjectFromSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN);
		session.storeObjectToSession(SessionConstants.SESSION_ACCOUNTING_CONTACT,actionForm.getAccountingContact());
		session.storeObjectToSession(SessionConstants.SESSION_LEGAL_CONTACT,actionForm.getLegalContact());
    	BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
    	customDto.setAccountingContactHdr(actionForm.getAccountingContact());
	    customDto.setLegalContactHdr(actionForm.getLegalContact());
    	TreeMap map = customDto.getModificationDetailsMap();
    	TreeMap viewbeanMap = displayModificationViewBean.getSelectedModifications();
    	if(customDto.getModificationDetailsMap().size()!= 0){
	    	String key = null;
	    	ModificationCustomDTO  modificationCustomDTO = null;
	    	for(Iterator i = map.keySet().iterator();i.hasNext();){
	    	    key = (String)i.next();
	        	modificationCustomDTO =(ModificationCustomDTO) map.get(key);
	        	modificationCustomDTO.setLegalContract(actionForm.getLegalContact());
	        	modificationCustomDTO.setAccountingContact(actionForm.getAccountingContact());
	    	customDto.setModificationDetailsMap(map);
	    	
	    }
     
		      String key1 = null;
		      for(Iterator i = viewbeanMap.keySet().iterator();i.hasNext();){
		      	key1= (String)i.next();
		     	displayModificationDetailViewBean =(DisplayModificationDetailViewBean)viewbeanMap.get(key1);
		     	displayModificationDetailViewBean.setLegalContact(actionForm.getLegalContact());
		     	displayModificationDetailViewBean.setAccountingContact(actionForm.getAccountingContact());
		     }
      }
     	displayModificationViewBean.setActionForm(actionForm);
      	displayModificationViewBean.setSelectedModifications(viewbeanMap);
    	viewBean = displayModificationViewBean;
    	setForwardName(ForwardNameConstants.PAGE_REFRESH_DETAILS_MODIFICATION);
    	session.storeObjectToSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN,displayModificationViewBean);
    	session.storeObjectToSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS,customDto);
		return viewBean;
	}


	
	
	//	Method added by Nayanatara L Pai
	private OPPTViewBean deleteForm(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		ErrorReport errorReport = null;
		
		FormDetailsCustomDTO formDetailsCustomDTO = (FormDetailsCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_FORM_DETAILS_CUSTOMDTO);
		try{
			getBaseAgreementDataManager().deleteForm(formDetailsCustomDTO);
	        //setForwardName(ForwardNameConstants.PAGE_FORM_MAINTENANCE_ACTION);  //$NON-NLS-1$
			setForwardName(ForwardNameConstants.PAGE_DISPLAY_FORM_LIST_ACTION);
		}
		catch(ServiceException se){
			viewBean = new ErrorViewBean();
			viewBean.setErrorReport(se.getErrorReport());
			setForwardName(ForwardNameConstants.PAGE_ERROR);
		}
        return viewBean;
	}
	
	/**
     * getUserManager
     * 
     * @throws java.lang.Exception
     * @return BaseAgreementManager
     * @author Ravi Yandapalli
     */
    protected BaseAgreementDataManager getBaseAgreementDataManager() throws Exception {
        BaseAgreementDataManagerHome baseAgreementDataManagerHome = (BaseAgreementDataManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("BaseAgreementDataManagerHome");  //$NON-NLS-1$
		return baseAgreementDataManagerHome.create();
	}
	private OPPTViewBean removeSVCLicenses(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		ProposalCustomDTO customDTO = getCurrentProposal(session);
		if(null != customDTO){
			setTransactionInformation(customDTO, session);
			customDTO.setTransactionName(ActionNameConstants.REMOVE_SVC_LICENSES);
			
			try {
				getProposalManager().removeSVCLicenses(customDTO);
				setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
			}
			catch(ServiceException se){
				viewBean = new ErrorViewBean();
				viewBean.setErrorReport(se.getErrorReport());
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
		}
		
		return viewBean;
	}

	private DeleteInventoryCustomDTO getInventoryToBeDeleted(OPPTSession session){
		DeleteInventoryCustomDTO customDTO = null;
		if(null != session){
			customDTO = (DeleteInventoryCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_INVENTIORY_TO_BE_DELETED);
		}
		return customDTO;
	}
	private void removeInventoryToBeDeleted(OPPTSession session){
		if(null != session){
			session.removeObjectFromSession(SessionConstants.SESSION_INVENTIORY_TO_BE_DELETED);
		}
	}
	private OPPTViewBean deleteInventory(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		DeleteInventoryCustomDTO customDTO = getInventoryToBeDeleted(session);
		if(null != customDTO){
			customDTO.setConfirmationRequired(false);
			customDTO.setTransactionName(ActionNameConstants.DELETE_INVENTORY);
			
			try {
				getProposalManager().deleteInventory(customDTO);
				removeInventoryToBeDeleted(session);
				setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
			}
			catch(ServiceException se){
				viewBean = new ErrorViewBean();
				viewBean.setErrorReport(se.getErrorReport());
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
		}
		
		return viewBean;
	}

	private ConfigureDMCustomDTO getConfigureDM(OPPTSession session){
		ConfigureDMCustomDTO customDTO = null;
		if(null != session){
			customDTO = (ConfigureDMCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_CONFIGURE_DM);
		}
		return customDTO;
	}
   
	private void removeConfigureDM(OPPTSession session){
		if(null != session){
			session.removeObjectFromSession(SessionConstants.SESSION_CONFIGURE_DM);
		}
	}
	private OPPTViewBean cancelConfigureDM(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		ConfigureDMCustomDTO customDTO = getConfigureDM(session);
		if(null != customDTO){
			customDTO.setConfirmationRequired(false);
			
			try {
				getProposalManager().cancelConfigureDM(customDTO);
				removeConfigureDM(session);
				setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
			}
			catch(ServiceException se){
				viewBean = new ErrorViewBean();
				viewBean.setErrorReport(se.getErrorReport());
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
		}
		
		return viewBean;
	}

	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);			
		}
		return currentProposal;
	}

	private ProposalHeaderCustomDTO getChangeProposalHeader(OPPTSession session){
		ProposalHeaderCustomDTO customDTO = null;
		if(null != session){
			customDTO = (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
		}
		return customDTO;
	}
	private OPPTViewBean changeProposalHeader(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		ProposalHeaderCustomDTO customDTO = getChangeProposalHeader(session);
		if(null != customDTO){
			customDTO.setConfirmationRequired(false);
			
			try {
				customDTO = getProposalManager().validateProposalHeader(customDTO);
				addDataStoreEntry(session, customDTO);
				if(customDTO.isProposalDetails()){
					setForwardName(ForwardNameConstants.ACTION_PROPOSAL_DETAILS);
				}
				else if(customDTO.isChangeVarianceProposal()){
					viewBean = handlePartnerSelection(session, customDTO);
				}
				else{
					viewBean = new PartnerDetailsViewBean(session.getUserInfo().getRole() == RoleConstants.BUSINESS_PARTNER, true, customDTO.getPartnerInformationCustomDTO(), customDTO.getSecondaryProposalCustomDTO().getComments());
					setPartnerDetailsForwardName(getRole(session));
				}
			}
			catch(ServiceException se){
				viewBean = new ErrorViewBean();
				viewBean.setErrorReport(se.getErrorReport());
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
		}
		
		return viewBean;
	}
	private OPPTViewBean handlePartnerSelection(OPPTSession session, ProposalHeaderCustomDTO proposalHeader) throws Exception {
		OPPTViewBean viewBean = null;
		
		FetchPartnerInformationCustomDTO customDTO = new FetchPartnerInformationCustomDTO();
		customDTO.setProposalDTO(proposalHeader.getProposal());
		setTransactionInformation(customDTO, session);
		customDTO.setTransactionName(proposalHeader.getTransactionName());
		customDTO.setDivisionCode(proposalHeader.getBasicProposalCustomDTO().getDivision());
		customDTO.setDistributionChannel(proposalHeader.getBasicProposalCustomDTO().getDistributionChannel());
		customDTO.setSelectedSalesOrg(proposalHeader.getBasicProposalCustomDTO().getSalesOrganization());
		String igfOfferNumber = proposalHeader.getSecondaryProposalCustomDTO().getIgfOfferNumber();
		if(null != igfOfferNumber && 0 < igfOfferNumber.length()){
			customDTO.setIGFFlag(true);
		}

		try{
			customDTO = getProposalManager().fetchPartnerInformationForCustomer(customDTO);
			ErrorReport messageReport = customDTO.getMessageReport();
			if(null == messageReport){
				session.storeObjectToSession(SessionConstants.PROPOSAL_CREATION_PARTNERS, customDTO);
				addDataStoreEntry(session, customDTO);
				TreeMap customers = null;
				if(null != proposalHeader.getPartnerInformationCustomDTO()){
					//customerLists = proposalHeader.getPartnerInformationCustomDTO().getCustomerLists(); changed according to DADO02
					customers = convertListToMap(proposalHeader.getPartnerInformationCustomDTO().getSelectedCustomers()); //DADO02 Sataeesh Anne
				}
				viewBean = new PartnerSelectionViewBean(customDTO, customers, proposalHeader.getSecondaryProposalCustomDTO().getComments(), true, false);
				setPartnerSelectionForwardName(getRole(session));
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(messageReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}

		}
		catch(ServiceException se){
			viewBean = handleErrorReport(se.getErrorReport(), ForwardNameConstants.ACTION_PROPOSAL_MAINTENANCE, true);
		}
		
		return viewBean;
	}

	private ProposalCustomDTO getProposalToBeApproved(OPPTSession session){
		ProposalCustomDTO customDTO = null;
		if(null != session){
			customDTO = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_TO_BE_APPROVED);
		}
		return customDTO;
	}
 	private void removeProposalToBeApproved(OPPTSession session){
		if(null != session){
			session.removeObjectFromSession(SessionConstants.PROPOSAL_TO_BE_APPROVED);
		}
	}
	private OPPTViewBean approveProposal(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		ProposalCustomDTO customDTO = getProposalToBeApproved(session);
		if(null != customDTO){
			customDTO.setConfirmationRequired(false);
			
			try {
				getProposalManager().approveRequest(customDTO);
				removeProposalToBeApproved(session);
//				Commented and added for the change DAD O11 Remove approval step,Blue Harmony -Ramesh
				//setForwardName(ForwardNameConstants.ACTION_PROPOSALS_FOR_APPROVAL);
				setForwardName(ForwardNameConstants.ACTION_PROPOSAL_MAINTENANCE);	//added by Ramesh
			}
			catch(ServiceException se){
				viewBean = new ErrorViewBean();
				viewBean.setErrorReport(se.getErrorReport());
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
		}
		
		return viewBean;
	}
	
	private OPPTViewBean revertProposal(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
	
		ContractCustomDTO customDTO = getProposalToBeReverted(session);
		if(null != customDTO){
			customDTO.setConfirmationRequired(false);
		
			try {
				getProposalManager().revertProposal(customDTO);
				setForwardName(ForwardNameConstants.ACTION_CONTRACT_MAINTENANCE);
			}
			catch(ServiceException se){
				viewBean = new ErrorViewBean();
				viewBean.setErrorReport(se.getErrorReport());
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
		}

		return viewBean;
	}
	
	private OPPTViewBean createProposal(OPPTSession session){
		OPPTViewBean viewBean = null;
		
		ProposalHeaderCustomDTO customDTO = getProposalHeader(session);
		if(null != customDTO){
			viewBean = new PartnerDetailsViewBean(session.getUserInfo().getRole() == RoleConstants.BUSINESS_PARTNER, false, null, customDTO.getSecondaryProposalCustomDTO().getComments());
			switch(getRole(session)){
				case Constants.PROPOSAL_CREATE_APPROVER: 
									setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PARTNER_DETAILS);
									break;

				case Constants.PROPOSAL_ADMINISTRATOR:
				default:
									setForwardName(ForwardNameConstants.PAGE_PARTNER_DETAILS);
									break;
			}
		}
		else{
			viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA47), ForwardNameConstants.ACTION_PROPOSAL_MAINTENANCE, true);
			setForwardName(ForwardNameConstants.PAGE_ERROR);
		}

		
		return viewBean;
	}
	private ProposalHeaderCustomDTO getProposalHeader(OPPTSession session){
		return (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
	}

	private OPPTViewBean removeQuotes(OPPTSession session) throws Exception {
			OPPTViewBean viewBean = null;
	
			ProposalCustomDTO  customDTO = getCurrentProposal(session);
			if(null != customDTO){
				customDTO.setConfirmationRequired(false);
				setTransactionInformation(customDTO, session);
				customDTO.setTransactionName(ActionNameConstants.REMOVE_QUOTES);
				try {
					getProposalManager().removeQuotes(customDTO);
					setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
				}
				catch(ServiceException se){
					viewBean = new ErrorViewBean();
					viewBean.setErrorReport(se.getErrorReport());
					setForwardName(ForwardNameConstants.PAGE_ERROR);
				}
			}

			return viewBean;
		}
	
	
	private ContractCustomDTO getProposalToBeReverted(OPPTSession session){
		ContractCustomDTO customDto=null;
		
		if(null != session){
			customDto = (ContractCustomDTO)session.getObjectFromSession(SessionConstants.REVERT_PROPOSAL);
		}
		
		return customDto;
	}
	
	private void removeRevertProposal(OPPTSession session){
		if(null != session){
			session.removeObjectFromSession(SessionConstants.REVERT_PROPOSAL);
		}
	}
	
	private UserContractsCustomDTO getUserContract(OPPTSession session){
		UserContractsCustomDTO customDto=null;
		if(null != session){
			customDto = (UserContractsCustomDTO)session.getObjectFromSession(SessionConstants.USER_CONTRACT);
		}

		return customDto;
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

	private void setPartnerSelectionForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PARTNER_SELECTION);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_PARTNER_SELECTION);
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
	
	private TreeMap convertListToMap(List selectedCustomers){
		TreeMap customers = new TreeMap();
		if(null!=selectedCustomers){
			Iterator iterator = selectedCustomers.iterator();
			while(iterator.hasNext()){
				CustomerListCustomDTO customer = (CustomerListCustomDTO)iterator.next();
				customers.put(customer.getCustomerNumber(),customer);
			}
		}
		
		return customers;
		
	}
}

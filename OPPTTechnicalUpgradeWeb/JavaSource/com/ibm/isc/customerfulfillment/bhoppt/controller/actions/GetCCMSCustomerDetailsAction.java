/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.security.Security;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.struts.action.ActionForm;

import com.ibm.ci.ccms.common.bus.enums.KeyTypeEnum;
import com.ibm.ci.ccms.common.bus.enums.LingualString;
import com.ibm.ci.ccms.common.bus.enums.RolePlayerNameType;
import com.ibm.ci.ccms.common.bus.enums.SearchTypeEnum;
import com.ibm.ci.ccms.common.bus.excep.WSException;
import com.ibm.ci.ccms.common.bus.qo.ClientQueryToken;
import com.ibm.ci.ccms.common.bus.qo.SearchCriteria;
import com.ibm.ci.ccms.common.bus.qo.SubDataCriteria;
import com.ibm.ci.ccms.common.bus.vo.Address;
import com.ibm.ci.ccms.common.bus.vo.CMRResult;
import com.ibm.ci.ccms.common.bus.vo.ClientResultToken;
import com.ibm.ci.ccms.common.bus.vo.CustomerMasterRecordView;
import com.ibm.ci.ccms.common.bus.vo.OrganizationView;
import com.ibm.ci.ccms.common.bus.vo.RolePlayerName;
import com.ibm.ci.ccms.common.bus.vo.SAPInformation;
import com.ibm.ci.ccms.common.bus.vo.SearchResult;
import com.ibm.ci.ccms.common.bus.vo.SiteView;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CCMSCustomerSelectionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CCMSCustomerSelectionViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.CCMSDataDAO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.CCMSCustomerDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.CCMSCustomerSelectionCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.CCMSDataCustomDTO;
import com.ibm.w3.WSCCMSBusService;
import com.ibm.ws.webservices.engine.client.Stub;

/**
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class GetCCMSCustomerDetailsAction extends OPPTLongAction {

    private static final String CLASS_NAME = "GetCCMSCustomerDetailsAction";
    
    static {
        System.setProperty("javax.net.ssl.trustStore",OPPTPropertiesReader.getCCCMSServerTrustFile());
        System.setProperty("javax.net.ssl.trustStorePassword", "WebAS");
        System.setProperty("javax.net.ssl.keyStore",OPPTPropertiesReader.getCCCMSServerKeyFile());
        System.setProperty("javax.net.ssl.keyStorePassword", "WebAS");
        System.setProperty("java.protocol.handler.pkgs","com.ibm.net.ssl.internal.www.protocol");
        Security.addProvider(new com.ibm.jsse.IBMJSSEProvider());
    }
    
    private static ErrorReport errorReport = new ErrorReport();
    /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Ravi Yandapalli
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
    
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
            throws Exception {
    	
		OPPTViewBean viewBean = null;
		CCMSCustomerSelectionActionForm actionForm=null;
		ArrayList dtoList = null;
		actionForm = (CCMSCustomerSelectionActionForm)form;
		CCMSCustomerSelectionCustomDTO customDTO = new CCMSCustomerSelectionCustomDTO();
		String countryCode= actionForm.getCountryCode();
		customDTO.setCountryCode(OPPTHelper.trimString(countryCode));
		customDTO.setCMRNumber(OPPTHelper.trimString(actionForm.getCmrNumber()));
		customDTO.setEnterpriseNumber(OPPTHelper.trimString(actionForm.getEnterpriseNumber()));
		try{
		dtoList = getCCMSCall(customDTO);
		
		}catch(Exception e){
		    e.printStackTrace();
		}
		if(dtoList != null && dtoList.size()!=0){
		    
		    customDTO.setCustomerList(dtoList);
			viewBean = new CCMSCustomerSelectionViewBean(customDTO);
			session.storeObjectToSession(SessionConstants.SESSION_CCMSCUSTOMER_SELECTION_VIEWBEAN,viewBean);
			setForwardName(ForwardNameConstants.PAGE_CCMSCUSTOMER_FETCH);
		
			}else{
			    errorReport = new ErrorReport(); 
	              errorReport.put(new ErrorKey(ErrorCodeConstants.PA53, OPPTMessageCatalog.TYPE_PRESENTATION),null);  
	          viewBean = new CCMSCustomerSelectionViewBean();
				viewBean.setErrorReport(errorReport);
				viewBean.setActionForm(actionForm);
				setForwardName(ForwardNameConstants.PAGE_CCMSCUSTOMER_FETCH);
		
			}
		
        return viewBean;
    }

    
    
    private ArrayList getCCMSCall(CCMSCustomerSelectionCustomDTO customDTO){
       
        ArrayList dtoList = new ArrayList();
        SearchResult searchResult = null;
        CustomerMasterRecordView cmrArray[] = null;
        SearchCriteria searchCriteria = new SearchCriteria();
       
        WSCCMSBusService busSvc;
        try {
            busSvc = getBusService();
            ClientQueryToken cq = getClientQueryToken();

            cq.setMaxRsltCnt(3);
            cq.setRequestTimestamp(Calendar.getInstance());
            searchCriteria.setClientQueryToken(cq);
            if(customDTO.getCMRNumber()!=null &&customDTO.getCMRNumber().length()!=0){
		            searchCriteria.setSearchType(SearchTypeEnum.KEY);
		            searchCriteria.setKeyType(KeyTypeEnum.CMR);
		            searchCriteria.setKey(customDTO.getCMRNumber());
		            searchCriteria.setCMRSystemLocationCode(customDTO.getCountryCode());
		     }else{
                if(customDTO.getEnterpriseNumber()!=null &&customDTO.getEnterpriseNumber().length()!=0){
                  
                    searchCriteria.setSearchType(SearchTypeEnum.KEY);
		            searchCriteria.setKeyType(KeyTypeEnum.ENTERPRISE);
		            searchCriteria.setKey(customDTO.getEnterpriseNumber());
		            searchCriteria.setCMRSystemLocationCode(customDTO.getCountryCode());
		        }
                
            }
            searchResult = busSvc.searchParties(searchCriteria);
            if (searchResult != null) {
                ClientResultToken  ct = searchResult.getClientResultToken();
                if ( ct.getResultCnt() > 0 ){
                 	  OrganizationView[] ov = searchResult.getOrganizationViews();
                    dtoList = populateDTO(ov,cq,customDTO);
            }
            }
    
        } catch (WSException e){
          // system.out.println(e.getErrorCode() + ", " + e.getErrorMessage() + ", " + e.isIsSysError());
        }
        catch (Exception e){
            e.printStackTrace();
            //throw e;
    }
      
        
    return dtoList;
    }
    

    
    private WSCCMSBusService getBusService() throws ServiceException, javax.xml.rpc.ServiceException {
        
        CCMSDataCustomDTO customDTO = null;
        WSCCMSBusService wf = null; 
		com.ibm.ci.ccms.bus.service.facade.WSCCMSServiceLocator wfsl = new com.ibm.ci.ccms.bus.service.facade.WSCCMSServiceLocator();
	 
		CCMSDataDAO ccmsDataDao = new CCMSDataDAO();
		  try {
		      customDTO = ccmsDataDao.retriveCCMSData();
		 	} catch(Exception de){		
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"retriveCCMSData",de.getMessage());
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);	
			}
			
		if (wf == null) {
		    if(customDTO !=null){
		try {
    	wf = (WSCCMSBusService) wfsl.getCCMSBusService_Port(new URL(customDTO.getURL()));
		//if (false) {
    		 Stub tmp = (Stub) wf;
	        tmp.setUsername(customDTO.getCCMSUserID());
	       tmp.setPassword(customDTO.getPassWord());
	       wf = (WSCCMSBusService) tmp;
	       // } 
	        return wf;
	    } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		    }
	 }
		
		return wf;
    }
    
    /**
     * @return
     */
    private ClientQueryToken getClientQueryToken() {
        ClientQueryToken ct = new ClientQueryToken();
        ct.setClientId("manish_999");
        ct.setEndUserId("manish_999");
        return ct;
    }
    
    /**
     * @param orgViewArray
     */
    private ArrayList populateDTO(OrganizationView[] orgViewArray,ClientQueryToken cq,CCMSCustomerSelectionCustomDTO customDTO) {
        SubDataCriteria input = new SubDataCriteria(); 
        CMRResult result = null;
        WSCCMSBusService busSvc;
        ArrayList dtoList = new ArrayList();
        try {
        busSvc = getBusService();
        if (orgViewArray != null) {
        int size = orgViewArray.length;
        String city = null;
        String street = null;
        RolePlayerName[] rpn = null;
        SiteView mainSite = null;
        SiteView sites[] = null;
        String name = null;
        String type = null;
        String businessName = null;
        String legalName = null;
       for(int i=0;i<size;i++) {
            if (orgViewArray[i] != null) {
                
                input.setClientQueryToken(cq);
                input.setKey(orgViewArray[i].getUniqueReferenceNumber());
                input.setKeyType(KeyTypeEnum.URN);
                result = busSvc.getCMRs(input);
                Address[] address= orgViewArray[i].getAddresses();
                if(address!=null && address.length !=0){
                    for(int add=0;add<address.length;add++){
                        Address obj = address[add];
                        city = obj.getCity(); 
                        street= obj.getStreetAddress();
                    }
                }
                
                RolePlayerName[] rolePlayerName = orgViewArray[i].getNames();
                if(rolePlayerName!=null && rolePlayerName.length!=0){
                	for(int rpname =0;rpname<rolePlayerName.length;rpname++){
                		RolePlayerName roleName = rolePlayerName[rpname];
                		LingualString lingualString = roleName.getRolePlayerName();
                		RolePlayerNameType roleplayerNameType = roleName.getRoleplayerNameType();
                		if(roleplayerNameType.getCode()!= null && roleplayerNameType.getCode().equals("BU")){
                			businessName = lingualString.getValue();
                		}
                		if(roleplayerNameType.getCode()!= null && roleplayerNameType.getCode().equals("LE")){
                			legalName = lingualString.getValue();
                		}
                		
                	}
                }
                
                if (result != null) {
                    CustomerMasterRecordView cmrArray[] = result.getCMRs();
                    if ((cmrArray != null) && cmrArray.length > 0){
                        for(int j=0;j<cmrArray.length;j++){
                          SAPInformation sap[] =cmrArray[j].getSapInformation(); 
                          if ((sap != null) && sap.length > 0){
                              for(int k=0;k<sap.length;k++){
                                  if(customDTO.getCMRNumber()!= null && customDTO.getCMRNumber().equals(cmrArray[j].getCMRNumber())){
                                      CCMSCustomerDetailsCustomDTO detailsCustomDTO = new CCMSCustomerDetailsCustomDTO();
                                      detailsCustomDTO.setURN(orgViewArray[i].getUniqueReferenceNumber());
		                                  detailsCustomDTO.setINAC(orgViewArray[i].getINAC());
		                                  detailsCustomDTO.setCMRNumber(cmrArray[j].getCMRNumber());
		                                  detailsCustomDTO.setEnterPriseNumber(cmrArray[j].getEnterPriseNumber());
		                                  detailsCustomDTO.setSapCustomerNumber(sap[k].getSapCustomerNumber());
		                                  detailsCustomDTO.setCustomerAccountGroup(sap[k].getCustomerAccountGroup());
		                                  detailsCustomDTO.setCountry(cmrArray[j].getCMRSystemLocation().getCode());
		                                  detailsCustomDTO.setCity(city);
		                                  detailsCustomDTO.setStreet(street);
		                                  detailsCustomDTO.setBusinessName(businessName);
		                                  detailsCustomDTO.setLegalName(legalName);
		                                  dtoList.add(detailsCustomDTO);
		                          }else{
		                              if(customDTO.getEnterpriseNumber()!= null&&customDTO.getEnterpriseNumber().length() !=0 && customDTO.getEnterpriseNumber().equals(cmrArray[j].getEnterPriseNumber())){
                                 CCMSCustomerDetailsCustomDTO detailsCustomDTO = new CCMSCustomerDetailsCustomDTO();
	                                  detailsCustomDTO.setURN(orgViewArray[i].getUniqueReferenceNumber());
	                                  detailsCustomDTO.setINAC(orgViewArray[i].getINAC());
	                                  detailsCustomDTO.setCMRNumber(cmrArray[j].getCMRNumber());
	                                  detailsCustomDTO.setEnterPriseNumber(cmrArray[j].getEnterPriseNumber());
	                                  detailsCustomDTO.setSapCustomerNumber(sap[k].getSapCustomerNumber());
	                                  detailsCustomDTO.setCustomerAccountGroup(sap[k].getCustomerAccountGroup());
	                                  detailsCustomDTO.setCountry(cmrArray[j].getCMRSystemLocation().getCode());
	                                  detailsCustomDTO.setCity(city);
	                                  detailsCustomDTO.setStreet(street);
	                                  detailsCustomDTO.setBusinessName(businessName);
	                                  detailsCustomDTO.setLegalName(legalName);
	                                  dtoList.add(detailsCustomDTO);
	                                  
                              }
                                  }
                              }
                             }
                        
                        }
                    }
                }
            }
          }
       
        }
        } catch (WSException e){
            // system.out.println(e.getErrorCode() + ", " + e.getErrorMessage() + ", " + e.isIsSysError());
        }
        catch (Exception e){
            e.printStackTrace();
    }
        return dtoList;
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
	 * @author Ravi Yandapalli
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return String
	 * 
	 */
    protected String getActionName() {
        return ActionNameConstants.GET_CCMSCUSTOMER_DETAILS;
    }

    /**
     * validate current view bwan
     * 
     * 
     * @return
     * @author Ravi Yandapalli
     * @param session
     */  
    protected boolean validateCurrentViewContent(OPPTSession session) {
        boolean valid = false;
        
        OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = ForwardNameConstants.PAGE_CCMSCUSTOMER_FETCH;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof CCMSCustomerSelectionViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new CCMSCustomerSelectionViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		return valid;
    }

}

/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.reports;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.avalon.framework.logger.Logger;
import org.apache.fop.apps.Driver;
import org.apache.fop.messaging.MessageHandler;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.w3c.dom.Document;

import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementReportConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementReportExcelViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.CompareTPReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.ContractAmendmentReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.ContractAttachmentReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.ContractPlanningReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.DeletedSWOReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.InventoryListReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.ListEntitledPricesReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.DeletedUsersReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.PrintProposalViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.ReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.ReverificationReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.SysplexReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.VarianceReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ReportTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CompareTPReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractAmendmentReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractAttachmentReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractPlanningReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeletedSWOReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryListReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ListEntitledPricesReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PrintProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReportsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReverificationReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeletedUsersReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SysplexReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceHeaderInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceRptCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportDetailCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationCustomDTO;


/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ReportGeneratorServlet extends HttpServlet {
	private final String BASEPATH = "/XSL/";  //$NON-NLS-1$
	private Logger log = null;

	/**
     * doGet
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     * @author thirumalai
     */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		OPPTSession opptSession = new OPPTSession(request.getSession());
		boolean viewReport = false;
		String reportType = null;
		String actionName = opptSession.getLastActionID();
		if (actionName != null
			&& (actionName.equalsIgnoreCase(ActionNameConstants.VIEW_REPORT)
				|| actionName.equalsIgnoreCase(ActionNameConstants.VIEW_CHECK_REPORT)
				|| actionName.equalsIgnoreCase(ActionNameConstants.PRINT_PROPOSAL)
				|| actionName.equalsIgnoreCase(ActionNameConstants.VIEW_REVERIFICATION_REPORT))) { /* CR4520 */
			viewReport = true;
		}
					
		try {
			try {
				ReportViewBean view = null;
				BaseAgreementReportExcelViewBean baseAgreementReportExcelViewBean = null;
				Date date = new Date();
				SimpleDateFormat format = null;
				format = new SimpleDateFormat("MM/dd/yyyy");
				
				//Define the column names
				String inacNo = "";				//1
				String enterpriseNo = "";		//2
				String customerNo = "";			//3
				String customerName = "";		//4
				String formNo = "";				//5
				String versionNo = "";			//6
				String formDesc = "";			//7
				String agrNo = "";				//8
				String acceptedDate = "";		//9
				String expirationDate = "";		//10
				String createDate = "";			//11
				String modified = "";			//12
				String modificationTerm = "";	//13
				String modificationDetail = "";	//14
				String modificationDate = "";	//15
				String modstatus = "";	//16
				String bastatus = "";	//17
								
				String salesOrg = "";
				String status = "";
				String today = "";
								
				TreeMap salesOrgMap = new TreeMap();
                TreeMap statusMap = new TreeMap();
                
                salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
                statusMap.putAll(OPPTStaticDataHolder.statusMap);
                				
				//Reports for specific form numbers
				if(actionName != null && actionName.equalsIgnoreCase(ActionNameConstants.GENERATE_REPORTS_BYFORMNUMBER)){
					opptSession.setCurrentViewBean((BaseAgreementReportExcelViewBean)opptSession.getObjectFromSession(SessionConstants.SESSION_EXCEL_VIEWBEAN));
					baseAgreementReportExcelViewBean = (BaseAgreementReportExcelViewBean)opptSession.getCurrentViewBean();
					today = format.format(date);			
					List list  = baseAgreementReportExcelViewBean.getBaseAgreementReportsCustomDTO().getBaseAgreementReportCustomDTOs();
					
					int numberRows = list.size();
					int numberColumns = 12;
					String[][] newarray = new String[numberRows][numberColumns];
					int count = 0;
					for(Iterator i= list.iterator();i.hasNext();){
						BaseAgreementReportCustomDTO customDto =(BaseAgreementReportCustomDTO)i.next();
						if(customDto.getSalesOrg() != null){
							salesOrg = (String)salesOrgMap.get(customDto.getSalesOrg())+ "-" + customDto.getSalesOrg();
						}
						if(customDto.getInputStatus() != null){
							status = (String)statusMap.get(customDto.getInputStatus());
						}					
						if(customDto.getEnterpriseNumber() != null){
							enterpriseNo = (String)customDto.getEnterpriseNumber();
							newarray[count][0] = enterpriseNo;
						}
						if(customDto.getCustomerNumber() != null){
							customerNo = (String)customDto.getCustomerNumber();
							newarray[count][1] = customerNo;
						}
						if(customDto.getCustomerName() != null){
							customerName = (String)customDto.getCustomerName();
							newarray[count][2] = customerName;
						}
						if(customDto.getFormNumber() != null){
							formNo = (String)customDto.getFormNumber();
							newarray[count][3] = formNo;
						}
						if(customDto.getVersionNo() != null){
							versionNo = (String)customDto.getVersionNo();
							newarray[count][4] = versionNo;
						}
						if(customDto.getFormLongDescription()== null){
							if(customDto.getFormShortDescription() != null){
								formDesc = (String)customDto.getFormShortDescription();
								newarray[count][5] = formDesc;
							}
						}
						else
							formDesc = (String)customDto.getFormLongDescription();
							newarray[count][5] = formDesc;
							
						if(customDto.getAgreementNumber() != null){
							agrNo = (String)customDto.getAgreementNumber();
							newarray[count][6] = agrNo;
						}
						if(customDto.getAcceptedDate() != null){
							acceptedDate = format.format(customDto.getAcceptedDate());
							newarray[count][7] = acceptedDate;
						}
						if(customDto.getExpirationDate() != null){
							expirationDate = format.format(customDto.getExpirationDate());
							newarray[count][8] = expirationDate;
						}
						if(customDto.getCreatedDate() != null){
							createDate = format.format(customDto.getCreatedDate());
							newarray[count][9] = createDate;
						}
						if(customDto.getIsModifiedAgreement() != null){
							modified = (String)customDto.getIsModifiedAgreement();
							if(modified.equals("Y")){
                                modified = "Yes";
	                        }
	                        else
                                modified = "No";
							newarray[count][10] = modified;
						}
						if(customDto.getStatus() != null){
							bastatus   = (String)customDto.getStatus();
							if(bastatus.equals("A")){
								bastatus = "Active";
	                        }
	                        else
	                        	bastatus = "Inactive";
							newarray[count][11] = bastatus ;
						}
						count++;		
												
					}
					renderExcelDedicatedFormNumbers(response,newarray,salesOrg,today,status);
					opptSession.setCurrentForward(ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_FORMNUMBER);
				}
										
				//If Report of all registered base agreements is to be generated
				else if(actionName != null && actionName.equalsIgnoreCase(ActionNameConstants.GENERATE_REPORTS_BASEAGREEMENTS)){
					baseAgreementReportExcelViewBean = (BaseAgreementReportExcelViewBean)opptSession.getCurrentViewBean();
																		
					today = format.format(date);
					List list  = baseAgreementReportExcelViewBean.getBaseAgreementReportsCustomDTO().getBaseAgreementReportCustomDTOs();
					
					int numberRows = list.size();
					int numberColumns = 11;
					String[][] newarray = new String[numberRows][numberColumns];
					int count = 0;
					for(Iterator i= list.iterator();i.hasNext();){
						BaseAgreementReportCustomDTO customDto =(BaseAgreementReportCustomDTO)i.next();
						
						if(customDto.getSalesOrg() != null){
							salesOrg = (String)salesOrgMap.get(customDto.getSalesOrg()) + "-" + customDto.getSalesOrg();
						}
											
						if(customDto.getStatus() != null){
							status = (String)statusMap.get(customDto.getStatus());
						}
						
						if(customDto.getEnterpriseNumber() != null){
							enterpriseNo = (String)customDto.getEnterpriseNumber();
							newarray[count][0] = enterpriseNo;
						}
						if(customDto.getCustomerNumber() != null){
							customerNo = (String)customDto.getCustomerNumber();
							newarray[count][1] = customerNo;
						}
						if(customDto.getCustomerName() != null){
							customerName = (String)customDto.getCustomerName();
							newarray[count][2] = customerName;
						}
						if(customDto.getFormNumber() != null){
							formNo = (String)customDto.getFormNumber();
							newarray[count][3] = formNo;
						}
						if(customDto.getVersionNo() != null){
							versionNo = (String)customDto.getVersionNo();
							newarray[count][4] = versionNo;
						}
						if(customDto.getFormLongDescription()== null){
							if(customDto.getFormShortDescription() != null){
								formDesc = (String)customDto.getFormShortDescription();
								newarray[count][5] = formDesc;
							}
						}
						else
							formDesc = (String)customDto.getFormLongDescription();
							newarray[count][5] = formDesc;
							
						if(customDto.getAgreementNumber() != null){
							agrNo = (String)customDto.getAgreementNumber();
							newarray[count][6] = agrNo;
						}
						if(customDto.getAcceptedDate() != null){
							acceptedDate = format.format(customDto.getAcceptedDate());
							newarray[count][7] = acceptedDate;
						}
						if(customDto.getExpirationDate() != null){
							expirationDate = format.format(customDto.getExpirationDate());
							newarray[count][8] = expirationDate;
						}
						if(customDto.getCreatedDate() != null){
							createDate = format.format(customDto.getCreatedDate());
							newarray[count][9] = createDate;
						}
						if(customDto.getIsModifiedAgreement() != null){
							modified = (String)customDto.getIsModifiedAgreement();
							if(modified.equals("Y")){
                                modified = "Yes";
	                        }
	                        else
                                modified = "No";
							newarray[count][10] = modified;
						}
						count++;		
							
							
					}
					renderExcelAllBaseAgreements(response,newarray,salesOrg,status,today);
										
				}
				
				// If Report of all registered modifications is to be generated
				else if(actionName != null && actionName.equalsIgnoreCase(ActionNameConstants.GENERATE_REPORTS_MODIFICATION)){
					baseAgreementReportExcelViewBean = (BaseAgreementReportExcelViewBean)opptSession.getCurrentViewBean();
					today = format.format(date);
					List list  = baseAgreementReportExcelViewBean.getBaseAgreementReportsCustomDTO().getBaseAgreementReportDetailCustomDTOs();
					
					int numberRows = list.size();
					int numberColumns = 12;
					String[][] newarray = new String[numberRows][numberColumns];
					int count = 0;
					
					for(Iterator i= list.iterator();i.hasNext();){
						
					BaseAgreementReportDetailCustomDTO baseAgreementReportDetailCustomDTO =(BaseAgreementReportDetailCustomDTO)i.next();
					
						if(baseAgreementReportDetailCustomDTO.getSalesOrg() != null){
							salesOrg = (String)salesOrgMap.get(baseAgreementReportDetailCustomDTO.getSalesOrg()) + "-" + baseAgreementReportDetailCustomDTO.getSalesOrg();
						}
						
						if(baseAgreementReportDetailCustomDTO.getStatus() != null){
							status = (String)statusMap.get(baseAgreementReportDetailCustomDTO.getStatus());
						}
						
						if(baseAgreementReportDetailCustomDTO.getAgreementNumber() != null){
							agrNo = (String)baseAgreementReportDetailCustomDTO.getAgreementNumber();
							newarray[count][6] = agrNo;
						}
								
						if(baseAgreementReportDetailCustomDTO.getEnterpriseNumber() != null){
							enterpriseNo = (String)baseAgreementReportDetailCustomDTO.getEnterpriseNumber();
							newarray[count][0] = enterpriseNo;
						}
						
						if(baseAgreementReportDetailCustomDTO.getCustomerNumber() != null){
							customerNo = (String)baseAgreementReportDetailCustomDTO.getCustomerNumber();
							newarray[count][1] = customerNo;
						}
						
						if(baseAgreementReportDetailCustomDTO.getCustomerName() != null){
							customerName = (String)baseAgreementReportDetailCustomDTO.getCustomerName();
							newarray[count][2] = customerName;
						}
						
						if(baseAgreementReportDetailCustomDTO.getFormNumber() != null){
							formNo = (String)baseAgreementReportDetailCustomDTO.getFormNumber();
							newarray[count][3] = formNo;
						}
						
						if(baseAgreementReportDetailCustomDTO.getVersionNo() != null){
							versionNo = (String)baseAgreementReportDetailCustomDTO.getVersionNo();
							newarray[count][4] = versionNo;
						}
						
						if(baseAgreementReportDetailCustomDTO.getFormLongDescription()== null){
								if(baseAgreementReportDetailCustomDTO.getFormShortDescription() != null){
									formDesc = (String)baseAgreementReportDetailCustomDTO.getFormShortDescription();
									newarray[count][5] = formDesc;
								}
						}
							else
							{
								formDesc = (String)baseAgreementReportDetailCustomDTO.getFormLongDescription();
								newarray[count][5] = formDesc;
								newarray[count][5] = formDesc;
							}	
																		
						if(baseAgreementReportDetailCustomDTO.getAcceptedDate() != null){
							acceptedDate = format.format(baseAgreementReportDetailCustomDTO.getAcceptedDate());
							newarray[count][7] = acceptedDate;
						}
						
						if(baseAgreementReportDetailCustomDTO.getExpirationDate() != null){
							expirationDate = format.format(baseAgreementReportDetailCustomDTO.getExpirationDate());
							newarray[count][8] = expirationDate;
						}
						
						if(baseAgreementReportDetailCustomDTO.getModificationTypeCode() != null){
							modificationTerm = (String)baseAgreementReportDetailCustomDTO.getModificationTypeCode();
							newarray[count][9] = modificationTerm;
						}
						
						if(baseAgreementReportDetailCustomDTO.getDetails() != null){
							modificationDetail  = (String)baseAgreementReportDetailCustomDTO.getDetails();
							newarray[count][10] = modificationDetail;
						}
						
						if(baseAgreementReportDetailCustomDTO.getModCreatedDate() != null){
							modificationDate   = format.format(baseAgreementReportDetailCustomDTO.getModCreatedDate());
							newarray[count][11] = modificationDate ;
						}
												
						count++;	
					}
					renderExcelAllRegisteredModifications(response,newarray,salesOrg,status,today);
				}
					
			//modified 
				else if(actionName != null && actionName.equalsIgnoreCase(ActionNameConstants.GENERATE_REPORTS_BYMODTYPE)){
					baseAgreementReportExcelViewBean = (BaseAgreementReportExcelViewBean)opptSession.getCurrentViewBean();
					today = format.format(date);
					List list  = baseAgreementReportExcelViewBean.getBaseAgreementReportsCustomDTO().getBaseAgreementReportDetailCustomDTOs();
					
					int numberRows = list.size();
					int numberColumns = 13;
					String[][] newarray = new String[numberRows][numberColumns];
					int count = 0;
					
					for(Iterator i= list.iterator();i.hasNext();){
						
					BaseAgreementReportDetailCustomDTO baseAgreementReportDetailCustomDTO =(BaseAgreementReportDetailCustomDTO)i.next();
					
						if(baseAgreementReportDetailCustomDTO.getSalesOrg() != null){
							salesOrg = (String)salesOrgMap.get(baseAgreementReportDetailCustomDTO.getSalesOrg()) + "-" + baseAgreementReportDetailCustomDTO.getSalesOrg();
						}
						if(baseAgreementReportDetailCustomDTO.getInputStatus() != null){
							status = (String)statusMap.get(baseAgreementReportDetailCustomDTO.getInputStatus());
						}
												
						if(baseAgreementReportDetailCustomDTO.getAgreementNumber() != null){
							agrNo = (String)baseAgreementReportDetailCustomDTO.getAgreementNumber();
							newarray[count][6] = agrNo;
						}
								
						if(baseAgreementReportDetailCustomDTO.getEnterpriseNumber() != null){
							enterpriseNo = (String)baseAgreementReportDetailCustomDTO.getEnterpriseNumber();
							newarray[count][0] = enterpriseNo;
						}
						
						if(baseAgreementReportDetailCustomDTO.getCustomerNumber() != null){
							customerNo = (String)baseAgreementReportDetailCustomDTO.getCustomerNumber();
							newarray[count][1] = customerNo;
						}
						
						if(baseAgreementReportDetailCustomDTO.getCustomerName() != null){
							customerName = (String)baseAgreementReportDetailCustomDTO.getCustomerName();
							newarray[count][2] = customerName;
						}
						
						if(baseAgreementReportDetailCustomDTO.getFormNumber() != null){
							formNo = (String)baseAgreementReportDetailCustomDTO.getFormNumber();
							newarray[count][3] = formNo;
						}
						
						if(baseAgreementReportDetailCustomDTO.getVersionNo() != null){
							versionNo = (String)baseAgreementReportDetailCustomDTO.getVersionNo();
							newarray[count][4] = versionNo;
						}
						
						if(baseAgreementReportDetailCustomDTO.getFormLongDescription()== null){
								if(baseAgreementReportDetailCustomDTO.getFormShortDescription() != null){
									formDesc = (String)baseAgreementReportDetailCustomDTO.getFormShortDescription();
									newarray[count][5] = formDesc;
								}
						}
							else
							{
								formDesc = (String)baseAgreementReportDetailCustomDTO.getFormLongDescription();
								newarray[count][5] = formDesc;
								newarray[count][5] = formDesc;
							}	
																		
						if(baseAgreementReportDetailCustomDTO.getAcceptedDate() != null){
							acceptedDate = format.format(baseAgreementReportDetailCustomDTO.getAcceptedDate());
							newarray[count][7] = acceptedDate;
						}
						
						if(baseAgreementReportDetailCustomDTO.getExpirationDate() != null){
							expirationDate = format.format(baseAgreementReportDetailCustomDTO.getExpirationDate());
							newarray[count][8] = expirationDate;
						}
						
						if(baseAgreementReportDetailCustomDTO.getModificationTypeCode() != null){
							modificationTerm = (String)baseAgreementReportDetailCustomDTO.getModificationTypeCode();
							newarray[count][9] = modificationTerm;
						}
						
						if(baseAgreementReportDetailCustomDTO.getDetails() != null){
							modificationDetail  = (String)baseAgreementReportDetailCustomDTO.getDetails();
							newarray[count][10] = modificationDetail;
						}
						
						if(baseAgreementReportDetailCustomDTO.getModCreatedDate() != null){
							modificationDate   = format.format(baseAgreementReportDetailCustomDTO.getModCreatedDate());
							newarray[count][11] = modificationDate ;
						}
						if(baseAgreementReportDetailCustomDTO.getStatus() != null){
							modstatus   = (String)baseAgreementReportDetailCustomDTO.getStatus();
							if(modstatus.equals("A")){
								modstatus = "Active";
	                        }
	                        else
	                        	modstatus = "Inactive";
							newarray[count][12] = modstatus ;
						}
												
						count++;	
					}
					renderExcelByModificationType(response,newarray,salesOrg,today,status);
				}
				
				
				
				
				
				// If Report of modifications for specific modification types is to be generated
			/* else if(actionName != null && actionName.equalsIgnoreCase(ActionNameConstants.GENERATE_REPORTS_BYMODTYPE)){
					
					opptSession.setCurrentViewBean((BaseAgreementReportExcelViewBean)opptSession.getObjectFromSession(SessionConstants.SESSION_EXCEL_VIEWBEAN));
					baseAgreementReportExcelViewBean = (BaseAgreementReportExcelViewBean)opptSession.getCurrentViewBean();
					TreeMap tmap = new TreeMap();
					HashMap map  = baseAgreementReportExcelViewBean.getBaseAgreementReportsCustomDTO().getBaseAgreementReportModificationMap();
					tmap.putAll(map);
					today = format.format(date);				
					Set set = tmap.keySet();
					BaseAgreementReportCustomDTO baseAgreementReportCustomDTO = null;
					ModificationCustomDTO modificationDto = null;
					Integer key = new Integer(0);
					int maxList = 0;
					//if no records are returned from the query, display only the sales org and the status
					if((set.size() == 1 && tmap.firstKey().toString() == BaseAgreementReportConstants.DUMMYKEY)){
						baseAgreementReportCustomDTO=(BaseAgreementReportCustomDTO)tmap.get(new Integer(BaseAgreementReportConstants.DUMMYKEY));
						if(baseAgreementReportCustomDTO.getSalesOrg() != null){
							salesOrg = (String)salesOrgMap.get(baseAgreementReportCustomDTO.getSalesOrg()) + "-" + baseAgreementReportCustomDTO.getSalesOrg();
						}
						
						if(baseAgreementReportCustomDTO.getStatus() != null){
							status = (String)statusMap.get(baseAgreementReportCustomDTO.getStatus());
						}
						
						renderExcelByModificationTypeNoRows(response,salesOrg,status,today);
					}
					else{
						for(Iterator i = set.iterator();i.hasNext();){
							
						 key = (Integer)i.next();
						 baseAgreementReportCustomDTO=(BaseAgreementReportCustomDTO)tmap.get(key);
						 List list = baseAgreementReportCustomDTO.getModDetails();
	
							for(int j = 0; j < list.size();j++){
								modificationDto =(ModificationCustomDTO) baseAgreementReportCustomDTO.getModDetails().get(j);
								maxList++;
							}
						}
						
						int numberRows = maxList;
						int numberColumns = 12;
						String[][] newarray = new String[numberRows][numberColumns];
						//Assign the values to the array
						int count = 0;
						for(Iterator i = set.iterator();i.hasNext();){
							
							 key = (Integer)i.next();
							 baseAgreementReportCustomDTO=(BaseAgreementReportCustomDTO)tmap.get(key);
							 					 		
							 List list = baseAgreementReportCustomDTO.getModDetails();
							 
							 //Agreement Number to compare
							 String sameAgrNo = "";
							 boolean firstTime = true;
								for(int j = 0; j < list.size();j++){
									modificationDto =(ModificationCustomDTO) baseAgreementReportCustomDTO.getModDetails().get(j);
									
									if(baseAgreementReportCustomDTO.getSalesOrg() != null){
										salesOrg = (String)salesOrgMap.get(baseAgreementReportCustomDTO.getSalesOrg()) + "-" + baseAgreementReportCustomDTO.getSalesOrg();
									}
									
									if(baseAgreementReportCustomDTO.getStatus() != null){
										status = (String)statusMap.get(baseAgreementReportCustomDTO.getStatus());
									}
									
									if(baseAgreementReportCustomDTO.getAgreementNumber() != null){
										
											agrNo = (String)baseAgreementReportCustomDTO.getAgreementNumber();
																											
										if(agrNo.equals(sameAgrNo)){
											firstTime = false;
											
										}
										if(firstTime == false){
											agrNo = "";
										}
										newarray[count][6] = agrNo;
									}
								
									if(baseAgreementReportCustomDTO.getEnterpriseNumber() != null){
										enterpriseNo = (String)baseAgreementReportCustomDTO.getEnterpriseNumber();
										if(firstTime == false){
											enterpriseNo = "";
										}
										newarray[count][0] = enterpriseNo;
									}
									if(baseAgreementReportCustomDTO.getCustomerNumber() != null){
										customerNo = (String)baseAgreementReportCustomDTO.getCustomerNumber();
										if(firstTime == false){
											customerNo = "";
										}
										newarray[count][1] = customerNo;
									}
									if(baseAgreementReportCustomDTO.getCustomerName() != null){
										customerName = (String)baseAgreementReportCustomDTO.getCustomerName();
										if(firstTime == false){
											customerName = "";
										}
										newarray[count][2] = customerName;
									}
									if(baseAgreementReportCustomDTO.getFormNumber() != null){
										formNo = (String)baseAgreementReportCustomDTO.getFormNumber();
										if(firstTime == false){
											formNo = "";
										}
										newarray[count][3] = formNo;
										
									}
									if(baseAgreementReportCustomDTO.getVersionNo() != null){
										versionNo = (String)baseAgreementReportCustomDTO.getVersionNo();
										if(firstTime == false){
											versionNo = "";
										}
										newarray[count][4] = versionNo;
									}
									if(baseAgreementReportCustomDTO.getFormLongDescription()== null){
										if(baseAgreementReportCustomDTO.getFormShortDescription() != null){
											formDesc = (String)baseAgreementReportCustomDTO.getFormShortDescription();
											if(firstTime == false){
												formDesc = "";
											}
											newarray[count][5] = formDesc;
										}
									}
									else
									{
										formDesc = (String)baseAgreementReportCustomDTO.getFormLongDescription();
										newarray[count][5] = formDesc;
										if(firstTime == false){
											formDesc = "";
										}
										newarray[count][5] = formDesc;
									}	
									
									if(baseAgreementReportCustomDTO.getAcceptedDate() != null){
										acceptedDate = format.format(baseAgreementReportCustomDTO.getAcceptedDate());
										if(firstTime == false){
											acceptedDate = "";
										}
										newarray[count][7] = acceptedDate;
									}
									if(baseAgreementReportCustomDTO.getExpirationDate() != null){
										expirationDate = format.format(baseAgreementReportCustomDTO.getExpirationDate());
										if(firstTime == false){
											expirationDate = "";
										}
										newarray[count][8] = expirationDate;
									}
									if(modificationDto.getModificationTypeCode() != null){
										modificationTerm = (String)modificationDto.getModificationTypeCode();
										newarray[count][9] = modificationTerm;
									}
									if(modificationDto.getDetails() != null){
										modificationDetail  = (String)modificationDto.getDetails();
										newarray[count][10] = modificationDetail;
									}
									if(modificationDto.getChangedDate() != null){
										modificationDate   = format.format(modificationDto.getChangedDate());
										newarray[count][11] = modificationDate ;
									}
									count++;
									sameAgrNo = agrNo;
									
								}
									
						}
						
						renderExcelByModificationType(response,newarray,salesOrg,status,today);
					}								
				}*/

				else if (actionName != null
					&& (actionName.equalsIgnoreCase(ActionNameConstants.VIEW_REVERIFICATION_REPORT)
					|| actionName.equalsIgnoreCase(ActionNameConstants.DOWNLOAD_REVERIFICATION_REPORT))) {
						view = (ReportViewBean) performTask(request, response, viewReport, true);
				}
				else {
					
					view = (ReportViewBean) performTask(request, response, viewReport, false);
				}
				if (null == view) {
					return;
				}

				Document viewXMLDocument = view.getDocument();
				String downloadContent = null;
				if (null == viewXMLDocument) {
					downloadContent = view.getDownloadContent();
				}

				String viewXSL = view.getView();
				if (viewXSL != null && !(viewXSL.endsWith(".xsl"))) {  //$NON-NLS-1$
					viewXSL = viewXSL + ".xsl";  //$NON-NLS-1$
				}

				viewXSL = BASEPATH + viewXSL;
				viewXSL = getServletContext().getRealPath(viewXSL);

				view = null;
				System.gc();

				if (log == null) {
					log = new ConsoleLogger(ConsoleLogger.LEVEL_WARN);
					MessageHandler.setScreenLogger(log);
				}

				if (viewReport) {
					renderXML(viewXMLDocument, viewXSL, response);
					
					 
				} else {
					
					if (null != viewXMLDocument) {
						renderHTML(viewXMLDocument, viewXSL, response);
					} else {
						renderHTML(downloadContent, response);
					}
				}

				downloadContent = null;
				viewXMLDocument = null;
				System.gc();
			} catch (ServiceException se) {
				request.setAttribute("errorView", "errorView");  //$NON-NLS-1$  //$NON-NLS-2$
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/protect/ErrorAction.wss");  //$NON-NLS-1$
				OPPTViewBean viewBean = new ErrorViewBean(se.getErrorReport(), getCurrentForwardName(getRole(opptSession), actionName));
				opptSession.setCurrentForward(getCurrentForwardName(getRole(opptSession), actionName));
				opptSession.setCurrentMessageViewBean(viewBean);
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorView", "errorView");  //$NON-NLS-1$  //$NON-NLS-2$
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/protect/ErrorAction.wss");  //$NON-NLS-1$
				OPPTViewBean viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA00), getCurrentForwardName(getRole(opptSession), actionName));
				opptSession.setCurrentForward(getCurrentForwardName(getRole(opptSession), actionName));
				opptSession.setCurrentMessageViewBean(viewBean);
				rd.forward(request, response);
			}
		} catch (IOException e) {
			throw new ServletException(e);
		}
	}

	/**
     * doPost
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     * @author thirumalai
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	/**
     * Renders an XML file into a PDF file by applying a stylesheet
     * that converts the XML to XSL:FO. The PDF is written
     * directly to the response object's OutputStream
     *
     * @param input
     * @param response
     * @param viewXSL
     * @throws javax.servlet.ServletException 
     */
	public void renderXML(Document input, String viewXSL, HttpServletResponse response) throws ServletException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {

			response.setContentType("application/pdf");  //$NON-NLS-1$
			
			Driver driver = new Driver();
			driver.setLogger(log);
			driver.setRenderer(Driver.RENDER_PDF);
			driver.setOutputStream(out);

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(new File(viewXSL)));

			Source src = new DOMSource(input);
			Result res = new SAXResult(driver.getContentHandler());

			transformer.transform(src, res);

			byte[] content = out.toByteArray();
			response.setContentLength(content.length);
			response.getOutputStream().write(content);
			response.getOutputStream().flush();
		} catch (Exception ex) {
			throw new ServletException(ex);
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ReportGeneratorServlet", "renderXML", null, e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
			}
		}
	}

	/**
     * Renders an XML file into a HTML file by applying a stylesheet
     * that converts the XML to HTML. The HTML is written
     * directly to the response object's OutputStream
     *
     * @param input
     * @param response
     * @param viewXSL
     * @throws javax.servlet.ServletException 
     */
	public void renderHTML(Document input, String viewXSL, HttpServletResponse response) throws ServletException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			response.setContentType("application/unknown");  //$NON-NLS-1$
			response.setHeader("Content-Disposition", "attachment;filename=report.html");  //$NON-NLS-1$  //$NON-NLS-2$

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(new File(viewXSL)));

			Source src = new DOMSource(input);
			StreamResult res = new StreamResult(out);
			transformer.transform(src, res);

			byte[] content = out.toByteArray();

			response.setContentLength(content.length);
			response.getOutputStream().write(content);
			response.getOutputStream().flush();
		} catch (Exception ex) {
			throw new ServletException(ex);
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ReportGeneratorServlet", "renderHTML", null, e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
			}
		}
	}
	
	/**
     * renderExcelDedicatedFormNumbers
     * @param response
     * @throws javax.servlet.ServletException
     * @author Nayantara L Pai
     */
	public void renderExcelDedicatedFormNumbers(HttpServletResponse response, String[][] args,String salesOrg, String date,String status ) throws ServletException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ServletOutputStream tobrowser = null;
		HSSFWorkbook wb = null;
		try {
			String fileName = "Report.xls";
			response.setContentType("applicaton/vnd-ms.excel");  //$NON-NLS-1$
			response.setHeader("Content-Disposition","attachment; filename=" + fileName);
			tobrowser = response.getOutputStream();
			short rownum;

			wb = new HSSFWorkbook();
			wb.setSheetName(0, "Reports" );
			
			HSSFSheet s = wb.createSheet();
			HSSFRow r = null;
			HSSFCell c = null;

			HSSFCellStyle cs = wb.createCellStyle();
			HSSFCellStyle cs2 = wb.createCellStyle();
	
			HSSFFont f = wb.createFont();
			HSSFFont f2 = wb.createFont();

			f.setFontHeightInPoints((short) 10);
			f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			f2.setFontHeightInPoints((short) 12);
			f2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			cs.setFont(f);
			cs2.setFont(f2);
						
			String header = null;
			header = "Report for registered Base Agreement";
			r = s.createRow((short)0);
			c = r.createCell((short)3);
			c.setCellValue(header);
			c.setCellStyle(cs2);
			
			r = s.createRow((short)3);
			c = r.createCell((short)0);
			c.setCellValue("Sales Org:");
			c = r.createCell((short)1);
			c.setCellValue(salesOrg);
			
			r = s.createRow((short)4);
			c = r.createCell((short)0);
			c.setCellValue("Date:");
			c = r.createCell((short)1);
			c.setCellValue(date);
			
			r = s.createRow((short)5);
			c = r.createCell((short)0);
			c.setCellValue("Status:");
			c = r.createCell((short)1);
			c.setCellValue(status);
			
			//set the column names
			String[] colnames = {"Enterprise Number", "Customer Number", "Customer Name", "Form Number", "Version Number",
					"Form Description", "Agreement Number", "Accepted Date", "Expiration Date", "Create Date","Modified","Agreement Status"};
			

			//populate the column names and set the width of the column accordingly
			r = s.createRow((short)8);
			for (short cellnum = (short) 0; cellnum < 12; cellnum ++)
		    {
		        
		        c = r.createCell(cellnum);
		        c.setCellValue(colnames[cellnum]);
		        c.setCellStyle(cs);
		        
		        int	width = colnames[cellnum].length()* 325;		        		        	
		        		        
		        if(width > s.getColumnWidth((short)cellnum)){
                    s.setColumnWidth((short)cellnum, (short)width);
                }

		    }
			int countRows = 0;
			int countCols = 0;
			
			
			for (short i = (short) 10; i < args.length + 10; i ++){
				r = s.createRow(i);
				for(short j = (short)0; j < 12;j++ ){
					c = r.createCell(j);
					c.setCellValue(args[i-10][j]);
					
				}
								
			}
			wb.write(tobrowser);
			
		} catch (Exception ex) {
			throw new ServletException(ex);
		} finally {
			try {
				tobrowser.flush();
				tobrowser.close();
			} catch (IOException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ReportGeneratorServlet", "renderExcelDedicatedFormNumbers", null, e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
			}
		}
	}
	/**
     * renderExcelAllBaseAgreements
     * @param response
     * @throws javax.servlet.ServletException
     * @author Nayantara L Pai
     */
	public void renderExcelAllBaseAgreements(HttpServletResponse response, String[][] args,String salesOrg, String status, String date) throws ServletException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ServletOutputStream tobrowser = null;
		HSSFWorkbook wb = null;
		try {
						
			String fileName = "Report.xls";
			response.setContentType("applicaton/vnd-ms.excel");  //$NON-NLS-1$
			response.setHeader("Content-Disposition","attachment; filename=" + fileName);
			tobrowser = response.getOutputStream();
			short rownum;

			wb = new HSSFWorkbook();
			wb.setSheetName(0, "Reports" );
			
			HSSFSheet s = wb.createSheet();
			HSSFRow r = null;
			HSSFCell c = null;

			HSSFCellStyle cs = wb.createCellStyle();
			HSSFCellStyle cs2 = wb.createCellStyle();
	
			HSSFFont f = wb.createFont();
			HSSFFont f2 = wb.createFont();

			f.setFontHeightInPoints((short) 10);
			f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			f2.setFontHeightInPoints((short) 12);
			f2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			cs.setFont(f);
			cs2.setFont(f2);
						
			String header = null;
			header = "Report of all registered base agreements ";
			r = s.createRow((short)0);
			c = r.createCell((short)3);
			c.setCellValue(header);
			c.setCellStyle(cs2);
			
			r = s.createRow((short)3);
			c = r.createCell((short)0);
			c.setCellValue("Sales Org:");
			c = r.createCell((short)1);
			c.setCellValue(salesOrg);
			
			r = s.createRow((short)4);
			c = r.createCell((short)0);
			c.setCellValue("Date:");
			c = r.createCell((short)1);
			c.setCellValue(date);
			
			r = s.createRow((short)5);
			c = r.createCell((short)0);
			c.setCellValue("Status:");
			c = r.createCell((short)1);
			c.setCellValue(status);
			
			//set the column names
			String[] colnames = {"Enterprise Number", "Customer Number", "Customer Name", "Form Number", "Version Number",
					"Form Description", "Agreement Number", "Accepted Date", "Expiration Date", "Create Date","Modified"};
			

			//populate the column names and set the width of the column accordingly
			r = s.createRow((short)8);
			for (short cellnum = (short) 0; cellnum < 11; cellnum ++)
		    {
		        
		        c = r.createCell(cellnum);
		        c.setCellValue(colnames[cellnum]);
		        c.setCellStyle(cs);
		        
		        int	width = colnames[cellnum].length()* 325;		        		        	
		        		        
		        if(width > s.getColumnWidth((short)cellnum)){
                    s.setColumnWidth((short)cellnum, (short)width);
                }

		    }
			int countRows = 0;
			int countCols = 0;
			
			for (short i = (short) 10; i < args.length + 10; i ++){
				r = s.createRow(i);
				for(short j = (short)0; j < 11;j++ ){
					c = r.createCell(j);
					c.setCellValue(args[i-10][j]);
					
				}
								
			}
			wb.write(tobrowser);
			
		} catch (Exception ex) {
			throw new ServletException(ex);
		} finally {
			try {
				tobrowser.flush();
				tobrowser.close();
			} catch (IOException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ReportGeneratorServlet", "renderExcelAllBaseAgreements", null, e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
			}
		}
	}
	/**
     * renderExcelAllRegisteredModifications
     * @param response
     * @throws javax.servlet.ServletException
     * @author Nayantara L Pai
     */
	public void renderExcelAllRegisteredModifications(HttpServletResponse response, String[][] args,String salesOrg, String status, String date) throws ServletException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ServletOutputStream tobrowser = null;
		HSSFWorkbook wb = null;
		try {
						
			String fileName = "Report.xls";
			response.setContentType("applicaton/vnd-ms.excel");  //$NON-NLS-1$
			response.setHeader("Content-Disposition","attachment; filename=" + fileName);
			tobrowser = response.getOutputStream();
			short rownum;

			wb = new HSSFWorkbook();
			wb.setSheetName(0, "Reports" );
			
			HSSFSheet s = wb.createSheet();
			HSSFRow r = null;
			HSSFCell c = null;

			HSSFCellStyle cs = wb.createCellStyle();
			HSSFCellStyle cs2 = wb.createCellStyle();
	
			HSSFFont f = wb.createFont();
			HSSFFont f2 = wb.createFont();

			f.setFontHeightInPoints((short) 10);
			f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			f2.setFontHeightInPoints((short) 12);
			f2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			cs.setFont(f);
			cs2.setFont(f2);
						
			String header = null;
			header = "Report of all registered modifications ";
			r = s.createRow((short)0);
			c = r.createCell((short)3);
			c.setCellValue(header);
			c.setCellStyle(cs2);
			
			r = s.createRow((short)3);
			c = r.createCell((short)0);
			c.setCellValue("Sales Org:");
			c = r.createCell((short)1);
			c.setCellValue(salesOrg);
			
			r = s.createRow((short)4);
			c = r.createCell((short)0);
			c.setCellValue("Date:");
			c = r.createCell((short)1);
			c.setCellValue(date);
			
			r = s.createRow((short)5);
			c = r.createCell((short)0);
			c.setCellValue("Status:");
			c = r.createCell((short)1);
			c.setCellValue(status);
			
			//set the column names
			String[] colnames = {"Enterprise Number", "Customer Number", "Customer Name", "Form Number", "Version Number",
					"Form Description", "Agreement Number", "Accepted Date", "Expiration Date", "Modification Term",
					"Modification Detail", "Modification Date"};
			

			//populate the column names and set the width of the column accordingly
			r = s.createRow((short)8);
			for (short cellnum = (short) 0; cellnum < 12; cellnum ++)
		    {
		        
		        c = r.createCell(cellnum);
		        c.setCellValue(colnames[cellnum]);
		        c.setCellStyle(cs);
		        
		        int	width = colnames[cellnum].length()* 325;		        		        	
		        		        
		        if(width > s.getColumnWidth((short)cellnum)){
                    s.setColumnWidth((short)cellnum, (short)width);
                }

		    }
			int countRows = 0;
			int countCols = 0;
			
			for (short i = (short) 10; i < args.length + 10; i ++){
				r = s.createRow(i);
				for(short j = (short)0; j < 12;j++ ){
					c = r.createCell(j);
					c.setCellValue(args[i-10][j]);
					
				}
								
			}
			wb.write(tobrowser);
			
		} catch (Exception ex) {
			throw new ServletException(ex);
		} finally {
			try {
				tobrowser.flush();
				tobrowser.close();
			} catch (IOException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ReportGeneratorServlet", "renderExcelAllRegisteredModifications", null, e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
			}
		}
	}
	/**
     * renderExcelAllRegisteredModificationsNoRows
     * @param response
     * @throws javax.servlet.ServletException
     * @author Nayantara L Pai
     */
	public void renderExcelAllRegisteredModificationsNoRows(HttpServletResponse response,String salesOrg, String status, String date) throws ServletException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ServletOutputStream tobrowser = null;
		HSSFWorkbook wb = null;
		try {
						
			String fileName = "Report.xls";
			response.setContentType("applicaton/vnd-ms.excel");  //$NON-NLS-1$
			response.setHeader("Content-Disposition","attachment; filename=" + fileName);
			tobrowser = response.getOutputStream();
			short rownum;

			wb = new HSSFWorkbook();
			wb.setSheetName(0, "Reports" );
			
			HSSFSheet s = wb.createSheet();
			HSSFRow r = null;
			HSSFCell c = null;

			HSSFCellStyle cs = wb.createCellStyle();
			HSSFCellStyle cs2 = wb.createCellStyle();
	
			HSSFFont f = wb.createFont();
			HSSFFont f2 = wb.createFont();

			f.setFontHeightInPoints((short) 10);
			f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			f2.setFontHeightInPoints((short) 12);
			f2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			cs.setFont(f);
			cs2.setFont(f2);
						
			String header = null;
			header = "Report of all registered modifications ";
			r = s.createRow((short)0);
			c = r.createCell((short)3);
			c.setCellValue(header);
			c.setCellStyle(cs2);
			
			r = s.createRow((short)3);
			c = r.createCell((short)0);
			c.setCellValue("Sales Org:");
			c = r.createCell((short)1);
			c.setCellValue(salesOrg);
			
			r = s.createRow((short)4);
			c = r.createCell((short)0);
			c.setCellValue("Date:");
			c = r.createCell((short)1);
			c.setCellValue(date);
			
			r = s.createRow((short)5);
			c = r.createCell((short)0);
			c.setCellValue("Status:");
			c = r.createCell((short)1);
			c.setCellValue(status);
			
			//set the column names
			String[] colnames = {"Enterprise Number", "Customer Number", "Customer Name", "Form Number", "Version Number",
					"Form Description", "Agreement Number", "Accepted Date", "Expiration Date", "Modification Term",
					"Modification Detail", "Modification Date"};
			

			//populate the column names and set the width of the column accordingly
			r = s.createRow((short)8);
			for (short cellnum = (short) 0; cellnum < 12; cellnum ++)
		    {
		        
		        c = r.createCell(cellnum);
		        c.setCellValue(colnames[cellnum]);
		        c.setCellStyle(cs);
		        
		        int	width = colnames[cellnum].length()* 325;		        		        	
		        		        
		        if(width > s.getColumnWidth((short)cellnum)){
                    s.setColumnWidth((short)cellnum, (short)width);
                }

		    }
			
			wb.write(tobrowser);
			
		} catch (Exception ex) {
			throw new ServletException(ex);
		} finally {
			try {
				tobrowser.flush();
				tobrowser.close();
			} catch (IOException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ReportGeneratorServlet", "renderExcelAllRegisteredModificationsNoRows", null, e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
			}
		}
	}
	/**
     * renderExcelByModificationType
     * @param response
     * @throws javax.servlet.ServletException
     * @author Nayantara L Pai
     */
	public void renderExcelByModificationType(HttpServletResponse response, String[][] args,String salesOrg,String date,String status) throws ServletException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ServletOutputStream tobrowser = null;
		HSSFWorkbook wb = null;
		try {
						
			String fileName = "Report.xls";
			response.setContentType("applicaton/vnd-ms.excel");  //$NON-NLS-1$
			response.setHeader("Content-Disposition","attachment; filename=" + fileName);
			tobrowser = response.getOutputStream();
			short rownum;

			wb = new HSSFWorkbook();
			wb.setSheetName(0, "Reports" );
			
			HSSFSheet s = wb.createSheet();
			HSSFRow r = null;
			HSSFCell c = null;

			HSSFCellStyle cs = wb.createCellStyle();
			HSSFCellStyle cs2 = wb.createCellStyle();
	
			HSSFFont f = wb.createFont();
			HSSFFont f2 = wb.createFont();

			f.setFontHeightInPoints((short) 10);
			f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			f2.setFontHeightInPoints((short) 12);
			f2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			cs.setFont(f);
			cs2.setFont(f2);
						
			String header = null;
			header = "Report for registered Modifications ";
			r = s.createRow((short)0);
			c = r.createCell((short)3);
			c.setCellValue(header);
			c.setCellStyle(cs2);
			
			r = s.createRow((short)3);
			c = r.createCell((short)0);
			c.setCellValue("Sales Org:");
			c = r.createCell((short)1);
			c.setCellValue(salesOrg);
			
			r = s.createRow((short)4);
			c = r.createCell((short)0);
			c.setCellValue("Date:");
			c = r.createCell((short)1);
			c.setCellValue(date);
			
			r = s.createRow((short)5);
			c = r.createCell((short)0);
			c.setCellValue("Status:");
			c = r.createCell((short)1);
			c.setCellValue(status);
			
			//set the column names
			String[] colnames = {"Enterprise Number", "Customer Number", "Customer Name", "Form Number", "Version Number",
					"Form Description", "Agreement Number", "Accepted Date", "Expiration Date", "Modification Term",
					"Modification Detail", "Modification Date","Modification Status"};
			

			//populate the column names and set the width of the column accordingly
			r = s.createRow((short)8);
			for (short cellnum = (short) 0; cellnum < 13; cellnum ++)
		    {
		        
		        c = r.createCell(cellnum);
		        c.setCellValue(colnames[cellnum]);
		        c.setCellStyle(cs);
		        
		        int	width = colnames[cellnum].length()* 325;		        		        	
		        		        
		        if(width > s.getColumnWidth((short)cellnum)){
                    s.setColumnWidth((short)cellnum, (short)width);
                }

		    }
			int countRows = 0;
			int countCols = 0;
			
			for (short i = (short) 10; i < args.length + 10; i ++){
				r = s.createRow(i);
				for(short j = (short)0; j < 13;j++ ){
					c = r.createCell(j);
					c.setCellValue(args[i-10][j]);
					
				}
								
			}
			wb.write(tobrowser);
			
		} catch (Exception ex) {
			throw new ServletException(ex);
		} finally {
			try {
				tobrowser.flush();
				tobrowser.close();
			} catch (IOException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ReportGeneratorServlet", "renderExcelByModificationType", null, e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
			}
		}
	}
	/**
     * renderExcelByModificationTypeNoRows
     * @param response
     * @throws javax.servlet.ServletException
     * @author Nayantara L Pai
     */
	public void renderExcelByModificationTypeNoRows(HttpServletResponse response,String salesOrg, String status, String date) throws ServletException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ServletOutputStream tobrowser = null;
		HSSFWorkbook wb = null;
		try {
						
			String fileName = "Report.xls";
			response.setContentType("applicaton/vnd-ms.excel");  //$NON-NLS-1$
			response.setHeader("Content-Disposition","attachment; filename=" + fileName);
			tobrowser = response.getOutputStream();
			short rownum;

			wb = new HSSFWorkbook();
			wb.setSheetName(0, "Reports" );
			
			HSSFSheet s = wb.createSheet();
			HSSFRow r = null;
			HSSFCell c = null;

			HSSFCellStyle cs = wb.createCellStyle();
			HSSFCellStyle cs2 = wb.createCellStyle();
	
			HSSFFont f = wb.createFont();
			HSSFFont f2 = wb.createFont();

			f.setFontHeightInPoints((short) 10);
			f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			f2.setFontHeightInPoints((short) 12);
			f2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			cs.setFont(f);
			cs2.setFont(f2);
						
			String header = null;
			header = "Report of modifications for a dedicated modification type ";
			r = s.createRow((short)0);
			c = r.createCell((short)3);
			c.setCellValue(header);
			c.setCellStyle(cs2);
			
			r = s.createRow((short)3);
			c = r.createCell((short)0);
			c.setCellValue("Sales Org:");
			c = r.createCell((short)1);
			c.setCellValue(salesOrg);
			
			r = s.createRow((short)4);
			c = r.createCell((short)0);
			c.setCellValue("Date:");
			c = r.createCell((short)1);
			c.setCellValue(date);
			
			r = s.createRow((short)5);
			c = r.createCell((short)0);
			c.setCellValue("Status:");
			c = r.createCell((short)1);
			c.setCellValue(status);
			
			//set the column names
			String[] colnames = {"Enterprise Number", "Customer Number", "Customer Name", "Form Number", "Version Number",
					"Form Description", "Agreement Number", "Accepted Date", "Expiration Date", "Modification Term",
					"Modification Detail", "Modification Date"};
			

			//populate the column names and set the width of the column accordingly
			r = s.createRow((short)8);
			for (short cellnum = (short) 0; cellnum < 12; cellnum ++)
		    {
		        
		        c = r.createCell(cellnum);
		        c.setCellValue(colnames[cellnum]);
		        c.setCellStyle(cs);
		        
		        int	width = colnames[cellnum].length()* 325;		        		        	
		        		        
		        if(width > s.getColumnWidth((short)cellnum)){
                    s.setColumnWidth((short)cellnum, (short)width);
                }

		    }
			
			wb.write(tobrowser);
			
		} catch (Exception ex) {
			throw new ServletException(ex);
		} finally {
			try {
				tobrowser.flush();
				tobrowser.close();
			} catch (IOException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ReportGeneratorServlet", "renderExcelByModificationTypeNoRows", null, e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
			}
		}
	}
	/**
     * renderHTML
     * 
     * @param downloadContent
     * @param response
     * @throws javax.servlet.ServletException
     * @author thirumalai
     */
    public void renderHTML(String downloadContent, HttpServletResponse response) throws ServletException {
		try {
			response.setContentType("application/unknown");  //$NON-NLS-1$
			response.setHeader("Content-Disposition", "attachment;filename=report.html");  //$NON-NLS-1$  //$NON-NLS-2$

			response.getOutputStream().print(downloadContent);
			response.getOutputStream().flush();
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	/**
     * performTask
     * 
     * @param request
     * @param response
     * @param viewReport
     * @param viewReverificationReport
     * @throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException
     * @throws java.lang.Exception
     * @return
     * @author thirumalai
     */
    public OPPTViewBean performTask(HttpServletRequest request, HttpServletResponse response, boolean viewReport, boolean viewReverificationReport) throws ServiceException, Exception {
		OPPTViewBean viewBean = null;
		String reportType = null;
		String proposalName = null;
		String salesOrg = null;
		
		OPPTSession session = new OPPTSession(request.getSession());
		if(viewReverificationReport == true) {
			salesOrg = (String) session.getObjectFromSession(SessionConstants.REVERIFICATION_SALES_ORG);
			reportType = (String) session.getObjectFromSession(SessionConstants.REPORT_REPORT_TYPE);
			
		}
		else {
			reportType = (String) session.getObjectFromSession(SessionConstants.REPORT_REPORT_TYPE);
			proposalName = (String) session.getObjectFromSession(SessionConstants.REPORT_PROPOSAL_NAME);
		}

		try {
			if (ReportTypeConstants.VIEW_PROPOSAL.equalsIgnoreCase(reportType)) {
				viewBean = getViewProposal(session);
			} else if (ReportTypeConstants.COMPARE_TP_REPORT.equalsIgnoreCase(reportType)) {
				viewBean = getCompareTPReport(session, true, viewReport);
			}
			/* CR4520S */ 
			else if (viewReverificationReport == true &&ReportTypeConstants.REVERIFICAION_REPORT.equalsIgnoreCase(reportType)  ) {
				ReverificationReportCustomDTO customDTO = new ReverificationReportCustomDTO();
				customDTO.setSalesOrg(salesOrg);
				viewBean = getUserReverificationReport(session, customDTO, viewReport);
			}
			
			else if (viewReverificationReport == true &&ReportTypeConstants.DELETION_REPORT.equalsIgnoreCase(reportType)  ) {
				DeletedUsersReportCustomDTO customDTO = new DeletedUsersReportCustomDTO();
				
				
				customDTO.setSalesOrg(salesOrg);
				viewBean = getdeletedUsersReport(session, customDTO, viewReport);
			}
			
			/* CR4520E */ 
			else {
				ProposalCustomDTO selectedProposal = null;
				if (null == proposalName) {
					selectedProposal = getSelectedProposal(session);
				} else {
					selectedProposal = getSelectedProposal(session, proposalName);
				}

				if (viewReport && OPPTPropertiesReader.useDownload()) {
					getReportManager().checkForDownload(selectedProposal);					
				}

				if (ReportTypeConstants.PLANNING_REPORT.equalsIgnoreCase(reportType)) {
					viewBean = getPlanningReport(session, selectedProposal, viewReport);
				} else if (ReportTypeConstants.CONTRACT_ATTACHMENT_REPORT_FINAL.equalsIgnoreCase(reportType)) {
					viewBean = getContractAttachmentReport(session, selectedProposal, false, viewReport);
				} else if (ReportTypeConstants.CONTRACT_ATTACHMENT_REPORT_DRAFT.equalsIgnoreCase(reportType)) {
					viewBean = getContractAttachmentReport(session, selectedProposal, true, viewReport);
				} else if (ReportTypeConstants.CONTRACT_AMENDMENT_REPORT.equalsIgnoreCase(reportType)) {
					viewBean = getContractAmendmentReport(session, selectedProposal, viewReport);
				} else if (ReportTypeConstants.DELETED_SWOS_REPORT.equalsIgnoreCase(reportType)) {
					viewBean = getDeletedSWOReport(session, selectedProposal, viewReport);
				} else if (ReportTypeConstants.SYSPLEX_REPORT.equalsIgnoreCase(reportType)) {
					viewBean = getSysplexReport(session, selectedProposal, viewReport);
				} else if (ReportTypeConstants.INVENTORY_LIST_REPORT.equalsIgnoreCase(reportType)) {
					viewBean = getInventoryListReport(session, selectedProposal, viewReport);
				} else if (ReportTypeConstants.LIST_ENTITLED_PRICE_REPORT.equalsIgnoreCase(reportType)) {
					viewBean = getListEntitledPricesReport(session, selectedProposal, viewReport);
				} else if (ReportTypeConstants.VARIANCE_REPORT_ALL.equalsIgnoreCase(reportType)) {
					viewBean = getVarianceReport(session, selectedProposal, false, viewReport);
				} else if (ReportTypeConstants.VARIANCE_REPORT_PRICE_CHANGE.equalsIgnoreCase(reportType)) {
					viewBean = getVarianceReport(session, selectedProposal, true, viewReport);
				}
			}
		} catch (ServiceException se) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ReportGeneratorServlet", "performTask", null, se);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ReportGeneratorServlet", "performTask", null, e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
			e.printStackTrace();
			throw e;
		}

		return viewBean;
	}
	

	private OPPTViewBean getViewProposal(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		PrintProposalCustomDTO cusomDTO = new PrintProposalCustomDTO();
		setTransactionInformation(cusomDTO, session, ActionNameConstants.PRINT_PROPOSAL);
		cusomDTO.setProposal(getCurrentProposal(session));

		cusomDTO = getProposalManager().printProposal(cusomDTO);
		viewBean = new PrintProposalViewBean(cusomDTO);

		return viewBean;
	}

	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		if (null != session) {
			currentProposal = (ProposalCustomDTO) session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);
		}
		return currentProposal;
	}

	private ProposalCustomDTO getSelectedProposal(OPPTSession session) {
		ContractCustomDTO currentProposal = null;
		VarianceHeaderInformationCustomDTO headerDto = null;
		if (null != session) {
			headerDto = (VarianceHeaderInformationCustomDTO) session.getObjectFromSession(SessionConstants.VARIANCE_CHECK);
			currentProposal = headerDto.getContractDTO();
		}
		return currentProposal;
	}

	/**
     * getProposalManager
     * 
     * @throws java.lang.Exception
     * @return
     * @author thirumalai
     */
    protected ProposalManager getProposalManager() throws Exception {
		ProposalManagerHome pcmHome = (ProposalManagerHome) ServiceLocator.getEJBHomeFactory().getRemoteHome("ProposalManagerHome");  //$NON-NLS-1$
		return pcmHome.create();
	}

	private OPPTViewBean getVarianceReport(OPPTSession session, ProposalCustomDTO selectedProposal, boolean priceChange, boolean viewReport) throws Exception {
		OPPTViewBean viewBean = null;
		VarianceRptCustomDTO customDTO = new VarianceRptCustomDTO();
		customDTO.setProposalDTO(selectedProposal);
		setTransactionInformation(customDTO, session, ActionNameConstants.VIEW_REPORT);

		try {
			if (priceChange) {
				customDTO = getReportManager().getVariancePriceRpt(customDTO);
			} else {
				customDTO = getReportManager().getVarianceAllRpt(customDTO);
			}
			if (viewReport) {
				viewBean = new VarianceReportViewBean(customDTO, "variancereportview");  //$NON-NLS-1$
			} else {
				viewBean = new VarianceReportViewBean(customDTO, "variancereportdownload",false);  //$NON-NLS-1$
			}
		} catch (ServiceException se) {
			throw se;
		}
		return viewBean;
	}

	private OPPTViewBean getCompareTPReport(OPPTSession session, boolean priceChange, boolean viewReport) throws Exception {
		OPPTViewBean viewBean = null;
		ContractCustomDTO selectedProposal = getCurrentProposalDTO(session);
		CompareTPReportCustomDTO compareTPDto = new CompareTPReportCustomDTO();
		compareTPDto.setContractCustomDTO(selectedProposal);
		setTransactionInformation(compareTPDto, session, ActionNameConstants.VIEW_REPORT);

		compareTPDto = getReportManager().getCompareTPRpt(compareTPDto);
		if (viewReport) {
			viewBean = new CompareTPReportViewBean(compareTPDto, "tpreportview");  //$NON-NLS-1$
		} else {
			viewBean = new CompareTPReportViewBean(compareTPDto, "tpreportdownload");  //$NON-NLS-1$
		}

		return viewBean;
	}

	private OPPTViewBean getPlanningReport(OPPTSession session, ProposalCustomDTO selectedProposal, boolean viewReport) throws Exception {
		OPPTViewBean viewBean = null;

		ContractPlanningReportCustomDTO customDTO = new ContractPlanningReportCustomDTO();
		customDTO.setProposalDTO(selectedProposal);
		setTransactionInformation(customDTO, session, ActionNameConstants.VIEW_REPORT);

		customDTO = getReportManager().getContractPlanningRpt(customDTO);
		if (viewReport) {
			viewBean = new ContractPlanningReportViewBean(customDTO, "contractplanningreportview");  //$NON-NLS-1$
		} else {
			viewBean = new ContractPlanningReportViewBean(customDTO, "contractplanningreportdownload",false);  //$NON-NLS-1$
		}

		return viewBean;
	}

	private OPPTViewBean getContractAttachmentReport(OPPTSession session, ProposalCustomDTO selectedProposal, boolean draft, boolean viewReport) throws Exception {
		OPPTViewBean viewBean = null;

		ContractAttachmentReportCustomDTO customDTO = new ContractAttachmentReportCustomDTO();
		customDTO.setProposalDTO(selectedProposal);
		customDTO.setDraft(draft);
		setTransactionInformation(customDTO, session, ActionNameConstants.VIEW_REPORT);

		customDTO = getReportManager().getContractAttachRpt(customDTO);
		if (viewReport) {
			viewBean = new ContractAttachmentReportViewBean(customDTO, "contractattachmentreportview");  //$NON-NLS-1$
		} else {
			//viewBean = new ContractAttachmentReportViewBean(customDTO, "contractattachmentreportdownload");
			viewBean = new ContractAttachmentReportViewBean(customDTO, "contractattachmentreportdownload", false);  //$NON-NLS-1$
		}

		return viewBean;
	}

	private OPPTViewBean getContractAmendmentReport(OPPTSession session, ProposalCustomDTO selectedProposal, boolean viewReport) throws Exception {

		OPPTViewBean viewBean = null;

		ContractAmendmentReportCustomDTO customDTO = new ContractAmendmentReportCustomDTO();
		customDTO.setProposalDTO(selectedProposal);
		setTransactionInformation(customDTO, session, ActionNameConstants.VIEW_REPORT);

		customDTO = getReportManager().getContractAmdRpt(customDTO);
		if (viewReport) {
			viewBean = new ContractAmendmentReportViewBean(customDTO, "contractamendmentreportview");  //$NON-NLS-1$
		} else {
			viewBean = new ContractAmendmentReportViewBean(customDTO, "contractamendmentreportdownload",false);  //$NON-NLS-1$
		}

		return viewBean;

	}

	private OPPTViewBean getDeletedSWOReport(OPPTSession session, ProposalCustomDTO selectedProposal, boolean viewReport) throws Exception {
		OPPTViewBean viewBean = null;

		DeletedSWOReportCustomDTO customDTO = new DeletedSWOReportCustomDTO();
		customDTO.setProposalDTO(selectedProposal);
		setTransactionInformation(customDTO, session, ActionNameConstants.VIEW_REPORT);

		customDTO = getReportManager().getDeletedSWORpt(customDTO);
		if (viewReport) {
			viewBean = new DeletedSWOReportViewBean(customDTO, "deletedsworeportview");  //$NON-NLS-1$
		} else {
			viewBean = new DeletedSWOReportViewBean(customDTO, "deletedsworeportdownload", false);  //$NON-NLS-1$
		}

		return viewBean;
	}

	private OPPTViewBean getSysplexReport(OPPTSession session, ProposalCustomDTO selectedProposal, boolean viewReport) throws Exception {
		OPPTViewBean viewBean = null;

		SysplexReportCustomDTO customDTO = new SysplexReportCustomDTO();
		customDTO.setProposalDTO(selectedProposal);
		setTransactionInformation(customDTO, session, ActionNameConstants.VIEW_REPORT);

		customDTO = getReportManager().getSysplexRpt(customDTO);
		if (viewReport) {
			viewBean = new SysplexReportViewBean(customDTO, "sysplexreportview");  //$NON-NLS-1$
		} else {
			viewBean = new SysplexReportViewBean(customDTO, "sysplexreportdownload",false);  //$NON-NLS-1$
		}

		return viewBean;
	}

	private OPPTViewBean getInventoryListReport(OPPTSession session, ProposalCustomDTO selectedProposal, boolean viewReport) throws Exception {
		OPPTViewBean viewBean = null;

		InventoryListReportCustomDTO customDTO = new InventoryListReportCustomDTO();
		customDTO.setProposalDTO(selectedProposal);
		setTransactionInformation(customDTO, session, ActionNameConstants.VIEW_REPORT);

		customDTO = getReportManager().getInventoryListRpt(customDTO);
		if (viewReport) {
			viewBean = new InventoryListReportViewBean(customDTO, "inventorylistview");  //$NON-NLS-1$
		} else {
			viewBean = new InventoryListReportViewBean(customDTO, "inventorylistdownload", false);  //$NON-NLS-1$
		}

		// customDTO.reset();
		customDTO = null;
		System.runFinalization();

		return viewBean;
	}

	private OPPTViewBean getListEntitledPricesReport(OPPTSession session, ProposalCustomDTO selectedProposal, boolean viewReport) throws Exception {
		OPPTViewBean viewBean = null;
		ListEntitledPricesReportCustomDTO customDTO = new ListEntitledPricesReportCustomDTO();
		customDTO.setProposalDTO(selectedProposal);
		setTransactionInformation(customDTO, session, ActionNameConstants.VIEW_REPORT);

		customDTO = getReportManager().getListEntitledRpt(customDTO);
		if (viewReport) {
			viewBean = new ListEntitledPricesReportViewBean(customDTO, "listentitledpricesreportview");  //$NON-NLS-1$
		} else {
			viewBean = new ListEntitledPricesReportViewBean(customDTO, "listentitledpricesreportdownload",false);  //$NON-NLS-1$
		}

		return viewBean;
	}
	
	/* CR4520S */ 
	private OPPTViewBean getUserReverificationReport(OPPTSession session, ReverificationReportCustomDTO customDTO, boolean viewReport) throws Exception {
		OPPTViewBean viewBean = null;
		setTransactionInformation(customDTO, session, ActionNameConstants.VIEW_REVERIFICATION_REPORT);
		customDTO = getReportManager().getReverificationReport(customDTO);
		if (viewReport) {
			viewBean = new ReverificationReportViewBean(customDTO, "reverificationreportview");  //$NON-NLS-1$
		} else {
			viewBean = new ReverificationReportViewBean(customDTO, "reverificationreportdownload",false);  //$NON-NLS-1$
		}

		return viewBean;
	}
	 /* CR4520E */
	
	private OPPTViewBean getdeletedUsersReport(OPPTSession session, DeletedUsersReportCustomDTO customDTO, boolean viewReport) throws Exception {
		OPPTViewBean viewBean = null;
		setTransactionInformation(customDTO, session, ActionNameConstants.VIEW_REVERIFICATION_REPORT);
		customDTO = getReportManager().getdeletedUsersReport(customDTO );
		
		if (viewReport) {
			viewBean = new DeletedUsersReportViewBean(customDTO, "deletionreportview");  //$NON-NLS-1$
		} else {
			viewBean = new DeletedUsersReportViewBean(customDTO, "deletionreportdownload",false);  //$NON-NLS-1$
		}

		return viewBean;
	}
	
	

	private ReportManager getReportManager() throws Exception {
		ReportManagerHome reportHome = (ReportManagerHome) ServiceLocator.getEJBHomeFactory().getRemoteHome("ReportManagerHome");  //$NON-NLS-1$
		return reportHome.create();
	}

	private ContractCustomDTO getCurrentProposalDTO(OPPTSession session) {
		ContractCustomDTO currentProposal = null;
		if (null != session) {
			currentProposal = (ContractCustomDTO) session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);
		}
		return currentProposal;
	}

	private ProposalCustomDTO getSelectedProposal(OPPTSession session, String selectedProposalId) {
		ProposalCustomDTO selectedProposal = null;
		if (null != session && null != selectedProposalId) {
			ReportsCustomDTO reportsDTO = (ReportsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_REPOTRS_PROPOSAL_DETAIL);
			if (null != reportsDTO) {
				Map proposals = reportsDTO.getProposalCustomDTO();
				if (null != proposals) {
					selectedProposal = (ProposalCustomDTO) proposals.get(selectedProposalId);
				}
			}
		}
		return selectedProposal;
	}
	
	/**
     * setTransactionInformation
     * 
     * @param customDTO
     * @param session
     * @param actionName
     * @author thirumalai
     */
    protected void setTransactionInformation(OPPTCustomDTO customDTO, OPPTSession session, String actionName) {
		if (null != customDTO && null != session) {
			UserInfoDataBean userInfo = session.getUserInfo();
			if (null != userInfo) {
				customDTO.setUserInfo(userInfo.getGroupName(), userInfo.getUserId(), userInfo.getRole(), userInfo.getEmailAddress(), userInfo.getPrimarySalesOrg(),userInfo.getUserGroups());
				customDTO.setFirstName(userInfo.getFirstName());
				customDTO.setLastName(userInfo.getLastName());
			}

			customDTO.setSessionId(session.getSessionId());
			customDTO.setTransactionName(actionName);
			// customDTO.setTransactionName(ActionNameConstants.VIEW_REPORT);
		}
	}

	/**
     * getErrorReport
     * 
     * @param errorId
     * @return
     * @author thirumalai
     */
    protected ErrorReport getErrorReport(String errorId) {
		ErrorReport errorReport = null;
		if (null != errorId) {
			errorReport = new ErrorReport();
			errorReport.addErrorEntry(new ErrorKey(errorId, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		return errorReport;
	}

	private String getCurrentForwardName(int role, String actionName) {
		String currentForwardName = null;

		if(actionName.equalsIgnoreCase(ActionNameConstants.PRINT_PROPOSAL)){
			currentForwardName = ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS;
		}
		else if(actionName.equalsIgnoreCase(ActionNameConstants.VIEW_CHECK_REPORT) || actionName.equalsIgnoreCase(ActionNameConstants.VIEW_CHECK_REPORT)){
			switch(role){
				case Constants.PROPOSAL_CREATE_APPROVER: 
					currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CHECK_VARIANCE_STATUS;
					break;

				case Constants.PROPOSAL_ADMINISTRATOR:
				default:
					currentForwardName = ForwardNameConstants.PAGE_CHECK_VARIANCE_STATUS;
					break;
			}
		}
		else {
			switch (role) {
				case Constants.PROPOSAL_CREATE_APPROVER :
					currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_REPORTS;
					break;

				case Constants.PROPOSAL_APPROVER :
					currentForwardName = ForwardNameConstants.PAGE_PROPOSAL_FOR_APPROVAL_REPORTS;
					break;

				case Constants.PROPOSAL_ADMINISTRATOR :
				default :
					currentForwardName = ForwardNameConstants.PAGE_REPORTS;
					break;
			}
		}

		return currentForwardName;
	}

	/**
     * getRole
     * 
     * @param session
     * @return
     * @author thirumalai
     */
    protected int getRole(OPPTSession session) {
		int role = -1;
		if (null != session) {
			switch (session.getUserInfo().getRole()) {
				case RoleConstants.BHD :
				case RoleConstants.OPPT_READ:
				case RoleConstants.CSO :
				case RoleConstants.MARKETING_REP :
				case RoleConstants.BUSINESS_PARTNER :
					role = Constants.PROPOSAL_ADMINISTRATOR;
					break;
				case RoleConstants.PROPOSAL_APPROVER :
					role = Constants.PROPOSAL_APPROVER;
					break;
				case RoleConstants.CREATE_APPROVE :
					role = Constants.PROPOSAL_CREATE_APPROVER;
					break;
				case RoleConstants.ADMINISTRATOR :
					role = Constants.ADMINISTRATOR;
					break;
			    default :
                    break;
            }
		}

		return role;
	}
}
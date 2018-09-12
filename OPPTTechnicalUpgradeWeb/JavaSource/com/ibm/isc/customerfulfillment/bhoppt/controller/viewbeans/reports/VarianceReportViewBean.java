/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceRptCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.*;

/**
 * Holds complete data required for variance report  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class VarianceReportViewBean extends ReportViewBean{
	/**
	 * Empty constructor
	 *
	 */
	public VarianceReportViewBean(){
		
	}
	
	/**
     * One Argument Constructor
     *
     * @param varianceRptCustomDTO
     * @param view 
     */
	public VarianceReportViewBean(VarianceRptCustomDTO varianceRptCustomDTO,String view){
		convertToDOM(varianceRptCustomDTO);
		super.setView(view);
	}
	
	/**
     * VarianceReportViewBean
     * 
     * @param varianceRptCustomDTO
     * @param view
     * @param viewReport
     * @author thirumalai
     */
    public VarianceReportViewBean(VarianceRptCustomDTO varianceRptCustomDTO,String view,boolean viewReport){
		if(viewReport) {
			convertToDOM(varianceRptCustomDTO);
		}
		else {
			convertToHTML(varianceRptCustomDTO);
		}
		super.setView(view);
	}
	/**
	 * This method converts CustomDTO in to DOM Object
	 * @param varianceRptCustomDTO
	 */
	private void convertToDOM(VarianceRptCustomDTO varianceRptCustomDTO) {
	   Document document = null;
	   
	   document=createDocument();
	   // Insert Root Order
	   Element root = (Element) document.createElement("variancereport");
	   // Insert child Manifest
	   document.appendChild(root);

	   VarianceRptDomainDTO varianceRptDomainDTO = varianceRptCustomDTO.getReportDTO();

	   addChildNode(document, (Node) root, "variancedate", formatDateVariance(varianceRptDomainDTO.getVariancedate()));  //$NON-NLS-1$
	   if(checkForNull(varianceRptDomainDTO.getExternalContractNo()).equals("-")) {  //$NON-NLS-1$
		  addChildNode(document, (Node) root, "extcontrno", checkForNull(varianceRptDomainDTO.getContractNo()));  //$NON-NLS-1$
	   }
	   else {
		  addChildNode(document, (Node) root, "extcontrno", checkForNull(varianceRptDomainDTO.getExternalContractNo()));  //$NON-NLS-1$
	   }
	   addChildNode(document, (Node) root, "contractstartdate", formatDateVariance(varianceRptDomainDTO.getContractStartDate()));  //$NON-NLS-1$
	   addChildNode(document, (Node) root, "contractenddate", formatDateVariance(varianceRptDomainDTO.getContractEndDate()));  //$NON-NLS-1$
	   addChildNode(document, (Node) root, "currency", checkForNull(varianceRptDomainDTO.getCurrency()));  //$NON-NLS-1$
	   addChildNode(document, (Node) root, "customerno", checkForNull(varianceRptDomainDTO.getSoldToCustomer()));  //$NON-NLS-1$
	   addChildNode(document, (Node) root, "invoiceamount", parseAmount(varianceRptDomainDTO.getInventoryAtStart()));  //$NON-NLS-1$
	   addChildNode(document, (Node) root, "cumulativeamount", parseAmount(varianceRptDomainDTO.getCumulativeInventory()));  //$NON-NLS-1$
	   addChildNode(document, (Node) root, "capamount", parseAmount(varianceRptDomainDTO.getCapAmount()));  //$NON-NLS-1$
	   addChildNode(document, (Node) root, "capvariance", parseAmount(varianceRptDomainDTO.getCapVariance()));  //$NON-NLS-1$

	   if(varianceRptDomainDTO.getStatusCode().trim().equals("C") || varianceRptDomainDTO.getStatusCode().trim().equals("VB")) {  //$NON-NLS-1$  //$NON-NLS-2$
	   		varianceRptDomainDTO.setCntrPeriodVarNo(varianceRptDomainDTO.getCntrPeriodVarNo() + 1);
	   }
	   
	   String cntrPeriodVarNo = Integer.toString(varianceRptDomainDTO.getCntrPeriodVarNo());
	   
	   addChildNode(document, (Node) root, "cntrperiodvarno", cntrPeriodVarNo);  //$NON-NLS-1$
	   
	   List customerLists = varianceRptDomainDTO.getCustomerDomainDTOList();
	   if (null != customerLists) {

		   Iterator customerListsIterator = customerLists.iterator();
		   while (customerListsIterator.hasNext()) {
			   Node customerNode = document.createElement("customer");  //$NON-NLS-1$
			   root.appendChild(customerNode);

			   VarianceRptCustomerDomainDTO varianceRptCustomerDomainDTO = (VarianceRptCustomerDomainDTO) customerListsIterator.next();
			  		
			   addChildNode(document, customerNode, "customerno", checkForNull(varianceRptCustomerDomainDTO.getCustomerNo()));  //$NON-NLS-1$

			   List dmLists = varianceRptCustomerDomainDTO.getDMDomainDTOList();
			   
			   if (null != dmLists) {
				   
				   Iterator dmListIterator = dmLists.iterator();
				   while (dmListIterator.hasNext()) {

					   Node dmNode = document.createElement("dm");  //$NON-NLS-1$
					   customerNode.appendChild(dmNode);

					   VarianceRptDMDomainDTO varianceRptDMDomainDTO = (VarianceRptDMDomainDTO) dmListIterator.next();
					
					   addChildNode(document, dmNode, "dmdesc", checkForNull(varianceRptDMDomainDTO.getDesgMcDesc()));  //$NON-NLS-1$
					   addChildNode(document, dmNode, "dmno", checkForNull(varianceRptDMDomainDTO.getDesgMcNo()));  //$NON-NLS-1$
					   
					   List swoLists = varianceRptDMDomainDTO.getSWODomainDTOList();
					   
					   if (null != swoLists) {
					
						   Iterator swoListsIterator = swoLists.iterator();
						   while (swoListsIterator.hasNext()) {

							   Node swoNode = document.createElement("swo");  //$NON-NLS-1$
							   dmNode.appendChild(swoNode);

								VarianceRptSWODomainDTO varianceRptSWODomainDTO = (VarianceRptSWODomainDTO) swoListsIterator.next();
					
							   addChildNode(document, swoNode, "swono", checkForNull(varianceRptSWODomainDTO.getSWONo()));  //$NON-NLS-1$
							   addChildNode(document, swoNode, "serialno", checkForNull(varianceRptSWODomainDTO.getSerialNo()));  //$NON-NLS-1$
							   // check the item category and set the corresponding indicator 
							   //addChildNode(document, swoNode, "indicator", checkForNull(varianceRptSWODomainDTO.getIndicator()));
							  
							   List swoEELists = varianceRptSWODomainDTO.getSWOEEDomainDTOList();
							   if (null != swoEELists) {
					
								   Iterator swoEEListsIterator = swoEELists.iterator();
								   while (swoEEListsIterator.hasNext()) {

									   Node eeNode = document.createElement("ee");  //$NON-NLS-1$
									   swoNode.appendChild(eeNode);

									   VarianceRptSWOEEDomainDTO varianceRptSWOEEDomainDTO = (VarianceRptSWOEEDomainDTO) swoEEListsIterator.next();

									   addChildNode(document, eeNode, "eeno", checkForNull(varianceRptSWOEEDomainDTO.getEENo()));  //$NON-NLS-1$
									   addChildNode(document, eeNode, "eedesc", checkForNull(varianceRptSWOEEDomainDTO.getDescription()));  //$NON-NLS-1$
									   
									   List swoEEPriceLists = varianceRptSWOEEDomainDTO.getPriceDomainDTOList();
										if (null != swoEEPriceLists) {

											Iterator swoEEPriceListsIterator = swoEEPriceLists.iterator();
											while (swoEEPriceListsIterator.hasNext()) {
											
												Node priceNode = document.createElement("price");  //$NON-NLS-1$
												eeNode.appendChild(priceNode);
												VarianceRptPriceDomainDTO varianceRptPriceDomainDTO = (VarianceRptPriceDomainDTO) swoEEPriceListsIterator.next();

												addChildNode(document, priceNode, "price", parseAmount(varianceRptPriceDomainDTO.getESWPrice()));  //$NON-NLS-1$
												addChildNode(document, priceNode, "effectivedate", formatDateVariance(varianceRptPriceDomainDTO.getPlanStartDate()));  //$NON-NLS-1$
												addChildNode(document, priceNode, "indicator", checkForNull(varianceRptPriceDomainDTO.getIndicator()));  //$NON-NLS-1$
																																						
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
	   super.setDocument(document);
   }
   
	/**
     * convertToHTML
     * @param varianceRptCustomDTO
     * @author thirumalai
     */
    public void convertToHTML(VarianceRptCustomDTO varianceRptCustomDTO){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<style>\n");  //$NON-NLS-1$
		buffer.append(".heading .content \n");  //$NON-NLS-1$
		buffer.append(".cellHeading {background-color:#ffffff;vertical-align:top;height:19px}\n");  //$NON-NLS-1$
		buffer.append(".cellContent {background-color:#ffffff;vertical-align:bottom;height:19px}\n");  //$NON-NLS-1$
		buffer.append("</style>\n");  //$NON-NLS-1$
		
		VarianceRptDomainDTO varianceRptDomainDTO = varianceRptCustomDTO.getReportDTO();
		
		String value = null;
		if(checkForNull(varianceRptDomainDTO.getExternalContractNo()).equals("-")) {  //$NON-NLS-1$
			value = checkForNull(varianceRptDomainDTO.getContractNo());
		}
		else {
			value = checkForNull(varianceRptDomainDTO.getExternalContractNo());
		}
		
		if(varianceRptDomainDTO.getStatusCode().trim().equals("C") || varianceRptDomainDTO.getStatusCode().trim().equals("VB")) {  //$NON-NLS-1$  //$NON-NLS-2$
			varianceRptDomainDTO.setCntrPeriodVarNo(varianceRptDomainDTO.getCntrPeriodVarNo() + 1);
		}
	   
	   String cntrPeriodVarNo = Integer.toString(varianceRptDomainDTO.getCntrPeriodVarNo());
	   
		buffer.append("<table width=\"1280\" border=\"0\">");  //$NON-NLS-1$
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"10\"><font LOTUS_SIZE=\"8\" COLOR=\"red\">IBM Confidential</font></td></tr>\n");
		buffer.append("<tr rowspan=\"2\"><td  colspan=\"18\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td></tr>");  //$NON-NLS-1$
		buffer.append("<tr><td  colspan=\"18\"  align=\"center\" valign=\"top\" height=\"29\"><b>Variance "+cntrPeriodVarNo+" report</b></td></tr>");  //$NON-NLS-2$  //$NON-NLS-1$
		
		buffer.append("<tr><td  colspan=\"18\"  align=\"left\" class=\"cellContent\"><b>Variance date : </b>"+formatDateVariance(varianceRptDomainDTO.getVariancedate())+" </td></tr>");  //$NON-NLS-2$  //$NON-NLS-1$
		buffer.append("<tr><td  colspan=\"18\"  align=\"left\" class=\"cellContent\"><b>External contract number : </b>"+value+" </td></tr>");  //$NON-NLS-2$  //$NON-NLS-1$
		buffer.append("<tr><td  colspan=\"18\"  align=\"left\" class=\"cellContent\"><b>Contract period start date : </b>"+formatDateVariance(varianceRptDomainDTO.getContractStartDate())+" </td></tr>");  //$NON-NLS-2$  //$NON-NLS-1$
		buffer.append("<tr><td  colspan=\"18\"  align=\"left\" class=\"cellContent\"><b>Contract period end date : </b>"+formatDateVariance(varianceRptDomainDTO.getContractEndDate())+" </td></tr>");  //$NON-NLS-2$  //$NON-NLS-1$
		buffer.append("<tr><td  colspan=\"18\"  align=\"left\" class=\"cellContent\"><b>Currency : </b>"+checkForNull(varianceRptDomainDTO.getCurrency())+" </td></tr>");  //$NON-NLS-2$  //$NON-NLS-1$
		
		buffer.append("<tr><td  colspan=\"18\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td></tr>");  //$NON-NLS-1$
		
		buffer.append("<tr><td  colspan=\"18\"  align=\"left\" class=\"cellContent\"><b>Sold-to customer no : </b>"+checkForNull(varianceRptDomainDTO.getSoldToCustomer())+" </td></tr>");  //$NON-NLS-2$  //$NON-NLS-1$
		buffer.append("<tr><td  colspan=\"18\"  align=\"left\" class=\"cellContent\"><b>Inventory at period start of contract : </b>"+parseAmount(varianceRptDomainDTO.getInventoryAtStart())+" </td></tr>");  //$NON-NLS-2$  //$NON-NLS-1$
		buffer.append("<tr><td  colspan=\"18\"  align=\"left\" class=\"cellContent\"><b>Cumulative actual inventory as of variance date : </b>"+parseAmount(varianceRptDomainDTO.getCumulativeInventory())+" </td></tr>");  //$NON-NLS-2$  //$NON-NLS-1$
		buffer.append("<tr><td  colspan=\"18\"  align=\"left\" class=\"cellContent\"><b>CAP amount : </b>"+parseAmount(varianceRptDomainDTO.getCapAmount())+" </td></tr>");  //$NON-NLS-2$  //$NON-NLS-1$
		buffer.append("<tr><td  colspan=\"18\"  align=\"left\" class=\"cellContent\"><b>CAP variance : </b>"+parseAmount(varianceRptDomainDTO.getCapVariance())+" </td></tr>");  //$NON-NLS-2$  //$NON-NLS-1$
	   
		buffer.append("<tr><td  colspan=\"18\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td></tr>");  //$NON-NLS-1$
		
		buffer.append("<tr>");  //$NON-NLS-1$
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><b>Customer no.</b></td>");  //$NON-NLS-1$
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><b>Desig mach.</b></td>");  //$NON-NLS-1$
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><b>SWO no.</b></td>");  //$NON-NLS-1$
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><b>Serial no.</b></td>");  //$NON-NLS-1$
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><b>EE no.</b></td>");  //$NON-NLS-1$
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><b>Description of EE</b></td>");  //$NON-NLS-1$
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"24\"><b>Entitled price</b></td>");  //$NON-NLS-1$
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"24\"><b>Effective date</b></td>");  //$NON-NLS-1$
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"24\"><b>Ind</b></td>");  //$NON-NLS-1$
		buffer.append("</tr>\n");  //$NON-NLS-1$
		

		List customerLists = varianceRptDomainDTO.getCustomerDomainDTOList();
		if (null != customerLists) {

			for(int custCounter=0, custSize=customerLists.size(); custCounter<custSize; custCounter++){
				VarianceRptCustomerDomainDTO varianceRptCustomerDomainDTO = (VarianceRptCustomerDomainDTO) customerLists.get(custCounter);

			/*	buffer.append("<tr>");  //$NON-NLS-1$		
				buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptCustomerDomainDTO.getCustomerNo())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
*/			  		  
				List dmLists = varianceRptCustomerDomainDTO.getDMDomainDTOList();
			   
				if (null != dmLists) {

					for(int dmCounter=0, dmSize=dmLists.size(); dmCounter<dmSize; dmCounter++){
						VarianceRptDMDomainDTO varianceRptDMDomainDTO = (VarianceRptDMDomainDTO) dmLists.get(dmCounter);

						/*if(dmCounter!=0) {
							buffer.append("<tr>");  //$NON-NLS-1$		
							buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"></td>");  //$NON-NLS-1$
						}
						buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptDMDomainDTO.getDesgMcNo())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
*/
						List swoLists = varianceRptDMDomainDTO.getSWODomainDTOList();
					   
						if (null != swoLists) {

							for(int swoCounter=0, swoSize=swoLists.size(); swoCounter<swoSize; swoCounter++){
								VarianceRptSWODomainDTO varianceRptSWODomainDTO = (VarianceRptSWODomainDTO) swoLists.get(swoCounter);
								
							/*if(swoCounter!=0) {
									buffer.append("<tr>");  //$NON-NLS-1$		
									buffer.append("<td lotus_celltype=\"label\" colspan=\"4\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"></td>");  //$NON-NLS-1$
								}

								buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptSWODomainDTO.getSWONo())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
								buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptSWODomainDTO.getSerialNo())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
*/
								List swoEELists = varianceRptSWODomainDTO.getSWOEEDomainDTOList();
								if (null != swoEELists) {

									for(int swoEECounter=0, swoEESize=swoEELists.size(); swoEECounter<swoEESize; swoEECounter++){
										VarianceRptSWOEEDomainDTO varianceRptSWOEEDomainDTO = (VarianceRptSWOEEDomainDTO) swoEELists.get(swoEECounter);
										
										/*if(swoEECounter!=0) {
											buffer.append("<tr>");  //$NON-NLS-1$		
											buffer.append("<td lotus_celltype=\"label\" colspan=\"8\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"></td>");  //$NON-NLS-1$
										}

										buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptSWOEEDomainDTO.getEENo())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
										buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptSWOEEDomainDTO.getDescription())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
*/
										List swoEEPriceLists = varianceRptSWOEEDomainDTO.getPriceDomainDTOList();
										if (null != swoEEPriceLists && swoEEPriceLists.size()!=0) {
											buffer.append("<tr>");  //$NON-NLS-1$		
											buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptCustomerDomainDTO.getCustomerNo())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
											
												buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptDMDomainDTO.getDesgMcNo())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
											
												buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptSWODomainDTO.getSWONo())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
												buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptSWODomainDTO.getSerialNo())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
											
												buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptSWOEEDomainDTO.getEENo())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
												buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptSWOEEDomainDTO.getDescription())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
												

											for(int priceCounter=0, priceSize=swoEEPriceLists.size(); priceCounter<priceSize; priceCounter++){ // Changed by Sara for EF0802041834 on 03 Aug 2004
												VarianceRptPriceDomainDTO varianceRptPriceDomainDTO = (VarianceRptPriceDomainDTO) swoEEPriceLists.get(priceCounter);
												/*if(priceCounter!=0) {
													buffer.append("<tr>");  //$NON-NLS-1$		
													buffer.append("<td lotus_celltype=\"label\" colspan=\"12\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"></td>");  //$NON-NLS-1$
												}*/

												buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"24\">"+parseAmount(varianceRptPriceDomainDTO.getESWPrice())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
												buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"24\">"+formatDateVariance(varianceRptPriceDomainDTO.getPlanStartDate())+"</td>");  //$NON-NLS-2$  //$NON-NLS-1$
												buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"24\">"+checkForNull(varianceRptPriceDomainDTO.getIndicator())+"</td></tr>");  //$NON-NLS-2$  //$NON-NLS-1$
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
		
		buffer.append("<tr><td  colspan=\"18\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td></tr>");  //$NON-NLS-1$

		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><b>Ind = Indicator</b></td></tr>");  //$NON-NLS-1$
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">I = Initial</td></tr>");  //$NON-NLS-1$
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">A = Addition</td></tr>");  //$NON-NLS-1$
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">R = Removal</td></tr>");  //$NON-NLS-1$
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">B = Bump</td></tr>");  //$NON-NLS-1$
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">P = Price change</td></tr>");  //$NON-NLS-1$
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">S = SVC</td></tr>");  //$NON-NLS-1$
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">D = Deselected</td></tr>");  //$NON-NLS-1$
		
		buffer.append("</table>\n");  //$NON-NLS-1$
		buffer.append("</table>\n");  //$NON-NLS-1$
				
		buffer.append("</center>\n");  //$NON-NLS-1$
		buffer.append("</body>\n");  //$NON-NLS-1$
		buffer.append("</html>\n");  //$NON-NLS-1$
	
		setDownloadContent(buffer.toString());
	}
}

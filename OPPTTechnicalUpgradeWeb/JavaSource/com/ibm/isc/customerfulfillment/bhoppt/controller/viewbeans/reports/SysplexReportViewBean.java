/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.EEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SysplexReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.*;

/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><strong>Known Bugs</strong><br/> 
 * 
 * <br/><PRE> 
 * date Feb 24, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class SysplexReportViewBean extends ReportViewBean {
	private int serialNumber = 0;

	/**
     * convertToDOM
     * 
     * @param customDTO
     * @author thirumalai
     */
    protected void convertToDOM(SysplexReportCustomDTO customDTO) {
		Document document = null;
		Element dmParentElem = null;
		Element swoParentElem = null;
		CustomerDomainDTO customerDto = null;
		SWODomainDTO swoDto = null;
		EEDomainDTO eeDto = null;
		int totalCount = 0;
		int firstMargin = 0;
		int secondMargin = 0;
		int pageWidth = 0;
		int secondPagewidth = 0;

		document = createDocument();
		Element root = (Element) document.createElement("sysplexreport");  //$NON-NLS-1$

		document.appendChild(root);

		SysplexRptDomainDTO sysplexRptDomainDTO = customDTO.getReportDTO();
		//		populateDto(sysplexRptDomainDTO);
		//		List customerList = sysplexRptDomainDTO.getCustomerDomainDTOList();
		List dmList = sysplexRptDomainDTO.getDMDomainDTOList();
		root.setAttribute("reportprinteddate", formatDate(sysplexRptDomainDTO.getRptPrintedOn()));  //$NON-NLS-1$
		root.setAttribute("priceasof", formatDate(sysplexRptDomainDTO.getPriceAsOf()));  //$NON-NLS-1$
		root.setAttribute("proposalname", sysplexRptDomainDTO.getProposalName());  //$NON-NLS-1$
		root.setAttribute("contractnumber", sysplexRptDomainDTO.getContractNo());  //$NON-NLS-1$
		root.setAttribute("contractstartdate", formatDate(sysplexRptDomainDTO.getContractStartDate()));  //$NON-NLS-1$
		root.setAttribute("contractenddate", formatDate(sysplexRptDomainDTO.getContractEndDate()));  //$NON-NLS-1$
		root.setAttribute("totalcharge", String.valueOf(sysplexRptDomainDTO.getTotalCharge()));  //$NON-NLS-1$
		if (null == dmList || dmList.size() == 0) {
			root.setAttribute("hasdata", "empty");  //$NON-NLS-2$  //$NON-NLS-1$
		} else {
			root.setAttribute("hasdata", "populated");  //$NON-NLS-1$  //$NON-NLS-2$
		}
		if (null != dmList && dmList.size() != 0) {
			int length = dmList.size();
			dmParentElem = (Element) document.createElement("dmdetail");  //$NON-NLS-1$
			swoParentElem = (Element) document.createElement("swodetail");
			root.appendChild(dmParentElem);
			root.appendChild(swoParentElem);
			serialNumber = 0;
			populateDMDetail(document, dmList, dmParentElem, swoParentElem, root);
		} else {
			totalCount = 13;
			firstMargin = (totalCount - 8) / 2;
			secondMargin = totalCount - 8 - firstMargin;
			pageWidth = 49;
			secondPagewidth = 44;
			root.setAttribute("count", String.valueOf(totalCount));  //$NON-NLS-1$
			root.setAttribute("firstMargin", String.valueOf(firstMargin));  //$NON-NLS-1$
			root.setAttribute("secondMargin", String.valueOf(secondMargin));  //$NON-NLS-1$
			root.setAttribute("pageWidth", String.valueOf(pageWidth) + "cm");  //$NON-NLS-2$  //$NON-NLS-1$
			root.setAttribute("secondPagewidth", String.valueOf(secondPagewidth) + "cm");  //$NON-NLS-2$  //$NON-NLS-1$
		}
		/*
		if(null == customerList || customerList.size() == 0){
			root.setAttribute("hasdata","empty");
		}
		else{
			root.setAttribute("hasdata","populated");
		}
		
		if(null != customerList && customerList.size() != 0){
			int length = customerList.size();
			dmParentElem = (Element) document.createElement("dmdetail");
			swoParentElem = (Element) document.createElement("swodetail");
			root.appendChild(dmParentElem);
			root.appendChild(swoParentElem);
			serialNumber = 0;
			for(int i = 0; i < length; i++){
				customerDto = (CustomerDomainDTO)customerList.get(i);
				if(null != customerDto){
					populateDMDetail(document, customerDto.getDMDTOList(),dmParentElem, swoParentElem, root);
				}
			}
		}
		else {
			totalCount  = 13;
			firstMargin = (totalCount - 8)/2;
			secondMargin = totalCount - 8 - firstMargin;
			pageWidth = 49;
			secondPagewidth = 44;
			root.setAttribute("count", String.valueOf(totalCount));
			root.setAttribute("firstMargin", String.valueOf(firstMargin));
			root.setAttribute("secondMargin", String.valueOf(secondMargin));
			root.setAttribute("pageWidth", String.valueOf(pageWidth)+"cm");
			root.setAttribute("secondPagewidth", String.valueOf(secondPagewidth)+"cm");	
		}
		*/
	}

	private void populateDMDetail(Document document, List dmDtoList, Element dmParentElem, Element swoParentElem, Element root) {
		SysplexRptDMDomainDTO dmDto = null;
		Element countPrice = null;
		int totalCount = 0;
		int firstMargin = 0;
		int secondMargin = 0;
		int pageWidth = 0;
		int secondPagewidth = 0;
		Element dm = null;
		if (null != dmDtoList) {

			int length = dmDtoList.size();
			for (int i = 0; i < length; i++) {
				dmDto = (SysplexRptDMDomainDTO) dmDtoList.get(i);
				if (null != dmDto) {
					serialNumber++;
					countPrice = (Element) document.createElement("countPrice");  //$NON-NLS-1$
					countPrice.setAttribute("displayCount", String.valueOf(serialNumber));  //$NON-NLS-1$
					root.appendChild(countPrice);
					dm = (Element) document.createElement("dm");  //$NON-NLS-1$
					dm.setAttribute("serialno", String.valueOf(serialNumber));  //$NON-NLS-1$
					dm.setAttribute("dmnumber", dmDto.getDesgMcNo());  //$NON-NLS-1$
					dm.setAttribute("dmdescription", dmDto.getDesgMcDesc());  //$NON-NLS-1$
					dmParentElem.appendChild(dm);
					populateSWODetail(document, dmDto, swoParentElem, serialNumber);
				}
			}
		}
		totalCount = 11 + serialNumber;
		firstMargin = (totalCount - 8) / 2;
		secondMargin = totalCount - 8 - firstMargin;
		pageWidth = 45 + (serialNumber * 2);
		secondPagewidth = 40 + (serialNumber * 2);
		root.setAttribute("count", String.valueOf(totalCount));  //$NON-NLS-1$
		root.setAttribute("firstMargin", String.valueOf(firstMargin));  //$NON-NLS-1$
		root.setAttribute("secondMargin", String.valueOf(secondMargin));  //$NON-NLS-1$
		root.setAttribute("pageWidth", String.valueOf(pageWidth) + "cm");  //$NON-NLS-2$  //$NON-NLS-1$
		root.setAttribute("secondPagewidth", String.valueOf(secondPagewidth) + "cm");  //$NON-NLS-2$  //$NON-NLS-1$
	}

	private void populateSWODetail(Document document, SysplexRptDMDomainDTO dmDto, Element swoParentElem, int serialNumber) {
		SysplexRptSWODomainDTO swoDto = null;
		SysplexRptSWOEEDomainDTO eeDto = null;
		Element swo = null;
		Element markDM = null;
		String swoNumber = "";  //$NON-NLS-1$

		List swoDtoList = dmDto.getSWODomainDTOLiat();
		if (null != swoDtoList) {
			int length = swoDtoList.size();
			for (int i = 0; i < length; i++) {
				swoDto = (SysplexRptSWODomainDTO) swoDtoList.get(i);
				swoNumber = swoDto.getSWONo();
				List eeList = swoDto.getSWOEEDomainDTOList();
				if (null != eeList) {
					int lengthEE = eeList.size();
					for (int j = 0; j < lengthEE; j++) {
						eeDto = (SysplexRptSWOEEDomainDTO) eeList.get(j);
						if (null != swoDto) {
							swo = (Element) document.createElement("swo");  //$NON-NLS-1$
							swo.setAttribute("swono", swoNumber);  //$NON-NLS-1$
							swo.setAttribute("eenumber", eeDto.getEENo());  //$NON-NLS-1$
							swo.setAttribute("eedesc", eeDto.getDescription());  //$NON-NLS-1$
							swo.setAttribute("price", parseAmount(eeDto.getPrice()));  //$NON-NLS-1$
							for (int selectDm = 1; selectDm <= serialNumber; selectDm++) {
								markDM = (Element) document.createElement("markDM");  //$NON-NLS-1$
								if (selectDm == serialNumber) {
									markDM.setAttribute("dmSelected", "X");  //$NON-NLS-2$  //$NON-NLS-1$
								} else {
									markDM.setAttribute("dmSelected", "");  //$NON-NLS-2$  //$NON-NLS-1$
								}
								swo.appendChild(markDM);
							}
							swoParentElem.appendChild(swo);
						}
					}
				}
			}
		}
	}

	/**
     * SysplexReportViewBean
     * 
     * @author thirumalai
     */
	public SysplexReportViewBean(SysplexReportCustomDTO customDTO, String view) {
		convertToDOM(customDTO);
		setView(view);
	}

	/**
     * SysplexReportViewBean
     * 
     * @param customDTO
     * @param view
     * @param viewReport
     * @author thirumalai
     */
    public SysplexReportViewBean(SysplexReportCustomDTO customDTO, String view, boolean viewReport) {
		if (viewReport) {
			convertToDOM(customDTO);
		} else {
			convertToHTML(customDTO);
		}
		setView(view);
	}

	/**
     * SysplexReportViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public SysplexReportViewBean(SysplexReportCustomDTO customDTO) {
		convertToDOM(customDTO);
		setView("sysplexreportview");  //$NON-NLS-1$
	}

	/**
     * convertToHTML
     * 
     * @param customDTO
     * @author thirumalai
     */
    protected void convertToHTML(SysplexReportCustomDTO customDTO) {
		StringBuffer buffer = new StringBuffer();
		int count = 0;
		int firstMargin = 0;
		int secondMargin = 0;
		int pageWidth = 0;
		int secondPagewidth = 0;
		int serialNumber = 0;
		SysplexRptDomainDTO reportDTO = customDTO.getReportDTO();
		List dmList = reportDTO.getDMDomainDTOList();

		if (dmList != null && dmList.size() > 0) {
			serialNumber = dmList.size();
			count = 11 + serialNumber;
			firstMargin = (count - 8) / 2;
			secondMargin = count - 8 - firstMargin;
			pageWidth = 45 + (serialNumber * 2);
			secondPagewidth = 40 + (serialNumber * 2);

		} else {
			serialNumber = 0;
			count = 13;
			firstMargin = (count - 8) / 2;
			secondMargin = count - 8 - firstMargin;
			pageWidth = 49;
			secondPagewidth = 44;
		}

		buffer.append("<html xml:lang=\"en\" lang=\"en\">");  //$NON-NLS-1$
		buffer.append("<head>");  //$NON-NLS-1$
		buffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">");  //$NON-NLS-1$
		buffer.append("</meta>");  //$NON-NLS-1$
		buffer.append("</meta>");  //$NON-NLS-1$
		buffer.append("<meta name=\"Version\" content=\"1.0\">");  //$NON-NLS-1$
		buffer.append("</meta>");  //$NON-NLS-1$
		buffer.append("<meta name=\"DC.Rights\" content=\"Copyright (c) 2003 by IBM Corporation\" />");  //$NON-NLS-1$
		buffer.append("<title> Sysplex report </title>");  //$NON-NLS-1$
		buffer.append("</head>");  //$NON-NLS-1$

		buffer.append("<body>");  //$NON-NLS-1$
		buffer.append("<center>");  //$NON-NLS-1$
		buffer.append("<table border=\"0\" lotus_anchor=\"A4..S14\" width=\"1120\">");  //$NON-NLS-1$
		buffer.append("<lotus_global align=\"center\" valign=\"bottom\" lotus_format=\"General\" height=\"19\" width=\"81\" grid=\"OFF\" gridcolor=\"#cccccc\">");  //$NON-NLS-1$
		buffer.append("</lotus_global>");  //$NON-NLS-1$
		buffer.append("<tr>");  //$NON-NLS-1$
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"" + count + "\" height=\"19\">");  //$NON-NLS-1$  //$NON-NLS-2$
		
		buffer.append("<a href=\"#main\">");  //$NON-NLS-1$
		buffer.append("&nbsp");  //$NON-NLS-1$
		buffer.append("</a> &#160;");  //$NON-NLS-1$

		buffer.append("");  //$NON-NLS-1$
		buffer.append("</td>");  //$NON-NLS-1$
		buffer.append("</tr> \n");  //$NON-NLS-1$
		buffer.append("<tr>");  //$NON-NLS-1$
		buffer.append("<a name=\"main\">");  //$NON-NLS-1$
		buffer.append("</a>");  //$NON-NLS-1$
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"10\"><p style=\"color:red;\">IBM Confidential</p></td></tr>\n");
		buffer.append("<td lotus_celltype=\"label\" colspan=\"" + count + "\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"24\">");  //$NON-NLS-1$  //$NON-NLS-2$
		
		buffer.append("<strong> Coupled environment sysplex report </strong>");  //$NON-NLS-1$
		buffer.append("");  //$NON-NLS-1$
		buffer.append("</td>");  //$NON-NLS-1$
		buffer.append("</tr> \n");  //$NON-NLS-1$
		buffer.append("<tr>");  //$NON-NLS-1$
		if (reportDTO != null) {
			buffer.append("<td lotus_celltype=\"label\" colspan=\"" + count + "\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">");
			buffer.append("<strong> Report printed : " + formatDate(reportDTO.getRptPrintedOn()));  //$NON-NLS-1$
			buffer.append("</strong>");  //$NON-NLS-1$
			buffer.append("");  //$NON-NLS-1$
			buffer.append("</td>");  //$NON-NLS-1$
			buffer.append("</tr> \n");  //$NON-NLS-1$
			buffer.append("<tr>");  //$NON-NLS-1$
			buffer.append("<td lotus_celltype=\"label\" colspan=\"" + count + "\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">");  //$NON-NLS-2$  //$NON-NLS-1$
			buffer.append("<strong> Prices as of : " + formatDate(reportDTO.getPriceAsOf()));  //$NON-NLS-1$
			buffer.append("</strong>");  //$NON-NLS-1$
			buffer.append("");  //$NON-NLS-1$
			buffer.append("</td>");  //$NON-NLS-1$
			buffer.append("</tr> \n");  //$NON-NLS-1$
			buffer.append("<tr>");  //$NON-NLS-1$
			buffer.append("<td lotus_celltype=\"label\" colspan=\"" + count + "\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$  //$NON-NLS-2$
			buffer.append(
				"	Contract period : "  //$NON-NLS-1$
					+ formatDate(reportDTO.getContractStartDate())
					+ " - "  //$NON-NLS-1$
					+ formatDate(reportDTO.getContractEndDate()));
			buffer.append("");  //$NON-NLS-1$
			buffer.append("</td>");  //$NON-NLS-1$
			buffer.append("</tr> \n");  //$NON-NLS-1$
			buffer.append("<tr>");  //$NON-NLS-1$
			buffer.append("<td lotus_celltype=\"label\" colspan=\"" + count + "\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$  //$NON-NLS-2$
			buffer.append("	Proposal name : " + checkForNull(reportDTO.getProposalName()));  //$NON-NLS-1$
			buffer.append("");  //$NON-NLS-1$
			buffer.append("</td>");  //$NON-NLS-1$
			buffer.append("</tr> \n");  //$NON-NLS-1$
			buffer.append("<tr>");  //$NON-NLS-1$
			buffer.append("<td lotus_celltype=\"label\" colspan=\"" + count + "\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$  //$NON-NLS-2$
			buffer.append("Contract number : " + checkForNull(reportDTO.getContractNo()));  //$NON-NLS-1$
			buffer.append("");  //$NON-NLS-1$
			buffer.append("</td>");  //$NON-NLS-1$
			buffer.append("</tr> \n");
			buffer.append("<tr>");  //$NON-NLS-1$
			buffer.append("<td lotus_celltype=\"label\" colspan=\"" + count + "\" bgcolor=\"#ffffff\" height=\"19\"> &#160;");  //$NON-NLS-1$  //$NON-NLS-2$
			buffer.append("</td>");  //$NON-NLS-1$
			buffer.append("</tr> \n");  //$NON-NLS-1$
			buffer.append("<tr>");  //$NON-NLS-1$
			buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
			buffer.append("");  //$NON-NLS-1$
			buffer.append("<strong> Sr No </strong>");  //$NON-NLS-1$
			buffer.append("");  //$NON-NLS-1$
			buffer.append("</td>");  //$NON-NLS-1$
			buffer.append("<td lotus_celltype=\"label\" colspan=\"" + firstMargin + "\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$  //$NON-NLS-2$
			buffer.append("&#160;");  //$NON-NLS-1$
			buffer.append("");  //$NON-NLS-1$
			buffer.append("</td>");  //$NON-NLS-1$
			buffer.append("<td lotus_celltype=\"label\" colspan=\"3\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
			buffer.append("<strong> Designated machine </strong>");  //$NON-NLS-1$
			buffer.append("");  //$NON-NLS-1$
			buffer.append("</td>");  //$NON-NLS-1$
			buffer.append("<td lotus_celltype=\"label\" colspan=\"" + secondMargin + "\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$  //$NON-NLS-2$
			buffer.append("");  //$NON-NLS-1$
			buffer.append("</td>");  //$NON-NLS-1$
			buffer.append("<td lotus_celltype=\"label\" colspan=\"4\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
			buffer.append("<strong> Designated machine desc </strong>");  //$NON-NLS-1$
			buffer.append("");  //$NON-NLS-1$
			buffer.append("</td>");  //$NON-NLS-1$
			buffer.append("</tr> \n");  //$NON-NLS-1$

			if (dmList != null && dmList.size() > 0) {
				for (int k = 0; k < dmList.size(); k++) {
					SysplexRptDMDomainDTO dm = (SysplexRptDMDomainDTO) dmList.get(k);

					buffer.append("<tr>");  //$NON-NLS-1$
					buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
					buffer.append((k + 1));
					buffer.append("");  //$NON-NLS-1$
					buffer.append("</td>");  //$NON-NLS-1$
					buffer.append("<td lotus_celltype=\"label\" colspan=\"" + firstMargin + "\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$  //$NON-NLS-2$
					buffer.append("");  //$NON-NLS-1$
					buffer.append("</td>");  //$NON-NLS-1$
					buffer.append("<td lotus_celltype=\"label\" colspan=\"3\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
					buffer.append(checkForNull(dm.getDesgMcNo()));
					buffer.append("");  //$NON-NLS-1$
					buffer.append("</td>");  //$NON-NLS-1$
					buffer.append("<td lotus_celltype=\"label\" colspan=\"" + secondMargin + "\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$  //$NON-NLS-2$
					buffer.append("&#160;");  //$NON-NLS-1$

					buffer.append("");  //$NON-NLS-1$
					buffer.append("</td>");  //$NON-NLS-1$
					buffer.append("<td lotus_celltype=\"label\" colspan=\"4\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
					buffer.append(checkForNull(dm.getDesgMcDesc()));
					buffer.append("");  //$NON-NLS-1$
					buffer.append("</td>");  //$NON-NLS-1$
					buffer.append("</tr> \n");  //$NON-NLS-1$

				}

				buffer.append("<tr>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"" + count + "\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\"> &#160;");  //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("</tr> \n");  //$NON-NLS-1$

				buffer.append("<tr>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
				buffer.append("<strong> SWO Number </strong>");  //$NON-NLS-1$
				buffer.append("");  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" height=\"19\"> &#160;");  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
				buffer.append("<strong> EE Number </strong>");  //$NON-NLS-1$
				buffer.append("");  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" height=\"19\"> &#160;");  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
				buffer.append("<strong> EE Description </strong>");  //$NON-NLS-1$
				buffer.append("");  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" height=\"19\"> &#160;");  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
				buffer.append("<strong> Price </strong>");  //$NON-NLS-1$
				buffer.append("");  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" height=\"19\"> &#160;");  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$

				// For Loop needed till the DM Size
				for (int k = 0; k < dmList.size(); k++) {
					buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
					buffer.append("<strong>");  //$NON-NLS-1$
					buffer.append((k + 1));
					buffer.append("</strong>");  //$NON-NLS-1$
					buffer.append("");  //$NON-NLS-1$
					buffer.append("</td>");  //$NON-NLS-1$
				}

				buffer.append("</tr> \n");  //$NON-NLS-1$
				buffer.append("<tr>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"" + count + "\" bgcolor=\"#ffffff\" height=\"19\"> &#160;");  //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("</tr> \n");  //$NON-NLS-1$

				// In LOOP
				for (int k = 0; k < dmList.size(); k++) {
					SysplexRptDMDomainDTO dm = (SysplexRptDMDomainDTO) dmList.get(k);
					List swoDtoList = dm.getSWODomainDTOLiat();
					if (null != swoDtoList) {
						int length = swoDtoList.size();
						for (int i = 0; i < length; i++) {
							SysplexRptSWODomainDTO swoDto = (SysplexRptSWODomainDTO) swoDtoList.get(i);
							String swoNumber = swoDto.getSWONo();
							List eeList = swoDto.getSWOEEDomainDTOList();
							if (null != eeList) {
								int lengthEE = eeList.size();
								for (int j = 0; j < lengthEE; j++) {
									SysplexRptSWOEEDomainDTO eeDto = (SysplexRptSWOEEDomainDTO) eeList.get(j);
									if (null != swoDto) {
										buffer.append("<tr>");  //$NON-NLS-1$
										buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
										buffer.append(checkForNull(swoNumber));
										buffer.append("");  //$NON-NLS-1$
										buffer.append("</td>");  //$NON-NLS-1$
										buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" height=\"19\"> &#160;");  //$NON-NLS-1$

										buffer.append("</td>");  //$NON-NLS-1$
										buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
										buffer.append(checkForNull(eeDto.getEENo()));
										buffer.append("");  //$NON-NLS-1$
										buffer.append("</td>");  //$NON-NLS-1$
										buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" height=\"19\"> &#160;");  //$NON-NLS-1$

										buffer.append("</td>");  //$NON-NLS-1$
										buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
										buffer.append(checkForNull(eeDto.getDescription()));
										buffer.append("");  //$NON-NLS-1$
										buffer.append("</td>");  //$NON-NLS-1$
										buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" height=\"19\"> &#160;");  //$NON-NLS-1$
										buffer.append("</td>");  //$NON-NLS-1$

										buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" align=\"right\" bgcolor=\"#ffffff\" height=\"19\">");  //$NON-NLS-1$
										buffer.append(parseAmount(eeDto.getPrice()));
										buffer.append("");  //$NON-NLS-1$
										buffer.append("</td>");  //$NON-NLS-1$
										buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" height=\"19\"> &#160;");  //$NON-NLS-1$
										buffer.append("</td>");  //$NON-NLS-1$

										String dmSelected = "";  //$NON-NLS-1$
										for (int selectDm = 0; selectDm <= k; selectDm++) {
											if (selectDm == k) {
												dmSelected = "X";  //$NON-NLS-1$
											}
											buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" height=\"19\">");  //$NON-NLS-1$
											buffer.append(dmSelected);
											buffer.append("");  //$NON-NLS-1$
											buffer.append("</td>");  //$NON-NLS-1$
										}

										buffer.append("</tr> \n");  //$NON-NLS-1$
									}
								}
							}
						}
					}
				}
				// End of LOOP

				buffer.append("<tr>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"" + count + "\" bgcolor=\"#ffffff\" height=\"19\"> &#160;");  //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("</tr> \n");  //$NON-NLS-1$
				buffer.append("<tr>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"8\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
				buffer.append("<strong> Total software charge for configuration  :</strong>");  //$NON-NLS-1$
				buffer.append("");  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$
				buffer.append("<strong>" + parseAmount(reportDTO.getTotalCharge()) + "</strong>");  //$NON-NLS-2$  //$NON-NLS-1$
				buffer.append("");  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("</tr> \n");  //$NON-NLS-1$

			} else {
				buffer.append("<tr>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"" + count + "\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append("<strong> MLC product </strong>");  //$NON-NLS-1$
				buffer.append("");  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("</tr> \n");  //$NON-NLS-1$
				buffer.append("<tr>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"" + count + "\" bgcolor=\"#ffffff\" height=\"19\"> &#160;");  //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("</tr> \n");  //$NON-NLS-1$
				buffer.append("<tr>");  //$NON-NLS-1$
				buffer.append("<td lotus_celltype=\"label\" colspan=\"" + (count - 6) + "\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");  //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append("No DM found in coupled environment");  //$NON-NLS-1$
				buffer.append("");  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("</tr> \n");  //$NON-NLS-1$
			}
		}

		buffer.append("</table> </center> </body> </html> ");  //$NON-NLS-1$
		setDownloadContent(buffer.toString());

	}

	//	private void populateDto(SysplexRptDomainDTO contractAttachmentRptDomainDTO){
	//		ArrayList swoList = new ArrayList();
	//		ArrayList customerList = new ArrayList();
	//		ArrayList dmList = new ArrayList();
	//		ArrayList eeList = new ArrayList();
	//		
	//		EEDomainDTO eeDto = new EEDomainDTO();
	//		eeDto.setEeDesc("First EE");
	//		eeDto.setEeNo("0001");
	//		eeDto.setCalculatedPrice(500.00);
	//		eeList.add(eeDto);
	//		eeDto = new EEDomainDTO();
	//		eeDto.setEeDesc("Second EE");
	//		eeDto.setEeNo("0002");
	//		eeDto.setCalculatedPrice(1500.00);
	//		eeList.add(eeDto);
	//		eeDto = new EEDomainDTO();
	//		eeDto.setEeDesc("Third EE");
	//		eeDto.setEeNo("0003");
	//		eeDto.setCalculatedPrice(2500.00);
	//		eeList.add(eeDto);
	//		
	//		SWODomainDTO swoDto = new SWODomainDTO();
	//		swoDto.setSwoNo("Test SWO");
	//		swoDto.setEEDTOList(eeList);
	//
	//		swoList.add(swoDto);
	//		swoDto = new SWODomainDTO();
	//		swoDto.setEEDTOList(eeList);
	//		swoDto.setSwoNo("Second");
	//		swoList.add(swoDto);
	//		
	//		DMDomainDTO dmDto = new DMDomainDTO();
	//		dmDto.setDmNo("001DM");
	//		dmDto.setDmDesc("002DM");
	//		dmDto.setSwoDTOList(swoList);
	//		dmList.add(dmDto);
	//		dmDto = new DMDomainDTO();
	//		dmDto.setDmNo("003DM");
	//		dmDto.setDmDesc("004DM");
	//		dmDto.setSwoDTOList(swoList);
	//		dmList.add(dmDto);
	//		dmDto = new DMDomainDTO();
	//		dmDto.setDmNo("005DM");
	//		dmDto.setDmDesc("006DM");
	//		dmDto.setSwoDTOList(swoList);
	//		dmList.add(dmDto);
	//		dmDto = new DMDomainDTO();
	//		dmDto.setDmNo("007DM");
	//		dmDto.setDmDesc("008DM");
	//		dmDto.setSwoDTOList(swoList);
	//		dmList.add(dmDto);
	//		dmDto = new DMDomainDTO();
	//		dmDto.setDmNo("009DM");
	//		dmDto.setDmDesc("010DM");
	//		dmDto.setSwoDTOList(swoList);
	//		dmList.add(dmDto);
	//		dmDto = new DMDomainDTO();
	//		dmDto.setDmNo("011DM");
	//		dmDto.setDmDesc("012DM");
	//		dmDto.setSwoDTOList(swoList);
	//		dmList.add(dmDto);
	//		dmDto = new DMDomainDTO();
	//		dmDto.setDmNo("013DM");
	//		dmDto.setDmDesc("014DM");
	//		dmDto.setSwoDTOList(swoList);
	//		dmList.add(dmDto);
	//		dmDto.setDmNo("0015DM");
	//		dmDto.setDmDesc("016DM");
	//		dmDto.setSwoDTOList(swoList);
	//		dmList.add(dmDto);
	//		dmDto = new DMDomainDTO();
	//		dmDto.setDmNo("009DM");
	//		dmDto.setDmDesc("010DM");
	//		dmDto.setSwoDTOList(swoList);
	//		dmList.add(dmDto);
	//		dmDto.setDmNo("007DM");
	//		dmDto.setDmDesc("008DM");
	//		dmDto.setSwoDTOList(swoList);
	//		dmList.add(dmDto);
	//		dmDto = new DMDomainDTO();
	//		dmDto.setDmNo("009DM");
	//		dmDto.setDmDesc("010DM");
	//		dmDto.setSwoDTOList(swoList);
	//		dmList.add(dmDto);
	//		
	//		CustomerDomainDTO customerDto = new CustomerDomainDTO();
	//		customerDto.setDMDTOList(dmList);
	//		customerList.add(customerDto);
	//		contractAttachmentRptDomainDTO.setCustomerDomainDTOList(customerList);
	//		contractAttachmentRptDomainDTO.setRptPrintedOn(new Date(04,11,23));
	//		contractAttachmentRptDomainDTO.setPriceAsOf(new Date(04,12,23));
	//		contractAttachmentRptDomainDTO.setTotalCharge("9870000");
	//		
	//		
	//	}
}

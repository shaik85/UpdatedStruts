/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CompareTPReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.CompareTPRptDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.CompareTPRptSWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.CompareTPRptSWOEEDomainDTO;

/**
 * This class form the DOM objects based CustomDTO  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar
 * @version 5.1A
 */
public class CompareTPReportViewBean extends ReportViewBean {
	
	
	/**
     * CompareTPReportViewBean
     * 
     * @author thirumalai
     */
    public CompareTPReportViewBean(){
	}
	
	/**
     * CompareTPReportViewBean
     * 
     * @param customDto
     * @param view
     * @author thirumalai
     */
    public CompareTPReportViewBean(CompareTPReportCustomDTO customDto,String view){
		convertToDOM(customDto);
		super.setView(view);
	}
	
	/**
     * This method converts CustomDTO in to DOM Object
     *
     * @param compareTPReportCustomDTO 
     */
	private void convertToDOM(CompareTPReportCustomDTO compareTPReportCustomDTO) {
	   Document document = null;
	
	   document=createDocument();
	   // Insert Root Order
	   Element root = (Element) document.createElement("comparetpreport");
	   // Insert child Manifest
	   document.appendChild(root);

	   CompareTPRptDomainDTO compareTPRptDomainDTO = compareTPReportCustomDTO.getCompareTPRptDomainDTO();

	   addChildNode(document, (Node) root, "printdate", formatDate(compareTPRptDomainDTO.getPrintedON()));
	   addChildNode(document, (Node) root, "contrno", checkForNull(compareTPRptDomainDTO.getContractNo()));
	   addChildNode(document, (Node) root, "newcontrno", checkForNull(compareTPRptDomainDTO.getNewProposalNo()));
	
		   List swoLists = compareTPRptDomainDTO.getSWODomainDTOList();
		   if (null != swoLists) {
			   Iterator swoListsIterator = swoLists.iterator();
			   
			   while (swoListsIterator.hasNext()) {

				   Node swoNode = document.createElement("swo");
				   root.appendChild(swoNode);
				   CompareTPRptSWODomainDTO compareTPRptSWODomainDTO = (CompareTPRptSWODomainDTO) swoListsIterator.next();

				   addChildNode(document, swoNode, "swono", checkForNull(compareTPRptSWODomainDTO.getSWONumber()));
				   				
				   List swoEELists = compareTPRptSWODomainDTO.getEEDomainDTOList();
				   
				   if (null != swoEELists) {
					 
					   Iterator swoEEListsIterator = swoEELists.iterator();
					 
					   while (swoEEListsIterator.hasNext()) {

						   Node eeNode = document.createElement("ee");
						   swoNode.appendChild(eeNode);

						   CompareTPRptSWOEEDomainDTO compareTPRptSWOEEDomainDTO = (CompareTPRptSWOEEDomainDTO) swoEEListsIterator.next();

						   addChildNode(document, eeNode, "eeno", checkForNull(compareTPRptSWOEEDomainDTO.getEENumber()));
						   addChildNode(document, eeNode, "eedesc", checkForNull(compareTPRptSWOEEDomainDTO.getEEDescription()));
						   addChildNode(document, eeNode, "eeserialno", checkForNull(compareTPRptSWOEEDomainDTO.getSerialNumber()));
									   
						  }
				   }
			  }
		   }
	   super.setDocument(document);
   }
}


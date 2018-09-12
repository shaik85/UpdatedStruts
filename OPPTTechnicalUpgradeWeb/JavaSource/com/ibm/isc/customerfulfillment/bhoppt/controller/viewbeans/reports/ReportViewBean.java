/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * Holds basic data that is required for showing in a report  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ReportViewBean extends OPPTViewBean {
	
	private static final String CLASS_NAME="ReportViewBean";
	private Document document = null;
	private String downloadContent = null;
	private String view = null;
	public final static String DATE_FORMAT_MM_DD_YYYY = "MM'-'dd'-'yyyy";
	public final static String DATE_FORMAT_YYYY_MM_DD = "yyyy'-'MM'-'dd";

	/**
     * checkForNull
     * 
     * @param input
     * @return
     * @author thirumalai
     */
    public String checkForNull(String input) {
		if (input == null || input.trim().equals("") || input.trim().equalsIgnoreCase("NULL")) {
			return "-";
		} else {
		input = input.trim();
	}
		return input;
	}

	/**
     * formatDate
     * 
     * @param input
     * @return
     * @author thirumalai
     */
    public String formatDate(Date input) {
		if (input == null) {
			return "-";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		String timeStamp = formatter.format(input);
		return timeStamp;
	}
	/**
     * formatDateVariance
     * 
     * @param input
     * @return
     * @author thirumalai
     */
    public String formatDateVariance(Date input) {
		if (input == null) {
			return "-";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		String timeStamp = formatter.format(input);
		return timeStamp;
	}

	/**
     * PrintProposalViewBean
     * 
     * @param input
     * @return
     * @author thirumalai
     */
    public static String parseAmount(double input) {
		String parsedInput = "0.00";

		BigDecimal initialDouble = new BigDecimal((new Double(input)).toString());
//		BigDecimal scaledDouble = initialDouble.setScale(2, BigDecimal.ROUND_DOWN);
		/*
		* This is a fix for display issue of rounding
		* Balaji 
		*/
		BigDecimal scaledDouble = initialDouble.setScale(2, BigDecimal.ROUND_HALF_EVEN);

		parsedInput = scaledDouble.toString();

//		Double inputDouble = new Double(input);
//		String parsedInput = "0.00";
//		if (inputDouble == null || inputDouble.toString().trim().equals("0")) {
//			return parsedInput;
//		}
//		NumberFormat f = NumberFormat.getInstance();
//		if (f instanceof DecimalFormat) {
//			((DecimalFormat) f).applyPattern("#.##");
//			parsedInput = ((DecimalFormat) f).format(inputDouble);
//			if (parsedInput == null)
//				return "0.00";
//			if (parsedInput.indexOf(".") == -1)
//				parsedInput = parsedInput + ".00";
//
//		}
		return parsedInput;
	}

	/**
	 *This method creates the document object
	 *  Returns the document.
	 * @return Document
	 */
	public Document createDocument() {
		String methodName="createDocument";
		DocumentBuilder builder = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
				builder = factory.newDocumentBuilder();
				document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
		}
	 return document;
	}

	/**
	 * Sets the document.
	 * @param document The document to set
	 */
	public void setDocument(Document document) {
		this.document = document;
	}
	
	/**
	 * This method adds child node object
	 * @param document
	 * @param parent
	 * @param itemName
	 * @param itemValue
	 */
	public void addChildNode(Document document, Node parent, String itemName, String itemValue) {
		// Insert child element name
		Node item = document.createElement(itemName);
		parent.appendChild(item);
		// Insert ID element value
		Node value = document.createTextNode(itemValue);
		item.appendChild(value);

	}

	/**
	 * This method adds node object
	 * @param document
	 * @param parent
	 * @param itemName
	 * @param itemValue
	 */
	public void addAttributeNode(Document document, Node parent, String itemName, String itemValue) {
		Attr item = document.createAttribute(itemName);
		
		Node value = document.createTextNode(itemValue);
		item.appendChild(value);		
			
		((Element)parent).setAttributeNode(item);				
	}
 
 	/**
 	 * This method sets the View 
 	 * @param newView
 	 */
 	public void setView(String newView){
 		view=newView;  	
 	}
 	
 	/**
 	 * This method gets the View
 	 * @return view
 	 */
 	public String getView(){
 		return view;
 	}
 
	/**
	 * This method gets the Document
	 * @return view
	 */
	public Document getDocument(){
		return document;
	}
 	
	/**
	 * Returns download content value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDownloadContent() {
		return downloadContent;
	}

	/**
	 * Sets download content value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDownloadContent String 
	 */
	public void setDownloadContent(String newDownloadContent) {
		downloadContent = newDownloadContent;
	}
}
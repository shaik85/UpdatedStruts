/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.QuoteCustomDTO;

/**
 * Holds complete data about a single used in quotes list view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class QuoteViewBean extends OPPTViewBean {
	private String iId = null;
	private String iQuoteNumber = null;
	private String iDetails = null;
	private String iInc = null;
	private Date iCraid = null;
	private boolean iQuoteAdded = false;
	private boolean iSelected = false;
	
	/**
	 * Returns craid 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getCraid() {
		return iCraid;
	}

	/**
	 * Returns quote details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDetails() {
		return iDetails;
	}

	/**
	 * Returns quote identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getId() {
		return iId;
	}

	/**
	 * Returns inc 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getInc() {
		return iInc;
	}

	/**
	 * Returns quote number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getQuoteNumber() {
		return iQuoteNumber;
	}

	/**
	 * Sets the crais for the quote 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCraid Date 
	 */
	public void setCraid(Date newCraid) {
		iCraid = newCraid;
	}

	/**
	 * sets the quote details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDetails String 
	 */
	public void setDetails(String newDetails) {
		iDetails = newDetails;
	}

	/**
	 * Sets quote identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newId String 
	 */
	public void setId(String newId) {
		iId = newId;
	}

	/**
	 * Sets inc 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newInc String 
	 */
	public void setInc(String newInc) {
		iInc = newInc;
	}

	/**
	 * Sets the quote number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newQuoteNumber String 
	 */
	public void setQuoteNumber(String newQuoteNumber) {
		iQuoteNumber = newQuoteNumber;
	}

	/**
	 * Returns quote added flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isQuoteAdded() {
		return iQuoteAdded;
	}

	/**
	 * Sets quote added flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newQuoteAdded boolean 
	 */
	public void setQuoteAdded(boolean newQuoteAdded) {
		iQuoteAdded = newQuoteAdded;
	}

	/**
	 * Sets complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param id String
	 * @param quoteNumber String
	 * @param details String
	 * @param inc String
	 * @param craid Date
	 * @param quoteAdded String
	 */
	public void setData(String id, String quoteNumber, String details, String inc, Date craid, boolean quoteAdded){
		setId(id);
		setQuoteNumber(quoteNumber);
		setDetails(details);
		setInc(inc);
		setCraid(craid);
		setQuoteAdded(quoteAdded);
	}
	
	/**
	 * Sets complete data from a custom dto  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO QuoteCustomDTO
	 */
	public void setData(QuoteCustomDTO customDTO){
		if(null != customDTO){
			setId(customDTO.getId());
			setQuoteNumber(customDTO.getQuoteNumber());
			setDetails(customDTO.getDetails());
			setInc(customDTO.getInc());
			setCraid(customDTO.getCraid());
			setQuoteAdded(customDTO.isQuoteAdded());
		}
	}
	
	/**
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param customDTO
	 */
	public QuoteViewBean(QuoteCustomDTO customDTO){
		setData(customDTO);				
	}
	
	/**
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public QuoteViewBean(){
	}

	/**
	 * Returns selected flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isSelected() {
		return iSelected;
	}

	/**
	 * Sets selected flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelected boolean
	 */
	public void setSelected(boolean newSelected) {
		iSelected = newSelected;
	}
}
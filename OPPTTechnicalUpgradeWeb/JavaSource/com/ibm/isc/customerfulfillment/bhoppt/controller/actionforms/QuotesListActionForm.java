/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;

public class QuotesListActionForm extends OPPTActionForm {
	private String[] selectedQuoteIds = null;
	
	/**
	 * Returns collection of selected quote id 
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
	 * @return String[]
	 */
	public String[] getSelectedQuoteIds() {
		return selectedQuoteIds;
	}

	/**
	 * Sets collection of selected quote ids 
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
	 * @param String[] newSelectedQuoteIds 
	 */
	public void setSelectedQuoteIds(String[] newSelectedQuoteIds) {
		selectedQuoteIds = newSelectedQuoteIds;
	}

	public void reset(){
		selectedQuoteIds = null;
	}
}

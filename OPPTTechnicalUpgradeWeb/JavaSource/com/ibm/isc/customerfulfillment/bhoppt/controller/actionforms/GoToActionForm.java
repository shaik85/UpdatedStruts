/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;


/**
 * Action form that validates the go to page number  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class GoToActionForm extends OPPTActionForm {
	private String pageNumberValue = null;
	private String totalPagesValue = null;
	private String mlcTotalPagesValue = null;
	private String mlcExcessValue = null;
	private boolean searchLicenses = false;
	private boolean duplicateSerial = false;
	
	/**
	 * Returns page number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPageNumberValue() {
		return pageNumberValue;
	}

	/**
	 * Sets page number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPageNumberValue String 
	 */
	public void setPageNumberValue(String newPageNumberValue) {
		pageNumberValue = newPageNumberValue;
	}

	/**
	 * Returns total number of pages value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getTotalPagesValue() {
		return totalPagesValue;
	}

	/**
	 * Sets total number of pages value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newTotalPagesValue String 
	 */
	public void setTotalPagesValue(String newTotalPagesValue) {
		totalPagesValue = newTotalPagesValue;
	}

	public void reset(){
		pageNumberValue = null;
		totalPagesValue = null;
		mlcExcessValue = null;
		mlcTotalPagesValue = null;
		searchLicenses = false;
	}

	/**
	 * Returns  mlc excess value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getMlcExcessValue() {
		return mlcExcessValue;
	}

	/**
	 * Returns mlc total number of pages value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getMlcTotalPagesValue() {
		return mlcTotalPagesValue;
	}

	/**
	 * Sets mlc exess value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMlcExcessValue String 
	 */
	public void setMlcExcessValue(String newMlcExcessValue) {
		mlcExcessValue = newMlcExcessValue;
	}

	/**
	 * Sets mlc total number of pages value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMlcTotalPagesValue String 
	 */
	public void setMlcTotalPagesValue(String newMlcTotalPagesValue) {
		mlcTotalPagesValue = newMlcTotalPagesValue;
	}

	/**
	 * Returns page number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getPageNumber() {
		return getIntValue(pageNumberValue);
	}

	/**
	 * Returns total number of pages value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 26, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int 
	 */
	public int getTotalPages() {
		return getIntValue(totalPagesValue);
	}

	/**
	 * Returns  mlc excess value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getMlcExcess() {
		return getIntValue(mlcExcessValue);
	}

	/**
	 * Returns mlc total number of pages value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getMlcTotalPages() {
		return getIntValue(mlcTotalPagesValue);
	}
	
	/**
	 * Returns searchLicenses field value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isSearchLicenses() {
		return searchLicenses;
	}

	/**
	 * Sets searchLicenses field value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSearchLicenses boolean
	 */
	public void setSearchLicenses(boolean newSearchLicenses) {
		searchLicenses = newSearchLicenses;
	}
	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Oct 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isDuplicateSerial() {
		return duplicateSerial;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Oct 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setDuplicateSerial(boolean b) {
		duplicateSerial = b;
	}

}
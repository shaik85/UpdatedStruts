/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;

public class IneligibleLicensesActionForm extends OPPTActionForm 
{
	private String[] selectedLicensesIds;

	/**
	 * Returns the selected licenses ids 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String[]
	 */
	public String[] getSelectedLicensesIds() {
		return selectedLicensesIds;
	}

	/**
	 * Sets selected licenses ids 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedLicensesIds String[] 
	 */
	public void setSelectedLicensesIds(String[] newSelectedLicensesIds) {
		selectedLicensesIds = newSelectedLicensesIds;
	}

	public void reset(){
		selectedLicensesIds = null;
	}
}

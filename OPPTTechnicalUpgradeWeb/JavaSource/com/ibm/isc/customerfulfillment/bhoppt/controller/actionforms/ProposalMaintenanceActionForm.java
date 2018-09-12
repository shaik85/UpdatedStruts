/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;

public class ProposalMaintenanceActionForm extends OPPTActionForm {
	private String groupUser = null;
	private String[] selectedIds = null;

	/**
	 * Returns collection of selected ids 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String[]
	 */
	public String[] getSelectedIds() {
		return selectedIds;
	}

	/**
	 * Sets collection of selected ids 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedIds String[] 
	 */
	public void setSelectedIds(String[] newSelectedIds) {
		selectedIds = newSelectedIds;
	}
	
	/**
	 * Returns the selected group user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getGroupUser() {
		return groupUser;
	}

	/**
	 * Sets group user value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGroupUser String 
	 */
	public void setGroupUser(String newGroupUser) {
		groupUser = newGroupUser;
	}
	
	public void reset(){
		groupUser = null;
		selectedIds = null;
	}
}

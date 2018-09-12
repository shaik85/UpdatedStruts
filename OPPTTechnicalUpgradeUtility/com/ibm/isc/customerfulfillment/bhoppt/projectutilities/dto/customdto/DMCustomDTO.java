/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.*;

/**
 * CustomDTO that holds data about a dm.  
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
public class DMCustomDTO extends OPPTCustomDTO {
	private boolean copiedDM = false;
	private String customerId = null;
	private String description = null;
	private String id = null;
	private String number = null;

	private boolean onlyQuotes = false;
	private Date planEndDate = null;
	private Date planStartDate = null;
	private int proposalId = -1;
	private TreeMap swos = null;

	private boolean sAndS = false;

	/**
	 * Adds a swo to the collection of licenses available for the dm  
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
	 * @param swo 
	 */
	public void addSwo(SWOCustomDTO swo) {
		if (null != swo) {
			if (null == swos) {
				swos = new TreeMap();
			}
			swo.setProposalId(getProposalId());
			swo.setCustomerId(getCustomerId());
			swo.setDMId(getId());
			// iSwos.put(swo.getId(), swo);
			swos.put(String.valueOf(swos.size() + 1), swo);
		}
	}

	/**
	 * Returns dm's parent customer'sid 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Returns dm description 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns dm id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns dm number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Returns plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getPlanEndDate() {
		return planEndDate;
	}

	/**
	 * Returns plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getPlanStartDate() {
		return planStartDate;
	}

	/**
	 * Returns proposal id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getProposalId() {
		return proposalId;
	}

	/**
	 * Returns collection of swos available for the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getSwos() {
		return swos;
	}

	/**
	 * Returns true of the dm is copied 
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
	 * @return boolean
	 */
	public boolean isCopiedDM() {
		return copiedDM;
	}

	/**
	 * Returns true if the DM has only quotes  
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
	 * @return boolean
	 */
	public boolean isOnlyQuotes() {
		return onlyQuotes;
	}

	/**
	 * Sets the copiedDM flag 
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
	 * @param newCopiedDM 
	 */
	public void setCopiedDM(boolean newCopiedDM) {
		copiedDM = newCopiedDM;
	}

	/**
	 * Returns dm's parent customer's id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerId  
	 */
	public void setCustomerId(String newCustomerId) {
		customerId = newCustomerId;
	}

	/**
	 * Sets complete data about an swo in a single method call  
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
	 * @param iid 
	 * @param inumber 
	 * @param idescription 
	 * @param iplanStartDate 
	 * @param iplanEndDate 
	 * @param iswos 
	 */
	public void setData(String iid, String inumber, String idescription, Date iplanStartDate, Date iplanEndDate, TreeMap iswos) {
		setId(iid);
		setNumber(inumber);
		setDescription(idescription);
		setPlanStartDate(iplanStartDate);
		setPlanEndDate(iplanEndDate);
		setSwos(iswos);
	}

	/**
	 * Returns dm description 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDescription 
	 */
	public void setDescription(String newDescription) {
		description = newDescription;
	}

	/**
	 * Sets all flag value in a single method call  
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
	 * @param ionlyQuotes 
	 * @param icopiedDM 
	 */
	public void setFlags(boolean ionlyQuotes, boolean icopiedDM) {
		setOnlyQuotes(ionlyQuotes);
		setCopiedDM(icopiedDM);
	}

	/**
	 * Returns dm identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newId 
	 */
	public void setId(String newId) {
		id = newId;
	}

	/**
	 * Sets dm number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNumber 
	 */
	public void setNumber(String newNumber) {
		number = newNumber;
	}

	/**
	 * Sets only quotes flag 
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
	 * @param newOnlyQuotes 
	 */
	public void setOnlyQuotes(boolean newOnlyQuotes) {
		onlyQuotes = newOnlyQuotes;
	}

	/**
	 * Sets plan end date for the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanEndDate 
	 */
	public void setPlanEndDate(Date newPlanEndDate) {
		planEndDate = newPlanEndDate;
	}

	/**
	 * Sets plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanStartDate 
	 */
	public void setPlanStartDate(Date newPlanStartDate) {
		planStartDate = newPlanStartDate;
	}

	/**
	 * Sets dm's parent proposal's id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalId 
	 */
	public void setProposalId(int newProposalId) {
		proposalId = newProposalId;
	}

	/**
	 * Sets collection of swos available for the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwos 
	 */
	public void setSwos(TreeMap newSwos) {
		swos = newSwos;
	}
	/**
	 * Sets collection of swos available for the dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("\nDM Number: " + getNumber());  /* NOI18N */
		buffer.append("\nDM Proposal id: " + getProposalId());  /* NOI18N */
		buffer.append("\nDM Description: " + getDescription());  /* NOI18N */
		buffer.append("\nDM Customer id: " + getCustomerId());  /* NOI18N */
		buffer.append("\nDM id: " + getId());  /* NOI18N */

		return buffer.toString();
	}
	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSAndS() {
		return sAndS;
	}

	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSAndS(boolean b) {
		sAndS = b;
	}

	/** 
	 * final method
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *  
	 */
	
	/*protected void finalize() {
		
		customerId = null;
		description = null;
		id = null;
		number = null;

		planEndDate = null;
		planStartDate = null;
		
		if (swos != null) {
			swos.clear();
			swos = null;
		}
		
	}*/

}

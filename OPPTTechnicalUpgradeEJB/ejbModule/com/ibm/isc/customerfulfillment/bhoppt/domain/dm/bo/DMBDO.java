/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.dm.bo;


import java.sql.Date;


/**
 *  
 * DBDO class represents attribute defined in DM Entity 
 * This data can be validated using DM Business Object class
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar * @version 5.1A
 */

public class DMBDO {
	private int dmId;
	private int proposalId;
	private int customerId;
	private String dmDesc;
	private String dmNo;
	private Date planStartDate;
	private Date planEndDate;
	private String plannedInd;
	private Date lastUpdatedDate;
	private Date dmAddedDate;
	private String exclusionID;
	private double dmCopyIncrNo;

	/**
	 *  
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public DMBDO() {

	}

	/**
	 * Get the Customer Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iCustomerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Get the DM Added Date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iDmAddedDate
	 */
	public Date getDmAddedDate() {
		return dmAddedDate;
	}

	/**
	 * Get the DM Copy Incr No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iDmCopyIncrNo
	 */
	public double getDmCopyIncrNo() {
		return dmCopyIncrNo;
	}

	/**
	 * Get the DM Description  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iDmDesc
	 */
	public String getDmDesc() {
		return dmDesc;
	}

	/**
	 *  Get the DM Id 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iDmId
	 */
	public int getDmId() {
		return dmId;
	}

	/**
	 * Get the DM No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iDmNo
	 */

	public String getDmNo() {
		return dmNo;
	}

	/**
	 * Get the Exclusion Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iExclusionID
	 */
	public String getExclusionID() {
		return exclusionID;
	}

	/**
	 * Get last updated date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iLastUpdatedDate
	 */
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	/**
	 * Get Plan end date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iPlanEndDate
	 */
	public Date getPlanEndDate() {
		return planEndDate;
	}

	/**
	 * Get Planned Indicator  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iPlannedInd
	 */
	public String getPlannedInd() {
		return plannedInd;
	}

	/**
	 * Get Plan start date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iPlanStartDate
	 */
	public Date getPlanStartDate() {
		return planStartDate;
	}

	/**
	 * Get Proposal Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iProposalId
	 */
	public int getProposalId() {
		return proposalId;
	}

	/**
	 * Set the customer id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerId
	 */
	public void setCustomerId(int iCustomerId) {
		customerId = iCustomerId;
	}

	/**
	 * set DM added date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmAddedDate
	 */
	public void setDmAddedDate(Date iDmAddedDate) {
		dmAddedDate = iDmAddedDate;
	}

	/**
	 * set DM Copy Increment No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmCopyIncrNo
	 */
	public void setDmCopyIncrNo(double iDmCopyIncrNo) {
		dmCopyIncrNo = iDmCopyIncrNo;
	}

	/**
	 * set DM description
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmDesc
	 */
	public void setDmDesc(String iDmDesc) {
		dmDesc = iDmDesc;
	}

	/**
	 * set DM id
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmId
	 */
	public void setDmId(int iDmId) {
		dmId = iDmId;
	}

	/**
	 * set DM No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmNo
	 */
	public void setDmNo(String iDmNo) {
		dmNo = iDmNo;
	}

	/**
	 * set Exclusion Id
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param exclusionID
	 */
	public void setExclusionID(String iExclusionID) {
		exclusionID = iExclusionID;
	}

	/**
	 * set Last Updated date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lastUpdatedDate
	 */
	public void setLastUpdatedDate(Date iLastUpdatedDate) {
		lastUpdatedDate = iLastUpdatedDate;
	}

	/**
	 * set Plan end date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param planEndDate
	 */
	public void setPlanEndDate(Date iPlanEndDate) {
		planEndDate = iPlanEndDate;
	}

	/**
	 * set Planned Indiactor  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param plannedInd
	 */
	public void setPlannedInd(String iPlannedInd) {
		plannedInd = iPlannedInd;
	}

	/**
	 * set Plan start date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param planStartDate
	 */
	public void setPlanStartDate(Date iPlanStartDate) {
		planStartDate = iPlanStartDate;
	}

	/**
	 * set Proposal Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 */
	public void setProposalId(int iProposalId) {
		proposalId = iProposalId;
	}

}

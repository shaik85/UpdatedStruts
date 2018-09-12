/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.domain.dto;
import java.sql.Date;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dm.bo.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;

/** 
 * This Domain DTOS have same attributes like DMBDO.
 * But this DTOs are mainly used to transfer the data across service layer 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar * @version 5.1A 
 */
public class DMDomainDTO extends OPPTDomainDTO {
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
	private List SWODTOList;
	/**
	 *  
	 * Empty Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public DMDomainDTO() {

	}
	/**
	 *  
	 * Constructor 
	 * Customer Domain DTO Constructor takes the CustomerBO object 
	 * Getter and setter methods act on the constructor itself 
	 * 
	 * <br/><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param bo
	 */
	public DMDomainDTO(DMBO dmbo) {
		dmId = dmbo.getDmId();
		proposalId = dmbo.getProposalId();
		customerId = dmbo.getCustomerId();
		dmDesc = dmbo.getDmDesc();
		dmNo = dmbo.getDmNo();
		planStartDate = dmbo.getPlanStartDate();
		planEndDate = dmbo.getPlanEndDate();
		plannedInd = dmbo.getPlannedInd();
		lastUpdatedDate = dmbo.getLastUpdatedDate();
		dmAddedDate = dmbo.getDmAddedDate();
		exclusionID = dmbo.getExclusionID();
		dmCopyIncrNo = dmbo.getDmCopyIncrNo();
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

	/** 
	 * Get SWODTO List from Domain DTO Object 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public List getSWODTOList() {
		return SWODTOList;
	}

	/** 
	 * Set SWO DTO List in DM Domian Object 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDTOList 
	 */
	public void setSwoDTOList(List iswoDTOList) {
		SWODTOList = iswoDTOList;
	}
	/**
	 * This method is used to copy inventory
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 * @author balajiv
	 */
	public String getSQL() {

		StringBuffer bufferSQL = new StringBuffer();
		OPPTCalender cal = new OPPTCalender();

		bufferSQL.append("INSERT INTO BH.CUSTDESGMACHINE(");
		bufferSQL.append(
			"DESG_MACHINE_ID,PROPOSAL_ID,SOLD_TO_PARTY_ID,DESG_MACHINE_NO,DESG_MACHINE_DESC,PLAN_START_DATE,PLAN_END_DATE,PLANNED_IND,LAST_UPDATED_DATE,EXCLUSION_ID,DM_ADDED_DATE,DM_COPY_INCR_NO)");
		bufferSQL.append(" VALUES( ");
		bufferSQL.append(getDmId());
		bufferSQL.append(",");
		bufferSQL.append(getProposalId());
		bufferSQL.append(",");
		bufferSQL.append(getCustomerId());
		bufferSQL.append(", '");
		bufferSQL.append(getDmNo());
		bufferSQL.append("','");
		bufferSQL.append(getDmDesc());
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getPlanStartDate()));
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getPlanEndDate()));
		bufferSQL.append("','");
		bufferSQL.append(getPlannedInd());
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getLastUpdatedDate()));
		bufferSQL.append("','");
		bufferSQL.append(getExclusionID());
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getDmAddedDate()));
		bufferSQL.append("',");
		bufferSQL.append(getDmCopyIncrNo());
		bufferSQL.append(")");

		return formatSQL(bufferSQL.toString());
	}

/*	protected void finalize() {
		if (null != SWODTOList) {
			SWODTOList.clear();
			SWODTOList = null;
		}
	}*/

}

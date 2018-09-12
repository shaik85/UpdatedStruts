/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;
import java.sql.Time;

/**
 * Custom dto that holds data related to a user access on a proposal. 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 26, 2003 
 * 
 * revision by Nomita
 * date feb 12th 2011
 * For activity log requirement
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class ProposalHistoryDataCustomDTO extends OPPTCustomDTO {
	
	private String userId = null;
	private String operationPerformed = null;
	private String additionalInfo = null;
	private String description=null;
	private Date accessDate = null;
	private Date accessTime = null;
	private int sequenceNo = 0;
	private ProposalCustomDTO proposalDTO = null;
	
	public ProposalCustomDTO getProposalDTO() {
		return proposalDTO;
	}
	
	
	
		public String getUserId() {
		return userId;
	}

	public String getOperationPerformed() {
		return operationPerformed;
	}
	
	public String getDescription() {
		return description;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	
	public Date getAccessDate() {
		return accessDate;
	}
	
	
	public Date getAccessTime() {
		return accessTime;
	}
	
	public int  getSequenceNo() {
		return sequenceNo;
	}
	
	
	public void  setUserId(String newUserId) {
		 userId=newUserId;
	}
	public void  setDescription(String newDescription) {
		 description=newDescription;
	}

	public void  setOperationPerformed(String newOperationPerformed) {
		 operationPerformed=newOperationPerformed;
	}
	
	public void  setAdditionalInfo(String newAdditionalInfo) {
		 additionalInfo=newAdditionalInfo;
	}
	
	public void  setAccessDate(Date newAccessDate) {
		 accessDate=newAccessDate;
	}
	
	public void  setAccessTime(Date newAccessTime) {
		 accessTime=newAccessTime;
	}
		
	public void  setSequenceNo(int newSequenceNo) {
		sequenceNo=newSequenceNo;
	}

	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ilockedBy String
	 * @param ilockedOn Date
	 */
	public void setData(String userId,String operationPerformed, String additionalInfo,Date accessDate,Date accessTime,int sequenceNo, String description ){
		setUserId(userId);
		setOperationPerformed(operationPerformed);
		setAdditionalInfo(additionalInfo);
		setAccessDate(accessDate);
		setAccessTime(accessTime);
		setSequenceNo(sequenceNo);
		setDescription(description);
		
	}
	
	/**
	 * constructor
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 */
	
	public ProposalHistoryDataCustomDTO(){
	}
	
	/**
	 * Proposal History Data Custom DTO
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ilockedBy String
	 * @param ilockedOn Date
	 */
	public ProposalHistoryDataCustomDTO(String userId,String operationPerformed, String additionalInfo,Date accessDate,Date accessTime,int sequenceNo, String Description){
		setUserId(userId);
		setOperationPerformed(operationPerformed);
		setAdditionalInfo(additionalInfo);
		setAccessDate(accessDate);
		setAccessTime(accessTime);
		setSequenceNo(sequenceNo);
		setDescription(description);
	}
}

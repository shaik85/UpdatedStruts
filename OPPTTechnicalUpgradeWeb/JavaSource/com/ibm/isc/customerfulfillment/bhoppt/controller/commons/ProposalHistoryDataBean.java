/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;

import java.util.Date;



import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHistoryDataCustomDTO;

/**
 * Holds proposal history data 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 *  Revised by Nomita as a part of Activity Log changes
 * Date 11th Jan 2011
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class ProposalHistoryDataBean extends OPPTDataBean{
	
	private String userId = null;
	private String operationPerformed = null;
	private String additionalInfo = null;
	private Date accessDate = null;
	private Date accessTime = null;
	private int sequenceNo = 0;
	private String description=null;
	
	/**
	 * Setting 
	 * @return
	 */
	
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
	 * set data
	 
	 */
	public void setData(String userId,String operationPerformed, String additionalInfo,Date accessDate,Date accessTime,int sequenceNo,String description ){
		
		setUserId(userId);
		setOperationPerformed(operationPerformed);
		setAdditionalInfo(additionalInfo);
		setAccessDate(accessDate);
		setAccessTime(accessTime);
		setSequenceNo(sequenceNo);
		setDescription(description);
		
		
		
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(ProposalHistoryDataCustomDTO customDTO){
		if(null != customDTO){
			
			setUserId(customDTO.getUserId());
			setOperationPerformed(customDTO.getOperationPerformed());
			setAdditionalInfo(customDTO.getAdditionalInfo());
			setAccessDate(customDTO.getAccessDate());
			setAccessTime(customDTO.getAccessTime());
			setSequenceNo(customDTO.getSequenceNo());
			setDescription(customDTO.getDescription());
			
		}
	}
	
	/**
     * ProposalHistoryDataBean
     * 
     * @author thirumalai
     */
    public ProposalHistoryDataBean(){
	}
	/**
     * ProposalHistoryDataBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public ProposalHistoryDataBean(ProposalHistoryDataCustomDTO customDTO){
		setData(customDTO);
	}
}

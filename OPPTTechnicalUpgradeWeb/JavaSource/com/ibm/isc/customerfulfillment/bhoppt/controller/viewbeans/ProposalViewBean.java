/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;

/**
 * Hold basic information about a proposal  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProposalViewBean extends OPPTViewBean 
{
	private String iId = null;
	private String iProposalName = null;
	private String iProposalType = null;
	private String iProposalContent = null;
	private String iStatus = null;
	private String iOldContractNumber = null;
	private String iLockedBy = null;
	private String iAccessType = null;
	private boolean iFullAccess = false;
	
	private String key = null;
	
	/**
	 * Returns access type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getAccessType() {
		return iAccessType;
	}

	/**
	 * Returns identifier of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Returns the user id of the person who locked the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getLockedBy() {
		return iLockedBy;
	}

	/**
	 * If the current proposal was created from another proposal or contract, this method returns the 
	 * other proposals number. Else it returns null. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getOldContractNumber() {
		return iOldContractNumber;
	}

	/**
	 * Returns the name of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getProposalName() {
		return iProposalName;
	}

	/**
	 * Returns the current status of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getStatus() {
		return iStatus;
	}

	/**
	 * Returns the type of the proposal. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getProposalType() {
		return iProposalType;
	}

	/**
	 * Sets the access type of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAccessType String 
	 */
	public void setAccessType(String newAccessType) {
		iAccessType = newAccessType;
	}

	/**
	 * Sets the identifier of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Sets the lockedBy property 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLockedBy String 
	 */
	public void setLockedBy(String newLockedBy) {
		iLockedBy = newLockedBy;
	}

	/**
	 * Sets the old contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldContractNumber String
	 */
	public void setOldContractNumber(String oldContractNumber) {
		iOldContractNumber = oldContractNumber;
	}

	/**
	 * Sets the proposal name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalName String 
	 */
	public void setProposalName(String newProposalName) {
		iProposalName = newProposalName;
	}

	/**
	 * Sets the status of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStatus 
	 */
	public void setStatus(String newStatus) {
		iStatus = OPPTStaticDataHolder.getProposalStatusDesc(newStatus);
	}

	/**
     * Sets the proposal type
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 17, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newProposalType 
     */
	public void setProposalType(String newProposalType) {
		//iProposalType = OPPTStaticDataHolder.getProposalTypeDesc(newProposalType); commented by ramesh
		this.iProposalType=newProposalType;
	}

	/**
	 * Sets complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param id String
	 * @param proposalName String
	 * @param proposalType String
	 * @param status String
	 * @param oldContractNumber String
	 * @param lockedBy String
	 * @param accessType String
	 */
	public void setData(String id, String proposalName, String proposalType, String status, String oldContractNumber, String lockedBy, String accessType){
		setId(id);
		setProposalName(proposalName);
		setProposalType(proposalType);
		//setProposalContent(customDTO.getContent()); added by Ramesh DAD003
		setStatus(status);
		setOldContractNumber(oldContractNumber);
		setLockedBy(lockedBy);
		setAccessType(accessType);
	}
	
	/**
     * ProposalViewBean
     * 
     * @author thirumalai
     */
    public ProposalViewBean(){
	}
    
	/**
     * ProposalViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public ProposalViewBean(ProposalCustomDTO customDTO){
		if(null != customDTO){
			setId(customDTO.getId()+"");
			setProposalName(customDTO.getName());
			setProposalType(customDTO.getType());
			setProposalContent(customDTO.getContent());
			ProposalTypeContent(customDTO.getType(),customDTO.getContent());
			setStatus(customDTO.getStatus());
			setOldContractNumber(customDTO.getOldContractNumber());
			setLockedBy(customDTO.getLockedBy());
			setAccessType(customDTO.getAccess());
			setFullAccess(customDTO.isFullAccess());
			setKey(getProposalKey(customDTO.getStatus()));
		}
	}
	
	public String getProposalKey(String statusCode){
		StringBuffer buffer = new StringBuffer();
		if(null != statusCode){
			buffer.append(statusCode);
		}
		buffer.append(" - ");
		if(null != iProposalName){
			buffer.append(iProposalName);
		}
		return buffer.toString();
	}

	/**
	 * Returns true if the proposal was shared to the user with full access. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isFullAccess() {
		return iFullAccess;
	}

	/**
	 * Sets proposal share flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFullAccess boolean
	 */
	public void setFullAccess(boolean newFullAccess) {
		iFullAccess = newFullAccess;
	}
	
	/**
	 * Returns the proposal key value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets proposal key value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newKey String 
	 */
	public void setKey(String newKey) {
		key = newKey;
	}
	/**
	 * Returns the Contenttype of the proposal. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Aug 20, 2010
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getProposalContent() {
		return iProposalContent;
	}
	/**
     * Sets the proposal Contenttype
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Aug 20, 2010
     * revision date author reason
     * </PRE><br>
     *
     * @param newProposalType 
     */
	public void setProposalContent(String newProposalContent) {
		this.iProposalContent = newProposalContent;
	}
	public void ProposalTypeContent(String proposaltype, String proposalcontent){
		if (proposaltype .equalsIgnoreCase("ES") && proposalcontent.equalsIgnoreCase("M")){
			iProposalType = "MLC";
		}else if(proposaltype.equalsIgnoreCase("ES") && proposalcontent.equalsIgnoreCase("S")){
			iProposalType = "S&S";
		}else{
			iProposalType = OPPTStaticDataHolder.getProposalTypeDesc(iProposalType);
		}
		setProposalType( iProposalType);
	}

}
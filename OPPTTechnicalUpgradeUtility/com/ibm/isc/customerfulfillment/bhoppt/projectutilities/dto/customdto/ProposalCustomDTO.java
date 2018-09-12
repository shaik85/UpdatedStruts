/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;

/**
 * Custom dto that holds proposal details  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 3, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProposalCustomDTO extends OPPTCustomDTO {
	private int id = -1;
	private String name = null;
	private String type = null;
	private String content = null; //Added by Ramesh for the DAD003
	private String status = null;
	private String oldContractNumber = null;
	private String lockedBy = null;
	private String access = null;
	private boolean fullAccess = false;
	private boolean selectedInventory=false;
	/* start change CR6153*/
	private String extendPeriod;
	/* end change CR6153*/
	private Date contractPeriodStartDate=null;//OPPT BH 1.0-DAD001-Srinivas
	private Date contractPeriodEndDate=null;//OPPT BH 1.0-DAD001-Srinivas
	private boolean isChangeProposal=false; //added byramesh
	
	/**
	 * Returns access type of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getAccess() {
		return access;
	}

	/**
	 * Returns proposal identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns user if who locked the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getLockedBy() {
		return lockedBy;
	}

	/**
	 * Returns proposal name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns old contract number of the proposal if any 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getOldContractNumber() {
		return oldContractNumber;
	}

	/**
	 * Sets access level of the proposal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAccess string 
	 */
	public void setAccess(String newAccess) {
		access = newAccess;
	}

	/**
	 * Sets proposal identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newId int 
	 */
	public void setId(int newId) {
		id = newId;
	}

	/**
	 * Sets user id of the person who locked the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLockedBy String 
	 */
	public void setLockedBy(String newLockedBy) {
		lockedBy = newLockedBy;
	}

	/**
	 * Sets name of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newName String 
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Sets old contract number of the proposal. This is the contract's number from which
	 * this proposal is created. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newOldContractNumber String 
	 */
	public void setOldContractNumber(String newOldContractNumber) {
		oldContractNumber = newOldContractNumber;
	}

	/**
	 * constructor 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	  */
	
	public ProposalCustomDTO(){
	}
	
	/**
	 * Sets old contract number of the proposal. This is the contract's number from which
	 * this proposal is created. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newtype String 
	 */
	
	public void setType(String newtype){
		type  = newtype;
	}
	/**
	 * Sets old contract number of the proposal. This is the contract's number from which
	 * this proposal is created. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newstatus String 
	 */
	
	public void setStatus(String newstatus){
		status = newstatus;
	}
	
	
	/**
	 * gets old contract number of the proposal. This is the contract's number from which
	 * this proposal is created. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String 
	 */
	
	public String getType(){
		return type ;
	}
	
	/**
	 * gets old contract number of the proposal. This is the contract's number from which
	 * this proposal is created. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String 
	 */
	
	public String getStatus(){
		return status;
	}

	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aid int
	 * @param aname String
	 * @param atype ProposalTypeCustomDTO
	 * @param astatus ProposalStatusCustomDTO
	 * @param aoldContractNumber String
	 * @param alockedBy String
	 * @param aaccess String
	 */
	public void setData(int aid, String aname, String atype, String astatus, 
						String aoldContractNumber, String alockedBy, String aaccess){
		setId(aid);
		setName(aname);
		setType(atype);
		setStatus(astatus);
		setOldContractNumber(aoldContractNumber);
		setLockedBy(alockedBy);
		setAccess(aaccess);
	}
	
	
	/**
	 * to String
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String 
	 */
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();

		buffer.append("\n[ProposalCustomDTO]");  /* NOI18N */
		buffer.append(" - [Id: "+id+"]");  /* NOI18N */  /* NOI18N */
		buffer.append(" - [Name: "+name+"]");  /* NOI18N */  /* NOI18N */
		buffer.append(" - [Type: "+type +"]");  /* NOI18N */  /* NOI18N */		
		buffer.append(" - [Status: "+status+"]");  /* NOI18N */  /* NOI18N */		
		buffer.append(" - [Old contract number: "+oldContractNumber+"]");  /* NOI18N */  /* NOI18N */		
		buffer.append(" - [Locked by: "+lockedBy+"]");  /* NOI18N */  /* NOI18N */		
		buffer.append(" - [Access: "+access+"]");  /* NOI18N */  /* NOI18N */		
		buffer.append(" - [Full access: "+fullAccess+"]");  /* NOI18N */  /* NOI18N */
		
		//OPPT BH 1.0-DAD001-Srinivas
		buffer.append("-[Contract Period Start Date:"+contractPeriodStartDate+"]");/* NOI18N */  /* NOI18N */
		buffer.append("-[Contract Period Start Date:"+contractPeriodEndDate+"]");/* NOI18N */  /* NOI18N */
		
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
		return fullAccess;
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
		fullAccess = newFullAccess;
	}
	
	/**
	 * set the default values 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 */
	
	/* start change CR6153*/
	/**
	 * @return Returns the extendPeriod.
	 */
	public String getExtendPeriod() {
		return extendPeriod;
	}
	/**
	 * @param extendPeriod The extendPeriod to set.
	 */
	public void setExtendPeriod(String extendPeriod) {
		this.extendPeriod = extendPeriod;
	}
	/* end change CR6153*/
	
	public void reset(){
		name = null;
		type  = null;
		status = null;
		oldContractNumber = null;
		lockedBy = null;
		access = null;
	}
	
	
    //	OPPT BH 1.0-DAD001-Srinivas
	
	/**
	 * @return Returns the contractPeriodEndDate.
	 */
	public Date getContractPeriodEndDate() {
		return contractPeriodEndDate;
	}
	   //OPPT BH 1.0-DAD001-Srinivas
	/**
	 * @param contractPeriodEndDate The contractPeriodEndDate to set.
	 */
	public void setContractPeriodEndDate(Date contractPeriodEndDate) {
		this.contractPeriodEndDate = contractPeriodEndDate;
	}
	   //OPPT BH 1.0-DAD001-Srinivas
	/**
	 * @return Returns the contractPeriodStartDate.
	 */
	public Date getContractPeriodStartDate() {
		return contractPeriodStartDate;
	}
	   //OPPT BH 1.0-DAD001-Srinivas
	/**
	 * @param contractPeriodStartDate The contractPeriodStartDate to set.
	 */
	public void setContractPeriodStartDate(Date contractPeriodStartDate) {
		this.contractPeriodStartDate = contractPeriodStartDate;
	}
	/**
	 * @return Returns the selectedInventory.
	 */
	public synchronized boolean isSelectedInventory() {
		return selectedInventory;
	}
	/**
	 * @param selectedInventory The selectedInventory to set.
	 */
	public synchronized void setSelectedInventory(boolean selectedInventory) {
		this.selectedInventory = selectedInventory;
	}
	/**
	 * @return Returns the content.
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content The content to set.
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return Returns the isChangeProposal.
	 */
	public boolean isChangeProposal() {
		return isChangeProposal;
	}
	/**
	 * @param isChangeProposal The isChangeProposal to set.
	 */
	public void setChangeProposal(boolean isChangeProposal) {
		this.isChangeProposal = isChangeProposal;
	}
}
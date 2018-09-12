/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.GroupUserDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserProposalsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * Holds complete data about the proposal maintenance view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProposalMaintenanceViewBean extends OPPTViewBean {
	private GroupUserDataBean iGroupUserData = null;
	private TreeMap iProposals = null;
	private String iMessage = null;
	private boolean groupUser = false;
	
	/**
	 * Returns group user data. That is the selected sales org, group name and sales org's
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return GroupUserDataBean
	 */
	public GroupUserDataBean getGroupUserData() {
		return iGroupUserData;
	}

	/**
	 * Returns collection of available proposals for the selected group user. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getProposals() {
		return iProposals;
	}

	/**
	 * Sets group users data 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGroupUserData GroupUserDataBean 
	 */
	public void setGroupUserData(GroupUserDataBean newGroupUserData) {
		iGroupUserData = newGroupUserData;
		if(null != iGroupUserData){
			setGroupUser(true);
		}
		else{
			setGroupUser(false);
		}
	}

	/**
	 * Sets the collection of proposals for the selected group user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposals TreeMap 
	 */
	public void setProposals(TreeMap newProposals) {
		iProposals = newProposals;
	}
	
	/**
	 * Adds the proposal to the already existing collection of proposals  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposal ProposalViewBean
	 */
	public void addProposal(ProposalViewBean proposal){
		if(null != proposal){
			if(null == iProposals){
				iProposals = new TreeMap();
			}
			iProposals.put(proposal.getKey(), proposal);
		}
	}
	
	/**
	 * Sets complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param groupUserData GroupUserDataBean
	 * @param proposals TreeMap
	 */
	public void setData(GroupUserDataBean groupUserData, TreeMap proposals){
		setGroupUserData(groupUserData);
		setProposals(proposals);
	}
	
	/**
     * ProposalMaintenanceViewBean
     * 
     * @author thirumalai
     */
    public ProposalMaintenanceViewBean(){
	}
	
	/**
     * ProposalMaintenanceViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public ProposalMaintenanceViewBean(UserProposalsCustomDTO customDTO){
		if(null != customDTO){
			GroupUserCustomDTO groupUser = customDTO.getGroupUserInfo();
			if(null != groupUser){
				setGroupUserData(new GroupUserDataBean(groupUser));				
			}
			else{
				setUserName(customDTO.getUserName());
			}
			
			ErrorReport messageReport = customDTO.getMessageReport();
			if(null == messageReport)
			{
				TreeMap userProposals = customDTO.getProposals();
				if(null != userProposals){
					Iterator proposalIterator = userProposals.values().iterator();
					if(null != proposalIterator){
						while(proposalIterator.hasNext()){
							addProposal(new ProposalViewBean((ProposalCustomDTO)proposalIterator.next()));
						}
					}
				}
			}
			else{
				setMessage(getMessage(messageReport));
			}
			
			setButtonFlags(customDTO.getButtonFlags());
		}
	}

	/**
     * ProposalMaintenanceViewBean
     * 
     * @param message
     * @author thirumalai
     */
    public ProposalMaintenanceViewBean(String message){
		setMessage(message);
	}
	
	/**
	 * Returns message value if no proposals present 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getMessage() {
		return iMessage;
	}

	/**
	 * Sets message value if no proposals present 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessage String 
	 */
	public void setMessage(String newMessage) {
		iMessage = newMessage;
	}

	/**
	 * Returns if the user is an group user or not 
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
	 * @return boolean 
	 */
	public boolean isGroupUser() {
		return groupUser;
	}

	/**
	 * Sets group user flag value 
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
	 * @param newGroupUser boolean
	 */
	public void setGroupUser(boolean newGroupUser) {
		groupUser = newGroupUser;
	}

	private String getMessage(ErrorReport errorReport){
		String message = null;
		
		if(null != errorReport){
			OPPTMessageCatalog.getInstance().populateErrorReport(errorReport);
			Iterator errorReportIterator = errorReport.values().iterator();
			if(errorReportIterator.hasNext()){
				ErrorEntry errorEntry = (ErrorEntry)errorReportIterator.next();
				if(null != errorEntry){
					message = errorEntry.getErrorMessage();
				}
			}
		}
		
		return message;
	}

	/**
     * isRequiredError
     * 
     * @return
     * @author thirumalai
     */
    public boolean isRequiredError(){
		boolean requiredError = false;
		
		if(null != getErrorReport()){
			HashSet errorFields = getErrorReport().getErrorFieldNames();
			if(null != errorFields && errorFields.contains("required")){  //$NON-NLS-1$
				requiredError= true;
			}
		}
		
		return requiredError;
	}
}
